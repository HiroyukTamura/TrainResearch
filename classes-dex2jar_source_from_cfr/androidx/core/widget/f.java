/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.view.View;
import android.widget.ListView;
import androidx.core.widget.a;
import androidx.core.widget.g;

public class f
extends a {
    private final ListView f;

    public f(ListView listView) {
        super((View)listView);
        this.f = listView;
    }

    @Override
    public void a(int n2, int n3) {
        g.a(this.f, n3);
    }

    @Override
    public boolean e(int n2) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean f(int n2) {
        ListView listView = this.f;
        int n3 = listView.getCount();
        if (n3 == 0) {
            return false;
        }
        int n4 = listView.getChildCount();
        int n5 = listView.getFirstVisiblePosition();
        if (n2 > 0) {
            if (n5 + n4 < n3 || listView.getChildAt(n4 - 1).getBottom() > listView.getHeight()) return true;
            return false;
        }
        if (n2 >= 0) return false;
        if (n5 > 0 || listView.getChildAt(0).getTop() < 0) return true;
        return false;
    }
}

