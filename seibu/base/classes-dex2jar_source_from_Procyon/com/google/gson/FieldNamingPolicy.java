// 
// Decompiled by Procyon v0.5.36
// 

package com.google.gson;

import java.util.Locale;
import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy
{
    IDENTITY {
        @Override
        public String translateName(final Field field) {
            return field.getName();
        }
    }, 
    LOWER_CASE_WITH_DASHES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_UNDERSCORES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }, 
    UPPER_CAMEL_CASE {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }, 
    UPPER_CAMEL_CASE_WITH_SPACES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    };
    
    private static String modifyString(final char c, final String s, final int beginIndex) {
        if (beginIndex < s.length()) {
            return c + s.substring(beginIndex);
        }
        return String.valueOf(c);
    }
    
    static String separateCamelCase(final String s, final String str) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (Character.isUpperCase(char1) && sb.length() != 0) {
                sb.append(str);
            }
            sb.append(char1);
        }
        return sb.toString();
    }
    
    static String upperCaseFirstLetter(final String s) {
        final StringBuilder sb = new StringBuilder();
        int index;
        char c;
        for (index = 0, c = s.charAt(0); index < s.length() - 1 && !Character.isLetter(c); ++index, c = s.charAt(index)) {
            sb.append(c);
        }
        String string = s;
        if (!Character.isUpperCase(c)) {
            string = sb.append(modifyString(Character.toUpperCase(c), s, index + 1)).toString();
        }
        return string;
    }
}
