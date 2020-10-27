package p043jp.reifrontier.gym.data.train.spot;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003J_\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentItem;", "", "title", "Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;", "note", "Ljp/reifrontier/gym/data/train/spot/RFGContentNote;", "image", "Ljp/reifrontier/gym/data/train/spot/RFGContentImage;", "access", "Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "infoList", "", "Ljp/reifrontier/gym/data/train/spot/RFGContentInfo;", "button", "Ljp/reifrontier/gym/data/train/spot/RFGContentButton;", "order", "", "(Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;Ljp/reifrontier/gym/data/train/spot/RFGContentNote;Ljp/reifrontier/gym/data/train/spot/RFGContentImage;Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;Ljava/util/List;Ljp/reifrontier/gym/data/train/spot/RFGContentButton;I)V", "getAccess", "()Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "getButton", "()Ljp/reifrontier/gym/data/train/spot/RFGContentButton;", "getImage", "()Ljp/reifrontier/gym/data/train/spot/RFGContentImage;", "getInfoList", "()Ljava/util/List;", "getNote", "()Ljp/reifrontier/gym/data/train/spot/RFGContentNote;", "getOrder", "()I", "getTitle", "()Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentItem */
public final class RFGContentItem {
    private final RFGContentAccess access;
    private final RFGContentButton button;
    private final RFGContentImage image;
    private final List<RFGContentInfo> infoList;
    private final RFGContentNote note;
    private final int order;
    private final RFGContentTitle title;

    public RFGContentItem(RFGContentTitle rFGContentTitle, RFGContentNote rFGContentNote, RFGContentImage rFGContentImage, RFGContentAccess rFGContentAccess, List<RFGContentInfo> list, RFGContentButton rFGContentButton, int i) {
        Intrinsics.checkParameterIsNotNull(list, "infoList");
        this.title = rFGContentTitle;
        this.note = rFGContentNote;
        this.image = rFGContentImage;
        this.access = rFGContentAccess;
        this.infoList = list;
        this.button = rFGContentButton;
        this.order = i;
    }

    public static /* synthetic */ RFGContentItem copy$default(RFGContentItem rFGContentItem, RFGContentTitle rFGContentTitle, RFGContentNote rFGContentNote, RFGContentImage rFGContentImage, RFGContentAccess rFGContentAccess, List<RFGContentInfo> list, RFGContentButton rFGContentButton, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rFGContentTitle = rFGContentItem.title;
        }
        if ((i2 & 2) != 0) {
            rFGContentNote = rFGContentItem.note;
        }
        RFGContentNote rFGContentNote2 = rFGContentNote;
        if ((i2 & 4) != 0) {
            rFGContentImage = rFGContentItem.image;
        }
        RFGContentImage rFGContentImage2 = rFGContentImage;
        if ((i2 & 8) != 0) {
            rFGContentAccess = rFGContentItem.access;
        }
        RFGContentAccess rFGContentAccess2 = rFGContentAccess;
        if ((i2 & 16) != 0) {
            list = rFGContentItem.infoList;
        }
        List<RFGContentInfo> list2 = list;
        if ((i2 & 32) != 0) {
            rFGContentButton = rFGContentItem.button;
        }
        RFGContentButton rFGContentButton2 = rFGContentButton;
        if ((i2 & 64) != 0) {
            i = rFGContentItem.order;
        }
        return rFGContentItem.copy(rFGContentTitle, rFGContentNote2, rFGContentImage2, rFGContentAccess2, list2, rFGContentButton2, i);
    }

    public final RFGContentTitle component1() {
        return this.title;
    }

    public final RFGContentNote component2() {
        return this.note;
    }

    public final RFGContentImage component3() {
        return this.image;
    }

    public final RFGContentAccess component4() {
        return this.access;
    }

    public final List<RFGContentInfo> component5() {
        return this.infoList;
    }

    public final RFGContentButton component6() {
        return this.button;
    }

    public final int component7() {
        return this.order;
    }

    public final RFGContentItem copy(RFGContentTitle rFGContentTitle, RFGContentNote rFGContentNote, RFGContentImage rFGContentImage, RFGContentAccess rFGContentAccess, List<RFGContentInfo> list, RFGContentButton rFGContentButton, int i) {
        Intrinsics.checkParameterIsNotNull(list, "infoList");
        return new RFGContentItem(rFGContentTitle, rFGContentNote, rFGContentImage, rFGContentAccess, list, rFGContentButton, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentItem)) {
            return false;
        }
        RFGContentItem rFGContentItem = (RFGContentItem) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) rFGContentItem.title) && Intrinsics.areEqual((Object) this.note, (Object) rFGContentItem.note) && Intrinsics.areEqual((Object) this.image, (Object) rFGContentItem.image) && Intrinsics.areEqual((Object) this.access, (Object) rFGContentItem.access) && Intrinsics.areEqual((Object) this.infoList, (Object) rFGContentItem.infoList) && Intrinsics.areEqual((Object) this.button, (Object) rFGContentItem.button) && this.order == rFGContentItem.order;
    }

    public final RFGContentAccess getAccess() {
        return this.access;
    }

    public final RFGContentButton getButton() {
        return this.button;
    }

    public final RFGContentImage getImage() {
        return this.image;
    }

    public final List<RFGContentInfo> getInfoList() {
        return this.infoList;
    }

    public final RFGContentNote getNote() {
        return this.note;
    }

    public final int getOrder() {
        return this.order;
    }

    public final RFGContentTitle getTitle() {
        return this.title;
    }

    public int hashCode() {
        RFGContentTitle rFGContentTitle = this.title;
        int i = 0;
        int hashCode = (rFGContentTitle != null ? rFGContentTitle.hashCode() : 0) * 31;
        RFGContentNote rFGContentNote = this.note;
        int hashCode2 = (hashCode + (rFGContentNote != null ? rFGContentNote.hashCode() : 0)) * 31;
        RFGContentImage rFGContentImage = this.image;
        int hashCode3 = (hashCode2 + (rFGContentImage != null ? rFGContentImage.hashCode() : 0)) * 31;
        RFGContentAccess rFGContentAccess = this.access;
        int hashCode4 = (hashCode3 + (rFGContentAccess != null ? rFGContentAccess.hashCode() : 0)) * 31;
        List<RFGContentInfo> list = this.infoList;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        RFGContentButton rFGContentButton = this.button;
        if (rFGContentButton != null) {
            i = rFGContentButton.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.order;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentItem(title=");
        a.append(this.title);
        a.append(", note=");
        a.append(this.note);
        a.append(", image=");
        a.append(this.image);
        a.append(", access=");
        a.append(this.access);
        a.append(", infoList=");
        a.append(this.infoList);
        a.append(", button=");
        a.append(this.button);
        a.append(", order=");
        return C0681a.m322a(a, this.order, ")");
    }
}
