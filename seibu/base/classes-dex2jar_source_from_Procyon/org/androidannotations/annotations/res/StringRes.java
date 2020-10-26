// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.annotations.res;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
public @interface StringRes {
    String resName() default "";
    
    int value() default -1;
}
