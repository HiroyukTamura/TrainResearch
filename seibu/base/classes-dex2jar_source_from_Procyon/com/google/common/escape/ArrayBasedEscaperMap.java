// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import com.google.common.annotations.VisibleForTesting;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.lang.reflect.Array;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap
{
    private static final char[][] EMPTY_REPLACEMENT_ARRAY;
    private final char[][] replacementArray;
    
    static {
        EMPTY_REPLACEMENT_ARRAY = (char[][])Array.newInstance(Character.TYPE, 0, 0);
    }
    
    private ArrayBasedEscaperMap(final char[][] replacementArray) {
        this.replacementArray = replacementArray;
    }
    
    public static ArrayBasedEscaperMap create(final Map<Character, String> map) {
        return new ArrayBasedEscaperMap(createReplacementArray(map));
    }
    
    @VisibleForTesting
    static char[][] createReplacementArray(final Map<Character, String> map) {
        Preconditions.checkNotNull(map);
        char[][] empty_REPLACEMENT_ARRAY;
        if (map.isEmpty()) {
            empty_REPLACEMENT_ARRAY = ArrayBasedEscaperMap.EMPTY_REPLACEMENT_ARRAY;
        }
        else {
            final char[][] array = new char[(char)Collections.max((Collection<? extends Character>)map.keySet()) + '\u0001'][];
            final Iterator<Character> iterator = map.keySet().iterator();
            while (true) {
                empty_REPLACEMENT_ARRAY = array;
                if (!iterator.hasNext()) {
                    break;
                }
                final char charValue = iterator.next();
                array[charValue] = map.get(charValue).toCharArray();
            }
        }
        return empty_REPLACEMENT_ARRAY;
    }
    
    char[][] getReplacementArray() {
        return this.replacementArray;
    }
}
