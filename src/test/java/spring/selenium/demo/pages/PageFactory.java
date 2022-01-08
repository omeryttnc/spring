package spring.selenium.demo.pages;


import org.springframework.context.annotation.Configuration;

@Configuration
public class PageFactory {

    public HomePage getHomePage() {
        return new HomePage();
    }
    public LoginPage getLoginPage() {
        return new LoginPage();
    }

}
