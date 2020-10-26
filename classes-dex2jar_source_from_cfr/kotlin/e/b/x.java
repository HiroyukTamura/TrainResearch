/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class x {
    private final ArrayList<Object> a;

    public x(int n2) {
        this.a = new ArrayList(n2);
    }

    public int a() {
        return this.a.size();
    }

    public void a(Object object) {
        block10 : {
            block8 : {
                block9 : {
                    block7 : {
                        if (object == null) {
                            return;
                        }
                        if (!(object instanceof Object[])) break block7;
                        if (((Object[])(object = (Object[])object)).length > 0) {
                            this.a.ensureCapacity(this.a.size() + ((Object)object).length);
                            for (Object object2 : object) {
                                this.a.add(object2);
                            }
                        }
                        break block8;
                    }
                    if (object instanceof Collection) {
                        this.a.addAll((Collection)object);
                        return;
                    }
                    if (!(object instanceof Iterable)) break block9;
                    for (Object e2 : (Iterable)object) {
                        this.a.add(e2);
                    }
                    break block8;
                }
                if (object instanceof Iterator) {
                    object = (Iterator)object;
                    while (object.hasNext()) {
                        this.a.add(object.next());
                    }
                }
                break block10;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to spread ");
        stringBuilder.append(object.getClass());
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public Object[] a(Object[] arrobject) {
        return this.a.toArray(arrobject);
    }

    public void b(Object object) {
        this.a.add(object);
    }
}

