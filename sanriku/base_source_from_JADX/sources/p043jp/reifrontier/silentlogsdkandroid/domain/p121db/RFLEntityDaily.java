package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDaily;", "", "date", "", "timezone", "data", "", "(Ljava/lang/String;Ljava/lang/String;[B)V", "daily", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "getDaily", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "dailyType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "getData", "()[B", "getDate", "()Ljava/lang/String;", "getTimezone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily */
public final class RFLEntityDaily {

    /* renamed from: a */
    private final Type f3651a = new RFLEntityDaily$dailyType$1().getType();

    /* renamed from: b */
    private final String f3652b;

    /* renamed from: c */
    private final String f3653c;

    /* renamed from: d */
    private final byte[] f3654d;

    public RFLEntityDaily(String str, String str2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3652b = str;
        this.f3653c = str2;
        this.f3654d = bArr;
    }

    public static /* synthetic */ RFLEntityDaily copy$default(RFLEntityDaily rFLEntityDaily, String str, String str2, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLEntityDaily.f3652b;
        }
        if ((i & 2) != 0) {
            str2 = rFLEntityDaily.f3653c;
        }
        if ((i & 4) != 0) {
            bArr = rFLEntityDaily.f3654d;
        }
        return rFLEntityDaily.copy(str, str2, bArr);
    }

    public final String component1() {
        return this.f3652b;
    }

    public final String component2() {
        return this.f3653c;
    }

    public final byte[] component3() {
        return this.f3654d;
    }

    public final RFLEntityDaily copy(String str, String str2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityDaily(str, str2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityDaily.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityDaily rFLEntityDaily = (RFLEntityDaily) obj;
            return !(Intrinsics.areEqual((Object) this.f3652b, (Object) rFLEntityDaily.f3652b) ^ true) && !(Intrinsics.areEqual((Object) this.f3653c, (Object) rFLEntityDaily.f3653c) ^ true) && Arrays.equals(this.f3654d, rFLEntityDaily.f3654d);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily");
    }

    public final RFLDaily getDaily() {
        Object fromJson = new Gson().fromJson(new String(this.f3654d, Charsets.UTF_8), this.f3651a);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<RFLDaily>(jsonData, dailyType)");
        return (RFLDaily) fromJson;
    }

    public final byte[] getData() {
        return this.f3654d;
    }

    public final String getDate() {
        return this.f3652b;
    }

    public final String getTimezone() {
        return this.f3653c;
    }

    public int hashCode() {
        int hashCode = this.f3653c.hashCode();
        return Arrays.hashCode(this.f3654d) + ((hashCode + (this.f3652b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityDaily(date=");
        a.append(this.f3652b);
        a.append(", timezone=");
        a.append(this.f3653c);
        a.append(", data=");
        a.append(Arrays.toString(this.f3654d));
        a.append(")");
        return a.toString();
    }
}
