package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

class zzm extends zzgh {

    /* renamed from: ID */
    private static final String f997ID = com.google.android.gms.internal.gtm.zza.ARBITRARY_PIXEL.toString();
    private static final String URL = zzb.URL.toString();
    private static final String zzadw = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzadx = zzb.UNREPEATABLE.toString();
    private static final String zzady;
    private static final Set<String> zzadz = new HashSet();
    private final zza zzaea;
    private final Context zzrm;

    public interface zza {
        zzbx zzgx();
    }

    static {
        String str = f997ID;
        zzady = C0681a.m313a(C0681a.m336b(str, 17), "gtm_", str, "_unrepeatable");
    }

    public zzm(Context context) {
        this(context, new zzn(context));
    }

    @VisibleForTesting
    private zzm(Context context, zza zza2) {
        super(f997ID, URL);
        this.zzaea = zza2;
        this.zzrm = context;
    }

    private final synchronized boolean zzak(String str) {
        if (zzadz.contains(str)) {
            return true;
        }
        if (!this.zzrm.getSharedPreferences(zzady, 0).contains(str)) {
            return false;
        }
        zzadz.add(str);
        return true;
    }

    public final void zzd(Map<String, zzl> map) {
        String zzc = map.get(zzadx) != null ? zzgj.zzc(map.get(zzadx)) : null;
        if (zzc == null || !zzak(zzc)) {
            Uri.Builder buildUpon = Uri.parse(zzgj.zzc(map.get(URL))).buildUpon();
            zzl zzl = map.get(zzadw);
            if (zzl != null) {
                Object zzh = zzgj.zzh(zzl);
                if (!(zzh instanceof List)) {
                    String valueOf = String.valueOf(buildUpon.build().toString());
                    zzdi.zzav(valueOf.length() != 0 ? "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(valueOf) : new String("ArbitraryPixel: additional params not a list: not sending partial hit: "));
                    return;
                }
                for (Object next : (List) zzh) {
                    if (!(next instanceof Map)) {
                        String valueOf2 = String.valueOf(buildUpon.build().toString());
                        zzdi.zzav(valueOf2.length() != 0 ? "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(valueOf2) : new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: "));
                        return;
                    }
                    for (Map.Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.zzaea.zzgx().zzay(uri);
            String valueOf3 = String.valueOf(uri);
            zzdi.zzab(valueOf3.length() != 0 ? "ArbitraryPixel: url = ".concat(valueOf3) : new String("ArbitraryPixel: url = "));
            if (zzc != null) {
                synchronized (zzm.class) {
                    zzadz.add(zzc);
                    zzft.zza(this.zzrm, zzady, zzc, "true");
                }
            }
        }
    }
}
