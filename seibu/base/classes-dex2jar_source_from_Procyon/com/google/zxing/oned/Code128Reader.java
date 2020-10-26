// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import java.util.ArrayList;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader
{
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS;
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    
    static {
        CODE_PATTERNS = new int[][] { { 2, 1, 2, 2, 2, 2 }, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, { 1, 2, 1, 2, 2, 3 }, { 1, 2, 1, 3, 2, 2 }, { 1, 3, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 3 }, { 1, 2, 2, 3, 1, 2 }, { 1, 3, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 3 }, { 2, 2, 1, 3, 1, 2 }, { 2, 3, 1, 2, 1, 2 }, { 1, 1, 2, 2, 3, 2 }, { 1, 2, 2, 1, 3, 2 }, { 1, 2, 2, 2, 3, 1 }, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, { 2, 2, 3, 2, 1, 1 }, { 2, 2, 1, 1, 3, 2 }, { 2, 2, 1, 2, 3, 1 }, { 2, 1, 3, 2, 1, 2 }, { 2, 2, 3, 1, 1, 2 }, { 3, 1, 2, 1, 3, 1 }, { 3, 1, 1, 2, 2, 2 }, { 3, 2, 1, 1, 2, 2 }, { 3, 2, 1, 2, 2, 1 }, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, { 2, 1, 2, 1, 2, 3 }, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, { 1, 1, 1, 3, 2, 3 }, { 1, 3, 1, 1, 2, 3 }, { 1, 3, 1, 3, 2, 1 }, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, { 1, 3, 2, 3, 1, 1 }, { 2, 1, 1, 3, 1, 3 }, { 2, 3, 1, 1, 1, 3 }, { 2, 3, 1, 3, 1, 1 }, { 1, 1, 2, 1, 3, 3 }, { 1, 1, 2, 3, 3, 1 }, { 1, 3, 2, 1, 3, 1 }, { 1, 1, 3, 1, 2, 3 }, { 1, 1, 3, 3, 2, 1 }, { 1, 3, 3, 1, 2, 1 }, { 3, 1, 3, 1, 2, 1 }, { 2, 1, 1, 3, 3, 1 }, { 2, 3, 1, 1, 3, 1 }, { 2, 1, 3, 1, 1, 3 }, { 2, 1, 3, 3, 1, 1 }, { 2, 1, 3, 1, 3, 1 }, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, { 3, 1, 2, 1, 1, 3 }, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, { 3, 1, 4, 1, 1, 1 }, { 2, 2, 1, 4, 1, 1 }, { 4, 3, 1, 1, 1, 1 }, { 1, 1, 1, 2, 2, 4 }, { 1, 1, 1, 4, 2, 2 }, { 1, 2, 1, 1, 2, 4 }, { 1, 2, 1, 4, 2, 1 }, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, { 1, 1, 2, 2, 1, 4 }, { 1, 1, 2, 4, 1, 2 }, { 1, 2, 2, 1, 1, 4 }, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, { 1, 4, 2, 2, 1, 1 }, { 2, 4, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 4 }, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, { 1, 1, 1, 2, 4, 2 }, { 1, 2, 1, 1, 4, 2 }, { 1, 2, 1, 2, 4, 1 }, { 1, 1, 4, 2, 1, 2 }, { 1, 2, 4, 1, 1, 2 }, { 1, 2, 4, 2, 1, 1 }, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, { 4, 2, 1, 2, 1, 1 }, { 2, 1, 2, 1, 4, 1 }, { 2, 1, 4, 1, 2, 1 }, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, { 1, 3, 1, 1, 4, 1 }, { 1, 1, 4, 1, 1, 3 }, { 1, 1, 4, 3, 1, 1 }, { 4, 1, 1, 1, 1, 3 }, { 4, 1, 1, 3, 1, 1 }, { 1, 1, 3, 1, 4, 1 }, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, { 2, 1, 1, 4, 1, 2 }, { 2, 1, 1, 2, 1, 4 }, { 2, 1, 1, 2, 3, 2 }, { 2, 3, 3, 1, 1, 1, 2 } };
    }
    
    private static int decodeCode(final BitArray bitArray, final int[] array, int i) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i, array);
        float n = 0.25f;
        int n2 = -1;
        float patternMatchVariance;
        float n3;
        for (i = 0; i < Code128Reader.CODE_PATTERNS.length; ++i, n = n3) {
            patternMatchVariance = OneDReader.patternMatchVariance(array, Code128Reader.CODE_PATTERNS[i], 0.7f);
            n3 = n;
            if (patternMatchVariance < n) {
                n3 = patternMatchVariance;
                n2 = i;
            }
        }
        if (n2 >= 0) {
            return n2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int[] findStartPattern(final BitArray bitArray) throws NotFoundException {
        final int size = bitArray.getSize();
        int i = bitArray.getNextSet(0);
        int n = 0;
        final int[] array = new int[6];
        int n2 = i;
        boolean b = false;
        while (i < size) {
            int n3;
            if (bitArray.get(i) != b) {
                ++array[n];
                n3 = n;
            }
            else {
                if (n == 5) {
                    float n4 = 0.25f;
                    int n5 = -1;
                    float n6;
                    for (int j = 103; j <= 105; ++j, n4 = n6) {
                        final float patternMatchVariance = OneDReader.patternMatchVariance(array, Code128Reader.CODE_PATTERNS[j], 0.7f);
                        n6 = n4;
                        if (patternMatchVariance < n4) {
                            n6 = patternMatchVariance;
                            n5 = j;
                        }
                    }
                    if (n5 >= 0 && bitArray.isRange(Math.max(0, n2 - (i - n2) / 2), n2, false)) {
                        return new int[] { n2, i, n5 };
                    }
                    n2 += array[0] + array[1];
                    System.arraycopy(array, 2, array, 0, n - 1);
                    array[n] = (array[n - 1] = 0);
                    n3 = n - 1;
                }
                else {
                    n3 = n + 1;
                }
                array[n3] = 1;
                b = !b;
            }
            ++i;
            n = n3;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        final boolean b = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        final int[] startPattern = findStartPattern(bitArray);
        int n2 = startPattern[2];
        final ArrayList<Byte> list = new ArrayList<Byte>(20);
        list.add((byte)n2);
        int n3 = 0;
        switch (n2) {
            default: {
                throw FormatException.getFormatInstance();
            }
            case 103: {
                n3 = 101;
                break;
            }
            case 104: {
                n3 = 100;
                break;
            }
            case 105: {
                n3 = 99;
                break;
            }
        }
        int n4 = 0;
        int n5 = 0;
        final StringBuilder sb = new StringBuilder(20);
        int n6 = startPattern[0];
        int n7 = startPattern[1];
        final int[] array = new int[6];
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 1;
        int n12 = 0;
        int n13 = 0;
        int n14 = n3;
        while (true) {
            final int n15 = n5;
            if (n4 == 0) {
                final int n16 = 0;
                final int n17 = n9;
                final int decodeCode = decodeCode(bitArray, array, n7);
                list.add((byte)decodeCode);
                int n18 = n11;
                if (decodeCode != 106) {
                    n18 = 1;
                }
                int n19 = n2;
                int n20 = n10;
                if (decodeCode != 106) {
                    n20 = n10 + 1;
                    n19 = n2 + n20 * decodeCode;
                }
                final int n21 = n7;
                int i = 0;
                int n22 = n7;
                while (i < 6) {
                    n22 += array[i];
                    ++i;
                }
                switch (decodeCode) {
                    default: {
                        int n23 = 0;
                        int n24 = 0;
                        int n25 = 0;
                        int n26 = 0;
                        int n27 = 0;
                        Label_0368: {
                            switch (n14) {
                                default: {
                                    n23 = n12;
                                    n24 = n13;
                                    n25 = n16;
                                    n26 = n4;
                                    n27 = n14;
                                    break;
                                }
                                case 101: {
                                    if (decodeCode < 64) {
                                        if (n13 == n12) {
                                            sb.append((char)(decodeCode + 32));
                                        }
                                        else {
                                            sb.append((char)(decodeCode + 32 + 128));
                                        }
                                        n24 = 0;
                                        n27 = n14;
                                        n26 = n4;
                                        n25 = n16;
                                        n23 = n12;
                                        break;
                                    }
                                    if (decodeCode < 96) {
                                        if (n13 == n12) {
                                            sb.append((char)(decodeCode - 64));
                                        }
                                        else {
                                            sb.append((char)(decodeCode + 64));
                                        }
                                        n24 = 0;
                                        n27 = n14;
                                        n26 = n4;
                                        n25 = n16;
                                        n23 = n12;
                                        break;
                                    }
                                    int n28 = n18;
                                    if (decodeCode != 106) {
                                        n28 = 0;
                                    }
                                    n27 = n14;
                                    n26 = n4;
                                    n25 = n16;
                                    n18 = n28;
                                    n24 = n13;
                                    n23 = n12;
                                    switch (decodeCode) {
                                        case 106: {
                                            n26 = 1;
                                            n27 = n14;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 99: {
                                            n27 = 99;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 100: {
                                            n27 = 100;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 98: {
                                            n25 = 1;
                                            n27 = 100;
                                            n26 = n4;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                        }
                                        case 96:
                                        case 97: {
                                            break Label_0368;
                                        }
                                        default: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 102: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            if (!b) {
                                                break Label_0368;
                                            }
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n28;
                                                n24 = n13;
                                                n23 = n12;
                                                break Label_0368;
                                            }
                                            sb.append('\u001d');
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 101: {
                                            if (n12 == 0 && n13 != 0) {
                                                n23 = 1;
                                                n24 = 0;
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n28;
                                                break Label_0368;
                                            }
                                            if (n12 != 0 && n13 != 0) {
                                                n23 = 0;
                                                n24 = 0;
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n28;
                                                break Label_0368;
                                            }
                                            n24 = 1;
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n28;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                    }
                                    break;
                                }
                                case 100: {
                                    if (decodeCode < 96) {
                                        if (n13 == n12) {
                                            sb.append((char)(decodeCode + 32));
                                        }
                                        else {
                                            sb.append((char)(decodeCode + 32 + 128));
                                        }
                                        n24 = 0;
                                        n27 = n14;
                                        n26 = n4;
                                        n25 = n16;
                                        n23 = n12;
                                        break;
                                    }
                                    int n29 = n18;
                                    if (decodeCode != 106) {
                                        n29 = 0;
                                    }
                                    n27 = n14;
                                    n26 = n4;
                                    n25 = n16;
                                    n18 = n29;
                                    n24 = n13;
                                    n23 = n12;
                                    switch (decodeCode) {
                                        case 106: {
                                            n26 = 1;
                                            n27 = n14;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 99: {
                                            n27 = 99;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 101: {
                                            n27 = 101;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 98: {
                                            n25 = 1;
                                            n27 = 101;
                                            n26 = n4;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                        }
                                        case 96:
                                        case 97: {
                                            break Label_0368;
                                        }
                                        default: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 102: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            if (!b) {
                                                break Label_0368;
                                            }
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n29;
                                                n24 = n13;
                                                n23 = n12;
                                                break Label_0368;
                                            }
                                            sb.append('\u001d');
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 100: {
                                            if (n12 == 0 && n13 != 0) {
                                                n23 = 1;
                                                n24 = 0;
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n29;
                                                break Label_0368;
                                            }
                                            if (n12 != 0 && n13 != 0) {
                                                n23 = 0;
                                                n24 = 0;
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n29;
                                                break Label_0368;
                                            }
                                            n24 = 1;
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n29;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                    }
                                    break;
                                }
                                case 99: {
                                    if (decodeCode < 100) {
                                        if (decodeCode < 10) {
                                            sb.append('0');
                                        }
                                        sb.append(decodeCode);
                                        n27 = n14;
                                        n26 = n4;
                                        n25 = n16;
                                        n24 = n13;
                                        n23 = n12;
                                        break;
                                    }
                                    int n30 = n18;
                                    if (decodeCode != 106) {
                                        n30 = 0;
                                    }
                                    switch (decodeCode) {
                                        default: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 100: {
                                            n27 = 100;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 102: {
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            if (!b) {
                                                break Label_0368;
                                            }
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                n27 = n14;
                                                n26 = n4;
                                                n25 = n16;
                                                n18 = n30;
                                                n24 = n13;
                                                n23 = n12;
                                                break Label_0368;
                                            }
                                            sb.append('\u001d');
                                            n27 = n14;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 101: {
                                            n27 = 101;
                                            n26 = n4;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                        case 106: {
                                            n26 = 1;
                                            n27 = n14;
                                            n25 = n16;
                                            n18 = n30;
                                            n24 = n13;
                                            n23 = n12;
                                            break Label_0368;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        n2 = n19;
                        n9 = decodeCode;
                        n14 = n27;
                        n4 = n26;
                        n5 = n25;
                        n11 = n18;
                        n8 = n17;
                        n6 = n21;
                        n10 = n20;
                        n7 = n22;
                        n13 = n24;
                        n12 = n23;
                        if (n15 != 0) {
                            if (n27 == 101) {
                                n14 = 100;
                            }
                            else {
                                n14 = 101;
                            }
                            n2 = n19;
                            n9 = decodeCode;
                            n4 = n26;
                            n5 = n25;
                            n11 = n18;
                            n8 = n17;
                            n6 = n21;
                            n10 = n20;
                            n7 = n22;
                            n13 = n24;
                            n12 = n23;
                            continue;
                        }
                        continue;
                    }
                    case 103:
                    case 104:
                    case 105: {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            else {
                final int nextUnset = bitArray.getNextUnset(n7);
                if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), (nextUnset - n6) / 2 + nextUnset), false)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if ((n2 - n10 * n8) % 103 != n8) {
                    throw ChecksumException.getChecksumInstance();
                }
                final int length = sb.length();
                if (length == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (length > 0 && n11 != 0) {
                    if (n14 == 99) {
                        sb.delete(length - 2, length);
                    }
                    else {
                        sb.delete(length - 1, length);
                    }
                }
                final float n31 = (startPattern[1] + startPattern[0]) / 2.0f;
                final float n32 = (float)n6;
                final float n33 = (n7 - n6) / 2.0f;
                final int size = list.size();
                final byte[] array2 = new byte[size];
                for (int j = 0; j < size; ++j) {
                    array2[j] = (byte)list.get(j);
                }
                return new Result(sb.toString(), array2, new ResultPoint[] { new ResultPoint(n31, (float)n), new ResultPoint(n32 + n33, (float)n) }, BarcodeFormat.CODE_128);
            }
        }
    }
}
