| <a href="https://developer.android.com/studio"> <img src="readme-images/android-studio-logo.png" width="30" height="30"> </a>|<a href="https://appium.io"> <img src="readme-images/appium-logo.png" width="30" height="30"> </a> |<a href="https://www.browserstack.com/"> <img src="readme-images/browserStack-logo.png" width="30" height="30"> </a>|
|---|---|---|

# I'm readme file and will tell about the project
___
The project shows how use an emulator of a mobile device or a real device for the test of a mobile app.

## Acknowledgements
___
[Vasenkov Stanislav](https://github.com/svasenkov)

[Eugen Paraschiv (Baeldung)](https://twitter.com/baeldung)

[Maintenance and technical support website https://browserstack.com](https://browserstack.com)

[Wikipedia Android app contributors](https://github.com/wikimedia/apps-android-wikipedia/graphs/contributors)

## About homework
___
1. Установить android studio https://developer.android.com/studio

2. Прописать path. See here Miscellaneous/1. About paths:

3. Установить appium desktop https://github.com/appium/appium-desktop

4. В android studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)

5. В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)

6. Запустить эмулятор телефона, опробовать кнопки и функционал

7. Открыть Appium Desktop, запустить server, проконектиться к эмулятору

8. Открыть в appium desktop инспектор, изучить его функционал, попробовать найти локатор

9. Разработать автотест на getting started в приложении википедии - пройти по 4м экранам, на каждом сделать проверку

10. Доработать возможность запуска на разных стендах (передать из командной строки `-DdeviceHost=browserstack / selenoid / emulation / real`.
Для каждого сделать драйвер и конфиг с owner

## Using
General properties for a real or emulated device is in the file `resources/config/local/local.properties`.
Example:
```
local.appPackage=org.wikipedia.alpha
local.appActivity=org.wikipedia.main.MainActivity
local.path.app=src/test/resources/apk/app-alpha-universal-release.apk
local.url=http://127.0.0.1:4723/wd/hub

```
The apk file is in `resources/apk/app-alpha-universal-release.apk`.

The paths of local starting tests by command line or IDE:
* start on default `emulate`: 

   `./gradlew test`

How set properties **see** `start on an emulated device`.

* start on a real device:
 
   `./gradlew test -DtypeDevice=real`

**Note**: Set properties in the file `resources/config/local/real/mobiledevice.properties`:
```
  udid=AAAAAAA*
  device=Redmi 7A
  os_version=9.0
  locale=en
  language=en
```
You can find `udid` by starting `adb devices` in a shell: 
```
$ adb devices
List of devices attached
AAAAAAA         device
emulator-5554   device
```

* start on an emulated device:
  `./gradlew test -DtypeDevice=emulate`

**Note**: Set properties in the file `resources/config/local/emulate/mobiledevice.properties`:
```
udid=emulator-5554
device=Pixel 4 API 30
os_version=9.0
locale=en
language=en
```

* start on the site [BrowserStack](https://www.browserstack.com/):
  `./gradlew test -DtypeDevice=browserstack`

**Note**: 
1. Set properties in the file `resources/config/remote/browserstack/mobiledevice.properties`:
```
device=Google Pixel 3
os_version=9.0
locale=en
language=en

```

2. Set properties in the file `resources/config/remote/browserstack/browserstack.properties`:

```
browserstack.user=*****
browserstack.key=*****
browserstack.networkLogs=true
browserstack.app=bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c
browserstack.url=http://hub.browserstack.com/wd/hub
browserstack.url.statSession=https://api-cloud.browserstack.com/app-automate/sessions/

# Set other BrowserStack capabilities
browserstack.project=First Java Project
browserstack.build=browserstack-build-1
browserstack.name=first_test
```

## What's new?
___

1. How creates a table by MD.
```
| A | B | C |
|---|---|---|
|   |   |   |
|   |   |   |
```
2. How creates a link in tag `img`.

```
   <a href=""> 
     <img src="" width="XX" height="YY"> 
   </a>
```

3. Appium
   1. [Appium Desired Capabilities](https://appium.io/docs/en/writing-running-appium/caps/)
   2. [Appium как подключить девайс?](https://software-testing.ru/forum/index.php?/topic/34805-appium-kak-podkliuchit-devajs/)
   3.Appium tutorial: Get appPackage и appActivity

   [2 Ways to find appPackage and appActivity name of your App](https://www.automationtestinghub.com/apppackage-and-appactivity-name/)

   [Appium tutorial (7) - получить appPackage и appActivity](https://russianblogs.com/article/5702202808/)
4. BrowserStack
   1. upload wiki app in site BrowserStack:
```
// Upload an app using the file manager to generate an "app_url" value. It uniquely identifies your uploaded app on BrowserStack.
{"app_url":"bs://0eb35601ca053f77de18448efbad5c204d63c44c"}
// In your test script, use this "app_url" value to specify the application under test using the "app" capability. During test execution, your app will automatically be installed and launched on the device being tested.
{
"app", "bs://0eb35601ca053f77de18448efbad5c204d63c44c"	
}
```

## Resources
___
1. [The latest Alpha version of the app (autogenerated)](https://github.com/wikimedia/apps-android-wikipedia/releases)
2. [The site BrowserStack](https://www.browserstack.com/)

## Miscellaneous
___
1. About paths

Параметры Path:

Windows:

%ANDROID_HOME%\tools

%ANDROID_HOME%\tools\bin

%ANDROID_HOME%\platform-tools

Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

Mac:

$ANDROID_HOME/tools

$ANDROID_HOME/tools/bin

$ANDROID_HOME/platform-tools

Одной строкой, можно скопировать и добавить в .bash_profile:

export PATH=”${PATH}:/$ANDROID_HOME/tools:/$ANDROID_HOME/tools/bin:/$ANDROID_HOME/platform-tools”

