// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

public interface Connection
{
    @Nullable
    Handshake handshake();
    
    Protocol protocol();
    
    Route route();
    
    Socket socket();
}
