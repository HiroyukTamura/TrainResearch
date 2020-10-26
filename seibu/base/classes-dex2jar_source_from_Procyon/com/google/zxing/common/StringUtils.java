// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;
import java.nio.charset.Charset;

public final class StringUtils
{
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";
    
    static {
        PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
        ASSUME_SHIFT_JIS = ("SJIS".equalsIgnoreCase(StringUtils.PLATFORM_DEFAULT_ENCODING) || "EUC_JP".equalsIgnoreCase(StringUtils.PLATFORM_DEFAULT_ENCODING));
    }
    
    private StringUtils() {
    }
    
    public static String guessEncoding(final byte[] array, final Map<DecodeHintType, ?> map) {
        if (map != null && map.containsKey(DecodeHintType.CHARACTER_SET)) {
            return map.get(DecodeHintType.CHARACTER_SET).toString();
        }
        final int length = array.length;
        int n = 1;
        int n2 = 1;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        final boolean b = array.length > 3 && array[0] == -17 && array[1] == -69 && array[2] == -65;
        int n17;
        int n18;
        int n19;
        int n20;
        int n21;
        int n23;
        int n24;
        int n25;
        int n26;
        int n27;
        int n28;
        int n29;
        int n30;
        int n31;
        for (int n15 = 0; n15 < length && (n != 0 || n2 != 0 || n3 != 0); ++n15, n = n23, n2 = n25, n3 = n17, n14 = n24, n8 = n26, n11 = n27, n10 = n28, n9 = n29, n13 = n30, n12 = n31, n5 = n18, n6 = n19, n7 = n20, n4 = n21) {
            final int n16 = array[n15] & 0xFF;
            n17 = n3;
            n18 = n5;
            n19 = n6;
            n20 = n7;
            n21 = n4;
            Label_0200: {
                if (n3 != 0) {
                    if (n4 > 0) {
                        n21 = n4;
                        if ((n16 & 0x80) != 0x0) {
                            n21 = n4 - 1;
                            n20 = n7;
                            n19 = n6;
                            n18 = n5;
                            n17 = n3;
                            break Label_0200;
                        }
                    }
                    else {
                        n17 = n3;
                        n18 = n5;
                        n19 = n6;
                        n20 = n7;
                        n21 = n4;
                        if ((n16 & 0x80) == 0x0) {
                            break Label_0200;
                        }
                        n21 = n4;
                        if ((n16 & 0x40) != 0x0) {
                            n21 = n4 + 1;
                            if ((n16 & 0x20) == 0x0) {
                                n18 = n5 + 1;
                                n17 = n3;
                                n19 = n6;
                                n20 = n7;
                                break Label_0200;
                            }
                            ++n21;
                            if ((n16 & 0x10) == 0x0) {
                                n19 = n6 + 1;
                                n17 = n3;
                                n18 = n5;
                                n20 = n7;
                                break Label_0200;
                            }
                            final int n22 = ++n21;
                            if ((n16 & 0x8) == 0x0) {
                                n20 = n7 + 1;
                                n17 = n3;
                                n18 = n5;
                                n19 = n6;
                                n21 = n22;
                                break Label_0200;
                            }
                        }
                    }
                    n17 = 0;
                    n18 = n5;
                    n19 = n6;
                    n20 = n7;
                }
            }
            n23 = n;
            n24 = n14;
            Label_0235: {
                if (n != 0) {
                    if (n16 > 127 && n16 < 160) {
                        n23 = 0;
                        n24 = n14;
                    }
                    else {
                        n23 = n;
                        n24 = n14;
                        if (n16 > 159) {
                            if (n16 >= 192 && n16 != 215) {
                                n23 = n;
                                n24 = n14;
                                if (n16 != 247) {
                                    break Label_0235;
                                }
                            }
                            n24 = n14 + 1;
                            n23 = n;
                        }
                    }
                }
            }
            n25 = n2;
            n26 = n8;
            n27 = n11;
            n28 = n10;
            n29 = n9;
            n30 = n13;
            n31 = n12;
            if (n2 != 0) {
                if (n8 > 0) {
                    if (n16 < 64 || n16 == 127 || n16 > 252) {
                        n25 = 0;
                        n31 = n12;
                        n30 = n13;
                        n29 = n9;
                        n28 = n10;
                        n27 = n11;
                        n26 = n8;
                    }
                    else {
                        n26 = n8 - 1;
                        n25 = n2;
                        n27 = n11;
                        n28 = n10;
                        n29 = n9;
                        n30 = n13;
                        n31 = n12;
                    }
                }
                else if (n16 == 128 || n16 == 160 || n16 > 239) {
                    n25 = 0;
                    n26 = n8;
                    n27 = n11;
                    n28 = n10;
                    n29 = n9;
                    n30 = n13;
                    n31 = n12;
                }
                else if (n16 > 160 && n16 < 224) {
                    final int n32 = n9 + 1;
                    final int n33 = 0;
                    final int n34 = n10 + 1;
                    n25 = n2;
                    n26 = n8;
                    n27 = n33;
                    n28 = n34;
                    n29 = n32;
                    n30 = n13;
                    if (n34 > (n31 = n12)) {
                        n31 = n34;
                        n25 = n2;
                        n26 = n8;
                        n27 = n33;
                        n28 = n34;
                        n29 = n32;
                        n30 = n13;
                    }
                }
                else if (n16 > 127) {
                    final int n35 = n8 + 1;
                    final int n36 = 0;
                    final int n37 = n11 + 1;
                    n25 = n2;
                    n26 = n35;
                    n27 = n37;
                    n28 = n36;
                    n29 = n9;
                    n30 = n13;
                    n31 = n12;
                    if (n37 > n13) {
                        n30 = n37;
                        n25 = n2;
                        n26 = n35;
                        n27 = n37;
                        n28 = n36;
                        n29 = n9;
                        n31 = n12;
                    }
                }
                else {
                    n28 = 0;
                    n27 = 0;
                    n25 = n2;
                    n26 = n8;
                    n29 = n9;
                    n30 = n13;
                    n31 = n12;
                }
            }
        }
        int n38;
        if ((n38 = n3) != 0) {
            n38 = n3;
            if (n4 > 0) {
                n38 = 0;
            }
        }
        int n39;
        if ((n39 = n2) != 0) {
            n39 = n2;
            if (n8 > 0) {
                n39 = 0;
            }
        }
        if (n38 != 0 && (b || n5 + n6 + n7 > 0)) {
            return "UTF8";
        }
        if (n39 != 0 && (StringUtils.ASSUME_SHIFT_JIS || n12 >= 3 || n13 >= 3)) {
            return "SJIS";
        }
        if (n != 0 && n39 != 0) {
            if ((n12 == 2 && n9 == 2) || n14 * 10 >= length) {
                return "SJIS";
            }
            return "ISO8859_1";
        }
        else {
            if (n != 0) {
                return "ISO8859_1";
            }
            if (n39 != 0) {
                return "SJIS";
            }
            if (n38 != 0) {
                return "UTF8";
            }
            return StringUtils.PLATFORM_DEFAULT_ENCODING;
        }
    }
}
