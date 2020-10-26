/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.j;

import jp.co.jreast.jreastapp.commuter.j.c;
import jp.co.jreast.jreastapp.commuter.j.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/http/RequestParameterUtil;", "", "()V", "generateServiceStatusAreaRequestParameter", "Ljp/co/jreast/jreastapp/commuter/http/ServiceStatusAreaRequestParameter;", "areaId", "", "generateServiceStatusRequestParameter", "Ljp/co/jreast/jreastapp/commuter/http/ServiceStatusRequestParameter;", "jrId", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    public final d a(String string2) {
        j.b(string2, "jrId");
        return new d(string2);
    }

    public final c b(String string2) {
        j.b(string2, "areaId");
        return new c(string2);
    }
}

