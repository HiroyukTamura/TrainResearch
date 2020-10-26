/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.a;
import androidx.appcompat.widget.aj;
import androidx.appcompat.widget.am;
import androidx.appcompat.widget.at;
import androidx.appcompat.widget.x;
import androidx.c.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static i b;
    private static final c c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private WeakHashMap<Context, h<ColorStateList>> j;
    private androidx.c.a<String, d> k;
    private h<String> l;
    private final WeakHashMap<Context, androidx.c.d<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap(0);
    private TypedValue n;
    private boolean o;

    static {
        c = new c(6);
        d = new int[]{a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
        e = new int[]{a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
        f = new int[]{a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
        g = new int[]{a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
        h = new int[]{a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
        i = new int[]{a.e.abc_btn_check_material, a.e.abc_btn_radio_material};
    }

    private static long a(TypedValue typedValue) {
        return (long)typedValue.assetCookie << 32 | (long)typedValue.data;
    }

    static PorterDuff.Mode a(int n2) {
        if (n2 == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static PorterDuffColorFilter a(int n2, PorterDuff.Mode mode) {
        synchronized (i.class) {
            PorterDuffColorFilter porterDuffColorFilter;
            block5 : {
                PorterDuffColorFilter porterDuffColorFilter2;
                porterDuffColorFilter = porterDuffColorFilter2 = c.a(n2, mode);
                if (porterDuffColorFilter2 != null) break block5;
                porterDuffColorFilter = new PorterDuffColorFilter(n2, mode);
                c.a(n2, mode, porterDuffColorFilter);
            }
            return porterDuffColorFilter;
            finally {
            }
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] arrn) {
        if (colorStateList != null && mode != null) {
            return i.a(colorStateList.getColorForState(arrn, 0), mode);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Drawable a(Context context, int n2, boolean bl2, Drawable drawable2) {
        Drawable drawable3;
        ColorStateList colorStateList = this.b(context, n2);
        if (colorStateList != null) {
            context = drawable2;
            if (x.b(drawable2)) {
                context = drawable2.mutate();
            }
            context = androidx.core.graphics.drawable.a.g((Drawable)context);
            androidx.core.graphics.drawable.a.a((Drawable)context, colorStateList);
            drawable2 = i.a(n2);
            colorStateList = context;
            if (drawable2 == null) return colorStateList;
            androidx.core.graphics.drawable.a.a((Drawable)context, (PorterDuff.Mode)drawable2);
            return context;
        }
        if (n2 == a.e.abc_seekbar_track_material) {
            colorStateList = (LayerDrawable)drawable2;
            i.a(colorStateList.findDrawableByLayerId(16908288), aj.a(context, a.a.colorControlNormal), a);
            drawable3 = colorStateList.findDrawableByLayerId(16908303);
            n2 = a.a.colorControlNormal;
        } else {
            if (n2 != a.e.abc_ratingbar_material && n2 != a.e.abc_ratingbar_indicator_material && n2 != a.e.abc_ratingbar_small_material) {
                colorStateList = drawable2;
                if (i.a(context, n2, drawable2)) return colorStateList;
                colorStateList = drawable2;
                if (!bl2) return colorStateList;
                return null;
            }
            colorStateList = (LayerDrawable)drawable2;
            i.a(colorStateList.findDrawableByLayerId(16908288), aj.c(context, a.a.colorControlNormal), a);
            drawable3 = colorStateList.findDrawableByLayerId(16908303);
            n2 = a.a.colorControlActivated;
        }
        i.a(drawable3, aj.a(context, n2), a);
        i.a(colorStateList.findDrawableByLayerId(16908301), aj.a(context, a.a.colorControlActivated), a);
        return drawable2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Drawable a(Context context, long l2) {
        synchronized (this) {
            androidx.c.d<WeakReference<Drawable.ConstantState>> d2;
            block8 : {
                block7 : {
                    d2 = this.m.get((Object)context);
                    if (d2 != null) break block7;
                    return null;
                }
                Drawable.ConstantState constantState = d2.a(l2);
                if (constantState == null) return null;
                constantState = (Drawable.ConstantState)constantState.get();
                if (constantState == null) break block8;
                return constantState.newDrawable(context.getResources());
            }
            d2.b(l2);
            return null;
        }
    }

    public static i a() {
        synchronized (i.class) {
            if (b == null) {
                b = new i();
                i.a(b);
            }
            i i2 = b;
            return i2;
        }
    }

    private void a(Context context, int n2, ColorStateList colorStateList) {
        h<ColorStateList> h2;
        if (this.j == null) {
            this.j = new WeakHashMap();
        }
        h<Object> h3 = h2 = this.j.get((Object)context);
        if (h2 == null) {
            h3 = new h();
            this.j.put(context, h3);
        }
        h3.c(n2, (Object)colorStateList);
    }

    private static void a(Drawable drawable2, int n2, PorterDuff.Mode mode) {
        Drawable drawable3 = drawable2;
        if (x.b(drawable2)) {
            drawable3 = drawable2.mutate();
        }
        drawable2 = mode;
        if (mode == null) {
            drawable2 = a;
        }
        drawable3.setColorFilter((ColorFilter)i.a(n2, (PorterDuff.Mode)drawable2));
    }

    static void a(Drawable drawable2, am am2, int[] arrn) {
        if (x.b(drawable2) && drawable2.mutate() != drawable2) {
            Log.d((String)"AppCompatDrawableManag", (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!am2.d && !am2.c) {
            drawable2.clearColorFilter();
        } else {
            ColorStateList colorStateList = am2.d ? am2.a : null;
            am2 = am2.c ? am2.b : a;
            drawable2.setColorFilter((ColorFilter)i.a(colorStateList, (PorterDuff.Mode)am2, arrn));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable2.invalidateSelf();
        }
    }

    private static void a(i i2) {
        if (Build.VERSION.SDK_INT < 24) {
            i2.a("vector", new e());
            i2.a("animated-vector", new b());
            i2.a("animated-selector", new a());
        }
    }

    private void a(String string2, d d2) {
        if (this.k == null) {
            this.k = new androidx.c.a();
        }
        this.k.put(string2, d2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static boolean a(Context var0, int var1_1, Drawable var2_2) {
        block7 : {
            block6 : {
                block5 : {
                    var6_3 = i.a;
                    var5_4 = i.a(i.d, var1_1);
                    var3_5 = 16842801;
                    if (!var5_4) break block5;
                    var1_1 = a.a.colorControlNormal;
                    ** GOTO lbl24
                }
                if (!i.a(i.f, var1_1)) break block6;
                var1_1 = a.a.colorControlActivated;
                ** GOTO lbl24
            }
            if (!i.a(i.g, var1_1)) break block7;
            var6_3 = PorterDuff.Mode.MULTIPLY;
            var1_1 = var3_5;
            ** GOTO lbl24
        }
        if (var1_1 == a.e.abc_list_divider_mtrl_alpha) {
            var1_1 = 16842800;
            var3_5 = Math.round(40.8f);
            var4_6 = true;
        } else if (var1_1 == a.e.abc_dialog_material_background) {
            var1_1 = var3_5;
lbl24: // 4 sources:
            var4_6 = true;
            var3_5 = -1;
        } else {
            var4_6 = false;
            var3_5 = -1;
            var1_1 = 0;
        }
        if (var4_6 == false) return false;
        var7_7 = var2_2;
        if (x.b(var2_2)) {
            var7_7 = var2_2.mutate();
        }
        var7_7.setColorFilter((ColorFilter)i.a(aj.a(var0, var1_1), var6_3));
        if (var3_5 == -1) return true;
        var7_7.setAlpha(var3_5);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(Context context, long l2, Drawable object) {
        synchronized (this) {
            void var2_2;
            void var4_6;
            void var4_3;
            Drawable.ConstantState constantState = var4_3.getConstantState();
            if (constantState == null) return false;
            androidx.c.d<WeakReference<Drawable.ConstantState>> d2 = this.m.get((Object)context);
            object = d2;
            if (d2 == null) {
                androidx.c.d d3 = new androidx.c.d();
                this.m.put(context, d3);
            }
            var4_6.b((long)var2_2, new WeakReference<Drawable.ConstantState>(constantState));
            return true;
        }
    }

    private static boolean a(Drawable drawable2) {
        return drawable2 instanceof androidx.k.a.a.i || "android.graphics.drawable.VectorDrawable".equals(drawable2.getClass().getName());
        {
        }
    }

    private static boolean a(int[] arrn, int n2) {
        int n3 = arrn.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrn[i2] != n2) continue;
            return true;
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return this.f(context, aj.a(context, a.a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return this.f(context, 0);
    }

    private Drawable c(Context context, int n2) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(n2, typedValue, true);
        long l2 = i.a(typedValue);
        Drawable drawable2 = this.a(context, l2);
        if (drawable2 != null) {
            return drawable2;
        }
        if (n2 == a.e.abc_cab_background_top_material) {
            drawable2 = new LayerDrawable(new Drawable[]{this.a(context, a.e.abc_cab_background_internal_bg), this.a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawable2 != null) {
            drawable2.setChangingConfigurations(typedValue.changingConfigurations);
            this.a(context, l2, drawable2);
        }
        return drawable2;
    }

    private ColorStateList d(Context context) {
        return this.f(context, aj.a(context, a.a.colorAccent));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable d(Context context, int n2) {
        if (this.k != null && !this.k.isEmpty()) {
            String string2;
            if (this.l != null) {
                string2 = this.l.a(n2);
                if ("appcompat_skip_skip".equals(string2) || string2 != null && this.k.get(string2) == null) {
                    return null;
                }
            } else {
                this.l = new h();
            }
            if (this.n == null) {
                this.n = new TypedValue();
            }
            TypedValue typedValue = this.n;
            string2 = context.getResources();
            string2.getValue(n2, typedValue, true);
            long l2 = i.a(typedValue);
            Drawable drawable2 = this.a(context, l2);
            if (drawable2 != null) {
                return drawable2;
            }
            Object object = drawable2;
            if (typedValue.string != null) {
                object = drawable2;
                if (typedValue.string.toString().endsWith(".xml")) {
                    object = drawable2;
                    try {
                        int n3;
                        XmlResourceParser xmlResourceParser = string2.getXml(n2);
                        object = drawable2;
                        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                        do {
                            object = drawable2;
                        } while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1);
                        if (n3 != 2) {
                            object = drawable2;
                            throw new XmlPullParserException("No start tag found");
                        }
                        object = drawable2;
                        string2 = xmlResourceParser.getName();
                        object = drawable2;
                        this.l.c(n2, string2);
                        object = drawable2;
                        d d2 = (d)this.k.get(string2);
                        string2 = drawable2;
                        if (d2 != null) {
                            object = drawable2;
                            string2 = d2.a(context, (XmlPullParser)xmlResourceParser, attributeSet, context.getTheme());
                        }
                        object = string2;
                        if (string2 != null) {
                            object = string2;
                            string2.setChangingConfigurations(typedValue.changingConfigurations);
                            object = string2;
                            this.a(context, l2, (Drawable)string2);
                            object = string2;
                        }
                    }
                    catch (Exception exception) {
                        Log.e((String)"AppCompatDrawableManag", (String)"Exception while inflating drawable", (Throwable)exception);
                    }
                }
            }
            if (object == null) {
                this.l.c(n2, "appcompat_skip_skip");
            }
            return object;
        }
        return null;
    }

    private ColorStateList e(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        ColorStateList colorStateList = aj.b(context, a.a.colorSwitchThumbNormal);
        if (colorStateList != null && colorStateList.isStateful()) {
            arrarrn[0] = aj.a;
            arrn[0] = colorStateList.getColorForState(arrarrn[0], 0);
            arrarrn[1] = aj.e;
            arrn[1] = aj.a(context, a.a.colorControlActivated);
            arrarrn[2] = aj.h;
            arrn[2] = colorStateList.getDefaultColor();
        } else {
            arrarrn[0] = aj.a;
            arrn[0] = aj.c(context, a.a.colorSwitchThumbNormal);
            arrarrn[1] = aj.e;
            arrn[1] = aj.a(context, a.a.colorControlActivated);
            arrarrn[2] = aj.h;
            arrn[2] = aj.a(context, a.a.colorSwitchThumbNormal);
        }
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList e(Context object, int n2) {
        ColorStateList colorStateList;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.j;
        ColorStateList colorStateList2 = colorStateList = null;
        if (weakHashMap != null) {
            object = this.j.get(object);
            colorStateList2 = colorStateList;
            if (object != null) {
                colorStateList2 = (ColorStateList)((h)object).a(n2);
            }
        }
        return colorStateList2;
    }

    private ColorStateList f(Context arrn, int n2) {
        int n3 = aj.a((Context)arrn, a.a.colorControlHighlight);
        int n4 = aj.c((Context)arrn, a.a.colorButtonNormal);
        arrn = aj.a;
        int[] arrn2 = aj.d;
        int n5 = androidx.core.graphics.a.a(n3, n2);
        int[] arrn3 = aj.b;
        n3 = androidx.core.graphics.a.a(n3, n2);
        return new ColorStateList((int[][])new int[][]{arrn, arrn2, arrn3, aj.h}, new int[]{n4, n5, n3, n2});
    }

    private void f(Context context) {
        if (this.o) {
            return;
        }
        this.o = true;
        if ((context = this.a(context, a.e.abc_vector_test)) != null && i.a((Drawable)context)) {
            return;
        }
        this.o = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    public Drawable a(Context context, int n2) {
        synchronized (this) {
            context = this.a(context, n2, false);
            return context;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Drawable a(Context context, int n2, boolean bl2) {
        synchronized (this) {
            void var2_2;
            Drawable drawable2;
            this.f(context);
            Drawable drawable3 = drawable2 = this.d(context, (int)var2_2);
            if (drawable2 == null) {
                drawable3 = this.c(context, (int)var2_2);
            }
            drawable2 = drawable3;
            if (drawable3 == null) {
                drawable2 = androidx.core.a.a.a(context, (int)var2_2);
            }
            drawable3 = drawable2;
            if (drawable2 != null) {
                void var3_3;
                drawable3 = this.a(context, (int)var2_2, (boolean)var3_3, drawable2);
            }
            if (drawable3 != null) {
                x.a(drawable3);
            }
            return drawable3;
        }
    }

    Drawable a(Context context, at at2, int n2) {
        synchronized (this) {
            Drawable drawable2;
            block6 : {
                Drawable drawable3;
                drawable2 = drawable3 = this.d(context, n2);
                if (drawable3 != null) break block6;
                drawable2 = at2.a(n2);
            }
            if (drawable2 != null) {
                context = this.a(context, n2, false, drawable2);
                return context;
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context object) {
        synchronized (this) {
            object = this.m.get(object);
            if (object != null) {
                ((androidx.c.d)object).c();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ColorStateList b(Context context, int n2) {
        synchronized (this) {
            ColorStateList colorStateList;
            void var2_2;
            ColorStateList colorStateList2;
            block6 : {
                int n3;
                block3 : {
                    block10 : {
                        block13 : {
                            block12 : {
                                block11 : {
                                    block9 : {
                                        block8 : {
                                            block7 : {
                                                block5 : {
                                                    block4 : {
                                                        block2 : {
                                                            colorStateList2 = colorStateList = this.e(context, (int)var2_2);
                                                            if (colorStateList != null) return colorStateList2;
                                                            if (var2_2 != a.e.abc_edit_text_material) break block2;
                                                            n3 = a.c.abc_tint_edittext;
                                                            break block3;
                                                        }
                                                        if (var2_2 != a.e.abc_switch_track_mtrl_alpha) break block4;
                                                        n3 = a.c.abc_tint_switch_track;
                                                        break block3;
                                                    }
                                                    if (var2_2 != a.e.abc_switch_thumb_material) break block5;
                                                    colorStateList = this.e(context);
                                                    break block6;
                                                }
                                                if (var2_2 != a.e.abc_btn_default_mtrl_shape) break block7;
                                                colorStateList = this.b(context);
                                                break block6;
                                            }
                                            if (var2_2 != a.e.abc_btn_borderless_material) break block8;
                                            colorStateList = this.c(context);
                                            break block6;
                                        }
                                        if (var2_2 != a.e.abc_btn_colored_material) break block9;
                                        colorStateList = this.d(context);
                                        break block6;
                                    }
                                    if (var2_2 == a.e.abc_spinner_mtrl_am_alpha || var2_2 == a.e.abc_spinner_textfield_background_material) break block10;
                                    if (!i.a(e, (int)var2_2)) break block11;
                                    colorStateList = aj.b(context, a.a.colorControlNormal);
                                    break block6;
                                }
                                if (!i.a(h, (int)var2_2)) break block12;
                                n3 = a.c.abc_tint_default;
                                break block3;
                            }
                            if (!i.a(i, (int)var2_2)) break block13;
                            n3 = a.c.abc_tint_btn_checkable;
                            break block3;
                        }
                        if (var2_2 != a.e.abc_seekbar_thumb_material) break block6;
                        n3 = a.c.abc_tint_seek_thumb;
                        break block3;
                    }
                    n3 = a.c.abc_tint_spinner;
                }
                colorStateList = androidx.appcompat.a.a.a.a(context, n3);
            }
            colorStateList2 = colorStateList;
            if (colorStateList == null) return colorStateList2;
            this.a(context, (int)var2_2, colorStateList);
            return colorStateList;
        }
    }

    static class a
    implements d {
        a() {
        }

        @Override
        public Drawable a(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = androidx.appcompat.b.a.a.a(object, object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"AsldcInflateDelegate", (String)"Exception while inflating <animated-selector>", (Throwable)exception);
                return null;
            }
        }
    }

    private static class b
    implements d {
        b() {
        }

        @Override
        public Drawable a(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = androidx.k.a.a.c.a(object, object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"AvdcInflateDelegate", (String)"Exception while inflating <animated-vector>", (Throwable)exception);
                return null;
            }
        }
    }

    private static class c
    extends androidx.c.e<Integer, PorterDuffColorFilter> {
        public c(int n2) {
            super(n2);
        }

        private static int b(int n2, PorterDuff.Mode mode) {
            return (n2 + 31) * 31 + mode.hashCode();
        }

        @Override
        PorterDuffColorFilter a(int n2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter)this.a(Integer.valueOf(c.b(n2, mode)));
        }

        PorterDuffColorFilter a(int n2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return this.a(c.b(n2, mode), porterDuffColorFilter);
        }
    }

    private static interface d {
        public Drawable a(Context var1, XmlPullParser var2, AttributeSet var3, Resources.Theme var4);
    }

    private static class e
    implements d {
        e() {
        }

        @Override
        public Drawable a(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = androidx.k.a.a.i.a(object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"VdcInflateDelegate", (String)"Exception while inflating <vector>", (Throwable)exception);
                return null;
            }
        }
    }

}

