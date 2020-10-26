/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ArrayAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  android.widget.ThemedSpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.a;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ak;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.f;
import androidx.core.h.r;
import androidx.core.h.t;

public class s
extends Spinner
implements r {
    private static final int[] d = new int[]{16843505};
    b a;
    int b;
    final Rect c;
    private final f e;
    private final Context f;
    private aa g;
    private SpinnerAdapter h;
    private final boolean i;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.spinnerStyle);
    }

    public s(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet, n2, -1);
    }

    public s(Context context, AttributeSet attributeSet, int n2, int n3) {
        this(context, attributeSet, n2, n3, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public s(Context var1_1, AttributeSet var2_5, int var3_6, int var4_7, Resources.Theme var5_8) {
        block20 : {
            super(var1_1, var2_5, var3_6);
            this.c = new Rect();
            var10_9 = ao.a(var1_1, var2_5, a.j.Spinner, var3_6, 0);
            this.e = new f((View)this);
            if (var5_8 == null) break block20;
            var5_8 = new d(var1_1, (Resources.Theme)var5_8);
            ** GOTO lbl12
        }
        var6_10 = var10_9.g(a.j.Spinner_popupTheme, 0);
        if (var6_10 != 0) {
            var5_8 = new d(var1_1, var6_10);
lbl12: // 2 sources:
            this.f = var5_8;
        } else {
            var5_8 = Build.VERSION.SDK_INT < 23 ? var1_1 : null;
            this.f = var5_8;
        }
        if (this.f != null) {
            block16 : {
                var7_11 = var4_7;
                if (var4_7 == -1) {
                    block19 : {
                        block17 : {
                            block18 : {
                                var5_8 = var1_1.obtainStyledAttributes(var2_5, s.d, var3_6, 0);
                                var6_10 = var4_7;
                                var8_12 = var5_8;
                                try {
                                    if (var5_8.hasValue(0)) {
                                        var8_12 = var5_8;
                                        var6_10 = var5_8.getInt(0, 0);
                                    }
                                    var7_11 = var6_10;
                                    if (var5_8 == null) break block16;
                                    var4_7 = var6_10;
                                    break block17;
                                }
                                catch (Exception var9_13) {
                                    break block18;
                                }
                                catch (Throwable var1_2) {
                                    var8_12 = null;
                                    break block19;
                                }
                                catch (Exception var9_14) {
                                    var5_8 = null;
                                }
                            }
                            var8_12 = var5_8;
                            try {
                                Log.i((String)"AppCompatSpinner", (String)"Could not read android:spinnerMode", (Throwable)var9_15);
                                var7_11 = var4_7;
                                if (var5_8 == null) break block16;
                            }
                            catch (Throwable var1_3) {
                                // empty catch block
                            }
                        }
                        var5_8.recycle();
                        var7_11 = var4_7;
                        {
                            break block16;
                        }
                    }
                    if (var8_12 == null) throw var1_4;
                    var8_12.recycle();
                    throw var1_4;
                }
            }
            if (var7_11 == 1) {
                var5_8 = new b(this.f, var2_5, var3_6);
                var8_12 = ao.a(this.f, var2_5, a.j.Spinner, var3_6, 0);
                this.b = var8_12.f(a.j.Spinner_android_dropDownWidth, -2);
                var5_8.a(var8_12.a(a.j.Spinner_android_popupBackground));
                var5_8.a(var10_9.d(a.j.Spinner_android_prompt));
                var8_12.a();
                this.a = var5_8;
                this.g = new aa((View)this, (b)var5_8){
                    final /* synthetic */ b a;
                    {
                        this.a = b2;
                        super(view);
                    }

                    @Override
                    public androidx.appcompat.view.menu.s a() {
                        return this.a;
                    }

                    @Override
                    public boolean b() {
                        if (!s.this.a.d()) {
                            s.this.a.a();
                        }
                        return true;
                    }
                };
            }
        }
        if ((var5_8 = var10_9.f(a.j.Spinner_android_entries)) != null) {
            var1_1 = new ArrayAdapter(var1_1, 17367048, (Object[])var5_8);
            var1_1.setDropDownViewResource(a.g.support_simple_spinner_dropdown_item);
            this.setAdapter((SpinnerAdapter)var1_1);
        }
        var10_9.a();
        this.i = true;
        if (this.h != null) {
            this.setAdapter(this.h);
            this.h = null;
        }
        this.e.a(var2_5, var3_6);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable2) {
        int n2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
        int n5 = Math.max(0, this.getSelectedItemPosition());
        int n6 = Math.min(spinnerAdapter.getCount(), n5 + 15);
        int n7 = Math.max(0, n5 - (15 - (n6 - n5)));
        View view = null;
        n5 = 0;
        while (n7 < n6) {
            int n8 = spinnerAdapter.getItemViewType(n7);
            int n9 = n2;
            if (n8 != n2) {
                view = null;
                n9 = n8;
            }
            if ((view = spinnerAdapter.getView(n7, view, (ViewGroup)this)).getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(n3, n4);
            n5 = Math.max(n5, view.getMeasuredWidth());
            ++n7;
            n2 = n9;
        }
        n7 = n5;
        if (drawable2 != null) {
            drawable2.getPadding(this.c);
            n7 = n5 + (this.c.left + this.c.right);
        }
        return n7;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.a != null) {
            return this.a.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        if (this.a != null) {
            return this.a.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.a != null) {
            return this.b;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        if (this.a != null) {
            return this.a.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.a != null) {
            return this.f;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        if (this.a != null) {
            return this.a.b();
        }
        return super.getPrompt();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.e != null) {
            return this.e.a();
        }
        return null;
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.e != null) {
            return this.e.b();
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null && this.a.d()) {
            this.a.c();
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.a != null && View.MeasureSpec.getMode((int)n2) == Integer.MIN_VALUE) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), View.MeasureSpec.getSize((int)n2)), this.getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g != null && this.g.onTouch((View)this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        if (this.a != null) {
            if (!this.a.d()) {
                this.a.a();
            }
            return true;
        }
        return super.performClick();
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.a != null) {
            Context context = this.f == null ? this.getContext() : this.f;
            this.a.a(new a(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        if (this.e != null) {
            this.e.a(drawable2);
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.e != null) {
            this.e.a(n2);
        }
    }

    public void setDropDownHorizontalOffset(int n2) {
        if (this.a != null) {
            this.a.c(n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(n2);
        }
    }

    public void setDropDownVerticalOffset(int n2) {
        if (this.a != null) {
            this.a.d(n2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(n2);
        }
    }

    public void setDropDownWidth(int n2) {
        if (this.a != null) {
            this.b = n2;
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(n2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable2) {
        if (this.a != null) {
            this.a.a(drawable2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable2);
        }
    }

    public void setPopupBackgroundResource(int n2) {
        this.setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(this.getPopupContext(), n2));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.a != null) {
            this.a.a(charSequence);
            return;
        }
        super.setPrompt(charSequence);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }

    private static class a
    implements ListAdapter,
    SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter)spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    if ((spinnerAdapter = (ThemedSpinnerAdapter)spinnerAdapter).getDropDownViewTheme() != theme) {
                        spinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                } else if (spinnerAdapter instanceof ak && (spinnerAdapter = (ak)spinnerAdapter).a() == null) {
                    spinnerAdapter.a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.getCount();
        }

        public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
            if (this.a == null) {
                return null;
            }
            return this.a.getDropDownView(n2, view, viewGroup);
        }

        public Object getItem(int n2) {
            if (this.a == null) {
                return null;
            }
            return this.a.getItem(n2);
        }

        public long getItemId(int n2) {
            if (this.a == null) {
                return -1L;
            }
            return this.a.getItemId(n2);
        }

        public int getItemViewType(int n2) {
            return 0;
        }

        public View getView(int n2, View view, ViewGroup viewGroup) {
            return this.getDropDownView(n2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public boolean isEmpty() {
            return this.getCount() == 0;
        }

        public boolean isEnabled(int n2) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(n2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b
    extends ac {
        ListAdapter a;
        private CharSequence h;
        private final Rect i;

        public b(Context context, AttributeSet attributeSet, int n2) {
            super(context, attributeSet, n2);
            this.i = new Rect();
            this.b((View)s.this);
            this.a(true);
            this.a(0);
            this.a(new AdapterView.OnItemClickListener(){

                public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                    s.this.setSelection(n2);
                    if (s.this.getOnItemClickListener() != null) {
                        s.this.performItemClick(view, n2, b.this.a.getItemId(n2));
                    }
                    b.this.c();
                }
            });
        }

        @Override
        public void a() {
            boolean bl2 = this.d();
            this.f();
            this.h(2);
            super.a();
            this.e().setChoiceMode(1);
            this.i(s.this.getSelectedItemPosition());
            if (bl2) {
                return;
            }
            ViewTreeObserver viewTreeObserver = s.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(){

                    public void onGlobalLayout() {
                        if (!b.this.a((View)s.this)) {
                            b.this.c();
                            return;
                        }
                        b.this.f();
                        b.super.a();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                this.a(new PopupWindow.OnDismissListener(){

                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = s.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        }

        @Override
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        boolean a(View view) {
            return t.B(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        /*
         * Enabled aggressive block sorting
         */
        void f() {
            int n2;
            Drawable drawable2 = this.h();
            int n3 = 0;
            if (drawable2 != null) {
                drawable2.getPadding(s.this.c);
                n2 = au.a((View)s.this) ? s.this.c.right : -s.this.c.left;
                n3 = n2;
            } else {
                drawable2 = s.this.c;
                s.this.c.right = 0;
                drawable2.left = 0;
            }
            int n4 = s.this.getPaddingLeft();
            int n5 = s.this.getPaddingRight();
            int n6 = s.this.getWidth();
            if (s.this.b == -2) {
                int n7 = s.this.a((SpinnerAdapter)this.a, this.h());
                int n8 = s.this.getContext().getResources().getDisplayMetrics().widthPixels - s.this.c.left - s.this.c.right;
                n2 = n7;
                if (n7 > n8) {
                    n2 = n8;
                }
                n2 = Math.max(n2, n6 - n4 - n5);
            } else {
                n2 = s.this.b == -1 ? n6 - n4 - n5 : s.this.b;
            }
            this.g(n2);
            n2 = au.a((View)s.this) ? n3 + (n6 - n5 - this.l()) : n3 + n4;
            this.c(n2);
        }

    }

}

