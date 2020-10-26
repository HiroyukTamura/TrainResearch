// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import org.androidannotations.annotations.AfterInject;
import java.util.HashMap;
import com.annimon.stream.Optional;
import com.feilang.mvpproject.remote.SSLRequestFactory;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import java.util.Map;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import java.nio.charset.Charset;
import com.annimon.stream.function.Predicate;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.AppPotUser;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageWrapper;
import java.util.List;
import java.util.Iterator;
import com.feilang.mvpproject.remote.TaskHelper;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import org.androidannotations.annotations.Background;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.androidannotations.rest.spring.annotations.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.annotations.Bean;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorHandler;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import org.androidannotations.annotations.EBean;
import com.feilang.mvpproject.remote.BaseRestManager;

@EBean(scope = EBean.Scope.Singleton)
public class AppDeviceRestManager extends BaseRestManager
{
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_LANGUAGE_KEY = "Accept-Language";
    private static final int TIME_OUT_MAX = 30000;
    @RootContext
    Context context;
    @Bean
    AppRestErrorHandler errorHandlerForUserService;
    @Pref
    PrefAppPotAccount_ mAppPotUser;
    @RestService
    AppDeviceRestAAService restAAService;
    
    private void initFactory(final SimpleClientHttpRequestFactory simpleClientHttpRequestFactory) {
        final RestTemplate restTemplate = this.restAAService.getRestTemplate();
        simpleClientHttpRequestFactory.setConnectTimeout(30000);
        simpleClientHttpRequestFactory.setReadTimeout(30000);
        restTemplate.setRequestFactory((ClientHttpRequestFactory)new BufferingClientHttpRequestFactory((ClientHttpRequestFactory)simpleClientHttpRequestFactory));
    }
    
    @Background
    public void changeCheckIn(final DataCallWrapper<CheckInData> dataCallWrapper, final String s, final CheckInInfo checkInInfo) {
        final String s2 = (String)this.mAppPotUser.apppotUserId().get();
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        final CheckInData changeCheckIn = this.restAAService.changeCheckIn(s2, s, checkInInfo);
        if (changeCheckIn == null) {
            this.mTaskHelper.done(dataCallWrapper);
            return;
        }
        this.runOnSuccess(dataCallWrapper, changeCheckIn);
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    @Background
    public void deleteBeacon(final DataCallWrapper<Object> dataCallWrapper) {
        final String s = (String)this.mAppPotUser.apppotUserId().get();
        if (Constants.DETECTED_ID != null) {
            for (final String s2 : Constants.DETECTED_ID) {
                if (!TextUtils.isEmpty((CharSequence)s2)) {
                    final AppDeviceRestAAService restAAService = this.restAAService;
                    restAAService.getClass();
                    this.exclusiveRun(AppDeviceRestManager$$Lambda$10.lambdaFactory$(restAAService), dataCallWrapper, s2, s);
                }
            }
            Constants.DETECTED_ID.clear();
        }
    }
    
    @Background
    public void deleteCheckIn(final DataCallWrapper<Object> dataCallWrapper, final String s) {
        final String s2 = (String)this.mAppPotUser.apppotUserId().get();
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$13.lambdaFactory$(restAAService), dataCallWrapper, s2, s);
    }
    
