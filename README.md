# http://realworld.io (medium clone) automated tests

## Covered features:

- Auth and registration (API + UI)
- Edit profile (UI)
- Create/Get/Update/Delete articles (API)


### Libraries have been used in this project

<p  align="left">
<code>
<img width="5%" title="IntelliJ IDEA" src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg">
<img width="5%" title="Java" src="https://starchenkov.pro/qa-guru/img/skills/Java.svg">

<img width="5%" title="JUnit5" src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg">
<img width="5%" title="Selenide" src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg">
<img width="5%" title="Gradle" src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg">
<img width="5%" title="Selenoid" src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg">
<img width="5%" title="Github" src="https://starchenkov.pro/qa-guru/img/skills/Github.svg">
<img width="5%" title="Jenkins" src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg">
<img width="5%" title="Allure Report" src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg">
<img width="5%" title="Telegram" src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg">
</code>
</p>

# USAGE examples

### For run tests need to select build params:

* browser
* browserVersion
* browserSize
* remoteDriverUrl (url address from selenoid or grid)
* environment
* comment (for telegram notification)
* threads (number of threads)

Run tests with filled remote.properties:

```bash
gradle clean test
```

Run tests with not filled remote.properties:

```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```
Usually, tests run on the Selenoid.
>Selenoid is one of implementation of original Selenium hub. It is using Docker to launch browsers. 


# Jenkins
>Jenkins – an open source automation server which enables developers around the world to reliably build, test, and deploy their software

## Jenkins job
Example of Jenkins job that executes tests
<a target="_blank" href="https://jenkins.autotests.cloud/job/09-Oleynik_Vladimir/">click here to open jenkins job</a>

## Jenkins parameters
You can change this params to run test on different environments, browsers, etc...

<p  align="left">
<code>
<img width="80%" title="Jenkins-params" src="images/jenkins.png">
</code>
</p>

# Allure
> Allure Framework is a flexible lightweight multi-language test report tool that not only shows a very concise representation of what have been tested in a neat web report form, but allows everyone participating in the development process to extract maximum of useful information from everyday execution of tests.

## Allure TestOps
> Allure TestOps is a refined Test Operations Swiss army knife which allows you to manage all test related stuff in one place.

## Test Cases
> Test case management
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/testcases.png">
</code>
</p>

## Dashboard
> Dashboard with statuses of testcases on Allure TestOps
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/dashboard.png">
</code>
</p>

## Allure overview
> Different charts, metrics and statistic to easily analyze tests result
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/allure.png">
</code>
</p>

## Allure test result
> Here is a result of test executing.  
<p  align="left">
<code>
<img width="80%" title="Allure test result" src="images/result.png">
</code>
</p>

## Allure video result
> You can see a short video how tests executes on Selenoid server
<p  align="left">
<code>
<img width="80%" title="Allure video" src="images/allure-record.gif">
</code>
</p>

## Jira Integration
> All test integrated with jira to check statuses and activity
<p  align="left">
<code>
<img width="80%" title="Allure video" src="images/jira.png">
</code>
</p>

# Telegram notification
> We use telegram bot to send test result to specified telegram channel
<p  align="left">
<code>
<img width="80%" title="Telegram notification" src="images/telegram.png">
</code>
</p>
