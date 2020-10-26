// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class VINResultParser extends ResultParser
{
    private static final Pattern AZ09;
    private static final Pattern IOQ;
    
    static {
        IOQ = Pattern.compile("[IOQ]");
        AZ09 = Pattern.compile("[A-Z0-9]{17}");
    }
    
    private static char checkChar(final int n) {
        if (n < 10) {
            return (char)(n + 48);
        }
        if (n == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }
    
    private static boolean checkChecksum(final CharSequence charSequence) {
        int n = 0;
        for (int i = 0; i < charSequence.length(); ++i) {
            n += vinPositionWeight(i + 1) * vinCharValue(charSequence.charAt(i));
        }
        return charSequence.charAt(8) == checkChar(n % 11);
    }
    
    private static String countryCode(final CharSequence charSequence) {
        final char char1 = charSequence.charAt(0);
        final char char2 = charSequence.charAt(1);
        switch (char1) {
            case 49:
            case 52:
            case 53: {
                return "US";
            }
            case 50: {
                return "CA";
            }
            case 51: {
                if (char2 >= 'A' && char2 <= 'W') {
                    return "MX";
                }
                break;
            }
            case 57: {
                if ((char2 >= 'A' && char2 <= 'E') || (char2 >= '3' && char2 <= '9')) {
                    return "BR";
                }
                break;
            }
            case 74: {
                if (char2 >= 'A' && char2 <= 'T') {
                    return "JP";
                }
                break;
            }
            case 75: {
                if (char2 >= 'L' && char2 <= 'R') {
                    return "KO";
                }
                break;
            }
            case 76: {
                return "CN";
            }
            case 77: {
                if (char2 >= 'A' && char2 <= 'E') {
                    return "IN";
                }
                break;
            }
            case 83: {
                if (char2 >= 'A' && char2 <= 'M') {
                    return "UK";
                }
                if (char2 >= 'N' && char2 <= 'T') {
                    return "DE";
                }
                break;
            }
            case 86: {
                if (char2 >= 'F' && char2 <= 'R') {
                    return "FR";
                }
                if (char2 >= 'S' && char2 <= 'W') {
                    return "ES";
                }
                break;
            }
            case 87: {
                return "DE";
            }
            case 88: {
                if (char2 == '0' || (char2 >= '3' && char2 <= '9')) {
                    return "RU";
                }
                break;
            }
            case 90: {
                if (char2 >= 'A' && char2 <= 'R') {
                    return "IT";
                }
                break;
            }
        }
        return null;
    }
    
    private static int modelYear(final char c) {
        if (c >= 'E' && c <= 'H') {
            return c - 'E' + 1984;
        }
        if (c >= 'J' && c <= 'N') {
            return c - 'J' + 1988;
        }
        if (c == 'P') {
            return 1993;
        }
        if (c >= 'R' && c <= 'T') {
            return c - 'R' + 1994;
        }
        if (c >= 'V' && c <= 'Y') {
            return c - 'V' + 1997;
        }
        if (c >= '1' && c <= '9') {
            return c - '1' + 2001;
        }
        if (c >= 'A' && c <= 'D') {
            return c - 'A' + 2010;
        }
        throw new IllegalArgumentException();
    }
    
    private static int vinCharValue(final char c) {
        if (c >= 'A' && c <= 'I') {
            return c - 'A' + 1;
        }
        if (c >= 'J' && c <= 'R') {
            return c - 'J' + 1;
        }
        if (c >= 'S' && c <= 'Z') {
            return c - 'S' + 2;
        }
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        throw new IllegalArgumentException();
    }
    
    private static int vinPositionWeight(final int n) {
        int n2 = 10;
        if (n > 0 && n <= 7) {
            n2 = 9 - n;
        }
        else if (n != 8) {
            if (n == 9) {
                return 0;
            }
            if (n >= 10 && n <= 17) {
                return 19 - n;
            }
            throw new IllegalArgumentException();
        }
        return n2;
    }
    
    @Override
    public VINParsedResult parse(final Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
            return null;
        }
        final String trim = VINResultParser.IOQ.matcher(result.getText()).replaceAll("").trim();
        if (!VINResultParser.AZ09.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!checkChecksum(trim)) {
                return null;
            }
            final String substring = trim.substring(0, 3);
            return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
