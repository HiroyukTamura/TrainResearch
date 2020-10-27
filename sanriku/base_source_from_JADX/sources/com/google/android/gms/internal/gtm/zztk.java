package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zztk implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzbee;
    private final /* synthetic */ zztc zzbef;
    private boolean zzbej;

    private zztk(zztc zztc) {
        this.zzbef = zztc;
        this.pos = -1;
    }

    /* synthetic */ zztk(zztc zztc, zztd zztd) {
        this(zztc);
    }

    private final Iterator<Map.Entry<K, V>> zzrf() {
        if (this.zzbee == null) {
            this.zzbee = this.zzbef.zzbea.entrySet().iterator();
        }
        return this.zzbee;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzbef.zzbdz.size() || (!this.zzbef.zzbea.isEmpty() && zzrf().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzbej = true;
        int i = this.pos + 1;
        this.pos = i;
        return (Map.Entry) (i < this.zzbef.zzbdz.size() ? this.zzbef.zzbdz.get(this.pos) : zzrf().next());
    }

    public final void remove() {
        if (this.zzbej) {
            this.zzbej = false;
            this.zzbef.zzrd();
            if (this.pos < this.zzbef.zzbdz.size()) {
                zztc zztc = this.zzbef;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zztc.zzbw(i);
                return;
            }
            zzrf().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
