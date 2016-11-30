package domain.builder.account;

import domain.detail.account.LoginDetails;

public class LoginDetailBuilder {

    private String username;
    private String password;

   
    public LoginDetailBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginDetailBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginDetails build() {
        return new LoginDetails(username, password);
    }
}