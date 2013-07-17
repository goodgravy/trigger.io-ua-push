Push via Urban Airship
==================================

This module allows you to send push notifications via [Urban Airship](http://urbanairship.com/) on iOS and Android.

The full Urban Airship API is not yet supported: you can find out the current device's push ID and receive push notifications.

## Config options

airshipProperties
: Location of your `airshipconfig.properties` file: you should create that file in your `src` folder and use this file picker to specify its name. For information about what should go into this file, and how it's formatted, see [this documentation](http://docs.urbanairship.com/build/android.html#setting-up-gcm-support-for-your-app).

locationProperties
: Location of your `location.properties` file: you should create that file in your `src` folder and use this file picker to specify its name. For information about what should go into this file, and how it's formatted, see [this documentation](http://docs.urbanairship.com/build/android_location.html#location-properties).

airshipConfigPlist
: Location of your `AirshipConfig.plist` file: you should create that file in your `src` folder and use this file picker to specify its name. For information about what should go into this file, and how it's formatted, see [this documentation](http://docs.urbanairship.com/build/ios.html#create-airshipconfig-plist).

## API

> ::Note:: You must ensure that push notifications have been activated and allowed on the device before receiving them: call `getPushID` first, because the user may need to allow remote notifications first.

!method: forge.urbanairship.getPushID(success, error)
!param: success `function(pushID)` invoked with the device's unique push ID
!param: error `function(content)` called with details of the error if something goes wrong
!description: Find out the current device's push ID. You can use this to target push notifications to a particular device from the Urban Airship dashboard.
!platforms: iOS, Android

!method: forge.urbanairship.pushReceived.addListener(success, error)
!param: success `function(message)` invoked whenever the device receives a push notification: `message` is a JSON object consisting of the notification's body
!param: error `function(content)` called with details of the error if something goes wrong
!description: Receive push notifications. Before using this API, you should ensure that push notifications are activated on the device by invoking `forge.urbanairship.getPushID` to prompt the user for permissions if necessary.
!platforms: iOS, Android