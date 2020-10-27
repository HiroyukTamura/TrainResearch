package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;
import p009e.p010a.p011a.p012a.C0681a;

final class zzz {
    private static final Pattern zza = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final String zzb;
    private final String zzc;
    private final String zzd;

    private zzz(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str}));
            str3 = str2.substring(8);
        }
        if (str3 == null || !zza.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str3, "[a-zA-Z0-9-_.~%]{1,900}"}));
        }
        this.zzb = str3;
        this.zzc = str;
        this.zzd = C0681a.m313a(C0681a.m336b(str2, C0681a.m336b(str, 1)), str, "!", str2);
    }

    public static zzz zza(@NonNull String str) {
        return new zzz(ExifInterface.LATITUDE_SOUTH, str);
    }

    public static zzz zzb(@NonNull String str) {
        return new zzz("U", str);
    }

    @Nullable
    static zzz zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new zzz(split[0], split[1]);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzz)) {
            return false;
        }
        zzz zzz = (zzz) obj;
        return this.zzb.equals(zzz.zzb) && this.zzc.equals(zzz.zzc);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzb);
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }
}
