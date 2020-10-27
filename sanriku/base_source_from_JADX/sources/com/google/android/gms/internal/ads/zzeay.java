package com.google.android.gms.internal.ads;

final class zzeay {
    private final byte[] buffer;
    private final zzebk zzhtl;

    private zzeay(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzhtl = zzebk.zzw(bArr);
    }

    /* synthetic */ zzeay(int i, zzeat zzeat) {
        this(i);
    }

    public final zzeaq zzbcw() {
        this.zzhtl.zzbdz();
        return new zzeba(this.buffer);
    }

    public final zzebk zzbcx() {
        return this.zzhtl;
    }
}
