package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdoc {
    private final String className;
    private final zzdob zzhds;
    private zzdob zzhdt;
    private boolean zzhdu;

    private zzdoc(String str) {
        zzdob zzdob = new zzdob();
        this.zzhds = zzdob;
        this.zzhdt = zzdob;
        this.zzhdu = false;
        this.className = (String) zzdoj.checkNotNull(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdob zzdob = this.zzhds.zzhdr;
        String str = "";
        while (zzdob != null) {
            Object obj = zzdob.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzdob = zzdob.zzhdr;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdoc zzy(@NullableDecl Object obj) {
        zzdob zzdob = new zzdob();
        this.zzhdt.zzhdr = zzdob;
        this.zzhdt = zzdob;
        zzdob.value = obj;
        return this;
    }
}
