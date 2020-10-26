// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzem extends zzga
{
    private static final String ID;
    private static final String zzbFR;
    
    static {
        ID = zzbf.zzev.toString();
        zzbFR = zzbg.zzhP.toString();
    }
    
    public zzem() {
        super(zzem.ID);
    }
    
    @Override
    protected final boolean zza(final String input, final String regex, final Map<String, com.google.android.gms.internal.zzbr> map) {
        while (true) {
            Label_0046: {
                if (!zzgk.zzf(map.get(zzem.zzbFR))) {
                    break Label_0046;
                }
                final int flags = 66;
                try {
                    return Pattern.compile(regex, flags).matcher(input).find();
                }
                catch (PatternSyntaxException ex) {
                    return false;
                }
            }
            final int flags = 64;
            continue;
        }
    }
}
