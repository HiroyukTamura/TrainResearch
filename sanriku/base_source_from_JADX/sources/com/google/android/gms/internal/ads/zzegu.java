package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzegu {
    public static final zzegu zziix = new zzegu(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzegu zziiy = new zzegu(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzegu zziiz = new zzegu(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzegu zzija = new zzegu(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    private final double f354a;

    /* renamed from: b */
    private final double f355b;

    /* renamed from: c */
    private final double f356c;

    /* renamed from: d */
    private final double f357d;

    /* renamed from: w */
    private final double f358w;
    private final double zziit;
    private final double zziiu;
    private final double zziiv;
    private final double zziiw;

    private zzegu(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zziit = d5;
        this.zziiu = d6;
        this.f358w = d7;
        this.f354a = d;
        this.f355b = d2;
        this.f356c = d3;
        this.f357d = d4;
        this.zziiv = d8;
        this.zziiw = d9;
    }

    public static zzegu zzn(ByteBuffer byteBuffer) {
        double zzd = zzbg.zzd(byteBuffer);
        double zzd2 = zzbg.zzd(byteBuffer);
        double zze = zzbg.zze(byteBuffer);
        return new zzegu(zzd, zzd2, zzbg.zzd(byteBuffer), zzbg.zzd(byteBuffer), zze, zzbg.zze(byteBuffer), zzbg.zze(byteBuffer), zzbg.zzd(byteBuffer), zzbg.zzd(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzegu.class != obj.getClass()) {
            return false;
        }
        zzegu zzegu = (zzegu) obj;
        return Double.compare(zzegu.f354a, this.f354a) == 0 && Double.compare(zzegu.f355b, this.f355b) == 0 && Double.compare(zzegu.f356c, this.f356c) == 0 && Double.compare(zzegu.f357d, this.f357d) == 0 && Double.compare(zzegu.zziiv, this.zziiv) == 0 && Double.compare(zzegu.zziiw, this.zziiw) == 0 && Double.compare(zzegu.zziit, this.zziit) == 0 && Double.compare(zzegu.zziiu, this.zziiu) == 0 && Double.compare(zzegu.f358w, this.f358w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zziit);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zziiu);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f358w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f354a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f355b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f356c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f357d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zziiv);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zziiw);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zziix)) {
            return "Rotate 0°";
        }
        if (equals(zziiy)) {
            return "Rotate 90°";
        }
        if (equals(zziiz)) {
            return "Rotate 180°";
        }
        if (equals(zzija)) {
            return "Rotate 270°";
        }
        double d = this.zziit;
        double d2 = this.zziiu;
        double d3 = this.f358w;
        double d4 = this.f354a;
        double d5 = this.f355b;
        double d6 = this.f356c;
        double d7 = this.f357d;
        double d8 = this.zziiv;
        double d9 = this.zziiw;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }
}
