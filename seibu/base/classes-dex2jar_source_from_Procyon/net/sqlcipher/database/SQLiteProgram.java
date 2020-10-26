// 
// Decompiled by Procyon v0.5.36
// 

package net.sqlcipher.database;

import android.util.Log;

public abstract class SQLiteProgram extends SQLiteClosable
{
    private static final String TAG = "SQLiteProgram";
    boolean mClosed;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected long nHandle;
    @Deprecated
    protected long nStatement;
    
    SQLiteProgram(final SQLiteDatabase mDatabase, final String s) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mClosed = false;
        this.mDatabase = mDatabase;
        this.mSql = s.trim();
        mDatabase.acquireReference();
        mDatabase.addSQLiteClosable(this);
        this.nHandle = mDatabase.mNativeHandle;
        String s2;
        if (this.mSql.length() >= 6) {
            s2 = this.mSql.substring(0, 6);
        }
        else {
            s2 = this.mSql;
        }
        if (!s2.equalsIgnoreCase("INSERT") && !s2.equalsIgnoreCase("UPDATE") && !s2.equalsIgnoreCase("REPLAC") && !s2.equalsIgnoreCase("DELETE") && !s2.equalsIgnoreCase("SELECT")) {
            this.mCompiledSql = new SQLiteCompiledSql(mDatabase, s);
            this.nStatement = this.mCompiledSql.nStatement;
            return;
        }
        this.mCompiledSql = mDatabase.getCompiledStatementForSql(s);
        if (this.mCompiledSql == null) {
            (this.mCompiledSql = new SQLiteCompiledSql(mDatabase, s)).acquire();
            mDatabase.addToCompiledQueries(s, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v("SQLiteProgram", "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + s);
            }
        }
        else if (!this.mCompiledSql.acquire()) {
            final long nStatement = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(mDatabase, s);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v("SQLiteProgram", "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + nStatement + ") was not released for sql:" + s);
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }
    
    private final native void native_clear_bindings();
    
    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        while (true) {
            synchronized (this.mDatabase.mCompiledQueries) {
                if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                    this.mCompiledSql.releaseSqlStatement();
                    this.mCompiledSql = null;
                    this.nStatement = 0L;
                    return;
                }
            }
            this.mCompiledSql.release();
        }
    }
    
    public void bindBlob(final int i, final byte[] array) {
        if (array == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_bind_blob(i, array);
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void bindDouble(final int n, final double n2) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_bind_double(n, n2);
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void bindLong(final int n, final long n2) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_bind_long(n, n2);
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void bindNull(final int n) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_bind_null(n);
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void bindString(final int i, final String s) {
        if (s == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_bind_string(i, s);
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void clearBindings() {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        this.acquireReference();
        try {
            this.native_clear_bindings();
        }
        finally {
            this.releaseReference();
        }
    }
    
    public void close() {
        if (this.mClosed || !this.mDatabase.isOpen()) {
            return;
        }
        this.mDatabase.lock();
        try {
            this.releaseReference();
            this.mDatabase.unlock();
            this.mClosed = true;
        }
        finally {
            this.mDatabase.unlock();
        }
    }
    
    @Deprecated
    protected void compile(final String s, final boolean b) {
    }
    
    String getSqlString() {
        return this.mSql;
    }
    
    public final long getUniqueId() {
        return this.nStatement;
    }
    
    protected final native void native_bind_blob(final int p0, final byte[] p1);
    
    protected final native void native_bind_double(final int p0, final double p1);
    
    protected final native void native_bind_long(final int p0, final long p1);
    
    protected final native void native_bind_null(final int p0);
    
    protected final native void native_bind_string(final int p0, final String p1);
    
    @Deprecated
    protected final native void native_compile(final String p0);
    
    @Deprecated
    protected final native void native_finalize();
    
    protected void onAllReferencesReleased() {
        this.releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }
    
    protected void onAllReferencesReleasedFromContainer() {
        this.releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }
}
