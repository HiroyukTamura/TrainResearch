package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import p009e.p028d.p030b.p054b.C1533b;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.snackbar.b */
public class C1199b extends FrameLayout {

    /* renamed from: a */
    private final AccessibilityManager f1236a;

    /* renamed from: b */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f1237b;

    /* renamed from: com.google.android.material.snackbar.b$a */
    class C1200a implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
        C1200a() {
        }

        public void onTouchExplorationStateChanged(boolean z) {
            C1199b bVar = C1199b.this;
            bVar.setClickable(!z);
            bVar.setFocusable(z);
        }
    }

    protected C1199b(Context context) {
        this(context, (AttributeSet) null);
    }

    protected C1199b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1533b.f1766i);
        if (obtainStyledAttributes.hasValue(1)) {
            ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(1, 0));
        }
        obtainStyledAttributes.recycle();
        this.f1236a = (AccessibilityManager) context.getSystemService("accessibility");
        C1200a aVar = new C1200a();
        this.f1237b = aVar;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f1236a, aVar);
        boolean isTouchExplorationEnabled = this.f1236a.isTouchExplorationEnabled();
        setClickable(!isTouchExplorationEnabled);
        setFocusable(isTouchExplorationEnabled);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(this.f1236a, this.f1237b);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
