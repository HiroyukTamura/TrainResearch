// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.api.sharedpreferences.BooleanPrefEditorField;
import org.androidannotations.api.sharedpreferences.StringPrefEditorField;
import android.content.SharedPreferences;
import org.androidannotations.api.sharedpreferences.EditorHelper;
import org.androidannotations.api.sharedpreferences.BooleanPrefField;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import android.content.Context;
import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;

public final class PrefAppPotAccount_ extends SharedPreferencesHelper
{
    public PrefAppPotAccount_(final Context context) {
        super(context.getSharedPreferences("PrefAppPotAccount", 0));
    }
    
    public StringPrefField apppotPassword() {
        return this.stringField("apppotPassword", "");
    }
    
    public StringPrefField apppotUserId() {
        return this.stringField("apppotUserId", "");
    }
    
    public PrefAppPotAccountEditor_ edit() {
        return new PrefAppPotAccountEditor_(this.getSharedPreferences());
    }
    
    public BooleanPrefField isSaved() {
        return this.booleanField("isSaved", false);
    }
    
    public StringPrefField loginToken() {
        return this.stringField("loginToken", "");
    }
    
    public static final class PrefAppPotAccountEditor_ extends EditorHelper<PrefAppPotAccountEditor_>
    {
        PrefAppPotAccountEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public StringPrefEditorField<PrefAppPotAccountEditor_> apppotPassword() {
            return (StringPrefEditorField<PrefAppPotAccountEditor_>)this.stringField("apppotPassword");
        }
        
        public StringPrefEditorField<PrefAppPotAccountEditor_> apppotUserId() {
            return (StringPrefEditorField<PrefAppPotAccountEditor_>)this.stringField("apppotUserId");
        }
        
        public BooleanPrefEditorField<PrefAppPotAccountEditor_> isSaved() {
            return (BooleanPrefEditorField<PrefAppPotAccountEditor_>)this.booleanField("isSaved");
        }
        
        public StringPrefEditorField<PrefAppPotAccountEditor_> loginToken() {
            return (StringPrefEditorField<PrefAppPotAccountEditor_>)this.stringField("loginToken");
        }
    }
}
