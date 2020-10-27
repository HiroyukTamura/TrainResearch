package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaqy;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzaxa;
import java.util.List;
import java.util.Map;

public final class zzc {
    private boolean zzblu;
    private zzaun zzblv;
    private zzaqy zzblw = null;
    private final Context zzvf;

    public zzc(Context context, zzaun zzaun, zzaqy zzaqy) {
        this.zzvf = context;
        this.zzblv = zzaun;
        if (0 == 0) {
            this.zzblw = new zzaqy();
        }
    }

    private final boolean zzjw() {
        zzaun zzaun = this.zzblv;
        return (zzaun != null && zzaun.zzvf().zzdsi) || this.zzblw.zzdox;
    }

    public final void recordClick() {
        this.zzblu = true;
    }

    public final void zzbm(@Nullable String str) {
        List<String> list;
        if (zzjw()) {
            if (str == null) {
                str = "";
            }
            zzaun zzaun = this.zzblv;
            if (zzaun != null) {
                zzaun.zza(str, (Map<String, String>) null, 3);
                return;
            }
            zzaqy zzaqy = this.zzblw;
            if (zzaqy.zzdox && (list = zzaqy.zzdoy) != null) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzq.zzkw();
                        zzaxa.zzb(this.zzvf, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzjx() {
        return !zzjw() || this.zzblu;
    }
}
