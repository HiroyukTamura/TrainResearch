// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.view.View$OnClickListener;

final class zzf implements View$OnClickListener
{
    private /* synthetic */ Intent zzaSA;
    private /* synthetic */ Context zztF;
    
    zzf(final Context zztF, final Intent zzaSA) {
        this.zztF = zztF;
        this.zzaSA = zzaSA;
    }
    
    public final void onClick(final View view) {
        try {
            this.zztF.startActivity(this.zzaSA);
        }
        catch (ActivityNotFoundException ex) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", (Throwable)ex);
        }
    }
}
