// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.BooleanPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.BooleanPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefAppStatus_ extends SharedPreferencesHelper
{
    public PrefAppStatus_(final Context context) {
        super(context.getSharedPreferences("PrefAppStatus", 0));
    }
    
    public PrefAppStatusEditor_ edit() {
        return new PrefAppStatusEditor_(this.getSharedPreferences());
    }
    
    public BooleanPrefField isFirstOpenApp() {
        return this.booleanField("isFirstOpenApp", true);
    }
    
    public static final class PrefAppStatusEditor_ extends EditorHelper<PrefAppStatusEditor_>
    {
        PrefAppStatusEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public BooleanPrefEditorField<PrefAppStatusEditor_> isFirstOpenApp() {
            return (BooleanPrefEditorField<PrefAppStatusEditor_>)this.booleanField("isFirstOpenApp");
        }
    }
}
