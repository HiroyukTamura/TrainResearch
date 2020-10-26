// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.beacon;

import java.io.Serializable;
import android.bluetooth.le.AdvertiseSettings$Builder;
import android.bluetooth.le.AdvertiseData$Builder;
import java.util.UUID;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import android.os.ParcelUuid;
import android.os.Build$VERSION;
import org.altbeacon.beacon.logging.LogManager;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.annotation.TargetApi;

@TargetApi(21)
public class BeaconTransmitter
{
    public static final int NOT_SUPPORTED_BLE = 2;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER = 4;
    public static final int NOT_SUPPORTED_CANNOT_GET_ADVERTISER_MULTIPLE_ADVERTISEMENTS = 5;
    public static final int NOT_SUPPORTED_MIN_SDK = 1;
    @Deprecated
    public static final int NOT_SUPPORTED_MULTIPLE_ADVERTISEMENTS = 3;
    public static final int SUPPORTED = 0;
    private static final String TAG = "BeaconTransmitter";
    private AdvertiseCallback mAdvertiseCallback;
    private int mAdvertiseMode;
    private int mAdvertiseTxPowerLevel;
    private AdvertiseCallback mAdvertisingClientCallback;
    private Beacon mBeacon;
    private BeaconParser mBeaconParser;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private boolean mConnectable;
    private boolean mStarted;
    
