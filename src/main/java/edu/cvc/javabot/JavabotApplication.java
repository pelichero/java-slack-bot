package edu.cvc.javabot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "edu.cvc.javabot"})
public class JavabotApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(JavabotApplication.class);

    private static final String defaultProfile = "dev";

    public static void main(String[] args) {

	log.info("####################################################################");
	log.info("");
	log.info("Running Spring with args:: {}", args);
	log.info("");
	log.info("####################################################################");

	SpringApplication.run(JavabotApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.profiles(getProfile());
    }

    @PostConstruct
    void configuraTimeZoneDefault() {

	TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	log.info("####################APPLICATION STARTED#############################");
	log.info("");
	log.info("Timezone set to: {}", TimeZone.getDefault());
	log.info("");
	log.info("####################################################################");
    }

    /**
     * Set a default profile if it has not been set.
     * <p/>
     * <p>
     * Please use -Dspring.profiles.active=dev
     * </p>
     */
    private String[] getProfile() {
	String profile = System.getProperty("spring.profiles.active");
	if (!StringUtils.isEmpty(profile)) {
	    log.info("####################################################################");
	    log.info("");
	    log.info("Running with Spring profile(s) : {}", profile);
	    log.info("");
	    log.info("####################################################################");
	    return profile.split(",");
	}

	log.warn("!!! No Spring profile configured, running with default configuration: " + defaultProfile);
	return new String[] {defaultProfile};
    }

}
