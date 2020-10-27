package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

public final class zzbzx {
    private Bundle extras;
    private zzack zzcyw;
    private List<zzye> zzczk = Collections.emptyList();
    private List<?> zzemd;
    private double zzemg;
    private float zzems;
    @Nullable
    private IObjectWrapper zzfke;
    private int zzfry;
    private zzxl zzfrz;
    private View zzfsa;
    private zzye zzfsb;
    private zzbek zzfsc;
    @Nullable
    private zzbek zzfsd;
    private View zzfse;
    private IObjectWrapper zzfsf;
    private zzacs zzfsg;
    private zzacs zzfsh;
    private String zzfsi;
    private SimpleArrayMap<String, zzace> zzfsj = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzfsk = new SimpleArrayMap<>();
    @Nullable
    private String zzfsl;

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzems = f;
    }

    private static zzbzu zza(zzxl zzxl, @Nullable zzame zzame) {
        if (zzxl == null) {
            return null;
        }
        return new zzbzu(zzxl, zzame);
    }

    public static zzbzx zza(zzaly zzaly) {
        try {
            zzbzu zza = zza(zzaly.getVideoController(), (zzame) null);
            zzack zzsb = zzaly.zzsb();
            String headline = zzaly.getHeadline();
            List<?> images = zzaly.getImages();
            String body = zzaly.getBody();
            Bundle extras2 = zzaly.getExtras();
            String callToAction = zzaly.getCallToAction();
            IObjectWrapper zzsc = zzaly.zzsc();
            String store = zzaly.getStore();
            String price = zzaly.getPrice();
            double starRating = zzaly.getStarRating();
            zzacs zzsa = zzaly.zzsa();
            zzbzx zzbzx = new zzbzx();
            zzbzx.zzfry = 2;
            zzbzx.zzfrz = zza;
            zzbzx.zzcyw = zzsb;
            zzbzx.zzfsa = (View) zzat(zzaly.zztr());
            zzbzx.zzn("headline", headline);
            zzbzx.zzemd = images;
            zzbzx.zzn("body", body);
            zzbzx.extras = extras2;
            zzbzx.zzn("call_to_action", callToAction);
            zzbzx.zzfse = (View) zzat(zzaly.zzts());
            zzbzx.zzfsf = zzsc;
            zzbzx.zzn("store", store);
            zzbzx.zzn(FirebaseAnalytics.Param.PRICE, price);
            zzbzx.zzemg = starRating;
            zzbzx.zzfsg = zzsa;
            return zzbzx;
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzbzx zza(zzamd zzamd) {
        try {
            zzbzu zza = zza(zzamd.getVideoController(), (zzame) null);
            zzack zzsb = zzamd.zzsb();
            String headline = zzamd.getHeadline();
            List<?> images = zzamd.getImages();
            String body = zzamd.getBody();
            Bundle extras2 = zzamd.getExtras();
            String callToAction = zzamd.getCallToAction();
            IObjectWrapper zzsc = zzamd.zzsc();
            String advertiser = zzamd.getAdvertiser();
            zzacs zzsd = zzamd.zzsd();
            zzbzx zzbzx = new zzbzx();
            zzbzx.zzfry = 1;
            zzbzx.zzfrz = zza;
            zzbzx.zzcyw = zzsb;
            zzbzx.zzfsa = (View) zzat(zzamd.zztr());
            zzbzx.zzn("headline", headline);
            zzbzx.zzemd = images;
            zzbzx.zzn("body", body);
            zzbzx.extras = extras2;
            zzbzx.zzn("call_to_action", callToAction);
            zzbzx.zzfse = (View) zzat(zzamd.zzts());
            zzbzx.zzfsf = zzsc;
            zzbzx.zzn("advertiser", advertiser);
            zzbzx.zzfsh = zzsd;
            return zzbzx;
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    private static zzbzx zza(zzxl zzxl, zzack zzack, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzacs zzacs, String str6, float f) {
        zzbzx zzbzx = new zzbzx();
        zzbzx.zzfry = 6;
        zzbzx.zzfrz = zzxl;
        zzbzx.zzcyw = zzack;
        zzbzx.zzfsa = view;
        String str7 = str;
        zzbzx.zzn("headline", str);
        zzbzx.zzemd = list;
        String str8 = str2;
        zzbzx.zzn("body", str2);
        zzbzx.extras = bundle;
        String str9 = str3;
        zzbzx.zzn("call_to_action", str3);
        zzbzx.zzfse = view2;
        zzbzx.zzfsf = iObjectWrapper;
        String str10 = str4;
        zzbzx.zzn("store", str4);
        String str11 = str5;
        zzbzx.zzn(FirebaseAnalytics.Param.PRICE, str5);
        zzbzx.zzemg = d;
        zzbzx.zzfsg = zzacs;
        zzbzx.zzn("advertiser", str6);
        zzbzx.setMediaContentAspectRatio(f);
        return zzbzx;
    }

    private static <T> T zzat(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzbzx zzb(zzaly zzaly) {
        try {
            return zza(zza(zzaly.getVideoController(), (zzame) null), zzaly.zzsb(), (View) zzat(zzaly.zztr()), zzaly.getHeadline(), zzaly.getImages(), zzaly.getBody(), zzaly.getExtras(), zzaly.getCallToAction(), (View) zzat(zzaly.zzts()), zzaly.zzsc(), zzaly.getStore(), zzaly.getPrice(), zzaly.getStarRating(), zzaly.zzsa(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzbzx zzb(zzamd zzamd) {
        try {
            return zza(zza(zzamd.getVideoController(), (zzame) null), zzamd.zzsb(), (View) zzat(zzamd.zztr()), zzamd.getHeadline(), zzamd.getImages(), zzamd.getBody(), zzamd.getExtras(), zzamd.getCallToAction(), (View) zzat(zzamd.zzts()), zzamd.zzsc(), (String) null, (String) null, -1.0d, zzamd.zzsd(), zzamd.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    public static zzbzx zzb(zzame zzame) {
        try {
            return zza(zza(zzame.getVideoController(), zzame), zzame.zzsb(), (View) zzat(zzame.zztr()), zzame.getHeadline(), zzame.getImages(), zzame.getBody(), zzame.getExtras(), zzame.getCallToAction(), (View) zzat(zzame.zzts()), zzame.zzsc(), zzame.getStore(), zzame.getPrice(), zzame.getStarRating(), zzame.zzsa(), zzame.getAdvertiser(), zzame.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    private final synchronized String zzga(String str) {
        return this.zzfsk.get(str);
    }

    public final synchronized void destroy() {
        if (this.zzfsc != null) {
            this.zzfsc.destroy();
            this.zzfsc = null;
        }
        if (this.zzfsd != null) {
            this.zzfsd.destroy();
            this.zzfsd = null;
        }
        this.zzfke = null;
        this.zzfsj.clear();
        this.zzfsk.clear();
        this.zzfrz = null;
        this.zzcyw = null;
        this.zzfsa = null;
        this.zzemd = null;
        this.extras = null;
        this.zzfse = null;
        this.zzfsf = null;
        this.zzfsg = null;
        this.zzfsh = null;
        this.zzfsi = null;
    }

    public final synchronized String getAdvertiser() {
        return zzga("advertiser");
    }

    public final synchronized String getBody() {
        return zzga("body");
    }

    public final synchronized String getCallToAction() {
        return zzga("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfsi;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzga("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzemd;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzems;
    }

    public final synchronized List<zzye> getMuteThisAdReasons() {
        return this.zzczk;
    }

    public final synchronized String getPrice() {
        return zzga(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.zzemg;
    }

    public final synchronized String getStore() {
        return zzga("store");
    }

    public final synchronized zzxl getVideoController() {
        return this.zzfrz;
    }

    public final synchronized void setImages(List<zzace> list) {
        this.zzemd = list;
    }

    public final synchronized void setStarRating(double d) {
        this.zzemg = d;
    }

    public final synchronized void zza(zzack zzack) {
        this.zzcyw = zzack;
    }

    public final synchronized void zza(zzacs zzacs) {
        this.zzfsg = zzacs;
    }

    public final synchronized void zza(@Nullable zzye zzye) {
        this.zzfsb = zzye;
    }

    public final synchronized void zza(String str, zzace zzace) {
        if (zzace == null) {
            this.zzfsj.remove(str);
        } else {
            this.zzfsj.put(str, zzace);
        }
    }

    public final synchronized void zzab(View view) {
        this.zzfse = view;
    }

    public final synchronized int zzakw() {
        return this.zzfry;
    }

    public final synchronized View zzakx() {
        return this.zzfsa;
    }

    @Nullable
    public final zzacs zzaky() {
        List<?> list = this.zzemd;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzemd.get(0);
            if (obj instanceof IBinder) {
                return zzacv.zzo((IBinder) obj);
            }
        }
        return null;
    }

    @Nullable
    public final synchronized zzye zzakz() {
        return this.zzfsb;
    }

    public final synchronized View zzala() {
        return this.zzfse;
    }

    public final synchronized zzbek zzalb() {
        return this.zzfsc;
    }

    @Nullable
    public final synchronized zzbek zzalc() {
        return this.zzfsd;
    }

    @Nullable
    public final synchronized IObjectWrapper zzald() {
        return this.zzfke;
    }

    public final synchronized SimpleArrayMap<String, zzace> zzale() {
        return this.zzfsj;
    }

    @Nullable
    public final synchronized String zzalf() {
        return this.zzfsl;
    }

    public final synchronized SimpleArrayMap<String, String> zzalg() {
        return this.zzfsk;
    }

    public final synchronized void zzas(IObjectWrapper iObjectWrapper) {
        this.zzfke = iObjectWrapper;
    }

    public final synchronized void zzb(zzacs zzacs) {
        this.zzfsh = zzacs;
    }

    public final synchronized void zzb(zzxl zzxl) {
        this.zzfrz = zzxl;
    }

    public final synchronized void zzdr(int i) {
        this.zzfry = i;
    }

    public final synchronized void zzfy(String str) {
        this.zzfsi = str;
    }

    public final synchronized void zzfz(@Nullable String str) {
        this.zzfsl = str;
    }

    public final synchronized void zzg(List<zzye> list) {
        this.zzczk = list;
    }

    public final synchronized void zzi(zzbek zzbek) {
        this.zzfsc = zzbek;
    }

    public final synchronized void zzj(zzbek zzbek) {
        this.zzfsd = zzbek;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzfsk.remove(str);
        } else {
            this.zzfsk.put(str, str2);
        }
    }

    public final synchronized zzacs zzsa() {
        return this.zzfsg;
    }

    public final synchronized zzack zzsb() {
        return this.zzcyw;
    }

    public final synchronized IObjectWrapper zzsc() {
        return this.zzfsf;
    }

    public final synchronized zzacs zzsd() {
        return this.zzfsh;
    }
}
