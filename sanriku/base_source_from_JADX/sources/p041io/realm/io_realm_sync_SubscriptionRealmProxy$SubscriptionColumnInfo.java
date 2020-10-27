package p041io.realm;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import p041io.realm.internal.ColumnInfo;
import p041io.realm.internal.OsObjectSchemaInfo;
import p041io.realm.internal.OsSchemaInfo;

/* renamed from: io.realm.io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo */
final class io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo extends ColumnInfo {
    long createdAtIndex;
    long errorMessageIndex;
    long expiresAtIndex;
    long matchesPropertyIndex;
    long maxColumnIndexValue;
    long nameIndex;
    long queryIndex;
    long queryParseCounterIndex;
    long statusIndex;
    long timeToLiveIndex;
    long updatedAtIndex;

    io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo(ColumnInfo columnInfo, boolean z) {
        super(columnInfo, z);
        copy(columnInfo, this);
    }

    io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo(OsSchemaInfo osSchemaInfo) {
        super(10);
        OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo(io_realm_sync_SubscriptionRealmProxy$ClassNameHelper.INTERNAL_CLASS_NAME);
        this.nameIndex = addColumnDetails(AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.NAME, objectSchemaInfo);
        this.statusIndex = addColumnDetails(NotificationCompat.CATEGORY_STATUS, NotificationCompat.CATEGORY_STATUS, objectSchemaInfo);
        this.errorMessageIndex = addColumnDetails("errorMessage", "error_message", objectSchemaInfo);
        this.matchesPropertyIndex = addColumnDetails("matchesProperty", "matches_property", objectSchemaInfo);
        this.queryIndex = addColumnDetails(SearchIntents.EXTRA_QUERY, SearchIntents.EXTRA_QUERY, objectSchemaInfo);
        this.queryParseCounterIndex = addColumnDetails("queryParseCounter", "query_parse_counter", objectSchemaInfo);
        this.createdAtIndex = addColumnDetails("createdAt", "created_at", objectSchemaInfo);
        this.updatedAtIndex = addColumnDetails("updatedAt", "updated_at", objectSchemaInfo);
        this.expiresAtIndex = addColumnDetails("expiresAt", "expires_at", objectSchemaInfo);
        this.timeToLiveIndex = addColumnDetails("timeToLive", AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, objectSchemaInfo);
        this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
    }

    /* access modifiers changed from: protected */
    public final ColumnInfo copy(boolean z) {
        return new io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo(this, z);
    }

    /* access modifiers changed from: protected */
    public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
        io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo = (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) columnInfo;
        io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2 = (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) columnInfo2;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.nameIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.nameIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.statusIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.statusIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.errorMessageIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.errorMessageIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.matchesPropertyIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.matchesPropertyIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.queryIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.queryIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.queryParseCounterIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.queryParseCounterIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.createdAtIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.createdAtIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.updatedAtIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.updatedAtIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.expiresAtIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.expiresAtIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.timeToLiveIndex = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.timeToLiveIndex;
        io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo2.maxColumnIndexValue = io_realm_sync_subscriptionrealmproxy_subscriptioncolumninfo.maxColumnIndexValue;
    }
}
