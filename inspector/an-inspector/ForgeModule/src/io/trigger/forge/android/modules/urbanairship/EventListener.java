package io.trigger.forge.android.modules.urbanairship;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeEventListener;
import android.os.Bundle;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.LocationOptions;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;

public class EventListener extends ForgeEventListener {
	@Override
	public void onCreate(Bundle bundle) {		
		LocationOptions lOptions 		= new LocationOptions();
		lOptions.locationServiceEnabled = ForgeApp.configForPlugin("urbanairship").get("locationEnabled").getAsBoolean();
		
		 AirshipConfigOptions options 	= new AirshipConfigOptions();
		 options.developmentAppKey		= ForgeApp.configForPlugin("urbanairship").get("developmentAppKey").getAsString();
		 options.developmentAppSecret	= ForgeApp.configForPlugin("urbanairship").get("developmentAppSecret").getAsString();
		 options.transport				= "gcm";
		 options.gcmSender				= ForgeApp.configForPlugin("urbanairship").get("gcmSender").getAsString();
		 options.inProduction			= ForgeApp.configForPlugin("urbanairship").get("inProduction").getAsBoolean();
		 options.developmentLogLevel	= ForgeApp.configForPlugin("urbanairship").get("developmentLogLevel").getAsInt();
		 options.pushServiceEnabled		= true;
		 options.locationOptions        = lOptions;

		UAirship.takeOff(ForgeApp.getApp(), options);
	    PushManager.enablePush();
		PushManager.shared().setIntentReceiver(IntentReceiver.class);
	}
	
	@Override
    public void onStop() {
        UAirship.land();
    }
}
