/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001b"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RailwayListKind;", "", "kindId", "", "kindName", "", "appName", "(ILjava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getKindId", "()I", "setKindId", "(I)V", "getKindName", "setKindName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RailwayListKind {
    private String appName;
    private int kindId;
    private String kindName;

    public RailwayListKind(int n2, String string2, String string3) {
        j.b(string2, "kindName");
        j.b(string3, "appName");
        this.kindId = n2;
        this.kindName = string2;
        this.appName = string3;
    }

    public /* synthetic */ RailwayListKind(int n2, String string2, String string3, int n3, g g2) {
        if ((n3 & 4) != 0) {
            string3 = "";
        }
        this(n2, string2, string3);
    }

    public static /* synthetic */ RailwayListKind copy$default(RailwayListKind railwayListKind, int n2, String string2, String string3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = railwayListKind.kindId;
        }
        if ((n3 & 2) != 0) {
            string2 = railwayListKind.kindName;
        }
        if ((n3 & 4) != 0) {
            string3 = railwayListKind.appName;
        }
        return railwayListKind.copy(n2, string2, string3);
    }

    public final int component1() {
        return this.kindId;
    }

    public final String component2() {
        return this.kindName;
    }

    public final String component3() {
        return this.appName;
    }

    public final RailwayListKind copy(int n2, String string2, String string3) {
        j.b(string2, "kindName");
        j.b(string3, "appName");
        return new RailwayListKind(n2, string2, string3);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof RailwayListKind) {
                object = (RailwayListKind)object;
                boolean bl2 = this.kindId == ((RailwayListKind)object).kindId;
                if (bl2 && j.a((Object)this.kindName, (Object)((RailwayListKind)object).kindName) && j.a((Object)this.appName, (Object)((RailwayListKind)object).appName)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getKindId() {
        return this.kindId;
    }

    public final String getKindName() {
        return this.kindName;
    }

    public int hashCode() {
        int n2 = this.kindId;
        String string2 = this.kindName;
        int n3 = 0;
        int n4 = string2 != null ? string2.hashCode() : 0;
        string2 = this.appName;
        if (string2 != null) {
            n3 = string2.hashCode();
        }
        return (n2 * 31 + n4) * 31 + n3;
    }

    public final void setAppName(String string2) {
        j.b(string2, "<set-?>");
        this.appName = string2;
    }

    public final void setKindId(int n2) {
        this.kindId = n2;
    }

    public final void setKindName(String string2) {
        j.b(string2, "<set-?>");
        this.kindName = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RailwayListKind(kindId=");
        stringBuilder.append(this.kindId);
        stringBuilder.append(", kindName=");
        stringBuilder.append(this.kindName);
        stringBuilder.append(", appName=");
        stringBuilder.append(this.appName);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

