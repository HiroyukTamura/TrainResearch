package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzcxb implements zzdak<zzdah<Bundle>> {
    @Nullable
    private final zzdee zzgmq;

    zzcxb(@Nullable zzdee zzdee) {
        this.zzgmq = zzdee;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        zzdee zzdee = this.zzgmq;
        return zzdqw.zzag((zzdee == null || zzdee.zzarn() == null || this.zzgmq.zzarn().isEmpty()) ? null : new zzcxe(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("key_schema", this.zzgmq.zzarn());
    }
}
