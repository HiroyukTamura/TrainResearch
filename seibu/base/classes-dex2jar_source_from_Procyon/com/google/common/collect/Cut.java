// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.NoSuchElementException;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable
{
    private static final long serialVersionUID = 0L;
    final C endpoint;
    
    Cut(@Nullable final C endpoint) {
        this.endpoint = endpoint;
    }
    
    static <C extends Comparable> Cut<C> aboveAll() {
        return (Cut<C>)AboveAll.INSTANCE;
    }
    
    static <C extends Comparable> Cut<C> aboveValue(final C c) {
        return new AboveValue<C>(c);
    }
    
    static <C extends Comparable> Cut<C> belowAll() {
        return (Cut<C>)BelowAll.INSTANCE;
    }
    
    static <C extends Comparable> Cut<C> belowValue(final C c) {
        return new BelowValue<C>(c);
    }
    
    Cut<C> canonical(final DiscreteDomain<C> discreteDomain) {
        return this;
    }
    
    @Override
    public int compareTo(final Cut<C> cut) {
        int compareOrThrow;
        if (cut == belowAll()) {
            compareOrThrow = 1;
        }
        else {
            if (cut == aboveAll()) {
                return -1;
            }
            if ((compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint)) == 0) {
                return Booleans.compare(this instanceof AboveValue, cut instanceof AboveValue);
            }
        }
        return compareOrThrow;
    }
    
    abstract void describeAsLowerBound(final StringBuilder p0);
    
    abstract void describeAsUpperBound(final StringBuilder p0);
    
    C endpoint() {
        return this.endpoint;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = false;
        if (!(o instanceof Cut)) {
            return b;
        }
        final Cut cut = (Cut)o;
        try {
            final int compareTo = this.compareTo(cut);
            b = b;
            if (compareTo == 0) {
                b = true;
            }
            return b;
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    abstract C greatestValueBelow(final DiscreteDomain<C> p0);
    
    abstract boolean isLessThan(final C p0);
    
    abstract C leastValueAbove(final DiscreteDomain<C> p0);
    
    abstract BoundType typeAsLowerBound();
    
    abstract BoundType typeAsUpperBound();
    
    abstract Cut<C> withLowerBoundType(final BoundType p0, final DiscreteDomain<C> p1);
    
    abstract Cut<C> withUpperBoundType(final BoundType p0, final DiscreteDomain<C> p1);
    
    private static final class AboveAll extends Cut<Comparable<?>>
    {
        private static final AboveAll INSTANCE;
        private static final long serialVersionUID = 0L;
        
        static {
            INSTANCE = new AboveAll();
        }
        
        private AboveAll() {
            super(null);
        }
        
        private Object readResolve() {
            return AboveAll.INSTANCE;
        }
        
        @Override
        public int compareTo(final Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return 1;
        }
        
        @Override
        void describeAsLowerBound(final StringBuilder sb) {
            throw new AssertionError();
        }
        
        @Override
        void describeAsUpperBound(final StringBuilder sb) {
            sb.append("+\u221e)");
        }
        
        @Override
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }
        
        @Override
        Comparable<?> greatestValueBelow(final DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }
        
        @Override
        boolean isLessThan(final Comparable<?> comparable) {
            return false;
        }
        
        @Override
        Comparable<?> leastValueAbove(final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }
        
        @Override
        public String toString() {
            return "+\u221e";
        }
        
        @Override
        BoundType typeAsLowerBound() {
            throw new AssertionError((Object)"this statement should be unreachable");
        }
        
        @Override
        BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }
        
        @Override
        Cut<Comparable<?>> withLowerBoundType(final BoundType boundType, final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError((Object)"this statement should be unreachable");
        }
        
        @Override
        Cut<Comparable<?>> withUpperBoundType(final BoundType boundType, final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }
    }
    
    private static final class AboveValue<C extends Comparable> extends Cut<C>
    {
        private static final long serialVersionUID = 0L;
        
        AboveValue(final C c) {
            super(Preconditions.checkNotNull((C)c));
        }
        
        @Override
        Cut<C> canonical(final DiscreteDomain<C> discreteDomain) {
            final Comparable leastValueAbove = this.leastValueAbove(discreteDomain);
            if (leastValueAbove != null) {
                return Cut.belowValue((C)leastValueAbove);
            }
            return Cut.aboveAll();
        }
        
        @Override
        void describeAsLowerBound(final StringBuilder sb) {
            sb.append('(').append(this.endpoint);
        }
        
        @Override
        void describeAsUpperBound(final StringBuilder sb) {
            sb.append(this.endpoint).append(']');
        }
        
        @Override
        C greatestValueBelow(final DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }
        
        @Override
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }
        
        @Override
        boolean isLessThan(final C c) {
            return Range.compareOrThrow(this.endpoint, c) < 0;
        }
        
        @Override
        C leastValueAbove(final DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.endpoint);
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.endpoint));
            return new StringBuilder(value.length() + 2).append("/").append(value).append("\\").toString();
        }
        
        @Override
        BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }
        
        @Override
        BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }
        
        @Override
        Cut<C> withLowerBoundType(final BoundType boundType, final DiscreteDomain<C> discreteDomain) {
            AboveValue aboveValue = this;
            switch (boundType) {
                default: {
                    throw new AssertionError();
                }
                case CLOSED: {
                    final Comparable next = discreteDomain.next(this.endpoint);
                    Comparable<Cut<C>> comparable;
                    if (next == null) {
                        comparable = (Comparable<Cut<C>>)Cut.belowAll();
                    }
                    else {
                        comparable = (Comparable<Cut<C>>)Cut.belowValue((C)next);
                    }
                    aboveValue = (AboveValue)comparable;
                }
                case OPEN: {
                    return aboveValue;
                }
            }
        }
        
        @Override
        Cut<C> withUpperBoundType(final BoundType boundType, final DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                default: {
                    throw new AssertionError();
                }
                case OPEN: {
                    final Comparable next = discreteDomain.next(this.endpoint);
                    if (next == null) {
                        return Cut.aboveAll();
                    }
                    return Cut.belowValue((C)next);
                }
                case CLOSED: {
                    return this;
                }
            }
        }
    }
    
    private static final class BelowAll extends Cut<Comparable<?>>
    {
        private static final BelowAll INSTANCE;
        private static final long serialVersionUID = 0L;
        
        static {
            INSTANCE = new BelowAll();
        }
        
        private BelowAll() {
            super(null);
        }
        
        private Object readResolve() {
            return BelowAll.INSTANCE;
        }
        
        @Override
        Cut<Comparable<?>> canonical(final DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.belowValue(discreteDomain.minValue());
            }
            catch (NoSuchElementException ex) {
                return this;
            }
        }
        
        @Override
        public int compareTo(final Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return -1;
        }
        
        @Override
        void describeAsLowerBound(final StringBuilder sb) {
            sb.append("(-\u221e");
        }
        
        @Override
        void describeAsUpperBound(final StringBuilder sb) {
            throw new AssertionError();
        }
        
        @Override
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }
        
        @Override
        Comparable<?> greatestValueBelow(final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }
        
        @Override
        boolean isLessThan(final Comparable<?> comparable) {
            return true;
        }
        
        @Override
        Comparable<?> leastValueAbove(final DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }
        
        @Override
        public String toString() {
            return "-\u221e";
        }
        
        @Override
        BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }
        
        @Override
        BoundType typeAsUpperBound() {
            throw new AssertionError((Object)"this statement should be unreachable");
        }
        
        @Override
        Cut<Comparable<?>> withLowerBoundType(final BoundType boundType, final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }
        
        @Override
        Cut<Comparable<?>> withUpperBoundType(final BoundType boundType, final DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError((Object)"this statement should be unreachable");
        }
    }
    
    private static final class BelowValue<C extends Comparable> extends Cut<C>
    {
        private static final long serialVersionUID = 0L;
        
        BelowValue(final C c) {
            super(Preconditions.checkNotNull((C)c));
        }
        
        @Override
        void describeAsLowerBound(final StringBuilder sb) {
            sb.append('[').append(this.endpoint);
        }
        
        @Override
        void describeAsUpperBound(final StringBuilder sb) {
            sb.append(this.endpoint).append(')');
        }
        
        @Override
        C greatestValueBelow(final DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.endpoint);
        }
        
        @Override
        public int hashCode() {
            return this.endpoint.hashCode();
        }
        
        @Override
        boolean isLessThan(final C c) {
            return Range.compareOrThrow(this.endpoint, c) <= 0;
        }
        
        @Override
        C leastValueAbove(final DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.endpoint));
            return new StringBuilder(value.length() + 2).append("\\").append(value).append("/").toString();
        }
        
        @Override
        BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }
        
        @Override
        BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }
        
        @Override
        Cut<C> withLowerBoundType(final BoundType boundType, final DiscreteDomain<C> discreteDomain) {
            BelowValue belowValue = this;
            switch (boundType) {
                default: {
                    throw new AssertionError();
                }
                case OPEN: {
                    final Comparable previous = discreteDomain.previous(this.endpoint);
                    Cut<Comparable> belowAll;
                    if (previous == null) {
                        belowAll = Cut.belowAll();
                    }
                    else {
                        belowAll = new AboveValue<Comparable>(previous);
                    }
                    belowValue = (BelowValue)belowAll;
                }
                case CLOSED: {
                    return belowValue;
                }
            }
        }
        
        @Override
        Cut<C> withUpperBoundType(final BoundType boundType, final DiscreteDomain<C> discreteDomain) {
            switch (boundType) {
                default: {
                    throw new AssertionError();
                }
                case CLOSED: {
                    final Comparable previous = discreteDomain.previous(this.endpoint);
                    if (previous == null) {
                        return Cut.aboveAll();
                    }
                    return new AboveValue<C>((C)previous);
                }
                case OPEN: {
                    return this;
                }
            }
        }
    }
}
