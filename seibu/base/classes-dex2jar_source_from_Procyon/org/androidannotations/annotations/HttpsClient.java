// 
// Decompiled by Procyon v0.5.36
// 

package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Deprecated
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
public @interface HttpsClient {
    public static final String DEFAULT_PASSWD = "changeit";
    
    boolean allowAllHostnames() default true;
    
    int keyStore() default -1;
    
    String keyStorePwd() default "changeit";
    
    String keyStoreResName() default "";
    
    int trustStore() default -1;
    
    String trustStorePwd() default "changeit";
    
    String trustStoreResName() default "";
}
