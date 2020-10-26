// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v7.app;

import android.app.Notification$BigTextStyle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(16)
@RequiresApi(16)
class NotificationCompatImplJellybean
{
    public static void addBigTextStyle(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final CharSequence charSequence) {
        new Notification$BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).bigText(charSequence);
    }
}
