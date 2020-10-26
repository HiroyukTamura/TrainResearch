// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.event;

import com.feilang.mvpproject.util.LogUtils;
import com.google.common.eventbus.EventBus;

public class CTCEventBus
{
    private static EventBus eventBus;
    
    static {
        CTCEventBus.eventBus = new EventBus();
    }
    
    private CTCEventBus() {
    }
    
    public static EventBus getInstance() {
        return CTCEventBus.eventBus;
    }
    
    public static void post(final Object o) {
        CTCEventBus.eventBus.post(o);
    }
    
    public static void register(final Object o) {
        CTCEventBus.eventBus.register(o);
    }
    
    public static void unregister(final Object o) {
        try {
            CTCEventBus.eventBus.unregister(o);
        }
        catch (IllegalArgumentException ex) {
            LogUtils.outputLog("CTCEventBus unregister failed, this: " + o.toString());
        }
    }
}
