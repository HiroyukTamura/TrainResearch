package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaww implements zzawt {
    private final Object lock = new Object();
    @Nullable
    private SharedPreferences zzcip;
    private boolean zzdme = true;
    private boolean zzdmr = false;
    private String zzdmu = "";
    private boolean zzdod = true;
    private boolean zzdop = true;
    private boolean zzdvi;
    private final List<Runnable> zzdvj = new ArrayList();
    private zzdri<?> zzdvk;
    @Nullable
    private zzqp zzdvl = null;
    @Nullable
    private SharedPreferences.Editor zzdvm;
    private boolean zzdvn = false;
    @Nullable
    private String zzdvo;
    @Nullable
    private String zzdvp;
    private long zzdvq = 0;
    private long zzdvr = 0;
    private long zzdvs = 0;
    private int zzdvt = -1;
    private int zzdvu = 0;
    private Set<String> zzdvv = Collections.emptySet();
    private JSONObject zzdvw = new JSONObject();
    private String zzdvx = null;
    private int zzdvy = -1;

    private final void zzc(Bundle bundle) {
        zzbab.zzdzr.execute(new zzawy(this));
    }

    private final void zzxd() {
        zzdri<?> zzdri = this.zzdvk;
        if (zzdri != null && !zzdri.isDone()) {
            try {
                this.zzdvk.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzazw.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzazw.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzxe() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdme);
            bundle.putBoolean("content_url_opted_out", this.zzdod);
            bundle.putBoolean("content_vertical_opted_out", this.zzdop);
            bundle.putBoolean("auto_collect_location", this.zzdmr);
            bundle.putInt("version_code", this.zzdvu);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdvv.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdmu);
            bundle.putLong("app_settings_last_update_ms", this.zzdvq);
            bundle.putLong("app_last_background_time_ms", this.zzdvr);
            bundle.putInt("request_in_session_count", this.zzdvt);
            bundle.putLong("first_ad_req_time_ms", this.zzdvs);
            bundle.putString("native_advanced_settings", this.zzdvw.toString());
            bundle.putString("display_cutout", this.zzdvx);
            bundle.putInt("app_measurement_npa", this.zzdvy);
            if (this.zzdvo != null) {
                bundle.putString("content_url_hashes", this.zzdvo);
            }
            if (this.zzdvp != null) {
                bundle.putString("content_vertical_hashes", this.zzdvp);
            }
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r4.length() == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r4 = "admob__".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r4 = new java.lang.String("admob__");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r2.zzdvk = com.google.android.gms.internal.ads.zzbab.zzdzr.zzf(new com.google.android.gms.internal.ads.zzawv(r2, r3, r4));
        r2.zzdvi = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        if (r4 != null) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r4 = "admob";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r2.zzcip     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            if (r4 != 0) goto L_0x000f
            java.lang.String r4 = "admob"
            goto L_0x0021
        L_0x000f:
            java.lang.String r0 = "admob__"
            int r1 = r4.length()
            if (r1 == 0) goto L_0x001c
            java.lang.String r4 = r0.concat(r4)
            goto L_0x0021
        L_0x001c:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x0021:
            com.google.android.gms.internal.ads.zzdrh r0 = com.google.android.gms.internal.ads.zzbab.zzdzr
            com.google.android.gms.internal.ads.zzawv r1 = new com.google.android.gms.internal.ads.zzawv
            r1.<init>(r2, r3, r4)
            com.google.android.gms.internal.ads.zzdri r3 = r0.zzf(r1)
            r2.zzdvk = r3
            r2.zzdvi = r5
            return
        L_0x0031:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zza(android.content.Context, java.lang.String, boolean):void");
    }

    public final void zza(String str, String str2, boolean z) {
        zzxd();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzdvw.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzq.zzld().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzdvw.put(str, optJSONArray);
            } catch (JSONException e) {
                zzazw.zzd("Could not update native advanced settings", e);
            }
            if (this.zzdvm != null) {
                this.zzdvm.putString("native_advanced_settings", this.zzdvw.toString());
                this.zzdvm.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzdvw.toString());
            zzc(bundle);
        }
    }

    public final void zzao(boolean z) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdod != z) {
                this.zzdod = z;
                if (this.zzdvm != null) {
                    this.zzdvm.putBoolean("content_url_opted_out", z);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdod);
                bundle.putBoolean("content_vertical_opted_out", this.zzdop);
                zzc(bundle);
            }
        }
    }

    public final void zzap(boolean z) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdop != z) {
                this.zzdop = z;
                if (this.zzdvm != null) {
                    this.zzdvm.putBoolean("content_vertical_opted_out", z);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdod);
                bundle.putBoolean("content_vertical_opted_out", this.zzdop);
                zzc(bundle);
            }
        }
    }

    public final void zzaq(boolean z) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdmr != z) {
                this.zzdmr = z;
                if (this.zzdvm != null) {
                    this.zzdvm.putBoolean("auto_collect_location", z);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzc(bundle);
            }
        }
    }

    public final void zzb(Runnable runnable) {
        this.zzdvj.add(runnable);
    }

    public final void zzcy(int i) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdvu != i) {
                this.zzdvu = i;
                if (this.zzdvm != null) {
                    this.zzdvm.putInt("version_code", i);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzc(bundle);
            }
        }
    }

    public final void zzcz(int i) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdvt != i) {
                this.zzdvt = i;
                if (this.zzdvm != null) {
                    this.zzdvm.putInt("request_in_session_count", i);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzc(bundle);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzeh(@androidx.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzxd()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdvo     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdvo = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzeh(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzei(@androidx.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzxd()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdvp     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdvp = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdvm     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzei(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzej(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzxd()
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ all -> 0x0060 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r5.zzdvq = r1     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r5.zzdmu     // Catch:{ all -> 0x0060 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            r5.zzdmu = r6     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdvm     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.zzdvm     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdvm     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_last_update_ms"
            r3.putLong(r4, r1)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdvm     // Catch:{ all -> 0x0060 }
            r3.apply()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "app_settings_last_update_ms"
            r3.putLong(r6, r1)     // Catch:{ all -> 0x0060 }
            r5.zzc(r3)     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Runnable> r6 = r5.zzdvj     // Catch:{ all -> 0x0060 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0060 }
        L_0x004c:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0060 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0060 }
            r1.run()     // Catch:{ all -> 0x0060 }
            goto L_0x004c
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0063:
            throw r6
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzej(java.lang.String):void");
    }

    public final void zzek(String str) {
        zzxd();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzdvx, str)) {
                this.zzdvx = str;
                if (this.zzdvm != null) {
                    this.zzdvm.putString("display_cutout", str);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                zzc(bundle);
            }
        }
    }

    public final void zzez(long j) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdvr != j) {
                this.zzdvr = j;
                if (this.zzdvm != null) {
                    this.zzdvm.putLong("app_last_background_time_ms", j);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final void zzfa(long j) {
        zzxd();
        synchronized (this.lock) {
            if (this.zzdvs != j) {
                this.zzdvs = j;
                if (this.zzdvm != null) {
                    this.zzdvm.putLong("first_ad_req_time_ms", j);
                    this.zzdvm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzc(bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcip = sharedPreferences;
            this.zzdvm = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdvn = z;
            this.zzdme = this.zzcip.getBoolean("use_https", this.zzdme);
            this.zzdod = this.zzcip.getBoolean("content_url_opted_out", this.zzdod);
            this.zzdvo = this.zzcip.getString("content_url_hashes", this.zzdvo);
            this.zzdmr = this.zzcip.getBoolean("auto_collect_location", this.zzdmr);
            this.zzdop = this.zzcip.getBoolean("content_vertical_opted_out", this.zzdop);
            this.zzdvp = this.zzcip.getString("content_vertical_hashes", this.zzdvp);
            this.zzdvu = this.zzcip.getInt("version_code", this.zzdvu);
            this.zzdmu = this.zzcip.getString("app_settings_json", this.zzdmu);
            this.zzdvq = this.zzcip.getLong("app_settings_last_update_ms", this.zzdvq);
            this.zzdvr = this.zzcip.getLong("app_last_background_time_ms", this.zzdvr);
            this.zzdvt = this.zzcip.getInt("request_in_session_count", this.zzdvt);
            this.zzdvs = this.zzcip.getLong("first_ad_req_time_ms", this.zzdvs);
            this.zzdvv = this.zzcip.getStringSet("never_pool_slots", this.zzdvv);
            this.zzdvx = this.zzcip.getString("display_cutout", this.zzdvx);
            this.zzdvy = this.zzcip.getInt("app_measurement_npa", this.zzdvy);
            try {
                this.zzdvw = new JSONObject(this.zzcip.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzazw.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzxe());
        }
    }

    @Nullable
    public final zzqp zzwp() {
        if (!this.zzdvi) {
            return null;
        }
        if ((zzwq() && zzws()) || !zzabh.zzcwc.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzdvl == null) {
                this.zzdvl = new zzqp();
            }
            this.zzdvl.zzmh();
            zzazw.zzfb("start fetching content...");
            zzqp zzqp = this.zzdvl;
            return zzqp;
        }
    }

    public final boolean zzwq() {
        boolean z;
        zzxd();
        synchronized (this.lock) {
            z = this.zzdod;
        }
        return z;
    }

    @Nullable
    public final String zzwr() {
        String str;
        zzxd();
        synchronized (this.lock) {
            str = this.zzdvo;
        }
        return str;
    }

    public final boolean zzws() {
        boolean z;
        zzxd();
        synchronized (this.lock) {
            z = this.zzdop;
        }
        return z;
    }

    @Nullable
    public final String zzwt() {
        String str;
        zzxd();
        synchronized (this.lock) {
            str = this.zzdvp;
        }
        return str;
    }

    public final boolean zzwu() {
        boolean z;
        zzxd();
        synchronized (this.lock) {
            z = this.zzdmr;
        }
        return z;
    }

    public final int zzwv() {
        int i;
        zzxd();
        synchronized (this.lock) {
            i = this.zzdvu;
        }
        return i;
    }

    public final zzawe zzww() {
        zzawe zzawe;
        zzxd();
        synchronized (this.lock) {
            zzawe = new zzawe(this.zzdmu, this.zzdvq);
        }
        return zzawe;
    }

    public final long zzwx() {
        long j;
        zzxd();
        synchronized (this.lock) {
            j = this.zzdvr;
        }
        return j;
    }

    public final int zzwy() {
        int i;
        zzxd();
        synchronized (this.lock) {
            i = this.zzdvt;
        }
        return i;
    }

    public final long zzwz() {
        long j;
        zzxd();
        synchronized (this.lock) {
            j = this.zzdvs;
        }
        return j;
    }

    public final JSONObject zzxa() {
        JSONObject jSONObject;
        zzxd();
        synchronized (this.lock) {
            jSONObject = this.zzdvw;
        }
        return jSONObject;
    }

    public final void zzxb() {
        zzxd();
        synchronized (this.lock) {
            this.zzdvw = new JSONObject();
            if (this.zzdvm != null) {
                this.zzdvm.remove("native_advanced_settings");
                this.zzdvm.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    public final String zzxc() {
        String str;
        zzxd();
        synchronized (this.lock) {
            str = this.zzdvx;
        }
        return str;
    }
}
