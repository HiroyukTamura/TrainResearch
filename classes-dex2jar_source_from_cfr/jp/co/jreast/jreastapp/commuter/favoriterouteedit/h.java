/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.a.a.b;
import jp.co.jreast.jreastapp.commuter.c.ag;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.d;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.e;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J@\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001e"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/ItemTouchHelperCallback;", "Lcom/loopeer/itemtouchhelperextension/ItemTouchHelperExtension$SimpleCallback;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "(Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;)V", "fromPosition", "", "toPosition", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends b.d {
    private int a;
    private int b;
    private final f c;

    public h(f f2) {
        j.b(f2, "viewModel");
        super(3, 16);
        this.c = f2;
        this.a = -1;
        this.b = -1;
    }

    @Override
    public void a(Canvas object, RecyclerView recyclerView, RecyclerView.x x2, float f2, float f3, int n2, boolean bl2) {
        j.b(object, "c");
        j.b(recyclerView, "recyclerView");
        j.b(x2, "viewHolder");
        if (f3 != 0.0f && f2 == 0.0f) {
            if (bl2) {
                View view = x2.a;
                j.a((Object)view, "viewHolder.itemView");
                view.setElevation(3.0f);
            }
            super.a((Canvas)object, recyclerView, x2, f2, f3, n2, bl2);
            return;
        }
        object = x2.a;
        j.a(object, "viewHolder.itemView");
        object.setElevation(0.0f);
        object = (e)x2;
        recyclerView = object.B().f;
        j.a((Object)recyclerView, "holder.binding.viewListRepoActionContainer");
        f3 = f2;
        if (f2 < -((float)recyclerView.getWidth())) {
            recyclerView = object.B().f;
            j.a((Object)recyclerView, "holder.binding.viewListRepoActionContainer");
            f3 = -((float)recyclerView.getWidth());
        }
        object = object.B().e;
        j.a(object, "holder.binding.viewListMainContent");
        object.setTranslationX(f3);
    }

    @Override
    public void a(RecyclerView.x x2, int n2) {
        j.b(x2, "viewHolder");
        this.c.a(x2.e());
        this.a(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void b(RecyclerView.x x2, int n2) {
        if (x2 instanceof e) {
            int n3;
            if (n2 == 2) {
                e e2 = (e)x2;
                e2.A().setScaleX(1.01f);
                e2.A().setScaleY(1.01f);
                this.c.g();
            }
            if (n2 == 1) {
                this.c.a(((e)x2).e());
                n3 = 0;
            } else {
                this.c.a(-1);
                n3 = 3;
            }
            this.a(n3);
        }
        super.b(x2, n2);
    }

    @Override
    public boolean b(RecyclerView object, RecyclerView.x x2, RecyclerView.x x3) {
        j.b(object, "recyclerView");
        j.b(x2, "viewHolder");
        j.b(x3, "target");
        if (this.a == -1) {
            this.a = x2.e();
        }
        this.b = x3.e();
        if ((object = ((RecyclerView)object).getAdapter()) != null) {
            ((d)object).c(x2.e(), x3.e());
            return true;
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.favoriterouteedit.FavoriteRouteEditAdapter");
    }

    @Override
    public void c(RecyclerView object, RecyclerView.x x2) {
        block7 : {
            block6 : {
                if (this.a == -1 && this.b == -1) break block6;
                if (object == null) {
                    j.a();
                }
                if ((object = ((RecyclerView)object).getAdapter()) == null) break block7;
                ((d)object).d(this.a, this.b);
                this.a = -1;
                this.b = -1;
            }
            if (this.c.e() != -1) {
                this.a(3);
                this.c.a(-1);
            }
            if (x2 == null) {
                j.a();
            }
            object = x2.a;
            j.a(object, "viewHolder!!.itemView");
            object.setScaleX(1.0f);
            object = x2.a;
            j.a(object, "viewHolder.itemView");
            object.setScaleY(1.0f);
            return;
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.favoriterouteedit.FavoriteRouteEditAdapter");
    }
}

