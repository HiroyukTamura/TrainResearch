/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.r;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.r.b;
import jp.co.jreast.jreastapp.commuter.r.h;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002\u00a8\u0006\u0011"}, d2={"Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptor;", "", "()V", "capture", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "createViewHolderList", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getScreenshotFromRecyclerView", "measureHolderHeight", "", "viewHolder", "width", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g {
    private final int a(RecyclerView.x x2, int n2) {
        x2.a.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
        View view = x2.a;
        View view2 = x2.a;
        j.a((Object)view2, "viewHolder.itemView");
        n2 = view2.getMeasuredWidth();
        view2 = x2.a;
        j.a((Object)view2, "viewHolder.itemView");
        view.layout(0, 0, n2, view2.getMeasuredHeight());
        x2 = x2.a;
        j.a((Object)x2, "viewHolder.itemView");
        return x2.getHeight();
    }

    private final Bitmap a(View view) {
        Bitmap bitmap = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable2 = view.getBackground();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        j.a((Object)bitmap, "bitmap");
        return bitmap;
    }

    private final List<RecyclerView.x> b(RecyclerView object) {
        RecyclerView.a a2 = ((RecyclerView)object).getAdapter();
        if (a2 != null) {
            List list = new ArrayList();
            ViewGroup viewGroup = (ViewGroup)object;
            Object VH = a2.b(viewGroup, h.a.a());
            int n2 = 0;
            a2.a(VH, 0);
            object = !(VH instanceof b) ? null : VH;
            object = (b)object;
            if (object != null) {
                object.B();
            }
            j.a(VH, "headerViewHolder");
            list.add(VH);
            j.a((Object)a2, "adapter");
            int n3 = a2.a();
            while (n2 < n3) {
                VH = a2.b(viewGroup, a2.a(n2));
                a2.a(VH, n2);
                object = !(VH instanceof b) ? null : VH;
                object = (b)object;
                if (object != null) {
                    object.B();
                }
                j.a(VH, "holder");
                list.add(VH);
                ++n2;
            }
            object = a2.b(viewGroup, h.b.a());
            j.a(object, "footerViewHolder");
            list.add(object);
            return list;
        }
        return m.a();
    }

    public final Bitmap a(RecyclerView recyclerView) {
        j.b(recyclerView, "view");
        Object object = this.b(recyclerView);
        Canvas canvas = ((Iterable)object).iterator();
        int n2 = 0;
        int n3 = 0;
        while (canvas.hasNext()) {
            n3 += this.a((RecyclerView.x)canvas.next(), recyclerView.getWidth());
        }
        if ((recyclerView = Bitmap.createBitmap((int)recyclerView.getMeasuredWidth(), (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888)) == null) {
            j.a();
        }
        canvas = new Canvas((Bitmap)recyclerView);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        object = object.iterator();
        n3 = n2;
        while (object.hasNext()) {
            View view = ((RecyclerView.x)object.next()).a;
            j.a((Object)view, "holder.itemView");
            view = this.a(view);
            canvas.drawBitmap((Bitmap)view, 0.0f, (float)n3, paint);
            n3 += view.getHeight();
            view.recycle();
            paint.reset();
        }
        return recyclerView;
    }
}

