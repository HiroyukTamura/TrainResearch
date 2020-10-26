// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;
import com.google.android.gms.common.internal.zzbo;

public class zzaoc extends zzamh
{
    private static String zzain;
    private static String zzaio;
    private static zzaoc zzaip;
    
    static {
        zzaoc.zzain = "3";
        zzaoc.zzaio = "01VDIWEA?";
    }
    
    public zzaoc(final zzamj zzamj) {
        super(zzamj);
    }
    
    private static String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = new Long((int)obj);
        }
        if (obj instanceof Long) {
            if (Math.abs((long)obj) < 100L) {
                return String.valueOf(obj);
            }
            String s;
            if (String.valueOf(obj).charAt(0) == '-') {
                s = "-";
            }
            else {
                s = "";
            }
            final String value = String.valueOf(Math.abs((long)obj));
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(Math.round(Math.pow(10.0, value.length() - 1)));
            sb.append("...");
            sb.append(s);
            sb.append(Math.round(Math.pow(10.0, value.length()) - 1.0));
            return sb.toString();
        }
        else {
            if (obj instanceof Boolean) {
                return String.valueOf(obj);
            }
            if (obj instanceof Throwable) {
                return obj.getClass().getCanonicalName();
            }
            return "-";
        }
    }
    
    public static zzaoc zzlM() {
        return zzaoc.zzaip;
    }
    
    public final void zza(final zzanx zzanx, String o) {
        String string;
        if (zzanx != null) {
            string = zzanx.toString();
        }
        else {
            string = "no hit data";
        }
        o = String.valueOf(o);
        if (((String)o).length() != 0) {
            o = "Discarding hit. ".concat((String)o);
        }
        else {
            o = new String("Discarding hit. ");
        }
        this.zzd((String)o, string);
    }
    
    public final void zzb(int index, String s, Object zzkH, final Object o, final Object o2) {
        while (true) {
            final int n = 0;
            while (true) {
                Label_0217: {
                    while (true) {
                        Label_0214: {
                            synchronized (this) {
                                zzbo.zzu(s);
                                if (index >= 0) {
                                    break Label_0217;
                                }
                                index = n;
                                if (index >= zzaoc.zzaio.length()) {
                                    index = zzaoc.zzaio.length() - 1;
                                    char c;
                                    if (this.zzks().zzln()) {
                                        c = 'C';
                                    }
                                    else {
                                        c = 'c';
                                    }
                                    final String zzain = zzaoc.zzain;
                                    final char char1 = zzaoc.zzaio.charAt(index);
                                    final String version = zzami.VERSION;
                                    s = String.valueOf(zzamg.zzc((String)s, zzk(zzkH), zzk(o), zzk(o2)));
                                    zzkH = (s = new StringBuilder(String.valueOf(zzain).length() + 3 + String.valueOf(version).length() + String.valueOf(s).length()).append(zzain).append(char1).append(c).append(version).append(":").append((String)s).toString());
                                    if (((String)zzkH).length() > 1024) {
                                        s = ((String)zzkH).substring(0, 1024);
                                    }
                                    zzkH = this.zzkp().zzkH();
                                    if (zzkH != null) {
                                        ((zzaog)zzkH).zzlZ().zzbA((String)s);
                                    }
                                    return;
                                }
                                break Label_0214;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
    }
    
    public final void zze(final Map<String, String> map, String o) {
        String string;
        if (map != null) {
            final StringBuilder sb = new StringBuilder();
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            string = sb.toString();
        }
        else {
            string = "no hit data";
        }
        o = String.valueOf(o);
        if (((String)o).length() != 0) {
            o = "Discarding hit. ".concat((String)o);
        }
        else {
            o = new String("Discarding hit. ");
        }
        this.zzd((String)o, string);
    }
    
    @Override
    protected final void zzjD() {
        synchronized (zzaoc.class) {
            zzaoc.zzaip = this;
        }
    }
}
