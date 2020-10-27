package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.NativeSessionReport;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public class ReportManager {
    private final ReportUploader.ReportFilesProvider reportFilesProvider;

    public ReportManager(ReportUploader.ReportFilesProvider reportFilesProvider2) {
        this.reportFilesProvider = reportFilesProvider2;
    }

    public boolean areReportsAvailable() {
        File[] completeSessionFiles = this.reportFilesProvider.getCompleteSessionFiles();
        File[] nativeReportFiles = this.reportFilesProvider.getNativeReportFiles();
        if (completeSessionFiles == null || completeSessionFiles.length <= 0) {
            return nativeReportFiles != null && nativeReportFiles.length > 0;
        }
        return true;
    }

    public void deleteReport(Report report) {
        report.remove();
    }

    public void deleteReports(List<Report> list) {
        for (Report deleteReport : list) {
            deleteReport(deleteReport);
        }
    }

    public List<Report> findReports() {
        Logger.getLogger().mo25712d("Checking for crash reports...");
        File[] completeSessionFiles = this.reportFilesProvider.getCompleteSessionFiles();
        File[] nativeReportFiles = this.reportFilesProvider.getNativeReportFiles();
        LinkedList linkedList = new LinkedList();
        if (completeSessionFiles != null) {
            for (File file : completeSessionFiles) {
                Logger logger = Logger.getLogger();
                StringBuilder a = C0681a.m330a("Found crash report ");
                a.append(file.getPath());
                logger.mo25712d(a.toString());
                linkedList.add(new SessionReport(file));
            }
        }
        if (nativeReportFiles != null) {
            for (File nativeSessionReport : nativeReportFiles) {
                linkedList.add(new NativeSessionReport(nativeSessionReport));
            }
        }
        if (linkedList.isEmpty()) {
            Logger.getLogger().mo25712d("No reports found.");
        }
        return linkedList;
    }
}
