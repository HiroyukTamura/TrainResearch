package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzt {
    @NonNull
    private final Bundle zza;

    public zzt(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.zza = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    public static boolean zza(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(zzi("gcm.n.e")));
    }

    @Nullable
    private final String zzb(Resources resources, String str, String str2) {
        String zze = zze(str2);
        if (TextUtils.isEmpty(zze)) {
            return null;
        }
        int identifier = resources.getIdentifier(zze, "string", str);
        if (identifier == 0) {
            String valueOf = String.valueOf(str2);
            String zzh = zzh("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
            Log.w("NotificationParams", C0681a.m314a(C0681a.m336b(str2, C0681a.m336b(zzh, 49)), zzh, " resource not found: ", str2, " Default value will be used."));
            return null;
        }
        Object[] zzf = zzf(str2);
        if (zzf == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzf);
        } catch (MissingFormatArgumentException e) {
            String zzh2 = zzh(str2);
            String arrays = Arrays.toString(zzf);
            StringBuilder b = C0681a.m337b(C0681a.m336b(arrays, C0681a.m336b(zzh2, 58)), "Missing format argument for ", zzh2, ": ", arrays);
            b.append(" Default value will be used.");
            Log.w("NotificationParams", b.toString(), e);
            return null;
        }
    }

    @Nullable
    private final JSONArray zzg(String str) {
        String zza2 = zza(str);
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        try {
            return new JSONArray(zza2);
        } catch (JSONException unused) {
            String zzh = zzh(str);
            StringBuilder b = C0681a.m337b(C0681a.m336b(zza2, C0681a.m336b(zzh, 50)), "Malformed JSON for key ", zzh, ": ", zza2);
            b.append(", falling back to default");
            Log.w("NotificationParams", b.toString());
            return null;
        }
    }

    private static String zzh(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    private static String zzi(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    @Nullable
    public final Uri zza() {
        String zza2 = zza("gcm.n.link_android");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zza("gcm.n.link");
        }
        if (!TextUtils.isEmpty(zza2)) {
            return Uri.parse(zza2);
        }
        return null;
    }

    public final String zza(Resources resources, String str, String str2) {
        String zza2 = zza(str2);
        return !TextUtils.isEmpty(zza2) ? zza2 : zzb(resources, str, str2);
    }

    public final String zza(String str) {
        Bundle bundle = this.zza;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String zzi = zzi(str);
            if (this.zza.containsKey(zzi)) {
                str = zzi;
            }
        }
        return bundle.getString(str);
    }

    @Nullable
    public final String zzb() {
        String zza2 = zza("gcm.n.sound2");
        return TextUtils.isEmpty(zza2) ? zza("gcm.n.sound") : zza2;
    }

    public final boolean zzb(String str) {
        String zza2 = zza(str);
        return "1".equals(zza2) || Boolean.parseBoolean(zza2);
    }

    public final Integer zzc(String str) {
        String zza2 = zza(str);
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(zza2));
        } catch (NumberFormatException unused) {
            String zzh = zzh(str);
            StringBuilder b = C0681a.m337b(C0681a.m336b(zza2, C0681a.m336b(zzh, 38)), "Couldn't parse value of ", zzh, "(", zza2);
            b.append(") into an int");
            Log.w("NotificationParams", b.toString());
            return null;
        }
    }

    @Nullable
    public final long[] zzc() {
        JSONArray zzg = zzg("gcm.n.vibrate_timings");
        if (zzg == null) {
            return null;
        }
        try {
            if (zzg.length() > 1) {
                int length = zzg.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = zzg.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(zzg);
            StringBuilder sb = new StringBuilder(valueOf.length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Long zzd(String str) {
        String zza2 = zza(str);
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(zza2));
        } catch (NumberFormatException unused) {
            String zzh = zzh(str);
            StringBuilder b = C0681a.m337b(C0681a.m336b(zza2, C0681a.m336b(zzh, 38)), "Couldn't parse value of ", zzh, "(", zza2);
            b.append(") into a long");
            Log.w("NotificationParams", b.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final int[] zzd() {
        StringBuilder sb;
        JSONArray zzg = zzg("gcm.n.light_settings");
        if (zzg == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (zzg.length() == 3) {
                int parseColor = Color.parseColor(zzg.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = zzg.optInt(1);
                    iArr[2] = zzg.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            String valueOf = String.valueOf(zzg);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf);
            sb = sb2;
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (IllegalArgumentException e) {
            String valueOf2 = String.valueOf(zzg);
            String message = e.getMessage();
            sb = C0681a.m337b(C0681a.m336b(message, valueOf2.length() + 60), "LightSettings is invalid: ", valueOf2, ". ", message);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Bundle zze() {
        Bundle bundle = new Bundle(this.zza);
        for (String str : this.zza.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    @Nullable
    public final String zze(String str) {
        String valueOf = String.valueOf(str);
        return zza("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle(this.zza);
        for (String str : this.zza.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    @Nullable
    public final Object[] zzf(String str) {
        String valueOf = String.valueOf(str);
        JSONArray zzg = zzg("_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (zzg == null) {
            return null;
        }
        int length = zzg.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = zzg.optString(i);
        }
        return strArr;
    }
}
