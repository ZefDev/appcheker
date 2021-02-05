package com.example.myappchecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;

import java.util.Formatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mInfoTextView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);

        CatTask catTask = new CatTask();
        catTask.execute();
    }
    class CatTask extends AsyncTask<Void, Void, List<AppInfo>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<AppInfo> doInBackground(Void... voids) {
            Context context = getApplicationContext();
            final PackageManager pm = context.getPackageManager();
            List<AppInfo> apps = new ArrayList<>();
            List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
            for (ApplicationInfo appInfo : packages) {
                PackageInfo packageInfo;
                try {
                    packageInfo = pm.getPackageInfo(appInfo.packageName, 0);
                    File file = new File(appInfo.publicSourceDir);
                    String hash_file = getSHA(appInfo);
                    String size = null;

                    AppInfo newApp =
                            new AppInfo(applicationLabel(context, appInfo), appInfo.packageName, appInfo.sourceDir,
                                    appInfo.publicSourceDir, packageInfo.versionName, packageInfo.versionCode,
                                    isSystemPackage(packageInfo), size, file.length(), appInfo.dataDir,
                                    appInfo.nativeLibraryDir, file.lastModified(), packageInfo.firstInstallTime,
                                    packageInfo.lastUpdateTime, appInfo.enabled, hash_file);
                    apps.add(newApp);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return apps;
        }
        private String applicationLabel(Context con, ApplicationInfo packageInfo) {
            PackageManager p = con.getPackageManager();
            return p.getApplicationLabel(packageInfo).toString();
        }
        private boolean isSystemPackage(PackageInfo pkgInfo) {
            return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
        }

        private String getSHA(ApplicationInfo appInfo){
            try {
                byte[] buffer= new byte[8192];
                int count;
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(appInfo.publicSourceDir));
                while ((count = bis.read(buffer)) > 0) {
                    digest.update(buffer, 0, count);
                }
                bis.close();

                byte[] hash = digest.digest();
                return bin2hex(hash);// android.util.Base64.encodeToString(hash, android.util.Base64.DEFAULT);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        private String bin2hex(byte[] data) {
            StringBuilder hex = new StringBuilder(data.length * 2);
            for (byte b : data)
                hex.append(String.format("%02x", b & 0xFF));
            return hex.toString();
        }

        @Override
        protected void onPostExecute(List<AppInfo> list) {
            super.onPostExecute(list);
            AppInfoAdapter adapter = new AppInfoAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }
    }
}