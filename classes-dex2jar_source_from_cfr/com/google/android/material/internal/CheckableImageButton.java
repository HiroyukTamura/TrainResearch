/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.widget.Checkable
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.h.a;
import androidx.core.h.a.b;
import androidx.core.h.t;

public class CheckableImageButton
extends AppCompatImageButton
implements Checkable {
    private static final int[] a = new int[]{16842912};
    private boolean b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        t.a((View)this, new a(){

            @Override
            public void a(View view, b b2) {
                super.a(view, b2);
                b2.a(true);
                b2.b(CheckableImageButton.this.isChecked());
            }

            @Override
            public void d(View view, AccessibilityEvent accessibilityEvent) {
                super.d(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public boolean isChecked() {
        return this.b;
    }

    public int[] onCreateDrawableState(int n2) {
        if (this.b) {
            return CheckableImageButton.mergeDrawableStates((int[])super.onCreateDrawableState(n2 + a.length), (int[])a);
        }
        return super.onCreateDrawableState(n2);
    }

    public void setChecked(boolean bl2) {
        if (this.b != bl2) {
            this.b = bl2;
            this.refreshDrawableState();
            this.sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        this.setChecked(this.b ^ true);
    }

}

