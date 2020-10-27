package p043jp.reifrontier.gym.data.train.spot;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J^\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u001d¨\u0006,"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContent;", "", "id", "", "date", "title", "", "stationId", "contents", "", "Ljp/reifrontier/gym/data/train/spot/RFGContentItem;", "spotType", "Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "updateAt", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljp/reifrontier/gym/data/train/spot/RFGSpotType;I)V", "getContents", "()Ljava/util/List;", "getDate", "()I", "getId", "getSpotType", "()Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "getStationId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getUpdateAt", "setUpdateAt", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljp/reifrontier/gym/data/train/spot/RFGSpotType;I)Ljp/reifrontier/gym/data/train/spot/RFGContent;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContent */
public final class RFGContent {
    private final List<RFGContentItem> contents;
    private final int date;

    /* renamed from: id */
    private final int f2956id;
    private final RFGSpotType spotType;
    private final Integer stationId;
    private final String title;
    private int updateAt;

    public RFGContent(int i, int i2, String str, Integer num, List<RFGContentItem> list, RFGSpotType rFGSpotType, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "contents");
        Intrinsics.checkParameterIsNotNull(rFGSpotType, "spotType");
        this.f2956id = i;
        this.date = i2;
        this.title = str;
        this.stationId = num;
        this.contents = list;
        this.spotType = rFGSpotType;
        this.updateAt = i3;
    }

    public static /* synthetic */ RFGContent copy$default(RFGContent rFGContent, int i, int i2, String str, Integer num, List<RFGContentItem> list, RFGSpotType rFGSpotType, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rFGContent.f2956id;
        }
        if ((i4 & 2) != 0) {
            i2 = rFGContent.date;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            str = rFGContent.title;
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            num = rFGContent.stationId;
        }
        Integer num2 = num;
        if ((i4 & 16) != 0) {
            list = rFGContent.contents;
        }
        List<RFGContentItem> list2 = list;
        if ((i4 & 32) != 0) {
            rFGSpotType = rFGContent.spotType;
        }
        RFGSpotType rFGSpotType2 = rFGSpotType;
        if ((i4 & 64) != 0) {
            i3 = rFGContent.updateAt;
        }
        return rFGContent.copy(i, i5, str2, num2, list2, rFGSpotType2, i3);
    }

    public final int component1() {
        return this.f2956id;
    }

    public final int component2() {
        return this.date;
    }

    public final String component3() {
        return this.title;
    }

    public final Integer component4() {
        return this.stationId;
    }

    public final List<RFGContentItem> component5() {
        return this.contents;
    }

    public final RFGSpotType component6() {
        return this.spotType;
    }

    public final int component7() {
        return this.updateAt;
    }

    public final RFGContent copy(int i, int i2, String str, Integer num, List<RFGContentItem> list, RFGSpotType rFGSpotType, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "contents");
        Intrinsics.checkParameterIsNotNull(rFGSpotType, "spotType");
        return new RFGContent(i, i2, str, num, list, rFGSpotType, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContent)) {
            return false;
        }
        RFGContent rFGContent = (RFGContent) obj;
        return this.f2956id == rFGContent.f2956id && this.date == rFGContent.date && Intrinsics.areEqual((Object) this.title, (Object) rFGContent.title) && Intrinsics.areEqual((Object) this.stationId, (Object) rFGContent.stationId) && Intrinsics.areEqual((Object) this.contents, (Object) rFGContent.contents) && Intrinsics.areEqual((Object) this.spotType, (Object) rFGContent.spotType) && this.updateAt == rFGContent.updateAt;
    }

    public final List<RFGContentItem> getContents() {
        return this.contents;
    }

    public final int getDate() {
        return this.date;
    }

    public final int getId() {
        return this.f2956id;
    }

    public final RFGSpotType getSpotType() {
        return this.spotType;
    }

    public final Integer getStationId() {
        return this.stationId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUpdateAt() {
        return this.updateAt;
    }

    public int hashCode() {
        int i = ((this.f2956id * 31) + this.date) * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.stationId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<RFGContentItem> list = this.contents;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        RFGSpotType rFGSpotType = this.spotType;
        if (rFGSpotType != null) {
            i2 = rFGSpotType.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.updateAt;
    }

    public final void setUpdateAt(int i) {
        this.updateAt = i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContent(id=");
        a.append(this.f2956id);
        a.append(", date=");
        a.append(this.date);
        a.append(", title=");
        a.append(this.title);
        a.append(", stationId=");
        a.append(this.stationId);
        a.append(", contents=");
        a.append(this.contents);
        a.append(", spotType=");
        a.append(this.spotType);
        a.append(", updateAt=");
        return C0681a.m322a(a, this.updateAt, ")");
    }
}
