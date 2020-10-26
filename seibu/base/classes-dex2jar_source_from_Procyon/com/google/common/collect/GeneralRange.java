// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable
{
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @Nullable
    private final T lowerEndpoint;
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @Nullable
    private final T upperEndpoint;
    
    private GeneralRange(final Comparator<? super T> comparator, final boolean hasLowerBound, @Nullable final T lowerEndpoint, final BoundType boundType, final boolean hasUpperBound, @Nullable final T upperEndpoint, final BoundType boundType2) {
        boolean b = true;
        this.comparator = Preconditions.checkNotNull(comparator);
        this.hasLowerBound = hasLowerBound;
        this.hasUpperBound = hasUpperBound;
        this.lowerEndpoint = lowerEndpoint;
        this.lowerBoundType = Preconditions.checkNotNull(boundType);
        this.upperEndpoint = upperEndpoint;
        this.upperBoundType = Preconditions.checkNotNull(boundType2);
        if (hasLowerBound) {
            comparator.compare(lowerEndpoint, lowerEndpoint);
        }
        if (hasUpperBound) {
            comparator.compare(upperEndpoint, upperEndpoint);
        }
        if (hasLowerBound && hasUpperBound) {
            final int compare = comparator.compare(lowerEndpoint, upperEndpoint);
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", lowerEndpoint, upperEndpoint);
            if (compare == 0) {
                boolean b2;
                if (boundType != BoundType.OPEN) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                if (boundType2 == BoundType.OPEN) {
                    b = false;
                }
                Preconditions.checkArgument(b2 | b);
            }
        }
    }
    
    static <T> GeneralRange<T> all(final Comparator<? super T> comparator) {
        return new GeneralRange<T>(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }
    
    static <T> GeneralRange<T> downTo(final Comparator<? super T> comparator, @Nullable final T t, final BoundType boundType) {
        return new GeneralRange<T>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }
    
    static <T extends Comparable> GeneralRange<T> from(final Range<T> range) {
        Comparable lowerEndpoint;
        if (range.hasLowerBound()) {
            lowerEndpoint = range.lowerEndpoint();
        }
        else {
            lowerEndpoint = null;
        }
        BoundType boundType;
        if (range.hasLowerBound()) {
            boundType = range.lowerBoundType();
        }
        else {
            boundType = BoundType.OPEN;
        }
        Comparable upperEndpoint;
        if (range.hasUpperBound()) {
            upperEndpoint = range.upperEndpoint();
        }
        else {
            upperEndpoint = null;
        }
        BoundType boundType2;
        if (range.hasUpperBound()) {
            boundType2 = range.upperBoundType();
        }
        else {
            boundType2 = BoundType.OPEN;
        }
        return new GeneralRange<T>((Comparator<? super Object>)Ordering.natural(), range.hasLowerBound(), lowerEndpoint, boundType, range.hasUpperBound(), upperEndpoint, boundType2);
    }
    
    static <T> GeneralRange<T> range(final Comparator<? super T> comparator, @Nullable final T t, final BoundType boundType, @Nullable final T t2, final BoundType boundType2) {
        return new GeneralRange<T>(comparator, true, t, boundType, true, t2, boundType2);
    }
    
    static <T> GeneralRange<T> upTo(final Comparator<? super T> comparator, @Nullable final T t, final BoundType boundType) {
        return new GeneralRange<T>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }
    
    Comparator<? super T> comparator() {
        return this.comparator;
    }
    
    boolean contains(@Nullable final T t) {
        return !this.tooLow(t) && !this.tooHigh(t);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof GeneralRange) {
            final GeneralRange generalRange = (GeneralRange)o;
            b2 = b;
            if (this.comparator.equals(generalRange.comparator)) {
                b2 = b;
                if (this.hasLowerBound == generalRange.hasLowerBound) {
                    b2 = b;
                    if (this.hasUpperBound == generalRange.hasUpperBound) {
                        b2 = b;
                        if (this.getLowerBoundType().equals(generalRange.getLowerBoundType())) {
                            b2 = b;
                            if (this.getUpperBoundType().equals(generalRange.getUpperBoundType())) {
                                b2 = b;
                                if (Objects.equal(this.getLowerEndpoint(), generalRange.getLowerEndpoint())) {
                                    b2 = b;
                                    if (Objects.equal(this.getUpperEndpoint(), generalRange.getUpperEndpoint())) {
                                        b2 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }
    
    T getLowerEndpoint() {
        return this.lowerEndpoint;
    }
    
    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
    
    T getUpperEndpoint() {
        return this.upperEndpoint;
    }
    
    boolean hasLowerBound() {
        return this.hasLowerBound;
    }
    
    boolean hasUpperBound() {
        return this.hasUpperBound;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.comparator, this.getLowerEndpoint(), this.getLowerBoundType(), this.getUpperEndpoint(), this.getUpperBoundType());
    }
    
    GeneralRange<T> intersect(final GeneralRange<T> generalRange) {
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        final boolean hasLowerBound = this.hasLowerBound;
        final T lowerEndpoint = this.getLowerEndpoint();
        final BoundType lowerBoundType = this.getLowerBoundType();
        boolean hasLowerBound2 = false;
        Object o = null;
        BoundType boundType = null;
        Label_0063: {
            if (!this.hasLowerBound()) {
                hasLowerBound2 = generalRange.hasLowerBound;
                o = generalRange.getLowerEndpoint();
                boundType = generalRange.getLowerBoundType();
            }
            else {
                hasLowerBound2 = hasLowerBound;
                o = lowerEndpoint;
                boundType = lowerBoundType;
                if (generalRange.hasLowerBound()) {
                    final int compare = this.comparator.compare(this.getLowerEndpoint(), (Object)generalRange.getLowerEndpoint());
                    if (compare >= 0) {
                        hasLowerBound2 = hasLowerBound;
                        o = lowerEndpoint;
                        boundType = lowerBoundType;
                        if (compare != 0) {
                            break Label_0063;
                        }
                        hasLowerBound2 = hasLowerBound;
                        o = lowerEndpoint;
                        boundType = lowerBoundType;
                        if (generalRange.getLowerBoundType() != BoundType.OPEN) {
                            break Label_0063;
                        }
                    }
                    o = generalRange.getLowerEndpoint();
                    boundType = generalRange.getLowerBoundType();
                    hasLowerBound2 = hasLowerBound;
                }
            }
        }
        final boolean hasUpperBound = this.hasUpperBound;
        final T upperEndpoint = this.getUpperEndpoint();
        final BoundType upperBoundType = this.getUpperBoundType();
        boolean hasUpperBound2 = false;
        Object o2 = null;
        BoundType boundType2 = null;
        Label_0106: {
            if (!this.hasUpperBound()) {
                hasUpperBound2 = generalRange.hasUpperBound;
                o2 = generalRange.getUpperEndpoint();
                boundType2 = generalRange.getUpperBoundType();
            }
            else {
                hasUpperBound2 = hasUpperBound;
                o2 = upperEndpoint;
                boundType2 = upperBoundType;
                if (generalRange.hasUpperBound()) {
                    final int compare2 = this.comparator.compare(this.getUpperEndpoint(), (Object)generalRange.getUpperEndpoint());
                    if (compare2 <= 0) {
                        hasUpperBound2 = hasUpperBound;
                        o2 = upperEndpoint;
                        boundType2 = upperBoundType;
                        if (compare2 != 0) {
                            break Label_0106;
                        }
                        hasUpperBound2 = hasUpperBound;
                        o2 = upperEndpoint;
                        boundType2 = upperBoundType;
                        if (generalRange.getUpperBoundType() != BoundType.OPEN) {
                            break Label_0106;
                        }
                    }
                    o2 = generalRange.getUpperEndpoint();
                    boundType2 = generalRange.getUpperBoundType();
                    hasUpperBound2 = hasUpperBound;
                }
            }
        }
        Object o3 = o;
        BoundType open = boundType;
        BoundType closed = boundType2;
        if (hasLowerBound2) {
            o3 = o;
            open = boundType;
            closed = boundType2;
            if (hasUpperBound2) {
                final int compare3 = this.comparator.compare((Object)o, (Object)o2);
                if (compare3 <= 0) {
                    o3 = o;
                    open = boundType;
                    closed = boundType2;
                    if (compare3 != 0) {
                        return new GeneralRange<T>((Comparator<? super Object>)this.comparator, hasLowerBound2, o3, open, hasUpperBound2, o2, closed);
                    }
                    o3 = o;
                    open = boundType;
                    closed = boundType2;
                    if (boundType != BoundType.OPEN) {
                        return new GeneralRange<T>((Comparator<? super Object>)this.comparator, hasLowerBound2, o3, open, hasUpperBound2, o2, closed);
                    }
                    o3 = o;
                    open = boundType;
                    if ((closed = boundType2) != BoundType.OPEN) {
                        return new GeneralRange<T>((Comparator<? super Object>)this.comparator, hasLowerBound2, o3, open, hasUpperBound2, o2, closed);
                    }
                }
                o3 = o2;
                open = BoundType.OPEN;
                closed = BoundType.CLOSED;
            }
        }
        return new GeneralRange<T>((Comparator<? super Object>)this.comparator, hasLowerBound2, o3, open, hasUpperBound2, o2, closed);
    }
    
    boolean isEmpty() {
        return (this.hasUpperBound() && this.tooLow(this.getUpperEndpoint())) || (this.hasLowerBound() && this.tooHigh(this.getLowerEndpoint()));
    }
    
    GeneralRange<T> reverse() {
        final GeneralRange<T> reverse = this.reverse;
        if (reverse == null) {
            final GeneralRange reverse2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, this.getUpperEndpoint(), this.getUpperBoundType(), this.hasLowerBound, this.getLowerEndpoint(), this.getLowerBoundType());
            reverse2.reverse = this;
            return this.reverse = reverse2;
        }
        return reverse;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append(this.comparator).append(":");
        char c;
        if (this.lowerBoundType == BoundType.CLOSED) {
            c = '[';
        }
        else {
            c = '(';
        }
        final StringBuilder append2 = append.append(c);
        Object lowerEndpoint;
        if (this.hasLowerBound) {
            lowerEndpoint = this.lowerEndpoint;
        }
        else {
            lowerEndpoint = "-\u221e";
        }
        final StringBuilder append3 = append2.append(lowerEndpoint).append(',');
        Object upperEndpoint;
        if (this.hasUpperBound) {
            upperEndpoint = this.upperEndpoint;
        }
        else {
            upperEndpoint = "\u221e";
        }
        final StringBuilder append4 = append3.append(upperEndpoint);
        char c2;
        if (this.upperBoundType == BoundType.CLOSED) {
            c2 = ']';
        }
        else {
            c2 = ')';
        }
        return append4.append(c2).toString();
    }
    
    boolean tooHigh(@Nullable final T t) {
        boolean b = true;
        if (!this.hasUpperBound()) {
            return false;
        }
        final int compare = this.comparator.compare((Object)t, this.getUpperEndpoint());
        boolean b2;
        if (compare > 0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (compare == 0) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (this.getUpperBoundType() != BoundType.OPEN) {
            b = false;
        }
        return b2 | (b3 & b);
    }
    
    boolean tooLow(@Nullable final T t) {
        boolean b = true;
        if (!this.hasLowerBound()) {
            return false;
        }
        final int compare = this.comparator.compare((Object)t, this.getLowerEndpoint());
        boolean b2;
        if (compare < 0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (compare == 0) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (this.getLowerBoundType() != BoundType.OPEN) {
            b = false;
        }
        return b2 | (b3 & b);
    }
}
