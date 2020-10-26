// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.datasource;

public interface DataSource
{
    public interface DataCallback<T>
    {
        void onDataFailed();
        
        void onDataSuccess(final T p0);
    }
    
    public interface ExcludeCallback<T> extends DataCallback<T>
    {
        String identifier();
    }
    
    public interface RepoCallback<T>
    {
        void onDataFailed();
        
        void onDataSuccess(final T p0);
    }
}
