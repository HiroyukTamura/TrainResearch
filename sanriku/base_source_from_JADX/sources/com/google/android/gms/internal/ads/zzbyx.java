package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbyx implements zzcaf {
    private final zzazz zzbmo;
    private final Clock zzbnt;
    private final zzdt zzejl;
    private final zzdld zzfgl;
    private final zzcae zzfjb;
    private final zzdgo zzfkd;
    private final zzdhe zzfll;
    private final JSONObject zzfpz;
    private final zzcdt zzfqa;
    private final zzbzx zzfqb;
    /* access modifiers changed from: private */
    public final zzbro zzfqc;
    /* access modifiers changed from: private */
    public final zzbqw zzfqd;
    private final zzbkp zzfqe;
    private final zzcaw zzfqf;
    private final zzbvs zzfqg;
    private boolean zzfqh = false;
    private boolean zzfqi;
    private boolean zzfqj = false;
    private boolean zzfqk = false;
    private Point zzfql = new Point();
    private Point zzfqm = new Point();
    private long zzfqn = 0;
    private long zzfqo = 0;
    private zzws zzfqp;
    private final Context zzvf;

    public zzbyx(Context context, zzcae zzcae, JSONObject jSONObject, zzcdt zzcdt, zzbzx zzbzx, zzdt zzdt, zzbro zzbro, zzbqw zzbqw, zzdgo zzdgo, zzazz zzazz, zzdhe zzdhe, zzbkp zzbkp, zzcaw zzcaw, Clock clock, zzbvs zzbvs, zzdld zzdld) {
        this.zzvf = context;
        this.zzfjb = zzcae;
        this.zzfpz = jSONObject;
        this.zzfqa = zzcdt;
        this.zzfqb = zzbzx;
        this.zzejl = zzdt;
        this.zzfqc = zzbro;
        this.zzfqd = zzbqw;
        this.zzfkd = zzdgo;
        this.zzbmo = zzazz;
        this.zzfll = zzdhe;
        this.zzfqe = zzbkp;
        this.zzfqf = zzcaw;
        this.zzbnt = clock;
        this.zzfqg = zzbvs;
        this.zzfgl = zzdld;
    }

    private final void zza(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzfpz);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzfjb.zzgc(this.zzfqb.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzfqb.zzakw());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfll.zzdhc != null && this.zzfll.zzdhc.zzblc);
            jSONObject8.put("custom_mute_enabled", !this.zzfqb.getMuteThisAdReasons().isEmpty() && this.zzfqb.zzakz() != null);
            if (this.zzfqf.zzamf() != null && this.zzfpz.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbnt.currentTimeMillis());
            if (this.zzfqk && zzakk()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzfjb.zzgc(this.zzfqb.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            jSONObject8.put("click_signals", zzw(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbnt.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzfqn);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzfqo);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbaf.zza(this.zzfqa.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzazw.zzc("Unable to create click JSON.", e);
        }
    }

    private final boolean zza(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzfpz);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcol)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            this.zzfqa.zza("/logScionEvent", (zzaga<Object>) new zzbyz(this));
            this.zzfqa.zza("/nativeImpression", (zzaga<Object>) new zzbyy(this));
            zzbaf.zza(this.zzfqa.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z = this.zzfqh;
            if (z || this.zzfkd.zzgtw == null) {
                return true;
            }
            this.zzfqh = z | zzq.zzlg().zzb(this.zzvf, this.zzbmo.zzbnd, this.zzfkd.zzgtw.toString(), this.zzfll.zzgux);
            return true;
        } catch (JSONException e) {
            zzazw.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzakk() {
        return this.zzfpz.optBoolean("allow_custom_click_gesture", false);
    }

    @Nullable
    private final String zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzakw = this.zzfqb.zzakw();
        if (zzakw == 1) {
            return "1099";
        }
        if (zzakw == 2) {
            return "2099";
        }
        if (zzakw != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzfw(String str) {
        JSONObject optJSONObject = this.zzfpz.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    private final String zzw(View view) {
        try {
            JSONObject optJSONObject = this.zzfpz.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzejl.zzcb().zza(this.zzvf, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzazw.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final String zzx(View view) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcol)).booleanValue()) {
            return null;
        }
        try {
            return this.zzejl.zzcb().zza(this.zzvf, view, (Activity) null);
        } catch (Exception unused) {
            zzazw.zzfa("Exception getting data.");
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfpz.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfqf.cancelUnconfirmedClick();
        }
    }

    public final void destroy() {
        this.zzfqa.destroy();
    }

    public final boolean isCustomClickGestureEnabled() {
        return zzakk();
    }

    public final void setClickConfirmingView(View view) {
        if (!this.zzfpz.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzazw.zzfc("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcaw zzcaw = this.zzfqf;
        if (view != null) {
            view.setOnClickListener(zzcaw);
            view.setClickable(true);
            zzcaw.zzftz = new WeakReference<>(view);
        }
    }

    public final void zza(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.zzfql = zzaza.zza(motionEvent, view2);
        long currentTimeMillis = this.zzbnt.currentTimeMillis();
        this.zzfqo = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfqn = currentTimeMillis;
            this.zzfqm = this.zzfql;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzfql;
        obtain.setLocation((float) point.x, (float) point.y);
        this.zzejl.zza(obtain);
        obtain.recycle();
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zza = zzaza.zza(this.zzvf, map, map2, view2);
        JSONObject zza2 = zzaza.zza(this.zzvf, view2);
        JSONObject zzs = zzaza.zzs(view2);
        JSONObject zzb = zzaza.zzb(this.zzvf, view2);
        View view4 = view;
        String zzb2 = zzb(view, map);
        zza(view, zza2, zza, zzs, zzb, zzb2, zzaza.zza(zzb2, this.zzvf, this.zzfqm, this.zzfql), (JSONObject) null, z, false);
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzfql = new Point();
        this.zzfqm = new Point();
        this.zzfqg.zzv(view);
        this.zzfqi = false;
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        zza(zzaza.zza(this.zzvf, view), zzaza.zza(this.zzvf, map, map2, view), zzaza.zzs(view), zzaza.zzb(this.zzvf, view), zzx(view), (JSONObject) null);
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzfql = new Point();
        this.zzfqm = new Point();
        if (!this.zzfqi) {
            this.zzfqg.zzu(view);
            this.zzfqi = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfqe.zzo(this);
        boolean zzdb = zzaza.zzdb(this.zzbmo.zzdzo);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzdb) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzdb) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.zzfqk) {
            zzazw.zzed("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzakk()) {
            zzazw.zzed("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zza = zzaza.zza(this.zzvf, map, map2, view);
            JSONObject zza2 = zzaza.zza(this.zzvf, view);
            JSONObject zzs = zzaza.zzs(view);
            JSONObject zzb = zzaza.zzb(this.zzvf, view);
            String zzb2 = zzb((View) null, map);
            zza(view, zza2, zza, zzs, zzb, zzb2, zzaza.zza(zzb2, this.zzvf, this.zzfqm, this.zzfql), (JSONObject) null, z, true);
        }
    }

    public final void zza(zzaer zzaer) {
        if (!this.zzfpz.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzazw.zzfc("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzfqf.zza(zzaer);
        }
    }

    public final void zza(zzws zzws) {
        this.zzfqp = zzws;
    }

    public final void zza(@Nullable zzww zzww) {
        try {
            if (!this.zzfqj) {
                if (zzww != null || this.zzfqb.zzakz() == null) {
                    this.zzfqj = true;
                    this.zzfgl.zzeq(zzww.zzqe());
                    zzakm();
                    return;
                }
                this.zzfqj = true;
                this.zzfgl.zzeq(this.zzfqb.zzakz().zzqe());
                zzakm();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzakl() {
        zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null);
    }

    public final void zzakm() {
        try {
            if (this.zzfqp != null) {
                this.zzfqp.onAdMuted();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzakn() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzfpz);
            zzbaf.zza(this.zzfqa.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzazw.zzc("", e);
        }
    }

    public final void zzfx(String str) {
        zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzazw.zzed("Click data is null. No click is reported.");
        } else if (!zzfw("click_reporting")) {
            zzazw.zzfa("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzq.zzkw().zza(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zzh(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzazw.zzed("Touch event data is null. No touch event is reported.");
        } else if (!zzfw("touch_reporting")) {
            zzazw.zzfa("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzejl.zzcb().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final boolean zzi(Bundle bundle) {
        if (!zzfw("impression_reporting")) {
            zzazw.zzfa("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzq.zzkw().zza(bundle, (JSONObject) null));
    }

    public final void zzsk() {
        this.zzfqk = true;
    }
}
