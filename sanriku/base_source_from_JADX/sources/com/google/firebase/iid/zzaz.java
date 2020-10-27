package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzaz {
    private final SharedPreferences zza;
    private final Context zzb;
    @GuardedBy("this")
    private final Map<String, Long> zzc = new ArrayMap();

    public zzaz(Context context) {
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !zzb()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zza();
                    FirebaseInstanceId.getInstance().zze();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private static String zza(String str, String str2) {
        return C0681a.m313a(C0681a.m336b(str2, C0681a.m336b(str, 3)), str, "|S|", str2);
    }

    private final synchronized boolean zzb() {
        return this.zza.getAll().isEmpty();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder b = C0681a.m337b(C0681a.m336b(str3, C0681a.m336b(str2, C0681a.m336b(str, 4))), str, "|T|", str2, "|");
        b.append(str3);
        return b.toString();
    }

    private final long zzd(String str) {
        String string = this.zza.getString(zza(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final synchronized long zza(String str) {
        Long l = this.zzc.get(str);
        if (l != null) {
            return l.longValue();
        }
        return zzd(str);
    }

    public final synchronized zzay zza(String str, String str2, String str3) {
        return zzay.zza(this.zza.getString(zzc(str, str2, str3), (String) null));
    }

    public final synchronized void zza() {
        this.zzc.clear();
        this.zza.edit().clear().commit();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza2 = zzay.zza(str4, str5, System.currentTimeMillis());
        if (zza2 != null) {
            SharedPreferences.Editor edit = this.zza.edit();
            edit.putString(zzc(str, str2, str3), zza2);
            edit.commit();
        }
    }

    public final synchronized long zzb(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.zza.contains(zza(str, "cre"))) {
            SharedPreferences.Editor edit = this.zza.edit();
            edit.putString(zza(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = zzd(str);
        }
        this.zzc.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc2 = zzc(str, str2, str3);
        SharedPreferences.Editor edit = this.zza.edit();
        edit.remove(zzc2);
        edit.commit();
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zza.edit();
        for (String next : this.zza.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
