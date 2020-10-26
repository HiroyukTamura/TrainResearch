/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import com.b.a.e;
import java.io.Serializable;
import java.util.Calendar;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010A\u001a\u00020\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0012H\u00c6\u0003J\t\u0010G\u001a\u00020\u0014H\u00c6\u0003J\t\u0010H\u001a\u00020\u0014H\u00c6\u0003J\t\u0010I\u001a\u00020\u0014H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u000bH\u00c6\u0003J\t\u0010Q\u001a\u00020\u000bH\u00c6\u0003J\u00b1\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u00c6\u0001J\u0013\u0010S\u001a\u00020\u00142\b\u0010T\u001a\u0004\u0018\u00010UH\u00d6\u0003J\u0006\u0010V\u001a\u00020\u0003J\t\u0010W\u001a\u00020XH\u00d6\u0001J\u0006\u0010Y\u001a\u00020\u0014J\u0006\u0010Z\u001a\u00020\u0014J\u0006\u0010[\u001a\u00020\u0014J\t\u0010\\\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010]\u001a\u00020\u0003R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u0016\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010#\"\u0004\b0\u0010%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001b\u00a8\u0006^"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "Ljava/io/Serializable;", "ekitanId", "", "jrId", "name", "kind", "railKind", "trainDirection", "boundFor", "from", "Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;", "to", "changeTime", "Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "color", "iconName", "serviceStatus", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "isPaidExpress", "", "directOperationDeparture", "directOperationArrival", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;Ljp/co/jreast/jreastapp/commuter/model/Accuracy;Ljava/lang/String;Ljava/lang/String;Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;ZZZ)V", "getBoundFor", "()Ljava/lang/String;", "setBoundFor", "(Ljava/lang/String;)V", "getChangeTime", "()Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "setChangeTime", "(Ljp/co/jreast/jreastapp/commuter/model/Accuracy;)V", "getColor", "setColor", "getDirectOperationArrival", "()Z", "setDirectOperationArrival", "(Z)V", "getDirectOperationDeparture", "setDirectOperationDeparture", "getEkitanId", "setEkitanId", "getFrom", "()Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;", "setFrom", "(Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;)V", "getIconName", "setIconName", "setPaidExpress", "getJrId", "setJrId", "getKind", "setKind", "getName", "setName", "getRailKind", "setRailKind", "getServiceStatus", "()Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "setServiceStatus", "(Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;)V", "getTo", "setTo", "getTrainDirection", "setTrainDirection", "boundForWithSuffix", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getKindAndBoundFor", "hashCode", "", "isDelayed", "isNormalPaidExpress", "isWalking", "toString", "travelTimeInMinutes", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RailwayLine
implements Serializable {
    private String boundFor;
    private Accuracy changeTime;
    private String color;
    private boolean directOperationArrival;
    private boolean directOperationDeparture;
    private String ekitanId;
    private BoardingStation from;
    private String iconName;
    private boolean isPaidExpress;
    private String jrId;
    private String kind;
    private String name;
    private String railKind;
    private ServiceStatus serviceStatus;
    private BoardingStation to;
    private String trainDirection;

    public RailwayLine(String string2, String string3, @e(a="name") String string4, String string5, String string6, String string7, String string8, BoardingStation boardingStation, BoardingStation boardingStation2, Accuracy accuracy, String string9, String string10, ServiceStatus serviceStatus, boolean bl2, boolean bl3, boolean bl4) {
        j.b(string2, "ekitanId");
        j.b(string4, "name");
        j.b(string5, "kind");
        j.b(string6, "railKind");
        j.b(string8, "boundFor");
        j.b(boardingStation, "from");
        j.b(boardingStation2, "to");
        j.b(string9, "color");
        j.b(serviceStatus, "serviceStatus");
        this.ekitanId = string2;
        this.jrId = string3;
        this.name = string4;
        this.kind = string5;
        this.railKind = string6;
        this.trainDirection = string7;
        this.boundFor = string8;
        this.from = boardingStation;
        this.to = boardingStation2;
        this.changeTime = accuracy;
        this.color = string9;
        this.iconName = string10;
        this.serviceStatus = serviceStatus;
        this.isPaidExpress = bl2;
        this.directOperationDeparture = bl3;
        this.directOperationArrival = bl4;
    }

    public static /* synthetic */ RailwayLine copy$default(RailwayLine railwayLine, String string2, String string3, String string4, String string5, String string6, String string7, String string8, BoardingStation boardingStation, BoardingStation boardingStation2, Accuracy accuracy, String string9, String string10, ServiceStatus serviceStatus, boolean bl2, boolean bl3, boolean bl4, int n2, Object object) {
        block15 : {
            if ((n2 & 1) != 0) {
                string2 = railwayLine.ekitanId;
            }
            if ((n2 & 2) != 0) {
                string3 = railwayLine.jrId;
            }
            if ((n2 & 4) != 0) {
                string4 = railwayLine.name;
            }
            if ((n2 & 8) != 0) {
                string5 = railwayLine.kind;
            }
            if ((n2 & 16) != 0) {
                string6 = railwayLine.railKind;
            }
            if ((n2 & 32) != 0) {
                string7 = railwayLine.trainDirection;
            }
            if ((n2 & 64) != 0) {
                string8 = railwayLine.boundFor;
            }
            if ((n2 & 128) != 0) {
                boardingStation = railwayLine.from;
            }
            if ((n2 & 256) != 0) {
                boardingStation2 = railwayLine.to;
            }
            if ((n2 & 512) != 0) {
                accuracy = railwayLine.changeTime;
            }
            if ((n2 & 1024) != 0) {
                string9 = railwayLine.color;
            }
            if ((n2 & 2048) != 0) {
                string10 = railwayLine.iconName;
            }
            if ((n2 & 4096) != 0) {
                serviceStatus = railwayLine.serviceStatus;
            }
            if ((n2 & 8192) != 0) {
                bl2 = railwayLine.isPaidExpress;
            }
            if ((n2 & 16384) != 0) {
                bl3 = railwayLine.directOperationDeparture;
            }
            if ((n2 & 32768) == 0) break block15;
            bl4 = railwayLine.directOperationArrival;
        }
        return railwayLine.copy(string2, string3, string4, string5, string6, string7, string8, boardingStation, boardingStation2, accuracy, string9, string10, serviceStatus, bl2, bl3, bl4);
    }

    public final String boundForWithSuffix() {
        boolean bl2 = ((CharSequence)this.boundFor).length() == 0;
        if (bl2) {
            return this.boundFor;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.boundFor);
        stringBuilder.append("\u884c\u304d");
        return stringBuilder.toString();
    }

    public final String component1() {
        return this.ekitanId;
    }

    public final Accuracy component10() {
        return this.changeTime;
    }

    public final String component11() {
        return this.color;
    }

    public final String component12() {
        return this.iconName;
    }

    public final ServiceStatus component13() {
        return this.serviceStatus;
    }

    public final boolean component14() {
        return this.isPaidExpress;
    }

    public final boolean component15() {
        return this.directOperationDeparture;
    }

    public final boolean component16() {
        return this.directOperationArrival;
    }

    public final String component2() {
        return this.jrId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.kind;
    }

    public final String component5() {
        return this.railKind;
    }

    public final String component6() {
        return this.trainDirection;
    }

    public final String component7() {
        return this.boundFor;
    }

    public final BoardingStation component8() {
        return this.from;
    }

    public final BoardingStation component9() {
        return this.to;
    }

    public final RailwayLine copy(String string2, String string3, @e(a="name") String string4, String string5, String string6, String string7, String string8, BoardingStation boardingStation, BoardingStation boardingStation2, Accuracy accuracy, String string9, String string10, ServiceStatus serviceStatus, boolean bl2, boolean bl3, boolean bl4) {
        j.b(string2, "ekitanId");
        j.b(string4, "name");
        j.b(string5, "kind");
        j.b(string6, "railKind");
        j.b(string8, "boundFor");
        j.b(boardingStation, "from");
        j.b(boardingStation2, "to");
        j.b(string9, "color");
        j.b(serviceStatus, "serviceStatus");
        return new RailwayLine(string2, string3, string4, string5, string6, string7, string8, boardingStation, boardingStation2, accuracy, string9, string10, serviceStatus, bl2, bl3, bl4);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof RailwayLine) {
                boolean bl2;
                object = (RailwayLine)object;
                if (j.a((Object)this.ekitanId, (Object)((RailwayLine)object).ekitanId) && j.a((Object)this.jrId, (Object)((RailwayLine)object).jrId) && j.a((Object)this.name, (Object)((RailwayLine)object).name) && j.a((Object)this.kind, (Object)((RailwayLine)object).kind) && j.a((Object)this.railKind, (Object)((RailwayLine)object).railKind) && j.a((Object)this.trainDirection, (Object)((RailwayLine)object).trainDirection) && j.a((Object)this.boundFor, (Object)((RailwayLine)object).boundFor) && j.a((Object)this.from, (Object)((RailwayLine)object).from) && j.a((Object)this.to, (Object)((RailwayLine)object).to) && j.a((Object)this.changeTime, (Object)((RailwayLine)object).changeTime) && j.a((Object)this.color, (Object)((RailwayLine)object).color) && j.a((Object)this.iconName, (Object)((RailwayLine)object).iconName) && j.a((Object)this.serviceStatus, (Object)((RailwayLine)object).serviceStatus) && (bl2 = this.isPaidExpress == ((RailwayLine)object).isPaidExpress) && (bl2 = this.directOperationDeparture == ((RailwayLine)object).directOperationDeparture) && (bl2 = this.directOperationArrival == ((RailwayLine)object).directOperationArrival)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final String getBoundFor() {
        return this.boundFor;
    }

    public final Accuracy getChangeTime() {
        return this.changeTime;
    }

    public final String getColor() {
        return this.color;
    }

    public final boolean getDirectOperationArrival() {
        return this.directOperationArrival;
    }

    public final boolean getDirectOperationDeparture() {
        return this.directOperationDeparture;
    }

    public final String getEkitanId() {
        return this.ekitanId;
    }

    public final BoardingStation getFrom() {
        return this.from;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final String getJrId() {
        return this.jrId;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getKindAndBoundFor() {
        int n2 = ((CharSequence)this.kind).length();
        int n3 = 0;
        if ((n2 = n2 == 0 ? 1 : 0) != 0 && (n2 = ((CharSequence)this.boundFor).length() == 0 ? 1 : 0) != 0) {
            return "";
        }
        n2 = ((CharSequence)this.boundFor).length() == 0 ? 1 : 0;
        if (n2 != 0) {
            return this.kind;
        }
        n2 = n3;
        if (((CharSequence)this.kind).length() == 0) {
            n2 = 1;
        }
        if (n2 != 0) {
            return this.boundForWithSuffix();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.kind);
        stringBuilder.append('\n');
        stringBuilder.append(this.boundForWithSuffix());
        return stringBuilder.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final String getRailKind() {
        return this.railKind;
    }

    public final ServiceStatus getServiceStatus() {
        return this.serviceStatus;
    }

    public final BoardingStation getTo() {
        return this.to;
    }

    public final String getTrainDirection() {
        return this.trainDirection;
    }

    public int hashCode() {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public final boolean isDelayed() {
        int n2 = ((CharSequence)this.serviceStatus.getDelayStatus()).length();
        boolean bl2 = false;
        n2 = n2 == 0 ? 1 : 0;
        boolean bl3 = bl2;
        if (n2 == 0) {
            bl3 = bl2;
            if (j.a((Object)this.ekitanId, (Object)"000000") ^ true) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public final boolean isNormalPaidExpress() {
        return this.isPaidExpress && j.a((Object)this.ekitanId, (Object)"000000");
    }

    public final boolean isPaidExpress() {
        return this.isPaidExpress;
    }

    public final boolean isWalking() {
        return j.a((Object)this.ekitanId, (Object)"999999");
    }

    public final void setBoundFor(String string2) {
        j.b(string2, "<set-?>");
        this.boundFor = string2;
    }

    public final void setChangeTime(Accuracy accuracy) {
        this.changeTime = accuracy;
    }

    public final void setColor(String string2) {
        j.b(string2, "<set-?>");
        this.color = string2;
    }

    public final void setDirectOperationArrival(boolean bl2) {
        this.directOperationArrival = bl2;
    }

    public final void setDirectOperationDeparture(boolean bl2) {
        this.directOperationDeparture = bl2;
    }

    public final void setEkitanId(String string2) {
        j.b(string2, "<set-?>");
        this.ekitanId = string2;
    }

    public final void setFrom(BoardingStation boardingStation) {
        j.b(boardingStation, "<set-?>");
        this.from = boardingStation;
    }

    public final void setIconName(String string2) {
        this.iconName = string2;
    }

    public final void setJrId(String string2) {
        this.jrId = string2;
    }

    public final void setKind(String string2) {
        j.b(string2, "<set-?>");
        this.kind = string2;
    }

    public final void setName(String string2) {
        j.b(string2, "<set-?>");
        this.name = string2;
    }

    public final void setPaidExpress(boolean bl2) {
        this.isPaidExpress = bl2;
    }

    public final void setRailKind(String string2) {
        j.b(string2, "<set-?>");
        this.railKind = string2;
    }

    public final void setServiceStatus(ServiceStatus serviceStatus) {
        j.b(serviceStatus, "<set-?>");
        this.serviceStatus = serviceStatus;
    }

    public final void setTo(BoardingStation boardingStation) {
        j.b(boardingStation, "<set-?>");
        this.to = boardingStation;
    }

    public final void setTrainDirection(String string2) {
        this.trainDirection = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RailwayLine(ekitanId=");
        stringBuilder.append(this.ekitanId);
        stringBuilder.append(", jrId=");
        stringBuilder.append(this.jrId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", kind=");
        stringBuilder.append(this.kind);
        stringBuilder.append(", railKind=");
        stringBuilder.append(this.railKind);
        stringBuilder.append(", trainDirection=");
        stringBuilder.append(this.trainDirection);
        stringBuilder.append(", boundFor=");
        stringBuilder.append(this.boundFor);
        stringBuilder.append(", from=");
        stringBuilder.append(this.from);
        stringBuilder.append(", to=");
        stringBuilder.append(this.to);
        stringBuilder.append(", changeTime=");
        stringBuilder.append(this.changeTime);
        stringBuilder.append(", color=");
        stringBuilder.append(this.color);
        stringBuilder.append(", iconName=");
        stringBuilder.append(this.iconName);
        stringBuilder.append(", serviceStatus=");
        stringBuilder.append(this.serviceStatus);
        stringBuilder.append(", isPaidExpress=");
        stringBuilder.append(this.isPaidExpress);
        stringBuilder.append(", directOperationDeparture=");
        stringBuilder.append(this.directOperationDeparture);
        stringBuilder.append(", directOperationArrival=");
        stringBuilder.append(this.directOperationArrival);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String travelTimeInMinutes() {
        long l2;
        try {
            Calendar calendar = this.from.dateTime();
            if (calendar == null) {
                j.a();
            }
            l2 = calendar.getTimeInMillis();
            calendar = this.to.dateTime();
            if (calendar == null) {
                j.a();
            }
            l2 = (calendar.getTimeInMillis() - l2) / (long)60000;
        }
        catch (Exception exception) {
            return "";
        }
        return String.valueOf(l2);
    }
}

