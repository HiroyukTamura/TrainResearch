// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible("unnecessary")
abstract class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V>
{
    ImmutableMapEntry(final ImmutableMapEntry<K, V> immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }
    
    ImmutableMapEntry(final K k, final V v) {
        super(k, v);
        CollectPreconditions.checkEntryNotNull(k, v);
    }
    
    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInKeyBucket();
    
    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInValueBucket();
    
    static final class TerminalEntry<K, V> extends ImmutableMapEntry<K, V>
    {
        TerminalEntry(final ImmutableMapEntry<K, V> immutableMapEntry) {
            super(immutableMapEntry);
        }
        
        TerminalEntry(final K k, final V v) {
            super(k, v);
        }
        
        @Nullable
        @Override
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return null;
        }
        
        @Nullable
        @Override
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }
    }
}
