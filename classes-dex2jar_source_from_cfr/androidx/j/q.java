/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.util.AndroidRuntimeException
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.j;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.j.g;
import androidx.j.m;
import androidx.j.n;
import androidx.j.p;
import androidx.j.s;
import androidx.j.t;
import java.util.ArrayList;
import java.util.Iterator;

public class q
extends m {
    int h;
    boolean i = false;
    private ArrayList<m> j = new ArrayList();
    private boolean k = true;
    private int l = 0;

    private void r() {
        a a2 = new a(this);
        Iterator<m> iterator = this.j.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(a2);
        }
        this.h = this.j.size();
    }

    @Override
    public /* synthetic */ m a(long l2) {
        return this.c(l2);
    }

    @Override
    public /* synthetic */ m a(TimeInterpolator timeInterpolator) {
        return this.b(timeInterpolator);
    }

    @Override
    public /* synthetic */ m a(m.c c2) {
        return this.c(c2);
    }

    public q a(int n2) {
        boolean bl2;
        switch (n2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
                stringBuilder.append(n2);
                throw new AndroidRuntimeException(stringBuilder.toString());
            }
            case 1: {
                bl2 = false;
                break;
            }
            case 0: {
                bl2 = true;
            }
        }
        this.k = bl2;
        return this;
    }

    public q a(m m2) {
        this.j.add(m2);
        m2.d = this;
        if (this.a >= 0L) {
            m2.a(this.a);
        }
        if ((this.l & 1) != 0) {
            m2.a(this.d());
        }
        if ((this.l & 2) != 0) {
            m2.a(this.n());
        }
        if ((this.l & 4) != 0) {
            m2.a(this.l());
        }
        if ((this.l & 8) != 0) {
            m2.a(this.m());
        }
        return this;
    }

    @Override
    String a(String string2) {
        Object object = super.a(string2);
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append("\n");
            object = this.j.get(i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("  ");
            stringBuilder.append(((m)object).a(stringBuilder2.toString()));
            object = stringBuilder.toString();
        }
        return object;
    }

    @Override
    protected void a(ViewGroup viewGroup, t t2, t t3, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long l2 = this.c();
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            m m2 = this.j.get(i2);
            if (l2 > 0L && (this.k || i2 == 0)) {
                long l3 = m2.c();
                if (l3 > 0L) {
                    m2.b(l3 + l2);
                } else {
                    m2.b(l2);
                }
            }
            m2.a(viewGroup, t2, t3, arrayList, arrayList2);
        }
    }

    @Override
    public void a(g g2) {
        super.a(g2);
        this.l |= 4;
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            this.j.get(i2).a(g2);
        }
    }

    @Override
    public void a(m.b b2) {
        super.a(b2);
        this.l |= 8;
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.j.get(i2).a(b2);
        }
    }

    @Override
    public void a(p p2) {
        super.a(p2);
        this.l |= 2;
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.j.get(i2).a(p2);
        }
    }

    @Override
    public void a(s s2) {
        if (this.a(s2.b)) {
            for (m m2 : this.j) {
                if (!m2.a(s2.b)) continue;
                m2.a(s2);
                s2.c.add(m2);
            }
        }
    }

    public m b(int n2) {
        if (n2 >= 0 && n2 < this.j.size()) {
            return this.j.get(n2);
        }
        return null;
    }

    @Override
    public /* synthetic */ m b(long l2) {
        return this.d(l2);
    }

    @Override
    public /* synthetic */ m b(View view) {
        return this.f(view);
    }

    @Override
    public /* synthetic */ m b(m.c c2) {
        return this.d(c2);
    }

    public q b(TimeInterpolator timeInterpolator) {
        this.l |= 1;
        if (this.j != null) {
            int n2 = this.j.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.j.get(i2).a(timeInterpolator);
            }
        }
        return (q)super.a(timeInterpolator);
    }

    @Override
    public void b(s s2) {
        if (this.a(s2.b)) {
            for (m m2 : this.j) {
                if (!m2.a(s2.b)) continue;
                m2.b(s2);
                s2.c.add(m2);
            }
        }
    }

    @Override
    public /* synthetic */ m c(View view) {
        return this.g(view);
    }

    public q c(long l2) {
        super.a(l2);
        if (this.a >= 0L) {
            int n2 = this.j.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.j.get(i2).a(l2);
            }
        }
        return this;
    }

    public q c(m.c c2) {
        return (q)super.a(c2);
    }

    @Override
    void c(s s2) {
        super.c(s2);
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.j.get(i2).c(s2);
        }
    }

    @Override
    public /* synthetic */ Object clone() {
        return this.o();
    }

    public q d(long l2) {
        return (q)super.b(l2);
    }

    public q d(m.c c2) {
        return (q)super.b(c2);
    }

    @Override
    public void d(View view) {
        super.d(view);
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.j.get(i2).d(view);
        }
    }

    @Override
    protected void e() {
        if (this.j.isEmpty()) {
            this.j();
            this.k();
            return;
        }
        this.r();
        if (!this.k) {
            for (int i2 = 1; i2 < this.j.size(); ++i2) {
                this.j.get(i2 - 1).a(new n(this.j.get(i2)){
                    final /* synthetic */ m a;
                    {
                        this.a = m2;
                    }

                    @Override
                    public void a(m m2) {
                        this.a.e();
                        m2.b(this);
                    }
                });
            }
            m m2 = this.j.get(0);
            if (m2 != null) {
                m2.e();
                return;
            }
        } else {
            Iterator<m> iterator = this.j.iterator();
            while (iterator.hasNext()) {
                iterator.next().e();
            }
        }
    }

    @Override
    public void e(View view) {
        super.e(view);
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.j.get(i2).e(view);
        }
    }

    public q f(View view) {
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            this.j.get(i2).b(view);
        }
        return (q)super.b(view);
    }

    public q g(View view) {
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            this.j.get(i2).c(view);
        }
        return (q)super.c(view);
    }

    @Override
    public m o() {
        q q2 = (q)super.o();
        q2.j = new ArrayList();
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            q2.a(this.j.get(i2).o());
        }
        return q2;
    }

    public int q() {
        return this.j.size();
    }

    static class a
    extends n {
        q a;

        a(q q2) {
            this.a = q2;
        }

        @Override
        public void a(m m2) {
            q q2 = this.a;
            --q2.h;
            if (this.a.h == 0) {
                this.a.i = false;
                this.a.k();
            }
            m2.b(this);
        }

        @Override
        public void d(m m2) {
            if (!this.a.i) {
                this.a.j();
                this.a.i = true;
            }
        }
    }

}

