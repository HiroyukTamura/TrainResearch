// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

public interface APConfig
{
    public static final String DATABASE_NAME = "stew.db";
    public static final int LOG_TIMER_INTERVAL = 600;
    public static final String OS_TYPE = "Android";
    public static final String TABLE_PRIMARY_KEY = "objectId";
    public static final String USER_INFO = "userInfo";
    
    public interface APTable
    {
        public static final String COL_CREATE_DATE = "createDate";
        public static final String COL_LOG_LEVL = "logLevel";
        public static final String COL_MESSAGE = "message";
        public static final String COL_MESSAGE_TYPE = "messageType";
        public static final String COL_OBJECT_ID = "targetObjectId";
        public static final String COL_SERVER_UPDATE_TIME = "serverUpdateTime";
        public static final String COL_TABLE_NAME = "targetTableName";
        public static final String COL_USER_TOKEN = "userToken";
        public static final int MESSAGE_DELETE = 3;
        public static final int MESSAGE_INSERT = 1;
        public static final int MESSAGE_UPDATE = 2;
    }
    
    public interface Key
    {
        public static final String ACCOUNT = "account";
        public static final String APP_ID = "appId";
        public static final String APP_KEY = "appKey";
        public static final String APP_VERSION = "appVersion";
        public static final String AUTH_INFO = "authInfor";
        public static final String AUTH_TOKEN = "authToken";
        public static final String COLUMNS = "columns";
        public static final String COLUMN_NAME = "colName";
        public static final String COLUMN_TYPE = "type";
        public static final String COMPANY_ID = "companyId";
        public static final String CONDITON = "condition";
        public static final String COUNTER = "counter";
        public static final String COUNT_QUERY_ALIAS = "__APPPOT_COUNT__";
        public static final String CREATE_TIME = "createTime";
        public static final String CREATE_USER_ID = "createUserId";
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String DEVICE_NAME = "deviceName";
        public static final String DEVICE_TOKEN = "deviceToken";
        public static final String DEVICE_UDID = "deviceUDID";
        public static final String FIRST_NAME = "firstName";
        public static final String GROUPS_AND_ROLES = "groupsAndRoles";
        public static final String GROUP_ID = "groupId";
        public static final String GROUP_IDS = "groupIds";
        public static final String GROUP_NAME = "groupName";
        public static final String IS_PUSH = "isPush";
        public static final String IS_RESET_DATABASE = "isResetDatabase";
        public static final String IS_USING_LOCK_FOR_UPDATE = "isUsingLockForUpdate";
        public static final String JOIN_TYPE = "joinType";
        public static final String LAST_NAME = "lastName";
        public static final String LOG_LEVEL = "logLevel";
        public static final String MAX_RECORD = "maxRecord";
        public static final String MESSAGE = "message";
        public static final String NAME = "name";
        public static final String OBJECT_ID = "objectId";
        public static final String OBJECT_IDS = "objectIds";
        public static final String OBJECT_NAME = "objectName";
        public static final String OBJECT_NAMES = "objectNames";
        public static final String OS_TYPE = "osType";
        public static final String PAGE_INDEX = "pageIndex";
        public static final String PASSWORD = "password";
        public static final String PRIMARY_KEY = "primary_key";
        public static final String RECORD = "record";
        public static final String RECORDS = "records";
        public static final String RESULT = "result";
        public static final String RESULTS = "results";
        public static final String RETURNED_OBJECT_NAMES = "returnedObjectNames";
        public static final String ROLE_ID = "roleId";
        public static final String ROLE_NAME = "roleName";
        public static final String SCOPE_TYPE = "scopeType";
        public static final String SERIAL_VERSION_UID = "serialVersionUID";
        public static final String SERVER_CREATE_TIME = "serverCreateTime";
        public static final String SERVER_RECORD_STATUS = "serverRecordStatus";
        public static final String SERVER_UPDATE_TIME = "serverUpdateTime";
        public static final String STATUS = "status";
        public static final String SYNC_DATA_FLAG = "syncDataFlag";
        public static final String TABLES = "tables";
        public static final String TABLE_NAME = "name";
        public static final String TABLE_NAME_JSON = "tableName";
        public static final String TOKEN = "token";
        public static final String TOTAL_PAGE = "totalPage";
        public static final String UPDATE_TIME = "updateTime";
        public static final String USER_ID = "userId";
        public static final String USER_INFO = "userInfo";
        public static final String USER_NAME = "username";
        public static final String USER_TOKENS = "userTokens";
        public static final String VALID_TIME = "validTime";
        public static final String VALUE = "value";
        public static final String _CHANGE = "$change";
    }
    
    public interface MSG
    {
        public static final String FAIL_INIT_REQUEST = "failed anonymous token";
        public static final String NOT_SERVICE_INIT = "you need to set APService.setServiceInfo";
        public static final String TOKEN_ERROR_1 = "Token does not exist";
        public static final String TOKEN_ERROR_2 = "The token is expired.";
        public static final String TOKEN_ERROR_3 = "User does not exist";
    }
    
    public interface ServerInfo
    {
        public static final String ADD_NEW_DATA = "/data/batch/addData";
        public static final String CONTENT_TYPE = "application/json";
        public static final String CREATE_APP_DATA = "/schemas";
        public static final String DELETE_DATA = "/data/batch/deleteData";
        public static final String DEVICE_REGISTRATION = "/devices";
        public static final String ENV_NAME = "/api";
        public static final String FILES = "/files";
        public static final String GET_ANONYMOUS_TOKEN = "/anonymousTokens";
        public static final String GET_DATA = "/data/query";
        public static final String GET_DATA_ONE = "/data";
        public static final String GET_LOG_LEVEL = "/logLevel";
        public static final String GET_ROLES = "/roles";
        public static final String GROUPS = "/groups";
        public static final String HTTPS_SCHEME = "https://";
        public static final String HTTP_SCHEME = "http://";
        public static final String LOG = "/logs";
        public static final String LOGIN = "/auth/login";
        public static final String LOGOUT = "/auth/logout";
        public static final String MAILS = "/emails";
        public static final String MESSAGES = "/messages";
        public static final String UPDATE_DATA = "/data/batch/updateData";
        public static final String USERS = "/users";
    }
}
