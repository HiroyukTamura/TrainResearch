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

public final class PrefTrainPosition_ extends SharedPreferencesHelper
{
    public PrefTrainPosition_(final Context context) {
        super(context.getSharedPreferences("PrefTrainPosition", 0));
    }
    
    public PrefTrainPositionEditor_ edit() {
        return new PrefTrainPositionEditor_(this.getSharedPreferences());
    }
    
    public BooleanPrefField isShowTrainType() {
        return this.booleanField("isShowTrainType", false);
    }
    
    public StringPrefField lineId() {
        return this.stringField("lineId", "");
    }
    
    public static final class PrefTrainPositionEditor_ extends EditorHelper<PrefTrainPositionEditor_>
    {
        PrefTrainPositionEditor_(final SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }
        
        public BooleanPrefEditorField<PrefTrainPositionEditor_> isShowTrainType() {
            return (BooleanPrefEditorField<PrefTrainPositionEditor_>)this.booleanField("isShowTrainType");
        }
        
        public StringPrefEditorField<PrefTrainPositionEditor_> lineId() {
            return (StringPrefEditorField<PrefTrainPositionEditor_>)this.stringField("lineId");
        }
    }
}
