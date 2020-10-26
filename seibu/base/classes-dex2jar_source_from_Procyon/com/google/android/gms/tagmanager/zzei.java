// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.net.Uri;

class zzei
{
    private static zzei zzbFF;
    private volatile String zzbDw;
    private volatile zza zzbFG;
    private volatile String zzbFH;
    private volatile String zzbFI;
    
    zzei() {
        this.zzbFG = zza.zzbFJ;
        this.zzbFH = null;
        this.zzbDw = null;
        this.zzbFI = null;
    }
    
    static zzei zzBD() {
        synchronized (zzei.class) {
            if (zzei.zzbFF == null) {
                zzei.zzbFF = new zzei();
            }
            return zzei.zzbFF;
        }
    }
    
    private static String zzfq(final String s) {
        return s.split("&")[0].split("=")[1];
    }
    
    final String getContainerId() {
        return this.zzbDw;
    }
    
    final zza zzBE() {
        return this.zzbFG;
    }
    
    final String zzBF() {
        return this.zzbFH;
    }
    
    final boolean zzr(final Uri original) {
        boolean b;
        String decode = null;
        String value;
        String concat;
        String value2;
        String value3;
        String concat2;
        String value4;
        String concat3;
        String value5;
        String concat4;
        Label_0066_Outer:Label_0128_Outer:
        while (true) {
            b = true;
            while (true) {
                Label_0305: {
                    Label_0182: {
                        while (true) {
                            synchronized (this) {
                                while (true) {
                                    while (true) {
                                        try {
                                            decode = URLDecoder.decode(original.toString(), "UTF-8");
                                            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                                                break Label_0182;
                                            }
                                            value = String.valueOf(decode);
                                            if (value.length() != 0) {
                                                concat = "Container preview url: ".concat(value);
                                                zzdj.v(concat);
                                                if (decode.matches(".*?&gtm_debug=x$")) {
                                                    this.zzbFG = zza.zzbFL;
                                                    this.zzbFI = original.getQuery().replace("&gtm_debug=x", "");
                                                    if (this.zzbFG == zza.zzbFK || this.zzbFG == zza.zzbFL) {
                                                        value2 = String.valueOf("/r?");
                                                        value3 = String.valueOf(this.zzbFI);
                                                        if (value3.length() == 0) {
                                                            break Label_0305;
                                                        }
                                                        concat2 = value2.concat(value3);
                                                        this.zzbFH = concat2;
                                                    }
                                                    this.zzbDw = zzfq(this.zzbFI);
                                                    return b;
                                                }
                                                break;
                                            }
                                        }
                                        catch (UnsupportedEncodingException ex) {
                                            b = false;
                                            return b;
                                        }
                                        concat = new String("Container preview url: ");
                                        continue Label_0066_Outer;
                                    }
                                }
                            }
                            this.zzbFG = zza.zzbFK;
                            continue Label_0128_Outer;
                        }
                    }
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        value4 = String.valueOf(decode);
                        if (value4.length() != 0) {
                            concat3 = "Invalid preview uri: ".concat(value4);
                        }
                        else {
                            concat3 = new String("Invalid preview uri: ");
                        }
                        zzdj.zzaT(concat3);
                        b = false;
                        return b;
                    }
                    if (zzfq(original.getQuery()).equals(this.zzbDw)) {
                        value5 = String.valueOf(this.zzbDw);
                        if (value5.length() != 0) {
                            concat4 = "Exit preview mode for container: ".concat(value5);
                        }
                        else {
                            concat4 = new String("Exit preview mode for container: ");
                        }
                        zzdj.v(concat4);
                        this.zzbFG = zza.zzbFJ;
                        this.zzbFH = null;
                        return b;
                    }
                    b = false;
                    return b;
                }
                concat2 = new String((String)original);
                continue;
            }
        }
    }
    
    enum zza
    {
        zzbFJ, 
        zzbFK, 
        zzbFL;
    }
}
