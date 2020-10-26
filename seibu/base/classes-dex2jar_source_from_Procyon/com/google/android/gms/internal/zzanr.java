// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Build$VERSION;

public final class zzanr
{
    public static int version() {
        try {
            return Integer.parseInt(Build$VERSION.SDK);
        }
        catch (NumberFormatException ex) {
            zzaob.zzf("Invalid version number", Build$VERSION.SDK);
            return 0;
        }
    }
}
