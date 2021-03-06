/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.text.Layout
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.widget.i;

public class DialogTitle
extends TextView {
    public DialogTitle(Context context) {
        super(context);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        super.onMeasure(n2, n3);
        Layout layout2 = this.getLayout();
        if (layout2 != null && (n4 = layout2.getLineCount()) > 0 && layout2.getEllipsisCount(n4 - 1) > 0) {
            this.setSingleLine(false);
            this.setMaxLines(2);
            layout2 = this.getContext().obtainStyledAttributes(null, a.j.TextAppearance, 16842817, 16973892);
            n4 = layout2.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
            if (n4 != 0) {
                this.setTextSize(0, (float)n4);
            }
            layout2.recycle();
            super.onMeasure(n2, n3);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView)this, callback));
    }
}

