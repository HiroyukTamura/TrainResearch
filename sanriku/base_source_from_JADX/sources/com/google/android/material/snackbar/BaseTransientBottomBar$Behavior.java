package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.C1201c;

public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: j */
    private final C1198a f1231j = new C1198a(this);

    /* renamed from: a */
    public boolean mo25356a(View view) {
        if (this.f1231j != null) {
            return view instanceof C1199b;
        }
        throw null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f1231j != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    C1201c.m1826a().mo25491b((C1201c.C1203b) null);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                C1201c.m1826a().mo25489a((C1201c.C1203b) null);
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
        throw null;
    }
}
