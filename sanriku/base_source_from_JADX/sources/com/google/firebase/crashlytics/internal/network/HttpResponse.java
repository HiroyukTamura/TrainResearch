package com.google.firebase.crashlytics.internal.network;

import java.io.IOException;
import p040i.C1758I;
import p040i.C1952y;

public class HttpResponse {
    private String body;
    private int code;
    private C1952y headers;

    HttpResponse(int i, String str, C1952y yVar) {
        this.code = i;
        this.body = str;
        this.headers = yVar;
    }

    static HttpResponse create(C1758I i) throws IOException {
        return new HttpResponse(i.mo27558o(), i.mo27554d() == null ? null : i.mo27554d().string(), i.mo27561r());
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String str) {
        return this.headers.get(str);
    }
}
