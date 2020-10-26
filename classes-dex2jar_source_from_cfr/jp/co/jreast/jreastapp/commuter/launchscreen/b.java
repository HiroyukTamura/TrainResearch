/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.launchscreen;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.k.a;
import jp.co.jreast.jreastapp.commuter.m.n;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.m.t;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/launchscreen/LaunchScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "userInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "networkUserInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkUserInformationRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "stationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;", "migrateMyRoutes", "Ljp/co/jreast/jreastapp/commuter/migrate/MigrateMyRoutes;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;Ljp/co/jreast/jreastapp/commuter/repository/NetworkUserInformationRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;Ljp/co/jreast/jreastapp/commuter/migrate/MigrateMyRoutes;)V", "migrateIfAppVersionCodeLessThan214", "", "migrateIfAppVersionCodeLessThan243", "migrateIfNeeded", "registerUserIfNeeded", "resetStatus", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends v {
    private final r a;
    private final n b;
    private final s c;
    private final t d;
    private final a e;

    public b(r r2, n n2, s s2, t t2, a a2) {
        j.b(r2, "userInformationRepository");
        j.b(n2, "networkUserInformationRepository");
        j.b(s2, "userSettingsRepository");
        j.b(t2, "stationHistoryRepository");
        j.b(a2, "migrateMyRoutes");
        this.a = r2;
        this.b = n2;
        this.c = s2;
        this.d = t2;
        this.e = a2;
    }

    private final void d() {
        if (this.c.i() < 214) {
            this.d.b(new Station("9659", "\u5357\u4e09\u9678\u753a\u5f79\u5834\u30fb\u75c5\u9662\u524d"));
        }
    }

    private final void e() {
        if (this.c.i() < 243) {
            this.e.a();
        }
    }

    public final void b() {
        if (this.c.g()) {
            this.d();
            this.e();
            this.c.h();
        }
    }

    public final void c() {
        this.c.b(0);
    }
}

