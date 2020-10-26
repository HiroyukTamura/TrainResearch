/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import com.b.a.e;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.d.a;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J\u0010\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0002J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u000bH\u00c6\u0003J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\bH\u00c6\u0003J\t\u00108\u001a\u00020\bH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\bH\u00c6\u0003J\t\u0010;\u001a\u00020\bH\u00c6\u0003J\t\u0010<\u001a\u00020\u000bH\u00c6\u0003J\t\u0010=\u001a\u00020\u000bH\u00c6\u0003J}\u0010>\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010AH\u00d6\u0003J\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\t\u0010D\u001a\u00020EH\u00d6\u0001J\u0010\u0010F\u001a\u00020G2\b\u0010@\u001a\u0004\u0018\u00010\u0000J\u0010\u0010H\u001a\u00020G2\b\u0010@\u001a\u0004\u0018\u00010\u0000J\t\u0010I\u001a\u00020\bH\u00d6\u0001J\u0006\u0010J\u001a\u00020ER\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"\u00a8\u0006K"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/Route;", "Ljava/io/Serializable;", "lines", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "accuracy", "Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "fare", "", "fareIc", "earliestToArrive", "", "transferCount", "previousNextKey", "shortestTime", "cheapestCash", "cheapestICCard", "minimumTransfer", "(Ljava/util/List;Ljp/co/jreast/jreastapp/commuter/model/Accuracy;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZZZ)V", "getAccuracy", "()Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "setAccuracy", "(Ljp/co/jreast/jreastapp/commuter/model/Accuracy;)V", "getCheapestCash", "()Z", "setCheapestCash", "(Z)V", "getCheapestICCard", "setCheapestICCard", "getEarliestToArrive", "setEarliestToArrive", "getFare", "()Ljava/lang/String;", "setFare", "(Ljava/lang/String;)V", "getFareIc", "setFareIc", "getLines", "()Ljava/util/List;", "setLines", "(Ljava/util/List;)V", "getMinimumTransfer", "setMinimumTransfer", "getPreviousNextKey", "setPreviousNextKey", "getShortestTime", "setShortestTime", "getTransferCount", "setTransferCount", "addSeparator", "number", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "fareIcWithSeparator", "fareWithSeparator", "hashCode", "", "minutesUntilArrivalOf", "", "minutesUntilDepartureOf", "toString", "travelTime", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class Route
implements Serializable {
    private Accuracy accuracy;
    private boolean cheapestCash;
    private boolean cheapestICCard;
    private boolean earliestToArrive;
    private String fare;
    private String fareIc;
    private List<RailwayLine> lines;
    private boolean minimumTransfer;
    private String previousNextKey;
    private boolean shortestTime;
    private String transferCount;

    public Route(@e(a="lines") List<RailwayLine> list, Accuracy accuracy, String string2, String string3, boolean bl2, String string4, String string5, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        j.b(list, "lines");
        j.b(accuracy, "accuracy");
        j.b(string2, "fare");
        j.b(string3, "fareIc");
        j.b(string4, "transferCount");
        j.b(string5, "previousNextKey");
        this.lines = list;
        this.accuracy = accuracy;
        this.fare = string2;
        this.fareIc = string3;
        this.earliestToArrive = bl2;
        this.transferCount = string4;
        this.previousNextKey = string5;
        this.shortestTime = bl3;
        this.cheapestCash = bl4;
        this.cheapestICCard = bl5;
        this.minimumTransfer = bl6;
    }

    public /* synthetic */ Route(List list, Accuracy accuracy, String string2, String string3, boolean bl2, String string4, String string5, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n2, g g2) {
        if ((n2 & 16) != 0) {
            bl2 = false;
        }
        if ((n2 & 128) != 0) {
            bl3 = false;
        }
        if ((n2 & 256) != 0) {
            bl4 = false;
        }
        if ((n2 & 512) != 0) {
            bl5 = false;
        }
        if ((n2 & 1024) != 0) {
            bl6 = false;
        }
        this(list, accuracy, string2, string3, bl2, string4, string5, bl3, bl4, bl5, bl6);
    }

    private final String addSeparator(String string2) {
        Object[] arrobject = y.a;
        arrobject = new Object[]{Integer.parseInt(string2)};
        string2 = String.format("%,d", Arrays.copyOf(arrobject, arrobject.length));
        j.a((Object)string2, "java.lang.String.format(format, *args)");
        return string2;
    }

    public static /* synthetic */ Route copy$default(Route route, List list, Accuracy accuracy, String string2, String string3, boolean bl2, String string4, String string5, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n2, Object object) {
        block10 : {
            if ((n2 & 1) != 0) {
                list = route.lines;
            }
            if ((n2 & 2) != 0) {
                accuracy = route.accuracy;
            }
            if ((n2 & 4) != 0) {
                string2 = route.fare;
            }
            if ((n2 & 8) != 0) {
                string3 = route.fareIc;
            }
            if ((n2 & 16) != 0) {
                bl2 = route.earliestToArrive;
            }
            if ((n2 & 32) != 0) {
                string4 = route.transferCount;
            }
            if ((n2 & 64) != 0) {
                string5 = route.previousNextKey;
            }
            if ((n2 & 128) != 0) {
                bl3 = route.shortestTime;
            }
            if ((n2 & 256) != 0) {
                bl4 = route.cheapestCash;
            }
            if ((n2 & 512) != 0) {
                bl5 = route.cheapestICCard;
            }
            if ((n2 & 1024) == 0) break block10;
            bl6 = route.minimumTransfer;
        }
        return route.copy(list, accuracy, string2, string3, bl2, string4, string5, bl3, bl4, bl5, bl6);
    }

    public final List<RailwayLine> component1() {
        return this.lines;
    }

    public final boolean component10() {
        return this.cheapestICCard;
    }

    public final boolean component11() {
        return this.minimumTransfer;
    }

    public final Accuracy component2() {
        return this.accuracy;
    }

    public final String component3() {
        return this.fare;
    }

    public final String component4() {
        return this.fareIc;
    }

    public final boolean component5() {
        return this.earliestToArrive;
    }

    public final String component6() {
        return this.transferCount;
    }

    public final String component7() {
        return this.previousNextKey;
    }

    public final boolean component8() {
        return this.shortestTime;
    }

    public final boolean component9() {
        return this.cheapestCash;
    }

    public final Route copy(@e(a="lines") List<RailwayLine> list, Accuracy accuracy, String string2, String string3, boolean bl2, String string4, String string5, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        j.b(list, "lines");
        j.b(accuracy, "accuracy");
        j.b(string2, "fare");
        j.b(string3, "fareIc");
        j.b(string4, "transferCount");
        j.b(string5, "previousNextKey");
        return new Route(list, accuracy, string2, string3, bl2, string4, string5, bl3, bl4, bl5, bl6);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof Route) {
                boolean bl2;
                object = (Route)object;
                if (j.a(this.lines, ((Route)object).lines) && j.a((Object)this.accuracy, (Object)((Route)object).accuracy) && j.a((Object)this.fare, (Object)((Route)object).fare) && j.a((Object)this.fareIc, (Object)((Route)object).fareIc) && (bl2 = this.earliestToArrive == ((Route)object).earliestToArrive) && j.a((Object)this.transferCount, (Object)((Route)object).transferCount) && j.a((Object)this.previousNextKey, (Object)((Route)object).previousNextKey) && (bl2 = this.shortestTime == ((Route)object).shortestTime) && (bl2 = this.cheapestCash == ((Route)object).cheapestCash) && (bl2 = this.cheapestICCard == ((Route)object).cheapestICCard) && (bl2 = this.minimumTransfer == ((Route)object).minimumTransfer)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String fareIcWithSeparator() {
        return this.addSeparator(this.fareIc);
    }

    public final String fareWithSeparator() {
        return this.addSeparator(this.fare);
    }

    public final Accuracy getAccuracy() {
        return this.accuracy;
    }

    public final boolean getCheapestCash() {
        return this.cheapestCash;
    }

    public final boolean getCheapestICCard() {
        return this.cheapestICCard;
    }

    public final boolean getEarliestToArrive() {
        return this.earliestToArrive;
    }

    public final String getFare() {
        return this.fare;
    }

    public final String getFareIc() {
        return this.fareIc;
    }

    public final List<RailwayLine> getLines() {
        return this.lines;
    }

    public final boolean getMinimumTransfer() {
        return this.minimumTransfer;
    }

    public final String getPreviousNextKey() {
        return this.previousNextKey;
    }

    public final boolean getShortestTime() {
        return this.shortestTime;
    }

    public final String getTransferCount() {
        return this.transferCount;
    }

    public int hashCode() {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public final float minutesUntilArrivalOf(Route object) {
        Calendar calendar = m.h(this.lines).getTo().dateTime();
        object = object != null && (object = ((Route)object).lines) != null && (object = (RailwayLine)m.h(object)) != null && (object = ((RailwayLine)object).getTo()) != null ? ((BoardingStation)object).dateTime() : null;
        if (calendar != null && object != null) {
            return new a().a((Calendar)object, calendar);
        }
        return 0.0f;
    }

    public final float minutesUntilDepartureOf(Route object) {
        Calendar calendar = m.f(this.lines).getFrom().dateTime();
        object = object != null && (object = ((Route)object).lines) != null && (object = (RailwayLine)m.f(object)) != null && (object = ((RailwayLine)object).getFrom()) != null ? ((BoardingStation)object).dateTime() : null;
        if (calendar != null && object != null) {
            return new a().a((Calendar)object, calendar);
        }
        return 0.0f;
    }

    public final void setAccuracy(Accuracy accuracy) {
        j.b(accuracy, "<set-?>");
        this.accuracy = accuracy;
    }

    public final void setCheapestCash(boolean bl2) {
        this.cheapestCash = bl2;
    }

    public final void setCheapestICCard(boolean bl2) {
        this.cheapestICCard = bl2;
    }

    public final void setEarliestToArrive(boolean bl2) {
        this.earliestToArrive = bl2;
    }

    public final void setFare(String string2) {
        j.b(string2, "<set-?>");
        this.fare = string2;
    }

    public final void setFareIc(String string2) {
        j.b(string2, "<set-?>");
        this.fareIc = string2;
    }

    public final void setLines(List<RailwayLine> list) {
        j.b(list, "<set-?>");
        this.lines = list;
    }

    public final void setMinimumTransfer(boolean bl2) {
        this.minimumTransfer = bl2;
    }

    public final void setPreviousNextKey(String string2) {
        j.b(string2, "<set-?>");
        this.previousNextKey = string2;
    }

    public final void setShortestTime(boolean bl2) {
        this.shortestTime = bl2;
    }

    public final void setTransferCount(String string2) {
        j.b(string2, "<set-?>");
        this.transferCount = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route(lines=");
        stringBuilder.append(this.lines);
        stringBuilder.append(", accuracy=");
        stringBuilder.append(this.accuracy);
        stringBuilder.append(", fare=");
        stringBuilder.append(this.fare);
        stringBuilder.append(", fareIc=");
        stringBuilder.append(this.fareIc);
        stringBuilder.append(", earliestToArrive=");
        stringBuilder.append(this.earliestToArrive);
        stringBuilder.append(", transferCount=");
        stringBuilder.append(this.transferCount);
        stringBuilder.append(", previousNextKey=");
        stringBuilder.append(this.previousNextKey);
        stringBuilder.append(", shortestTime=");
        stringBuilder.append(this.shortestTime);
        stringBuilder.append(", cheapestCash=");
        stringBuilder.append(this.cheapestCash);
        stringBuilder.append(", cheapestICCard=");
        stringBuilder.append(this.cheapestICCard);
        stringBuilder.append(", minimumTransfer=");
        stringBuilder.append(this.minimumTransfer);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int travelTime() {
        return Integer.parseInt(this.accuracy.getHour()) * 60 + Integer.parseInt(this.accuracy.getMin());
    }
}

