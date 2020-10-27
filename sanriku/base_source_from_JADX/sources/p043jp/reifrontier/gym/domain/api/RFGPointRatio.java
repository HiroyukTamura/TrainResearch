package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGPointRatio;", "", "wlk", "", "run", "bike", "(FFF)V", "getBike", "()F", "getRun", "getWlk", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGPointRatio */
public final class RFGPointRatio {
    @SerializedName("bike")
    private final float bike;
    @SerializedName("run")
    private final float run;
    @SerializedName("wlk")
    private final float wlk;

    public RFGPointRatio(float f, float f2, float f3) {
        this.wlk = f;
        this.run = f2;
        this.bike = f3;
    }

    public static /* synthetic */ RFGPointRatio copy$default(RFGPointRatio rFGPointRatio, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rFGPointRatio.wlk;
        }
        if ((i & 2) != 0) {
            f2 = rFGPointRatio.run;
        }
        if ((i & 4) != 0) {
            f3 = rFGPointRatio.bike;
        }
        return rFGPointRatio.copy(f, f2, f3);
    }

    public final float component1() {
        return this.wlk;
    }

    public final float component2() {
        return this.run;
    }

    public final float component3() {
        return this.bike;
    }

    public final RFGPointRatio copy(float f, float f2, float f3) {
        return new RFGPointRatio(f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGPointRatio)) {
            return false;
        }
        RFGPointRatio rFGPointRatio = (RFGPointRatio) obj;
        return Float.compare(this.wlk, rFGPointRatio.wlk) == 0 && Float.compare(this.run, rFGPointRatio.run) == 0 && Float.compare(this.bike, rFGPointRatio.bike) == 0;
    }

    public final float getBike() {
        return this.bike;
    }

    public final float getRun() {
        return this.run;
    }

    public final float getWlk() {
        return this.wlk;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.run);
        return Float.floatToIntBits(this.bike) + ((floatToIntBits + (Float.floatToIntBits(this.wlk) * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGPointRatio(wlk=");
        a.append(this.wlk);
        a.append(", run=");
        a.append(this.run);
        a.append(", bike=");
        a.append(this.bike);
        a.append(")");
        return a.toString();
    }
}
