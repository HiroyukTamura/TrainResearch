package com.squareup.picasso;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.squareup.picasso.f */
class C1490f extends C1530z {

    /* renamed from: b */
    private static final UriMatcher f1615b;

    /* renamed from: a */
    private final Context f1616a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f1615b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f1615b.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f1615b.addURI("com.android.contacts", "contacts/#/photo", 2);
        f1615b.addURI("com.android.contacts", "contacts/#", 3);
        f1615b.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C1490f(Context context) {
        this.f1616a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.picasso.C1530z.C1531a mo27173a(com.squareup.picasso.C1526x r5, int r6) throws java.io.IOException {
        /*
            r4 = this;
            android.content.Context r6 = r4.f1616a
            android.content.ContentResolver r6 = r6.getContentResolver()
            android.net.Uri r5 = r5.f1717d
            android.content.UriMatcher r0 = f1615b
            int r0 = r0.match(r5)
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r3 = 2
            if (r0 == r3) goto L_0x0033
            r3 = 3
            if (r0 == r3) goto L_0x0040
            r1 = 4
            if (r0 != r1) goto L_0x001c
            goto L_0x0033
        L_0x001c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid uri: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x0033:
            java.io.InputStream r5 = r6.openInputStream(r5)
            goto L_0x0044
        L_0x0038:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.lookupContact(r6, r5)
            if (r5 != 0) goto L_0x0040
            r5 = r2
            goto L_0x0044
        L_0x0040:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r6, r5, r1)
        L_0x0044:
            if (r5 != 0) goto L_0x0047
            return r2
        L_0x0047:
            com.squareup.picasso.z$a r6 = new com.squareup.picasso.z$a
            j.z r5 = p042j.C2080p.m3583a((java.io.InputStream) r5)
            com.squareup.picasso.u$e r0 = com.squareup.picasso.C1513u.C1519e.DISK
            r6.<init>(r5, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1490f.mo27173a(com.squareup.picasso.x, int):com.squareup.picasso.z$a");
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        Uri uri = xVar.f1717d;
        return FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f1615b.match(xVar.f1717d) != -1;
    }
}
