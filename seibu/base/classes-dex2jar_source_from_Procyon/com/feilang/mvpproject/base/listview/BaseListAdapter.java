// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base.listview;

import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.widget.BaseAdapter;

public class BaseListAdapter<E> extends BaseAdapter
{
    private List<E> mDataSource;
    private BaseListView mViewGenerator;
    
    public BaseListAdapter(final BaseListView mViewGenerator) {
        this.mViewGenerator = mViewGenerator;
    }
    
    public BaseListAdapter(final BaseListView mViewGenerator, final List<E> mDataSource) {
        this.mViewGenerator = mViewGenerator;
        this.mDataSource = mDataSource;
    }
    
    public int getCount() {
        if (this.mDataSource == null) {
            return 0;
        }
        return this.mDataSource.size();
    }
    
    public Object getItem(final int n) {
        if (n >= 0 && n < this.mDataSource.size()) {
            return this.mDataSource.get(n);
        }
        return null;
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        return this.mViewGenerator.generateListItem(this.getItem(n), n, view, viewGroup);
    }
    
    public void setDataSource(final List<E> mDataSource) {
        this.mDataSource = mDataSource;
    }
}
