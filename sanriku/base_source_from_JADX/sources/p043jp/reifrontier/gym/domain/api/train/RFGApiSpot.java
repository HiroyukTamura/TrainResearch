package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1010x7e6e613;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p043jp.reifrontier.gym.util.CaledarExKt;
import p043jp.reifrontier.gym.util.CalendarEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "Lio/realm/RealmObject;", "()V", "date", "", "getDate", "()I", "setDate", "(I)V", "id", "getId", "setId", "order", "getOrder", "setOrder", "stationId", "getStationId", "setStationId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "updateAt", "getUpdateAt", "setUpdateAt", "copy", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiSpot */
public class RFGApiSpot extends RealmObject implements C1010x7e6e613 {
    @SerializedName("date")
    private int date;
    @SerializedName("id")
    @PrimaryKey

    /* renamed from: id */
    private int f719id;
    @SerializedName("order")
    private int order;
    @SerializedName("station_id")
    private int stationId;
    @SerializedName("title")
    private String title;
    @SerializedName("update_at")
    private int updateAt;

    public RFGApiSpot() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$date(CaledarExKt.unixTime(CalendarEx.INSTANCE.now()));
        realmSet$title("");
        realmSet$stationId(-1);
        realmSet$updateAt(-1);
    }

    public static /* synthetic */ RFGApiSpot copy$default(RFGApiSpot rFGApiSpot, int i, int i2, String str, int i3, int i4, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                i = rFGApiSpot.realmGet$id();
            }
            if ((i6 & 2) != 0) {
                i2 = rFGApiSpot.realmGet$date();
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                str = rFGApiSpot.realmGet$title();
            }
            String str2 = str;
            if ((i6 & 8) != 0) {
                i3 = rFGApiSpot.realmGet$stationId();
            }
            int i8 = i3;
            if ((i6 & 16) != 0) {
                i4 = rFGApiSpot.realmGet$updateAt();
            }
            int i9 = i4;
            if ((i6 & 32) != 0) {
                i5 = rFGApiSpot.realmGet$order();
            }
            return rFGApiSpot.copy(i, i7, str2, i8, i9, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final RFGApiSpot copy(int i, int i2, String str, int i3, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        RFGApiSpot rFGApiSpot = new RFGApiSpot();
        rFGApiSpot.realmSet$id(i);
        rFGApiSpot.realmSet$date(i2);
        rFGApiSpot.realmSet$title(str);
        rFGApiSpot.realmSet$stationId(i3);
        rFGApiSpot.realmSet$updateAt(i4);
        rFGApiSpot.realmSet$order(i5);
        return rFGApiSpot;
    }

    public final int getDate() {
        return realmGet$date();
    }

    public final int getId() {
        return realmGet$id();
    }

    public final int getOrder() {
        return realmGet$order();
    }

    public final int getStationId() {
        return realmGet$stationId();
    }

    public final String getTitle() {
        return realmGet$title();
    }

    public final int getUpdateAt() {
        return realmGet$updateAt();
    }

    public int realmGet$date() {
        return this.date;
    }

    public int realmGet$id() {
        return this.f719id;
    }

    public int realmGet$order() {
        return this.order;
    }

    public int realmGet$stationId() {
        return this.stationId;
    }

    public String realmGet$title() {
        return this.title;
    }

    public int realmGet$updateAt() {
        return this.updateAt;
    }

    public void realmSet$date(int i) {
        this.date = i;
    }

    public void realmSet$id(int i) {
        this.f719id = i;
    }

    public void realmSet$order(int i) {
        this.order = i;
    }

    public void realmSet$stationId(int i) {
        this.stationId = i;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public void realmSet$updateAt(int i) {
        this.updateAt = i;
    }

    public final void setDate(int i) {
        realmSet$date(i);
    }

    public final void setId(int i) {
        realmSet$id(i);
    }

    public final void setOrder(int i) {
        realmSet$order(i);
    }

    public final void setStationId(int i) {
        realmSet$stationId(i);
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$title(str);
    }

    public final void setUpdateAt(int i) {
        realmSet$updateAt(i);
    }
}
