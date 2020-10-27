package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcca {
    private final Executor executor;
    private final zzazz zzbmo;
    private final zzaci zzdhc;
    private final zzst zzeht;
    private final zzdt zzejl;
    private final ScheduledExecutorService zzfky;
    private final zzcbv zzfve;
    private final zza zzfvf;
    private final zzccr zzfvg;
    private final Context zzvf;

    public zzcca(Context context, zzcbv zzcbv, zzdt zzdt, zzazz zzazz, zza zza, zzst zzst, Executor executor2, zzdhe zzdhe, zzccr zzccr, ScheduledExecutorService scheduledExecutorService) {
        this.zzvf = context;
        this.zzfve = zzcbv;
        this.zzejl = zzdt;
        this.zzbmo = zzazz;
        this.zzfvf = zza;
        this.zzeht = zzst;
        this.executor = executor2;
        this.zzdhc = zzdhe.zzdhc;
        this.zzfvg = zzccr;
        this.zzfky = scheduledExecutorService;
    }

    private static <T> zzdri<T> zza(zzdri<T> zzdri, T t) {
        return zzdqw.zzb(zzdri, Exception.class, new zzccg((Object) null), zzbab.zzdzw);
    }

    private final zzdri<List<zzace>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdqw.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdqw.zzb(zzdqw.zzi(arrayList), zzccd.zzdsc, this.executor);
    }

    private final zzdri<zzace> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdqw.zzag(null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzdqw.zzag(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzdqw.zzag(new zzace((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzdqw.zzb(this.zzfve.zza(optString, optDouble, optBoolean), new zzccc(optString, optDouble, optInt, optInt2), this.executor), (Object) null);
    }

    private static <T> zzdri<T> zza(boolean z, zzdri<T> zzdri, T t) {
        return z ? zzdqw.zzb(zzdri, new zzccj(zzdri), (Executor) zzbab.zzdzw) : zza(zzdri, (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzye> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzye zzl = zzl(optJSONArray.optJSONObject(i));
            if (zzl != null) {
                arrayList.add(zzl);
            }
        }
        return arrayList;
    }

    @Nullable
    public static zzye zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(optJSONObject);
    }

    @Nullable
    private static zzye zzl(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzye(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzacd zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzacd(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdhc.zzbla, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzb(String str, Object obj) throws Exception {
        zzq.zzkx();
        zzbek zza = zzbes.zza(this.zzvf, zzbfz.zzacl(), "native-omid", false, false, this.zzejl, this.zzbmo, (zzaam) null, (zzi) null, this.zzfvf, this.zzeht, (zzrv) null, false);
        zzbak zzl = zzbak.zzl(zza);
        zza.zzabj().zza((zzbfv) new zzcci(zzl));
        zza.loadData(str, "text/html", "UTF-8");
        return zzl;
    }

    public final zzdri<zzace> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdhc.zzcyt);
    }

    public final zzdri<List<zzace>> zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzaci zzaci = this.zzdhc;
        return zza(optJSONArray, zzaci.zzcyt, zzaci.zzbkz);
    }

    public final zzdri<zzacd> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdqw.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdqw.zzb(zza(optJSONArray, false, true), new zzccf(this, optJSONObject), this.executor), (Object) null);
    }

    public final zzdri<zzbek> zzm(JSONObject jSONObject) {
        JSONObject zza = zzayu.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdqw.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzazw.zzfc("Required field 'vast_xml' is missing");
                return zzdqw.zzag(null);
            }
            return zza(zzdqw.zza(this.zzfvg.zzn(optJSONObject), (long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcot)).intValue(), TimeUnit.SECONDS, this.zzfky), (Object) null);
        }
        zzdri<zzbek> zzo = this.zzfvg.zzo(zza.optString("base_url"), zza.optString("html"));
        return zzdqw.zzb(zzo, new zzcch(zzo), (Executor) zzbab.zzdzw);
    }
}
