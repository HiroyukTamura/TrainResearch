/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.di;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/StationListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/StationListItemBinding;", "(Ljp/co/jreast/jreastapp/commuter/databinding/StationListItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/StationListItemBinding;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends RecyclerView.x {
    private final di q;

    public g(di di2) {
        j.b(di2, "binding");
        super(di2.e());
        this.q = di2;
    }

    public final di A() {
        return this.q;
    }
}

