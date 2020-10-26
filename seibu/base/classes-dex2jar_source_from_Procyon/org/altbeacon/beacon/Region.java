// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.beacon;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import java.util.regex.Pattern;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class Region implements Parcelable, Serializable
{
    public static final Parcelable$Creator<Region> CREATOR;
    private static final Pattern MAC_PATTERN;
    private static final String TAG = "Region";
    protected final String mBluetoothAddress;
    protected final List<Identifier> mIdentifiers;
    protected final String mUniqueId;
    
    static {
        MAC_PATTERN = Pattern.compile("^[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}$");
        CREATOR = (Parcelable$Creator)new Region$1();
    }
    
    protected Region(final Parcel parcel) {
        this.mUniqueId = parcel.readString();
        this.mBluetoothAddress = parcel.readString();
        final int int1 = parcel.readInt();
        this.mIdentifiers = new ArrayList<Identifier>(int1);
        for (int i = 0; i < int1; ++i) {
            final String string = parcel.readString();
            if (string == null) {
                this.mIdentifiers.add(null);
            }
            else {
                this.mIdentifiers.add(Identifier.parse(string));
            }
        }
    }
    
    public Region(final String mUniqueId, final String mBluetoothAddress) {
        this.validateMac(mBluetoothAddress);
        this.mBluetoothAddress = mBluetoothAddress;
        this.mUniqueId = mUniqueId;
        this.mIdentifiers = new ArrayList<Identifier>();
        if (mUniqueId == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }
    
    public Region(final String s, final List<Identifier> list) {
        this(s, list, null);
    }
    
    public Region(final String mUniqueId, final List<Identifier> c, final String mBluetoothAddress) {
        this.validateMac(mBluetoothAddress);
        this.mIdentifiers = new ArrayList<Identifier>(c);
        this.mUniqueId = mUniqueId;
        this.mBluetoothAddress = mBluetoothAddress;
        if (mUniqueId == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }
    
    public Region(final String mUniqueId, final Identifier identifier, final Identifier identifier2, final Identifier identifier3) {
        (this.mIdentifiers = new ArrayList<Identifier>(3)).add(identifier);
        this.mIdentifiers.add(identifier2);
        this.mIdentifiers.add(identifier3);
        this.mUniqueId = mUniqueId;
        this.mBluetoothAddress = null;
        if (mUniqueId == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }
    
    private void validateMac(final String s) throws IllegalArgumentException {
        if (s != null && !Region.MAC_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("Invalid mac address: '" + s + "' Must be 6 hex bytes separated by colons.");
        }
    }
    
    @Deprecated
    public Region clone() {
        return new Region(this.mUniqueId, this.mIdentifiers, this.mBluetoothAddress);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Region && ((Region)o).mUniqueId.equals(this.mUniqueId);
    }
    
    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }
    
    public Identifier getId1() {
        return this.getIdentifier(0);
    }
    
    public Identifier getId2() {
        return this.getIdentifier(1);
    }
    
    public Identifier getId3() {
        return this.getIdentifier(2);
    }
    
    public Identifier getIdentifier(final int n) {
        if (this.mIdentifiers.size() > n) {
            return this.mIdentifiers.get(n);
        }
        return null;
    }
    
    public String getUniqueId() {
        return this.mUniqueId;
    }
    
    public boolean hasSameIdentifiers(final Region region) {
        if (region.mIdentifiers.size() == this.mIdentifiers.size()) {
            for (int i = 0; i < region.mIdentifiers.size(); ++i) {
                if ((region.getIdentifier(i) == null && this.getIdentifier(i) != null) || (region.getIdentifier(i) != null && this.getIdentifier(i) == null) || ((region.getIdentifier(i) != null || this.getIdentifier(i) != null) && !region.getIdentifier(i).equals(this.getIdentifier(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.mUniqueId.hashCode();
    }
    
    public boolean matchesBeacon(final Beacon beacon) {
        int size = this.mIdentifiers.size();
        Label_0094: {
            while (true) {
                final int n = size - 1;
                if (n < 0) {
                    break Label_0094;
                }
                final Identifier identifier = this.mIdentifiers.get(n);
                Object identifier2 = null;
                if (n < beacon.mIdentifiers.size()) {
                    identifier2 = beacon.getIdentifier(n);
                }
                if (identifier2 == null && identifier != null) {
                    break;
                }
                size = n;
                if (identifier2 == null) {
                    continue;
                }
                size = n;
                if (identifier == null) {
                    continue;
                }
                size = n;
                if (!identifier.equals(identifier2)) {
                    break;
                }
            }
            return false;
        }
        if (this.mBluetoothAddress == null || this.mBluetoothAddress.equalsIgnoreCase(beacon.mBluetoothAddress)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        int i = 1;
        for (final Identifier identifier : this.mIdentifiers) {
            if (i > 1) {
                sb.append(" ");
            }
            sb.append("id");
            sb.append(i);
            sb.append(": ");
            String string;
            if (identifier == null) {
                string = "null";
            }
            else {
                string = identifier.toString();
            }
            sb.append(string);
            ++i;
        }
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.mUniqueId);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mIdentifiers.size());
        for (final Identifier identifier : this.mIdentifiers) {
            if (identifier != null) {
                parcel.writeString(identifier.toString());
            }
            else {
                parcel.writeString((String)null);
            }
        }
    }
}
