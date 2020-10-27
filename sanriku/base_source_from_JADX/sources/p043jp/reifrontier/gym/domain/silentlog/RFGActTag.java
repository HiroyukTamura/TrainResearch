package p043jp.reifrontier.gym.domain.silentlog;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxyInterface;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGActTag;", "Lio/realm/RealmObject;", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "owner", "getOwner", "setOwner", "type", "getType", "setType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGActTag */
public class RFGActTag extends RealmObject implements jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxyInterface {
    @SerializedName("tagName")
    private String name;
    @SerializedName("tagOwner")
    private String owner;
    @SerializedName("tagType")
    private String type;

    public RFGActTag() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$name("");
        realmSet$type("");
        realmSet$owner("");
    }

    public String getName() {
        return realmGet$name();
    }

    public String getOwner() {
        return realmGet$owner();
    }

    public String getType() {
        return realmGet$type();
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$owner() {
        return this.owner;
    }

    public String realmGet$type() {
        return this.type;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$owner(String str) {
        this.owner = str;
    }

    public void realmSet$type(String str) {
        this.type = str;
    }

    public void setName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$name(str);
    }

    public void setOwner(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$owner(str);
    }

    public void setType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$type(str);
    }
}
