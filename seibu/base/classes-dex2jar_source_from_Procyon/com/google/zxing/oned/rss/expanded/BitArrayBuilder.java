// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

final class BitArrayBuilder
{
    private BitArrayBuilder() {
    }
    
    static BitArray buildBitArray(final List<ExpandedPair> list) {
        int n = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).getRightChar() == null) {
            --n;
        }
        final BitArray bitArray = new BitArray(n * 12);
        int n2 = 0;
        final int value = list.get(0).getRightChar().getValue();
        for (int i = 11; i >= 0; --i) {
            if ((1 << i & value) != 0x0) {
                bitArray.set(n2);
            }
            ++n2;
        }
        int n3;
        for (int j = 1; j < list.size(); ++j, n2 = n3) {
            final ExpandedPair expandedPair = list.get(j);
            final int value2 = expandedPair.getLeftChar().getValue();
            for (int k = 11; k >= 0; --k) {
                if ((1 << k & value2) != 0x0) {
                    bitArray.set(n2);
                }
                ++n2;
            }
            n3 = n2;
            if (expandedPair.getRightChar() != null) {
                final int value3 = expandedPair.getRightChar().getValue();
                int n4 = 11;
                while (true) {
                    n3 = n2;
                    if (n4 < 0) {
                        break;
                    }
                    if ((1 << n4 & value3) != 0x0) {
                        bitArray.set(n2);
                    }
                    ++n2;
                    --n4;
                }
            }
        }
        return bitArray;
    }
}
