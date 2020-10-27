package p040i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1746B;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p042j.C2068f;
import p042j.C2071g;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u001d"}, mo21739d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "encodedNames", "", "", "encodedValues", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "()I", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "encodedName", "index", "encodedValue", "name", "-deprecated_size", "value", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.u */
public final class C1946u extends C0976G {

    /* renamed from: c */
    private static final C1746B f2835c = C1746B.C1747a.m2460a("application/x-www-form-urlencoded");

    /* renamed from: a */
    private final List<String> f2836a;

    /* renamed from: b */
    private final List<String> f2837b;

    /* renamed from: i.u$a */
    public static final class C1947a {

        /* renamed from: a */
        private final List<String> f2838a = new ArrayList();

        /* renamed from: b */
        private final List<String> f2839b = new ArrayList();

        /* renamed from: c */
        private final Charset f2840c = null;

        /* renamed from: a */
        public final C1947a mo28102a(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2838a.add(C1955z.C1958b.m3423a(C1955z.f2852l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f2840c, 91));
            this.f2839b.add(C1955z.C1958b.m3423a(C1955z.f2852l, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f2840c, 91));
            return this;
        }

        /* renamed from: a */
        public final C1946u mo28103a() {
            return new C1946u(this.f2838a, this.f2839b);
        }

        /* renamed from: b */
        public final C1947a mo28104b(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2838a.add(C1955z.C1958b.m3423a(C1955z.f2852l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f2840c, 83));
            this.f2839b.add(C1955z.C1958b.m3423a(C1955z.f2852l, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f2840c, 83));
            return this;
        }
    }

    static {
        C1746B.C1747a aVar = C1746B.f2080f;
    }

    public C1946u(List<String> list, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list, "encodedNames");
        Intrinsics.checkParameterIsNotNull(list2, "encodedValues");
        this.f2836a = C1764b.m2639b(list);
        this.f2837b = C1764b.m2639b(list2);
    }

    /* renamed from: a */
    private final long m3359a(C2071g gVar, boolean z) {
        C2068f fVar;
        if (z) {
            fVar = new C2068f();
        } else {
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            fVar = gVar.getBuffer();
        }
        int size = this.f2836a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                fVar.writeByte(38);
            }
            fVar.mo29138a(this.f2836a.get(i));
            fVar.writeByte(61);
            fVar.mo29138a(this.f2837b.get(i));
        }
        if (!z) {
            return 0;
        }
        long size2 = fVar.size();
        fVar.mo29154d();
        return size2;
    }

    public long contentLength() {
        return m3359a((C2071g) null, true);
    }

    public C1746B contentType() {
        return f2835c;
    }

    public void writeTo(C2071g gVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        m3359a(gVar, false);
    }
}
