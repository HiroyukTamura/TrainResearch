/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.widget.ao;
import androidx.core.widget.h;

class m
extends PopupWindow {
    private static final boolean a;
    private boolean b;

    static {
        boolean bl2 = Build.VERSION.SDK_INT < 21;
        a = bl2;
    }

    public m(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.a(context, attributeSet, n2, n3);
    }

    private void a(Context object, AttributeSet attributeSet, int n2, int n3) {
        if (((ao)(object = ao.a((Context)object, attributeSet, a.j.PopupWindow, n2, n3))).g(a.j.PopupWindow_overlapAnchor)) {
            this.a(((ao)object).a(a.j.PopupWindow_overlapAnchor, false));
        }
        this.setBackgroundDrawable(((ao)object).a(a.j.PopupWindow_android_popupBackground));
        ((ao)object).a();
    }

    private void a(boolean bl2) {
        if (a) {
            this.b = bl2;
            return;
        }
        h.a((PopupWindow)this, bl2);
    }

    public void showAsDropDown(View view, int n2, int n3) {
        int n4 = n3;
        if (a) {
            n4 = n3;
            if (this.b) {
                n4 = n3 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n2, n4);
    }

    public void showAsDropDown(View view, int n2, int n3, int n4) {
        int n5 = n3;
        if (a) {
            n5 = n3;
            if (this.b) {
                n5 = n3 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n2, n5, n4);
    }

    public void update(View view, int n2, int n3, int n4, int n5) {
        int n6 = n3;
        if (a) {
            n6 = n3;
            if (this.b) {
                n6 = n3 - view.getHeight();
            }
        }
        super.update(view, n2, n6, n4, n5);
    }
}

