// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import com.google.android.gms.internal.zzbfg;
import com.google.android.gms.internal.zzbfl;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzbe;
import android.net.Uri;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class zzc extends zza
{
    private WeakReference<ImageView> zzaGm;
    
    public zzc(final ImageView referent, final int n) {
        super(null, n);
        com.google.android.gms.common.internal.zzc.zzr(referent);
        this.zzaGm = new WeakReference<ImageView>(referent);
    }
    
    public zzc(final ImageView referent, final Uri uri) {
        super(uri, 0);
        com.google.android.gms.common.internal.zzc.zzr(referent);
        this.zzaGm = new WeakReference<ImageView>(referent);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof zzc)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final zzc zzc = (zzc)o;
        final ImageView imageView = this.zzaGm.get();
        final ImageView imageView2 = zzc.zzaGm.get();
        return imageView2 != null && imageView != null && zzbe.equal(imageView2, imageView);
    }
    
    @Override
    public final int hashCode() {
        return 0;
    }
    
    @Override
    protected final void zza(Drawable imageDrawable, final boolean b, final boolean b2, final boolean b3) {
        final Uri uri = null;
        final ImageView imageView = this.zzaGm.get();
        if (imageView != null) {
            boolean b4;
            if (!b2 && !b3) {
                b4 = true;
            }
            else {
                b4 = false;
            }
            if (b4 && imageView instanceof zzbfl) {
                final int zzqY = ((zzbfl)imageView).zzqY();
                if (this.zzaGh != 0 && zzqY == this.zzaGh) {
                    return;
                }
            }
            final boolean zzc = this.zzc(b, b2);
            if (zzc) {
                final Drawable drawable = imageView.getDrawable();
                Drawable zzqW;
                if (drawable != null) {
                    zzqW = drawable;
                    if (drawable instanceof zzbfg) {
                        zzqW = ((zzbfg)drawable).zzqW();
                    }
                }
                else {
                    zzqW = null;
                }
                imageDrawable = new zzbfg(zzqW, imageDrawable);
            }
            imageView.setImageDrawable(imageDrawable);
            if (imageView instanceof zzbfl) {
                final zzbfl zzbfl = (zzbfl)imageView;
                Uri uri2 = uri;
                if (b3) {
                    uri2 = this.zzaGf.uri;
                }
                zzbfl.zzo(uri2);
                int zzaGh;
                if (b4) {
                    zzaGh = this.zzaGh;
                }
                else {
                    zzaGh = 0;
                }
                zzbfl.zzax(zzaGh);
            }
            if (zzc) {
                ((zzbfg)imageDrawable).startTransition(250);
            }
        }
    }
}
