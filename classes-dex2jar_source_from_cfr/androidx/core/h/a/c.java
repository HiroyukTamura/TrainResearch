/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 */
package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class c {
    private final Object a;

    /*
     * Enabled aggressive block sorting
     */
    public c() {
        void var1_2;
        if (Build.VERSION.SDK_INT >= 19) {
            b b2 = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            a a2 = new a(this);
        } else {
            Object var1_4 = null;
        }
        this.a = var1_2;
    }

    public c(Object object) {
        this.a = object;
    }

    public androidx.core.h.a.b a(int n2) {
        return null;
    }

    public Object a() {
        return this.a;
    }

    public List<androidx.core.h.a.b> a(String string2, int n2) {
        return null;
    }

    public boolean a(int n2, int n3, Bundle bundle) {
        return false;
    }

    public androidx.core.h.a.b b(int n2) {
        return null;
    }

    static class a
    extends AccessibilityNodeProvider {
        final c a;

        a(c c2) {
            this.a = c2;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int n2) {
            androidx.core.h.a.b b2 = this.a.a(n2);
            if (b2 == null) {
                return null;
            }
            return b2.a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String object, int n2) {
            if ((object = this.a.a((String)object, n2)) == null) {
                return null;
            }
            ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
            int n3 = object.size();
            for (n2 = 0; n2 < n3; ++n2) {
                arrayList.add(((androidx.core.h.a.b)object.get(n2)).a());
            }
            return arrayList;
        }

        public boolean performAction(int n2, int n3, Bundle bundle) {
            return this.a.a(n2, n3, bundle);
        }
    }

    static class b
    extends a {
        b(c c2) {
            super(c2);
        }

        public AccessibilityNodeInfo findFocus(int n2) {
            androidx.core.h.a.b b2 = this.a.b(n2);
            if (b2 == null) {
                return null;
            }
            return b2.a();
        }
    }

}

