package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

final class zzaqe extends zzavl {
    private final /* synthetic */ QueryInfoGenerationCallback zzdlk;

    zzaqe(zzaqc zzaqc, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdlk = queryInfoGenerationCallback;
    }

    public final void onError(String str) {
        this.zzdlk.onFailure(str);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzyh(str, bundle));
        zzvj.zzpz().put(queryInfo, str2);
        this.zzdlk.onSuccess(queryInfo);
    }

    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzyh(str, (Bundle) null));
        zzvj.zzpz().put(queryInfo, str2);
        this.zzdlk.onSuccess(queryInfo);
    }
}
