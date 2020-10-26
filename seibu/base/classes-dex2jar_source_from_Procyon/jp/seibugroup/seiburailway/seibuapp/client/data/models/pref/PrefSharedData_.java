// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefSharedData_ extends SharedPreferencesHelper
{
    public PrefSharedData_(final Context context) {
        super(context.getSharedPreferences("PrefSharedData", 0));
    }
    
    public PrefSharedDataEditor_ edit() {
        return new PrefSharedDataEditor_(this.getSharedPreferences());
    }
    
    public StringPrefField sharedCheckInData() {
        return this.stringField("sharedCheckInData", "");
    }
    
    public static final class PrefSharedDataEditor_ extends EditorHelper<PrefSharedDataEditor_>
    {
        PrefSharedDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefSharedDataEditor_> sharedCheckInData() {
            return (StringPrefEditorField<PrefSharedDataEditor_>)this.stringField("sharedCheckInData");
        }
    }
}
