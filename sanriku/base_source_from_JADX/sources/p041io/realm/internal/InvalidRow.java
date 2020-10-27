package p041io.realm.internal;

import java.util.Date;
import p041io.realm.RealmFieldType;

/* renamed from: io.realm.internal.InvalidRow */
public enum InvalidRow implements Row {
    INSTANCE;

    private RuntimeException getStubException() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }

    public void checkIfAttached() {
        throw getStubException();
    }

    public byte[] getBinaryByteArray(long j) {
        throw getStubException();
    }

    public boolean getBoolean(long j) {
        throw getStubException();
    }

    public long getColumnCount() {
        throw getStubException();
    }

    public long getColumnIndex(String str) {
        throw getStubException();
    }

    public String getColumnName(long j) {
        throw getStubException();
    }

    public RealmFieldType getColumnType(long j) {
        throw getStubException();
    }

    public Date getDate(long j) {
        throw getStubException();
    }

    public double getDouble(long j) {
        throw getStubException();
    }

    public float getFloat(long j) {
        throw getStubException();
    }

    public long getIndex() {
        throw getStubException();
    }

    public long getLink(long j) {
        throw getStubException();
    }

    public long getLong(long j) {
        throw getStubException();
    }

    public OsList getModelList(long j) {
        throw getStubException();
    }

    public String getString(long j) {
        throw getStubException();
    }

    public Table getTable() {
        throw getStubException();
    }

    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        throw getStubException();
    }

    public boolean hasColumn(String str) {
        throw getStubException();
    }

    public boolean isAttached() {
        return false;
    }

    public boolean isNull(long j) {
        throw getStubException();
    }

    public boolean isNullLink(long j) {
        throw getStubException();
    }

    public void nullifyLink(long j) {
        throw getStubException();
    }

    public void setBinaryByteArray(long j, byte[] bArr) {
        throw getStubException();
    }

    public void setBoolean(long j, boolean z) {
        throw getStubException();
    }

    public void setDate(long j, Date date) {
        throw getStubException();
    }

    public void setDouble(long j, double d) {
        throw getStubException();
    }

    public void setFloat(long j, float f) {
        throw getStubException();
    }

    public void setLink(long j, long j2) {
        throw getStubException();
    }

    public void setLong(long j, long j2) {
        throw getStubException();
    }

    public void setNull(long j) {
        throw getStubException();
    }

    public void setString(long j, String str) {
        throw getStubException();
    }
}
