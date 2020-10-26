// 
// Decompiled by Procyon v0.5.36
// 

package com.google.protobuf;

final class zzc
{
    private static Class<?> zzcrO;
    
    static {
        zzc.zzcrO = zzLq();
    }
    
    private static Class<?> zzLq() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    public static zzd zzLr() {
        if (zzc.zzcrO != null) {
            try {
                return (zzd)zzc.zzcrO.getMethod("getEmptyRegistry", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            }
            catch (Exception ex) {}
        }
        return zzd.zzcrR;
    }
}
