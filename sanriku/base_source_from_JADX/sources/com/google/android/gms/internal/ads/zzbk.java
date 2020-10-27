package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;
import kotlin.UByte;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzbk extends zzegk {
    private Date zzct;
    private Date zzcu;
    private long zzcv;
    private long zzcw;
    private double zzcx = 1.0d;
    private float zzcy = 1.0f;
    private zzegu zzcz = zzegu.zziix;
    private long zzda;
    private int zzdb;
    private int zzdc;
    private int zzdd;
    private int zzde;
    private int zzdf;
    private int zzdg;

    public zzbk() {
        super("mvhd");
    }

    public final long getDuration() {
        return this.zzcw;
    }

    public final String toString() {
        StringBuilder c = C0681a.m340c("MovieHeaderBox[", "creationTime=");
        c.append(this.zzct);
        c.append(";");
        c.append("modificationTime=");
        c.append(this.zzcu);
        c.append(";");
        c.append("timescale=");
        c.append(this.zzcv);
        c.append(";");
        c.append("duration=");
        c.append(this.zzcw);
        c.append(";");
        c.append("rate=");
        c.append(this.zzcx);
        c.append(";");
        c.append("volume=");
        c.append(this.zzcy);
        c.append(";");
        c.append("matrix=");
        c.append(this.zzcz);
        c.append(";");
        c.append("nextTrackId=");
        c.append(this.zzda);
        c.append("]");
        return c.toString();
    }

    public final void zzg(ByteBuffer byteBuffer) {
        long j;
        zzm(byteBuffer);
        if (getVersion() == 1) {
            this.zzct = zzegn.zzfv(zzbg.zzc(byteBuffer));
            this.zzcu = zzegn.zzfv(zzbg.zzc(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            j = zzbg.zzc(byteBuffer);
        } else {
            this.zzct = zzegn.zzfv(zzbg.zza(byteBuffer));
            this.zzcu = zzegn.zzfv(zzbg.zza(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            j = zzbg.zza(byteBuffer);
        }
        this.zzcw = j;
        this.zzcx = zzbg.zzd(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzcy = ((float) ((short) ((bArr[1] & UByte.MAX_VALUE) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)))))) / 256.0f;
        zzbg.zzb(byteBuffer);
        zzbg.zza(byteBuffer);
        zzbg.zza(byteBuffer);
        this.zzcz = zzegu.zzn(byteBuffer);
        this.zzdb = byteBuffer.getInt();
        this.zzdc = byteBuffer.getInt();
        this.zzdd = byteBuffer.getInt();
        this.zzde = byteBuffer.getInt();
        this.zzdf = byteBuffer.getInt();
        this.zzdg = byteBuffer.getInt();
        this.zzda = zzbg.zza(byteBuffer);
    }

    public final long zzs() {
        return this.zzcv;
    }
}
