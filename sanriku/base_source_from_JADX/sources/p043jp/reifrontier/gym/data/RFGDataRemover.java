package p043jp.reifrontier.gym.data;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.RFGApp;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1698d;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1603b;
import p078g.p079a.p080A.p085e.p086a.C1610c;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/RFGDataRemover;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setUp", "Ljp/reifrontier/gym/data/RFGAppSetUp;", "deleteRealm", "", "deleteSharedPref", "deleteWithLogout", "deleteWithoutLogout", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.RFGDataRemover */
public final class RFGDataRemover {
    private RFGAppSetUp setUp;

    public RFGDataRemover(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context applicationContext = context.getApplicationContext();
        RFGApp rFGApp = (RFGApp) (!(applicationContext instanceof RFGApp) ? null : applicationContext);
        if (rFGApp != null) {
            this.setUp = new RFGAppSetUp(rFGApp);
        }
    }

    /* access modifiers changed from: private */
    public final void deleteRealm() {
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.executeTransaction(new RFGDataRemover$deleteRealm$1(defaultInstance));
    }

    /* access modifiers changed from: private */
    public final void deleteSharedPref() {
        RFGShared.INSTANCE.deleteAll();
    }

    @SuppressLint({"CheckResult"})
    public final void deleteWithLogout() {
        C1122a.m1600c("[Gym]::Info Delete All Data with Logout.", new Object[0]);
        RFGAppSetUp rFGAppSetUp = this.setUp;
        if (rFGAppSetUp != null) {
            SilentLogOperation.Companion.getInstance().release().mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGDataRemover$deleteWithLogout$1(this, rFGAppSetUp), RFGDataRemover$deleteWithLogout$2.INSTANCE);
        } else {
            C1122a.m1599b("[Gym]::Error cannot get application instance.", new Object[0]);
        }
    }

    @SuppressLint({"CheckResult"})
    public final void deleteWithoutLogout() {
        C1122a.m1600c("[Gym]::Info Delete All Data without Logout.", new Object[0]);
        RFGAppSetUp rFGAppSetUp = this.setUp;
        if (rFGAppSetUp != null) {
            C1696b a = SilentLogOperation.Companion.getInstance().releaseWithoutLogout().mo27420a(C1683a.m2378b());
            C1711q a2 = C1721a.m2428a();
            C1599b.m2241a(a2, "scheduler is null");
            C1610c cVar = new C1610c(a, a2);
            RFGDataRemover$deleteWithoutLogout$1 rFGDataRemover$deleteWithoutLogout$1 = new RFGDataRemover$deleteWithoutLogout$1(this, rFGAppSetUp);
            RFGDataRemover$deleteWithoutLogout$2 rFGDataRemover$deleteWithoutLogout$2 = RFGDataRemover$deleteWithoutLogout$2.INSTANCE;
            C1599b.m2241a(rFGDataRemover$deleteWithoutLogout$2, "onError is null");
            C1599b.m2241a(rFGDataRemover$deleteWithoutLogout$1, "onComplete is null");
            cVar.mo27423a((C1698d) new C1603b(rFGDataRemover$deleteWithoutLogout$2, rFGDataRemover$deleteWithoutLogout$1));
            return;
        }
        C1122a.m1599b("[Gym]::Error cannot get application instance.", new Object[0]);
    }
}
