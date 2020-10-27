package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzez<MessageType, BuilderType>> implements zzho {
    protected int zzrb = 0;

    public final zzff zzag() {
        try {
            zzfn zzj = zzff.zzj(zzbk());
            zzb(zzj.zzau());
            return zzj.zzat();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzah() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzg(int i) {
        throw new UnsupportedOperationException();
    }
}
