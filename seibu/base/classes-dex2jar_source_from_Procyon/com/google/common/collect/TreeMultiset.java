// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.ConcurrentModificationException;
import com.google.common.base.MoreObjects;
import java.util.Set;
import java.util.NavigableSet;
import com.google.common.primitives.Ints;
import java.util.NoSuchElementException;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import javax.annotation.Nullable;
import java.util.Comparator;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable
{
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 1L;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;
    
    TreeMultiset(final Reference<AvlNode<E>> rootReference, final GeneralRange<E> range, final AvlNode<E> header) {
        super(range.comparator());
        this.rootReference = rootReference;
        this.range = range;
        this.header = header;
    }
    
    TreeMultiset(final Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        successor(this.header = new AvlNode<E>(null, 1), this.header);
        this.rootReference = new Reference<AvlNode<E>>();
    }
    
    private long aggregateAboveRange(final Aggregate aggregate, @Nullable final AvlNode<E> avlNode) {
        if (avlNode == null) {
            return 0L;
        }
        final int compare = this.comparator().compare(this.range.getUpperEndpoint(), ((AvlNode<Object>)avlNode).elem);
        if (compare > 0) {
            return this.aggregateAboveRange(aggregate, ((AvlNode<Object>)avlNode).right);
        }
        if (compare != 0) {
            return aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).right) + aggregate.nodeAggregate((AvlNode<?>)avlNode) + this.aggregateAboveRange(aggregate, ((AvlNode<Object>)avlNode).left);
        }
        switch (this.range.getUpperBoundType()) {
            default: {
                throw new AssertionError();
            }
            case OPEN: {
                return aggregate.nodeAggregate((AvlNode<?>)avlNode) + aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).right);
            }
            case CLOSED: {
                return aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).right);
            }
        }
    }
    
    private long aggregateBelowRange(final Aggregate aggregate, @Nullable final AvlNode<E> avlNode) {
        if (avlNode == null) {
            return 0L;
        }
        final int compare = this.comparator().compare(this.range.getLowerEndpoint(), ((AvlNode<Object>)avlNode).elem);
        if (compare < 0) {
            return this.aggregateBelowRange(aggregate, ((AvlNode<Object>)avlNode).left);
        }
        if (compare != 0) {
            return aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).left) + aggregate.nodeAggregate((AvlNode<?>)avlNode) + this.aggregateBelowRange(aggregate, ((AvlNode<Object>)avlNode).right);
        }
        switch (this.range.getLowerBoundType()) {
            default: {
                throw new AssertionError();
            }
            case OPEN: {
                return aggregate.nodeAggregate((AvlNode<?>)avlNode) + aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).left);
            }
            case CLOSED: {
                return aggregate.treeAggregate((AvlNode<?>)((AvlNode<Object>)avlNode).left);
            }
        }
    }
    
    private long aggregateForEntries(final Aggregate aggregate) {
        final AvlNode<E> avlNode = this.rootReference.get();
        long treeAggregate;
        final long n = treeAggregate = aggregate.treeAggregate((AvlNode<?>)avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate = n - this.aggregateBelowRange(aggregate, avlNode);
        }
        long n2 = treeAggregate;
        if (this.range.hasUpperBound()) {
            n2 = treeAggregate - this.aggregateAboveRange(aggregate, avlNode);
        }
        return n2;
    }
    
    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<E>(Ordering.natural());
    }
    
    public static <E extends Comparable> TreeMultiset<E> create(final Iterable<? extends E> iterable) {
        final TreeMultiset<Object> create = (TreeMultiset<Object>)create();
        Iterables.addAll(create, iterable);
        return (TreeMultiset<E>)create;
    }
    
    public static <E> TreeMultiset<E> create(@Nullable final Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<E>((Comparator<? super E>)Ordering.natural());
        }
        return new TreeMultiset<E>(comparator);
    }
    
    static int distinctElements(@Nullable final AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return ((AvlNode<Object>)avlNode).distinctElements;
    }
    
    @Nullable
    private AvlNode<E> firstNode() {
        if (this.rootReference.get() != null) {
            AvlNode<Object> avlNode;
            if (this.range.hasLowerBound()) {
                final E lowerEndpoint = this.range.getLowerEndpoint();
                final AvlNode<Object> access$800 = ((AvlNode<Object>)this.rootReference.get()).ceiling(this.comparator(), lowerEndpoint);
                if (access$800 == null) {
                    return null;
                }
                avlNode = access$800;
                if (this.range.getLowerBoundType() == BoundType.OPEN) {
                    avlNode = access$800;
                    if (this.comparator().compare(lowerEndpoint, access$800.getElement()) == 0) {
                        avlNode = access$800.succ;
                    }
                }
            }
            else {
                avlNode = ((AvlNode<Object>)this.header).succ;
            }
            if (avlNode != this.header) {
                final Multisets.AbstractEntry<E> abstractEntry = (Multisets.AbstractEntry<E>)avlNode;
                if (this.range.contains(avlNode.getElement())) {
                    return (AvlNode<E>)abstractEntry;
                }
            }
            final Multisets.AbstractEntry<E> abstractEntry = null;
            return (AvlNode<E>)abstractEntry;
        }
        return null;
    }
    
    @Nullable
    private AvlNode<E> lastNode() {
        if (this.rootReference.get() != null) {
            AvlNode<Object> avlNode;
            if (this.range.hasUpperBound()) {
                final E upperEndpoint = this.range.getUpperEndpoint();
                final AvlNode<Object> access$1000 = ((AvlNode<Object>)this.rootReference.get()).floor(this.comparator(), upperEndpoint);
                if (access$1000 == null) {
                    return null;
                }
                avlNode = access$1000;
                if (this.range.getUpperBoundType() == BoundType.OPEN) {
                    avlNode = access$1000;
                    if (this.comparator().compare(upperEndpoint, access$1000.getElement()) == 0) {
                        avlNode = access$1000.pred;
                    }
                }
            }
            else {
                avlNode = ((AvlNode<Object>)this.header).pred;
            }
            if (avlNode != this.header) {
                final Multisets.AbstractEntry<E> abstractEntry = (Multisets.AbstractEntry<E>)avlNode;
                if (this.range.contains(avlNode.getElement())) {
                    return (AvlNode<E>)abstractEntry;
                }
            }
            final Multisets.AbstractEntry<E> abstractEntry = null;
            return (AvlNode<E>)abstractEntry;
        }
        return null;
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        final Comparator comparator = (Comparator)objectInputStream.readObject();
        Serialization.getFieldSetter((Class<TreeMultiset>)AbstractSortedMultiset.class, "comparator").set(this, comparator);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set(this, GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set(this, new Reference());
        final AvlNode<Object> avlNode = new AvlNode<Object>(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set(this, avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset((Multiset<Object>)this, objectInputStream);
    }
    
    private static <T> void successor(final AvlNode<T> avlNode, final AvlNode<T> avlNode2) {
        ((AvlNode<Object>)avlNode).succ = (AvlNode<Object>)avlNode2;
        ((AvlNode<Object>)avlNode2).pred = (AvlNode<Object>)avlNode;
    }
    
    private static <T> void successor(final AvlNode<T> avlNode, final AvlNode<T> avlNode2, final AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }
    
    private Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() {
            @Override
            public int getCount() {
                int n;
                if ((n = avlNode.getCount()) == 0) {
                    n = TreeMultiset.this.count(this.getElement());
                }
                return n;
            }
            
            @Override
            public E getElement() {
                return avlNode.getElement();
            }
        };
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.elementSet().comparator());
        Serialization.writeMultiset((Multiset<Object>)this, objectOutputStream);
    }
    
    @Override
    public int add(@Nullable final E e, final int n) {
        CollectPreconditions.checkNonnegative(n, "occurrences");
        if (n == 0) {
            return this.count(e);
        }
        Preconditions.checkArgument(this.range.contains(e));
        final AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            this.comparator().compare(e, e);
            final AvlNode<E> avlNode2 = new AvlNode<E>(e, n);
            successor(this.header, avlNode2, this.header);
            this.rootReference.checkAndSet(avlNode, avlNode2);
            return 0;
        }
        final int[] array = { 0 };
        this.rootReference.checkAndSet(avlNode, avlNode.add(this.comparator(), e, n, array));
        return array[0];
    }
    
    @Override
    public int count(@Nullable final Object o) {
        try {
            final AvlNode<E> avlNode = this.rootReference.get();
            if (this.range.contains((E)o)) {
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(this.comparator(), (E)o);
            }
        }
        catch (ClassCastException ex) {
            return 0;
        }
        catch (NullPointerException ex2) {}
        return 0;
    }
    
    @Override
    Iterator<Entry<E>> descendingEntryIterator() {
        return new Iterator<Entry<E>>() {
            AvlNode<E> current = TreeMultiset.this.lastNode();
            Entry<E> prevEntry = null;
            
            @Override
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    this.current = null;
                    return false;
                }
                return true;
            }
            
            @Override
            public Entry<E> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final Entry access$1400 = TreeMultiset.this.wrapEntry((AvlNode)this.current);
                this.prevEntry = (Entry<E>)access$1400;
                if (((AvlNode<Object>)this.current).pred == TreeMultiset.this.header) {
                    this.current = null;
                    return (Entry<E>)access$1400;
                }
                this.current = (AvlNode<E>)((AvlNode<Object>)this.current).pred;
                return (Entry<E>)access$1400;
            }
            
            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }
    
    @Override
    int distinctElements() {
        return Ints.saturatedCast(this.aggregateForEntries(Aggregate.DISTINCT));
    }
    
    @Override
    Iterator<Entry<E>> entryIterator() {
        return new Iterator<Entry<E>>() {
            AvlNode<E> current = TreeMultiset.this.firstNode();
            Entry<E> prevEntry;
            
            @Override
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    this.current = null;
                    return false;
                }
                return true;
            }
            
            @Override
            public Entry<E> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final Entry access$1400 = TreeMultiset.this.wrapEntry((AvlNode)this.current);
                this.prevEntry = (Entry<E>)access$1400;
                if (((AvlNode<Object>)this.current).succ == TreeMultiset.this.header) {
                    this.current = null;
                    return (Entry<E>)access$1400;
                }
                this.current = (AvlNode<E>)((AvlNode<Object>)this.current).succ;
                return (Entry<E>)access$1400;
            }
            
            @Override
            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }
    
    @Override
    public SortedMultiset<E> headMultiset(@Nullable final E e, final BoundType boundType) {
        return new TreeMultiset((Reference<AvlNode<Object>>)this.rootReference, (GeneralRange<Object>)this.range.intersect(GeneralRange.upTo(this.comparator(), e, boundType)), (AvlNode<Object>)this.header);
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        final boolean b = false;
        CollectPreconditions.checkNonnegative(n, "occurrences");
        int count;
        if (n == 0) {
            count = this.count(o);
        }
        else {
            final AvlNode<E> avlNode = this.rootReference.get();
            final int[] array = { 0 };
            count = (b ? 1 : 0);
            try {
                if (this.range.contains((E)o)) {
                    count = (b ? 1 : 0);
                    if (avlNode != null) {
                        this.rootReference.checkAndSet(avlNode, avlNode.remove(this.comparator(), (E)o, n, array));
                        return array[0];
                    }
                }
            }
            catch (ClassCastException ex) {
                return 0;
            }
            catch (NullPointerException ex2) {
                return 0;
            }
        }
        return count;
    }
    
    @Override
    public int setCount(@Nullable final E e, final int n) {
        boolean b = true;
        CollectPreconditions.checkNonnegative(n, "count");
        if (!this.range.contains(e)) {
            if (n != 0) {
                b = false;
            }
            Preconditions.checkArgument(b);
        }
        else {
            final AvlNode<E> avlNode = this.rootReference.get();
            if (avlNode != null) {
                final int[] array = { 0 };
                this.rootReference.checkAndSet(avlNode, avlNode.setCount(this.comparator(), e, n, array));
                return array[0];
            }
            if (n > 0) {
                this.add(e, n);
                return 0;
            }
        }
        return 0;
    }
    
    @Override
    public boolean setCount(@Nullable final E e, final int n, final int n2) {
        CollectPreconditions.checkNonnegative(n2, "newCount");
        CollectPreconditions.checkNonnegative(n, "oldCount");
        Preconditions.checkArgument(this.range.contains(e));
        final AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            final int[] array = { 0 };
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(this.comparator(), e, n, n2, array));
            return array[0] == n;
        }
        if (n == 0) {
            if (n2 > 0) {
                this.add(e, n2);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public int size() {
        return Ints.saturatedCast(this.aggregateForEntries(Aggregate.SIZE));
    }
    
    @Override
    public SortedMultiset<E> tailMultiset(@Nullable final E e, final BoundType boundType) {
        return new TreeMultiset((Reference<AvlNode<Object>>)this.rootReference, (GeneralRange<Object>)this.range.intersect(GeneralRange.downTo(this.comparator(), e, boundType)), (AvlNode<Object>)this.header);
    }
    
    private enum Aggregate
    {
        DISTINCT {
            @Override
            int nodeAggregate(final AvlNode<?> avlNode) {
                return 1;
            }
            
            @Override
            long treeAggregate(@Nullable final AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode<Object>)avlNode).distinctElements;
            }
        }, 
        SIZE {
            @Override
            int nodeAggregate(final AvlNode<?> avlNode) {
                return ((AvlNode<Object>)avlNode).elemCount;
            }
            
            @Override
            long treeAggregate(@Nullable final AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode<Object>)avlNode).totalCount;
            }
        };
        
        abstract int nodeAggregate(final AvlNode<?> p0);
        
        abstract long treeAggregate(@Nullable final AvlNode<?> p0);
    }
    
    private static final class AvlNode<E> extends AbstractEntry<E>
    {
        private int distinctElements;
        @Nullable
        private final E elem;
        private int elemCount;
        private int height;
        private AvlNode<E> left;
        private AvlNode<E> pred;
        private AvlNode<E> right;
        private AvlNode<E> succ;
        private long totalCount;
        
        AvlNode(@Nullable final E elem, final int elemCount) {
            Preconditions.checkArgument(elemCount > 0);
            this.elem = elem;
            this.elemCount = elemCount;
            this.totalCount = elemCount;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
        
        private AvlNode<E> addLeftChild(final E e, final int n) {
            this.left = new AvlNode<E>(e, n);
            successor(this.pred, this.left, (AvlNode<Object>)this);
            this.height = Math.max(2, this.height);
            ++this.distinctElements;
            this.totalCount += n;
            return this;
        }
        
        private AvlNode<E> addRightChild(final E e, final int n) {
            successor(this, this.right = new AvlNode<E>(e, n), (AvlNode<Object>)this.succ);
            this.height = Math.max(2, this.height);
            ++this.distinctElements;
            this.totalCount += n;
            return this;
        }
        
        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }
        
        @Nullable
        private AvlNode<E> ceiling(final Comparator<? super E> comparator, final E e) {
            final int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                if (this.left != null) {
                    return MoreObjects.firstNonNull(this.left.ceiling(comparator, e), this);
                }
            }
            else if (compare != 0) {
                AvlNode<E> ceiling;
                if (this.right == null) {
                    ceiling = null;
                }
                else {
                    ceiling = this.right.ceiling(comparator, e);
                }
                return ceiling;
            }
            return this;
        }
        
        private AvlNode<E> deleteMe() {
            final int elemCount = this.elemCount;
            this.elemCount = 0;
            successor(this.pred, (AvlNode<Object>)this.succ);
            if (this.left == null) {
                return this.right;
            }
            if (this.right == null) {
                return this.left;
            }
            if (this.left.height >= this.right.height) {
                final AvlNode<E> pred = this.pred;
                pred.left = this.left.removeMax(pred);
                pred.right = this.right;
                pred.distinctElements = this.distinctElements - 1;
                pred.totalCount = this.totalCount - elemCount;
                return (AvlNode<E>)pred.rebalance();
            }
            final AvlNode<E> succ = this.succ;
            succ.right = this.right.removeMin(succ);
            succ.left = this.left;
            succ.distinctElements = this.distinctElements - 1;
            succ.totalCount = this.totalCount - elemCount;
            return (AvlNode<E>)succ.rebalance();
        }
        
        @Nullable
        private AvlNode<E> floor(final Comparator<? super E> comparator, final E e) {
            final int compare = comparator.compare(e, this.elem);
            if (compare > 0) {
                if (this.right != null) {
                    return MoreObjects.firstNonNull(this.right.floor(comparator, e), this);
                }
            }
            else if (compare != 0) {
                AvlNode<E> floor;
                if (this.left == null) {
                    floor = null;
                }
                else {
                    floor = this.left.floor(comparator, e);
                }
                return floor;
            }
            return this;
        }
        
        private static int height(@Nullable final AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.height;
        }
        
        private AvlNode<E> rebalance() {
            switch (this.balanceFactor()) {
                default: {
                    this.recomputeHeight();
                    return this;
                }
                case -2: {
                    if (this.right.balanceFactor() > 0) {
                        this.right = this.right.rotateRight();
                    }
                    return this.rotateLeft();
                }
                case 2: {
                    if (this.left.balanceFactor() < 0) {
                        this.left = this.left.rotateLeft();
                    }
                    return this.rotateRight();
                }
            }
        }
        
        private void recompute() {
            this.recomputeMultiset();
            this.recomputeHeight();
        }
        
        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }
        
        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
        }
        
        private AvlNode<E> removeMax(final AvlNode<E> avlNode) {
            if (this.right == null) {
                return this.left;
            }
            this.right = this.right.removeMax(avlNode);
            --this.distinctElements;
            this.totalCount -= avlNode.elemCount;
            return this.rebalance();
        }
        
        private AvlNode<E> removeMin(final AvlNode<E> avlNode) {
            if (this.left == null) {
                return this.right;
            }
            this.left = this.left.removeMin(avlNode);
            --this.distinctElements;
            this.totalCount -= avlNode.elemCount;
            return this.rebalance();
        }
        
        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            final AvlNode<E> right = this.right;
            this.right = right.left;
            right.left = this;
            right.totalCount = this.totalCount;
            right.distinctElements = this.distinctElements;
            this.recompute();
            right.recomputeHeight();
            return right;
        }
        
        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            final AvlNode<E> left = this.left;
            this.left = left.right;
            left.right = this;
            left.totalCount = this.totalCount;
            left.distinctElements = this.distinctElements;
            this.recompute();
            left.recomputeHeight();
            return left;
        }
        
        private static long totalCount(@Nullable final AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return avlNode.totalCount;
        }
        
        AvlNode<E> add(final Comparator<? super E> comparator, @Nullable final E e, final int n, final int[] array) {
            final int compare = comparator.compare(e, this.elem);
            AvlNode<E> addLeftChild;
            if (compare < 0) {
                final AvlNode<E> left = this.left;
                if (left == null) {
                    array[0] = 0;
                    addLeftChild = this.addLeftChild(e, n);
                }
                else {
                    final int height = left.height;
                    this.left = (AvlNode<E>)left.add((Comparator<? super Object>)comparator, (Object)e, n, array);
                    if (array[0] == 0) {
                        ++this.distinctElements;
                    }
                    this.totalCount += n;
                    addLeftChild = this;
                    if (this.left.height != height) {
                        return this.rebalance();
                    }
                }
            }
            else {
                if (compare <= 0) {
                    array[0] = this.elemCount;
                    Preconditions.checkArgument(this.elemCount + (long)n <= 2147483647L);
                    this.elemCount += n;
                    this.totalCount += n;
                    return this;
                }
                final AvlNode<E> right = this.right;
                if (right == null) {
                    array[0] = 0;
                    return this.addRightChild(e, n);
                }
                final int height2 = right.height;
                this.right = (AvlNode<E>)right.add((Comparator<? super Object>)comparator, (Object)e, n, array);
                if (array[0] == 0) {
                    ++this.distinctElements;
                }
                this.totalCount += n;
                addLeftChild = this;
                if (this.right.height != height2) {
                    return this.rebalance();
                }
            }
            return addLeftChild;
        }
        
        public int count(final Comparator<? super E> comparator, final E e) {
            final int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                if (this.left != null) {
                    return this.left.count(comparator, e);
                }
            }
            else {
                if (compare <= 0) {
                    return this.elemCount;
                }
                if (this.right != null) {
                    return this.right.count(comparator, e);
                }
            }
            return 0;
        }
        
        @Override
        public int getCount() {
            return this.elemCount;
        }
        
        @Override
        public E getElement() {
            return this.elem;
        }
        
        AvlNode<E> remove(final Comparator<? super E> comparator, @Nullable final E e, final int n, final int[] array) {
            final int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                final AvlNode<E> left = this.left;
                if (left == null) {
                    array[0] = 0;
                }
                else {
                    this.left = (AvlNode<E>)left.remove((Comparator<? super Object>)comparator, (Object)e, n, array);
                    if (array[0] > 0) {
                        if (n >= array[0]) {
                            --this.distinctElements;
                            this.totalCount -= array[0];
                        }
                        else {
                            this.totalCount -= n;
                        }
                    }
                    if (array[0] != 0) {
                        return this.rebalance();
                    }
                }
                return this;
            }
            if (compare > 0) {
                final AvlNode<E> right = this.right;
                if (right == null) {
                    array[0] = 0;
                    return this;
                }
                this.right = (AvlNode<E>)right.remove((Comparator<? super Object>)comparator, (Object)e, n, array);
                if (array[0] > 0) {
                    if (n >= array[0]) {
                        --this.distinctElements;
                        this.totalCount -= array[0];
                    }
                    else {
                        this.totalCount -= n;
                    }
                }
                return this.rebalance();
            }
            else {
                array[0] = this.elemCount;
                if (n >= this.elemCount) {
                    return this.deleteMe();
                }
                this.elemCount -= n;
                this.totalCount -= n;
                return this;
            }
        }
        
        AvlNode<E> setCount(final Comparator<? super E> comparator, @Nullable final E e, final int n, final int elemCount, final int[] array) {
            final int compare = comparator.compare(e, this.elem);
            AvlNode addLeftChild;
            if (compare < 0) {
                final AvlNode<E> left = this.left;
                if (left != null) {
                    this.left = (AvlNode<E>)left.setCount((Comparator<? super Object>)comparator, (Object)e, n, elemCount, array);
                    if (array[0] == n) {
                        if (elemCount == 0 && array[0] != 0) {
                            --this.distinctElements;
                        }
                        else if (elemCount > 0 && array[0] == 0) {
                            ++this.distinctElements;
                        }
                        this.totalCount += elemCount - array[0];
                    }
                    return this.rebalance();
                }
                array[0] = 0;
                addLeftChild = this;
                if (n == 0) {
                    addLeftChild = this;
                    if (elemCount > 0) {
                        addLeftChild = this.addLeftChild(e, elemCount);
                    }
                }
            }
            else if (compare > 0) {
                final AvlNode<E> right = this.right;
                if (right != null) {
                    this.right = (AvlNode<E>)right.setCount((Comparator<? super Object>)comparator, (Object)e, n, elemCount, array);
                    if (array[0] == n) {
                        if (elemCount == 0 && array[0] != 0) {
                            --this.distinctElements;
                        }
                        else if (elemCount > 0 && array[0] == 0) {
                            ++this.distinctElements;
                        }
                        this.totalCount += elemCount - array[0];
                    }
                    return this.rebalance();
                }
                array[0] = 0;
                addLeftChild = this;
                if (n == 0) {
                    addLeftChild = this;
                    if (elemCount > 0) {
                        return this.addRightChild(e, elemCount);
                    }
                }
            }
            else {
                array[0] = this.elemCount;
                addLeftChild = this;
                if (n == this.elemCount) {
                    if (elemCount == 0) {
                        return this.deleteMe();
                    }
                    this.totalCount += elemCount - this.elemCount;
                    this.elemCount = elemCount;
                    return this;
                }
            }
            return addLeftChild;
        }
        
        AvlNode<E> setCount(final Comparator<? super E> comparator, @Nullable final E e, final int elemCount, final int[] array) {
            final int compare = comparator.compare(e, this.elem);
            AvlNode addLeftChild;
            if (compare < 0) {
                final AvlNode<E> left = this.left;
                if (left != null) {
                    this.left = (AvlNode<E>)left.setCount((Comparator<? super Object>)comparator, (Object)e, elemCount, array);
                    if (elemCount == 0 && array[0] != 0) {
                        --this.distinctElements;
                    }
                    else if (elemCount > 0 && array[0] == 0) {
                        ++this.distinctElements;
                    }
                    this.totalCount += elemCount - array[0];
                    return this.rebalance();
                }
                array[0] = 0;
                addLeftChild = this;
                if (elemCount > 0) {
                    addLeftChild = this.addLeftChild(e, elemCount);
                }
            }
            else if (compare > 0) {
                final AvlNode<E> right = this.right;
                if (right != null) {
                    this.right = (AvlNode<E>)right.setCount((Comparator<? super Object>)comparator, (Object)e, elemCount, array);
                    if (elemCount == 0 && array[0] != 0) {
                        --this.distinctElements;
                    }
                    else if (elemCount > 0 && array[0] == 0) {
                        ++this.distinctElements;
                    }
                    this.totalCount += elemCount - array[0];
                    return this.rebalance();
                }
                array[0] = 0;
                addLeftChild = this;
                if (elemCount > 0) {
                    return this.addRightChild(e, elemCount);
                }
            }
            else {
                array[0] = this.elemCount;
                if (elemCount == 0) {
                    return this.deleteMe();
                }
                this.totalCount += elemCount - this.elemCount;
                this.elemCount = elemCount;
                return this;
            }
            return addLeftChild;
        }
        
        @Override
        public String toString() {
            return Multisets.immutableEntry(this.getElement(), this.getCount()).toString();
        }
    }
    
    private static final class Reference<T>
    {
        @Nullable
        private T value;
        
        public void checkAndSet(@Nullable final T t, final T value) {
            if (this.value != t) {
                throw new ConcurrentModificationException();
            }
            this.value = value;
        }
        
        @Nullable
        public T get() {
            return this.value;
        }
    }
}
