package com.example.helloapp;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.helloapp.MESSAGE";
	private static final int REQUEST_ENABLE_BT = 1;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, StartRunningActivity.class);
    	startActivity(intent);
    }
    
    public void startLearn(View view) {
    	// Do something in response to button
    	Intent intent = new Intent(this, LearnActivity.class);
    	startActivity(intent);
    }
    
    public void startLog(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, RunningLogActivity.class);
    	startActivity(intent);
    }
    
    public void bluetoothConnect(View view) {
    	BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    	 
    	if(bluetooth != null) {	
    		if (!bluetooth.isEnabled()) {
		        Intent turnOnIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		        startActivityForResult(turnOnIntent, REQUEST_ENABLE_BT);
		 
		        Toast.makeText(getApplicationContext(),"Bluetooth turned on" , Toast.LENGTH_LONG).show();
    			
    			/*bluetooth.startDiscovery();
    			
    			// Create a BroadcastReceiver for ACTION_FOUND
    			final BroadcastReceiver mReceiver = new BroadcastReceiver() {
    			    public void onReceive(Context context, Intent intent) {
    			        String action = intent.getAction();
    			        // When discovery finds a device
    			        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
    			            // Get the BluetoothDevice object from the Intent
    			            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    			            // Add the name and address to an array adapter to show in a ListView
    			            Toast.makeText(getApplicationContext(), device.getName() + "\n" + device.getAddress() , Toast.LENGTH_LONG).show();
    			        }
    			    }
    			};
    			// Register the BroadcastReceiver
    			IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
    			registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy*/
    			
    			
//    			Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
//				discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
//				startActivity(discoverableIntent);
		    }
		    else {
		        Toast.makeText(getApplicationContext(),"Bluetooth is already on", Toast.LENGTH_LONG).show();
		    }

    		
    		TextView text = (TextView) findViewById(R.id.bluetooth_found);
        	text.setText("Connected");
    	}
    }
}
