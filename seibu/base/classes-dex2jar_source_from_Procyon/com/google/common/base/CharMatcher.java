// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.CheckReturnValue;
import com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;
import java.util.Arrays;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character>
{
    public static final CharMatcher ANY;
    public static final CharMatcher ASCII;
    public static final CharMatcher BREAKING_WHITESPACE;
    public static final CharMatcher DIGIT;
    private static final int DISTINCT_CHARS = 65536;
    public static final CharMatcher INVISIBLE;
    public static final CharMatcher JAVA_DIGIT;
    public static final CharMatcher JAVA_ISO_CONTROL;
    public static final CharMatcher JAVA_LETTER;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT;
    public static final CharMatcher JAVA_LOWER_CASE;
    public static final CharMatcher JAVA_UPPER_CASE;
    private static final String NINES;
    public static final CharMatcher NONE;
    public static final CharMatcher SINGLE_WIDTH;
    public static final CharMatcher WHITESPACE;
    static final int WHITESPACE_MULTIPLIER = 1682554634;
    static final int WHITESPACE_SHIFT;
    static final String WHITESPACE_TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";
    private static final String ZEROES = "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10";
    final String description;
    
    static {
        BREAKING_WHITESPACE = new CharMatcher() {
            @Override
            public boolean matches(final char c) {
                switch (c) {
                    default: {
                        if (c >= '\u2000' && c <= '\u200a') {
                            return true;
                        }
                        return false;
                    }
                    case '\t':
                    case '\n':
                    case '\u000b':
                    case '\f':
                    case '\r':
                    case ' ':
                    case '\u0085':
                    case '\u1680':
                    case '\u2028':
                    case '\u2029':
                    case '\u205f':
                    case '\u3000': {
                        return true;
                    }
                    case '\u2007': {
                        return false;
                    }
                }
            }
            
            @Override
            public String toString() {
                return "CharMatcher.BREAKING_WHITESPACE";
            }
        };
        ASCII = inRange('\0', '\u007f', "CharMatcher.ASCII");
        final StringBuilder sb = new StringBuilder("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length());
        for (int i = 0; i < "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length(); ++i) {
            sb.append((char)("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".charAt(i) + '\t'));
        }
        NINES = sb.toString();
        DIGIT = new RangesMatcher("CharMatcher.DIGIT", "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray(), CharMatcher.NINES.toCharArray());
        JAVA_DIGIT = new CharMatcher("CharMatcher.JAVA_DIGIT") {
            @Override
            public boolean matches(final char ch) {
                return Character.isDigit(ch);
            }
        };
        JAVA_LETTER = new CharMatcher("CharMatcher.JAVA_LETTER") {
            @Override
            public boolean matches(final char ch) {
                return Character.isLetter(ch);
            }
        };
        JAVA_LETTER_OR_DIGIT = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT") {
            @Override
            public boolean matches(final char ch) {
                return Character.isLetterOrDigit(ch);
            }
        };
        JAVA_UPPER_CASE = new CharMatcher("CharMatcher.JAVA_UPPER_CASE") {
            @Override
            public boolean matches(final char ch) {
                return Character.isUpperCase(ch);
            }
        };
        JAVA_LOWER_CASE = new CharMatcher("CharMatcher.JAVA_LOWER_CASE") {
            @Override
            public boolean matches(final char ch) {
                return Character.isLowerCase(ch);
            }
        };
        JAVA_ISO_CONTROL = inRange('\0', '\u001f').or(inRange('\u007f', '\u009f')).withToString("CharMatcher.JAVA_ISO_CONTROL");
        INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f\u202f\u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH", "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray(), "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray());
        ANY = new FastMatcher("CharMatcher.ANY") {
            @Override
            public CharMatcher and(final CharMatcher charMatcher) {
                return Preconditions.checkNotNull(charMatcher);
            }
            
            @Override
            public String collapseFrom(final CharSequence charSequence, final char c) {
                if (charSequence.length() == 0) {
                    return "";
                }
                return String.valueOf(c);
            }
            
            @Override
            public int countIn(final CharSequence charSequence) {
                return charSequence.length();
            }
            
            @Override
            public int indexIn(final CharSequence charSequence) {
                if (charSequence.length() == 0) {
                    return -1;
                }
                return 0;
            }
            
            @Override
            public int indexIn(final CharSequence charSequence, final int n) {
                final int length = charSequence.length();
                Preconditions.checkPositionIndex(n, length);
                int n2 = n;
                if (n == length) {
                    n2 = -1;
                }
                return n2;
            }
            
            @Override
            public int lastIndexIn(final CharSequence charSequence) {
                return charSequence.length() - 1;
            }
            
            @Override
            public boolean matches(final char c) {
                return true;
            }
            
            @Override
            public boolean matchesAllOf(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return true;
            }
            
            @Override
            public boolean matchesNoneOf(final CharSequence charSequence) {
                return charSequence.length() == 0;
            }
            
            @Override
            public CharMatcher negate() {
                return CharMatcher$7.NONE;
            }
            
            @Override
            public CharMatcher or(final CharMatcher charMatcher) {
                Preconditions.checkNotNull(charMatcher);
                return this;
            }
            
            @Override
            public String removeFrom(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return "";
            }
            
            @Override
            public String replaceFrom(final CharSequence charSequence, final char val) {
                final char[] array = new char[charSequence.length()];
                Arrays.fill(array, val);
                return new String(array);
            }
            
            @Override
            public String replaceFrom(final CharSequence charSequence, final CharSequence s) {
                final StringBuilder sb = new StringBuilder(charSequence.length() * s.length());
                for (int i = 0; i < charSequence.length(); ++i) {
                    sb.append(s);
                }
                return sb.toString();
            }
            
            @Override
            public String trimFrom(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return "";
            }
        };
        NONE = new FastMatcher("CharMatcher.NONE") {
            @Override
            public CharMatcher and(final CharMatcher charMatcher) {
                Preconditions.checkNotNull(charMatcher);
                return this;
            }
            
            @Override
            public String collapseFrom(final CharSequence charSequence, final char c) {
                return charSequence.toString();
            }
            
            @Override
            public int countIn(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return 0;
            }
            
            @Override
            public int indexIn(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return -1;
            }
            
            @Override
            public int indexIn(final CharSequence charSequence, final int n) {
                Preconditions.checkPositionIndex(n, charSequence.length());
                return -1;
            }
            
            @Override
            public int lastIndexIn(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return -1;
            }
            
            @Override
            public boolean matches(final char c) {
                return false;
            }
            
            @Override
            public boolean matchesAllOf(final CharSequence charSequence) {
                return charSequence.length() == 0;
            }
            
            @Override
            public boolean matchesNoneOf(final CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return true;
            }
            
            @Override
            public CharMatcher negate() {
                return CharMatcher$8.ANY;
            }
            
            @Override
            public CharMatcher or(final CharMatcher charMatcher) {
                return Preconditions.checkNotNull(charMatcher);
            }
            
            @Override
            public String removeFrom(final CharSequence charSequence) {
                return charSequence.toString();
            }
            
            @Override
            public String replaceFrom(final CharSequence charSequence, final char c) {
                return charSequence.toString();
            }
            
            @Override
            public String replaceFrom(final CharSequence charSequence, final CharSequence charSequence2) {
                Preconditions.checkNotNull(charSequence2);
                return charSequence.toString();
            }
            
            @Override
            public String trimFrom(final CharSequence charSequence) {
                return charSequence.toString();
            }
            
            @Override
            public String trimLeadingFrom(final CharSequence charSequence) {
                return charSequence.toString();
            }
            
            @Override
            public String trimTrailingFrom(final CharSequence charSequence) {
                return charSequence.toString();
            }
        };
        WHITESPACE_SHIFT = Integer.numberOfLeadingZeros("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
        WHITESPACE = new FastMatcher("WHITESPACE") {
            @Override
            public boolean matches(final char c) {
                return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(1682554634 * c >>> CharMatcher$15.WHITESPACE_SHIFT) == c;
            }
            
            @GwtIncompatible("java.util.BitSet")
            @Override
            void setBits(final BitSet set) {
                for (int i = 0; i < "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length(); ++i) {
                    set.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(i));
                }
            }
        };
    }
    
    protected CharMatcher() {
        this.description = super.toString();
    }
    
    CharMatcher(final String description) {
        this.description = description;
    }
    
    public static CharMatcher anyOf(final CharSequence charSequence) {
        switch (charSequence.length()) {
            default: {
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                final StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
                for (int length = charArray.length, i = 0; i < length; ++i) {
                    sb.append(showCharacter(charArray[i]));
                }
                sb.append("\")");
                return new CharMatcher(sb.toString()) {
                    @Override
                    public boolean matches(final char key) {
                        return Arrays.binarySearch(charArray, key) >= 0;
                    }
                    
                    @GwtIncompatible("java.util.BitSet")
                    @Override
                    void setBits(final BitSet set) {
                        final char[] val$chars = charArray;
                        for (int length = val$chars.length, i = 0; i < length; ++i) {
                            set.set(val$chars[i]);
                        }
                    }
                };
            }
            case 0: {
                return CharMatcher.NONE;
            }
            case 1: {
                return is(charSequence.charAt(0));
            }
            case 2: {
                return isEither(charSequence.charAt(0), charSequence.charAt(1));
            }
        }
    }
    
    private String finishCollapseFrom(final CharSequence charSequence, int i, final int n, final char c, final StringBuilder sb, final boolean b) {
        int n2 = b ? 1 : 0;
        while (i < n) {
            final char char1 = charSequence.charAt(i);
            int n3;
            if (this.matches(char1)) {
                if ((n3 = n2) == 0) {
                    sb.append(c);
                    n3 = 1;
                }
            }
            else {
                sb.append(char1);
                n3 = 0;
            }
            ++i;
            n2 = n3;
        }
        return sb.toString();
    }
    
    public static CharMatcher forPredicate(final Predicate<? super Character> obj) {
        Preconditions.checkNotNull(obj);
        if (obj instanceof CharMatcher) {
            return (CharMatcher)obj;
        }
        final String value = String.valueOf(String.valueOf(obj));
        return new CharMatcher(new StringBuilder(value.length() + 26).append("CharMatcher.forPredicate(").append(value).append(")").toString()) {
            @Override
            public boolean apply(final Character c) {
                return obj.apply(Preconditions.checkNotNull(c));
            }
            
            @Override
            public boolean matches(final char c) {
                return obj.apply(c);
            }
        };
    }
    
    public static CharMatcher inRange(final char c, final char c2) {
        Preconditions.checkArgument(c2 >= c);
        final String value = String.valueOf(String.valueOf(showCharacter(c)));
        final String value2 = String.valueOf(String.valueOf(showCharacter(c2)));
        return inRange(c, c2, new StringBuilder(value.length() + 27 + value2.length()).append("CharMatcher.inRange('").append(value).append("', '").append(value2).append("')").toString());
    }
    
    static CharMatcher inRange(final char c, final char c2, final String s) {
        return new FastMatcher(s) {
            @Override
            public boolean matches(final char c) {
                return c <= c && c <= c2;
            }
            
            @GwtIncompatible("java.util.BitSet")
            @Override
            void setBits(final BitSet set) {
                set.set(c, c2 + '\u0001');
            }
        };
    }
    
    public static CharMatcher is(final char c) {
        final String value = String.valueOf(String.valueOf(showCharacter(c)));
        return new FastMatcher(new StringBuilder(value.length() + 18).append("CharMatcher.is('").append(value).append("')").toString()) {
            @Override
            public CharMatcher and(final CharMatcher charMatcher) {
                if (charMatcher.matches(c)) {
                    return this;
                }
                return CharMatcher$9.NONE;
            }
            
            @Override
            public boolean matches(final char c) {
                return c == c;
            }
            
            @Override
            public CharMatcher negate() {
                return CharMatcher.isNot(c);
            }
            
            @Override
            public CharMatcher or(final CharMatcher charMatcher) {
                if (charMatcher.matches(c)) {
                    return charMatcher;
                }
                return super.or(charMatcher);
            }
            
            @Override
            public String replaceFrom(final CharSequence charSequence, final char newChar) {
                return charSequence.toString().replace(c, newChar);
            }
            
            @GwtIncompatible("java.util.BitSet")
            @Override
            void setBits(final BitSet set) {
                set.set(c);
            }
        };
    }
    
    private static CharMatcher isEither(final char c, final char c2) {
        final String value = String.valueOf(String.valueOf(showCharacter(c)));
        final String value2 = String.valueOf(String.valueOf(showCharacter(c2)));
        return new FastMatcher(new StringBuilder(value.length() + 21 + value2.length()).append("CharMatcher.anyOf(\"").append(value).append(value2).append("\")").toString()) {
            @Override
            public boolean matches(final char c) {
                return c == c || c == c2;
            }
            
            @GwtIncompatible("java.util.BitSet")
            @Override
            void setBits(final BitSet set) {
                set.set(c);
                set.set(c2);
            }
        };
    }
    
    public static CharMatcher isNot(final char c) {
        final String value = String.valueOf(String.valueOf(showCharacter(c)));
        return new FastMatcher(new StringBuilder(value.length() + 21).append("CharMatcher.isNot('").append(value).append("')").toString()) {
            @Override
            public CharMatcher and(final CharMatcher charMatcher) {
                CharMatcher and = charMatcher;
                if (charMatcher.matches(c)) {
                    and = super.and(charMatcher);
                }
                return and;
            }
            
            @Override
            public boolean matches(final char c) {
                return c != c;
            }
            
            @Override
            public CharMatcher negate() {
                return CharMatcher.is(c);
            }
            
            @Override
            public CharMatcher or(final CharMatcher charMatcher) {
                CharMatcher any = this;
                if (charMatcher.matches(c)) {
                    any = CharMatcher$10.ANY;
                }
                return any;
            }
            
            @GwtIncompatible("java.util.BitSet")
            @Override
            void setBits(final BitSet set) {
                set.set(0, c);
                set.set(c + '\u0001', 65536);
            }
        };
    }
    
    @GwtIncompatible("SmallCharMatcher")
    private static boolean isSmall(final int n, final int n2) {
        return n <= 1023 && n2 > n * 4 * 16;
    }
    
    public static CharMatcher noneOf(final CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }
    
    @GwtIncompatible("java.util.BitSet")
    private static CharMatcher precomputedPositive(final int n, final BitSet set, final String s) {
        switch (n) {
            default: {
                if (isSmall(n, set.length())) {
                    return SmallCharMatcher.from(set, s);
                }
                return new BitSetMatcher(set, s);
            }
            case 0: {
                return CharMatcher.NONE;
            }
            case 1: {
                return is((char)set.nextSetBit(0));
            }
            case 2: {
                final char c = (char)set.nextSetBit(0);
                return isEither(c, (char)set.nextSetBit(c + '\u0001'));
            }
        }
    }
    
    private static String showCharacter(final char c) {
        final char[] array;
        final char[] data = array = new char[6];
        array[0] = '\\';
        array[1] = 'u';
        array[3] = (array[2] = '\0');
        array[5] = (array[4] = '\0');
        final int n = 0;
        char c2 = c;
        for (int i = n; i < 4; ++i) {
            data[5 - i] = "0123456789ABCDEF".charAt(c2 & '\u000f');
            c2 >>= 4;
        }
        return String.copyValueOf(data);
    }
    
    public CharMatcher and(final CharMatcher charMatcher) {
        return new And(this, Preconditions.checkNotNull(charMatcher));
    }
    
    @Deprecated
    @Override
    public boolean apply(final Character c) {
        return this.matches(c);
    }
    
    @CheckReturnValue
    public String collapseFrom(final CharSequence charSequence, final char c) {
        int n;
        for (int length = charSequence.length(), i = 0; i < length; i = n + 1) {
            final char char1 = charSequence.charAt(i);
            n = i;
            if (this.matches(char1)) {
                if (char1 != c || (i != length - 1 && this.matches(charSequence.charAt(i + 1)))) {
                    return this.finishCollapseFrom(charSequence, i + 1, length, c, new StringBuilder(length).append(charSequence.subSequence(0, i)).append(c), true);
                }
                n = i + 1;
            }
        }
        return charSequence.toString();
    }
    
    public int countIn(final CharSequence charSequence) {
        int n = 0;
        int n2;
        for (int i = 0; i < charSequence.length(); ++i, n = n2) {
            n2 = n;
            if (this.matches(charSequence.charAt(i))) {
                n2 = n + 1;
            }
        }
        return n;
    }
    
    public int indexIn(final CharSequence charSequence) {
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            if (this.matches(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public int indexIn(final CharSequence charSequence, int i) {
        final int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        while (i < length) {
            if (this.matches(charSequence.charAt(i))) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public int lastIndexIn(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (this.matches(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public abstract boolean matches(final char p0);
    
    public boolean matchesAllOf(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (!this.matches(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean matchesAnyOf(final CharSequence charSequence) {
        return !this.matchesNoneOf(charSequence);
    }
    
    public boolean matchesNoneOf(final CharSequence charSequence) {
        return this.indexIn(charSequence) == -1;
    }
    
    public CharMatcher negate() {
        return new NegatedMatcher(this);
    }
    
    public CharMatcher or(final CharMatcher charMatcher) {
        return new Or(this, Preconditions.checkNotNull(charMatcher));
    }
    
    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }
    
    @GwtIncompatible("java.util.BitSet")
    CharMatcher precomputedInternal() {
        final BitSet bits = new BitSet();
        this.setBits(bits);
        final int cardinality = bits.cardinality();
        if (cardinality * 2 <= 65536) {
            return precomputedPositive(cardinality, bits, this.description);
        }
        bits.flip(0, 65536);
        String s;
        if (this.description.endsWith(".negate()")) {
            s = this.description.substring(0, this.description.length() - ".negate()".length());
        }
        else {
            final String value = String.valueOf(this.description);
            final String value2 = String.valueOf(".negate()");
            if (value2.length() != 0) {
                s = value.concat(value2);
            }
            else {
                s = new String(value);
            }
        }
        return new NegatedFastMatcher(this.toString(), precomputedPositive(65536 - cardinality, bits, s));
    }
    
    @CheckReturnValue
    public String removeFrom(final CharSequence charSequence) {
        final String string = charSequence.toString();
        int i = this.indexIn(string);
        if (i == -1) {
            return string;
        }
        final char[] charArray = string.toCharArray();
        int n = 1;
    Label_0027:
        while (true) {
            for (++i; i != charArray.length; ++i) {
                if (this.matches(charArray[i])) {
                    ++n;
                    continue Label_0027;
                }
                charArray[i - n] = charArray[i];
            }
            break;
        }
        return new String(charArray, 0, i - n);
    }
    
    @CheckReturnValue
    public String replaceFrom(final CharSequence charSequence, final char c) {
        final String string = charSequence.toString();
        final int indexIn = this.indexIn(string);
        if (indexIn == -1) {
            return string;
        }
        final char[] charArray = string.toCharArray();
        charArray[indexIn] = c;
        for (int i = indexIn + 1; i < charArray.length; ++i) {
            if (this.matches(charArray[i])) {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }
    
    @CheckReturnValue
    public String replaceFrom(final CharSequence charSequence, final CharSequence s) {
        final int length = s.length();
        String remove;
        if (length == 0) {
            remove = this.removeFrom(charSequence);
        }
        else {
            if (length == 1) {
                return this.replaceFrom(charSequence, s.charAt(0));
            }
            final String string = charSequence.toString();
            int indexIn = this.indexIn(string);
            remove = string;
            if (indexIn != -1) {
                final int length2 = string.length();
                final StringBuilder sb = new StringBuilder(length2 * 3 / 2 + 16);
                int start = 0;
                int indexIn2;
                int start2;
                do {
                    sb.append(string, start, indexIn);
                    sb.append(s);
                    start2 = indexIn + 1;
                    indexIn2 = this.indexIn(string, start2);
                    start = start2;
                } while ((indexIn = indexIn2) != -1);
                sb.append(string, start2, length2);
                return sb.toString();
            }
        }
        return remove;
    }
    
    @CheckReturnValue
    public String retainFrom(final CharSequence charSequence) {
        return this.negate().removeFrom(charSequence);
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(final BitSet set) {
        for (int i = 65535; i >= 0; --i) {
            if (this.matches((char)i)) {
                set.set(i);
            }
        }
    }
    
    @Override
    public String toString() {
        return this.description;
    }
    
    @CheckReturnValue
    public String trimAndCollapseFrom(final CharSequence charSequence, final char c) {
        int length;
        int n;
        for (length = charSequence.length(), n = 0; n < length && this.matches(charSequence.charAt(n)); ++n) {}
        int n2;
        for (n2 = length - 1; n2 > n && this.matches(charSequence.charAt(n2)); --n2) {}
        if (n == 0 && n2 == length - 1) {
            return this.collapseFrom(charSequence, c);
        }
        return this.finishCollapseFrom(charSequence, n, n2 + 1, c, new StringBuilder(n2 + 1 - n), false);
    }
    
    @CheckReturnValue
    public String trimFrom(final CharSequence charSequence) {
        int length;
        int n;
        for (length = charSequence.length(), n = 0; n < length && this.matches(charSequence.charAt(n)); ++n) {}
        int n2;
        for (n2 = length - 1; n2 > n && this.matches(charSequence.charAt(n2)); --n2) {}
        return charSequence.subSequence(n, n2 + 1).toString();
    }
    
    @CheckReturnValue
    public String trimLeadingFrom(final CharSequence charSequence) {
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            if (!this.matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }
    
    @CheckReturnValue
    public String trimTrailingFrom(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (!this.matches(charSequence.charAt(i))) {
                return charSequence.subSequence(0, i + 1).toString();
            }
        }
        return "";
    }
    
    CharMatcher withToString(final String s) {
        throw new UnsupportedOperationException();
    }
    
    private static class And extends CharMatcher
    {
        final CharMatcher first;
        final CharMatcher second;
        
        And(final CharMatcher obj, final CharMatcher obj2) {
            final String value = String.valueOf(String.valueOf(obj));
            final String value2 = String.valueOf(String.valueOf(obj2));
            this(obj, obj2, new StringBuilder(value.length() + 19 + value2.length()).append("CharMatcher.and(").append(value).append(", ").append(value2).append(")").toString());
        }
        
        And(final CharMatcher charMatcher, final CharMatcher charMatcher2, final String s) {
            super(s);
            this.first = Preconditions.checkNotNull(charMatcher);
            this.second = Preconditions.checkNotNull(charMatcher2);
        }
        
        @Override
        public boolean matches(final char c) {
            return this.first.matches(c) && this.second.matches(c);
        }
        
        @GwtIncompatible("java.util.BitSet")
        @Override
        void setBits(final BitSet set) {
            final BitSet set2 = new BitSet();
            this.first.setBits(set2);
            final BitSet set3 = new BitSet();
            this.second.setBits(set3);
            set2.and(set3);
            set.or(set2);
        }
        
        @Override
        CharMatcher withToString(final String s) {
            return new And(this.first, this.second, s);
        }
    }
    
    @GwtIncompatible("java.util.BitSet")
    private static class BitSetMatcher extends FastMatcher
    {
        private final BitSet table;
        
        private BitSetMatcher(final BitSet set, final String s) {
            super(s);
            BitSet table = set;
            if (set.length() + 64 < set.size()) {
                table = (BitSet)set.clone();
            }
            this.table = table;
        }
        
        @Override
        public boolean matches(final char bitIndex) {
            return this.table.get(bitIndex);
        }
        
        @Override
        void setBits(final BitSet set) {
            set.or(this.table);
        }
    }
    
    abstract static class FastMatcher extends CharMatcher
    {
        FastMatcher() {
        }
        
        FastMatcher(final String s) {
            super(s);
        }
        
        @Override
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
        
        @Override
        public final CharMatcher precomputed() {
            return this;
        }
    }
    
    static final class NegatedFastMatcher extends NegatedMatcher
    {
        NegatedFastMatcher(final CharMatcher charMatcher) {
            super(charMatcher);
        }
        
        NegatedFastMatcher(final String s, final CharMatcher charMatcher) {
            super(s, charMatcher);
        }
        
        @Override
        public final CharMatcher precomputed() {
            return this;
        }
        
        @Override
        CharMatcher withToString(final String s) {
            return new NegatedFastMatcher(s, this.original);
        }
    }
    
    private static class NegatedMatcher extends CharMatcher
    {
        final CharMatcher original;
        
        NegatedMatcher(final CharMatcher obj) {
            final String value = String.valueOf(String.valueOf(obj));
            this(new StringBuilder(value.length() + 9).append(value).append(".negate()").toString(), obj);
        }
        
        NegatedMatcher(final String s, final CharMatcher original) {
            super(s);
            this.original = original;
        }
        
        @Override
        public int countIn(final CharSequence charSequence) {
            return charSequence.length() - this.original.countIn(charSequence);
        }
        
        @Override
        public boolean matches(final char c) {
            return !this.original.matches(c);
        }
        
        @Override
        public boolean matchesAllOf(final CharSequence charSequence) {
            return this.original.matchesNoneOf(charSequence);
        }
        
        @Override
        public boolean matchesNoneOf(final CharSequence charSequence) {
            return this.original.matchesAllOf(charSequence);
        }
        
        @Override
        public CharMatcher negate() {
            return this.original;
        }
        
        @GwtIncompatible("java.util.BitSet")
        @Override
        void setBits(final BitSet set) {
            final BitSet set2 = new BitSet();
            this.original.setBits(set2);
            set2.flip(0, 65536);
            set.or(set2);
        }
        
        @Override
        CharMatcher withToString(final String s) {
            return new NegatedMatcher(s, this.original);
        }
    }
    
    private static class Or extends CharMatcher
    {
        final CharMatcher first;
        final CharMatcher second;
        
        Or(final CharMatcher obj, final CharMatcher obj2) {
            final String value = String.valueOf(String.valueOf(obj));
            final String value2 = String.valueOf(String.valueOf(obj2));
            this(obj, obj2, new StringBuilder(value.length() + 18 + value2.length()).append("CharMatcher.or(").append(value).append(", ").append(value2).append(")").toString());
        }
        
        Or(final CharMatcher charMatcher, final CharMatcher charMatcher2, final String s) {
            super(s);
            this.first = Preconditions.checkNotNull(charMatcher);
            this.second = Preconditions.checkNotNull(charMatcher2);
        }
        
        @Override
        public boolean matches(final char c) {
            return this.first.matches(c) || this.second.matches(c);
        }
        
        @GwtIncompatible("java.util.BitSet")
        @Override
        void setBits(final BitSet set) {
            this.first.setBits(set);
            this.second.setBits(set);
        }
        
        @Override
        CharMatcher withToString(final String s) {
            return new Or(this.first, this.second, s);
        }
    }
    
    private static class RangesMatcher extends CharMatcher
    {
        private final char[] rangeEnds;
        private final char[] rangeStarts;
        
        RangesMatcher(final String s, final char[] rangeStarts, final char[] rangeEnds) {
            super(s);
            this.rangeStarts = rangeStarts;
            this.rangeEnds = rangeEnds;
            Preconditions.checkArgument(rangeStarts.length == rangeEnds.length);
            for (int i = 0; i < rangeStarts.length; ++i) {
                Preconditions.checkArgument(rangeStarts[i] <= rangeEnds[i]);
                if (i + 1 < rangeStarts.length) {
                    Preconditions.checkArgument(rangeEnds[i] < rangeStarts[i + 1]);
                }
            }
        }
        
        @Override
        public boolean matches(final char key) {
            final int binarySearch = Arrays.binarySearch(this.rangeStarts, key);
            if (binarySearch < 0) {
                final int n = ~binarySearch - 1;
                if (n < 0 || key > this.rangeEnds[n]) {
                    return false;
                }
            }
            return true;
        }
    }
}
