/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package androidx.core.e;

import android.util.Base64;
import androidx.core.g.e;
import java.util.List;

public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public a(String charSequence, String string2, String string3, List<List<byte[]>> list) {
        this.a = e.a(charSequence);
        this.b = e.a(string2);
        this.c = e.a(string3);
        this.d = e.a(list);
        this.e = 0;
        charSequence = new StringBuilder(this.a);
        ((StringBuilder)charSequence).append("-");
        ((StringBuilder)charSequence).append(this.b);
        ((StringBuilder)charSequence).append("-");
        ((StringBuilder)charSequence).append(this.c);
        this.f = ((StringBuilder)charSequence).toString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<List<byte[]>> d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("FontRequest {mProviderAuthority: ");
        ((StringBuilder)object).append(this.a);
        ((StringBuilder)object).append(", mProviderPackage: ");
        ((StringBuilder)object).append(this.b);
        ((StringBuilder)object).append(", mQuery: ");
        ((StringBuilder)object).append(this.c);
        ((StringBuilder)object).append(", mCertificates:");
        stringBuilder.append(((StringBuilder)object).toString());
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            stringBuilder.append(" [");
            object = this.d.get(i2);
            for (int i3 = 0; i3 < object.size(); ++i3) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])((byte[])object.get(i3)), (int)0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        object = new StringBuilder();
        ((StringBuilder)object).append("mCertificatesArray: ");
        ((StringBuilder)object).append(this.e);
        stringBuilder.append(((StringBuilder)object).toString());
        return stringBuilder.toString();
    }
}

