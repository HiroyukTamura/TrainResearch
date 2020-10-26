/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.a.a.b;
import jp.co.jreast.jreastapp.commuter.c.ag;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.e;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006 "}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;)V", "getContext", "()Landroid/content/Context;", "mItemTouchHelperExtension", "Lcom/loopeer/itemtouchhelperextension/ItemTouchHelperExtension;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "doDelete", "", "adapterPosition", "", "finishMove", "from", "to", "getItemCount", "move", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemTouchHelperExtension", "itemTouchHelperExtension", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends RecyclerView.a<RecyclerView.x> {
    private b a;
    private final Context b;
    private final f c;

    public d(Context context, f f2) {
        j.b((Object)context, "context");
        j.b(f2, "viewModel");
        this.b = context;
        this.c = f2;
    }

    @Override
    public int a() {
        return this.c.h().a();
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = ag.a(LayoutInflater.from((Context)this.b), object, false);
        j.a(object, "FavoriteRouteEditItemBin\u2026(inflater, parent, false)");
        return new e((ag)object);
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        j.b(x2, "holder");
        if (x2 instanceof e) {
            x2.a(false);
            x2 = (e)x2;
            ((e)x2).a(this.c, this.c.h().a(n2).getName());
            ((e)x2).B().b(n2);
        }
    }

    @Override
    public final void a(b b2) {
        j.b(b2, "itemTouchHelperExtension");
        this.a = b2;
    }

    @Override
    public final void c(int n2) {
        this.c.h().b(n2);
        this.c();
    }

    public final void c(int n2, int n3) {
        this.b(n2, n3);
    }

    public final void d(int n2, int n3) {
        this.c.h().a(n2, n3);
        new Handler().postDelayed(new Runnable(){

            @Override
            public final void run() {
                this.c();
            }
        }, 0L);
    }

}

