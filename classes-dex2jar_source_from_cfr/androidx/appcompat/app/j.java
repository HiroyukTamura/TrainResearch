/*
 * Decompiled with CFR 0.139.
 */
package androidx.appcompat.app;

class j {
    private static j d;
    public long a;
    public long b;
    public int c;

    j() {
    }

    static j a() {
        if (d == null) {
            d = new j();
        }
        return d;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2, double d2, double d3) {
        block6 : {
            block5 : {
                block4 : {
                    float f2 = (float)(l2 - 946728000000L) / 8.64E7f;
                    float f3 = 0.01720197f * f2 + 6.24006f;
                    double d4 = f3;
                    double d5 = Math.sin(d4) * 0.03341960161924362 + d4 + Math.sin(2.0f * f3) * 3.4906598739326E-4 + Math.sin(f3 * 3.0f) * 5.236000106378924E-6 + 1.796593063 + 3.141592653589793;
                    d3 = -d3 / 360.0;
                    d3 = (double)((float)Math.round((double)(f2 - 9.0E-4f) - d3) + 9.0E-4f) + d3 + Math.sin(d4) * 0.0053 + Math.sin(2.0 * d5) * -0.0069;
                    d5 = Math.asin(Math.sin(d5) * Math.sin(0.4092797040939331));
                    d2 = 0.01745329238474369 * d2;
                    d2 = (Math.sin(-0.10471975803375244) - Math.sin(d2) * Math.sin(d5)) / (Math.cos(d2) * Math.cos(d5));
                    if (!(d2 >= 1.0)) break block4;
                    this.c = 1;
                    break block5;
                }
                if (!(d2 <= -1.0)) break block6;
                this.c = 0;
            }
            this.a = -1L;
            this.b = -1L;
            return;
        }
        d2 = (float)(Math.acos(d2) / 6.283185307179586);
        this.a = Math.round((d3 + d2) * 8.64E7) + 946728000000L;
        this.b = Math.round((d3 - d2) * 8.64E7) + 946728000000L;
        if (this.b < l2 && this.a > l2) {
            this.c = 0;
            return;
        }
        this.c = 1;
    }
}

