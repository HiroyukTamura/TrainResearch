/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 */
package androidx.core.h;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.h.a.b;
import androidx.core.h.a.c;

public class a {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b = new a(this);

    View.AccessibilityDelegate a() {
        return this.b;
    }

    public c a(View view) {
        if (Build.VERSION.SDK_INT >= 16 && (view = a.getAccessibilityNodeProvider(view)) != null) {
            return new c((Object)view);
        }
        return null;
    }

    public void a(View view, int n2) {
        a.sendAccessibilityEvent(view, n2);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, b b2) {
        a.onInitializeAccessibilityNodeInfo(view, b2.a());
    }

    public boolean a(View view, int n2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a.performAccessibilityAction(view, n2, bundle);
        }
        return false;
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    private static final class a
    extends View.AccessibilityDelegate {
        private final a a;

        a(a a2) {
            this.a = a2;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.b(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View object) {
            if ((object = this.a.a((View)object)) != null) {
                return (AccessibilityNodeProvider)((c)object).a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.a.a(view, b.a(accessibilityNodeInfo));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int n2, Bundle bundle) {
            return this.a.a(view, n2, bundle);
        }

        public void sendAccessibilityEvent(View view, int n2) {
            this.a.a(view, n2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.a(view, accessibilityEvent);
        }
    }

}

