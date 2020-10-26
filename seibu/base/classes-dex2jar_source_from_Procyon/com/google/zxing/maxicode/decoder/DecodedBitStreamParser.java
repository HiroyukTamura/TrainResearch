// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.maxicode.decoder;

import java.util.List;
import java.text.DecimalFormat;
import com.google.zxing.common.DecoderResult;

final class DecodedBitStreamParser
{
    private static final char ECI = '\ufffa';
    private static final char FS = '\u001c';
    private static final char GS = '\u001d';
    private static final char LATCHA = '\ufff7';
    private static final char LATCHB = '\ufff8';
    private static final char LOCK = '\ufff9';
    private static final char NS = '\ufffb';
    private static final char PAD = '\ufffc';
    private static final char RS = '\u001e';
    private static final String[] SETS;
    private static final char SHIFTA = '\ufff0';
    private static final char SHIFTB = '\ufff1';
    private static final char SHIFTC = '\ufff2';
    private static final char SHIFTD = '\ufff3';
    private static final char SHIFTE = '\ufff4';
    private static final char THREESHIFTA = '\ufff6';
    private static final char TWOSHIFTA = '\ufff5';
    
    static {
        SETS = new String[] { "\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb \ufffc\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{\ufffc}~\u007f;<=>?[\\]^_ ,./:@!|\ufffc\ufff5\ufff6\ufffc\ufff0\ufff2\ufff3\ufff4\ufff7", "\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\ufffa\u001c\u001d\u001e\u00db\u00dc\u00dd\u00de\u00dfª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\ufffa\u001c\u001d\u001e\ufffb\u00fb\u00fc\u00fd\u00fe\u00ff¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa\ufffc\ufffc\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?" };
    }
    
    private DecodedBitStreamParser() {
    }
    
    static DecoderResult decode(final byte[] array, final int i) {
        final StringBuilder sb = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3: {
                String s;
                if (i == 2) {
                    s = new DecimalFormat("0000000000".substring(0, getPostCode2Length(array))).format(getPostCode2(array));
                }
                else {
                    s = getPostCode3(array);
                }
                final DecimalFormat decimalFormat = new DecimalFormat("000");
                final String format = decimalFormat.format(getCountry(array));
                final String format2 = decimalFormat.format(getServiceClass(array));
                sb.append(getMessage(array, 10, 84));
                if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                    sb.insert(9, s + '\u001d' + format + '\u001d' + format2 + '\u001d');
                    break;
                }
                sb.insert(0, s + '\u001d' + format + '\u001d' + format2 + '\u001d');
                break;
            }
            case 4: {
                sb.append(getMessage(array, 1, 93));
                break;
            }
            case 5: {
                sb.append(getMessage(array, 1, 77));
                break;
            }
        }
        return new DecoderResult(array, sb.toString(), null, String.valueOf(i));
    }
    
    private static int getBit(int n, final byte[] array) {
        final int n2 = 1;
        final int n3 = n - 1;
        n = n2;
        if ((array[n3 / 6] & 1 << 5 - n3 % 6) == 0x0) {
            n = 0;
        }
        return n;
    }
    
    private static int getCountry(final byte[] array) {
        return getInt(array, new byte[] { 53, 54, 43, 44, 45, 46, 47, 48, 37, 38 });
    }
    
    private static int getInt(final byte[] array, final byte[] array2) {
        if (array2.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = 0;
        for (int i = 0; i < array2.length; ++i) {
            n += getBit(array2[i], array) << array2.length - i - 1;
        }
        return n;
    }
    
    private static String getMessage(final byte[] array, final int n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        int n3 = -1;
        int n4 = 0;
        int n5 = 0;
        int n13;
        for (int i = n; i < n + n2; ++i, n3 = n13) {
            final char char1 = DecodedBitStreamParser.SETS[n4].charAt(array[i]);
            switch (char1) {
                default: {
                    sb.append(char1);
                    break;
                }
                case 65527: {
                    n4 = 0;
                    n3 = -1;
                    break;
                }
                case 65528: {
                    n4 = 1;
                    n3 = -1;
                    break;
                }
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524: {
                    final int n6 = char1 - '\ufff0';
                    n3 = 1;
                    n5 = n4;
                    n4 = n6;
                    break;
                }
                case 65525: {
                    final int n7 = 0;
                    n3 = 2;
                    n5 = n4;
                    n4 = n7;
                    break;
                }
                case 65526: {
                    final int n8 = 0;
                    n3 = 3;
                    n5 = n4;
                    n4 = n8;
                    break;
                }
                case 65531: {
                    final int n9 = i + 1;
                    final byte b = array[n9];
                    final int n10 = n9 + 1;
                    final byte b2 = array[n10];
                    final int n11 = n10 + 1;
                    final byte b3 = array[n11];
                    final int n12 = n11 + 1;
                    final byte b4 = array[n12];
                    i = n12 + 1;
                    sb.append(new DecimalFormat("000000000").format((b << 24) + (b2 << 18) + (b3 << 12) + (b4 << 6) + array[i]));
                    break;
                }
                case 65529: {
                    n3 = -1;
                    break;
                }
            }
            n13 = n3 - 1;
            if (n3 == 0) {
                n4 = n5;
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\ufffc') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private static int getPostCode2(final byte[] array) {
        return getInt(array, new byte[] { 33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2 });
    }
    
    private static int getPostCode2Length(final byte[] array) {
        return getInt(array, new byte[] { 39, 40, 41, 42, 31, 32 });
    }
    
    private static String getPostCode3(final byte[] array) {
        return String.valueOf(new char[] { DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 39, 40, 41, 42, 31, 32 })), DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 33, 34, 35, 36, 25, 26 })), DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 27, 28, 29, 30, 19, 20 })), DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 21, 22, 23, 24, 13, 14 })), DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 15, 16, 17, 18, 7, 8 })), DecodedBitStreamParser.SETS[0].charAt(getInt(array, new byte[] { 9, 10, 11, 12, 1, 2 })) });
    }
    
    private static int getServiceClass(final byte[] array) {
        return getInt(array, new byte[] { 55, 56, 57, 58, 59, 60, 49, 50, 51, 52 });
    }
}
