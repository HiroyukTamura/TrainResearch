package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Random;

@ShowFirstParty
public final class zzai {
    private final String zzaec;
    private final Random zzafj;
    private final Context zzrm;

    public zzai(Context context, String str) {
        this(context, str, new Random());
    }

    @VisibleForTesting
    private zzai(Context context, String str, Random random) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzaec = (String) Preconditions.checkNotNull(str);
        this.zzafj = random;
    }

    private final long zza(long j, long j2) {
        SharedPreferences zzhp = zzhp();
        long max = Math.max(0, zzhp.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.zzafj.nextFloat() * ((float) (j + ((long) ((((float) max) / ((float) ((max + Math.max(0, zzhp.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j2 - j)))))));
    }

    private final SharedPreferences zzhp() {
        Context context = this.zzrm;
        String valueOf = String.valueOf(this.zzaec);
        return context.getSharedPreferences(valueOf.length() != 0 ? "_gtmContainerRefreshPolicy_".concat(valueOf) : new String("_gtmContainerRefreshPolicy_"), 0);
    }

    public final long zzhl() {
        return zza(7200000, 259200000) + 43200000;
    }

    public final long zzhm() {
        return zza(600000, 86400000) + 3600000;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzhn() {
        SharedPreferences zzhp = zzhp();
        long j = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long j2 = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        SharedPreferences.Editor edit = zzhp.edit();
        long min = j == 0 ? 3 : Math.min(10, j + 1);
        long max = Math.max(0, Math.min(j2, 10 - min));
        edit.putLong("FORBIDDEN_COUNT", min);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzho() {
        SharedPreferences zzhp = zzhp();
        long j = zzhp.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = zzhp.getLong("FORBIDDEN_COUNT", 0);
        long min = Math.min(10, j + 1);
        long max = Math.max(0, Math.min(j2, 10 - min));
        SharedPreferences.Editor edit = zzhp.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }
}
