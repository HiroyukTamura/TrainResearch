package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1002xa3bfb722;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentAccess;", "Lio/realm/RealmObject;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "address", "getAddress", "setAddress", "lat", "", "getLat", "()D", "setLat", "(D)V", "lon", "getLon", "setLon", "pKey", "getPKey", "setPKey", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentAccess */
public class RFGApiContentAccess extends RealmObject implements C1002xa3bfb722 {
    @SerializedName("access")
    private String access;
    @SerializedName("address")
    private String address;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;

    public RFGApiContentAccess() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
        realmSet$lat(35.681236d);
        realmSet$lon(139.767125d);
    }

    public final String getAccess() {
        return realmGet$access();
    }

    public final String getAddress() {
        return realmGet$address();
    }

    public final double getLat() {
        return realmGet$lat();
    }

    public final double getLon() {
        return realmGet$lon();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public String realmGet$access() {
        return this.access;
    }

    public String realmGet$address() {
        return this.address;
    }

    public double realmGet$lat() {
        return this.lat;
    }

    public double realmGet$lon() {
        return this.lon;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public void realmSet$access(String str) {
        this.access = str;
    }

    public void realmSet$address(String str) {
        this.address = str;
    }

    public void realmSet$lat(double d) {
        this.lat = d;
    }

    public void realmSet$lon(double d) {
        this.lon = d;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public final void setAccess(String str) {
        realmSet$access(str);
    }

    public final void setAddress(String str) {
        realmSet$address(str);
    }

    public final void setLat(double d) {
        realmSet$lat(d);
    }

    public final void setLon(double d) {
        realmSet$lon(d);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }
}
