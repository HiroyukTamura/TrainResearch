package com.google.android.gms.internal.ads;

public final class zzdzc {
    private final zzdzp zzhrc;
    private final zzdzp zzhrd;

    public zzdzc(byte[] bArr, byte[] bArr2) {
        this.zzhrc = zzdzp.zzs(bArr);
        this.zzhrd = zzdzp.zzs(bArr2);
    }

    public final byte[] zzbby() {
        zzdzp zzdzp = this.zzhrc;
        if (zzdzp == null) {
            return null;
        }
        return zzdzp.getBytes();
    }

    public final byte[] zzbbz() {
        zzdzp zzdzp = this.zzhrd;
        if (zzdzp == null) {
            return null;
        }
        return zzdzp.getBytes();
    }
}
