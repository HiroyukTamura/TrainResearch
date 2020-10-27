package p040i.p103M.p110i;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p040i.p103M.p110i.C1837d;
import p042j.C1016z;
import p042j.C2057A;
import p042j.C2068f;
import p042j.C2072h;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo21739d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "close", "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", "flags", "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.h */
public final class C1859h implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Logger f2595e;

    /* renamed from: f */
    public static final C1859h f2596f = null;

    /* renamed from: a */
    private final C1860a f2597a;

    /* renamed from: b */
    private final C1837d.C1838a f2598b;

    /* renamed from: c */
    private final C2072h f2599c;

    /* renamed from: d */
    private final boolean f2600d;

    /* renamed from: i.M.i.h$a */
    public static final class C1860a implements C1016z {

        /* renamed from: a */
        private int f2601a;

        /* renamed from: b */
        private int f2602b;

        /* renamed from: c */
        private int f2603c;

        /* renamed from: d */
        private int f2604d;

        /* renamed from: e */
        private int f2605e;

        /* renamed from: f */
        private final C2072h f2606f;

        public C1860a(C2072h hVar) {
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
            this.f2606f = hVar;
        }

        /* renamed from: a */
        public final void mo27877a(int i) {
            this.f2602b = i;
        }

        /* renamed from: b */
        public final void mo27878b(int i) {
            this.f2604d = i;
        }

        /* renamed from: c */
        public final void mo27879c(int i) {
            this.f2601a = i;
        }

        public void close() throws IOException {
        }

        /* renamed from: d */
        public final int mo27880d() {
            return this.f2604d;
        }

        /* renamed from: d */
        public final void mo27881d(int i) {
            this.f2605e = i;
        }

        /* renamed from: e */
        public final void mo27882e(int i) {
            this.f2603c = i;
        }

        public long read(C2068f fVar, long j) throws IOException {
            int i;
            int readInt;
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            do {
                int i2 = this.f2604d;
                if (i2 == 0) {
                    this.f2606f.skip((long) this.f2605e);
                    this.f2605e = 0;
                    if ((this.f2602b & 4) != 0) {
                        return -1;
                    }
                    i = this.f2603c;
                    int a = C1764b.m2607a(this.f2606f);
                    this.f2604d = a;
                    this.f2601a = a;
                    byte readByte = this.f2606f.readByte() & UByte.MAX_VALUE;
                    this.f2602b = this.f2606f.readByte() & UByte.MAX_VALUE;
                    C1859h hVar = C1859h.f2596f;
                    if (C1859h.f2595e.isLoggable(Level.FINE)) {
                        C1859h hVar2 = C1859h.f2596f;
                        C1859h.f2595e.fine(C1840e.f2510e.mo27822a(true, this.f2603c, this.f2601a, readByte, this.f2602b));
                    }
                    readInt = this.f2606f.readInt() & Integer.MAX_VALUE;
                    this.f2603c = readInt;
                    if (readByte != 9) {
                        throw new IOException(readByte + " != TYPE_CONTINUATION");
                    }
                } else {
                    long read = this.f2606f.read(fVar, Math.min(j, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.f2604d -= (int) read;
                    return read;
                }
            } while (readInt == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        public C2057A timeout() {
            return this.f2606f.timeout();
        }
    }

    /* renamed from: i.M.i.h$b */
    public interface C1861b {
        /* renamed from: a */
        void mo27863a();

        /* renamed from: a */
        void mo27864a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo27865a(int i, int i2, List<C1836c> list) throws IOException;

        /* renamed from: a */
        void mo27866a(int i, long j);

        /* renamed from: a */
        void mo27867a(int i, C1834b bVar);

        /* renamed from: a */
        void mo27868a(int i, C1834b bVar, C2073i iVar);

        /* renamed from: a */
        void mo27869a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo27870a(boolean z, int i, int i2, List<C1836c> list);

        /* renamed from: a */
        void mo27871a(boolean z, int i, C2072h hVar, int i2) throws IOException;

        /* renamed from: a */
        void mo27872a(boolean z, C1871n nVar);
    }

    static {
        Logger logger = Logger.getLogger(C1840e.class.getName());
        Intrinsics.checkExpressionValueIsNotNull(logger, "Logger.getLogger(Http2::class.java.name)");
        f2595e = logger;
    }

    public C1859h(C2072h hVar, boolean z) {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        this.f2599c = hVar;
        this.f2600d = z;
        C1860a aVar = new C1860a(hVar);
        this.f2597a = aVar;
        this.f2598b = new C1837d.C1838a(aVar, 4096, 0, 4);
    }

    /* renamed from: a */
    public static final int m3034a(int i, int i2, int i3) throws IOException {
        if ((i2 & 8) != 0) {
            i--;
        }
        if (i3 <= i) {
            return i - i3;
        }
        throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
    }

    /* renamed from: a */
    private final List<C1836c> m3035a(int i, int i2, int i3, int i4) throws IOException {
        this.f2597a.mo27878b(i);
        C1860a aVar = this.f2597a;
        aVar.mo27879c(aVar.mo27880d());
        this.f2597a.mo27881d(i2);
        this.f2597a.mo27877a(i3);
        this.f2597a.mo27882e(i4);
        this.f2598b.mo27817c();
        return this.f2598b.mo27815a();
    }

    /* renamed from: a */
    private final void m3036a(C1861b bVar, int i) throws IOException {
        int readInt = this.f2599c.readInt();
        bVar.mo27864a(i, readInt & Integer.MAX_VALUE, C1764b.m2604a(this.f2599c.readByte(), 255) + 1, (readInt & ((int) 2147483648L)) != 0);
    }

    /* renamed from: a */
    public final boolean mo27875a(boolean z, C1861b bVar) throws IOException {
        int readInt;
        Intrinsics.checkParameterIsNotNull(bVar, "handler");
        boolean z2 = false;
        try {
            this.f2599c.mo29159f(9);
            int a = C1764b.m2607a(this.f2599c);
            if (a <= 16384) {
                byte readByte = this.f2599c.readByte() & UByte.MAX_VALUE;
                if (!z || readByte == 4) {
                    byte readByte2 = this.f2599c.readByte() & UByte.MAX_VALUE;
                    int readInt2 = this.f2599c.readInt() & Integer.MAX_VALUE;
                    if (f2595e.isLoggable(Level.FINE)) {
                        f2595e.fine(C1840e.f2510e.mo27822a(true, readInt2, a, readByte, readByte2));
                    }
                    switch (readByte) {
                        case 0:
                            if (readInt2 != 0) {
                                boolean z3 = (readByte2 & 1) != 0;
                                if (!((readByte2 & 32) != 0)) {
                                    if ((readByte2 & 8) != 0) {
                                        z2 = this.f2599c.readByte() & true;
                                    }
                                    bVar.mo27871a(z3, readInt2, this.f2599c, m3034a(a, readByte2, z2 ? 1 : 0));
                                    this.f2599c.skip(z2 ? 1 : 0);
                                    break;
                                } else {
                                    throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                                }
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                            }
                        case 1:
                            if (readInt2 != 0) {
                                boolean z4 = (readByte2 & 1) != 0;
                                if ((readByte2 & 8) != 0) {
                                    z2 = this.f2599c.readByte() & true;
                                }
                                if ((readByte2 & 32) != 0) {
                                    m3036a(bVar, readInt2);
                                    a -= 5;
                                }
                                bVar.mo27870a(z4, readInt2, -1, m3035a(m3034a(a, readByte2, z2 ? 1 : 0), z2, readByte2, readInt2));
                                break;
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                            }
                        case 2:
                            if (a != 5) {
                                throw new IOException(C0681a.m317a("TYPE_PRIORITY length: ", a, " != 5"));
                            } else if (readInt2 != 0) {
                                m3036a(bVar, readInt2);
                                break;
                            } else {
                                throw new IOException("TYPE_PRIORITY streamId == 0");
                            }
                        case 3:
                            if (a != 4) {
                                throw new IOException(C0681a.m317a("TYPE_RST_STREAM length: ", a, " != 4"));
                            } else if (readInt2 != 0) {
                                int readInt3 = this.f2599c.readInt();
                                C1834b a2 = C1834b.f2474i.mo27807a(readInt3);
                                if (a2 != null) {
                                    bVar.mo27867a(readInt2, a2);
                                    break;
                                } else {
                                    throw new IOException(C0681a.m316a("TYPE_RST_STREAM unexpected error code: ", readInt3));
                                }
                            } else {
                                throw new IOException("TYPE_RST_STREAM streamId == 0");
                            }
                        case 4:
                            if (readInt2 != 0) {
                                throw new IOException("TYPE_SETTINGS streamId != 0");
                            } else if ((readByte2 & 1) != 0) {
                                if (a == 0) {
                                    bVar.mo27863a();
                                    break;
                                } else {
                                    throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                                }
                            } else if (a % 6 == 0) {
                                C1871n nVar = new C1871n();
                                IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, a), 6);
                                int first = step.getFirst();
                                int last = step.getLast();
                                int step2 = step.getStep();
                                if (step2 < 0 ? first >= last : first <= last) {
                                    while (true) {
                                        short readShort = this.f2599c.readShort() & UShort.MAX_VALUE;
                                        readInt = this.f2599c.readInt();
                                        if (readShort != 2) {
                                            if (readShort == 3) {
                                                readShort = 4;
                                            } else if (readShort == 4) {
                                                readShort = 7;
                                                if (readInt < 0) {
                                                    throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                                }
                                            } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                                            }
                                        } else if (!(readInt == 0 || readInt == 1)) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                        }
                                        nVar.mo27947a(readShort, readInt);
                                        if (first != last) {
                                            first += step2;
                                        }
                                    }
                                    throw new IOException(C0681a.m316a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", readInt));
                                }
                                bVar.mo27872a(false, nVar);
                                break;
                            } else {
                                throw new IOException(C0681a.m316a("TYPE_SETTINGS length % 6 != 0: ", a));
                            }
                        case 5:
                            if (readInt2 != 0) {
                                if ((readByte2 & 8) != 0) {
                                    z2 = this.f2599c.readByte() & true;
                                }
                                bVar.mo27865a(readInt2, this.f2599c.readInt() & Integer.MAX_VALUE, m3035a(m3034a(a - 4, readByte2, z2 ? 1 : 0), z2, readByte2, readInt2));
                                break;
                            } else {
                                throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                            }
                        case 6:
                            if (a != 8) {
                                throw new IOException(C0681a.m316a("TYPE_PING length != 8: ", a));
                            } else if (readInt2 == 0) {
                                int readInt4 = this.f2599c.readInt();
                                int readInt5 = this.f2599c.readInt();
                                if ((readByte2 & 1) != 0) {
                                    z2 = true;
                                }
                                bVar.mo27869a(z2, readInt4, readInt5);
                                break;
                            } else {
                                throw new IOException("TYPE_PING streamId != 0");
                            }
                        case 7:
                            if (a < 8) {
                                throw new IOException(C0681a.m316a("TYPE_GOAWAY length < 8: ", a));
                            } else if (readInt2 == 0) {
                                int readInt6 = this.f2599c.readInt();
                                int readInt7 = this.f2599c.readInt();
                                int i = a - 8;
                                C1834b a3 = C1834b.f2474i.mo27807a(readInt7);
                                if (a3 != null) {
                                    C2073i iVar = C2073i.f2894d;
                                    if (i > 0) {
                                        iVar = this.f2599c.mo29142a((long) i);
                                    }
                                    bVar.mo27868a(readInt6, a3, iVar);
                                    break;
                                } else {
                                    throw new IOException(C0681a.m316a("TYPE_GOAWAY unexpected error code: ", readInt7));
                                }
                            } else {
                                throw new IOException("TYPE_GOAWAY streamId != 0");
                            }
                        case 8:
                            if (a == 4) {
                                long readInt8 = 2147483647L & ((long) this.f2599c.readInt());
                                if (readInt8 != 0) {
                                    bVar.mo27866a(readInt2, readInt8);
                                    break;
                                } else {
                                    throw new IOException("windowSizeIncrement was 0");
                                }
                            } else {
                                throw new IOException(C0681a.m316a("TYPE_WINDOW_UPDATE length !=4: ", a));
                            }
                        default:
                            this.f2599c.skip((long) a);
                            break;
                    }
                    return true;
                }
                throw new IOException(C0681a.m316a("Expected a SETTINGS frame but was ", (int) readByte));
            }
            throw new IOException(C0681a.m316a("FRAME_SIZE_ERROR: ", a));
        } catch (EOFException unused) {
            return false;
        }
    }

    public void close() throws IOException {
        this.f2599c.close();
    }

    /* renamed from: a */
    public final void mo27874a(C1861b bVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "handler");
        if (!this.f2600d) {
            C2073i a = this.f2599c.mo29142a((long) C1840e.f2506a.mo29212d());
            if (f2595e.isLoggable(Level.FINE)) {
                Logger logger = f2595e;
                StringBuilder a2 = C0681a.m330a("<< CONNECTION ");
                a2.append(a.mo29213e());
                logger.fine(C1764b.m2621a(a2.toString(), new Object[0]));
            }
            if (!Intrinsics.areEqual((Object) C1840e.f2506a, (Object) a)) {
                StringBuilder a3 = C0681a.m330a("Expected a connection header but was ");
                a3.append(a.mo29217h());
                throw new IOException(a3.toString());
            }
        } else if (!mo27875a(true, bVar)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }
}
