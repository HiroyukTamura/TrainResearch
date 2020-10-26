// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import org.androidannotations.api.sharedpreferences.IntPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import org.androidannotations.api.sharedpreferences.IntPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefWallPaperData_ extends SharedPreferencesHelper
{
    public PrefWallPaperData_(final Context context) {
        super(context.getSharedPreferences("PrefWallPaperData", 0));
    }
    
    public PrefWallPaperDataEditor_ edit() {
        return new PrefWallPaperDataEditor_(this.getSharedPreferences());
    }
    
    public IntPrefField wallPaperColor() {
        return this.intField("wallPaperColor", 0);
    }
    
    public StringPrefField wallPaperUrl() {
        return this.stringField("wallPaperUrl", "");
    }
    
    public static final class PrefWallPaperDataEditor_ extends EditorHelper<PrefWallPaperDataEditor_>
    {
        PrefWallPaperDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public IntPrefEditorField<PrefWallPaperDataEditor_> wallPaperColor() {
            return (IntPrefEditorField<PrefWallPaperDataEditor_>)this.intField("wallPaperColor");
        }
        
        public StringPrefEditorField<PrefWallPaperDataEditor_> wallPaperUrl() {
            return (StringPrefEditorField<PrefWallPaperDataEditor_>)this.stringField("wallPaperUrl");
        }
    }
}
