// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.annotations.Beta;

@Beta
public class DeadEvent
{
    private final Object event;
    private final Object source;
    
    public DeadEvent(final Object o, final Object o2) {
        this.source = Preconditions.checkNotNull(o);
        this.event = Preconditions.checkNotNull(o2);
    }
    
    public Object getEvent() {
        return this.event;
    }
    
    public Object getSource() {
        return this.source;
    }
}
