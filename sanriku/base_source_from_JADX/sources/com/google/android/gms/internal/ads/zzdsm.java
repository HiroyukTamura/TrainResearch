package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import com.google.android.gms.internal.ads.zzedo;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzdsm<KeyProtoT extends zzedo> {
    private final Class<KeyProtoT> zzhiy;
    private final Map<Class<?>, zzdso<?, KeyProtoT>> zzhiz;
    private final Class<?> zzhja;

    @SafeVarargs
    protected zzdsm(Class<KeyProtoT> cls, zzdso<?, KeyProtoT>... zzdsoArr) {
        this.zzhiy = cls;
        HashMap hashMap = new HashMap();
        int length = zzdsoArr.length;
        int i = 0;
        while (i < length) {
            zzdtv zzdtv = zzdsoArr[i];
            if (hashMap.containsKey(zzdtv.zzawu())) {
                String valueOf = String.valueOf(zzdtv.zzawu().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzdtv.zzawu(), zzdtv);
                i++;
            }
        }
        this.zzhja = zzdsoArr.length > 0 ? zzdsoArr[0].zzawu() : Void.class;
        this.zzhiz = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzdso zzdso = this.zzhiz.get(cls);
        if (zzdso != null) {
            return zzdso.zzah(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException(C0681a.m313a(C0681a.m336b(canonicalName, 41), "Requested primitive class ", canonicalName, " not supported."));
    }

    public final Class<KeyProtoT> zzawx() {
        return this.zzhiy;
    }

    public abstract zzdxf.zzb zzawy();

    public final Set<Class<?>> zzawz() {
        return this.zzhiz.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzaxa() {
        return this.zzhja;
    }

    public zzdsl<?, KeyProtoT> zzaxb() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract KeyProtoT zzr(zzeaq zzeaq) throws zzeco;
}
