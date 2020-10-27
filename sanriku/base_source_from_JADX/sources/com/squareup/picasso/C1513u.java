package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.squareup.picasso.C1478a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.u */
public class C1513u {

    /* renamed from: p */
    static final Handler f1671p = new C1514a(Looper.getMainLooper());
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: q */
    static volatile C1513u f1672q = null;

    /* renamed from: a */
    private final C1518d f1673a;

    /* renamed from: b */
    private final C1521g f1674b;

    /* renamed from: c */
    private final C1516c f1675c;

    /* renamed from: d */
    private final List<C1530z> f1676d;

    /* renamed from: e */
    final Context f1677e;

    /* renamed from: f */
    final C1493i f1678f;

    /* renamed from: g */
    final C1488d f1679g;

    /* renamed from: h */
    final C1467B f1680h;

    /* renamed from: i */
    final Map<Object, C1478a> f1681i;

    /* renamed from: j */
    final Map<ImageView, C1492h> f1682j;

    /* renamed from: k */
    final ReferenceQueue<Object> f1683k;

    /* renamed from: l */
    final Bitmap.Config f1684l;

    /* renamed from: m */
    boolean f1685m;

    /* renamed from: n */
    volatile boolean f1686n;

    /* renamed from: o */
    boolean f1687o;

