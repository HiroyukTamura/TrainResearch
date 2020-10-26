// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.Nullable;
import java.io.Serializable;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum CaseFormat
{
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        @Override
        String normalizeWord(final String s) {
            return firstCharOnlyToUpper(s);
        }
    }, 
    LOWER_HYPHEN(CharMatcher.is('-'), "-") {
        @Override
        String convert(final CaseFormat caseFormat, final String s) {
            if (caseFormat == CaseFormat$1.LOWER_UNDERSCORE) {
                return s.replace('-', '_');
            }
            if (caseFormat == CaseFormat$1.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(s.replace('-', '_'));
            }
            return super.convert(caseFormat, s);
        }
        
        @Override
        String normalizeWord(final String s) {
            return Ascii.toLowerCase(s);
        }
    }, 
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override
        String convert(final CaseFormat caseFormat, final String s) {
            if (caseFormat == CaseFormat$2.LOWER_HYPHEN) {
                return s.replace('_', '-');
            }
            if (caseFormat == CaseFormat$2.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(s);
            }
            return super.convert(caseFormat, s);
        }
        
        @Override
        String normalizeWord(final String s) {
            return Ascii.toLowerCase(s);
        }
    }, 
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        @Override
        String normalizeWord(final String s) {
            return firstCharOnlyToUpper(s);
        }
    }, 
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override
        String convert(final CaseFormat caseFormat, final String s) {
            if (caseFormat == CaseFormat$5.LOWER_HYPHEN) {
                return Ascii.toLowerCase(s.replace('_', '-'));
            }
            if (caseFormat == CaseFormat$5.LOWER_UNDERSCORE) {
                return Ascii.toLowerCase(s);
            }
            return super.convert(caseFormat, s);
        }
        
        @Override
        String normalizeWord(final String s) {
            return Ascii.toUpperCase(s);
        }
    };
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;
    
    private CaseFormat(final CharMatcher wordBoundary, final String wordSeparator) {
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }
    
    private static String firstCharOnlyToUpper(final String s) {
        if (s.isEmpty()) {
            return s;
        }
        return new StringBuilder(s.length()).append(Ascii.toUpperCase(s.charAt(0))).append(Ascii.toLowerCase(s.substring(1))).toString();
    }
    
    private String normalizeFirstWord(final String s) {
        if (this == CaseFormat.LOWER_CAMEL) {
            return Ascii.toLowerCase(s);
        }
        return this.normalizeWord(s);
    }
    
    String convert(final CaseFormat caseFormat, final String s) {
        StringBuilder sb = null;
        int beginIndex = 0;
        int indexIn = -1;
        while (true) {
            indexIn = this.wordBoundary.indexIn(s, indexIn + 1);
            if (indexIn == -1) {
                break;
            }
            if (beginIndex == 0) {
                sb = new StringBuilder(s.length() + this.wordSeparator.length() * 4);
                sb.append(caseFormat.normalizeFirstWord(s.substring(beginIndex, indexIn)));
            }
            else {
                sb.append(caseFormat.normalizeWord(s.substring(beginIndex, indexIn)));
            }
            sb.append(caseFormat.wordSeparator);
            beginIndex = indexIn + this.wordSeparator.length();
        }
        if (beginIndex == 0) {
            return caseFormat.normalizeFirstWord(s);
        }
        return sb.append(caseFormat.normalizeWord(s.substring(beginIndex))).toString();
    }
    
    @Beta
    public Converter<String, String> converterTo(final CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }
    
    abstract String normalizeWord(final String p0);
    
    public final String to(final CaseFormat caseFormat, final String s) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(s);
        if (caseFormat == this) {
            return s;
        }
        return this.convert(caseFormat, s);
    }
    
    private static final class StringConverter extends Converter<String, String> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;
        
        StringConverter(final CaseFormat caseFormat, final CaseFormat caseFormat2) {
            this.sourceFormat = Preconditions.checkNotNull(caseFormat);
            this.targetFormat = Preconditions.checkNotNull(caseFormat2);
        }
        
        @Override
        protected String doBackward(final String s) {
            if (s == null) {
                return null;
            }
            return this.targetFormat.to(this.sourceFormat, s);
        }
        
        @Override
        protected String doForward(final String s) {
            if (s == null) {
                return null;
            }
            return this.sourceFormat.to(this.targetFormat, s);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof StringConverter) {
                final StringConverter stringConverter = (StringConverter)o;
                b2 = b;
                if (this.sourceFormat.equals(stringConverter.sourceFormat)) {
                    b2 = b;
                    if (this.targetFormat.equals(stringConverter.targetFormat)) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.sourceFormat));
            final String value2 = String.valueOf(String.valueOf(this.targetFormat));
            return new StringBuilder(value.length() + 14 + value2.length()).append(value).append(".converterTo(").append(value2).append(")").toString();
        }
    }
}
