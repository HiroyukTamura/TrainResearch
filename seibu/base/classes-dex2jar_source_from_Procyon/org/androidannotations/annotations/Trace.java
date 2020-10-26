// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.annotations;

import org.androidannotations.api.KotlinOpen;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD })
@KotlinOpen
public @interface Trace {
    public static final String DEFAULT_TAG = "NO_TAG";
    
    int level() default 4;
    
    String tag() default "NO_TAG";
}
