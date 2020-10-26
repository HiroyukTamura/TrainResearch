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

public final class PrefMyLineData_ extends SharedPreferencesHelper
{
    public PrefMyLineData_(final Context context) {
        super(context.getSharedPreferences("PrefMyLineData", 0));
    }
    
    public PrefMyLineDataEditor_ edit() {
        return new PrefMyLineDataEditor_(this.getSharedPreferences());
    }
    
    public StringPrefField myLineIds() {
        return this.stringField("myLineIds", "");
    }
    
    public static final class PrefMyLineDataEditor_ extends EditorHelper<PrefMyLineDataEditor_>
    {
        PrefMyLineDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefMyLineDataEditor_> myLineIds() {
            return (StringPrefEditorField<PrefMyLineDataEditor_>)this.stringField("myLineIds");
        }
    }
}
