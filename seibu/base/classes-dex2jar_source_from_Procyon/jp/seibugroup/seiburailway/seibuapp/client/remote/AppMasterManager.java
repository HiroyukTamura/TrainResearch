// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import org.androidannotations.annotations.AfterInject;
import java.util.HashMap;
import com.annimon.stream.Optional;
import com.feilang.mvpproject.remote.SSLRequestFactory;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import java.util.Map;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DepartureWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.OnlineTrains;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusData;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import java.nio.charset.Charset;
import com.annimon.stream.function.Predicate;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import org.androidannotations.annotations.Background;
import com.feilang.mvpproject.remote.TaskHelper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.androidannotations.rest.spring.annotations.RestService;
import org.androidannotations.annotations.Bean;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorHandler;
import org.androidannotations.annotations.EBean;
import com.feilang.mvpproject.remote.BaseRestManager;

@EBean(scope = EBean.Scope.Singleton)
public class AppMasterManager extends BaseRestManager
{
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String SAMPLE_MANAGER_TAG = "AppMasterManagerTag";
    private static final int TIME_OUT_MAX = 30000;
    @Bean
    AppRestErrorHandler errorHandlerForUserService;
    @RestService
    AppMasterAAService masterAAService;
    
    private void initFactory(final SimpleClientHttpRequestFactory simpleClientHttpRequestFactory) {
        final RestTemplate restTemplate = this.masterAAService.getRestTemplate();
        simpleClientHttpRequestFactory.setConnectTimeout(30000);
        simpleClientHttpRequestFactory.setReadTimeout(30000);
        restTemplate.setRequestFactory((ClientHttpRequestFactory)new BufferingClientHttpRequestFactory((ClientHttpRequestFactory)simpleClientHttpRequestFactory));
    }
    
    @Background(serial = "initial")
    public void getMaintenance(final DataCallWrapper<Maintenance> dataCallWrapper) {
        final AppMasterAAService masterAAService = this.masterAAService;
        masterAAService.getClass();
        this.exclusiveRun((TaskHelper.NoParamApi<Object, Object>)AppMasterManager$$Lambda$3.lambdaFactory$(masterAAService), dataCallWrapper);
    }
    
    @Background(serial = "initial")
    public void getMasterData(final DataCallWrapper<BaseData> dataCallWrapper) {
        final AppMasterAAService masterAAService = this.masterAAService;
        masterAAService.getClass();
        this.exclusiveRun((TaskHelper.NoParamApi<Object, Object>)AppMasterManager$$Lambda$2.lambdaFactory$(masterAAService), dataCallWrapper);
    }
    
    @Override
    public RestTemplate getRestTemplate() {
        return this.masterAAService.getRestTemplate();
    }
    
    @Override
    public Object getService() {
        return this.masterAAService;
    }
    
    public AppMasterManager http() {
        this.masterAAService.setRootUrl(this.masterAAService.getRootUrl().replace("https://", "http://"));
        return this;
    }
    
    public AppMasterManager https() {
        this.masterAAService.setRootUrl(this.masterAAService.getRootUrl().replace("http://", "https://"));
        return this;
    }
    
    @AfterInject
    @Override
    protected void init() {
        super.init();
        this.masterAAService.setHeader("Content-Type", "application/json");
        final List messageConverters = this.masterAAService.getRestTemplate().getMessageConverters();
        final Stream<GsonHttpMessageConverter> of = Stream.of((Iterable<? extends GsonHttpMessageConverter>)messageConverters);
        GsonHttpMessageConverter.class.getClass();
        final Optional<GsonHttpMessageConverter> first = of.filter(AppMasterManager$$Lambda$1.lambdaFactory$(GsonHttpMessageConverter.class)).findFirst();
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
        final HashMap<Class<BaseData>, JsonPathDeserializer> hashMap = Maps.newHashMap();
        hashMap.put(BaseData.class, new JsonPathDeserializer("$.seibuappInitialMaster"));
        hashMap.put((Class<BaseData>)RunStatusData.class, new JsonPathDeserializer("$.lineStatusList.lineStatus[0]"));
        hashMap.put((Class<BaseData>)OnlineTrains.class, new JsonPathDeserializer("$.trainList"));
        hashMap.put((Class<BaseData>)DepartureWrapper.class, new JsonPathDeserializer("$.departureList"));
        hashMap.put((Class<BaseData>)Maintenance.class, new JsonPathDeserializer("$.seibuappMaintenance"));
        messageConverters.add(0, new GsonAdapterHttpMessageConverter((Map)hashMap));
        this.masterAAService.setRestTemplate(new TaskHelper.CallbackRestTemplate(this.masterAAService.getRestTemplate()));
        this.masterAAService.setRestErrorHandler((RestErrorHandler)this.errorHandlerForUserService);
        this.initFactory(new SSLRequestFactory());
    }
}
