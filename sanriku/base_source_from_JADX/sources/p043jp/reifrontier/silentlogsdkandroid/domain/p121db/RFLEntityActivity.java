package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityActivity;", "", "date", "", "timezone", "data", "", "(Ljava/lang/String;Ljava/lang/String;[B)V", "activities", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "getActivities", "()Ljava/util/List;", "activityType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "getData", "()[B", "getDate", "()Ljava/lang/String;", "getTimezone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity */
public final class RFLEntityActivity {

    /* renamed from: a */
    private final Type f3620a = new RFLEntityActivity$activityType$1().getType();

    /* renamed from: b */
    private final String f3621b;

    /* renamed from: c */
    private final String f3622c;

    /* renamed from: d */
    private final byte[] f3623d;

    public RFLEntityActivity(String str, String str2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3621b = str;
        this.f3622c = str2;
        this.f3623d = bArr;
    }

    public static /* synthetic */ RFLEntityActivity copy$default(RFLEntityActivity rFLEntityActivity, String str, String str2, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLEntityActivity.f3621b;
        }
        if ((i & 2) != 0) {
            str2 = rFLEntityActivity.f3622c;
        }
        if ((i & 4) != 0) {
            bArr = rFLEntityActivity.f3623d;
        }
        return rFLEntityActivity.copy(str, str2, bArr);
    }

    public final String component1() {
        return this.f3621b;
    }

    public final String component2() {
        return this.f3622c;
    }

    public final byte[] component3() {
        return this.f3623d;
    }

    public final RFLEntityActivity copy(String str, String str2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityActivity(str, str2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityActivity.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityActivity rFLEntityActivity = (RFLEntityActivity) obj;
            return !(Intrinsics.areEqual((Object) this.f3621b, (Object) rFLEntityActivity.f3621b) ^ true) && !(Intrinsics.areEqual((Object) this.f3622c, (Object) rFLEntityActivity.f3622c) ^ true) && Arrays.equals(this.f3623d, rFLEntityActivity.f3623d);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity");
    }

    public final List<RFLActivity> getActivities() {
        Object fromJson = new Gson().fromJson(new String(this.f3623d, Charsets.UTF_8), this.f3620a);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<List<RFL…>(jsonData, activityType)");
        return (List) fromJson;
    }

    public final byte[] getData() {
        return this.f3623d;
    }

    public final String getDate() {
        return this.f3621b;
    }

    public final String getTimezone() {
        return this.f3622c;
    }

    public int hashCode() {
        int hashCode = this.f3622c.hashCode();
        return Arrays.hashCode(this.f3623d) + ((hashCode + (this.f3621b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityActivity(date=");
        a.append(this.f3621b);
        a.append(", timezone=");
        a.append(this.f3622c);
        a.append(", data=");
        a.append(Arrays.toString(this.f3623d));
        a.append(")");
        return a.toString();
    }
}
