/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import b.a.e;
import f.a.a.h;
import f.b.b.c;
import f.c;
import f.e;
import f.n;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import jp.co.jreast.jreastapp.commuter.api.MixpanelDeleteApi;
import jp.co.jreast.jreastapp.commuter.l.d;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.s;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/NetworkMixpanelAPIRepository;", "", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "schedulerProvider", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "(Lretrofit2/Retrofit$Builder;Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;)V", "requestDeletionTask", "Lio/reactivex/Observable;", "", "baseUrl", "id", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j {
    private final n.a a;
    private final d b;

    public j(n.a a2, d d2) {
        kotlin.e.b.j.b(a2, "retrofitBuilder");
        kotlin.e.b.j.b(d2, "schedulerProvider");
        this.a = a2;
        this.b = d2;
    }

    public final e<String> a(String object, String string2) {
        kotlin.e.b.j.b(object, "baseUrl");
        kotlin.e.b.j.b(string2, "id");
        object = this.a.a((String)object).a(Executors.newSingleThreadExecutor()).a(h.a()).a(c.a()).a().a(MixpanelDeleteApi.class).deleteRequest(af.a(s.a("id", string2), s.a("type", "android"))).b(this.b.b()).a(this.b.a());
        kotlin.e.b.j.a(object, "service.deleteRequest(pa\u2026n(schedulerProvider.ui())");
        return object;
    }
}

