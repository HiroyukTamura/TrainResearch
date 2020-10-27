package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class zzx {
    private final SharedPreferences zza;
    private final String zzb;
    private final String zzc;
    @GuardedBy("internalQueue")
    private final ArrayDeque<String> zzd = new ArrayDeque<>();
    private final Executor zze;
    @GuardedBy("internalQueue")
    private boolean zzf = false;

    private zzx(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = str2;
        this.zze = executor;
    }

    @WorkerThread
    static zzx zza(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        zzx zzx = new zzx(sharedPreferences, str, str2, executor);
        synchronized (zzx.zzd) {
            zzx.zzd.clear();
            String string = zzx.zza.getString(zzx.zzb, "");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains(zzx.zzc)) {
                    String[] split = string.split(zzx.zzc, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str3 : split) {
                        if (!TextUtils.isEmpty(str3)) {
                            zzx.zzd.add(str3);
                        }
                    }
                }
            }
        }
        return zzx;
    }

    @GuardedBy("internalQueue")
    private final boolean zza(boolean z) {
        if (z) {
            this.zze.execute(new zzw(this));
        }
        return z;
    }

    @Nullable
    public final String zza() {
        String peek;
        synchronized (this.zzd) {
            peek = this.zzd.peek();
        }
        return peek;
    }

    public final boolean zza(@Nullable Object obj) {
        boolean zza2;
        synchronized (this.zzd) {
            zza2 = zza(this.zzd.remove(obj));
        }
        return zza2;
    }

    public final boolean zza(@NonNull String str) {
        boolean zza2;
        if (TextUtils.isEmpty(str) || str.contains(this.zzc)) {
            return false;
        }
        synchronized (this.zzd) {
            zza2 = zza(this.zzd.add(str));
        }
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            SharedPreferences.Editor edit = this.zza.edit();
            String str = this.zzb;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.zzd.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(this.zzc);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }
}
