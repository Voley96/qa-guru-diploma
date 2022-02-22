package io.realworld.config.project;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/local.properties",
        "classpath:config/remote.properties",
})
public interface ProjectConfig extends Config {

    @Key("browser.name")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.size")
    String browserSize();

    @Key("remote.driver.url")
    String remoteDriverUrl();

    @Key("remote.video.storage")
    String videoStorage();

    @Key("auth.login")
    String login();

    @Key("auth.password")
    String password();

    @Key("run")
    @DefaultValue("remote")
    String run();
}
