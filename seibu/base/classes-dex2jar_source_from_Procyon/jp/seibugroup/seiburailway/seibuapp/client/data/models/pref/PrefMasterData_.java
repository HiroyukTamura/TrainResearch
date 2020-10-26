// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.IntPrefEditorField;
import org.androidannotations.api.sharedpreferences.LongPrefEditorField;
import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.IntPrefField;
import org.androidannotations.api.sharedpreferences.LongPrefField;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefMasterData_ extends SharedPreferencesHelper
{
    public PrefMasterData_(final Context context) {
        super(context.getSharedPreferences(getLocalClassName(context) + "_PrefMasterData", 0));
    }
    
    private static String getLocalClassName(final Context context) {
        final String packageName = context.getPackageName();
        final String name = context.getClass().getName();
        final int length = packageName.length();
        if (!name.startsWith(packageName) || name.length() <= length || name.charAt(length) != '.') {
            return name;
        }
        return name.substring(length + 1);
    }
    
    public StringPrefField appVersion() {
        return this.stringField("appVersion", "");
    }
    
    public PrefMasterDataEditor_ edit() {
        return new PrefMasterDataEditor_(this.getSharedPreferences());
    }
    
    public LongPrefField expiredTime() {
        return this.longField("expiredTime", 0L);
    }
    
    public StringPrefField releaseDate() {
        return this.stringField("releaseDate", "");
    }
    
    public LongPrefField validPeriod() {
        return this.longField("validPeriod", 0L);
    }
    
    public IntPrefField version() {
        return this.intField("version", 0);
    }
    
    public static final class PrefMasterDataEditor_ extends EditorHelper<PrefMasterDataEditor_>
    {
        PrefMasterDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefMasterDataEditor_> appVersion() {
            return (StringPrefEditorField<PrefMasterDataEditor_>)this.stringField("appVersion");
        }
        
        public LongPrefEditorField<PrefMasterDataEditor_> expiredTime() {
            return (LongPrefEditorField<PrefMasterDataEditor_>)this.longField("expiredTime");
        }
        
        public StringPrefEditorField<PrefMasterDataEditor_> releaseDate() {
            return (StringPrefEditorField<PrefMasterDataEditor_>)this.stringField("releaseDate");
        }
        
        public LongPrefEditorField<PrefMasterDataEditor_> validPeriod() {
            return (LongPrefEditorField<PrefMasterDataEditor_>)this.longField("validPeriod");
        }
        
        public IntPrefEditorField<PrefMasterDataEditor_> version() {
            return (IntPrefEditorField<PrefMasterDataEditor_>)this.intField("version");
        }
    }
}
