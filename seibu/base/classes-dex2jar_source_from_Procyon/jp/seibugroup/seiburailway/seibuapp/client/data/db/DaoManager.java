// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import org.greenrobot.greendao.query.QueryBuilder;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.DaoSession;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.DaoMaster;

public class DaoManager
{
    private static final String DB_ENCRYPT_PASSWORD = "SEIBURAILWAY";
    private static final String DB_NAME = "app.db";
    public static final boolean ENCRYPTED = true;
    private static final String TAG;
    private static volatile DaoManager manager;
    private static DaoMaster sDaoMaster;
    private static DaoSession sDaoSession;
    private static DaoMaster.DevOpenHelper sHelper;
    private Context context;
    
    static {
        TAG = DaoManager.class.getSimpleName();
        DaoManager.manager = new DaoManager();
    }
    
    public static DaoManager getInstance() {
        return DaoManager.manager;
    }
    
    public void closeConnection() {
        this.closeHelper();
        this.closeDaoSession();
    }
    
    public void closeDaoSession() {
        if (DaoManager.sDaoSession != null) {
            DaoManager.sDaoSession.clear();
            DaoManager.sDaoSession = null;
        }
    }
    
    public void closeHelper() {
        if (DaoManager.sHelper != null) {
            DaoManager.sHelper.close();
            DaoManager.sHelper = null;
        }
    }
    
    public DaoMaster getDaoMaster() {
        if (DaoManager.sDaoMaster == null) {
            DaoManager.sDaoMaster = new DaoMaster(new DaoMaster.DevOpenHelper(this.context, "app.db").getEncryptedWritableDb("SEIBURAILWAY"));
        }
        return DaoManager.sDaoMaster;
    }
    
    public DaoSession getDaoSession() {
        if (DaoManager.sDaoSession == null) {
            if (DaoManager.sDaoMaster == null) {
                DaoManager.sDaoMaster = this.getDaoMaster();
            }
            DaoManager.sDaoSession = DaoManager.sDaoMaster.newSession();
        }
        return DaoManager.sDaoSession;
    }
    
    public void init(final Context context) {
        this.context = context;
    }
    
    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}
