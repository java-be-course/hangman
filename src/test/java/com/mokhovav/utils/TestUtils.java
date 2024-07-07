package com.mokhovav.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;

public class TestUtils {
    public static void writeInConsole(String str){
        if (StringUtils.isBlank(str)){
            return;
        }
        System.setIn(new ByteArrayInputStream(str.getBytes()));
    }
}
