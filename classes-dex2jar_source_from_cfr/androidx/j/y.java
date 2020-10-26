/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.LayoutTransition
 *  android.util.Log
 *  android.view.ViewGroup
 */
package androidx.j;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.j.j;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class y {
    private static LayoutTransition a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(LayoutTransition layoutTransition) {
        String string2;
        block7 : {
            if (!e) {
                block6 : {
                    try {
                        d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                        d.setAccessible(true);
                        break block6;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {}
                    Log.i((String)"ViewGroupUtilsApi14", (String)"Failed to access cancel method by reflection");
                }
                e = true;
            }
            if (d == null) return;
            try {
                d.invoke((Object)layoutTransition, new Object[0]);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {}
            string2 = "Failed to access cancel method by reflection";
            break block7;
            catch (InvocationTargetException invocationTargetException) {}
            string2 = "Failed to invoke cancel method by reflection";
        }
        Log.i((String)"ViewGroupUtilsApi14", (String)string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void a(ViewGroup var0, boolean var1_1) {
        block16 : {
            block14 : {
                block17 : {
                    block15 : {
                        var4_2 = y.a;
                        var3_6 = false;
                        var2_7 = false;
                        if (var4_2 == null) {
                            y.a = new LayoutTransition(){

                                public boolean isChangingLayout() {
                                    return true;
                                }
                            };
                            y.a.setAnimator(2, null);
                            y.a.setAnimator(0, null);
                            y.a.setAnimator(1, null);
                            y.a.setAnimator(3, null);
                            y.a.setAnimator(4, null);
                        }
                        if (!var1_1) break block15;
                        var4_2 = var0.getLayoutTransition();
                        if (var4_2 != null) {
                            if (var4_2.isRunning()) {
                                y.a(var4_2);
                            }
                            if (var4_2 != y.a) {
                                var0.setTag(j.a.transition_layout_save, (Object)var4_2);
                            }
                        }
                        var4_2 = y.a;
                        break block16;
                    }
                    var0.setLayoutTransition(null);
                    if (!y.c) {
                        block13 : {
                            try {
                                y.b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                                y.b.setAccessible(true);
                                break block13;
                            }
                            catch (NoSuchFieldException var4_3) {}
                            Log.i((String)"ViewGroupUtilsApi14", (String)"Failed to access mLayoutSuppressed field by reflection");
                        }
                        y.c = true;
                    }
                    var1_1 = var3_6;
                    if (y.b == null) break block14;
                    try {
                        var1_1 = y.b.getBoolean((Object)var0);
                        ** if (!var1_1) goto lbl-1000
                    }
                    catch (IllegalAccessException var4_5) {
                        var1_1 = var2_7;
                    }
lbl-1000: // 1 sources:
                    {
                        y.b.setBoolean((Object)var0, false);
                    }
lbl-1000: // 2 sources:
                    {
                        break block14;
                    }
                    break block17;
                    catch (IllegalAccessException var4_4) {}
                }
                Log.i((String)"ViewGroupUtilsApi14", (String)"Failed to get mLayoutSuppressed field by reflection");
            }
            if (var1_1) {
                var0.requestLayout();
            }
            if ((var4_2 = (LayoutTransition)var0.getTag(j.a.transition_layout_save)) == null) return;
            var0.setTag(j.a.transition_layout_save, null);
        }
        var0.setLayoutTransition(var4_2);
    }

}

