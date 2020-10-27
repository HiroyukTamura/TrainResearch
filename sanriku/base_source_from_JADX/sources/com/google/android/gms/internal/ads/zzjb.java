package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzjb extends zziu {
    public long timeUs;
    public final zzix zzano = new zzix();
    private final int zzanp = 0;
    public ByteBuffer zzcs;

    public zzjb(int i) {
    }

    private final ByteBuffer zzac(int i) {
        ByteBuffer byteBuffer = this.zzcs;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzcs;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzz(1073741824);
    }

    public final void zzab(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzcs;
        if (byteBuffer == null) {
            this.zzcs = zzac(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzcs.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzac = zzac(i2);
            if (position > 0) {
                this.zzcs.position(0);
                this.zzcs.limit(position);
                zzac.put(this.zzcs);
            }
            this.zzcs = zzac;
        }
    }
}
