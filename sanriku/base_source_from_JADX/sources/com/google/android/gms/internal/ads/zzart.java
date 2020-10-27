package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

final class zzart implements Callable<zzars> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaru zzdqr;

    zzart(zzaru zzaru, Context context) {
        this.zzdqr = zzaru;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzars zzars;
        zzarw zzarw = (zzarw) this.zzdqr.zzdqs.get(this.val$context);
        if (zzarw != null) {
            if (!(zzabf.zzcvx.get().longValue() + zzarw.zzdqv < zzq.zzld().currentTimeMillis())) {
                zzars = new zzarr(this.val$context, zzarw.zzdqw).zzvb();
                this.zzdqr.zzdqs.put(this.val$context, new zzarw(this.zzdqr, zzars));
                return zzars;
            }
        }
        zzars = new zzarr(this.val$context).zzvb();
        this.zzdqr.zzdqs.put(this.val$context, new zzarw(this.zzdqr, zzars));
        return zzars;
    }
}
