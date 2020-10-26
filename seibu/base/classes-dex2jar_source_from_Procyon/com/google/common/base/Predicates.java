// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.regex.Pattern;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.Beta;
import java.util.Arrays;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Predicates
{
    private static final Joiner COMMA_JOINER;
    
    static {
        COMMA_JOINER = Joiner.on(',');
    }
    
    private Predicates() {
    }
    
    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }
    
    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }
    
    public static <T> Predicate<T> and(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
        return new AndPredicate<T>((List)asList(Preconditions.checkNotNull(predicate), Preconditions.checkNotNull(predicate2)));
    }
    
    public static <T> Predicate<T> and(final Iterable<? extends Predicate<? super T>> iterable) {
        return new AndPredicate<T>((List)defensiveCopy((Iterable<Object>)iterable));
    }
    
    public static <T> Predicate<T> and(final Predicate<? super T>... array) {
        return new AndPredicate<T>((List)defensiveCopy(array));
    }
    
    private static <T> List<Predicate<? super T>> asList(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }
    
    @Beta
    @GwtIncompatible("Class.isAssignableFrom")
    public static Predicate<Class<?>> assignableFrom(final Class<?> clazz) {
        return new AssignableFromPredicate((Class)clazz);
    }
    
    public static <A, B> Predicate<A> compose(final Predicate<B> predicate, final Function<A, ? extends B> function) {
        return new CompositionPredicate<A, Object>((Predicate)predicate, (Function)function);
    }
    
    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(final Pattern pattern) {
        return new ContainsPatternPredicate(pattern);
    }
    
    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> containsPattern(final String s) {
        return new ContainsPatternFromStringPredicate(s);
    }
    
    static <T> List<T> defensiveCopy(final Iterable<T> iterable) {
        final ArrayList<T> list = new ArrayList<T>();
        final Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(Preconditions.checkNotNull(iterator.next()));
        }
        return list;
    }
    
    private static <T> List<T> defensiveCopy(final T... a) {
        return defensiveCopy(Arrays.asList(a));
    }
    
    public static <T> Predicate<T> equalTo(@Nullable final T t) {
        if (t == null) {
            return isNull();
        }
        return new IsEqualToPredicate<T>((Object)t);
    }
    
    public static <T> Predicate<T> in(final Collection<? extends T> collection) {
        return new InPredicate<T>((Collection)collection);
    }
    
    @GwtIncompatible("Class.isInstance")
    public static Predicate<Object> instanceOf(final Class<?> clazz) {
        return new InstanceOfPredicate((Class)clazz);
    }
    
    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }
    
    public static <T> Predicate<T> not(final Predicate<T> predicate) {
        return new NotPredicate<T>(predicate);
    }
    
    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }
    
    public static <T> Predicate<T> or(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
        return new OrPredicate<T>((List)asList(Preconditions.checkNotNull(predicate), Preconditions.checkNotNull(predicate2)));
    }
    
    public static <T> Predicate<T> or(final Iterable<? extends Predicate<? super T>> iterable) {
        return new OrPredicate<T>((List)defensiveCopy((Iterable<Object>)iterable));
    }
    
    public static <T> Predicate<T> or(final Predicate<? super T>... array) {
        return new OrPredicate<T>((List)defensiveCopy(array));
    }
    
    private static class AndPredicate<T> implements Predicate<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final List<? extends Predicate<? super T>> components;
        
        private AndPredicate(final List<? extends Predicate<? super T>> components) {
            this.components = components;
        }
        
        @Override
        public boolean apply(@Nullable final T t) {
            for (int i = 0; i < this.components.size(); ++i) {
                if (!((Predicate)this.components.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof AndPredicate && this.components.equals(((AndPredicate)o).components);
        }
        
        @Override
        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(Predicates.COMMA_JOINER.join(this.components)));
            return new StringBuilder(value.length() + 16).append("Predicates.and(").append(value).append(")").toString();
        }
    }
    
    @GwtIncompatible("Class.isAssignableFrom")
    private static class AssignableFromPredicate implements Predicate<Class<?>>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final Class<?> clazz;
        
        private AssignableFromPredicate(final Class<?> clazz) {
            this.clazz = Preconditions.checkNotNull(clazz);
        }
        
        @Override
        public boolean apply(final Class<?> clazz) {
            return this.clazz.isAssignableFrom(clazz);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b = false;
            if (o instanceof AssignableFromPredicate) {
                final AssignableFromPredicate assignableFromPredicate = (AssignableFromPredicate)o;
                b = b;
                if (this.clazz == assignableFromPredicate.clazz) {
                    b = true;
                }
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            return this.clazz.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.clazz.getName()));
            return new StringBuilder(value.length() + 27).append("Predicates.assignableFrom(").append(value).append(")").toString();
        }
    }
    
    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Function<A, ? extends B> f;
        final Predicate<B> p;
        
        private CompositionPredicate(final Predicate<B> predicate, final Function<A, ? extends B> function) {
            this.p = Preconditions.checkNotNull(predicate);
            this.f = Preconditions.checkNotNull(function);
        }
        
        @Override
        public boolean apply(@Nullable final A a) {
            return this.p.apply((B)this.f.apply(a));
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof CompositionPredicate) {
                final CompositionPredicate compositionPredicate = (CompositionPredicate)o;
                b2 = b;
                if (this.f.equals(compositionPredicate.f)) {
                    b2 = b;
                    if (this.p.equals(compositionPredicate.p)) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            return this.f.hashCode() ^ this.p.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.p.toString()));
            final String value2 = String.valueOf(String.valueOf(this.f.toString()));
            return new StringBuilder(value.length() + 2 + value2.length()).append(value).append("(").append(value2).append(")").toString();
        }
    }
    
    @GwtIncompatible("Only used by other GWT-incompatible code.")
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate
    {
        private static final long serialVersionUID = 0L;
        
        ContainsPatternFromStringPredicate(final String regex) {
            super(Pattern.compile(regex));
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.pattern.pattern()));
            return new StringBuilder(value.length() + 28).append("Predicates.containsPattern(").append(value).append(")").toString();
        }
    }
    
    @GwtIncompatible("Only used by other GWT-incompatible code.")
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Pattern pattern;
        
        ContainsPatternPredicate(final Pattern pattern) {
            this.pattern = Preconditions.checkNotNull(pattern);
        }
        
        @Override
        public boolean apply(final CharSequence input) {
            return this.pattern.matcher(input).find();
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof ContainsPatternPredicate) {
                final ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate)o;
                b2 = b;
                if (Objects.equal(this.pattern.pattern(), containsPatternPredicate.pattern.pattern())) {
                    b2 = b;
                    if (Objects.equal(this.pattern.flags(), containsPatternPredicate.pattern.flags())) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            return Objects.hashCode(this.pattern.pattern(), this.pattern.flags());
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(Objects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString()));
            return new StringBuilder(value.length() + 21).append("Predicates.contains(").append(value).append(")").toString();
        }
    }
    
    private static class InPredicate<T> implements Predicate<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final Collection<?> target;
        
        private InPredicate(final Collection<?> collection) {
            this.target = Preconditions.checkNotNull(collection);
        }
        
        @Override
        public boolean apply(@Nullable final T t) {
            try {
                return this.target.contains(t);
            }
            catch (NullPointerException ex) {
                return false;
            }
            catch (ClassCastException ex2) {
                return false;
            }
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof InPredicate && this.target.equals(((InPredicate)o).target);
        }
        
        @Override
        public int hashCode() {
            return this.target.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.target));
            return new StringBuilder(value.length() + 15).append("Predicates.in(").append(value).append(")").toString();
        }
    }
    
    @GwtIncompatible("Class.isInstance")
    private static class InstanceOfPredicate implements Predicate<Object>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final Class<?> clazz;
        
        private InstanceOfPredicate(final Class<?> clazz) {
            this.clazz = Preconditions.checkNotNull(clazz);
        }
        
        @Override
        public boolean apply(@Nullable final Object o) {
            return this.clazz.isInstance(o);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b = false;
            if (o instanceof InstanceOfPredicate) {
                final InstanceOfPredicate instanceOfPredicate = (InstanceOfPredicate)o;
                b = b;
                if (this.clazz == instanceOfPredicate.clazz) {
                    b = true;
                }
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            return this.clazz.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.clazz.getName()));
            return new StringBuilder(value.length() + 23).append("Predicates.instanceOf(").append(value).append(")").toString();
        }
    }
    
    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final T target;
        
        private IsEqualToPredicate(final T target) {
            this.target = target;
        }
        
        @Override
        public boolean apply(final T obj) {
            return this.target.equals(obj);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof IsEqualToPredicate && this.target.equals(((IsEqualToPredicate)o).target);
        }
        
        @Override
        public int hashCode() {
            return this.target.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.target));
            return new StringBuilder(value.length() + 20).append("Predicates.equalTo(").append(value).append(")").toString();
        }
    }
    
    private static class NotPredicate<T> implements Predicate<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Predicate<T> predicate;
        
        NotPredicate(final Predicate<T> predicate) {
            this.predicate = Preconditions.checkNotNull(predicate);
        }
        
        @Override
        public boolean apply(@Nullable final T t) {
            return !this.predicate.apply(t);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof NotPredicate && this.predicate.equals(((NotPredicate)o).predicate);
        }
        
        @Override
        public int hashCode() {
            return ~this.predicate.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.predicate.toString()));
            return new StringBuilder(value.length() + 16).append("Predicates.not(").append(value).append(")").toString();
        }
    }
    
    enum ObjectPredicate implements Predicate<Object>
    {
        ALWAYS_FALSE {
            @Override
            public boolean apply(@Nullable final Object o) {
                return false;
            }
            
            @Override
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }, 
        ALWAYS_TRUE {
            @Override
            public boolean apply(@Nullable final Object o) {
                return true;
            }
            
            @Override
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }, 
        IS_NULL {
            @Override
            public boolean apply(@Nullable final Object o) {
                return o == null;
            }
            
            @Override
            public String toString() {
                return "Predicates.isNull()";
            }
        }, 
        NOT_NULL {
            @Override
            public boolean apply(@Nullable final Object o) {
                return o != null;
            }
            
            @Override
            public String toString() {
                return "Predicates.notNull()";
            }
        };
        
         <T> Predicate<T> withNarrowedType() {
            return (Predicate<T>)this;
        }
    }
    
    private static class OrPredicate<T> implements Predicate<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final List<? extends Predicate<? super T>> components;
        
        private OrPredicate(final List<? extends Predicate<? super T>> components) {
            this.components = components;
        }
        
        @Override
        public boolean apply(@Nullable final T t) {
            for (int i = 0; i < this.components.size(); ++i) {
                if (((Predicate)this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof OrPredicate && this.components.equals(((OrPredicate)o).components);
        }
        
        @Override
        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(Predicates.COMMA_JOINER.join(this.components)));
            return new StringBuilder(value.length() + 15).append("Predicates.or(").append(value).append(")").toString();
        }
    }
}
