// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.net.URI;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

public final class zzm
{
    private static final Pattern zzaJR;
    private static final Pattern zzaJS;
    private static final Pattern zzaJT;
    
    static {
        zzaJR = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        zzaJS = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        zzaJT = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }
    
    private static String decode(final String s, String s2) {
        Label_0010: {
            if (s2 == null) {
                break Label_0010;
            }
            try {
                return URLDecoder.decode(s, s2);
                s2 = "ISO-8859-1";
                return URLDecoder.decode(s, s2);
            }
            catch (UnsupportedEncodingException cause) {
                throw new IllegalArgumentException(cause);
            }
        }
    }
    
    public static Map<String, String> zza(final URI uri, final String s) {
        final Map<String, String> emptyMap = Collections.emptyMap();
        final String rawQuery = uri.getRawQuery();
        Map<String, String> map = emptyMap;
        if (rawQuery != null) {
            map = emptyMap;
            if (rawQuery.length() > 0) {
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                final Scanner scanner = new Scanner(rawQuery);
                scanner.useDelimiter("&");
                while (scanner.hasNext()) {
                    final String[] split = scanner.next().split("=");
                    if (split.length == 0 || split.length > 2) {
                        throw new IllegalArgumentException("bad parameter");
                    }
                    final String decode = decode(split[0], s);
                    String decode2 = null;
                    if (split.length == 2) {
                        decode2 = decode(split[1], s);
                    }
                    hashMap.put(decode, decode2);
                }
                map = hashMap;
            }
        }
        return map;
    }
}
