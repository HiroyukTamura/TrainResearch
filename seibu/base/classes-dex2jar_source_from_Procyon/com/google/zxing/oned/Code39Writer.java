// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;

public final class Code39Writer extends OneDimensionalCodeWriter
{
    private static void toIntArray(final int n, final int[] array) {
        for (int i = 0; i < 9; ++i) {
            int n2;
            if ((n & 1 << 8 - i) == 0x0) {
                n2 = 1;
            }
            else {
                n2 = 2;
            }
            array[i] = n2;
        }
    }
    
    private static String tryToConvertToExtendedMode(final String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            switch (char1) {
                default: {
                    if (char1 > '\0' && char1 < '\u001b') {
                        sb.append('$');
                        sb.append((char)(char1 - '\u0001' + 65));
                        break;
                    }
                    if (char1 > '\u001a' && char1 < ' ') {
                        sb.append('%');
                        sb.append((char)(char1 - '\u001b' + 65));
                        break;
                    }
                    if ((char1 > ' ' && char1 < '-') || char1 == '/' || char1 == ':') {
                        sb.append('/');
                        sb.append((char)(char1 - '!' + 65));
                        break;
                    }
                    if (char1 > '/' && char1 < ':') {
                        sb.append((char)(char1 - '0' + 48));
                        break;
                    }
                    if (char1 > ':' && char1 < '@') {
                        sb.append('%');
                        sb.append((char)(char1 - ';' + 70));
                        break;
                    }
                    if (char1 > '@' && char1 < '[') {
                        sb.append((char)(char1 - 'A' + 65));
                        break;
                    }
                    if (char1 > 'Z' && char1 < '`') {
                        sb.append('%');
                        sb.append((char)(char1 - '[' + 75));
                        break;
                    }
                    if (char1 > '`' && char1 < '{') {
                        sb.append('+');
                        sb.append((char)(char1 - 'a' + 65));
                        break;
                    }
                    if (char1 > 'z' && char1 < '\u0080') {
                        sb.append('%');
                        sb.append((char)(char1 - '{' + 80));
                        break;
                    }
                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + s.charAt(i) + "'");
                }
                case 0: {
                    sb.append("%U");
                    break;
                }
                case 32:
                case 45:
                case 46: {
                    sb.append(char1);
                    break;
                }
                case 64: {
                    sb.append("%V");
                    break;
                }
                case 96: {
                    sb.append("%W");
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.CODE_39) {
            throw new IllegalArgumentException("Can only encode CODE_39, but got " + obj);
        }
        return super.encode(s, obj, n, n2, map);
    }
    
    @Override
    public boolean[] encode(final String s) {
        final int length = s.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int index = 0;
        int n;
        String tryToConvertToExtendedMode;
        while (true) {
            n = length;
            tryToConvertToExtendedMode = s;
            if (index >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(s.charAt(index)) < 0) {
                tryToConvertToExtendedMode = tryToConvertToExtendedMode(s);
                final int length2 = tryToConvertToExtendedMode.length();
                if ((n = length2) > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length2 + " (extended full ASCII mode)");
                }
                break;
            }
            else {
                ++index;
            }
        }
        final int[] array = new int[9];
        int n2 = n + 25;
        for (int i = 0; i < n; ++i) {
            toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(tryToConvertToExtendedMode.charAt(i))], array);
            for (int j = 0; j < 9; ++j) {
                n2 += array[j];
            }
        }
        final boolean[] array2 = new boolean[n2];
        toIntArray(148, array);
        final int appendPattern = OneDimensionalCodeWriter.appendPattern(array2, 0, array, true);
        final int[] array3 = { 1 };
        int n3 = appendPattern + OneDimensionalCodeWriter.appendPattern(array2, appendPattern, array3, false);
        for (int k = 0; k < n; ++k) {
            toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(tryToConvertToExtendedMode.charAt(k))], array);
            final int n4 = n3 + OneDimensionalCodeWriter.appendPattern(array2, n3, array, true);
            n3 = n4 + OneDimensionalCodeWriter.appendPattern(array2, n4, array3, false);
        }
        toIntArray(148, array);
        OneDimensionalCodeWriter.appendPattern(array2, n3, array, true);
        return array2;
    }
}
