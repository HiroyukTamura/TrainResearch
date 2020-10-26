// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONObject;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import jp.co.ncdc.apppot.stew.log.Logger;

public class APFile
{
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_RESULTS = "results";
    static final String KEY_URL = "url";
    private static final APService SERVICE;
    private static final String TAG = "APFile";
    public String fileName;
    public String url;
    
    static {
        SERVICE = APService.getInstance();
    }
    
    public static final void deleteFile(String format, final APResponseHandler apResponseHandler) {
        if (!APFile.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        final APHttpClient httpClient = APFile.SERVICE.getHttpClient();
        format = String.format("%s/%s?userToken=%s", "/files", format, APFile.SERVICE.getAuthToken());
        Logger.d("APFile", "[deleteFile]:" + format);
        httpClient.delete(APFile.SERVICE.getContext(), APFile.SERVICE.getServerInfo().getUrl(format), apResponseHandler);
    }
    
    public static final boolean deleteFile(final String s) {
        Logger.v("APFile", "[deleteFile]:sync:start");
        final StringBuilder sb = new StringBuilder();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                sb.append(apResponse.isOK());
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        deleteFile(s, apResponseHandler);
        Logger.v("APFile", "[deleteFile]:sync:start");
        return sb.toString().equals("true");
    }
    
    private static final APFile getFile(final String s) {
        Logger.v("APFile", "[getFile]:sync:start");
        final APFile apFile = new APFile();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APFile", "[onFailure]:" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APFile", "[onSuccess]:" + apResponse.getResponseData());
                ((APFileResponse)apResponse).getResult(apFile);
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        getFile(s, apResponseHandler);
        Logger.v("APFile", "[getFile]:sync:end");
        return apFile;
    }
    
    private static final void getFile(String format, final APResponseHandler apResponseHandler) {
        if (!APFile.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        final APHttpClient httpClient = APFile.SERVICE.getHttpClient();
        format = String.format("%s/%s?userToken=%s", "/files", format, APFile.SERVICE.getAuthToken());
        Logger.d("APFile", "[getFile]:" + format);
        httpClient.fileGet(APFile.SERVICE.getContext(), APFile.SERVICE.getServerInfo().getUrl(format), apResponseHandler);
    }
    
    public static final String getFileUrl(String format) {
        format = String.format("%s/%s?userToken=%s", "/files", format, APFile.SERVICE.getAuthToken());
        return APFile.SERVICE.getServerInfo().getUrl(format);
    }
    
    public static final APFile updateFile(final String s, final String s2) {
        Logger.v("APFile", "[updateFile]sync:start");
        final APFile apFile = new APFile();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APFile", "[onFailure]:" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APFile", "[onSuccess]:" + apResponse.getResponseData());
                ((APFileResponse)apResponse).getResult(apFile);
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        updateFile(s, s2, apResponseHandler);
        Logger.v("APFile", "[updateFile]sync:end");
        return apFile;
    }
    
    public static final void updateFile(String format, final String s, final APResponseHandler apResponseHandler) {
        if (!APFile.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        final APHttpClient httpClient = APFile.SERVICE.getHttpClient();
        format = String.format("%s/%s?userToken=%s", "/files", format, APFile.SERVICE.getAuthToken());
        Logger.d("APFile", "[updateFile]:" + format);
        httpClient.fileUpdate(APFile.SERVICE.getContext(), APFile.SERVICE.getServerInfo().getUrl(format), s, apResponseHandler);
    }
    
    public static final APFile uploadFile(final String s) {
        Logger.v("APFile", "[uploadFile]sync:start");
        final APFile apFile = new APFile();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.d("APFile", "[onFailure]:" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(final APResponse apResponse) {
                Logger.d("APFile", "[onSuccess]:" + apResponse.getResponseData());
                ((APFileResponse)apResponse).getResult(apFile);
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        uploadFile(s, apResponseHandler);
        Logger.v("APFile", "[uploadFile]sync:end");
        return apFile;
    }
    
    public static final void uploadFile(final String s, final APResponseHandler apResponseHandler) {
        if (!APFile.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        APFile.SERVICE.getHttpClient().fileUpload(APFile.SERVICE.getContext(), APFile.SERVICE.getServerInfo().getUrl("/files?userToken=" + APFile.SERVICE.getAuthToken()), s, apResponseHandler);
    }
    
    void setData(final AJSONObject ajsonObject) {
        this.fileName = JsonUtils.getString(ajsonObject, "name");
        this.url = JsonUtils.getString(ajsonObject, "url");
    }
}
