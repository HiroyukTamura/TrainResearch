package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

public final class zzayb extends zzak {
    private final Context zzvf;

    private zzayb(Context context, zzah zzah) {
        super(zzah);
        this.zzvf = context;
    }

    public static zzu zzbi(Context context) {
        zzu zzu = new zzu(new zzal(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayb(context, new zzat()));
        zzu.start();
        return zzu;
    }

    public final zzo zzc(zzq<?> zzq) throws zzae {
        if (zzq.zzh() && zzq.getMethod() == 0) {
            if (Pattern.matches((String) zzvj.zzpv().zzd(zzzz.zzcqb), zzq.getUrl())) {
                zzvj.zzpr();
                if (zzazm.zzd(this.zzvf, 13400000)) {
                    zzo zzc = new zzagu(this.zzvf).zzc(zzq);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzq.getUrl());
                        zzawr.zzeg(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzq.getUrl());
                    zzawr.zzeg(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzq);
    }
}
