// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.StringUtils;
import java.util.Collection;
import jp.co.ncdc.apppot.stew.dto.APMessageQueue;
import jp.co.ncdc.apppot.stew.utils.DBUtils;
import jp.co.ncdc.apppot.stew.dto.APLogging;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.UUID;
import org.json.JSONException;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.SharedPreferences;
import jp.co.ncdc.apppot.stew.utils.AES;
import jp.co.ncdc.apppot.stew.json.AJSONArray;
import java.util.Iterator;
import org.json.JSONArray;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import jp.co.ncdc.apppot.stew.utils.DateTimeUtils;
import java.util.Date;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.utils.APObjectUtils;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import android.content.Context;
import java.util.Map;
import java.util.HashMap;

public class APEntityManager
{
    private static final String TAG = "APEntityManager";
    private static String _encryptKey;
    private static APEntityManager _instance;
    static HashMap<String, String> _serverDBColumnTypeConf;
    private Map<String, Class<?>> mAPClassMap;
    private Context mContext;
    private APSQLiteOpenHelper mDatabaseHelper;
    private APHttpClient mHttpClient;
    private APServerInfo mServerInfo;
    private APService mService;
    
    static {
        APEntityManager._instance = null;
        APEntityManager._encryptKey = null;
    }
    
    public APEntityManager() {
        this.mHttpClient = null;
        this.mContext = null;
        this.mServerInfo = null;
        this.mDatabaseHelper = null;
        this.mAPClassMap = new HashMap<String, Class<?>>();
        this.mService = APService.getInstance();
    }
    
    private static AJSONObject convertAPObjectToJson(final APObject obj) {
        final AJSONObject ajsonObject = new AJSONObject();
        final Field[] fields = obj.getClass().getFields();
        for (int i = 0; i < fields.length; ++i) {
            final String name = fields[i].getName();
            if (!APObjectUtils.isLocalColumn(name) && !APObjectUtils.isExceptColumn(name)) {
                Object value = null;
                Label_0145: {
                    try {
                        value = fields[i].get(obj);
                        if (value != null) {
                            break Label_0145;
                        }
                        Logger.d("APEntityManager", "[convertAPObjectToJson]:fieldName " + name + "'s Data is null.");
                    }
                    catch (Exception ex) {
                        Logger.e("APEntityManager", "fieldName=" + name + "," + ex.getLocalizedMessage());
                    }
                    continue;
                }
                final String simpleName = fields[i].getType().getSimpleName();
                if ("Date".equals(simpleName)) {
                    ajsonObject.put(name, DateTimeUtils.convertToUnixDate((Date)value).getTime());
                }
                else if ("ScopeType".equals(simpleName)) {
                    ajsonObject.put(name, APObject.ScopeType.getValue(value.toString()));
                }
                else if ("BigDecimal".equals(simpleName)) {
                    ajsonObject.put(name, ((BigDecimal)value).toString());
                }
                else {
                    ajsonObject.put(name, value);
                }
            }
        }
        if (obj.serverCreateTime != null) {
            ajsonObject.put("serverUpdateTime", obj.serverUpdateTime);
        }
        return ajsonObject;
    }
    
