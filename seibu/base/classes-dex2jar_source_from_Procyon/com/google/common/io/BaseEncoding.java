// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import javax.annotation.Nullable;
import com.google.common.base.Ascii;
import java.util.Arrays;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import javax.annotation.CheckReturnValue;
import java.io.Writer;
import java.io.OutputStream;
import java.io.Reader;
import com.google.common.annotations.GwtIncompatible;
import java.io.InputStream;
import java.io.IOException;
import com.google.common.base.Preconditions;
import com.google.common.base.CharMatcher;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(emulated = true)
public abstract class BaseEncoding
{
    private static final BaseEncoding BASE16;
    private static final BaseEncoding BASE32;
    private static final BaseEncoding BASE32_HEX;
    private static final BaseEncoding BASE64;
    private static final BaseEncoding BASE64_URL;
    
    static {
        BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);
    }
    
    BaseEncoding() {
    }
    
    public static BaseEncoding base16() {
        return BaseEncoding.BASE16;
    }
    
    public static BaseEncoding base32() {
        return BaseEncoding.BASE32;
    }
    
    public static BaseEncoding base32Hex() {
        return BaseEncoding.BASE32_HEX;
    }
    
    public static BaseEncoding base64() {
        return BaseEncoding.BASE64;
    }
    
    public static BaseEncoding base64Url() {
        return BaseEncoding.BASE64_URL;
    }
    
    private static byte[] extract(final byte[] array, final int n) {
        if (n == array.length) {
            return array;
        }
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    static GwtWorkarounds.CharInput ignoringInput(final GwtWorkarounds.CharInput charInput, final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charInput);
        Preconditions.checkNotNull(charMatcher);
        return new GwtWorkarounds.CharInput() {
            @Override
            public void close() throws IOException {
                charInput.close();
            }
            
            @Override
            public int read() throws IOException {
                int read;
                do {
                    read = charInput.read();
                } while (read != -1 && charMatcher.matches((char)read));
                return read;
            }
        };
    }
    
    static GwtWorkarounds.CharOutput separatingOutput(final GwtWorkarounds.CharOutput charOutput, final String s, final int n) {
        Preconditions.checkNotNull(charOutput);
        Preconditions.checkNotNull(s);
        Preconditions.checkArgument(n > 0);
        return new GwtWorkarounds.CharOutput() {
            int charsUntilSeparator = n;
            
            @Override
            public void close() throws IOException {
                charOutput.close();
            }
            
            @Override
            public void flush() throws IOException {
                charOutput.flush();
            }
            
            @Override
            public void write(final char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    for (int i = 0; i < s.length(); ++i) {
                        charOutput.write(s.charAt(i));
                    }
                    this.charsUntilSeparator = n;
                }
                charOutput.write(c);
                --this.charsUntilSeparator;
            }
        };
    }
    
    public final byte[] decode(final CharSequence charSequence) {
        try {
            return this.decodeChecked(charSequence);
        }
        catch (DecodingException cause) {
            throw new IllegalArgumentException(cause);
        }
    }
    
    final byte[] decodeChecked(final CharSequence charSequence) throws DecodingException {
        final String trimTrailing = this.padding().trimTrailingFrom(charSequence);
        final GwtWorkarounds.ByteInput decodingStream = this.decodingStream(GwtWorkarounds.asCharInput(trimTrailing));
        final byte[] array = new byte[this.maxDecodedSize(trimTrailing.length())];
        int n;
        try {
            for (int i = decodingStream.read(), n = 0; i != -1; i = decodingStream.read(), ++n) {
                array[n] = (byte)i;
            }
        }
        catch (DecodingException ex) {
            throw ex;
        }
        catch (IOException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
        return extract(array, n);
    }
    
    @GwtIncompatible("ByteSource,CharSource")
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() {
            @Override
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }
    
    abstract GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput p0);
    
    @GwtIncompatible("Reader,InputStream")
    public final InputStream decodingStream(final Reader reader) {
        return GwtWorkarounds.asInputStream(this.decodingStream(GwtWorkarounds.asCharInput(reader)));
    }
    
    public String encode(final byte[] array) {
        return this.encode(Preconditions.checkNotNull(array), 0, array.length);
    }
    
    public final String encode(final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(array);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        final GwtWorkarounds.CharOutput stringBuilderOutput = GwtWorkarounds.stringBuilderOutput(this.maxEncodedSize(n2));
        final GwtWorkarounds.ByteOutput encodingStream = this.encodingStream(stringBuilderOutput);
        int n3 = 0;
        while (true) {
            Label_0063: {
                if (n3 >= n2) {
                    break Label_0063;
                }
                try {
                    encodingStream.write(array[n + n3]);
                    ++n3;
                    continue;
                    encodingStream.close();
                    return stringBuilderOutput.toString();
                }
                catch (IOException ex) {
                    throw new AssertionError((Object)"impossible");
                }
            }
        }
    }
    
    @GwtIncompatible("ByteSink,CharSink")
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() {
            @Override
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }
    
    abstract GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput p0);
    
    @GwtIncompatible("Writer,OutputStream")
    public final OutputStream encodingStream(final Writer writer) {
        return GwtWorkarounds.asOutputStream(this.encodingStream(GwtWorkarounds.asCharOutput(writer)));
    }
    
    @CheckReturnValue
    public abstract BaseEncoding lowerCase();
    
    abstract int maxDecodedSize(final int p0);
    
    abstract int maxEncodedSize(final int p0);
    
    @CheckReturnValue
    public abstract BaseEncoding omitPadding();
    
    abstract CharMatcher padding();
    
    @CheckReturnValue
    public abstract BaseEncoding upperCase();
    
    @CheckReturnValue
    public abstract BaseEncoding withPadChar(final char p0);
    
    @CheckReturnValue
    public abstract BaseEncoding withSeparator(final String p0, final int p1);
    
    private static final class Alphabet extends CharMatcher
    {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;
        
        Alphabet(final String s, final char[] array) {
            byte[] array2;
            while (true) {
                this.name = Preconditions.checkNotNull(s);
                this.chars = Preconditions.checkNotNull(array);
                while (true) {
                    Label_0208: {
                        try {
                            this.bitsPerChar = IntMath.log2(array.length, RoundingMode.UNNECESSARY);
                            final int min = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
                            this.charsPerChunk = 8 / min;
                            this.bytesPerChunk = this.bitsPerChar / min;
                            this.mask = array.length - 1;
                            array2 = new byte[128];
                            Arrays.fill(array2, (byte)(-1));
                            for (int i = 0; i < array.length; ++i) {
                                final char c = array[i];
                                Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", c);
                                if (array2[c] != -1) {
                                    break Label_0208;
                                }
                                final boolean b = true;
                                Preconditions.checkArgument(b, "Duplicate character: %s", c);
                                array2[c] = (byte)i;
                            }
                            break;
                        }
                        catch (ArithmeticException cause) {
                            throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(array.length).toString(), cause);
                        }
                    }
                    final boolean b = false;
                    continue;
                }
            }
            this.decodabet = array2;
            final boolean[] validPadding = new boolean[this.charsPerChunk];
            for (int j = 0; j < this.bytesPerChunk; ++j) {
                validPadding[IntMath.divide(j * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
            }
            this.validPadding = validPadding;
        }
        
        private boolean hasLowerCase() {
            final char[] chars = this.chars;
            for (int length = chars.length, i = 0; i < length; ++i) {
                if (Ascii.isLowerCase(chars[i])) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean hasUpperCase() {
            final char[] chars = this.chars;
            for (int length = chars.length, i = 0; i < length; ++i) {
                if (Ascii.isUpperCase(chars[i])) {
                    return true;
                }
            }
            return false;
        }
        
        int decode(final char c) throws IOException {
            if (c > '\u007f' || this.decodabet[c] == -1) {
                throw new DecodingException(new StringBuilder(25).append("Unrecognized character: ").append(c).toString());
            }
            return this.decodabet[c];
        }
        
        char encode(final int n) {
            return this.chars[n];
        }
        
        boolean isValidPaddingStartPosition(final int n) {
            return this.validPadding[n % this.charsPerChunk];
        }
        
        Alphabet lowerCase() {
            if (!this.hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!this.hasLowerCase(), (Object)"Cannot call lowerCase() on a mixed-case alphabet");
            final char[] array = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; ++i) {
                array[i] = Ascii.toLowerCase(this.chars[i]);
            }
            return new Alphabet(String.valueOf(this.name).concat(".lowerCase()"), array);
        }
        
        @Override
        public boolean matches(final char c) {
            return CharMatcher.ASCII.matches(c) && this.decodabet[c] != -1;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        Alphabet upperCase() {
            if (!this.hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!this.hasUpperCase(), (Object)"Cannot call upperCase() on a mixed-case alphabet");
            final char[] array = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; ++i) {
                array[i] = Ascii.toUpperCase(this.chars[i]);
            }
            return new Alphabet(String.valueOf(this.name).concat(".upperCase()"), array);
        }
    }
    
    public static final class DecodingException extends IOException
    {
        DecodingException(final String message) {
            super(message);
        }
        
        DecodingException(final Throwable cause) {
            super(cause);
        }
    }
    
    static final class SeparatedBaseEncoding extends BaseEncoding
    {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;
        private final CharMatcher separatorChars;
        
        SeparatedBaseEncoding(final BaseEncoding baseEncoding, final String s, final int n) {
            this.delegate = Preconditions.checkNotNull(baseEncoding);
            this.separator = Preconditions.checkNotNull(s);
            this.afterEveryChars = n;
            Preconditions.checkArgument(n > 0, "Cannot add a separator after every %s chars", n);
            this.separatorChars = CharMatcher.anyOf(s).precomputed();
        }
        
        @Override
        GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput charInput) {
            return this.delegate.decodingStream(BaseEncoding.ignoringInput(charInput, this.separatorChars));
        }
        
        @Override
        GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput charOutput) {
            return this.delegate.encodingStream(BaseEncoding.separatingOutput(charOutput, this.separator, this.afterEveryChars));
        }
        
        @Override
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }
        
        @Override
        int maxDecodedSize(final int n) {
            return this.delegate.maxDecodedSize(n);
        }
        
        @Override
        int maxEncodedSize(int maxEncodedSize) {
            maxEncodedSize = this.delegate.maxEncodedSize(maxEncodedSize);
            return this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR) + maxEncodedSize;
        }
        
        @Override
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }
        
        @Override
        CharMatcher padding() {
            return this.delegate.padding();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.delegate.toString()));
            final String value2 = String.valueOf(String.valueOf(this.separator));
            return new StringBuilder(value.length() + 31 + value2.length()).append(value).append(".withSeparator(\"").append(value2).append("\", ").append(this.afterEveryChars).append(")").toString();
        }
        
        @Override
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }
        
        @Override
        public BaseEncoding withPadChar(final char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }
        
        @Override
        public BaseEncoding withSeparator(final String s, final int n) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }
    
    static final class StandardBaseEncoding extends BaseEncoding
    {
        private final Alphabet alphabet;
        private transient BaseEncoding lowerCase;
        @Nullable
        private final Character paddingChar;
        private transient BaseEncoding upperCase;
        
        StandardBaseEncoding(final Alphabet alphabet, @Nullable final Character paddingChar) {
            this.alphabet = Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(paddingChar == null || !alphabet.matches(paddingChar), "Padding character %s was already in alphabet", paddingChar);
            this.paddingChar = paddingChar;
        }
        
        StandardBaseEncoding(final String s, final String s2, @Nullable final Character c) {
            this(new Alphabet(s, s2.toCharArray()), c);
        }
        
        @Override
        GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput charInput) {
            Preconditions.checkNotNull(charInput);
            return new GwtWorkarounds.ByteInput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                boolean hitPadding = false;
                final CharMatcher paddingMatcher = StandardBaseEncoding.this.padding();
                int readChars = 0;
                
                @Override
                public void close() throws IOException {
                    charInput.close();
                }
                
                @Override
                public int read() throws IOException {
                    final int n = -1;
                    int n2;
                    while (true) {
                        final int read = charInput.read();
                        if (read == -1) {
                            n2 = n;
                            if (this.hitPadding) {
                                break;
                            }
                            n2 = n;
                            if (!StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                                throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(this.readChars).toString());
                            }
                            break;
                        }
                        else {
                            ++this.readChars;
                            final char c = (char)read;
                            if (this.paddingMatcher.matches(c)) {
                                if (!this.hitPadding && (this.readChars == 1 || !StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                                    throw new DecodingException(new StringBuilder(41).append("Padding cannot start at index ").append(this.readChars).toString());
                                }
                                this.hitPadding = true;
                            }
                            else {
                                if (this.hitPadding) {
                                    throw new DecodingException(new StringBuilder(61).append("Expected padding character but found '").append(c).append("' at index ").append(this.readChars).toString());
                                }
                                this.bitBuffer <<= StandardBaseEncoding.this.alphabet.bitsPerChar;
                                this.bitBuffer |= StandardBaseEncoding.this.alphabet.decode(c);
                                this.bitBufferLength += StandardBaseEncoding.this.alphabet.bitsPerChar;
                                if (this.bitBufferLength >= 8) {
                                    this.bitBufferLength -= 8;
                                    n2 = (this.bitBuffer >> this.bitBufferLength & 0xFF);
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    return n2;
                }
            };
        }
        
        @Override
        GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput charOutput) {
            Preconditions.checkNotNull(charOutput);
            return new GwtWorkarounds.ByteOutput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;
                
                @Override
                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode(this.bitBuffer << StandardBaseEncoding.this.alphabet.bitsPerChar - this.bitBufferLength & StandardBaseEncoding.this.alphabet.mask));
                        ++this.writtenChars;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                                charOutput.write(StandardBaseEncoding.this.paddingChar);
                                ++this.writtenChars;
                            }
                        }
                    }
                    charOutput.close();
                }
                
                @Override
                public void flush() throws IOException {
                    charOutput.flush();
                }
                
                @Override
                public void write(final byte b) throws IOException {
                    this.bitBuffer <<= 8;
                    this.bitBuffer |= (b & 0xFF);
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= StandardBaseEncoding.this.alphabet.bitsPerChar) {
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode(this.bitBuffer >> this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar & StandardBaseEncoding.this.alphabet.mask));
                        ++this.writtenChars;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }
            };
        }
        
        @Override
        public BaseEncoding lowerCase() {
            BaseEncoding lowerCase;
            if ((lowerCase = this.lowerCase) == null) {
                final Alphabet lowerCase2 = this.alphabet.lowerCase();
                if (lowerCase2 == this.alphabet) {
                    lowerCase = this;
                }
                else {
                    lowerCase = new StandardBaseEncoding(lowerCase2, this.paddingChar);
                }
                this.lowerCase = lowerCase;
            }
            return lowerCase;
        }
        
        @Override
        int maxDecodedSize(final int n) {
            return (int)((this.alphabet.bitsPerChar * (long)n + 7L) / 8L);
        }
        
        @Override
        int maxEncodedSize(final int n) {
            return this.alphabet.charsPerChunk * IntMath.divide(n, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }
        
        @Override
        public BaseEncoding omitPadding() {
            if (this.paddingChar == null) {
                return this;
            }
            return new StandardBaseEncoding(this.alphabet, null);
        }
        
        @Override
        CharMatcher padding() {
            if (this.paddingChar == null) {
                return CharMatcher.NONE;
            }
            return CharMatcher.is(this.paddingChar);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                }
                else {
                    sb.append(".withPadChar(").append(this.paddingChar).append(')');
                }
            }
            return sb.toString();
        }
        
        @Override
        public BaseEncoding upperCase() {
            BaseEncoding upperCase;
            if ((upperCase = this.upperCase) == null) {
                final Alphabet upperCase2 = this.alphabet.upperCase();
                if (upperCase2 == this.alphabet) {
                    upperCase = this;
                }
                else {
                    upperCase = new StandardBaseEncoding(upperCase2, this.paddingChar);
                }
                this.upperCase = upperCase;
            }
            return upperCase;
        }
        
        @Override
        public BaseEncoding withPadChar(final char c) {
            if (8 % this.alphabet.bitsPerChar == 0 || (this.paddingChar != null && this.paddingChar == c)) {
                return this;
            }
            return new StandardBaseEncoding(this.alphabet, c);
        }
        
        @Override
        public BaseEncoding withSeparator(final String s, final int n) {
            Preconditions.checkNotNull(s);
            Preconditions.checkArgument(this.padding().or(this.alphabet).matchesNoneOf(s), (Object)"Separator cannot contain alphabet or padding characters");
            return new SeparatedBaseEncoding(this, s, n);
        }
    }
}
