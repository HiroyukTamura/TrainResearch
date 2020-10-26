// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.util.Iterator;
import java.util.List;

public class StringUtils
{
    public static int countHas(String s, String substring) {
        int n = 0;
        final int index = s.indexOf(substring);
        int n2;
        do {
            n2 = n;
            if (index <= 0) {
                break;
            }
            n2 = n + 1;
            substring = s.substring(index + 1);
            n = n2;
            s = substring;
        } while (substring.length() != 0);
        return n2;
    }
    
    public static boolean isNullSpace(final String s) {
        return s == null || s.trim().length() == 0;
    }
    
    public static long parseLong(final String s) {
        if (isNullSpace(s)) {
            return -1L;
        }
        return Long.parseLong(s);
    }
    
    public static String stringByJoinList(final List<String> list, final String str) {
        final StringBuilder sb = new StringBuilder();
        int n = 1;
        for (final String str2 : list) {
            if (n == 0) {
                sb.append(str);
            }
            sb.append(str2);
            n = 0;
        }
        return sb.toString();
    }
    
    public static String[] toStringArray(final List<Object> list) {
        String[] array;
        if (list == null || list.size() == 0) {
            array = null;
        }
        else {
            final String[] array2 = new String[list.size()];
            int n = 0;
            while (true) {
                array = array2;
                if (n >= list.size()) {
                    break;
                }
                array2[n] = String.valueOf(list.get(n));
                ++n;
            }
        }
        return array;
    }
}
