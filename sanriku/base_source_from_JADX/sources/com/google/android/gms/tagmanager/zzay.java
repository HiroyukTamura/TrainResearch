package com.google.android.gms.tagmanager;

import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

final class zzay {
    final String zzagg;
    final byte[] zzagh;

    zzay(String str, byte[] bArr) {
        this.zzagg = str;
        this.zzagh = bArr;
    }

    public final String toString() {
        String str = this.zzagg;
        int hashCode = Arrays.hashCode(this.zzagh);
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 54));
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(hashCode);
        return sb.toString();
    }
}
