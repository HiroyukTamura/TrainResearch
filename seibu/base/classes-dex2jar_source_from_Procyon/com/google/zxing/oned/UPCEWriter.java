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

public final class UPCEWriter extends UPCEANWriter
{
    private static final int CODE_WIDTH = 51;
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.UPC_E) {
            throw new IllegalArgumentException("Can only encode UPC_E, but got " + obj);
        }
        return super.encode(s, obj, n, n2, map);
    }
    
    @Override
    public boolean[] encode(final String str) {
        final int length = str.length();
        String string = null;
        int digit = 0;
        while (true) {
            switch (length) {
                default: {
                    throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
                }
                case 7: {
                    try {
                        string = str + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str));
                        digit = Character.digit(string.charAt(0), 10);
                        if (digit != 0 && digit != 1) {
                            throw new IllegalArgumentException("Number system must be 0 or 1");
                        }
                        break;
                    }
                    catch (FormatException cause) {
                        throw new IllegalArgumentException(cause);
                    }
                }
                case 8: {
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
        final int n = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[digit][Character.digit(string.charAt(7), 10)];
        final boolean[] array = new boolean[51];
        int n2 = OneDimensionalCodeWriter.appendPattern(array, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        for (int i = 1; i <= 6; ++i) {
            int digit2 = Character.digit(string.charAt(i), 10);
            if ((n >> 6 - i & 0x1) == 0x1) {
                digit2 += 10;
            }
            n2 += OneDimensionalCodeWriter.appendPattern(array, n2, UPCEANReader.L_AND_G_PATTERNS[digit2], false);
        }
        OneDimensionalCodeWriter.appendPattern(array, n2, UPCEANReader.END_PATTERN, false);
        return array;
    }
}
