package p040i.p103M;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1746B;
import p040i.C1752D;
import p040i.C1758I;
import p040i.C1923f;
import p040i.C1943t;
import p040i.C1952y;
import p040i.C1955z;
import p040i.p103M.p110i.C1836c;
import p042j.C1016z;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2073i;
import p042j.C2081q;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¶\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016\u001a'\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 \"\u00020!¢\u0006\u0002\u0010\"\u001a\u0017\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0%H\b\u001a-\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0004\b\u0000\u0010(2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u0002H(0 \"\u0002H(H\u0007¢\u0006\u0002\u0010*\u001a1\u0010+\u001a\u0004\u0018\u0001H(\"\u0004\b\u0000\u0010(2\u0006\u0010,\u001a\u00020!2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H(0.2\u0006\u0010/\u001a\u00020\u0011¢\u0006\u0002\u00100\u001a\u0016\u00101\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u000f\u001a\u001f\u00104\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0%H\b\u001a%\u00105\u001a\u00020\u001a\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H6072\u0006\u00108\u001a\u0002H6H\u0000¢\u0006\u0002\u00109\u001a\u0015\u0010:\u001a\u00020\u0013*\u00020;2\u0006\u0010<\u001a\u00020\u0013H\u0004\u001a\u0015\u0010:\u001a\u00020\u0016*\u00020\u00132\u0006\u0010<\u001a\u00020\u0016H\u0004\u001a\u0015\u0010:\u001a\u00020\u0013*\u00020=2\u0006\u0010<\u001a\u00020\u0013H\u0004\u001a\n\u0010>\u001a\u00020?*\u00020@\u001a\r\u0010A\u001a\u00020\u001a*\u00020!H\b\u001a\r\u0010B\u001a\u00020\u001a*\u00020!H\b\u001a\n\u0010C\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010D\u001a\u00020\u000f*\u00020E2\u0006\u0010F\u001a\u00020E\u001a\n\u0010G\u001a\u00020\u001a*\u00020H\u001a\n\u0010G\u001a\u00020\u001a*\u00020I\u001a\n\u0010G\u001a\u00020\u001a*\u00020J\u001a#\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110 *\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u0010L\u001a\u00020\u0011¢\u0006\u0002\u0010M\u001a&\u0010N\u001a\u00020\u0013*\u00020\u00112\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010R\u001a\u00020\u0013\u001a&\u0010N\u001a\u00020\u0013*\u00020\u00112\u0006\u0010S\u001a\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010R\u001a\u00020\u0013\u001a\u001a\u0010T\u001a\u00020\u000f*\u00020U2\u0006\u0010V\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u0018\u001a8\u0010X\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0Y2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\u000f0[¢\u0006\u0002\b\\H\b\u001a5\u0010]\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110 2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010 2\u000e\u0010^\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110_¢\u0006\u0002\u0010`\u001a\n\u0010a\u001a\u00020\u0016*\u00020b\u001a+\u0010c\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u0010L\u001a\u00020\u00112\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110_¢\u0006\u0002\u0010d\u001a\n\u0010e\u001a\u00020\u0013*\u00020\u0011\u001a\u001e\u0010f\u001a\u00020\u0013*\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010R\u001a\u00020\u0013\u001a\u001e\u0010g\u001a\u00020\u0013*\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010R\u001a\u00020\u0013\u001a\u0014\u0010h\u001a\u00020\u0013*\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\u0013\u001a9\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00110 *\b\u0012\u0004\u0012\u00020\u00110 2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u000e\u0010^\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110_¢\u0006\u0002\u0010j\u001a\u0012\u0010k\u001a\u00020\u000f*\u00020l2\u0006\u0010m\u001a\u00020n\u001a\u0012\u0010o\u001a\u00020\u000f*\u00020J2\u0006\u0010p\u001a\u00020q\u001a\r\u0010r\u001a\u00020\u001a*\u00020!H\b\u001a\r\u0010s\u001a\u00020\u001a*\u00020!H\b\u001a\n\u0010t\u001a\u00020\u0013*\u00020P\u001a\n\u0010u\u001a\u00020\u0011*\u00020J\u001a\u0012\u0010v\u001a\u00020w*\u00020q2\u0006\u0010x\u001a\u00020w\u001a\n\u0010y\u001a\u00020\u0013*\u00020q\u001a\u0012\u0010z\u001a\u00020\u0013*\u00020{2\u0006\u0010|\u001a\u00020;\u001a\u001a\u0010z\u001a\u00020\u000f*\u00020U2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u0018\u001a\u0010\u0010}\u001a\b\u0012\u0004\u0012\u00020~0'*\u00020\u0003\u001a\u0010\u0010\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020~0'\u001a\u000b\u0010\u0001\u001a\u00020\u0011*\u00020\u0013\u001a\u000b\u0010\u0001\u001a\u00020\u0011*\u00020\u0016\u001a\u0016\u0010\u0001\u001a\u00020\u0011*\u00020E2\t\b\u0002\u0010\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0'\u001a7\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u0001*\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001\u001a\u0014\u0010\u0001\u001a\u00020\u0016*\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0016\u001a\u0016\u0010\u0001\u001a\u00020\u0013*\u0004\u0018\u00010\u00112\u0007\u0010\u0001\u001a\u00020\u0013\u001a\u001f\u0010\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\u00132\b\b\u0002\u0010R\u001a\u00020\u0013\u001a\u000e\u0010\u0001\u001a\u00020\u001a*\u00020!H\b\u001a'\u0010\u0001\u001a\u00030\u0001*\b0\u0001j\u0003`\u00012\u0013\u0010\u0001\u001a\u000e\u0012\n\u0012\b0\u0001j\u0003`\u00010'\u001a\u0015\u0010\u0001\u001a\u00020\u001a*\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0013\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo21739d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", "T", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", "file", "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, mo21740k = 2, mo21741mv = {1, 1, 16})
@JvmName(name = "Util")
/* renamed from: i.M.b */
public final class C1764b {
    @JvmField

