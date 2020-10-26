// 
// Decompiled by Procyon v0.5.36
// 

package org.greenrobot.greendao.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface JoinProperty {
    String name();
    
    String referencedName();
}
