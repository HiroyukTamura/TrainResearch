// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.CheckReturnValue;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Ascii
{
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte CAN = 24;
    public static final byte CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;
    public static final byte EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;
    public static final byte FF = 12;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final char MAX = '\u007f';
    public static final char MIN = '\0';
    public static final byte NAK = 21;
    public static final byte NL = 10;
    public static final byte NUL = 0;
    public static final byte RS = 30;
    public static final byte SI = 15;
    public static final byte SO = 14;
    public static final byte SOH = 1;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;
    public static final byte US = 31;
    public static final byte VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;
    
    private Ascii() {
    }
    
    @Beta
    public static boolean equalsIgnoreCase(final CharSequence charSequence, final CharSequence charSequence2) {
        final int length = charSequence.length();
        if (charSequence != charSequence2) {
            if (length != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < length; ++i) {
                final char char1 = charSequence.charAt(i);
                final char char2 = charSequence2.charAt(i);
                if (char1 != char2) {
                    final int alphaIndex = getAlphaIndex(char1);
                    if (alphaIndex >= 26 || alphaIndex != getAlphaIndex(char2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static int getAlphaIndex(final char c) {
        return (char)((c | ' ') - 97);
    }
    
    public static boolean isLowerCase(final char c) {
        return c >= 'a' && c <= 'z';
    }
    
    public static boolean isUpperCase(final char c) {
        return c >= 'A' && c <= 'Z';
    }
    
    public static char toLowerCase(final char c) {
        char c2 = c;
        if (isUpperCase(c)) {
            c2 = (char)(c ^ ' ');
        }
        return c2;
    }
    
    public static String toLowerCase(final CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String)charSequence);
        }
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append(toLowerCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }
    
    public static String toLowerCase(final String s) {
        final int length = s.length();
        int i = 0;
        String value;
        while (true) {
            value = s;
            if (i >= length) {
                break;
            }
            if (isUpperCase(s.charAt(i))) {
                final char[] charArray = s.toCharArray();
                while (i < length) {
                    final char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char)(c ^ ' ');
                    }
                    ++i;
                }
                value = String.valueOf(charArray);
                break;
            }
            ++i;
        }
        return value;
    }
    
    public static char toUpperCase(final char c) {
        char c2 = c;
        if (isLowerCase(c)) {
            c2 = (char)(c & '_');
        }
        return c2;
    }
    
    public static String toUpperCase(final CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String)charSequence);
        }
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append(toUpperCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }
    
    public static String toUpperCase(final String s) {
        final int length = s.length();
        int i = 0;
        String value;
        while (true) {
            value = s;
            if (i >= length) {
                break;
            }
            if (isLowerCase(s.charAt(i))) {
                final char[] charArray = s.toCharArray();
                while (i < length) {
                    final char c = charArray[i];
                    if (isLowerCase(c)) {
                        charArray[i] = (char)(c & '_');
                    }
                    ++i;
                }
                value = String.valueOf(charArray);
                break;
            }
            ++i;
        }
        return value;
    }
    
    @CheckReturnValue
    @Beta
    public static String truncate(final CharSequence charSequence, final int n, final String str) {
        Preconditions.checkNotNull(charSequence);
        final int end = n - str.length();
        Preconditions.checkArgument(end >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n, str.length());
        CharSequence string = charSequence;
        if (charSequence.length() <= n) {
            string = charSequence.toString();
            if (((String)string).length() <= n) {
                return (String)string;
            }
        }
        return new StringBuilder(n).append(string, 0, end).append(str).toString();
    }
}
