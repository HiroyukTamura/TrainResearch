/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 */
package androidx.core.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class b {
    public int a = -1;
    private final AccessibilityNodeInfo b;

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private static String b(int n2) {
        switch (n2) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 1: 
        }
        return "ACTION_FOCUS";
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public void a(int n2) {
        this.b.addAction(n2);
    }

    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void a(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public void a(Object object) {
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.b;
            object = object == null ? null : (AccessibilityNodeInfo.CollectionInfo)((a)object).a;
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)object);
        }
    }

    public void a(boolean bl2) {
        this.b.setCheckable(bl2);
    }

    public int b() {
        return this.b.getActions();
    }

    public void b(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public void b(Object object) {
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.b;
            object = object == null ? null : (AccessibilityNodeInfo.CollectionItemInfo)((b)object).a;
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)object);
        }
    }

    public void b(boolean bl2) {
        this.b.setChecked(bl2);
    }

    public void c(boolean bl2) {
        this.b.setScrollable(bl2);
    }

    public boolean c() {
        return this.b.isCheckable();
    }

    public void d(boolean bl2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setDismissable(bl2);
        }
    }

    public boolean d() {
        return this.b.isChecked();
    }

    public boolean e() {
        return this.b.isFocusable();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (b)object;
        return !(this.b == null ? ((b)object).b != null : !this.b.equals((Object)((b)object).b));
    }

    public boolean f() {
        return this.b.isFocused();
    }

    public boolean g() {
        return this.b.isSelected();
    }

    public boolean h() {
        return this.b.isClickable();
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public boolean i() {
        return this.b.isLongClickable();
    }

    public boolean j() {
        return this.b.isEnabled();
    }

    public boolean k() {
        return this.b.isPassword();
    }

    public boolean l() {
        return this.b.isScrollable();
    }

    public CharSequence m() {
        return this.b.getPackageName();
    }

    public CharSequence n() {
        return this.b.getClassName();
    }

    public CharSequence o() {
        return this.b.getText();
    }

    public CharSequence p() {
        return this.b.getContentDescription();
    }

    public String q() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Object object = new Rect();
        this.a((Rect)object);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInParent: ");
        stringBuilder2.append(object);
        stringBuilder.append(stringBuilder2.toString());
        this.b((Rect)object);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInScreen: ");
        stringBuilder2.append(object);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(this.m());
        stringBuilder.append("; className: ");
        stringBuilder.append(this.n());
        stringBuilder.append("; text: ");
        stringBuilder.append(this.o());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(this.p());
        stringBuilder.append("; viewId: ");
        stringBuilder.append(this.q());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(this.c());
        stringBuilder.append("; checked: ");
        stringBuilder.append(this.d());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(this.e());
        stringBuilder.append("; focused: ");
        stringBuilder.append(this.f());
        stringBuilder.append("; selected: ");
        stringBuilder.append(this.g());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(this.h());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(this.i());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(this.j());
        stringBuilder.append("; password: ");
        stringBuilder.append(this.k());
        object = new StringBuilder();
        ((StringBuilder)object).append("; scrollable: ");
        ((StringBuilder)object).append(this.l());
        stringBuilder.append(((StringBuilder)object).toString());
        stringBuilder.append("; [");
        int n2 = this.b();
        while (n2 != 0) {
            int n3 = 1 << Integer.numberOfTrailingZeros(n2);
            int n4 = n2 & n3;
            stringBuilder.append(b.b(n3));
            n2 = n4;
            if (n4 == 0) continue;
            stringBuilder.append(", ");
            n2 = n4;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class a {
        final Object a;

        a(Object object) {
            this.a = object;
        }

        public static a a(int n2, int n3, boolean bl2, int n4) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new a((Object)AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl2, (int)n4));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new a((Object)AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl2));
            }
            return new a(null);
        }
    }

    public static class b {
        final Object a;

        b(Object object) {
            this.a = object;
        }

        public static b a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b((Object)AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl2, (boolean)bl3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b((Object)AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl2));
            }
            return new b(null);
        }
    }

}

