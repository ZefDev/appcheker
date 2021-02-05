package com.example.myappchecker;

public class AppInfo {
    String applicationLabel;

    public String getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getPublicSourceDir() {
        return publicSourceDir;
    }

    public void setPublicSourceDir(String publicSourceDir) {
        this.publicSourceDir = publicSourceDir;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public boolean isSystemPackage() {
        return systemPackage;
    }

    public void setSystemPackage(boolean systemPackage) {
        this.systemPackage = systemPackage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }

    public String getNativeLibraryDir() {
        return nativeLibraryDir;
    }

    public void setNativeLibraryDir(String nativeLibraryDir) {
        this.nativeLibraryDir = nativeLibraryDir;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public long getFirstInstallTime() {
        return firstInstallTime;
    }

    public void setFirstInstallTime(long firstInstallTime) {
        this.firstInstallTime = firstInstallTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    String packageName;
    String sourceDir;
    String publicSourceDir;
    String versionName;
    int versionCode;
    boolean systemPackage;
    String size;
    long length;
    String dataDir;
    String nativeLibraryDir;
    String hash_file;
    long lastModified;
    long firstInstallTime;
    long lastUpdateTime;
    boolean enabled;
    public AppInfo(String applicationLabel, String packageName, String sourceDir, String publicSourceDir,
                   String versionName, int versionCode, boolean systemPackage, String size, long length,
                   String dataDir, String nativeLibraryDir, long lastModified, long firstInstallTime,
                   long lastUpdateTime, boolean enabled,String hash_file) {
        this.applicationLabel = applicationLabel;
        this.packageName = packageName;
        this.sourceDir = sourceDir;
        this.publicSourceDir = publicSourceDir;
        this.versionCode = versionCode;
        this.systemPackage = systemPackage;
        this.size = size;
        this.length = length;
        this.dataDir = dataDir;
        this.nativeLibraryDir = nativeLibraryDir;
        this.lastModified = lastModified;
        this.firstInstallTime = firstInstallTime;
        this.lastUpdateTime = lastUpdateTime;
        this.enabled = enabled;
        this.hash_file = hash_file;
    }
}
