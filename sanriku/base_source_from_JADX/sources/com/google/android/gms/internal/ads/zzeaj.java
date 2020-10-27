package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeaj;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzeaj<MessageType extends zzeag<MessageType, BuilderType>, BuilderType extends zzeaj<MessageType, BuilderType>> implements zzedn {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzebf zzebf, zzebq zzebq) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzebq zzebq) throws zzeco {
        try {
            zzebf zzb = zzebf.zzb(bArr, 0, i2, false);
            zza(zzb, zzebq);
            zzb.zzfs(0);
            return this;
        } catch (zzeco e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("byte array".length() + name.length() + 60, "Reading ", name, " from a ", "byte array");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e2);
        }
    }

    /* renamed from: zzbch */
    public abstract BuilderType clone();

    public final /* synthetic */ zzedn zzf(zzedo zzedo) {
        if (zzbeu().getClass().isInstance(zzedo)) {
            return zza((zzeag) zzedo);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
