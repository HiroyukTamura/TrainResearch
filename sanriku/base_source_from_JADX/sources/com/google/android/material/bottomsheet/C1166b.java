package com.google.android.material.bottomsheet;

import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import p043jp.reifrontier.sanriku.R;

/* renamed from: com.google.android.material.bottomsheet.b */
public class C1166b extends AppCompatDialog {

    /* renamed from: a */
    private BottomSheetBehavior<FrameLayout> f1106a;

    /* renamed from: b */
    boolean f1107b;

    /* renamed from: c */
    private boolean f1108c;

    /* renamed from: d */
    private boolean f1109d;

    /* renamed from: e */
    private BottomSheetBehavior.C1163b f1110e;

    /* renamed from: com.google.android.material.bottomsheet.b$a */
    class C1167a implements View.OnClickListener {
        C1167a() {
        }

        public void onClick(View view) {
            C1166b bVar = C1166b.this;
            if (bVar.f1107b && bVar.isShowing() && C1166b.this.mo25376a()) {
                C1166b.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.b$b */
    class C1168b extends AccessibilityDelegateCompat {
        C1168b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (C1166b.this.f1107b) {
                accessibilityNodeInfoCompat.addAction(1048576);
                z = true;
            } else {
                z = false;
            }
            accessibilityNodeInfoCompat.setDismissable(z);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                C1166b bVar = C1166b.this;
                if (bVar.f1107b) {
                    bVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.b$c */
    class C1169c implements View.OnTouchListener {
        C1169c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.b$d */
    class C1170d extends BottomSheetBehavior.C1163b {
        C1170d() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1166b(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.StyleRes int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 != 0) goto L_0x001b
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources$Theme r1 = r4.getTheme()
            r2 = 2130903112(0x7f030048, float:1.7413033E38)
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0018
            int r5 = r5.resourceId
            goto L_0x001b
        L_0x0018:
            r5 = 2131689827(0x7f0f0163, float:1.900868E38)
        L_0x001b:
            r3.<init>(r4, r5)
            r3.f1107b = r0
            r3.f1108c = r0
            com.google.android.material.bottomsheet.b$d r4 = new com.google.android.material.bottomsheet.b$d
            r4.<init>()
            r3.f1110e = r4
            r3.supportRequestWindowFeature(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.C1166b.<init>(android.content.Context, int):void");
    }

    /* renamed from: a */
    private View m1750a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
        if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                BottomSheetBehavior<FrameLayout> bottomSheetBehavior = (BottomSheetBehavior) behavior;
                this.f1106a = bottomSheetBehavior;
                bottomSheetBehavior.mo25367a(this.f1110e);
                this.f1106a.f1081j = this.f1107b;
                if (layoutParams == null) {
                    frameLayout2.addView(view);
                } else {
                    frameLayout2.addView(view, layoutParams);
                }
                coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new C1167a());
                ViewCompat.setAccessibilityDelegate(frameLayout2, new C1168b());
                frameLayout2.setOnTouchListener(new C1169c());
                return frameLayout;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25376a() {
        if (!this.f1109d) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f1108c = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f1109d = true;
        }
        return this.f1108c;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        int i;
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f1106a;
        if (bottomSheetBehavior != null && (i = bottomSheetBehavior.f1083l) == 5 && 4 != i) {
            WeakReference<V> weakReference = bottomSheetBehavior.f1089r;
            if (weakReference == null) {
                bottomSheetBehavior.f1083l = 4;
                return;
            }
            View view = (View) weakReference.get();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(view)) {
                    bottomSheetBehavior.mo25366a(view, 4);
                } else {
                    view.post(new C1165a(bottomSheetBehavior, view, 4));
                }
            }
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f1107b != z) {
            this.f1107b = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f1106a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.f1081j = z;
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f1107b) {
            this.f1107b = true;
        }
        this.f1108c = z;
        this.f1109d = true;
    }

    public void setContentView(@LayoutRes int i) {
        super.setContentView(m1750a(i, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view) {
        super.setContentView(m1750a(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m1750a(0, view, layoutParams));
    }
}
