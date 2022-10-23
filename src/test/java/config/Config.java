package config;

@org.aeonbits.owner.Config.Sources({
        "classpath:${environment}.properties"
})
public interface Config extends org.aeonbits.owner.Config {

    @Key("browserName")
    @DefaultValue("CHROME")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1500x1200")
    String getBrowserSize();

    @Key("browserPosition")
    @DefaultValue("0x0")
    String getBrowserPosition();

    @Key("baseUrl")
    @DefaultValue("https://demowebshop.tricentis.com")
    String getBaseUrl();

    @Key("baseURI")
    @DefaultValue("https://demowebshop.tricentis.com")
    String getBaseURI();

    @Key("remoteUrl")
    String getRemoteUrl();
}
