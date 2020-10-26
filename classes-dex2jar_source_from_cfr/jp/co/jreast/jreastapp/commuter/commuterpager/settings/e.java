/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import androidx.lifecycle.p;
import androidx.lifecycle.v;
import b.a.b.b;
import b.a.g;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.j;
import jp.co.jreast.jreastapp.commuter.m.s;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0006\u0010\u001f\u001a\u00020\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/RemoveAccessLogViewModel;", "Landroidx/lifecycle/ViewModel;", "networkMixPanelAPIRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkMixpanelAPIRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkMixpanelAPIRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;)V", "closeModalEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getCloseModalEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "showCompleteDialogEvent", "getShowCompleteDialogEvent$app_productRelease", "showConfirmDialogButtonEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "getShowConfirmDialogButtonEnabled", "()Landroidx/lifecycle/MutableLiveData;", "showConfirmDialogEvent", "getShowConfirmDialogEvent$app_productRelease", "showErrorDialogEvent", "getShowErrorDialogEvent$app_productRelease", "removeAccessLog", "", "setConfirmDialogButtonStatus", "showCompleteDialog", "showConfirmDialog", "showErrorDialog", "tapCloseButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends v {
    private final al<Void> a;
    private final al<Void> b;
    private final al<Void> c;
    private final al<Void> d;
    private final p<Boolean> e;
    private final j f;
    private final jp.co.jreast.jreastapp.commuter.l.a g;
    private final s h;

    public e(j object, jp.co.jreast.jreastapp.commuter.l.a a2, s s2) {
        kotlin.e.b.j.b(object, "networkMixPanelAPIRepository");
        kotlin.e.b.j.b(s2, "userSettingsRepository");
        this.f = object;
        this.g = a2;
        this.h = s2;
        this.a = new al();
        this.b = new al();
        this.c = new al();
        this.d = new al();
        object = new p();
        ((p)object).b(true);
        this.e = object;
    }

    private final void l() {
        this.d.f();
    }

    public final al<Void> b() {
        return this.a;
    }

    public final al<Void> c() {
        return this.b;
    }

    public final al<Void> d() {
        return this.c;
    }

    public final al<Void> e() {
        return this.d;
    }

    public final p<Boolean> f() {
        return this.e;
    }

    public final void g() {
        if (this.h.p()) {
            this.e.b(false);
        }
    }

    public final void h() {
        this.a.f();
    }

    public final void i() {
        this.b.f();
    }

    public final void j() {
        this.c.f();
    }

    public final void k() {
        Object object = this.g;
        if (object != null && (object = object.b()) != null) {
            this.f.a("https://rp.cloudrail.jp/com/api/", (String)object).a(new g<String>(){

                @Override
                public void a(b b2) {
                    kotlin.e.b.j.b(b2, "d");
                }

                public void a(String string2) {
                    kotlin.e.b.j.b(string2, "result");
                }

                @Override
                public void a(Throwable throwable) {
                    kotlin.e.b.j.b(throwable, "e");
                    this.l();
                }

                @Override
                public /* synthetic */ void a_(Object object) {
                    this.a((String)object);
                }

                @Override
                public void b_() {
                    this.g.a();
                    this.h.a(true);
                    this.j();
                    this.f().b(false);
                }
            });
        }
    }

}

