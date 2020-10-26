// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import android.net.Uri;

final class zzb
{
    public final Uri uri;
    
    public zzb(final Uri uri) {
        this.uri = uri;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof zzb && (this == o || zzbe.equal(((zzb)o).uri, this.uri));
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.uri });
    }
}
