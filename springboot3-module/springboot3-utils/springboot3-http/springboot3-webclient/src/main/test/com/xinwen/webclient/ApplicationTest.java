package com.xinwen.webclient;

import io.netty.handler.timeout.ReadTimeoutException;
import lombok.extern.slf4j.Slf4j;

import org.apache.http.conn.ConnectTimeoutException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

/**
 * @author shenlx
 * @description
 * @date 2025/1/22 17:11
 */
@Slf4j
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private WebClient webClient;

    /**
     * 2) 同步发送请求（就像RestTemplate一样）
     * 如果你想坚持使用发送 HTTP 请求并等待响应的老方法，也可以使用 WebClient 实现如下所示的相同功能：
     * block()用于同步等待响应，这可能并不适合所有情况，你可能需要考虑subscribe()异步使用和处理响应。
     */
    @Test
    public String postSynchronously(String url, String requestBody) {
        log.info("Going to hit API - URL {} Body {}", url, requestBody);
        String response = "";
        try {
            String block = webClient
                    .method(HttpMethod.POST)
                    .uri(url)
                    .accept(MediaType.ALL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();//block()用于同步等待响应，这可能并不适合所有情况，你可能需要考虑subscribe()异步使用和处理响应
        } catch (Exception e) {
            log.error("Error while calling API", e);
            throw new RuntimeException("XYZ service api error: " + e.getMessage());
        } finally {
            log.info("API Response {}", response);
        }
        return response;
    }

    /**
     * 3) 异步发送请求：
     * 要使用此函数，只需要传入要向其发送POST请求的url以及要在请求正文中以URL编码字符串形式发送的数据，该函数将返回来自服务器的响应
     * ，或者如果请求由于任何原因失败，则返回一条错误信息
     */
    public static Mono<String> makePostRequestAsync(String url, String postData) {
        WebClient client = WebClient.builder().build();
        return client.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("data", postData))
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * 请注意，在此示例中，WebClient是使用默认配置构建的。你可能需要根据不同要求进行不同的配置。
     * 另请注意，block()用于同步等待响应，这可能并不适合所有情况。你可能需要考虑subscribe()异步使用和处理响应。
     */
    public void doMakePostRequestAsyncFail() {
        makePostRequestAsync("https://example.com/api", "param1=value1¶m2=value2")
                .subscribe(response -> {
                    //处理正确的响应
                    System.out.println(response);
                }, error -> {
                    //处理错误响应
                    System.err.println(error.getMessage());
                });
    }


    /**
     * 4.处理4XX和5XX错误
     * 在此示例中，该onStatus方法被调用两次，一次针对4XX客户端错误，一次针对5XX服务器错误，onStatus每次调用都采用两个参数
     * aPredicate确定错误状态代码是否与条件匹配
     * aFunction用户返回Moon，即要传播到订阅者的错误信息
     * 如果状态码与条件不匹配，Moon则会出现相应的状态码，并且Moon链会因错误而终止，在此示例中，Moon将发出一条RuntimeException
     * 错误消息，指示该错误是客户端错误还是服务器错误
     */
    public static Mono<String> makePostRequestAsyncFail(String url, String postData) {
        WebClient client = WebClient
                .builder()
                .baseUrl(url)
                .build();
        //HttpStatus
        Mono<String> stringMono = client.post()
                //.uri("/")
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData("data", postData))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("client error")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("client error")))
                .bodyToMono(String.class);
        /**
         * 在此示例中，该onStatus()方法被调用两次，一次针对 4xx 客户端错误，一次针对 5xx 服务器错误。onStatus()
         * 每次调用都采用两个参数：
         *      aPredicate确定错误状态代码是否与条件匹配
         *      aFunction用于返回Mono，即要传播到订阅者的错误信息。
         *如果状态代码与条件匹配，Mono则会发出相应的状态代码，并且Mono链会因错误而终止。在此示例中，Mono 将发出一条
         * RuntimeException 错误消息，指示该错误是客户端错误还是服务器错误。
         */
        return stringMono;
    }

    /**
     * 5) 根据错误状态采取行动
     * 要根据Mono的subscribe()方法中的错误采取操作，可以在subscribe函数中处理响应的lambda表达式之后添加另一个lambda表达。
     * 如果在处理Monumber的过程中出现错误，则执行第二个lambda表达式
     * subscribe方法中的第二个lambda表达式检查错误是否是WebClientResponseException的实例，这是WebClient在服务器有错误
     * 响应时抛出的特定类型的异常。如果它是WebClientResponseException的实例，则代码将从异常中提取状态代码和状态文本，并将
     * 它们记录到日志中。还可以根据发生的特定错误在此lambda表达式中添加其他错误处理逻辑。例如，你可以重试请求、回退到默认值或以
     * 特定方式记录错误。
     */
    @Test
    public void subscribe() {
        makePostRequestAsync("", "")
                .subscribe(log::info, error -> {
                    log.error("An error occurred:{}", error.getMessage());
                    if (error instanceof WebClientResponseException webClientException) {
                        int statusCode = webClientException.getStatusCode().value();

                        String statusText = webClientException.getStatusText();

                        log.error("ERROR status code:{}", statusCode);
                        log.error("ERROR status text:{}", statusText);
                    }
                });
    }


    /**
     * 6处理成功响应和错误的完整代码
     **/
    @Test
    public void subscribe2() {
        makePostRequestAsync("", "")
                .subscribe(
                        response -> {
                            log.warn("SUCCESS API Response{}", response);
                        }
                        , error -> {
                            log.error("AN error occurred:{}", error.getMessage());
                            log.error("error class:{}", error.getClass());

                            //Errors/Exceptions from Server
                            if (error instanceof WebClientResponseException error1) {
                                int statusCode = error1.getStatusCode().value();

                                String statusText = error1.getStatusText();

                                log.warn("ERROR STATUS CODE:{}", statusCode);

                                log.warn("ERROR STATUS TEXT:{}", statusText);

                                if (statusCode >= 400 && statusCode < 500) {
                                    log.warn("Error Response body {}", error1.getResponseBodyAsString());
                                }

                                Throwable cause = error1.getCause();
                                log.error("webClientResponseException");

                                if (null != cause) {
                                    log.info("Cause{}", cause.getClass());
                                    if (cause instanceof ReadTimeoutException) {
                                        log.error("ReadTimeoutException");
                                    }
                                    if (cause instanceof TimeoutException) {
                                        log.error("TimeoutException");
                                    }
                                }
                            }

                            //Clienterrorsi.e.Timeoutsetc-
                            if (error instanceof WebClientRequestException webClientRequestException) {
                                log.error("webClientRequestException");
                                Throwable cause = webClientRequestException.getCause();
                                if (null != cause) {
                                    log.info("Cause{}", cause.getClass());
                                    if (cause instanceof ReadTimeoutException) {
                                        log.error("ReadTimeoutException");
                                    }

                                    if (cause instanceof ConnectTimeoutException) {
                                        log.error("ConnectTimeoutException");
                                    }
                                }
                            }
                        });
    }

    /**
     *      设置超时时间
     *     public void me(){
     *         WebClient webClient = WebClient
     *                 .builder()
     *                 .build();
     *         return webClient
     *                 .method(this.httpMethod)
     *                 .uri(this.uri)
     *                 .headers(httpHeaders->httpHeaders.addAll(additionalHeaders))
     *                 .bodyValue(this.requestEntity)
     *                 .retrieve()
     *                 .bodyToMono(responseType)
     *                 .timeout(Duration.ofMillis(readTimeout))//requesttimeoutforthisrequest
     *                 .block();
     *     }
     *
     *     但是，我们无法在每个请求中设置连接超时，这是WebClient 的属性，只能设置一次。
     *     如果需要，我们始终可以使用新的连接超时值创建一个新的 Web 客户端实例。连接超时、读取超时和请求超时的区别如下：
     */


}
