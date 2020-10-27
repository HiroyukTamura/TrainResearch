package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLFinishedEvent;", "", "eventId", "", "eventTime", "(II)V", "getEventId", "()I", "getEventTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLFinishedEvent */
public final class RFLFinishedEvent {
    @SerializedName("event_id")

    /* renamed from: a */
    private final int f3472a;
    @SerializedName("event_time")

    /* renamed from: b */
    private final int f3473b;

    public RFLFinishedEvent(int i, int i2) {
        this.f3472a = i;
        this.f3473b = i2;
    }

    public static /* synthetic */ RFLFinishedEvent copy$default(RFLFinishedEvent rFLFinishedEvent, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rFLFinishedEvent.f3472a;
        }
        if ((i3 & 2) != 0) {
            i2 = rFLFinishedEvent.f3473b;
        }
        return rFLFinishedEvent.copy(i, i2);
    }

    public final int component1() {
        return this.f3472a;
    }

    public final int component2() {
        return this.f3473b;
    }

    public final RFLFinishedEvent copy(int i, int i2) {
        return new RFLFinishedEvent(i, i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RFLFinishedEvent)) {
            obj = null;
        }
        RFLFinishedEvent rFLFinishedEvent = (RFLFinishedEvent) obj;
        return rFLFinishedEvent != null && this.f3472a == rFLFinishedEvent.f3472a;
    }

    public final int getEventId() {
        return this.f3472a;
    }

    public final int getEventTime() {
        return this.f3473b;
    }

    public int hashCode() {
        return this.f3472a;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLFinishedEvent(eventId=");
        a.append(this.f3472a);
        a.append(", eventTime=");
        return C0681a.m322a(a, this.f3473b, ")");
    }
}
