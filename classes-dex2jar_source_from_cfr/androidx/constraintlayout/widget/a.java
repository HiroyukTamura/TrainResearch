/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.b.a.b;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.j;

public class a
extends c {
    private int f;
    private int g;
    private b h;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override
    protected void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.h = new b();
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, j.b.ConstraintLayout_Layout);
            int n2 = attributeSet.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = attributeSet.getIndex(i2);
                if (n3 == j.b.ConstraintLayout_Layout_barrierDirection) {
                    this.setType(attributeSet.getInt(n3, 0));
                    continue;
                }
                if (n3 != j.b.ConstraintLayout_Layout_barrierAllowsGoneWidgets) continue;
                this.h.a(attributeSet.getBoolean(n3, true));
            }
        }
        this.d = this.h;
        this.b();
    }

    public boolean a() {
        return this.h.b();
    }

    public int getType() {
        return this.f;
    }

    public void setAllowsGoneWidget(boolean bl2) {
        this.h.a(bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setType(int n2) {
        block4 : {
            block5 : {
                block7 : {
                    block3 : {
                        block6 : {
                            block2 : {
                                this.f = n2;
                                this.g = n2;
                                if (Build.VERSION.SDK_INT >= 17) break block2;
                                if (this.f == 5) break block3;
                                if (this.f != 6) break block4;
                                break block5;
                            }
                            n2 = 1 == this.getResources().getConfiguration().getLayoutDirection() ? 1 : 0;
                            if (n2 == 0) break block6;
                            if (this.f == 5) break block5;
                            if (this.f != 6) break block4;
                            break block3;
                        }
                        if (this.f != 5) break block7;
                    }
                    this.g = 0;
                    break block4;
                }
                if (this.f != 6) break block4;
            }
            this.g = 1;
        }
        this.h.a(this.g);
    }
}

