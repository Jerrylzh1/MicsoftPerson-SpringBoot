package org.javaboy.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * @author Jerry
 * @version 1.0
 * @date 2020/5/14 22:54
 */
@Configuration
public class WebConfig {
    /**
     * 设置全局时间格式转换
     * @return
     */
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converter.setObjectMapper(om);
        return converter;
    }


}
