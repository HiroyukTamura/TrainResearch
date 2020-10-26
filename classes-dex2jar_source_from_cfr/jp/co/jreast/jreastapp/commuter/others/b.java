/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.bo;
import jp.co.jreast.jreastapp.commuter.common.h;
import jp.co.jreast.jreastapp.commuter.common.i;
import jp.co.jreast.jreastapp.commuter.others.c;
import jp.co.jreast.jreastapp.commuter.others.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Ljp/co/jreast/jreastapp/commuter/others/OthersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/others/OthersViewModel;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/others/OthersViewModel;)V", "getContext", "()Landroid/content/Context;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/others/OthersViewModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final d b;

    public b(Context context, d d2) {
        j.b((Object)context, "context");
        j.b(d2, "viewModel");
        this.a = context;
        this.b = d2;
    }

    @Override
    public int a() {
        return 1;
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = bo.a(LayoutInflater.from((Context)this.a), object, false);
        j.a(object, "ItemOthersBinding.inflate(inflater, parent, false)");
        return new c((bo)object);
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        j.b(x2, "holder");
        if (x2 instanceof c) {
            x2 = (c)x2;
            ((c)x2).A().a(this.b);
            ((c)x2).A().a(new h("\u307e\u3082\u30ec\u30fc\u30eb", "\u307e\u3082\u30ec\u30fc\u30eb", "ic_lineicon_default", i.a, "ks01/GatePassageNotice/member/noticeHistory?user_id=%uid%"));
        }
    }
}

