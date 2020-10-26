// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.R;
import android.content.Context;
import android.content.res.Resources;

public final class zzby
{
    private final Resources zzaIw;
    private final String zzaIx;
    
    public zzby(final Context context) {
        zzbo.zzu(context);
        this.zzaIw = context.getResources();
        this.zzaIx = this.zzaIw.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }
    
    public final String getString(final String s) {
        final int identifier = this.zzaIw.getIdentifier(s, "string", this.zzaIx);
        if (identifier == 0) {
            return null;
        }
        return this.zzaIw.getString(identifier);
    }
}
