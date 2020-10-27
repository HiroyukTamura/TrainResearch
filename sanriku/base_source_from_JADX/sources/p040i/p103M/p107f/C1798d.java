package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1752D;
import p040i.C1760K;
import p040i.C1912a;
import p040i.C1943t;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1811m;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1821g;
import p040i.p103M.p110i.C1833a;
import p040i.p103M.p110i.C1834b;
import p040i.p103M.p110i.C1872o;

/* renamed from: i.M.f.d */
public final class C1798d {

    /* renamed from: a */
    private C1811m.C1812a f2342a;

    /* renamed from: b */
    private C1811m f2343b;

    /* renamed from: c */
    private C1806i f2344c;

    /* renamed from: d */
    private int f2345d;

    /* renamed from: e */
    private int f2346e;

    /* renamed from: f */
    private int f2347f;

    /* renamed from: g */
    private C1760K f2348g;

    /* renamed from: h */
    private final C1807j f2349h;

    /* renamed from: i */
    private final C1912a f2350i;

    /* renamed from: j */
    private final C1799e f2351j;

    /* renamed from: k */
    private final C1943t f2352k;

    public C1798d(C1807j jVar, C1912a aVar, C1799e eVar, C1943t tVar) {
        Intrinsics.checkParameterIsNotNull(jVar, "connectionPool");
        Intrinsics.checkParameterIsNotNull(aVar, "address");
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(tVar, "eventListener");
        this.f2349h = jVar;
        this.f2350i = aVar;
        this.f2351j = eVar;
        this.f2352k = tVar;
    }

