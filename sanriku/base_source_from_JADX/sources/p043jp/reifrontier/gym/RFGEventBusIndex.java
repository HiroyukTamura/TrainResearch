package p043jp.reifrontier.gym;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.p132s.C2631a;
import org.greenrobot.eventbus.p132s.C2632b;
import org.greenrobot.eventbus.p132s.C2633c;
import org.greenrobot.eventbus.p132s.C2634d;
import p043jp.reifrontier.gym.activity.RFGInitActivity;
import p043jp.reifrontier.gym.activity.RFGMainActivity;
import p043jp.reifrontier.gym.activity.RFGPasswordActivity;
import p043jp.reifrontier.gym.data.bus.RFGCompletedRemoveData;
import p043jp.reifrontier.gym.data.bus.RFGConnectSilentLog;
import p043jp.reifrontier.gym.data.bus.RFGSelectedStation;
import p043jp.reifrontier.gym.data.bus.RFGUnauthorize;
import p043jp.reifrontier.gym.data.bus.RFGUpdatePassword;
import p043jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment;
import p043jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;

/* renamed from: jp.reifrontier.gym.RFGEventBusIndex */
public class RFGEventBusIndex implements C2633c {
    private static final Map<Class<?>, C2632b> SUBSCRIBER_INDEX = new HashMap();

    static {
        putIndex(new C2631a(RFGScheduleMapFragment.class, true, new C2634d[]{new C2634d("onCompletedRealtimeRequest", RFGScheduleMapFragment.OnCompletedRealtimeRequest.class)}));
        putIndex(new C2631a(RFGPasswordActivity.class, true, new C2634d[]{new C2634d("onReceiveUpdate", RFGUpdatePassword.class, ThreadMode.MAIN)}));
        putIndex(new C2631a(RFGSpotDetailFragment.class, true, new C2634d[]{new C2634d("onCompletedSpotDetailRequest", RFGSpotDetailFragment.OnCompletedSpotDetailRequest.class)}));
        putIndex(new C2631a(RFGMainActivity.class, true, new C2634d[]{new C2634d("onReceiveUpdate", RFGUnauthorize.class, ThreadMode.MAIN), new C2634d("onSelectedStation", RFGSelectedStation.class, ThreadMode.MAIN), new C2634d("onCompletedRemoveData", RFGCompletedRemoveData.class)}));
        putIndex(new C2631a(RFGInitActivity.class, true, new C2634d[]{new C2634d("onReceiveConnect", RFGConnectSilentLog.class, ThreadMode.MAIN)}));
        putIndex(new C2631a(RFGSpotListFragment.class, true, new C2634d[]{new C2634d("onSelectedOrder", RFGSpotListFragment.OnSelectedOrder.class), new C2634d("onSelectedStation", RFGSpotListFragment.OnSelectedStation.class)}));
    }

    private static void putIndex(C2632b bVar) {
        SUBSCRIBER_INDEX.put(bVar.mo35660c(), bVar);
    }

    public C2632b getSubscriberInfo(Class<?> cls) {
        C2632b bVar = SUBSCRIBER_INDEX.get(cls);
        if (bVar != null) {
            return bVar;
        }
        return null;
    }
}
