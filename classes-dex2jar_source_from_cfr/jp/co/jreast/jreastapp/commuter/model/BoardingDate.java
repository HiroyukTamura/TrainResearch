/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;", "Ljava/io/Serializable;", "year", "", "month", "day", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "getMonth", "setMonth", "getYear", "setYear", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class BoardingDate
implements Serializable {
    private String day;
    private String month;
    private String year;

    public BoardingDate(String string2, String string3, String string4) {
        j.b(string2, "year");
        j.b(string3, "month");
        j.b(string4, "day");
        this.year = string2;
        this.month = string3;
        this.day = string4;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setDay(String string2) {
        j.b(string2, "<set-?>");
        this.day = string2;
    }

    public final void setMonth(String string2) {
        j.b(string2, "<set-?>");
        this.month = string2;
    }

    public final void setYear(String string2) {
        j.b(string2, "<set-?>");
        this.year = string2;
    }
}

