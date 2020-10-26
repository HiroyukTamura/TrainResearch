// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import java.util.Iterator;
import java.util.ArrayList;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;

public final class Code128Writer extends OneDimensionalCodeWriter
{
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = '\u00f1';
    private static final char ESCAPE_FNC_2 = '\u00f2';
    private static final char ESCAPE_FNC_3 = '\u00f3';
    private static final char ESCAPE_FNC_4 = '\u00f4';
    
    private static int chooseCode(final CharSequence charSequence, int char1, final int n) {
        final CType cType = findCType(charSequence, char1);
        if (cType != CType.ONE_DIGIT) {
            if (cType == CType.UNCODABLE) {
                if (char1 < charSequence.length()) {
                    char1 = charSequence.charAt(char1);
                    if (char1 < 32 || (n == 101 && char1 < 96)) {
                        return 101;
                    }
                }
            }
            else {
                if (n == 99) {
                    return 99;
                }
                if (n == 100) {
                    if (cType != CType.FNC_1) {
                        final CType cType2 = findCType(charSequence, char1 + 2);
                        if (cType2 != CType.UNCODABLE && cType2 != CType.ONE_DIGIT) {
                            if (cType2 == CType.FNC_1) {
                                if (findCType(charSequence, char1 + 3) == CType.TWO_DIGITS) {
                                    return 99;
                                }
                            }
                            else {
                                char1 += 4;
                                CType cType3;
                                while (true) {
                                    cType3 = findCType(charSequence, char1);
                                    if (cType3 != CType.TWO_DIGITS) {
                                        break;
                                    }
                                    char1 += 2;
                                }
                                if (cType3 != CType.ONE_DIGIT) {
                                    return 99;
                                }
                            }
                        }
                    }
                }
                else {
                    CType cType4;
                    if ((cType4 = cType) == CType.FNC_1) {
                        cType4 = findCType(charSequence, char1 + 1);
                    }
                    if (cType4 == CType.TWO_DIGITS) {
                        return 99;
                    }
                }
            }
        }
        return 100;
    }
    
    private static CType findCType(final CharSequence charSequence, int char1) {
        final int length = charSequence.length();
        if (char1 >= length) {
            return CType.UNCODABLE;
        }
        final char char2 = charSequence.charAt(char1);
        if (char2 == '\u00f1') {
            return CType.FNC_1;
        }
        if (char2 < '0' || char2 > '9') {
            return CType.UNCODABLE;
        }
        if (char1 + 1 >= length) {
            return CType.ONE_DIGIT;
        }
        char1 = charSequence.charAt(char1 + 1);
        if (char1 < 48 || char1 > 57) {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.CODE_128) {
            throw new IllegalArgumentException("Can only encode CODE_128, but got " + obj);
        }
        return super.encode(s, obj, n, n2, map);
    }
    
    @Override
    public boolean[] encode(final String s) {
        final int length = s.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            switch (char1) {
                default: {
                    if (char1 > '\u007f') {
                        throw new IllegalArgumentException("Bad character in input: " + char1);
                    }
                }
                case 241:
                case 242:
                case 243:
                case 244: {
                    ++i;
                    continue;
                }
            }
        }
        final ArrayList<int[]> list = new ArrayList<int[]>();
        int n = 0;
        int n2 = 1;
        int n3 = 0;
        int n6;
        for (int j = 0; j < length; j = n6) {
            int chooseCode = chooseCode(s, j, n3);
            int int1 = 0;
            if (chooseCode == n3) {
                int n4 = 0;
                Label_0252: {
                    switch (s.charAt(j)) {
                        default: {
                            switch (n3) {
                                default: {
                                    int1 = Integer.parseInt(s.substring(j, j + 2));
                                    n4 = j + 1;
                                    break Label_0252;
                                }
                                case 101: {
                                    final int n5 = int1 = s.charAt(j) - 32;
                                    n4 = j;
                                    if (n5 < 0) {
                                        int1 = n5 + 96;
                                        n4 = j;
                                        break Label_0252;
                                    }
                                    break Label_0252;
                                }
                                case 100: {
                                    int1 = s.charAt(j) - ' ';
                                    n4 = j;
                                    break Label_0252;
                                }
                            }
                            break;
                        }
                        case '\u00f1': {
                            int1 = 102;
                            n4 = j;
                            break;
                        }
                        case '\u00f2': {
                            int1 = 97;
                            n4 = j;
                            break;
                        }
                        case '\u00f3': {
                            int1 = 96;
                            n4 = j;
                            break;
                        }
                        case '\u00f4': {
                            if (n3 == 101) {
                                int1 = 101;
                                n4 = j;
                                break;
                            }
                            int1 = 100;
                            n4 = j;
                            break;
                        }
                    }
                }
                n6 = n4 + 1;
                chooseCode = n3;
            }
            else {
                if (n3 == 0) {
                    switch (chooseCode) {
                        default: {
                            int1 = 105;
                            break;
                        }
                        case 101: {
                            int1 = 103;
                            break;
                        }
                        case 100: {
                            int1 = 104;
                            break;
                        }
                    }
                }
                else {
                    int1 = chooseCode;
                }
                n6 = j;
            }
            list.add(Code128Reader.CODE_PATTERNS[int1]);
            final int n7 = n += int1 * n2;
            n3 = chooseCode;
            j = n6;
            if (n6 != 0) {
                ++n2;
                n = n7;
                n3 = chooseCode;
            }
        }
        list.add(Code128Reader.CODE_PATTERNS[n % 103]);
        list.add(Code128Reader.CODE_PATTERNS[106]);
        int n8 = 0;
        for (final int[] array : list) {
            final int length2 = array.length;
            int n9 = 0;
            int n10 = n8;
            while (true) {
                n8 = n10;
                if (n9 >= length2) {
                    break;
                }
                n10 += array[n9];
                ++n9;
            }
        }
        final boolean[] array2 = new boolean[n8];
        int n11 = 0;
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            n11 += OneDimensionalCodeWriter.appendPattern(array2, n11, iterator2.next(), true);
        }
        return array2;
    }
    
    private enum CType
    {
        FNC_1, 
        ONE_DIGIT, 
        TWO_DIGITS, 
        UNCODABLE;
    }
}
