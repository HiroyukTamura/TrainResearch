// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.regex.Matcher;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.regex.Pattern;

public final class zzo
{
    private static final Pattern zzaJU;
    private static final Pattern zzaJV;
    
    static {
        zzaJU = Pattern.compile("\\\\.");
        zzaJV = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }
    
    public static boolean zzc(final Object o, final Object obj) {
        final boolean b = false;
        boolean b2;
        if (o == null && obj == null) {
            b2 = true;
        }
        else {
            b2 = b;
            if (o != null) {
                b2 = b;
                if (obj != null) {
                    Label_0131: {
                        if (!(o instanceof JSONObject) || !(obj instanceof JSONObject)) {
                            break Label_0131;
                        }
                        final JSONObject jsonObject = (JSONObject)o;
                        final JSONObject jsonObject2 = (JSONObject)obj;
                        b2 = b;
                        if (jsonObject.length() != jsonObject2.length()) {
                            return b2;
                        }
                        final Iterator keys = jsonObject.keys();
                    Block_14_Outer:
                        while (true) {
                            if (!keys.hasNext()) {
                                return true;
                            }
                            final String s = keys.next();
                            b2 = b;
                            if (!jsonObject2.has(s)) {
                                return b2;
                            }
                            try {
                                if (!zzc(jsonObject.get(s), jsonObject2.get(s))) {
                                    return false;
                                }
                                continue Block_14_Outer;
                                // iftrue(Label_0211:, !o instanceof JSONArray || !obj instanceof JSONArray)
                                // iftrue(Label_0209:, n >= jsonArray.length())
                                while (true) {
                                    Block_13: {
                                        break Block_13;
                                        int n = 0;
                                        while (true) {
                                            Label_0171: {
                                                break Label_0171;
                                                try {
                                                    final JSONArray jsonArray;
                                                    final JSONArray jsonArray2;
                                                    final boolean zzc = zzc(jsonArray.get(n), jsonArray2.get(n));
                                                    b2 = b;
                                                    if (zzc) {
                                                        ++n;
                                                        break Label_0171;
                                                    }
                                                    return b2;
                                                    Label_0209: {
                                                        return true;
                                                    }
                                                    Label_0211:
                                                    return o.equals(obj);
                                                }
                                                catch (JSONException ex) {
                                                    return false;
                                                }
                                            }
                                            continue;
                                        }
                                    }
                                    final JSONArray jsonArray = (JSONArray)o;
                                    final JSONArray jsonArray2 = (JSONArray)obj;
                                    b2 = b;
                                    continue;
                                }
                            }
                            // iftrue(Label_0013:, jsonArray.length() != jsonArray2.length())
                            catch (JSONException ex2) {
                                return false;
                            }
                            break;
                        }
                    }
                }
            }
        }
        Label_0013: {
            return b2;
        }
    }
    
    public static String zzcK(final String input) {
        if (!TextUtils.isEmpty((CharSequence)input)) {
            final Matcher matcher = zzo.zzaJV.matcher(input);
            StringBuffer sb = null;
            while (matcher.find()) {
                StringBuffer sb2;
                if ((sb2 = sb) == null) {
                    sb2 = new StringBuffer();
                }
                switch (matcher.group().charAt(0)) {
                    default: {
                        sb = sb2;
                        continue;
                    }
                    case '\b': {
                        matcher.appendReplacement(sb2, "\\\\b");
                        sb = sb2;
                        continue;
                    }
                    case '\"': {
                        matcher.appendReplacement(sb2, "\\\\\\\"");
                        sb = sb2;
                        continue;
                    }
                    case '\\': {
                        matcher.appendReplacement(sb2, "\\\\\\\\");
                        sb = sb2;
                        continue;
                    }
                    case '/': {
                        matcher.appendReplacement(sb2, "\\\\/");
                        sb = sb2;
                        continue;
                    }
                    case '\f': {
                        matcher.appendReplacement(sb2, "\\\\f");
                        sb = sb2;
                        continue;
                    }
                    case '\n': {
                        matcher.appendReplacement(sb2, "\\\\n");
                        sb = sb2;
                        continue;
                    }
                    case '\r': {
                        matcher.appendReplacement(sb2, "\\\\r");
                        sb = sb2;
                        continue;
                    }
                    case '\t': {
                        matcher.appendReplacement(sb2, "\\\\t");
                        sb = sb2;
                        continue;
                    }
                }
            }
            if (sb != null) {
                matcher.appendTail(sb);
                return sb.toString();
            }
        }
        return input;
    }
}
