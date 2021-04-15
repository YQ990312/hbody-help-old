package com.indata.service.web.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangqi
 */
@Configuration
@ComponentScan(
        basePackages = {
                "com.indata.service.web.controller",
                "com.indata.service.web.aop"
        }
)
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

        private static final Logger log= LoggerFactory.getLogger(WebMvcConfig.class);

        /**
         * 配置web连接使用
         * @return
         */
        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver commonsMultipartResolver() {
                log.info("==== commonsMultipartResolver execute ====");

                CommonsMultipartResolver resolver = new CommonsMultipartResolver();
                resolver.setMaxInMemorySize(200 * 1024 * 1024);
                resolver.setMaxUploadSize(200 * 1024 * 1024);
                resolver.setResolveLazily(true);
                resolver.setDefaultEncoding("UTF-8");
                return resolver;
        }

        /**
         * 数据格式
         * @param converters
         */
        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                log.info("==== mappingJackson2HttpMessageConverter execute ====");

                MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
                jacksonConverter.setSupportedMediaTypes(Stream.of(
                        new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8")),
                        new MediaType("application", "*+json"),
                        new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")),
                        new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8")),
                        new MediaType(MediaType.MULTIPART_FORM_DATA, Charset.forName("UTF-8"))
                ).collect(Collectors.toList()));

                JavaTimeModule javaTimeModule = new JavaTimeModule();
                //配置序列化格式
                javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

                //配置反序列化格式
                javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));


                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                objectMapper.setTimeZone(TimeZone.getDefault());
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.registerModule(javaTimeModule);
                objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);
                jacksonConverter.setObjectMapper(objectMapper);

                log.info("==== stringHttpMessageConverter execute ====");
                StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
                converters.add(stringConverter);
                converters.add(jacksonConverter);

                converters.parallelStream()
                        //过滤出MappingJackson2HttpMessageConverter
                        .filter(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter)
                        //将所有MappingJackson2HttpMessageConverter中的objectMapper替换成自定义的策略
                        .forEach(httpMessageConverter -> ((MappingJackson2HttpMessageConverter) httpMessageConverter).setObjectMapper(objectMapper));
        }

        /**
         * 拦截器
         * @param registry
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                log.info("==== addInterceptors init ====");
        }

}