    /* renamed from: a */
    public static final byte[] f2213a = new byte[0];
    @JvmField

    /* renamed from: b */
    public static final C1952y f2214b = C1952y.f2848b.mo28130a(new String[0]);
    @JvmField

    /* renamed from: c */
    public static final C0980J f2215c = C0980J.Companion.mo20419a(f2213a, (C1746B) null);

    /* renamed from: d */
    private static final C2081q f2216d = C2081q.f2912c.mo29233a(C2073i.f2895e.mo29220a("efbbbf"), C2073i.f2895e.mo29220a("feff"), C2073i.f2895e.mo29220a("fffe"), C2073i.f2895e.mo29220a("0000ffff"), C2073i.f2895e.mo29220a("ffff0000"));
    @JvmField

    /* renamed from: e */
    public static final TimeZone f2217e;

    /* renamed from: f */
    private static final Regex f2218f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    @JvmField

    /* renamed from: g */
    public static final boolean f2219g = C1752D.class.desiredAssertionStatus();
    @JvmField

    /* renamed from: h */
    public static final String f2220h;

    /* renamed from: i.M.b$a */
    public static final class C1765a implements C1943t.C1945b {

        /* renamed from: a */
        final /* synthetic */ C1943t f2221a;

        C1765a(C1943t tVar) {
            this.f2221a = tVar;
        }

        /* renamed from: a */
        public C1943t mo27597a(C1923f fVar) {
            Intrinsics.checkParameterIsNotNull(fVar, NotificationCompat.CATEGORY_CALL);
            return this.f2221a;
        }
    }

    /* renamed from: i.M.b$b */
    static final class C1766b implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ String f2222a;

        /* renamed from: b */
        final /* synthetic */ boolean f2223b;

