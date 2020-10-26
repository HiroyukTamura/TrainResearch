/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.co.bug.sst;

import android.os.Handler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import jp.co.bug.sst.a.a;
import jp.co.bug.sst.b;
import jp.co.bug.sst.c;
import jp.co.bug.sst.e;
import jp.co.bug.sst.g;
import jp.co.bug.sst.h;

public class i
implements b.a,
e {
    private int a = 0;
    private e.a b;
    private Handler c;
    private int d = -1;
    private b e;
    private c f = new h();

    private boolean a(int n2, int n3) {
        this.e = this.f.a(n2, n3);
        this.e.a(this);
        if (this.d != -1) {
            this.e.a(this.d);
        }
        try {
            boolean bl2 = this.e.a(this.c);
            return bl2;
        }
        catch (b.b b2) {
            this.e.a((b.a)null);
            this.e = null;
            throw b2;
        }
    }

    private void b() {
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
    }

    @Override
    public void a() {
        synchronized (this) {
            if (this.a != 0) {
                this.a = 0;
                this.b();
                this.c = null;
            }
            return;
        }
    }

    @Override
    public void a(b.c c2) {
        this.a();
        if (this.b != null) {
            e.a a2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("audioError (");
            stringBuilder.append(c2.getMessage());
            stringBuilder.append(")");
            a2.a(new e.b(stringBuilder.toString(), c2));
        }
    }

    @Override
    public void a(e.a a2) {
        this.b = a2;
    }

    @Override
    public void a(byte[] object) {
        if (this.a != 1) {
            return;
        }
        jp.co.bug.b.a.a("onGetSstAudioBytes ", this.b((byte[])object));
        try {
            object = a.a(object);
            if (this.b != null) {
                this.b.a((jp.co.bug.sst.a.b)object);
            }
            return;
        }
        catch (a.a a2) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(Handler handler, int n2, int n3) {
        synchronized (this) {
            boolean bl2;
            block6 : {
                int n4 = this.a;
                if (n4 != 0) {
                    return false;
                }
                this.a = 1;
                this.c = handler;
                try {
                    void var3_4;
                    void var2_3;
                    bl2 = this.a((int)var2_3, (int)var3_4);
                    if (bl2) break block6;
                    this.a = 0;
                    this.c = null;
                }
                catch (b.b b2) {
                    this.a = 0;
                    this.c = null;
                    throw b2;
                }
            }
            return bl2;
        }
    }

    String b(byte[] arrby) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            printWriter.printf("%02x ", arrby[i2] & 255);
        }
        return stringWriter.toString();
    }
}

