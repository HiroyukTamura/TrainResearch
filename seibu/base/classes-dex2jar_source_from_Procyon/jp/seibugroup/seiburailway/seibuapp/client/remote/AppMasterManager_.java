// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.BackgroundExecutor$Task;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorHandler_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import android.content.Context;

public final class AppMasterManager_ extends AppMasterManager
{
    private static AppMasterManager_ instance_;
    private Context context_;
    
    private AppMasterManager_(final Context context_) {
        this.context_ = context_;
    }
    
    public static AppMasterManager_ getInstance_(final Context context) {
        if (AppMasterManager_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (AppMasterManager_.instance_ = new AppMasterManager_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return AppMasterManager_.instance_;
    }
    
    private void init_() {
        this.errorHandlerForUserService = AppRestErrorHandler_.getInstance_(this.context_);
        this.masterAAService = new AppMasterAAService_(this.context_);
        this.init();
    }
    
    @Override
    public void getMaintenance(final DataCallWrapper<Maintenance> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "initial") {
            public void execute() {
                try {
                    AppMasterManager.this.getMaintenance(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getMasterData(final DataCallWrapper<BaseData> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "initial") {
            public void execute() {
                try {
                    AppMasterManager.this.getMasterData(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
}
