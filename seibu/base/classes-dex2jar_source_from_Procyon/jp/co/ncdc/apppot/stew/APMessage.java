// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import java.util.Map;
import org.json.JSONException;
import java.util.Iterator;
import jp.co.ncdc.apppot.stew.dto.MessageGroupTarget;
import jp.co.ncdc.apppot.stew.dto.MessageUserTarget;
import jp.co.ncdc.apppot.stew.dto.MessageAllTarget;
import org.json.JSONObject;
import org.json.JSONArray;
import com.google.gson.Gson;
import jp.co.ncdc.apppot.stew.dto.APApp;
import java.util.Date;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import jp.co.ncdc.apppot.stew.dto.MessageTarget;
import java.util.List;

public class APMessage
{
    private static final String KEY_ACCOUNT = "account";
    private static final String KEY_ALL = "all";
    private static final String KEY_BADGE = "badge";
    private static final String KEY_CUSTOMDATA = "customData";
    private static final String KEY_GROUPID = "groupId";
    private static final String KEY_ICON = "icon";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_MESSAGE_LOC_ARGS = "messageLocArgs";
    private static final String KEY_MESSAGE_LOC_KEY = "messageLocKey";
    private static final String KEY_ROLENAME = "roleName";
    private static final String KEY_SEND_AT = "sendAt";
    private static final String KEY_SOUND = "sound";
    private static final String KEY_TARGET = "target";
    private static final String KEY_TARGET_APP = "targetApp";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TITLE_LOC_ARGS = "titleLocArgs";
    private static final String KEY_TITLE_LOC_KEY = "titleLocKey";
    private String message;
    private List<MessageTarget> messageTargetList;
    private AJSONObject requestJson;
    private Date sendAt;
    private APService service;
    private APApp targetApp;
    
    public APMessage(String message, final String s, final String s2, final Date sendAt, final List<MessageTarget> messageTargetList) {
        this.service = null;
        if (message == null || s == null) {
            this.targetApp = null;
        }
        else {
            this.targetApp = new APApp(message, s);
        }
        message = s2;
        if (s2 == null) {
            message = "";
        }
        this.message = message;
        this.sendAt = sendAt;
        if (messageTargetList == null || messageTargetList.size() <= 0) {
            throw new IllegalArgumentException("Target List is required.");
        }
        this.messageTargetList = messageTargetList;
        this.service = APService.getInstance();
        this.requestJson = new AJSONObject();
    }
    
    private AJSONObject createRequest(final APApp apApp, final List<MessageTarget> list, final String s, final Date date) throws JSONException {
        final Gson gson = new Gson();
        if (apApp != null) {
            this.requestJson.put("targetApp", gson.toJson(apApp));
        }
        this.requestJson.put("message", s);
        if (date != null) {
            this.requestJson.put("sendAt", date);
        }
        final JSONArray jsonArray = new JSONArray();
        for (final MessageTarget messageTarget : list) {
            final JSONObject jsonObject = new JSONObject();
            if (messageTarget instanceof MessageAllTarget) {
                jsonObject.put("all", true);
            }
            if (messageTarget instanceof MessageUserTarget) {
                jsonObject.put("account", (Object)((MessageUserTarget)messageTarget).getAccount());
            }
            if (messageTarget instanceof MessageGroupTarget) {
                final MessageGroupTarget messageGroupTarget = (MessageGroupTarget)messageTarget;
                jsonObject.put("groupId", messageGroupTarget.getGroupId());
                if (messageGroupTarget.getRoleName() != null && messageGroupTarget.getRoleName().length() != 0) {
                    jsonObject.put("roleName", (Object)messageGroupTarget.getRoleName());
                }
            }
            jsonArray.put((Object)jsonObject);
        }
        this.requestJson.put("target", jsonArray);
        return this.requestJson;
    }
    
    public void send(final APResponseHandler apResponseHandler) {
        if (!this.service.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        try {
            this.service.getHttpClient().postWithToken(this.service.getContext(), this.service.getAuthToken(), this.service.getServerInfo().getUrl("/messages"), this.createRequest(this.targetApp, this.messageTargetList, this.message, this.sendAt), apResponseHandler);
        }
        catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setCustomData(final Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.requestJson.put("customData", JsonUtils.toJson(map));
    }
    
    public void setIcon(final String s) {
        this.requestJson.put("icon", s);
    }
    
    public void setMessageLocArgs(final List<Object> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.requestJson.put("messageLocArgs", JsonUtils.toJsonArray(list));
    }
    
    public void setMessageLocKey(final String s) {
        this.requestJson.put("messageLocKey", s);
    }
    
    public void setSound(final String s) {
        this.requestJson.put("sound", s);
    }
    
    public void setTitle(final String s) {
        this.requestJson.put("title", s);
    }
    
    public void setTitleLocArgs(final List<Object> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.requestJson.put("titleLocArgs", JsonUtils.toJsonArray(list));
    }
    
    public void setTitleLocKey(final String s) {
        this.requestJson.put("titleLocKey", s);
    }
}
