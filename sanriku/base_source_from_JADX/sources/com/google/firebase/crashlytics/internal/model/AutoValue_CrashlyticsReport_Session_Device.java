package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import p009e.p010a.p011a.p012a.C0681a;

final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {
    private final int arch;
    private final int cores;
    private final long diskSpace;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final long ram;
    private final boolean simulator;
    private final int state;

    static final class Builder extends CrashlyticsReport.Session.Device.Builder {
        private Integer arch;
        private Integer cores;
        private Long diskSpace;
        private String manufacturer;
        private String model;
        private String modelClass;
        private Long ram;
        private Boolean simulator;
        private Integer state;

        Builder() {
        }

        public CrashlyticsReport.Session.Device build() {
            String str = this.arch == null ? " arch" : "";
            if (this.model == null) {
                str = C0681a.m320a(str, " model");
            }
            if (this.cores == null) {
                str = C0681a.m320a(str, " cores");
            }
            if (this.ram == null) {
                str = C0681a.m320a(str, " ram");
            }
            if (this.diskSpace == null) {
                str = C0681a.m320a(str, " diskSpace");
            }
            if (this.simulator == null) {
                str = C0681a.m320a(str, " simulator");
            }
            if (this.state == null) {
                str = C0681a.m320a(str, " state");
            }
            if (this.manufacturer == null) {
                str = C0681a.m320a(str, " manufacturer");
            }
            if (this.modelClass == null) {
                str = C0681a.m320a(str, " modelClass");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Session.Device.Builder setArch(int i) {
            this.arch = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setCores(int i) {
            this.cores = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setDiskSpace(long j) {
            this.diskSpace = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            if (str != null) {
                this.manufacturer = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public CrashlyticsReport.Session.Device.Builder setModel(String str) {
            if (str != null) {
                this.model = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            if (str != null) {
                this.modelClass = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public CrashlyticsReport.Session.Device.Builder setRam(long j) {
            this.ram = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setSimulator(boolean z) {
            this.simulator = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setState(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.arch = i;
        this.model = str;
        this.cores = i2;
        this.ram = j;
        this.diskSpace = j2;
        this.simulator = z;
        this.state = i3;
        this.manufacturer = str2;
        this.modelClass = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        return this.arch == device.getArch() && this.model.equals(device.getModel()) && this.cores == device.getCores() && this.ram == device.getRam() && this.diskSpace == device.getDiskSpace() && this.simulator == device.isSimulator() && this.state == device.getState() && this.manufacturer.equals(device.getManufacturer()) && this.modelClass.equals(device.getModelClass());
    }

    @NonNull
    public int getArch() {
        return this.arch;
    }

    public int getCores() {
        return this.cores;
    }

    public long getDiskSpace() {
        return this.diskSpace;
    }

    @NonNull
    public String getManufacturer() {
        return this.manufacturer;
    }

    @NonNull
    public String getModel() {
        return this.model;
    }

    @NonNull
    public String getModelClass() {
        return this.modelClass;
    }

    public long getRam() {
        return this.ram;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        long j = this.ram;
        long j2 = this.diskSpace;
        return ((((((((((((((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cores) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.simulator ? 1231 : 1237)) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    public boolean isSimulator() {
        return this.simulator;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Device{arch=");
        a.append(this.arch);
        a.append(", model=");
        a.append(this.model);
        a.append(", cores=");
        a.append(this.cores);
        a.append(", ram=");
        a.append(this.ram);
        a.append(", diskSpace=");
        a.append(this.diskSpace);
        a.append(", simulator=");
        a.append(this.simulator);
        a.append(", state=");
        a.append(this.state);
        a.append(", manufacturer=");
        a.append(this.manufacturer);
        a.append(", modelClass=");
        return C0681a.m324a(a, this.modelClass, "}");
    }
}
