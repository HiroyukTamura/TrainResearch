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

public final class PrefTrafficCardData_ extends SharedPreferencesHelper
{
    public PrefTrafficCardData_(final Context context) {
        super(context.getSharedPreferences("PrefTrafficCardData", 0));
    }
    
    public PrefTrafficCardDataEditor_ edit() {
        return new PrefTrafficCardDataEditor_(this.getSharedPreferences());
    }
    
    public StringPrefField firstCard() {
        return this.stringField("firstCard", "");
    }
    
    public StringPrefField secondCard() {
        return this.stringField("secondCard", "");
    }
    
    public static final class PrefTrafficCardDataEditor_ extends EditorHelper<PrefTrafficCardDataEditor_>
    {
        PrefTrafficCardDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefTrafficCardDataEditor_> firstCard() {
            return (StringPrefEditorField<PrefTrafficCardDataEditor_>)this.stringField("firstCard");
        }
        
        public StringPrefEditorField<PrefTrafficCardDataEditor_> secondCard() {
            return (StringPrefEditorField<PrefTrafficCardDataEditor_>)this.stringField("secondCard");
        }
    }
}
