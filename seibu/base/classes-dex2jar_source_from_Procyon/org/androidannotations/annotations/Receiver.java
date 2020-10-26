// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD })
public @interface Receiver {
    String[] actions();
    
    String[] dataSchemes() default {};
    
    boolean local() default false;
    
    RegisterAt registerAt() default RegisterAt.OnCreateOnDestroy;
    
    @Retention(RetentionPolicy.CLASS)
    @Target({ ElementType.PARAMETER })
    public @interface Extra {
        String value() default "";
    }
    
    public enum RegisterAt
    {
        OnAttachOnDetach, 
        OnCreateOnDestroy, 
        OnResumeOnPause, 
        OnStartOnStop;
    }
}
