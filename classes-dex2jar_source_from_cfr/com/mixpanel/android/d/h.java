/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import android.view.View;
import android.view.ViewGroup;
import com.mixpanel.android.c.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class h {
    private final b a = new b();

    private View a(c c2, View view, int n2) {
        int n3 = this.a.a(n2);
        if (this.a(c2, view)) {
            this.a.b(n2);
            if (c2.c == -1 || c2.c == n3) {
                return view;
            }
        }
        if (c2.a == 1 && view instanceof ViewGroup) {
            view = (ViewGroup)view;
            int n4 = view.getChildCount();
            for (n3 = 0; n3 < n4; ++n3) {
                View view2 = this.a(c2, view.getChildAt(n3), n2);
                if (view2 == null) continue;
                return view2;
            }
        }
        return null;
    }

    private boolean a(c c2, View view) {
        if (c2.b != null && !h.a((Object)view, c2.b)) {
            return false;
        }
        if (-1 != c2.d && view.getId() != c2.d) {
            return false;
        }
        if (c2.e != null && !c2.e.equals(view.getContentDescription())) {
            return false;
        }
        String string2 = c2.f;
        return c2.f == null || view.getTag() != null && string2.equals(view.getTag().toString());
    }

    private static boolean a(Object class_, String string2) {
        class_ = class_.getClass();
        while (!class_.getCanonicalName().equals(string2)) {
            if (class_ == Object.class) {
                return false;
            }
            class_ = class_.getSuperclass();
        }
        return true;
    }

    private void b(View view, List<c> list, a a2) {
        if (list.isEmpty()) {
            a2.a(view);
            return;
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        if (this.a.a()) {
            f.a("MixpanelAPI.PathFinder", "Path is too deep, will not match");
            return;
        }
        view = (ViewGroup)view;
        c c2 = list.get(0);
        list = list.subList(1, list.size());
        int n2 = view.getChildCount();
        int n3 = this.a.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view2 = this.a(c2, view.getChildAt(i2), n3);
            if (view2 != null) {
                this.b(view2, list, a2);
            }
            if (c2.c >= 0 && this.a.a(n3) > c2.c) break;
        }
        this.a.c();
    }

    public void a(View view, List<c> list, a a2) {
        if (list.isEmpty()) {
            return;
        }
        if (this.a.a()) {
            f.d("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
            return;
        }
        c c2 = list.get(0);
        list = list.subList(1, list.size());
        view = this.a(c2, view, this.a.b());
        this.a.c();
        if (view != null) {
            this.b(view, list, a2);
        }
    }

    public static interface a {
        public void a(View var1);
    }

    private static class b {
        private final int[] a = new int[256];
        private int b = 0;

        public int a(int n2) {
            return this.a[n2];
        }

        public boolean a() {
            return this.a.length == this.b;
        }

        public int b() {
            int n2 = this.b++;
            this.a[n2] = 0;
            return n2;
        }

        public void b(int n2) {
            int[] arrn = this.a;
            arrn[n2] = arrn[n2] + 1;
        }

        public void c() {
            --this.b;
            if (this.b >= 0) {
                return;
            }
            throw new ArrayIndexOutOfBoundsException(this.b);
        }
    }

    public static class c {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;
        public final String f;

        public c(int n2, String string2, int n3, int n4, String string3, String string4) {
            this.a = n2;
            this.b = string2;
            this.c = n3;
            this.d = n4;
            this.e = string3;
            this.f = string4;
        }

        public String toString() {
            try {
                Object object = new JSONObject();
                if (this.a == 1) {
                    object.put("prefix", (Object)"shortest");
                }
                if (this.b != null) {
                    object.put("view_class", (Object)this.b);
                }
                if (this.c > -1) {
                    object.put("index", this.c);
                }
                if (this.d > -1) {
                    object.put("id", this.d);
                }
                if (this.e != null) {
                    object.put("contentDescription", (Object)this.e);
                }
                if (this.f != null) {
                    object.put("tag", (Object)this.f);
                }
                object = object.toString();
                return object;
            }
            catch (JSONException jSONException) {
                throw new RuntimeException("Can't serialize PathElement to String", (Throwable)jSONException);
            }
        }
    }

}

