/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.m.s;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u000e\u0010'\u001a\u0002042\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J\u0006\u00109\u001a\u000204R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010$\"\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\n\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006:"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "Landroidx/lifecycle/ViewModel;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "favoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "changeViewPageEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "", "getChangeViewPageEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "setChangeViewPageEvent", "(Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;)V", "closeMyRouteNoticeViewEvent", "Ljava/lang/Void;", "getCloseMyRouteNoticeViewEvent", "setCloseMyRouteNoticeViewEvent", "currentPosition", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "getFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "setFavoriteRouteRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;)V", "favoriteRoutesUpdatedEvent", "getFavoriteRoutesUpdatedEvent", "setFavoriteRoutesUpdatedEvent", "myRouteNoticeCheck", "Landroidx/lifecycle/MutableLiveData;", "", "getMyRouteNoticeCheck", "()Landroidx/lifecycle/MutableLiveData;", "myRouteNoticeHidden", "getMyRouteNoticeHidden", "setMyRouteNoticeHidden", "(Landroidx/lifecycle/MutableLiveData;)V", "notifyChangedEvent", "getNotifyChangedEvent", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "setTranslationRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "getUserSettingsRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "setUserSettingsRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;)V", "hideMyRouteNotice", "", "notifyChangedAdapter", "position", "tapMyRouteEmptyButton", "tapMyRouteNoticeCloseButton", "tapTutorialButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends v {
    private int a;
    private final androidx.lifecycle.p<Boolean> b;
    private androidx.lifecycle.p<Boolean> c;
    private al<Void> d;
    private al<Integer> e;
    private al<Void> f;
    private final al<Void> g;
    private s h;
    private q i;
    private p j;

    public d(s object, q q2, p p2) {
        j.b(object, "userSettingsRepository");
        j.b(q2, "favoriteRouteRepository");
        j.b(p2, "translationRepository");
        this.h = object;
        this.i = q2;
        this.j = p2;
        this.a = a.a.b.a();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.b = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(true);
        this.c = object;
        this.d = new al();
        this.e = new al();
        this.f = new al();
        this.g = new al();
    }

    public final void a(int n2) {
        this.a = n2;
    }

    public final int b() {
        return this.a;
    }

    public final void b(int n2) {
        androidx.lifecycle.p<Boolean> p2 = this.c;
        boolean bl2 = n2 != 0 || this.h.k();
        p2.b(bl2);
    }

    public final androidx.lifecycle.p<Boolean> c() {
        return this.b;
    }

    public final androidx.lifecycle.p<Boolean> d() {
        return this.c;
    }

    public final al<Void> e() {
        return this.d;
    }

    public final al<Integer> f() {
        return this.e;
    }

    public final al<Void> g() {
        return this.f;
    }

    public final al<Void> h() {
        return this.g;
    }

    public final void i() {
        this.e.b(a.a.b.a());
    }

    public final void j() {
        this.e.b(2);
    }

    public final void k() {
        Object t2 = this.b.a();
        if (t2 == null) {
            j.a();
        }
        j.a(t2, "myRouteNoticeCheck.value!!");
        if (((Boolean)t2).booleanValue()) {
            this.h.j();
        }
        this.f.b(null);
    }

    public final void l() {
        this.c.b(true);
    }

    public final void m() {
        this.g.f();
    }

    public final q n() {
        return this.i;
    }

    public final p o() {
        return this.j;
    }
}

