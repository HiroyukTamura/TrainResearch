package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzbdm implements Iterable<zzbdk> {
    private final List<zzbdk> zzegp = new ArrayList();

    public static boolean zzc(zzbbx zzbbx) {
        zzbdk zzd = zzd(zzbbx);
        if (zzd == null) {
            return false;
        }
        zzd.zzegn.abort();
        return true;
    }

    static zzbdk zzd(zzbbx zzbbx) {
        Iterator<zzbdk> it = zzq.zzls().iterator();
        while (it.hasNext()) {
            zzbdk next = it.next();
            if (next.zzebj == zzbbx) {
                return next;
            }
        }
        return null;
    }

    public final Iterator<zzbdk> iterator() {
        return this.zzegp.iterator();
    }

    public final void zza(zzbdk zzbdk) {
        this.zzegp.add(zzbdk);
    }

    public final void zzb(zzbdk zzbdk) {
        this.zzegp.remove(zzbdk);
    }
}
