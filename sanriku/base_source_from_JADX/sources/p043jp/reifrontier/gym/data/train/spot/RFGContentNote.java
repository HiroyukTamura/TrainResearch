package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentNote;", "", "value", "", "size", "Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType;", "bold", "", "color", "Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "(Ljava/lang/String;Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType;ZLjp/reifrontier/gym/data/train/spot/RFGColorType;)V", "getBold", "()Z", "getColor", "()Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "getSize", "()Ljp/reifrontier/gym/data/train/spot/RFGNoteTextSizeType;", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentNote */
public final class RFGContentNote {
    private final boolean bold;
    private final RFGColorType color;
    private final RFGNoteTextSizeType size;
    private final String value;

    public RFGContentNote(String str, RFGNoteTextSizeType rFGNoteTextSizeType, boolean z, RFGColorType rFGColorType) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(rFGNoteTextSizeType, "size");
        Intrinsics.checkParameterIsNotNull(rFGColorType, "color");
        this.value = str;
        this.size = rFGNoteTextSizeType;
        this.bold = z;
        this.color = rFGColorType;
    }

    public static /* synthetic */ RFGContentNote copy$default(RFGContentNote rFGContentNote, String str, RFGNoteTextSizeType rFGNoteTextSizeType, boolean z, RFGColorType rFGColorType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGContentNote.value;
        }
        if ((i & 2) != 0) {
            rFGNoteTextSizeType = rFGContentNote.size;
        }
        if ((i & 4) != 0) {
            z = rFGContentNote.bold;
        }
        if ((i & 8) != 0) {
            rFGColorType = rFGContentNote.color;
        }
        return rFGContentNote.copy(str, rFGNoteTextSizeType, z, rFGColorType);
    }

    public final String component1() {
        return this.value;
    }

    public final RFGNoteTextSizeType component2() {
        return this.size;
    }

    public final boolean component3() {
        return this.bold;
    }

    public final RFGColorType component4() {
        return this.color;
    }

    public final RFGContentNote copy(String str, RFGNoteTextSizeType rFGNoteTextSizeType, boolean z, RFGColorType rFGColorType) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(rFGNoteTextSizeType, "size");
        Intrinsics.checkParameterIsNotNull(rFGColorType, "color");
        return new RFGContentNote(str, rFGNoteTextSizeType, z, rFGColorType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentNote)) {
            return false;
        }
        RFGContentNote rFGContentNote = (RFGContentNote) obj;
        return Intrinsics.areEqual((Object) this.value, (Object) rFGContentNote.value) && Intrinsics.areEqual((Object) this.size, (Object) rFGContentNote.size) && this.bold == rFGContentNote.bold && Intrinsics.areEqual((Object) this.color, (Object) rFGContentNote.color);
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final RFGColorType getColor() {
        return this.color;
    }

    public final RFGNoteTextSizeType getSize() {
        return this.size;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.value;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RFGNoteTextSizeType rFGNoteTextSizeType = this.size;
        int hashCode2 = (hashCode + (rFGNoteTextSizeType != null ? rFGNoteTextSizeType.hashCode() : 0)) * 31;
        boolean z = this.bold;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        RFGColorType rFGColorType = this.color;
        if (rFGColorType != null) {
            i = rFGColorType.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentNote(value=");
        a.append(this.value);
        a.append(", size=");
        a.append(this.size);
        a.append(", bold=");
        a.append(this.bold);
        a.append(", color=");
        a.append(this.color);
        a.append(")");
        return a.toString();
    }
}
