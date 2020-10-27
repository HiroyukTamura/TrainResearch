package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

public class zzbd extends zzegj implements Closeable {
    private static zzegr zzcr = zzegr.zzn(zzbd.class);

    public zzbd(zzegl zzegl, zzbe zzbe) throws IOException {
        zza(zzegl, zzegl.size(), zzbe);
    }

    public void close() throws IOException {
        this.zziij.close();
    }

    public String toString() {
        String obj = this.zziij.toString();
        return C0681a.m313a(C0681a.m336b(obj, 7), "model(", obj, ")");
    }
}
