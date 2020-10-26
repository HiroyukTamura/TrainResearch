// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import com.google.android.gms.internal.zzbfm;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import com.google.android.gms.common.internal.zzc;
import android.graphics.Bitmap;
import android.content.Context;
import android.net.Uri;

public abstract class zza
{
    final zzb zzaGf;
    private int zzaGg;
    protected int zzaGh;
    private boolean zzaGi;
    private boolean zzaGj;
    private boolean zzaGk;
    private boolean zzaGl;
    
    public zza(final Uri uri, final int zzaGh) {
        this.zzaGg = 0;
        this.zzaGh = 0;
        this.zzaGi = false;
        this.zzaGj = true;
        this.zzaGk = false;
        this.zzaGl = true;
        this.zzaGf = new zzb(uri);
        this.zzaGh = zzaGh;
    }
    
    final void zza(final Context context, final Bitmap bitmap, final boolean b) {
        zzc.zzr(bitmap);
        this.zza((Drawable)new BitmapDrawable(context.getResources(), bitmap), b, false, true);
    }
    
    final void zza(final Context context, final zzbfm zzbfm) {
        if (this.zzaGl) {
            this.zza(null, false, true, false);
        }
    }
    
    final void zza(final Context context, final zzbfm zzbfm, final boolean b) {
        Drawable drawable = null;
        if (this.zzaGh != 0) {
            drawable = context.getResources().getDrawable(this.zzaGh);
        }
        this.zza(drawable, b, false, false);
    }
    
    protected abstract void zza(final Drawable p0, final boolean p1, final boolean p2, final boolean p3);
    
    protected final boolean zzc(final boolean b, final boolean b2) {
        return this.zzaGj && !b2 && !b;
    }
}
