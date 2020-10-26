/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.g;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;", "Landroidx/lifecycle/ViewModel;", "userTrainLocationHistoryRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "emptyHistoryTextHidden", "Landroidx/lifecycle/MutableLiveData;", "", "getEmptyHistoryTextHidden", "()Landroidx/lifecycle/MutableLiveData;", "setEmptyHistoryTextHidden", "(Landroidx/lifecycle/MutableLiveData;)V", "openClearDialogEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getOpenClearDialogEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "openSearchLineScreenEvent", "getOpenSearchLineScreenEvent", "clearHistory", "", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineAdapter;", "context", "Landroid/content/Context;", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getLineIcon", "Landroid/graphics/drawable/Drawable;", "railwayLineInformation", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "tapClear", "tapSearchButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j
extends v {
    private final al<Void> a;
    private final al<Void> b;
    private p<Boolean> c;
    private u d;
    private b e;

    public j(u object, b b2) {
        kotlin.e.b.j.b(object, "userTrainLocationHistoryRepository");
        kotlin.e.b.j.b(b2, "drawableRepository");
        this.d = object;
        this.e = b2;
        this.a = new al();
        this.b = new al();
        object = new p();
        ((p)object).b(true);
        this.c = object;
    }

    public final Drawable a(RailwayLineInformation railwayLineInformation) {
        kotlin.e.b.j.b(railwayLineInformation, "railwayLineInformation");
        return this.e.a(railwayLineInformation);
    }

    public final g a(Context context, y y2) {
        kotlin.e.b.j.b((Object)context, "context");
        kotlin.e.b.j.b(y2, "pagerViewModel");
        List<RailwayLineInformation> list = this.d.a();
        this.c.b(list.isEmpty() ^ true);
        return new g(context, this, y2, list);
    }

    public final al<Void> b() {
        return this.a;
    }

    public final al<Void> c() {
        return this.b;
    }

    public final p<Boolean> d() {
        return this.c;
    }

    public final void e() {
        this.a.f();
    }

    public final void f() {
        this.b.f();
    }

    public final void g() {
        this.d.b();
        this.c.b(false);
    }
}

