// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.util;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import java.io.Serializable;

public class Payload implements Serializable
{
    public static final int WHO_MODEL_RUNSTATUS = 4;
    public static final int WHO_NOTICATION_SETTINGS = 3;
    public static final int WHO_ROUTE_MAP = 2;
    public static final int WHO_TRAIN_POSITION = 1;
    Object content;
    final int from;
    
    public Payload(final int from, final Object content) {
        this.from = from;
        this.content = content;
    }
    
    public static boolean isValid(final Payload payload) {
        return payload != null && payload.getContent() != null;
    }
    
    public static Payload make(final int n, final Object o) {
        return new Payload(n, o);
    }
    
    public static <T> T peek(final Payload payload) {
        final Object content = payload.getContent();
        payload.setContent(null);
        return (T)content;
    }
    
    public Object getContent() {
        return this.content;
    }
    
    public int getFrom() {
        return this.from;
    }
    
    public void setContent(final Object content) {
        this.content = content;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Who {
    }
}
