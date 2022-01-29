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
`<a href=""> <img src="" width="XX" height="YY"> </a>`

3. Appium
   1. [Appium Desired Capabilities](https://appium.io/docs/en/writing-running-appium/caps/)

## Resources
___



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


2. Appium tutorial: Get appPackage и appActivity

[2 Ways to find appPackage and appActivity name of your App](https://www.automationtestinghub.com/apppackage-and-appactivity-name/)

[Appium tutorial (7) - получить appPackage и appActivity](https://russianblogs.com/article/5702202808/)


