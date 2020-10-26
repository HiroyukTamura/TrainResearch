// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import org.androidannotations.api.sharedpreferences.BooleanPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import org.androidannotations.api.sharedpreferences.BooleanPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefAppTestData_ extends SharedPreferencesHelper
{
    public PrefAppTestData_(final Context context) {
        super(context.getSharedPreferences("PrefAppTestData", 0));
    }
    
    public PrefAppTestDataEditor_ edit() {
        return new PrefAppTestDataEditor_(this.getSharedPreferences());
    }
    
    public BooleanPrefField isValidMaintenance() {
        return this.booleanField("isValidMaintenance", true);
    }
    
    public StringPrefField latitude() {
        return this.stringField("latitude", "");
    }
    
    public StringPrefField longitude() {
        return this.stringField("longitude", "");
    }
    
    public static final class PrefAppTestDataEditor_ extends EditorHelper<PrefAppTestDataEditor_>
    {
        PrefAppTestDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public BooleanPrefEditorField<PrefAppTestDataEditor_> isValidMaintenance() {
            return (BooleanPrefEditorField<PrefAppTestDataEditor_>)this.booleanField("isValidMaintenance");
        }
        
        public StringPrefEditorField<PrefAppTestDataEditor_> latitude() {
            return (StringPrefEditorField<PrefAppTestDataEditor_>)this.stringField("latitude");
        }
        
        public StringPrefEditorField<PrefAppTestDataEditor_> longitude() {
            return (StringPrefEditorField<PrefAppTestDataEditor_>)this.stringField("longitude");
        }
    }
}
