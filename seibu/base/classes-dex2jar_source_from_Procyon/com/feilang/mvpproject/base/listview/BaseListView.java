// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base.listview;

import android.view.ViewGroup;
import android.view.View;
import com.feilang.mvpproject.base.BaseView;

public interface BaseListView<T, E> extends BaseView<T>
{
    android.view.View generateListItem(final E p0, final int p1, final android.view.View p2, final ViewGroup p3);
}
