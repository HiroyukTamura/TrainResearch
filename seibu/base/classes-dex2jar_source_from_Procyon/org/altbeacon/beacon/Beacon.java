// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.beacon;

import java.util.Iterator;
import org.altbeacon.beacon.logging.LogManager;
import java.util.Collection;
import android.os.Parcel;
import org.altbeacon.beacon.client.NullBeaconDataFactory;
import java.util.Collections;
import java.util.ArrayList;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.client.BeaconDataFactory;
import java.util.List;
import android.os.Parcelable$Creator;
import java.io.Serializable;
import android.os.Parcelable;

public class Beacon implements Parcelable, Serializable
{
    @Deprecated
    public static final Parcelable$Creator<Beacon> CREATOR;
    private static final String TAG = "Beacon";
    private static final List<Identifier> UNMODIFIABLE_LIST_OF_IDENTIFIER;
    private static final List<Long> UNMODIFIABLE_LIST_OF_LONG;
    protected static BeaconDataFactory beaconDataFactory;
    protected static DistanceCalculator sDistanceCalculator;
    protected static boolean sHardwareEqualityEnforced;
    protected int mBeaconTypeCode;
    protected String mBluetoothAddress;
    protected String mBluetoothName;
    protected List<Long> mDataFields;
    protected Double mDistance;
    protected List<Long> mExtraDataFields;
    protected List<Identifier> mIdentifiers;
    protected int mManufacturer;
    protected boolean mMultiFrameBeacon;
    private int mPacketCount;
    protected String mParserIdentifier;
    protected int mRssi;
    private int mRssiMeasurementCount;
    private Double mRunningAverageRssi;
    protected int mServiceUuid;
    protected int mTxPower;
    
    static {
        UNMODIFIABLE_LIST_OF_LONG = Collections.unmodifiableList((List<? extends Long>)new ArrayList<Long>());
        UNMODIFIABLE_LIST_OF_IDENTIFIER = Collections.unmodifiableList((List<? extends Identifier>)new ArrayList<Identifier>());
        Beacon.sHardwareEqualityEnforced = false;
        Beacon.sDistanceCalculator = null;
        Beacon.beaconDataFactory = (BeaconDataFactory)new NullBeaconDataFactory();
        CREATOR = (Parcelable$Creator)new Beacon$1();
    }
    
    protected Beacon() {
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        this.mIdentifiers = new ArrayList<Identifier>(1);
        this.mDataFields = new ArrayList<Long>(1);
        this.mExtraDataFields = new ArrayList<Long>(1);
    }
    
    @Deprecated
    protected Beacon(final Parcel parcel) {
        boolean mMultiFrameBeacon = false;
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        final int int1 = parcel.readInt();
        this.mIdentifiers = new ArrayList<Identifier>(int1);
        for (int i = 0; i < int1; ++i) {
            this.mIdentifiers.add(Identifier.parse(parcel.readString()));
        }
        this.mDistance = parcel.readDouble();
        this.mRssi = parcel.readInt();
        this.mTxPower = parcel.readInt();
        this.mBluetoothAddress = parcel.readString();
        this.mBeaconTypeCode = parcel.readInt();
        this.mServiceUuid = parcel.readInt();
        final int int2 = parcel.readInt();
        this.mDataFields = new ArrayList<Long>(int2);
        for (int j = 0; j < int2; ++j) {
            this.mDataFields.add(parcel.readLong());
        }
        final int int3 = parcel.readInt();
        this.mExtraDataFields = new ArrayList<Long>(int3);
        for (int k = 0; k < int3; ++k) {
            this.mExtraDataFields.add(parcel.readLong());
        }
        this.mManufacturer = parcel.readInt();
        this.mBluetoothName = parcel.readString();
        this.mParserIdentifier = parcel.readString();
        if (parcel.readByte() != 0) {
            mMultiFrameBeacon = true;
        }
        this.mMultiFrameBeacon = mMultiFrameBeacon;
        this.mRunningAverageRssi = (Double)parcel.readValue((ClassLoader)null);
        this.mRssiMeasurementCount = parcel.readInt();
        this.mPacketCount = parcel.readInt();
    }
    
