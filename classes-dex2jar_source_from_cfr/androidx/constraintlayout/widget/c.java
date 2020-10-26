/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.j;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class c
extends View {
    protected int[] a = new int[32];
    protected int b;
    protected Context c;
    protected androidx.constraintlayout.b.a.j d;
    protected boolean e = false;
    private String f;
    private View[] g = null;

    public c(Context context) {
        super(context);
        this.c = context;
        this.a((AttributeSet)null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        Object object;
        int n2;
        block11 : {
            if (string2 == null) {
                return;
            }
            if (this.c == null) {
                return;
            }
            string2 = string2.trim();
            try {
                n2 = j.a.class.getField(string2).getInt(null);
                break block11;
            }
            catch (Exception exception) {}
            n2 = 0;
        }
        int n3 = n2;
        if (n2 == 0) {
            n3 = this.c.getResources().getIdentifier(string2, "id", this.c.getPackageName());
        }
        n2 = n3;
        if (n3 == 0) {
            n2 = n3;
            if (this.isInEditMode()) {
                n2 = n3;
                if (this.getParent() instanceof ConstraintLayout) {
                    object = ((ConstraintLayout)this.getParent()).a(0, string2);
                    n2 = n3;
                    if (object != null) {
                        n2 = n3;
                        if (object instanceof Integer) {
                            n2 = (Integer)object;
                        }
                    }
                }
            }
        }
        if (n2 != 0) {
            this.setTag(n2, null);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Could not find id of \"");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("\"");
        Log.w((String)"ConstraintHelper", (String)((StringBuilder)object).toString());
    }

    private void setIds(String string2) {
        if (string2 == null) {
            return;
        }
        int n2 = 0;
        do {
            int n3;
            if ((n3 = string2.indexOf(44, n2)) == -1) {
                this.a(string2.substring(n2));
                return;
            }
            this.a(string2.substring(n2, n3));
            n2 = n3 + 1;
        } while (true);
    }

    protected void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, j.b.ConstraintLayout_Layout);
            int n2 = attributeSet.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = attributeSet.getIndex(i2);
                if (n3 != j.b.ConstraintLayout_Layout_constraint_referenced_ids) continue;
                this.f = attributeSet.getString(n3);
                this.setIds(this.f);
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.isInEditMode()) {
            this.setIds(this.f);
        }
        if (this.d == null) {
            return;
        }
        this.d.a_();
        for (int i2 = 0; i2 < this.b; ++i2) {
            View view = constraintLayout.findViewById(this.a[i2]);
            if (view == null) continue;
            this.d.a(constraintLayout.a(view));
        }
    }

    public void b() {
        if (this.d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a)layoutParams).am = (f)((Object)this.d);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    public void onDraw(Canvas canvas) {
    }

    protected void onMeasure(int n2, int n3) {
        if (this.e) {
            super.onMeasure(n2, n3);
            return;
        }
        this.setMeasuredDimension(0, 0);
    }

    public void setReferencedIds(int[] arrn) {
        this.b = 0;
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            this.setTag(arrn[i2], null);
        }
    }

    public void setTag(int n2, Object object) {
        if (this.b + 1 > this.a.length) {
            this.a = Arrays.copyOf(this.a, this.a.length * 2);
        }
        this.a[this.b] = n2;
        ++this.b;
    }
}

