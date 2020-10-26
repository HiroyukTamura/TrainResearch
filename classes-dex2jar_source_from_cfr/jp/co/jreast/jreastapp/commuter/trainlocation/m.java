/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.bs;
import jp.co.jreast.jreastapp.commuter.c.bw;
import jp.co.jreast.jreastapp.commuter.c.by;
import jp.co.jreast.jreastapp.commuter.c.ca;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.aa;
import jp.co.jreast.jreastapp.commuter.trainlocation.p;
import jp.co.jreast.jreastapp.commuter.trainlocation.r;
import jp.co.jreast.jreastapp.commuter.trainlocation.t;
import jp.co.jreast.jreastapp.commuter.trainlocation.u;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;
import kotlin.e.b.j;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

@Metadata(bv={1, 0, 2}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001f"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;)V", "getContext", "()Landroid/content/Context;", "getPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBoldFont", "textView", "Landroid/widget/TextView;", "setMediumFont", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class m
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final y b;
    private final p c;

    public m(Context context, y y2, p p2) {
        j.b((Object)context, "context");
        j.b(y2, "pagerViewModel");
        j.b(p2, "viewModel");
        this.a = context;
        this.b = y2;
        this.c = p2;
    }

    @Override
    private final void a(TextView textView) {
        CalligraphyUtils.applyFontToTextView(this.a, textView, "fonts/TT-UDShinGoPro-Bold.ttf");
    }

    private final void b(TextView textView) {
        CalligraphyUtils.applyFontToTextView(this.a, textView, "fonts/TT-UDShinGoPro-Medium.ttf");
    }

    @Override
    public int a() {
        return this.c.b();
    }

    @Override
    public int a(int n2) {
        return this.c.c(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        void var2_13;
        void var1_4;
        j.b(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (var2_13 == RailwayLineInformation.Type.NOSECTION.getCode() || var2_13 == RailwayLineInformation.Type.SECTION.getCode()) {
            ca ca2 = ca.a(layoutInflater, object, false);
            j.a((Object)ca2, "ItemTrainLocationSingleL\u2026(inflater, parent, false)");
            aa aa2 = new aa(ca2);
            do {
                return (RecyclerView.x)var1_4;
                break;
            } while (true);
        }
        if (var2_13 == RailwayLineInformation.Type.LINES.getCode()) {
            bw bw2 = bw.a(layoutInflater, object, false);
            j.a((Object)bw2, "ItemTrainLocationLinesBi\u2026(inflater, parent, false)");
            t t2 = new t(bw2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_13 == RailwayLineInformation.Type.OTHERS.getCode()) {
            by by2 = by.a(layoutInflater, object, false);
            j.a((Object)by2, "ItemTrainLocationOthersB\u2026(inflater, parent, false)");
            u u2 = new u(by2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_13 == RailwayLineInformation.Type.AKAGI.getCode()) {
            bs bs2 = bs.a(layoutInflater, object, false);
            j.a((Object)bs2, "ItemTrainLocationAkagiBi\u2026(inflater, parent, false)");
            r r2 = new r(bs2);
            return (RecyclerView.x)var1_4;
        }
        ca ca3 = ca.a(layoutInflater, object, false);
        j.a((Object)ca3, "ItemTrainLocationSingleL\u2026(inflater, parent, false)");
        aa aa3 = new aa(ca3);
        return (RecyclerView.x)var1_4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(RecyclerView.x var1_1, int var2_2) {
        block3 : {
            block2 : {
                j.b(var1_1, "holder");
                var3_3 = this.c.b(var2_2);
                if (!(var1_1 instanceof aa)) break block2;
                var1_1 = (aa)var1_1;
                var1_1.A().a(this.b);
                var1_1.A().a((RailwayLineInformation)var3_3);
                var3_3 = this.c.a((RailwayLineInformation)var3_3);
                var1_1.A().d.setImageDrawable((Drawable)var3_3);
                var3_3 = var1_1.A().c;
                j.a(var3_3, "holder.binding.displayName");
                this.a((TextView)var3_3);
                var1_1 = var1_1.A().e;
                ** GOTO lbl58
            }
            if (!(var1_1 instanceof t)) break block3;
            var1_1 = (t)var1_1;
            var1_1.A().a(this.b);
            var1_1.A().a((RailwayLineInformation)var3_3);
            var3_3 = this.c.a((RailwayLineInformation)var3_3);
            var1_1.A().d.setImageDrawable((Drawable)var3_3);
            var3_3 = var1_1.A().c;
            j.a(var3_3, "holder.binding.displayName");
            this.a((TextView)var3_3);
            var1_1 = var1_1.A().e;
            ** GOTO lbl58
        }
        if (var1_1 instanceof u) {
            var1_1 = (u)var1_1;
            var1_1.A().a(this.b);
            var1_1.A().a((RailwayLineInformation)var3_3);
            var3_3 = this.c.a((RailwayLineInformation)var3_3);
            var1_1.A().e.setImageDrawable((Drawable)var3_3);
            var3_3 = var1_1.A().d;
            j.a(var3_3, "holder.binding.displayName");
            this.a((TextView)var3_3);
            var3_3 = var1_1.A().g;
            j.a(var3_3, "holder.binding.section");
            this.b((TextView)var3_3);
            var3_3 = var1_1.A().f;
            j.a(var3_3, "holder.binding.liner");
            this.a((TextView)var3_3);
            var3_3 = var1_1.A().h;
            j.a(var3_3, "holder.binding.underLiner");
            this.a((TextView)var3_3);
            var1_1 = var1_1.A().c;
            var3_3 = "holder.binding.direction";
        } else {
            if (var1_1 instanceof r == false) return;
            var1_1 = (r)var1_1;
            var1_1.A().a(this.b);
            var1_1.A().a((RailwayLineInformation)var3_3);
            var3_3 = this.c.a((RailwayLineInformation)var3_3);
            var1_1.A().d.setImageDrawable((Drawable)var3_3);
            var3_3 = var1_1.A().c;
            j.a(var3_3, "holder.binding.displayName");
            this.a((TextView)var3_3);
            var1_1 = var1_1.A().e;
lbl58: // 3 sources:
            var3_3 = "holder.binding.section";
        }
        j.a((Object)var1_1, (String)var3_3);
        this.b((TextView)var1_1);
    }
}

