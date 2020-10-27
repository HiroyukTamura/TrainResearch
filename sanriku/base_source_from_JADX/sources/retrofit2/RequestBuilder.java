package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0976G;
import p040i.C1746B;
import p040i.C1748C;
import p040i.C1755F;
import p040i.C1946u;
import p040i.C1952y;
import p040i.C1955z;
import p042j.C2068f;
import p042j.C2071g;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final C1955z baseUrl;
    private C0976G body;
    private C1746B contentType;
    private C1946u.C1947a formBuilder;
    private final boolean hasBody;
    private final C1952y.C1953a headersBuilder;
    private final String method;
    private C1748C.C1749a multipartBuilder;
    private String relativeUrl;
    private final C1755F.C1756a requestBuilder = new C1755F.C1756a();
    private C1955z.C1956a urlBuilder;

    private static class ContentTypeOverridingRequestBody extends C0976G {
        private final C1746B contentType;
        private final C0976G delegate;

        ContentTypeOverridingRequestBody(C0976G g, C1746B b) {
            this.delegate = g;
            this.contentType = b;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public C1746B contentType() {
            return this.contentType;
        }

        public void writeTo(C2071g gVar) throws IOException {
            this.delegate.writeTo(gVar);
        }
    }

    RequestBuilder(String str, C1955z zVar, String str2, C1952y yVar, C1746B b, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = zVar;
        this.relativeUrl = str2;
        this.contentType = b;
        this.hasBody = z;
        this.headersBuilder = yVar != null ? yVar.mo28112a() : new C1952y.C1953a();
        if (z2) {
            this.formBuilder = new C1946u.C1947a();
        } else if (z3) {
            C1748C.C1749a aVar = new C1748C.C1749a();
            this.multipartBuilder = aVar;
            aVar.mo27458a(C1748C.f2085g);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                C2068f fVar = new C2068f();
                fVar.mo29139a(str, 0, i);
                canonicalizeForPath(fVar, str, i, length, z);
                return fVar.mo29175o();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void canonicalizeForPath(C2068f fVar, String str, int i, int i2, boolean z) {
        C2068f fVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (fVar2 == null) {
                        fVar2 = new C2068f();
                    }
                    fVar2.mo29150c(codePointAt);
                    while (!fVar2.mo29152c()) {
                        byte readByte = fVar2.readByte() & UByte.MAX_VALUE;
                        fVar.writeByte(37);
                        fVar.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                        fVar.writeByte((int) HEX_DIGITS[readByte & 15]);
                    }
                } else {
                    fVar.mo29150c(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.mo28104b(str, str2);
        } else {
            this.formBuilder.mo28102a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.contentType = C1746B.m2454a(str2);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(C0681a.m320a("Malformed content type: ", str2), e);
            }
        } else {
            this.headersBuilder.mo28123a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeaders(C1952y yVar) {
        C1952y.C1953a aVar = this.headersBuilder;
        if (aVar != null) {
            Intrinsics.checkParameterIsNotNull(yVar, "headers");
            int size = yVar.size();
            for (int i = 0; i < size; i++) {
                aVar.mo28125b(yVar.mo28113a(i), yVar.mo28115b(i));
            }
            return;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void addPart(C1748C.C1751c cVar) {
        this.multipartBuilder.mo27459a(cVar);
    }

    /* access modifiers changed from: package-private */
    public void addPart(C1952y yVar, C0976G g) {
        C1748C.C1749a aVar = this.multipartBuilder;
        if (aVar != null) {
            Intrinsics.checkParameterIsNotNull(g, "body");
            aVar.mo27459a(C1748C.C1751c.m2467a(yVar, g));
            return;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (!PATH_TRAVERSAL.matcher(replace).matches()) {
                this.relativeUrl = replace;
                return;
            }
            throw new IllegalArgumentException(C0681a.m320a("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str2));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            C1955z.C1956a a = this.baseUrl.mo28131a(str3);
            this.urlBuilder = a;
            if (a != null) {
                this.relativeUrl = null;
            } else {
                StringBuilder a2 = C0681a.m330a("Malformed URL. Base: ");
                a2.append(this.baseUrl);
                a2.append(", Relative: ");
                a2.append(this.relativeUrl);
                throw new IllegalArgumentException(a2.toString());
            }
        }
        if (z) {
            this.urlBuilder.mo28153a(str, str2);
        } else {
            this.urlBuilder.mo28156b(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void addTag(Class<T> cls, T t) {
        this.requestBuilder.mo27547a(cls, t);
    }

    /* access modifiers changed from: package-private */
    public C1755F.C1756a get() {
        C1955z zVar;
        C1955z.C1956a aVar = this.urlBuilder;
        if (aVar != null) {
            zVar = aVar.mo28154a();
        } else {
            C1955z zVar2 = this.baseUrl;
            String str = this.relativeUrl;
            if (zVar2 != null) {
                Intrinsics.checkParameterIsNotNull(str, "link");
                C1955z.C1956a a = zVar2.mo28131a(str);
                zVar = a != null ? a.mo28154a() : null;
                if (zVar == null) {
                    StringBuilder a2 = C0681a.m330a("Malformed URL. Base: ");
                    a2.append(this.baseUrl);
                    a2.append(", Relative: ");
                    a2.append(this.relativeUrl);
                    throw new IllegalArgumentException(a2.toString());
                }
            } else {
                throw null;
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            C1946u.C1947a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.mo28103a();
            } else {
                C1748C.C1749a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.mo27460a();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = C0976G.create((C1746B) null, new byte[0]);
                }
            }
        }
        C1746B b = this.contentType;
        if (b != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, b);
            } else {
                this.headersBuilder.mo28123a("Content-Type", b.toString());
            }
        }
        C1755F.C1756a aVar4 = this.requestBuilder;
        aVar4.mo27546a(zVar);
        aVar4.mo27545a(this.headersBuilder.mo28124a());
        aVar4.mo27549a(this.method, contentTypeOverridingRequestBody);
        return aVar4;
    }

    /* access modifiers changed from: package-private */
    public void setBody(C0976G g) {
        this.body = g;
    }

    /* access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }
}
