package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxyInterface;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGHistory;", "Lio/realm/RealmObject;", "()V", "gymId", "", "getGymId", "()Ljava/lang/String;", "setGymId", "(Ljava/lang/String;)V", "height", "getHeight", "setHeight", "historyId", "getHistoryId", "setHistoryId", "updated_at", "updated_at$annotations", "getUpdated_at", "setUpdated_at", "weight", "getWeight", "setWeight", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.RFGHistory */
public class RFGHistory extends RealmObject implements jp_reifrontier_gym_domain_api_RFGHistoryRealmProxyInterface {
    @SerializedName("sl2user_id")
    private String gymId;
    @SerializedName("height")
    private String height;
    @SerializedName("id")
    private String historyId;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("weight")
    private String weight;

    public RFGHistory() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$historyId("");
        realmSet$gymId("");
        realmSet$height(RFGDef.DEFAULT_GYM_ID);
        realmSet$weight(RFGDef.DEFAULT_GYM_ID);
        realmSet$updated_at("");
    }

    public static /* synthetic */ void updated_at$annotations() {
    }

    public String getGymId() {
        return realmGet$gymId();
    }

    public String getHeight() {
        return realmGet$height();
    }

    public String getHistoryId() {
        return realmGet$historyId();
    }

    public String getUpdated_at() {
        return realmGet$updated_at();
    }

    public String getWeight() {
        return realmGet$weight();
    }

    public String realmGet$gymId() {
        return this.gymId;
    }

    public String realmGet$height() {
        return this.height;
    }

    public String realmGet$historyId() {
        return this.historyId;
    }

    public String realmGet$updated_at() {
        return this.updated_at;
    }

    public String realmGet$weight() {
        return this.weight;
    }

    public void realmSet$gymId(String str) {
        this.gymId = str;
    }

    public void realmSet$height(String str) {
        this.height = str;
    }

    public void realmSet$historyId(String str) {
        this.historyId = str;
    }

    public void realmSet$updated_at(String str) {
        this.updated_at = str;
    }

    public void realmSet$weight(String str) {
        this.weight = str;
    }

    public void setGymId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$gymId(str);
    }

    public void setHeight(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$height(str);
    }

    public void setHistoryId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$historyId(str);
    }

    public void setUpdated_at(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$updated_at(str);
    }

    public void setWeight(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$weight(str);
    }
}
