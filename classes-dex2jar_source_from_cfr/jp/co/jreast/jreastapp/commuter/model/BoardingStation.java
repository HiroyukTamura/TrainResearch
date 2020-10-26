/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import java.util.Calendar;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingDate;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\b\u0010!\u001a\u0004\u0018\u00010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u00d6\u0003J\t\u0010'\u001a\u00020(H\u00d6\u0001J\u0006\u0010)\u001a\u00020\u0003J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016\u00a8\u0006+"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/BoardingStation;", "Ljava/io/Serializable;", "code", "", "name", "accuracy", "Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "boardingDate", "Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;", "platformName", "(Ljava/lang/String;Ljava/lang/String;Ljp/co/jreast/jreastapp/commuter/model/Accuracy;Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;Ljava/lang/String;)V", "getAccuracy", "()Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "setAccuracy", "(Ljp/co/jreast/jreastapp/commuter/model/Accuracy;)V", "getBoardingDate", "()Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;", "setBoardingDate", "(Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getName", "setName", "getPlatformName", "setPlatformName", "component1", "component2", "component3", "component4", "component5", "copy", "dateTime", "Ljava/util/Calendar;", "equals", "", "other", "", "hashCode", "", "platformNameWithSuffix", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class BoardingStation
implements Serializable {
    private Accuracy accuracy;
    private BoardingDate boardingDate;
    private String code;
    private String name;
    private String platformName;

    public BoardingStation(String string2, String string3, Accuracy accuracy, BoardingDate boardingDate, String string4) {
        j.b(string2, "code");
        j.b(string3, "name");
        j.b(accuracy, "accuracy");
        j.b(boardingDate, "boardingDate");
        j.b(string4, "platformName");
        this.code = string2;
        this.name = string3;
        this.accuracy = accuracy;
        this.boardingDate = boardingDate;
        this.platformName = string4;
    }

    public static /* synthetic */ BoardingStation copy$default(BoardingStation boardingStation, String string2, String string3, Accuracy accuracy, BoardingDate boardingDate, String string4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = boardingStation.code;
        }
        if ((n2 & 2) != 0) {
            string3 = boardingStation.name;
        }
        if ((n2 & 4) != 0) {
            accuracy = boardingStation.accuracy;
        }
        if ((n2 & 8) != 0) {
            boardingDate = boardingStation.boardingDate;
        }
        if ((n2 & 16) != 0) {
            string4 = boardingStation.platformName;
        }
        return boardingStation.copy(string2, string3, accuracy, boardingDate, string4);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final Accuracy component3() {
        return this.accuracy;
    }

    public final BoardingDate component4() {
        return this.boardingDate;
    }

    public final String component5() {
        return this.platformName;
    }

    public final BoardingStation copy(String string2, String string3, Accuracy accuracy, BoardingDate boardingDate, String string4) {
        j.b(string2, "code");
        j.b(string3, "name");
        j.b(accuracy, "accuracy");
        j.b(boardingDate, "boardingDate");
        j.b(string4, "platformName");
        return new BoardingStation(string2, string3, accuracy, boardingDate, string4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Calendar dateTime() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.set(Integer.parseInt(this.boardingDate.getYear()), Integer.parseInt(this.boardingDate.getMonth()) - 1, Integer.parseInt(this.boardingDate.getDay()), Integer.parseInt(this.accuracy.getHour()), Integer.parseInt(this.accuracy.getMin()), 0);
            calendar.set(14, 0);
            return calendar;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof BoardingStation)) break block3;
                object = (BoardingStation)object;
                if (j.a((Object)this.code, (Object)((BoardingStation)object).code) && j.a((Object)this.name, (Object)((BoardingStation)object).name) && j.a((Object)this.accuracy, (Object)((BoardingStation)object).accuracy) && j.a((Object)this.boardingDate, (Object)((BoardingStation)object).boardingDate) && j.a((Object)this.platformName, (Object)((BoardingStation)object).platformName)) break block2;
            }
            return false;
        }
        return true;
    }

    public final Accuracy getAccuracy() {
        return this.accuracy;
    }

    public final BoardingDate getBoardingDate() {
        return this.boardingDate;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlatformName() {
        return this.platformName;
    }

    public int hashCode() {
        Object object = this.code;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.name;
        int n4 = object != null ? object.hashCode() : 0;
        object = this.accuracy;
        int n5 = object != null ? object.hashCode() : 0;
        object = this.boardingDate;
        int n6 = object != null ? object.hashCode() : 0;
        object = this.platformName;
        if (object != null) {
            n2 = object.hashCode();
        }
        return (((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n2;
    }

    public final String platformNameWithSuffix() {
        boolean bl2 = ((CharSequence)this.platformName).length() == 0;
        if (bl2) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.platformName);
        stringBuilder.append("\u756a\u7dda");
        return stringBuilder.toString();
    }

    public final void setAccuracy(Accuracy accuracy) {
        j.b(accuracy, "<set-?>");
        this.accuracy = accuracy;
    }

    public final void setBoardingDate(BoardingDate boardingDate) {
        j.b(boardingDate, "<set-?>");
        this.boardingDate = boardingDate;
    }

    public final void setCode(String string2) {
        j.b(string2, "<set-?>");
        this.code = string2;
    }

    public final void setName(String string2) {
        j.b(string2, "<set-?>");
        this.name = string2;
    }

    public final void setPlatformName(String string2) {
        j.b(string2, "<set-?>");
        this.platformName = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BoardingStation(code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", accuracy=");
        stringBuilder.append(this.accuracy);
        stringBuilder.append(", boardingDate=");
        stringBuilder.append(this.boardingDate);
        stringBuilder.append(", platformName=");
        stringBuilder.append(this.platformName);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

