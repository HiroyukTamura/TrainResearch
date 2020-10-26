/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.f;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class m
extends AbstractList<f>
implements RandomAccess {
    final f[] a;
    final int[] b;

    private m(f[] arrf, int[] arrn) {
        this.a = arrf;
        this.b = arrn;
    }

    private static int a(c c2) {
        return (int)(c2.b() / 4L);
    }

    public static /* varargs */ m a(f ... object) {
        int n2 = ((f[])object).length;
        int n3 = 0;
        if (n2 == 0) {
            return new m(new f[0], new int[]{0, -1});
        }
        int[] arrn = new int[](Arrays.asList(object));
        Collections.sort(arrn);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n2 = 0; n2 < arrn.size(); ++n2) {
            arrayList.add(-1);
        }
        for (n2 = 0; n2 < arrn.size(); ++n2) {
            arrayList.set(Collections.binarySearch(arrn, object[n2]), n2);
        }
        if (((f)arrn.get(0)).g() != 0) {
            Object object2;
            n2 = 0;
            while (n2 < arrn.size()) {
                int n4;
                f f2 = (f)arrn.get(n2);
                int n5 = n4 = n2 + 1;
                while (n5 < arrn.size() && ((f)(object2 = (f)arrn.get(n5))).a(f2)) {
                    if (((f)object2).g() != f2.g()) {
                        if ((Integer)arrayList.get(n5) > (Integer)arrayList.get(n2)) {
                            arrn.remove(n5);
                            arrayList.remove(n5);
                            continue;
                        }
                        ++n5;
                        continue;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("duplicate option: ");
                    ((StringBuilder)object).append(object2);
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                n2 = n4;
            }
            object2 = new c();
            m.a(0L, (c)object2, 0, arrn, 0, arrn.size(), arrayList);
            arrn = new int[m.a((c)object2)];
            for (n2 = n3; n2 < arrn.length; ++n2) {
                arrn[n2] = ((c)object2).k();
            }
            if (((c)object2).f()) {
                return new m((f[])object.clone(), arrn);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    private static void a(long l2, c c2, int n2, List<f> list, int n3, int n4, List<Integer> list2) {
        int n5 = n3;
        if (n5 < n4) {
            int n6;
            int n7;
            for (n6 = n5; n6 < n4; ++n6) {
                if (list.get(n6).g() >= n2) {
                    continue;
                }
                throw new AssertionError();
            }
            f f2 = list.get(n3);
            f f3 = list.get(n4 - 1);
            n6 = -1;
            n3 = n5;
            Object object = f2;
            if (n2 == f2.g()) {
                n6 = list2.get(n5);
                n3 = n5 + 1;
                object = list.get(n3);
            }
            if (((f)object).a(n2) != f3.a(n2)) {
                byte by2 = 1;
                for (n5 = n3 + 1; n5 < n4; ++n5) {
                    byte by3 = by2;
                    if (list.get(n5 - 1).a(n2) != list.get(n5).a(n2)) {
                        by3 = by2 + 1;
                    }
                    by2 = by3;
                }
                l2 = l2 + (long)m.a(c2) + 2L + (long)(by2 * 2);
                c2.d(by2);
                c2.d(n6);
                for (n5 = n3; n5 < n4; ++n5) {
                    n6 = list.get(n5).a(n2);
                    if (n5 != n3 && n6 == list.get(n5 - 1).a(n2)) continue;
                    c2.d(n6 & 255);
                }
                object = new c();
                n5 = n3;
                while (n5 < n4) {
                    block17 : {
                        by2 = list.get(n5).a(n2);
                        for (n3 = n6 = n5 + 1; n3 < n4; ++n3) {
                            if (by2 == list.get(n3).a(n2)) {
                                continue;
                            }
                            break block17;
                        }
                        n3 = n4;
                    }
                    if (n6 == n3 && n2 + 1 == list.get(n5).g()) {
                        c2.d(list2.get(n5));
                    } else {
                        c2.d((int)(((long)m.a((c)object) + l2) * -1L));
                        m.a(l2, (c)object, n2 + 1, list, n5, n3, list2);
                    }
                    n5 = n3;
                }
                c2.a_((c)object, ((c)object).b());
                return;
            }
            int n8 = Math.min(((f)object).g(), f3.g());
            n5 = 0;
            for (n7 = n2; n7 < n8 && ((f)object).a(n7) == f3.a(n7); ++n7) {
                ++n5;
            }
            l2 = l2 + (long)m.a(c2) + 2L + (long)n5 + 1L;
            c2.d(-n5);
            c2.d(n6);
            for (n6 = n2; n6 < (n7 = n2 + n5); ++n6) {
                c2.d(((f)object).a(n6) & 255);
            }
            if (n3 + 1 == n4) {
                if (n7 == list.get(n3).g()) {
                    c2.d(list2.get(n3));
                    return;
                }
                throw new AssertionError();
            }
            object = new c();
            c2.d((int)(((long)m.a((c)object) + l2) * -1L));
            m.a(l2, (c)object, n7, list, n3, n4, list2);
            c2.a_((c)object, ((c)object).b());
            return;
        }
        throw new AssertionError();
    }

    public f a(int n2) {
        return this.a[n2];
    }

    @Override
    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    @Override
    public final int size() {
        return this.a.length;
    }
}

