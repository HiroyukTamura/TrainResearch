/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Movie
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 */
package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class af
extends Resources {
    private final Resources a;

    public af(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = resources;
    }

    public XmlResourceParser getAnimation(int n2) {
        return this.a.getAnimation(n2);
    }

    public boolean getBoolean(int n2) {
        return this.a.getBoolean(n2);
    }

    public int getColor(int n2) {
        return this.a.getColor(n2);
    }

    public ColorStateList getColorStateList(int n2) {
        return this.a.getColorStateList(n2);
    }

    public Configuration getConfiguration() {
        return this.a.getConfiguration();
    }

    public float getDimension(int n2) {
        return this.a.getDimension(n2);
    }

    public int getDimensionPixelOffset(int n2) {
        return this.a.getDimensionPixelOffset(n2);
    }

    public int getDimensionPixelSize(int n2) {
        return this.a.getDimensionPixelSize(n2);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.a.getDisplayMetrics();
    }

    public Drawable getDrawable(int n2) {
        return this.a.getDrawable(n2);
    }

    public Drawable getDrawable(int n2, Resources.Theme theme) {
        return this.a.getDrawable(n2, theme);
    }

    public Drawable getDrawableForDensity(int n2, int n3) {
        return this.a.getDrawableForDensity(n2, n3);
    }

    public Drawable getDrawableForDensity(int n2, int n3, Resources.Theme theme) {
        return this.a.getDrawableForDensity(n2, n3, theme);
    }

    public float getFraction(int n2, int n3, int n4) {
        return this.a.getFraction(n2, n3, n4);
    }

    public int getIdentifier(String string2, String string3, String string4) {
        return this.a.getIdentifier(string2, string3, string4);
    }

    public int[] getIntArray(int n2) {
        return this.a.getIntArray(n2);
    }

    public int getInteger(int n2) {
        return this.a.getInteger(n2);
    }

    public XmlResourceParser getLayout(int n2) {
        return this.a.getLayout(n2);
    }

    public Movie getMovie(int n2) {
        return this.a.getMovie(n2);
    }

    public String getQuantityString(int n2, int n3) {
        return this.a.getQuantityString(n2, n3);
    }

    public /* varargs */ String getQuantityString(int n2, int n3, Object ... arrobject) {
        return this.a.getQuantityString(n2, n3, arrobject);
    }

    public CharSequence getQuantityText(int n2, int n3) {
        return this.a.getQuantityText(n2, n3);
    }

    public String getResourceEntryName(int n2) {
        return this.a.getResourceEntryName(n2);
    }

    public String getResourceName(int n2) {
        return this.a.getResourceName(n2);
    }

    public String getResourcePackageName(int n2) {
        return this.a.getResourcePackageName(n2);
    }

    public String getResourceTypeName(int n2) {
        return this.a.getResourceTypeName(n2);
    }

    public String getString(int n2) {
        return this.a.getString(n2);
    }

    public /* varargs */ String getString(int n2, Object ... arrobject) {
        return this.a.getString(n2, arrobject);
    }

    public String[] getStringArray(int n2) {
        return this.a.getStringArray(n2);
    }

    public CharSequence getText(int n2) {
        return this.a.getText(n2);
    }

    public CharSequence getText(int n2, CharSequence charSequence) {
        return this.a.getText(n2, charSequence);
    }

    public CharSequence[] getTextArray(int n2) {
        return this.a.getTextArray(n2);
    }

    public void getValue(int n2, TypedValue typedValue, boolean bl2) {
        this.a.getValue(n2, typedValue, bl2);
    }

    public void getValue(String string2, TypedValue typedValue, boolean bl2) {
        this.a.getValue(string2, typedValue, bl2);
    }

    public void getValueForDensity(int n2, int n3, TypedValue typedValue, boolean bl2) {
        this.a.getValueForDensity(n2, n3, typedValue, bl2);
    }

    public XmlResourceParser getXml(int n2) {
        return this.a.getXml(n2);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] arrn) {
        return this.a.obtainAttributes(attributeSet, arrn);
    }

    public TypedArray obtainTypedArray(int n2) {
        return this.a.obtainTypedArray(n2);
    }

    public InputStream openRawResource(int n2) {
        return this.a.openRawResource(n2);
    }

    public InputStream openRawResource(int n2, TypedValue typedValue) {
        return this.a.openRawResource(n2, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int n2) {
        return this.a.openRawResourceFd(n2);
    }

    public void parseBundleExtra(String string2, AttributeSet attributeSet, Bundle bundle) {
        this.a.parseBundleExtra(string2, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.a != null) {
            this.a.updateConfiguration(configuration, displayMetrics);
        }
    }
}

