/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.q;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.ce;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/ItemTrainServiceRowBinding;", "(Ljp/co/jreast/jreastapp/commuter/databinding/ItemTrainServiceRowBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ItemTrainServiceRowBinding;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends RecyclerView.x {
    private final ce q;

    public f(ce ce2) {
        j.b(ce2, "binding");
        super(ce2.e());
        this.q = ce2;
    }

    public final ce A() {
        return this.q;
    }
}

