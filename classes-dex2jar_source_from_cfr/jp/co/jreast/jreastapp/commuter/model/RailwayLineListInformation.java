/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.model.RailwayListKind;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RailwayLineListInformation;", "", "lines", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "kind", "Ljp/co/jreast/jreastapp/commuter/model/RailwayListKind;", "(Ljava/util/List;Ljp/co/jreast/jreastapp/commuter/model/RailwayListKind;)V", "getKind", "()Ljp/co/jreast/jreastapp/commuter/model/RailwayListKind;", "setKind", "(Ljp/co/jreast/jreastapp/commuter/model/RailwayListKind;)V", "getLines", "()Ljava/util/List;", "setLines", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RailwayLineListInformation {
    private RailwayListKind kind;
    private List<RailwayLineInformation> lines;

    public RailwayLineListInformation(List<RailwayLineInformation> list, RailwayListKind railwayListKind) {
        j.b(list, "lines");
        j.b(railwayListKind, "kind");
        this.lines = list;
        this.kind = railwayListKind;
    }

    public static /* synthetic */ RailwayLineListInformation copy$default(RailwayLineListInformation railwayLineListInformation, List list, RailwayListKind railwayListKind, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = railwayLineListInformation.lines;
        }
        if ((n2 & 2) != 0) {
            railwayListKind = railwayLineListInformation.kind;
        }
        return railwayLineListInformation.copy(list, railwayListKind);
    }

    public final List<RailwayLineInformation> component1() {
        return this.lines;
    }

    public final RailwayListKind component2() {
        return this.kind;
    }

    public final RailwayLineListInformation copy(List<RailwayLineInformation> list, RailwayListKind railwayListKind) {
        j.b(list, "lines");
        j.b(railwayListKind, "kind");
        return new RailwayLineListInformation(list, railwayListKind);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof RailwayLineListInformation)) break block3;
                object = (RailwayLineListInformation)object;
                if (j.a(this.lines, ((RailwayLineListInformation)object).lines) && j.a((Object)this.kind, (Object)((RailwayLineListInformation)object).kind)) break block2;
            }
            return false;
        }
        return true;
    }

    public final RailwayListKind getKind() {
        return this.kind;
    }

    public final List<RailwayLineInformation> getLines() {
        return this.lines;
    }

    public int hashCode() {
        Object object = this.lines;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.kind;
        if (object != null) {
            n2 = object.hashCode();
        }
        return n3 * 31 + n2;
    }

    public final void setKind(RailwayListKind railwayListKind) {
        j.b(railwayListKind, "<set-?>");
        this.kind = railwayListKind;
    }

    public final void setLines(List<RailwayLineInformation> list) {
        j.b(list, "<set-?>");
        this.lines = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RailwayLineListInformation(lines=");
        stringBuilder.append(this.lines);
        stringBuilder.append(", kind=");
        stringBuilder.append(this.kind);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

