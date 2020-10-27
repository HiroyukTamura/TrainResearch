package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzzv implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private final ConditionVariable zzcin = new ConditionVariable();
    @VisibleForTesting
    private volatile boolean zzcio = false;
    /* access modifiers changed from: private */
    @Nullable
    public SharedPreferences zzcip = null;
    private Context zzciq;
    private JSONObject zzcir = new JSONObject();
    private volatile boolean zzyw = false;

    private final void zzrc() {
        if (this.zzcip != null) {
            try {
                this.zzcir = new JSONObject((String) zzaze.zza(new zzzx(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void initialize(Context context) {
        if (!this.zzyw) {
            synchronized (this.lock) {
                if (!this.zzyw) {
                    if (!this.zzcio) {
                        this.zzcio = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzciq = applicationContext;
                    try {
                        this.metaData = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzciq.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null) {
                            Context applicationContext2 = context.getApplicationContext();
                            if (applicationContext2 != null) {
                                context = applicationContext2;
                            }
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzvj.zzpt();
                            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            this.zzcip = sharedPreferences;
                            if (sharedPreferences != null) {
                                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzacb.zza(new zzzw(this));
                            zzrc();
                            this.zzyw = true;
                            this.zzcio = false;
                            this.zzcin.open();
                        }
                    } finally {
                        this.zzcio = false;
                        this.zzcin.open();
                    }
                }
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzrc();
        }
    }

    public final <T> T zzd(zzzk<T> zzzk) {
        if (!this.zzcin.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzcio) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzyw || this.zzcip == null) {
            synchronized (this.lock) {
                if (this.zzyw) {
                    if (this.zzcip == null) {
                    }
                }
                T zzqz = zzzk.zzqz();
                return zzqz;
            }
        }
        if (zzzk.getSource() != 2) {
            return (zzzk.getSource() != 1 || !this.zzcir.has(zzzk.getKey())) ? zzaze.zza(new zzzu(this, zzzk)) : zzzk.zzb(this.zzcir);
        }
        Bundle bundle = this.metaData;
        return bundle == null ? zzzk.zzqz() : zzzk.zza(bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzzk zzzk) {
        return zzzk.zza(this.zzcip);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzrd() {
        return this.zzcip.getString("flag_configuration", "{}");
    }
}
