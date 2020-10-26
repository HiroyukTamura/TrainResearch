// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import android.util.Log;
import java.util.Collection;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import android.database.Cursor;

public class APDBResponse implements APResponse
{
    private static final String TAG = "APDBResponse";
    private Cursor c;
    private String desctiption;
    private AJSONObject mJsonObject;
    private boolean mResultFlag;
    private List<APObject> mResultList;
    private APSearchResult mSearchResult;
    private int rowCount;
    
    public APDBResponse() {
        this.mResultFlag = false;
        this.mResultList = null;
        this.desctiption = null;
        this.rowCount = 0;
        this.mSearchResult = null;
        this.mJsonObject = new AJSONObject();
    }
    
    APDBResponse(final Cursor c, final int rowCount) {
        this.mResultFlag = false;
        this.mResultList = null;
        this.desctiption = null;
        this.rowCount = 0;
        this.mSearchResult = null;
        this.mJsonObject = new AJSONObject();
        this.c = c;
        this.rowCount = rowCount;
    }
    
    public APDBResponse(final boolean mResultFlag) {
        this.mResultFlag = false;
        this.mResultList = null;
        this.desctiption = null;
        this.rowCount = 0;
        this.mSearchResult = null;
        this.mJsonObject = new AJSONObject();
        this.mResultFlag = mResultFlag;
        if (mResultFlag) {
            this.mJsonObject.put("status", "OK");
        }
    }
    
    private APObject newAPObject(final Class<?> clazz) {
        try {
            return (APObject)clazz.newInstance();
        }
        catch (Exception ex) {
            Logger.e("APDBResponse", "newAPObject:" + ex.getLocalizedMessage());
            return null;
        }
    }
    
    void addResultList(final List<APObject> list) {
        if (this.mResultList == null) {
            this.mResultList = new ArrayList<APObject>();
        }
        this.mResultList.addAll(list);
    }
    
    @Override
    public String getDescription() {
        return this.desctiption;
    }
    
    @Override
    public Object getResponseData() {
        return this.mJsonObject;
    }
    
    @Override
    public List<APObject> getResultForSavedObject(final Class<?> clazz) {
        return this.mResultList;
    }
    
    @Override
    public APSearchResult getResultForSearchObject(final Class<?> clazz) {
        if (this.mSearchResult != null) {
            return this.mSearchResult;
        }
        this.mSearchResult = new APSearchResult();
        this.c.moveToFirst();
        this.mResultList = new ArrayList<APObject>();
        for (int i = 0; i < this.c.getCount(); ++i) {
            final APObject apObject = this.newAPObject(clazz);
            final List<String> encryptedProperties = apObject.getEncryptedProperties();
            for (int j = 0; j < this.c.getColumnCount(); ++j) {
                final String columnName = this.c.getColumnName(j);
                final String string = this.c.getString(j);
                Logger.v("APDBResponse", "key=" + columnName + " value=" + string);
                if (string != null) {
                    String decrypt = string;
                    String str = string;
                    try {
                        if (encryptedProperties.contains(columnName)) {
                            str = string;
                            decrypt = APEntityManager.getInstance().decrypt(string);
                        }
                        str = decrypt;
                        APObject.setValueFromLocal(apObject, clazz.getField(columnName), decrypt);
                    }
                    catch (IllegalArgumentException ex) {
                        Log.e("APDBResponse", "IllegalArgumentException:name=" + columnName + ", value=" + str + ", " + ex.getLocalizedMessage());
                    }
                    catch (NoSuchFieldException ex2) {
                        Log.e("APDBResponse", "NoSuchFieldException:name=" + columnName + ", " + ex2.getLocalizedMessage());
                    }
                }
            }
            this.mSearchResult.add(apObject);
            this.c.moveToNext();
        }
        this.c.close();
        this.mResultFlag = true;
        this.mSearchResult.counter = this.rowCount;
        Logger.d("APDBResponse", "[getResultForSearchObject]:" + clazz.getSimpleName() + ":rowCount=" + this.rowCount);
        return this.mSearchResult;
    }
    
    @Override
    public boolean isOK() {
        return this.mResultFlag;
    }
}
