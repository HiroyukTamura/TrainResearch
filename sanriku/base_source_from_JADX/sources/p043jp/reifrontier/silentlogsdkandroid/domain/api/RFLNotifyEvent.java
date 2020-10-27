package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotifyEvent;", "", "eventId", "", "eventName", "", "eventNotificationPOI", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "notificationTitle", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;", "notificationBody", "notificationUrl", "(ILjava/lang/String;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;Ljava/lang/String;)V", "getEventId", "()I", "getEventName", "()Ljava/lang/String;", "getEventNotificationPOI", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "getNotificationBody", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;", "getNotificationTitle", "getNotificationUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotifyEvent */
public final class RFLNotifyEvent {
    @SerializedName("event_id")

    /* renamed from: a */
    private final int f3487a;
    @SerializedName("event_name")

    /* renamed from: b */
    private final String f3488b;
    @SerializedName("event_poi")

    /* renamed from: c */
    private final RFLNotificationPoi f3489c;
    @SerializedName("notification_title")

    /* renamed from: d */
    private final RFLText f3490d;
    @SerializedName("notification_body")

    /* renamed from: e */
    private final RFLText f3491e;
    @SerializedName("notification_url")

    /* renamed from: f */
    private final String f3492f;

    public RFLNotifyEvent(int i, String str, RFLNotificationPoi rFLNotificationPoi, RFLText rFLText, RFLText rFLText2, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "eventName");
        Intrinsics.checkParameterIsNotNull(rFLNotificationPoi, "eventNotificationPOI");
        Intrinsics.checkParameterIsNotNull(rFLText, "notificationTitle");
        Intrinsics.checkParameterIsNotNull(rFLText2, "notificationBody");
        Intrinsics.checkParameterIsNotNull(str2, "notificationUrl");
        this.f3487a = i;
        this.f3488b = str;
        this.f3489c = rFLNotificationPoi;
        this.f3490d = rFLText;
        this.f3491e = rFLText2;
        this.f3492f = str2;
    }

    public static /* synthetic */ RFLNotifyEvent copy$default(RFLNotifyEvent rFLNotifyEvent, int i, String str, RFLNotificationPoi rFLNotificationPoi, RFLText rFLText, RFLText rFLText2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFLNotifyEvent.f3487a;
        }
        if ((i2 & 2) != 0) {
            str = rFLNotifyEvent.f3488b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            rFLNotificationPoi = rFLNotifyEvent.f3489c;
        }
        RFLNotificationPoi rFLNotificationPoi2 = rFLNotificationPoi;
        if ((i2 & 8) != 0) {
            rFLText = rFLNotifyEvent.f3490d;
        }
        RFLText rFLText3 = rFLText;
        if ((i2 & 16) != 0) {
            rFLText2 = rFLNotifyEvent.f3491e;
        }
        RFLText rFLText4 = rFLText2;
        if ((i2 & 32) != 0) {
            str2 = rFLNotifyEvent.f3492f;
        }
        return rFLNotifyEvent.copy(i, str3, rFLNotificationPoi2, rFLText3, rFLText4, str2);
    }

    public final int component1() {
        return this.f3487a;
    }

    public final String component2() {
        return this.f3488b;
    }

    public final RFLNotificationPoi component3() {
        return this.f3489c;
    }

    public final RFLText component4() {
        return this.f3490d;
    }

    public final RFLText component5() {
        return this.f3491e;
    }

    public final String component6() {
        return this.f3492f;
    }

    public final RFLNotifyEvent copy(int i, String str, RFLNotificationPoi rFLNotificationPoi, RFLText rFLText, RFLText rFLText2, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "eventName");
        Intrinsics.checkParameterIsNotNull(rFLNotificationPoi, "eventNotificationPOI");
        Intrinsics.checkParameterIsNotNull(rFLText, "notificationTitle");
        Intrinsics.checkParameterIsNotNull(rFLText2, "notificationBody");
        Intrinsics.checkParameterIsNotNull(str2, "notificationUrl");
        return new RFLNotifyEvent(i, str, rFLNotificationPoi, rFLText, rFLText2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLNotifyEvent)) {
            return false;
        }
        RFLNotifyEvent rFLNotifyEvent = (RFLNotifyEvent) obj;
        return this.f3487a == rFLNotifyEvent.f3487a && Intrinsics.areEqual((Object) this.f3488b, (Object) rFLNotifyEvent.f3488b) && Intrinsics.areEqual((Object) this.f3489c, (Object) rFLNotifyEvent.f3489c) && Intrinsics.areEqual((Object) this.f3490d, (Object) rFLNotifyEvent.f3490d) && Intrinsics.areEqual((Object) this.f3491e, (Object) rFLNotifyEvent.f3491e) && Intrinsics.areEqual((Object) this.f3492f, (Object) rFLNotifyEvent.f3492f);
    }

    public final int getEventId() {
        return this.f3487a;
    }

    public final String getEventName() {
        return this.f3488b;
    }

    public final RFLNotificationPoi getEventNotificationPOI() {
        return this.f3489c;
    }

    public final RFLText getNotificationBody() {
        return this.f3491e;
    }

    public final RFLText getNotificationTitle() {
        return this.f3490d;
    }

    public final String getNotificationUrl() {
        return this.f3492f;
    }

    public int hashCode() {
        int i = this.f3487a * 31;
        String str = this.f3488b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        RFLNotificationPoi rFLNotificationPoi = this.f3489c;
        int hashCode2 = (hashCode + (rFLNotificationPoi != null ? rFLNotificationPoi.hashCode() : 0)) * 31;
        RFLText rFLText = this.f3490d;
        int hashCode3 = (hashCode2 + (rFLText != null ? rFLText.hashCode() : 0)) * 31;
        RFLText rFLText2 = this.f3491e;
        int hashCode4 = (hashCode3 + (rFLText2 != null ? rFLText2.hashCode() : 0)) * 31;
        String str2 = this.f3492f;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLNotifyEvent(eventId=");
        a.append(this.f3487a);
        a.append(", eventName=");
        a.append(this.f3488b);
        a.append(", eventNotificationPOI=");
        a.append(this.f3489c);
        a.append(", notificationTitle=");
        a.append(this.f3490d);
        a.append(", notificationBody=");
        a.append(this.f3491e);
        a.append(", notificationUrl=");
        return C0681a.m324a(a, this.f3492f, ")");
    }
}
