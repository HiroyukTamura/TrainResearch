package com.google.android.gms.internal.p008authapi;

import com.google.android.gms.auth.api.identity.SignInOptions;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzah */
final /* synthetic */ class zzah implements RemoteCall {
    private final zzaf zzbh;

    zzah(zzaf zzaf) {
        this.zzbh = zzaf;
    }

    public final void accept(Object obj, Object obj2) {
        zzaf zzaf = this.zzbh;
        ((zzad) ((zzak) obj).getService()).zzc((IStatusCallback) new zzai(zzaf, (TaskCompletionSource) obj2), ((SignInOptions) zzaf.getApiOptions()).zzf());
    }
}
