/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import com.b.a.e;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003Jm\u0010.\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u00065"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/TrainHeaderParam;", "", "userId", "", "area", "line", "station", "at", "osType", "networkInfo", "modelName", "hostServerName", "mode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()Ljava/lang/String;", "setArea", "(Ljava/lang/String;)V", "getAt", "setAt", "getHostServerName", "setHostServerName", "getLine", "setLine", "getMode", "setMode", "getModelName", "setModelName", "getNetworkInfo", "setNetworkInfo", "getOsType", "setOsType", "getStation", "setStation", "getUserId", "setUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class TrainHeaderParam {
    private String area;
    private String at;
    private String hostServerName;
    private String line;
    private String mode;
    private String modelName;
    private String networkInfo;
    private String osType;
    private String station;
    private String userId;

    public TrainHeaderParam() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public TrainHeaderParam(@e(a="User-Id") String string2, String string3, String string4, String string5, String string6, @e(a="os_type") String string7, @e(a="network_info") String string8, @e(a="model_name") String string9, @e(a="host_server_name") String string10, String string11) {
        j.b(string2, "userId");
        j.b(string3, "area");
        j.b(string4, "line");
        j.b(string5, "station");
        j.b(string6, "at");
        j.b(string7, "osType");
        j.b(string8, "networkInfo");
        j.b(string9, "modelName");
        j.b(string10, "hostServerName");
        j.b(string11, "mode");
        this.userId = string2;
        this.area = string3;
        this.line = string4;
        this.station = string5;
        this.at = string6;
        this.osType = string7;
        this.networkInfo = string8;
        this.modelName = string9;
        this.hostServerName = string10;
        this.mode = string11;
    }

    public /* synthetic */ TrainHeaderParam(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, int n2, g g2) {
        if ((n2 & 1) != 0) {
            string2 = "";
        }
        if ((n2 & 2) != 0) {
            string3 = "";
        }
        if ((n2 & 4) != 0) {
            string4 = "";
        }
        if ((n2 & 8) != 0) {
            string5 = "";
        }
        if ((n2 & 16) != 0) {
            string6 = "";
        }
        if ((n2 & 32) != 0) {
            string7 = "";
        }
        if ((n2 & 64) != 0) {
            string8 = "";
        }
        if ((n2 & 128) != 0) {
            string9 = "";
        }
        if ((n2 & 256) != 0) {
            string10 = "/tw02/jreast_app";
        }
        if ((n2 & 512) != 0) {
            string11 = "";
        }
        this(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
    }

    public static /* synthetic */ TrainHeaderParam copy$default(TrainHeaderParam trainHeaderParam, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, int n2, Object object) {
        block9 : {
            if ((n2 & 1) != 0) {
                string2 = trainHeaderParam.userId;
            }
            if ((n2 & 2) != 0) {
                string3 = trainHeaderParam.area;
            }
            if ((n2 & 4) != 0) {
                string4 = trainHeaderParam.line;
            }
            if ((n2 & 8) != 0) {
                string5 = trainHeaderParam.station;
            }
            if ((n2 & 16) != 0) {
                string6 = trainHeaderParam.at;
            }
            if ((n2 & 32) != 0) {
                string7 = trainHeaderParam.osType;
            }
            if ((n2 & 64) != 0) {
                string8 = trainHeaderParam.networkInfo;
            }
            if ((n2 & 128) != 0) {
                string9 = trainHeaderParam.modelName;
            }
            if ((n2 & 256) != 0) {
                string10 = trainHeaderParam.hostServerName;
            }
            if ((n2 & 512) == 0) break block9;
            string11 = trainHeaderParam.mode;
        }
        return trainHeaderParam.copy(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.mode;
    }

    public final String component2() {
        return this.area;
    }

    public final String component3() {
        return this.line;
    }

    public final String component4() {
        return this.station;
    }

    public final String component5() {
        return this.at;
    }

    public final String component6() {
        return this.osType;
    }

    public final String component7() {
        return this.networkInfo;
    }

    public final String component8() {
        return this.modelName;
    }

    public final String component9() {
        return this.hostServerName;
    }

    public final TrainHeaderParam copy(@e(a="User-Id") String string2, String string3, String string4, String string5, String string6, @e(a="os_type") String string7, @e(a="network_info") String string8, @e(a="model_name") String string9, @e(a="host_server_name") String string10, String string11) {
        j.b(string2, "userId");
        j.b(string3, "area");
        j.b(string4, "line");
        j.b(string5, "station");
        j.b(string6, "at");
        j.b(string7, "osType");
        j.b(string8, "networkInfo");
        j.b(string9, "modelName");
        j.b(string10, "hostServerName");
        j.b(string11, "mode");
        return new TrainHeaderParam(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof TrainHeaderParam)) break block3;
                object = (TrainHeaderParam)object;
                if (j.a((Object)this.userId, (Object)((TrainHeaderParam)object).userId) && j.a((Object)this.area, (Object)((TrainHeaderParam)object).area) && j.a((Object)this.line, (Object)((TrainHeaderParam)object).line) && j.a((Object)this.station, (Object)((TrainHeaderParam)object).station) && j.a((Object)this.at, (Object)((TrainHeaderParam)object).at) && j.a((Object)this.osType, (Object)((TrainHeaderParam)object).osType) && j.a((Object)this.networkInfo, (Object)((TrainHeaderParam)object).networkInfo) && j.a((Object)this.modelName, (Object)((TrainHeaderParam)object).modelName) && j.a((Object)this.hostServerName, (Object)((TrainHeaderParam)object).hostServerName) && j.a((Object)this.mode, (Object)((TrainHeaderParam)object).mode)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getAt() {
        return this.at;
    }

    public final String getHostServerName() {
        return this.hostServerName;
    }

    public final String getLine() {
        return this.line;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getNetworkInfo() {
        return this.networkInfo;
    }

    public final String getOsType() {
        return this.osType;
    }

    public final String getStation() {
        return this.station;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String string2 = this.userId;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.area;
        int n4 = string2 != null ? string2.hashCode() : 0;
        string2 = this.line;
        int n5 = string2 != null ? string2.hashCode() : 0;
        string2 = this.station;
        int n6 = string2 != null ? string2.hashCode() : 0;
        string2 = this.at;
        int n7 = string2 != null ? string2.hashCode() : 0;
        string2 = this.osType;
        int n8 = string2 != null ? string2.hashCode() : 0;
        string2 = this.networkInfo;
        int n9 = string2 != null ? string2.hashCode() : 0;
        string2 = this.modelName;
        int n10 = string2 != null ? string2.hashCode() : 0;
        string2 = this.hostServerName;
        int n11 = string2 != null ? string2.hashCode() : 0;
        string2 = this.mode;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return ((((((((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n2;
    }

    public final void setArea(String string2) {
        j.b(string2, "<set-?>");
        this.area = string2;
    }

    public final void setAt(String string2) {
        j.b(string2, "<set-?>");
        this.at = string2;
    }

    public final void setHostServerName(String string2) {
        j.b(string2, "<set-?>");
        this.hostServerName = string2;
    }

    public final void setLine(String string2) {
        j.b(string2, "<set-?>");
        this.line = string2;
    }

    public final void setMode(String string2) {
        j.b(string2, "<set-?>");
        this.mode = string2;
    }

    public final void setModelName(String string2) {
        j.b(string2, "<set-?>");
        this.modelName = string2;
    }

    public final void setNetworkInfo(String string2) {
        j.b(string2, "<set-?>");
        this.networkInfo = string2;
    }

    public final void setOsType(String string2) {
        j.b(string2, "<set-?>");
        this.osType = string2;
    }

    public final void setStation(String string2) {
        j.b(string2, "<set-?>");
        this.station = string2;
    }

    public final void setUserId(String string2) {
        j.b(string2, "<set-?>");
        this.userId = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainHeaderParam(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", area=");
        stringBuilder.append(this.area);
        stringBuilder.append(", line=");
        stringBuilder.append(this.line);
        stringBuilder.append(", station=");
        stringBuilder.append(this.station);
        stringBuilder.append(", at=");
        stringBuilder.append(this.at);
        stringBuilder.append(", osType=");
        stringBuilder.append(this.osType);
        stringBuilder.append(", networkInfo=");
        stringBuilder.append(this.networkInfo);
        stringBuilder.append(", modelName=");
        stringBuilder.append(this.modelName);
        stringBuilder.append(", hostServerName=");
        stringBuilder.append(this.hostServerName);
        stringBuilder.append(", mode=");
        stringBuilder.append(this.mode);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

