// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;

public final class EAN13Writer extends UPCEANWriter
{
    private static final int CODE_WIDTH = 95;
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.EAN_13) {
            throw new IllegalArgumentException("Can only encode EAN_13, but got " + obj);
        }
        return super.encode(s, obj, n, n2, map);
    }
    
    @Override
    public boolean[] encode(final String str) {
        final int length = str.length();
        String string = null;
        boolean[] array = null;
        int n2 = 0;
        while (true) {
            switch (length) {
                default: {
                    throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
                }
                case 12: {
                    try {
                        string = str + UPCEANReader.getStandardUPCEANChecksum(str);
                        final int n = EAN13Reader.FIRST_DIGIT_ENCODINGS[Character.digit(string.charAt(0), 10)];
                        array = new boolean[95];
                        n2 = OneDimensionalCodeWriter.appendPattern(array, 0, UPCEANReader.START_END_PATTERN, true) + 0;
                        for (int i = 1; i <= 6; ++i) {
                            int digit = Character.digit(string.charAt(i), 10);
                            if ((n >> 6 - i & 0x1) == 0x1) {
                                digit += 10;
                            }
                            n2 += OneDimensionalCodeWriter.appendPattern(array, n2, UPCEANReader.L_AND_G_PATTERNS[digit], false);
                        }
                        break;
                    }
                    catch (FormatException cause) {
                        throw new IllegalArgumentException(cause);
                    }
                }
                case 13: {
                    string = str;
                    try {
                        if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                        continue;
                    }
                    catch (FormatException ex) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                    break;
                }
            }
            break;
        }
        int n3 = n2 + OneDimensionalCodeWriter.appendPattern(array, n2, UPCEANReader.MIDDLE_PATTERN, false);
        for (int j = 7; j <= 12; ++j) {
            n3 += OneDimensionalCodeWriter.appendPattern(array, n3, UPCEANReader.L_PATTERNS[Character.digit(string.charAt(j), 10)], true);
        }
        OneDimensionalCodeWriter.appendPattern(array, n3, UPCEANReader.START_END_PATTERN, true);
        return array;
    }
}
