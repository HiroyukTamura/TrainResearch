package p040i.p103M.p110i;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p040i.p103M.p110i.C1837d;
import p042j.C2068f;
import p042j.C2071g;

/* renamed from: i.M.i.j */
public final class C1866j implements Closeable {

    /* renamed from: g */
    private static final Logger f2632g = Logger.getLogger(C1840e.class.getName());

    /* renamed from: a */
    private final C2068f f2633a;

    /* renamed from: b */
    private int f2634b = 16384;

    /* renamed from: c */
    private boolean f2635c;

    /* renamed from: d */
    private final C1837d.C1839b f2636d;

    /* renamed from: e */
    private final C2071g f2637e;

    /* renamed from: f */
    private final boolean f2638f;

    public C1866j(C2071g gVar, boolean z) {
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        this.f2637e = gVar;
        this.f2638f = z;
        C2068f fVar = new C2068f();
        this.f2633a = fVar;
        this.f2636d = new C1837d.C1839b(0, false, fVar, 3);
    }

    /* renamed from: b */
    private final void m3099b(int i, long j) throws IOException {
        while (j > 0) {
            long min = Math.min((long) this.f2634b, j);
            j -= min;
            mo27921a(i, (int) min, 9, j == 0 ? 4 : 0);
            this.f2637e.mo27647a(this.f2633a, min);
        }
    }

    /* renamed from: a */
    public final void mo27921a(int i, int i2, int i3, int i4) throws IOException {
        if (f2632g.isLoggable(Level.FINE)) {
            f2632g.fine(C1840e.f2510e.mo27822a(false, i, i2, i3, i4));
        }
        boolean z = true;
        if (i2 <= this.f2634b) {
            if ((((int) 2147483648L) & i) != 0) {
                z = false;
            }
            if (z) {
                C1764b.m2628a(this.f2637e, i2);
                this.f2637e.writeByte(i3 & 255);
                this.f2637e.writeByte(i4 & 255);
                this.f2637e.writeInt(i & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(C0681a.m316a("reserved bit set: ", i).toString());
        }
        StringBuilder a = C0681a.m330a("FRAME_SIZE_ERROR length > ");
        a.append(this.f2634b);
        a.append(": ");
        a.append(i2);
        throw new IllegalArgumentException(a.toString().toString());
    }

    /* renamed from: a */
    public final synchronized void mo27922a(int i, int i2, List<C1836c> list) throws IOException {
        Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
        if (!this.f2635c) {
            this.f2636d.mo27821a(list);
            long size = this.f2633a.size();
            int min = (int) Math.min(((long) this.f2634b) - 4, size);
            long j = (long) min;
            mo27921a(i, min + 4, 5, size == j ? 4 : 0);
            this.f2637e.writeInt(i2 & Integer.MAX_VALUE);
            this.f2637e.mo27647a(this.f2633a, j);
            if (size > j) {
                m3099b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27923a(int i, long j) throws IOException {
        if (!this.f2635c) {
            if (j != 0 && j <= 2147483647L) {
                mo27921a(i, 4, 8, 0);
                this.f2637e.writeInt((int) j);
                this.f2637e.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27924a(int i, C1834b bVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        if (!this.f2635c) {
            if (bVar.mo27806a() != -1) {
                mo27921a(i, 4, 3, 0);
                this.f2637e.writeInt(bVar.mo27806a());
                this.f2637e.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27925a(int i, C1834b bVar, byte[] bArr) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        Intrinsics.checkParameterIsNotNull(bArr, "debugData");
        if (!this.f2635c) {
            boolean z = false;
            if (bVar.mo27806a() != -1) {
                mo27921a(0, bArr.length + 8, 7, 0);
                this.f2637e.writeInt(i);
                this.f2637e.writeInt(bVar.mo27806a());
                if (bArr.length == 0) {
                    z = true;
                }
                if (!z) {
                    this.f2637e.write(bArr);
                }
                this.f2637e.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27926a(C1871n nVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(nVar, "peerSettings");
        if (!this.f2635c) {
            this.f2634b = nVar.mo27950b(this.f2634b);
            if (nVar.mo27945a() != -1) {
                this.f2636d.mo27818a(nVar.mo27945a());
            }
            mo27921a(0, 0, 4, 1);
            this.f2637e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27927a(boolean z, int i, int i2) throws IOException {
        if (!this.f2635c) {
            mo27921a(0, 8, 6, z ? 1 : 0);
            this.f2637e.writeInt(i);
            this.f2637e.writeInt(i2);
            this.f2637e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27928a(boolean z, int i, C2068f fVar, int i2) throws IOException {
        if (!this.f2635c) {
            mo27921a(i, i2, 0, z ? 1 : 0);
            if (i2 > 0) {
                C2071g gVar = this.f2637e;
                if (fVar == null) {
                    Intrinsics.throwNpe();
                }
                gVar.mo27647a(fVar, (long) i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public final synchronized void mo27929a(boolean z, int i, List<C1836c> list) throws IOException {
        Intrinsics.checkParameterIsNotNull(list, "headerBlock");
        if (!this.f2635c) {
            this.f2636d.mo27821a(list);
            long size = this.f2633a.size();
            long min = Math.min((long) this.f2634b, size);
            int i2 = size == min ? 4 : 0;
            if (z) {
                i2 |= 1;
            }
            mo27921a(i, (int) min, 1, i2);
            this.f2637e.mo27647a(this.f2633a, min);
            if (size > min) {
                m3099b(i, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public final synchronized void mo27930b(C1871n nVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(nVar, "settings");
        if (!this.f2635c) {
            int i = 0;
            mo27921a(0, nVar.mo27953d() * 6, 4, 0);
            while (i < 10) {
                if (nVar.mo27952c(i)) {
                    this.f2637e.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                    this.f2637e.writeInt(nVar.mo27946a(i));
                }
                i++;
            }
            this.f2637e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.f2635c = true;
        this.f2637e.close();
    }

    /* renamed from: d */
    public final synchronized void mo27932d() throws IOException {
        if (this.f2635c) {
            throw new IOException("closed");
        } else if (this.f2638f) {
            if (f2632g.isLoggable(Level.FINE)) {
                Logger logger = f2632g;
                logger.fine(C1764b.m2621a(">> CONNECTION " + C1840e.f2506a.mo29213e(), new Object[0]));
            }
            this.f2637e.mo29137a(C1840e.f2506a);
            this.f2637e.flush();
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.f2635c) {
            this.f2637e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: h */
    public final int mo27934h() {
        return this.f2634b;
    }
}
