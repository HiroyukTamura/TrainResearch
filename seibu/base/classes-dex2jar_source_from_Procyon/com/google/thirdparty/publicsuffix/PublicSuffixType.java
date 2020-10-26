// 
// Decompiled by Procyon v0.5.36
// 

package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
enum PublicSuffixType
{
    ICANN('!', '?'), 
    PRIVATE(':', ',');
    
    private final char innerNodeCode;
    private final char leafNodeCode;
    
    private PublicSuffixType(final char innerNodeCode, final char leafNodeCode) {
        this.innerNodeCode = innerNodeCode;
        this.leafNodeCode = leafNodeCode;
    }
    
    static PublicSuffixType fromCode(final char c) {
        final PublicSuffixType[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final PublicSuffixType publicSuffixType = values[i];
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException(new StringBuilder(38).append("No enum corresponding to given code: ").append(c).toString());
    }
    
    static PublicSuffixType fromIsPrivate(final boolean b) {
        if (b) {
            return PublicSuffixType.PRIVATE;
        }
        return PublicSuffixType.ICANN;
    }
    
    char getInnerNodeCode() {
        return this.innerNodeCode;
    }
    
    char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
