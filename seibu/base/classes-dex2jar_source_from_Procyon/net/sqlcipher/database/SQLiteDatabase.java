// 
// Decompiled by Procyon v0.5.36
// 

package net.sqlcipher.database;

import java.util.Set;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.CrossProcessCursorWrapper;
import android.content.ContentValues;
import net.sqlcipher.DatabaseUtils;
import java.io.File;
import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import net.sqlcipher.Cursor;
import android.util.Pair;
import java.util.Collection;
import java.util.ArrayList;
import android.text.TextUtils;
import java.util.Iterator;
import android.os.Debug;
import android.util.Log;
import android.os.SystemClock;
import net.sqlcipher.SQLException;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.DatabaseErrorHandler;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

public class SQLiteDatabase extends SQLiteClosable
{
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "3.5.7";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
    private static int sQueryLogTimeInMillis;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private SQLiteDatabase.SQLiteDatabase$CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    
    static {
        SQLiteDatabase.sActiveDatabases = new WeakHashMap<SQLiteDatabase, Object>();
        CONFLICT_VALUES = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
        EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
        SQLiteDatabase.sQueryLogTimeInMillis = 0;
    }
    
    private SQLiteDatabase(final String mPath, final SQLiteDatabase.SQLiteDatabase$CursorFactory mFactory, final int mFlags, final DatabaseErrorHandler mErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap<String, SQLiteCompiledSql>();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap<String, SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo>();
        if (mPath == null) {
            throw new IllegalArgumentException("path should not be null");
        }
        this.mFlags = mFlags;
        this.mPath = mPath;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = mFactory;
        this.mPrograms = new WeakHashMap<SQLiteClosable, Object>();
        this.mErrorHandler = mErrorHandler;
    }
    
