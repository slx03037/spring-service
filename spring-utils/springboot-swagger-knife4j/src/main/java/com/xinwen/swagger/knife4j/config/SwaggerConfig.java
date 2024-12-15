package com.xinwen.swagger.knife4j.config;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-24 21:52
 **/
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//    /**
//     * @return swagger config
//     */
//    @Bean
//    public Docket openApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .groupName("Test group")
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                .globalRequestParameters(getGlobalRequestParameters())
//                .globalResponses(HttpMethod.GET, getGlobalResponse());
//    }
//
//    /**
//     * @return global response code->description
//     */
//    private List<Response> getGlobalResponse() {
//        return ResponseStatus.HTTP_STATUS_ALL.stream().map(
//                a -> new ResponseBuilder().code(a.getResponseCode()).description(a.getDescription()).build())
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * @return global request parameters
//     */
//    private List<RequestParameter> getGlobalRequestParameters() {
//        List<RequestParameter> parameters = new ArrayList<>();
//        parameters.add(new RequestParameterBuilder()
//                .name("AppKey")
//                .description("App Key")
//                .required(false)
//                .in(ParameterType.QUERY)
//                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
//                .required(false)
//                .build());
//        return parameters;
//    }
//
//    /**
//     * @return api info
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger API")
//                .description("test api")
//                .contact(new Contact("pdai", "http://pdai.tech", "suzhou.daipeng@gmail.com"))
//                .termsOfServiceUrl("http://xxxxxx.com/")
//                .version("1.0")
//                .build();
//    }
//}
