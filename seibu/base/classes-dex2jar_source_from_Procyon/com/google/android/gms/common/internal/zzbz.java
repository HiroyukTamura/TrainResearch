// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.content.Context;

public final class zzbz
{
    public static String zza(String attributeValue, final String s, final Context context, AttributeSet string, final boolean b, final boolean b2, final String s2) {
        Label_0118: {
            if (string != null) {
                break Label_0118;
            }
            attributeValue = null;
        Label_0099_Outer:
            while (true) {
                string = (AttributeSet)attributeValue;
                if (attributeValue == null) {
                    return (String)string;
                }
                string = (AttributeSet)attributeValue;
                if (!attributeValue.startsWith("@string/")) {
                    return (String)string;
                }
                final String substring = attributeValue.substring(8);
                final String packageName = context.getPackageName();
                string = (AttributeSet)new TypedValue();
                while (true) {
                    try {
                        context.getResources().getValue(new StringBuilder(String.valueOf(packageName).length() + 8 + String.valueOf(substring).length()).append(packageName).append(":string/").append(substring).toString(), (TypedValue)string, true);
                        if (((TypedValue)string).string != null) {
                            string = (AttributeSet)((TypedValue)string).string.toString();
                            return (String)string;
                        }
                        break Label_0118;
                        attributeValue = string.getAttributeValue(attributeValue, s);
                        continue Label_0099_Outer;
                    }
                    catch (Resources$NotFoundException ex) {
                        Log.w(s2, new StringBuilder(String.valueOf(s).length() + 30 + String.valueOf(attributeValue).length()).append("Could not find resource for ").append(s).append(": ").append(attributeValue).toString());
                        continue;
                    }
                    break;
                }
                break;
            }
        }
        final String value = String.valueOf(string);
        Log.w(s2, new StringBuilder(String.valueOf(s).length() + 28 + String.valueOf(value).length()).append("Resource ").append(s).append(" was not a string: ").append(value).toString());
        return attributeValue;
    }
}
