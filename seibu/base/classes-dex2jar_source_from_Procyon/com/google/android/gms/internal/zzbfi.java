// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

final class zzbfi extends Drawable
{
    private static final zzbfi zzaGB;
    private static final zzbfj zzaGC;
    
    static {
        zzaGB = new zzbfi();
        zzaGC = new zzbfj(null);
    }
    
    private zzbfi() {
    }
    
    public final void draw(final Canvas canvas) {
    }
    
    public final Drawable$ConstantState getConstantState() {
        return zzbfi.zzaGC;
    }
    
    public final int getOpacity() {
        return -2;
    }
    
    public final void setAlpha(final int n) {
    }
    
    public final void setColorFilter(final ColorFilter colorFilter) {
    }
}