    @Background
    public void getCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper) {
        final String s = (String)this.mAppPotUser.apppotUserId().get();
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$11.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Background
    public void getEmerg(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        String s = (String)this.mAppPotUser.apppotUserId().get();
        if ("apistub".equals("release")) {
            s = "user1";
        }
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$8.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Background
    public void getEventMessage(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        String s = (String)this.mAppPotUser.apppotUserId().get();
        if ("apistub".equals("release")) {
            s = "user1";
        }
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$5.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Background
    public void getHeadlines(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        String s = (String)this.mAppPotUser.apppotUserId().get();
        if ("apistub".equals("release")) {
            s = "user1";
        }
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$7.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Background
    public void getNoticeMessage(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        final String s = (String)this.mAppPotUser.apppotUserId().get();
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$4.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Override
    public RestTemplate getRestTemplate() {
        return this.restAAService.getRestTemplate();
    }
    
    @Override
    public Object getService() {
        return this.restAAService;
    }
    
    @Background
    public void getSharedCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper, final String s) {
        final String s2 = (String)this.mAppPotUser.apppotUserId().get();
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$12.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s2, s);
    }
    
    @Background
    public void getThreeNoticeMessage(final DataCallWrapper<NoticeThreeMessageWrapper> dataCallWrapper) {
        final String s = (String)this.mAppPotUser.apppotUserId().get();
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$3.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    @Background
    public void getUserFromAppPot(final AppPotGetUserParam appPotGetUserParam, final DataCallWrapper<AppPotUser> dataCallWrapper) {
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$2.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, appPotGetUserParam);
    }
    
    @Background
    public void getWallpapers(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        String s = (String)this.mAppPotUser.apppotUserId().get();
        if ("apistub".equals("release")) {
            s = "user1";
        }
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$6.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, s);
    }
    
    public AppDeviceRestManager http() {
        this.restAAService.setRootUrl(this.restAAService.getRootUrl().replace("https://", "http://"));
        return this;
    }
    
    public AppDeviceRestManager https() {
        this.restAAService.setRootUrl(this.restAAService.getRootUrl().replace("http://", "https://"));
        return this;
    }
    
    @AfterInject
    @Override
    protected void init() {
        super.init();
        this.restAAService.setHeader("Content-Type", "application/json");
        this.setLanguageHeader();
        final List messageConverters = this.restAAService.getRestTemplate().getMessageConverters();
        final Stream<GsonHttpMessageConverter> of = Stream.of((Iterable<? extends GsonHttpMessageConverter>)messageConverters);
        GsonHttpMessageConverter.class.getClass();
        final Optional<GsonHttpMessageConverter> first = of.filter(AppDeviceRestManager$$Lambda$1.lambdaFactory$(GsonHttpMessageConverter.class)).findFirst();
        final MediaType e = new MediaType("application", "octet-stream", Charset.forName("UTF-8"));
        if (first.isPresent()) {
            final GsonHttpMessageConverter gsonHttpMessageConverter = first.get();
            final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)gsonHttpMessageConverter.getSupportedMediaTypes());
            arrayList.add(e);
            gsonHttpMessageConverter.setSupportedMediaTypes((List)arrayList);
        }
        else {
            final GsonHttpMessageConverter gsonHttpMessageConverter2 = new GsonHttpMessageConverter();
            final ArrayList<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
            supportedMediaTypes.add(e);
            gsonHttpMessageConverter2.setSupportedMediaTypes((List)supportedMediaTypes);
            messageConverters.add(gsonHttpMessageConverter2);
        }
        final HashMap<Class<NoticeMessageData>, JsonPathDeserializer> hashMap = Maps.newHashMap();
        hashMap.put(NoticeMessageData.class, new JsonPathDeserializer("$.notice"));
        messageConverters.add(0, new GsonAdapterHttpMessageConverter((Map)hashMap));
        this.restAAService.setRestTemplate(new TaskHelper.CallbackRestTemplate(this.restAAService.getRestTemplate()));
        this.restAAService.setRestErrorHandler((RestErrorHandler)this.errorHandlerForUserService);
        this.initFactory(new SSLRequestFactory());
    }
    
    @Background
    public void postBeacon(final BeaconInfo beaconInfo, final DataCallWrapper<BeaconLocationInfo> dataCallWrapper) {
        beaconInfo.setUserId((String)this.mAppPotUser.apppotUserId().get());
        final AppDeviceRestAAService restAAService = this.restAAService;
        restAAService.getClass();
        this.exclusiveRun(AppDeviceRestManager$$Lambda$9.lambdaFactory$(restAAService), (DataCallWrapper<Object>)dataCallWrapper, beaconInfo);
    }
    
    @Background
    public void requestCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper, final CheckInInfo checkInInfo) {
        final String s = (String)this.mAppPotUser.apppotUserId().get();
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        final List<CheckInData> requestCheckIn = this.restAAService.requestCheckIn(s, Lists.newArrayList(checkInInfo));
        if (requestCheckIn == null || requestCheckIn.size() == 0) {
            this.mTaskHelper.done(dataCallWrapper);
            return;
        }
        this.runOnSuccess((DataCallWrapper<List>)dataCallWrapper, requestCheckIn);
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    public void setLanguageHeader() {
        this.restAAService.setHeader("Accept-Language", this.context.getString(2131230790));
    }
}
