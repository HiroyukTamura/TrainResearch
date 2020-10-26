// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.annotations.sharedpreferences;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE })
public @interface SharedPref {
    int mode() default 0;
    
    String name() default "";
    
    Scope value() default Scope.ACTIVITY;
    
    public enum Scope
    {
        ACTIVITY, 
        ACTIVITY_DEFAULT, 
        APPLICATION_DEFAULT, 
        UNIQUE;
    }
}
