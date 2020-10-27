package p040i;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.text.Regex;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1763a;
import p040i.p103M.C1764b;
import p042j.C2068f;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, mo21739d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.z */
public final class C1955z {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final char[] f2851k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: l */
    public static final C1958b f2852l = new C1958b((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final boolean f2853a;

    /* renamed from: b */
    private final String f2854b;

    /* renamed from: c */
    private final String f2855c;

    /* renamed from: d */
    private final String f2856d;

    /* renamed from: e */
    private final String f2857e;

    /* renamed from: f */
    private final int f2858f;

    /* renamed from: g */
    private final List<String> f2859g;

    /* renamed from: h */
    private final List<String> f2860h;

    /* renamed from: i */
    private final String f2861i;

    /* renamed from: j */
    private final String f2862j;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006W"}, mo21739d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.z$a */
    public static final class C1956a {

        /* renamed from: i */
        public static final C1957a f2863i = new C1957a((DefaultConstructorMarker) null);

        /* renamed from: a */
        private String f2864a;

        /* renamed from: b */
        private String f2865b = "";

        /* renamed from: c */
        private String f2866c = "";

        /* renamed from: d */
        private String f2867d;

        /* renamed from: e */
        private int f2868e = -1;

        /* renamed from: f */
        private final List<String> f2869f;

        /* renamed from: g */
        private List<String> f2870g;

        /* renamed from: h */
        private String f2871h;

        /* renamed from: i.z$a$a */
        public static final class C1957a {
            public /* synthetic */ C1957a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public C1956a() {
            ArrayList arrayList = new ArrayList();
            this.f2869f = arrayList;
            arrayList.add("");
        }

        /* renamed from: d */
        private final int m3404d() {
            int i = this.f2868e;
            if (i != -1) {
                return i;
            }
            C1958b bVar = C1955z.f2852l;
            String str = this.f2864a;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            return bVar.mo28169a(str);
        }

        /* renamed from: a */
        public final C1956a mo28150a(int i) {
            boolean z = true;
            if (1 > i || 65535 < i) {
                z = false;
            }
            if (z) {
                this.f2868e = i;
                return this;
            }
            throw new IllegalArgumentException(C0681a.m316a("unexpected port: ", i).toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:106:0x025e, code lost:
            if (65535 < r1) goto L_0x0267;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            if (r14 == ':') goto L_0x0069;
         */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0326  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x0425 A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p040i.C1955z.C1956a mo28151a(p040i.C1955z r29, java.lang.String r30) {
            /*
                r28 = this;
                r0 = r28
                r12 = r30
                java.lang.String r1 = "input"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r1)
                r1 = 0
                r2 = 3
                int r2 = p040i.p103M.C1764b.m2612a((java.lang.String) r12, (int) r1, (int) r1, (int) r2)
                int r3 = r30.length()
                int r13 = p040i.p103M.C1764b.m2638b((java.lang.String) r12, (int) r2, (int) r3)
                int r3 = r13 - r2
                r4 = 2
                r5 = 58
                r6 = -1
                r7 = 1
                if (r3 >= r4) goto L_0x0021
                goto L_0x0068
            L_0x0021:
                char r3 = r12.charAt(r2)
                r8 = 90
                r9 = 122(0x7a, float:1.71E-43)
                r10 = 65
                r11 = 97
                if (r3 < r11) goto L_0x0031
                if (r3 <= r9) goto L_0x0036
            L_0x0031:
                if (r3 < r10) goto L_0x0068
                if (r3 <= r8) goto L_0x0036
                goto L_0x0068
            L_0x0036:
                r3 = r2
            L_0x0037:
                int r3 = r3 + r7
                if (r3 >= r13) goto L_0x0068
                char r14 = r12.charAt(r3)
                if (r11 <= r14) goto L_0x0041
                goto L_0x0044
            L_0x0041:
                if (r9 < r14) goto L_0x0044
                goto L_0x0062
            L_0x0044:
                if (r10 <= r14) goto L_0x0047
                goto L_0x004a
            L_0x0047:
                if (r8 < r14) goto L_0x004a
                goto L_0x0062
            L_0x004a:
                r8 = 57
                r15 = 48
                if (r15 <= r14) goto L_0x0051
                goto L_0x0054
            L_0x0051:
                if (r8 < r14) goto L_0x0054
                goto L_0x0062
            L_0x0054:
                r8 = 43
                if (r14 != r8) goto L_0x0059
                goto L_0x0062
            L_0x0059:
                r8 = 45
                if (r14 != r8) goto L_0x005e
                goto L_0x0062
            L_0x005e:
                r8 = 46
                if (r14 != r8) goto L_0x0065
            L_0x0062:
                r8 = 90
                goto L_0x0037
            L_0x0065:
                if (r14 != r5) goto L_0x0068
                goto L_0x0069
            L_0x0068:
                r3 = -1
            L_0x0069:
                java.lang.String r14 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                if (r3 == r6) goto L_0x00aa
                java.lang.String r8 = "https:"
                boolean r8 = kotlin.text.StringsKt__StringsJVMKt.startsWith(r12, r8, r2, r7)
                if (r8 == 0) goto L_0x007c
                java.lang.String r1 = "https"
                r0.f2864a = r1
                int r2 = r2 + 6
                goto L_0x00b2
            L_0x007c:
                java.lang.String r8 = "http:"
                boolean r8 = kotlin.text.StringsKt__StringsJVMKt.startsWith(r12, r8, r2, r7)
                if (r8 == 0) goto L_0x008b
                java.lang.String r1 = "http"
                r0.f2864a = r1
                int r2 = r2 + 5
                goto L_0x00b2
            L_0x008b:
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but was '"
                java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
                java.lang.String r1 = r12.substring(r1, r3)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r14)
                r2.append(r1)
                java.lang.String r1 = "'"
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                r2.<init>(r1)
                throw r2
            L_0x00aa:
                if (r29 == 0) goto L_0x04a8
                java.lang.String r1 = r29.mo28146m()
                r0.f2864a = r1
            L_0x00b2:
                r1 = 0
                r3 = r2
            L_0x00b4:
                r8 = 47
                r9 = 92
                if (r3 >= r13) goto L_0x00c7
                char r10 = r12.charAt(r3)
                if (r10 == r9) goto L_0x00c2
                if (r10 != r8) goto L_0x00c7
            L_0x00c2:
                int r1 = r1 + 1
                int r3 = r3 + 1
                goto L_0x00b4
            L_0x00c7:
                r3 = 63
                r10 = 35
                if (r1 >= r4) goto L_0x0117
                if (r29 == 0) goto L_0x0117
                java.lang.String r4 = r29.mo28146m()
                java.lang.String r11 = r0.f2864a
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r11)
                r4 = r4 ^ r7
                if (r4 == 0) goto L_0x00dd
                goto L_0x0117
            L_0x00dd:
                java.lang.String r1 = r29.mo28136e()
                r0.f2865b = r1
                java.lang.String r1 = r29.mo28132a()
                r0.f2866c = r1
                java.lang.String r1 = r29.mo28138f()
                r0.f2867d = r1
                int r1 = r29.mo28143j()
                r0.f2868e = r1
                java.util.List<java.lang.String> r1 = r0.f2869f
                r1.clear()
                java.util.List<java.lang.String> r1 = r0.f2869f
                java.util.List r3 = r29.mo28134c()
                r1.addAll(r3)
                if (r2 == r13) goto L_0x010b
                char r1 = r12.charAt(r2)
                if (r1 != r10) goto L_0x0112
            L_0x010b:
                java.lang.String r1 = r29.mo28135d()
                r0.mo28152a((java.lang.String) r1)
            L_0x0112:
                r1 = 1
                r17 = r13
                goto L_0x02ce
            L_0x0117:
                int r2 = r2 + r1
                r1 = 0
                r4 = 0
                r11 = r2
                r15 = 0
                r16 = 0
            L_0x011e:
                java.lang.String r1 = "@/\\?#"
                int r7 = p040i.p103M.C1764b.m2614a((java.lang.String) r12, (java.lang.String) r1, (int) r11, (int) r13)
                if (r7 == r13) goto L_0x012b
                char r1 = r12.charAt(r7)
                goto L_0x012c
            L_0x012b:
                r1 = -1
            L_0x012c:
                if (r1 == r6) goto L_0x01f5
                if (r1 == r10) goto L_0x01f5
                if (r1 == r8) goto L_0x01f5
                if (r1 == r9) goto L_0x01f5
                if (r1 == r3) goto L_0x01f5
                r2 = 64
                if (r1 == r2) goto L_0x013e
                r17 = r13
                goto L_0x01e6
            L_0x013e:
                java.lang.String r10 = "%40"
                if (r15 != 0) goto L_0x01ab
                int r9 = p040i.p103M.C1764b.m2608a((java.lang.String) r12, (char) r5, (int) r11, (int) r7)
                i.z$b r1 = p040i.C1955z.f2852l
                r6 = 1
                r8 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 240(0xf0, float:3.36E-43)
                java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
                r2 = r30
                r3 = r11
                r4 = r9
                r11 = r7
                r7 = r8
                r8 = r17
                r21 = r9
                r9 = r18
                r22 = r10
                r10 = r19
                r29 = r15
                r15 = r11
                r11 = r20
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r16 == 0) goto L_0x0185
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r0.f2865b
                r2.append(r3)
                r3 = r22
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
            L_0x0185:
                r0.f2865b = r1
                r1 = r21
                if (r1 == r15) goto L_0x01a4
                i.z$b r2 = p040i.C1955z.f2852l
                int r3 = r1 + 1
                r6 = 1
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 240(0xf0, float:3.36E-43)
                java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
                r1 = r2
                r2 = r30
                r4 = r15
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r0.f2866c = r1
                r1 = 1
                goto L_0x01a6
            L_0x01a4:
                r1 = r29
            L_0x01a6:
                r16 = 1
                r17 = r13
                goto L_0x01e3
            L_0x01ab:
                r3 = r10
                r29 = r15
                r15 = r7
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r1 = r0.f2866c
                r10.append(r1)
                r10.append(r3)
                i.z$b r1 = p040i.C1955z.f2852l
                r6 = 1
                r7 = 0
                r8 = 0
                r9 = 0
                r17 = 0
                r18 = 240(0xf0, float:3.36E-43)
                java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
                r2 = r30
                r3 = r11
                r4 = r15
                r11 = r10
                r10 = r17
                r17 = r13
                r13 = r11
                r11 = r18
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r13.append(r1)
                java.lang.String r1 = r13.toString()
                r0.f2866c = r1
                r1 = r29
            L_0x01e3:
                int r11 = r15 + 1
                r15 = r1
            L_0x01e6:
                r10 = 35
                r3 = 63
                r9 = 92
                r8 = 47
                r6 = -1
                r5 = 58
                r13 = r17
                goto L_0x011e
            L_0x01f5:
                r15 = r7
                r17 = r13
                r7 = r11
            L_0x01f9:
                if (r7 >= r15) goto L_0x021a
                char r1 = r12.charAt(r7)
                r2 = 58
                if (r1 == r2) goto L_0x0217
                r2 = 91
                if (r1 == r2) goto L_0x0208
                goto L_0x0214
            L_0x0208:
                int r7 = r7 + 1
                if (r7 >= r15) goto L_0x0214
                char r1 = r12.charAt(r7)
                r2 = 93
                if (r1 != r2) goto L_0x0208
            L_0x0214:
                int r7 = r7 + 1
                goto L_0x01f9
            L_0x0217:
                r1 = 1
                r10 = r7
                goto L_0x021c
            L_0x021a:
                r1 = 1
                r10 = r15
            L_0x021c:
                r13 = 1
                int r9 = r10 + 1
                if (r9 >= r15) goto L_0x0298
                i.z$b r1 = p040i.C1955z.f2852l
                r5 = 0
                r6 = 4
                r2 = r30
                r3 = r11
                r4 = r10
                java.lang.String r1 = p040i.C1955z.C1958b.m3424a(r1, r2, r3, r4, r5, r6)
                java.lang.String r1 = p040i.p103M.C1763a.m2602a(r1)
                r0.f2867d = r1
                i.z$b r1 = p040i.C1955z.f2852l     // Catch:{ NumberFormatException -> 0x0261 }
                java.lang.String r5 = ""
                r6 = 0
                r7 = 0
                r8 = 0
                r16 = 0
                r18 = 0
                r19 = 248(0xf8, float:3.48E-43)
                r2 = r30
                r3 = r9
                r4 = r15
                r23 = r9
                r9 = r16
                r29 = r10
                r10 = r18
                r16 = r11
                r11 = r19
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ NumberFormatException -> 0x0267 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0267 }
                r2 = 65535(0xffff, float:9.1834E-41)
                if (r13 <= r1) goto L_0x025e
                goto L_0x0267
            L_0x025e:
                if (r2 < r1) goto L_0x0267
                goto L_0x0268
            L_0x0261:
                r23 = r9
                r29 = r10
                r16 = r11
            L_0x0267:
                r1 = -1
            L_0x0268:
                r0.f2868e = r1
                r2 = -1
                if (r1 == r2) goto L_0x026f
                r1 = 1
                goto L_0x0270
            L_0x026f:
                r1 = 0
            L_0x0270:
                if (r1 == 0) goto L_0x0273
                goto L_0x02c1
            L_0x0273:
                java.lang.String r1 = "Invalid URL port: \""
                java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
                r10 = r23
                java.lang.String r2 = r12.substring(r10, r15)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r14)
                r1.append(r2)
                r2 = 34
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.String r1 = r1.toString()
                r2.<init>(r1)
                throw r2
            L_0x0298:
                r29 = r10
                r16 = r11
                r7 = 34
                i.z$b r1 = p040i.C1955z.f2852l
                r5 = 0
                r6 = 4
                r2 = r30
                r3 = r16
                r4 = r29
                java.lang.String r1 = p040i.C1955z.C1958b.m3424a(r1, r2, r3, r4, r5, r6)
                java.lang.String r1 = p040i.p103M.C1763a.m2602a(r1)
                r0.f2867d = r1
                i.z$b r1 = p040i.C1955z.f2852l
                java.lang.String r2 = r0.f2864a
                if (r2 != 0) goto L_0x02bb
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x02bb:
                int r1 = r1.mo28169a(r2)
                r0.f2868e = r1
            L_0x02c1:
                r1 = 34
                java.lang.String r2 = r0.f2867d
                if (r2 == 0) goto L_0x02c9
                r2 = 1
                goto L_0x02ca
            L_0x02c9:
                r2 = 0
            L_0x02ca:
                if (r2 == 0) goto L_0x0483
                r1 = r13
                r2 = r15
            L_0x02ce:
                java.lang.String r3 = "?#"
                r4 = r17
                int r3 = p040i.p103M.C1764b.m2614a((java.lang.String) r12, (java.lang.String) r3, (int) r2, (int) r4)
                if (r2 != r3) goto L_0x02dd
                r15 = r0
                r14 = r4
                r13 = r12
                goto L_0x042b
            L_0x02dd:
                char r5 = r12.charAt(r2)
                java.lang.String r6 = ""
                r7 = 47
                if (r5 == r7) goto L_0x0304
                r7 = 92
                if (r5 != r7) goto L_0x02ec
                goto L_0x0304
            L_0x02ec:
                java.util.List<java.lang.String> r5 = r0.f2869f
                int r7 = r5.size()
                int r7 = r7 - r1
                r5.set(r7, r6)
                r10 = r0
                r16 = r10
                r14 = r1
                r15 = r3
                r17 = r4
                r11 = r6
                r1 = r12
                r9 = r1
                r13 = r9
                r4 = r2
                r12 = r15
                goto L_0x0324
            L_0x0304:
                java.util.List<java.lang.String> r5 = r0.f2869f
                r5.clear()
                java.util.List<java.lang.String> r5 = r0.f2869f
                r5.add(r6)
                r8 = r0
                r9 = r8
                r5 = r3
                r13 = r4
                r7 = r6
                r4 = r2
                r6 = r5
                r2 = r12
                r3 = r1
                r1 = r2
            L_0x0318:
                int r4 = r4 + r3
                r14 = r3
                r15 = r5
                r11 = r7
                r16 = r8
                r10 = r9
                r9 = r12
                r17 = r13
                r13 = r2
                r12 = r6
            L_0x0324:
                if (r4 >= r12) goto L_0x0425
                java.lang.String r2 = "/\\"
                int r8 = p040i.p103M.C1764b.m2614a((java.lang.String) r9, (java.lang.String) r2, (int) r4, (int) r12)
                if (r8 >= r12) goto L_0x0332
                r2 = 1
                r18 = 1
                goto L_0x0335
            L_0x0332:
                r2 = 0
                r18 = 0
            L_0x0335:
                r7 = 1
                i.z$b r2 = p040i.C1955z.f2852l
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 240(0xf0, float:3.36E-43)
                java.lang.String r6 = " \"<>^`{}|/\\?#"
                r3 = r9
                r5 = r8
                r24 = r8
                r8 = r19
                r19 = r9
                r9 = r20
                r25 = r10
                r10 = r21
                r26 = r11
                r11 = r22
                r20 = r12
                r12 = r23
                java.lang.String r2 = p040i.C1955z.C1958b.m3423a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                java.lang.String r3 = "."
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x0371
                java.lang.String r3 = "%2e"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r2, r3, r14)
                if (r3 == 0) goto L_0x036f
                goto L_0x0371
            L_0x036f:
                r3 = 0
                goto L_0x0372
            L_0x0371:
                r3 = 1
            L_0x0372:
                if (r3 == 0) goto L_0x037a
                r9 = r25
                r6 = r26
                goto L_0x0409
            L_0x037a:
                java.lang.String r3 = ".."
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x039d
                java.lang.String r3 = "%2e."
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r2, r3, r14)
                if (r3 != 0) goto L_0x039d
                java.lang.String r3 = ".%2e"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r2, r3, r14)
                if (r3 != 0) goto L_0x039d
                java.lang.String r3 = "%2e%2e"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r2, r3, r14)
                if (r3 == 0) goto L_0x039b
                goto L_0x039d
            L_0x039b:
                r3 = 0
                goto L_0x039e
            L_0x039d:
                r3 = 1
            L_0x039e:
                if (r3 == 0) goto L_0x03d8
                r9 = r25
                java.util.List<java.lang.String> r2 = r9.f2869f
                int r3 = r2.size()
                int r3 = r3 - r14
                java.lang.Object r2 = r2.remove(r3)
                java.lang.String r2 = (java.lang.String) r2
                int r2 = r2.length()
                if (r2 != 0) goto L_0x03b7
                r2 = 1
                goto L_0x03b8
            L_0x03b7:
                r2 = 0
            L_0x03b8:
                if (r2 == 0) goto L_0x03d0
                java.util.List<java.lang.String> r2 = r9.f2869f
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ r14
                if (r2 == 0) goto L_0x03d0
                java.util.List<java.lang.String> r2 = r9.f2869f
                int r3 = r2.size()
                int r3 = r3 - r14
                r6 = r26
                r2.set(r3, r6)
                goto L_0x0409
            L_0x03d0:
                r6 = r26
                java.util.List<java.lang.String> r2 = r9.f2869f
                r2.add(r6)
                goto L_0x0409
            L_0x03d8:
                r9 = r25
                r6 = r26
                java.util.List<java.lang.String> r3 = r9.f2869f
                int r4 = r3.size()
                int r4 = r4 - r14
                java.lang.Object r3 = r3.get(r4)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 != 0) goto L_0x03f1
                r3 = 1
                goto L_0x03f2
            L_0x03f1:
                r3 = 0
            L_0x03f2:
                java.util.List<java.lang.String> r4 = r9.f2869f
                if (r3 == 0) goto L_0x03ff
                int r3 = r4.size()
                int r3 = r3 - r14
                r4.set(r3, r2)
                goto L_0x0402
            L_0x03ff:
                r4.add(r2)
            L_0x0402:
                if (r18 == 0) goto L_0x0409
                java.util.List<java.lang.String> r2 = r9.f2869f
                r2.add(r6)
            L_0x0409:
                if (r18 == 0) goto L_0x041b
                r7 = r6
                r2 = r13
                r3 = r14
                r5 = r15
                r8 = r16
                r13 = r17
                r12 = r19
                r6 = r20
                r4 = r24
                goto L_0x0318
            L_0x041b:
                r11 = r6
                r10 = r9
                r9 = r19
                r12 = r20
                r4 = r24
                goto L_0x0324
            L_0x0425:
                r12 = r1
                r3 = r15
                r15 = r16
                r14 = r17
            L_0x042b:
                if (r3 >= r14) goto L_0x0463
                char r1 = r13.charAt(r3)
                r2 = 63
                if (r1 != r2) goto L_0x0463
                r11 = 35
                int r16 = p040i.p103M.C1764b.m2608a((java.lang.String) r13, (char) r11, (int) r3, (int) r14)
                i.z$b r10 = p040i.C1955z.f2852l
                int r3 = r3 + 1
                r6 = 1
                r7 = 0
                r8 = 1
                r9 = 0
                r17 = 0
                r18 = 208(0xd0, float:2.91E-43)
                java.lang.String r5 = " \"'<>#"
                r1 = r10
                r2 = r12
                r4 = r16
                r27 = r10
                r10 = r17
                r17 = 35
                r11 = r18
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r2 = r27
                java.util.List r1 = r2.mo28172c(r1)
                r15.f2870g = r1
                r3 = r16
            L_0x0463:
                r11 = 35
                if (r3 >= r14) goto L_0x0482
                char r1 = r13.charAt(r3)
                if (r1 != r11) goto L_0x0482
                i.z$b r1 = p040i.C1955z.f2852l
                int r3 = r3 + 1
                r6 = 1
                r7 = 0
                r8 = 0
                r9 = 1
                r10 = 0
                r11 = 176(0xb0, float:2.47E-43)
                java.lang.String r5 = ""
                r2 = r12
                r4 = r14
                java.lang.String r1 = p040i.C1955z.C1958b.m3423a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r15.f2871h = r1
            L_0x0482:
                return r15
            L_0x0483:
                java.lang.String r2 = "Invalid URL host: \""
                java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
                r15 = r29
                r11 = r16
                java.lang.String r3 = r12.substring(r11, r15)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r14)
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.String r1 = r1.toString()
                r2.<init>(r1)
                throw r2
            L_0x04a8:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Expected URL scheme 'http' or 'https' but no colon was found"
                r1.<init>(r2)
                goto L_0x04b1
            L_0x04b0:
                throw r1
            L_0x04b1:
                goto L_0x04b0
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.C1955z.C1956a.mo28151a(i.z, java.lang.String):i.z$a");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r12 = p040i.C1955z.C1958b.m3423a(p040i.C1955z.f2852l, r12, 0, 0, " \"'<>#", true, false, true, false, (java.nio.charset.Charset) null, 211);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p040i.C1955z.C1956a mo28152a(java.lang.String r12) {
            /*
                r11 = this;
                if (r12 == 0) goto L_0x001d
                i.z$b r0 = p040i.C1955z.f2852l
                r2 = 0
                r3 = 0
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 0
                r9 = 0
                r10 = 211(0xd3, float:2.96E-43)
                java.lang.String r4 = " \"'<>#"
                r1 = r12
                java.lang.String r12 = p040i.C1955z.C1958b.m3423a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r12 == 0) goto L_0x001d
                i.z$b r0 = p040i.C1955z.f2852l
                java.util.List r12 = r0.mo28172c(r12)
                goto L_0x001e
            L_0x001d:
                r12 = 0
            L_0x001e:
                r11.f2870g = r12
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.C1955z.C1956a.mo28152a(java.lang.String):i.z$a");
        }

        /* renamed from: a */
        public final C1956a mo28153a(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "encodedName");
            if (this.f2870g == null) {
                this.f2870g = new ArrayList();
            }
            List<String> list = this.f2870g;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            list.add(C1958b.m3423a(C1955z.f2852l, str, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211));
            List<String> list2 = this.f2870g;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            list2.add(str2 != null ? C1958b.m3423a(C1955z.f2852l, str2, 0, 0, " \"'<>#&=", true, false, true, false, (Charset) null, 211) : null);
            return this;
        }

        /* renamed from: a */
        public final C1955z mo28154a() {
            ArrayList arrayList;
            String str = this.f2864a;
            if (str != null) {
                String a = C1958b.m3424a(C1955z.f2852l, this.f2865b, 0, 0, false, 7);
                String a2 = C1958b.m3424a(C1955z.f2852l, this.f2866c, 0, 0, false, 7);
                String str2 = this.f2867d;
                if (str2 != null) {
                    int d = m3404d();
                    List<String> list = this.f2869f;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (String a3 : list) {
                        arrayList2.add(C1958b.m3424a(C1955z.f2852l, a3, 0, 0, false, 7));
                    }
                    List<String> list2 = this.f2870g;
                    String str3 = null;
                    if (list2 != null) {
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        for (String str4 : list2) {
                            arrayList3.add(str4 != null ? C1958b.m3424a(C1955z.f2852l, str4, 0, 0, true, 3) : null);
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                    }
                    String str5 = this.f2871h;
                    if (str5 != null) {
                        str3 = C1958b.m3424a(C1955z.f2852l, str5, 0, 0, false, 7);
                    }
                    return new C1955z(str, a, a2, str2, d, arrayList2, arrayList, str3, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* renamed from: b */
        public final C1956a mo28155b(String str) {
            Intrinsics.checkParameterIsNotNull(str, "host");
            String a = C1763a.m2602a(C1958b.m3424a(C1955z.f2852l, str, 0, 0, false, 7));
            if (a != null) {
                this.f2867d = a;
                return this;
            }
            throw new IllegalArgumentException(C0681a.m320a("unexpected host: ", str));
        }

        /* renamed from: b */
        public final C1956a mo28156b(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (this.f2870g == null) {
                this.f2870g = new ArrayList();
            }
            List<String> list = this.f2870g;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            list.add(C1958b.m3423a(C1955z.f2852l, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219));
            List<String> list2 = this.f2870g;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            list2.add(str2 != null ? C1958b.m3423a(C1955z.f2852l, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, (Charset) null, 219) : null);
            return this;
        }

        /* renamed from: b */
        public final List<String> mo28157b() {
            return this.f2869f;
        }

        /* renamed from: b */
        public final void mo28158b(int i) {
            this.f2868e = i;
        }

        /* renamed from: c */
        public final C1956a mo28159c() {
            String str = this.f2867d;
            String str2 = null;
            this.f2867d = str != null ? new Regex("[\"<>^`{|}]").replace((CharSequence) str, "") : null;
            int size = this.f2869f.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.f2869f;
                list.set(i, C1958b.m3423a(C1955z.f2852l, list.get(i), 0, 0, "[]", true, true, false, false, (Charset) null, 227));
            }
            List<String> list2 = this.f2870g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str3 = list2.get(i2);
                    list2.set(i2, str3 != null ? C1958b.m3423a(C1955z.f2852l, str3, 0, 0, "\\^`{|}", true, true, true, false, (Charset) null, 195) : null);
                }
            }
            String str4 = this.f2871h;
            if (str4 != null) {
                str2 = C1958b.m3423a(C1955z.f2852l, str4, 0, 0, " \"#<>\\^`{|}", true, true, false, true, (Charset) null, 163);
            }
            this.f2871h = str2;
            return this;
        }

        /* renamed from: c */
        public final C1956a mo28160c(String str) {
            Intrinsics.checkParameterIsNotNull(str, "password");
            this.f2866c = C1958b.m3423a(C1955z.f2852l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251);
            return this;
        }

        /* renamed from: d */
        public final C1956a mo28161d(String str) {
            Intrinsics.checkParameterIsNotNull(str, "scheme");
            String str2 = "http";
            if (!StringsKt__StringsJVMKt.equals(str, str2, true)) {
                str2 = "https";
                if (!StringsKt__StringsJVMKt.equals(str, str2, true)) {
                    throw new IllegalArgumentException(C0681a.m320a("unexpected scheme: ", str));
                }
            }
            this.f2864a = str2;
            return this;
        }

        /* renamed from: e */
        public final void mo28162e(String str) {
            this.f2871h = str;
        }

        /* renamed from: f */
        public final void mo28163f(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.f2866c = str;
        }

        /* renamed from: g */
        public final void mo28164g(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.f2865b = str;
        }

        /* renamed from: h */
        public final void mo28165h(String str) {
            this.f2867d = str;
        }

        /* renamed from: i */
        public final void mo28166i(String str) {
            this.f2864a = str;
        }

        /* renamed from: j */
        public final C1956a mo28167j(String str) {
            Intrinsics.checkParameterIsNotNull(str, "username");
            this.f2865b = C1958b.m3423a(C1955z.f2852l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251);
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
            if ((r6.f2866c.length() > 0) != false) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
            if (r1 != r5.mo28169a(r2)) goto L_0x0094;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.f2864a
                if (r1 == 0) goto L_0x000f
                r0.append(r1)
                java.lang.String r1 = "://"
                goto L_0x0011
            L_0x000f:
                java.lang.String r1 = "//"
            L_0x0011:
                r0.append(r1)
                java.lang.String r1 = r6.f2865b
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L_0x0020
                r1 = 1
                goto L_0x0021
            L_0x0020:
                r1 = 0
            L_0x0021:
                r4 = 58
                if (r1 != 0) goto L_0x0032
                java.lang.String r1 = r6.f2866c
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x002f
                r1 = 1
                goto L_0x0030
            L_0x002f:
                r1 = 0
            L_0x0030:
                if (r1 == 0) goto L_0x0050
            L_0x0032:
                java.lang.String r1 = r6.f2865b
                r0.append(r1)
                java.lang.String r1 = r6.f2866c
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0040
                goto L_0x0041
            L_0x0040:
                r2 = 0
            L_0x0041:
                if (r2 == 0) goto L_0x004b
                r0.append(r4)
                java.lang.String r1 = r6.f2866c
                r0.append(r1)
            L_0x004b:
                r1 = 64
                r0.append(r1)
            L_0x0050:
                java.lang.String r1 = r6.f2867d
                if (r1 == 0) goto L_0x0076
                if (r1 != 0) goto L_0x0059
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0059:
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r1, (char) r4, (boolean) r3, (int) r2, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0071
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.f2867d
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L_0x0076
            L_0x0071:
                java.lang.String r1 = r6.f2867d
                r0.append(r1)
            L_0x0076:
                int r1 = r6.f2868e
                r2 = -1
                if (r1 != r2) goto L_0x007f
                java.lang.String r1 = r6.f2864a
                if (r1 == 0) goto L_0x009a
            L_0x007f:
                int r1 = r6.m3404d()
                java.lang.String r2 = r6.f2864a
                if (r2 == 0) goto L_0x0094
                i.z$b r5 = p040i.C1955z.f2852l
                if (r2 != 0) goto L_0x008e
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x008e:
                int r2 = r5.mo28169a(r2)
                if (r1 == r2) goto L_0x009a
            L_0x0094:
                r0.append(r4)
                r0.append(r1)
            L_0x009a:
                i.z$b r1 = p040i.C1955z.f2852l
                java.util.List<java.lang.String> r1 = r6.f2869f
                java.lang.String r2 = "$this$toPathString"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)
                java.lang.String r2 = "out"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)
                int r2 = r1.size()
            L_0x00ac:
                if (r3 >= r2) goto L_0x00bf
                r4 = 47
                r0.append(r4)
                java.lang.Object r4 = r1.get(r3)
                java.lang.String r4 = (java.lang.String) r4
                r0.append(r4)
                int r3 = r3 + 1
                goto L_0x00ac
            L_0x00bf:
                java.util.List<java.lang.String> r1 = r6.f2870g
                if (r1 == 0) goto L_0x00d4
                r1 = 63
                r0.append(r1)
                i.z$b r1 = p040i.C1955z.f2852l
                java.util.List<java.lang.String> r2 = r6.f2870g
                if (r2 != 0) goto L_0x00d1
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00d1:
                r1.mo28170a(r2, r0)
            L_0x00d4:
                java.lang.String r1 = r6.f2871h
                if (r1 == 0) goto L_0x00e2
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.f2871h
                r0.append(r1)
            L_0x00e2:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.C1955z.C1956a.toString():java.lang.String");
        }
    }

    public C1955z(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        Intrinsics.checkParameterIsNotNull(str2, "username");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        Intrinsics.checkParameterIsNotNull(str4, "host");
        Intrinsics.checkParameterIsNotNull(list, "pathSegments");
        Intrinsics.checkParameterIsNotNull(str6, ImagesContract.URL);
        this.f2854b = str;
        this.f2855c = str2;
        this.f2856d = str3;
        this.f2857e = str4;
        this.f2858f = i;
        this.f2859g = list;
        this.f2860h = list2;
        this.f2861i = str5;
        this.f2862j = str6;
        this.f2853a = Intrinsics.areEqual((Object) str, (Object) "https");
    }

    /* renamed from: a */
    public final C1956a mo28131a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "link");
        try {
            C1956a aVar = new C1956a();
            aVar.mo28151a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @JvmName(name = "encodedPassword")
    /* renamed from: a */
    public final String mo28132a() {
        if (this.f2856d.length() == 0) {
            return "";
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, ':', this.f2854b.length() + 3, false, 4, (Object) null) + 1;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, '@', 0, false, 6, (Object) null);
        String str = this.f2862j;
        if (str != null) {
            String substring = str.substring(indexOf$default, indexOf$default2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName(name = "encodedPath")
    /* renamed from: b */
    public final String mo28133b() {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, '/', this.f2854b.length() + 3, false, 4, (Object) null);
        String str = this.f2862j;
        int a = C1764b.m2614a(str, "?#", indexOf$default, str.length());
        String str2 = this.f2862j;
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, a);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName(name = "encodedPathSegments")
    /* renamed from: c */
    public final List<String> mo28134c() {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, '/', this.f2854b.length() + 3, false, 4, (Object) null);
        String str = this.f2862j;
        int a = C1764b.m2614a(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < a) {
            int i = indexOf$default + 1;
            int a2 = C1764b.m2608a(this.f2862j, '/', i, a);
            String str2 = this.f2862j;
            if (str2 != null) {
                String substring = str2.substring(i, a2);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(substring);
                indexOf$default = a2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    @JvmName(name = "encodedQuery")
    /* renamed from: d */
    public final String mo28135d() {
        if (this.f2860h == null) {
            return null;
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, '?', 0, false, 6, (Object) null) + 1;
        String str = this.f2862j;
        int a = C1764b.m2608a(str, '#', indexOf$default, str.length());
        String str2 = this.f2862j;
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, a);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName(name = "encodedUsername")
    /* renamed from: e */
    public final String mo28136e() {
        if (this.f2855c.length() == 0) {
            return "";
        }
        int length = this.f2854b.length() + 3;
        String str = this.f2862j;
        int a = C1764b.m2614a(str, ":@", length, str.length());
        String str2 = this.f2862j;
        if (str2 != null) {
            String substring = str2.substring(length, a);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1955z) && Intrinsics.areEqual((Object) ((C1955z) obj).f2862j, (Object) this.f2862j);
    }

    @JvmName(name = "host")
    /* renamed from: f */
    public final String mo28138f() {
        return this.f2857e;
    }

    /* renamed from: g */
    public final boolean mo28139g() {
        return this.f2853a;
    }

    /* renamed from: h */
    public final C1956a mo28140h() {
        String str;
        C1956a aVar = new C1956a();
        aVar.mo28166i(this.f2854b);
        aVar.mo28164g(mo28136e());
        aVar.mo28163f(mo28132a());
        aVar.mo28165h(this.f2857e);
        aVar.mo28158b(this.f2858f != f2852l.mo28169a(this.f2854b) ? this.f2858f : -1);
        aVar.mo28157b().clear();
        aVar.mo28157b().addAll(mo28134c());
        aVar.mo28152a(mo28135d());
        if (this.f2861i == null) {
            str = null;
        } else {
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f2862j, '#', 0, false, 6, (Object) null) + 1;
            String str2 = this.f2862j;
            if (str2 != null) {
                str = str2.substring(indexOf$default);
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        aVar.mo28162e(str);
        return aVar;
    }

    public int hashCode() {
        return this.f2862j.hashCode();
    }

    @JvmName(name = "pathSegments")
    /* renamed from: i */
    public final List<String> mo28142i() {
        return this.f2859g;
    }

    @JvmName(name = "port")
    /* renamed from: j */
    public final int mo28143j() {
        return this.f2858f;
    }

    @JvmName(name = "query")
    /* renamed from: k */
    public final String mo28144k() {
        if (this.f2860h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f2852l.mo28170a(this.f2860h, sb);
        return sb.toString();
    }

    /* renamed from: l */
    public final String mo28145l() {
        C1956a a = mo28131a("/...");
        if (a == null) {
            Intrinsics.throwNpe();
        }
        a.mo28167j("");
        a.mo28160c("");
        return a.mo28154a().f2862j;
    }

    @JvmName(name = "scheme")
    /* renamed from: m */
    public final String mo28146m() {
        return this.f2854b;
    }

    @JvmName(name = "uri")
    /* renamed from: n */
    public final URI mo28147n() {
        C1956a h = mo28140h();
        h.mo28159c();
        String aVar = h.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace((CharSequence) aVar, ""));
                Intrinsics.checkExpressionValueIsNotNull(create, "URI.create(stripped)");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @JvmName(name = "url")
    /* renamed from: o */
    public final URL mo28148o() {
        try {
            return new URL(this.f2862j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.f2862j;
    }

    /* renamed from: i.z$b */
    public static final class C1958b {
        public /* synthetic */ C1958b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static /* synthetic */ String m3423a(C1958b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3) {
            boolean z5;
            C1958b bVar2 = bVar;
            String str3 = str;
            String str4 = str2;
            int i4 = i3;
            int i5 = (i4 & 1) != 0 ? 0 : i;
            int length = (i4 & 2) != 0 ? str.length() : i2;
            boolean z6 = (i4 & 8) != 0 ? false : z;
            boolean z7 = (i4 & 16) != 0 ? false : z2;
            boolean z8 = (i4 & 32) != 0 ? false : z3;
            boolean z9 = (i4 & 64) != 0 ? false : z4;
            int i6 = 128;
            Charset charset2 = (i4 & 128) != 0 ? null : charset;
            if (bVar2 != null) {
                Intrinsics.checkParameterIsNotNull(str3, "$this$canonicalize");
                Intrinsics.checkParameterIsNotNull(str4, "encodeSet");
                int i7 = i5;
                while (i7 < length) {
                    int codePointAt = str3.codePointAt(i7);
                    if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= i6 && !z9) || StringsKt__StringsKt.contains$default((CharSequence) str4, (char) codePointAt, false, 2, (Object) null) || ((codePointAt == 37 && (!z6 || (z7 && !bVar2.m3425a(str3, i7, length)))) || (codePointAt == 43 && z8)))) {
                        C2068f fVar = new C2068f();
                        fVar.mo29139a(str3, i5, i7);
                        C2068f fVar2 = null;
                        while (i7 < length) {
                            int codePointAt2 = str3.codePointAt(i7);
                            if (!z6 || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                                if (codePointAt2 != 43 || !z8) {
                                    if (codePointAt2 < 32 || codePointAt2 == 127 || (codePointAt2 >= 128 && !z9)) {
                                        z5 = z8;
                                    } else {
                                        z5 = z8;
                                        if (!StringsKt__StringsKt.contains$default((CharSequence) str4, (char) codePointAt2, false, 2, (Object) null) && (codePointAt2 != 37 || (z6 && (!z7 || bVar2.m3425a(str3, i7, length))))) {
                                            fVar.mo29150c(codePointAt2);
                                            i7 += Character.charCount(codePointAt2);
                                            z8 = z5;
                                        }
                                    }
                                    if (fVar2 == null) {
                                        fVar2 = new C2068f();
                                    }
                                    if (charset2 == null || Intrinsics.areEqual((Object) charset2, (Object) StandardCharsets.UTF_8)) {
                                        fVar2.mo29150c(codePointAt2);
                                    } else {
                                        fVar2.mo29140a(str3, i7, Character.charCount(codePointAt2) + i7, charset2);
                                    }
                                    while (!fVar2.mo29152c()) {
                                        byte readByte = fVar2.readByte() & UByte.MAX_VALUE;
                                        fVar.writeByte(37);
                                        fVar.writeByte((int) C1955z.f2851k[(readByte >> 4) & 15]);
                                        fVar.writeByte((int) C1955z.f2851k[readByte & 15]);
                                    }
                                    i7 += Character.charCount(codePointAt2);
                                    z8 = z5;
                                } else {
                                    fVar.mo29138a(z6 ? "+" : "%2B");
                                }
                            }
                            z5 = z8;
                            i7 += Character.charCount(codePointAt2);
                            z8 = z5;
                        }
                        return fVar.mo29175o();
                    }
                    i7 += Character.charCount(codePointAt);
                    i6 = 128;
                }
                String substring = str3.substring(i5, length);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw null;
        }

        /* renamed from: a */
        private final boolean m3425a(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && C1764b.m2605a(str.charAt(i + 1)) != -1 && C1764b.m2605a(str.charAt(i3)) != -1;
        }

        @JvmStatic
        /* renamed from: a */
        public final int mo28169a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "scheme");
            int hashCode = str.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && str.equals("https")) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        /* renamed from: a */
        public final void mo28170a(List<String> list, StringBuilder sb) {
            Intrinsics.checkParameterIsNotNull(list, "$this$toQueryString");
            Intrinsics.checkParameterIsNotNull(sb, "out");
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, list.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return;
                }
            } else if (first < last) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }

        @JvmStatic
        @JvmName(name = "get")
        /* renamed from: b */
        public final C1955z mo28171b(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toHttpUrl");
            C1956a aVar = new C1956a();
            aVar.mo28151a((C1955z) null, str);
            return aVar.mo28154a();
        }

        /* renamed from: c */
        public final List<String> mo28172c(String str) {
            String str2;
            Intrinsics.checkParameterIsNotNull(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) Typography.amp, i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int i2 = indexOf$default;
                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (indexOf$default2 == -1 || indexOf$default2 > i2) {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str2 = null;
                } else {
                    String substring2 = str.substring(i, indexOf$default2);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str2 = str.substring(indexOf$default2 + 1, i2);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(str2);
                i = i2 + 1;
            }
            return arrayList;
        }

        /* renamed from: a */
        public static /* synthetic */ String m3424a(C1958b bVar, String str, int i, int i2, boolean z, int i3) {
            int i4;
            int i5;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            if (bVar != null) {
                Intrinsics.checkParameterIsNotNull(str, "$this$percentDecode");
                int i6 = i;
                while (i4 < i2) {
                    char charAt = str.charAt(i4);
                    if (charAt == '%' || (charAt == '+' && z)) {
                        C2068f fVar = new C2068f();
                        fVar.mo29139a(str, i, i4);
                        while (i4 < i2) {
                            int codePointAt = str.codePointAt(i4);
                            if (codePointAt == 37 && (i5 = i4 + 2) < i2) {
                                int a = C1764b.m2605a(str.charAt(i4 + 1));
                                int a2 = C1764b.m2605a(str.charAt(i5));
                                if (!(a == -1 || a2 == -1)) {
                                    fVar.writeByte((a << 4) + a2);
                                    i4 = Character.charCount(codePointAt) + i5;
                                }
                            } else if (codePointAt == 43 && z) {
                                fVar.writeByte(32);
                                i4++;
                            }
                            fVar.mo29150c(codePointAt);
                            i4 += Character.charCount(codePointAt);
                        }
                        return fVar.mo29175o();
                    }
                    i6 = i4 + 1;
                }
                String substring = str.substring(i, i2);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw null;
        }
    }
}
