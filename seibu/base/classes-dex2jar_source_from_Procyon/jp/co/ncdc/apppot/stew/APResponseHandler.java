// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.json.AJSONObject;
import java.io.UnsupportedEncodingException;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;

public abstract class APResponseHandler extends APSuperResponseHandler
{
    private static final String TAG = "APResponseHandler";
    private APResponseHandler handler;
    private APInterceptResponseListener mListener;
    private List<APObject> mLocalResultData;
    private List<APObject> mTargetData;
    private APResponse response;
    public String url;
    
    public APResponseHandler() {
        this.mListener = null;
        this.response = null;
    }
    
    public APResponseHandler(final APResponseHandler handler) {
        this.mListener = null;
        this.response = null;
        this.handler = handler;
    }
    
    public List<APObject> getData() {
        return this.mTargetData;
    }
    
    @Deprecated
    public APResponseHandler getHander() {
        return this.getHandler();
    }
    
    public APResponseHandler getHandler() {
        return this.handler;
    }
    
    public void onError(final String str, final Throwable t) {
        Logger.e("APResponseHandler", "[onError]" + this.url + ":" + str);
        this.countDown();
    }
    
    protected void onFailure(final Exception ex) {
        final APResponse apResponse = new APResponse() {
            @Override
            public String getDescription() {
                return ex.getMessage();
            }
            
            @Override
            public Object getResponseData() {
                return null;
            }
            
            @Override
            public List<APObject> getResultForSavedObject(final Class<?> clazz) {
                return null;
            }
            
            @Override
            public APSearchResult getResultForSearchObject(final Class<?> clazz) {
                return null;
            }
            
            @Override
            public boolean isOK() {
                return false;
            }
        };
        Logger.w("APResponseHandler", "[onFailure]message=" + ex.getMessage());
        this.onFailure(apResponse);
        this.countDown();
    }
    
    public abstract void onFailure(final APResponse p0);
    
    protected void onSuccess(final int n, String description) {
        Logger.v("APResponseHandler", "[onSuccess]URL=" + this.url + " \nStatusCode=" + n + "\nBody=" + description);
        if (n != 200) {
            this.onError(description, new APException("Error:" + n));
            return;
        }
        try {
            final AJSONObject convertToJSONObject = JsonUtils.convertToJSONObject(description);
            APJSONResponse response;
            if (this.url.contains("/groups")) {
                response = new APGroupResponse(convertToJSONObject, this.mLocalResultData);
            }
            else if (this.url.contains("/users")) {
                response = new APUserResponse(convertToJSONObject, this.mLocalResultData);
            }
            else if (this.url.contains("/files")) {
                response = new APFileResponse(convertToJSONObject, this.mLocalResultData);
            }
            else {
                response = new APJSONResponse(convertToJSONObject, this.mLocalResultData);
            }
            this.response = response;
            this.checkOutOfService(APService.getInstance().getServerInfo().checkCharacter, description, n);
            description = response.getDescription();
            if (this.mListener != null) {
                this.mListener.receiveData(response);
            }
            if (response.isOK()) {
                Logger.d("APResponseHandler", "[onSuccess]responseBody=" + convertToJSONObject);
                this.onSuccess(response);
            }
            else {
                this.checkTokenValid(description);
                this.onFailure(response);
            }
        }
        catch (APOutOfServiceException ex3) {
            this.onFailure(new APOutOfServiceException());
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
            Logger.v("APResponseHandler", "[onSuccess]NPE");
            this.onFailure(ex);
        }
        catch (UnsupportedEncodingException ex2) {
            ex2.printStackTrace();
            this.onFailure(ex2);
        }
        finally {
            this.countDown();
        }
    }
    
    public abstract void onSuccess(final APResponse p0);
    
    public void setData(final List<APObject> mTargetData) {
        this.mTargetData = mTargetData;
    }
    
    void setInterceptDataListener(final APInterceptResponseListener mListener) {
        this.mListener = mListener;
    }
    
    void setLocalResultData(final List<APObject> mLocalResultData) {
        this.mLocalResultData = mLocalResultData;
    }
    
    interface APInterceptResponseListener
    {
        void receiveData(final APResponse p0);
    }
}
