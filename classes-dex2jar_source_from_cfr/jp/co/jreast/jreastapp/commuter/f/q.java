/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.f;

import androidx.f.a.e;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "Ljava/io/Serializable;", "()V", "of", "Landroidx/lifecycle/ViewModelProvider;", "activity", "Landroidx/fragment/app/FragmentActivity;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class q
implements Serializable {
    public final w a(e object, w.b b2) {
        j.b(object, "activity");
        j.b(b2, "factory");
        object = x.a((e)object, b2);
        j.a(object, "ViewModelProviders.of(activity, factory)");
        return object;
    }
}

