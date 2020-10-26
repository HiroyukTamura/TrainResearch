/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2\u00a8\u00063"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ArgumentKeys;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "VIEW_MODEL_PROVIDERS", "DATA_BINDING_UTIL", "DEPARTURE_OR_ARRIVAL", "USE_CURRENT_DATE_TIME", "SELECTED_DATE", "DEPARTURE_STATION", "DEPARTURE_STATION_CODE", "DEPARTURE_STATION_NAME", "ARRIVAL_STATION", "ARRIVAL_STATION_CODE", "ARRIVAL_STATION_NAME", "VIA_STATION1", "VIA_STATION1_CODE", "VIA_STATION1_NAME", "VIA_STATION2", "VIA_STATION2_CODE", "VIA_STATION2_NAME", "EXPRESS", "FARE", "TRANSFER_TIME", "STATION", "ROUTE", "VIEW_CONFIG", "LINE", "VIEW_TYPE_NAME", "SETTING_TYPE", "SITE", "FAVORITE_ROUTE", "USER_SETTINGS_PREF", "HIDDEN_MYROUTE_NOTICE", "HIDDEN_SCREEN_CAPTURE_NOTICE", "APP_VERSION_CODE", "SAVED_TOKEN_FLAG", "PUSH_V", "PUSH_P", "PUSH_MESSAGE", "TRAIN_SERVICE_AREA", "HISTORY_SELECTED_LINE_VM", "RAILWAY_LIST_VM", "TRAIN_LOCATION_PAGE_TYPE", "ACTIVE_TAB_ITEM_TAG", "TRAIN_LOCATION_PAGE", "RAILWAY_LINE", "MIXPANEL_OPTOUT", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends Enum<b> {
    public static final /* enum */ b A;
    public static final /* enum */ b B;
    public static final /* enum */ b C;
    public static final /* enum */ b D;
    public static final /* enum */ b E;
    public static final /* enum */ b F;
    public static final /* enum */ b G;
    public static final /* enum */ b H;
    public static final /* enum */ b I;
    public static final /* enum */ b J;
    public static final /* enum */ b K;
    public static final /* enum */ b L;
    public static final /* enum */ b M;
    public static final /* enum */ b N;
    public static final /* enum */ b O;
    public static final /* enum */ b P;
    public static final /* enum */ b Q;
    public static final /* enum */ b R;
    private static final /* synthetic */ b[] S;
    public static final /* enum */ b a;
    public static final /* enum */ b b;
    public static final /* enum */ b c;
    public static final /* enum */ b d;
    public static final /* enum */ b e;
    public static final /* enum */ b f;
    public static final /* enum */ b g;
    public static final /* enum */ b h;
    public static final /* enum */ b i;
    public static final /* enum */ b j;
    public static final /* enum */ b k;
    public static final /* enum */ b l;
    public static final /* enum */ b m;
    public static final /* enum */ b n;
    public static final /* enum */ b o;
    public static final /* enum */ b p;
    public static final /* enum */ b q;
    public static final /* enum */ b r;
    public static final /* enum */ b s;
    public static final /* enum */ b t;
    public static final /* enum */ b u;
    public static final /* enum */ b v;
    public static final /* enum */ b w;
    public static final /* enum */ b x;
    public static final /* enum */ b y;
    public static final /* enum */ b z;
    private final String T;

    static {
        b b2;
        b b3;
        b b4;
        b b5;
        b b6;
        b b7;
        b b8;
        b b9;
        b b10;
        b b11;
        b b12;
        b b13;
        b b14;
        b b15;
        b b16;
        b b17;
        b b18;
        b b19;
        b b20;
        b b21;
        b b22;
        b b23;
        b b24;
        b b25;
        b b26;
        b b27;
        b b28;
        b b29;
        b b30;
        b b31;
        b b32;
        b b33;
        b b34;
        b b35;
        b b36;
        b b37;
        b b38;
        b b39;
        b b40;
        b b41;
        b b42;
        b b43;
        b b44;
        b b45;
        a = b29 = new b("providers");
        b = b10 = new b("bindingUtil");
        c = b33 = new b("departureOrArrival");
        d = b39 = new b("useCurrentDateTime");
        e = b6 = new b("selectedDate");
        f = b28 = new b("departureStation");
        g = b40 = new b("departure_station_code");
        h = b3 = new b("departure_station_name");
        i = b35 = new b("arrivalStation");
        j = b42 = new b("arrival_station_code");
        k = b27 = new b("arrival_station_name");
        l = b44 = new b("viaStation1");
        m = b15 = new b("via1_station_code");
        n = b26 = new b("via1_station_name");
        o = b13 = new b("viaStation2");
        p = b31 = new b("via2_station_code");
        q = b38 = new b("via2_station_name");
        r = b24 = new b("express");
        s = b25 = new b("fare");
        t = b9 = new b("transfer_time");
        u = b22 = new b("station");
        v = b43 = new b("route");
        w = b18 = new b("viewConfig");
        x = b12 = new b("line");
        y = b32 = new b("viewTypeName");
        z = b7 = new b("setting_type");
        A = b45 = new b("site");
        B = b19 = new b("favoriteRoute");
        C = b11 = new b("user_settings_pref");
        D = b37 = new b("hidden_myroute_notice");
        E = b21 = new b("hidden_screen_capture_notice");
        F = b8 = new b("appVersionCode");
        G = b36 = new b("saved_token_flag");
        H = b16 = new b("v");
        I = b41 = new b("p");
        J = b23 = new b("message");
        K = b5 = new b("train_service_area");
        L = b17 = new b("history_selected_line_vm");
        M = b34 = new b("railway_list_vm");
        N = b4 = new b("train_location_page_type");
        O = b14 = new b("active_tab_item_tag");
        P = b30 = new b("train_location_page");
        Q = b2 = new b("railway_line");
        R = b20 = new b("mixpanelOptout");
        S = new b[]{b29, b10, b33, b39, b6, b28, b40, b3, b35, b42, b27, b44, b15, b26, b13, b31, b38, b24, b25, b9, b22, b43, b18, b12, b32, b7, b45, b19, b11, b37, b21, b8, b36, b16, b41, b23, b5, b17, b34, b4, b14, b30, b2, b20};
    }

    protected b(String string3) {
        j.b(string3, "key");
        this.T = string3;
    }

    public static b valueOf(String string2) {
        return Enum.valueOf(b.class, string2);
    }

    public static b[] values() {
        return (b[])S.clone();
    }

    public final String a() {
        return this.T;
    }
}

