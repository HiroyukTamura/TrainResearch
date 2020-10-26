/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class g {
    public static void a(ListView listView, int n2) {
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(n2);
            return;
        }
        int n3 = listView.getFirstVisiblePosition();
        if (n3 == -1) {
            return;
        }
        View view = listView.getChildAt(0);
        if (view == null) {
            return;
        }
        listView.setSelectionFromTop(n3, view.getTop() - n2);
    }

    public static boolean b(ListView listView, int n2) {
        boolean bl2;
        block8 : {
            block7 : {
                if (Build.VERSION.SDK_INT >= 19) {
                    return listView.canScrollList(n2);
                }
                int n3 = listView.getChildCount();
                boolean bl3 = false;
                bl2 = false;
                if (n3 == 0) {
                    return false;
                }
                int n4 = listView.getFirstVisiblePosition();
                if (n2 > 0) {
                    n2 = listView.getChildAt(n3 - 1).getBottom();
                    if (n4 + n3 < listView.getCount() || n2 > listView.getHeight() - listView.getListPaddingBottom()) {
                        bl2 = true;
                    }
                    return bl2;
                }
                n2 = listView.getChildAt(0).getTop();
                if (n4 > 0) break block7;
                bl2 = bl3;
                if (n2 >= listView.getListPaddingTop()) break block8;
            }
            bl2 = true;
        }
        return bl2;
    }
}

