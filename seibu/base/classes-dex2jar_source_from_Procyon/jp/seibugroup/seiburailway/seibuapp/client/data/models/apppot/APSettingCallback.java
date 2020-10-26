// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot;

import java.util.List;

public interface APSettingCallback
{
    public interface Common
    {
        void onFailure();
        
        void onSuccess();
    }
    
    public interface Select<T>
    {
        void onFailure();
        
        void onSuccess(final List<T> p0);
    }
}
