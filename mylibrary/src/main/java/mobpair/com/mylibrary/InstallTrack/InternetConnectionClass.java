package mobpair.com.mylibrary.InstallTrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ${Mobpair} on 3/4/18.
 */
public class InternetConnectionClass {

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static InternetConnectionClass instance = new InternetConnectionClass();
    private ConnectivityManager connectivityManager;
    private boolean connected = false;

    public static InternetConnectionClass getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        Toast.makeText(context, "InternetConnectionClass : isOnline Called", Toast.LENGTH_SHORT).show();
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            assert connectivityManager != null;
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.d("connectivity", e.toString());
        }
        return connected;
    }
}