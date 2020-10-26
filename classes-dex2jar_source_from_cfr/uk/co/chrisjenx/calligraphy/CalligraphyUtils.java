/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.text.Editable
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 */
package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public final class CalligraphyUtils {
    public static final int[] ANDROID_ATTR_TEXT_APPEARANCE = new int[]{16842804};
    private static Boolean sAppCompatViewCheck;
    private static Boolean sToolbarCheck;

    static {
        sToolbarCheck = null;
        sAppCompatViewCheck = null;
    }

    private CalligraphyUtils() {
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig) {
        CalligraphyUtils.applyFontToTextView(context, textView, calligraphyConfig, false);
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String string2) {
        CalligraphyUtils.applyFontToTextView(context, textView, calligraphyConfig, string2, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String string2, boolean bl2) {
        if (context != null && textView != null) {
            if (calligraphyConfig == null) {
                return;
            }
            if (!TextUtils.isEmpty((CharSequence)string2) && CalligraphyUtils.applyFontToTextView(context, textView, string2, bl2)) {
                return;
            }
            CalligraphyUtils.applyFontToTextView(context, textView, calligraphyConfig, bl2);
        }
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, boolean bl2) {
        if (context != null && textView != null) {
            if (calligraphyConfig == null) {
                return;
            }
            if (!calligraphyConfig.isFontSet()) {
                return;
            }
            CalligraphyUtils.applyFontToTextView(context, textView, calligraphyConfig.getFontPath(), bl2);
        }
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String string2) {
        return CalligraphyUtils.applyFontToTextView(context, textView, string2, false);
    }

    static boolean applyFontToTextView(Context context, TextView textView, String string2, boolean bl2) {
        if (textView != null && context != null) {
            return CalligraphyUtils.applyFontToTextView(textView, TypefaceUtils.load(context.getAssets(), string2), bl2);
        }
        return false;
    }

    public static boolean applyFontToTextView(TextView textView, Typeface typeface) {
        return CalligraphyUtils.applyFontToTextView(textView, typeface, false);
    }

    public static boolean applyFontToTextView(TextView textView, final Typeface typeface, boolean bl2) {
        if (textView != null && typeface != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 128 | 1);
            textView.setTypeface(typeface);
            if (bl2) {
                textView.setText(CalligraphyUtils.applyTypefaceSpan(textView.getText(), typeface), TextView.BufferType.SPANNABLE);
                textView.addTextChangedListener(new TextWatcher(){

                    public void afterTextChanged(Editable editable) {
                        CalligraphyUtils.applyTypefaceSpan((CharSequence)editable, typeface);
                    }

                    public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                    }

                    public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                    }
                });
            }
            return true;
        }
        return false;
    }

    public static CharSequence applyTypefaceSpan(CharSequence charSequence, Typeface typeface) {
        CharSequence charSequence2 = charSequence;
        if (charSequence != null) {
            charSequence2 = charSequence;
            if (charSequence.length() > 0) {
                charSequence2 = charSequence;
                if (!(charSequence instanceof Spannable)) {
                    charSequence2 = new SpannableString(charSequence);
                }
                ((Spannable)charSequence2).setSpan((Object)TypefaceUtils.getSpan(typeface), 0, charSequence2.length(), 33);
            }
        }
        return charSequence2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean canAddV7AppCompatViews() {
        if (sAppCompatViewCheck != null) return sAppCompatViewCheck;
        try {
            Class.forName("androidx.appcompat.widget.AppCompatTextView");
            sAppCompatViewCheck = Boolean.TRUE;
            return sAppCompatViewCheck;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        sAppCompatViewCheck = Boolean.FALSE;
        return sAppCompatViewCheck;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean canCheckForV7Toolbar() {
        if (sToolbarCheck != null) return sToolbarCheck;
        try {
            Class.forName("androidx.appcompat.widget.Toolbar");
            sToolbarCheck = Boolean.TRUE;
            return sToolbarCheck;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        sToolbarCheck = Boolean.FALSE;
        return sToolbarCheck;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static String pullFontPathFromStyle(Context var0, AttributeSet var1_1, int[] var2_4) {
        if (var2_5 == null) ** GOTO lbl17
        if (var1_1 /* !! */  == null) {
            return null;
        }
        if ((var0 = var0.obtainStyledAttributes(var1_1 /* !! */ , (int[])var2_5)) == null) ** GOTO lbl17
        try {
            var1_2 = var0.getString(0);
            var3_6 = TextUtils.isEmpty((CharSequence)var1_2);
            ** if (var3_6) goto lbl-1000
        }
        catch (Throwable var1_3) {
            var0.recycle();
            throw var1_3;
        }
lbl-1000: // 1 sources:
        {
            var0.recycle();
            return var1_2;
        }
lbl-1000: // 1 sources:
        {
        }
lbl15: // 2 sources:
        do {
            var0.recycle();
lbl17: // 3 sources:
            return null;
            break;
        } while (true);
        catch (Exception var1_4) {
            ** continue;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static String pullFontPathFromTextAppearance(Context var0, AttributeSet var1_3, int[] var2_6) {
        block10 : {
            if (var2_8 == null) ** GOTO lbl28
            if (var1_3 /* !! */  == null) {
                return null;
            }
            var1_4 = var0.obtainStyledAttributes(var1_3 /* !! */ , CalligraphyUtils.ANDROID_ATTR_TEXT_APPEARANCE);
            var3_9 = -1;
            if (var1_4 != null) {
                try {
                    var3_9 = var1_4.getResourceId(0, -1);
                }
                catch (Throwable var0_1) {
                    var1_4.recycle();
                    throw var0_1;
                }
                var1_4.recycle();
                break block10;
lbl14: // 1 sources:
                do {
                    var1_4.recycle();
                    return null;
                    break;
                } while (true);
            }
        }
        if ((var0 = var0.obtainStyledAttributes(var3_9, (int[])var2_8)) == null) ** GOTO lbl28
        try {
            var1_5 = var0.getString(0);
        }
        catch (Throwable var1_6) {
            var0.recycle();
            throw var1_6;
        }
        var0.recycle();
        return var1_5;
lbl26: // 1 sources:
        do {
            var0.recycle();
lbl28: // 3 sources:
            return null;
            break;
        } while (true);
        catch (Exception var0_2) {
            ** continue;
        }
        catch (Exception var1_7) {
            ** continue;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static String pullFontPathFromTheme(Context var0, int var1_3, int var2_4, int[] var3_5) {
        if (var1_3 == -1) ** GOTO lbl29
        if (var3_5 /* !! */  == null) {
            return null;
        }
        var4_9 = var0.getTheme();
        var5_10 = new TypedValue();
        var4_9.resolveAttribute(var1_3, var5_10, true);
        var4_9 = var4_9.obtainStyledAttributes(var5_10.resourceId, new int[]{var2_4});
        var1_3 = var4_9.getResourceId(0, -1);
        var4_9.recycle();
        if (var1_3 == -1) {
            return null;
        }
        if ((var0 = var0.obtainStyledAttributes(var1_3, var3_5 /* !! */ )) == null) ** GOTO lbl23
        try {
            var3_6 = var0.getString(0);
        }
        catch (Throwable var3_7) {
            var0.recycle();
            throw var3_7;
        }
        var0.recycle();
        return var3_6;
lbl21: // 1 sources:
        do {
            var0.recycle();
lbl23: // 2 sources:
            return null;
            break;
        } while (true);
        catch (Throwable var0_1) {
            var4_9.recycle();
            throw var0_1;
        }
lbl27: // 1 sources:
        do {
            var4_9.recycle();
lbl29: // 2 sources:
            return null;
            break;
        } while (true);
        catch (Exception var0_2) {
            ** continue;
        }
        catch (Exception var3_8) {
            ** continue;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static String pullFontPathFromTheme(Context var0, int var1_1, int[] var2_2) {
        if (var1_1 == -1) ** GOTO lbl17
        if (var2_2 /* !! */  == null) {
            return null;
        }
        var0 = var0.getTheme();
        var3_6 = new TypedValue();
        var0.resolveAttribute(var1_1, var3_6, true);
        var0 = var0.obtainStyledAttributes(var3_6.resourceId, var2_2 /* !! */ );
        try {
            var2_3 = var0.getString(0);
        }
        catch (Throwable var2_4) {
            var0.recycle();
            throw var2_4;
        }
        var0.recycle();
        return var2_3;
lbl15: // 1 sources:
        do {
            var0.recycle();
lbl17: // 2 sources:
            return null;
            break;
        } while (true);
        catch (Exception var2_5) {
            ** continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static String pullFontPathFromView(Context context, AttributeSet attributeSet, int[] object) {
        if (object == null) return null;
        if (attributeSet == null) {
            return null;
        }
        try {
            object = context.getResources().getResourceEntryName((int)object[0]);
        }
        catch (Resources.NotFoundException notFoundException) {
            return null;
        }
        int n2 = attributeSet.getAttributeResourceValue(null, (String)object, -1);
        if (n2 <= 0) return attributeSet.getAttributeValue(null, (String)object);
        return context.getString(n2);
    }

}

