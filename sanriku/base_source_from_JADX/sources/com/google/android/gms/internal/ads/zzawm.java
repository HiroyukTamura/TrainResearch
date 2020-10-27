package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import p043jp.reifrontier.gym.RFGDef;

public final class zzawm {
    private String zzdma = RFGDef.DEFAULT_GYM_ID;
    private BigInteger zzduz = BigInteger.ONE;

    public final synchronized String zzwl() {
        String bigInteger;
        bigInteger = this.zzduz.toString();
        this.zzduz = this.zzduz.add(BigInteger.ONE);
        this.zzdma = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzwm() {
        return this.zzdma;
    }
}
