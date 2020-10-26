// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMasterData_;
import android.content.Context;

public final class MasterDaoUtils_ extends MasterDaoUtils
{
    private Context context_;
    
    private MasterDaoUtils_(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    public static MasterDaoUtils_ getInstance_(final Context context) {
        return new MasterDaoUtils_(context);
    }
    
    private void init_() {
        this.pref = new PrefMasterData_(this.context_);
        this.context = this.context_;
        this.init();
    }
    
    public void rebind(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
}
