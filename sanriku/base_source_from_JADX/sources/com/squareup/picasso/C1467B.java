package com.squareup.picasso;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.B */
class C1467B {

    /* renamed from: a */
    final HandlerThread f1537a;

    /* renamed from: b */
    final C1488d f1538b;

    /* renamed from: c */
    final Handler f1539c = new C1468a(this.f1537a.getLooper(), this);

    /* renamed from: d */
    long f1540d;

    /* renamed from: e */
    long f1541e;

    /* renamed from: f */
    long f1542f;

    /* renamed from: g */
    long f1543g;

    /* renamed from: h */
    long f1544h;

    /* renamed from: i */
    long f1545i;

    /* renamed from: j */
    long f1546j;

    /* renamed from: k */
    long f1547k;

    /* renamed from: l */
    int f1548l;

    /* renamed from: m */
    int f1549m;

    /* renamed from: n */
    int f1550n;

    /* renamed from: com.squareup.picasso.B$a */
    private static class C1468a extends Handler {

        /* renamed from: a */
        private final C1467B f1551a;

        /* renamed from: com.squareup.picasso.B$a$a */
        class C1469a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Message f1552a;

            C1469a(C1468a aVar, Message message) {
                this.f1552a = message;
            }

            public void run() {
                StringBuilder a = C0681a.m330a("Unhandled stats message.");
                a.append(this.f1552a.what);
                throw new AssertionError(a.toString());
            }
        }

        C1468a(Looper looper, C1467B b) {
            super(looper);
            this.f1551a = b;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f1551a.f1540d++;
            } else if (i == 1) {
                this.f1551a.f1541e++;
            } else if (i == 2) {
                C1467B b = this.f1551a;
                long j = (long) message.arg1;
                int i2 = b.f1549m + 1;
                b.f1549m = i2;
                long j2 = b.f1543g + j;
                b.f1543g = j2;
                b.f1546j = j2 / ((long) i2);
            } else if (i == 3) {
                C1467B b2 = this.f1551a;
                long j3 = (long) message.arg1;
                b2.f1550n++;
                long j4 = b2.f1544h + j3;
                b2.f1544h = j4;
                b2.f1547k = j4 / ((long) b2.f1549m);
            } else if (i != 4) {
                C1513u.f1671p.post(new C1469a(this, message));
            } else {
                C1467B b3 = this.f1551a;
                b3.f1548l++;
                long longValue = ((Long) message.obj).longValue() + b3.f1542f;
                b3.f1542f = longValue;
                b3.f1545i = longValue / ((long) b3.f1548l);
            }
        }
    }

    C1467B(C1488d dVar) {
        this.f1538b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f1537a = handlerThread;
        handlerThread.start();
        C1474G.m2010a(this.f1537a.getLooper());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1470C mo27175a() {
        return new C1470C(this.f1538b.mo27207a(), this.f1538b.size(), this.f1540d, this.f1541e, this.f1542f, this.f1543g, this.f1544h, this.f1545i, this.f1546j, this.f1547k, this.f1548l, this.f1549m, this.f1550n, System.currentTimeMillis());
    }
}
