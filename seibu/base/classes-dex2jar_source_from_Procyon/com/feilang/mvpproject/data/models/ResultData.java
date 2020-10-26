// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.models;

public class ResultData
{
    private Object[] data;
    
    public static ResultData createNew(final Object... data) {
        final ResultData resultData = new ResultData();
        resultData.setData(data);
        return resultData;
    }
    
    public Object[] getData() {
        return this.data;
    }
    
    public void setData(final Object[] data) {
        this.data = data;
    }
}
