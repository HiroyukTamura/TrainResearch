/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.j;

public class f
extends ViewGroup {
    e a;

    protected a a() {
        return new a(-2, -2);
    }

    public a a(AttributeSet attributeSet) {
        return new a(this.getContext(), attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public e getConstraintSet() {
        if (this.a == null) {
            this.a = new e();
        }
        this.a.a(this);
        return this.a;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
    }

    public static class a
    extends ConstraintLayout.a {
        public float aA;
        public float ao = 1.0f;
        public boolean ap;
        public float aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public a(int n2, int n3) {
            super(n2, n3);
            this.ap = false;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 0.0f;
            this.au = 1.0f;
            this.av = 1.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            this.aA = 0.0f;
        }

        /*
         * Enabled aggressive block sorting
         */
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int n2 = 0;
            this.ap = false;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 0.0f;
            this.au = 1.0f;
            this.av = 1.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            this.aA = 0.0f;
            context = context.obtainStyledAttributes(attributeSet, j.b.ConstraintSet);
            int n3 = context.getIndexCount();
            do {
                block6 : {
                    int n4;
                    float f2;
                    block16 : {
                        block17 : {
                            block15 : {
                                block14 : {
                                    block13 : {
                                        block12 : {
                                            block11 : {
                                                block10 : {
                                                    block9 : {
                                                        block8 : {
                                                            block7 : {
                                                                block5 : {
                                                                    if (n2 >= n3) {
                                                                        return;
                                                                    }
                                                                    n4 = context.getIndex(n2);
                                                                    if (n4 != j.b.ConstraintSet_android_alpha) break block5;
                                                                    this.ao = context.getFloat(n4, this.ao);
                                                                    break block6;
                                                                }
                                                                if (n4 != j.b.ConstraintSet_android_elevation) break block7;
                                                                this.aq = context.getFloat(n4, this.aq);
                                                                this.ap = true;
                                                                break block6;
                                                            }
                                                            if (n4 != j.b.ConstraintSet_android_rotationX) break block8;
                                                            this.as = context.getFloat(n4, this.as);
                                                            break block6;
                                                        }
                                                        if (n4 != j.b.ConstraintSet_android_rotationY) break block9;
                                                        this.at = context.getFloat(n4, this.at);
                                                        break block6;
                                                    }
                                                    if (n4 != j.b.ConstraintSet_android_rotation) break block10;
                                                    this.ar = context.getFloat(n4, this.ar);
                                                    break block6;
                                                }
                                                if (n4 != j.b.ConstraintSet_android_scaleX) break block11;
                                                this.au = context.getFloat(n4, this.au);
                                                break block6;
                                            }
                                            if (n4 != j.b.ConstraintSet_android_scaleY) break block12;
                                            this.av = context.getFloat(n4, this.av);
                                            break block6;
                                        }
                                        if (n4 != j.b.ConstraintSet_android_transformPivotX) break block13;
                                        this.aw = context.getFloat(n4, this.aw);
                                        break block6;
                                    }
                                    if (n4 != j.b.ConstraintSet_android_transformPivotY) break block14;
                                    this.ax = context.getFloat(n4, this.ax);
                                    break block6;
                                }
                                if (n4 != j.b.ConstraintSet_android_translationX) break block15;
                                f2 = this.ay;
                                break block16;
                            }
                            if (n4 != j.b.ConstraintSet_android_translationY) break block17;
                            this.az = context.getFloat(n4, this.az);
                            break block6;
                        }
                        if (n4 != j.b.ConstraintSet_android_translationZ) break block6;
                        f2 = this.aA;
                    }
                    this.ay = context.getFloat(n4, f2);
                }
                ++n2;
            } while (true);
        }
    }

}

