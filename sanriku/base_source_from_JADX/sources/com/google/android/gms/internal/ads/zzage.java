package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbft;
import java.net.URISyntaxException;
import java.util.Map;

public final class zzage<T extends zzbfj & zzbfm & zzbfq & zzbfr & zzbft> implements zzaga<T> {
    private final zzc zzdaq;
    private final zzaor zzdar;

    public zzage(zzc zzc, zzaor zzaor) {
        this.zzdaq = zzc;
        this.zzdar = zzaor;
    }

    @VisibleForTesting
    static Uri zza(Context context, zzdt zzdt, Uri uri, View view, @Nullable Activity activity) {
        if (zzdt == null) {
            return uri;
        }
        try {
            return zzdt.zzc(uri) ? zzdt.zza(uri, context, view, activity) : uri;
        } catch (zzdw unused) {
            return uri;
        } catch (Exception e) {
            zzq.zzla().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    private final void zzab(boolean z) {
        zzaor zzaor = this.zzdar;
        if (zzaor != null) {
            zzaor.zzac(z);
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzq.zzky();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzq.zzky();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzq.zzky().zzxk();
        } else {
            return -1;
        }
    }

    @VisibleForTesting
    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzazw.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfj zzbfj = (zzbfj) obj;
        String zzc = zzavj.zzc((String) map.get("u"), zzbfj.getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzazw.zzfc("Action missing from an open GMSG.");
            return;
        }
        zzc zzc2 = this.zzdaq;
        if (zzc2 != null && !zzc2.zzjx()) {
            this.zzdaq.zzbm(zzc);
        } else if ("expand".equalsIgnoreCase(str)) {
            if (((zzbfm) zzbfj).zzabo()) {
                zzazw.zzfc("Cannot expand WebView that is already expanded.");
                return;
            }
            zzab(false);
            ((zzbfq) zzbfj).zzb(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            zzab(false);
            zzbfq zzbfq = (zzbfq) zzbfj;
            if (zzc != null) {
                zzbfq.zza(zzc(map), zzd(map), zzc);
            } else {
                zzbfq.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzab(true);
            String str2 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    intent = Intent.parseUri(str2, 0);
                } catch (URISyntaxException e) {
                    String valueOf = String.valueOf(str2);
                    zzazw.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                if (!Uri.EMPTY.equals(data)) {
                    intent.setData(zze(zza(zzbfj.getContext(), ((zzbfr) zzbfj).zzabm(), data, ((zzbft) zzbfj).getView(), zzbfj.zzzh())));
                }
            }
            if (intent != null) {
                ((zzbfq) zzbfj).zza(new zzd(intent));
                return;
            }
            if (!TextUtils.isEmpty(zzc)) {
                zzc = zze(zza(zzbfj.getContext(), ((zzbfr) zzbfj).zzabm(), Uri.parse(zzc), ((zzbft) zzbfj).getView(), zzbfj.zzzh())).toString();
            }
            ((zzbfq) zzbfj).zza(new zzd((String) map.get("i"), zzc, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        } else {
            zzab(true);
            if (TextUtils.isEmpty(zzc)) {
                zzazw.zzfc("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbfq) zzbfj).zza(new zzd(new zzagh(zzbfj.getContext(), ((zzbfr) zzbfj).zzabm(), ((zzbft) zzbfj).getView()).zze(map)));
            } catch (ActivityNotFoundException e2) {
                zzazw.zzfc(e2.getMessage());
            }
        }
    }
}
