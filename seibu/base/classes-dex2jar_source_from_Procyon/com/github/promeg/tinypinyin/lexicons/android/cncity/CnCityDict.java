// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.tinypinyin.lexicons.android.cncity;

import android.content.Context;
import com.github.promeg.tinypinyin.android.asset.lexicons.AndroidAssetDict;

public final class CnCityDict extends AndroidAssetDict
{
    static volatile CnCityDict singleton;
    
    static {
        CnCityDict.singleton = null;
    }
    
    public CnCityDict(final Context context) {
        super(context);
    }
    
    public static CnCityDict getInstance(final Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        Label_0043: {
            if (CnCityDict.singleton != null) {
                break Label_0043;
            }
            synchronized (CnCityDict.class) {
                if (CnCityDict.singleton == null) {
                    CnCityDict.singleton = new CnCityDict(context);
                }
                return CnCityDict.singleton;
            }
        }
    }
    
    @Override
    protected String assetFileName() {
        return "cncity.txt";
    }
}
