package p043jp.reifrontier.gym.data.train.spot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "", "address", "", "access", "lat", "", "lon", "(Ljava/lang/String;Ljava/lang/String;DD)V", "getAccess", "()Ljava/lang/String;", "getAddress", "getLat", "()D", "getLon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentAccess */
public final class RFGContentAccess {
    private final String access;
    private final String address;
    private final double lat;
    private final double lon;

    public RFGContentAccess(String str, String str2, double d, double d2) {
        this.address = str;
        this.access = str2;
        this.lat = d;
        this.lon = d2;
    }

    public static /* synthetic */ RFGContentAccess copy$default(RFGContentAccess rFGContentAccess, String str, String str2, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGContentAccess.address;
        }
        if ((i & 2) != 0) {
            str2 = rFGContentAccess.access;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            d = rFGContentAccess.lat;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = rFGContentAccess.lon;
        }
        return rFGContentAccess.copy(str, str3, d3, d2);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.access;
    }

    public final double component3() {
        return this.lat;
    }

    public final double component4() {
        return this.lon;
    }

    public final RFGContentAccess copy(String str, String str2, double d, double d2) {
        return new RFGContentAccess(str, str2, d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentAccess)) {
            return false;
        }
        RFGContentAccess rFGContentAccess = (RFGContentAccess) obj;
        return Intrinsics.areEqual((Object) this.address, (Object) rFGContentAccess.address) && Intrinsics.areEqual((Object) this.access, (Object) rFGContentAccess.access) && Double.compare(this.lat, rFGContentAccess.lat) == 0 && Double.compare(this.lon, rFGContentAccess.lon) == 0;
    }

    public final String getAccess() {
        return this.access;
    }

    public final String getAddress() {
        return this.address;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public int hashCode() {
        String str = this.address;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.access;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + i) * 31) + Double.doubleToLongBits(this.lat)) * 31) + Double.doubleToLongBits(this.lon);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentAccess(address=");
        a.append(this.address);
        a.append(", access=");
        a.append(this.access);
        a.append(", lat=");
        a.append(this.lat);
        a.append(", lon=");
        a.append(this.lon);
        a.append(")");
        return a.toString();
    }
}
