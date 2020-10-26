/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.f.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.c.g;
import androidx.f.a.a;
import androidx.f.a.d;
import androidx.f.a.f;
import androidx.f.a.h;
import androidx.f.a.j;
import androidx.f.a.r;
import androidx.f.a.s;
import androidx.f.a.t;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

class q {
    private static final int[] a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final s b;
    private static final s c;

    static {
        r r2 = Build.VERSION.SDK_INT >= 21 ? new r() : null;
        b = r2;
        c = q.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    static View a(androidx.c.a<String, View> a2, a arrayList, Object object, boolean bl2) {
        arrayList = ((a)arrayList).c;
        if (object == null) return null;
        if (a2 == null) return null;
        if (((androidx.f.a.a)arrayList).r == null) return null;
        if (((androidx.f.a.a)arrayList).r.isEmpty()) return null;
        arrayList = bl2 ? ((androidx.f.a.a)arrayList).r : ((androidx.f.a.a)arrayList).s;
        arrayList = arrayList.get(0);
        return (View)a2.get(arrayList);
    }

    private static androidx.c.a<String, String> a(int n2, ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, int n3, int n4) {
        androidx.c.a<String, String> a2 = new androidx.c.a<String, String>();
        --n4;
        while (n4 >= n3) {
            Object object = arrayList.get(n4);
            if (((androidx.f.a.a)object).b(n2)) {
                boolean bl2 = arrayList2.get(n4);
                if (((androidx.f.a.a)object).r != null) {
                    ArrayList<String> arrayList3;
                    ArrayList<String> arrayList4;
                    int n5 = ((androidx.f.a.a)object).r.size();
                    if (bl2) {
                        arrayList3 = ((androidx.f.a.a)object).r;
                        arrayList4 = ((androidx.f.a.a)object).s;
                    } else {
                        arrayList4 = ((androidx.f.a.a)object).r;
                        arrayList3 = ((androidx.f.a.a)object).s;
                    }
                    for (int i2 = 0; i2 < n5; ++i2) {
                        object = arrayList4.get(i2);
                        String string2 = arrayList3.get(i2);
                        String string3 = (String)a2.remove(string2);
                        if (string3 != null) {
                            a2.put((String)object, string3);
                            continue;
                        }
                        a2.put((String)object, string2);
                    }
                }
            }
            --n4;
        }
        return a2;
    }

    static androidx.c.a<String, View> a(s arrayList, androidx.c.a<String, String> a2, Object object, a object2) {
        d d2 = ((a)object2).a;
        View view = d2.y();
        if (!a2.isEmpty() && object != null && view != null) {
            androidx.c.a<String, View> a3 = new androidx.c.a<String, View>();
            ((s)((Object)arrayList)).a(a3, view);
            arrayList = ((a)object2).c;
            if (((a)object2).b) {
                object = d2.ac();
                arrayList = ((androidx.f.a.a)arrayList).r;
            } else {
                object = d2.ab();
                arrayList = ((androidx.f.a.a)arrayList).s;
            }
            if (arrayList != null) {
                a3.a(arrayList);
                a3.a(a2.values());
            }
            if (object != null) {
                ((androidx.core.app.f)object).a(arrayList, a3);
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    object2 = arrayList.get(i2);
                    object = (View)a3.get(object2);
                    if (object == null) {
                        object = q.a(a2, (String)object2);
                        if (object == null) continue;
                        a2.remove(object);
                        continue;
                    }
                    if (((String)object2).equals(androidx.core.h.t.o((View)object)) || (object2 = q.a(a2, (String)object2)) == null) continue;
                    a2.put((String)object2, androidx.core.h.t.o((View)object));
                }
            } else {
                q.a(a2, a3);
            }
            return a3;
        }
        a2.clear();
        return null;
    }

