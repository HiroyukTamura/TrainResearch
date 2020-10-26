/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class i<E>
extends AbstractList<E>
implements RandomAccess {
    private int a;
    private Object b;

    @Override
    public void add(int n2, E object) {
        if (n2 >= 0 && n2 <= this.a) {
            if (this.a == 0) {
                this.b = object;
            } else if (this.a == 1 && n2 == 0) {
                this.b = new Object[]{object, this.b};
            } else {
                Object[] arrobject = new Object[this.a + 1];
                if (this.a == 1) {
                    arrobject[0] = this.b;
                } else {
                    Object[] arrobject2 = (Object[])this.b;
                    System.arraycopy(arrobject2, 0, arrobject, 0, n2);
                    System.arraycopy(arrobject2, n2, arrobject, n2 + 1, this.a - n2);
                }
                arrobject[n2] = object;
                this.b = arrobject;
            }
            ++this.a;
            ++this.modCount;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Index: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", Size: ");
        ((StringBuilder)object).append(this.a);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @Override
    public boolean add(E e2) {
        if (this.a == 0) {
            this.b = e2;
        } else if (this.a == 1) {
            this.b = new Object[]{this.b, e2};
        } else {
            Object[] arrobject = (Object[])this.b;
            int n2 = arrobject.length;
            Object[] arrobject2 = arrobject;
            if (this.a >= n2) {
                int n3 = n2 * 3 / 2 + 1;
                int n4 = this.a + 1;
                if (n3 < n4) {
                    n3 = n4;
                }
                this.b = arrobject2 = new Object[n3];
                System.arraycopy(arrobject, 0, arrobject2, 0, n2);
            }
            arrobject2[this.a] = e2;
        }
        ++this.a;
        ++this.modCount;
        return true;
    }

    @Override
    public void clear() {
        this.b = null;
        this.a = 0;
        ++this.modCount;
    }

    @Override
    public E get(int n2) {
        if (n2 >= 0 && n2 < this.a) {
            if (this.a == 1) {
                return (E)this.b;
            }
            return (E)((Object[])this.b)[n2];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n2);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public Iterator<E> iterator() {
        if (this.a == 0) {
            return a.a();
        }
        if (this.a == 1) {
            return new b();
        }
        return super.iterator();
    }

    @Override
    public E remove(int n2) {
        if (n2 >= 0 && n2 < this.a) {
            Object object;
            if (this.a == 1) {
                object = this.b;
                this.b = null;
            } else {
                Object[] arrobject = (Object[])this.b;
                object = arrobject[n2];
                if (this.a == 2) {
                    this.b = arrobject[1 - n2];
                } else {
                    int n3 = this.a - n2 - 1;
                    if (n3 > 0) {
                        System.arraycopy(arrobject, n2 + 1, arrobject, n2, n3);
                    }
                    arrobject[this.a - 1] = null;
                }
            }
            --this.a;
            ++this.modCount;
            return (E)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n2);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public E set(int n2, E object) {
        if (n2 >= 0 && n2 < this.a) {
            if (this.a == 1) {
                Object object2 = this.b;
                this.b = object;
                return (E)object2;
            }
            Object[] arrobject = (Object[])this.b;
            Object object3 = arrobject[n2];
            arrobject[n2] = object;
            return (E)object3;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Index: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", Size: ");
        ((StringBuilder)object).append(this.a);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @Override
    public int size() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public <T> T[] toArray(T[] arrobject) {
        int n2 = arrobject.length;
        if (this.a == 1) {
            if (n2 == 0) {
                arrobject = (Object[])Array.newInstance(arrobject.getClass().getComponentType(), 1);
                arrobject[0] = this.b;
                return arrobject;
            }
            arrobject[0] = this.b;
        } else {
            if (n2 < this.a) {
                return Arrays.copyOf((Object[])this.b, this.a, arrobject.getClass());
            }
            if (this.a != 0) {
                System.arraycopy(this.b, 0, arrobject, 0, this.a);
            }
        }
        if (n2 > this.a) {
            arrobject[this.a] = null;
        }
        return arrobject;
    }

    private static class a<T>
    implements Iterator<T> {
        private static final a a = new a<T>();

        private a() {
        }

        public static <T> a<T> a() {
            return a;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new IllegalStateException();
        }
    }

    private class b
    extends c<E> {
        private final int b;

        public b() {
            super();
            this.b = i.this.modCount;
        }

        @Override
        protected E a() {
            return (E)i.this.b;
        }

        @Override
        protected void b() {
            if (i.this.modCount == this.b) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModCount: ");
            stringBuilder.append(i.this.modCount);
            stringBuilder.append("; expected: ");
            stringBuilder.append(this.b);
            throw new ConcurrentModificationException(stringBuilder.toString());
        }

        @Override
        public void remove() {
            this.b();
            i.this.clear();
        }
    }

    private static abstract class c<T>
    implements Iterator<T> {
        private boolean a;

        private c() {
        }

        protected abstract T a();

        protected abstract void b();

        @Override
        public final boolean hasNext() {
            return this.a ^ true;
        }

        @Override
        public final T next() {
            if (!this.a) {
                this.a = true;
                this.b();
                return this.a();
            }
            throw new NoSuchElementException();
        }
    }

}

