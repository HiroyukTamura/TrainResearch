package p043jp.reifrontier.gym.domain.silentlog;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1014x5da4d90;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGTrainEntity;", "Lio/realm/RealmObject;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "stations", "getStations", "setStations", "trains", "getTrains", "setTrains", "updateTime", "", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGTrainEntity */
public class RFGTrainEntity extends RealmObject implements C1014x5da4d90 {
    @PrimaryKey

    /* renamed from: id */
    private String f720id;
    private String stations;
    private String trains;
    private long updateTime;

    public RFGTrainEntity() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$id(uuid);
        realmSet$stations("");
        realmSet$trains("");
    }

    public String getId() {
        return realmGet$id();
    }

    public String getStations() {
        return realmGet$stations();
    }

    public String getTrains() {
        return realmGet$trains();
    }

    public long getUpdateTime() {
        return realmGet$updateTime();
    }

    public String realmGet$id() {
        return this.f720id;
    }

    public String realmGet$stations() {
        return this.stations;
    }

    public String realmGet$trains() {
        return this.trains;
    }

    public long realmGet$updateTime() {
        return this.updateTime;
    }

    public void realmSet$id(String str) {
        this.f720id = str;
    }

    public void realmSet$stations(String str) {
        this.stations = str;
    }

    public void realmSet$trains(String str) {
        this.trains = str;
    }

    public void realmSet$updateTime(long j) {
        this.updateTime = j;
    }

    public void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$id(str);
    }

    public void setStations(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$stations(str);
    }

    public void setTrains(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$trains(str);
    }

    public void setUpdateTime(long j) {
        realmSet$updateTime(j);
    }
}
