// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client;

import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;

public final class CTCApplication_ extends CTCApplication
{
    private static CTCApplication INSTANCE_;
    
    public static CTCApplication getInstance() {
        return CTCApplication_.INSTANCE_;
    }
    
    private void init_() {
        this.mPrefAppData = new PrefAppData_((Context)this);
    }
    
    public static void setForTesting(final CTCApplication instance_) {
        CTCApplication_.INSTANCE_ = instance_;
    }
    
    @Override
    public void onCreate() {
        ((CTCApplication_)(CTCApplication_.INSTANCE_ = this)).init_();
        super.onCreate();
    }
}
