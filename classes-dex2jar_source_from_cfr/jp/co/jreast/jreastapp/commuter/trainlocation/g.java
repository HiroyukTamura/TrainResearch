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
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.c.bs;
import jp.co.jreast.jreastapp.commuter.c.bu;
import jp.co.jreast.jreastapp.commuter.c.bw;
import jp.co.jreast.jreastapp.commuter.c.by;
import jp.co.jreast.jreastapp.commuter.c.ca;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.aa;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;
import jp.co.jreast.jreastapp.commuter.trainlocation.r;
import jp.co.jreast.jreastapp.commuter.trainlocation.s;
import jp.co.jreast.jreastapp.commuter.trainlocation.t;
import jp.co.jreast.jreastapp.commuter.trainlocation.u;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

@Metadata(bv={1, 0, 2}, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006$"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "list", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/List;", "getPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBoldFont", "textView", "Landroid/widget/TextView;", "setMediumFont", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final j b;
    private final y c;
    private final List<RailwayLineInformation> d;

    public g(Context context, j j2, y y2, List<RailwayLineInformation> list) {
        kotlin.e.b.j.b((Object)context, "context");
        kotlin.e.b.j.b(j2, "viewModel");
        kotlin.e.b.j.b(y2, "pagerViewModel");
        kotlin.e.b.j.b(list, "list");
        this.a = context;
        this.b = j2;
        this.c = y2;
        this.d = list;
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
        if (this.d.isEmpty()) {
            return 0;
        }
        return ((Collection)this.d).size() + 1;
    }

    @Override
    public int a(int n2) {
        if (n2 < ((Collection)this.d).size()) {
            return this.d.get(n2).getDisplayType();
        }
        return RailwayLineInformation.Type.CLEAR.getCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        void var1_4;
        void var2_15;
        kotlin.e.b.j.b(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (var2_15 == RailwayLineInformation.Type.NOSECTION.getCode() || var2_15 == RailwayLineInformation.Type.SECTION.getCode()) {
            ca ca2 = ca.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)ca2, "ItemTrainLocationSingleL\u2026(inflater, parent, false)");
            aa aa2 = new aa(ca2);
            do {
                return (RecyclerView.x)var1_4;
                break;
            } while (true);
        }
        if (var2_15 == RailwayLineInformation.Type.LINES.getCode()) {
            bw bw2 = bw.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)bw2, "ItemTrainLocationLinesBi\u2026(inflater, parent, false)");
            t t2 = new t(bw2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_15 == RailwayLineInformation.Type.OTHERS.getCode()) {
            by by2 = by.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)by2, "ItemTrainLocationOthersB\u2026(inflater, parent, false)");
            u u2 = new u(by2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_15 == RailwayLineInformation.Type.AKAGI.getCode()) {
            bs bs2 = bs.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)bs2, "ItemTrainLocationAkagiBi\u2026(inflater, parent, false)");
            r r2 = new r(bs2);
            return (RecyclerView.x)var1_4;
        }
        if (var2_15 == RailwayLineInformation.Type.CLEAR.getCode()) {
            bu bu2 = bu.a(layoutInflater, object, false);
            kotlin.e.b.j.a((Object)bu2, "ItemTrainLocationClearBi\u2026(inflater, parent, false)");
            s s2 = new s(bu2);
            return (RecyclerView.x)var1_4;
        }
        ca ca3 = ca.a(layoutInflater, object, false);
        kotlin.e.b.j.a((Object)ca3, "ItemTrainLocationSingleL\u2026(inflater, parent, false)");
        aa aa3 = new aa(ca3);
        return (RecyclerView.x)var1_4;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(RecyclerView.x x2, int n2) {
        block9 : {
            Object object;
            block8 : {
                block5 : {
                    block7 : {
                        block6 : {
                            block4 : {
                                kotlin.e.b.j.b(x2, "holder");
                                if (!(x2 instanceof aa)) break block4;
                                object = this.d.get(n2);
                                x2 = (aa)x2;
                                ((aa)x2).A().a(this.c);
                                ((aa)x2).A().a((RailwayLineInformation)object);
                                object = this.b.a((RailwayLineInformation)object);
                                x2.A().d.setImageDrawable((Drawable)object);
                                object = x2.A().c;
                                kotlin.e.b.j.a(object, "holder.binding.displayName");
                                this.a((TextView)object);
                                x2 = x2.A().e;
                                break block5;
                            }
                            if (!(x2 instanceof t)) break block6;
                            object = this.d.get(n2);
                            x2 = (t)x2;
                            ((t)x2).A().a(this.c);
                            ((t)x2).A().a((RailwayLineInformation)object);
                            object = this.b.a((RailwayLineInformation)object);
                            x2.A().d.setImageDrawable((Drawable)object);
                            object = x2.A().c;
                            kotlin.e.b.j.a(object, "holder.binding.displayName");
                            this.a((TextView)object);
                            x2 = x2.A().e;
                            break block5;
                        }
                        if (!(x2 instanceof u)) break block7;
                        object = this.d.get(n2);
                        x2 = (u)x2;
                        ((u)x2).A().a(this.c);
                        ((u)x2).A().a((RailwayLineInformation)object);
                        object = this.b.a((RailwayLineInformation)object);
                        x2.A().e.setImageDrawable((Drawable)object);
                        object = x2.A().d;
                        kotlin.e.b.j.a(object, "holder.binding.displayName");
                        this.a((TextView)object);
                        object = x2.A().g;
                        kotlin.e.b.j.a(object, "holder.binding.section");
                        this.b((TextView)object);
                        object = x2.A().f;
                        kotlin.e.b.j.a(object, "holder.binding.liner");
                        this.a((TextView)object);
                        object = x2.A().h;
                        kotlin.e.b.j.a(object, "holder.binding.underLiner");
                        this.a((TextView)object);
                        x2 = x2.A().c;
                        object = "holder.binding.direction";
                        break block8;
                    }
                    if (!(x2 instanceof r)) break block9;
                    object = this.d.get(n2);
                    x2 = (r)x2;
                    ((r)x2).A().a(this.c);
                    ((r)x2).A().a((RailwayLineInformation)object);
                    object = this.b.a((RailwayLineInformation)object);
                    x2.A().d.setImageDrawable((Drawable)object);
                    object = x2.A().c;
                    kotlin.e.b.j.a(object, "holder.binding.displayName");
                    this.a((TextView)object);
                    x2 = x2.A().e;
                }
                object = "holder.binding.section";
            }
            kotlin.e.b.j.a((Object)x2, (String)object);
            this.b((TextView)x2);
            return;
        }
        if (x2 instanceof s) {
            x2 = (s)x2;
            ((s)x2).A().a(this.b);
            x2 = x2.A().c;
            kotlin.e.b.j.a((Object)x2, "holder.binding.clearHistoryText");
            this.a((TextView)x2);
        }
    }
}

