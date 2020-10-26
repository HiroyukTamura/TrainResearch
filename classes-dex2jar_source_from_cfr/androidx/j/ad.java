/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.Log
 *  android.util.Property
 *  android.view.View
 */
package androidx.j;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.core.h.t;
import androidx.j.aa;
import androidx.j.ab;
import androidx.j.ac;
import androidx.j.ae;
import androidx.j.af;
import androidx.j.ag;
import androidx.j.ah;
import androidx.j.aj;
import androidx.j.ak;
import androidx.j.al;
import java.lang.reflect.Field;

class ad {
    static final Property<View, Float> a;
    static final Property<View, Rect> b;
    private static final ah c;
    private static Field d;
    private static boolean e;

    /*
     * Enabled aggressive block sorting
     */
    static {
        void var0_1;
        if (Build.VERSION.SDK_INT >= 22) {
            ag ag2 = new ag();
        } else if (Build.VERSION.SDK_INT >= 21) {
            af af2 = new af();
        } else if (Build.VERSION.SDK_INT >= 19) {
            ae ae2 = new ae();
        } else {
            ah ah2 = new ah();
        }
        c = var0_1;
        a = new Property<View, Float>(Float.class, "translationAlpha"){

            public Float a(View view) {
                return Float.valueOf(ad.c(view));
            }

            public void a(View view, Float f2) {
                ad.a(view, f2.floatValue());
            }

            public /* synthetic */ Object get(Object object) {
                return this.a((View)object);
            }

            public /* synthetic */ void set(Object object, Object object2) {
                this.a((View)object, (Float)object2);
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds"){

            public Rect a(View view) {
                return t.A(view);
            }

            public void a(View view, Rect rect) {
                t.a(view, rect);
            }

            public /* synthetic */ Object get(Object object) {
                return this.a((View)object);
            }

            public /* synthetic */ void set(Object object, Object object2) {
                this.a((View)object, (Rect)object2);
            }
        };
    }

    static ac a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ab(view);
        }
        return aa.d(view);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a() {
        if (!e) {
            block3 : {
                try {
                    d = View.class.getDeclaredField("mViewFlags");
                    d.setAccessible(true);
                    break block3;
                }
                catch (NoSuchFieldException noSuchFieldException) {}
                Log.i((String)"ViewUtils", (String)"fetchViewFlagsField: ");
            }
            e = true;
        }
    }

    static void a(View view, float f2) {
        c.a(view, f2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void a(View view, int n2) {
        ad.a();
        if (d == null) return;
        try {
            int n3 = d.getInt((Object)view);
            d.setInt((Object)view, n2 | n3 & -13);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }

    static void a(View view, int n2, int n3, int n4, int n5) {
        c.a(view, n2, n3, n4, n5);
    }

    static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    static al b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ak(view);
        }
        return new aj(view.getWindowToken());
    }

    static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    static float c(View view) {
        return c.a(view);
    }

    static void d(View view) {
        c.b(view);
    }

    static void e(View view) {
        c.c(view);
    }

}

