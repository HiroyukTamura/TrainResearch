package p043jp.reifrontier.gym.domain.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGSetting;", "", "type", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType;", "title", "", "switch", "", "on", "linkType", "", "link", "(Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType;Ljava/lang/String;ZZILjava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getLinkType", "()I", "getOn", "()Z", "getSwitch", "getTitle", "getType", "()Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGSetting */
public final class RFGSetting {
    private final String link;
    private final int linkType;

    /* renamed from: on */
    private final boolean f2964on;

    /* renamed from: switch  reason: not valid java name */
    private final boolean f4372switch;
    private final String title;
    private final RFGSettingAdapter.SettingViewType type;

    public RFGSetting() {
        this((RFGSettingAdapter.SettingViewType) null, (String) null, false, false, 0, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public RFGSetting(RFGSettingAdapter.SettingViewType settingViewType, String str, boolean z, boolean z2, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(settingViewType, "type");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "link");
        this.type = settingViewType;
        this.title = str;
        this.f4372switch = z;
        this.f2964on = z2;
        this.linkType = i;
        this.link = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGSetting(p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter.SettingViewType r5, java.lang.String r6, boolean r7, boolean r8, int r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$SettingViewType r5 = p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter.SettingViewType.SECTION
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            java.lang.String r6 = "title"
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            r0 = 0
            if (r6 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r9
        L_0x0022:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            java.lang.String r10 = ""
        L_0x0028:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r0
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.app.RFGSetting.<init>(jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$SettingViewType, java.lang.String, boolean, boolean, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGSetting copy$default(RFGSetting rFGSetting, RFGSettingAdapter.SettingViewType settingViewType, String str, boolean z, boolean z2, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            settingViewType = rFGSetting.type;
        }
        if ((i2 & 2) != 0) {
            str = rFGSetting.title;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            z = rFGSetting.f4372switch;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = rFGSetting.f2964on;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            i = rFGSetting.linkType;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str2 = rFGSetting.link;
        }
        return rFGSetting.copy(settingViewType, str3, z3, z4, i3, str2);
    }

    public final RFGSettingAdapter.SettingViewType component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.f4372switch;
    }

    public final boolean component4() {
        return this.f2964on;
    }

    public final int component5() {
        return this.linkType;
    }

    public final String component6() {
        return this.link;
    }

    public final RFGSetting copy(RFGSettingAdapter.SettingViewType settingViewType, String str, boolean z, boolean z2, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(settingViewType, "type");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "link");
        return new RFGSetting(settingViewType, str, z, z2, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGSetting)) {
            return false;
        }
        RFGSetting rFGSetting = (RFGSetting) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) rFGSetting.type) && Intrinsics.areEqual((Object) this.title, (Object) rFGSetting.title) && this.f4372switch == rFGSetting.f4372switch && this.f2964on == rFGSetting.f2964on && this.linkType == rFGSetting.linkType && Intrinsics.areEqual((Object) this.link, (Object) rFGSetting.link);
    }

    public final String getLink() {
        return this.link;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final boolean getOn() {
        return this.f2964on;
    }

    public final boolean getSwitch() {
        return this.f4372switch;
    }

    public final String getTitle() {
        return this.title;
    }

    public final RFGSettingAdapter.SettingViewType getType() {
        return this.type;
    }

    public int hashCode() {
        RFGSettingAdapter.SettingViewType settingViewType = this.type;
        int i = 0;
        int hashCode = (settingViewType != null ? settingViewType.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.f4372switch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.f2964on;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (((i2 + (z2 ? 1 : 0)) * 31) + this.linkType) * 31;
        String str2 = this.link;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGSetting(type=");
        a.append(this.type);
        a.append(", title=");
        a.append(this.title);
        a.append(", switch=");
        a.append(this.f4372switch);
        a.append(", on=");
        a.append(this.f2964on);
        a.append(", linkType=");
        a.append(this.linkType);
        a.append(", link=");
        return C0681a.m324a(a, this.link, ")");
    }
}
