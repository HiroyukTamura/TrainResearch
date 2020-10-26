/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.e.b.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0019"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/Accuracy;", "Ljava/io/Serializable;", "hour", "", "min", "(Ljava/lang/String;Ljava/lang/String;)V", "getHour", "()Ljava/lang/String;", "setHour", "(Ljava/lang/String;)V", "getMin", "setMin", "component1", "component2", "copy", "displayString", "equals", "", "other", "", "fourDigitString", "getMinutes", "", "hashCode", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class Accuracy
implements Serializable {
    private String hour;
    private String min;

    public Accuracy(String string2, String string3) {
        j.b(string2, "hour");
        j.b(string3, "min");
        this.hour = string2;
        this.min = string3;
    }

    public static /* synthetic */ Accuracy copy$default(Accuracy accuracy, String string2, String string3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = accuracy.hour;
        }
        if ((n2 & 2) != 0) {
            string3 = accuracy.min;
        }
        return accuracy.copy(string2, string3);
    }

    public final String component1() {
        return this.hour;
    }

    public final String component2() {
        return this.min;
    }

    public final Accuracy copy(String string2, String string3) {
        j.b(string2, "hour");
        j.b(string3, "min");
        return new Accuracy(string2, string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String displayString() {
        try {
            Serializable serializable = Integer.valueOf(Integer.parseInt(this.hour));
            Serializable serializable2 = Integer.valueOf(Integer.parseInt(this.min));
            if ((Integer)serializable == 0) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append(serializable2);
                ((StringBuilder)serializable).append('\u5206');
                return ((StringBuilder)serializable).toString();
            }
            if ((Integer)serializable2 == 0) {
                serializable2 = new StringBuilder();
                ((StringBuilder)serializable2).append(serializable);
                ((StringBuilder)serializable2).append("\u6642\u9593");
                return ((StringBuilder)serializable2).toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(serializable);
            stringBuilder.append("\u6642\u9593");
            stringBuilder.append(serializable2);
            stringBuilder.append('\u5206');
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return "";
        }
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof Accuracy)) break block3;
                object = (Accuracy)object;
                if (j.a((Object)this.hour, (Object)((Accuracy)object).hour) && j.a((Object)this.min, (Object)((Accuracy)object).min)) break block2;
            }
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String fourDigitString() {
        int n2;
        int n3;
        try {
            n2 = Integer.parseInt(this.hour);
            n3 = Integer.parseInt(this.min);
            y y2 = y.a;
        }
        catch (Exception exception) {
            return "";
        }
        Object[] arrobject = new Object[]{n2, n3};
        String string2 = String.format("%02d:%02d", Arrays.copyOf(arrobject, arrobject.length));
        j.a((Object)string2, "java.lang.String.format(format, *args)");
        return string2;
    }

    public final String getHour() {
        return this.hour;
    }

    public final String getMin() {
        return this.min;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int getMinutes() {
        try {
            int n2 = Integer.parseInt(this.hour);
            int n3 = Integer.parseInt(this.min);
            if (n2 != 0 || n3 != 0) return n2 * 60 + n3;
            return 1;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public int hashCode() {
        String string2 = this.hour;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.min;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return n3 * 31 + n2;
    }

    public final void setHour(String string2) {
        j.b(string2, "<set-?>");
        this.hour = string2;
    }

    public final void setMin(String string2) {
        j.b(string2, "<set-?>");
        this.min = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Accuracy(hour=");
        stringBuilder.append(this.hour);
        stringBuilder.append(", min=");
        stringBuilder.append(this.min);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

