// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.SOURCE)
public @interface FlexWrap {
    public static final int NOWRAP = 0;
    public static final int WRAP = 1;
    public static final int WRAP_REVERSE = 2;
}
