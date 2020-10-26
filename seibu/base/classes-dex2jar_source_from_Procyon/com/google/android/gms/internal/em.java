// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class em
{
    private final List<ei> zzbLJ;
    private final List<ei> zzbLK;
    private final List<String> zzbLL;
    private final List<String> zzbLM;
    private final List<String> zzbLN;
    private final List<String> zzbLO;
    private final List<ei> zzbLb;
    private final List<ei> zzbLc;
    private final List<ei> zzbLd;
    private final List<ei> zzbLe;
    
    private em(final List<ei> list, final List<ei> list2, final List<ei> list3, final List<ei> list4, final List<ei> list5, final List<ei> list6, final List<String> list7, final List<String> list8, final List<String> list9, final List<String> list10) {
        this.zzbLb = Collections.unmodifiableList((List<? extends ei>)list);
        this.zzbLc = Collections.unmodifiableList((List<? extends ei>)list2);
        this.zzbLd = Collections.unmodifiableList((List<? extends ei>)list3);
        this.zzbLe = Collections.unmodifiableList((List<? extends ei>)list4);
        this.zzbLJ = Collections.unmodifiableList((List<? extends ei>)list5);
        this.zzbLK = Collections.unmodifiableList((List<? extends ei>)list6);
        this.zzbLL = Collections.unmodifiableList((List<? extends String>)list7);
        this.zzbLM = Collections.unmodifiableList((List<? extends String>)list8);
        this.zzbLN = Collections.unmodifiableList((List<? extends String>)list9);
        this.zzbLO = Collections.unmodifiableList((List<? extends String>)list10);
    }
    
    @Override
    public final String toString() {
        final String value = String.valueOf(this.zzbLb);
        final String value2 = String.valueOf(this.zzbLc);
        final String value3 = String.valueOf(this.zzbLd);
        final String value4 = String.valueOf(this.zzbLe);
        final String value5 = String.valueOf(this.zzbLJ);
        final String value6 = String.valueOf(this.zzbLK);
        return new StringBuilder(String.valueOf(value).length() + 102 + String.valueOf(value2).length() + String.valueOf(value3).length() + String.valueOf(value4).length() + String.valueOf(value5).length() + String.valueOf(value6).length()).append("Positive predicates: ").append(value).append("  Negative predicates: ").append(value2).append("  Add tags: ").append(value3).append("  Remove tags: ").append(value4).append("  Add macros: ").append(value5).append("  Remove macros: ").append(value6).toString();
    }
    
    public final List<ei> zzDC() {
        return this.zzbLJ;
    }
    
    public final List<ei> zzDD() {
        return this.zzbLK;
    }
    
    public final List<ei> zzDb() {
        return this.zzbLb;
    }
    
    public final List<ei> zzDc() {
        return this.zzbLc;
    }
    
    public final List<ei> zzDd() {
        return this.zzbLd;
    }
    
    public final List<ei> zzDe() {
        return this.zzbLe;
    }
}
