package p043jp.reifrontier.gym.domain.silentlog;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p041io.realm.C1013x5a4bc2b4;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGTrackPoint;", "Lio/realm/RealmObject;", "()V", "accuracy", "", "getAccuracy", "()F", "setAccuracy", "(F)V", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", "timestamp", "", "getTimestamp", "()I", "setTimestamp", "(I)V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGTrackPoint */
public class RFGTrackPoint extends RealmObject implements C1013x5a4bc2b4 {
    @SerializedName("hacc")
    private float accuracy;
    @SerializedName("lat")
    private double latitude;
    @SerializedName("lon")
    private double longitude;
    @SerializedName("updated_at")
    private int timestamp;

    public RFGTrackPoint() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public float getAccuracy() {
        return realmGet$accuracy();
    }

    public double getLatitude() {
        return realmGet$latitude();
    }

    public double getLongitude() {
        return realmGet$longitude();
    }

    public int getTimestamp() {
        return realmGet$timestamp();
    }

    public float realmGet$accuracy() {
        return this.accuracy;
    }

    public double realmGet$latitude() {
        return this.latitude;
    }

    public double realmGet$longitude() {
        return this.longitude;
    }

    public int realmGet$timestamp() {
        return this.timestamp;
    }

    public void realmSet$accuracy(float f) {
        this.accuracy = f;
    }

    public void realmSet$latitude(double d) {
        this.latitude = d;
    }

    public void realmSet$longitude(double d) {
        this.longitude = d;
    }

    public void realmSet$timestamp(int i) {
        this.timestamp = i;
    }

    public void setAccuracy(float f) {
        realmSet$accuracy(f);
    }

    public void setLatitude(double d) {
        realmSet$latitude(d);
    }

    public void setLongitude(double d) {
        realmSet$longitude(d);
    }

    public void setTimestamp(int i) {
        realmSet$timestamp(i);
    }
}
