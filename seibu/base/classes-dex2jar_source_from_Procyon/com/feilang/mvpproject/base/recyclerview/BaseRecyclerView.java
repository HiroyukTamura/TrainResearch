// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base.recyclerview;

import com.feilang.mvpproject.base.BaseView;

public interface BaseRecyclerView<T> extends BaseView<T>
{
    void notifyDataSourceChanged();
    
    void setNoMore(final boolean p0);
}
