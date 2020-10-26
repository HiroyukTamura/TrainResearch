// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;

final class zzcex implements Iterator<String>
{
    private Iterator<String> zzbpK;
    private /* synthetic */ zzcew zzbpL;
    
    zzcex(final zzcew zzbpL) {
        this.zzbpL = zzbpL;
        this.zzbpK = this.zzbpL.zzbpJ.keySet().iterator();
    }
    
    @Override
    public final boolean hasNext() {
        return this.zzbpK.hasNext();
    }
    
    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
