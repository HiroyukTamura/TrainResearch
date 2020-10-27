package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import android.location.Location;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006)"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "", "triggerId", "", "triggerType", "triggerUuid", "", "lat", "", "lon", "distance", "", "(IILjava/lang/String;DDF)V", "getDistance", "()F", "dumpMessage", "getDumpMessage", "()Ljava/lang/String;", "getLat", "()D", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "getLon", "getTriggerId", "()I", "getTriggerType", "getTriggerUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger */
public final class RFLAdTrigger {
    @SerializedName("trigger_id")

    /* renamed from: a */
    private final int f3449a;
    @SerializedName("trigger_type")

    /* renamed from: b */
    private final int f3450b;
    @SerializedName("trigger_uuid")

    /* renamed from: c */
    private final String f3451c;
    @SerializedName("lat")

    /* renamed from: d */
    private final double f3452d;
    @SerializedName("lon")

    /* renamed from: e */
    private final double f3453e;

    /* renamed from: f */
    private final transient float f3454f;

    public RFLAdTrigger(int i, int i2, String str, double d, double d2, float f) {
        Intrinsics.checkParameterIsNotNull(str, "triggerUuid");
        this.f3449a = i;
        this.f3450b = i2;
        this.f3451c = str;
        this.f3452d = d;
        this.f3453e = d2;
        this.f3454f = f;
    }

    public static /* synthetic */ RFLAdTrigger copy$default(RFLAdTrigger rFLAdTrigger, int i, int i2, String str, double d, double d2, float f, int i3, Object obj) {
        RFLAdTrigger rFLAdTrigger2 = rFLAdTrigger;
        return rFLAdTrigger.copy((i3 & 1) != 0 ? rFLAdTrigger2.f3449a : i, (i3 & 2) != 0 ? rFLAdTrigger2.f3450b : i2, (i3 & 4) != 0 ? rFLAdTrigger2.f3451c : str, (i3 & 8) != 0 ? rFLAdTrigger2.f3452d : d, (i3 & 16) != 0 ? rFLAdTrigger2.f3453e : d2, (i3 & 32) != 0 ? rFLAdTrigger2.f3454f : f);
    }

    public final int component1() {
        return this.f3449a;
    }

    public final int component2() {
        return this.f3450b;
    }

    public final String component3() {
        return this.f3451c;
    }

    public final double component4() {
        return this.f3452d;
    }

    public final double component5() {
        return this.f3453e;
    }

    public final float component6() {
        return this.f3454f;
    }

    public final RFLAdTrigger copy(int i, int i2, String str, double d, double d2, float f) {
        Intrinsics.checkParameterIsNotNull(str, "triggerUuid");
        return new RFLAdTrigger(i, i2, str, d, d2, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLAdTrigger)) {
            return false;
        }
        RFLAdTrigger rFLAdTrigger = (RFLAdTrigger) obj;
        return this.f3449a == rFLAdTrigger.f3449a && this.f3450b == rFLAdTrigger.f3450b && Intrinsics.areEqual((Object) this.f3451c, (Object) rFLAdTrigger.f3451c) && Double.compare(this.f3452d, rFLAdTrigger.f3452d) == 0 && Double.compare(this.f3453e, rFLAdTrigger.f3453e) == 0 && Float.compare(this.f3454f, rFLAdTrigger.f3454f) == 0;
    }

    public final float getDistance() {
        return this.f3454f;
    }

    public final String getDumpMessage() {
        StringBuilder a = C0681a.m330a("========== TRIGGER ");
        a.append(this.f3452d);
        a.append(',');
        a.append(this.f3453e);
        a.append(" coverId ");
        a.append(this.f3449a);
        return a.toString();
    }

    public final double getLat() {
        return this.f3452d;
    }

    public final Location getLocation() {
        Location location = new Location("silentLog");
        location.setLatitude(this.f3452d);
        location.setLongitude(this.f3453e);
        return location;
    }

    public final double getLon() {
        return this.f3453e;
    }

    public final int getTriggerId() {
        return this.f3449a;
    }

    public final int getTriggerType() {
        return this.f3450b;
    }

    public final String getTriggerUuid() {
        return this.f3451c;
    }

    public int hashCode() {
        int i = ((this.f3449a * 31) + this.f3450b) * 31;
        String str = this.f3451c;
        return Float.floatToIntBits(this.f3454f) + ((((((i + (str != null ? str.hashCode() : 0)) * 31) + Double.doubleToLongBits(this.f3452d)) * 31) + Double.doubleToLongBits(this.f3453e)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLAdTrigger(triggerId=");
        a.append(this.f3449a);
        a.append(", triggerType=");
        a.append(this.f3450b);
        a.append(", triggerUuid=");
        a.append(this.f3451c);
        a.append(", lat=");
        a.append(this.f3452d);
        a.append(", lon=");
        a.append(this.f3453e);
        a.append(", distance=");
        a.append(this.f3454f);
        a.append(")");
        return a.toString();
    }
}
