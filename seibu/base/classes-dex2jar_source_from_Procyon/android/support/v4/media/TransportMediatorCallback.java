// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.media;

import android.view.KeyEvent;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(18)
@RequiresApi(18)
interface TransportMediatorCallback
{
    long getPlaybackPosition();
    
    void handleAudioFocusChange(final int p0);
    
    void handleKey(final KeyEvent p0);
    
    void playbackPositionUpdate(final long p0);
}
