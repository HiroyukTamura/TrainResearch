// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class VINParsedResult extends ParsedResult
{
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;
    
    public VINParsedResult(final String vin, final String worldManufacturerID, final String vehicleDescriptorSection, final String vehicleIdentifierSection, final String countryCode, final String vehicleAttributes, final int modelYear, final char plantCode, final String sequentialNumber) {
        super(ParsedResultType.VIN);
        this.vin = vin;
        this.worldManufacturerID = worldManufacturerID;
        this.vehicleDescriptorSection = vehicleDescriptorSection;
        this.vehicleIdentifierSection = vehicleIdentifierSection;
        this.countryCode = countryCode;
        this.vehicleAttributes = vehicleAttributes;
        this.modelYear = modelYear;
        this.plantCode = plantCode;
        this.sequentialNumber = sequentialNumber;
    }
    
    public String getCountryCode() {
        return this.countryCode;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(50);
        sb.append(this.worldManufacturerID).append(' ');
        sb.append(this.vehicleDescriptorSection).append(' ');
        sb.append(this.vehicleIdentifierSection).append('\n');
        if (this.countryCode != null) {
            sb.append(this.countryCode).append(' ');
        }
        sb.append(this.modelYear).append(' ');
        sb.append(this.plantCode).append(' ');
        sb.append(this.sequentialNumber).append('\n');
        return sb.toString();
    }
    
    public int getModelYear() {
        return this.modelYear;
    }
    
    public char getPlantCode() {
        return this.plantCode;
    }
    
    public String getSequentialNumber() {
        return this.sequentialNumber;
    }
    
    public String getVIN() {
        return this.vin;
    }
    
    public String getVehicleAttributes() {
        return this.vehicleAttributes;
    }
    
    public String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }
    
    public String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }
    
    public String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }
}
