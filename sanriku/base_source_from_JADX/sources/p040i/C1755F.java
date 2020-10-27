package p040i;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p040i.p103M.p108g.C1820f;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0001J#\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\f¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001a¨\u0006+"}, mo21739d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", "tag", "T", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.F */
public final class C1755F {

    /* renamed from: a */
    private C1921e f2163a;

    /* renamed from: b */
    private final C1955z f2164b;

    /* renamed from: c */
    private final String f2165c;

    /* renamed from: d */
    private final C1952y f2166d;

    /* renamed from: e */
    private final C0976G f2167e;

    /* renamed from: f */
    private final Map<Class<?>, Object> f2168f;

    /* renamed from: i.F$a */
    public static class C1756a {

        /* renamed from: a */
        private C1955z f2169a;

        /* renamed from: b */
        private String f2170b;

        /* renamed from: c */
        private C1952y.C1953a f2171c;

        /* renamed from: d */
        private C0976G f2172d;

        /* renamed from: e */
        private Map<Class<?>, Object> f2173e;

        public C1756a() {
            this.f2173e = new LinkedHashMap();
            this.f2170b = "GET";
            this.f2171c = new C1952y.C1953a();
        }

        public C1756a(C1755F f) {
            Intrinsics.checkParameterIsNotNull(f, "request");
            this.f2173e = new LinkedHashMap();
            this.f2169a = f.mo27542g();
            this.f2170b = f.mo27541f();
            this.f2172d = f.mo27533a();
            this.f2173e = f.mo27538c().isEmpty() ? new LinkedHashMap<>() : MapsKt__MapsKt.toMutableMap(f.mo27538c());
            this.f2171c = f.mo27539d().mo28112a();
        }

        /* renamed from: a */
        public C1756a mo27544a(C1921e eVar) {
            Intrinsics.checkParameterIsNotNull(eVar, "cacheControl");
            String eVar2 = eVar.toString();
            if (eVar2.length() == 0) {
                mo27548a("Cache-Control");
            } else {
                mo27550a("Cache-Control", eVar2);
            }
            return this;
        }

        /* renamed from: a */
        public C1756a mo27545a(C1952y yVar) {
            Intrinsics.checkParameterIsNotNull(yVar, "headers");
            this.f2171c = yVar.mo28112a();
            return this;
        }

        /* renamed from: a */
        public C1756a mo27546a(C1955z zVar) {
            Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
            this.f2169a = zVar;
            return this;
        }

        /* renamed from: a */
        public <T> C1756a mo27547a(Class<? super T> cls, T t) {
            Intrinsics.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.f2173e.remove(cls);
            } else {
                if (this.f2173e.isEmpty()) {
                    this.f2173e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.f2173e;
                Object cast = cls.cast(t);
                if (cast == null) {
                    Intrinsics.throwNpe();
                }
                map.put(cls, cast);
            }
            return this;
        }

        /* renamed from: a */
        public C1756a mo27548a(String str) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.f2171c.mo28128c(str);
            return this;
        }

        /* renamed from: a */
        public C1756a mo27549a(String str, C0976G g) {
            Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.METHOD);
            if (str.length() > 0) {
                if (g == null) {
                    if (!(!C1820f.m2875b(str))) {
                        throw new IllegalArgumentException(C0681a.m321a("method ", str, " must have a request body.").toString());
                    }
                } else if (!C1820f.m2874a(str)) {
                    throw new IllegalArgumentException(C0681a.m321a("method ", str, " must not have a request body.").toString());
                }
                this.f2170b = str;
                this.f2172d = g;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        /* renamed from: a */
        public C1756a mo27550a(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2171c.mo28129c(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1755F mo27551a() {
            C1955z zVar = this.f2169a;
            if (zVar != null) {
                return new C1755F(zVar, this.f2170b, this.f2171c.mo28124a(), this.f2172d, C1764b.m2625a(this.f2173e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        /* renamed from: b */
        public C1756a mo27552b(String str) {
            int i;
            StringBuilder sb;
            Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
            if (StringsKt__StringsJVMKt.startsWith(str, "ws:", true)) {
                sb = C0681a.m330a("http:");
                i = 3;
            } else {
                if (StringsKt__StringsJVMKt.startsWith(str, "wss:", true)) {
                    sb = C0681a.m330a("https:");
                    i = 4;
                }
                mo27546a(C1955z.f2852l.mo28171b(str));
                return this;
            }
            String substring = str.substring(i);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            str = sb.toString();
            mo27546a(C1955z.f2852l.mo28171b(str));
            return this;
        }
    }

    public C1755F(C1955z zVar, String str, C1952y yVar, C0976G g, Map<Class<?>, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkParameterIsNotNull(yVar, "headers");
        Intrinsics.checkParameterIsNotNull(map, "tags");
        this.f2164b = zVar;
        this.f2165c = str;
        this.f2166d = yVar;
        this.f2167e = g;
        this.f2168f = map;
    }

    @JvmName(name = "body")
    /* renamed from: a */
    public final C0976G mo27533a() {
        return this.f2167e;
    }

    /* renamed from: a */
    public final <T> T mo27534a(Class<? extends T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "type");
        return cls.cast(this.f2168f.get(cls));
    }

    /* renamed from: a */
    public final String mo27535a(String str) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return this.f2166d.get(str);
    }

    @JvmName(name = "cacheControl")
    /* renamed from: b */
    public final C1921e mo27536b() {
        C1921e eVar = this.f2163a;
        if (eVar != null) {
            return eVar;
        }
        C1921e eVar2 = C1921e.f2750o;
        C1921e a = C1921e.m3295a(this.f2166d);
        this.f2163a = a;
        return a;
    }

    /* renamed from: b */
    public final List<String> mo27537b(String str) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return this.f2166d.mo28114a(str);
    }

    /* renamed from: c */
    public final Map<Class<?>, Object> mo27538c() {
        return this.f2168f;
    }

    @JvmName(name = "headers")
    /* renamed from: d */
    public final C1952y mo27539d() {
        return this.f2166d;
    }

    /* renamed from: e */
    public final boolean mo27540e() {
        return this.f2164b.mo28139g();
    }

    @JvmName(name = "method")
    /* renamed from: f */
    public final String mo27541f() {
        return this.f2165c;
    }

    @JvmName(name = "url")
    /* renamed from: g */
    public final C1955z mo27542g() {
        return this.f2164b;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Request{method=");
        a.append(this.f2165c);
        a.append(", url=");
        a.append(this.f2164b);
        if (this.f2166d.size() != 0) {
            a.append(", headers=[");
            int i = 0;
            for (Object next : this.f2166d) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i > 0) {
                    a.append(", ");
                }
                a.append(str);
                a.append(':');
                a.append(str2);
                i = i2;
            }
            a.append(']');
        }
        if (!this.f2168f.isEmpty()) {
            a.append(", tags=");
            a.append(this.f2168f);
        }
        a.append('}');
        String sb = a.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
