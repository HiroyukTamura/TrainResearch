package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzak extends zzfz {

    /* renamed from: ID */
    private static final String f957ID = zza.CONTAINS.toString();

    public zzak() {
        super(f957ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzl> map) {
        return str.contains(str2);
    }
}
