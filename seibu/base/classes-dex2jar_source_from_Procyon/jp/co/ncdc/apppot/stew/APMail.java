// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONArray;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import java.util.List;

public class APMail
{
    static final String KEY_BODY = "body";
    static final String KEY_MAIL_FROM = "mailFrom";
    static final String KEY_MAIL_TO = "mailTo";
    static final String KEY_SENDING_ROUTE_NAME = "sendingRouteName";
    static final String KEY_SUBJECT = "subject";
    private static final APService SERVICE;
    public String sendingRouteName;
    
    static {
        SERVICE = APService.getInstance();
    }
    
    public APMail(final String sendingRouteName) {
        this.sendingRouteName = sendingRouteName;
    }
    
    private AJSONObject createRequest(final String s, final String s2, final List<String> list, final String s3, final String s4) throws JSONException {
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("sendingRouteName", s);
        ajsonObject.put("mailFrom", s2);
        ajsonObject.put("body", s4);
        ajsonObject.put("subject", s3);
        final JSONArray jsonArray = new JSONArray();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)iterator.next());
        }
        ajsonObject.put("mailTo", jsonArray);
        return ajsonObject;
    }
    
    public void post(final String s, final List<String> list, final String s2, final String s3, final APResponseHandler apResponseHandler) {
        if (!APMail.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        try {
            APMail.SERVICE.getHttpClient().postWithToken(APMail.SERVICE.getContext(), APMail.SERVICE.getAuthToken(), APMail.SERVICE.getServerInfo().getUrl("/emails"), this.createRequest(this.sendingRouteName, s, list, s2, s3), apResponseHandler);
        }
        catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}
