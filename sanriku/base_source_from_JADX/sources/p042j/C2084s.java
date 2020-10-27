package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: j.s */
public final class C2084s implements C2071g {
    @JvmField

    /* renamed from: a */
    public final C2068f f2917a = new C2068f();
    @JvmField

    /* renamed from: b */
    public boolean f2918b;
    @JvmField

    /* renamed from: c */
    public final C2090x f2919c;

    public C2084s(C2090x xVar) {
        Intrinsics.checkParameterIsNotNull(xVar, "sink");
        this.f2919c = xVar;
    }

    /* renamed from: a */
    public long mo29135a(C1016z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, FirebaseAnalytics.Param.SOURCE);
        long j = 0;
        while (true) {
            long read = zVar.read(this.f2917a, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            mo29158f();
        }
    }

    /* renamed from: a */
    public C2071g mo29137a(C2073i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "byteString");
        if (!this.f2918b) {
            this.f2917a.mo29137a(iVar);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: a */
    public C2071g mo29138a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (!this.f2918b) {
            this.f2917a.mo29138a(str);
            return mo29158f();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        if (!this.f2918b) {
            this.f2917a.mo27647a(fVar, j);
            mo29158f();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: c */
    public C2071g mo29151c(long j) {
        if (!this.f2918b) {
            this.f2917a.mo29151c(j);
            return mo29158f();
        }
        throw new IllegalStateException("closed".toString());
    }

    public void close() {
        if (!this.f2918b) {
            Throwable th = null;
            try {
                if (this.f2917a.size() > 0) {
                    this.f2919c.mo27647a(this.f2917a, this.f2917a.size());
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f2919c.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f2918b = true;
            if (th != null) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    public C2071g mo29158f() {
        if (!this.f2918b) {
            long h = this.f2917a.mo29164h();
            if (h > 0) {
                this.f2919c.mo27647a(this.f2917a, h);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void flush() {
        if (!this.f2918b) {
            if (this.f2917a.size() > 0) {
                C2090x xVar = this.f2919c;
                C2068f fVar = this.f2917a;
                xVar.mo27647a(fVar, fVar.size());
            }
            this.f2919c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: g */
    public C2071g mo29161g(long j) {
        if (!this.f2918b) {
            this.f2917a.mo29161g(j);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2068f getBuffer() {
        return this.f2917a;
    }

    public boolean isOpen() {
        return !this.f2918b;
    }

    public C2057A timeout() {
        return this.f2919c.timeout();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("buffer(");
        a.append(this.f2919c);
        a.append(')');
        return a.toString();
    }

    public int write(ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, FirebaseAnalytics.Param.SOURCE);
        if (!this.f2918b) {
            int write = this.f2917a.write(byteBuffer);
            mo29158f();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2071g write(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.SOURCE);
        if (!this.f2918b) {
            this.f2917a.write(bArr);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2071g write(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.SOURCE);
        if (!this.f2918b) {
            this.f2917a.write(bArr, i, i2);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2071g writeByte(int i) {
        if (!this.f2918b) {
            this.f2917a.writeByte(i);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2071g writeInt(int i) {
        if (!this.f2918b) {
            this.f2917a.writeInt(i);
            return mo29158f();
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2071g writeShort(int i) {
        if (!this.f2918b) {
            this.f2917a.writeShort(i);
            mo29158f();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
