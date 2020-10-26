/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b8\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0013H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\u00a9\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u0010J\u001a\u00020\u00132\b\u0010K\u001a\u0004\u0018\u00010LH\u00d6\u0003J\t\u0010M\u001a\u00020NH\u00d6\u0001J\t\u0010O\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018\u00a8\u0006P"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "Ljava/io/Serializable;", "delayIcon", "", "delayStatus", "delayReason", "delayMinute", "delayDirection", "delayFromStation", "delayToStation", "delayDetailText", "resumeTime", "occurrenceTime", "ekitanId", "lineName", "lineColor", "companyId", "iconName", "detailVisibility", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCompanyId", "()Ljava/lang/String;", "setCompanyId", "(Ljava/lang/String;)V", "getDelayDetailText", "setDelayDetailText", "getDelayDirection", "setDelayDirection", "getDelayFromStation", "setDelayFromStation", "getDelayIcon", "setDelayIcon", "getDelayMinute", "setDelayMinute", "getDelayReason", "setDelayReason", "getDelayStatus", "setDelayStatus", "getDelayToStation", "setDelayToStation", "getDetailVisibility", "()Z", "setDetailVisibility", "(Z)V", "getEkitanId", "setEkitanId", "getIconName", "setIconName", "getLineColor", "setLineColor", "getLineName", "setLineName", "getOccurrenceTime", "setOccurrenceTime", "getResumeTime", "setResumeTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class LineServiceStatus
implements Serializable {
    private String companyId;
    private String delayDetailText;
    private String delayDirection;
    private String delayFromStation;
    private String delayIcon;
    private String delayMinute;
    private String delayReason;
    private String delayStatus;
    private String delayToStation;
    private boolean detailVisibility;
    private String ekitanId;
    private String iconName;
    private String lineColor;
    private String lineName;
    private String occurrenceTime;
    private String resumeTime;

    public LineServiceStatus(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, boolean bl2) {
        j.b(string2, "delayIcon");
        j.b(string3, "delayStatus");
        j.b(string4, "delayReason");
        j.b(string5, "delayMinute");
        j.b(string6, "delayDirection");
        j.b(string7, "delayFromStation");
        j.b(string8, "delayToStation");
        j.b(string9, "delayDetailText");
        j.b(string10, "resumeTime");
        j.b(string11, "occurrenceTime");
        j.b(string12, "ekitanId");
        j.b(string13, "lineName");
        j.b(string14, "lineColor");
        j.b(string15, "companyId");
        j.b(string16, "iconName");
        this.delayIcon = string2;
        this.delayStatus = string3;
        this.delayReason = string4;
        this.delayMinute = string5;
        this.delayDirection = string6;
        this.delayFromStation = string7;
        this.delayToStation = string8;
        this.delayDetailText = string9;
        this.resumeTime = string10;
        this.occurrenceTime = string11;
        this.ekitanId = string12;
        this.lineName = string13;
        this.lineColor = string14;
        this.companyId = string15;
        this.iconName = string16;
        this.detailVisibility = bl2;
    }

    public /* synthetic */ LineServiceStatus(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, boolean bl2, int n2, g g2) {
        if ((n2 & 32768) != 0) {
            bl2 = false;
        }
        this(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, bl2);
    }

    public static /* synthetic */ LineServiceStatus copy$default(LineServiceStatus lineServiceStatus, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, boolean bl2, int n2, Object object) {
        block15 : {
            if ((n2 & 1) != 0) {
                string2 = lineServiceStatus.delayIcon;
            }
            if ((n2 & 2) != 0) {
                string3 = lineServiceStatus.delayStatus;
            }
            if ((n2 & 4) != 0) {
                string4 = lineServiceStatus.delayReason;
            }
            if ((n2 & 8) != 0) {
                string5 = lineServiceStatus.delayMinute;
            }
            if ((n2 & 16) != 0) {
                string6 = lineServiceStatus.delayDirection;
            }
            if ((n2 & 32) != 0) {
                string7 = lineServiceStatus.delayFromStation;
            }
            if ((n2 & 64) != 0) {
                string8 = lineServiceStatus.delayToStation;
            }
            if ((n2 & 128) != 0) {
                string9 = lineServiceStatus.delayDetailText;
            }
            if ((n2 & 256) != 0) {
                string10 = lineServiceStatus.resumeTime;
            }
            if ((n2 & 512) != 0) {
                string11 = lineServiceStatus.occurrenceTime;
            }
            if ((n2 & 1024) != 0) {
                string12 = lineServiceStatus.ekitanId;
            }
            if ((n2 & 2048) != 0) {
                string13 = lineServiceStatus.lineName;
            }
            if ((n2 & 4096) != 0) {
                string14 = lineServiceStatus.lineColor;
            }
            if ((n2 & 8192) != 0) {
                string15 = lineServiceStatus.companyId;
            }
            if ((n2 & 16384) != 0) {
                string16 = lineServiceStatus.iconName;
            }
            if ((n2 & 32768) == 0) break block15;
            bl2 = lineServiceStatus.detailVisibility;
        }
        return lineServiceStatus.copy(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, bl2);
    }

    public final String component1() {
        return this.delayIcon;
    }

    public final String component10() {
        return this.occurrenceTime;
    }

    public final String component11() {
        return this.ekitanId;
    }

    public final String component12() {
        return this.lineName;
    }

    public final String component13() {
        return this.lineColor;
    }

    public final String component14() {
        return this.companyId;
    }

    public final String component15() {
        return this.iconName;
    }

    public final boolean component16() {
        return this.detailVisibility;
    }

    public final String component2() {
        return this.delayStatus;
    }

    public final String component3() {
        return this.delayReason;
    }

    public final String component4() {
        return this.delayMinute;
    }

    public final String component5() {
        return this.delayDirection;
    }

    public final String component6() {
        return this.delayFromStation;
    }

    public final String component7() {
        return this.delayToStation;
    }

    public final String component8() {
        return this.delayDetailText;
    }

    public final String component9() {
        return this.resumeTime;
    }

    public final LineServiceStatus copy(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, boolean bl2) {
        j.b(string2, "delayIcon");
        j.b(string3, "delayStatus");
        j.b(string4, "delayReason");
        j.b(string5, "delayMinute");
        j.b(string6, "delayDirection");
        j.b(string7, "delayFromStation");
        j.b(string8, "delayToStation");
        j.b(string9, "delayDetailText");
        j.b(string10, "resumeTime");
        j.b(string11, "occurrenceTime");
        j.b(string12, "ekitanId");
        j.b(string13, "lineName");
        j.b(string14, "lineColor");
        j.b(string15, "companyId");
        j.b(string16, "iconName");
        return new LineServiceStatus(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, bl2);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof LineServiceStatus) {
                boolean bl2;
                object = (LineServiceStatus)object;
                if (j.a((Object)this.delayIcon, (Object)((LineServiceStatus)object).delayIcon) && j.a((Object)this.delayStatus, (Object)((LineServiceStatus)object).delayStatus) && j.a((Object)this.delayReason, (Object)((LineServiceStatus)object).delayReason) && j.a((Object)this.delayMinute, (Object)((LineServiceStatus)object).delayMinute) && j.a((Object)this.delayDirection, (Object)((LineServiceStatus)object).delayDirection) && j.a((Object)this.delayFromStation, (Object)((LineServiceStatus)object).delayFromStation) && j.a((Object)this.delayToStation, (Object)((LineServiceStatus)object).delayToStation) && j.a((Object)this.delayDetailText, (Object)((LineServiceStatus)object).delayDetailText) && j.a((Object)this.resumeTime, (Object)((LineServiceStatus)object).resumeTime) && j.a((Object)this.occurrenceTime, (Object)((LineServiceStatus)object).occurrenceTime) && j.a((Object)this.ekitanId, (Object)((LineServiceStatus)object).ekitanId) && j.a((Object)this.lineName, (Object)((LineServiceStatus)object).lineName) && j.a((Object)this.lineColor, (Object)((LineServiceStatus)object).lineColor) && j.a((Object)this.companyId, (Object)((LineServiceStatus)object).companyId) && j.a((Object)this.iconName, (Object)((LineServiceStatus)object).iconName) && (bl2 = this.detailVisibility == ((LineServiceStatus)object).detailVisibility)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String getCompanyId() {
        return this.companyId;
    }

    public final String getDelayDetailText() {
        return this.delayDetailText;
    }

    public final String getDelayDirection() {
        return this.delayDirection;
    }

    public final String getDelayFromStation() {
        return this.delayFromStation;
    }

    public final String getDelayIcon() {
        return this.delayIcon;
    }

    public final String getDelayMinute() {
        return this.delayMinute;
    }

    public final String getDelayReason() {
        return this.delayReason;
    }

    public final String getDelayStatus() {
        return this.delayStatus;
    }

    public final String getDelayToStation() {
        return this.delayToStation;
    }

    public final boolean getDetailVisibility() {
        return this.detailVisibility;
    }

    public final String getEkitanId() {
        return this.ekitanId;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final String getLineColor() {
        return this.lineColor;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final String getOccurrenceTime() {
        return this.occurrenceTime;
    }

    public final String getResumeTime() {
        return this.resumeTime;
    }

    public int hashCode() {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public final void setCompanyId(String string2) {
        j.b(string2, "<set-?>");
        this.companyId = string2;
    }

    public final void setDelayDetailText(String string2) {
        j.b(string2, "<set-?>");
        this.delayDetailText = string2;
    }

    public final void setDelayDirection(String string2) {
        j.b(string2, "<set-?>");
        this.delayDirection = string2;
    }

    public final void setDelayFromStation(String string2) {
        j.b(string2, "<set-?>");
        this.delayFromStation = string2;
    }

    public final void setDelayIcon(String string2) {
        j.b(string2, "<set-?>");
        this.delayIcon = string2;
    }

    public final void setDelayMinute(String string2) {
        j.b(string2, "<set-?>");
        this.delayMinute = string2;
    }

    public final void setDelayReason(String string2) {
        j.b(string2, "<set-?>");
        this.delayReason = string2;
    }

    public final void setDelayStatus(String string2) {
        j.b(string2, "<set-?>");
        this.delayStatus = string2;
    }

    public final void setDelayToStation(String string2) {
        j.b(string2, "<set-?>");
        this.delayToStation = string2;
    }

    public final void setDetailVisibility(boolean bl2) {
        this.detailVisibility = bl2;
    }

    public final void setEkitanId(String string2) {
        j.b(string2, "<set-?>");
        this.ekitanId = string2;
    }

    public final void setIconName(String string2) {
        j.b(string2, "<set-?>");
        this.iconName = string2;
    }

    public final void setLineColor(String string2) {
        j.b(string2, "<set-?>");
        this.lineColor = string2;
    }

    public final void setLineName(String string2) {
        j.b(string2, "<set-?>");
        this.lineName = string2;
    }

    public final void setOccurrenceTime(String string2) {
        j.b(string2, "<set-?>");
        this.occurrenceTime = string2;
    }

    public final void setResumeTime(String string2) {
        j.b(string2, "<set-?>");
        this.resumeTime = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LineServiceStatus(delayIcon=");
        stringBuilder.append(this.delayIcon);
        stringBuilder.append(", delayStatus=");
        stringBuilder.append(this.delayStatus);
        stringBuilder.append(", delayReason=");
        stringBuilder.append(this.delayReason);
        stringBuilder.append(", delayMinute=");
        stringBuilder.append(this.delayMinute);
        stringBuilder.append(", delayDirection=");
        stringBuilder.append(this.delayDirection);
        stringBuilder.append(", delayFromStation=");
        stringBuilder.append(this.delayFromStation);
        stringBuilder.append(", delayToStation=");
        stringBuilder.append(this.delayToStation);
        stringBuilder.append(", delayDetailText=");
        stringBuilder.append(this.delayDetailText);
        stringBuilder.append(", resumeTime=");
        stringBuilder.append(this.resumeTime);
        stringBuilder.append(", occurrenceTime=");
        stringBuilder.append(this.occurrenceTime);
        stringBuilder.append(", ekitanId=");
        stringBuilder.append(this.ekitanId);
        stringBuilder.append(", lineName=");
        stringBuilder.append(this.lineName);
        stringBuilder.append(", lineColor=");
        stringBuilder.append(this.lineColor);
        stringBuilder.append(", companyId=");
        stringBuilder.append(this.companyId);
        stringBuilder.append(", iconName=");
        stringBuilder.append(this.iconName);
        stringBuilder.append(", detailVisibility=");
        stringBuilder.append(this.detailVisibility);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

