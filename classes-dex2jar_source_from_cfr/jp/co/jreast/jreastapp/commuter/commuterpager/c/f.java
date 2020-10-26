/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Spanned
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import jp.co.jreast.jreastapp.commuter.ak;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setImage", "", "position", "", "setText", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends RecyclerView.x {
    public static final a q = new a(null);
    private static final int[] s = new int[]{2131558624, 2131558625, 2131558626, 2131558627, 2131558628, 2131558629};
    private static final int[] t = new int[]{2131558617, 2131558618, 2131558619, 2131558620, 2131558621, 2131558622};
    private final Context r;

    public f(Context context, View view) {
        j.b((Object)context, "context");
        j.b((Object)view, "itemView");
        super(view);
        this.r = context;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void c(int n2) {
        void var2_9;
        y y2 = y.a;
        Object[] arrobject = new Object[]{n2};
        String string2 = String.format("%02d", Arrays.copyOf(arrobject, arrobject.length));
        j.a((Object)string2, "java.lang.String.format(format, *args)");
        View view = this.a;
        j.a((Object)view, "itemView");
        view = (TextView)view.findViewById(ak.a.sectionNo);
        j.a((Object)view, "itemView.sectionNo");
        view.setText((CharSequence)string2);
        View view2 = this.a;
        j.a((Object)view2, "itemView");
        TextView textView = (TextView)view2.findViewById(ak.a.sectionTitle);
        view = s;
        textView.setText(view[--n2]);
        String string3 = this.r.getString(t[n2]);
        view = this.a;
        j.a((Object)view, "itemView");
        view = (TextView)view.findViewById(ak.a.sectionDesc);
        j.a((Object)view, "itemView.sectionDesc");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned spanned = Html.fromHtml((String)string3, (int)0);
        } else {
            Spanned spanned = Html.fromHtml((String)string3);
        }
        CharSequence charSequence = (CharSequence)var2_9;
        view.setText(charSequence);
    }

    public final void d(int n2) {
        Object[] arrobject = y.a;
        arrobject = new Object[]{n2};
        arrobject = String.format("%02d", Arrays.copyOf(arrobject, arrobject.length));
        j.a((Object)arrobject, "java.lang.String.format(format, *args)");
        Resources resources = this.r.getResources();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("myroute_img_");
        stringBuilder.append((String)arrobject);
        n2 = resources.getIdentifier(stringBuilder.toString(), "drawable", this.r.getPackageName());
        arrobject = this.a;
        j.a((Object)arrobject, "itemView");
        ((AppCompatImageView)arrobject.findViewById(ak.a.sectionImage)).setImageResource(n2);
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialViewHolder$Companion;", "", "()V", "TUTORIAL_SECTION_DESC", "", "getTUTORIAL_SECTION_DESC", "()[I", "TUTORIAL_SECTION_TITLE", "getTUTORIAL_SECTION_TITLE", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

