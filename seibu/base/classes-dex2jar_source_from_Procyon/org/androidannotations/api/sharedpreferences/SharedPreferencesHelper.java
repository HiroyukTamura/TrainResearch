// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.api.sharedpreferences;

import java.util.Set;
import android.content.SharedPreferences;

public abstract class SharedPreferencesHelper
{
    private final SharedPreferences sharedPreferences;
    
    public SharedPreferencesHelper(final SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
    
    protected BooleanPrefField booleanField(final String s, final boolean b) {
        return new BooleanPrefField(this.sharedPreferences, s, Boolean.valueOf(b));
    }
    
    public final void clear() {
        SharedPreferencesCompat.apply(this.sharedPreferences.edit().clear());
    }
    
    protected FloatPrefField floatField(final String s, final float f) {
        return new FloatPrefField(this.sharedPreferences, s, Float.valueOf(f));
    }
    
    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }
    
    protected IntPrefField intField(final String s, final int i) {
        return new IntPrefField(this.sharedPreferences, s, Integer.valueOf(i));
    }
    
    protected LongPrefField longField(final String s, final long l) {
        return new LongPrefField(this.sharedPreferences, s, Long.valueOf(l));
    }
    
    protected StringPrefField stringField(final String s, final String s2) {
        return new StringPrefField(this.sharedPreferences, s, s2);
    }
    
    protected StringSetPrefField stringSetField(final String s, final Set<String> set) {
        return new StringSetPrefField(this.sharedPreferences, s, (Set)set);
    }
}
