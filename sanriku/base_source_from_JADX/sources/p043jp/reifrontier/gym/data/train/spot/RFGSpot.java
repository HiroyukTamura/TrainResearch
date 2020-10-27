package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "", "id", "", "date", "title", "", "stationId", "updateAt", "(IILjava/lang/String;II)V", "getDate", "()I", "setDate", "(I)V", "getId", "setId", "getStationId", "setStationId", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getUpdateAt", "setUpdateAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGSpot */
public final class RFGSpot {
    private int date;

    /* renamed from: id */
    private int f2957id;
    private int stationId;
    private String title;
    private int updateAt;

    public RFGSpot(int i, int i2, String str, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        this.f2957id = i;
        this.date = i2;
        this.title = str;
        this.stationId = i3;
        this.updateAt = i4;
    }

    public static /* synthetic */ RFGSpot copy$default(RFGSpot rFGSpot, int i, int i2, String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = rFGSpot.f2957id;
        }
        if ((i5 & 2) != 0) {
            i2 = rFGSpot.date;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            str = rFGSpot.title;
        }
        String str2 = str;
        if ((i5 & 8) != 0) {
            i3 = rFGSpot.stationId;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = rFGSpot.updateAt;
        }
        return rFGSpot.copy(i, i6, str2, i7, i4);
    }

    public final int component1() {
        return this.f2957id;
    }

    public final int component2() {
        return this.date;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.stationId;
    }

    public final int component5() {
        return this.updateAt;
    }

    public final RFGSpot copy(int i, int i2, String str, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        return new RFGSpot(i, i2, str, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGSpot)) {
            return false;
        }
        RFGSpot rFGSpot = (RFGSpot) obj;
        return this.f2957id == rFGSpot.f2957id && this.date == rFGSpot.date && Intrinsics.areEqual((Object) this.title, (Object) rFGSpot.title) && this.stationId == rFGSpot.stationId && this.updateAt == rFGSpot.updateAt;
    }

    public final int getDate() {
        return this.date;
    }

    public final int getId() {
        return this.f2957id;
    }

    public final int getStationId() {
        return this.stationId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUpdateAt() {
        return this.updateAt;
    }

    public int hashCode() {
        int i = ((this.f2957id * 31) + this.date) * 31;
        String str = this.title;
        return ((((i + (str != null ? str.hashCode() : 0)) * 31) + this.stationId) * 31) + this.updateAt;
    }

    public final void setDate(int i) {
        this.date = i;
    }

    public final void setId(int i) {
        this.f2957id = i;
    }

    public final void setStationId(int i) {
        this.stationId = i;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final void setUpdateAt(int i) {
        this.updateAt = i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGSpot(id=");
        a.append(this.f2957id);
        a.append(", date=");
        a.append(this.date);
        a.append(", title=");
        a.append(this.title);
        a.append(", stationId=");
        a.append(this.stationId);
        a.append(", updateAt=");
        return C0681a.m322a(a, this.updateAt, ")");
    }
}
