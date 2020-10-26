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

public final class PrefMyStationData_ extends SharedPreferencesHelper
{
    public PrefMyStationData_(final Context context) {
        super(context.getSharedPreferences("PrefMyStationData", 0));
    }
    
    public PrefMyStationDataEditor_ edit() {
        return new PrefMyStationDataEditor_(this.getSharedPreferences());
    }
    
    public StringPrefField myStation() {
        return this.stringField("myStation", "");
    }
    
    public static final class PrefMyStationDataEditor_ extends EditorHelper<PrefMyStationDataEditor_>
    {
        PrefMyStationDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefMyStationDataEditor_> myStation() {
            return (StringPrefEditorField<PrefMyStationDataEditor_>)this.stringField("myStation");
        }
    }
}
