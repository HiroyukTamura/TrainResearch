/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/RegisteredUserId;", "", "userId", "", "authId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RegisteredUserId {
    private final String authId;
    private final String userId;

    public RegisteredUserId(String string2, String string3) {
        j.b(string2, "userId");
        j.b(string3, "authId");
        this.userId = string2;
        this.authId = string3;
    }

    public static /* synthetic */ RegisteredUserId copy$default(RegisteredUserId registeredUserId, String string2, String string3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = registeredUserId.userId;
        }
        if ((n2 & 2) != 0) {
            string3 = registeredUserId.authId;
        }
        return registeredUserId.copy(string2, string3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.authId;
    }

    public final RegisteredUserId copy(String string2, String string3) {
        j.b(string2, "userId");
        j.b(string3, "authId");
        return new RegisteredUserId(string2, string3);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof RegisteredUserId)) break block3;
                object = (RegisteredUserId)object;
                if (j.a((Object)this.userId, (Object)((RegisteredUserId)object).userId) && j.a((Object)this.authId, (Object)((RegisteredUserId)object).authId)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String string2 = this.userId;
        int n2 = 0;
        int n3 = string2 != null ? string2.hashCode() : 0;
        string2 = this.authId;
        if (string2 != null) {
            n2 = string2.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RegisteredUserId(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", authId=");
        stringBuilder.append(this.authId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

