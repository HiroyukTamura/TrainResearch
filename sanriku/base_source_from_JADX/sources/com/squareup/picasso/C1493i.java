package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.C1513u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.i */
class C1493i {

    /* renamed from: a */
    final C1496b f1621a;

    /* renamed from: b */
    final Context f1622b;

    /* renamed from: c */
    final ExecutorService f1623c;

    /* renamed from: d */
    final C1498j f1624d;

    /* renamed from: e */
    final Map<String, C1481c> f1625e = new LinkedHashMap();

    /* renamed from: f */
    final Map<Object, C1478a> f1626f = new WeakHashMap();

    /* renamed from: g */
    final Map<Object, C1478a> f1627g = new WeakHashMap();

    /* renamed from: h */
    final Set<Object> f1628h = new LinkedHashSet();

    /* renamed from: i */
    final Handler f1629i = new C1494a(this.f1621a.getLooper(), this);

    /* renamed from: j */
    final Handler f1630j;

    /* renamed from: k */
    final C1488d f1631k;

    /* renamed from: l */
    final C1467B f1632l;

    /* renamed from: m */
    final List<C1481c> f1633m;

    /* renamed from: n */
    final C1497c f1634n;

    /* renamed from: o */
    final boolean f1635o;

    /* renamed from: p */
    boolean f1636p;

    /* renamed from: com.squareup.picasso.i$a */
    private static class C1494a extends Handler {

        /* renamed from: a */
        private final C1493i f1637a;

        /* renamed from: com.squareup.picasso.i$a$a */
        class C1495a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Message f1638a;

            C1495a(C1494a aVar, Message message) {
                this.f1638a = message;
            }

            public void run() {
                StringBuilder a = C0681a.m330a("Unknown handler message received: ");
                a.append(this.f1638a.what);
                throw new AssertionError(a.toString());
            }
        }

