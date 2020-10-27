package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001b¨\u00061"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "", "premiumLimit", "", "registUser", "", "lastReadDate", "advertisingIds", "", "pushTokenAnd", "adEntry", "", "jrForms", "mpAuth", "installDate", "twoWeekSetting", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAdEntry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdvertisingIds", "()Ljava/util/List;", "getInstallDate", "()Ljava/lang/String;", "getJrForms", "getLastReadDate", "getMpAuth", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPremiumLimit", "getPushTokenAnd", "getRegistUser", "getTwoWeekSetting", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "equals", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate */
public final class RFLPrivate {
    @SerializedName("premium_limit")

    /* renamed from: a */
    private final String f3493a;
    @SerializedName("regist_user")

    /* renamed from: b */
    private final Boolean f3494b;
    @SerializedName("last_read_date")

    /* renamed from: c */
    private final String f3495c;
    @SerializedName("adids")

    /* renamed from: d */
    private final List<String> f3496d;
    @SerializedName("push_token_and")

    /* renamed from: e */
    private final String f3497e;
    @SerializedName("ad_entry")

    /* renamed from: f */
    private final Integer f3498f;
    @SerializedName("jr_form")

    /* renamed from: g */
    private final List<String> f3499g;
    @SerializedName("mp_auth")

    /* renamed from: h */
    private final Boolean f3500h;
    @SerializedName("install_date")

    /* renamed from: i */
    private final String f3501i;
    @SerializedName("two_week_setting")

    /* renamed from: j */
    private final Boolean f3502j;

    public RFLPrivate() {
        this((String) null, (Boolean) null, (String) null, (List) null, (String) null, (Integer) null, (List) null, (Boolean) null, (String) null, (Boolean) null, 1023, (DefaultConstructorMarker) null);
    }

    public RFLPrivate(String str, Boolean bool, String str2, List<String> list, String str3, Integer num, List<String> list2, Boolean bool2, String str4, Boolean bool3) {
        this.f3493a = str;
        this.f3494b = bool;
        this.f3495c = str2;
        this.f3496d = list;
        this.f3497e = str3;
        this.f3498f = num;
        this.f3499g = list2;
        this.f3500h = bool2;
        this.f3501i = str4;
        this.f3502j = bool3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFLPrivate(java.lang.String r12, java.lang.Boolean r13, java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.Integer r17, java.util.List r18, java.lang.Boolean r19, java.lang.String r20, java.lang.Boolean r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate.<init>(java.lang.String, java.lang.Boolean, java.lang.String, java.util.List, java.lang.String, java.lang.Integer, java.util.List, java.lang.Boolean, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFLPrivate copy$default(RFLPrivate rFLPrivate, String str, Boolean bool, String str2, List list, String str3, Integer num, List list2, Boolean bool2, String str4, Boolean bool3, int i, Object obj) {
        RFLPrivate rFLPrivate2 = rFLPrivate;
        int i2 = i;
        return rFLPrivate.copy((i2 & 1) != 0 ? rFLPrivate2.f3493a : str, (i2 & 2) != 0 ? rFLPrivate2.f3494b : bool, (i2 & 4) != 0 ? rFLPrivate2.f3495c : str2, (i2 & 8) != 0 ? rFLPrivate2.f3496d : list, (i2 & 16) != 0 ? rFLPrivate2.f3497e : str3, (i2 & 32) != 0 ? rFLPrivate2.f3498f : num, (i2 & 64) != 0 ? rFLPrivate2.f3499g : list2, (i2 & 128) != 0 ? rFLPrivate2.f3500h : bool2, (i2 & 256) != 0 ? rFLPrivate2.f3501i : str4, (i2 & 512) != 0 ? rFLPrivate2.f3502j : bool3);
    }

    public final String component1() {
        return this.f3493a;
    }

    public final Boolean component10() {
        return this.f3502j;
    }

    public final Boolean component2() {
        return this.f3494b;
    }

    public final String component3() {
        return this.f3495c;
    }

    public final List<String> component4() {
        return this.f3496d;
    }

    public final String component5() {
        return this.f3497e;
    }

    public final Integer component6() {
        return this.f3498f;
    }

    public final List<String> component7() {
        return this.f3499g;
    }

    public final Boolean component8() {
        return this.f3500h;
    }

    public final String component9() {
        return this.f3501i;
    }

    public final RFLPrivate copy(String str, Boolean bool, String str2, List<String> list, String str3, Integer num, List<String> list2, Boolean bool2, String str4, Boolean bool3) {
        return new RFLPrivate(str, bool, str2, list, str3, num, list2, bool2, str4, bool3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLPrivate)) {
            return false;
        }
        RFLPrivate rFLPrivate = (RFLPrivate) obj;
        return Intrinsics.areEqual((Object) this.f3493a, (Object) rFLPrivate.f3493a) && Intrinsics.areEqual((Object) this.f3494b, (Object) rFLPrivate.f3494b) && Intrinsics.areEqual((Object) this.f3495c, (Object) rFLPrivate.f3495c) && Intrinsics.areEqual((Object) this.f3496d, (Object) rFLPrivate.f3496d) && Intrinsics.areEqual((Object) this.f3497e, (Object) rFLPrivate.f3497e) && Intrinsics.areEqual((Object) this.f3498f, (Object) rFLPrivate.f3498f) && Intrinsics.areEqual((Object) this.f3499g, (Object) rFLPrivate.f3499g) && Intrinsics.areEqual((Object) this.f3500h, (Object) rFLPrivate.f3500h) && Intrinsics.areEqual((Object) this.f3501i, (Object) rFLPrivate.f3501i) && Intrinsics.areEqual((Object) this.f3502j, (Object) rFLPrivate.f3502j);
    }

    public final Integer getAdEntry() {
        return this.f3498f;
    }

    public final List<String> getAdvertisingIds() {
        return this.f3496d;
    }

    public final String getInstallDate() {
        return this.f3501i;
    }

    public final List<String> getJrForms() {
        return this.f3499g;
    }

    public final String getLastReadDate() {
        return this.f3495c;
    }

    public final Boolean getMpAuth() {
        return this.f3500h;
    }

    public final String getPremiumLimit() {
        return this.f3493a;
    }

    public final String getPushTokenAnd() {
        return this.f3497e;
    }

    public final Boolean getRegistUser() {
        return this.f3494b;
    }

    public final Boolean getTwoWeekSetting() {
        return this.f3502j;
    }

    public int hashCode() {
        String str = this.f3493a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.f3494b;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.f3495c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.f3496d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.f3497e;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.f3498f;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        List<String> list2 = this.f3499g;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool2 = this.f3500h;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str4 = this.f3501i;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool3 = this.f3502j;
        if (bool3 != null) {
            i = bool3.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLPrivate(premiumLimit=");
        a.append(this.f3493a);
        a.append(", registUser=");
        a.append(this.f3494b);
        a.append(", lastReadDate=");
        a.append(this.f3495c);
        a.append(", advertisingIds=");
        a.append(this.f3496d);
        a.append(", pushTokenAnd=");
        a.append(this.f3497e);
        a.append(", adEntry=");
        a.append(this.f3498f);
        a.append(", jrForms=");
        a.append(this.f3499g);
        a.append(", mpAuth=");
        a.append(this.f3500h);
        a.append(", installDate=");
        a.append(this.f3501i);
        a.append(", twoWeekSetting=");
        a.append(this.f3502j);
        a.append(")");
        return a.toString();
    }
}