        C1766b(String str, boolean z) {
            this.f2222a = str;
            this.f2223b = z;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f2222a);
            thread.setDaemon(this.f2223b);
            return thread;
        }
    }

    static {
        C0976G.C0977a.m1377a(C0976G.Companion, f2213a, (C1746B) null, 0, 0, 7);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            Intrinsics.throwNpe();
        }
        f2217e = timeZone;
        String name = C1752D.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "OkHttpClient::class.java.name");
        f2220h = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    /* renamed from: a */
    public static final int m2604a(byte b, int i) {
        return b & i;
    }

    /* renamed from: a */
    public static final int m2605a(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static final int m2606a(C2068f fVar, byte b) {
        Intrinsics.checkParameterIsNotNull(fVar, "$this$skipAll");
        int i = 0;
        while (!fVar.mo29152c() && fVar.mo29163h(0) == b) {
            i++;
            fVar.readByte();
        }
        return i;
    }

    /* renamed from: a */
    public static final int m2607a(C2072h hVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(hVar, "$this$readMedium");
        return (hVar.readByte() & UByte.MAX_VALUE) | ((hVar.readByte() & UByte.MAX_VALUE) << 16) | ((hVar.readByte() & UByte.MAX_VALUE) << 8);
    }

    /* renamed from: a */
    public static final int m2608a(String str, char c, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static /* synthetic */ int m2609a(String str, char c, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return m2608a(str, c, i, i2);
    }

    /* renamed from: a */
    public static final int m2610a(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* renamed from: a */
    public static final int m2611a(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static /* synthetic */ int m2612a(String str, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m2611a(str, i, i2);
    }

    /* renamed from: a */
    public static final int m2613a(String str, long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        boolean z = true;
        if (j >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis <= ((long) Integer.MAX_VALUE)) {
                    if (millis == 0 && j > 0) {
                        z = false;
                    }
                    if (z) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException(C0681a.m320a(str, " too small.").toString());
                }
                throw new IllegalArgumentException(C0681a.m320a(str, " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException(C0681a.m320a(str, " < 0").toString());
    }

    /* renamed from: a */
    public static final int m2614a(String str, String str2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$delimiterOffset");
        Intrinsics.checkParameterIsNotNull(str2, "delimiters");
        while (i < i2) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static final int m2615a(String[] strArr, String str, Comparator<String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static final long m2616a(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "$this$headersContentLength");
        String str = i.mo27561r().get("Content-Length");
        if (str == null) {
            return -1;
        }
        Intrinsics.checkParameterIsNotNull(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static final long m2617a(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    /* renamed from: a */
    public static final C1943t.C1945b m2618a(C1943t tVar) {
        Intrinsics.checkParameterIsNotNull(tVar, "$this$asFactory");
        return new C1765a(tVar);
    }

    /* renamed from: a */
    public static final String m2620a(C1955z zVar, boolean z) {
        String str;
        Intrinsics.checkParameterIsNotNull(zVar, "$this$toHostHeader");
        if (StringsKt__StringsKt.contains$default((CharSequence) zVar.mo28138f(), (CharSequence) ":", false, 2, (Object) null)) {
            StringBuilder a = C0681a.m329a('[');
            a.append(zVar.mo28138f());
            a.append(']');
            str = a.toString();
        } else {
            str = zVar.mo28138f();
        }
        if (!z && zVar.mo28143j() == C1955z.f2852l.mo28169a(zVar.mo28146m())) {
            return str;
        }
        return str + ':' + zVar.mo28143j();
    }

    /* renamed from: a */
    public static final String m2621a(String str, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(objArr, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    /* renamed from: a */
    public static final Throwable m2622a(Exception exc, List<? extends Exception> list) {
        Intrinsics.checkParameterIsNotNull(exc, "$this$withSuppressed");
        Intrinsics.checkParameterIsNotNull(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception addSuppressed : list) {
            exc.addSuppressed(addSuppressed);
        }
        return exc;
    }

    /* renamed from: a */
    public static final Charset m2623a(C2072h hVar, Charset charset) throws IOException {
        Charset charset2;
        String str;
        Intrinsics.checkParameterIsNotNull(hVar, "$this$readBomAsCharset");
        Intrinsics.checkParameterIsNotNull(charset, "default");
        int a = hVar.mo29132a(f2216d);
        if (a == -1) {
            return charset;
        }
        if (a == 0) {
            charset2 = StandardCharsets.UTF_8;
            str = "UTF_8";
        } else if (a == 1) {
            charset2 = StandardCharsets.UTF_16BE;
            str = "UTF_16BE";
        } else if (a == 2) {
            charset2 = StandardCharsets.UTF_16LE;
            str = "UTF_16LE";
        } else if (a == 3) {
            return Charsets.INSTANCE.UTF32_BE();
        } else {
            if (a == 4) {
                return Charsets.INSTANCE.UTF32_LE();
            }
            throw new AssertionError();
        }
        Intrinsics.checkExpressionValueIsNotNull(charset2, str);
        return charset2;
    }

    @SafeVarargs
    /* renamed from: a */
    public static final <T> List<T> m2624a(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return unmodifiableList;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m2625a(Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return MapsKt__MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    /* renamed from: a */
    public static final ThreadFactory m2626a(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return new C1766b(str, z);
    }

    /* renamed from: a */
    public static final void m2627a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static final void m2628a(C2071g gVar, int i) throws IOException {
        Intrinsics.checkParameterIsNotNull(gVar, "$this$writeMedium");
        gVar.writeByte((i >>> 16) & 255);
        gVar.writeByte((i >>> 8) & 255);
        gVar.writeByte(i & 255);
    }

    /* renamed from: a */
    public static final void m2629a(Closeable closeable) {
        Intrinsics.checkParameterIsNotNull(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static final void m2630a(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static final boolean m2631a(C1955z zVar, C1955z zVar2) {
        Intrinsics.checkParameterIsNotNull(zVar, "$this$canReuseConnectionFor");
        Intrinsics.checkParameterIsNotNull(zVar2, FitnessActivities.OTHER);
        return Intrinsics.areEqual((Object) zVar.mo28138f(), (Object) zVar2.mo28138f()) && zVar.mo28143j() == zVar2.mo28143j() && Intrinsics.areEqual((Object) zVar.mo28146m(), (Object) zVar2.mo28146m());
    }

    /* renamed from: a */
    public static final boolean m2632a(C1016z zVar, int i, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(zVar, "$this$discard");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        try {
            return m2640b(zVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static final boolean m2633a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
        return f2218f.matches(str);
    }

    /* renamed from: a */
    public static final boolean m2634a(Socket socket, C2072h hVar) {
        int soTimeout;
        Intrinsics.checkParameterIsNotNull(socket, "$this$isHealthy");
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        try {
            soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z = !hVar.mo29152c();
            socket.setSoTimeout(soTimeout);
            return z;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    /* renamed from: a */
    public static final boolean m2635a(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$hasIntersection");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String compare : strArr2) {
                        if (comparator.compare(str, compare) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static final int m2636b(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static final int m2637b(String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > ((long) Integer.MAX_VALUE)) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* renamed from: b */
    public static final int m2638b(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt == 9 || charAt == 10 || charAt == 12 || charAt == 13 || charAt == ' ') {
                    if (i3 == i) {
                        break;
                    }
                    i3--;
                } else {
                    return i3 + 1;
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public static final <T> List<T> m2639b(List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.toMutableList(list));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r11.timeout().mo29118a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        r11.timeout().mo29119a(r0 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        if (r5 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        return r12;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m2640b(p042j.C1016z r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "$this$skipAll"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            long r0 = java.lang.System.nanoTime()
            j.A r2 = r11.timeout()
            boolean r2 = r2.mo29123d()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L_0x0027
            j.A r2 = r11.timeout()
            long r5 = r2.mo29122c()
            long r5 = r5 - r0
            goto L_0x0028
        L_0x0027:
            r5 = r3
        L_0x0028:
            j.A r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.mo29119a(r12)
            j.f r12 = new j.f     // Catch:{ InterruptedIOException -> 0x0076, all -> 0x0064 }
            r12.<init>()     // Catch:{ InterruptedIOException -> 0x0076, all -> 0x0064 }
        L_0x003e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch:{ InterruptedIOException -> 0x0076, all -> 0x0064 }
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x004e
            r12.mo29154d()     // Catch:{ InterruptedIOException -> 0x0076, all -> 0x0064 }
            goto L_0x003e
        L_0x004e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x005b
        L_0x0053:
            j.A r11 = r11.timeout()
            r11.mo29118a()
            goto L_0x007d
        L_0x005b:
            j.A r11 = r11.timeout()
            long r0 = r0 + r5
            r11.mo29119a(r0)
            goto L_0x007d
        L_0x0064:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            j.A r11 = r11.timeout()
            if (r13 != 0) goto L_0x0071
            r11.mo29118a()
            goto L_0x0075
        L_0x0071:
            long r0 = r0 + r5
            r11.mo29119a(r0)
        L_0x0075:
            throw r12
        L_0x0076:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x005b
            goto L_0x0053
        L_0x007d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.C1764b.m2640b(j.z, int, java.util.concurrent.TimeUnit):boolean");
    }

    /* renamed from: b */
    public static final String[] m2641b(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$intersect");
        Intrinsics.checkParameterIsNotNull(strArr2, FitnessActivities.OTHER);
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: c */
    public static final String m2642c(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$trimSubstring");
        int a = m2611a(str, i, i2);
        String substring = str.substring(a, m2638b(str, a, i2));
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final C1952y m2619a(List<C1836c> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$toHeaders");
        C1952y.C1953a aVar = new C1952y.C1953a();
        for (C1836c next : list) {
            aVar.mo28125b(next.f2483b.mo29217h(), next.f2484c.mo29217h());
        }
        return aVar.mo28124a();
    }
}
