/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.f;
import androidx.constraintlayout.widget.h;
import androidx.constraintlayout.widget.j;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {
    private static final int[] b = new int[]{0, 4, 8};
    private static SparseIntArray d = new SparseIntArray();
    private HashMap<String, b> a = new HashMap();
    private HashMap<Integer, a> c = new HashMap();

    static {
        d.append(j.b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        d.append(j.b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        d.append(j.b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        d.append(j.b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        d.append(j.b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        d.append(j.b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        d.append(j.b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        d.append(j.b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        d.append(j.b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        d.append(j.b.ConstraintSet_layout_editor_absoluteX, 6);
        d.append(j.b.ConstraintSet_layout_editor_absoluteY, 7);
        d.append(j.b.ConstraintSet_layout_constraintGuide_begin, 17);
        d.append(j.b.ConstraintSet_layout_constraintGuide_end, 18);
        d.append(j.b.ConstraintSet_layout_constraintGuide_percent, 19);
        d.append(j.b.ConstraintSet_android_orientation, 27);
        d.append(j.b.ConstraintSet_layout_constraintStart_toEndOf, 32);
        d.append(j.b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        d.append(j.b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        d.append(j.b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        d.append(j.b.ConstraintSet_layout_goneMarginLeft, 13);
        d.append(j.b.ConstraintSet_layout_goneMarginTop, 16);
        d.append(j.b.ConstraintSet_layout_goneMarginRight, 14);
        d.append(j.b.ConstraintSet_layout_goneMarginBottom, 11);
        d.append(j.b.ConstraintSet_layout_goneMarginStart, 15);
        d.append(j.b.ConstraintSet_layout_goneMarginEnd, 12);
        d.append(j.b.ConstraintSet_layout_constraintVertical_weight, 40);
        d.append(j.b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        d.append(j.b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        d.append(j.b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        d.append(j.b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        d.append(j.b.ConstraintSet_layout_constraintVertical_bias, 37);
        d.append(j.b.ConstraintSet_layout_constraintDimensionRatio, 5);
        d.append(j.b.ConstraintSet_layout_constraintLeft_creator, 76);
        d.append(j.b.ConstraintSet_layout_constraintTop_creator, 76);
        d.append(j.b.ConstraintSet_layout_constraintRight_creator, 76);
        d.append(j.b.ConstraintSet_layout_constraintBottom_creator, 76);
        d.append(j.b.ConstraintSet_layout_constraintBaseline_creator, 76);
        d.append(j.b.ConstraintSet_android_layout_marginLeft, 24);
        d.append(j.b.ConstraintSet_android_layout_marginRight, 28);
        d.append(j.b.ConstraintSet_android_layout_marginStart, 31);
        d.append(j.b.ConstraintSet_android_layout_marginEnd, 8);
        d.append(j.b.ConstraintSet_android_layout_marginTop, 34);
        d.append(j.b.ConstraintSet_android_layout_marginBottom, 2);
        d.append(j.b.ConstraintSet_android_layout_width, 23);
        d.append(j.b.ConstraintSet_android_layout_height, 21);
        d.append(j.b.ConstraintSet_android_visibility, 22);
        d.append(j.b.ConstraintSet_android_alpha, 43);
        d.append(j.b.ConstraintSet_android_elevation, 44);
        d.append(j.b.ConstraintSet_android_rotationX, 45);
        d.append(j.b.ConstraintSet_android_rotationY, 46);
        d.append(j.b.ConstraintSet_android_rotation, 60);
        d.append(j.b.ConstraintSet_android_scaleX, 47);
        d.append(j.b.ConstraintSet_android_scaleY, 48);
        d.append(j.b.ConstraintSet_android_transformPivotX, 49);
        d.append(j.b.ConstraintSet_android_transformPivotY, 50);
        d.append(j.b.ConstraintSet_android_translationX, 51);
        d.append(j.b.ConstraintSet_android_translationY, 52);
        d.append(j.b.ConstraintSet_android_translationZ, 53);
        d.append(j.b.ConstraintSet_layout_constraintWidth_default, 54);
        d.append(j.b.ConstraintSet_layout_constraintHeight_default, 55);
        d.append(j.b.ConstraintSet_layout_constraintWidth_max, 56);
        d.append(j.b.ConstraintSet_layout_constraintHeight_max, 57);
        d.append(j.b.ConstraintSet_layout_constraintWidth_min, 58);
        d.append(j.b.ConstraintSet_layout_constraintHeight_min, 59);
        d.append(j.b.ConstraintSet_layout_constraintCircle, 61);
        d.append(j.b.ConstraintSet_layout_constraintCircleRadius, 62);
        d.append(j.b.ConstraintSet_layout_constraintCircleAngle, 63);
        d.append(j.b.ConstraintSet_animate_relativeTo, 64);
        d.append(j.b.ConstraintSet_transitionEasing, 65);
        d.append(j.b.ConstraintSet_drawPath, 66);
        d.append(j.b.ConstraintSet_transitionPathRotate, 67);
        d.append(j.b.ConstraintSet_android_id, 38);
        d.append(j.b.ConstraintSet_progress, 68);
        d.append(j.b.ConstraintSet_layout_constraintWidth_percent, 69);
        d.append(j.b.ConstraintSet_layout_constraintHeight_percent, 70);
        d.append(j.b.ConstraintSet_chainUseRtl, 71);
        d.append(j.b.ConstraintSet_barrierDirection, 72);
        d.append(j.b.ConstraintSet_constraint_referenced_ids, 73);
        d.append(j.b.ConstraintSet_barrierAllowsGoneWidgets, 74);
        d.append(j.b.ConstraintSet_pathMotionArc, 75);
    }

    private static int a(TypedArray typedArray, int n2, int n3) {
        int n4;
        n3 = n4 = typedArray.getResourceId(n2, n3);
        if (n4 == -1) {
            n3 = typedArray.getInt(n2, -1);
        }
        return n3;
    }

    private a a(int n2) {
        if (!this.c.containsKey(n2)) {
            this.c.put(n2, new a());
        }
        return this.c.get(n2);
    }

    private a a(Context context, AttributeSet attributeSet) {
        a a2 = new a();
        context = context.obtainStyledAttributes(attributeSet, j.b.ConstraintSet);
        this.a(a2, (TypedArray)context);
        context.recycle();
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(a var1_1, TypedArray var2_2) {
        var4_3 = var2_2.getIndexCount();
        var3_4 = 0;
        while (var3_4 < var4_3) {
            var5_5 = var2_2.getIndex(var3_4);
            var6_6 = e.d.get(var5_5);
            block0 : switch (var6_6) {
                default: {
                    switch (var6_6) {
                        default: {
                            var7_7 = new StringBuilder();
                            var8_8 = "Unknown attribute 0x";
                            ** GOTO lbl16
                        }
                        case 76: {
                            var7_7 = new StringBuilder();
                            var8_8 = "unused attribute 0x";
lbl16: // 2 sources:
                            var7_7.append(var8_8);
                            var7_7.append(Integer.toHexString(var5_5));
                            var7_7.append("   ");
                            var7_7.append(e.d.get(var5_5));
                            Log.w((String)"ConstraintSet", (String)var7_7.toString());
                            break block0;
                        }
                        case 75: {
                            var1_1.ax = var2_2.getInt(var5_5, var1_1.ax);
                            break block0;
                        }
                        case 74: {
                            var1_1.aB = var2_2.getBoolean(var5_5, var1_1.aB);
                            break block0;
                        }
                        case 73: {
                            var1_1.au = var2_2.getString(var5_5);
                            break block0;
                        }
                        case 72: {
                            var1_1.ar = var2_2.getInt(var5_5, var1_1.ar);
                            break block0;
                        }
                        case 71: {
                            Log.e((String)"ConstraintSet", (String)"CURRENTLY UNSUPPORTED");
                            break block0;
                        }
                        case 70: {
                            var1_1.aq = var2_2.getFloat(var5_5, 1.0f);
                            break block0;
                        }
                        case 69: {
                            var1_1.ap = var2_2.getFloat(var5_5, 1.0f);
                            break block0;
                        }
                        case 68: {
                            var1_1.aA = var2_2.getFloat(var5_5, var1_1.aA);
                            break block0;
                        }
                        case 67: {
                            var1_1.az = var2_2.getFloat(var5_5, var1_1.az);
                            break block0;
                        }
                        case 66: {
                            var1_1.ay = var2_2.getInt(var5_5, 0);
                            break block0;
                        }
                        case 65: {
                            var7_7 = var2_2.peekValue((int)var5_5).type == 3 ? var2_2.getString(var5_5) : androidx.constraintlayout.a.a.a.c[var2_2.getInteger(var5_5, 0)];
                            var1_1.aw = var7_7;
                            break block0;
                        }
                        case 64: {
                            var1_1.av = e.a(var2_2, var5_5, var1_1.av);
                            break block0;
                        }
                        case 63: {
                            var1_1.z = var2_2.getFloat(var5_5, var1_1.z);
                            break block0;
                        }
                        case 62: {
                            var1_1.y = var2_2.getDimensionPixelSize(var5_5, var1_1.y);
                            break block0;
                        }
                        case 61: {
                            var1_1.x = e.a(var2_2, var5_5, var1_1.x);
                            break block0;
                        }
                        case 60: 
                    }
                    var1_1.X = var2_2.getFloat(var5_5, var1_1.X);
                    break;
                }
                case 53: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    var1_1.ag = var2_2.getDimension(var5_5, var1_1.ag);
                    break;
                }
                case 52: {
                    var1_1.af = var2_2.getDimension(var5_5, var1_1.af);
                    break;
                }
                case 51: {
                    var1_1.ae = var2_2.getDimension(var5_5, var1_1.ae);
                    break;
                }
                case 50: {
                    var1_1.ad = var2_2.getFloat(var5_5, var1_1.ad);
                    break;
                }
                case 49: {
                    var1_1.ac = var2_2.getFloat(var5_5, var1_1.ac);
                    break;
                }
                case 48: {
                    var1_1.ab = var2_2.getFloat(var5_5, var1_1.ab);
                    break;
                }
                case 47: {
                    var1_1.aa = var2_2.getFloat(var5_5, var1_1.aa);
                    break;
                }
                case 46: {
                    var1_1.Z = var2_2.getFloat(var5_5, var1_1.Z);
                    break;
                }
                case 45: {
                    var1_1.Y = var2_2.getFloat(var5_5, var1_1.Y);
                    break;
                }
                case 44: {
                    var1_1.V = true;
                    var1_1.W = var2_2.getDimension(var5_5, var1_1.W);
                    break;
                }
                case 43: {
                    var1_1.U = var2_2.getFloat(var5_5, var1_1.U);
                    break;
                }
                case 42: {
                    var1_1.T = var2_2.getInt(var5_5, var1_1.T);
                    break;
                }
                case 41: {
                    var1_1.S = var2_2.getInt(var5_5, var1_1.S);
                    break;
                }
                case 40: {
                    var1_1.Q = var2_2.getFloat(var5_5, var1_1.Q);
                    break;
                }
                case 39: {
                    var1_1.R = var2_2.getFloat(var5_5, var1_1.R);
                    break;
                }
                case 38: {
                    var1_1.d = var2_2.getResourceId(var5_5, var1_1.d);
                    break;
                }
                case 37: {
                    var1_1.v = var2_2.getFloat(var5_5, var1_1.v);
                    break;
                }
                case 36: {
                    var1_1.l = e.a(var2_2, var5_5, var1_1.l);
                    break;
                }
                case 35: {
                    var1_1.m = e.a(var2_2, var5_5, var1_1.m);
                    break;
                }
                case 34: {
                    var1_1.F = var2_2.getDimensionPixelSize(var5_5, var1_1.F);
                    break;
                }
                case 33: {
                    var1_1.r = e.a(var2_2, var5_5, var1_1.r);
                    break;
                }
                case 32: {
                    var1_1.q = e.a(var2_2, var5_5, var1_1.q);
                    break;
                }
                case 31: {
                    var1_1.I = var2_2.getDimensionPixelSize(var5_5, var1_1.I);
                    break;
                }
                case 30: {
                    var1_1.k = e.a(var2_2, var5_5, var1_1.k);
                    break;
                }
                case 29: {
                    var1_1.j = e.a(var2_2, var5_5, var1_1.j);
                    break;
                }
                case 28: {
                    var1_1.E = var2_2.getDimensionPixelSize(var5_5, var1_1.E);
                    break;
                }
                case 27: {
                    var1_1.C = var2_2.getInt(var5_5, var1_1.C);
                    break;
                }
                case 26: {
                    var1_1.i = e.a(var2_2, var5_5, var1_1.i);
                    break;
                }
                case 25: {
                    var1_1.h = e.a(var2_2, var5_5, var1_1.h);
                    break;
                }
                case 24: {
                    var1_1.D = var2_2.getDimensionPixelSize(var5_5, var1_1.D);
                    break;
                }
                case 23: {
                    var1_1.b = var2_2.getLayoutDimension(var5_5, var1_1.b);
                    break;
                }
                case 22: {
                    var1_1.J = var2_2.getInt(var5_5, var1_1.J);
                    var1_1.J = e.b[var1_1.J];
                    break;
                }
                case 21: {
                    var1_1.c = var2_2.getLayoutDimension(var5_5, var1_1.c);
                    break;
                }
                case 20: {
                    var1_1.u = var2_2.getFloat(var5_5, var1_1.u);
                    break;
                }
                case 19: {
                    var1_1.g = var2_2.getFloat(var5_5, var1_1.g);
                    break;
                }
                case 18: {
                    var1_1.f = var2_2.getDimensionPixelOffset(var5_5, var1_1.f);
                    break;
                }
                case 17: {
                    var1_1.e = var2_2.getDimensionPixelOffset(var5_5, var1_1.e);
                    break;
                }
                case 16: {
                    var1_1.L = var2_2.getDimensionPixelSize(var5_5, var1_1.L);
                    break;
                }
                case 15: {
                    var1_1.P = var2_2.getDimensionPixelSize(var5_5, var1_1.P);
                    break;
                }
                case 14: {
                    var1_1.M = var2_2.getDimensionPixelSize(var5_5, var1_1.M);
                    break;
                }
                case 13: {
                    var1_1.K = var2_2.getDimensionPixelSize(var5_5, var1_1.K);
                    break;
                }
                case 12: {
                    var1_1.O = var2_2.getDimensionPixelSize(var5_5, var1_1.O);
                    break;
                }
                case 11: {
                    var1_1.N = var2_2.getDimensionPixelSize(var5_5, var1_1.N);
                    break;
                }
                case 10: {
                    var1_1.s = e.a(var2_2, var5_5, var1_1.s);
                    break;
                }
                case 9: {
                    var1_1.t = e.a(var2_2, var5_5, var1_1.t);
                    break;
                }
                case 8: {
                    var1_1.H = var2_2.getDimensionPixelSize(var5_5, var1_1.H);
                    break;
                }
                case 7: {
                    var1_1.B = var2_2.getDimensionPixelOffset(var5_5, var1_1.B);
                    break;
                }
                case 6: {
                    var1_1.A = var2_2.getDimensionPixelOffset(var5_5, var1_1.A);
                    break;
                }
                case 5: {
                    var1_1.w = var2_2.getString(var5_5);
                    break;
                }
                case 4: {
                    var1_1.n = e.a(var2_2, var5_5, var1_1.n);
                    break;
                }
                case 3: {
                    var1_1.o = e.a(var2_2, var5_5, var1_1.o);
                    break;
                }
                case 2: {
                    var1_1.G = var2_2.getDimensionPixelSize(var5_5, var1_1.G);
                    break;
                }
                case 1: {
                    var1_1.p = e.a(var2_2, var5_5, var1_1.p);
                }
            }
            ++var3_4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int[] a(View arrn, String arrn2) {
        String[] arrstring = arrn2.split(",");
        Context context = arrn.getContext();
        arrn2 = new int[arrstring.length];
        int n3 = 0;
        for (int n2 = 0; n2 < arrstring.length; ++n2, ++n3) {
            int n4;
            Object object;
            block9 : {
                object = arrstring[n2].trim();
                try {
                    n4 = j.a.class.getField((String)object).getInt(null);
                    break block9;
                }
                catch (Exception exception) {}
                n4 = 0;
            }
            int n5 = n4;
            if (n4 == 0) {
                n5 = context.getResources().getIdentifier((String)object, "id", context.getPackageName());
            }
            n4 = n5;
            if (n5 == 0) {
                n4 = n5;
                if (arrn.isInEditMode()) {
                    n4 = n5;
                    if (arrn.getParent() instanceof ConstraintLayout) {
                        object = ((ConstraintLayout)arrn.getParent()).a(0, object);
                        n4 = n5;
                        if (object != null) {
                            n4 = n5;
                            if (object instanceof Integer) {
                                n4 = (Integer)object;
                            }
                        }
                    }
                }
            }
            arrn2[n3] = n4;
        }
        arrn = arrn2;
        if (n3 == arrstring.length) return arrn;
        return Arrays.copyOf(arrn2, n3);
    }

    private String b(int n2) {
        switch (n2) {
            default: {
                return "undefined";
            }
            case 7: {
                return "end";
            }
            case 6: {
                return "start";
            }
            case 5: {
                return "baseline";
            }
            case 4: {
                return "bottom";
            }
            case 3: {
                return "top";
            }
            case 2: {
                return "right";
            }
            case 1: 
        }
        return "left";
    }

    public void a(int n2, int n3) {
        if (this.c.containsKey(n2)) {
            a a2 = this.c.get(n2);
            switch (n3) {
                default: {
                    throw new IllegalArgumentException("unknown constraint");
                }
                case 7: {
                    a2.s = -1;
                    a2.t = -1;
                    a2.H = -1;
                    a2.O = -1;
                    return;
                }
                case 6: {
                    a2.q = -1;
                    a2.r = -1;
                    a2.I = -1;
                    a2.P = -1;
                    return;
                }
                case 5: {
                    a2.p = -1;
                    return;
                }
                case 4: {
                    a2.n = -1;
                    a2.o = -1;
                    a2.G = -1;
                    a2.N = -1;
                    return;
                }
                case 3: {
                    a2.m = -1;
                    a2.l = -1;
                    a2.F = -1;
                    a2.L = -1;
                    return;
                }
                case 2: {
                    a2.k = -1;
                    a2.j = -1;
                    a2.E = -1;
                    a2.M = -1;
                    return;
                }
                case 1: 
            }
            a2.i = -1;
            a2.h = -1;
            a2.D = -1;
            a2.K = -1;
        }
    }

    public void a(int n2, int n3, int n4) {
        a a2 = this.a(n2);
        switch (n3) {
            default: {
                throw new IllegalArgumentException("unknown constraint");
            }
            case 7: {
                a2.H = n4;
                return;
            }
            case 6: {
                a2.I = n4;
                return;
            }
            case 5: {
                throw new IllegalArgumentException("baseline does not support margins");
            }
            case 4: {
                a2.G = n4;
                return;
            }
            case 3: {
                a2.F = n4;
                return;
            }
            case 2: {
                a2.E = n4;
                return;
            }
            case 1: 
        }
        a2.D = n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, int n3, int n4, int n5, int n6) {
        if (!this.c.containsKey(n2)) {
            this.c.put(n2, new a());
        }
        Object object = this.c.get(n2);
        switch (n3) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append(this.b(n3));
                ((StringBuilder)object).append(" to ");
                ((StringBuilder)object).append(this.b(n5));
                ((StringBuilder)object).append(" unknown");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            case 7: {
                if (n5 == 7) {
                    ((a)object).t = n4;
                    ((a)object).s = -1;
                } else {
                    if (n5 != 6) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.b(n5));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((a)object).s = n4;
                    ((a)object).t = -1;
                }
                ((a)object).H = n6;
                return;
            }
            case 6: {
                if (n5 == 6) {
                    ((a)object).r = n4;
                    ((a)object).q = -1;
                } else {
                    if (n5 != 7) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.b(n5));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((a)object).q = n4;
                    ((a)object).r = -1;
                }
                ((a)object).I = n6;
                return;
            }
            case 5: {
                if (n5 == 5) {
                    ((a)object).p = n4;
                    ((a)object).o = -1;
                    ((a)object).n = -1;
                    ((a)object).l = -1;
                    ((a)object).m = -1;
                    return;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("right to ");
                ((StringBuilder)object).append(this.b(n5));
                ((StringBuilder)object).append(" undefined");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            case 4: {
                if (n5 == 4) {
                    ((a)object).o = n4;
                    ((a)object).n = -1;
                } else {
                    if (n5 != 3) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.b(n5));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((a)object).n = n4;
                    ((a)object).o = -1;
                }
                ((a)object).p = -1;
                ((a)object).G = n6;
                return;
            }
            case 3: {
                if (n5 == 3) {
                    ((a)object).l = n4;
                    ((a)object).m = -1;
                } else {
                    if (n5 != 4) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.b(n5));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((a)object).m = n4;
                    ((a)object).l = -1;
                }
                ((a)object).p = -1;
                ((a)object).F = n6;
                return;
            }
            case 2: {
                if (n5 == 1) {
                    ((a)object).j = n4;
                    ((a)object).k = -1;
                } else {
                    if (n5 != 2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.b(n5));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((a)object).k = n4;
                    ((a)object).j = -1;
                }
                ((a)object).E = n6;
                return;
            }
            case 1: 
        }
        if (n5 == 1) {
            ((a)object).h = n4;
            ((a)object).i = -1;
        } else {
            if (n5 != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Left to ");
                ((StringBuilder)object).append(this.b(n5));
                ((StringBuilder)object).append(" undefined");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            ((a)object).i = n4;
            ((a)object).h = -1;
        }
        ((a)object).D = n6;
    }

    public void a(Context context, int n2) {
        this.a((ConstraintLayout)LayoutInflater.from((Context)context).inflate(n2, null));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(Context var1_1, XmlPullParser var2_4) {
        try {
            var3_5 = var2_4.getEventType();
            var5_6 = null;
            ** GOTO lbl32
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
            return;
        }
        catch (XmlPullParserException var1_3) {
            var1_3.printStackTrace();
            return;
        }
        do {
            var4_7 = var5_6;
            if (!var6_8.equalsIgnoreCase("Constraint")) ** GOTO lbl29
            this.c.put(var5_6.d, var5_6);
            var4_7 = null;
            ** GOTO lbl29
            break;
        } while (true);
        {
            block11 : {
                if (!var6_8.equalsIgnoreCase("Guideline")) break block11;
                var4_7 = this.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_4));
                var4_7.a = true;
                ** GOTO lbl29
            }
            var4_7 = var5_6;
            if (!var6_8.equalsIgnoreCase("CustomAttribute")) ** GOTO lbl29
            b.a(var1_1, var2_4, var5_6.aC);
            var4_7 = var5_6;
            ** GOTO lbl29
            {
                var2_4.getName();
                var4_7 = var5_6;
lbl29: // 6 sources:
                block10 : do {
                    var3_5 = var2_4.next();
                    var5_6 = var4_7;
lbl32: // 2 sources:
                    if (var3_5 == 1) return;
                    if (var3_5 == 0) continue block9;
                    switch (var3_5) {
                        case 3: {
                            if (!"ConstraintSet".equals(var6_8 = var2_4.getName())) ** continue;
                            return;
                        }
                        case 2: {
                            var6_8 = var2_4.getName();
                            if (!var6_8.equalsIgnoreCase("Constraint")) continue block8;
                            var4_7 = this.a(var1_1, Xml.asAttributeSet((XmlPullParser)var2_4));
                            continue block10;
                        }
                    }
                    var4_7 = var5_6;
                } while (true);
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        int n2 = constraintLayout.getChildCount();
        this.c.clear();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = constraintLayout.getChildAt(i2);
            ConstraintLayout.a a2 = (ConstraintLayout.a)view.getLayoutParams();
            int n3 = view.getId();
            if (n3 != -1) {
                if (!this.c.containsKey(n3)) {
                    this.c.put(n3, new a());
                }
                a a3 = this.c.get(n3);
                a3.aC = b.a(this.a, view);
                a3.a(n3, a2);
                a3.J = view.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    a3.U = view.getAlpha();
                    a3.X = view.getRotation();
                    a3.Y = view.getRotationX();
                    a3.Z = view.getRotationY();
                    a3.aa = view.getScaleX();
                    a3.ab = view.getScaleY();
                    float f2 = view.getPivotX();
                    float f3 = view.getPivotY();
                    if ((double)f2 != 0.0 || (double)f3 != 0.0) {
                        a3.ac = f2;
                        a3.ad = f3;
                    }
                    a3.ae = view.getTranslationX();
                    a3.af = view.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        a3.ag = view.getTranslationZ();
                        if (a3.V) {
                            a3.W = view.getElevation();
                        }
                    }
                }
                if (!(view instanceof androidx.constraintlayout.widget.a)) continue;
                view = (androidx.constraintlayout.widget.a)view;
                a3.aB = view.a();
                a3.at = view.getReferencedIds();
                a3.ar = view.getType();
                continue;
            }
            throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
    }

    public void a(f f2) {
        int n2 = f2.getChildCount();
        this.c.clear();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = f2.getChildAt(i2);
            f.a a2 = (f.a)view.getLayoutParams();
            int n3 = view.getId();
            if (n3 != -1) {
                if (!this.c.containsKey(n3)) {
                    this.c.put(n3, new a());
                }
                a a3 = this.c.get(n3);
                if (view instanceof c) {
                    a3.a((c)view, n3, a2);
                }
                a3.a(n3, a2);
                continue;
            }
            throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void b(Context var1_1, int var2_4) {
        var3_5 = var1_1.getResources().getXml(var2_4);
        try {
            var2_4 = var3_5.getEventType();
            ** GOTO lbl14
        }
        catch (IOException var1_2) {
            var1_2.printStackTrace();
            return;
        }
        catch (XmlPullParserException var1_3) {
            var1_3.printStackTrace();
            return;
        }
        {
            var3_5.getName();
            block8 : do {
                var2_4 = var3_5.next();
lbl14: // 2 sources:
                if (var2_4 == 1) return;
                if (var2_4 == 0) continue block7;
                switch (var2_4) {
                    case 2: {
                        var4_6 = var3_5.getName();
                        var5_7 = this.a(var1_1, Xml.asAttributeSet((XmlPullParser)var3_5));
                        if (var4_6.equalsIgnoreCase("Guideline")) {
                            var5_7.a = true;
                        }
                        this.c.put(var5_7.d, var5_7);
                        continue block8;
                    }
                    case 3: {
                        continue block8;
                    }
                }
            } while (true);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        this.c(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    /*
     * Enabled aggressive block sorting
     */
    void c(ConstraintLayout constraintLayout) {
        Object object;
        Object object2;
        int n2 = constraintLayout.getChildCount();
        Object object3 = new HashSet<Integer>(this.c.keySet());
        for (int i2 = 0; i2 < n2; ++i2) {
            block14 : {
                int n3;
                block15 : {
                    View view;
                    block16 : {
                        block17 : {
                            block13 : {
                                view = constraintLayout.getChildAt(i2);
                                n3 = view.getId();
                                if (this.c.containsKey(n3)) break block13;
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("id unknown ");
                                ((StringBuilder)object2).append(androidx.constraintlayout.a.b.a.a(view));
                                break block14;
                            }
                            if (n3 == -1) {
                                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                            }
                            if (!this.c.containsKey(n3)) break block15;
                            ((HashSet)object3).remove(n3);
                            object2 = this.c.get(n3);
                            if (view instanceof androidx.constraintlayout.widget.a) {
                                ((a)object2).as = 1;
                            }
                            if (((a)object2).as == -1 || ((a)object2).as != 1) break block16;
                            object = (androidx.constraintlayout.widget.a)view;
                            object.setId(n3);
                            ((androidx.constraintlayout.widget.a)((Object)object)).setType(((a)object2).ar);
                            ((androidx.constraintlayout.widget.a)((Object)object)).setAllowsGoneWidget(((a)object2).aB);
                            if (((a)object2).at != null) break block17;
                            if (((a)object2).au == null) break block16;
                            ((a)object2).at = this.a((View)object, ((a)object2).au);
                        }
                        ((c)((Object)object)).setReferencedIds(((a)object2).at);
                    }
                    object = (ConstraintLayout.a)view.getLayoutParams();
                    ((a)object2).a((ConstraintLayout.a)((Object)object));
                    b.a(view, ((a)object2).aC);
                    view.setLayoutParams((ViewGroup.LayoutParams)object);
                    view.setVisibility(((a)object2).J);
                    if (Build.VERSION.SDK_INT < 17) continue;
                    view.setAlpha(((a)object2).U);
                    view.setRotation(((a)object2).X);
                    view.setRotationX(((a)object2).Y);
                    view.setRotationY(((a)object2).Z);
                    view.setScaleX(((a)object2).aa);
                    view.setScaleY(((a)object2).ab);
                    if (!Float.isNaN(((a)object2).ac)) {
                        view.setPivotX(((a)object2).ac);
                    }
                    if (!Float.isNaN(((a)object2).ad)) {
                        view.setPivotY(((a)object2).ad);
                    }
                    view.setTranslationX(((a)object2).ae);
                    view.setTranslationY(((a)object2).af);
                    if (Build.VERSION.SDK_INT < 21) continue;
                    view.setTranslationZ(((a)object2).ag);
                    if (!((a)object2).V) continue;
                    view.setElevation(((a)object2).W);
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("WARNING NO CONSTRAINTS for view ");
                ((StringBuilder)object2).append(n3);
            }
            Log.v((String)"ConstraintSet", (String)((StringBuilder)object2).toString());
        }
        object2 = ((HashSet)object3).iterator();
        do {
            Integer n4;
            block18 : {
                block20 : {
                    block19 : {
                        if (!object2.hasNext()) {
                            return;
                        }
                        n4 = object2.next();
                        object3 = this.c.get(n4);
                        if (((a)object3).as == -1 || ((a)object3).as != 1) break block18;
                        object = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                        object.setId(n4.intValue());
                        if (((a)object3).at != null) break block19;
                        if (((a)object3).au == null) break block20;
                        ((a)object3).at = this.a((View)object, ((a)object3).au);
                    }
                    ((c)((Object)object)).setReferencedIds(((a)object3).at);
                }
                ((androidx.constraintlayout.widget.a)((Object)object)).setType(((a)object3).ar);
                ConstraintLayout.a a2 = constraintLayout.a();
                ((c)((Object)object)).b();
                ((a)object3).a(a2);
                constraintLayout.addView((View)object, (ViewGroup.LayoutParams)a2);
            }
            if (!((a)object3).a) continue;
            object = new h(constraintLayout.getContext());
            object.setId(n4.intValue());
            ConstraintLayout.a a3 = constraintLayout.a();
            ((a)object3).a(a3);
            constraintLayout.addView((View)object, (ViewGroup.LayoutParams)a3);
        } while (true);
    }

    public static class a {
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = 0;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public float Q = 0.0f;
        public float R = 0.0f;
        public int S = 0;
        public int T = 0;
        public float U = 1.0f;
        public boolean V = false;
        public float W = 0.0f;
        public float X = 0.0f;
        public float Y = 0.0f;
        public float Z = 0.0f;
        boolean a = false;
        public float aA = Float.NaN;
        public boolean aB = true;
        public HashMap<String, b> aC = new HashMap();
        public float aa = 1.0f;
        public float ab = 1.0f;
        public float ac = Float.NaN;
        public float ad = Float.NaN;
        public float ae = 0.0f;
        public float af = 0.0f;
        public float ag = 0.0f;
        public boolean ah = false;
        public boolean ai = false;
        public int aj = 0;
        public int ak = 0;
        public int al = -1;
        public int am = -1;
        public int an = -1;
        public int ao = -1;
        public float ap = 1.0f;
        public float aq = 1.0f;
        public int ar = -1;
        public int as = -1;
        public int[] at;
        public String au;
        public int av = -1;
        public String aw = null;
        public int ax = -1;
        public int ay = 0;
        public float az = Float.NaN;
        public int b;
        public int c;
        int d;
        public int e = -1;
        public int f = -1;
        public float g = -1.0f;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;

        private void a(int n2, ConstraintLayout.a a2) {
            this.d = n2;
            this.h = a2.d;
            this.i = a2.e;
            this.j = a2.f;
            this.k = a2.g;
            this.l = a2.h;
            this.m = a2.i;
            this.n = a2.j;
            this.o = a2.k;
            this.p = a2.l;
            this.q = a2.p;
            this.r = a2.q;
            this.s = a2.r;
            this.t = a2.s;
            this.u = a2.z;
            this.v = a2.A;
            this.w = a2.B;
            this.x = a2.m;
            this.y = a2.n;
            this.z = a2.o;
            this.A = a2.Q;
            this.B = a2.R;
            this.C = a2.S;
            this.g = a2.c;
            this.e = a2.a;
            this.f = a2.b;
            this.b = a2.width;
            this.c = a2.height;
            this.D = a2.leftMargin;
            this.E = a2.rightMargin;
            this.F = a2.topMargin;
            this.G = a2.bottomMargin;
            this.Q = a2.F;
            this.R = a2.E;
            this.T = a2.H;
            this.S = a2.G;
            this.ah = a2.T;
            this.ai = a2.U;
            this.aj = a2.I;
            this.ak = a2.J;
            this.ah = a2.T;
            this.al = a2.M;
            this.am = a2.N;
            this.an = a2.K;
            this.ao = a2.L;
            this.ap = a2.O;
            this.aq = a2.P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = a2.getMarginEnd();
                this.I = a2.getMarginStart();
            }
        }

        private void a(int n2, f.a a2) {
            this.a(n2, (ConstraintLayout.a)a2);
            this.U = a2.ao;
            this.X = a2.ar;
            this.Y = a2.as;
            this.Z = a2.at;
            this.aa = a2.au;
            this.ab = a2.av;
            this.ac = a2.aw;
            this.ad = a2.ax;
            this.ae = a2.ay;
            this.af = a2.az;
            this.ag = a2.aA;
            this.W = a2.aq;
            this.V = a2.ap;
        }

        private void a(c c2, int n2, f.a a2) {
            this.a(n2, a2);
            if (c2 instanceof androidx.constraintlayout.widget.a) {
                this.as = 1;
                c2 = (androidx.constraintlayout.widget.a)c2;
                this.ar = ((androidx.constraintlayout.widget.a)c2).getType();
                this.at = c2.getReferencedIds();
            }
        }

        public a a() {
            a a2 = new a();
            a2.a = this.a;
            a2.b = this.b;
            a2.c = this.c;
            a2.e = this.e;
            a2.f = this.f;
            a2.g = this.g;
            a2.h = this.h;
            a2.i = this.i;
            a2.j = this.j;
            a2.k = this.k;
            a2.l = this.l;
            a2.m = this.m;
            a2.n = this.n;
            a2.o = this.o;
            a2.p = this.p;
            a2.q = this.q;
            a2.r = this.r;
            a2.s = this.s;
            a2.t = this.t;
            a2.u = this.u;
            a2.v = this.v;
            a2.w = this.w;
            a2.A = this.A;
            a2.B = this.B;
            a2.u = this.u;
            a2.u = this.u;
            a2.u = this.u;
            a2.u = this.u;
            a2.u = this.u;
            a2.C = this.C;
            a2.D = this.D;
            a2.E = this.E;
            a2.F = this.F;
            a2.G = this.G;
            a2.H = this.H;
            a2.I = this.I;
            a2.J = this.J;
            a2.K = this.K;
            a2.L = this.L;
            a2.M = this.M;
            a2.N = this.N;
            a2.O = this.O;
            a2.P = this.P;
            a2.Q = this.Q;
            a2.R = this.R;
            a2.S = this.S;
            a2.T = this.T;
            a2.U = this.U;
            a2.V = this.V;
            a2.W = this.W;
            a2.X = this.X;
            a2.Y = this.Y;
            a2.Z = this.Z;
            a2.aa = this.aa;
            a2.ab = this.ab;
            a2.ac = this.ac;
            a2.ad = this.ad;
            a2.ae = this.ae;
            a2.af = this.af;
            a2.ag = this.ag;
            a2.ah = this.ah;
            a2.ai = this.ai;
            a2.aj = this.aj;
            a2.ak = this.ak;
            a2.al = this.al;
            a2.am = this.am;
            a2.an = this.an;
            a2.ao = this.ao;
            a2.ap = this.ap;
            a2.aq = this.aq;
            a2.ar = this.ar;
            a2.as = this.as;
            if (this.at != null) {
                a2.at = Arrays.copyOf(this.at, this.at.length);
            }
            a2.x = this.x;
            a2.y = this.y;
            a2.z = this.z;
            a2.av = this.av;
            a2.aw = this.aw;
            a2.ax = this.ax;
            a2.ay = this.ay;
            a2.aB = this.aB;
            return a2;
        }

        public void a(ConstraintLayout.a a2) {
            a2.d = this.h;
            a2.e = this.i;
            a2.f = this.j;
            a2.g = this.k;
            a2.h = this.l;
            a2.i = this.m;
            a2.j = this.n;
            a2.k = this.o;
            a2.l = this.p;
            a2.p = this.q;
            a2.q = this.r;
            a2.r = this.s;
            a2.s = this.t;
            a2.leftMargin = this.D;
            a2.rightMargin = this.E;
            a2.topMargin = this.F;
            a2.bottomMargin = this.G;
            a2.x = this.P;
            a2.y = this.O;
            a2.z = this.u;
            a2.A = this.v;
            a2.m = this.x;
            a2.n = this.y;
            a2.o = this.z;
            a2.B = this.w;
            a2.Q = this.A;
            a2.R = this.B;
            a2.F = this.Q;
            a2.E = this.R;
            a2.H = this.T;
            a2.G = this.S;
            a2.T = this.ah;
            a2.U = this.ai;
            a2.I = this.aj;
            a2.J = this.ak;
            a2.M = this.al;
            a2.N = this.am;
            a2.K = this.an;
            a2.L = this.ao;
            a2.O = this.ap;
            a2.P = this.aq;
            a2.S = this.C;
            a2.c = this.g;
            a2.a = this.e;
            a2.b = this.f;
            a2.width = this.b;
            a2.height = this.c;
            if (Build.VERSION.SDK_INT >= 17) {
                a2.setMarginStart(this.I);
                a2.setMarginEnd(this.H);
            }
            a2.a();
        }

        public /* synthetic */ Object clone() {
            return this.a();
        }
    }

}

