package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1008xe5813026;
import p041io.realm.RealmList;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p043jp.reifrontier.gym.util.CaledarExKt;
import p043jp.reifrontier.gym.util.CalendarEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u0006%"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "Lio/realm/RealmObject;", "()V", "contents", "Lio/realm/RealmList;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentItem;", "getContents", "()Lio/realm/RealmList;", "setContents", "(Lio/realm/RealmList;)V", "date", "", "getDate", "()I", "setDate", "(I)V", "id", "getId", "setId", "spotType", "getSpotType", "setSpotType", "stationId", "getStationId", "()Ljava/lang/Integer;", "setStationId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "updateAt", "getUpdateAt", "setUpdateAt", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContent */
public class RFGApiContent extends RealmObject implements C1008xe5813026 {
    @SerializedName("contents")
    private RealmList<RFGApiContentItem> contents;
    @SerializedName("date")
    private int date;
    @SerializedName("id")
    @PrimaryKey

    /* renamed from: id */
    private int f718id;
    @SerializedName("spot_type")
    private int spotType;
    @SerializedName("station_id")
    private Integer stationId;
    @SerializedName("title")
    private String title;
    @SerializedName("update_at")
    private int updateAt;

    public RFGApiContent() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$date(CaledarExKt.unixTime(CalendarEx.INSTANCE.now()));
        realmSet$contents(new RealmList());
        realmSet$updateAt(-1);
    }

    public final RealmList<RFGApiContentItem> getContents() {
        return realmGet$contents();
    }

    public final int getDate() {
        return realmGet$date();
    }

    public final int getId() {
        return realmGet$id();
    }

    public final int getSpotType() {
        return realmGet$spotType();
    }

    public final Integer getStationId() {
        return realmGet$stationId();
    }

    public final String getTitle() {
        return realmGet$title();
    }

    public final int getUpdateAt() {
        return realmGet$updateAt();
    }

    public RealmList realmGet$contents() {
        return this.contents;
    }

    public int realmGet$date() {
        return this.date;
    }

    public int realmGet$id() {
        return this.f718id;
    }

    public int realmGet$spotType() {
        return this.spotType;
    }

    public Integer realmGet$stationId() {
        return this.stationId;
    }

    public String realmGet$title() {
        return this.title;
    }

    public int realmGet$updateAt() {
        return this.updateAt;
    }

    public void realmSet$contents(RealmList realmList) {
        this.contents = realmList;
    }

    public void realmSet$date(int i) {
        this.date = i;
    }

    public void realmSet$id(int i) {
        this.f718id = i;
    }

    public void realmSet$spotType(int i) {
        this.spotType = i;
    }

    public void realmSet$stationId(Integer num) {
        this.stationId = num;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public void realmSet$updateAt(int i) {
        this.updateAt = i;
    }

    public final void setContents(RealmList<RFGApiContentItem> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$contents(realmList);
    }

    public final void setDate(int i) {
        realmSet$date(i);
    }

    public final void setId(int i) {
        realmSet$id(i);
    }

    public final void setSpotType(int i) {
        realmSet$spotType(i);
    }

    public final void setStationId(Integer num) {
        realmSet$stationId(num);
    }

    public final void setTitle(String str) {
        realmSet$title(str);
    }

    public final void setUpdateAt(int i) {
        realmSet$updateAt(i);
    }
}
