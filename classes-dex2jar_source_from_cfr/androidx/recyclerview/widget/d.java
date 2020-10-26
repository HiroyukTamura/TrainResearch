/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class d
extends RecyclerView.h {
    private static final int[] a = new int[]{16843284};
    private Drawable b;
    private int c;
    private final Rect d = new Rect();

    public d(Context context, int n2) {
        context = context.obtainStyledAttributes(a);
        this.b = context.getDrawable(0);
        if (this.b == null) {
            Log.w((String)"DividerItem", (String)"@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        context.recycle();
        this.a(n2);
    }

    private void c(Canvas canvas, RecyclerView recyclerView) {
        int n2;
        int n3;
        canvas.save();
        boolean bl2 = recyclerView.getClipToPadding();
        int n4 = 0;
        if (bl2) {
            n3 = recyclerView.getPaddingLeft();
            n2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(n3, recyclerView.getPaddingTop(), n2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            n2 = recyclerView.getWidth();
            n3 = 0;
        }
        int n5 = recyclerView.getChildCount();
        while (n4 < n5) {
            View view = recyclerView.getChildAt(n4);
            recyclerView.a(view, this.d);
            int n6 = this.d.bottom + Math.round(view.getTranslationY());
            int n7 = this.b.getIntrinsicHeight();
            this.b.setBounds(n3, n6 - n7, n2, n6);
            this.b.draw(canvas);
            ++n4;
        }
        canvas.restore();
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int n2;
        int n3;
        canvas.save();
        boolean bl2 = recyclerView.getClipToPadding();
        int n4 = 0;
        if (bl2) {
            n3 = recyclerView.getPaddingTop();
            n2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), n3, recyclerView.getWidth() - recyclerView.getPaddingRight(), n2);
        } else {
            n2 = recyclerView.getHeight();
            n3 = 0;
        }
        int n5 = recyclerView.getChildCount();
        while (n4 < n5) {
            View view = recyclerView.getChildAt(n4);
            recyclerView.getLayoutManager().a(view, this.d);
            int n6 = this.d.right + Math.round(view.getTranslationX());
            int n7 = this.b.getIntrinsicWidth();
            this.b.setBounds(n6 - n7, n3, n6, n2);
            this.b.draw(canvas);
            ++n4;
        }
        canvas.restore();
    }

    public void a(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.c = n2;
    }

    @Override
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.u u2) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.b == null) {
                return;
            }
            if (this.c == 1) {
                this.c(canvas, recyclerView);
                return;
            }
            this.d(canvas, recyclerView);
        }
    }

    @Override
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u u2) {
        if (this.b == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (this.c == 1) {
            rect.set(0, 0, 0, this.b.getIntrinsicHeight());
            return;
        }
        rect.set(0, 0, this.b.getIntrinsicWidth(), 0);
    }

    public void a(Drawable drawable2) {
        if (drawable2 != null) {
            this.b = drawable2;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }
}

