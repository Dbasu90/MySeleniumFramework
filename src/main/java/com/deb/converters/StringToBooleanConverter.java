package com.deb.converters;

import io.github.sskorol.converters.DefaultConverter;

public class StringToBooleanConverter extends DefaultConverter<Boolean> {

    @Override
    public Boolean convert(String s) {
        return s.equalsIgnoreCase("yes");
    }
}
