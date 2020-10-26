// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import jp.seibugroup.seiburailway.seibuapp.client.remote.AppRestManager;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppRestManager_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import android.content.Context;

public final class StationsRepository_ extends StationsRepository
{
    private static StationsRepository_ instance_;
    private Context context_;
    
    private StationsRepository_(final Context context_) {
        this.context_ = context_;
    }
    
    public static StationsRepository_ getInstance_(final Context context) {
        if (StationsRepository_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (StationsRepository_.instance_ = new StationsRepository_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return StationsRepository_.instance_;
    }
    
    private void init_() {
        this.mRest = (AppRestManager)AppRestManager_.getInstance_(this.context_);
        this.mMaster = MasterDataRepository_.getInstance_(this.context_);
        this.mContext = this.context_;
        this.init();
    }
}
