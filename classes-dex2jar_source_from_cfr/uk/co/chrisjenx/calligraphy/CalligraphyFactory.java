/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewParent
 *  android.widget.TextView
 */
package uk.co.chrisjenx.calligraphy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.reflect.Method;
import java.util.Map;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.HasTypeface;
import uk.co.chrisjenx.calligraphy.R;
import uk.co.chrisjenx.calligraphy.ReflectionUtils;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

class CalligraphyFactory {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;

    public CalligraphyFactory(int n2) {
        this.mAttributeId = new int[]{n2};
    }

    private void applyFontToToolbar(Toolbar toolbar) {
        CharSequence charSequence = toolbar.getTitle();
        CharSequence charSequence2 = toolbar.getSubtitle();
        toolbar.setTitle(" ");
        toolbar.setSubtitle(" ");
        int n2 = toolbar.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.onViewCreated(toolbar.getChildAt(i2), toolbar.getContext(), null);
        }
        toolbar.setTitle(charSequence);
        toolbar.setSubtitle(charSequence2);
    }

    private Typeface getDefaultTypeface(Context context, String string2) {
        String string3 = string2;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string3 = CalligraphyConfig.get().getFontPath();
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            return TypefaceUtils.load(context.getAssets(), string3);
        }
        return null;
    }

    protected static int[] getStyleForTextView(TextView textView) {
        int[] arrn;
        int[] arrn2 = arrn = new int[2];
        arrn2[0] = -1;
        arrn2[1] = -1;
        if (CalligraphyFactory.isActionBarTitle(textView)) {
            arrn[0] = 16843470;
            arrn[1] = 16843512;
        } else if (CalligraphyFactory.isActionBarSubTitle(textView)) {
            arrn[0] = 16843470;
            arrn[1] = 16843513;
        }
        if (arrn[0] == -1) {
            int n2 = CalligraphyConfig.get().getClassStyles().containsKey(textView.getClass()) ? CalligraphyConfig.get().getClassStyles().get(textView.getClass()) : 16842804;
            arrn[0] = n2;
        }
        return arrn;
    }

    @SuppressLint(value={"NewApi"})
    protected static boolean isActionBarSubTitle(TextView textView) {
        if (CalligraphyFactory.matchesResourceIdName((View)textView, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (CalligraphyFactory.parentIsToolbarV7((View)textView)) {
            return TextUtils.equals((CharSequence)((Toolbar)textView.getParent()).getSubtitle(), (CharSequence)textView.getText());
        }
        return false;
    }

    @SuppressLint(value={"NewApi"})
    protected static boolean isActionBarTitle(TextView textView) {
        if (CalligraphyFactory.matchesResourceIdName((View)textView, ACTION_BAR_TITLE)) {
            return true;
        }
        if (CalligraphyFactory.parentIsToolbarV7((View)textView)) {
            return TextUtils.equals((CharSequence)((Toolbar)textView.getParent()).getTitle(), (CharSequence)textView.getText());
        }
        return false;
    }

    protected static boolean matchesResourceIdName(View view, String string2) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(string2);
    }

    protected static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && view.getParent() instanceof Toolbar;
    }

    private String resolveFontPath(Context context, AttributeSet attributeSet) {
        String string2;
        String string3 = string2 = CalligraphyUtils.pullFontPathFromView(context, attributeSet, this.mAttributeId);
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string3 = CalligraphyUtils.pullFontPathFromStyle(context, attributeSet, this.mAttributeId);
        }
        string2 = string3;
        if (TextUtils.isEmpty((CharSequence)string3)) {
            string2 = CalligraphyUtils.pullFontPathFromTextAppearance(context, attributeSet, this.mAttributeId);
        }
        return string2;
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) {
        if (view != null && view.getTag(R.id.calligraphy_tag_id) != Boolean.TRUE) {
            this.onViewCreatedInternal(view, context, attributeSet);
            view.setTag(R.id.calligraphy_tag_id, (Object)Boolean.TRUE);
        }
        return view;
    }

    void onViewCreatedInternal(View view, Context context, AttributeSet attributeSet) {
        Object object;
        if (view instanceof TextView) {
            TextView textView = (TextView)view;
            if (TypefaceUtils.isLoaded(textView.getTypeface())) {
                return;
            }
            String string2 = this.resolveFontPath(context, attributeSet);
            object = string2;
            if (TextUtils.isEmpty((CharSequence)string2)) {
                object = CalligraphyFactory.getStyleForTextView(textView);
                object = object[1] != -1 ? CalligraphyUtils.pullFontPathFromTheme(context, object[0], object[1], this.mAttributeId) : CalligraphyUtils.pullFontPathFromTheme(context, object[0], this.mAttributeId);
            }
            boolean bl2 = CalligraphyFactory.matchesResourceIdName(view, ACTION_BAR_TITLE) || CalligraphyFactory.matchesResourceIdName(view, ACTION_BAR_SUBTITLE);
            CalligraphyUtils.applyFontToTextView(context, textView, CalligraphyConfig.get(), (String)object, bl2);
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && view instanceof Toolbar) {
            this.applyFontToToolbar((Toolbar)view);
        }
        if (view instanceof HasTypeface) {
            if ((context = this.getDefaultTypeface(context, this.resolveFontPath(context, attributeSet))) != null) {
                ((HasTypeface)view).setTypeface((Typeface)context);
                return;
            }
        } else if (CalligraphyConfig.get().isCustomViewTypefaceSupport() && CalligraphyConfig.get().isCustomViewHasTypeface(view)) {
            object = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            context = this.getDefaultTypeface(context, this.resolveFontPath(context, attributeSet));
            if (object != null && context != null) {
                ReflectionUtils.invokeMethod((Object)view, (Method)object, new Object[]{context});
            }
        }
    }
}