    private static a a(a a2, SparseArray<a> sparseArray, int n2) {
        a a3 = a2;
        if (a2 == null) {
            a3 = new a();
            sparseArray.put(n2, (Object)a3);
        }
        return a3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static s a() {
        try {
            return (s)Class.forName("androidx.j.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static s a(d object, d d2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null) {
            Object object2 = ((d)object).G();
            if (object2 != null) {
                arrayList.add(object2);
            }
            if ((object2 = ((d)object).F()) != null) {
                arrayList.add(object2);
            }
            if ((object = ((d)object).J()) != null) {
                arrayList.add(object);
            }
        }
        if (d2 != null) {
            object = d2.E();
            if (object != null) {
                arrayList.add(object);
            }
            if ((object = d2.H()) != null) {
                arrayList.add(object);
            }
            if ((object = d2.I()) != null) {
                arrayList.add(object);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && q.a(b, arrayList)) {
            return b;
        }
        if (c != null && q.a(c, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static Object a(s s2, ViewGroup viewGroup, View view, androidx.c.a<String, String> object, a a2, ArrayList<View> view2, ArrayList<View> arrayList, Object object2, Object object3) {
        final d d2 = a2.a;
        final d d3 = a2.d;
        if (d2 != null) {
            d2.y().setVisibility(0);
        }
        if (d2 != null) {
            if (d3 == null) {
                return null;
            }
            final boolean bl2 = a2.b;
            Object object4 = ((g)object).isEmpty() ? null : q.a(s2, d2, d3, bl2);
            androidx.c.a<String, View> a3 = q.b(s2, object, object4, a2);
            final androidx.c.a<String, View> a4 = q.a(s2, object, object4, a2);
            if (((g)object).isEmpty()) {
                if (a3 != null) {
                    a3.clear();
                }
                if (a4 != null) {
                    a4.clear();
                }
                object = null;
            } else {
                q.a(view2, a3, ((androidx.c.a)object).keySet());
                q.a(arrayList, a4, ((androidx.c.a)object).values());
                object = object4;
            }
            if (object2 == null && object3 == null && object == null) {
                return null;
            }
            q.a(d2, d3, bl2, a3, true);
            if (object != null) {
                arrayList.add(view);
                s2.a(object, view, (ArrayList<View>)view2);
                q.a(s2, object, object3, a3, a2.e, a2.f);
                view = new Rect();
                a2 = q.a(a4, a2, object2, bl2);
                if (a2 != null) {
                    s2.a(object2, (Rect)view);
                }
                view2 = view;
            } else {
                view2 = view = null;
                a2 = view;
            }
            t.a((View)viewGroup, new Runnable((View)a2, s2, (Rect)view2){
                final /* synthetic */ View e;
                final /* synthetic */ s f;
                final /* synthetic */ Rect g;
                {
                    this.e = view;
                    this.f = s2;
                    this.g = rect;
                }

                @Override
                public void run() {
                    q.a(d2, d3, bl2, a4, false);
                    if (this.e != null) {
                        this.f.a(this.e, this.g);
                    }
                }
            });
            return object;
        }
        return null;
    }

    private static Object a(s s2, d object, d d2, boolean bl2) {
        if (object != null && d2 != null) {
            object = bl2 ? d2.J() : ((d)object).I();
            return s2.c(s2.b(object));
        }
        return null;
    }

    private static Object a(s s2, d object, boolean bl2) {
        if (object == null) {
            return null;
        }
        object = bl2 ? ((d)object).H() : ((d)object).E();
        return s2.b(object);
    }

    private static Object a(s s2, Object object, Object object2, Object object3, d d2, boolean bl2) {
        bl2 = object != null && object2 != null && d2 != null ? (bl2 ? d2.L() : d2.K()) : true;
        if (bl2) {
            return s2.a(object2, object, object3);
        }
        return s2.b(object2, object, object3);
    }

    private static String a(androidx.c.a<String, String> a2, String string2) {
        int n2 = a2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals(a2.c(i2))) continue;
            return (String)a2.b(i2);
        }
        return null;
    }

    static ArrayList<View> a(s s2, Object object, d object2, ArrayList<View> arrayList, View view) {
        if (object != null) {
            ArrayList<View> arrayList2 = new ArrayList<View>();
            if ((object2 = ((d)object2).y()) != null) {
                s2.a(arrayList2, (View)object2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            object2 = arrayList2;
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                s2.a(object, arrayList2);
                return arrayList2;
            }
        } else {
            object2 = null;
        }
        return object2;
    }

    private static void a(androidx.c.a<String, String> a2, androidx.c.a<String, View> a3) {
        for (int i2 = a2.size() - 1; i2 >= 0; --i2) {
            if (a3.containsKey((String)a2.c(i2))) continue;
            a2.d(i2);
        }
    }

    public static void a(androidx.f.a.a a2, SparseArray<a> sparseArray, boolean bl2) {
        int n2 = a2.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            q.a(a2, a2.b.get(i2), sparseArray, false, bl2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void a(androidx.f.a.a var0, a.a var1_1, SparseArray<a> var2_2, boolean var3_3, boolean var4_4) {
        block25 : {
            block26 : {
                block24 : {
                    block22 : {
                        block23 : {
                            block21 : {
                                var12_5 = var1_1.b;
                                if (var12_5 == null) {
                                    return;
                                }
                                var8_6 = var12_5.I;
                                if (var8_6 == 0) {
                                    return;
                                }
                                var5_7 = var3_3 != false ? q.a[var1_1.a] : var1_1.a;
                                var10_8 = false;
                                var9_9 = false;
                                if (var5_7 == 1) break block21;
                                switch (var5_7) {
                                    default: {
                                        var5_7 = 0;
                                        break block22;
                                    }
                                    case 5: {
                                        if (!var4_4) ** GOTO lbl19
                                        if (!var12_5.Y || var12_5.K || !var12_5.u) ** GOTO lbl-1000
                                        ** GOTO lbl-1000
lbl19: // 1 sources:
                                        var9_9 = var12_5.K;
                                        break block23;
                                    }
                                    case 4: {
                                        if (!(var4_4 != false ? var12_5.Y != false && var12_5.u != false && var12_5.K != false : var12_5.u != false && var12_5.K == false)) ** GOTO lbl-1000
                                        ** GOTO lbl-1000
                                    }
                                    case 3: 
                                    case 6: {
                                        if (var4_4 != false ? var12_5.u == false && var12_5.S != null && var12_5.S.getVisibility() == 0 && var12_5.Z >= 0.0f : var12_5.u != false && var12_5.K == false) lbl-1000: // 2 sources:
                                        {
                                            var5_7 = 1;
                                        } else lbl-1000: // 2 sources:
                                        {
                                            var5_7 = 0;
                                        }
                                        var6_11 = var5_7;
                                        var5_7 = 0;
                                        var7_10 = true;
                                        var9_9 = var10_8;
                                        break block24;
                                    }
                                    case 7: 
                                }
                            }
                            if (var4_4) {
                                var9_9 = var12_5.X;
                            } else if (!var12_5.u && !var12_5.K) lbl-1000: // 2 sources:
                            {
                                var9_9 = true;
                            } else lbl-1000: // 2 sources:
                            {
                                var9_9 = false;
                            }
                        }
                        var5_7 = 1;
                    }
                    var7_10 = false;
                    var6_11 = 0;
                }
                var1_1 = var11_12 = (a)var2_2.get(var8_6);
                if (var9_9) {
                    var1_1 = q.a((a)var11_12, var2_2, var8_6);
                    var1_1.a = var12_5;
                    var1_1.b = var3_3;
                    var1_1.c = var0;
                }
                if (!var4_4 && var5_7 != 0) {
                    if (var1_1 != null && var1_1.d == var12_5) {
                        var1_1.d = null;
                    }
                    var11_12 = var0.a;
                    if (var12_5.k < 1 && var11_12.l >= 1 && !var0.t) {
                        var11_12.g(var12_5);
                        var11_12.a(var12_5, 1, 0, 0, false);
                    }
                }
                var11_12 = var1_1;
                if (var6_11 == 0) break block25;
                if (var1_1 == null) break block26;
                var11_12 = var1_1;
                if (var1_1.d != null) break block25;
            }
            var11_12 = q.a((a)var1_1, var2_2, var8_6);
            var11_12.d = var12_5;
            var11_12.e = var3_3;
            var11_12.f = var0;
        }
        if (var4_4 != false) return;
        if (var7_10 == false) return;
        if (var11_12 == null) return;
        if (var11_12.a != var12_5) return;
        var11_12.a = null;
    }

    static void a(d object, d object2, boolean bl2, androidx.c.a<String, View> a2, boolean bl3) {
        object = bl2 ? ((d)object2).ab() : ((d)object).ab();
        if (object != null) {
            object2 = new ArrayList();
            ArrayList<String> arrayList = new ArrayList<String>();
            int n2 = a2 == null ? 0 : a2.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList.add((String)a2.b(i2));
                ((ArrayList)object2).add(a2.c(i2));
            }
            if (bl3) {
                ((androidx.core.app.f)object).a(arrayList, (List<View>)object2, null);
                return;
            }
            ((androidx.core.app.f)object).b(arrayList, (List<View>)object2, null);
        }
    }

    private static void a(j j2, int n2, a object, View object2, androidx.c.a<String, String> a2) {
        j2 = j2.n.a() ? (ViewGroup)j2.n.a(n2) : null;
        if (j2 == null) {
            return;
        }
        Object object3 = ((a)object).d;
        Object object4 = ((a)object).a;
        s s2 = q.a((d)object3, (d)object4);
        if (s2 == null) {
            return;
        }
        boolean bl2 = ((a)object).b;
        boolean bl3 = ((a)object).e;
        ArrayList<View> arrayList = new ArrayList<View>();
        ArrayList<View> arrayList2 = new ArrayList<View>();
        Object object5 = q.a(s2, (d)object4, bl2);
        ArrayList<View> arrayList3 = q.b(s2, (d)object3, bl3);
        Object object6 = q.a(s2, (ViewGroup)j2, object2, a2, (a)object, arrayList2, arrayList, object5, (Object)arrayList3);
        if (object5 == null && object6 == null && arrayList3 == null) {
            return;
        }
        object = arrayList3;
        arrayList3 = q.a(s2, object, (d)object3, arrayList2, object2);
        object2 = q.a(s2, object5, (d)object4, arrayList, object2);
        q.a((ArrayList<View>)object2, 4);
        object4 = q.a(s2, object5, object, object6, (d)object4, bl2);
        if (object4 != null) {
            q.a(s2, object, (d)object3, arrayList3);
            object3 = s2.a(arrayList);
            s2.a(object4, object5, (ArrayList<View>)object2, object, arrayList3, object6, arrayList);
            s2.a((ViewGroup)j2, object4);
            s2.a((View)j2, arrayList2, arrayList, (ArrayList<String>)object3, a2);
            q.a((ArrayList<View>)object2, 0);
            s2.a(object6, arrayList2, arrayList);
        }
    }

    static void a(j j2, ArrayList<androidx.f.a.a> arrayList, ArrayList<Boolean> arrayList2, int n2, int n3, boolean bl2) {
        androidx.f.a.a a2;
        int n4;
        if (j2.l < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (n4 = n2; n4 < n3; ++n4) {
            a2 = arrayList.get(n4);
            if (arrayList2.get(n4).booleanValue()) {
                q.b(a2, (SparseArray<a>)sparseArray, bl2);
                continue;
            }
            q.a(a2, (SparseArray<a>)sparseArray, bl2);
        }
        if (sparseArray.size() != 0) {
            a2 = new View(j2.m.g());
            int n5 = sparseArray.size();
            for (n4 = 0; n4 < n5; ++n4) {
                int n6 = sparseArray.keyAt(n4);
                androidx.c.a<String, String> a3 = q.a(n6, arrayList, arrayList2, n2, n3);
                a a4 = (a)sparseArray.valueAt(n4);
                if (bl2) {
                    q.a(j2, n6, a4, (View)a2, a3);
                    continue;
                }
                q.b(j2, n6, a4, (View)a2, a3);
            }
        }
    }

    private static void a(final s s2, ViewGroup viewGroup, final d d2, final View view, final ArrayList<View> arrayList, final Object object, final ArrayList<View> arrayList2, final Object object2, final ArrayList<View> arrayList3) {
        t.a((View)viewGroup, new Runnable(){

            @Override
            public void run() {
                ArrayList<View> arrayList4;
                if (object != null) {
                    s2.c(object, view);
                    arrayList4 = q.a(s2, object, d2, arrayList, view);
                    arrayList2.addAll(arrayList4);
                }
                if (arrayList3 != null) {
                    if (object2 != null) {
                        arrayList4 = new ArrayList<View>();
                        arrayList4.add(view);
                        s2.b(object2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void a(s s2, Object object, d d2, final ArrayList<View> arrayList) {
        if (d2 != null && object != null && d2.u && d2.K && d2.Y) {
            d2.i(true);
            s2.b(object, d2.y(), arrayList);
            t.a((View)d2.R, new Runnable(){

                @Override
                public void run() {
                    q.a(arrayList, 4);
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(s s2, Object object, Object object2, androidx.c.a<String, View> view, boolean bl2, androidx.f.a.a arrayList) {
        if (((androidx.f.a.a)arrayList).r != null && !((androidx.f.a.a)arrayList).r.isEmpty()) {
            arrayList = bl2 ? ((androidx.f.a.a)arrayList).s : ((androidx.f.a.a)arrayList).r;
            arrayList = arrayList.get(0);
            view = (View)view.get(arrayList);
            s2.a(object, view);
            if (object2 != null) {
                s2.a(object2, view);
            }
        }
    }

    static void a(ArrayList<View> arrayList, int n2) {
        if (arrayList == null) {
            return;
        }
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            arrayList.get(i2).setVisibility(n2);
        }
    }

    private static void a(ArrayList<View> arrayList, androidx.c.a<String, View> a2, Collection<String> collection) {
        for (int i2 = a2.size() - 1; i2 >= 0; --i2) {
            View view = (View)a2.c(i2);
            if (!collection.contains(androidx.core.h.t.o(view))) continue;
            arrayList.add(view);
        }
    }

    private static boolean a(s s2, List<Object> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (s2.a(list.get(i2))) continue;
            return false;
        }
        return true;
    }

    private static androidx.c.a<String, View> b(s arrayList, androidx.c.a<String, String> a2, Object object, a object2) {
        if (!a2.isEmpty() && object != null) {
            object = ((a)object2).d;
            androidx.c.a<String, View> a3 = new androidx.c.a<String, View>();
            ((s)((Object)arrayList)).a(a3, ((d)object).y());
            arrayList = ((a)object2).f;
            if (((a)object2).e) {
                object = ((d)object).ab();
                arrayList = ((androidx.f.a.a)arrayList).s;
            } else {
                object = ((d)object).ac();
                arrayList = ((androidx.f.a.a)arrayList).r;
            }
            a3.a(arrayList);
            if (object != null) {
                ((androidx.core.app.f)object).a(arrayList, a3);
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    object2 = arrayList.get(i2);
                    object = (View)a3.get(object2);
                    if (object == null) {
                        a2.remove(object2);
                        continue;
                    }
                    if (((String)object2).equals(androidx.core.h.t.o((View)object))) continue;
                    object2 = (String)a2.remove(object2);
                    a2.put(androidx.core.h.t.o((View)object), (String)object2);
                }
            } else {
                a2.a(a3.keySet());
            }
            return a3;
        }
        a2.clear();
        return null;
    }

    private static Object b(final s s2, ViewGroup viewGroup, final View view, final androidx.c.a<String, String> a2, final a a3, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object object, Object object2) {
        final d d2 = a3.a;
        final d d3 = a3.d;
        if (d2 != null) {
            if (d3 == null) {
                return null;
            }
            final boolean bl2 = a3.b;
            final Object object3 = a2.isEmpty() ? null : q.a(s2, d2, d3, bl2);
            androidx.c.a<String, View> a4 = q.b(s2, a2, object3, a3);
            if (a2.isEmpty()) {
                object3 = null;
            } else {
                arrayList.addAll(a4.values());
            }
            if (object == null && object2 == null && object3 == null) {
                return null;
            }
            q.a(d2, d3, bl2, a4, true);
            if (object3 != null) {
                Rect rect = new Rect();
                s2.a(object3, view, arrayList);
                q.a(s2, object3, object2, a4, a3.e, a3.f);
                object2 = rect;
                if (object != null) {
                    s2.a(object, rect);
                    object2 = rect;
                }
            } else {
                object2 = null;
            }
            t.a((View)viewGroup, new Runnable((Rect)object2){
                final /* synthetic */ Rect l;
                {
                    this.l = rect;
                }

                @Override
                public void run() {
                    View view2 = q.a(s2, a2, object3, a3);
                    if (view2 != null) {
                        arrayList2.addAll(view2.values());
                        arrayList2.add(view);
                    }
                    q.a(d2, d3, bl2, view2, false);
                    if (object3 != null) {
                        s2.a(object3, (ArrayList<View>)arrayList, (ArrayList<View>)arrayList2);
                        view2 = q.a(view2, a3, object, bl2);
                        if (view2 != null) {
                            s2.a(view2, this.l);
                        }
                    }
                }
            });
            return object3;
        }
        return null;
    }

    private static Object b(s s2, d object, boolean bl2) {
        if (object == null) {
            return null;
        }
        object = bl2 ? ((d)object).F() : ((d)object).G();
        return s2.b(object);
    }

    public static void b(androidx.f.a.a a2, SparseArray<a> sparseArray, boolean bl2) {
        if (!a2.a.n.a()) {
            return;
        }
        for (int i2 = a2.b.size() - 1; i2 >= 0; --i2) {
            q.a(a2, a2.b.get(i2), sparseArray, true, bl2);
        }
    }

    private static void b(j j2, int n2, a object, View view, androidx.c.a<String, String> a2) {
        j2 = j2.n.a() ? (ViewGroup)j2.n.a(n2) : null;
        if (j2 == null) {
            return;
        }
        Object object2 = ((a)object).d;
        d d2 = ((a)object).a;
        s s2 = q.a((d)object2, d2);
        if (s2 == null) {
            return;
        }
        boolean bl2 = ((a)object).b;
        boolean bl3 = ((a)object).e;
        Object object3 = q.a(s2, d2, bl2);
        Object object4 = q.b(s2, (d)object2, bl3);
        ArrayList<Object> arrayList = new ArrayList<View>();
        ArrayList<View> arrayList2 = new ArrayList<View>();
        Object object5 = q.b(s2, (ViewGroup)j2, view, a2, (a)object, arrayList, arrayList2, object3, object4);
        if (object3 == null && object5 == null && object4 == null) {
            return;
        }
        if ((object2 = q.a(s2, object4, (d)object2, arrayList, view)) == null || ((ArrayList)object2).isEmpty()) {
            object4 = null;
        }
        s2.b(object3, view);
        object = q.a(s2, object3, object4, object5, d2, ((a)object).b);
        if (object != null) {
            arrayList = new ArrayList();
            s2.a(object, object3, arrayList, object4, (ArrayList<View>)object2, object5, arrayList2);
            q.a(s2, (ViewGroup)j2, d2, view, arrayList2, object3, arrayList, object4, (ArrayList<View>)object2);
            s2.a((View)j2, arrayList2, a2);
            s2.a((ViewGroup)j2, object);
            s2.a((ViewGroup)j2, arrayList2, a2);
        }
    }

    static class a {
        public d a;
        public boolean b;
        public androidx.f.a.a c;
        public d d;
        public boolean e;
        public androidx.f.a.a f;

        a() {
        }
    }

}

