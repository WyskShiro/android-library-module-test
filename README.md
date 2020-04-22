# App Template Android

An Android app template including:

 - A splash screen [V]
 - A login screen (including facebook login) [V]
 - A register screen [V]
 - A password recovery screen [ ]
 - Material design [V]
 - A Retrofit API client [V]
 - A dependency graph using dagger 2 [V]
 - Clean Architecture [V]
 - Unit tests [ ]


### Before you begin

 - Fork the project
 - Update gradle, kotlin and support versions in build.gradle
 - In app/build.gradle
   - Update the version of the Android SDK, build tools, and dependencies
 - Create a merge request
 - TODO more things to come!

### Configuring your App

 - Change the package name (don't forget to update it in the app's manifest)
 - In app/build.gradle
   - Change the applicationId
   - Change the app name for all build variants
   - Change API url for all build variants
 - Check if the date format in the API module matches the one used by your API
 - Update the ApiService to match your API routes
 - Change the facebook_app_id in res/values/keys
 - Add or remove facebook permissions in LoginActivity
 - Change the AndroidLogger tag
 - TODO more things to come!

### Customizing the UI

 - Replace the launcher icons
 - Replace or remove the logo drawable and vector
 - Change the app colors in res/values/colors
 - Change the splash by editing res/drawable/splash
 - Change colors in res/values/colors and attributes in res/values/styles
 - TODO more things to come!