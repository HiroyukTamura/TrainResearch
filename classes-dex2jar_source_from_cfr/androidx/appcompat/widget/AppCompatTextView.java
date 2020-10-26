/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.t;
import androidx.core.f.a;
import androidx.core.h.r;
import androidx.core.widget.b;
import androidx.core.widget.i;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
extends TextView
implements r,
b {
    private final f a = new f((View)this);
    private final t b;
    private Future<a> c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int n2) {
        super(al.a(context), attributeSet, n2);
        this.a.a(attributeSet, n2);
        this.b = new t(this);
        this.b.a(attributeSet, n2);
        this.b.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a() {
        if (this.c == null) return;
        try {
            Future<a> future = this.c;
            this.c = null;
            i.a((TextView)this, future.get());
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            return;
        }
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

    public int getFirstBaselineToTopHeight() {
        return i.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return i.c(this);
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

    public CharSequence getText() {
        this.a();
        return super.getText();
    }

    public a.a getTextMetricsParamsCompat() {
        return i.d(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (this.b != null) {
            this.b.a(bl2, n2, n3, n4, n5);
        }
    }

    protected void onMeasure(int n2, int n3) {
        this.a();
        super.onMeasure(n2, n3);
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

    public void setFirstBaselineToTopHeight(int n2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(n2);
            return;
        }
        i.b(this, n2);
    }

    public void setLastBaselineToBottomHeight(int n2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(n2);
            return;
        }
        i.c(this, n2);
    }

    public void setLineHeight(int n2) {
        i.d(this, n2);
    }

    public void setPrecomputedText(a a2) {
        i.a((TextView)this, a2);
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

    public void setTextFuture(Future<a> future) {
        this.c = future;
        this.requestLayout();
    }

    public void setTextMetricsParamsCompat(a.a a2) {
        i.a((TextView)this, a2);
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

