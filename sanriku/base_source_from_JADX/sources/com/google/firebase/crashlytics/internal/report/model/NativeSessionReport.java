package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public class NativeSessionReport implements Report {
    private final File reportDirectory;

    public NativeSessionReport(File file) {
        this.reportDirectory = file;
    }

    public Map<String, String> getCustomHeaders() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public File[] getFiles() {
        return this.reportDirectory.listFiles();
    }

    public String getIdentifier() {
        return this.reportDirectory.getName();
    }

    public Report.Type getType() {
        return Report.Type.NATIVE;
    }

    public void remove() {
        for (File file : getFiles()) {
            Logger logger = Logger.getLogger();
            StringBuilder a = C0681a.m330a("Removing native report file at ");
            a.append(file.getPath());
            logger.mo25712d(a.toString());
            file.delete();
        }
        Logger logger2 = Logger.getLogger();
        StringBuilder a2 = C0681a.m330a("Removing native report directory at ");
        a2.append(this.reportDirectory);
        logger2.mo25712d(a2.toString());
        this.reportDirectory.delete();
    }
}
