// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.MoreObjects;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collection;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import java.util.Map;
import com.google.common.base.Preconditions;
import java.util.TreeMap;
import com.google.common.annotations.VisibleForTesting;
import java.util.NavigableMap;
import java.util.Set;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtIncompatible("uses NavigableMap")
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C>
{
    private transient Set<Range<C>> asRanges;
    private transient RangeSet<C> complement;
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
    
    private TreeRangeSet(final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound) {
        this.rangesByLowerBound = rangesByLowerBound;
    }
    
    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<C>(new TreeMap<Cut<C>, Range<C>>());
    }
    
    public static <C extends Comparable<?>> TreeRangeSet<C> create(final RangeSet<C> set) {
        final TreeRangeSet<C> create = (TreeRangeSet<C>)create();
        create.addAll(set);
        return create;
    }
    
    @Nullable
    private Range<C> rangeEnclosing(final Range<C> range) {
        Preconditions.checkNotNull(range);
        final Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry != null && floorEntry.getValue().encloses(range)) {
            return floorEntry.getValue();
        }
        return null;
    }
    
    private void replaceRangeWithSameLowerBound(final Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
            return;
        }
        this.rangesByLowerBound.put(range.lowerBound, range);
    }
    
    @Override
    public void add(final Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        final Cut<C> lowerBound = (Cut<C>)range.lowerBound;
        final Cut<C> upperBound = (Cut<C>)range.upperBound;
        final Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry((Cut<C>)lowerBound);
        Cut<C> lowerBound2 = (Cut<C>)lowerBound;
        Object upperBound2 = upperBound;
        if (lowerEntry != null) {
            final Range<C> range2 = lowerEntry.getValue();
            lowerBound2 = (Cut<C>)lowerBound;
            upperBound2 = upperBound;
            if (range2.upperBound.compareTo((Cut<C>)lowerBound) >= 0) {
                upperBound2 = upperBound;
                if (range2.upperBound.compareTo((Cut<C>)upperBound) >= 0) {
                    upperBound2 = range2.upperBound;
                }
                lowerBound2 = range2.lowerBound;
            }
        }
        final Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry((Cut<C>)upperBound2);
        Cut<C> upperBound3 = (Cut<C>)upperBound2;
        if (floorEntry != null) {
            final Range<C> range3 = floorEntry.getValue();
            upperBound3 = (Cut<C>)upperBound2;
            if (range3.upperBound.compareTo((Cut<C>)upperBound2) >= 0) {
                upperBound3 = range3.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(lowerBound2, upperBound3).clear();
        this.replaceRangeWithSameLowerBound(Range.create(lowerBound2, upperBound3));
    }
    
    @Override
    public Set<Range<C>> asRanges() {
        Set<Range<C>> asRanges;
        if ((asRanges = this.asRanges) == null) {
            asRanges = new AsRanges();
            this.asRanges = asRanges;
        }
        return asRanges;
    }
    
    @Override
    public RangeSet<C> complement() {
        RangeSet<C> complement;
        if ((complement = this.complement) == null) {
            complement = new Complement();
            this.complement = complement;
        }
        return complement;
    }
    
    @Override
    public boolean encloses(final Range<C> range) {
        Preconditions.checkNotNull(range);
        final Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }
    
    @Nullable
    @Override
    public Range<C> rangeContaining(final C c) {
        Preconditions.checkNotNull(c);
        final Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c));
        if (floorEntry != null && floorEntry.getValue().contains(c)) {
            return floorEntry.getValue();
        }
        return null;
    }
    
    @Override
    public void remove(final Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        final Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            final Range<C> range2 = lowerEntry.getValue();
            if (range2.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && range2.upperBound.compareTo(range.upperBound) >= 0) {
                    this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, range2.upperBound));
                }
                this.replaceRangeWithSameLowerBound(Range.create(range2.lowerBound, range.lowerBound));
            }
        }
        final Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            final Range<C> range3 = floorEntry.getValue();
            if (range.hasUpperBound() && range3.upperBound.compareTo(range.upperBound) >= 0) {
                this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, range3.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }
    
    @Override
    public Range<C> span() {
        final Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        final Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
    }
    
    @Override
    public RangeSet<C> subRangeSet(final Range<C> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeSet(range);
    }
    
    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>>
    {
        @Override
        protected Collection<Range<C>> delegate() {
            return TreeRangeSet.this.rangesByLowerBound.values();
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return Sets.equalsImpl(this, o);
        }
        
        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }
    
    private final class Complement extends TreeRangeSet<C>
    {
        Complement() {
            super(new ComplementRangesByLowerBound(TreeRangeSet.this.rangesByLowerBound), null);
        }
        
        @Override
        public void add(final Range<C> range) {
            TreeRangeSet.this.remove(range);
        }
        
        @Override
        public RangeSet<C> complement() {
            return (RangeSet<C>)TreeRangeSet.this;
        }
        
        @Override
        public boolean contains(final C c) {
            return !TreeRangeSet.this.contains(c);
        }
        
        @Override
        public void remove(final Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }
    
    private static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>>
    {
        private final Range<Cut<C>> complementLowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;
        
        ComplementRangesByLowerBound(final NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }
        
        private ComplementRangesByLowerBound(final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound, final Range<Cut<C>> complementLowerBoundWindow) {
            this.positiveRangesByLowerBound = positiveRangesByLowerBound;
            this.positiveRangesByUpperBound = (NavigableMap<Cut<C>, Range<C>>)new RangesByUpperBound((NavigableMap<Cut<Comparable>, Range<Comparable>>)positiveRangesByLowerBound);
            this.complementLowerBoundWindow = complementLowerBoundWindow;
        }
        
        private NavigableMap<Cut<C>, Range<C>> subMap(final Range<Cut<C>> range) {
            if (!this.complementLowerBoundWindow.isConnected(range)) {
                return (NavigableMap<Cut<C>, Range<C>>)ImmutableSortedMap.of();
            }
            return new ComplementRangesByLowerBound<Object>((NavigableMap<Cut<?>, Range<?>>)this.positiveRangesByLowerBound, (Range<Cut<?>>)range.intersection(this.complementLowerBoundWindow));
        }
        
        @Override
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return this.get(o) != null;
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            Cut<C> aboveAll;
            if (this.complementLowerBoundWindow.hasUpperBound()) {
                aboveAll = this.complementLowerBoundWindow.upperEndpoint();
            }
            else {
                aboveAll = Cut.aboveAll();
            }
            final PeekingIterator<Object> peekingIterator = Iterators.peekingIterator((Iterator<?>)this.positiveRangesByUpperBound.headMap(aboveAll, this.complementLowerBoundWindow.hasUpperBound() && this.complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            Object lowerBound;
            if (peekingIterator.hasNext()) {
                if (peekingIterator.peek().upperBound == Cut.aboveAll()) {
                    lowerBound = peekingIterator.next().lowerBound;
                }
                else {
                    lowerBound = this.positiveRangesByLowerBound.higherKey((Cut<C>)peekingIterator.peek().upperBound);
                }
            }
            else {
                if (!this.complementLowerBoundWindow.contains(Cut.belowAll()) || this.positiveRangesByLowerBound.containsKey(Cut.belowAll())) {
                    return (Iterator<Entry<Cut<C>, Range<C>>>)Iterators.emptyIterator();
                }
                lowerBound = this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                Cut<C> nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
                final /* synthetic */ Cut val$firstComplementRangeUpperBound = MoreObjects.firstNonNull(lowerBound, Cut.aboveAll());
                
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    if (this.nextComplementRangeUpperBound == Cut.belowAll()) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    if (peekingIterator.hasNext()) {
                        final Range range = peekingIterator.next();
                        final Range<C> create = Range.create((Cut<C>)range.upperBound, this.nextComplementRangeUpperBound);
                        this.nextComplementRangeUpperBound = (Cut<C>)range.lowerBound;
                        if (ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan((C)create.lowerBound)) {
                            return Maps.immutableEntry(create.lowerBound, create);
                        }
                    }
                    else if (ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan((C)Cut.belowAll())) {
                        final Range<C> create2 = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
                        this.nextComplementRangeUpperBound = Cut.belowAll();
                        return Maps.immutableEntry(Cut.belowAll(), create2);
                    }
                    return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                }
            };
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> entryIterator() {
            Collection<? extends T> collection;
            if (this.complementLowerBoundWindow.hasLowerBound()) {
                collection = this.positiveRangesByUpperBound.tailMap(this.complementLowerBoundWindow.lowerEndpoint(), this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values();
            }
            else {
                collection = this.positiveRangesByUpperBound.values();
            }
            final PeekingIterator<Object> peekingIterator = Iterators.peekingIterator((Iterator<?>)collection.iterator());
            Cut<Comparable> cut;
            if (this.complementLowerBoundWindow.contains(Cut.belowAll()) && (!peekingIterator.hasNext() || peekingIterator.peek().lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            }
            else {
                if (!peekingIterator.hasNext()) {
                    return (Iterator<Entry<Cut<C>, Range<C>>>)Iterators.emptyIterator();
                }
                cut = (Cut<Comparable>)peekingIterator.next().upperBound;
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                Cut<C> nextComplementRangeLowerBound = cut;
                
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    if (ComplementRangesByLowerBound.this.complementLowerBoundWindow.upperBound.isLessThan((C)this.nextComplementRangeLowerBound) || this.nextComplementRangeLowerBound == Cut.aboveAll()) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    Range<C> range2;
                    if (peekingIterator.hasNext()) {
                        final Range range = peekingIterator.next();
                        range2 = Range.create(this.nextComplementRangeLowerBound, (Cut<C>)range.lowerBound);
                        this.nextComplementRangeLowerBound = (Cut<C>)range.upperBound;
                    }
                    else {
                        range2 = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
                        this.nextComplementRangeLowerBound = Cut.aboveAll();
                    }
                    return Maps.immutableEntry(range2.lowerBound, range2);
                }
            };
        }
        
        @Nullable
        @Override
        public Range<C> get(final Object o) {
            if (o instanceof Cut) {
                try {
                    final Cut cut = (Cut)o;
                    final Map.Entry<Cut<C>, Range<C>> firstEntry = this.tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                }
                catch (ClassCastException ex) {
                    return null;
                }
            }
            return null;
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> headMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.upTo(cut, BoundType.forBoolean(b)));
        }
        
        @Override
        public int size() {
            return Iterators.size(this.entryIterator());
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> subMap(final Cut<C> cut, final boolean b, final Cut<C> cut2, final boolean b2) {
            return this.subMap(Range.range(cut, BoundType.forBoolean(b), cut2, BoundType.forBoolean(b2)));
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> tailMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.downTo(cut, BoundType.forBoolean(b)));
        }
    }
    
    @VisibleForTesting
    static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>>
    {
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final Range<Cut<C>> upperBoundWindow;
        
        RangesByUpperBound(final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound) {
            this.rangesByLowerBound = rangesByLowerBound;
            this.upperBoundWindow = Range.all();
        }
        
        private RangesByUpperBound(final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound, final Range<Cut<C>> upperBoundWindow) {
            this.rangesByLowerBound = rangesByLowerBound;
            this.upperBoundWindow = upperBoundWindow;
        }
        
        private NavigableMap<Cut<C>, Range<C>> subMap(final Range<Cut<C>> range) {
            if (range.isConnected(this.upperBoundWindow)) {
                return new RangesByUpperBound<Object>((NavigableMap<Cut<?>, Range<?>>)this.rangesByLowerBound, (Range<Cut<?>>)range.intersection(this.upperBoundWindow));
            }
            return (NavigableMap<Cut<C>, Range<C>>)ImmutableSortedMap.of();
        }
        
        @Override
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.get(o) != null;
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            Collection<? extends T> collection;
            if (this.upperBoundWindow.hasUpperBound()) {
                collection = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
            }
            else {
                collection = this.rangesByLowerBound.descendingMap().values();
            }
            final PeekingIterator<Object> peekingIterator = Iterators.peekingIterator((Iterator<?>)collection.iterator());
            if (peekingIterator.hasNext() && this.upperBoundWindow.upperBound.isLessThan((Cut<C>)peekingIterator.peek().upperBound)) {
                peekingIterator.next();
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    if (!peekingIterator.hasNext()) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    final Range<C> range = peekingIterator.next();
                    if (RangesByUpperBound.this.upperBoundWindow.lowerBound.isLessThan((C)range.upperBound)) {
                        return Maps.immutableEntry(range.upperBound, range);
                    }
                    return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                }
            };
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> entryIterator() {
            Iterator<Object> iterator;
            if (!this.upperBoundWindow.hasLowerBound()) {
                iterator = this.rangesByLowerBound.values().iterator();
            }
            else {
                final Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
                if (lowerEntry == null) {
                    iterator = this.rangesByLowerBound.values().iterator();
                }
                else if (this.upperBoundWindow.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                    iterator = this.rangesByLowerBound.tailMap(lowerEntry.getKey(), true).values().iterator();
                }
                else {
                    iterator = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
                }
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    if (!iterator.hasNext()) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    final Range<C> range = iterator.next();
                    if (RangesByUpperBound.this.upperBoundWindow.upperBound.isLessThan((C)range.upperBound)) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    return Maps.immutableEntry(range.upperBound, range);
                }
            };
        }
        
        @Override
        public Range<C> get(@Nullable final Object o) {
            if (o instanceof Cut) {
                try {
                    final Cut cut = (Cut)o;
                    if (!this.upperBoundWindow.contains(cut)) {
                        return null;
                    }
                    final Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
                    if (lowerEntry != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                }
                catch (ClassCastException ex) {
                    return null;
                }
            }
            return null;
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> headMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.upTo(cut, BoundType.forBoolean(b)));
        }
        
        @Override
        public boolean isEmpty() {
            if (this.upperBoundWindow.equals(Range.all())) {
                return this.rangesByLowerBound.isEmpty();
            }
            return !this.entryIterator().hasNext();
        }
        
        @Override
        public int size() {
            if (this.upperBoundWindow.equals(Range.all())) {
                return this.rangesByLowerBound.size();
            }
            return Iterators.size(this.entryIterator());
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> subMap(final Cut<C> cut, final boolean b, final Cut<C> cut2, final boolean b2) {
            return this.subMap(Range.range(cut, BoundType.forBoolean(b), cut2, BoundType.forBoolean(b2)));
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> tailMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.downTo(cut, BoundType.forBoolean(b)));
        }
    }
    
    private final class SubRangeSet extends TreeRangeSet<C>
    {
        private final Range<C> restriction;
        
        SubRangeSet(final Range<C> restriction) {
            super(new SubRangeSetRangesByLowerBound((Range)Range.all(), (Range)restriction, (NavigableMap)TreeRangeSet.this.rangesByLowerBound), null);
            this.restriction = restriction;
        }
        
        @Override
        public void add(final Range<C> range) {
            Preconditions.checkArgument(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }
        
        @Override
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }
        
        @Override
        public boolean contains(final C c) {
            return this.restriction.contains(c) && TreeRangeSet.this.contains(c);
        }
        
        @Override
        public boolean encloses(final Range<C> range) {
            boolean b2;
            final boolean b = b2 = false;
            if (!this.restriction.isEmpty()) {
                b2 = b;
                if (this.restriction.encloses(range)) {
                    final Range access$600 = TreeRangeSet.this.rangeEnclosing(range);
                    b2 = b;
                    if (access$600 != null) {
                        b2 = b;
                        if (!access$600.intersection(this.restriction).isEmpty()) {
                            b2 = true;
                        }
                    }
                }
            }
            return b2;
        }
        
        @Nullable
        @Override
        public Range<C> rangeContaining(final C c) {
            if (this.restriction.contains(c)) {
                final Range<C> rangeContaining = TreeRangeSet.this.rangeContaining(c);
                if (rangeContaining != null) {
                    return rangeContaining.intersection(this.restriction);
                }
            }
            return null;
        }
        
        @Override
        public void remove(final Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }
        
        @Override
        public RangeSet<C> subRangeSet(final Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this.restriction.intersection(range));
            }
            return (RangeSet<C>)ImmutableRangeSet.of();
        }
    }
    
    private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>>
    {
        private final Range<Cut<C>> lowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
        private final Range<C> restriction;
        
        private SubRangeSetRangesByLowerBound(final Range<Cut<C>> range, final Range<C> range2, final NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.lowerBoundWindow = Preconditions.checkNotNull(range);
            this.restriction = Preconditions.checkNotNull(range2);
            this.rangesByLowerBound = Preconditions.checkNotNull(navigableMap);
            this.rangesByUpperBound = (NavigableMap<Cut<C>, Range<C>>)new RangesByUpperBound((NavigableMap<Cut<Comparable>, Range<Comparable>>)navigableMap);
        }
        
        private NavigableMap<Cut<C>, Range<C>> subMap(final Range<Cut<C>> range) {
            if (!range.isConnected(this.lowerBoundWindow)) {
                return (NavigableMap<Cut<C>, Range<C>>)ImmutableSortedMap.of();
            }
            return new SubRangeSetRangesByLowerBound<Object>((Range<Cut<?>>)this.lowerBoundWindow.intersection(range), this.restriction, (NavigableMap<Cut<?>, Range<?>>)this.rangesByLowerBound);
        }
        
        @Override
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.get(o) != null;
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.restriction.isEmpty()) {
                return (Iterator<Entry<Cut<C>, Range<C>>>)Iterators.emptyIterator();
            }
            final Cut<Cut<C>> cut = Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                final /* synthetic */ Iterator val$completeRangeItr = SubRangeSetRangesByLowerBound.this.rangesByLowerBound.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator();
                
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.val$completeRangeItr:Ljava/util/Iterator;
                    //     4: invokeinterface java/util/Iterator.hasNext:()Z
                    //     9: ifne            20
                    //    12: aload_0        
                    //    13: invokevirtual   com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.endOfData:()Ljava/lang/Object;
                    //    16: checkcast       Ljava/util/Map$Entry;
                    //    19: areturn        
                    //    20: aload_0        
                    //    21: getfield        com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.val$completeRangeItr:Ljava/util/Iterator;
                    //    24: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                    //    29: checkcast       Lcom/google/common/collect/Range;
                    //    32: astore_1       
                    //    33: aload_0        
                    //    34: getfield        com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.this$0:Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;
                    //    37: invokestatic    com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound.access$300:(Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;)Lcom/google/common/collect/Range;
                    //    40: getfield        com/google/common/collect/Range.lowerBound:Lcom/google/common/collect/Cut;
                    //    43: aload_1        
                    //    44: getfield        com/google/common/collect/Range.upperBound:Lcom/google/common/collect/Cut;
                    //    47: invokevirtual   com/google/common/collect/Cut.compareTo:(Lcom/google/common/collect/Cut;)I
                    //    50: iflt            61
                    //    53: aload_0        
                    //    54: invokevirtual   com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.endOfData:()Ljava/lang/Object;
                    //    57: checkcast       Ljava/util/Map$Entry;
                    //    60: areturn        
                    //    61: aload_1        
                    //    62: aload_0        
                    //    63: getfield        com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.this$0:Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;
                    //    66: invokestatic    com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound.access$300:(Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;)Lcom/google/common/collect/Range;
                    //    69: invokevirtual   com/google/common/collect/Range.intersection:(Lcom/google/common/collect/Range;)Lcom/google/common/collect/Range;
                    //    72: astore_1       
                    //    73: aload_0        
                    //    74: getfield        com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.this$0:Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;
                    //    77: invokestatic    com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound.access$400:(Lcom/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound;)Lcom/google/common/collect/Range;
                    //    80: aload_1        
                    //    81: getfield        com/google/common/collect/Range.lowerBound:Lcom/google/common/collect/Cut;
                    //    84: invokevirtual   com/google/common/collect/Range.contains:(Ljava/lang/Comparable;)Z
                    //    87: ifeq            99
                    //    90: aload_1        
                    //    91: getfield        com/google/common/collect/Range.lowerBound:Lcom/google/common/collect/Cut;
                    //    94: aload_1        
                    //    95: invokestatic    com/google/common/collect/Maps.immutableEntry:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;
                    //    98: areturn        
                    //    99: aload_0        
                    //   100: invokevirtual   com/google/common/collect/TreeRangeSet$SubRangeSetRangesByLowerBound$2.endOfData:()Ljava/lang/Object;
                    //   103: checkcast       Ljava/util/Map$Entry;
                    //   106: areturn        
                    //    Signature:
                    //  ()Ljava/util/Map$Entry<Lcom/google/common/collect/Cut<TC;>;Lcom/google/common/collect/Range<TC;>;>;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.UnsupportedOperationException: The requested operation is not supported.
                    //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
                    //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
                    //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
                    //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                    //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                    //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                    //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameters(TypeSubstitutionVisitor.java:364)
                    //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:279)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2104)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1531)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:759)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1011)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2695)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1656)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
                    //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
                    //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
                    //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                    //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                    //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                    //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                    //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            };
        }
        
        @Override
        Iterator<Entry<Cut<C>, Range<C>>> entryIterator() {
            boolean b = false;
            if (this.restriction.isEmpty()) {
                return (Iterator<Entry<Cut<C>, Range<C>>>)Iterators.emptyIterator();
            }
            if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound)) {
                return (Iterator<Entry<Cut<C>, Range<C>>>)Iterators.emptyIterator();
            }
            Iterator<Object> iterator;
            if (this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound)) {
                iterator = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
            }
            else {
                final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound = this.rangesByLowerBound;
                final Cut<C> endpoint = this.lowerBoundWindow.lowerBound.endpoint();
                if (this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED) {
                    b = true;
                }
                iterator = rangesByLowerBound.tailMap(endpoint, b).values().iterator();
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>() {
                final /* synthetic */ Cut val$upperBoundOnLowerBounds = Ordering.natural().min(SubRangeSetRangesByLowerBound.this.lowerBoundWindow.upperBound, Cut.belowValue(SubRangeSetRangesByLowerBound.this.restriction.upperBound));
                
                @Override
                protected Entry<Cut<C>, Range<C>> computeNext() {
                    if (!iterator.hasNext()) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    final Range<C> range = iterator.next();
                    if (this.val$upperBoundOnLowerBounds.isLessThan(range.lowerBound)) {
                        return (Entry<Cut<C>, Range<C>>)((AbstractIterator<Map.Entry>)this).endOfData();
                    }
                    final Range<C> intersection = range.intersection(SubRangeSetRangesByLowerBound.this.restriction);
                    return Maps.immutableEntry(intersection.lowerBound, intersection);
                }
            };
        }
        
        @Nullable
        @Override
        public Range<C> get(@Nullable final Object o) {
            if (o instanceof Cut) {
                try {
                    final Cut cut = (Cut)o;
                    if (this.lowerBoundWindow.contains(cut) && cut.compareTo(this.restriction.lowerBound) >= 0) {
                        if (cut.compareTo(this.restriction.upperBound) >= 0) {
                            return null;
                        }
                        if (cut.equals(this.restriction.lowerBound)) {
                            final Range<C> range = Maps.valueOrNull((Entry<?, Range<C>>)this.rangesByLowerBound.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo(this.restriction.lowerBound) > 0) {
                                return range.intersection(this.restriction);
                            }
                        }
                        else {
                            final Range<C> range2 = this.rangesByLowerBound.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.restriction);
                            }
                        }
                    }
                }
                catch (ClassCastException ex) {}
            }
            return null;
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> headMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.upTo(cut, BoundType.forBoolean(b)));
        }
        
        @Override
        public int size() {
            return Iterators.size(this.entryIterator());
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> subMap(final Cut<C> cut, final boolean b, final Cut<C> cut2, final boolean b2) {
            return this.subMap(Range.range(cut, BoundType.forBoolean(b), cut2, BoundType.forBoolean(b2)));
        }
        
        @Override
        public NavigableMap<Cut<C>, Range<C>> tailMap(final Cut<C> cut, final boolean b) {
            return this.subMap(Range.downTo(cut, BoundType.forBoolean(b)));
        }
    }
}
