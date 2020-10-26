/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.common.k;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "", "jsonUtil", "Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;", "(Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;)V", "maxNumber", "", "railwayLineInformationList", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "saveFileName", "", "add", "", "railwayLineInformation", "clear", "count", "getAll", "save", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class u {
    private final String a;
    private final int b;
    private List<RailwayLineInformation> c;
    private final k d;

    public u(k k2) {
        j.b(k2, "jsonUtil");
        this.d = k2;
        this.a = "trainLocationHistory.json";
        this.b = 20;
        this.c = m.c(this.d.b(this.a));
    }

    private final void c() {
        this.d.a(this.a, (Type)((Object)RailwayLineInformation.class), this.c);
    }

    public final List<RailwayLineInformation> a() {
        return this.c;
    }

    public final void a(RailwayLineInformation railwayLineInformation) {
        j.b(railwayLineInformation, "railwayLineInformation");
        if (this.c.contains(railwayLineInformation)) {
            this.c.remove(railwayLineInformation);
        }
        this.c.add(0, railwayLineInformation);
        if (((Collection)this.c).size() > this.b) {
            this.c.remove(m.a(this.c));
        }
        this.c();
    }

    public final void b() {
        this.c.clear();
        this.c();
    }
}

