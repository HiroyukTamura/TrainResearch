/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.selectsetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.dg;
import jp.co.jreast.jreastapp.commuter.model.Settings;
import jp.co.jreast.jreastapp.commuter.selectsetting.c;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2={"Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingViewModel;", "settings", "", "Ljp/co/jreast/jreastapp/commuter/model/Settings;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingViewModel;[Ljp/co/jreast/jreastapp/commuter/model/Settings;)V", "getContext", "()Landroid/content/Context;", "getSettings", "()[Ljp/co/jreast/jreastapp/commuter/model/Settings;", "[Ljp/co/jreast/jreastapp/commuter/model/Settings;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingViewModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends RecyclerView.a<RecyclerView.x> {
    private final Context a;
    private final d b;
    private final Settings[] c;

    public b(Context context, d d2, Settings[] arrsettings) {
        j.b((Object)context, "context");
        j.b(d2, "viewModel");
        j.b(arrsettings, "settings");
        this.a = context;
        this.b = d2;
        this.c = arrsettings;
    }

    @Override
    public int a() {
        return this.c.length;
    }

    @Override
    public RecyclerView.x a(ViewGroup object, int n2) {
        j.b(object, "parent");
        object = dg.a(LayoutInflater.from((Context)this.a), object, false);
        j.a(object, "SettingsSelectItemBindin\u2026(inflater, parent, false)");
        return new c((dg)object);
    }

    @Override
    public void a(RecyclerView.x object, int n2) {
        j.b(object, "holder");
        if (object instanceof c) {
            object = (c)object;
            ((c)object).A().a(this.b);
            ((c)object).A().a(this.c[n2]);
            object = ((c)object).A();
            boolean bl2 = this.b.e() == this.c[n2].getValue();
            ((dg)object).a(bl2);
        }
    }
}

