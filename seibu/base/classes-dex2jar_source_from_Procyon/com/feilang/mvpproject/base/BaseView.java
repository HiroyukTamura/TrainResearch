// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import android.content.Context;

public interface BaseView<T> extends View
{
    Context getContext();
    
    void setPresenter(final T p0);
}
