package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@VisibleForTesting
public abstract class zzef extends zzbq {
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzaio = zzb.ARG1.toString();

    public zzef(String str) {
        super(str, zzags, zzaio);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzl zzl, zzl zzl2, Map<String, zzl> map);

    public final zzl zzb(Map<String, zzl> map) {
        boolean z;
        Iterator<zzl> it = map.values().iterator();
        while (true) {
            z = false;
            if (it.hasNext()) {
                if (it.next() == zzgj.zzkc()) {
                    break;
                }
            } else {
                zzl zzl = map.get(zzags);
                zzl zzl2 = map.get(zzaio);
                if (zzl != null && zzl2 != null) {
                    z = zza(zzl, zzl2, map);
                }
            }
        }
        return zzgj.zzi(Boolean.valueOf(z));
    }

    public final boolean zzgw() {
        return true;
    }

    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }
}
