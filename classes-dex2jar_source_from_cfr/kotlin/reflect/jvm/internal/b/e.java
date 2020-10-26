/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.b;

import java.io.Serializable;

final class e<K, V>
implements Serializable {
    public final K a;
    public final V b;

    public e(K k2, V v2) {
        this.a = k2;
        this.b = v2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        block5 : {
            block8 : {
                boolean bl3;
                block7 : {
                    block6 : {
                        block4 : {
                            bl2 = object instanceof e;
                            bl3 = false;
                            if (!bl2) {
                                return false;
                            }
                            object = (e)object;
                            if (this.a != null) break block4;
                            bl2 = bl3;
                            if (((e)object).a != null) break block5;
                            break block6;
                        }
                        bl2 = bl3;
                        if (!this.a.equals(((e)object).a)) break block5;
                    }
                    if (this.b != null) break block7;
                    bl2 = bl3;
                    if (((e)object).b != null) break block5;
                    break block8;
                }
                bl2 = bl3;
                if (!this.b.equals(((e)object).b)) break block5;
            }
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        K k2 = this.a;
        int n2 = 0;
        int n3 = k2 == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            n2 = this.b.hashCode();
        }
        return n3 ^ n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("=");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

