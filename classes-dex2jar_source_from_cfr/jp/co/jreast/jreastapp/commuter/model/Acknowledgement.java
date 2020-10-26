/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001e"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/Acknowledgement;", "Ljava/io/Serializable;", "message", "", "approvalNumber", "title", "creditToEkitan", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApprovalNumber", "()Ljava/lang/String;", "setApprovalNumber", "(Ljava/lang/String;)V", "getCreditToEkitan", "setCreditToEkitan", "getMessage", "setMessage", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class Acknowledgement
implements Serializable {
    private String approvalNumber;
    private String creditToEkitan;
    private String message;
    private String title;

    public Acknowledgement(String string2, String string3, String string4, String string5) {
        j.b(string2, "message");
        j.b(string3, "approvalNumber");
        j.b(string4, "title");
        j.b(string5, "creditToEkitan");
        this.message = string2;
        this.approvalNumber = string3;
        this.title = string4;
        this.creditToEkitan = string5;
    }

    public static /* synthetic */ Acknowledgement copy$default(Acknowledgement acknowledgement, String string2, String string3, String string4, String string5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = acknowledgement.message;
        }
        if ((n2 & 2) != 0) {
            string3 = acknowledgement.approvalNumber;
        }
        if ((n2 & 4) != 0) {
            string4 = acknowledgement.title;
        }
        if ((n2 & 8) != 0) {
            string5 = acknowledgement.creditToEkitan;
        }
        return acknowledgement.copy(string2, string3, string4, string5);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.approvalNumber;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.creditToEkitan;
    }

    public final Acknowledgement copy(String string2, String string3, String string4, String string5) {
        j.b(string2, "message");
        j.b(string3, "approvalNumber");
        j.b(string4, "title");
        j.b(string5, "creditToEkitan");
        return new Acknowledgement(string2, string3, string4, string5);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof Acknowledgement)) break block3;
                object = (Acknowledgement)object;
                if (j.a((Object)this.message, (Object)((Acknowledgement)object).message) && j.a((Object)this.approvalNumber, (Object)((Acknowledgement)object).approvalNumber) && j.a((Object)this.title, (Object)((Acknowledgement)object).title) && j.a((Object)this.creditToEkitan, (Object)((Acknowledgement)object).creditToEkitan)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getApprovalNumber() {
        return this.approvalNumber;
    }

    public final String getCreditToEkitan() {
        return this.creditToEkitan;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String string2 = this.message;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.approvalNumber;
        int n4 = string2 != null ? string2.hashCode() : 0;
        string2 = this.title;
        int n5 = string2 != null ? string2.hashCode() : 0;
        string2 = this.creditToEkitan;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return ((n3 * 31 + n4) * 31 + n5) * 31 + n2;
    }

    public final void setApprovalNumber(String string2) {
        j.b(string2, "<set-?>");
        this.approvalNumber = string2;
    }

    public final void setCreditToEkitan(String string2) {
        j.b(string2, "<set-?>");
        this.creditToEkitan = string2;
    }

    public final void setMessage(String string2) {
        j.b(string2, "<set-?>");
        this.message = string2;
    }

    public final void setTitle(String string2) {
        j.b(string2, "<set-?>");
        this.title = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Acknowledgement(message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", approvalNumber=");
        stringBuilder.append(this.approvalNumber);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", creditToEkitan=");
        stringBuilder.append(this.creditToEkitan);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

