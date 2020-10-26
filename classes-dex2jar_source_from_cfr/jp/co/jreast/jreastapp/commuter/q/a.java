/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.cc;
import jp.co.jreast.jreastapp.commuter.c.ce;
import jp.co.jreast.jreastapp.commuter.c.cg;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import jp.co.jreast.jreastapp.commuter.q.e;
import jp.co.jreast.jreastapp.commuter.q.f;
import jp.co.jreast.jreastapp.commuter.q.g;
import jp.co.jreast.jreastapp.commuter.q.h;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceViewModel;", "list", "", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceViewModel;[Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;)V", "getContext", "()Landroid/content/Context;", "getList", "()[Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "setList", "([Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;)V", "[Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceViewModel;", "addAll", "", "item", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final h b;
    private LineServiceStatusItem[] c;

    public a(Context context, h h2, LineServiceStatusItem[] arrlineServiceStatusItem) {
        j.b((Object)context, "context");
        j.b(h2, "viewModel");
        j.b(arrlineServiceStatusItem, "list");
        this.a = context;
        this.b = h2;
        this.c = arrlineServiceStatusItem;
    }

    @Override
    public int a() {
        return this.c.length;
    }

    @Override
    public int a(int n2) {
        return this.c[n2].getType().getCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        void var1_4;
        void var2_11;
        j.b(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (var2_11 == LineServiceStatusItem.Type.IMAGE.getCode()) {
            cc cc2 = cc.a(layoutInflater, object, false);
            j.a((Object)cc2, "ItemTrainServiceImageBin\u2026(inflater, parent, false)");
            e e2 = new e(cc2);
            do {
                return (RecyclerView.x)var1_4;
                break;
            } while (true);
        }
        if (var2_11 == LineServiceStatusItem.Type.ROW.getCode()) {
            ce ce2 = ce.a(layoutInflater, object, false);
            j.a((Object)ce2, "ItemTrainServiceRowBindi\u2026(inflater, parent, false)");
            f f2 = new f(ce2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_11 == LineServiceStatusItem.Type.SUBTITLE.getCode()) {
            cg cg2 = cg.a(layoutInflater, object, false);
            j.a((Object)cg2, "ItemTrainServiceSubtitle\u2026(inflater, parent, false)");
            g g2 = new g(cg2);
            return (RecyclerView.x)var1_4;
        }
        ce ce3 = ce.a(layoutInflater, object, false);
        j.a((Object)ce3, "ItemTrainServiceRowBindi\u2026(inflater, parent, false)");
        f f3 = new f(ce3);
        return (RecyclerView.x)var1_4;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(RecyclerView.x object, int n2) {
        void var2_7;
        j.b(object, "holder");
        if (object instanceof e) {
            e e2 = (e)object;
            e2.A().a(this.b);
            AppCompatImageView appCompatImageView = e2.A().c;
            j.a((Object)appCompatImageView, "holder.binding.delayedKantoImage");
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            Resources resources = this.a.getResources();
            j.a((Object)resources, "context.resources");
            layoutParams.height = (int)((float)resources.getDisplayMetrics().widthPixels * (float)this.a.getResources().getInteger(2131296262) / (float)this.a.getResources().getInteger(2131296263));
            AppCompatImageView appCompatImageView2 = e2.A().c;
            j.a((Object)appCompatImageView2, "holder.binding.delayedKantoImage");
            appCompatImageView2.setLayoutParams(layoutParams);
            return;
        }
        if (object instanceof f) {
            LineServiceStatusItem lineServiceStatusItem = this.c[var2_7];
            LineServiceStatus lineServiceStatus = lineServiceStatusItem.getLineServiceStatus();
            if (lineServiceStatus == null) {
                j.a();
            }
            f f2 = (f)object;
            f2.A().c((int)var2_7);
            f2.A().a(this.b);
            f2.A().a(lineServiceStatusItem);
            AppCompatImageView appCompatImageView = f2.A().m;
            h h2 = this.b;
            if (lineServiceStatus == null) {
                j.a();
            }
            appCompatImageView.setImageDrawable(h2.d(lineServiceStatus));
            f2.A().i.setImageDrawable(this.b.e(lineServiceStatus));
            boolean bl2 = this.b.a(lineServiceStatusItem.getJrId(), lineServiceStatus.getDelayStatus());
            int n3 = 0;
            if (bl2) {
                f2.A().c.setImageDrawable(this.b.a(this.c[var2_7].getJrId()));
                AppCompatImageView appCompatImageView3 = f2.A().c;
                j.a((Object)appCompatImageView3, "holder.binding.changeRouteImage");
                appCompatImageView3.setVisibility(0);
            } else {
                AppCompatImageView appCompatImageView4 = f2.A().c;
                j.a((Object)appCompatImageView4, "holder.binding.changeRouteImage");
                appCompatImageView4.setVisibility(8);
            }
            ConstraintLayout constraintLayout = f2.A().x;
            j.a((Object)constraintLayout, "holder.binding.trainServiceRow");
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            int n4 = n3;
            if (var2_7 == false) {
                n4 = n3;
                if (this.b.b() != LineServiceStatusItem.Area.KANTO.getCode()) {
                    float f3 = 30;
                    Resources resources = this.a.getResources();
                    j.a((Object)resources, "context.resources");
                    n4 = (int)(f3 * resources.getDisplayMetrics().density);
                }
            }
            marginLayoutParams.topMargin = n4;
            ConstraintLayout constraintLayout2 = f2.A().x;
            j.a((Object)constraintLayout2, "holder.binding.trainServiceRow");
            constraintLayout2.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            ConstraintLayout constraintLayout3 = f2.A().w;
            j.a((Object)constraintLayout3, "holder.binding.trainServiceDetailRow");
            ViewGroup.LayoutParams layoutParams2 = constraintLayout3.getLayoutParams();
            layoutParams2.height = this.c[var2_7].getTrainServiceDetailRowHeight();
            ConstraintLayout constraintLayout4 = f2.A().w;
            j.a((Object)constraintLayout4, "holder.binding.trainServiceDetailRow");
            constraintLayout4.setLayoutParams(layoutParams2);
            return;
        }
        if (!(object instanceof g)) {
            return;
        }
        g g2 = (g)object;
        TextView textView = g2.A().c;
        j.a((Object)textView, "holder.binding.subtitle");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        int n5 = var2_7 == true ? 10 : 20;
        float f4 = n5;
        Resources resources = this.a.getResources();
        j.a((Object)resources, "context.resources");
        marginLayoutParams.topMargin = (int)(f4 * resources.getDisplayMetrics().density);
        TextView textView2 = g2.A().c;
        j.a((Object)textView2, "holder.binding.subtitle");
        textView2.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        g2.A().a(this.c[var2_7]);
    }

    @Override
    public final void a(LineServiceStatusItem[] arrlineServiceStatusItem) {
        j.b(arrlineServiceStatusItem, "item");
        this.c = arrlineServiceStatusItem;
    }

    public final LineServiceStatusItem[] d() {
        return this.c;
    }
}

