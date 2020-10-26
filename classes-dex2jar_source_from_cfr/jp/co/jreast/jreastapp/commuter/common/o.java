/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.common;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.j;
import jp.co.jreast.jreastapp.commuter.m.e;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ScalableImageViewModel;", "Landroidx/lifecycle/ViewModel;", "cacheRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;)V", "_delayedKantoImage", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/drawable/Drawable;", "delayedKantoImage", "Landroidx/lifecycle/LiveData;", "getDelayedKantoImage", "()Landroidx/lifecycle/LiveData;", "dismissViewEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissViewEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "loadImage", "", "tapCloseButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class o
extends v {
    private final p<Drawable> a;
    private final al<Void> b;
    private final e c;

    public o(e e2) {
        kotlin.e.b.j.b(e2, "cacheRepository");
        this.c = e2;
        this.a = new p();
        this.b = new al();
    }

    public final LiveData<Drawable> b() {
        return this.a;
    }

    public final al<Void> c() {
        return this.b;
    }

    public final void d() {
        this.a.b(this.c.a(j.a.a()));
    }

    public final void e() {
        this.b.f();
    }
}

