package p043jp.reifrontier.gym.domain.api;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGServerActivity;", "", "order", "", "type", "", "(ILjava/lang/String;)V", "getOrder", "()I", "setOrder", "(I)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "actType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGServerActivity */
public final class RFGServerActivity {
    @SerializedName("ord")
    private int order;
    @SerializedName("type")
    private String type;

    public RFGServerActivity() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public RFGServerActivity(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        this.order = i;
        this.type = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGServerActivity(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ RFGServerActivity copy$default(RFGServerActivity rFGServerActivity, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFGServerActivity.order;
        }
        if ((i2 & 2) != 0) {
            str = rFGServerActivity.type;
        }
        return rFGServerActivity.copy(i, str);
    }

    public final String actType() {
        String str = this.type;
        int hashCode = str.hashCode();
        if (hashCode != -117759745) {
            if (hashCode != 3641801) {
                if (hashCode == 1052964649 && str.equals(NotificationCompat.CATEGORY_TRANSPORT)) {
                    return "trp";
                }
            } else if (str.equals("walk")) {
                return "wlk";
            }
        } else if (str.equals("bicycle")) {
            return "bicycle";
        }
        return "sty";
    }

    public final int component1() {
        return this.order;
    }

    public final String component2() {
        return this.type;
    }

    public final RFGServerActivity copy(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return new RFGServerActivity(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGServerActivity)) {
            return false;
        }
        RFGServerActivity rFGServerActivity = (RFGServerActivity) obj;
        return this.order == rFGServerActivity.order && Intrinsics.areEqual((Object) this.type, (Object) rFGServerActivity.type);
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.order * 31;
        String str = this.type;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void setOrder(int i) {
        this.order = i;
    }

    public final void setType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGServerActivity(order=");
        a.append(this.order);
        a.append(", type=");
        return C0681a.m324a(a, this.type, ")");
    }
}
