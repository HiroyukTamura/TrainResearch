package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzk {
    private final String mName;
    private final String mValue;

    public zzk(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzk.class == obj.getClass()) {
            zzk zzk = (zzk) obj;
            return TextUtils.equals(this.mName, zzk.mName) && TextUtils.equals(this.mValue, zzk.mValue);
        }
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final int hashCode() {
        return this.mValue.hashCode() + (this.mName.hashCode() * 31);
    }

    public final String toString() {
        String str = this.mName;
        String str2 = this.mValue;
        StringBuilder b = C0681a.m337b(C0681a.m336b(str2, C0681a.m336b(str, 20)), "Header[name=", str, ",value=", str2);
        b.append("]");
        return b.toString();
    }
}
