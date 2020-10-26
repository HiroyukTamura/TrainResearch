// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.app;

import android.app.Notification$Builder;
import android.app.Notification;
import android.support.annotation.RestrictTo;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public interface NotificationBuilderWithBuilderAccessor
{
    Notification build();
    
    Notification$Builder getBuilder();
}
