/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.a;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
extends View {
    private int a = 0;
    private int b;
    private WeakReference<View> c;
    private LayoutInflater d;
    private a e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        context = context.obtainStyledAttributes(attributeSet, a.j.ViewStubCompat, n2, 0);
        this.b = context.getResourceId(a.j.ViewStubCompat_android_inflatedId, -1);
        this.a = context.getResourceId(a.j.ViewStubCompat_android_layout, 0);
        this.setId(context.getResourceId(a.j.ViewStubCompat_android_id, -1));
        context.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    public View a() {
        ViewParent viewParent = this.getParent();
        if (viewParent != null && viewParent instanceof ViewGroup) {
            if (this.a != 0) {
                ViewGroup viewGroup = (ViewGroup)viewParent;
                viewParent = this.d != null ? this.d : LayoutInflater.from((Context)this.getContext());
                viewParent = viewParent.inflate(this.a, viewGroup, false);
                if (this.b != -1) {
                    viewParent.setId(this.b);
                }
                int n2 = viewGroup.indexOfChild((View)this);
                viewGroup.removeViewInLayout((View)this);
                ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView((View)viewParent, n2, layoutParams);
                } else {
                    viewGroup.addView((View)viewParent, n2);
                }
                this.c = new WeakReference<ViewParent>(viewParent);
                if (this.e != null) {
                    this.e.a(this, (View)viewParent);
                }
                return viewParent;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint(value={"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.d;
    }

    public int getLayoutResource() {
        return this.a;
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int n2) {
        this.b = n2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.d = layoutInflater;
    }

    public void setLayoutResource(int n2) {
        this.a = n2;
    }

    public void setOnInflateListener(a a2) {
        this.e = a2;
    }

    public void setVisibility(int n2) {
        if (this.c != null) {
            View view = (View)this.c.get();
            if (view != null) {
                view.setVisibility(n2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(n2);
        if (n2 == 0 || n2 == 4) {
            this.a();
        }
    }

    public static interface a {
        public void a(ViewStubCompat var1, View var2);
    }

}