    public BeaconTransmitter(final Context context, final BeaconParser mBeaconParser) {
        this.mAdvertiseMode = 0;
        this.mAdvertiseTxPowerLevel = 3;
        this.mConnectable = false;
        this.mBeaconParser = mBeaconParser;
        final BluetoothManager bluetoothManager = (BluetoothManager)context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
            this.mBluetoothLeAdvertiser = this.mBluetoothAdapter.getBluetoothLeAdvertiser();
            LogManager.d("BeaconTransmitter", "new BeaconTransmitter constructed.  mbluetoothLeAdvertiser is %s", new Object[] { this.mBluetoothLeAdvertiser });
            return;
        }
        LogManager.e("BeaconTransmitter", "Failed to get BluetoothManager", new Object[0]);
    }
    
    public static int checkTransmissionSupported(final Context context) {
        int n = 0;
        if (Build$VERSION.SDK_INT < 21) {
            n = 1;
        }
        else {
            if (!context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return 2;
            }
            try {
                if (((BluetoothManager)context.getSystemService("bluetooth")).getAdapter().getBluetoothLeAdvertiser() == null) {
                    if (!((BluetoothManager)context.getSystemService("bluetooth")).getAdapter().isMultipleAdvertisementSupported()) {
                        return 5;
                    }
                    return 4;
                }
            }
            catch (Exception ex) {
                return 4;
            }
        }
        return n;
    }
    
    private AdvertiseCallback getAdvertiseCallback() {
        if (this.mAdvertiseCallback == null) {
            this.mAdvertiseCallback = (AdvertiseCallback)new BeaconTransmitter$1(this);
        }
        return this.mAdvertiseCallback;
    }
    
    private static ParcelUuid parseUuidFrom(final byte[] array) {
        final ParcelUuid fromString = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        if (array == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        final int length = array.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            final ByteBuffer order = ByteBuffer.wrap(array).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        }
        long n;
        if (length == 2) {
            n = (array[0] & 0xFF) + (long)((array[1] & 0xFF) << 8);
        }
        else {
            n = (array[0] & 0xFF) + (long)((array[1] & 0xFF) << 8) + ((array[2] & 0xFF) << 16) + ((array[3] & 0xFF) << 24);
        }
        return new ParcelUuid(new UUID(fromString.getUuid().getMostSignificantBits() + (n << 32), fromString.getUuid().getLeastSignificantBits()));
    }
    
    public int getAdvertiseMode() {
        return this.mAdvertiseMode;
    }
    
    public int getAdvertiseTxPowerLevel() {
        return this.mAdvertiseTxPowerLevel;
    }
    
    public boolean isConnectable() {
        return this.mConnectable;
    }
    
    public boolean isStarted() {
        return this.mStarted;
    }
    
    public void setAdvertiseMode(final int mAdvertiseMode) {
        this.mAdvertiseMode = mAdvertiseMode;
    }
    
    public void setAdvertiseTxPowerLevel(final int mAdvertiseTxPowerLevel) {
        this.mAdvertiseTxPowerLevel = mAdvertiseTxPowerLevel;
    }
    
    public void setBeacon(final Beacon mBeacon) {
        this.mBeacon = mBeacon;
    }
    
    public void setBeaconParser(final BeaconParser mBeaconParser) {
        this.mBeaconParser = mBeaconParser;
    }
    
    public void setConnectable(final boolean mConnectable) {
        this.mConnectable = mConnectable;
    }
    
    public void startAdvertising() {
        if (this.mBeacon == null) {
            throw new NullPointerException("Beacon cannot be null.  Set beacon before starting advertising");
        }
        final int manufacturer = this.mBeacon.getManufacturer();
        int intValue = -1;
        if (this.mBeaconParser.getServiceUuid() != null) {
            intValue = this.mBeaconParser.getServiceUuid().intValue();
        }
        if (this.mBeaconParser == null) {
            throw new NullPointerException("You must supply a BeaconParser instance to BeaconTransmitter.");
        }
        final byte[] beaconAdvertisementData = this.mBeaconParser.getBeaconAdvertisementData(this.mBeacon);
        String string = "";
        for (int i = 0; i < beaconAdvertisementData.length; ++i) {
            string = string + String.format("%02X", beaconAdvertisementData[i]) + " ";
        }
        final Identifier id1 = this.mBeacon.getId1();
        while (true) {
            while (true) {
                Label_0196: {
                    if (this.mBeacon.getIdentifiers().size() > 1) {
                        final Serializable id2 = this.mBeacon.getId2();
                        break Label_0196;
                    }
                    Label_0416: {
                        break Label_0416;
                        while (true) {
                            Serializable id2 = null;
                            Serializable id3 = null;
                            LogManager.d("BeaconTransmitter", "Starting advertising with ID1: %s ID2: %s ID3: %s and data: %s of size %s", new Object[] { id1, id2, id3, string, beaconAdvertisementData.length });
                            try {
                                final AdvertiseData$Builder advertiseData$Builder = new AdvertiseData$Builder();
                                if (intValue > 0) {
                                    final ParcelUuid uuid = parseUuidFrom(new byte[] { (byte)(intValue & 0xFF), (byte)(intValue >> 8 & 0xFF) });
                                    advertiseData$Builder.addServiceData(uuid, beaconAdvertisementData);
                                    advertiseData$Builder.addServiceUuid(uuid);
                                    advertiseData$Builder.setIncludeTxPowerLevel(false);
                                    advertiseData$Builder.setIncludeDeviceName(false);
                                }
                                else {
                                    advertiseData$Builder.addManufacturerData(manufacturer, beaconAdvertisementData);
                                }
                                final AdvertiseSettings$Builder advertiseSettings$Builder = new AdvertiseSettings$Builder();
                                advertiseSettings$Builder.setAdvertiseMode(this.mAdvertiseMode);
                                advertiseSettings$Builder.setTxPowerLevel(this.mAdvertiseTxPowerLevel);
                                advertiseSettings$Builder.setConnectable(this.mConnectable);
                                this.mBluetoothLeAdvertiser.startAdvertising(advertiseSettings$Builder.build(), advertiseData$Builder.build(), this.getAdvertiseCallback());
                                LogManager.d("BeaconTransmitter", "Started advertisement with callback: %s", new Object[] { this.getAdvertiseCallback() });
                                return;
                                id3 = "";
                                continue;
                                id2 = "";
                                break;
                            }
                            catch (Exception ex) {
                                LogManager.e((Throwable)ex, "BeaconTransmitter", "Cannot start advertising due to exception", new Object[0]);
                                return;
                            }
                        }
                    }
                }
                if (this.mBeacon.getIdentifiers().size() > 2) {
                    final Serializable id3 = this.mBeacon.getId3();
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    public void startAdvertising(final Beacon beacon) {
        this.startAdvertising(beacon, null);
    }
    
    public void startAdvertising(final Beacon mBeacon, final AdvertiseCallback mAdvertisingClientCallback) {
        this.mBeacon = mBeacon;
        this.mAdvertisingClientCallback = mAdvertisingClientCallback;
        this.startAdvertising();
    }
    
    public void stopAdvertising() {
        if (!this.mStarted) {
            LogManager.d("BeaconTransmitter", "Skipping stop advertising -- not started", new Object[0]);
            return;
        }
        LogManager.d("BeaconTransmitter", "Stopping advertising with object %s", new Object[] { this.mBluetoothLeAdvertiser });
        this.mAdvertisingClientCallback = null;
        while (true) {
            try {
                this.mBluetoothLeAdvertiser.stopAdvertising(this.getAdvertiseCallback());
                this.mStarted = false;
            }
            catch (IllegalStateException ex) {
                LogManager.w("BeaconTransmitter", "Bluetooth is turned off. Transmitter stop call failed.", new Object[0]);
                continue;
            }
            break;
        }
    }
}
