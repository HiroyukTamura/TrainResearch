/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.e.c;
import jp.co.jreast.jreastapp.commuter.m.q;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\tX\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "Landroidx/lifecycle/ViewModel;", "favoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "vibrationService", "Ljp/co/jreast/jreastapp/commuter/device/VibrationService;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;Ljp/co/jreast/jreastapp/commuter/device/VibrationService;)V", "deleteFavoriteRouteEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "", "getDeleteFavoriteRouteEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "dismissEvent", "Ljava/lang/Void;", "getDismissEvent$app_productRelease", "getFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "renameFavoriteRouteEvent", "getRenameFavoriteRouteEvent$app_productRelease", "swipedPosition", "getSwipedPosition$app_productRelease", "()I", "setSwipedPosition$app_productRelease", "(I)V", "deleteFavoriteRoute", "", "position", "openDeleteFavoriteRouteDialog", "openRenameFavoriteRouteDialog", "renameFavoriteRoute", "name", "", "tapCloseButton", "vibrate", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends v {
    public static final a a = new a(null);
    private final al<Void> b;
    private final al<Integer> c;
    private final al<Integer> d;
    private int e;
    private final q f;
    private final c g;

    public f(q q2, c c2) {
        j.b(q2, "favoriteRouteRepository");
        j.b(c2, "vibrationService");
        this.f = q2;
        this.g = c2;
        this.b = new al();
        this.c = new al();
        this.d = new al();
        this.e = -1;
    }

    public final void a(int n2) {
        this.e = n2;
    }

    public final void a(int n2, String string2) {
        j.b(string2, "name");
        if (n.a(string2) ^ true && n2 > -1) {
            this.f.a(n2, string2);
        }
    }

    public final al<Void> b() {
        return this.b;
    }

    public final void b(int n2) {
        if (this.e == n2) {
            this.c.b(n2);
        }
    }

    public final al<Integer> c() {
        return this.c;
    }

    public final void c(int n2) {
        if (this.e == n2) {
            this.d.b(n2);
        }
    }

    public final al<Integer> d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final void f() {
        this.b.f();
    }

    public final void g() {
        this.g.a(100L);
    }

    public final q h() {
        return this.f;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel$Companion;", "", "()V", "NO_ALL_SWIPE", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

