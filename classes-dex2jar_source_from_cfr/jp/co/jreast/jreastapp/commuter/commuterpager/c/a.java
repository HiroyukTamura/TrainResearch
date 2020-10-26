/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.commuterpager.c.b;
import jp.co.jreast.jreastapp.commuter.commuterpager.c.e;
import jp.co.jreast.jreastapp.commuter.commuterpager.c.f;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "footer", "", "header", "section", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends RecyclerView.a<RecyclerView.x> {
    private final int a;
    private final int b;
    private final int c;
    private final Context d;

    public a(Context context) {
        j.b((Object)context, "context");
        this.d = context;
        this.b = 1;
        this.c = 2;
    }

    @Override
    public int a() {
        return 8;
    }

    @Override
    public int a(int n2) {
        if (n2 != 0) {
            if (n2 != 7) {
                return this.b;
            }
            return this.c;
        }
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        void var2_9;
        void var1_4;
        j.b(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.d);
        if (var2_9 == this.a) {
            Context context = this.d;
            View view = layoutInflater.inflate(2131427459, object, false);
            j.a((Object)view, "inflater.inflate(R.layou\u2026ader_item, parent, false)");
            e e2 = new e(context, view);
            do {
                return (RecyclerView.x)var1_4;
                break;
            } while (true);
        }
        if (var2_9 == this.c) {
            View view = layoutInflater.inflate(2131427458, object, false);
            j.a((Object)view, "inflater.inflate(R.layou\u2026oter_item, parent, false)");
            b b2 = new b(view);
            return (RecyclerView.x)var1_4;
        }
        Context context = this.d;
        View view = layoutInflater.inflate(2131427460, object, false);
        j.a((Object)view, "inflater.inflate(R.layou\u2026rial_item, parent, false)");
        f f2 = new f(context, view);
        return (RecyclerView.x)var1_4;
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        j.b(x2, "holder");
        if (x2 instanceof e) {
            ((e)x2).A();
            return;
        }
        if (x2 instanceof f) {
            x2 = (f)x2;
            ((f)x2).c(n2);
            ((f)x2).d(n2);
            return;
        }
        boolean bl2 = x2 instanceof b;
    }
}

