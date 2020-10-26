// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.auth.api.signin.internal.zzy;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ResultCallback;

final class zzbct implements ResultCallback<Status>
{
    private /* synthetic */ zzbcp zzaDN;
    private /* synthetic */ zzben zzaDP;
    private /* synthetic */ boolean zzaDQ;
    private /* synthetic */ GoogleApiClient zzaqW;
    
    zzbct(final zzbcp zzaDN, final zzben zzaDP, final boolean zzaDQ, final GoogleApiClient zzaqW) {
        this.zzaDN = zzaDN;
        this.zzaDP = zzaDP;
        this.zzaDQ = zzaDQ;
        this.zzaqW = zzaqW;
    }
}
