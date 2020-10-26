/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "Ljava/io/Serializable;", "delayIcon", "", "delayStatus", "delayReason", "delayMinute", "delayDirection", "delayFromStation", "delayToStation", "delayDetailText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDelayDetailText", "()Ljava/lang/String;", "setDelayDetailText", "(Ljava/lang/String;)V", "getDelayDirection", "setDelayDirection", "getDelayFromStation", "setDelayFromStation", "getDelayIcon", "setDelayIcon", "getDelayMinute", "setDelayMinute", "getDelayReason", "setDelayReason", "getDelayStatus", "setDelayStatus", "getDelayToStation", "setDelayToStation", "clearStatus", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ServiceStatus
implements Serializable {
    private String delayDetailText;
    private String delayDirection;
    private String delayFromStation;
    private String delayIcon;
    private String delayMinute;
    private String delayReason;
    private String delayStatus;
    private String delayToStation;

    public ServiceStatus(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        j.b(string2, "delayIcon");
        j.b(string3, "delayStatus");
        j.b(string4, "delayReason");
        j.b(string5, "delayMinute");
        j.b(string6, "delayDirection");
        j.b(string7, "delayFromStation");
        j.b(string8, "delayToStation");
        j.b(string9, "delayDetailText");
        this.delayIcon = string2;
        this.delayStatus = string3;
        this.delayReason = string4;
        this.delayMinute = string5;
        this.delayDirection = string6;
        this.delayFromStation = string7;
        this.delayToStation = string8;
        this.delayDetailText = string9;
    }

    public static /* synthetic */ ServiceStatus copy$default(ServiceStatus serviceStatus, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int n2, Object object) {
        block7 : {
            if ((n2 & 1) != 0) {
                string2 = serviceStatus.delayIcon;
            }
            if ((n2 & 2) != 0) {
                string3 = serviceStatus.delayStatus;
            }
            if ((n2 & 4) != 0) {
                string4 = serviceStatus.delayReason;
            }
            if ((n2 & 8) != 0) {
                string5 = serviceStatus.delayMinute;
            }
            if ((n2 & 16) != 0) {
                string6 = serviceStatus.delayDirection;
            }
            if ((n2 & 32) != 0) {
                string7 = serviceStatus.delayFromStation;
            }
            if ((n2 & 64) != 0) {
                string8 = serviceStatus.delayToStation;
            }
            if ((n2 & 128) == 0) break block7;
            string9 = serviceStatus.delayDetailText;
        }
        return serviceStatus.copy(string2, string3, string4, string5, string6, string7, string8, string9);
    }

    public final void clearStatus() {
        this.delayIcon = "";
        this.delayStatus = "";
        this.delayReason = "";
        this.delayMinute = "";
        this.delayDirection = "";
        this.delayFromStation = "";
        this.delayToStation = "";
        this.delayDetailText = "";
    }

    public final String component1() {
        return this.delayIcon;
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

    public final ServiceStatus copy(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        j.b(string2, "delayIcon");
        j.b(string3, "delayStatus");
        j.b(string4, "delayReason");
        j.b(string5, "delayMinute");
        j.b(string6, "delayDirection");
        j.b(string7, "delayFromStation");
        j.b(string8, "delayToStation");
        j.b(string9, "delayDetailText");
        return new ServiceStatus(string2, string3, string4, string5, string6, string7, string8, string9);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof ServiceStatus)) break block3;
                object = (ServiceStatus)object;
                if (j.a((Object)this.delayIcon, (Object)((ServiceStatus)object).delayIcon) && j.a((Object)this.delayStatus, (Object)((ServiceStatus)object).delayStatus) && j.a((Object)this.delayReason, (Object)((ServiceStatus)object).delayReason) && j.a((Object)this.delayMinute, (Object)((ServiceStatus)object).delayMinute) && j.a((Object)this.delayDirection, (Object)((ServiceStatus)object).delayDirection) && j.a((Object)this.delayFromStation, (Object)((ServiceStatus)object).delayFromStation) && j.a((Object)this.delayToStation, (Object)((ServiceStatus)object).delayToStation) && j.a((Object)this.delayDetailText, (Object)((ServiceStatus)object).delayDetailText)) break block2;
            }
            return false;
        }
        return true;
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

    public int hashCode() {
        String string2 = this.delayIcon;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayStatus;
        int n4 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayReason;
        int n5 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayMinute;
        int n6 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayDirection;
        int n7 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayFromStation;
        int n8 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayToStation;
        int n9 = string2 != null ? string2.hashCode() : 0;
        string2 = this.delayDetailText;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return ((((((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n2;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ServiceStatus(delayIcon=");
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
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

