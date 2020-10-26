/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.core.h;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.core.h.m;
import androidx.core.h.n;

public final class w {
    public static void a(ViewParent viewParent, View view, int n2) {
        if (viewParent instanceof n) {
            ((n)viewParent).c(view, n2);
            return;
        }
        if (n2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                }
                catch (AbstractMethodError abstractMethodError) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append((Object)viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onStopNestedScroll");
                    Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                    return;
                }
            }
            if (viewParent instanceof m) {
                ((m)viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5, int n6) {
        if (viewParent instanceof n) {
            ((n)viewParent).a(view, n2, n3, n4, n5, n6);
            return;
        }
        if (n6 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, n2, n3, n4, n5);
                    return;
                }
                catch (AbstractMethodError abstractMethodError) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append((Object)viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onNestedScroll");
                    Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
                    return;
                }
            }
            if (viewParent instanceof m) {
                ((m)viewParent).onNestedScroll(view, n2, n3, n4, n5);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int[] object, int n4) {
        if (viewParent instanceof n) {
            ((n)viewParent).a(view, n2, n3, (int[])object, n4);
            return;
        }
        if (n4 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, n2, n3, (int[])object);
                    return;
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append((Object)viewParent);
                    ((StringBuilder)object).append(" does not implement interface ");
                    ((StringBuilder)object).append("method onNestedPreScroll");
                    Log.e((String)"ViewParentCompat", (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                    return;
                }
            }
            if (viewParent instanceof m) {
                ((m)viewParent).onNestedPreScroll(view, n2, n3, (int[])object);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                boolean bl2 = viewParent.onNestedPreFling(view, f2, f3);
                return bl2;
            }
            catch (AbstractMethodError abstractMethodError) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ViewParent ");
                stringBuilder.append((Object)viewParent);
                stringBuilder.append(" does not implement interface ");
                stringBuilder.append("method onNestedPreFling");
                Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
            }
        } else if (viewParent instanceof m) {
            return ((m)viewParent).onNestedPreFling(view, f2, f3);
        }
        return false;
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                bl2 = viewParent.onNestedFling(view, f2, f3, bl2);
                return bl2;
            }
            catch (AbstractMethodError abstractMethodError) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ViewParent ");
                stringBuilder.append((Object)viewParent);
                stringBuilder.append(" does not implement interface ");
                stringBuilder.append("method onNestedFling");
                Log.e((String)"ViewParentCompat", (String)stringBuilder.toString(), (Throwable)abstractMethodError);
            }
        } else if (viewParent instanceof m) {
            return ((m)viewParent).onNestedFling(view, f2, f3, bl2);
        }
        return false;
    }

    public static boolean a(ViewParent viewParent, View view, View object, int n2, int n3) {
        if (viewParent instanceof n) {
            return ((n)viewParent).a(view, (View)object, n2, n3);
        }
        if (n3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    boolean bl2 = viewParent.onStartNestedScroll(view, (View)object, n2);
                    return bl2;
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append((Object)viewParent);
                    ((StringBuilder)object).append(" does not implement interface ");
                    ((StringBuilder)object).append("method onStartNestedScroll");
                    Log.e((String)"ViewParentCompat", (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                }
            } else if (viewParent instanceof m) {
                return ((m)viewParent).onStartNestedScroll(view, (View)object, n2);
            }
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View object, int n2, int n3) {
        if (viewParent instanceof n) {
            ((n)viewParent).b(view, (View)object, n2, n3);
            return;
        }
        if (n3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, (View)object, n2);
                    return;
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ViewParent ");
                    ((StringBuilder)object).append((Object)viewParent);
                    ((StringBuilder)object).append(" does not implement interface ");
                    ((StringBuilder)object).append("method onNestedScrollAccepted");
                    Log.e((String)"ViewParentCompat", (String)((StringBuilder)object).toString(), (Throwable)abstractMethodError);
                    return;
                }
            }
            if (viewParent instanceof m) {
                ((m)viewParent).onNestedScrollAccepted(view, (View)object, n2);
            }
        }
    }
}

