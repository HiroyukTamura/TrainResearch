package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityTag;", "", "fromDate", "", "toDate", "data", "", "(II[B)V", "getData", "()[B", "getFromDate", "()I", "tag", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "getTag", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "tagType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "getToDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag */
public final class RFLEntityTag {

    /* renamed from: a */
    private final Type f3704a = new RFLEntityTag$tagType$1().getType();

    /* renamed from: b */
    private final int f3705b;

    /* renamed from: c */
    private final int f3706c;

    /* renamed from: d */
    private final byte[] f3707d;

    public RFLEntityTag(int i, int i2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3705b = i;
        this.f3706c = i2;
        this.f3707d = bArr;
    }

    public static /* synthetic */ RFLEntityTag copy$default(RFLEntityTag rFLEntityTag, int i, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rFLEntityTag.f3705b;
        }
        if ((i3 & 2) != 0) {
            i2 = rFLEntityTag.f3706c;
        }
        if ((i3 & 4) != 0) {
            bArr = rFLEntityTag.f3707d;
        }
        return rFLEntityTag.copy(i, i2, bArr);
    }

    public final int component1() {
        return this.f3705b;
    }

    public final int component2() {
        return this.f3706c;
    }

    public final byte[] component3() {
        return this.f3707d;
    }

    public final RFLEntityTag copy(int i, int i2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityTag(i, i2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityTag.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityTag rFLEntityTag = (RFLEntityTag) obj;
            return this.f3705b == rFLEntityTag.f3705b && this.f3706c == rFLEntityTag.f3706c && Arrays.equals(this.f3707d, rFLEntityTag.f3707d);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag");
    }

    public final byte[] getData() {
        return this.f3707d;
    }

    public final int getFromDate() {
        return this.f3705b;
    }

    public final RFLTag getTag() {
        Object fromJson = new Gson().fromJson(new String(this.f3707d, Charsets.UTF_8), this.f3704a);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<RFLTag>(jsonData, tagType)");
        return (RFLTag) fromJson;
    }

    public final int getToDate() {
        return this.f3706c;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3707d) + (((this.f3705b * 31) + this.f3706c) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityTag(fromDate=");
        a.append(this.f3705b);
        a.append(", toDate=");
        a.append(this.f3706c);
        a.append(", data=");
        a.append(Arrays.toString(this.f3707d));
        a.append(")");
        return a.toString();
    }
}
