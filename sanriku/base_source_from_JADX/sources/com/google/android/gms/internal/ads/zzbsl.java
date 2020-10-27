package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbsl extends zzbui<AdMetadataListener> implements zzafj {
    private Bundle zzfnk = new Bundle();

    public zzbsl(Set<zzbvt<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfnk);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfnk.putAll(bundle);
        zza(zzbso.zzfnf);
    }
}
