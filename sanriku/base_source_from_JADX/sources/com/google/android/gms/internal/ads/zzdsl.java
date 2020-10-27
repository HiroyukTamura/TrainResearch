package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedo;
import java.security.GeneralSecurityException;

public abstract class zzdsl<KeyFormatProtoT extends zzedo, KeyT> {
    private final Class<KeyFormatProtoT> zzhiy;

    public zzdsl(Class<KeyFormatProtoT> cls) {
        this.zzhiy = cls;
    }

    public final Class<KeyFormatProtoT> zzaww() {
        return this.zzhiy;
    }

    public abstract void zzc(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzq(zzeaq zzeaq) throws zzeco;
}
