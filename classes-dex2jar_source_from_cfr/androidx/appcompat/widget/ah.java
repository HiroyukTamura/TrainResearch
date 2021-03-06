/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.AbsListView
 *  android.widget.AbsListView$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.BaseAdapter
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.aq;
import androidx.appcompat.widget.s;

public class ah
extends HorizontalScrollView
implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    ab b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    private void b() {
        if (this.a()) {
            return;
        }
        if (this.f == null) {
            this.f = this.d();
        }
        this.removeView((View)this.b);
        this.addView((View)this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter)new a());
        }
        if (this.a != null) {
            this.removeCallbacks(this.a);
            this.a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (!this.a()) {
            return false;
        }
        this.removeView((View)this.f);
        this.addView((View)this.b, new ViewGroup.LayoutParams(-2, -1));
        this.setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    private Spinner d() {
        s s2 = new s(this.getContext(), null, a.a.actionDropDownStyle);
        s2.setLayoutParams((ViewGroup.LayoutParams)new ab.a(-2, -1));
        s2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        return s2;
    }

    c a(a.c object, boolean bl2) {
        object = new c(this.getContext(), (a.c)object, bl2);
        if (bl2) {
            object.setBackgroundDrawable(null);
            object.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.h));
            return object;
        }
        object.setFocusable(true);
        if (this.e == null) {
            this.e = new b();
        }
        object.setOnClickListener((View.OnClickListener)this.e);
        return object;
    }

    public void a(int n2) {
        final View view = this.b.getChildAt(n2);
        if (this.a != null) {
            this.removeCallbacks(this.a);
        }
        this.a = new Runnable(){

            @Override
            public void run() {
                int n2 = view.getLeft();
                int n3 = (ah.this.getWidth() - view.getWidth()) / 2;
                ah.this.smoothScrollTo(n2 - n3, 0);
                ah.this.a = null;
            }
        };
        this.post(this.a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.post(this.a);
        }
    }

    protected void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        object = androidx.appcompat.view.a.a(this.getContext());
        this.setContentHeight(((androidx.appcompat.view.a)object).e());
        this.d = ((androidx.appcompat.view.a)object).g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.removeCallbacks(this.a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n2, long l2) {
        ((c)view).b().d();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onMeasure(int var1_1, int var2_2) {
        var2_2 = View.MeasureSpec.getMode((int)var1_1);
        var3_3 = 1;
        var5_4 = var2_2 == 1073741824;
        this.setFillViewport(var5_4);
        var4_5 = this.b.getChildCount();
        if (var4_5 > 1 && (var2_2 == 1073741824 || var2_2 == Integer.MIN_VALUE)) {
            this.c = var4_5 > 2 ? (int)((float)View.MeasureSpec.getSize((int)var1_1) * 0.4f) : View.MeasureSpec.getSize((int)var1_1) / 2;
            var2_2 = Math.min(this.c, this.d);
        } else {
            var2_2 = -1;
        }
        this.c = var2_2;
        var4_5 = View.MeasureSpec.makeMeasureSpec((int)this.h, (int)1073741824);
        var2_2 = var5_4 == false && this.g != false ? var3_3 : 0;
        if (var2_2 == 0) ** GOTO lbl-1000
        this.b.measure(0, var4_5);
        if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize((int)var1_1)) {
            this.b();
        } else lbl-1000: // 2 sources:
        {
            this.c();
        }
        var2_2 = this.getMeasuredWidth();
        super.onMeasure(var1_1, var4_5);
        var1_1 = this.getMeasuredWidth();
        if (var5_4 == false) return;
        if (var2_2 == var1_1) return;
        this.setTabSelected(this.i);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean bl2) {
        this.g = bl2;
    }

    public void setContentHeight(int n2) {
        this.h = n2;
        this.requestLayout();
    }

    public void setTabSelected(int n2) {
        this.i = n2;
        int n3 = this.b.getChildCount();
        for (int i2 = 0; i2 < n3; ++i2) {
            View view = this.b.getChildAt(i2);
            boolean bl2 = i2 == n2;
            view.setSelected(bl2);
            if (!bl2) continue;
            this.a(n2);
        }
        if (this.f != null && n2 >= 0) {
            this.f.setSelection(n2);
        }
    }

    private class a
    extends BaseAdapter {
        a() {
        }

        public int getCount() {
            return ah.this.b.getChildCount();
        }

        public Object getItem(int n2) {
            return ((c)ah.this.b.getChildAt(n2)).b();
        }

        public long getItemId(int n2) {
            return n2;
        }

        public View getView(int n2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ah.this.a((a.c)this.getItem(n2), true);
            }
            ((c)view).a((a.c)this.getItem(n2));
            return view;
        }
    }

    private class b
    implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((c)view).b().d();
            int n2 = ah.this.b.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = ah.this.b.getChildAt(i2);
                boolean bl2 = view2 == view;
                view2.setSelected(bl2);
            }
        }
    }

    private class c
    extends LinearLayout {
        private final int[] b;
        private a.c c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, a.c c2, boolean bl2) {
            super(context, null, a.a.actionBarTabStyle);
            this.b = new int[]{16842964};
            this.c = c2;
            ah.this = ao.a(context, null, this.b, a.a.actionBarTabStyle, 0);
            if (((ao)ah.this).g(0)) {
                this.setBackgroundDrawable(((ao)ah.this).a(0));
            }
            ((ao)ah.this).a();
            if (bl2) {
                this.setGravity(8388627);
            }
            this.a();
        }

        public void a() {
            a.c c2 = this.c;
            Object object = c2.c();
            Object object2 = null;
            if (object != null) {
                object2 = object.getParent();
                if (object2 != this) {
                    if (object2 != null) {
                        ((ViewGroup)object2).removeView(object);
                    }
                    this.addView(object);
                }
                this.f = object;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
            } else {
                AppCompatImageView appCompatImageView;
                if (this.f != null) {
                    this.removeView(this.f);
                    this.f = null;
                }
                Object object3 = c2.a();
                object = c2.b();
                if (object3 != null) {
                    if (this.e == null) {
                        appCompatImageView = new AppCompatImageView(this.getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        appCompatImageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                        this.addView((View)appCompatImageView, 0);
                        this.e = appCompatImageView;
                    }
                    this.e.setImageDrawable(object3);
                    this.e.setVisibility(0);
                } else if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)object) ^ true;
                if (bl2) {
                    if (this.d == null) {
                        object3 = new AppCompatTextView(this.getContext(), null, a.a.actionBarTabTextStyle);
                        object3.setEllipsize(TextUtils.TruncateAt.END);
                        appCompatImageView = new LinearLayout.LayoutParams(-2, -2);
                        ((LinearLayout.LayoutParams)appCompatImageView).gravity = 16;
                        object3.setLayoutParams((ViewGroup.LayoutParams)appCompatImageView);
                        this.addView((View)object3);
                        this.d = object3;
                    }
                    this.d.setText((CharSequence)object);
                    this.d.setVisibility(0);
                } else if (this.d != null) {
                    this.d.setVisibility(8);
                    this.d.setText(null);
                }
                if (this.e != null) {
                    this.e.setContentDescription(c2.e());
                }
                if (!bl2) {
                    object2 = c2.e();
                }
                aq.a((View)this, (CharSequence)object2);
            }
        }

        public void a(a.c c2) {
            this.c = c2;
            this.a();
        }

        public a.c b() {
            return this.c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)a.c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)a.c.class.getName());
        }

        public void onMeasure(int n2, int n3) {
            super.onMeasure(n2, n3);
            if (ah.this.c > 0 && this.getMeasuredWidth() > ah.this.c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)ah.this.c, (int)1073741824), n3);
            }
        }

        public void setSelected(boolean bl2) {
            boolean bl3 = this.isSelected() != bl2;
            super.setSelected(bl2);
            if (bl3 && bl2) {
                this.sendAccessibilityEvent(4);
            }
        }
    }

}

