/*
 * Decompiled with CFR 0.139.
 */
package androidx.appcompat.widget;

class ag {
    private int a = 0;
    private int b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    ag() {
    }

    public int a() {
        return this.a;
    }

    public void a(int n2, int n3) {
        this.c = n2;
        this.d = n3;
        this.h = true;
        if (this.g) {
            if (n3 != Integer.MIN_VALUE) {
                this.a = n3;
            }
            if (n2 != Integer.MIN_VALUE) {
                this.b = n2;
                return;
            }
        } else {
            if (n2 != Integer.MIN_VALUE) {
                this.a = n2;
            }
            if (n3 != Integer.MIN_VALUE) {
                this.b = n3;
            }
        }
    }

    public void a(boolean bl2) {
        int n2;
        block4 : {
            block3 : {
                block1 : {
                    block2 : {
                        if (bl2 == this.g) {
                            return;
                        }
                        this.g = bl2;
                        if (!this.h) break block1;
                        if (!bl2) break block2;
                        n2 = this.d != Integer.MIN_VALUE ? this.d : this.e;
                        this.a = n2;
                        if (this.c == Integer.MIN_VALUE) break block3;
                        n2 = this.c;
                        break block4;
                    }
                    n2 = this.c != Integer.MIN_VALUE ? this.c : this.e;
                    this.a = n2;
                    if (this.d == Integer.MIN_VALUE) break block3;
                    n2 = this.d;
                    break block4;
                }
                this.a = this.e;
            }
            n2 = this.f;
        }
        this.b = n2;
    }

    public int b() {
        return this.b;
    }

    public void b(int n2, int n3) {
        this.h = false;
        if (n2 != Integer.MIN_VALUE) {
            this.e = n2;
            this.a = n2;
        }
        if (n3 != Integer.MIN_VALUE) {
            this.f = n3;
            this.b = n3;
        }
    }

    public int c() {
        if (this.g) {
            return this.b;
        }
        return this.a;
    }

    public int d() {
        if (this.g) {
            return this.a;
        }
        return this.b;
    }
}

