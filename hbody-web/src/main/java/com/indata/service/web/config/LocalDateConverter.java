package com.indata.service.web.config;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YangQi
 * @Date: 2021/9/14 14:29
 */
public class LocalDateConverter implements Converter<String, LocalDate> {
    private final DateTimeFormatter formatter;

    public LocalDateConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDate convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalDate.parse(source, formatter);
    }
}
