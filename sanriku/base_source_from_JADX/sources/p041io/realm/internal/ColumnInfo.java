package p041io.realm.internal;

import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.RealmFieldType;

/* renamed from: io.realm.internal.ColumnInfo */
public abstract class ColumnInfo {
    private final Map<String, ColumnDetails> indicesFromColumnNames;
    private final Map<String, ColumnDetails> indicesFromJavaFieldNames;
    private final Map<String, String> javaFieldNameToInternalNames;
    private final boolean mutable;

    /* renamed from: io.realm.internal.ColumnInfo$ColumnDetails */
    public static final class ColumnDetails {
        public final long columnIndex;
        public final RealmFieldType columnType;
        public final String linkedClassName;

        private ColumnDetails(long j, RealmFieldType realmFieldType, String str) {
            this.columnIndex = j;
            this.columnType = realmFieldType;
            this.linkedClassName = str;
        }

        ColumnDetails(Property property) {
            this(property.getColumnIndex(), property.getType(), property.getLinkedObjectName());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ColumnDetails[");
            sb.append(this.columnIndex);
            sb.append(", ");
            sb.append(this.columnType);
            sb.append(", ");
            return C0681a.m324a(sb, this.linkedClassName, "]");
        }
    }

    protected ColumnInfo(int i) {
        this(i, true);
    }

    private ColumnInfo(int i, boolean z) {
        this.indicesFromJavaFieldNames = new HashMap(i);
        this.indicesFromColumnNames = new HashMap(i);
        this.javaFieldNameToInternalNames = new HashMap(i);
        this.mutable = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected ColumnInfo(ColumnInfo columnInfo, boolean z) {
        this(columnInfo == null ? 0 : columnInfo.indicesFromJavaFieldNames.size(), z);
        if (columnInfo != null) {
            this.indicesFromJavaFieldNames.putAll(columnInfo.indicesFromJavaFieldNames);
        }
    }

    /* access modifiers changed from: protected */
    public final void addBacklinkDetails(OsSchemaInfo osSchemaInfo, String str, String str2, String str3) {
        this.indicesFromJavaFieldNames.put(str, new ColumnDetails(osSchemaInfo.getObjectSchemaInfo(str2).getProperty(str3).getColumnIndex(), RealmFieldType.LINKING_OBJECTS, str2));
    }

    /* access modifiers changed from: protected */
    public final long addColumnDetails(String str, String str2, OsObjectSchemaInfo osObjectSchemaInfo) {
        Property property = osObjectSchemaInfo.getProperty(str2);
        ColumnDetails columnDetails = new ColumnDetails(property);
        this.indicesFromJavaFieldNames.put(str, columnDetails);
        this.indicesFromColumnNames.put(str2, columnDetails);
        this.javaFieldNameToInternalNames.put(str, str2);
        return property.getColumnIndex();
    }

    /* access modifiers changed from: protected */
    public abstract ColumnInfo copy(boolean z);

    /* access modifiers changed from: protected */
    public abstract void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2);

    public void copyFrom(ColumnInfo columnInfo) {
        if (!this.mutable) {
            throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
        } else if (columnInfo != null) {
            this.indicesFromJavaFieldNames.clear();
            this.indicesFromJavaFieldNames.putAll(columnInfo.indicesFromJavaFieldNames);
            this.indicesFromColumnNames.clear();
            this.indicesFromColumnNames.putAll(columnInfo.indicesFromColumnNames);
            this.javaFieldNameToInternalNames.clear();
            this.javaFieldNameToInternalNames.putAll(columnInfo.javaFieldNameToInternalNames);
            copy(columnInfo, this);
        } else {
            throw new NullPointerException("Attempt to copy null ColumnInfo");
        }
    }

    public ColumnDetails getColumnDetails(String str) {
        return this.indicesFromJavaFieldNames.get(str);
    }

    public long getColumnIndex(String str) {
        ColumnDetails columnDetails = this.indicesFromJavaFieldNames.get(str);
        if (columnDetails == null) {
            return -1;
        }
        return columnDetails.columnIndex;
    }

    public Map<String, ColumnDetails> getIndicesMap() {
        return this.indicesFromJavaFieldNames;
    }

    public String getInternalFieldName(String str) {
        return this.javaFieldNameToInternalNames.get(str);
    }

    public final boolean isMutable() {
        return this.mutable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnInfo[");
        StringBuilder a = C0681a.m330a("mutable=");
        a.append(this.mutable);
        sb.append(a.toString());
        sb.append(",");
        boolean z = false;
        if (this.indicesFromJavaFieldNames != null) {
            sb.append("JavaFieldNames=[");
            boolean z2 = false;
            for (Map.Entry next : this.indicesFromJavaFieldNames.entrySet()) {
                if (z2) {
                    sb.append(",");
                }
                sb.append((String) next.getKey());
                sb.append("->");
                sb.append(next.getValue());
                z2 = true;
            }
            sb.append("]");
        }
        if (this.indicesFromColumnNames != null) {
            sb.append(", InternalFieldNames=[");
            for (Map.Entry next2 : this.indicesFromColumnNames.entrySet()) {
                if (z) {
                    sb.append(",");
                }
                sb.append((String) next2.getKey());
                sb.append("->");
                sb.append(next2.getValue());
                z = true;
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}
