// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import java.util.LinkedHashMap;
import java.util.Map;
import com.google.common.annotations.Beta;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckReturnValue;
import com.google.common.annotations.GwtIncompatible;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Splitter
{
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;
    
    private Splitter(final Strategy strategy) {
        this(strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }
    
    private Splitter(final Strategy strategy, final boolean omitEmptyStrings, final CharMatcher trimmer, final int limit) {
        this.strategy = strategy;
        this.omitEmptyStrings = omitEmptyStrings;
        this.trimmer = trimmer;
        this.limit = limit;
    }
    
    public static Splitter fixedLength(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"The length may not be less than 1");
        return new Splitter((Strategy)new Strategy() {
            public SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(final int n) {
                        return n;
                    }
                    
                    public int separatorStart(int n) {
                        n += n;
                        if (n < this.toSplit.length()) {
                            return n;
                        }
                        return -1;
                    }
                };
            }
        });
    }
    
    public static Splitter on(final char c) {
        return on(CharMatcher.is(c));
    }
    
    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter((Strategy)new Strategy() {
            public SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    @Override
                    int separatorEnd(final int n) {
                        return n + 1;
                    }
                    
                    @Override
                    int separatorStart(final int n) {
                        return charMatcher.indexIn(this.toSplit, n);
                    }
                };
            }
        });
    }
    
    public static Splitter on(final String s) {
        Preconditions.checkArgument(s.length() != 0, (Object)"The separator may not be the empty string.");
        return new Splitter((Strategy)new Strategy() {
            public SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorEnd(final int n) {
                        return s.length() + n;
                    }
                    
                    public int separatorStart(int i) {
                        final int length = s.length();
                        final int length2 = this.toSplit.length();
                    Label_0023:
                        while (i <= length2 - length) {
                            int index = 0;
                            int n;
                            while (true) {
                                n = i;
                                if (index >= length) {
                                    break;
                                }
                                if (this.toSplit.charAt(index + i) != s.charAt(index)) {
                                    ++i;
                                    continue Label_0023;
                                }
                                ++index;
                            }
                            return n;
                        }
                        return -1;
                    }
                };
            }
        });
    }
    
    @GwtIncompatible("java.util.regex")
    public static Splitter on(final Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter((Strategy)new Strategy() {
            public SplittingIterator iterator(final Splitter splitter, final CharSequence input) {
                return new SplittingIterator(splitter, input) {
                    final /* synthetic */ Matcher val$matcher = pattern.matcher(input);
                    
                    public int separatorEnd(final int n) {
                        return this.val$matcher.end();
                    }
                    
                    public int separatorStart(final int start) {
                        if (this.val$matcher.find(start)) {
                            return this.val$matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }
    
    @GwtIncompatible("java.util.regex")
    public static Splitter onPattern(final String regex) {
        return on(Pattern.compile(regex));
    }
    
    private Iterator<String> splittingIterator(final CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }
    
    @CheckReturnValue
    public Splitter limit(final int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }
    
    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }
    
    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }
            
            @Override
            public String toString() {
                return Joiner.on(", ").appendTo(new StringBuilder().append('['), (Iterable<?>)this).append(']').toString();
            }
        };
    }
    
    @Beta
    public List<String> splitToList(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        final Iterator<String> splittingIterator = this.splittingIterator(charSequence);
        final ArrayList<String> list = new ArrayList<String>();
        while (splittingIterator.hasNext()) {
            list.add(splittingIterator.next());
        }
        return (List<String>)Collections.unmodifiableList((List<?>)list);
    }
    
    @CheckReturnValue
    public Splitter trimResults() {
        return this.trimResults(CharMatcher.WHITESPACE);
    }
    
    @CheckReturnValue
    public Splitter trimResults(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }
    
    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(final char c) {
        return this.withKeyValueSeparator(on(c));
    }
    
    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(final Splitter splitter) {
        return new MapSplitter(this, splitter);
    }
    
    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(final String s) {
        return this.withKeyValueSeparator(on(s));
    }
    
    @Beta
    public static final class MapSplitter
    {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;
        
        private MapSplitter(final Splitter outerSplitter, final Splitter splitter) {
            this.outerSplitter = outerSplitter;
            this.entrySplitter = Preconditions.checkNotNull(splitter);
        }
        
        public Map<String, String> split(final CharSequence charSequence) {
            final LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
            for (final String s : this.outerSplitter.split(charSequence)) {
                final Iterator access$000 = this.entrySplitter.splittingIterator(s);
                Preconditions.checkArgument(access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
                final String s2 = access$000.next();
                Preconditions.checkArgument(!m.containsKey(s2), "Duplicate key [%s] found.", s2);
                Preconditions.checkArgument(access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
                m.put(s2, access$000.next());
                Preconditions.checkArgument(!access$000.hasNext(), "Chunk [%s] is not a valid entry", s);
            }
            return (Map<String, String>)Collections.unmodifiableMap((Map<?, ?>)m);
        }
    }
    
    private abstract static class SplittingIterator extends AbstractIterator<String>
    {
        int limit;
        int offset;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;
        
        protected SplittingIterator(final Splitter splitter, final CharSequence toSplit) {
            this.offset = 0;
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = toSplit;
        }
        
        @Override
        protected String computeNext() {
            int n = this.offset;
            while (this.offset != -1) {
                int i = n;
                final int separatorStart = this.separatorStart(this.offset);
                int length;
                if (separatorStart == -1) {
                    length = this.toSplit.length();
                    this.offset = -1;
                }
                else {
                    length = separatorStart;
                    this.offset = this.separatorEnd(separatorStart);
                }
                if (this.offset == n) {
                    ++this.offset;
                    if (this.offset < this.toSplit.length()) {
                        continue;
                    }
                    this.offset = -1;
                }
                else {
                    int n2;
                    while (i < (n2 = length)) {
                        n2 = length;
                        if (!this.trimmer.matches(this.toSplit.charAt(i))) {
                            break;
                        }
                        ++i;
                    }
                    while (n2 > i && this.trimmer.matches(this.toSplit.charAt(n2 - 1))) {
                        --n2;
                    }
                    if (!this.omitEmptyStrings || i != n2) {
                        int n3;
                        if (this.limit == 1) {
                            int length2 = this.toSplit.length();
                            this.offset = -1;
                            while (true) {
                                n3 = length2;
                                if (length2 <= i) {
                                    break;
                                }
                                n3 = length2;
                                if (!this.trimmer.matches(this.toSplit.charAt(length2 - 1))) {
                                    break;
                                }
                                --length2;
                            }
                        }
                        else {
                            --this.limit;
                            n3 = n2;
                        }
                        return this.toSplit.subSequence(i, n3).toString();
                    }
                    n = this.offset;
                }
            }
            return this.endOfData();
        }
        
        abstract int separatorEnd(final int p0);
        
        abstract int separatorStart(final int p0);
    }
    
    private interface Strategy
    {
        Iterator<String> iterator(final Splitter p0, final CharSequence p1);
    }
}
