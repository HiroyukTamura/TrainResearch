// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.rest.spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD })
public @interface Options {
    String value();
}