    /* renamed from: a */
    private final C1806i m2774a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket socket;
        Socket h;
        C1806i iVar;
        boolean z2;
        C1760K k;
        boolean z3;
        List<C1760K> list;
        C1811m.C1812a aVar;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.f2349h) {
            if (!this.f2351j.isCanceled()) {
                T b = this.f2351j.mo27717b();
                objectRef.element = b;
                socket = null;
                h = (b == null || (!b.mo27755e() && mo27706a(b.mo27762l().mo27588a().mo28020k()))) ? null : this.f2351j.mo27726h();
                if (this.f2351j.mo27717b() != null) {
                    iVar = this.f2351j.mo27717b();
                    objectRef.element = null;
                } else {
                    iVar = null;
                }
                if (iVar == null) {
                    this.f2345d = 0;
                    this.f2346e = 0;
                    this.f2347f = 0;
                    if (this.f2349h.mo27767a(this.f2350i, this.f2351j, (List<C1760K>) null, false)) {
                        iVar = this.f2351j.mo27717b();
                        k = null;
                        z2 = true;
                        Unit unit = Unit.INSTANCE;
                    } else if (this.f2348g != null) {
                        k = this.f2348g;
                        this.f2348g = null;
                        z2 = false;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                k = null;
                z2 = false;
                Unit unit22 = Unit.INSTANCE;
            } else {
                throw new IOException("Canceled");
            }
        }
        if (h != null) {
            C1764b.m2630a(h);
        }
        C1806i iVar2 = (C1806i) objectRef.element;
        if (iVar2 != null) {
            C1943t tVar = this.f2352k;
            C1799e eVar = this.f2351j;
            if (iVar2 == null) {
                Intrinsics.throwNpe();
            }
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(iVar2, "connection");
            } else {
                throw null;
            }
        }
        if (z2) {
            C1943t tVar2 = this.f2352k;
            C1799e eVar2 = this.f2351j;
            if (iVar == null) {
                Intrinsics.throwNpe();
            }
            tVar2.mo28101a(eVar2, iVar);
        }
        if (iVar != null) {
            return iVar;
        }
        if (k != null || ((aVar = this.f2342a) != null && aVar.mo27778b())) {
            z3 = false;
        } else {
            C1811m mVar = this.f2343b;
            if (mVar == null) {
                mVar = new C1811m(this.f2350i, this.f2351j.mo27709a().mo27484o(), this.f2351j, this.f2352k);
                this.f2343b = mVar;
            }
            this.f2342a = mVar.mo27776b();
            z3 = true;
        }
        synchronized (this.f2349h) {
            if (!this.f2351j.isCanceled()) {
                if (z3) {
                    C1811m.C1812a aVar2 = this.f2342a;
                    if (aVar2 == null) {
                        Intrinsics.throwNpe();
                    }
                    list = aVar2.mo27777a();
                    if (this.f2349h.mo27767a(this.f2350i, this.f2351j, list, false)) {
                        iVar = this.f2351j.mo27717b();
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (k == null) {
                        C1811m.C1812a aVar3 = this.f2342a;
                        if (aVar3 == null) {
                            Intrinsics.throwNpe();
                        }
                        k = aVar3.mo27779c();
                    }
                    C1807j jVar = this.f2349h;
                    if (k == null) {
                        Intrinsics.throwNpe();
                    }
                    iVar = new C1806i(jVar, k);
                    this.f2344c = iVar;
                }
                Unit unit3 = Unit.INSTANCE;
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            C1943t tVar3 = this.f2352k;
            C1799e eVar3 = this.f2351j;
            if (iVar == null) {
                Intrinsics.throwNpe();
            }
            tVar3.mo28101a(eVar3, iVar);
            if (iVar == null) {
                Intrinsics.throwNpe();
            }
            return iVar;
        }
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        iVar.mo27743a(i, i2, i3, i4, z, this.f2351j, this.f2352k);
        this.f2351j.mo27709a().mo27484o().mo27769a(iVar.mo27762l());
        synchronized (this.f2349h) {
            this.f2344c = null;
            if (this.f2349h.mo27767a(this.f2350i, this.f2351j, list, true)) {
                iVar.mo27752b(true);
                socket = iVar.mo27763m();
                iVar = this.f2351j.mo27717b();
                this.f2348g = k;
            } else {
                this.f2349h.mo27768b(iVar);
                this.f2351j.mo27714a(iVar);
            }
            Unit unit4 = Unit.INSTANCE;
        }
        if (socket != null) {
            C1764b.m2630a(socket);
        }
        C1943t tVar4 = this.f2352k;
        C1799e eVar4 = this.f2351j;
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        tVar4.mo28101a(eVar4, iVar);
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        return iVar;
    }

    /* renamed from: a */
    private final C1806i m2775a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            C1806i a = m2774a(i, i2, i3, i4, z);
            if (a.mo27750a(z2)) {
                return a;
            }
            a.mo27761k();
            synchronized (this.f2349h) {
                if (this.f2348g == null) {
                    C1811m.C1812a aVar = this.f2342a;
                    boolean z3 = true;
                    if (!(aVar != null ? aVar.mo27778b() : true)) {
                        C1811m mVar = this.f2343b;
                        if (mVar != null) {
                            z3 = mVar.mo27775a();
                        }
                        if (!z3) {
                            throw new IOException("exhausted all routes");
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: a */
    public final C1806i mo27703a() {
        C1807j jVar = this.f2349h;
        if (!C1764b.f2219g || Thread.holdsLock(jVar)) {
            return this.f2344c;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public final C1818d mo27704a(C1752D d, C1821g gVar) {
        Intrinsics.checkParameterIsNotNull(d, "client");
        Intrinsics.checkParameterIsNotNull(gVar, "chain");
        try {
            return m2775a(gVar.mo27791c(), gVar.mo27793e(), gVar.mo27795g(), d.mo27489t(), d.mo27495z(), !Intrinsics.areEqual((Object) gVar.mo27794f().mo27541f(), (Object) "GET")).mo27741a(d, gVar);
        } catch (C1810l e) {
            mo27705a(e.mo27774b());
            throw e;
        } catch (IOException e2) {
            mo27705a(e2);
            throw new C1810l(e2);
        }
    }

    /* renamed from: a */
    public final void mo27705a(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        C1807j jVar = this.f2349h;
        if (!C1764b.f2219g || !Thread.holdsLock(jVar)) {
            synchronized (this.f2349h) {
                this.f2348g = null;
                if ((iOException instanceof C1872o) && ((C1872o) iOException).f2649a == C1834b.REFUSED_STREAM) {
                    this.f2345d++;
                } else if (iOException instanceof C1833a) {
                    this.f2346e++;
                } else {
                    this.f2347f++;
                }
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public final boolean mo27706a(C1955z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
        C1955z k = this.f2350i.mo28020k();
        return zVar.mo28143j() == k.mo28143j() && Intrinsics.areEqual((Object) zVar.mo28138f(), (Object) k.mo28138f());
    }

    /* renamed from: b */
    public final C1912a mo27707b() {
        return this.f2350i;
    }

    /* renamed from: c */
    public final boolean mo27708c() {
        synchronized (this.f2349h) {
            boolean z = false;
            if (this.f2345d == 0 && this.f2346e == 0 && this.f2347f == 0) {
                return false;
            }
            if (this.f2348g != null) {
                return true;
            }
            if (this.f2345d <= 1 && this.f2346e <= 1) {
                if (this.f2347f <= 0) {
                    C1806i b = this.f2351j.mo27717b();
                    if (b != null && b.mo27756f() == 0 && C1764b.m2631a(b.mo27762l().mo27588a().mo28020k(), this.f2350i.mo28020k())) {
                        z = true;
                    }
                }
            }
            if (z) {
                C1806i b2 = this.f2351j.mo27717b();
                if (b2 == null) {
                    Intrinsics.throwNpe();
                }
                this.f2348g = b2.mo27762l();
                return true;
            }
            C1811m.C1812a aVar = this.f2342a;
            if (aVar != null && aVar.mo27778b()) {
                return true;
            }
            C1811m mVar = this.f2343b;
            if (mVar == null) {
                return true;
            }
            boolean a = mVar.mo27775a();
            return a;
        }
    }
}
