package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzdsp {
    private static final CopyOnWriteArrayList<zzdsq> zzhjc = new CopyOnWriteArrayList<>();

    public static zzdsq zzhf(String str) throws GeneralSecurityException {
        Iterator<zzdsq> it = zzhjc.iterator();
        while (it.hasNext()) {
            zzdsq next = it.next();
            if (next.zzhg(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
