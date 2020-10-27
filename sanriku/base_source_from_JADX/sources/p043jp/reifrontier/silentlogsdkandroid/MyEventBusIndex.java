package p043jp.reifrontier.silentlogsdkandroid;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.p132s.C2631a;
import org.greenrobot.eventbus.p132s.C2632b;
import org.greenrobot.eventbus.p132s.C2633c;
import org.greenrobot.eventbus.p132s.C2634d;
import p043jp.reifrontier.silentlogsdkandroid.bus.ActiveMode;
import p043jp.reifrontier.silentlogsdkandroid.bus.InvalidToken;
import p043jp.reifrontier.silentlogsdkandroid.bus.PostDaily;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;

/* renamed from: jp.reifrontier.silentlogsdkandroid.MyEventBusIndex */
public class MyEventBusIndex implements C2633c {

    /* renamed from: a */
    private static final Map<Class<?>, C2632b> f2967a = new HashMap();

    static {
        Class<ActiveMode> cls = ActiveMode.class;
        m3643a(new C2631a(RFLSilentLogOperation.class, true, new C2634d[]{new C2634d("onReceiveInvalidToken", InvalidToken.class, ThreadMode.MAIN)}));
        m3643a(new C2631a(RFLDailyManager.class, true, new C2634d[]{new C2634d("onReceivePostDaily", PostDaily.class, ThreadMode.MAIN)}));
        m3643a(new C2631a(RFLAdManager.class, true, new C2634d[]{new C2634d("onReceiveActiveMode", cls)}));
        m3643a(new C2631a(RFLLocationManager.class, true, new C2634d[]{new C2634d("onReceiveActiveMode", cls, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m3643a(C2632b bVar) {
        f2967a.put(bVar.mo35660c(), bVar);
    }

    public C2632b getSubscriberInfo(Class<?> cls) {
        C2632b bVar = f2967a.get(cls);
        if (bVar != null) {
            return bVar;
        }
        return null;
    }
}
