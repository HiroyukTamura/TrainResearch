package p041io.realm;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;

/* renamed from: io.realm.io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo */
final class C2003xc9bb9c53 extends ColumnInfo {
    long maxColumnIndexValue;
    long nameIndex;
    long permissionsIndex;

    C2003xc9bb9c53(ColumnInfo columnInfo, boolean z) {
        super(columnInfo, z);
        copy(columnInfo, this);
    }

    C2003xc9bb9c53(OsSchemaInfo osSchemaInfo) {
        super(2);
        OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(C2002x3a7fdb6e.INTERNAL_CLASS_NAME);
        this.nameIndex = addColumnDetails(AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.NAME, objectSchemaInfo);
        this.permissionsIndex = addColumnDetails("permissions", "permissions", objectSchemaInfo);
        this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo copy(boolean z) {
        return new C2003xc9bb9c53(this, z);
    }

    /* access modifiers changed from: protected */
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        C2003xc9bb9c53 io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo = (C2003xc9bb9c53) columnInfo;
        C2003xc9bb9c53 io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2 = (C2003xc9bb9c53) columnInfo2;
        io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2.nameIndex = io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo.nameIndex;
        io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2.permissionsIndex = io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo.permissionsIndex;
        io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo2.maxColumnIndexValue = io_realm_sync_permissions_classpermissionsrealmproxy_classpermissionscolumninfo.maxColumnIndexValue;
    }
}
