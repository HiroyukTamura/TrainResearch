// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import android.database.ContentObserver;

final class hj extends ContentObserver
{
    hj(final Handler handler) {
        super((Handler)null);
    }
    
    public final void onChange(final boolean b) {
        hi.zzbUd.set(true);
    }
}
