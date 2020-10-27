package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzdt;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzbmn;

    private zzp(zzl zzl) {
        this.zzbmn = zzl;
    }

    /* synthetic */ zzp(zzl zzl, zzk zzk) {
        this(zzl);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzdt unused = this.zzbmn.zzbmu = (zzdt) this.zzbmn.zzbmq.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzazw.zzd("", e);
        }
        return this.zzbmn.zzkl();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zzbmn.zzbms != null && str != null) {
            this.zzbmn.zzbms.loadUrl(str);
        }
    }
}