    /* renamed from: com.squareup.picasso.u$a */
    static class C1514a extends Handler {
        C1514a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i2 < size) {
                        C1481c cVar = (C1481c) list.get(i2);
                        cVar.f1592b.mo27248a(cVar);
                        i2++;
                    }
                } else if (i == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i2 < size2) {
                        C1478a aVar = (C1478a) list2.get(i2);
                        aVar.f1571a.mo27252b(aVar);
                        i2++;
                    }
                } else {
                    StringBuilder a = C0681a.m330a("Unknown handler message received: ");
                    a.append(message.what);
                    throw new AssertionError(a.toString());
                }
            } else {
                C1478a aVar2 = (C1478a) message.obj;
                if (aVar2.f1571a.f1686n) {
                    C1474G.m2011a("Main", "canceled", aVar2.f1572b.mo27266b(), "target got garbage collected");
                }
                aVar2.f1571a.mo27249a(aVar2.mo27197b());
            }
        }
    }

    /* renamed from: com.squareup.picasso.u$b */
    public static class C1515b {

        /* renamed from: a */
        private final Context f1688a;

        /* renamed from: b */
        private C1498j f1689b;

        /* renamed from: c */
        private ExecutorService f1690c;

        /* renamed from: d */
        private C1488d f1691d;

        /* renamed from: e */
        private C1521g f1692e;

        public C1515b(@NonNull Context context) {
            if (context != null) {
                this.f1688a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C1513u mo27255a() {
            Context context = this.f1688a;
            if (this.f1689b == null) {
                this.f1689b = new C1512t(context);
            }
            if (this.f1691d == null) {
                this.f1691d = new C1502n(context);
            }
            if (this.f1690c == null) {
                this.f1690c = new C1524w();
            }
            if (this.f1692e == null) {
                this.f1692e = C1521g.f1703a;
            }
            C1467B b = new C1467B(this.f1691d);
            Context context2 = context;
            return new C1513u(context2, new C1493i(context2, this.f1690c, C1513u.f1671p, this.f1689b, this.f1691d, b), this.f1691d, (C1518d) null, this.f1692e, (List<C1530z>) null, b, (Bitmap.Config) null, false, false);
        }
    }

    /* renamed from: com.squareup.picasso.u$c */
    private static class C1516c extends Thread {

        /* renamed from: a */
        private final ReferenceQueue<Object> f1693a;

        /* renamed from: b */
        private final Handler f1694b;

        /* renamed from: com.squareup.picasso.u$c$a */
        class C1517a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Exception f1695a;

            C1517a(C1516c cVar, Exception exc) {
                this.f1695a = exc;
            }

            public void run() {
                throw new RuntimeException(this.f1695a);
            }
        }

        C1516c(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f1693a = referenceQueue;
            this.f1694b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C1478a.C1479a aVar = (C1478a.C1479a) this.f1693a.remove(1000);
                    Message obtainMessage = this.f1694b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f1583a;
                        this.f1694b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f1694b.post(new C1517a(this, e));
                    return;
                }
            }
        }
    }

    /* renamed from: com.squareup.picasso.u$d */
    public interface C1518d {
        /* renamed from: a */
        void mo27258a(C1513u uVar, Uri uri, Exception exc);
    }

    /* renamed from: com.squareup.picasso.u$e */
    public enum C1519e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        

        /* renamed from: a */
        final int f1699a;

        static {
            MEMORY = new C1519e("MEMORY", 0, -16711936);
            DISK = new C1519e("DISK", 1, -16776961);
            NETWORK = new C1519e("NETWORK", 2, SupportMenu.CATEGORY_MASK);
        }

        private C1519e(int i) {
            this.f1699a = i;
        }
    }

    /* renamed from: com.squareup.picasso.u$f */
    public enum C1520f {
        LOW,
        NORMAL,
        HIGH;

        static {
            LOW = new C1520f("LOW", 0);
            NORMAL = new C1520f("NORMAL", 1);
            HIGH = new C1520f("HIGH", 2);
        }
    }

    /* renamed from: com.squareup.picasso.u$g */
    public interface C1521g {

        /* renamed from: a */
        public static final C1521g f1703a = new C1522a();

        /* renamed from: com.squareup.picasso.u$g$a */
        static class C1522a implements C1521g {
            C1522a() {
            }
        }
    }

    C1513u(Context context, C1493i iVar, C1488d dVar, C1518d dVar2, C1521g gVar, List<C1530z> list, C1467B b, Bitmap.Config config, boolean z, boolean z2) {
        this.f1677e = context;
        this.f1678f = iVar;
        this.f1679g = dVar;
        this.f1673a = dVar2;
        this.f1674b = gVar;
        this.f1684l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C1466A(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C1490f(context));
        arrayList.add(new C1505p(context));
        arrayList.add(new C1491g(context));
        arrayList.add(new C1480b(context));
        arrayList.add(new C1499k(context));
        arrayList.add(new C1509s(iVar.f1624d, b));
        this.f1676d = Collections.unmodifiableList(arrayList);
        this.f1680h = b;
        this.f1681i = new WeakHashMap();
        this.f1682j = new WeakHashMap();
        this.f1685m = z;
        this.f1686n = z2;
        this.f1683k = new ReferenceQueue<>();
        C1516c cVar = new C1516c(this.f1683k, f1671p);
        this.f1675c = cVar;
        cVar.start();
    }

    /* renamed from: b */
    public static C1513u m2068b() {
        if (f1672q == null) {
            synchronized (C1513u.class) {
                if (f1672q == null) {
                    if (PicassoProvider.f1570a != null) {
                        f1672q = new C1515b(PicassoProvider.f1570a).mo27255a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f1672q;
    }

    /* renamed from: a */
    public C1529y mo27244a(@DrawableRes int i) {
        if (i != 0) {
            return new C1529y(this, (Uri) null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    /* renamed from: a */
    public C1529y mo27245a(@Nullable Uri uri) {
        return new C1529y(this, uri, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C1530z> mo27246a() {
        return this.f1676d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27249a(Object obj) {
        C1492h remove;
        C1474G.m2009a();
        C1478a remove2 = this.f1681i.remove(obj);
        if (remove2 != null) {
            remove2.mo27196a();
            Handler handler = this.f1678f.f1629i;
            handler.sendMessage(handler.obtainMessage(2, remove2));
        }
        if ((obj instanceof ImageView) && (remove = this.f1682j.remove((ImageView) obj)) != null) {
            remove.mo27214a();
        }
    }

    /* renamed from: b */
    public C1529y mo27251b(@Nullable String str) {
        if (str == null) {
            return new C1529y(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return mo27245a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo27252b(C1478a aVar) {
        Bitmap c = C1507q.m2061a(aVar.f1575e) ? mo27253c(aVar.f1579i) : null;
        if (c != null) {
            m2067a(c, C1519e.MEMORY, aVar, (Exception) null);
            if (this.f1686n) {
                String b = aVar.f1572b.mo27266b();
                StringBuilder a = C0681a.m330a("from ");
                a.append(C1519e.MEMORY);
                C1474G.m2011a("Main", "completed", b, a.toString());
                return;
            }
            return;
        }
        mo27247a(aVar);
        if (this.f1686n) {
            C1474G.m2011a("Main", "resumed", aVar.f1572b.mo27266b(), "");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Bitmap mo27253c(String str) {
        Bitmap bitmap = this.f1679g.get(str);
        C1467B b = this.f1680h;
        if (bitmap != null) {
            b.f1539c.sendEmptyMessage(0);
        } else {
            b.f1539c.sendEmptyMessage(1);
        }
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27248a(C1481c cVar) {
        C1478a aVar = cVar.f1601m;
        List<C1478a> list = cVar.f1602n;
        boolean z = true;
        boolean z2 = list != null && !list.isEmpty();
        if (aVar == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.f1597g.f1717d;
            Exception exc = cVar.f1606r;
            Bitmap bitmap = cVar.f1603o;
            C1519e eVar = cVar.f1605q;
            if (aVar != null) {
                m2067a(bitmap, eVar, aVar, exc);
            }
            if (z2) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    m2067a(bitmap, eVar, list.get(i), exc);
                }
            }
            C1518d dVar = this.f1673a;
            if (dVar != null && exc != null) {
                dVar.mo27258a(this, uri, exc);
            }
        }
    }

    /* renamed from: a */
    private void m2067a(Bitmap bitmap, C1519e eVar, C1478a aVar, Exception exc) {
        String str;
        String str2;
        String str3;
        if (!aVar.f1582l) {
            if (!aVar.f1581k) {
                this.f1681i.remove(aVar.mo27197b());
            }
            if (bitmap == null) {
                aVar.mo27184a(exc);
                if (this.f1686n) {
                    str3 = aVar.f1572b.mo27266b();
                    str2 = exc.getMessage();
                    str = "errored";
                } else {
                    return;
                }
            } else if (eVar != null) {
                aVar.mo27183a(bitmap, eVar);
                if (this.f1686n) {
                    str3 = aVar.f1572b.mo27266b();
                    str2 = "from " + eVar;
                    str = "completed";
                } else {
                    return;
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
            C1474G.m2011a("Main", str, str3, str2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27247a(C1478a aVar) {
        Object b = aVar.mo27197b();
        if (!(b == null || this.f1681i.get(b) == aVar)) {
            mo27249a(b);
            this.f1681i.put(b, aVar);
        }
        Handler handler = this.f1678f.f1629i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* renamed from: a */
    public void mo27250a(@Nullable String str) {
        Uri parse;
        if (str != null && (parse = Uri.parse(str)) != null) {
            this.f1679g.mo27208a(parse.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1526x mo27243a(C1526x xVar) {
        if (((C1521g.C1522a) this.f1674b) == null) {
            throw null;
        } else if (xVar != null) {
            return xVar;
        } else {
            StringBuilder a = C0681a.m330a("Request transformer ");
            a.append(this.f1674b.getClass().getCanonicalName());
            a.append(" returned null for ");
            a.append(xVar);
            throw new IllegalStateException(a.toString());
        }
    }
}
