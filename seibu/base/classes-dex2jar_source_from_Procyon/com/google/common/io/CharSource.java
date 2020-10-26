// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.collect.AbstractIterator;
import java.util.regex.Pattern;
import com.google.common.base.Splitter;
import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.Collection;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public abstract class CharSource
{
    protected CharSource() {
    }
    
    public static CharSource concat(final Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }
    
    public static CharSource concat(final Iterator<? extends CharSource> iterator) {
        return concat((Iterable<? extends CharSource>)ImmutableList.copyOf((Iterator<?>)iterator));
    }
    
    public static CharSource concat(final CharSource... array) {
        return concat(ImmutableList.copyOf(array));
    }
    
    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }
    
    public static CharSource wrap(final CharSequence charSequence) {
        return new CharSequenceCharSource(charSequence);
    }
    
    public long copyTo(final CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        final Closer create = Closer.create();
        try {
            return CharStreams.copy(create.register(this.openStream()), create.register(charSink.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long copyTo(final Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        final Closer create = Closer.create();
        try {
            return CharStreams.copy(create.register(this.openStream()), appendable);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public boolean isEmpty() throws IOException {
        final Closer create = Closer.create();
        try {
            return create.register(this.openStream()).read() == -1;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public BufferedReader openBufferedStream() throws IOException {
        final Reader openStream = this.openStream();
        if (openStream instanceof BufferedReader) {
            return (BufferedReader)openStream;
        }
        return new BufferedReader(openStream);
    }
    
    public abstract Reader openStream() throws IOException;
    
    public String read() throws IOException {
        final Closer create = Closer.create();
        try {
            return CharStreams.toString(create.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Nullable
    public String readFirstLine() throws IOException {
        final Closer create = Closer.create();
        try {
            return create.register(this.openBufferedStream()).readLine();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public ImmutableList<String> readLines() throws IOException {
        final Closer create = Closer.create();
        ArrayList<Object> arrayList;
        try {
            final BufferedReader bufferedReader = create.register(this.openBufferedStream());
            arrayList = Lists.newArrayList();
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            }
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
        final ImmutableList<String> copy = ImmutableList.copyOf((Collection<? extends String>)arrayList);
        create.close();
        return copy;
    }
    
    @Beta
    public <T> T readLines(final LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        final Closer create = Closer.create();
        try {
            return CharStreams.readLines(create.register(this.openStream()), lineProcessor);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private static class CharSequenceCharSource extends CharSource
    {
        private static final Splitter LINE_SPLITTER;
        private final CharSequence seq;
        
        static {
            LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
        }
        
        protected CharSequenceCharSource(final CharSequence charSequence) {
            this.seq = Preconditions.checkNotNull(charSequence);
        }
        
        private Iterable<String> lines() {
            return new Iterable<String>() {
                @Override
                public Iterator<String> iterator() {
                    return new AbstractIterator<String>() {
                        Iterator<String> lines = CharSequenceCharSource.LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();
                        
                        @Override
                        protected String computeNext() {
                            if (this.lines.hasNext()) {
                                final String s = this.lines.next();
                                if (this.lines.hasNext() || !s.isEmpty()) {
                                    return s;
                                }
                            }
                            return this.endOfData();
                        }
                    };
                }
            };
        }
        
        @Override
        public boolean isEmpty() {
            return this.seq.length() == 0;
        }
        
        @Override
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }
        
        @Override
        public String read() {
            return this.seq.toString();
        }
        
        @Override
        public String readFirstLine() {
            final Iterator<String> iterator = this.lines().iterator();
            if (iterator.hasNext()) {
                return iterator.next();
            }
            return null;
        }
        
        @Override
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf((Iterable<? extends String>)this.lines());
        }
        
        @Override
        public <T> T readLines(final LineProcessor<T> lineProcessor) throws IOException {
            final Iterator<String> iterator = this.lines().iterator();
            while (iterator.hasNext() && lineProcessor.processLine(iterator.next())) {}
            return lineProcessor.getResult();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(Ascii.truncate(this.seq, 30, "...")));
            return new StringBuilder(value.length() + 17).append("CharSource.wrap(").append(value).append(")").toString();
        }
    }
    
    private static final class ConcatenatedCharSource extends CharSource
    {
        private final Iterable<? extends CharSource> sources;
        
        ConcatenatedCharSource(final Iterable<? extends CharSource> iterable) {
            this.sources = Preconditions.checkNotNull(iterable);
        }
        
        @Override
        public boolean isEmpty() throws IOException {
            final Iterator<? extends CharSource> iterator = this.sources.iterator();
            while (iterator.hasNext()) {
                if (!((CharSource)iterator.next()).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.sources));
            return new StringBuilder(value.length() + 19).append("CharSource.concat(").append(value).append(")").toString();
        }
    }
    
    private static final class EmptyCharSource extends CharSequenceCharSource
    {
        private static final EmptyCharSource INSTANCE;
        
        static {
            INSTANCE = new EmptyCharSource();
        }
        
        private EmptyCharSource() {
            super("");
        }
        
        @Override
        public String toString() {
            return "CharSource.empty()";
        }
    }
}
