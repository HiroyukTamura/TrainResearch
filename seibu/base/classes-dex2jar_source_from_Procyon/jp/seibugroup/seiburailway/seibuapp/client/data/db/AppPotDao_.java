// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import org.androidannotations.api.view.OnViewChangedNotifier;
import android.content.Context;

public final class AppPotDao_ extends AppPotDao
{
    private static AppPotDao_ instance_;
    private Context context_;
    
    private AppPotDao_(final Context context_) {
        this.context_ = context_;
    }
    
    public static AppPotDao_ getInstance_(final Context context) {
        if (AppPotDao_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (AppPotDao_.instance_ = new AppPotDao_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return AppPotDao_.instance_;
    }
    
    private void init_() {
    }
}
