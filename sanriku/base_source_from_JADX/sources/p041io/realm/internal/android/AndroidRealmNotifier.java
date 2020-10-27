package p041io.realm.internal.android;

import android.os.Handler;
import android.os.Looper;
import p041io.realm.internal.Capabilities;
import p041io.realm.internal.Keep;
import p041io.realm.internal.OsSharedRealm;
import p041io.realm.internal.RealmNotifier;

@Keep
/* renamed from: io.realm.internal.android.AndroidRealmNotifier */
public class AndroidRealmNotifier extends RealmNotifier {
    private Handler handler;

    public AndroidRealmNotifier(OsSharedRealm osSharedRealm, Capabilities capabilities) {
        super(osSharedRealm);
        this.handler = capabilities.canDeliverNotification() ? new Handler(Looper.myLooper()) : null;
    }

    public boolean post(Runnable runnable) {
        Handler handler2 = this.handler;
        return handler2 != null && handler2.post(runnable);
    }
}
