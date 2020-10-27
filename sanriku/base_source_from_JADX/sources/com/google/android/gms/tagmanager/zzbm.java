package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
public final class zzbm extends zzfz {

    /* renamed from: ID */
    private static final String f965ID = zza.EQUALS.toString();

    public zzbm() {
        super(f965ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzl> map) {
        return str.equals(str2);
    }
}
