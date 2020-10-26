/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Spanned
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.c;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.ak;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setText", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends RecyclerView.x {
    private final Context q;

    public e(Context context, View view) {
        j.b((Object)context, "context");
        j.b((Object)view, "itemView");
        super(view);
        this.q = context;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void A() {
        void var1_3;
        String string2 = this.q.getString(2131558615);
        View view = this.a;
        j.a((Object)view, "itemView");
        view = (TextView)view.findViewById(ak.a.headerDesc);
        j.a((Object)view, "itemView.headerDesc");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned spanned = Html.fromHtml((String)string2, (int)0);
        } else {
            Spanned spanned = Html.fromHtml((String)string2);
        }
        CharSequence charSequence = (CharSequence)var1_3;
        view.setText(charSequence);
    }
}

