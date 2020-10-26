/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 */
package com.mixpanel.android.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.d.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

@TargetApi(value=16)
abstract class o
implements h.a {
    private final List<h.c> a;
    private final com.mixpanel.android.d.h b;

    protected o(List<h.c> list) {
        this.a = list;
        this.b = new com.mixpanel.android.d.h();
    }

    public abstract void a();

    protected List<h.c> b() {
        return this.a;
    }

    public void b(View view) {
        this.b.a(view, this.a, this);
    }

    protected com.mixpanel.android.d.h c() {
        return this.b;
    }

    public static class com.mixpanel.android.d.o$a
    extends d {
        private final int a;
        private final WeakHashMap<View, a> b;

        public com.mixpanel.android.d.o$a(List<h.c> list, int n2, String string2, h h2) {
            super(list, string2, h2, false);
            this.a = n2;
            this.b = new WeakHashMap();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private View.AccessibilityDelegate d(View view) {
            try {
                return (View.AccessibilityDelegate)view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke((Object)view, new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                com.mixpanel.android.c.f.d("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", invocationTargetException);
                do {
                    return null;
                    break;
                } while (true);
            }
            catch (IllegalAccessException | NoSuchMethodException reflectiveOperationException) {
                return null;
            }
        }

        @Override
        public void a() {
            for (Map.Entry<View, a> entry : this.b.entrySet()) {
                View view = entry.getKey();
                a object = entry.getValue();
                View.AccessibilityDelegate accessibilityDelegate = this.d(view);
                if (accessibilityDelegate == object) {
                    view.setAccessibilityDelegate(object.a());
                    continue;
                }
                if (!(accessibilityDelegate instanceof a)) continue;
                ((a)accessibilityDelegate).a(object);
            }
            this.b.clear();
        }

        @Override
        public void a(View view) {
            View.AccessibilityDelegate accessibilityDelegate = this.d(view);
            if (accessibilityDelegate instanceof a && ((a)accessibilityDelegate).a(this.d())) {
                return;
            }
            accessibilityDelegate = new a(accessibilityDelegate);
            view.setAccessibilityDelegate(accessibilityDelegate);
            this.b.put(view, (a)accessibilityDelegate);
        }

        private class a
        extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;

            public a(View.AccessibilityDelegate accessibilityDelegate) {
                this.b = accessibilityDelegate;
            }

            public View.AccessibilityDelegate a() {
                return this.b;
            }

            public void a(a a2) {
                if (this.b == a2) {
                    this.b = a2.a();
                    return;
                }
                if (this.b instanceof a) {
                    ((a)this.b).a(a2);
                }
            }

            public boolean a(String string2) {
                if (a.this.d() == string2) {
                    return true;
                }
                if (this.b instanceof a) {
                    return ((a)this.b).a(string2);
                }
                return false;
            }

            public void sendAccessibilityEvent(View view, int n2) {
                if (n2 == a.this.a) {
                    a.this.c(view);
                }
                if (this.b != null) {
                    this.b.sendAccessibilityEvent(view, n2);
                }
            }
        }

    }

    public static class b
    extends d {
        private final Map<TextView, TextWatcher> a = new HashMap<TextView, TextWatcher>();

        public b(List<h.c> list, String string2, h h2) {
            super(list, string2, h2, true);
        }

        @Override
        public void a() {
            for (Map.Entry<TextView, TextWatcher> entry : this.a.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.a.clear();
        }

        @Override
        public void a(View view) {
            if (view instanceof TextView) {
                view = (TextView)view;
                a a2 = new a(view);
                TextWatcher textWatcher = this.a.get((Object)view);
                if (textWatcher != null) {
                    view.removeTextChangedListener(textWatcher);
                }
                view.addTextChangedListener((TextWatcher)a2);
                this.a.put((TextView)view, a2);
            }
        }

        private class a
        implements TextWatcher {
            private final View b;

            public a(View view) {
                this.b = view;
            }

            public void afterTextChanged(Editable editable) {
                b.this.c(this.b);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        }

    }

    private static class c {
        private c() {
        }

        private boolean a(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains((Object)view)) {
                return false;
            }
            if (treeMap.containsKey((Object)view)) {
                List<View> list2 = treeMap.remove((Object)view);
                list.add(view);
                int n2 = list2.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (this.a(treeMap, list2.get(i2), list)) continue;
                    return false;
                }
                list.remove((Object)view);
            }
            return true;
        }

        public boolean a(TreeMap<View, List<View>> treeMap) {
            ArrayList<View> arrayList = new ArrayList<View>();
            while (!treeMap.isEmpty()) {
                if (this.a(treeMap, treeMap.firstKey(), arrayList)) continue;
                return false;
            }
            return true;
        }
    }

    private static abstract class d
    extends o {
        private final h a;
        private final String b;
        private final boolean c;

        public d(List<h.c> list, String string2, h h2, boolean bl2) {
            super(list);
            this.a = h2;
            this.b = string2;
            this.c = bl2;
        }

        protected void c(View view) {
            this.a.a(view, this.b, this.c);
        }

        protected String d() {
            return this.b;
        }
    }

    public static class e {
        private final String a;
        private final String b;

        public e(String string2, String string3) {
            this.a = string2;
            this.b = string3;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    public static class f {
        public final int a;
        public final int b;
        public final int c;

        public f(int n2, int n3, int n4) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
        }
    }

    public static class g
    extends o {
        private static final Set<Integer> d = new HashSet<Integer>(Arrays.asList(0, 1, 5, 7));
        private static final Set<Integer> e = new HashSet<Integer>(Arrays.asList(2, 3, 4, 6, 8));
        private final WeakHashMap<View, int[]> a = new WeakHashMap();
        private final List<f> b;
        private final String c;
        private boolean f;
        private final i g;
        private final c h;

        public g(List<h.c> list, List<f> list2, String string2, i i2) {
            super(list);
            this.b = list2;
            this.c = string2;
            this.f = true;
            this.g = i2;
            this.h = new c();
        }

        private boolean a(Set<Integer> set, SparseArray<View> sparseArray) {
            TreeMap<View, List<View>> treeMap = new TreeMap<View, List<View>>(new Comparator<View>(){

                public int a(View view, View view2) {
                    if (view == view2) {
                        return 0;
                    }
                    if (view == null) {
                        return -1;
                    }
                    if (view2 == null) {
                        return 1;
                    }
                    return view2.hashCode() - view.hashCode();
                }

                @Override
                public /* synthetic */ int compare(Object object, Object object2) {
                    return this.a((View)object, (View)object2);
                }
            });
            int n2 = sparseArray.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = (View)sparseArray.valueAt(i2);
                int[] arrn = ((RelativeLayout.LayoutParams)view.getLayoutParams()).getRules();
                ArrayList<Object> arrayList = new ArrayList<Object>();
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int n3 = arrn[iterator.next()];
                    if (n3 <= 0 || n3 == view.getId()) continue;
                    arrayList.add(sparseArray.get(n3));
                }
                treeMap.put(view, arrayList);
            }
            return this.h.a(treeMap);
        }

        @Override
        public void a() {
            Iterator<Map.Entry<View, int[]>> iterator = this.a.entrySet().iterator();
            do {
                boolean bl2 = iterator.hasNext();
                if (!bl2) break;
                int[] arrn = iterator.next();
                View view = arrn.getKey();
                arrn = arrn.getValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)view.getLayoutParams();
                for (int i2 = 0; i2 < arrn.length; ++i2) {
                    layoutParams.addRule(i2, arrn[i2]);
                }
                view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } while (true);
            this.f = false;
        }

        @Override
        public void a(View object) {
            View view;
            int n2;
            object = (ViewGroup)object;
            SparseArray sparseArray = new SparseArray();
            int n3 = object.getChildCount();
            int n4 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                view = object.getChildAt(n2);
                int n5 = view.getId();
                if (n5 <= 0) continue;
                sparseArray.put(n5, (Object)view);
            }
            n3 = this.b.size();
            for (n2 = n4; n2 < n3; ++n2) {
                RelativeLayout.LayoutParams layoutParams;
                int[] arrn;
                object = this.b.get(n2);
                view = (View)sparseArray.get(object.a);
                if (view == null || (arrn = (int[])(layoutParams = (RelativeLayout.LayoutParams)view.getLayoutParams()).getRules().clone())[object.b] == object.c) continue;
                if (!this.a.containsKey((Object)view)) {
                    this.a.put(view, arrn);
                }
                layoutParams.addRule(object.b, object.c);
                object = d.contains(object.b) ? d : (e.contains(object.b) ? e : null);
                if (object != null && !this.a((Set<Integer>)object, (SparseArray<View>)sparseArray)) {
                    this.a();
                    this.g.a(new e("circular_dependency", this.c));
                    return;
                }
                view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
        }

        @Override
        public void b(View view) {
            if (this.f) {
                this.c().a(view, this.b(), this);
            }
        }

    }

    public static interface h {
        public void a(View var1, String var2, boolean var3);
    }

    public static interface i {
        public void a(e var1);
    }

    public static class j
    extends o {
        private final com.mixpanel.android.d.a a;
        private final com.mixpanel.android.d.a b;
        private final WeakHashMap<View, Object> c;
        private final Object[] d;

        public j(List<h.c> list, com.mixpanel.android.d.a a2, com.mixpanel.android.d.a a3) {
            super(list);
            this.a = a2;
            this.b = a3;
            this.d = new Object[1];
            this.c = new WeakHashMap();
        }

        @Override
        public void a() {
            for (Map.Entry<View, Object> entry : this.c.entrySet()) {
                View view = entry.getKey();
                Object object = entry.getValue();
                if (object == null) continue;
                this.d[0] = object;
                this.a.a(view, this.d);
            }
        }

        @Override
        public void a(View view) {
            Object object;
            if (this.b != null && 1 == ((Object[])(object = this.a.a())).length) {
                Object object2 = object[0];
                object = this.b.a(view);
                if (object2 == object) {
                    return;
                }
                if (object2 != null) {
                    if (object2 instanceof Bitmap && object instanceof Bitmap) {
                        if (((Bitmap)object2).sameAs((Bitmap)object)) {
                            return;
                        }
                    } else if (object2 instanceof BitmapDrawable && object instanceof BitmapDrawable) {
                        object2 = ((BitmapDrawable)object2).getBitmap();
                        Bitmap bitmap = ((BitmapDrawable)object).getBitmap();
                        if (object2 != null && object2.sameAs(bitmap)) {
                            return;
                        }
                    } else if (object2.equals(object)) {
                        return;
                    }
                }
                if (!(object instanceof Bitmap || object instanceof BitmapDrawable || this.c.containsKey((Object)view))) {
                    this.d[0] = object;
                    if (this.a.a(this.d)) {
                        this.c.put(view, object);
                    } else {
                        this.c.put(view, null);
                    }
                }
            }
            this.a.a(view);
        }
    }

    public static class k
    extends d {
        private boolean a = false;

        public k(List<h.c> list, String string2, h h2) {
            super(list, string2, h2, false);
        }

        @Override
        public void a() {
        }

        @Override
        public void a(View view) {
            if (view != null && !this.a) {
                this.c(view);
            }
            boolean bl2 = view != null;
            this.a = bl2;
        }
    }

}

