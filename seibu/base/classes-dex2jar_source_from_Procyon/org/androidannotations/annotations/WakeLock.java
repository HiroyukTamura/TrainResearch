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
public @interface WakeLock {
    public static final String DEFAULT_TAG = "NO_TAG";
    
    Flag[] flags() default {};
    
    Level level() default Level.PARTIAL_WAKE_LOCK;
    
    String tag() default "NO_TAG";
    
    public enum Flag
    {
        ACQUIRE_CAUSES_WAKEUP, 
        ON_AFTER_RELEASE;
    }
    
    public enum Level
    {
        FULL_WAKE_LOCK, 
        PARTIAL_WAKE_LOCK, 
        SCREEN_BRIGHT_WAKE_LOCK, 
        SCREEN_DIM_WAKE_LOCK;
    }
}
