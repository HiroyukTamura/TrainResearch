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

public final class PrefBeaconData_ extends SharedPreferencesHelper
{
    public PrefBeaconData_(final Context context) {
        super(context.getSharedPreferences("PrefBeaconData", 0));
    }
    
    public PrefBeaconDataEditor_ edit() {
        return new PrefBeaconDataEditor_(this.getSharedPreferences());
    }
    
    public BooleanPrefField isEntered() {
        return this.booleanField("isEntered", false);
    }
    
    public static final class PrefBeaconDataEditor_ extends EditorHelper<PrefBeaconDataEditor_>
    {
        PrefBeaconDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public BooleanPrefEditorField<PrefBeaconDataEditor_> isEntered() {
            return (BooleanPrefEditorField<PrefBeaconDataEditor_>)this.booleanField("isEntered");
        }
    }
}
