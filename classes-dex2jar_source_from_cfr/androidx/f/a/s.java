/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.f.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.v;
import androidx.f.a.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class s {
    static String a(Map<String, String> object, String string2) {
        for (Map.Entry entry : object.entrySet()) {
            if (!string2.equals(entry.getValue())) continue;
            return (String)entry.getKey();
        }
        return null;
    }

    protected static void a(List<View> list, View view) {
        int n2 = list.size();
        if (s.a(list, view, n2)) {
            return;
        }
        list.add(view);
        for (int i2 = n2; i2 < list.size(); ++i2) {
            view = list.get(i2);
            if (!(view instanceof ViewGroup)) continue;
            view = (ViewGroup)view;
            int n3 = view.getChildCount();
            for (int i3 = 0; i3 < n3; ++i3) {
                View view2 = view.getChildAt(i3);
                if (s.a(list, view2, n2)) continue;
                list.add(view2);
            }
        }
    }

    protected static boolean a(List list) {
        return list == null || list.isEmpty();
        {
        }
    }

    private static boolean a(List<View> list, View view, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            if (list.get(i2) != view) continue;
            return true;
        }
        return false;
    }

    public abstract Object a(Object var1, Object var2, Object var3);

    ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = arrayList.get(i2);
            arrayList2.add(androidx.core.h.t.o(view));
            androidx.core.h.t.a(view, null);
        }
        return arrayList2;
    }

    protected void a(View view, Rect rect) {
        int[] arrn = new int[2];
        view.getLocationOnScreen(arrn);
        rect.set(arrn[0], arrn[1], arrn[0] + view.getWidth(), arrn[1] + view.getHeight());
    }

    void a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int n2 = arrayList2.size();
        final ArrayList<String> arrayList4 = new ArrayList<String>();
        block0 : for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrayList.get(i2);
            String string2 = androidx.core.h.t.o((View)object);
            arrayList4.add(string2);
            if (string2 == null) continue;
            androidx.core.h.t.a((View)object, null);
            object = map.get(string2);
            for (int i3 = 0; i3 < n2; ++i3) {
                if (!((String)object).equals(arrayList3.get(i3))) continue;
                androidx.core.h.t.a(arrayList2.get(i3), string2);
                continue block0;
            }
        }
        t.a(view, new Runnable(){

            @Override
            public void run() {
                for (int i2 = 0; i2 < n2; ++i2) {
                    androidx.core.h.t.a((View)arrayList2.get(i2), (String)arrayList3.get(i2));
                    androidx.core.h.t.a((View)arrayList.get(i2), (String)arrayList4.get(i2));
                }
            }
        });
    }

    void a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        t.a(view, new Runnable(){

            @Override
            public void run() {
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    View view = (View)arrayList.get(i2);
                    String string2 = androidx.core.h.t.o(view);
                    if (string2 == null) continue;
                    androidx.core.h.t.a(view, s.a(map, string2));
                }
            }
        });
    }

    public abstract void a(ViewGroup var1, Object var2);

    void a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        t.a((View)viewGroup, new Runnable(){

            @Override
            public void run() {
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    View view = (View)arrayList.get(i2);
                    String string2 = androidx.core.h.t.o(view);
                    androidx.core.h.t.a(view, (String)map.get(string2));
                }
            }
        });
    }

    public abstract void a(Object var1, Rect var2);

    public abstract void a(Object var1, View var2);

    public abstract void a(Object var1, View var2, ArrayList<View> var3);

    public abstract void a(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7);

    public abstract void a(Object var1, ArrayList<View> var2);

    public abstract void a(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            View view2 = view;
            if (view instanceof ViewGroup && !v.a((ViewGroup)(view2 = (ViewGroup)view))) {
                int n2 = view2.getChildCount();
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.a(arrayList, view2.getChildAt(i2));
                }
            } else {
                arrayList.add(view2);
            }
        }
    }

    void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String string2 = androidx.core.h.t.o(view);
            if (string2 != null) {
                map.put(string2, view);
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                int n2 = view.getChildCount();
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.a(map, view.getChildAt(i2));
                }
            }
        }
    }

    public abstract boolean a(Object var1);

    public abstract Object b(Object var1);

    public abstract Object b(Object var1, Object var2, Object var3);

    public abstract void b(Object var1, View var2);

    public abstract void b(Object var1, View var2, ArrayList<View> var3);

    public abstract void b(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    public abstract Object c(Object var1);

    public abstract void c(Object var1, View var2);

}

