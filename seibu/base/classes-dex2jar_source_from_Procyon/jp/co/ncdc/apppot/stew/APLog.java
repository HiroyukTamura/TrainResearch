// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.log.Logger;

public class APLog
{
    public static final int LOG_LEVEL_ERROR = 1;
    public static final int LOG_LEVEL_MONITOR = 0;
    private static APEntityManager aem;
    
    static {
        APLog.aem = APEntityManager.getInstance();
    }
    
    public static final void error(final String s) {
        APLog.aem.checkDoneCreateAppDB();
        APLog.aem.addLog(1, s);
        Logger.e("error", s);
    }
    
    public static final void monitor(final String s) {
        APLog.aem.checkDoneCreateAppDB();
        APLog.aem.addLog(0, s);
        Logger.d("monitor", s);
    }
}
