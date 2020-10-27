package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;

public abstract class zzez<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzez<MessageType, BuilderType>> implements zzhn {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzhn zza(zzho zzho) {
        if (zzbm().getClass().isInstance(zzho)) {
            return zza((zzex) zzho);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzaj */
    public abstract BuilderType clone();
}
