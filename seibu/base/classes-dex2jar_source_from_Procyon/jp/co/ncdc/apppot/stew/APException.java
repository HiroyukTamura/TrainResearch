// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

public class APException extends RuntimeException
{
    private static final long serialVersionUID = 5515129709315598805L;
    
    public APException() {
    }
    
    public APException(final String message) {
        super(message);
    }
    
    public APException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public APException(final Throwable cause) {
        super(cause);
    }
}
