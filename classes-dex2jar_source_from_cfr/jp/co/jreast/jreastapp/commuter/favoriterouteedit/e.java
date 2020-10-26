/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.ag;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteEditItemBinding;", "(Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteEditItemBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FavoriteRouteEditItemBinding;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;)V", "getItemView", "Landroid/view/View;", "set", "", "myRouteName", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends RecyclerView.x {
    public f q;
    private final ag r;

    public e(ag ag2) {
        j.b(ag2, "binding");
        super(ag2.e());
        this.r = ag2;
    }

    public final View A() {
        View view = this.a;
        j.a((Object)view, "itemView");
        return view;
    }

    public final ag B() {
        return this.r;
    }

    public final void a(f f2, String string2) {
        j.b(f2, "viewModel");
        j.b(string2, "myRouteName");
        this.q = f2;
        this.r.a(f2);
        f2 = this.r.d;
        j.a((Object)f2, "binding.textListMainTitle");
        f2.setText((CharSequence)string2);
        this.r.b(this.e());
    }
}

