/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import f.n;
import jp.co.jreast.jreastapp.commuter.l.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/NetworkUserInformationRepository;", "", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "schedulerProvider", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "(Lretrofit2/Retrofit$Builder;Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;)V", "registerUser", "Lio/reactivex/Observable;", "Ljp/co/jreast/jreastapp/commuter/model/RegisteredUserId;", "baseUrl", "", "setToken", "requestParameter", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class n {
    private final n.a a;
    private final d b;

    public n(n.a a2, d d2) {
        j.b(a2, "retrofitBuilder");
        j.b(d2, "schedulerProvider");
        this.a = a2;
        this.b = d2;
    }
}

