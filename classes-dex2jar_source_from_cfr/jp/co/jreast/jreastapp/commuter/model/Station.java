/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/Station;", "Ljava/io/Serializable;", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class Station
implements Serializable {
    private final String code;
    private final String name;

    public Station(String string2, String string3) {
        j.b(string2, "code");
        j.b(string3, "name");
        this.code = string2;
        this.name = string3;
    }

    public static /* synthetic */ Station copy$default(Station station, String string2, String string3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = station.code;
        }
        if ((n2 & 2) != 0) {
            string3 = station.name;
        }
        return station.copy(string2, string3);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final Station copy(String string2, String string3) {
        j.b(string2, "code");
        j.b(string3, "name");
        return new Station(string2, string3);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof Station)) break block3;
                object = (Station)object;
                if (j.a((Object)this.code, (Object)((Station)object).code) && j.a((Object)this.name, (Object)((Station)object).name)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String string2 = this.code;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.name;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Station(code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

