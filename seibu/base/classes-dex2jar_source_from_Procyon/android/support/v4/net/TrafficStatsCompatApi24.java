// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.net;

import java.net.SocketException;
import android.net.TrafficStats;
import java.net.DatagramSocket;
import android.support.annotation.RestrictTo;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(24)
@RequiresApi(24)
@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public class TrafficStatsCompatApi24
{
    public static void tagDatagramSocket(final DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }
    
    public static void untagDatagramSocket(final DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}
