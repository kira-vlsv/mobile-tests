package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:common.properties"
})

public interface ProjectConfig extends Config {
    @DefaultValue("Pixel 7 API 30")
    @Key("device")
    String device();

    @DefaultValue("11.0")
    @Key("osVersion")
    String osVersion();

    @DefaultValue("local")
    @Key("driver")
    String driver();

    @Key("bsusername")
    String bsusername();

    @Key("bspassword")
    String bspassword();
}