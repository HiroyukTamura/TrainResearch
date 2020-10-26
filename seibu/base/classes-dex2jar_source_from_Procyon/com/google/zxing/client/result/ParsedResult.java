// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public abstract class ParsedResult
{
    private final ParsedResultType type;
    
    protected ParsedResult(final ParsedResultType type) {
        this.type = type;
    }
    
    public static void maybeAppend(final String str, final StringBuilder sb) {
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(str);
        }
    }
    
    public static void maybeAppend(final String[] array, final StringBuilder sb) {
        if (array != null) {
            for (int length = array.length, i = 0; i < length; ++i) {
                maybeAppend(array[i], sb);
            }
        }
    }
    
    public abstract String getDisplayResult();
    
    public final ParsedResultType getType() {
        return this.type;
    }
    
    @Override
    public final String toString() {
        return this.getDisplayResult();
    }
}
