package p043jp.reifrontier.gym.domain.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1011x6905d40d;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGParameterBadge;", "Lio/realm/RealmObject;", "()V", "parameterId", "", "getParameterId", "()Ljava/lang/String;", "setParameterId", "(Ljava/lang/String;)V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.app.RFGParameterBadge */
public class RFGParameterBadge extends RealmObject implements C1011x6905d40d {
    private String parameterId;

    public RFGParameterBadge() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$parameterId("");
    }

    public String getParameterId() {
        return realmGet$parameterId();
    }

    public String realmGet$parameterId() {
        return this.parameterId;
    }

    public void realmSet$parameterId(String str) {
        this.parameterId = str;
    }

    public void setParameterId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$parameterId(str);
    }
}
