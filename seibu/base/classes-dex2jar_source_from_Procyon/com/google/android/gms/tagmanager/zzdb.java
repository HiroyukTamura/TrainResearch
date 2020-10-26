// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.el;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ek;
import org.json.JSONException;
import java.util.Iterator;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;

final class zzdb
{
    private static Object zzG(final Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        }
        Object o = obj;
        if (obj instanceof JSONObject) {
            final JSONObject jsonObject = (JSONObject)obj;
            o = new HashMap<String, Object>();
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String s = keys.next();
                ((Map<String, Object>)o).put(s, zzG(jsonObject.get(s)));
            }
        }
        return o;
    }
    
    public static ek zzfo(final String s) throws JSONException {
        final zzbr zzI = zzgk.zzI(zzG(new JSONObject(s)));
        final el zzDz = ek.zzDz();
        for (int i = 0; i < zzI.zzlF.length; ++i) {
            zzDz.zzc(ei.zzDx().zzb(zzbg.zzhS.toString(), zzI.zzlF[i]).zzb(zzbg.zzhG.toString(), zzgk.zzfy(zzt.zzAG())).zzb(zzt.zzAH(), zzI.zzlG[i]).zzDy());
        }
        return zzDz.zzDB();
    }
}
