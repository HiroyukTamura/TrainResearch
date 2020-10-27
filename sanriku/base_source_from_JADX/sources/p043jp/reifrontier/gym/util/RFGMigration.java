package p043jp.reifrontier.gym.util;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.DynamicRealm;
import p041io.realm.FieldAttribute;
import p041io.realm.RealmMigration;
import p041io.realm.RealmObjectSchema;
import p041io.realm.RealmSchema;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy;
import p041io.realm.jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/util/RFGMigration;", "Lio/realm/RealmMigration;", "()V", "migrate", "", "realm", "Lio/realm/DynamicRealm;", "oldVersion", "", "newVersion", "migrate1to2", "migrate2to3", "migrate3to4", "setRequired", "schema", "Lio/realm/RealmSchema;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.RFGMigration */
public final class RFGMigration implements RealmMigration {
    private final void migrate1to2(DynamicRealm dynamicRealm) {
        RealmObjectSchema realmObjectSchema = dynamicRealm.getSchema().get(jp_reifrontier_gym_domain_api_train_RFGApiSpotRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (realmObjectSchema != null) {
            realmObjectSchema.addField("order", Integer.TYPE, new FieldAttribute[0]);
        }
    }

    private final void migrate2to3(DynamicRealm dynamicRealm) {
        Class<String> cls = String.class;
        dynamicRealm.getSchema().create(jp_reifrontier_gym_domain_silentlog_RFGTrainEntityRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME).addField("id", cls, new FieldAttribute[0]).addField("stations", cls, new FieldAttribute[0]).addField("trains", cls, new FieldAttribute[0]).addField("updateTime", Long.TYPE, new FieldAttribute[0]).setRequired("id", true).setRequired("stations", true).setRequired("trains", true).addPrimaryKey("id");
    }

    private final void migrate3to4(DynamicRealm dynamicRealm) {
        RealmSchema schema = dynamicRealm.getSchema();
        Intrinsics.checkExpressionValueIsNotNull(schema, "schema");
        setRequired(schema);
    }

    private final void setRequired(RealmSchema realmSchema) {
        RealmObjectSchema required;
        RealmObjectSchema required2;
        RealmObjectSchema required3;
        RealmObjectSchema required4;
        RealmObjectSchema required5;
        RealmObjectSchema required6;
        RealmObjectSchema required7;
        RealmObjectSchema required8;
        RealmObjectSchema required9;
        RealmObjectSchema required10;
        RealmObjectSchema required11;
        RealmObjectSchema required12;
        RealmObjectSchema required13;
        RealmObjectSchema required14;
        RealmObjectSchema realmObjectSchema = realmSchema.get(jp_reifrontier_gym_domain_silentlog_RFGActivityRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (realmObjectSchema != null) {
            realmObjectSchema.setRequired("activity", true);
        }
        RealmObjectSchema realmObjectSchema2 = realmSchema.get(jp_reifrontier_gym_domain_silentlog_RFGActTagRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (!(realmObjectSchema2 == null || (required13 = realmObjectSchema2.setRequired(AppMeasurementSdk.ConditionalUserProperty.NAME, true)) == null || (required14 = required13.setRequired("type", true)) == null)) {
            required14.setRequired("owner", true);
        }
        RealmObjectSchema realmObjectSchema3 = realmSchema.get("RFGChallengeBadge");
        if (realmObjectSchema3 != null) {
            realmObjectSchema3.setRequired("challengeId", true);
        }
        RealmObjectSchema realmObjectSchema4 = realmSchema.get(jp_reifrontier_gym_domain_silentlog_RFGDayRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (realmObjectSchema4 != null) {
            realmObjectSchema4.setRequired("date", true);
        }
        RealmObjectSchema realmObjectSchema5 = realmSchema.get(jp_reifrontier_gym_domain_api_RFGHistoryRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (!(realmObjectSchema5 == null || (required9 = realmObjectSchema5.setRequired("historyId", true)) == null || (required10 = required9.setRequired("gymId", true)) == null || (required11 = required10.setRequired("height", true)) == null || (required12 = required11.setRequired("weight", true)) == null)) {
            required12.setRequired("updated_at", true);
        }
        RealmObjectSchema realmObjectSchema6 = realmSchema.get(jp_reifrontier_gym_domain_app_RFGParameterBadgeRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (realmObjectSchema6 != null) {
            realmObjectSchema6.setRequired("parameterId", true);
        }
        RealmObjectSchema realmObjectSchema7 = realmSchema.get(jp_reifrontier_gym_domain_api_RFGUserRealmProxy.ClassNameHelper.INTERNAL_CLASS_NAME);
        if (realmObjectSchema7 != null && (required = realmObjectSchema7.setRequired("userId", true)) != null && (required2 = required.setRequired("firstDate", true)) != null && (required3 = required2.setRequired("icon", true)) != null && (required4 = required3.setRequired("gender", true)) != null && (required5 = required4.setRequired("birthday", true)) != null && (required6 = required5.setRequired("email", true)) != null && (required7 = required6.setRequired("handleName", true)) != null && (required8 = required7.setRequired("pushAllow", true)) != null) {
            required8.setRequired("archiveCount", true);
        }
    }

    public void migrate(DynamicRealm dynamicRealm, long j, long j2) {
        C1122a.m1600c("[Gym]::Info old:" + j + " new:" + j2, new Object[0]);
        if (dynamicRealm != null) {
            if (j <= 1 && j2 >= 2) {
                migrate1to2(dynamicRealm);
            }
            if (j <= 2 && j2 >= 3) {
                migrate2to3(dynamicRealm);
            }
        }
    }
}
