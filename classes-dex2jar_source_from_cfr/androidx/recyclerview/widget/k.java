/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.b;
import androidx.recyclerview.widget.RecyclerView;

public class k
extends androidx.core.h.a {
    final RecyclerView a;
    final androidx.core.h.a b;

    public k(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.b = new a(this);
    }

    @Override
    public void a(View view, b b2) {
        super.a(view, b2);
        b2.a(RecyclerView.class.getName());
        if (!this.b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().a(b2);
        }
    }

    @Override
    public boolean a(View view, int n2, Bundle bundle) {
        if (super.a(view, n2, bundle)) {
            return true;
        }
        if (!this.b() && this.a.getLayoutManager() != null) {
            return this.a.getLayoutManager().a(n2, bundle);
        }
        return false;
    }

    boolean b() {
        return this.a.w();
    }

    public androidx.core.h.a c() {
        return this.b;
    }

    @Override
    public void d(View object, AccessibilityEvent accessibilityEvent) {
        super.d((View)object, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)RecyclerView.class.getName());
        if (object instanceof RecyclerView && !this.b() && ((RecyclerView)(object = (RecyclerView)object)).getLayoutManager() != null) {
            ((RecyclerView)object).getLayoutManager().a(accessibilityEvent);
        }
    }

    public static class a
    extends androidx.core.h.a {
        final k a;

        public a(k k2) {
            this.a = k2;
        }

        @Override
        public void a(View view, b b2) {
            super.a(view, b2);
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                this.a.a.getLayoutManager().a(view, b2);
            }
        }

        @Override
        public boolean a(View view, int n2, Bundle bundle) {
            if (super.a(view, n2, bundle)) {
                return true;
            }
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                return this.a.a.getLayoutManager().a(view, n2, bundle);
            }
            return false;
        }
    }

}

