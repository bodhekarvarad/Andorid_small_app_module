package com.example.brodcastreciever;// MainActivity.java

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver systemBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and register the BroadcastReceiver
        systemBroadcastReceiver = new SystemBroadcastReceiver();
        registerSystemBroadcastReceiver();
    }

    private void registerSystemBroadcastReceiver() {
        // Create an IntentFilter to specify which system broadcasts to listen for
        IntentFilter intentFilter = new IntentFilter();

        // Add actions for the broadcasts you want to listen to
        intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
      intentFilter.addAction(Intent.ACTION_SCREEN_ON);
      intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        // Add Airplane mode change action
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        // Register the BroadcastReceiver with the specified IntentFilter
        registerReceiver(systemBroadcastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        // Unregister the BroadcastReceiver when the activity is destroyed
        unregisterReceiver(systemBroadcastReceiver);
        super.onDestroy();
    }

    // Define the BroadcastReceiver class
    private class SystemBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Handle the received broadcast
            String action = intent.getAction();

            if (action != null) {
                switch (action) {

                    case Intent.ACTION_POWER_CONNECTED:
                        showToast("Power connected");
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        showToast("Power disconnected");
                        break;
                    case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                        boolean isAirplaneModeOn = Settings.Global.getInt(
                                context.getContentResolver(),
                                Settings.Global.AIRPLANE_MODE_ON,
                                0) != 0;

                        if (isAirplaneModeOn) {
                            showToast("Airplane mode turned on");
                        } else {
                            showToast("Airplane mode turned off");
                        }
                        break;
                    case WifiManager.NETWORK_STATE_CHANGED_ACTION:
                        showToast("WiFi state changed");
                    // Add more cases for other broadcasts as needed
                    case Intent.ACTION_SCREEN_ON:
                        showToast("Screen On");
                    case Intent.ACTION_SCREEN_OFF:
                        showToast("Screen OF");
                    case Intent.ACTION_BATTERY_LOW:
                        showToast("Low Battery Please Charge");

                }
            }
        }

        private void showToast(String message) {
            // Display a Toast message with the received information
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
