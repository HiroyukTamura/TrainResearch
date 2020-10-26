// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.datasource;

public abstract class ErrorTagDataCallWrapper<T> extends DataCallWrapper<T>
{
    public ErrorTagDataCallWrapper(final Object o, final DataNotifyEvent.ApiEventType apiEventType, final Object tag) {
        super(o, apiEventType);
        this.tag = tag;
    }
    
    public ErrorTagDataCallWrapper(final Object o, final DataNotifyEvent.ApiEventType apiEventType, final Object tag, final boolean b) {
        super(o, apiEventType, b);
        this.tag = tag;
    }
    
    public ErrorTagDataCallWrapper(final Object o, final DataNotifyEvent.ApiEventType apiEventType, final Object tag, final boolean b, final boolean b2) {
        super(o, apiEventType, b, b2);
        this.tag = tag;
    }
    
    public ErrorTagDataCallWrapper(final Object o, final DataNotifyEvent.ApiEventType apiEventType, final Object tag, final boolean b, final boolean b2, final Object... array) {
        super(o, apiEventType, b, b2, array);
        this.tag = tag;
    }
}
