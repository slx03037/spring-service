package com.xinwen.example.config.filter;

import com.xinwen.example.utils.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author shenlx
 * @description 它能够确保在一次请求中只通过一次filter
 *  * 请求过滤器
 *  * OncePerRequestFilter:
 *  * OncePerRequestFilter，顾名思义，它能够确保在一次请求中只通过一次filter.
 *  * 大家常识上都认为，一次请求本来就只filter一次，为什么还要由此特别限定呢，往往我们的常识和实际的实现并不真的一样，经过一番资料的查阅，此方法是为了兼容不同的web container，
 *  * 也就是说并不是所有的container都入我们期望的只过滤一次，servlet版本不同，执行过程也不同，
 *  * 因此，为了兼容各种不同运行环境和版本，默认filter继承OncePerRequestFilter是一个比较稳妥的选择。
 *  *
 * @date 2024/5/21 22:51
 */
@Slf4j
public class OnceRequestFilter extends OncePerRequestFilter {
    @Override
    public void destroy() {
        super.destroy();
        log.info("RequestFilter destroy");
    }
    /*
           OncePerRequestFilter.doFilter方法中通过request.getAttribute判断当前过滤器是否已执行
           若未执行过，则调用doFilterInternal方法，交由其子类实现
       */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
            filterChain.doFilter(requestWrapper, httpServletResponse);
            log.info("RequestFilter");
            log.info(Arrays.toString(requestWrapper.getParameterValues("name")));
        } catch (Exception exception) {
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(exception.toString());
        }
    }
}
