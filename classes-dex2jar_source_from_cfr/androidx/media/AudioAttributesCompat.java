/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package androidx.media;

import android.util.SparseIntArray;
import androidx.media.a;
import androidx.versionedparcelable.c;

public class AudioAttributesCompat
implements c {
    private static final SparseIntArray b = new SparseIntArray();
    private static final int[] c;
    a a;

    static {
        b.put(5, 1);
        b.put(6, 2);
        b.put(7, 2);
        b.put(8, 1);
        b.put(9, 1);
        b.put(10, 1);
        c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    static int a(boolean bl2, int n2, int n3) {
        if ((n2 & 1) == 1) {
            if (bl2) {
                return 1;
            }
            return 7;
        }
        int n4 = 0;
        if ((n2 & 4) == 4) {
            if (bl2) {
                return 0;
            }
            return 6;
        }
        int n5 = 3;
        n2 = n4;
        switch (n3) {
            default: {
                if (bl2) break;
                return 3;
            }
            case 13: {
                return 1;
            }
            case 11: {
                return 10;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                if (bl2) {
                    return 0;
                }
                n2 = 8;
            }
            case 2: {
                return n2;
            }
            case 1: 
            case 12: 
            case 14: 
            case 16: {
                return 3;
            }
            case 0: {
                n2 = n5;
                if (bl2) {
                    n2 = Integer.MIN_VALUE;
                }
                return n2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown usage value ");
        stringBuilder.append(n3);
        stringBuilder.append(" in audio attributes");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static String a(int n2) {
        switch (n2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown usage ");
                stringBuilder.append(n2);
                return stringBuilder.toString();
            }
            case 16: {
                return "USAGE_ASSISTANT";
            }
            case 14: {
                return "USAGE_GAME";
            }
            case 13: {
                return "USAGE_ASSISTANCE_SONIFICATION";
            }
            case 12: {
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            }
            case 11: {
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            }
            case 10: {
                return "USAGE_NOTIFICATION_EVENT";
            }
            case 9: {
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            }
            case 8: {
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            }
            case 7: {
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            }
            case 6: {
                return "USAGE_NOTIFICATION_RINGTONE";
            }
            case 5: {
                return "USAGE_NOTIFICATION";
            }
            case 4: {
                return "USAGE_ALARM";
            }
            case 3: {
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            }
            case 2: {
                return "USAGE_VOICE_COMMUNICATION";
            }
            case 1: {
                return "USAGE_MEDIA";
            }
            case 0: 
        }
        return "USAGE_UNKNOWN";
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof AudioAttributesCompat;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = (AudioAttributesCompat)object;
        if (this.a == null) {
            if (((AudioAttributesCompat)object).a == null) {
                bl3 = true;
            }
            return bl3;
        }
        return this.a.equals(((AudioAttributesCompat)object).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}

