// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import com.feilang.mvpproject.data.datasource.DataNotifyEventBus;
import android.support.annotation.CallSuper;
import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorEvent;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.feilang.mvpproject.util.AppEventBus;
import com.feilang.mvpproject.util.ApiEventDispatchUtils;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;

public class BasePresenterClass implements BasePresenter, ApiCallbackable
{
    @Override
    public boolean isCallerSpecific() {
        return false;
    }
    
    @Subscribe
    @Override
    public void onApiEvent(final DataNotifyEvent dataNotifyEvent) {
        while (true) {
            Label_0042: {
                synchronized (this) {
                    if (!this.isCallerSpecific() || dataNotifyEvent.isSameCaller(this)) {
                        if (!dataNotifyEvent.isSucceed()) {
                            break Label_0042;
                        }
                        ApiEventDispatchUtils.dispatchSuccessEvent(this, dataNotifyEvent);
                    }
                    return;
                }
            }
            final DataNotifyEvent dataNotifyEvent2;
            if (dataNotifyEvent2.isSameCaller(this)) {
                AppEventBus.getInstance().post(new AppRestErrorEvent(dataNotifyEvent2.getErrorData(), 0, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        ApiEventDispatchUtils.dispatchFailedEvent(BasePresenterClass.this, dataNotifyEvent2);
                        dialogInterface.dismiss();
                    }
                }));
            }
        }
    }
    
    @CallSuper
    @Override
    public void start() {
    }
    
    @CallSuper
    @Override
    public void startReceiveDataEvent() {
        DataNotifyEventBus.getInstance().register(this);
    }
    
    @CallSuper
    @Override
    public void stop() {
    }
    
    @CallSuper
    @Override
    public void stopReceiveDataEvent() {
        DataNotifyEventBus.getInstance().unregister(this);
        AppEventBus.hideProgress();
    }
}
