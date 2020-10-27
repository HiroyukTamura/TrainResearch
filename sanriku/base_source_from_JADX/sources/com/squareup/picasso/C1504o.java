package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.squareup.picasso.o */
final class C1504o extends InputStream {

    /* renamed from: a */
    private final InputStream f1644a;

    /* renamed from: b */
    private long f1645b;

    /* renamed from: c */
    private long f1646c;

    /* renamed from: d */
    private long f1647d;

    /* renamed from: e */
    private long f1648e = -1;

    /* renamed from: f */
    private boolean f1649f = true;

    /* renamed from: g */
    private int f1650g = -1;

    C1504o(InputStream inputStream) {
        this.f1644a = !inputStream.markSupported() ? new BufferedInputStream(inputStream, 4096) : inputStream;
        this.f1650g = 1024;
    }

    /* renamed from: a */
    private void m2054a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f1644a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    /* renamed from: i */
    private void m2055i(long j) {
        try {
            if (this.f1646c >= this.f1645b || this.f1645b > this.f1647d) {
                this.f1646c = this.f1645b;
                this.f1644a.mark((int) (j - this.f1645b));
            } else {
                this.f1644a.reset();
                this.f1644a.mark((int) (j - this.f1646c));
                m2054a(this.f1646c, this.f1645b);
            }
            this.f1647d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    /* renamed from: a */
    public long mo27228a(int i) {
        long j = this.f1645b + ((long) i);
        if (this.f1647d < j) {
            m2055i(j);
        }
        return this.f1645b;
    }

    /* renamed from: a */
    public void mo27229a(boolean z) {
        this.f1649f = z;
    }

    public int available() throws IOException {
        return this.f1644a.available();
    }

    public void close() throws IOException {
        this.f1644a.close();
    }

    /* renamed from: h */
    public void mo27232h(long j) throws IOException {
        if (this.f1645b > this.f1647d || j < this.f1646c) {
            throw new IOException("Cannot reset");
        }
        this.f1644a.reset();
        m2054a(this.f1646c, j);
        this.f1645b = j;
    }

    public void mark(int i) {
        long j = this.f1645b + ((long) i);
        if (this.f1647d < j) {
            m2055i(j);
        }
        this.f1648e = this.f1645b;
    }

    public boolean markSupported() {
        return this.f1644a.markSupported();
    }

    public int read() throws IOException {
        if (!this.f1649f) {
            long j = this.f1647d;
            if (this.f1645b + 1 > j) {
                m2055i(j + ((long) this.f1650g));
            }
        }
        int read = this.f1644a.read();
        if (read != -1) {
            this.f1645b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.f1649f) {
            long j = this.f1645b;
            if (((long) bArr.length) + j > this.f1647d) {
                m2055i(j + ((long) bArr.length) + ((long) this.f1650g));
            }
        }
        int read = this.f1644a.read(bArr);
        if (read != -1) {
            this.f1645b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f1649f) {
            long j = this.f1645b;
            long j2 = (long) i2;
            if (j + j2 > this.f1647d) {
                m2055i(j + j2 + ((long) this.f1650g));
            }
        }
        int read = this.f1644a.read(bArr, i, i2);
        if (read != -1) {
            this.f1645b += (long) read;
        }
        return read;
    }

    public void reset() throws IOException {
        mo27232h(this.f1648e);
    }

    public long skip(long j) throws IOException {
        if (!this.f1649f) {
            long j2 = this.f1645b;
            if (j2 + j > this.f1647d) {
                m2055i(j2 + j + ((long) this.f1650g));
            }
        }
        long skip = this.f1644a.skip(j);
        this.f1645b += skip;
        return skip;
    }
}
