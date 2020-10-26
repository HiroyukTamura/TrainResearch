/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.text.Editable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020 J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineViewModel;", "Landroidx/lifecycle/ViewModel;", "railwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "userTrainLocationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;)V", "_railwayListProperty", "Landroidx/lifecycle/MutableLiveData;", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "clearButtonVisibility", "Landroidx/lifecycle/LiveData;", "", "getClearButtonVisibility", "()Landroidx/lifecycle/LiveData;", "dismissEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "hideKeyboardEvent", "getHideKeyboardEvent", "railwayListProperty", "getRailwayListProperty", "searchTextProperty", "", "getSearchTextProperty", "()Landroidx/lifecycle/MutableLiveData;", "selectRailwayEvent", "getSelectRailwayEvent", "afterTextChanged", "", "s", "Landroid/text/Editable;", "tapCancelButton", "tapRailway", "railway", "tapTextClearButton", "tapViewWithoutInputField", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends v {
    private final al<Void> a;
    private final al<RailwayLineInformation> b;
    private final al<Void> c;
    private final p<String> d;
    private final LiveData<Integer> e;
    private final p<List<RailwayLineInformation>> f;
    private final f g;
    private final jp.co.jreast.jreastapp.commuter.m.u h;

    public d(f p2, jp.co.jreast.jreastapp.commuter.m.u u2) {
        j.b(p2, "railwayRepository");
        j.b(u2, "userTrainLocationHistoryRepository");
        this.g = p2;
        this.h = u2;
        this.a = new al();
        this.b = new al();
        this.c = new al();
        p2 = new p();
        p2.b("");
        this.d = p2;
        p2 = u.a((LiveData)this.d, a.a);
        j.a(p2, "Transformations.switchMa\u2026          }\n            }");
        this.e = p2;
        p2 = new p();
        m.a();
        this.f = p2;
    }

    public final void a(Editable object) {
        j.b(object, "s");
        object = this.g.a(object.toString());
        this.f.b((List<RailwayLineInformation>)object);
    }

    public final void a(RailwayLineInformation railwayLineInformation) {
        j.b(railwayLineInformation, "railway");
        this.b.b(railwayLineInformation);
    }

    public final al<Void> b() {
        return this.a;
    }

    public final al<RailwayLineInformation> c() {
        return this.b;
    }

    public final al<Void> d() {
        return this.c;
    }

    public final p<String> e() {
        return this.d;
    }

    public final LiveData<Integer> f() {
        return this.e;
    }

    public final LiveData<List<RailwayLineInformation>> g() {
        return this.f;
    }

    public final void h() {
        this.a.f();
    }

    public final void i() {
        this.d.b("");
    }

    public final void j() {
        this.c.f();
    }

}

