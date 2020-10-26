/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.main;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.l.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "trainServiceRefreshEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getTrainServiceRefreshEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "sendSelectTabEvent", "", "position", "", "trainServiceRefresh", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class s
extends v {
    private final al<Void> a;
    private final a b;

    public s(a a2) {
        this.b = a2;
        this.a = new al();
    }

    public final void a(int n2) {
        a a2 = this.b;
        if (a2 != null) {
            a2.e(n2);
        }
    }

    public final al<Void> b() {
        return this.a;
    }

    public final void c() {
        this.a.f();
    }
}