    static AJSONObject convertObjectListToJson(final List<APObject> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        final JSONArray jsonArray = new JSONArray();
        final Iterator<APObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)convertAPObjectToJson(iterator.next()));
        }
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("data", jsonArray);
        ajsonObject.put("objectName", list.get(0).getClass().getSimpleName());
        return ajsonObject;
    }
    
    private boolean createLocalTables(final List<APObject> list, final int n) {
        Logger.d("APEntityManager", "[createLocalTables]:start");
        final APAutoRefreshManager instance = APAutoRefreshManager.getInstance();
        if (this.mDatabaseHelper == null) {
            (this.mDatabaseHelper = new APSQLiteOpenHelper(this.mContext, list, n)).getWritableDatabase();
        }
        this.mAPClassMap.clear();
        for (final APObject apObject : list) {
            if (apObject.getPersistentType() == APObject.PersistentType.APLocalAndServer && apObject.isAutoRefresh()) {
                instance.registerAutoRefresh(apObject);
            }
            final Class<? extends APObject> class1 = apObject.getClass();
            this.mAPClassMap.put(class1.getSimpleName(), class1);
        }
        Logger.d("APEntityManager", "[createLocalTables]:end:mAPClassMap.size=" + this.mAPClassMap.size());
        return true;
    }
    
    private void deleteToLocal(final List<APObject> list, final APResponseHandler apResponseHandler) {
        APDBResponse apdbResponse;
        if (this.deleteToLocal(list)) {
            apdbResponse = new APDBResponse(true);
        }
        else {
            apdbResponse = new APDBResponse(false);
        }
        apResponseHandler.onSuccess(apdbResponse);
    }
    
    private boolean deleteToLocal(final List<APObject> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        final String simpleName = list.get(0).getClass().getSimpleName();
        Logger.d("APEntityManager", "[deleteToLocal]" + simpleName);
        int delete;
        final int n = delete = 1;
        try {
            this.getDB().beginTransaction();
            delete = n;
            final StringBuilder sb = new StringBuilder();
            delete = n;
            sb.append("objectId");
            delete = n;
            sb.append(" IN (");
            int n2 = 0;
            while (true) {
                delete = n;
                if (n2 >= list.size()) {
                    break;
                }
                if (n2 > 0) {
                    delete = n;
                    sb.append(", ");
                }
                delete = n;
                final APObject apObject = list.get(n2);
                delete = n;
                sb.append("'" + apObject.objectId + "'");
                ++n2;
            }
            delete = n;
            sb.append(") ");
            delete = n;
            final boolean b = (delete = (this.getDB().delete(simpleName, sb.toString()) ? 1 : 0)) != 0;
            this.getDB().commit();
            return b;
        }
        catch (Exception ex) {
            delete = 0;
            Logger.e("APEntityManager", "[deleteToLocal]" + ex.getLocalizedMessage());
            if (!false) {
                Logger.w("APEntityManager", "[deleteToLocal]##delete fail:" + simpleName);
            }
            this.getDB().endTransaction();
            return false;
        }
        finally {
            if (delete == 0) {
                Logger.w("APEntityManager", "[deleteToLocal]##delete fail:" + simpleName);
            }
            this.getDB().endTransaction();
        }
    }
    
    private void deleteToServer(final List<APObject> data, final APResponseHandler apResponseHandler) {
        if (data == null || data.size() == 0 || apResponseHandler == null) {
            return;
        }
        Logger.d("APEntityManager", "deleteToServer");
        final AJSONObject ajsonObject = new AJSONObject();
        final String authToken = this.mService.getAuthToken();
        ajsonObject.put("objectName", data.get(0).getClass().getSimpleName());
        ajsonObject.put("token", authToken);
        final AJSONArray ajsonArray = new AJSONArray();
        for (final APObject apObject : data) {
            final AJSONObject ajsonObject2 = new AJSONObject();
            ajsonObject2.put("objectId", apObject.objectId);
            ajsonObject2.put("serverUpdateTime", apObject.serverUpdateTime);
            ajsonArray.put((Object)ajsonObject2);
        }
        ajsonObject.put("objectIds", ajsonArray);
        Logger.v("APEntityManager", "params=" + ajsonObject.toString());
        apResponseHandler.setData(data);
        this.mHttpClient.postWithToken(this.mContext, this.mService.getUserInfo().userTokens, this.mServerInfo.getUrl("/data/batch/deleteData"), ajsonObject, apResponseHandler);
    }
    
    private AJSONObject generateTableSchema(final List<APObject> list) {
        final AJSONObject ajsonObject = new AJSONObject();
        final AJSONArray ajsonArray = new AJSONArray();
        for (final APObject apObject : list) {
            final AJSONArray ajsonArray2 = new AJSONArray();
            final List<String> encryptedProperties = apObject.getEncryptedProperties();
            final Field[] fields = apObject.getClass().getFields();
            for (int i = 0; i < fields.length; ++i) {
                final String name = fields[i].getName();
                if (!APObjectUtils.isLocalColumn(name) && !APObjectUtils.isExceptColumn(name)) {
                    final AJSONObject ajsonObject2 = new AJSONObject();
                    ajsonObject2.put("colName", name);
                    final String simpleName = fields[i].getType().getSimpleName();
                    if (encryptedProperties.contains(name)) {
                        ajsonObject2.put("type", "varchar");
                    }
                    else {
                        Logger.w("APEntityManager", "type=" + simpleName + ",db_type=" + APEntityManager._serverDBColumnTypeConf.get(simpleName));
                        ajsonObject2.put("type", APEntityManager._serverDBColumnTypeConf.get(simpleName));
                    }
                    ajsonArray2.put((Object)ajsonObject2);
                }
            }
            final AJSONObject ajsonObject3 = new AJSONObject();
            ajsonObject3.put("primary_key", "objectId");
            ajsonObject3.put("name", apObject.getClass().getSimpleName());
            ajsonObject3.put("columns", ajsonArray2);
            ajsonArray.put((Object)ajsonObject3);
        }
        ajsonObject.put("tables", ajsonArray);
        return ajsonObject;
    }
    
    private APSQLiteOpenHelper getDB() {
        if (this.mDatabaseHelper == null) {
            this.mDatabaseHelper = new APSQLiteOpenHelper(this.mContext);
        }
        return this.mDatabaseHelper;
    }
    
    private String getEncryptKey() {
        if (APEntityManager._encryptKey == null) {
            final SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("APEntityManager", 0);
            String encryptKey;
            if ((encryptKey = sharedPreferences.getString("ek", (String)null)) == null) {
                encryptKey = AES.generateStringKey();
                sharedPreferences.edit().putString("ek", encryptKey).commit();
            }
            APEntityManager._encryptKey = encryptKey;
        }
        return APEntityManager._encryptKey;
    }
    
    public static APEntityManager getInstance() {
        if (APEntityManager._instance == null) {
            (APEntityManager._instance = new APEntityManager()).init();
        }
        return APEntityManager._instance;
    }
    
    private String getString(final Cursor cursor, final String str, final String str2) {
        return cursor.getString(cursor.getColumnIndex(str + str2));
    }
    
    private void init() {
        this.mContext = this.mService.getContext();
        this.mServerInfo = this.mService.getServerInfo();
        this.mHttpClient = this.mServerInfo.getHttpClient();
        (APEntityManager._serverDBColumnTypeConf = new HashMap<String, String>()).put("String", "varchar");
        APEntityManager._serverDBColumnTypeConf.put("int", "integer");
        APEntityManager._serverDBColumnTypeConf.put("Integer", "integer");
        APEntityManager._serverDBColumnTypeConf.put("long", "integer");
        APEntityManager._serverDBColumnTypeConf.put("double", "double");
        APEntityManager._serverDBColumnTypeConf.put("boolean", "boolean");
        APEntityManager._serverDBColumnTypeConf.put("Date", "datetime");
        APEntityManager._serverDBColumnTypeConf.put("float", "float");
        APEntityManager._serverDBColumnTypeConf.put("BigDecimal", "decimal");
    }
    
    private int insertToLocal(final List<APObject> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        final AJSONObject convertObjectListToJson = convertObjectListToJson(list);
        Logger.d("APEntityManager", "insertToLocal:" + convertObjectListToJson.toString());
        final String string = convertObjectListToJson.getString("objectName");
        int n = 0;
        int n2 = 0;
        this.getDB().beginTransaction();
        Label_0451: {
            try {
                final JSONArray jsonArray = convertObjectListToJson.getJSONArray("data");
                int i = 0;
            Label_0284_Outer:
                while (true) {
                    n = n2;
                    if (i < jsonArray.length()) {
                        n = n2;
                        final ContentValues contentValues = new ContentValues();
                        n = n2;
                        final APObject apObject = list.get(i);
                        int n3 = n2;
                        n = n2;
                        while (true) {
                            Label_0293: {
                                try {
                                    final JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    n3 = n2;
                                    n = n2;
                                    final Iterator keys = jsonObject.keys();
                                    while (true) {
                                        n3 = n2;
                                        n = n2;
                                        if (!keys.hasNext()) {
                                            break Label_0293;
                                        }
                                        n3 = n2;
                                        n = n2;
                                        final String anObject = keys.next();
                                        n3 = n2;
                                        n = n2;
                                        if ("scopeType".equals(anObject)) {
                                            continue Label_0284_Outer;
                                        }
                                        n3 = n2;
                                        n = n2;
                                        String s = jsonObject.getString(anObject);
                                        n3 = n2;
                                        n = n2;
                                        if (apObject.isEncryptedProperties(anObject)) {
                                            n3 = n2;
                                            n = n2;
                                            s = this.encrypt(s);
                                        }
                                        n3 = n2;
                                        n = n2;
                                        contentValues.put(anObject, s);
                                    }
                                }
                                catch (JSONException ex) {
                                    n = n3;
                                    ex.printStackTrace();
                                    n2 = n3;
                                }
                                ++i;
                                continue Label_0284_Outer;
                            }
                            n = n2;
                            if (apObject.objectId == null) {
                                n = n2;
                                apObject.objectId = UUID.randomUUID().toString();
                            }
                            n = n2;
                            contentValues.put("objectId", apObject.objectId);
                            int n4 = n2;
                            n = n2;
                            if (this.getDB().insert(string, contentValues) > 0) {
                                n4 = n2 + 1;
                            }
                            n = n4;
                            Logger.d("APEntityManager", "create:" + string + " objectId[" + i + "]=" + apObject.objectId);
                            n2 = n4;
                            continue;
                        }
                    }
                    break Label_0451;
                }
            }
            catch (Exception ex2) {
                Logger.e("APEntityManager", "error insertToLocal", ex2);
                return n;
                this.getDB().commit();
                return n2;
            }
            finally {
                this.getDB().endTransaction();
            }
        }
    }
    
    private boolean insertToServer(final List<APObject> data, final APResponseHandler apResponseHandler) {
        if (data == null || data.size() == 0 || apResponseHandler == null) {
            return false;
        }
        final AJSONObject convertObjectListToJson = convertObjectListToJson(data);
        Logger.v("APEntityManager", "insertToServer params=" + convertObjectListToJson.toString());
        final String authToken = this.mService.getAuthToken();
        apResponseHandler.setData(data);
        this.mHttpClient.postWithToken(this.mContext, authToken, this.mServerInfo.getUrl("/data/batch/addData"), convertObjectListToJson, apResponseHandler);
        return true;
    }
    
    private APObject newAPObject(final Class<?> clazz) {
        try {
            return (APObject)clazz.newInstance();
        }
        catch (Exception ex) {
            Logger.e("APEntityManager", "newAPObject:" + ex.getLocalizedMessage());
            return null;
        }
    }
    
    private APResponse queryToLocal(final APQuery apQuery) {
        Logger.v("APEntityManager", "[queryToLocal]" + apQuery.getTableName());
        final Map<String, Object> where = apQuery.toWhere();
        final String s = where.get("where");
        final String[] array = where.get("args");
        String stringJoinQuery = null;
        Cursor cursor;
        if (apQuery.isHasJoin()) {
            stringJoinQuery = apQuery.toStringJoinQuery();
            cursor = this.getDB().rawQuery(apQuery.getTableName(), stringJoinQuery, s, array, apQuery.toSort(), apQuery.toLimit());
        }
        else {
            cursor = this.getDB().query(apQuery.getTableName(), s, array, apQuery.toSort(), apQuery.toLimit());
        }
        final APDBResponse apdbResponse = new APDBResponse(cursor, this.getDB().tableCount(apQuery.getTableName(), stringJoinQuery, s, array));
        Logger.v("APEntityManager", "[queryToLocal]end");
        APQuery.initTableAliasCount();
        return apdbResponse;
    }
    
    private void queryToLocal(final APQuery apQuery, final APResponseHandler apResponseHandler) {
        apResponseHandler.onSuccess(this.queryToLocal(apQuery));
    }
    
    private void queryToServer(final APQuery apQuery, final APResponseHandler apResponseHandler) {
        Logger.v("APEntityManager", "[queryToServer]start");
        final String authToken = this.mService.getAuthToken();
        if (authToken == null) {
            Logger.w("APEntityManager", "token is null");
            apResponseHandler.onFailure(new APInvalidTokenException());
            return;
        }
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("maxRecord", apQuery.maxRecord);
        ajsonObject.put("pageIndex", apQuery.pageIndex);
        ajsonObject.put("token", authToken);
        final ArrayList<Object> list = new ArrayList<Object>(1);
        list.add(apQuery.getTableName());
        ajsonObject.put("objectNames", JsonUtils.toJsonArray(list));
        ajsonObject.put("condition", JsonUtils.toJson(apQuery.getCondition()));
        List<E> list3;
        if (apQuery.returnObjects == null || apQuery.returnObjects.size() == 0) {
            final ArrayList<String> list2 = (ArrayList<String>)new ArrayList<Object>(1);
            list2.add(apQuery.getTableName());
            list3 = (List<E>)list2;
        }
        else {
            final ArrayList<Object> list4 = new ArrayList<Object>(apQuery.returnObjects.size());
            final Iterator<Class<?>> iterator = apQuery.returnObjects.iterator();
            while (true) {
                list3 = (List<E>)list4;
                if (!iterator.hasNext()) {
                    break;
                }
                list4.add(iterator.next().getSimpleName());
            }
        }
        ajsonObject.put("returnedObjectNames", JsonUtils.toJsonArray((List<Object>)list3));
        Logger.v("APEntityManager", "params=" + ajsonObject.toString());
        this.mHttpClient.postWithToken(this.mContext, this.mService.getUserInfo().userTokens, this.mServerInfo.getUrl("/data/query"), ajsonObject, apResponseHandler);
        Logger.v("APEntityManager", "[queryToServer]end");
    }
    
    private void updateSyncLocal(final List<APObject> list) {
        for (final APObject apObject : list) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("syncDataFlag", Boolean.valueOf(true));
            contentValues.put("serverCreateTime", apObject.serverCreateTime);
            contentValues.put("serverUpdateTime", apObject.serverUpdateTime);
            contentValues.put("createUserId", Double.valueOf(apObject.createUserId));
            contentValues.put("groupIds", apObject.groupIds);
            this.getDB().update(apObject.getClass().getSimpleName(), contentValues, "objectId = ? ", new String[] { apObject.objectId });
        }
    }
    
    private int updateToLocal(final List<APObject> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          13
        //     4: aload_1        
        //     5: invokeinterface java/util/List.size:()I
        //    10: ifne            15
        //    13: iconst_0       
        //    14: ireturn        
        //    15: aload_1        
        //    16: invokestatic    jp/co/ncdc/apppot/stew/APEntityManager.convertObjectListToJson:(Ljava/util/List;)Ljp/co/ncdc/apppot/stew/json/AJSONObject;
        //    19: astore          6
        //    21: ldc             "APEntityManager"
        //    23: new             Ljava/lang/StringBuilder;
        //    26: dup            
        //    27: invokespecial   java/lang/StringBuilder.<init>:()V
        //    30: ldc_w           "updateToLocal:"
        //    33: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    36: aload           6
        //    38: invokevirtual   jp/co/ncdc/apppot/stew/json/AJSONObject.toString:()Ljava/lang/String;
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    47: invokestatic    jp/co/ncdc/apppot/stew/log/Logger.d:(Ljava/lang/String;Ljava/lang/String;)V
        //    50: aload           6
        //    52: ldc             "objectName"
        //    54: invokevirtual   jp/co/ncdc/apppot/stew/json/AJSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //    57: astore          9
        //    59: iconst_0       
        //    60: istore          4
        //    62: iconst_0       
        //    63: istore_2       
        //    64: aload_0        
        //    65: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //    68: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.beginTransaction:()V
        //    71: aload           6
        //    73: ldc             "data"
        //    75: invokevirtual   jp/co/ncdc/apppot/stew/json/AJSONObject.getJSONArray:(Ljava/lang/String;)Lorg/json/JSONArray;
        //    78: astore          10
        //    80: iconst_0       
        //    81: istore_3       
        //    82: iload_2        
        //    83: istore          4
        //    85: iload_3        
        //    86: aload           10
        //    88: invokevirtual   org/json/JSONArray.length:()I
        //    91: if_icmpge       372
        //    94: iload_2        
        //    95: istore          4
        //    97: new             Landroid/content/ContentValues;
        //   100: dup            
        //   101: invokespecial   android/content/ContentValues.<init>:()V
        //   104: astore          11
        //   106: iload_2        
        //   107: istore          4
        //   109: aload           10
        //   111: iload_3        
        //   112: invokevirtual   org/json/JSONArray.getJSONObject:(I)Lorg/json/JSONObject;
        //   115: astore          12
        //   117: iload_2        
        //   118: istore          4
        //   120: aload_1        
        //   121: iload_3        
        //   122: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   127: checkcast       Ljp/co/ncdc/apppot/stew/dto/APObject;
        //   130: astore          6
        //   132: iload_2        
        //   133: istore          4
        //   135: aload           12
        //   137: invokevirtual   org/json/JSONObject.keys:()Ljava/util/Iterator;
        //   140: astore          13
        //   142: iload_2        
        //   143: istore          4
        //   145: aload           6
        //   147: invokevirtual   jp/co/ncdc/apppot/stew/dto/APObject.getEncryptedProperties:()Ljava/util/List;
        //   150: astore          14
        //   152: aconst_null    
        //   153: astore          6
        //   155: iload_2        
        //   156: istore          4
        //   158: aload           13
        //   160: invokeinterface java/util/Iterator.hasNext:()Z
        //   165: ifeq            308
        //   168: iload_2        
        //   169: istore          4
        //   171: aload           13
        //   173: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   178: checkcast       Ljava/lang/String;
        //   181: astore          15
        //   183: iload_2        
        //   184: istore          4
        //   186: ldc_w           "scopeType"
        //   189: aload           15
        //   191: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   194: ifne            155
        //   197: iload_2        
        //   198: istore          4
        //   200: aload           12
        //   202: aload           15
        //   204: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   207: astore          8
        //   209: aload           8
        //   211: astore          7
        //   213: iload_2        
        //   214: istore          4
        //   216: aload           14
        //   218: aload           15
        //   220: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   225: ifeq            239
        //   228: iload_2        
        //   229: istore          4
        //   231: aload_0        
        //   232: aload           8
        //   234: invokevirtual   jp/co/ncdc/apppot/stew/APEntityManager.encrypt:(Ljava/lang/String;)Ljava/lang/String;
        //   237: astore          7
        //   239: iload_2        
        //   240: istore          4
        //   242: ldc_w           "objectId"
        //   245: aload           15
        //   247: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   250: ifeq            293
        //   253: iload_2        
        //   254: istore          4
        //   256: new             Ljava/lang/StringBuilder;
        //   259: dup            
        //   260: invokespecial   java/lang/StringBuilder.<init>:()V
        //   263: aload           15
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: ldc_w           "='"
        //   271: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   274: aload           7
        //   276: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: ldc_w           "'"
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   288: astore          6
        //   290: goto            155
        //   293: iload_2        
        //   294: istore          4
        //   296: aload           11
        //   298: aload           15
        //   300: aload           7
        //   302: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/String;)V
        //   305: goto            155
        //   308: iload_2        
        //   309: istore          4
        //   311: ldc             "APEntityManager"
        //   313: new             Ljava/lang/StringBuilder;
        //   316: dup            
        //   317: invokespecial   java/lang/StringBuilder.<init>:()V
        //   320: ldc_w           "update data where "
        //   323: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   326: aload           6
        //   328: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   331: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   334: invokestatic    jp/co/ncdc/apppot/stew/log/Logger.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   337: iload_2        
        //   338: istore          4
        //   340: aload_0        
        //   341: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //   344: aload           9
        //   346: aload           11
        //   348: aload           6
        //   350: aconst_null    
        //   351: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.update:(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   354: istore          5
        //   356: iload_2        
        //   357: istore          4
        //   359: iload           5
        //   361: ifle            426
        //   364: iload_2        
        //   365: iconst_1       
        //   366: iadd           
        //   367: istore          4
        //   369: goto            426
        //   372: iload_2        
        //   373: istore          4
        //   375: aload_0        
        //   376: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //   379: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.commit:()V
        //   382: aload_0        
        //   383: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //   386: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.endTransaction:()V
        //   389: iload_2        
        //   390: ireturn        
        //   391: astore_1       
        //   392: ldc             "APEntityManager"
        //   394: ldc_w           "error updateToLocal"
        //   397: aload_1        
        //   398: invokestatic    jp/co/ncdc/apppot/stew/log/Logger.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   401: aload_0        
        //   402: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //   405: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.endTransaction:()V
        //   408: iload           4
        //   410: ireturn        
        //   411: astore_1       
        //   412: aload_0        
        //   413: invokespecial   jp/co/ncdc/apppot/stew/APEntityManager.getDB:()Ljp/co/ncdc/apppot/stew/APSQLiteOpenHelper;
        //   416: invokevirtual   jp/co/ncdc/apppot/stew/APSQLiteOpenHelper.endTransaction:()V
        //   419: aload_1        
        //   420: athrow         
        //   421: astore          6
        //   423: iload_2        
        //   424: istore          4
        //   426: iload_3        
        //   427: iconst_1       
        //   428: iadd           
        //   429: istore_3       
        //   430: iload           4
        //   432: istore_2       
        //   433: goto            82
        //    Signature:
        //  (Ljava/util/List<Ljp/co/ncdc/apppot/stew/dto/APObject;>;)I
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  71     80     391    411    Ljava/lang/Exception;
        //  71     80     411    421    Any
        //  85     94     391    411    Ljava/lang/Exception;
        //  85     94     411    421    Any
        //  97     106    391    411    Ljava/lang/Exception;
        //  97     106    411    421    Any
        //  109    117    421    426    Lorg/json/JSONException;
        //  109    117    391    411    Ljava/lang/Exception;
        //  109    117    411    421    Any
        //  120    132    421    426    Lorg/json/JSONException;
        //  120    132    391    411    Ljava/lang/Exception;
        //  120    132    411    421    Any
        //  135    142    421    426    Lorg/json/JSONException;
        //  135    142    391    411    Ljava/lang/Exception;
        //  135    142    411    421    Any
        //  145    152    421    426    Lorg/json/JSONException;
        //  145    152    391    411    Ljava/lang/Exception;
        //  145    152    411    421    Any
        //  158    168    421    426    Lorg/json/JSONException;
        //  158    168    391    411    Ljava/lang/Exception;
        //  158    168    411    421    Any
        //  171    183    421    426    Lorg/json/JSONException;
        //  171    183    391    411    Ljava/lang/Exception;
        //  171    183    411    421    Any
        //  186    197    421    426    Lorg/json/JSONException;
        //  186    197    391    411    Ljava/lang/Exception;
        //  186    197    411    421    Any
        //  200    209    421    426    Lorg/json/JSONException;
        //  200    209    391    411    Ljava/lang/Exception;
        //  200    209    411    421    Any
        //  216    228    421    426    Lorg/json/JSONException;
        //  216    228    391    411    Ljava/lang/Exception;
        //  216    228    411    421    Any
        //  231    239    421    426    Lorg/json/JSONException;
        //  231    239    391    411    Ljava/lang/Exception;
        //  231    239    411    421    Any
        //  242    253    421    426    Lorg/json/JSONException;
        //  242    253    391    411    Ljava/lang/Exception;
        //  242    253    411    421    Any
        //  256    290    421    426    Lorg/json/JSONException;
        //  256    290    391    411    Ljava/lang/Exception;
        //  256    290    411    421    Any
        //  296    305    421    426    Lorg/json/JSONException;
        //  296    305    391    411    Ljava/lang/Exception;
        //  296    305    411    421    Any
        //  311    337    421    426    Lorg/json/JSONException;
        //  311    337    391    411    Ljava/lang/Exception;
        //  311    337    411    421    Any
        //  340    356    421    426    Lorg/json/JSONException;
        //  340    356    391    411    Ljava/lang/Exception;
        //  340    356    411    421    Any
        //  375    382    391    411    Ljava/lang/Exception;
        //  375    382    411    421    Any
        //  392    401    411    421    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0155:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean updateToServer(final List<APObject> data, final APResponseHandler apResponseHandler) {
        if (data == null || data.size() == 0 || apResponseHandler == null) {
            return false;
        }
        final AJSONObject convertObjectListToJson = convertObjectListToJson(data);
        Logger.v("APEntityManager", "updateToServer params=" + convertObjectListToJson.toString());
        convertObjectListToJson.put("token", this.mService.getAuthToken());
        apResponseHandler.setData(data);
        this.mHttpClient.postWithToken(this.mContext, this.mService.getUserInfo().userTokens, this.mServerInfo.getUrl("/data/batch/updateData"), convertObjectListToJson, apResponseHandler);
        return true;
    }
    
    void addLog(final int i, final String str) {
        final ContentValues convertToContentValues = DBUtils.convertToContentValues(new APLogging(i, str, this.mService.getAuthToken()));
        while (true) {
            try {
                this.getDB().insert(APLogging.class.getSimpleName(), convertToContentValues);
                Logger.d("APEntityManager", "[addLog]logLevel=" + i + " logMessage=" + str);
            }
            catch (Exception obj) {
                Logger.w("APEntityManager", "[addLog]:Error:" + obj + ", values=" + convertToContentValues);
                continue;
            }
            break;
        }
    }
    
    void addMessageQueue(final Class<?> clazz, final String s, final int n) {
        this.addMessageQueue(clazz, s, n, null);
    }
    
    void addMessageQueue(final Class<?> obj, final String str, final int i, final String s) {
        this.getDB().insert(APMessageQueue.class.getSimpleName(), DBUtils.convertToContentValues(new APMessageQueue(obj.getName(), str, i, s)));
        Logger.d("APEntityManager", "addMessageQueue:" + obj + " id=" + str + " type=" + i);
    }
    
    public void checkDoneCreateAppDB() {
        if (!this.getDB().isValidSQLiteDB()) {
            throw new APException("Need to CreateAppDB!!!");
        }
    }
    
    public void clearAllTables() {
        final ArrayList<Class<APLogging>> list = new ArrayList<Class<APLogging>>((Collection<? extends Class<APLogging>>)this.mAPClassMap.values());
        list.add(APLogging.class);
        list.add(APMessageQueue.class);
        this.getDB().beginTransaction();
        Logger.i("APEntityManager", "[clearAllTables]:Start");
        Label_0163: {
            try {
                final Iterator<Class> iterator = list.iterator();
                while (iterator.hasNext()) {
                    final String simpleName = iterator.next().getSimpleName();
                    Logger.d("APEntityManager", "[clearAllTables]table=" + simpleName);
                    this.getDB().delete(simpleName, "");
                }
                break Label_0163;
            }
            catch (Exception obj) {
                Logger.w("APEntityManager", "[clearAllTables]:Error:" + obj);
                return;
                this.getDB().commit();
            }
            finally {
                this.getDB().endTransaction();
                Logger.i("APEntityManager", "[clearAllTables]:End");
            }
        }
    }
    
    public void createAppDB(final Context context, final List<APObject> list, final int n, final boolean b, final int n2, final APResponseHandler apResponseHandler) {
        Logger.i("APEntityManager", "createAppDB");
        final ArrayList<APObject> list2 = new ArrayList<APObject>();
        final ArrayList<APObject> list3 = new ArrayList<APObject>();
        for (final APObject apObject : list) {
            if (apObject.getPersistentType() == APObject.PersistentType.APLocalOnly) {
                list3.add(apObject);
            }
            else if (apObject.getPersistentType() == APObject.PersistentType.APServerOnly) {
                list2.add(apObject);
            }
            else {
                list3.add(apObject);
                list2.add(apObject);
            }
        }
        while (true) {
            if (b) {
                while (true) {
                    try {
                        context.deleteDatabase("stew.db");
                        this.createLocalTables(list3, n2);
                        this.mService.refreshAnonymousToken(true);
                        if (list2.size() > 0) {
                            final AJSONObject generateTableSchema = this.generateTableSchema(list2);
                            generateTableSchema.put("appId", this.mServerInfo.appId);
                            generateTableSchema.put("appVersion", this.mServerInfo.appVersion);
                            generateTableSchema.put("isResetDatabase", b);
                            generateTableSchema.put("companyId", n);
                            Logger.i("APEntityManager", "params=" + generateTableSchema.toString());
                            this.mHttpClient.postWithToken(this.mContext, this.mService.getUserInfo().anonymousToken, this.mServerInfo.getUrl("/schemas"), generateTableSchema, apResponseHandler);
                            return;
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        if (apResponseHandler != null) {
                            apResponseHandler.onError(ex.getLocalizedMessage(), ex);
                        }
                        continue;
                    }
                    break;
                }
                if (apResponseHandler != null) {
                    apResponseHandler.onSuccess(new APDBResponse(true));
                }
                Logger.d("APEntityManager", "No Server Table");
                return;
            }
            continue;
        }
    }
    
    public void createAppDB(final Context context, final List<APObject> list, final int n, final boolean b, final APResponseHandler apResponseHandler) {
        this.createAppDB(context, list, n, b, 1, apResponseHandler);
    }
    
    public String decrypt(final String s) {
        if (StringUtils.isNullSpace(s)) {
            return null;
        }
        return new String(AES.decrypt(s, this.getEncryptKey()));
    }
    
    public void deleteExpireData(final Class<?> clazz) {
        final APQuery apQuery = new APQuery(clazz);
        apQuery.sort("updateTime");
        final List<APObject> searchResuls = this.queryToLocal(apQuery).getResultForSearchObject(clazz).getSearchResuls();
        final ArrayList<APObject> list = new ArrayList<APObject>();
        for (final APObject apObject : searchResuls) {
            if (DateTimeUtils.compareExpiredDate(apObject.updateTime, apObject.getLifeSpan())) {
                list.add(apObject);
            }
        }
        Logger.d("APEntityManager", "[deleteExpireData]" + clazz.getName());
        this.deleteToLocal(list);
    }
    
    public int deleteObject(final List<APObject> list) {
        final APCommonResponseHandler apCommonResponseHandler = new APCommonResponseHandler(true);
        this.deleteObject(list, apCommonResponseHandler);
        return apCommonResponseHandler.status;
    }
    
    public int deleteObject(final APObject apObject) {
        final APCommonResponseHandler apCommonResponseHandler = new APCommonResponseHandler(true);
        this.deleteObject(apObject, apCommonResponseHandler);
        return apCommonResponseHandler.status;
    }
    
    public void deleteObject(final List<APObject> list, final APResponseHandler apResponseHandler) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("delete target List is null or no data");
        }
        switch (list.get(0).getPersistentType()) {
            default: {
                this.deleteToServer(list, apResponseHandler);
            }
            case APLocalAndServer: {
                this.deleteToLocal(list);
                this.deleteToServer(list, new APResponseHandler() {
                    private void addMessageDeleteData(final List<APObject> list) {
                        for (final APObject apObject : list) {
                            if (apObject.serverUpdateTime != null) {
                                APEntityManager.this.addMessageQueue(apObject.getClass(), apObject.objectId, 3, apObject.serverUpdateTime);
                            }
                            else {
                                APEntityManager.this.removeMessageQueue(apObject.getClass().getName(), apObject.objectId);
                            }
                        }
                    }
                    
                    @Override
                    public void onError(final String s, final Throwable t) {
                        this.addMessageDeleteData(this.getData());
                        apResponseHandler.onSuccess(new APDBResponse(false));
                    }
                    
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        this.addMessageDeleteData(this.getData());
                        apResponseHandler.onSuccess(new APDBResponse(false));
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        Logger.d("APEntityManager", "success:delete from server");
                        apResponseHandler.onSuccess(new APDBResponse(true));
                    }
                });
            }
            case APLocalOnly: {
                this.deleteToLocal(list, apResponseHandler);
            }
        }
    }
    
    public void deleteObject(final APObject apObject, final APResponseHandler apResponseHandler) {
        final ArrayList<APObject> list = new ArrayList<APObject>();
        list.add(apObject);
        this.deleteObject(list, apResponseHandler);
    }
    
    void deleteToServerFromLocalData(final Class<?> clazz, final String s) {
        Logger.d("APEntityManager", "[deleteToServerFromLocalData]:start:" + clazz.getSimpleName());
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onError(final String str, final Throwable t) {
                Logger.w("APEntityManager", "[deleteToServerFromLocalData]:onError:" + clazz.getSimpleName() + ":" + str);
            }
            
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APEntityManager", "[deleteToServerFromLocalData]:onFailure:" + clazz.getSimpleName());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APEntityManager", "[deleteToServerFromLocalData]:onSuccess:" + clazz.getSimpleName());
                APEntityManager.this.removeMessageQueue(clazz.getName(), s);
            }
        };
        final APQuery apQuery = new APQuery(clazz);
        apQuery.whereEqual("objectId", s);
        final List<APObject> searchResuls = this.queryToLocal(apQuery).getResultForSearchObject(clazz).getSearchResuls();
        if (searchResuls != null && searchResuls.size() > 0) {
            this.deleteToServer(searchResuls, apResponseHandler);
        }
    }
    
    public String encrypt(final String s) {
        if (StringUtils.isNullSpace(s)) {
            return null;
        }
        return AES.encrypt(s, this.getEncryptKey());
    }
    
    List<APMessageQueue> getAllMessageQueue() {
        return this.getMessageQueue(null);
    }
    
    List<APLogging> getLogList() {
        this.getDB().beginTransaction();
        final ArrayList<APLogging> list = new ArrayList<APLogging>();
        try {
            final Cursor query = this.getDB().query(APLogging.class.getSimpleName());
            query.moveToFirst();
            final int count = query.getCount();
            if (count > 0) {
                for (int i = 0; i < count; ++i) {
                    final APLogging apLogging = new APLogging();
                    apLogging.logLevel = DBUtils.getInt(query, "logLevel");
                    apLogging.message = DBUtils.getString(query, "message");
                    apLogging.userToken = DBUtils.getString(query, "userToken");
                    apLogging.createDate = DBUtils.getLong(query, "createDate");
                    list.add(apLogging);
                    query.moveToNext();
                }
            }
            return list;
        }
        finally {
            this.getDB().endTransaction();
        }
    }
    
    List<APMessageQueue> getMessageQueue(final String s) {
        Object o = null;
        Label_0176: {
            if (s == null) {
                break Label_0176;
            }
            Object query = "targetTableName = ?";
            while (true) {
                if (s != null) {
                    o = new String[] { s };
                }
                this.getDB().beginTransaction();
                final ArrayList<APMessageQueue> list = new ArrayList<APMessageQueue>();
                try {
                    query = this.getDB().query(APMessageQueue.class.getSimpleName(), (String)query, (String[])o, "createDate desc");
                    ((Cursor)query).moveToFirst();
                    final int count = ((Cursor)query).getCount();
                    if (count > 0) {
                        for (int i = 0; i < count; ++i) {
                            o = new APMessageQueue();
                            ((APMessageQueue)o).targetTableName = DBUtils.getString((Cursor)query, "targetTableName");
                            ((APMessageQueue)o).targetObjectId = DBUtils.getString((Cursor)query, "targetObjectId");
                            ((APMessageQueue)o).messageType = DBUtils.getInt((Cursor)query, "messageType");
                            ((APMessageQueue)o).createDate = DBUtils.getLong((Cursor)query, "createDate");
                            list.add((APMessageQueue)o);
                            ((Cursor)query).moveToNext();
                        }
                    }
                    return list;
                    query = null;
                    continue;
                }
                finally {
                    this.getDB().endTransaction();
                }
                break;
            }
        }
    }
    
    int getMessageQueueCount() {
        this.getDB().beginTransaction();
        try {
            final Cursor query = this.getDB().query(APMessageQueue.class.getSimpleName());
            query.moveToFirst();
            return query.getCount();
        }
        finally {
            this.getDB().endTransaction();
        }
    }
    
    public List<APObject> getObject(final APQuery apQuery) {
        final ArrayList<APObject> list = new ArrayList<APObject>();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                list.addAll(apResponse.getResultForSearchObject(apQuery.getTableClass()).getSearchResuls());
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        this.getObject(apQuery, apResponseHandler);
        return list;
    }
    
    public void getObject(final APQuery apQuery, final APResponseHandler apResponseHandler) {
        Logger.v("APEntityManager", "[getObject]start");
        if (apQuery == null || apResponseHandler == null) {
            throw new IllegalArgumentException("query or handler is null");
        }
        switch (apQuery.getAPObject().getPersistentType()) {
            default: {
                this.queryToServer(apQuery, apResponseHandler);
                break;
            }
            case APLocalAndServer: {
                final APResponse queryToLocal = this.queryToLocal(apQuery);
                final List<APObject> searchResuls = queryToLocal.getResultForSearchObject(this.mAPClassMap.get(apQuery.getTableName())).getSearchResuls();
                if (this.isOnline()) {
                    if (searchResuls.size() > 0) {
                        apResponseHandler.setLocalResultData(searchResuls);
                    }
                    this.queryToServer(apQuery, apResponseHandler);
                    break;
                }
                if (searchResuls.size() > 0) {
                    apResponseHandler.setLocalResultData(searchResuls);
                }
                apResponseHandler.onSuccess(queryToLocal);
                break;
            }
            case APLocalOnly: {
                this.queryToLocal(apQuery, apResponseHandler);
                break;
            }
        }
        Logger.v("APEntityManager", "[getObject]end");
    }
    
    void insertToServerFromLocalData(final Class<?> clazz, final String s) {
        Logger.d("APEntityManager", "[insertToServerFromLocalData]:start:" + clazz.getSimpleName());
        final APQuery apQuery = new APQuery(clazz);
        apQuery.whereEqual("objectId", s);
        this.insertToServer(this.queryToLocal(apQuery).getResultForSearchObject(clazz).getSearchResuls(), new APResponseHandler() {
            @Override
            public void onError(final String str, final Throwable t) {
                Logger.w("APEntityManager", "[insertToServerFromLocalData]:onError:" + clazz.getSimpleName() + ":" + str);
            }
            
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APEntityManager", "[insertToServerFromLocalData]:onFailure:" + clazz.getSimpleName() + ":" + apResponse.getDescription());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APEntityManager", "[insertToServerFromLocalData]:onSuccess:" + clazz.getSimpleName());
                APEntityManager.this.removeMessageQueue(clazz.getName(), s);
            }
        });
    }
    
    public boolean isOnline() {
        return this.mHttpClient.isOnline(this.mContext);
    }
    
     <T> Map<String, T> localSelect(String decrypt, List<Object> list, final Map<String, Class<APObject>> map) {
        String[] stringArray;
        final String[] array = stringArray = null;
        if (list != null) {
            stringArray = array;
            if (list.size() > 0) {
                stringArray = StringUtils.toStringArray(list);
            }
        }
        Logger.d("APEntityManager", "sqlQuery=" + decrypt + ", args=" + stringArray);
        final Cursor rawQuery = this.getDB().rawQuery(decrypt, stringArray);
        if (rawQuery == null) {
            return null;
        }
        final HashMap<Object, List<Object>> hashMap = (HashMap<Object, List<Object>>)new HashMap<Object, T>();
        Label_0242: {
            try {
                if (!decrypt.contains("__APPPOT_COUNT__")) {
                    break Label_0242;
                }
                while (rawQuery.moveToNext()) {
                    hashMap.put("count", (T)(rawQuery.getInt(rawQuery.getColumnIndex("__APPPOT_COUNT__")) + ""));
                }
            }
            finally {
                rawQuery.close();
            }
            if (hashMap.size() == 0) {
                hashMap.put("count", (T)"0");
            }
            Logger.d("APEntityManager", "count query:" + hashMap.get("count"));
            rawQuery.close();
            return (Map<String, T>)hashMap;
        }
        Logger.d("APEntityManager", "Data is Exist:" + rawQuery.getCount());
        while (rawQuery.moveToNext()) {
            for (final String s : map.keySet()) {
                if ((list = (List<Object>)hashMap.get(s)) == null) {
                    list = new ArrayList<Object>();
                }
                final APObject apObject = this.newAPObject(map.get(s));
                final List<String> encryptedProperties = apObject.getEncryptedProperties();
                final Field[] fields = map.get(s).getFields();
                for (int length = fields.length, i = 0; i < length; ++i) {
                    final Field field = fields[i];
                    final String name = field.getName();
                    if (!APObjectUtils.isExceptColumn(name)) {
                        if (!APObjectUtils.isServerColumn(name)) {
                            final String string = rawQuery.getString(rawQuery.getColumnIndex(name + s));
                            Logger.v("APEntityManager", "alias=" + s + ", key=" + name + ", value=" + string);
                            decrypt = string;
                            String str = string;
                            try {
                                if (encryptedProperties.contains(name)) {
                                    str = string;
                                    decrypt = getInstance().decrypt(string);
                                }
                                str = decrypt;
                                APObject.setValueFromLocal(apObject, field, decrypt);
                            }
                            catch (IllegalArgumentException ex) {
                                Logger.e("APEntityManager", "IllegalArgumentException:name=" + name + ", value=" + str + ", " + ex.getLocalizedMessage());
                            }
                        }
                    }
                }
                list.add(apObject);
                hashMap.put(s, (T)list);
            }
        }
        rawQuery.close();
        return (Map<String, T>)hashMap;
    }
    
    void removeLog(final APLogging apLogging) {
        Logger.d("APEntityManager", "[removeLog]" + apLogging.message);
        this.getDB().beginTransaction();
        try {
            Logger.d("APEntityManager", "where = " + "createDate = ?");
            Logger.d("APEntityManager", "removeLog:" + this.getDB().delete(APLogging.class.getSimpleName(), "createDate = ?", new String[] { String.valueOf(apLogging.createDate) }));
            this.getDB().commit();
        }
        finally {
            this.getDB().endTransaction();
        }
    }
    
    void removeMessageQueue(final String str, final String str2) {
        this.getDB().beginTransaction();
        try {
            this.getDB().delete(APMessageQueue.class.getSimpleName(), "targetTableName = ? and targetObjectId = ?", new String[] { str, str2 });
            this.getDB().commit();
            this.getDB().endTransaction();
            Logger.d("APEntityManager", "removeMessageQueue:" + str + " id=" + str2);
        }
        finally {
            this.getDB().endTransaction();
        }
    }
    
    void saveNotExitLocal(final List<APObject> list) {
        if (list != null && list.size() > 0 && list.get(0).getPersistentType() != APObject.PersistentType.APServerOnly) {
            this.insertToLocal(list);
        }
    }
    
    public int saveObject(final APObject apObject) {
        final APCommonResponseHandler apCommonResponseHandler = new APCommonResponseHandler(true);
        this.saveObject(apObject, apCommonResponseHandler);
        return apCommonResponseHandler.status;
    }
    
    public void saveObject(final APObject e, final APResponseHandler apResponseHandler) {
        final ArrayList<APObject> list = new ArrayList<APObject>();
        list.add(e);
        this.saveObjectList(list, apResponseHandler);
    }
    
    public void saveObjectList(final List<APObject> list, final APResponseHandler apResponseHandler) {
        if (list == null || list.size() == 0) {
            Logger.w("APEntityManager", "saved No data");
            return;
        }
        Logger.i("APEntityManager", "saveObject:start");
        final APObject.PersistentType persistentType = list.get(0).getPersistentType();
        final ArrayList<APObject> list2 = new ArrayList<APObject>();
        final ArrayList<APObject> list3 = new ArrayList<APObject>();
        for (final APObject apObject : list) {
            if (apObject.objectId != null) {
                apObject.updateTime = new Date(System.currentTimeMillis());
                list3.add(apObject);
            }
            else {
                apObject.createTime = new Date(System.currentTimeMillis());
                apObject.updateTime = apObject.createTime;
                list2.add(apObject);
            }
        }
        switch (persistentType) {
            default: {
                if (list2.size() > 0) {
                    this.insertToServer(list2, apResponseHandler);
                }
                if (list3.size() > 0) {
                    this.updateToServer(list3, apResponseHandler);
                    break;
                }
                break;
            }
            case APLocalAndServer: {
                final APResponseHandler apResponseHandler2 = new APResponseHandler() {
                    private void addMessageSaveData(final List<APObject> list) {
                        for (final APObject apObject : list) {
                            int n;
                            if (apObject.serverUpdateTime == null) {
                                n = 1;
                            }
                            else {
                                n = 2;
                            }
                            APEntityManager.this.addMessageQueue(apObject.getClass(), apObject.objectId, n);
                        }
                    }
                    
                    @Override
                    public void onError(final String s, final Throwable t) {
                        this.addMessageSaveData(this.getData());
                        apResponseHandler.onError(s, t);
                    }
                    
                    @Override
                    public void onFailure(final APResponse apResponse) {
                        this.addMessageSaveData(this.getData());
                        Logger.w("APEntityManager", "onFailure:saveObject to Server " + apResponse.getResponseData());
                        apResponseHandler.onFailure(apResponse);
                    }
                    
                    @Override
                    public void onSuccess(final APResponse apResponse) {
                        APEntityManager.this.updateSyncLocal(apResponse.getResultForSavedObject(list.get(0).getClass()));
                        apResponseHandler.onSuccess(apResponse);
                    }
                };
                if (list2.size() > 0) {
                    this.insertToLocal(list2);
                    this.insertToServer(list2, apResponseHandler2);
                }
                if (list3.size() > 0) {
                    this.updateToLocal(list3);
                    this.updateToServer(list3, apResponseHandler2);
                    break;
                }
                break;
            }
            case APLocalOnly: {
                final APDBResponse apdbResponse = new APDBResponse(true);
                if (list2.size() > 0) {
                    this.insertToLocal(list2);
                    apdbResponse.addResultList(list2);
                }
                if (list3.size() > 0) {
                    this.updateToLocal(list3);
                    apdbResponse.addResultList(list3);
                }
                apResponseHandler.onSuccess(apdbResponse);
                break;
            }
        }
        Logger.i("APEntityManager", "saveObject:end");
    }
    
    int serverSelect(final APSelect apSelect, final Map<String, Class<APObject>> aliasEntities) {
        final APResponseCountHandler apResponseCountHandler = new APResponseCountHandler();
        apResponseCountHandler.setAliasEntities(aliasEntities);
        this.serverSelect(apSelect, apResponseCountHandler);
        return apResponseCountHandler.getCount();
    }
    
    void serverSelect(final APSelect apSelect, final APResponseSelectHandler apResponseSelectHandler) {
        Logger.v("APEntityManager", "[serverSelect]:start");
        if (this.mService.getAuthToken() == null) {
            Logger.w("APEntityManager", "token is null");
            apResponseSelectHandler.onFailure(new APError("token is null", -1));
            return;
        }
        final AJSONObject json = JsonUtils.toJson(apSelect.getConditions());
        Logger.v("APEntityManager", "params=" + json.toString());
        String str = String.format("%s/%s", this.mServerInfo.getUrl("/data/query"), apSelect.getObjectClassName());
        if (apResponseSelectHandler instanceof APResponseCountHandler) {
            str += "/count";
        }
        this.mHttpClient.postForSelectWithToken(this.mContext, this.mService.getUserInfo().userTokens, str, json, apResponseSelectHandler);
        Logger.v("APEntityManager", "[serverSelect]:end");
    }
    
    void updateToServerFromLocalData(final Class<?> clazz, final String s) {
        Logger.d("APEntityManager", "[updateToServerFromLocalData]:start:" + clazz.getSimpleName());
        final APQuery apQuery = new APQuery(clazz);
        apQuery.whereEqual("objectId", s);
        this.updateToServer(this.queryToLocal(apQuery).getResultForSearchObject(clazz).getSearchResuls(), new APResponseHandler() {
            @Override
            public void onError(final String str, final Throwable t) {
                Logger.w("APEntityManager", "[updateToServerFromLocalData]:onError:" + clazz.getSimpleName() + ":" + str);
            }
            
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APEntityManager", "[updateToServerFromLocalData]:onFailure:" + clazz.getSimpleName());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APEntityManager", "[updateToServerFromLocalData]:onSuccess:" + clazz.getSimpleName());
                APEntityManager.this.removeMessageQueue(clazz.getName(), s);
            }
        });
    }
}
