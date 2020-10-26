// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzc;
import android.net.Uri;
import java.lang.ref.WeakReference;

public final class zzd extends zza
{
    private WeakReference<ImageManager.OnImageLoadedListener> zzaGn;
    
    public zzd(final ImageManager.OnImageLoadedListener referent, final Uri uri) {
        super(uri, 0);
        zzc.zzr(referent);
        this.zzaGn = new WeakReference<ImageManager.OnImageLoadedListener>(referent);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof zzd)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final zzd zzd = (zzd)o;
        final ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzaGn.get();
        final ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzd.zzaGn.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && zzbe.equal(onImageLoadedListener2, onImageLoadedListener) && zzbe.equal(zzd.zzaGf, this.zzaGf);
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaGf });
    }
    
    @Override
    protected final void zza(final Drawable drawable, final boolean b, final boolean b2, final boolean b3) {
        if (!b2) {
            final ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzaGn.get();
            if (onImageLoadedListener != null) {
                onImageLoadedListener.onImageLoaded(this.zzaGf.uri, drawable, b3);
            }
        }
    }
}
