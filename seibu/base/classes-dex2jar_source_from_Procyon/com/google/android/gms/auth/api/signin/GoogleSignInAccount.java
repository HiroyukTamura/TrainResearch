// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.Set;
import android.accounts.Account;
import java.util.Iterator;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zzbo;
import java.util.HashSet;
import org.json.JSONObject;
import android.text.TextUtils;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzi;
import android.net.Uri;
import java.util.List;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;
import com.google.android.gms.common.util.zze;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class GoogleSignInAccount extends zza implements ReflectedParcelable
{
    public static final Parcelable$Creator<GoogleSignInAccount> CREATOR;
    private static zze zzalN;
    private static Comparator<Scope> zzalU;
    private int versionCode;
    private String zzIi;
    private String zzakX;
    private String zzakY;
    private List<Scope> zzakz;
    private String zzalO;
    private String zzalP;
    private Uri zzalQ;
    private String zzalR;
    private long zzalS;
    private String zzalT;
    private String zzaln;
    
    static {
        CREATOR = (Parcelable$Creator)new zzb();
        GoogleSignInAccount.zzalN = zzi.zzrY();
        GoogleSignInAccount.zzalU = new com.google.android.gms.auth.api.signin.zza();
    }
    
    GoogleSignInAccount(final int versionCode, final String zzIi, final String zzaln, final String zzalO, final String zzalP, final Uri zzalQ, final String zzalR, final long zzalS, final String zzalT, final List<Scope> zzakz, final String zzakX, final String zzakY) {
        this.versionCode = versionCode;
        this.zzIi = zzIi;
        this.zzaln = zzaln;
        this.zzalO = zzalO;
        this.zzalP = zzalP;
        this.zzalQ = zzalQ;
        this.zzalR = zzalR;
        this.zzalS = zzalS;
        this.zzalT = zzalT;
        this.zzakz = zzakz;
        this.zzakX = zzakX;
        this.zzakY = zzakY;
    }
    
    @Nullable
    public static GoogleSignInAccount zzbP(@Nullable final String s) throws JSONException {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        final JSONObject jsonObject = new JSONObject(s);
        Uri parse = null;
        final String optString = jsonObject.optString("photoUrl", (String)null);
        if (!TextUtils.isEmpty((CharSequence)optString)) {
            parse = Uri.parse(optString);
        }
        final long long1 = Long.parseLong(jsonObject.getString("expirationTime"));
        final HashSet<Scope> set = new HashSet<Scope>();
        final JSONArray jsonArray = jsonObject.getJSONArray("grantedScopes");
        for (int length = jsonArray.length(), i = 0; i < length; ++i) {
            set.add(new Scope(jsonArray.getString(i)));
        }
        final String optString2 = jsonObject.optString("id");
        final String optString3 = jsonObject.optString("tokenId", (String)null);
        final String optString4 = jsonObject.optString("email", (String)null);
        final String optString5 = jsonObject.optString("displayName", (String)null);
        final String optString6 = jsonObject.optString("givenName", (String)null);
        final String optString7 = jsonObject.optString("familyName", (String)null);
        Long n = long1;
        final String string = jsonObject.getString("obfuscatedIdentifier");
        if (n == null) {
            n = GoogleSignInAccount.zzalN.currentTimeMillis() / 1000L;
        }
        final GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, n, zzbo.zzcF(string), new ArrayList<Scope>(zzbo.zzu(set)), optString6, optString7);
        googleSignInAccount.zzalR = jsonObject.optString("serverAuthCode", (String)null);
        return googleSignInAccount;
    }
    
    private final JSONObject zzmz() {
        final JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;
        try {
            if (this.getId() != null) {
                jsonObject.put("id", (Object)this.getId());
            }
            if (this.getIdToken() != null) {
                jsonObject.put("tokenId", (Object)this.getIdToken());
            }
            if (this.getEmail() != null) {
                jsonObject.put("email", (Object)this.getEmail());
            }
            if (this.getDisplayName() != null) {
                jsonObject.put("displayName", (Object)this.getDisplayName());
            }
            if (this.getGivenName() != null) {
                jsonObject.put("givenName", (Object)this.getGivenName());
            }
            if (this.getFamilyName() != null) {
                jsonObject.put("familyName", (Object)this.getFamilyName());
            }
            if (this.getPhotoUrl() != null) {
                jsonObject.put("photoUrl", (Object)this.getPhotoUrl().toString());
            }
            if (this.getServerAuthCode() != null) {
                jsonObject.put("serverAuthCode", (Object)this.getServerAuthCode());
            }
            jsonObject.put("expirationTime", this.zzalS);
            jsonObject.put("obfuscatedIdentifier", (Object)this.zzalT);
            jsonArray = new JSONArray();
            Collections.sort(this.zzakz, GoogleSignInAccount.zzalU);
            final Iterator<Scope> iterator = this.zzakz.iterator();
            while (iterator.hasNext()) {
                jsonArray.put((Object)iterator.next().zzpp());
            }
        }
        catch (JSONException cause) {
            throw new RuntimeException((Throwable)cause);
        }
        jsonObject.put("grantedScopes", (Object)jsonArray);
        return jsonObject;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof GoogleSignInAccount && ((GoogleSignInAccount)o).zzmz().toString().equals(this.zzmz().toString());
    }
    
    @Nullable
    public Account getAccount() {
        if (this.zzalO == null) {
            return null;
        }
        return new Account(this.zzalO, "com.google");
    }
    
    @Nullable
    public String getDisplayName() {
        return this.zzalP;
    }
    
    @Nullable
    public String getEmail() {
        return this.zzalO;
    }
    
    @Nullable
    public String getFamilyName() {
        return this.zzakY;
    }
    
    @Nullable
    public String getGivenName() {
        return this.zzakX;
    }
    
    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet<Scope>(this.zzakz);
    }
    
    @Nullable
    public String getId() {
        return this.zzIi;
    }
    
    @Nullable
    public String getIdToken() {
        return this.zzaln;
    }
    
    @Nullable
    public Uri getPhotoUrl() {
        return this.zzalQ;
    }
    
    @Nullable
    public String getServerAuthCode() {
        return this.zzalR;
    }
    
    @Override
    public int hashCode() {
        return this.zzmz().toString().hashCode();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.getId(), false);
        zzd.zza(parcel, 3, this.getIdToken(), false);
        zzd.zza(parcel, 4, this.getEmail(), false);
        zzd.zza(parcel, 5, this.getDisplayName(), false);
        zzd.zza(parcel, 6, (Parcelable)this.getPhotoUrl(), n, false);
        zzd.zza(parcel, 7, this.getServerAuthCode(), false);
        zzd.zza(parcel, 8, this.zzalS);
        zzd.zza(parcel, 9, this.zzalT, false);
        zzd.zzc(parcel, 10, this.zzakz, false);
        zzd.zza(parcel, 11, this.getGivenName(), false);
        zzd.zza(parcel, 12, this.getFamilyName(), false);
        zzd.zzI(parcel, zze);
    }
    
    public final boolean zzmw() {
        return GoogleSignInAccount.zzalN.currentTimeMillis() / 1000L >= this.zzalS - 300L;
    }
    
    @NonNull
    public final String zzmx() {
        return this.zzalT;
    }
    
    public final String zzmy() {
        final JSONObject zzmz = this.zzmz();
        zzmz.remove("serverAuthCode");
        return zzmz.toString();
    }
}
