/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.AutoCompleteTextView
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.EditText
 *  android.widget.MultiAutoCompleteTextView
 *  android.widget.RadioButton
 *  android.widget.TextView
 *  android.widget.ToggleButton
 */
package uk.co.chrisjenx.calligraphy;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.l;
import androidx.appcompat.widget.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.R;

public class CalligraphyConfig {
    private static final Map<Class<? extends TextView>, Integer> DEFAULT_STYLES = new HashMap<Class<? extends TextView>, Integer>();
    private static CalligraphyConfig sInstance;
    private final Set<Class<?>> hasTypefaceViews;
    private final int mAttrId;
    private final Map<Class<? extends TextView>, Integer> mClassStyleAttributeMap;
    private final boolean mCustomViewCreation;
    private final boolean mCustomViewTypefaceSupport;
    private final String mFontPath;
    private final boolean mIsFontSet;
    private final boolean mReflection;

    static {
        DEFAULT_STYLES.put(TextView.class, 16842884);
        DEFAULT_STYLES.put(Button.class, 16842824);
        DEFAULT_STYLES.put(EditText.class, 16842862);
        DEFAULT_STYLES.put(AutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(MultiAutoCompleteTextView.class, 16842859);
        DEFAULT_STYLES.put(CheckBox.class, 16842860);
        DEFAULT_STYLES.put(RadioButton.class, 16842878);
        DEFAULT_STYLES.put(ToggleButton.class, 16842827);
        if (CalligraphyUtils.canAddV7AppCompatViews()) {
            CalligraphyConfig.addAppCompatViews();
        }
    }

    protected CalligraphyConfig(Builder builder) {
        this.mIsFontSet = builder.isFontSet;
        this.mFontPath = builder.fontAssetPath;
        this.mAttrId = builder.attrId;
        this.mReflection = builder.reflection;
        this.mCustomViewCreation = builder.customViewCreation;
        this.mCustomViewTypefaceSupport = builder.customViewTypefaceSupport;
        HashMap<Class<? extends TextView>, Integer> hashMap = new HashMap<Class<? extends TextView>, Integer>(DEFAULT_STYLES);
        hashMap.putAll(builder.mStyleClassMap);
        this.mClassStyleAttributeMap = Collections.unmodifiableMap(hashMap);
        this.hasTypefaceViews = Collections.unmodifiableSet(builder.mHasTypefaceClasses);
    }

    private static void addAppCompatViews() {
        DEFAULT_STYLES.put(AppCompatTextView.class, 16842884);
        DEFAULT_STYLES.put(AppCompatButton.class, 16842824);
        DEFAULT_STYLES.put(AppCompatEditText.class, 16842862);
        DEFAULT_STYLES.put(e.class, 16842859);
        DEFAULT_STYLES.put(l.class, 16842859);
        DEFAULT_STYLES.put(g.class, 16842860);
        DEFAULT_STYLES.put(o.class, 16842878);
        DEFAULT_STYLES.put(AppCompatCheckedTextView.class, 16843720);
    }

    public static CalligraphyConfig get() {
        if (sInstance == null) {
            sInstance = new CalligraphyConfig(new Builder());
        }
        return sInstance;
    }

    public static void initDefault(CalligraphyConfig calligraphyConfig) {
        sInstance = calligraphyConfig;
    }

    public int getAttrId() {
        return this.mAttrId;
    }

    Map<Class<? extends TextView>, Integer> getClassStyles() {
        return this.mClassStyleAttributeMap;
    }

    public String getFontPath() {
        return this.mFontPath;
    }

    public boolean isCustomViewCreation() {
        return this.mCustomViewCreation;
    }

    public boolean isCustomViewHasTypeface(View view) {
        return this.hasTypefaceViews.contains(view.getClass());
    }

    public boolean isCustomViewTypefaceSupport() {
        return this.mCustomViewTypefaceSupport;
    }

    boolean isFontSet() {
        return this.mIsFontSet;
    }

    public boolean isReflection() {
        return this.mReflection;
    }

    public static class Builder {
        public static final int INVALID_ATTR_ID = -1;
        private int attrId;
        private boolean customViewCreation;
        private boolean customViewTypefaceSupport;
        private String fontAssetPath;
        private boolean isFontSet;
        private Set<Class<?>> mHasTypefaceClasses;
        private Map<Class<? extends TextView>, Integer> mStyleClassMap;
        private boolean reflection;

        public Builder() {
            boolean bl2 = Build.VERSION.SDK_INT >= 11;
            this.reflection = bl2;
            this.customViewCreation = true;
            this.customViewTypefaceSupport = false;
            this.attrId = R.attr.fontPath;
            this.isFontSet = false;
            this.fontAssetPath = null;
            this.mStyleClassMap = new HashMap<Class<? extends TextView>, Integer>();
            this.mHasTypefaceClasses = new HashSet();
        }

        public Builder addCustomStyle(Class<? extends TextView> class_, int n2) {
            if (class_ != null) {
                if (n2 == 0) {
                    return this;
                }
                this.mStyleClassMap.put(class_, n2);
            }
            return this;
        }

        public Builder addCustomViewWithSetTypeface(Class<?> class_) {
            this.customViewTypefaceSupport = true;
            this.mHasTypefaceClasses.add(class_);
            return this;
        }

        public CalligraphyConfig build() {
            this.isFontSet = TextUtils.isEmpty((CharSequence)this.fontAssetPath) ^ true;
            return new CalligraphyConfig(this);
        }

        public Builder disableCustomViewInflation() {
            this.customViewCreation = false;
            return this;
        }

        public Builder disablePrivateFactoryInjection() {
            this.reflection = false;
            return this;
        }

        public Builder setDefaultFontPath(String string2) {
            this.isFontSet = TextUtils.isEmpty((CharSequence)string2) ^ true;
            this.fontAssetPath = string2;
            return this;
        }

        public Builder setFontAttrId(int n2) {
            this.attrId = n2;
            return this;
        }
    }

}

