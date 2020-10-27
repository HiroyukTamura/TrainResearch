package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzfy extends zzfz {

    /* renamed from: ID */
    private static final String f988ID = zza.STARTS_WITH.toString();

    public zzfy() {
        super(f988ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzl> map) {
        return str.startsWith(str2);
    }
}
