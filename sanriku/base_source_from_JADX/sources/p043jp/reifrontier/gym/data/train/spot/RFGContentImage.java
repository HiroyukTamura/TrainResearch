package p043jp.reifrontier.gym.data.train.spot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/spot/RFGContentImage;", "", "path", "", "width", "", "height", "full", "", "(Ljava/lang/String;IIZ)V", "getFull", "()Z", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.spot.RFGContentImage */
public final class RFGContentImage {
    private final boolean full;
    private final int height;
    @SerializedName("path")
    private final String path;
    private final int width;

    public RFGContentImage(String str, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.path = str;
        this.width = i;
        this.height = i2;
        this.full = z;
    }

    public static /* synthetic */ RFGContentImage copy$default(RFGContentImage rFGContentImage, String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rFGContentImage.path;
        }
        if ((i3 & 2) != 0) {
            i = rFGContentImage.width;
        }
        if ((i3 & 4) != 0) {
            i2 = rFGContentImage.height;
        }
        if ((i3 & 8) != 0) {
            z = rFGContentImage.full;
        }
        return rFGContentImage.copy(str, i, i2, z);
    }

    public final String component1() {
        return this.path;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final boolean component4() {
        return this.full;
    }

    public final RFGContentImage copy(String str, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        return new RFGContentImage(str, i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGContentImage)) {
            return false;
        }
        RFGContentImage rFGContentImage = (RFGContentImage) obj;
        return Intrinsics.areEqual((Object) this.path, (Object) rFGContentImage.path) && this.width == rFGContentImage.width && this.height == rFGContentImage.height && this.full == rFGContentImage.full;
    }

    public final boolean getFull() {
        return this.full;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.path;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height) * 31;
        boolean z = this.full;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGContentImage(path=");
        a.append(this.path);
        a.append(", width=");
        a.append(this.width);
        a.append(", height=");
        a.append(this.height);
        a.append(", full=");
        a.append(this.full);
        a.append(")");
        return a.toString();
    }
}
