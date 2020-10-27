package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class zzcqd<AdT> implements zzcnj<AdT> {
    private static Bundle zzn(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    /* access modifiers changed from: protected */
    public abstract zzdri<AdT> zza(zzdhe zzdhe, Bundle bundle);

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        return !TextUtils.isEmpty(zzdgo.zzgtu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public final zzdri<AdT> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzdgo zzdgo2 = zzdgo;
        String optString = zzdgo2.zzgtu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdhe zzdhe = zzdha.zzgur.zzfll;
        zzdhg zzgr = new zzdhg().zzc(zzdhe).zzgr(optString);
        Bundle zzn = zzn(zzdhe.zzguw.zzcen);
        Bundle zzn2 = zzn(zzn.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzn2.putInt("gw", 1);
        String optString2 = zzdgo2.zzgtu.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzn2.putString("mad_hac", optString2);
        }
        String optString3 = zzdgo2.zzgtu.optString("adJson", (String) null);
        if (optString3 != null) {
            zzn2.putString("_ad", optString3);
        }
        zzn2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdgo2.zzgtx.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdgo2.zzgtx.optString(next, (String) null);
            if (next != null) {
                zzn2.putString(next, optString4);
            }
        }
        zzn.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzn2);
        zzuj zzuj = zzdhe.zzguw;
        zzuj zzuj2 = r5;
        zzuj zzuj3 = new zzuj(zzuj.versionCode, zzuj.zzceg, zzn2, zzuj.zzceh, zzuj.zzcei, zzuj.zzcej, zzuj.zzacq, zzuj.zzbli, zzuj.zzcek, zzuj.zzcel, zzuj.zzmp, zzuj.zzcem, zzn, zzuj.zzceo, zzuj.zzcep, zzuj.zzceq, zzuj.zzcer, zzuj.zzces, zzuj.zzceu, zzuj.zzacr, zzuj.zzacs, zzuj.zzcet);
        zzdhe zzasc = zzgr.zzh(zzuj2).zzasc();
        Bundle bundle = new Bundle();
        zzdha zzdha2 = zzdha;
        zzdgq zzdgq = zzdha2.zzgus.zzgup;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzdgq.zzdex));
        bundle2.putInt("refresh_interval", zzdgq.zzgug);
        bundle2.putString("gws_query_id", zzdgq.zzdoh);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdha2.zzgur.zzfll.zzgux;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzdgo zzdgo3 = zzdgo;
        bundle3.putString("allocation_id", zzdgo3.zzdfq);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzdgo3.zzdeu));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzdgo3.zzdev));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzdgo3.zzdnv));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzdgo3.zzgtp));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzdgo3.zzdoj));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzdgo3.zzdok));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzdgo3.zzgto));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdgo3.zzdgb);
        bundle3.putString("valid_from_timestamp", zzdgo3.zzdgc);
        bundle3.putBoolean("is_closable_area_disabled", zzdgo3.zzbmh);
        if (zzdgo3.zzdoi != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdgo3.zzdoi.zzdqy);
            bundle4.putString("rb_type", zzdgo3.zzdoi.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzasc, bundle);
    }
}
