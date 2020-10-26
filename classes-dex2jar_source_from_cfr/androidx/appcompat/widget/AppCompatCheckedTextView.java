/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.t;
import androidx.core.widget.i;

public class AppCompatCheckedTextView
extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private final t b = new t((TextView)this);

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context object, AttributeSet attributeSet, int n2) {
        super(al.a((Context)object), attributeSet, n2);
        this.b.a(attributeSet, n2);
        this.b.a();
        object = ao.a(this.getContext(), attributeSet, a, n2, 0);
        this.setCheckMarkDrawable(((ao)object).a(0));
        ((ao)object).a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
    }

    public void setCheckMarkDrawable(int n2) {
        this.setCheckMarkDrawable(a.b(this.getContext(), n2));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView)this, callback));
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.b != null) {
            this.b.a(context, n2);
        }
    }
}