        C1494a(Looper looper, C1493i iVar) {
            super(looper);
            this.f1637a = iVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: java.util.ArrayList} */
        /* JADX WARNING: type inference failed for: r6v40, types: [java.util.List] */
        /* JADX WARNING: type inference failed for: r6v44 */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0034, code lost:
            r6 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x017a, code lost:
            if (r7 != 12) goto L_0x0180;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                int r2 = r1.what
                java.lang.String r3 = "canceled"
                java.lang.String r4 = ""
                java.lang.String r5 = "Dispatcher"
                r6 = 0
                switch(r2) {
                    case 1: goto L_0x037e;
                    case 2: goto L_0x0308;
                    case 3: goto L_0x0010;
                    case 4: goto L_0x02fd;
                    case 5: goto L_0x0237;
                    case 6: goto L_0x022b;
                    case 7: goto L_0x01c7;
                    case 8: goto L_0x0010;
                    case 9: goto L_0x0144;
                    case 10: goto L_0x0136;
                    case 11: goto L_0x0066;
                    case 12: goto L_0x001c;
                    default: goto L_0x0010;
                }
            L_0x0010:
                android.os.Handler r2 = com.squareup.picasso.C1513u.f1671p
                com.squareup.picasso.i$a$a r3 = new com.squareup.picasso.i$a$a
                r3.<init>(r0, r1)
                r2.post(r3)
                goto L_0x0388
            L_0x001c:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.i r2 = r0.f1637a
                java.util.Set<java.lang.Object> r3 = r2.f1628h
                boolean r3 = r3.remove(r1)
                if (r3 != 0) goto L_0x002a
                goto L_0x0388
            L_0x002a:
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r3 = r2.f1627g
                java.util.Collection r3 = r3.values()
                java.util.Iterator r3 = r3.iterator()
            L_0x0034:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0057
                java.lang.Object r4 = r3.next()
                com.squareup.picasso.a r4 = (com.squareup.picasso.C1478a) r4
                java.lang.Object r5 = r4.f1580j
                boolean r5 = r5.equals(r1)
                if (r5 == 0) goto L_0x0034
                if (r6 != 0) goto L_0x0050
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                r6 = r5
            L_0x0050:
                r6.add(r4)
                r3.remove()
                goto L_0x0034
            L_0x0057:
                if (r6 == 0) goto L_0x0388
                android.os.Handler r1 = r2.f1630j
                r2 = 13
                android.os.Message r2 = r1.obtainMessage(r2, r6)
                r1.sendMessage(r2)
                goto L_0x0388
            L_0x0066:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.i r2 = r0.f1637a
                java.util.Set<java.lang.Object> r4 = r2.f1628h
                boolean r4 = r4.add(r1)
                if (r4 != 0) goto L_0x0074
                goto L_0x0388
            L_0x0074:
                java.util.Map<java.lang.String, com.squareup.picasso.c> r4 = r2.f1625e
                java.util.Collection r4 = r4.values()
                java.util.Iterator r4 = r4.iterator()
            L_0x007e:
                boolean r6 = r4.hasNext()
                if (r6 == 0) goto L_0x0388
                java.lang.Object r6 = r4.next()
                com.squareup.picasso.c r6 = (com.squareup.picasso.C1481c) r6
                com.squareup.picasso.u r9 = r6.f1592b
                boolean r9 = r9.f1686n
                com.squareup.picasso.a r10 = r6.f1601m
                java.util.List<com.squareup.picasso.a> r11 = r6.f1602n
                if (r11 == 0) goto L_0x009c
                boolean r12 = r11.isEmpty()
                if (r12 != 0) goto L_0x009c
                r12 = 1
                goto L_0x009d
            L_0x009c:
                r12 = 0
            L_0x009d:
                if (r10 != 0) goto L_0x00a2
                if (r12 != 0) goto L_0x00a2
                goto L_0x007e
            L_0x00a2:
                java.lang.String r13 = "' was paused"
                java.lang.String r14 = "because tag '"
                java.lang.String r15 = "paused"
                if (r10 == 0) goto L_0x00db
                java.lang.Object r7 = r10.f1580j
                boolean r7 = r7.equals(r1)
                if (r7 == 0) goto L_0x00db
                r6.mo27198a((com.squareup.picasso.C1478a) r10)
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r7 = r2.f1627g
                java.lang.Object r8 = r10.mo27197b()
                r7.put(r8, r10)
                if (r9 == 0) goto L_0x00db
                com.squareup.picasso.x r7 = r10.f1572b
                java.lang.String r7 = r7.mo27266b()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r14)
                r8.append(r1)
                r8.append(r13)
                java.lang.String r8 = r8.toString()
                com.squareup.picasso.C1474G.m2011a(r5, r15, r7, r8)
            L_0x00db:
                if (r12 == 0) goto L_0x0120
                int r7 = r11.size()
                r8 = 1
                int r7 = r7 - r8
            L_0x00e3:
                if (r7 < 0) goto L_0x0120
                java.lang.Object r8 = r11.get(r7)
                com.squareup.picasso.a r8 = (com.squareup.picasso.C1478a) r8
                java.lang.Object r10 = r8.f1580j
                boolean r10 = r10.equals(r1)
                if (r10 != 0) goto L_0x00f4
                goto L_0x011d
            L_0x00f4:
                r6.mo27198a((com.squareup.picasso.C1478a) r8)
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r10 = r2.f1627g
                java.lang.Object r12 = r8.mo27197b()
                r10.put(r12, r8)
                if (r9 == 0) goto L_0x011d
                com.squareup.picasso.x r8 = r8.f1572b
                java.lang.String r8 = r8.mo27266b()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r14)
                r10.append(r1)
                r10.append(r13)
                java.lang.String r10 = r10.toString()
                com.squareup.picasso.C1474G.m2011a(r5, r15, r8, r10)
            L_0x011d:
                int r7 = r7 + -1
                goto L_0x00e3
            L_0x0120:
                boolean r7 = r6.mo27199a()
                if (r7 == 0) goto L_0x007e
                r4.remove()
                if (r9 == 0) goto L_0x007e
                java.lang.String r6 = com.squareup.picasso.C1474G.m2006a((com.squareup.picasso.C1481c) r6)
                java.lang.String r7 = "all actions paused"
                com.squareup.picasso.C1474G.m2011a(r5, r3, r6, r7)
                goto L_0x007e
            L_0x0136:
                com.squareup.picasso.i r2 = r0.f1637a
                int r1 = r1.arg1
                r3 = 1
                if (r1 != r3) goto L_0x013f
                r7 = 1
                goto L_0x0140
            L_0x013f:
                r7 = 0
            L_0x0140:
                r2.f1636p = r7
                goto L_0x0388
            L_0x0144:
                java.lang.Object r1 = r1.obj
                android.net.NetworkInfo r1 = (android.net.NetworkInfo) r1
                com.squareup.picasso.i r2 = r0.f1637a
                java.util.concurrent.ExecutorService r3 = r2.f1623c
                boolean r7 = r3 instanceof com.squareup.picasso.C1524w
                if (r7 == 0) goto L_0x0188
                com.squareup.picasso.w r3 = (com.squareup.picasso.C1524w) r3
                if (r3 == 0) goto L_0x0187
                r6 = 3
                if (r1 == 0) goto L_0x0180
                boolean r7 = r1.isConnectedOrConnecting()
                if (r7 != 0) goto L_0x015e
                goto L_0x0180
            L_0x015e:
                int r7 = r1.getType()
                if (r7 == 0) goto L_0x0171
                r8 = 1
                if (r7 == r8) goto L_0x016f
                r8 = 6
                if (r7 == r8) goto L_0x016f
                r8 = 9
                if (r7 == r8) goto L_0x016f
                goto L_0x0180
            L_0x016f:
                r6 = 4
                goto L_0x0180
            L_0x0171:
                int r7 = r1.getSubtype()
                switch(r7) {
                    case 1: goto L_0x017d;
                    case 2: goto L_0x017d;
                    case 3: goto L_0x017f;
                    case 4: goto L_0x017f;
                    case 5: goto L_0x017f;
                    case 6: goto L_0x017f;
                    default: goto L_0x0178;
                }
            L_0x0178:
                r8 = 12
                if (r7 == r8) goto L_0x017f
                goto L_0x0180
            L_0x017d:
                r6 = 1
                goto L_0x0180
            L_0x017f:
                r6 = 2
            L_0x0180:
                r3.setCorePoolSize(r6)
                r3.setMaximumPoolSize(r6)
                goto L_0x0188
            L_0x0187:
                throw r6
            L_0x0188:
                if (r1 == 0) goto L_0x0388
                boolean r1 = r1.isConnected()
                if (r1 == 0) goto L_0x0388
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r1 = r2.f1626f
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x0388
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r1 = r2.f1626f
                java.util.Collection r1 = r1.values()
                java.util.Iterator r1 = r1.iterator()
            L_0x01a2:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0388
                java.lang.Object r3 = r1.next()
                com.squareup.picasso.a r3 = (com.squareup.picasso.C1478a) r3
                r1.remove()
                com.squareup.picasso.u r6 = r3.f1571a
                boolean r6 = r6.f1686n
                if (r6 == 0) goto L_0x01c2
                com.squareup.picasso.x r6 = r3.f1572b
                java.lang.String r6 = r6.mo27266b()
                java.lang.String r7 = "replaying"
                com.squareup.picasso.C1474G.m2011a(r5, r7, r6, r4)
            L_0x01c2:
                r6 = 0
                r2.mo27218a((com.squareup.picasso.C1478a) r3, (boolean) r6)
                goto L_0x01a2
            L_0x01c7:
                com.squareup.picasso.i r1 = r0.f1637a
                if (r1 == 0) goto L_0x022a
                java.util.ArrayList r2 = new java.util.ArrayList
                java.util.List<com.squareup.picasso.c> r3 = r1.f1633m
                r2.<init>(r3)
                java.util.List<com.squareup.picasso.c> r3 = r1.f1633m
                r3.clear()
                android.os.Handler r1 = r1.f1630j
                r3 = 8
                android.os.Message r3 = r1.obtainMessage(r3, r2)
                r1.sendMessage(r3)
                boolean r1 = r2.isEmpty()
                if (r1 == 0) goto L_0x01ea
                goto L_0x0388
            L_0x01ea:
                r1 = 0
                java.lang.Object r1 = r2.get(r1)
                com.squareup.picasso.c r1 = (com.squareup.picasso.C1481c) r1
                com.squareup.picasso.u r1 = r1.f1592b
                boolean r1 = r1.f1686n
                if (r1 == 0) goto L_0x0388
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.util.Iterator r2 = r2.iterator()
            L_0x0200:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x021f
                java.lang.Object r3 = r2.next()
                com.squareup.picasso.c r3 = (com.squareup.picasso.C1481c) r3
                int r6 = r1.length()
                if (r6 <= 0) goto L_0x0217
                java.lang.String r6 = ", "
                r1.append(r6)
            L_0x0217:
                java.lang.String r3 = com.squareup.picasso.C1474G.m2006a((com.squareup.picasso.C1481c) r3)
                r1.append(r3)
                goto L_0x0200
            L_0x021f:
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "delivered"
                com.squareup.picasso.C1474G.m2011a(r5, r2, r1, r4)
                goto L_0x0388
            L_0x022a:
                throw r6
            L_0x022b:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.c r1 = (com.squareup.picasso.C1481c) r1
                com.squareup.picasso.i r2 = r0.f1637a
                r3 = 0
                r2.mo27220a((com.squareup.picasso.C1481c) r1, (boolean) r3)
                goto L_0x0388
            L_0x0237:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.c r1 = (com.squareup.picasso.C1481c) r1
                com.squareup.picasso.i r2 = r0.f1637a
                if (r2 == 0) goto L_0x02fc
                java.util.concurrent.Future<?> r3 = r1.f1604p
                if (r3 == 0) goto L_0x024b
                boolean r3 = r3.isCancelled()
                if (r3 == 0) goto L_0x024b
                r3 = 1
                goto L_0x024c
            L_0x024b:
                r3 = 0
            L_0x024c:
                if (r3 == 0) goto L_0x0250
                goto L_0x0388
            L_0x0250:
                java.util.concurrent.ExecutorService r3 = r2.f1623c
                boolean r3 = r3.isShutdown()
                if (r3 == 0) goto L_0x025e
                r3 = 0
                r2.mo27220a((com.squareup.picasso.C1481c) r1, (boolean) r3)
                goto L_0x0388
            L_0x025e:
                r3 = 0
                boolean r7 = r2.f1635o
                if (r7 == 0) goto L_0x0271
                android.content.Context r6 = r2.f1622b
                java.lang.String r7 = "connectivity"
                java.lang.Object r6 = com.squareup.picasso.C1474G.m2004a((android.content.Context) r6, (java.lang.String) r7)
                android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
                android.net.NetworkInfo r6 = r6.getActiveNetworkInfo()
            L_0x0271:
                boolean r7 = r2.f1636p
                int r8 = r1.f1608t
                if (r8 <= 0) goto L_0x0279
                r8 = 1
                goto L_0x027a
            L_0x0279:
                r8 = 0
            L_0x027a:
                if (r8 != 0) goto L_0x027e
                r6 = 0
                goto L_0x028a
            L_0x027e:
                int r8 = r1.f1608t
                r9 = 1
                int r8 = r8 - r9
                r1.f1608t = r8
                com.squareup.picasso.z r8 = r1.f1600l
                boolean r6 = r8.mo27241a((boolean) r7, (android.net.NetworkInfo) r6)
            L_0x028a:
                if (r6 == 0) goto L_0x02b4
                com.squareup.picasso.u r3 = r1.f1592b
                boolean r3 = r3.f1686n
                if (r3 == 0) goto L_0x029b
                java.lang.String r3 = com.squareup.picasso.C1474G.m2006a((com.squareup.picasso.C1481c) r1)
                java.lang.String r6 = "retrying"
                com.squareup.picasso.C1474G.m2011a(r5, r6, r3, r4)
            L_0x029b:
                java.lang.Exception r3 = r1.f1606r
                boolean r3 = r3 instanceof com.squareup.picasso.C1509s.C1510a
                if (r3 == 0) goto L_0x02aa
                int r3 = r1.f1599i
                com.squareup.picasso.r r4 = com.squareup.picasso.C1508r.NO_CACHE
                int r4 = r4.f1664a
                r3 = r3 | r4
                r1.f1599i = r3
            L_0x02aa:
                java.util.concurrent.ExecutorService r2 = r2.f1623c
                java.util.concurrent.Future r2 = r2.submit(r1)
                r1.f1604p = r2
                goto L_0x0388
            L_0x02b4:
                boolean r4 = r2.f1635o
                if (r4 == 0) goto L_0x02c2
                com.squareup.picasso.z r4 = r1.f1600l
                boolean r4 = r4.mo27242b()
                if (r4 == 0) goto L_0x02c2
                r4 = 1
                goto L_0x02c3
            L_0x02c2:
                r4 = 0
            L_0x02c3:
                r2.mo27220a((com.squareup.picasso.C1481c) r1, (boolean) r4)
                if (r4 == 0) goto L_0x0388
                com.squareup.picasso.a r4 = r1.f1601m
                if (r4 == 0) goto L_0x02da
                java.lang.Object r5 = r4.mo27197b()
                if (r5 == 0) goto L_0x02da
                r6 = 1
                r4.f1581k = r6
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r6 = r2.f1626f
                r6.put(r5, r4)
            L_0x02da:
                java.util.List<com.squareup.picasso.a> r1 = r1.f1602n
                if (r1 == 0) goto L_0x0388
                int r4 = r1.size()
                r7 = 0
            L_0x02e3:
                if (r7 >= r4) goto L_0x0388
                java.lang.Object r3 = r1.get(r7)
                com.squareup.picasso.a r3 = (com.squareup.picasso.C1478a) r3
                java.lang.Object r5 = r3.mo27197b()
                if (r5 == 0) goto L_0x02f9
                r6 = 1
                r3.f1581k = r6
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r6 = r2.f1626f
                r6.put(r5, r3)
            L_0x02f9:
                int r7 = r7 + 1
                goto L_0x02e3
            L_0x02fc:
                throw r6
            L_0x02fd:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.c r1 = (com.squareup.picasso.C1481c) r1
                com.squareup.picasso.i r2 = r0.f1637a
                r2.mo27222c(r1)
                goto L_0x0388
            L_0x0308:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.a r1 = (com.squareup.picasso.C1478a) r1
                com.squareup.picasso.i r2 = r0.f1637a
                if (r2 == 0) goto L_0x037d
                java.lang.String r6 = r1.f1579i
                java.util.Map<java.lang.String, com.squareup.picasso.c> r7 = r2.f1625e
                java.lang.Object r7 = r7.get(r6)
                com.squareup.picasso.c r7 = (com.squareup.picasso.C1481c) r7
                if (r7 == 0) goto L_0x0339
                r7.mo27198a((com.squareup.picasso.C1478a) r1)
                boolean r7 = r7.mo27199a()
                if (r7 == 0) goto L_0x0339
                java.util.Map<java.lang.String, com.squareup.picasso.c> r7 = r2.f1625e
                r7.remove(r6)
                com.squareup.picasso.u r6 = r1.f1571a
                boolean r6 = r6.f1686n
                if (r6 == 0) goto L_0x0339
                com.squareup.picasso.x r6 = r1.f1572b
                java.lang.String r6 = r6.mo27266b()
                com.squareup.picasso.C1474G.m2011a(r5, r3, r6, r4)
            L_0x0339:
                java.util.Set<java.lang.Object> r4 = r2.f1628h
                java.lang.Object r6 = r1.f1580j
                boolean r4 = r4.contains(r6)
                if (r4 == 0) goto L_0x035d
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r4 = r2.f1627g
                java.lang.Object r6 = r1.mo27197b()
                r4.remove(r6)
                com.squareup.picasso.u r4 = r1.f1571a
                boolean r4 = r4.f1686n
                if (r4 == 0) goto L_0x035d
                com.squareup.picasso.x r4 = r1.f1572b
                java.lang.String r4 = r4.mo27266b()
                java.lang.String r6 = "because paused request got canceled"
                com.squareup.picasso.C1474G.m2011a(r5, r3, r4, r6)
            L_0x035d:
                java.util.Map<java.lang.Object, com.squareup.picasso.a> r2 = r2.f1626f
                java.lang.Object r1 = r1.mo27197b()
                java.lang.Object r1 = r2.remove(r1)
                com.squareup.picasso.a r1 = (com.squareup.picasso.C1478a) r1
                if (r1 == 0) goto L_0x0388
                com.squareup.picasso.u r2 = r1.f1571a
                boolean r2 = r2.f1686n
                if (r2 == 0) goto L_0x0388
                com.squareup.picasso.x r1 = r1.f1572b
                java.lang.String r1 = r1.mo27266b()
                java.lang.String r2 = "from replaying"
                com.squareup.picasso.C1474G.m2011a(r5, r3, r1, r2)
                goto L_0x0388
            L_0x037d:
                throw r6
            L_0x037e:
                java.lang.Object r1 = r1.obj
                com.squareup.picasso.a r1 = (com.squareup.picasso.C1478a) r1
                com.squareup.picasso.i r2 = r0.f1637a
                r3 = 1
                r2.mo27218a((com.squareup.picasso.C1478a) r1, (boolean) r3)
            L_0x0388:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1493i.C1494a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.squareup.picasso.i$b */
    static class C1496b extends HandlerThread {
        C1496b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: com.squareup.picasso.i$c */
    static class C1497c extends BroadcastReceiver {

        /* renamed from: a */
        private final C1493i f1639a;

        C1497c(C1493i iVar) {
            this.f1639a = iVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27225a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f1639a.f1635o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f1639a.f1622b.registerReceiver(this, intentFilter);
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        C1493i iVar = this.f1639a;
                        boolean booleanExtra = intent.getBooleanExtra("state", false);
                        Handler handler = iVar.f1629i;
                        handler.sendMessage(handler.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    C1493i iVar2 = this.f1639a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) C1474G.m2004a(context, "connectivity")).getActiveNetworkInfo();
                    Handler handler2 = iVar2.f1629i;
                    handler2.sendMessage(handler2.obtainMessage(9, activeNetworkInfo));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C1493i(android.content.Context r2, java.util.concurrent.ExecutorService r3, android.os.Handler r4, com.squareup.picasso.C1498j r5, com.squareup.picasso.C1488d r6, com.squareup.picasso.C1467B r7) {
        /*
            r1 = this;
            r1.<init>()
            com.squareup.picasso.i$b r0 = new com.squareup.picasso.i$b
            r0.<init>()
            r1.f1621a = r0
            r0.start()
            com.squareup.picasso.i$b r0 = r1.f1621a
            android.os.Looper r0 = r0.getLooper()
            com.squareup.picasso.C1474G.m2010a((android.os.Looper) r0)
            r1.f1622b = r2
            r1.f1623c = r3
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            r1.f1625e = r3
            java.util.WeakHashMap r3 = new java.util.WeakHashMap
            r3.<init>()
            r1.f1626f = r3
            java.util.WeakHashMap r3 = new java.util.WeakHashMap
            r3.<init>()
            r1.f1627g = r3
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            r1.f1628h = r3
            com.squareup.picasso.i$a r3 = new com.squareup.picasso.i$a
            com.squareup.picasso.i$b r0 = r1.f1621a
            android.os.Looper r0 = r0.getLooper()
            r3.<init>(r0, r1)
            r1.f1629i = r3
            r1.f1624d = r5
            r1.f1630j = r4
            r1.f1631k = r6
            r1.f1632l = r7
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 4
            r3.<init>(r4)
            r1.f1633m = r3
            android.content.Context r3 = r1.f1622b
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 1
            r5 = 0
            java.lang.String r6 = "airplane_mode_on"
            int r3 = android.provider.Settings.Global.getInt(r3, r6, r5)     // Catch:{ NullPointerException | SecurityException -> 0x0065 }
            if (r3 == 0) goto L_0x0065
            r3 = 1
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            r1.f1636p = r3
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            int r2 = r2.checkCallingOrSelfPermission(r3)
            if (r2 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r1.f1635o = r4
            com.squareup.picasso.i$c r2 = new com.squareup.picasso.i$c
            r2.<init>(r1)
            r1.f1634n = r2
            r2.mo27225a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1493i.<init>(android.content.Context, java.util.concurrent.ExecutorService, android.os.Handler, com.squareup.picasso.j, com.squareup.picasso.d, com.squareup.picasso.B):void");
    }

    /* renamed from: d */
    private void m2039d(C1481c cVar) {
        Future<?> future = cVar.f1604p;
        if (!(future != null && future.isCancelled())) {
            Bitmap bitmap = cVar.f1603o;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f1633m.add(cVar);
            if (!this.f1629i.hasMessages(7)) {
                this.f1629i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27219a(C1481c cVar) {
        Handler handler = this.f1629i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27220a(C1481c cVar, boolean z) {
        if (cVar.f1592b.f1686n) {
            String a = C1474G.m2006a(cVar);
            StringBuilder a2 = C0681a.m330a("for error");
            a2.append(z ? " (will replay)" : "");
            C1474G.m2011a("Dispatcher", "batched", a, a2.toString());
        }
        this.f1625e.remove(cVar.f1596f);
        m2039d(cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo27221b(C1481c cVar) {
        Handler handler = this.f1629i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo27222c(C1481c cVar) {
        if ((cVar.f1598h & C1507q.f1659c.f1660a) == 0) {
            this.f1631k.mo27209a(cVar.f1596f, cVar.f1603o);
        }
        this.f1625e.remove(cVar.f1596f);
        m2039d(cVar);
        if (cVar.f1592b.f1686n) {
            C1474G.m2011a("Dispatcher", "batched", C1474G.m2006a(cVar), "for completion");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27218a(C1478a aVar, boolean z) {
        String str;
        String str2;
        if (this.f1628h.contains(aVar.f1580j)) {
            this.f1627g.put(aVar.mo27197b(), aVar);
            if (aVar.f1571a.f1686n) {
                String b = aVar.f1572b.mo27266b();
                StringBuilder a = C0681a.m330a("because tag '");
                a.append(aVar.f1580j);
                a.append("' is paused");
                C1474G.m2011a("Dispatcher", "paused", b, a.toString());
                return;
            }
            return;
        }
        C1481c cVar = this.f1625e.get(aVar.f1579i);
        if (cVar != null) {
            boolean z2 = cVar.f1592b.f1686n;
            C1526x xVar = aVar.f1572b;
            if (cVar.f1601m == null) {
                cVar.f1601m = aVar;
                if (z2) {
                    List<C1478a> list = cVar.f1602n;
                    if (list == null || list.isEmpty()) {
                        str2 = xVar.mo27266b();
                        str = "to empty hunter";
                    } else {
                        str2 = xVar.mo27266b();
                        str = C1474G.m2007a(cVar, "to ");
                    }
                    C1474G.m2011a("Hunter", "joined", str2, str);
                    return;
                }
                return;
            }
            if (cVar.f1602n == null) {
                cVar.f1602n = new ArrayList(3);
            }
            cVar.f1602n.add(aVar);
            if (z2) {
                C1474G.m2011a("Hunter", "joined", xVar.mo27266b(), C1474G.m2007a(cVar, "to "));
            }
            C1513u.C1520f fVar = aVar.f1572b.f1733t;
            if (fVar.ordinal() > cVar.f1609u.ordinal()) {
                cVar.f1609u = fVar;
            }
        } else if (!this.f1623c.isShutdown()) {
            C1481c a2 = C1481c.m2023a(aVar.f1571a, this, this.f1631k, this.f1632l, aVar);
            a2.f1604p = this.f1623c.submit(a2);
            this.f1625e.put(aVar.f1579i, a2);
            if (z) {
                this.f1626f.remove(aVar.mo27197b());
            }
            if (aVar.f1571a.f1686n) {
                C1474G.m2011a("Dispatcher", "enqueued", aVar.f1572b.mo27266b(), "");
            }
        } else if (aVar.f1571a.f1686n) {
            C1474G.m2011a("Dispatcher", "ignored", aVar.f1572b.mo27266b(), "because shut down");
        }
    }
}
