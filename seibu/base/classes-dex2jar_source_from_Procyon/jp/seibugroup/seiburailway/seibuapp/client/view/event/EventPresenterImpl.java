// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.event;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import java.util.Iterator;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.EventInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import java.util.ArrayList;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

public class EventPresenterImpl extends BasePresenterClass implements EventContract$Presenter
{
    private DeviceDataRepository mDeviceDataRepository;
    private EventContract$View mView;
    
    public EventPresenterImpl(@NonNull final EventContract$View eventContract$View) {
        (this.mView = Preconditions.checkNotNull(eventContract$View)).setPresenter((Object)this);
        this.mDeviceDataRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_EVENT_MESSAGE)
    public void failedEvents() {
        LogUtils.w("API Failed : API_EVENT_MESSAGE ");
    }
    
    public void getEvent() {
        this.mDeviceDataRepository.getEvents(this);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_EVENT_MESSAGE)
    void receiveEvents(final String s, final ArrayList<NoticeMessageData> list) {
        if (list == null) {
            LogUtils.w("API Return Null : API_EVENT_MESSAGE ");
            return;
        }
        final ArrayList<EventInfo> list2 = new ArrayList<EventInfo>();
        final ArrayList<EventInfo> list3 = new ArrayList<EventInfo>();
        for (final NoticeMessageData noticeMessageData : list) {
            final List<String> imageUrlList = noticeMessageData.getImageUrlList();
            final List<String> toUrlList = noticeMessageData.getToUrlList();
            final List<Boolean> viaBrowserList = noticeMessageData.getViaBrowserList();
            if (imageUrlList != null && imageUrlList.size() > 0) {
                final EventInfo eventInfo = new EventInfo();
                eventInfo.setImageUrl(imageUrlList.get(0));
                if (toUrlList != null && toUrlList.size() > 0) {
                    eventInfo.setToUrl(toUrlList.get(0));
                }
                eventInfo.setTitle(noticeMessageData.getTitle());
                if (viaBrowserList != null && viaBrowserList.size() > 0) {
                    eventInfo.setViaBrowser(viaBrowserList.get(0));
                }
                if ("event1".equals(noticeMessageData.getAreaCode())) {
                    list2.add(eventInfo);
                }
                else {
                    list3.add(eventInfo);
                }
            }
        }
        this.mView.setEvent((List)list2, (List)list3);
    }
}
