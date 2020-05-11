package org.javaboy.vhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @author Jerry
 * @version 1.0
 * @date 2020/4/11 14:29
 * 进行跨域的配置操作
 */
@Configuration
public class CORSConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        //服务器允许使用的字段
        corsConfiguration.addAllowedHeader("*");
        //真实请求允许的方法
        corsConfiguration.addAllowedMethod("*");
        //是否允许用户发送、处理 cookie
        corsConfiguration.setAllowCredentials(true);
        //预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
        //corsConfiguration.setMaxAge(1728000);

        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        //corsConfiguration.addExposedHeader("*");

        // 如果是OPTIONS则结束请求
//        if (HttpMethod.OPTIONS.toString().equals("OPTION")) {
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            return false;
//        }
//
//        return true;

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource  = new UrlBasedCorsConfigurationSource();
        configSource .registerCorsConfiguration("/**", corsConfiguration);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource );
    }
}
