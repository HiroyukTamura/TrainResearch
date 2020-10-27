package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentButton;", "", "label", "", "type", "Ljp/reifrontier/gym/data/train/spot/RFGButtonType;", "value", "color", "Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "analytics", "(Ljava/lang/String;Ljp/reifrontier/gym/data/train/spot/RFGButtonType;Ljava/lang/String;Ljp/reifrontier/gym/data/train/spot/RFGColorType;Ljava/lang/String;)V", "getAnalytics", "()Ljava/lang/String;", "getColor", "()Ljp/reifrontier/gym/data/train/spot/RFGColorType;", "getLabel", "getType", "()Ljp/reifrontier/gym/data/train/spot/RFGButtonType;", "getValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentButton */
public final class RFGContentButton {
    private final String analytics;
    private final RFGColorType color;
    private final String label;
    private final RFGButtonType type;
    private final String value;

    public RFGContentButton(String str, RFGButtonType rFGButtonType, String str2, RFGColorType rFGColorType, String str3) {
        Intrinsics.checkParameterIsNotNull(rFGButtonType, "type");
        Intrinsics.checkParameterIsNotNull(rFGColorType, "color");
        this.label = str;
        this.type = rFGButtonType;
        this.value = str2;
        this.color = rFGColorType;
        this.analytics = str3;
    }

    public static /* synthetic */ RFGContentButton copy$default(RFGContentButton rFGContentButton, String str, RFGButtonType rFGButtonType, String str2, RFGColorType rFGColorType, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGContentButton.label;
        }
        if ((i & 2) != 0) {
            rFGButtonType = rFGContentButton.type;
        }
        RFGButtonType rFGButtonType2 = rFGButtonType;
        if ((i & 4) != 0) {
            str2 = rFGContentButton.value;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            rFGColorType = rFGContentButton.color;
        }
        RFGColorType rFGColorType2 = rFGColorType;
        if ((i & 16) != 0) {
            str3 = rFGContentButton.analytics;
        }
        return rFGContentButton.copy(str, rFGButtonType2, str4, rFGColorType2, str3);
    }

    public final String component1() {
        return this.label;
    }

    public final RFGButtonType component2() {
        return this.type;
    }

    public final String component3() {
        return this.value;
    }

    public final RFGColorType component4() {
        return this.color;
    }

    public final String component5() {
        return this.analytics;
    }

    public final RFGContentButton copy(String str, RFGButtonType rFGButtonType, String str2, RFGColorType rFGColorType, String str3) {
        Intrinsics.checkParameterIsNotNull(rFGButtonType, "type");
        Intrinsics.checkParameterIsNotNull(rFGColorType, "color");
        return new RFGContentButton(str, rFGButtonType, str2, rFGColorType, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentButton)) {
            return false;
        }
        RFGContentButton rFGContentButton = (RFGContentButton) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) rFGContentButton.label) && Intrinsics.areEqual((Object) this.type, (Object) rFGContentButton.type) && Intrinsics.areEqual((Object) this.value, (Object) rFGContentButton.value) && Intrinsics.areEqual((Object) this.color, (Object) rFGContentButton.color) && Intrinsics.areEqual((Object) this.analytics, (Object) rFGContentButton.analytics);
    }

    public final String getAnalytics() {
        return this.analytics;
    }

    public final RFGColorType getColor() {
        return this.color;
    }

    public final String getLabel() {
        return this.label;
    }

    public final RFGButtonType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.label;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RFGButtonType rFGButtonType = this.type;
        int hashCode2 = (hashCode + (rFGButtonType != null ? rFGButtonType.hashCode() : 0)) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        RFGColorType rFGColorType = this.color;
        int hashCode4 = (hashCode3 + (rFGColorType != null ? rFGColorType.hashCode() : 0)) * 31;
        String str3 = this.analytics;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentButton(label=");
        a.append(this.label);
        a.append(", type=");
        a.append(this.type);
        a.append(", value=");
        a.append(this.value);
        a.append(", color=");
        a.append(this.color);
        a.append(", analytics=");
        return C0681a.m324a(a, this.analytics, ")");
    }
}
