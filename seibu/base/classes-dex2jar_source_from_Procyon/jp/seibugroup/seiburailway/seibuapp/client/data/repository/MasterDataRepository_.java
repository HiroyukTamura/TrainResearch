// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import jp.seibugroup.seiburailway.seibuapp.client.data.db.MasterDaoUtils_;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppMasterManager_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMasterData_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import android.content.Context;

public final class MasterDataRepository_ extends MasterDataRepository
{
    private static MasterDataRepository_ instance_;
    private Context context_;
    
    private MasterDataRepository_(final Context context_) {
        this.context_ = context_;
    }
    
    public static MasterDataRepository_ getInstance_(final Context context) {
        if (MasterDataRepository_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (MasterDataRepository_.instance_ = new MasterDataRepository_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return MasterDataRepository_.instance_;
    }
    
    private void init_() {
        this.prefs = new PrefMasterData_(this.context_);
        this.mMasterManager = AppMasterManager_.getInstance_(this.context_);
        this.mDao = MasterDaoUtils_.getInstance_(this.context_);
        this.mContext = this.context_;
    }
}
