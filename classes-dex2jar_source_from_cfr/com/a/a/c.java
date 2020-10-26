/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View
 */
package com.a.a;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.h.t;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.a.a.d;

class c {

    static class a
    implements g {
        a() {
        }

        private void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3) {
            canvas.save();
            canvas.translate(f2, f3);
            recyclerView.drawChild(canvas, view, 0L);
            canvas.restore();
        }

        @Override
        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int n2, boolean bl2) {
            if (n2 != 2) {
                this.a(canvas, recyclerView, view, f2, f3);
            }
        }

        @Override
        public void a(View view) {
            view.setVisibility(0);
        }

        @Override
        public void b(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int n2, boolean bl2) {
            if (n2 == 2) {
                this.a(canvas, recyclerView, view, f2, f3);
            }
        }

        @Override
        public void b(View view) {
            view.setVisibility(4);
        }
    }

    static class b
    implements g {
        b() {
        }

        @Override
        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int n2, boolean bl2) {
            t.a(view, f2);
            t.b(view, f3);
        }

        @Override
        public void a(View view) {
            t.a(view, 0.0f);
            t.b(view, 0.0f);
        }

        @Override
        public void b(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int n2, boolean bl2) {
        }

        @Override
        public void b(View view) {
        }
    }

    static class c
    extends b {
        c() {
        }

        private float a(RecyclerView recyclerView, View view) {
            int n2 = recyclerView.getChildCount();
            float f2 = 0.0f;
            for (int i2 = 0; i2 < n2; ++i2) {
                float f3;
                View view2 = recyclerView.getChildAt(i2);
                if (view2 == view) {
                    f3 = f2;
                } else {
                    float f4 = t.n(view2);
                    f3 = f2;
                    if (f4 > f2) {
                        f3 = f4;
                    }
                }
                f2 = f3;
            }
            return f2;
        }

        @Override
        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int n2, boolean bl2) {
            if (bl2 && view.getTag(d.b.item_touch_helper_previous_elevation) == null) {
                float f4 = t.n(view);
                t.c(view, this.a(recyclerView, view) + 1.0f);
                view.setTag(d.b.item_touch_helper_previous_elevation, (Object)Float.valueOf(f4));
            }
            super.a(canvas, recyclerView, view, f2, f3, n2, bl2);
        }

        @Override
        public void a(View view) {
            Object object = view.getTag(d.b.item_touch_helper_previous_elevation);
            if (object != null && object instanceof Float) {
                t.c(view, ((Float)object).floatValue());
            }
            view.setTag(d.b.item_touch_helper_previous_elevation, null);
            super.a(view);
        }
    }

}

