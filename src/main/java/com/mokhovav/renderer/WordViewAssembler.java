package com.mokhovav.renderer;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public class WordViewAssembler {

    private static String REPLACEMENT = "_";
    public static String toView(String word, Collection<String> letters) {
        if (CollectionUtils.isEmpty(letters)){
            return word.replaceAll(".", REPLACEMENT);
        }
        return word.replaceAll("[^" + String.join("", letters) + "]", REPLACEMENT);
    }
}
