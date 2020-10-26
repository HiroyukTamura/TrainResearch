/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.j;
import java.util.Arrays;

public class k
extends f
implements j {
    protected f[] af = new f[4];
    protected int ag = 0;

    @Override
    public void a(f f2) {
        if (this.ag + 1 > this.af.length) {
            this.af = Arrays.copyOf(this.af, this.af.length * 2);
        }
        this.af[this.ag] = f2;
        ++this.ag;
    }

    @Override
    public void a_() {
        this.ag = 0;
    }
}

