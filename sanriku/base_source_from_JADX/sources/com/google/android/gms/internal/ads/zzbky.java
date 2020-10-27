package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbky implements zzpz {
    private final Clock zzbnt;
    private boolean zzbtg = false;
    private zzbek zzdce;
    private final zzbkn zzfhf;
    private final Executor zzfhi;
    private zzbkr zzfhk = new zzbkr();
    private boolean zzfid = false;

    public zzbky(Executor executor, zzbkn zzbkn, Clock clock) {
        this.zzfhi = executor;
        this.zzfhf = zzbkn;
        this.zzbnt = clock;
    }

    private final void zzagp() {
        try {
            JSONObject zza = this.zzfhf.zzj(this.zzfhk);
            if (this.zzdce != null) {
                this.zzfhi.execute(new zzblb(this, zza));
            }
        } catch (JSONException e) {
            zzawr.zza("Failed to call video active view js", e);
        }
    }

    public final void disable() {
        this.zzbtg = false;
    }

    public final void enable() {
        this.zzbtg = true;
        zzagp();
    }

    public final void zza(zzqa zzqa) {
        this.zzfhk.zzbot = this.zzfid ? false : zzqa.zzbot;
        this.zzfhk.timestamp = this.zzbnt.elapsedRealtime();
        this.zzfhk.zzfhu = zzqa;
        if (this.zzbtg) {
            zzagp();
        }
    }

    public final void zzbf(boolean z) {
        this.zzfid = z;
    }

    public final void zzg(zzbek zzbek) {
        this.zzdce = zzbek;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdce.zza("AFMA_updateActiveView", jSONObject);
    }
}
