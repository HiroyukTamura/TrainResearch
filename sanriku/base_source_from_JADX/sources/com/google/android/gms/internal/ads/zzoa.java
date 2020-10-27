package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzoa extends IOException {
    private final int type;
    private final zznv zzbfy;

    public zzoa(IOException iOException, zznv zznv, int i) {
        super(iOException);
        this.zzbfy = zznv;
        this.type = i;
    }

    public zzoa(String str, zznv zznv, int i) {
        super(str);
        this.zzbfy = zznv;
        this.type = 1;
    }

    public zzoa(String str, IOException iOException, zznv zznv, int i) {
        super(str, iOException);
        this.zzbfy = zznv;
        this.type = 1;
    }
}
