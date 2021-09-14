package com.indata.service.web.config;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YangQi
 * @Date: 2021/9/14 14:30
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    private final DateTimeFormatter formatter;

    public LocalDateTimeConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDateTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalDateTime.parse(source, formatter);

    }
}
