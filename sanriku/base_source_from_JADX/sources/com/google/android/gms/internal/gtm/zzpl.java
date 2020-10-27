package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzpl;
import com.google.android.gms.internal.gtm.zzpm;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzpl<MessageType extends zzpl<MessageType, BuilderType>, BuilderType extends zzpm<MessageType, BuilderType>> implements zzsk {
    private static boolean zzavq = false;
    protected int zzavp = 0;

    /* access modifiers changed from: package-private */
    public void zzag(int i) {
        throw new UnsupportedOperationException();
    }

    public final zzps zzmv() {
        try {
            zzqa zzam = zzps.zzam(zzpe());
            zzb(zzam.zznh());
            return zzam.zzng();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzmw() {
        throw new UnsupportedOperationException();
    }
}
