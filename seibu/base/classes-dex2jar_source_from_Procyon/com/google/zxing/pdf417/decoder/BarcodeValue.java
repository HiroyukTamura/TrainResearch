// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import java.util.Iterator;
import java.util.Collection;
import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class BarcodeValue
{
    private final Map<Integer, Integer> values;
    
    BarcodeValue() {
        this.values = new HashMap<Integer, Integer>();
    }
    
    Integer getConfidence(final int i) {
        return this.values.get(i);
    }
    
    int[] getValue() {
        int intValue = -1;
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (final Map.Entry<Integer, Integer> entry : this.values.entrySet()) {
            if (entry.getValue() > intValue) {
                intValue = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }
            else {
                if (entry.getValue() != intValue) {
                    continue;
                }
                list.add(entry.getKey());
            }
        }
        return PDF417Common.toIntArray(list);
    }
    
    void setValue(final int n) {
        Integer value;
        if ((value = this.values.get(n)) == null) {
            value = 0;
        }
        this.values.put(n, value + 1);
    }
}
