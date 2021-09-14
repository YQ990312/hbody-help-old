package com.indata.service.web.config;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YangQi
 * @Date: 2021/9/14 14:30
 */
public class LocalTimeConverter implements Converter<String, LocalTime> {
    private final DateTimeFormatter formatter;

    public LocalTimeConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalTime.parse(source, formatter);
    }
}
