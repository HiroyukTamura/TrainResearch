// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base.annotations;

import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Stage {
    DataNotifyEvent.ApiEventType RestEvent() default DataNotifyEvent.ApiEventType.API_NONE;
    
    int order() default 0;
    
    Type value() default Type.BG;
    
    public enum Type
    {
        AC, 
        BG, 
        UI;
    }
}
