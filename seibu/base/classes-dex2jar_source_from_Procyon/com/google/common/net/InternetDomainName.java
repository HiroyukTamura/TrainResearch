// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.net;

import javax.annotation.Nullable;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import java.util.List;
import com.google.common.base.Preconditions;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.base.Splitter;
import com.google.common.base.Joiner;
import com.google.common.base.CharMatcher;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class InternetDomainName
{
    private static final CharMatcher DASH_MATCHER;
    private static final CharMatcher DOTS_MATCHER;
    private static final Joiner DOT_JOINER;
    private static final String DOT_REGEX = "\\.";
    private static final Splitter DOT_SPLITTER;
    private static final int MAX_DOMAIN_PART_LENGTH = 63;
    private static final int MAX_LENGTH = 253;
    private static final int MAX_PARTS = 127;
    private static final int NO_PUBLIC_SUFFIX_FOUND = -1;
    private static final CharMatcher PART_CHAR_MATCHER;
    private final String name;
    private final ImmutableList<String> parts;
    private final int publicSuffixIndex;
    
    static {
        DOTS_MATCHER = CharMatcher.anyOf(".\u3002\uff0e\uff61");
        DOT_SPLITTER = Splitter.on('.');
        DOT_JOINER = Joiner.on('.');
        DASH_MATCHER = CharMatcher.anyOf("-_");
        PART_CHAR_MATCHER = CharMatcher.JAVA_LETTER_OR_DIGIT.or(InternetDomainName.DASH_MATCHER);
    }
    
    InternetDomainName(String name) {
        final String s = name = Ascii.toLowerCase(InternetDomainName.DOTS_MATCHER.replaceFrom(name, (char)46));
        if (s.endsWith(".")) {
            name = s.substring(0, s.length() - 1);
        }
        Preconditions.checkArgument(name.length() <= 253, "Domain name too long: '%s':", name);
        this.name = name;
        this.parts = ImmutableList.copyOf((Iterable<? extends String>)InternetDomainName.DOT_SPLITTER.split(name));
        Preconditions.checkArgument(this.parts.size() <= 127, "Domain has too many parts: '%s'", name);
        Preconditions.checkArgument(validateSyntax(this.parts), "Not a valid domain name: '%s'", name);
        this.publicSuffixIndex = this.findPublicSuffix();
    }
    
    private InternetDomainName ancestor(final int n) {
        return from(InternetDomainName.DOT_JOINER.join(this.parts.subList(n, this.parts.size())));
    }
    
    private int findPublicSuffix() {
        final int size = this.parts.size();
        int i = 0;
        while (i < size) {
            final String join = InternetDomainName.DOT_JOINER.join(this.parts.subList(i, size));
            if (!PublicSuffixPatterns.EXACT.containsKey(join)) {
                if (PublicSuffixPatterns.EXCLUDED.containsKey(join)) {
                    return i + 1;
                }
                if (!matchesWildcardPublicSuffix(join)) {
                    ++i;
                    continue;
                }
            }
            return i;
        }
        return -1;
    }
    
    public static InternetDomainName from(final String s) {
        return new InternetDomainName(Preconditions.checkNotNull(s));
    }
    
    public static boolean isValid(final String s) {
        try {
            from(s);
            return true;
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
    }
    
    private static boolean matchesWildcardPublicSuffix(final String s) {
        final String[] split = s.split("\\.", 2);
        return split.length == 2 && PublicSuffixPatterns.UNDER.containsKey(split[1]);
    }
    
    private static boolean validatePart(final String s, final boolean b) {
        return s.length() >= 1 && s.length() <= 63 && InternetDomainName.PART_CHAR_MATCHER.matchesAllOf(CharMatcher.ASCII.retainFrom(s)) && !InternetDomainName.DASH_MATCHER.matches(s.charAt(0)) && !InternetDomainName.DASH_MATCHER.matches(s.charAt(s.length() - 1)) && (!b || !CharMatcher.DIGIT.matches(s.charAt(0)));
    }
    
    private static boolean validateSyntax(final List<String> list) {
        final int n = list.size() - 1;
        if (!validatePart(list.get(n), true)) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (!validatePart(list.get(i), false)) {
                return false;
            }
        }
        return true;
    }
    
    public InternetDomainName child(String value) {
        value = String.valueOf(String.valueOf(Preconditions.checkNotNull(value)));
        final String value2 = String.valueOf(String.valueOf(this.name));
        return from(new StringBuilder(value.length() + 1 + value2.length()).append(value).append(".").append(value2).toString());
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || (o instanceof InternetDomainName && this.name.equals(((InternetDomainName)o).name));
    }
    
    public boolean hasParent() {
        return this.parts.size() > 1;
    }
    
    public boolean hasPublicSuffix() {
        return this.publicSuffixIndex != -1;
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public boolean isPublicSuffix() {
        return this.publicSuffixIndex == 0;
    }
    
    public boolean isTopPrivateDomain() {
        return this.publicSuffixIndex == 1;
    }
    
    public boolean isUnderPublicSuffix() {
        return this.publicSuffixIndex > 0;
    }
    
    public InternetDomainName parent() {
        Preconditions.checkState(this.hasParent(), "Domain '%s' has no parent", this.name);
        return this.ancestor(1);
    }
    
    public ImmutableList<String> parts() {
        return this.parts;
    }
    
    public InternetDomainName publicSuffix() {
        if (this.hasPublicSuffix()) {
            return this.ancestor(this.publicSuffixIndex);
        }
        return null;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public InternetDomainName topPrivateDomain() {
        if (this.isTopPrivateDomain()) {
            return this;
        }
        Preconditions.checkState(this.isUnderPublicSuffix(), "Not under a public suffix: %s", this.name);
        return this.ancestor(this.publicSuffixIndex - 1);
    }
}
