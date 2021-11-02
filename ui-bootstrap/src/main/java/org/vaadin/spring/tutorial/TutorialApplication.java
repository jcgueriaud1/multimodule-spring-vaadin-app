package org.vaadin.spring.tutorial;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Theme("reusable-theme")
@SpringBootApplication
public class TutorialApplication  implements AppShellConfigurator {

    /**
     * The main method makes it possible to run the application as a plain Java
     * application which starts embedded web server via Spring Boot.
     *
     * @param args
     *            command line parameters
     */
    public static void main(String[] args) {
        SpringApplication.run(TutorialApplication.class, args);
    }
}
