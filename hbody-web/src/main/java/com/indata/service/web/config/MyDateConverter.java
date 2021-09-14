package com.indata.service.web.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: YangQi
 * @Date: 2021/9/14 14:40
 */
@Slf4j
public class MyDateConverter implements Converter<String, Date> {

    private static final Map<Pattern, String> pattern2Formats = new HashMap<>(4);

    static {
        pattern2Formats.put(Pattern.compile("^\\d{4}-\\d{1,2}"), "yyyy-MM");
        pattern2Formats.put(Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}"), "yyyy-MM-dd");
        pattern2Formats.put(Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}"), "yyyy-MM-dd HH:mm");
        pattern2Formats.put(Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}"), "yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }

        for (Map.Entry<Pattern, String> entry : pattern2Formats.entrySet()) {
            if (entry.getKey().matcher(source).matches()) {
                return parseDate(source, entry.getValue());
            }
        }
        throw new IllegalArgumentException("Invalid date value '" + source + "'");
    }

    /**
     * 格式化日期
     *
     * @param dateStr String 字符型日期 * @param format String 格式
     * @return Date 日期
     */
    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, format);
        } catch (Exception e) {
            log.error("错误的格式化时间: dateStr:{} , format:{}", dateStr, format);
        }
        return date;
    }
}
