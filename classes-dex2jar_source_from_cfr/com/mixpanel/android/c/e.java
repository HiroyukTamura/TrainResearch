/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.mixpanel.android.c;

import org.json.JSONObject;

public class e {
    public static String a(JSONObject jSONObject, String string2) {
        if (jSONObject.has(string2) && !jSONObject.isNull(string2)) {
            return jSONObject.getString(string2);
        }
        return null;
    }
}

