package com.squareup.picasso;

import java.io.PrintWriter;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.C */
public class C1470C {

    /* renamed from: a */
    public final int f1553a;

    /* renamed from: b */
    public final int f1554b;

    /* renamed from: c */
    public final long f1555c;

    /* renamed from: d */
    public final long f1556d;

    /* renamed from: e */
    public final long f1557e;

    /* renamed from: f */
    public final long f1558f;

    /* renamed from: g */
    public final long f1559g;

    /* renamed from: h */
    public final long f1560h;

    /* renamed from: i */
    public final long f1561i;

    /* renamed from: j */
    public final long f1562j;

    /* renamed from: k */
    public final int f1563k;

    /* renamed from: l */
    public final int f1564l;

    /* renamed from: m */
    public final int f1565m;

    /* renamed from: n */
    public final long f1566n;

    public C1470C(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f1553a = i;
        this.f1554b = i2;
        this.f1555c = j;
        this.f1556d = j2;
        this.f1557e = j3;
        this.f1558f = j4;
        this.f1559g = j5;
        this.f1560h = j6;
        this.f1561i = j7;
        this.f1562j = j8;
        this.f1563k = i3;
        this.f1564l = i4;
        this.f1565m = i5;
        this.f1566n = j9;
    }

    /* renamed from: a */
    public void mo27178a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f1553a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f1554b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f1554b) / ((float) this.f1553a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f1555c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f1556d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f1563k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f1557e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f1560h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f1564l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f1558f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f1565m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f1559g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f1561i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f1562j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("StatsSnapshot{maxSize=");
        a.append(this.f1553a);
        a.append(", size=");
        a.append(this.f1554b);
        a.append(", cacheHits=");
        a.append(this.f1555c);
        a.append(", cacheMisses=");
        a.append(this.f1556d);
        a.append(", downloadCount=");
        a.append(this.f1563k);
        a.append(", totalDownloadSize=");
        a.append(this.f1557e);
        a.append(", averageDownloadSize=");
        a.append(this.f1560h);
        a.append(", totalOriginalBitmapSize=");
        a.append(this.f1558f);
        a.append(", totalTransformedBitmapSize=");
        a.append(this.f1559g);
        a.append(", averageOriginalBitmapSize=");
        a.append(this.f1561i);
        a.append(", averageTransformedBitmapSize=");
        a.append(this.f1562j);
        a.append(", originalBitmapCount=");
        a.append(this.f1564l);
        a.append(", transformedBitmapCount=");
        a.append(this.f1565m);
        a.append(", timeStamp=");
        a.append(this.f1566n);
        a.append('}');
        return a.toString();
    }
}
