package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface zzhv {
    public static final ByteBuffer zzaig = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i, int i2, int i3) throws zzhu;

    boolean zzfd();

    int zzfi();

    int zzfj();

    void zzfk();

    ByteBuffer zzfl();

    void zzi(ByteBuffer byteBuffer);
}
