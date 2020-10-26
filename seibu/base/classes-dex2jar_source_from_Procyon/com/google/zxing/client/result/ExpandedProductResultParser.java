// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.Map;
import java.util.HashMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ExpandedProductResultParser extends ResultParser
{
    private static String findAIvalue(int i, String substring) {
        if (substring.charAt(i) == '(') {
            substring = substring.substring(i + 1);
            final StringBuilder sb = new StringBuilder();
            char char1;
            for (i = 0; i < substring.length(); ++i) {
                char1 = substring.charAt(i);
                if (char1 == ')') {
                    return sb.toString();
                }
                if (char1 < '0' || char1 > '9') {
                    return null;
                }
                sb.append(char1);
            }
            return sb.toString();
        }
        return null;
    }
    
    private static String findValue(int i, String substring) {
        final StringBuilder sb = new StringBuilder();
        char char1;
        for (substring = substring.substring(i), i = 0; i < substring.length(); ++i) {
            char1 = substring.charAt(i);
            if (char1 == '(') {
                if (findAIvalue(i, substring) != null) {
                    break;
                }
                sb.append('(');
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    @Override
    public ExpandedProductParsedResult parse(final Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        final String massagedText = ResultParser.getMassagedText(result);
        String s = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        String s10 = null;
        String substring = null;
        String s11 = null;
        String substring2 = null;
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        int i = 0;
        while (i < massagedText.length()) {
            final String aIvalue = findAIvalue(i, massagedText);
            if (aIvalue == null) {
                return null;
            }
            final int n = i + (aIvalue.length() + 2);
            final String value = findValue(n, massagedText);
            final int n2 = n + value.length();
            switch (aIvalue) {
                default: {
                    hashMap.put(aIvalue, value);
                    i = n2;
                    continue;
                }
                case "00": {
                    s2 = value;
                    i = n2;
                    continue;
                }
                case "01": {
                    s = value;
                    i = n2;
                    continue;
                }
                case "10": {
                    s3 = value;
                    i = n2;
                    continue;
                }
                case "11": {
                    s4 = value;
                    i = n2;
                    continue;
                }
                case "13": {
                    s5 = value;
                    i = n2;
                    continue;
                }
                case "15": {
                    s6 = value;
                    i = n2;
                    continue;
                }
                case "17": {
                    s7 = value;
                    i = n2;
                    continue;
                }
                case "3100":
                case "3101":
                case "3102":
                case "3103":
                case "3104":
                case "3105":
                case "3106":
                case "3107":
                case "3108":
                case "3109": {
                    s9 = "KG";
                    s10 = aIvalue.substring(3);
                    s8 = value;
                    i = n2;
                    continue;
                }
                case "3200":
                case "3201":
                case "3202":
                case "3203":
                case "3204":
                case "3205":
                case "3206":
                case "3207":
                case "3208":
                case "3209": {
                    s9 = "LB";
                    s10 = aIvalue.substring(3);
                    s8 = value;
                    i = n2;
                    continue;
                }
                case "3920":
                case "3921":
                case "3922":
                case "3923": {
                    s11 = aIvalue.substring(3);
                    substring = value;
                    i = n2;
                    continue;
                }
                case "3930":
                case "3931":
                case "3932":
                case "3933": {
                    if (value.length() < 4) {
                        return null;
                    }
                    substring = value.substring(3);
                    substring2 = value.substring(0, 3);
                    s11 = aIvalue.substring(3);
                    i = n2;
                    continue;
                }
            }
        }
        return new ExpandedProductParsedResult(massagedText, s, s2, s3, s4, s5, s6, s7, s8, s9, s10, substring, s11, substring2, hashMap);
    }
}
