package io.realworld.config.project;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return config.run().equals("remote");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