    protected Beacon(final Beacon beacon) {
        this.mRssiMeasurementCount = 0;
        this.mPacketCount = 0;
        this.mRunningAverageRssi = null;
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        this.mIdentifiers = new ArrayList<Identifier>(beacon.mIdentifiers);
        this.mDataFields = new ArrayList<Long>(beacon.mDataFields);
        this.mExtraDataFields = new ArrayList<Long>(beacon.mExtraDataFields);
        this.mDistance = beacon.mDistance;
        this.mRunningAverageRssi = beacon.mRunningAverageRssi;
        this.mPacketCount = beacon.mPacketCount;
        this.mRssiMeasurementCount = beacon.mRssiMeasurementCount;
        this.mRssi = beacon.mRssi;
        this.mTxPower = beacon.mTxPower;
        this.mBluetoothAddress = beacon.mBluetoothAddress;
        this.mBeaconTypeCode = beacon.getBeaconTypeCode();
        this.mServiceUuid = beacon.getServiceUuid();
        this.mBluetoothName = beacon.mBluetoothName;
        this.mParserIdentifier = beacon.mParserIdentifier;
        this.mMultiFrameBeacon = beacon.mMultiFrameBeacon;
        this.mManufacturer = beacon.mManufacturer;
    }
    
    protected static Double calculateDistance(final int n, final double n2) {
        if (getDistanceCalculator() != null) {
            return getDistanceCalculator().calculateDistance(n, n2);
        }
        LogManager.e("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return -1.0;
    }
    
    public static DistanceCalculator getDistanceCalculator() {
        return Beacon.sDistanceCalculator;
    }
    
    public static boolean getHardwareEqualityEnforced() {
        return Beacon.sHardwareEqualityEnforced;
    }
    
    public static void setDistanceCalculator(final DistanceCalculator sDistanceCalculator) {
        Beacon.sDistanceCalculator = sDistanceCalculator;
    }
    
    public static void setHardwareEqualityEnforced(final boolean sHardwareEqualityEnforced) {
        Beacon.sHardwareEqualityEnforced = sHardwareEqualityEnforced;
    }
    
    private StringBuilder toStringBuilder() {
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
        if (this.mParserIdentifier != null) {
            sb.append(" type " + this.mParserIdentifier);
        }
        return sb;
    }
    
    @Deprecated
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Beacon) {
            final Beacon beacon = (Beacon)o;
            if (this.mIdentifiers.equals(beacon.mIdentifiers)) {
                return !Beacon.sHardwareEqualityEnforced || this.getBluetoothAddress().equals(beacon.getBluetoothAddress());
            }
        }
        return false;
    }
    
    public int getBeaconTypeCode() {
        return this.mBeaconTypeCode;
    }
    
    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }
    
    public String getBluetoothName() {
        return this.mBluetoothName;
    }
    
    public List<Long> getDataFields() {
        if (this.mDataFields.getClass().isInstance(Beacon.UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mDataFields;
        }
        return Collections.unmodifiableList((List<? extends Long>)this.mDataFields);
    }
    
    public double getDistance() {
        if (this.mDistance == null) {
            double doubleValue = this.mRssi;
            if (this.mRunningAverageRssi != null) {
                doubleValue = this.mRunningAverageRssi;
            }
            else {
                LogManager.d("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            this.mDistance = calculateDistance(this.mTxPower, doubleValue);
        }
        return this.mDistance;
    }
    
    public List<Long> getExtraDataFields() {
        if (this.mExtraDataFields.getClass().isInstance(Beacon.UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mExtraDataFields;
        }
        return Collections.unmodifiableList((List<? extends Long>)this.mExtraDataFields);
    }
    
    public Identifier getId1() {
        return this.mIdentifiers.get(0);
    }
    
    public Identifier getId2() {
        return this.mIdentifiers.get(1);
    }
    
    public Identifier getId3() {
        return this.mIdentifiers.get(2);
    }
    
    public Identifier getIdentifier(final int n) {
        return this.mIdentifiers.get(n);
    }
    
    public List<Identifier> getIdentifiers() {
        if (this.mIdentifiers.getClass().isInstance(Beacon.UNMODIFIABLE_LIST_OF_IDENTIFIER)) {
            return this.mIdentifiers;
        }
        return Collections.unmodifiableList((List<? extends Identifier>)this.mIdentifiers);
    }
    
    public int getManufacturer() {
        return this.mManufacturer;
    }
    
    public int getMeasurementCount() {
        return this.mRssiMeasurementCount;
    }
    
    public int getPacketCount() {
        return this.mPacketCount;
    }
    
    public String getParserIdentifier() {
        return this.mParserIdentifier;
    }
    
    public int getRssi() {
        return this.mRssi;
    }
    
    public double getRunningAverageRssi() {
        if (this.mRunningAverageRssi != null) {
            return this.mRunningAverageRssi;
        }
        return this.mRssi;
    }
    
    @Deprecated
    public double getRunningAverageRssi(final double d) {
        final Double value = d;
        this.mRunningAverageRssi = value;
        return value;
    }
    
    public int getServiceUuid() {
        return this.mServiceUuid;
    }
    
    public int getTxPower() {
        return this.mTxPower;
    }
    
    @Override
    public int hashCode() {
        final StringBuilder stringBuilder = this.toStringBuilder();
        if (Beacon.sHardwareEqualityEnforced) {
            stringBuilder.append(this.mBluetoothAddress);
        }
        return stringBuilder.toString().hashCode();
    }
    
    public boolean isExtraBeaconData() {
        return this.mIdentifiers.size() == 0 && this.mDataFields.size() != 0;
    }
    
    public boolean isMultiFrameBeacon() {
        return this.mMultiFrameBeacon;
    }
    
    public void requestData(final BeaconDataNotifier beaconDataNotifier) {
        Beacon.beaconDataFactory.requestBeaconData(this, beaconDataNotifier);
    }
    
    public void setExtraDataFields(final List<Long> mExtraDataFields) {
        this.mExtraDataFields = mExtraDataFields;
    }
    
    public void setPacketCount(final int mPacketCount) {
        this.mPacketCount = mPacketCount;
    }
    
    public void setRssi(final int mRssi) {
        this.mRssi = mRssi;
    }
    
    public void setRssiMeasurementCount(final int mRssiMeasurementCount) {
        this.mRssiMeasurementCount = mRssiMeasurementCount;
    }
    
    public void setRunningAverageRssi(final double d) {
        this.mRunningAverageRssi = d;
        this.mDistance = null;
    }
    
    @Override
    public String toString() {
        return this.toStringBuilder().toString();
    }
    
    @Deprecated
    public void writeToParcel(final Parcel parcel, int n) {
        parcel.writeInt(this.mIdentifiers.size());
        for (final Identifier identifier : this.mIdentifiers) {
            String string;
            if (identifier == null) {
                string = null;
            }
            else {
                string = identifier.toString();
            }
            parcel.writeString(string);
        }
        parcel.writeDouble(this.getDistance());
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mTxPower);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mBeaconTypeCode);
        parcel.writeInt(this.mServiceUuid);
        parcel.writeInt(this.mDataFields.size());
        final Iterator<Long> iterator2 = this.mDataFields.iterator();
        while (iterator2.hasNext()) {
            parcel.writeLong((long)iterator2.next());
        }
        parcel.writeInt(this.mExtraDataFields.size());
        final Iterator<Long> iterator3 = this.mExtraDataFields.iterator();
        while (iterator3.hasNext()) {
            parcel.writeLong((long)iterator3.next());
        }
        parcel.writeInt(this.mManufacturer);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mParserIdentifier);
        if (this.mMultiFrameBeacon) {
            n = 1;
        }
        else {
            n = 0;
        }
        parcel.writeByte((byte)n);
        parcel.writeValue((Object)this.mRunningAverageRssi);
        parcel.writeInt(this.mRssiMeasurementCount);
        parcel.writeInt(this.mPacketCount);
    }
}
