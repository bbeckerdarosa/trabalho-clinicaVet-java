package br.com.clinicaVet.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.format.Formatter;

public class LocalDateParser {

    @Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return DateTimeFormatter.ISO_DATE.format(object);
            }
        };
    }
}
