package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.annotation.KeepForSdk;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
public class ViewUtils {
    private ViewUtils() {
    }

    @KeepForSdk
    public static String getXmlAttributeString(String str, String str2, Context context, AttributeSet attributeSet, boolean z, boolean z2, String str3) {
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z) {
            String substring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 8 + String.valueOf(substring).length());
                sb.append(packageName);
                sb.append(":string/");
                sb.append(substring);
                resources.getValue(sb.toString(), typedValue, true);
            } catch (Resources.NotFoundException unused) {
                Log.w(str3, C0681a.m314a(attributeValue.length() + C0681a.m336b(str2, 30), "Could not find resource for ", str2, ": ", attributeValue));
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                String valueOf = String.valueOf(typedValue);
                Log.w(str3, C0681a.m314a(valueOf.length() + C0681a.m336b(str2, 28), "Resource ", str2, " was not a string: ", valueOf));
            }
        }
        if (z2 && attributeValue == null) {
            StringBuilder sb2 = new StringBuilder(C0681a.m336b(str2, 33));
            sb2.append("Required XML attribute \"");
            sb2.append(str2);
            sb2.append("\" missing");
            Log.w(str3, sb2.toString());
        }
        return attributeValue;
    }
}
