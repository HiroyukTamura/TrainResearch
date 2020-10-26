/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.favoriteroute;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriteroute/FavoriteRouteRegistrationViewModel;", "Landroidx/lifecycle/ViewModel;", "favoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;)V", "clearButtonVisibility", "Landroidx/lifecycle/LiveData;", "", "getClearButtonVisibility", "()Landroidx/lifecycle/LiveData;", "dismissFavoriteRouteRegistrationEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissFavoriteRouteRegistrationEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "hideKeyboardEvent", "getHideKeyboardEvent$app_productRelease", "nameTextFieldProperty", "Landroidx/lifecycle/MutableLiveData;", "", "getNameTextFieldProperty", "()Landroidx/lifecycle/MutableLiveData;", "registerButtonEnabledProperty", "", "getRegisterButtonEnabledProperty", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "getRoute", "()Ljp/co/jreast/jreastapp/commuter/model/Route;", "setRoute", "(Ljp/co/jreast/jreastapp/commuter/model/Route;)V", "tapCancelButton", "", "tapRegisterButton", "tapTextClearButton", "tapViewWithoutInputField", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends v {
    public Route a;
    private final al<Void> b;
    private final al<Void> c;
    private final p<String> d;
    private final LiveData<Integer> e;
    private final LiveData<Boolean> f;
    private final q g;

    public b(q liveData) {
        j.b(liveData, "favoriteRouteRepository");
        this.g = liveData;
        this.b = new al();
        this.c = new al();
        liveData = new p();
        ((p)liveData).b("");
        this.d = liveData;
        liveData = u.a((LiveData)this.d, a.a);
        j.a(liveData, "Transformations.switchMa\u2026          }\n            }");
        this.e = liveData;
        liveData = u.a((LiveData)this.d, b.a);
        j.a(liveData, "Transformations.switchMa\u2026          }\n            }");
        this.f = liveData;
    }

    public final void a(Route route) {
        j.b(route, "<set-?>");
        this.a = route;
    }

    public final al<Void> b() {
        return this.b;
    }

    public final al<Void> c() {
        return this.c;
    }

    public final p<String> d() {
        return this.d;
    }

    public final LiveData<Integer> e() {
        return this.e;
    }

    public final LiveData<Boolean> f() {
        return this.f;
    }

    public final void g() {
        this.c.f();
    }

    public final void h() {
        this.b.f();
    }

    public final void i() {
        q q2 = this.g;
        Object object = this.d.a();
        if (object == null) {
            j.a();
        }
        j.a(object, "nameTextFieldProperty.value!!");
        object = (String)object;
        Route route = this.a;
        if (route == null) {
            j.b("route");
        }
        q2.a(new FavoriteRoute((String)object, route));
        this.b.f();
    }

    public final void j() {
        this.d.b("");
    }

}

