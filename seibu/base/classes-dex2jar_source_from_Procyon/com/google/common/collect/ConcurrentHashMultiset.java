// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.math.IntMath;
import java.util.Map;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import com.google.common.annotations.Beta;
import java.util.concurrent.ConcurrentHashMap;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentMap;
import java.io.Serializable;

public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;
    
    @VisibleForTesting
    ConcurrentHashMultiset(final ConcurrentMap<E, AtomicInteger> countMap) {
        Preconditions.checkArgument(countMap.isEmpty());
        this.countMap = countMap;
    }
    
    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<E>(new ConcurrentHashMap<E, AtomicInteger>());
    }
    
    @Beta
    public static <E> ConcurrentHashMultiset<E> create(final MapMaker mapMaker) {
        return new ConcurrentHashMultiset<E>(mapMaker.makeMap());
    }
    
    public static <E> ConcurrentHashMultiset<E> create(final Iterable<? extends E> iterable) {
        final ConcurrentHashMultiset<Object> create = create();
        Iterables.addAll(create, iterable);
        return (ConcurrentHashMultiset<E>)create;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, objectInputStream.readObject());
    }
    
    private List<E> snapshot() {
        final ArrayList<E> arrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(this.size());
        for (final Multiset.Entry<Object> entry : this.entrySet()) {
            final E element = entry.getElement();
            for (int i = entry.getCount(); i > 0; --i) {
                arrayListWithExpectedSize.add(element);
            }
        }
        return arrayListWithExpectedSize;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }
    
    @Override
    public int add(final E e, final int n) {
        final int n2 = 0;
        Preconditions.checkNotNull(e);
        int count;
        if (n == 0) {
            count = this.count(e);
        }
        else {
            while (true) {
                AtomicInteger atomicInteger = null;
                Label_0128: {
                    if (n <= 0) {
                        break Label_0128;
                    }
                    boolean b = true;
                Label_0098_Outer:
                    while (true) {
                        Preconditions.checkArgument(b, "Invalid occurrences: %s", n);
                        if ((atomicInteger = Maps.safeGet(this.countMap, e)) == null) {
                            atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(n));
                            count = n2;
                            if (atomicInteger == null) {
                                return count;
                            }
                        }
                        while (true) {
                            final int value = atomicInteger.get();
                            if (value == 0) {
                                break Label_0128;
                            }
                            try {
                                if (atomicInteger.compareAndSet(value, IntMath.checkedAdd(value, n))) {
                                    return value;
                                }
                                continue;
                                b = false;
                                continue Label_0098_Outer;
                            }
                            catch (ArithmeticException ex) {
                                throw new IllegalArgumentException(new StringBuilder(65).append("Overflow adding ").append(n).append(" occurrences to a count of ").append(value).toString());
                            }
                            break;
                        }
                        break;
                    }
                }
                final AtomicInteger atomicInteger2 = new AtomicInteger(n);
                count = n2;
                if (this.countMap.putIfAbsent(e, atomicInteger2) != null) {
                    if (this.countMap.replace(e, atomicInteger, atomicInteger2)) {
                        return 0;
                    }
                    continue;
                }
                break;
            }
        }
        return count;
    }
    
    @Override
    public void clear() {
        this.countMap.clear();
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final AtomicInteger atomicInteger = Maps.safeGet(this.countMap, o);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }
    
    @Override
    Set<E> createElementSet() {
        return new ForwardingSet<E>() {
            final /* synthetic */ Set val$delegate = ConcurrentHashMultiset.this.countMap.keySet();
            
            @Override
            public boolean contains(@Nullable final Object o) {
                return o != null && Collections2.safeContains(this.val$delegate, o);
            }
            
            @Override
            public boolean containsAll(final Collection<?> collection) {
                return this.standardContainsAll(collection);
            }
            
            @Override
            protected Set<E> delegate() {
                return (Set<E>)this.val$delegate;
            }
            
            @Override
            public boolean remove(final Object o) {
                return o != null && Collections2.safeRemove(this.val$delegate, o);
            }
            
            @Override
            public boolean removeAll(final Collection<?> collection) {
                return this.standardRemoveAll(collection);
            }
        };
    }
    
    public Set<Entry<E>> createEntrySet() {
        return (Set<Entry<E>>)new EntrySet();
    }
    
    @Override
    int distinctElements() {
        return this.countMap.size();
    }
    
    @Override
    Iterator<Entry<E>> entryIterator() {
        return new ForwardingIterator<Entry<E>>() {
            private Entry<E> last;
            final /* synthetic */ Iterator val$readOnlyIterator = new AbstractIterator<Entry<E>>(this) {
                private Iterator<Map.Entry<E, AtomicInteger>> mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
                
                @Override
                protected Entry<E> computeNext() {
                    while (this.mapEntries.hasNext()) {
                        final Map.Entry entry = this.mapEntries.next();
                        final int value = entry.getValue().get();
                        if (value != 0) {
                            return Multisets.immutableEntry((E)entry.getKey(), value);
                        }
                    }
                    return (Entry<E>)((AbstractIterator<Multiset.Entry>)this).endOfData();
                }
            };
            
            @Override
            protected Iterator<Entry<E>> delegate() {
                return (Iterator<Entry<E>>)this.val$readOnlyIterator;
            }
            
            @Override
            public Entry<E> next() {
                return this.last = (Entry<E>)super.next();
            }
            
            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.last != null);
                ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
                this.last = null;
            }
        };
    }
    
    @Override
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }
    
    @Override
    public int remove(@Nullable final Object o, final int i) {
        final int n = 0;
        int count;
        if (i == 0) {
            count = this.count(o);
        }
        else {
            Preconditions.checkArgument(i > 0, "Invalid occurrences: %s", i);
            final AtomicInteger atomicInteger = Maps.safeGet(this.countMap, o);
            count = n;
            if (atomicInteger != null) {
                int value;
                int max;
                do {
                    value = atomicInteger.get();
                    count = n;
                    if (value == 0) {
                        return count;
                    }
                    max = Math.max(0, value - i);
                } while (!atomicInteger.compareAndSet(value, max));
                if (max == 0) {
                    this.countMap.remove(o, atomicInteger);
                }
                return value;
            }
        }
        return count;
    }
    
    public boolean removeExactly(@Nullable final Object o, final int i) {
        if (i != 0) {
            Preconditions.checkArgument(i > 0, "Invalid occurrences: %s", i);
            final AtomicInteger atomicInteger = Maps.safeGet(this.countMap, o);
            if (atomicInteger == null) {
                return false;
            }
            int value;
            int newValue;
            do {
                value = atomicInteger.get();
                if (value < i) {
                    return false;
                }
                newValue = value - i;
            } while (!atomicInteger.compareAndSet(value, newValue));
            if (newValue == 0) {
                this.countMap.remove(o, atomicInteger);
                return true;
            }
        }
        return true;
    }
    
    @Override
    public int setCount(final E e, final int initialValue) {
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(initialValue, "count");
        int n = 0;
    Label_0013:
        while (true) {
            AtomicInteger atomicInteger;
            if ((atomicInteger = Maps.safeGet(this.countMap, e)) == null) {
                if (initialValue == 0) {
                    n = 0;
                    break;
                }
                if ((atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(initialValue))) == null) {
                    return 0;
                }
            }
            int value;
            do {
                value = atomicInteger.get();
                if (value == 0) {
                    if (initialValue == 0) {
                        return 0;
                    }
                    final AtomicInteger atomicInteger2 = new AtomicInteger(initialValue);
                    if (this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2)) {
                        return 0;
                    }
                    continue Label_0013;
                }
            } while (!atomicInteger.compareAndSet(value, initialValue));
            n = value;
            if (initialValue == 0) {
                this.countMap.remove(e, atomicInteger);
                return value;
            }
            break;
        }
        return n;
    }
    
    @Override
    public boolean setCount(final E e, final int n, final int initialValue) {
        boolean b = false;
        final boolean b2 = true;
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(initialValue, "newCount");
        final AtomicInteger atomicInteger = Maps.safeGet(this.countMap, e);
        if (atomicInteger != null) {
            final int value = atomicInteger.get();
            if (value == n) {
                if (value == 0) {
                    if (initialValue == 0) {
                        this.countMap.remove(e, atomicInteger);
                        return true;
                    }
                    final AtomicInteger atomicInteger2 = new AtomicInteger(initialValue);
                    if (this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2)) {
                        b = true;
                    }
                    return b;
                }
                else if (atomicInteger.compareAndSet(value, initialValue)) {
                    final boolean b3 = b2;
                    if (initialValue == 0) {
                        this.countMap.remove(e, atomicInteger);
                        return true;
                    }
                    return b3;
                }
            }
            return false;
        }
        boolean b3;
        if (n != 0) {
            b3 = false;
        }
        else {
            b3 = b2;
            if (initialValue != 0) {
                b3 = b2;
                if (this.countMap.putIfAbsent(e, new AtomicInteger(initialValue)) != null) {
                    return false;
                }
            }
        }
        return b3;
    }
    
    @Override
    public int size() {
        long n = 0L;
        final Iterator<AtomicInteger> iterator = this.countMap.values().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().get();
        }
        return Ints.saturatedCast(n);
    }
    
    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        return this.snapshot().toArray(array);
    }
    
    private class EntrySet extends AbstractMultiset.EntrySet
    {
        private List<Entry<E>> snapshot() {
            final ArrayList<Object> arrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(((AbstractMultiset.EntrySet)this).size());
            Iterators.addAll(arrayListWithExpectedSize, ((AbstractMultiset.EntrySet)this).iterator());
            return (List<Entry<E>>)arrayListWithExpectedSize;
        }
        
        ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }
        
        @Override
        public Object[] toArray() {
            return this.snapshot().toArray();
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            return this.snapshot().toArray(array);
        }
    }
    
    private static class FieldSettersHolder
    {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER;
        
        static {
            COUNT_MAP_FIELD_SETTER = (Serialization.FieldSetter)Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
        }
    }
}
