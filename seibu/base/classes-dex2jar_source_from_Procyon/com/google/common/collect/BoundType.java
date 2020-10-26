// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum BoundType
{
    CLOSED {
        @Override
        BoundType flip() {
            return BoundType$2.OPEN;
        }
    }, 
    OPEN {
        @Override
        BoundType flip() {
            return BoundType$1.CLOSED;
        }
    };
    
    static BoundType forBoolean(final boolean b) {
        if (b) {
            return BoundType.CLOSED;
        }
        return BoundType.OPEN;
    }
    
    abstract BoundType flip();
}
