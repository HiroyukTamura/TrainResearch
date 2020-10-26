/*
 * Decompiled with CFR 0.139.
 */
package androidx.databinding;

import androidx.databinding.i;
import androidx.databinding.m;

public class a
implements i {
    private transient m a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2) {
        synchronized (this) {
            if (this.a == null) {
                return;
            }
        }
        this.a.a(this, n2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(i.a a2) {
        synchronized (this) {
            if (this.a == null) {
                this.a = new m();
            }
        }
        this.a.a(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(i.a a2) {
        synchronized (this) {
            if (this.a == null) {
                return;
            }
        }
        this.a.b(a2);
    }
}

