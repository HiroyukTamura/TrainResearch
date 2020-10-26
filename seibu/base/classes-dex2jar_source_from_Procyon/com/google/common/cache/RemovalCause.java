// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public enum RemovalCause
{
    COLLECTED {
        @Override
        boolean wasEvicted() {
            return true;
        }
    }, 
    EXPIRED {
        @Override
        boolean wasEvicted() {
            return true;
        }
    }, 
    EXPLICIT {
        @Override
        boolean wasEvicted() {
            return false;
        }
    }, 
    REPLACED {
        @Override
        boolean wasEvicted() {
            return false;
        }
    }, 
    SIZE {
        @Override
        boolean wasEvicted() {
            return true;
        }
    };
    
    abstract boolean wasEvicted();
}
