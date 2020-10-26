// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.res.Resources$NotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.text.TextUtils;
import android.content.res.XmlResourceParser;

class zzani<T extends zzanh> extends zzamg
{
    private zzanj<T> zzagT;
    
    public zzani(final zzamj zzamj, final zzanj<T> zzagT) {
        super(zzamj);
        this.zzagT = zzagT;
    }
    
    private final T zza(final XmlResourceParser xmlResourceParser) {
        while (true) {
            while (true) {
                String lowerCase = null;
                try {
                    xmlResourceParser.next();
                    for (int i = xmlResourceParser.getEventType(); i != 1; i = xmlResourceParser.next()) {
                        if (xmlResourceParser.getEventType() == 2) {
                            lowerCase = xmlResourceParser.getName().toLowerCase();
                            if (lowerCase.equals("screenname")) {
                                final String attributeValue = xmlResourceParser.getAttributeValue((String)null, "name");
                                final String trim = xmlResourceParser.nextText().trim();
                                if (!TextUtils.isEmpty((CharSequence)attributeValue) && !TextUtils.isEmpty((CharSequence)trim)) {
                                    this.zzagT.zzl(attributeValue, trim);
                                }
                            }
                            else {
                                if (!lowerCase.equals("string")) {
                                    goto Label_0190;
                                }
                                final String attributeValue2 = xmlResourceParser.getAttributeValue((String)null, "name");
                                final String trim2 = xmlResourceParser.nextText().trim();
                                if (!TextUtils.isEmpty((CharSequence)attributeValue2) && trim2 != null) {
                                    this.zzagT.zzm(attributeValue2, trim2);
                                }
                            }
                        }
                    }
                    goto Label_0180;
                }
                catch (XmlPullParserException ex) {
                    this.zze("Error parsing tracker configuration file", ex);
                }
                catch (IOException ex2) {
                    this.zze("Error parsing tracker configuration file", ex2);
                    goto Label_0180;
                }
                try {
                    final String s;
                    final String s2;
                    this.zzagT.zze(s, Boolean.parseBoolean(s2));
                    continue;
                }
                catch (NumberFormatException ex4) {}
                if (!lowerCase.equals("integer")) {
                    continue;
                }
                final String attributeValue3 = xmlResourceParser.getAttributeValue((String)null, "name");
                final String trim3 = xmlResourceParser.nextText().trim();
                if (!TextUtils.isEmpty((CharSequence)attributeValue3) && !TextUtils.isEmpty((CharSequence)trim3)) {
                    try {
                        this.zzagT.zzd(attributeValue3, Integer.parseInt(trim3));
                        continue;
                    }
                    catch (NumberFormatException ex3) {
                        this.zzc("Error parsing int configuration value", trim3, ex3);
                        continue;
                    }
                    continue;
                }
                continue;
            }
        }
    }
    
    public final T zzP(final int n) {
        try {
            return this.zza(this.zzkp().zzkE().getResources().getXml(n));
        }
        catch (Resources$NotFoundException ex) {
            this.zzd("inflate() called with unknown resourceId", ex);
            return null;
        }
    }
}
