// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import java.io.UnsupportedEncodingException;
import jp.co.ncdc.apppot.stew.log.Logger;
import java.util.concurrent.CountDownLatch;

public abstract class APSuperResponseHandler
{
    private CountDownLatch countDownLatch;
    private boolean useSynchronousMode;
    
    public APSuperResponseHandler() {
        this.countDownLatch = null;
    }
    
    protected void checkOutOfService(final String s, final String str, final int n) throws APOutOfServiceException, UnsupportedEncodingException {
        if (s != null && n == 200) {
            Logger.v("[checkOutOfService]", "Check OutOfService.CheckString=" + s + ". bodyString3=" + str);
            if (str.contains(s)) {
                throw new APOutOfServiceException();
            }
        }
    }
    
    protected void checkTokenValid(final String s) {
        if (s != null && (s.contains("Token does not exist") || s.contains("The token is expired.") || s.contains("User does not exist"))) {
            APService.getInstance().deleteTokenInfo();
        }
    }
    
    protected void countDown() {
        if (this.countDownLatch != null && this.countDownLatch.getCount() != 0L) {
            this.countDownLatch.countDown();
            Logger.v("[countDown]", "call countDown:" + this.countDownLatch.getCount());
        }
    }
    
    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }
    
    protected void ifNeedWait() {
        if (this.countDownLatch == null || this.countDownLatch.getCount() == 0L) {
            return;
        }
        try {
            this.countDownLatch.await();
        }
        catch (InterruptedException ex) {
            Logger.e("[ifNeedWait]", ex);
        }
    }
    
    void setCountDownLatch(final int count) {
        this.countDownLatch = new CountDownLatch(count);
    }
    
    public void setUseSynchronousMode(final boolean useSynchronousMode) {
        this.useSynchronousMode = useSynchronousMode;
    }
}
