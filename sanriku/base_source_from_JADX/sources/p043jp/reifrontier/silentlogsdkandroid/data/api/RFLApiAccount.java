package p043jp.reifrontier.silentlogsdkandroid.data.api;

import java.util.Map;
import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLLogout;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLProfile;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J®\u0001\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u00072\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0014\b\u0003\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H'J(\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'Jz\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\u0014\b\u0003\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H'J\u001e\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0007H'JH\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\u00072\u0014\b\u0003\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H'J(\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007H'J(\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007H'J>\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\u0014\b\u0003\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H'J(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u001f\u001a\u00020\u0007H'¨\u0006$"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiAccount;", "", "create", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCreate;", "client_id", "", "client_secret", "device_token", "platform", "time_zone", "lang", "username", "password", "gender", "birthday", "install_date", "private_key", "extra_key", "extra_params", "", "forgetPassword", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCommon;", "mailAddress", "login", "logout", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLLogout;", "accessToken", "profile", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "privateKey", "updateBirthday", "updateGender", "updatePassword", "updatePrivateKey", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiAccount */
public interface RFLApiAccount {

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiAccount$DefaultImpls */
    public static final class DefaultImpls {
        public static /* synthetic */ C1714r create$default(RFLApiAccount rFLApiAccount, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map map, int i, Object obj) {
            if (obj == null) {
                return rFLApiAccount.create(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, (i & 8192) != 0 ? RFLSharedHolder.INSTANCE.extraParameter() : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }

        public static /* synthetic */ C1714r login$default(RFLApiAccount rFLApiAccount, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Map map, int i, Object obj) {
            if (obj == null) {
                return rFLApiAccount.login(str, str2, str3, str4, str5, str6, str7, str8, (i & 256) != 0 ? RFLSharedHolder.INSTANCE.extraParameter() : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ C1714r profile$default(RFLApiAccount rFLApiAccount, String str, String str2, String str3, Map<String, String> map, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    map = RFLSharedHolder.INSTANCE.extraParameter();
                }
                return rFLApiAccount.profile(str, str2, str3, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: profile");
        }

        public static /* synthetic */ C1714r updatePassword$default(RFLApiAccount rFLApiAccount, String str, String str2, Map<String, String> map, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = RFLSharedHolder.INSTANCE.extraParameter();
                }
                return rFLApiAccount.updatePassword(str, str2, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePassword");
        }
    }

    @FormUrlEncoded
    @POST("authorize/create")
    C1714r<Response<RFLCreate>> create(@Field("client_id") String str, @Field("client_secret") String str2, @Field("device_token") String str3, @Field("platform") String str4, @Field("time_zone") String str5, @Field("lang") String str6, @Field("username") String str7, @Field("password") String str8, @Field("gender") String str9, @Field("birthday") String str10, @Field("install_date") String str11, @Field("private_key") String str12, @Field("extra_key") String str13, @FieldMap(encoded = true) Map<String, String> map);

    @FormUrlEncoded
    @POST("setting/forgotpass")
    C1714r<Response<RFLCommon>> forgetPassword(@Field("mailaddress") String str, @Field("lang") String str2);

    @FormUrlEncoded
    @POST("authorize")
    C1714r<Response<RFLCreate>> login(@Field("client_id") String str, @Field("client_secret") String str2, @Field("device_token") String str3, @Field("platform") String str4, @Field("time_zone") String str5, @Field("lang") String str6, @Field("username") String str7, @Field("password") String str8, @FieldMap(encoded = true) Map<String, String> map);

    @FormUrlEncoded
    @POST("authorize/logout")
    C1714r<Response<RFLLogout>> logout(@Field("access_token") String str);

    @GET("user/profile")
    C1714r<Response<RFLProfile>> profile(@Query("access_token") String str, @Query("private_key") String str2, @Query("extra_key") String str3, @QueryMap(encoded = true) Map<String, String> map);

    @FormUrlEncoded
    @POST("user/profile")
    C1714r<Response<RFLProfile>> updateBirthday(@Field("access_token") String str, @Field("birthday") String str2);

    @FormUrlEncoded
    @POST("user/profile")
    C1714r<Response<RFLProfile>> updateGender(@Field("access_token") String str, @Field("gender") String str2);

    @FormUrlEncoded
    @POST("user/profile")
    C1714r<Response<RFLProfile>> updatePassword(@Field("access_token") String str, @Field("password") String str2, @FieldMap(encoded = true) Map<String, String> map);

    @FormUrlEncoded
    @POST("user/profile")
    C1714r<Response<RFLProfile>> updatePrivateKey(@Field("access_token") String str, @Field("private_key") String str2);
}