    public SQLiteDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n) {
        this(s, sqLiteDatabase$CursorFactory, n, null);
        this.openDatabaseInternal(array, null);
    }
    
    public SQLiteDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        this(s, sqLiteDatabase$CursorFactory, n, null);
        this.openDatabaseInternal(array, sqLiteDatabaseHook);
    }
    
    private void checkLockHoldTime() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long lng = elapsedRealtime - this.mLockAcquiredWallTime;
        if ((lng >= 2000L || Log.isLoggable("Database", 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000L) && lng > 300L) {
            final int i = (int)((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000L);
            if (i > 100 || lng > 2000L) {
                this.mLastLockMessageTime = elapsedRealtime;
                final String string = "lock held on " + this.mPath + " for " + lng + "ms. Thread time was " + i + "ms";
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d("Database", string, (Throwable)new Exception());
                    return;
                }
                Log.d("Database", string);
            }
        }
    }
    
    private void closeClosable() {
        this.deallocCachedSqlStatements();
        final Iterator<Map.Entry<SQLiteClosable, Object>> iterator = this.mPrograms.entrySet().iterator();
        while (iterator.hasNext()) {
            final SQLiteClosable sqLiteClosable = iterator.next().getKey();
            if (sqLiteClosable != null) {
                sqLiteClosable.onAllReferencesReleasedFromContainer();
            }
        }
    }
    
    private boolean containsNull(final char[] array) {
        boolean b2;
        final boolean b = b2 = false;
        if (array != null) {
            b2 = b;
            if (array.length > 0) {
                final int length = array.length;
                int n = 0;
                while (true) {
                    b2 = b;
                    if (n >= length) {
                        break;
                    }
                    if (array[n] == '\0') {
                        b2 = true;
                        break;
                    }
                    ++n;
                }
            }
        }
        return b2;
    }
    
    public static SQLiteDatabase create(final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final String s) {
        char[] charArray;
        if (s == null) {
            charArray = null;
        }
        else {
            charArray = s.toCharArray();
        }
        return openDatabase(":memory:", charArray, sqLiteDatabase$CursorFactory, 268435456);
    }
    
    public static SQLiteDatabase create(final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final char[] array) {
        return openDatabase(":memory:", array, sqLiteDatabase$CursorFactory, 268435456);
    }
    
    private native void dbclose();
    
    private native void dbopen(final String p0, final int p1);
    
    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            final Iterator<SQLiteCompiledSql> iterator = this.mCompiledQueries.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().releaseSqlStatement();
            }
        }
        this.mCompiledQueries.clear();
    }
    // monitorexit(map)
    
    private native void enableSqlProfiling(final String p0);
    
    private native void enableSqlTracing(final String p0);
    
    public static String findEditTable(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final int index = s.indexOf(32);
            final int index2 = s.indexOf(44);
            String substring;
            if (index > 0 && (index < index2 || index2 < 0)) {
                substring = s.substring(0, index);
            }
            else {
                substring = s;
                if (index2 > 0) {
                    if (index2 >= index) {
                        substring = s;
                        if (index >= 0) {
                            return substring;
                        }
                    }
                    return s.substring(0, index2);
                }
            }
            return substring;
        }
        throw new IllegalStateException("Invalid tables");
    }
    
    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        final ArrayList<SQLiteDatabase> list = new ArrayList<SQLiteDatabase>();
        synchronized (SQLiteDatabase.sActiveDatabases) {
            list.addAll(SQLiteDatabase.sActiveDatabases.keySet());
            return list;
        }
    }
    
    private static ArrayList<Pair<String, String>> getAttachedDbs(final SQLiteDatabase sqLiteDatabase) {
        if (!sqLiteDatabase.isOpen()) {
            return null;
        }
        final ArrayList<Pair> list = (ArrayList<Pair>)new ArrayList<Pair<String, String>>();
        final Cursor rawQuery = sqLiteDatabase.rawQuery("pragma database_list;", null);
        while (rawQuery.moveToNext()) {
            list.add(new Pair((Object)rawQuery.getString(1), (Object)rawQuery.getString(2)));
        }
        rawQuery.close();
        return (ArrayList<Pair<String, String>>)list;
    }
    
    private byte[] getBytes(final char[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        final ByteBuffer encode = Charset.forName("UTF-8").encode(CharBuffer.wrap(array));
        final byte[] dst = new byte[encode.limit()];
        encode.get(dst);
        return dst;
    }
    
    static ArrayList<SQLiteDebug$DbStats> getDbStats() {
        final ArrayList<SQLiteDebug$DbStats> list = new ArrayList<SQLiteDebug$DbStats>();
        for (final SQLiteDatabase sqLiteDatabase : getActiveDatabases()) {
            if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
                int native_getDbLookaside = sqLiteDatabase.native_getDbLookaside();
                final String path = sqLiteDatabase.getPath();
                final int lastIndex = path.lastIndexOf("/");
                int beginIndex;
                if (lastIndex != -1) {
                    beginIndex = lastIndex + 1;
                }
                else {
                    beginIndex = 0;
                }
                final String substring = path.substring(beginIndex);
                final ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(sqLiteDatabase);
                if (attachedDbs == null) {
                    continue;
                }
                for (int i = 0; i < attachedDbs.size(); ++i) {
                    final Pair<String, String> pair = attachedDbs.get(i);
                    final long pragmaVal = getPragmaVal(sqLiteDatabase, (String)pair.first + ".page_count;");
                    String str;
                    if (i == 0) {
                        str = substring;
                    }
                    else {
                        final int n = 0;
                        str = "  (attached) " + (String)pair.first;
                        native_getDbLookaside = n;
                        if (((String)pair.second).trim().length() > 0) {
                            final int lastIndex2 = ((String)pair.second).lastIndexOf("/");
                            final StringBuilder append = new StringBuilder().append(str).append(" : ");
                            final String s = (String)pair.second;
                            int beginIndex2;
                            if (lastIndex2 != -1) {
                                beginIndex2 = lastIndex2 + 1;
                            }
                            else {
                                beginIndex2 = 0;
                            }
                            str = append.append(s.substring(beginIndex2)).toString();
                            native_getDbLookaside = n;
                        }
                    }
                    if (pragmaVal > 0L) {
                        list.add(new SQLiteDebug$DbStats(str, pragmaVal, sqLiteDatabase.getPageSize(), native_getDbLookaside));
                    }
                }
            }
        }
        return list;
    }
    
    private String getPathForLogs() {
        if (this.mPathForLogs != null) {
            return this.mPathForLogs;
        }
        if (this.mPath == null) {
            return null;
        }
        if (this.mPath.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        }
        else {
            this.mPathForLogs = SQLiteDatabase.EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }
    
    private static long getPragmaVal(SQLiteDatabase sqLiteDatabase, final String str) {
        long simpleQueryForLong;
        if (!sqLiteDatabase.isOpen()) {
            simpleQueryForLong = 0L;
        }
        else {
            final SQLiteDatabase sqLiteDatabase2 = null;
            try {
                final Object o;
                sqLiteDatabase = (SQLiteDatabase)(o = new SQLiteStatement(sqLiteDatabase, "PRAGMA " + str));
                final long simpleQueryForLong2 = ((SQLiteStatement)o).simpleQueryForLong();
                simpleQueryForLong = simpleQueryForLong2;
                final SQLiteDatabase sqLiteDatabase3 = sqLiteDatabase;
                if (sqLiteDatabase3 != null) {
                    final SQLiteDatabase sqLiteDatabase4 = sqLiteDatabase;
                    ((SQLiteStatement)sqLiteDatabase4).close();
                    return simpleQueryForLong2;
                }
                return simpleQueryForLong;
            }
            finally {
                final Throwable t2;
                final Throwable t = t2;
                sqLiteDatabase = sqLiteDatabase2;
            }
            while (true) {
                try {
                    final Object o = sqLiteDatabase;
                    final long simpleQueryForLong2 = simpleQueryForLong = ((SQLiteStatement)o).simpleQueryForLong();
                    final SQLiteDatabase sqLiteDatabase3 = sqLiteDatabase;
                    if (sqLiteDatabase3 != null) {
                        final SQLiteDatabase sqLiteDatabase4 = sqLiteDatabase;
                        ((SQLiteStatement)sqLiteDatabase4).close();
                        return simpleQueryForLong2;
                    }
                    return simpleQueryForLong;
                    final Throwable t;
                    Label_0075: {
                        throw t;
                    }
                    // iftrue(Label_0075:, sqLiteDatabase == null)
                    ((SQLiteStatement)sqLiteDatabase).close();
                    throw t;
                }
                finally {
                    continue;
                }
                break;
            }
        }
        return simpleQueryForLong;
    }
    
    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(System.currentTimeMillis());
    }
    
    private native void key(final byte[] p0) throws SQLException;
    
    private void keyDatabase(final SQLiteDatabaseHook sqLiteDatabaseHook, final Runnable runnable) {
        if (sqLiteDatabaseHook != null) {
            sqLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sqLiteDatabaseHook != null) {
            sqLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = this.getTime();
        }
        try {
            final Cursor rawQuery = this.rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        }
        catch (RuntimeException ex) {
            Log.e("Database", ex.getMessage(), (Throwable)ex);
            throw ex;
        }
    }
    
    private native void key_mutf8(final char[] p0) throws SQLException;
    
    private static void loadICUData(final Context p0, final File p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          9
        //     3: aconst_null    
        //     4: astore          7
        //     6: aconst_null    
        //     7: astore          5
        //     9: aconst_null    
        //    10: astore          6
        //    12: aconst_null    
        //    13: astore          10
        //    15: aconst_null    
        //    16: astore          4
        //    18: aconst_null    
        //    19: astore          8
        //    21: new             Ljava/io/File;
        //    24: dup            
        //    25: aload_1        
        //    26: ldc_w           "icu"
        //    29: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    32: astore          12
        //    34: new             Ljava/io/File;
        //    37: dup            
        //    38: aload           12
        //    40: ldc_w           "icudt46l.dat"
        //    43: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    46: astore          11
        //    48: aload           10
        //    50: astore_1       
        //    51: aload           9
        //    53: astore_3       
        //    54: aload           12
        //    56: invokevirtual   java/io/File.exists:()Z
        //    59: ifne            74
        //    62: aload           10
        //    64: astore_1       
        //    65: aload           9
        //    67: astore_3       
        //    68: aload           12
        //    70: invokevirtual   java/io/File.mkdirs:()Z
        //    73: pop            
        //    74: aload           10
        //    76: astore_1       
        //    77: aload           9
        //    79: astore_3       
        //    80: aload           11
        //    82: invokevirtual   java/io/File.exists:()Z
        //    85: ifne            242
        //    88: aload           10
        //    90: astore_1       
        //    91: aload           9
        //    93: astore_3       
        //    94: new             Ljava/util/zip/ZipInputStream;
        //    97: dup            
        //    98: aload_0        
        //    99: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //   102: ldc_w           "icudt46l.zip"
        //   105: invokevirtual   android/content/res/AssetManager.open:(Ljava/lang/String;)Ljava/io/InputStream;
        //   108: invokespecial   java/util/zip/ZipInputStream.<init>:(Ljava/io/InputStream;)V
        //   111: astore_0       
        //   112: aload_0        
        //   113: invokevirtual   java/util/zip/ZipInputStream.getNextEntry:()Ljava/util/zip/ZipEntry;
        //   116: pop            
        //   117: new             Ljava/io/FileOutputStream;
        //   120: dup            
        //   121: aload           11
        //   123: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   126: astore_1       
        //   127: sipush          1024
        //   130: newarray        B
        //   132: astore_3       
        //   133: aload_0        
        //   134: aload_3        
        //   135: invokevirtual   java/util/zip/ZipInputStream.read:([B)I
        //   138: istore_2       
        //   139: iload_2        
        //   140: ifle            236
        //   143: aload_1        
        //   144: aload_3        
        //   145: iconst_0       
        //   146: iload_2        
        //   147: invokevirtual   java/io/OutputStream.write:([BII)V
        //   150: goto            133
        //   153: astore          4
        //   155: aload_1        
        //   156: astore          5
        //   158: aload_0        
        //   159: astore_1       
        //   160: aload           5
        //   162: astore_3       
        //   163: ldc             "Database"
        //   165: ldc_w           "Error copying icu dat file"
        //   168: aload           4
        //   170: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   173: pop            
        //   174: aload_0        
        //   175: astore_1       
        //   176: aload           5
        //   178: astore_3       
        //   179: aload           11
        //   181: invokevirtual   java/io/File.exists:()Z
        //   184: ifeq            198
        //   187: aload_0        
        //   188: astore_1       
        //   189: aload           5
        //   191: astore_3       
        //   192: aload           11
        //   194: invokevirtual   java/io/File.delete:()Z
        //   197: pop            
        //   198: aload_0        
        //   199: astore_1       
        //   200: aload           5
        //   202: astore_3       
        //   203: new             Ljava/lang/RuntimeException;
        //   206: dup            
        //   207: aload           4
        //   209: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   212: athrow         
        //   213: astore_0       
        //   214: aload_1        
        //   215: ifnull          222
        //   218: aload_1        
        //   219: invokevirtual   java/util/zip/ZipInputStream.close:()V
        //   222: aload_3        
        //   223: ifnull          234
        //   226: aload_3        
        //   227: invokevirtual   java/io/OutputStream.flush:()V
        //   230: aload_3        
        //   231: invokevirtual   java/io/OutputStream.close:()V
        //   234: aload_0        
        //   235: athrow         
        //   236: aload_1        
        //   237: astore          5
        //   239: aload_0        
        //   240: astore          4
        //   242: aload           4
        //   244: ifnull          252
        //   247: aload           4
        //   249: invokevirtual   java/util/zip/ZipInputStream.close:()V
        //   252: aload           5
        //   254: ifnull          267
        //   257: aload           5
        //   259: invokevirtual   java/io/OutputStream.flush:()V
        //   262: aload           5
        //   264: invokevirtual   java/io/OutputStream.close:()V
        //   267: return         
        //   268: astore_0       
        //   269: ldc             "Database"
        //   271: ldc_w           "Error in closing streams IO streams after expanding ICU dat file"
        //   274: aload_0        
        //   275: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   278: pop            
        //   279: new             Ljava/lang/RuntimeException;
        //   282: dup            
        //   283: aload_0        
        //   284: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   287: athrow         
        //   288: astore_0       
        //   289: ldc             "Database"
        //   291: ldc_w           "Error in closing streams IO streams after expanding ICU dat file"
        //   294: aload_0        
        //   295: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   298: pop            
        //   299: new             Ljava/lang/RuntimeException;
        //   302: dup            
        //   303: aload_0        
        //   304: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   307: athrow         
        //   308: astore          4
        //   310: aload_0        
        //   311: astore_1       
        //   312: aload           7
        //   314: astore_3       
        //   315: aload           4
        //   317: astore_0       
        //   318: goto            214
        //   321: astore          4
        //   323: aload_1        
        //   324: astore_3       
        //   325: aload_0        
        //   326: astore_1       
        //   327: aload           4
        //   329: astore_0       
        //   330: goto            214
        //   333: astore          4
        //   335: aload           8
        //   337: astore_0       
        //   338: aload           6
        //   340: astore          5
        //   342: goto            158
        //   345: astore          4
        //   347: aload           6
        //   349: astore          5
        //   351: goto            158
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  54     62     333    345    Ljava/lang/Exception;
        //  54     62     213    214    Any
        //  68     74     333    345    Ljava/lang/Exception;
        //  68     74     213    214    Any
        //  80     88     333    345    Ljava/lang/Exception;
        //  80     88     213    214    Any
        //  94     112    333    345    Ljava/lang/Exception;
        //  94     112    213    214    Any
        //  112    127    345    354    Ljava/lang/Exception;
        //  112    127    308    321    Any
        //  127    133    153    158    Ljava/lang/Exception;
        //  127    133    321    333    Any
        //  133    139    153    158    Ljava/lang/Exception;
        //  133    139    321    333    Any
        //  143    150    153    158    Ljava/lang/Exception;
        //  143    150    321    333    Any
        //  163    174    213    214    Any
        //  179    187    213    214    Any
        //  192    198    213    214    Any
        //  203    213    213    214    Any
        //  218    222    288    308    Ljava/io/IOException;
        //  226    234    288    308    Ljava/io/IOException;
        //  247    252    268    288    Ljava/io/IOException;
        //  257    267    268    288    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0133:
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
    
    public static void loadLibs(final Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }
    
    public static void loadLibs(final Context context, final File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, (SQLiteDatabase.SQLiteDatabase$LibraryLoader)new SQLiteDatabase$1());
        }
    }
    
    public static void loadLibs(final Context context, final File file, final SQLiteDatabase.SQLiteDatabase$LibraryLoader sqLiteDatabase$LibraryLoader) {
        synchronized (SQLiteDatabase.class) {
            sqLiteDatabase$LibraryLoader.loadLibraries(new String[] { "sqlcipher" });
        }
    }
    
    public static void loadLibs(final Context context, final SQLiteDatabase.SQLiteDatabase$LibraryLoader sqLiteDatabase$LibraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), sqLiteDatabase$LibraryLoader);
        }
    }
    
    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }
    
    private void markTableSyncable(final String str, String mSyncUpdateInfo, final String str2, final String s) {
        this.lock();
        SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo sqLiteDatabase$SyncUpdateInfo;
        try {
            this.native_execSQL("SELECT _sync_dirty FROM " + str2 + " LIMIT 0");
            this.native_execSQL("SELECT " + mSyncUpdateInfo + " FROM " + str + " LIMIT 0");
            this.unlock();
            sqLiteDatabase$SyncUpdateInfo = new SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo(str2, s, mSyncUpdateInfo);
            mSyncUpdateInfo = (String)this.mSyncUpdateInfo;
            // monitorenter(mSyncUpdateInfo)
            final SQLiteDatabase sqLiteDatabase = this;
            final Map<String, SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo> map = sqLiteDatabase.mSyncUpdateInfo;
            final String s2 = str;
            final SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo sqLiteDatabase$SyncUpdateInfo2 = sqLiteDatabase$SyncUpdateInfo;
            map.put(s2, sqLiteDatabase$SyncUpdateInfo2);
            return;
        }
        finally {
            this.unlock();
        }
        try {
            final SQLiteDatabase sqLiteDatabase = this;
            final Map<String, SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo> map = sqLiteDatabase.mSyncUpdateInfo;
            final String s2 = str;
            final SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo sqLiteDatabase$SyncUpdateInfo2 = sqLiteDatabase$SyncUpdateInfo;
            map.put(s2, sqLiteDatabase$SyncUpdateInfo2);
        }
        finally {
        }
        // monitorexit(mSyncUpdateInfo)
    }
    
    private native int native_getDbLookaside();
    
    private native void native_key(final char[] p0) throws SQLException;
    
    private native void native_rawExecSQL(final String p0);
    
    private native void native_rekey(final String p0) throws SQLException;
    
    private native int native_status(final int p0, final boolean p1);
    
    public static SQLiteDatabase openDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n) {
        return openDatabase(s, s2, sqLiteDatabase$CursorFactory, n, null);
    }
    
    public static SQLiteDatabase openDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        return openDatabase(s, s2, sqLiteDatabase$CursorFactory, n, sqLiteDatabaseHook, null);
    }
    
    public static SQLiteDatabase openDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n, final SQLiteDatabaseHook sqLiteDatabaseHook, final DatabaseErrorHandler databaseErrorHandler) {
        char[] charArray;
        if (s2 == null) {
            charArray = null;
        }
        else {
            charArray = s2.toCharArray();
        }
        return openDatabase(s, charArray, sqLiteDatabase$CursorFactory, n, sqLiteDatabaseHook, databaseErrorHandler);
    }
    
    public static SQLiteDatabase openDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n) {
        return openDatabase(s, array, sqLiteDatabase$CursorFactory, n, null, null);
    }
    
    public static SQLiteDatabase openDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        return openDatabase(s, array, sqLiteDatabase$CursorFactory, n, sqLiteDatabaseHook, null);
    }
    
    public static SQLiteDatabase openDatabase(final String p0, final char[] p1, final SQLiteDatabase.SQLiteDatabase$CursorFactory p2, final int p3, final SQLiteDatabaseHook p4, final DatabaseErrorHandler p5) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          7
        //     3: aload           5
        //     5: ifnull          74
        //     8: new             Lnet/sqlcipher/database/SQLiteDatabase;
        //    11: dup            
        //    12: aload_0        
        //    13: aload_2        
        //    14: iload_3        
        //    15: aload           5
        //    17: invokespecial   net/sqlcipher/database/SQLiteDatabase.<init>:(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/DatabaseErrorHandler;)V
        //    20: astore          6
        //    22: aload           6
        //    24: aload_1        
        //    25: aload           4
        //    27: invokespecial   net/sqlcipher/database/SQLiteDatabase.openDatabaseInternal:([CLnet/sqlcipher/database/SQLiteDatabaseHook;)V
        //    30: aload           6
        //    32: astore_1       
        //    33: getstatic       net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_STATEMENTS:Z
        //    36: ifeq            44
        //    39: aload_1        
        //    40: aload_0        
        //    41: invokespecial   net/sqlcipher/database/SQLiteDatabase.enableSqlTracing:(Ljava/lang/String;)V
        //    44: getstatic       net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_TIME:Z
        //    47: ifeq            55
        //    50: aload_1        
        //    51: aload_0        
        //    52: invokespecial   net/sqlcipher/database/SQLiteDatabase.enableSqlProfiling:(Ljava/lang/String;)V
        //    55: getstatic       net/sqlcipher/database/SQLiteDatabase.sActiveDatabases:Ljava/util/WeakHashMap;
        //    58: astore_0       
        //    59: aload_0        
        //    60: monitorenter   
        //    61: getstatic       net/sqlcipher/database/SQLiteDatabase.sActiveDatabases:Ljava/util/WeakHashMap;
        //    64: aload_1        
        //    65: aconst_null    
        //    66: invokevirtual   java/util/WeakHashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: pop            
        //    70: aload_0        
        //    71: monitorexit    
        //    72: aload_1        
        //    73: areturn        
        //    74: new             Lnet/sqlcipher/DefaultDatabaseErrorHandler;
        //    77: dup            
        //    78: invokespecial   net/sqlcipher/DefaultDatabaseErrorHandler.<init>:()V
        //    81: astore          5
        //    83: goto            8
        //    86: astore          6
        //    88: ldc             "Database"
        //    90: new             Ljava/lang/StringBuilder;
        //    93: dup            
        //    94: invokespecial   java/lang/StringBuilder.<init>:()V
        //    97: ldc_w           "Calling error handler for corrupt database "
        //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: aload_0        
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   110: aload           6
        //   112: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   115: pop            
        //   116: aload           5
        //   118: aload           7
        //   120: invokeinterface net/sqlcipher/DatabaseErrorHandler.onCorruption:(Lnet/sqlcipher/database/SQLiteDatabase;)V
        //   125: new             Lnet/sqlcipher/database/SQLiteDatabase;
        //   128: dup            
        //   129: aload_0        
        //   130: aload_2        
        //   131: iload_3        
        //   132: aload           5
        //   134: invokespecial   net/sqlcipher/database/SQLiteDatabase.<init>:(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/DatabaseErrorHandler;)V
        //   137: astore_2       
        //   138: aload_2        
        //   139: aload_1        
        //   140: aload           4
        //   142: invokespecial   net/sqlcipher/database/SQLiteDatabase.openDatabaseInternal:([CLnet/sqlcipher/database/SQLiteDatabaseHook;)V
        //   145: aload_2        
        //   146: astore_1       
        //   147: goto            33
        //   150: astore_1       
        //   151: aload_0        
        //   152: monitorexit    
        //   153: aload_1        
        //   154: athrow         
        //   155: astore          8
        //   157: aload           6
        //   159: astore          7
        //   161: aload           8
        //   163: astore          6
        //   165: goto            88
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                   
        //  -----  -----  -----  -----  -------------------------------------------------------
        //  8      22     86     88     Lnet/sqlcipher/database/SQLiteDatabaseCorruptException;
        //  22     30     155    168    Lnet/sqlcipher/database/SQLiteDatabaseCorruptException;
        //  61     72     150    155    Any
        //  151    153    150    155    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    private void openDatabaseInternal(final char[] array, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        int length = 0;
        int length2 = 0;
        int i = 0;
        final byte[] bytes = this.getBytes(array);
        this.dbopen(this.mPath, this.mFlags);
        try {
            this.keyDatabase(sqLiteDatabaseHook, (Runnable)new SQLiteDatabase$2(this, bytes));
            if (false) {
                this.dbclose();
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    this.mTimeClosed = this.getTime();
                }
            }
            if (bytes != null && bytes.length > 0) {
                for (length = bytes.length; i < length; ++i) {
                    length2 = bytes[i];
                }
            }
        }
        catch (RuntimeException ex) {
            if (!this.containsNull(array)) {
                throw ex;
            }
            this.keyDatabase(sqLiteDatabaseHook, (Runnable)new SQLiteDatabase$3(this, array));
            if (bytes != null && bytes.length > 0) {
                this.rekey(bytes);
            }
            if (false) {
                this.dbclose();
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    this.mTimeClosed = this.getTime();
                }
            }
            if (bytes != null && bytes.length > 0) {
                length2 = bytes.length;
                for (int j = length; j < length2; ++j) {
                    final byte b = bytes[j];
                }
            }
        }
        finally {
            if (true) {
                this.dbclose();
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    this.mTimeClosed = this.getTime();
                }
            }
            if (bytes != null && bytes.length > 0) {
                for (int length3 = bytes.length, k = length2; k < length3; ++k) {
                    final byte b2 = bytes[k];
                }
            }
        }
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final File file, final String s, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory) {
        return openOrCreateDatabase(file, s, sqLiteDatabase$CursorFactory, null);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final File file, final String s, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        return openOrCreateDatabase(file, s, sqLiteDatabase$CursorFactory, sqLiteDatabaseHook, null);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final File file, final String s, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook, final DatabaseErrorHandler databaseErrorHandler) {
        String path;
        if (file == null) {
            path = null;
        }
        else {
            path = file.getPath();
        }
        return openOrCreateDatabase(path, s, sqLiteDatabase$CursorFactory, sqLiteDatabaseHook, databaseErrorHandler);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory) {
        return openDatabase(s, s2, sqLiteDatabase$CursorFactory, 268435456, null);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        return openDatabase(s, s2, sqLiteDatabase$CursorFactory, 268435456, sqLiteDatabaseHook);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final String s2, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook, final DatabaseErrorHandler databaseErrorHandler) {
        char[] charArray;
        if (s2 == null) {
            charArray = null;
        }
        else {
            charArray = s2.toCharArray();
        }
        return openDatabase(s, charArray, sqLiteDatabase$CursorFactory, 268435456, sqLiteDatabaseHook, databaseErrorHandler);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory) {
        return openDatabase(s, array, sqLiteDatabase$CursorFactory, 268435456, null);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook) {
        return openDatabase(s, array, sqLiteDatabase$CursorFactory, 268435456, sqLiteDatabaseHook);
    }
    
    public static SQLiteDatabase openOrCreateDatabase(final String s, final char[] array, final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final SQLiteDatabaseHook sqLiteDatabaseHook, final DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(s, array, sqLiteDatabase$CursorFactory, 268435456, sqLiteDatabaseHook, databaseErrorHandler);
    }
    
    private native void rekey(final byte[] p0) throws SQLException;
    
    public static native int releaseMemory();
    
    public static native void setICURoot(final String p0);
    
    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.checkLockHoldTime();
        }
        this.mLock.unlock();
    }
    
    private boolean yieldIfContendedHelper(final boolean b, long n) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        this.setTransactionSuccessful();
        final SQLiteTransactionListener mTransactionListener = this.mTransactionListener;
        this.endTransaction();
        if (b && this.isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        Label_0106: {
            if (n <= 0L) {
                break Label_0106;
            }
            long n2;
            Label_0085_Outer:Label_0090_Outer:
            while (true) {
                if (n <= 0L) {
                    break Label_0106;
                }
                Label_0114: {
                    if (n >= 1000L) {
                        break Label_0114;
                    }
                    n2 = n;
                    while (true) {
                        try {
                            while (true) {
                                Thread.sleep(n2);
                                n -= 1000L;
                                if (this.mLock.getQueueLength() == 0) {
                                    this.beginTransactionWithListener(mTransactionListener);
                                    return true;
                                }
                                continue Label_0085_Outer;
                                n2 = 1000L;
                                continue Label_0090_Outer;
                            }
                        }
                        catch (InterruptedException ex) {
                            Thread.interrupted();
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    void addSQLiteClosable(final SQLiteClosable key) {
        this.lock();
        try {
            this.mPrograms.put(key, null);
        }
        finally {
            this.unlock();
        }
    }
    
    void addToCompiledQueries(final String str, final SQLiteCompiledSql sqLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                Log.v("Database", "|NOT adding_sql_to_cache|" + this.getPath() + "|" + str);
            }
            return;
        }
        synchronized (this.mCompiledQueries) {
            if (this.mCompiledQueries.get(str) != null) {
                return;
            }
        }
        if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
            if (++this.mCacheFullWarnings == 1) {
                final String s;
                Log.w("Database", "Reached MAX size for compiled-sql statement cache for database " + this.getPath() + "; i.e., NO space for this sql statement in cache: " + s + ". Please change your sql statements to use '?' for " + "bindargs, instead of using actual values");
            }
        }
        else {
            final String s;
            this.mCompiledQueries.put(s, sqLiteCompiledSql);
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                Log.v("Database", "|adding_sql_to_cache|" + this.getPath() + "|" + this.mCompiledQueries.size() + "|" + s);
            }
        }
    }
    // monitorexit(map)
    
    public void beginTransaction() {
        this.beginTransactionWithListener(null);
    }
    
    public void beginTransactionWithListener(final SQLiteTransactionListener sqLiteTransactionListener) {
        this.lockForced();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        Label_0083: {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    break Label_0083;
                }
                if (this.mInnerTransactionIsSuccessful) {
                    final IllegalStateException ex = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    Log.e("Database", "beginTransaction() failed", (Throwable)ex);
                    throw ex;
                }
            }
            finally {
                if (!false) {
                    this.unlockForced();
                }
            }
            if (!true) {
                this.unlockForced();
            }
            return;
        }
        this.execSQL("BEGIN EXCLUSIVE;");
        final SQLiteTransactionListener mTransactionListener;
        this.mTransactionListener = mTransactionListener;
        this.mTransactionIsSuccessful = true;
        this.mInnerTransactionIsSuccessful = false;
        Label_0115: {
            if (mTransactionListener == null) {
                break Label_0115;
            }
            try {
                mTransactionListener.onBegin();
                if (!true) {
                    this.unlockForced();
                }
            }
            catch (RuntimeException ex2) {
                this.execSQL("ROLLBACK;");
            }
        }
    }
    
    public void changePassword(final String s) throws SQLiteException {
        if (!this.isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (s != null) {
            final byte[] bytes = this.getBytes(s.toCharArray());
            this.rekey(bytes);
            for (int length = bytes.length, i = 0; i < length; ++i) {
                final byte b = bytes[i];
            }
        }
    }
    
    public void changePassword(final char[] array) throws SQLiteException {
        if (!this.isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (array != null) {
            final byte[] bytes = this.getBytes(array);
            this.rekey(bytes);
            for (int length = bytes.length, i = 0; i < length; ++i) {
                final byte b = bytes[i];
            }
        }
    }
    
    public void close() {
        if (!this.isOpen()) {
            return;
        }
        this.lock();
        try {
            this.closeClosable();
            this.onAllReferencesReleased();
        }
        finally {
            this.unlock();
        }
    }
    
    public SQLiteStatement compileStatement(final String s) throws SQLException {
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        try {
            return new SQLiteStatement(this, s);
        }
        finally {
            this.unlock();
        }
    }
    
    public int delete(String string, final String str, final String[] array) {
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        while (true) {
            final SQLiteStatement sqLiteStatement = null;
            SQLiteStatement sqLiteStatement3;
            final SQLiteStatement sqLiteStatement2 = sqLiteStatement3 = null;
            SQLiteStatement sqLiteStatement4 = sqLiteStatement;
            while (true) {
                try {
                    final StringBuilder append = new StringBuilder().append("DELETE FROM ").append(string);
                    sqLiteStatement3 = sqLiteStatement2;
                    sqLiteStatement4 = sqLiteStatement;
                    if (!TextUtils.isEmpty((CharSequence)str)) {
                        sqLiteStatement3 = sqLiteStatement2;
                        sqLiteStatement4 = sqLiteStatement;
                        string = " WHERE " + str;
                        sqLiteStatement3 = sqLiteStatement2;
                        sqLiteStatement4 = sqLiteStatement;
                        final SQLiteStatement compileStatement = this.compileStatement(append.append(string).toString());
                        if (array != null) {
                            sqLiteStatement3 = compileStatement;
                            sqLiteStatement4 = compileStatement;
                            for (int length = array.length, i = 0; i < length; ++i) {
                                sqLiteStatement3 = compileStatement;
                                sqLiteStatement4 = compileStatement;
                                DatabaseUtils.bindObjectToProgram((SQLiteProgram)compileStatement, i + 1, (Object)array[i]);
                            }
                        }
                        sqLiteStatement3 = compileStatement;
                        sqLiteStatement4 = compileStatement;
                        compileStatement.execute();
                        sqLiteStatement3 = compileStatement;
                        sqLiteStatement4 = compileStatement;
                        return this.lastChangeCount();
                    }
                }
                catch (SQLiteDatabaseCorruptException ex) {
                    sqLiteStatement4 = sqLiteStatement3;
                    this.onCorruption();
                    sqLiteStatement4 = sqLiteStatement3;
                    throw ex;
                }
                finally {
                    if (sqLiteStatement4 != null) {
                        sqLiteStatement4.close();
                    }
                    this.unlock();
                }
                string = "";
                continue;
            }
        }
    }
    
    public void endTransaction() {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        try {
            if (this.mInnerTransactionIsSuccessful) {
                this.mInnerTransactionIsSuccessful = false;
            }
            else {
                this.mTransactionIsSuccessful = false;
            }
            if (this.mLock.getHoldCount() != 1) {
                return;
            }
        }
        finally {
            this.mTransactionListener = null;
            this.unlockForced();
        }
        final RuntimeException ex = null;
        final SQLiteTransactionListener mTransactionListener = this.mTransactionListener;
        RuntimeException ex2 = ex;
    Label_0127:
        while (true) {
            if (mTransactionListener == null) {
                break Label_0127;
            }
            while (true) {
                while (true) {
                    Label_0173: {
                        try {
                            if (this.mTransactionIsSuccessful) {
                                this.mTransactionListener.onCommit();
                                ex2 = ex;
                            }
                            else {
                                this.mTransactionListener.onRollback();
                                ex2 = ex;
                            }
                            if (this.mTransactionIsSuccessful) {
                                this.execSQL("COMMIT;");
                                this.mTransactionListener = null;
                                this.unlockForced();
                                return;
                            }
                            break Label_0173;
                        }
                        catch (RuntimeException ex2) {
                            this.mTransactionIsSuccessful = false;
                            continue Label_0127;
                        }
                        continue Label_0127;
                        try {
                            this.execSQL("ROLLBACK;");
                            if (ex2 != null) {
                                throw ex2;
                            }
                            continue;
                        }
                        catch (SQLException ex3) {
                            Log.d("Database", "exception during rollback, maybe the DB previously performed an auto-rollback");
                            continue;
                        }
                    }
                    break;
                }
            }
            break;
        }
    }
    
    public void execSQL(final String s) throws SQLException {
        SystemClock.uptimeMillis();
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        try {
            this.native_execSQL(s);
        }
        catch (SQLiteDatabaseCorruptException ex) {
            this.onCorruption();
            throw ex;
        }
        finally {
            this.unlock();
        }
    }
    
    public void execSQL(final String s, final Object[] array) throws SQLException {
        if (array == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        SystemClock.uptimeMillis();
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        SQLiteStatement sqLiteStatement = null;
        SQLiteStatement sqLiteStatement2 = null;
        try {
            final SQLiteStatement compileStatement = this.compileStatement(s);
            if (array != null) {
                sqLiteStatement2 = compileStatement;
                sqLiteStatement = compileStatement;
                for (int length = array.length, i = 0; i < length; ++i) {
                    sqLiteStatement2 = compileStatement;
                    sqLiteStatement = compileStatement;
                    DatabaseUtils.bindObjectToProgram((SQLiteProgram)compileStatement, i + 1, array[i]);
                }
            }
            sqLiteStatement2 = compileStatement;
            sqLiteStatement = compileStatement;
            compileStatement.execute();
        }
        catch (SQLiteDatabaseCorruptException ex) {
            sqLiteStatement = sqLiteStatement2;
            this.onCorruption();
            sqLiteStatement = sqLiteStatement2;
            throw ex;
        }
        finally {
            if (sqLiteStatement != null) {
                sqLiteStatement.close();
            }
            this.unlock();
        }
    }
    
    protected void finalize() {
        if (this.isOpen()) {
            Log.e("Database", "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
            this.closeClosable();
            this.onAllReferencesReleased();
        }
    }
    
    SQLiteCompiledSql getCompiledStatementForSql(final String str) {
        while (true) {
            while (true) {
                synchronized (this.mCompiledQueries) {
                    if (this.mMaxSqlCacheSize == 0) {
                        if (SQLiteDebug.DEBUG_SQL_CACHE) {
                            Log.v("Database", "|cache NOT found|" + this.getPath());
                        }
                        return null;
                    }
                    final SQLiteCompiledSql sqLiteCompiledSql = this.mCompiledQueries.get(str);
                    final boolean b = sqLiteCompiledSql != null;
                    // monitorexit(this.mCompiledQueries)
                    if (b) {
                        ++this.mNumCacheHits;
                        if (SQLiteDebug.DEBUG_SQL_CACHE) {
                            Log.v("Database", "|cache_stats|" + this.getPath() + "|" + this.mCompiledQueries.size() + "|" + this.mNumCacheHits + "|" + this.mNumCacheMisses + "|" + b + "|" + this.mTimeOpened + "|" + this.mTimeClosed + "|" + str);
                        }
                        return sqLiteCompiledSql;
                    }
                }
                ++this.mNumCacheMisses;
                continue;
            }
        }
    }
    
    public int getMaxSqlCacheSize() {
        synchronized (this) {
            return this.mMaxSqlCacheSize;
        }
    }
    
    public long getMaximumSize() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          5
        //     3: aload_0        
        //     4: invokevirtual   net/sqlcipher/database/SQLiteDatabase.lock:()V
        //     7: aload_0        
        //     8: invokevirtual   net/sqlcipher/database/SQLiteDatabase.isOpen:()Z
        //    11: ifne            25
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc_w           "database not open"
        //    21: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    24: athrow         
        //    25: new             Lnet/sqlcipher/database/SQLiteStatement;
        //    28: dup            
        //    29: aload_0        
        //    30: ldc_w           "PRAGMA max_page_count;"
        //    33: invokespecial   net/sqlcipher/database/SQLiteStatement.<init>:(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
        //    36: astore          7
        //    38: aload           7
        //    40: invokevirtual   net/sqlcipher/database/SQLiteStatement.simpleQueryForLong:()J
        //    43: lstore_1       
        //    44: aload_0        
        //    45: invokevirtual   net/sqlcipher/database/SQLiteDatabase.getPageSize:()J
        //    48: lstore_3       
        //    49: aload           7
        //    51: ifnull          59
        //    54: aload           7
        //    56: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    59: aload_0        
        //    60: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    63: lload_3        
        //    64: lload_1        
        //    65: lmul           
        //    66: lreturn        
        //    67: astore          6
        //    69: aload           5
        //    71: ifnull          79
        //    74: aload           5
        //    76: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    79: aload_0        
        //    80: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    83: aload           6
        //    85: athrow         
        //    86: astore          6
        //    88: aload           7
        //    90: astore          5
        //    92: goto            69
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     38     67     69     Any
        //  38     49     86     95     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0059:
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
    
    public long getPageSize() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3       
        //     2: aload_0        
        //     3: invokevirtual   net/sqlcipher/database/SQLiteDatabase.lock:()V
        //     6: aload_0        
        //     7: invokevirtual   net/sqlcipher/database/SQLiteDatabase.isOpen:()Z
        //    10: ifne            24
        //    13: new             Ljava/lang/IllegalStateException;
        //    16: dup            
        //    17: ldc_w           "database not open"
        //    20: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    23: athrow         
        //    24: new             Lnet/sqlcipher/database/SQLiteStatement;
        //    27: dup            
        //    28: aload_0        
        //    29: ldc_w           "PRAGMA page_size;"
        //    32: invokespecial   net/sqlcipher/database/SQLiteStatement.<init>:(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
        //    35: astore          5
        //    37: aload           5
        //    39: invokevirtual   net/sqlcipher/database/SQLiteStatement.simpleQueryForLong:()J
        //    42: lstore_1       
        //    43: aload           5
        //    45: ifnull          53
        //    48: aload           5
        //    50: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    53: aload_0        
        //    54: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    57: lload_1        
        //    58: lreturn        
        //    59: astore          4
        //    61: aload_3        
        //    62: ifnull          69
        //    65: aload_3        
        //    66: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    69: aload_0        
        //    70: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    73: aload           4
        //    75: athrow         
        //    76: astore          4
        //    78: aload           5
        //    80: astore_3       
        //    81: goto            61
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  24     37     59     61     Any
        //  37     43     76     84     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
    
    public final String getPath() {
        return this.mPath;
    }
    
    public Map<String, String> getSyncedTables() {
        synchronized (this.mSyncUpdateInfo) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            for (final String key : this.mSyncUpdateInfo.keySet()) {
                final SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo sqLiteDatabase$SyncUpdateInfo = this.mSyncUpdateInfo.get(key);
                if (sqLiteDatabase$SyncUpdateInfo.deletedTable != null) {
                    hashMap.put(key, sqLiteDatabase$SyncUpdateInfo.deletedTable);
                }
            }
        }
        // monitorexit(map)
        return;
    }
    
    public int getVersion() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: invokevirtual   net/sqlcipher/database/SQLiteDatabase.lock:()V
        //     7: aload_0        
        //     8: invokevirtual   net/sqlcipher/database/SQLiteDatabase.isOpen:()Z
        //    11: ifne            25
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc_w           "database not open"
        //    21: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    24: athrow         
        //    25: new             Lnet/sqlcipher/database/SQLiteStatement;
        //    28: dup            
        //    29: aload_0        
        //    30: ldc_w           "PRAGMA user_version;"
        //    33: invokespecial   net/sqlcipher/database/SQLiteStatement.<init>:(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
        //    36: astore          6
        //    38: aload           6
        //    40: invokevirtual   net/sqlcipher/database/SQLiteStatement.simpleQueryForLong:()J
        //    43: lstore_2       
        //    44: lload_2        
        //    45: l2i            
        //    46: istore_1       
        //    47: aload           6
        //    49: ifnull          57
        //    52: aload           6
        //    54: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    57: aload_0        
        //    58: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    61: iload_1        
        //    62: ireturn        
        //    63: astore          5
        //    65: aload           4
        //    67: ifnull          75
        //    70: aload           4
        //    72: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //    75: aload_0        
        //    76: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //    79: aload           5
        //    81: athrow         
        //    82: astore          5
        //    84: aload           6
        //    86: astore          4
        //    88: goto            65
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     38     63     65     Any
        //  38     44     82     91     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
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
    
    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }
    
    public long insert(final String str, final String s, final ContentValues contentValues) {
        try {
            return this.insertWithOnConflict(str, s, contentValues, 0);
        }
        catch (SQLException ex) {
            Log.e("Database", "Error inserting <redacted values> into " + str, (Throwable)ex);
            return -1L;
        }
    }
    
    public long insertOrThrow(final String s, final String s2, final ContentValues contentValues) throws SQLException {
        return this.insertWithOnConflict(s, s2, contentValues, 0);
    }
    
    public long insertWithOnConflict(final String str, String str2, ContentValues contentValues, int i) {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        Object compileStatement = new StringBuilder(152);
        ((StringBuilder)compileStatement).append("INSERT");
        ((StringBuilder)compileStatement).append(SQLiteDatabase.CONFLICT_VALUES[i]);
        ((StringBuilder)compileStatement).append(" INTO ");
        ((StringBuilder)compileStatement).append(str);
        final StringBuilder s = new StringBuilder(40);
        Object o = null;
        Label_0323: {
            if (contentValues == null || contentValues.size() <= 0) {
                break Label_0323;
            }
            o = contentValues.valueSet();
            final Iterator<Map.Entry<String, V>> iterator = ((Set<Map.Entry<String, V>>)o).iterator();
            ((StringBuilder)compileStatement).append('(');
            i = 0;
            while (iterator.hasNext()) {
                if (i != 0) {
                    ((StringBuilder)compileStatement).append(", ");
                    s.append(", ");
                }
                i = 1;
                ((StringBuilder)compileStatement).append(iterator.next().getKey());
                s.append('?');
            }
            ((StringBuilder)compileStatement).append(')');
            while (true) {
                ((StringBuilder)compileStatement).append(" VALUES(");
                ((StringBuilder)compileStatement).append((CharSequence)s);
                ((StringBuilder)compileStatement).append(");");
                this.lock();
                contentValues = null;
                str2 = null;
                try {
                    compileStatement = this.compileStatement(((StringBuilder)compileStatement).toString());
                    if (o != null) {
                        str2 = (String)compileStatement;
                        contentValues = (ContentValues)compileStatement;
                        final int size = ((Set)o).size();
                        str2 = (String)compileStatement;
                        contentValues = (ContentValues)compileStatement;
                        o = ((Set<Object>)o).iterator();
                        for (i = 0; i < size; ++i) {
                            str2 = (String)compileStatement;
                            contentValues = (ContentValues)compileStatement;
                            DatabaseUtils.bindObjectToProgram((SQLiteProgram)compileStatement, i + 1, ((Iterator<Map.Entry<K, Object>>)o).next().getValue());
                        }
                    }
                    str2 = (String)compileStatement;
                    contentValues = (ContentValues)compileStatement;
                    ((SQLiteStatement)compileStatement).execute();
                    str2 = (String)compileStatement;
                    contentValues = (ContentValues)compileStatement;
                    long lastInsertRow;
                    if (this.lastChangeCount() > 0) {
                        str2 = (String)compileStatement;
                        contentValues = (ContentValues)compileStatement;
                        lastInsertRow = this.lastInsertRow();
                    }
                    else {
                        lastInsertRow = -1L;
                    }
                    if (lastInsertRow == -1L) {
                        str2 = (String)compileStatement;
                        contentValues = (ContentValues)compileStatement;
                        Log.e("Database", "Error inserting <redacted values> using <redacted sql> into " + str);
                    }
                    else {
                        str2 = (String)compileStatement;
                        contentValues = (ContentValues)compileStatement;
                        if (Log.isLoggable("Database", 2)) {
                            str2 = (String)compileStatement;
                            contentValues = (ContentValues)compileStatement;
                            Log.v("Database", "Inserting row " + lastInsertRow + " from <redacted values> using <redacted sql> into " + str);
                        }
                    }
                    return lastInsertRow;
                    ((StringBuilder)compileStatement).append("(" + str2 + ") ");
                    s.append("NULL");
                }
                catch (SQLiteDatabaseCorruptException ex) {
                    contentValues = (ContentValues)str2;
                    this.onCorruption();
                    contentValues = (ContentValues)str2;
                    throw ex;
                }
                finally {
                    if (contentValues != null) {
                        ((SQLiteStatement)contentValues).close();
                    }
                    this.unlock();
                }
            }
        }
    }
    
    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }
    
    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }
    
    public boolean isInCompiledSqlCache(final String s) {
        synchronized (this.mCompiledQueries) {
            return this.mCompiledQueries.containsKey(s);
        }
    }
    
    public boolean isOpen() {
        return this.mNativeHandle != 0L;
    }
    
    public boolean isReadOnly() {
        return (this.mFlags & 0x1) == 0x1;
    }
    
    native int lastChangeCount();
    
    native long lastInsertRow();
    
    void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }
    
    public void markTableSyncable(final String s, final String s2) {
        if (!this.isOpen()) {
            throw new SQLiteException("database not open");
        }
        this.markTableSyncable(s, "_id", s, s2);
    }
    
    public void markTableSyncable(final String s, final String s2, final String s3) {
        if (!this.isOpen()) {
            throw new SQLiteException("database not open");
        }
        this.markTableSyncable(s, s2, s3, null);
    }
    
    native void native_execSQL(final String p0) throws SQLException;
    
    native void native_setLocale(final String p0, final int p1);
    
    public boolean needUpgrade(final int n) {
        return n > this.getVersion();
    }
    
    protected void onAllReferencesReleased() {
        if (this.isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = this.getTime();
            }
            this.dbclose();
            synchronized (SQLiteDatabase.sActiveDatabases) {
                SQLiteDatabase.sActiveDatabases.remove(this);
            }
        }
    }
    
    void onCorruption() {
        Log.e("Database", "Calling error handler for corrupt database (detected) " + this.mPath);
        this.mErrorHandler.onCorruption(this);
    }
    
    public void purgeFromCompiledSqlCache(final String s) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(s);
        }
    }
    
    public Cursor query(final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5) {
        return this.query(false, s, array, s2, array2, s3, s4, s5, null);
    }
    
    public Cursor query(final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5, final String s6) {
        return this.query(false, s, array, s2, array2, s3, s4, s5, s6);
    }
    
    public Cursor query(final boolean b, final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5, final String s6) {
        return this.queryWithFactory(null, b, s, array, s2, array2, s3, s4, s5, s6);
    }
    
    public Cursor queryWithFactory(final SQLiteDatabase.SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final boolean b, final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5, final String s6) {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        return this.rawQueryWithFactory(sqLiteDatabase$CursorFactory, SQLiteQueryBuilder.buildQueryString(b, s, array, s2, s3, s4, s5, s6), array2, findEditTable(s));
    }
    
    public void rawExecSQL(final String s) {
        SystemClock.uptimeMillis();
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        try {
            this.native_rawExecSQL(s);
        }
        catch (SQLiteDatabaseCorruptException ex) {
            this.onCorruption();
            throw ex;
        }
        finally {
            this.unlock();
        }
    }
    
    public Cursor rawQuery(String s, final Object[] array) {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long currentTimeMillis = 0L;
        if (this.mSlowQueryThreshold != -1) {
            currentTimeMillis = System.currentTimeMillis();
        }
        s = (String)new SQLiteDirectCursorDriver(this, s, (String)null);
        try {
            final Cursor query = ((SQLiteDirectCursorDriver)s).query(this.mFactory, array);
            if (this.mSlowQueryThreshold != -1) {
                int count = -1;
                if (query != null) {
                    count = query.getCount();
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis >= this.mSlowQueryThreshold) {
                    Log.v("Database", "query (" + currentTimeMillis + " ms): " + ((SQLiteDirectCursorDriver)s).toString() + ", args are <redacted>, count is " + count);
                }
            }
            return (Cursor)new CrossProcessCursorWrapper(query);
        }
        finally {
            if (this.mSlowQueryThreshold != -1) {
                if (false) {
                    throw new NullPointerException();
                }
                final long lng = System.currentTimeMillis() - currentTimeMillis;
                if (lng >= this.mSlowQueryThreshold) {
                    Log.v("Database", "query (" + lng + " ms): " + ((SQLiteDirectCursorDriver)s).toString() + ", args are <redacted>, count is " + -1);
                }
            }
        }
    }
    
    public Cursor rawQuery(final String s, final String[] array) {
        return this.rawQueryWithFactory(null, s, array, null);
    }
    
    public Cursor rawQuery(final String s, final String[] array, final int n, final int n2) {
        final CursorWrapper cursorWrapper = (CursorWrapper)this.rawQueryWithFactory(null, s, array, null);
        ((SQLiteCursor)cursorWrapper.getWrappedCursor()).setLoadStyle(n, n2);
        return (Cursor)cursorWrapper;
    }
    
    public Cursor rawQueryWithFactory(SQLiteDatabase.SQLiteDatabase$CursorFactory mFactory, String s, final String[] array, final String s2) {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long currentTimeMillis = 0L;
        if (this.mSlowQueryThreshold != -1) {
            currentTimeMillis = System.currentTimeMillis();
        }
        s = (String)new SQLiteDirectCursorDriver(this, s, s2);
        Label_0161: {
            if (mFactory == null) {
                break Label_0161;
            }
            try {
                while (true) {
                    final Cursor query = ((SQLiteCursorDriver)s).query(mFactory, array);
                    if (this.mSlowQueryThreshold != -1) {
                        int count = -1;
                        if (query != null) {
                            count = query.getCount();
                        }
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis >= this.mSlowQueryThreshold) {
                            Log.v("Database", "query (" + currentTimeMillis + " ms): " + s.toString() + ", args are <redacted>, count is " + count);
                        }
                    }
                    return (Cursor)new CrossProcessCursorWrapper(query);
                    mFactory = this.mFactory;
                    continue;
                }
            }
            finally {
                if (this.mSlowQueryThreshold != -1) {
                    if (false) {
                        throw new NullPointerException();
                    }
                    final long lng = System.currentTimeMillis() - currentTimeMillis;
                    if (lng >= this.mSlowQueryThreshold) {
                        Log.v("Database", "query (" + lng + " ms): " + s.toString() + ", args are <redacted>, count is " + -1);
                    }
                }
            }
        }
    }
    
    void removeSQLiteClosable(final SQLiteClosable key) {
        this.lock();
        try {
            this.mPrograms.remove(key);
        }
        finally {
            this.unlock();
        }
    }
    
    public long replace(final String str, final String s, final ContentValues contentValues) {
        try {
            return this.insertWithOnConflict(str, s, contentValues, 5);
        }
        catch (SQLException ex) {
            Log.e("Database", "Error inserting <redacted values> into " + str, (Throwable)ex);
            return -1L;
        }
    }
    
    public long replaceOrThrow(final String s, final String s2, final ContentValues contentValues) throws SQLException {
        return this.insertWithOnConflict(s, s2, contentValues, 5);
    }
    
    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }
    
    void rowUpdated(final String str, final long lng) {
        synchronized (this.mSyncUpdateInfo) {
            final SQLiteDatabase.SQLiteDatabase$SyncUpdateInfo sqLiteDatabase$SyncUpdateInfo = this.mSyncUpdateInfo.get(str);
            // monitorexit(this.mSyncUpdateInfo)
            if (sqLiteDatabase$SyncUpdateInfo != null) {
                this.execSQL("UPDATE " + sqLiteDatabase$SyncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + sqLiteDatabase$SyncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + lng + ")");
            }
        }
    }
    
    public void setLocale(final Locale locale) {
        this.lock();
        try {
            this.native_setLocale(locale.toString(), this.mFlags);
        }
        finally {
            this.unlock();
        }
    }
    
    public void setLockingEnabled(final boolean mLockingEnabled) {
        this.mLockingEnabled = mLockingEnabled;
    }
    
    public void setMaxSqlCacheSize(final int mMaxSqlCacheSize) {
        // monitorenter(this)
        Label_0029: {
            if (mMaxSqlCacheSize <= 250) {
                if (mMaxSqlCacheSize >= 0) {
                    break Label_0029;
                }
            }
            try {
                throw new IllegalStateException("expected value between 0 and 250");
            }
            finally {
            }
            // monitorexit(this)
        }
        if (mMaxSqlCacheSize < this.mMaxSqlCacheSize) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
        this.mMaxSqlCacheSize = mMaxSqlCacheSize;
    }
    // monitorexit(this)
    
    public long setMaximumSize(final long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          9
        //     3: aload_0        
        //     4: invokevirtual   net/sqlcipher/database/SQLiteDatabase.lock:()V
        //     7: aload_0        
        //     8: invokevirtual   net/sqlcipher/database/SQLiteDatabase.isOpen:()Z
        //    11: ifne            25
        //    14: new             Ljava/lang/IllegalStateException;
        //    17: dup            
        //    18: ldc_w           "database not open"
        //    21: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    24: athrow         
        //    25: aload_0        
        //    26: invokevirtual   net/sqlcipher/database/SQLiteDatabase.getPageSize:()J
        //    29: lstore          7
        //    31: lload_1        
        //    32: lload           7
        //    34: ldiv           
        //    35: lstore          5
        //    37: lload           5
        //    39: lstore_3       
        //    40: lload_1        
        //    41: lload           7
        //    43: lrem           
        //    44: lconst_0       
        //    45: lcmp           
        //    46: ifeq            54
        //    49: lload           5
        //    51: lconst_1       
        //    52: ladd           
        //    53: lstore_3       
        //    54: new             Lnet/sqlcipher/database/SQLiteStatement;
        //    57: dup            
        //    58: aload_0        
        //    59: new             Ljava/lang/StringBuilder;
        //    62: dup            
        //    63: invokespecial   java/lang/StringBuilder.<init>:()V
        //    66: ldc_w           "PRAGMA max_page_count = "
        //    69: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    72: lload_3        
        //    73: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    76: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    79: invokespecial   net/sqlcipher/database/SQLiteStatement.<init>:(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
        //    82: astore          11
        //    84: aload           11
        //    86: invokevirtual   net/sqlcipher/database/SQLiteStatement.simpleQueryForLong:()J
        //    89: lstore_1       
        //    90: aload           11
        //    92: ifnull          100
        //    95: aload           11
        //    97: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //   100: aload_0        
        //   101: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //   104: lload_1        
        //   105: lload           7
        //   107: lmul           
        //   108: lreturn        
        //   109: astore          10
        //   111: aload           9
        //   113: ifnull          121
        //   116: aload           9
        //   118: invokevirtual   net/sqlcipher/database/SQLiteStatement.close:()V
        //   121: aload_0        
        //   122: invokevirtual   net/sqlcipher/database/SQLiteDatabase.unlock:()V
        //   125: aload           10
        //   127: athrow         
        //   128: astore          10
        //   130: aload           11
        //   132: astore          9
        //   134: goto            111
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     37     109    111    Any
        //  54     84     109    111    Any
        //  84     90     128    137    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0100:
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
    
    public void setPageSize(final long lng) {
        this.execSQL("PRAGMA page_size = " + lng);
    }
    
    public void setTransactionSuccessful() {
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        if (this.mInnerTransactionIsSuccessful) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
        this.mInnerTransactionIsSuccessful = true;
    }
    
    public void setVersion(final int i) {
        this.execSQL("PRAGMA user_version = " + i);
    }
    
    public int status(final int n, final boolean b) {
        return this.native_status(n, b);
    }
    
    void unlock() {
        if (!this.mLockingEnabled) {
            return;
        }
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.checkLockHoldTime();
        }
        this.mLock.unlock();
    }
    
    public int update(final String s, final ContentValues contentValues, final String s2, final String[] array) {
        return this.updateWithOnConflict(s, contentValues, s2, array, 0);
    }
    
    public int updateWithOnConflict(final String str, ContentValues contentValues, String compileStatement, final String[] array, int lastChangeCount) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        final StringBuilder sb = new StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(SQLiteDatabase.CONFLICT_VALUES[lastChangeCount]);
        sb.append(str);
        sb.append(" SET ");
        final Set valueSet = contentValues.valueSet();
        final Iterator<Map.Entry<String, V>> iterator = valueSet.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().getKey());
            sb.append("=?");
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        if (!TextUtils.isEmpty((CharSequence)compileStatement)) {
            sb.append(" WHERE ");
            sb.append(compileStatement);
        }
        this.lock();
        if (!this.isOpen()) {
            throw new IllegalStateException("database not open");
        }
        contentValues = null;
        Object o = null;
        compileStatement = null;
        try {
            final Object o2 = o = (contentValues = (ContentValues)(compileStatement = (String)this.compileStatement(sb.toString())));
            final int size = valueSet.size();
            compileStatement = (String)o2;
            contentValues = (ContentValues)o2;
            o = o2;
            final Iterator<Map.Entry<String, V>> iterator2 = valueSet.iterator();
            lastChangeCount = 1;
            for (int i = 0; i < size; ++i) {
                compileStatement = (String)o2;
                contentValues = (ContentValues)o2;
                o = o2;
                DatabaseUtils.bindObjectToProgram((SQLiteProgram)o2, lastChangeCount, (Object)iterator2.next().getValue());
                ++lastChangeCount;
            }
            if (array != null) {
                compileStatement = (String)o2;
                contentValues = (ContentValues)o2;
                o = o2;
                for (int length = array.length, j = 0; j < length; ++j) {
                    compileStatement = (String)o2;
                    contentValues = (ContentValues)o2;
                    o = o2;
                    ((SQLiteStatement)o2).bindString(lastChangeCount, array[j]);
                    ++lastChangeCount;
                }
            }
            compileStatement = (String)o2;
            contentValues = (ContentValues)o2;
            o = o2;
            ((SQLiteStatement)o2).execute();
            compileStatement = (String)o2;
            contentValues = (ContentValues)o2;
            o = o2;
            lastChangeCount = this.lastChangeCount();
            compileStatement = (String)o2;
            contentValues = (ContentValues)o2;
            o = o2;
            if (Log.isLoggable("Database", 2)) {
                compileStatement = (String)o2;
                contentValues = (ContentValues)o2;
                o = o2;
                Log.v("Database", "Updated " + lastChangeCount + " rows using <redacted values> and <redacted sql> for " + str);
            }
            return lastChangeCount;
        }
        catch (SQLiteDatabaseCorruptException ex) {
            contentValues = (ContentValues)compileStatement;
            this.onCorruption();
            contentValues = (ContentValues)compileStatement;
            throw ex;
        }
        catch (SQLException ex2) {
            contentValues = (ContentValues)o;
            Log.e("Database", "Error updating <redacted values> using <redacted sql> for " + str);
            contentValues = (ContentValues)o;
            throw ex2;
        }
        finally {
            if (contentValues != null) {
                ((SQLiteStatement)contentValues).close();
            }
            this.unlock();
        }
    }
    
    @Deprecated
    public boolean yieldIfContended() {
        return this.isOpen() && this.yieldIfContendedHelper(false, -1L);
    }
    
    public boolean yieldIfContendedSafely() {
        return this.isOpen() && this.yieldIfContendedHelper(true, -1L);
    }
    
    public boolean yieldIfContendedSafely(final long n) {
        return this.isOpen() && this.yieldIfContendedHelper(true, n);
    }
}
