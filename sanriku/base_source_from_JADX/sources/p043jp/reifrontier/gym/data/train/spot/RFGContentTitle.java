package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;", "", "value", "", "size", "Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType;", "(Ljava/lang/String;Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType;)V", "getSize", "()Ljp/reifrontier/gym/data/train/spot/RFGTitleTextSizeType;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentTitle */
public final class RFGContentTitle {
    private final RFGTitleTextSizeType size;
    private final String value;

    public RFGContentTitle(String str, RFGTitleTextSizeType rFGTitleTextSizeType) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(rFGTitleTextSizeType, "size");
        this.value = str;
        this.size = rFGTitleTextSizeType;
    }

    public static /* synthetic */ RFGContentTitle copy$default(RFGContentTitle rFGContentTitle, String str, RFGTitleTextSizeType rFGTitleTextSizeType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGContentTitle.value;
        }
        if ((i & 2) != 0) {
            rFGTitleTextSizeType = rFGContentTitle.size;
        }
        return rFGContentTitle.copy(str, rFGTitleTextSizeType);
    }

    public final String component1() {
        return this.value;
    }

    public final RFGTitleTextSizeType component2() {
        return this.size;
    }

    public final RFGContentTitle copy(String str, RFGTitleTextSizeType rFGTitleTextSizeType) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(rFGTitleTextSizeType, "size");
        return new RFGContentTitle(str, rFGTitleTextSizeType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentTitle)) {
            return false;
        }
        RFGContentTitle rFGContentTitle = (RFGContentTitle) obj;
        return Intrinsics.areEqual((Object) this.value, (Object) rFGContentTitle.value) && Intrinsics.areEqual((Object) this.size, (Object) rFGContentTitle.size);
    }

    public final RFGTitleTextSizeType getSize() {
        return this.size;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.value;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RFGTitleTextSizeType rFGTitleTextSizeType = this.size;
        if (rFGTitleTextSizeType != null) {
            i = rFGTitleTextSizeType.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentTitle(value=");
        a.append(this.value);
        a.append(", size=");
        a.append(this.size);
        a.append(")");
        return a.toString();
    }
}
