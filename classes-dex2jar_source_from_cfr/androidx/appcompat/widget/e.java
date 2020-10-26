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
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.AutoCompleteTextView
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
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.t;
import androidx.core.h.r;
import androidx.core.widget.i;

public class e
extends AutoCompleteTextView
implements r {
    private static final int[] a = new int[]{16843126};
    private final f b;
    private final t c;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.autoCompleteTextViewStyle);
    }

    public e(Context object, AttributeSet attributeSet, int n2) {
        super(al.a((Context)object), attributeSet, n2);
        object = ao.a(this.getContext(), attributeSet, a, n2, 0);
        if (((ao)object).g(0)) {
            this.setDropDownBackgroundDrawable(((ao)object).a(0));
        }
        ((ao)object).a();
        this.b = new f((View)this);
        this.b.a(attributeSet, n2);
        this.c = new t((TextView)this);
        this.c.a(attributeSet, n2);
        this.c.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        if (this.b != null) {
            this.b.a(drawable2);
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.b != null) {
            this.b.a(n2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView)this, callback));
    }

    public void setDropDownBackgroundResource(int n2) {
        this.setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(this.getContext(), n2));
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.c != null) {
            this.c.a(context, n2);
        }
    }
}

