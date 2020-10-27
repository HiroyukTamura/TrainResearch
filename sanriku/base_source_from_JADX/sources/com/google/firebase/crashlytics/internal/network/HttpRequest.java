package com.google.firebase.crashlytics.internal.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0976G;
import p040i.C1746B;
import p040i.C1748C;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1921e;
import p040i.C1955z;

public class HttpRequest {
    private static final C1752D CLIENT;
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private C1748C.C1749a bodyBuilder = null;
    private final Map<String, String> headers;
    private final HttpMethod method;
    private final Map<String, String> queryParams;
    private final String url;

    static {
        C1752D.C1753a aVar = new C1752D.C1753a(new C1752D(new C1752D.C1753a()));
        aVar.mo27500a(10000, TimeUnit.MILLISECONDS);
        CLIENT = new C1752D(aVar);
    }

    public HttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        this.method = httpMethod;
        this.url = str;
        this.queryParams = map;
        this.headers = new HashMap();
    }

    private C1755F build() {
        C1955z zVar;
        C1755F.C1756a aVar = new C1755F.C1756a();
        C1921e.C1922a aVar2 = new C1921e.C1922a();
        aVar2.mo28052b();
        aVar.mo27544a(aVar2.mo28051a());
        String str = this.url;
        C1955z.C1958b bVar = C1955z.f2852l;
        Intrinsics.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        C1748C c = null;
        try {
            zVar = bVar.mo28171b(str);
        } catch (IllegalArgumentException unused) {
            zVar = null;
        }
        C1955z.C1956a h = zVar.mo28140h();
        for (Map.Entry next : this.queryParams.entrySet()) {
            h.mo28153a((String) next.getKey(), (String) next.getValue());
        }
        aVar.mo27546a(h.mo28154a());
        for (Map.Entry next2 : this.headers.entrySet()) {
            aVar.mo27550a((String) next2.getKey(), (String) next2.getValue());
        }
        C1748C.C1749a aVar3 = this.bodyBuilder;
        if (aVar3 != null) {
            c = aVar3.mo27460a();
        }
        aVar.mo27549a(this.method.name(), (C0976G) c);
        return aVar.mo27551a();
    }

    private C1748C.C1749a getOrCreateBodyBuilder() {
        if (this.bodyBuilder == null) {
            C1748C.C1749a aVar = new C1748C.C1749a();
            aVar.mo27458a(C1748C.f2085g);
            this.bodyBuilder = aVar;
        }
        return this.bodyBuilder;
    }

    public HttpResponse execute() throws IOException {
        return HttpResponse.create(CLIENT.mo27469a(build()).execute());
    }

    public HttpRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public String method() {
        return this.method.name();
    }

    public HttpRequest part(String str, String str2) {
        C1748C.C1749a orCreateBodyBuilder = getOrCreateBodyBuilder();
        if (orCreateBodyBuilder != null) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            orCreateBodyBuilder.mo27459a(C1748C.C1751c.m2468a(str, (String) null, C0976G.Companion.mo20405a(str2, (C1746B) null)));
            this.bodyBuilder = orCreateBodyBuilder;
            return this;
        }
        throw null;
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        C1746B.C1747a aVar = C1746B.f2080f;
        C0976G create = C0976G.create(C1746B.C1747a.m2461b(str3), file);
        C1748C.C1749a orCreateBodyBuilder = getOrCreateBodyBuilder();
        if (orCreateBodyBuilder != null) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(create, "body");
            orCreateBodyBuilder.mo27459a(C1748C.C1751c.m2468a(str, str2, create));
            this.bodyBuilder = orCreateBodyBuilder;
            return this;
        }
        throw null;
    }
}
