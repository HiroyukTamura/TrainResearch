/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u0014"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteBoundsCalculator;", "", "()V", "cellLineSpacing", "", "getCellLineSpacing", "()F", "cellWidth", "getCellWidth", "calculateLineHeight", "", "scale", "containerHeight", "lines", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getDpToPixel", "value", "getLineBarCount", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    public static final a a = new a(null);
    private final float b = 64.0f;
    private final float c = 20.0f;

    private final int a(int n2, float f2) {
        return (int)((float)n2 * f2 + 0.5f);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final int a(List<RailwayLine> var1_1) {
        var6_2 = (Collection)var1_1;
        if (var6_2.size() == 1) {
            return 2;
        }
        var1_1 = ((Iterable)var1_1).iterator();
        var3_3 = 0;
        var2_4 = 0;
        while (var1_1.hasNext() != false) {
            var7_7 = (RailwayLine)var1_1.next();
            if (var2_4 == 0 || var2_4 == var6_2.size() - 1) ** GOTO lbl-1000
            var5_6 = var7_7.getDirectOperationDeparture();
            if (var7_7.getDirectOperationArrival() ^ var5_6) lbl-1000: // 2 sources:
            {
                var4_5 = 1;
            } else {
                var4_5 = 2;
            }
            var3_3 += var4_5;
            ++var2_4;
        }
        return var3_3;
    }

    public final float a() {
        return this.b;
    }

    public final int a(float f2, int n2, List<RailwayLine> list) {
        j.b(list, "lines");
        int n3 = this.a(32, f2);
        int n4 = this.a(32, f2);
        int n5 = this.a(64, f2);
        int n6 = this.a(1, f2);
        n3 = ((Collection)list).size() * (n3 + n4);
        if ((n2 -= n5) <= n3) {
            return n6;
        }
        if ((n2 = (n2 - n3) / this.a(list)) <= n6) {
            return n6;
        }
        return n2;
    }

    public final float b() {
        return this.c;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteBoundsCalculator$Companion;", "", "()V", "accuracyHeight", "", "arrivalTimeHeight", "cellHeightWithoutRailwayLinesView", "departureTimeHeight", "earliestToArriveHeight", "earliestToArrivePaddingBottom", "fareHeight", "gapOfAccuracyAndDepartureTime", "gapOfArrivalTimeAndFare", "gapOfDepartureTimeAndRailwayLinesView", "gapOfFareAndEarliestToArrive", "gapOfRailwayLinesViewAndArrivalTime", "routeListItemPaddingTop", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

