/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.drawable.Drawable
 *  android.icu.text.DecimalFormatSymbols
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.Log
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.f.a;
import androidx.core.g.e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class i {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    private static int a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }

    public static int a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!d) {
            c = i.a("mMaxMode");
            d = true;
        }
        if (c != null && i.a(c, textView) == 1) {
            if (!b) {
                a = i.a("mMaximum");
                b = true;
            }
            if (a != null) {
                return i.a(a, textView);
            }
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int a(Field field, TextView textView) {
        try {
            return field.getInt((Object)textView);
        }
        catch (IllegalAccessException illegalAccessException) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not retrieve value of ");
        stringBuilder.append(field.getName());
        stringBuilder.append(" field.");
        Log.d((String)"TextViewCompat", (String)stringBuilder.toString());
        return -1;
    }

    public static ActionMode.Callback a(TextView textView, ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27) {
            if (callback instanceof a) {
                return callback;
            }
            return new a(callback, textView);
        }
        return callback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Field a(String string2) {
        Field field;
        try {
            field = TextView.class.getDeclaredField(string2);
        }
        catch (NoSuchFieldException noSuchFieldException) {}
        try {
            field.setAccessible(true);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {}
        field = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not retrieve ");
        stringBuilder.append(string2);
        stringBuilder.append(" field.");
        Log.e((String)"TextViewCompat", (String)stringBuilder.toString());
        return field;
    }

    public static void a(TextView textView, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(n2);
            return;
        }
        textView.setTextAppearance(textView.getContext(), n2);
    }

    public static void a(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable5);
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            int n2 = textView.getLayoutDirection();
            boolean bl2 = true;
            if (n2 != 1) {
                bl2 = false;
            }
            Drawable drawable6 = bl2 ? drawable4 : drawable2;
            if (!bl2) {
                drawable2 = drawable4;
            }
            textView.setCompoundDrawables(drawable6, drawable3, drawable2, drawable5);
            return;
        }
        textView.setCompoundDrawables(drawable2, drawable3, drawable4, drawable5);
    }

    public static void a(TextView textView, a.a a2) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(i.a(a2.b()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float f2 = a2.a().getTextScaleX();
            textView.getPaint().set(a2.a());
            if (f2 == textView.getTextScaleX()) {
                textView.setTextScaleX(f2 / 2.0f + 1.0f);
            }
            textView.setTextScaleX(f2);
            return;
        }
        textView.getPaint().set(a2.a());
        textView.setBreakStrategy(a2.c());
        textView.setHyphenationFrequency(a2.d());
    }

    public static void a(TextView textView, androidx.core.f.a a2) {
        if (i.d(textView).a(a2.a())) {
            textView.setText((CharSequence)((Object)a2));
            return;
        }
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static void b(TextView textView, int n2) {
        e.a(n2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(n2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n3 = Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding() ? fontMetricsInt.ascent : fontMetricsInt.top;
        if (n2 > Math.abs(n3)) {
            n3 = -n3;
            textView.setPadding(textView.getPaddingLeft(), n2 - n3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void c(TextView textView, int n2) {
        e.a(n2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n3 = Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding() ? fontMetricsInt.descent : fontMetricsInt.bottom;
        if (n2 > Math.abs(n3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), n2 - n3);
        }
    }

    public static a.a d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new a.a(textView.getTextMetricsParams());
        }
        a.a.a a2 = new a.a.a(new TextPaint((Paint)textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            a2.a(textView.getBreakStrategy());
            a2.b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            a2.a(i.e(textView));
        }
        return a2.a();
    }

    public static void d(TextView textView, int n2) {
        e.a(n2);
        int n3 = textView.getPaint().getFontMetricsInt(null);
        if (n2 != n3) {
            textView.setLineSpacing((float)(n2 - n3), 1.0f);
        }
    }

    private static TextDirectionHeuristic e(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        int n2 = Build.VERSION.SDK_INT;
        byte by2 = 0;
        if (n2 >= 28 && (textView.getInputType() & 15) == 3) {
            by2 = Character.getDirectionality(DecimalFormatSymbols.getInstance((Locale)textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (by2 != 1 && by2 != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        if (textView.getLayoutDirection() == 1) {
            by2 = 1;
        }
        switch (textView.getTextDirection()) {
            default: {
                if (by2 == 0) break;
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 7: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 6: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            case 4: {
                return TextDirectionHeuristics.RTL;
            }
            case 3: {
                return TextDirectionHeuristics.LTR;
            }
            case 2: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
        }
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }

    private static class a
    implements ActionMode.Callback {
        private final ActionMode.Callback a;
        private final TextView b;
        private Class c;
        private Method d;
        private boolean e;
        private boolean f;

        a(ActionMode.Callback callback, TextView textView) {
            this.a = callback;
            this.b = textView;
            this.f = false;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent a(ResolveInfo resolveInfo, TextView textView) {
            return this.a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.a(textView) ^ true).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private List<ResolveInfo> a(Context context, PackageManager object) {
            ArrayList<ResolveInfo> arrayList = new ArrayList<ResolveInfo>();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : object.queryIntentActivities(this.a(), 0)) {
                if (!this.a(resolveInfo, context)) continue;
                arrayList.add(resolveInfo);
            }
            return arrayList;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void a(Menu menu) {
            Context context;
            int n2;
            Object object;
            PackageManager packageManager;
            block8 : {
                context = this.b.getContext();
                packageManager = context.getPackageManager();
                if (!this.f) {
                    this.f = true;
                    try {
                        this.c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                        this.d = this.c.getDeclaredMethod("removeItemAt", Integer.TYPE);
                        this.e = true;
                        break block8;
                    }
                    catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {}
                    this.c = null;
                    this.d = null;
                    this.e = false;
                }
            }
            try {
                object = this.e && this.c.isInstance((Object)menu) ? this.d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (n2 = menu.size() - 1; n2 >= 0; --n2) {
                    MenuItem menuItem = menu.getItem(n2);
                    if (menuItem.getIntent() == null || !"android.intent.action.PROCESS_TEXT".equals(menuItem.getIntent().getAction())) continue;
                    ((Method)object).invoke((Object)menu, n2);
                }
                object = this.a(context, packageManager);
                n2 = 0;
            }
            catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
                return;
            }
            do {
                if (n2 >= object.size()) {
                    return;
                }
                context = (ResolveInfo)object.get(n2);
                menu.add(0, 0, n2 + 100, context.loadLabel(packageManager)).setIntent(this.a((ResolveInfo)context, this.b)).setShowAsAction(1);
                ++n2;
            } while (true);
        }

        private boolean a(ResolveInfo resolveInfo, Context context) {
            boolean bl2 = context.getPackageName().equals(resolveInfo.activityInfo.packageName);
            boolean bl3 = true;
            if (bl2) {
                return true;
            }
            if (!resolveInfo.activityInfo.exported) {
                return false;
            }
            if (resolveInfo.activityInfo.permission != null) {
                if (context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0) {
                    return true;
                }
                bl3 = false;
            }
            return bl3;
        }

        private boolean a(TextView textView) {
            return textView instanceof Editable && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            this.a(menu);
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

}

