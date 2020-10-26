/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Button
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.t;
import androidx.core.h.r;
import androidx.core.widget.b;
import androidx.core.widget.i;

public class AppCompatButton
extends Button
implements r,
b {
    private final f a = new f((View)this);
    private final t b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int n2) {
        super(al.a(context), attributeSet, n2);
        this.a.a(attributeSet, n2);
        this.b = new t((TextView)this);
        this.b.a(attributeSet, n2);
        this.b.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.b != null) {
            return this.b.g();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.b != null) {
            return this.b.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.b != null) {
            return this.b.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.b != null) {
            return this.b.h();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        boolean bl2 = d;
        int n2 = 0;
        if (bl2) {
            if (super.getAutoSizeTextType() == 1) {
                n2 = 1;
            }
            return n2;
        }
        if (this.b != null) {
            return this.b.d();
        }
        return 0;
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (this.b != null) {
            this.b.a(bl2, n2, n3, n4, n5);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        super.onTextChanged(charSequence, n2, n3, n4);
        if (this.b != null && !d && this.b.c()) {
            this.b.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n2, int n3, int n4, int n5) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n2, n3, n4, n5);
            return;
        }
        if (this.b != null) {
            this.b.a(n2, n3, n4, n5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arrn, int n2) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arrn, n2);
            return;
        }
        if (this.b != null) {
            this.b.a(arrn, n2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int n2) {
        if (d) {
            super.setAutoSizeTextTypeWithDefaults(n2);
            return;
        }
        if (this.b != null) {
            this.b.a(n2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        if (this.a != null) {
            this.a.a(drawable2);
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.a != null) {
            this.a.a(n2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView)this, callback));
    }

    public void setSupportAllCaps(boolean bl2) {
        if (this.b != null) {
            this.b.a(bl2);
        }
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.b != null) {
            this.b.a(context, n2);
        }
    }

    public void setTextSize(int n2, float f2) {
        if (d) {
            super.setTextSize(n2, f2);
            return;
        }
        if (this.b != null) {
            this.b.a(n2, f2);
        }
    }
}

