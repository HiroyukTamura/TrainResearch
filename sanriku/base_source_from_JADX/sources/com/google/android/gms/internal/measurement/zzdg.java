package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

final /* synthetic */ class zzdg implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzdh zza;

    zzdg(zzdh zzdh) {
        this.zza = zzdh;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
