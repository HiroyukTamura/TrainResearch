package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzeeg extends zzeav {
    private final zzeei zzibh = new zzeei(this.zzibj, (zzeeg) null);
    private zzeaz zzibi = zzbgo();
    private final /* synthetic */ zzeed zzibj;

    zzeeg(zzeed zzeed) {
        this.zzibj = zzeed;
    }

    private final zzeaz zzbgo() {
        if (this.zzibh.hasNext()) {
            return (zzeaz) ((zzebb) this.zzibh.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzibi != null;
    }

    public final byte nextByte() {
        zzeaz zzeaz = this.zzibi;
        if (zzeaz != null) {
            byte nextByte = zzeaz.nextByte();
            if (!this.zzibi.hasNext()) {
                this.zzibi = zzbgo();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
