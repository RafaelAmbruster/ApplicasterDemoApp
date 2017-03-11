# Applicaster Demo App
This is a small assignment that consist in develop an android app for consume Twitter API.

# What the app do
Basic app that connect with Twitter API and obtain 10 Tweet of the most influential people (more followers) based on a hashtag or a text,
every 20 seconds the screen is refreshed based on the last used hashtag/text.
Every searched text and its results is stored onto SQLite database for posterior analysis.
All POJOs based on Twitter API response were generated with http://www.jsonschema2pojo.org

# Prerequisites
Java 8
Android SDK v25
Android Build Tools v25
Min SDK v17

# Getting Started
Download or Clone the project, then import with Android Studio, then run into emulator or device.
All keys of configuration are in the build.gradle file, eg, Secret  and consumer key to communicate with twitter API

# Principal Libraries
ORMLite, for handle storage into SQLite Database.
Retrofit, for handle network calls.
Picasso, for handle image download.

# APK
You can copy the demo apk provided to your device directly to see how it work!.
https://github.com/RafaelAmbruster/ApplicasterDemoApp/blob/master/app-demo.apk