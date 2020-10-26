/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.c.cs;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailCaptureFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureFooterBinding;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureFooterBinding;)V", "getBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/RouteDetailCaptureFooterBinding;", "getContext", "()Landroid/content/Context;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends RecyclerView.x {
    private final Context q;
    private final cs r;

    public b(Context context, cs cs2) {
        j.b((Object)context, "context");
        j.b(cs2, "binding");
        super(cs2.e());
        this.q = context;
        this.r = cs2;
    }
}

