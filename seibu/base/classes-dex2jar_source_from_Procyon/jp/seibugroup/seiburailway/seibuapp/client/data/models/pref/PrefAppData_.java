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

public final class PrefAppData_ extends SharedPreferencesHelper
{
    public PrefAppData_(final Context context) {
        super(context.getSharedPreferences("PrefAppData", 0));
    }
    
    public StringPrefField appVersion() {
        return this.stringField("appVersion", "");
    }
    
    public StringPrefField dayStartTime() {
        return this.stringField("dayStartTime", "");
    }
    
    public StringPrefField deviceToken() {
        return this.stringField("deviceToken", "");
    }
    
    public StringPrefField directionNameJson() {
        return this.stringField("directionNameJson", "[]");
    }
    
    public PrefAppDataEditor_ edit() {
        return new PrefAppDataEditor_(this.getSharedPreferences());
    }
    
    public StringPrefField emergIdJson() {
        return this.stringField("emergIdJson", "[]");
    }
    
    public StringPrefField nightStartTime() {
        return this.stringField("nightStartTime", "");
    }
    
    public StringPrefField noticeIdJson() {
        return this.stringField("noticeIdJson", "[]");
    }
    
    public static final class PrefAppDataEditor_ extends EditorHelper<PrefAppDataEditor_>
    {
        PrefAppDataEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> appVersion() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("appVersion");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> dayStartTime() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("dayStartTime");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> deviceToken() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("deviceToken");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> directionNameJson() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("directionNameJson");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> emergIdJson() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("emergIdJson");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> nightStartTime() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("nightStartTime");
        }
        
        public StringPrefEditorField<PrefAppDataEditor_> noticeIdJson() {
            return (StringPrefEditorField<PrefAppDataEditor_>)this.stringField("noticeIdJson");
        }
    }
}
