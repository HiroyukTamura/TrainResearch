// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class ResultParser
{
    private static final Pattern AMPERSAND;
    private static final String BYTE_ORDER_MARK = "\ufeff";
    private static final Pattern DIGITS;
    private static final Pattern EQUALS;
    private static final ResultParser[] PARSERS;
    
    static {
        PARSERS = new ResultParser[] { new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser() };
        DIGITS = Pattern.compile("\\d+");
        AMPERSAND = Pattern.compile("&");
        EQUALS = Pattern.compile("=");
    }
    
    private static void appendKeyValue(final CharSequence input, final Map<String, String> map) {
        final String[] split = ResultParser.EQUALS.split(input, 2);
        if (split.length != 2) {
            return;
        }
        final String s = split[0];
        final String s2 = split[1];
        try {
            map.put(s, urlDecode(s2));
        }
        catch (IllegalArgumentException ex) {}
    }
    
    private static int countPrecedingBackslashes(final CharSequence charSequence, int n) {
        int n2 = 0;
        for (--n; n >= 0 && charSequence.charAt(n) == '\\'; --n) {
            ++n2;
        }
        return n2;
    }
    
    protected static String getMassagedText(final Result result) {
        String s2;
        final String s = s2 = result.getText();
        if (s.startsWith("\ufeff")) {
            s2 = s.substring(1);
        }
        return s2;
    }
    
    protected static boolean isStringOfDigits(final CharSequence input, final int n) {
        return input != null && n > 0 && n == input.length() && ResultParser.DIGITS.matcher(input).matches();
    }
    
    protected static boolean isSubstringOfDigits(final CharSequence charSequence, final int n, int n2) {
        if (charSequence != null && n2 > 0) {
            n2 += n;
            if (charSequence.length() >= n2 && ResultParser.DIGITS.matcher(charSequence.subSequence(n, n2)).matches()) {
                return true;
            }
        }
        return false;
    }
    
    static String[] matchPrefixedField(final String str, final String s, final char ch, final boolean b) {
        List<String> list = null;
        int i = 0;
        while (i < s.length()) {
            final int index = s.indexOf(str, i);
            if (index < 0) {
                break;
            }
            final int beginIndex = index + str.length();
            int n = 1;
            List<String> list2 = list;
            int length = beginIndex;
            while (true) {
                final int fromIndex = i = length;
                list = list2;
                if (n == 0) {
                    break;
                }
                final int index2 = s.indexOf(ch, fromIndex);
                if (index2 < 0) {
                    length = s.length();
                    n = 0;
                }
                else if (countPrecedingBackslashes(s, index2) % 2 != 0) {
                    length = index2 + 1;
                }
                else {
                    List<String> list3;
                    if ((list3 = list2) == null) {
                        list3 = new ArrayList<String>(3);
                    }
                    String s3;
                    final String s2 = s3 = unescapeBackslash(s.substring(beginIndex, index2));
                    if (b) {
                        s3 = s2.trim();
                    }
                    if (!s3.isEmpty()) {
                        list3.add(s3);
                    }
                    length = index2 + 1;
                    n = 0;
                    list2 = list3;
                }
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.toArray(new String[list.size()]);
    }
    
    static String matchSinglePrefixedField(final String s, final String s2, final char c, final boolean b) {
        final String[] matchPrefixedField = matchPrefixedField(s, s2, c, b);
        if (matchPrefixedField == null) {
            return null;
        }
        return matchPrefixedField[0];
    }
    
    protected static void maybeAppend(final String str, final StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }
    
    protected static void maybeAppend(final String[] array, final StringBuilder sb) {
        if (array != null) {
            for (int length = array.length, i = 0; i < length; ++i) {
                final String str = array[i];
                sb.append('\n');
                sb.append(str);
            }
        }
    }
    
    protected static String[] maybeWrap(final String s) {
        if (s == null) {
            return null;
        }
        return new String[] { s };
    }
    
    protected static int parseHexDigit(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        return -1;
    }
    
    static Map<String, String> parseNameValuePairs(final String s) {
        final int index = s.indexOf(63);
        Map<String, String> map;
        if (index < 0) {
            map = null;
        }
        else {
            final HashMap<String, String> hashMap = new HashMap<String, String>(3);
            final String[] split = ResultParser.AMPERSAND.split(s.substring(index + 1));
            final int length = split.length;
            int n = 0;
            while (true) {
                map = hashMap;
                if (n >= length) {
                    break;
                }
                appendKeyValue(split[n], hashMap);
                ++n;
            }
        }
        return map;
    }
    
    public static ParsedResult parseResult(final Result result) {
        final ResultParser[] parsers = ResultParser.PARSERS;
        for (int length = parsers.length, i = 0; i < length; ++i) {
            final ParsedResult parse = parsers[i].parse(result);
            if (parse != null) {
                return parse;
            }
        }
        return new TextParsedResult(result.getText(), null);
    }
    
    protected static String unescapeBackslash(final String s) {
        int i = s.indexOf(92);
        if (i < 0) {
            return s;
        }
        final int length = s.length();
        final StringBuilder sb = new StringBuilder(length - 1);
        sb.append(s.toCharArray(), 0, i);
        int n = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            if (n != 0 || char1 != '\\') {
                sb.append(char1);
                n = 0;
            }
            else {
                n = 1;
            }
            ++i;
        }
        return sb.toString();
    }
    
    static String urlDecode(String decode) {
        try {
            decode = URLDecoder.decode(decode, "UTF-8");
            return decode;
        }
        catch (UnsupportedEncodingException cause) {
            throw new IllegalStateException(cause);
        }
    }
    
    public abstract ParsedResult parse(final Result p0);
}
