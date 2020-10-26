// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Collection;
import com.google.common.base.Preconditions;
import java.util.concurrent.CopyOnWriteArrayList;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.support.v7.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<VH extends ViewHolder, T> extends Adapter<VH>
{
    protected WeakReference<Context> mContext;
    protected CopyOnWriteArrayList<T> mDatas;
    protected OnItemClickListener<T> mOnItemClickListener;
    
    public BaseRecyclerViewAdapter(final Context referent) {
        this.mDatas = new CopyOnWriteArrayList<T>();
        this.mContext = new WeakReference<Context>(referent);
    }
    
    public BaseRecyclerViewAdapter(final Context referent, final CopyOnWriteArrayList<T> list) {
        this.mDatas = new CopyOnWriteArrayList<T>();
        this.mContext = new WeakReference<Context>(referent);
        this.mDatas = new CopyOnWriteArrayList<T>((Collection<? extends T>)Preconditions.checkNotNull(list));
    }
    
    public void addDataSource(final List<T> list) {
        this.mDatas.addAll(Preconditions.checkNotNull((Collection<? extends T>)list));
    }
    
    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }
    
    public View getItemView(final int n, final ViewGroup viewGroup) {
        return LayoutInflater.from((Context)this.mContext.get()).inflate(n, viewGroup, false);
    }
    
    @Override
    public abstract void onBindViewHolder(final VH p0, final int p1);
    
    @Override
    public abstract VH onCreateViewHolder(final ViewGroup p0, final int p1);
    
    public void setDataSource(final List list) {
        try {
            this.mDatas = new CopyOnWriteArrayList<T>(Preconditions.checkNotNull(list));
        }
        catch (NullPointerException ex) {
            this.mDatas = new CopyOnWriteArrayList<T>();
        }
    }
    
    public void setOnItemClickListener(final OnItemClickListener<T> mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    
    public interface OnItemClickListener<T>
    {
        void onItemClick(final View p0, final int p1, final T p2);
    }
}
