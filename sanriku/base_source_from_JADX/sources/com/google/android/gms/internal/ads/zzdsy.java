package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedo;

public abstract class zzdsy<KeyProtoT extends zzedo, PublicKeyProtoT extends zzedo> extends zzdsm<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhjr;

    @SafeVarargs
    protected zzdsy(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzdso<?, KeyProtoT>... zzdsoArr) {
        super(cls, zzdsoArr);
        this.zzhjr = cls2;
    }
}
