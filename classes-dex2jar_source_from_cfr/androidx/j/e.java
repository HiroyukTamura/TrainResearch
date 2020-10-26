/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.j;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.f.a.s;
import androidx.j.m;
import androidx.j.o;
import androidx.j.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class e
extends s {
    private static boolean a(m m2) {
        return !e.a(m2.f()) || !e.a(m2.h()) || !e.a(m2.i());
        {
        }
    }

    @Override
    public Object a(Object object, Object object2, Object object3) {
        q q2 = new q();
        if (object != null) {
            q2.a((m)object);
        }
        if (object2 != null) {
            q2.a((m)object2);
        }
        if (object3 != null) {
            q2.a((m)object3);
        }
        return q2;
    }

    @Override
    public void a(ViewGroup viewGroup, Object object) {
        o.a(viewGroup, (m)object);
    }

    @Override
    public void a(Object object, final Rect rect) {
        if (object != null) {
            ((m)object).a(new m.b(){});
        }
    }

    @Override
    public void a(Object object, View view) {
        if (view != null) {
            object = (m)object;
            final Rect rect = new Rect();
            this.a(view, rect);
            ((m)object).a(new m.b(){});
        }
    }

    @Override
    public void a(Object object, View view, ArrayList<View> arrayList) {
        object = (q)object;
        List<View> list = ((m)object).g();
        list.clear();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e.a(list, arrayList.get(i2));
        }
        list.add(view);
        arrayList.add(view);
        this.a(object, arrayList);
    }

    @Override
    public void a(Object object, final Object object2, final ArrayList<View> arrayList, final Object object3, final ArrayList<View> arrayList2, final Object object4, final ArrayList<View> arrayList3) {
        ((m)object).a(new m.c(){

            @Override
            public void a(m m2) {
            }

            @Override
            public void b(m m2) {
            }

            @Override
            public void c(m m2) {
            }

            @Override
            public void d(m m2) {
                if (object2 != null) {
                    e.this.b(object2, arrayList, null);
                }
                if (object3 != null) {
                    e.this.b(object3, arrayList2, null);
                }
                if (object4 != null) {
                    e.this.b(object4, arrayList3, null);
                }
            }
        });
    }

    @Override
    public void a(Object object, ArrayList<View> arrayList) {
        block4 : {
            int n2;
            block3 : {
                if ((object = (m)object) == null) {
                    return;
                }
                boolean bl2 = object instanceof q;
                int n3 = 0;
                if (!bl2) break block3;
                object = (q)object;
                n3 = ((q)object).q();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.a((Object)((q)object).b(n2), arrayList);
                }
                break block4;
            }
            if (e.a((m)object) || !e.a(((m)object).g())) break block4;
            int n4 = arrayList.size();
            for (n2 = n3; n2 < n4; ++n2) {
                ((m)object).b(arrayList.get(n2));
            }
        }
    }

    @Override
    public void a(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if ((object = (q)object) != null) {
            ((m)object).g().clear();
            ((m)object).g().addAll(arrayList2);
            this.b(object, arrayList, arrayList2);
        }
    }

    @Override
    public boolean a(Object object) {
        return object instanceof m;
    }

    @Override
    public Object b(Object object) {
        if (object != null) {
            return ((m)object).o();
        }
        return null;
    }

    @Override
    public Object b(Object object, Object object2, Object object3) {
        object = (m)object;
        object2 = (m)object2;
        object3 = (m)object3;
        if (object != null && object2 != null) {
            object = new q().a((m)object).a((m)object2).a(1);
        } else if (object == null) {
            object = object2 != null ? object2 : null;
        }
        if (object3 != null) {
            object2 = new q();
            if (object != null) {
                ((q)object2).a((m)object);
            }
            ((q)object2).a((m)object3);
            return object2;
        }
        return object;
    }

    @Override
    public void b(Object object, View view) {
        if (object != null) {
            ((m)object).b(view);
        }
    }

    @Override
    public void b(Object object, final View view, final ArrayList<View> arrayList) {
        ((m)object).a(new m.c(){

            @Override
            public void a(m m2) {
                m2.b(this);
                view.setVisibility(8);
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((View)arrayList.get(i2)).setVisibility(0);
                }
            }

            @Override
            public void b(m m2) {
            }

            @Override
            public void c(m m2) {
            }

            @Override
            public void d(m m2) {
            }
        });
    }

    @Override
    public void b(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        block4 : {
            int n2;
            List<View> list;
            int n3;
            block3 : {
                object = (m)object;
                boolean bl2 = object instanceof q;
                if (!bl2) break block3;
                object = (q)object;
                n3 = ((q)object).q();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.b((Object)((q)object).b(n2), arrayList, arrayList2);
                }
                break block4;
            }
            if (e.a((m)object) || (list = ((m)object).g()).size() != arrayList.size() || !list.containsAll(arrayList)) break block4;
            n2 = arrayList2 == null ? 0 : arrayList2.size();
            for (n3 = 0; n3 < n2; ++n3) {
                ((m)object).b(arrayList2.get(n3));
            }
            for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                ((m)object).c(arrayList.get(n2));
            }
        }
    }

    @Override
    public Object c(Object object) {
        if (object == null) {
            return null;
        }
        q q2 = new q();
        q2.a((m)object);
        return q2;
    }

    @Override
    public void c(Object object, View view) {
        if (object != null) {
            ((m)object).c(view);
        }
    }

}

