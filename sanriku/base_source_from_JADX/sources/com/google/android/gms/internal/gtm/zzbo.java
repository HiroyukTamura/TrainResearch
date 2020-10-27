package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.internal.gtm.zzbn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

class zzbo<T extends zzbn> extends zzam {
    private zzbp<T> zzyn;

    public zzbo(zzap zzap, zzbp<T> zzbp) {
        super(zzap);
        this.zzyn = zzbp;
    }

    private final T zza(XmlResourceParser xmlResourceParser) {
        int eventType;
        String trim;
        String str;
        try {
            xmlResourceParser.next();
            eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.NAME);
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim2)) {
                            this.zzyn.zzb(attributeValue, trim2);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.NAME);
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim3 != null) {
                            this.zzyn.zzc(attributeValue2, trim3);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.NAME);
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.zzyn.zza(attributeValue3, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                e = e;
                                str = "Error parsing bool configuration value";
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.NAME);
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.zzyn.zzb(attributeValue4, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                e = e2;
                                str = "Error parsing int configuration value";
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            zze("Error parsing tracker configuration file", e3);
        }
        return this.zzyn.zzel();
        zzc(str, trim, e);
        eventType = xmlResourceParser.next();
    }

    public T zzq(int i) {
        try {
            return zza(zzcm().zzdc().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
