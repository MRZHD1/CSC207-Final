package use_case.signup;

import entity.CommonPlace;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private CommonPlace defaultAddress;

    public SignupInputData(String username, String password, String repeatPassword, String defaultAddress) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.defaultAddress = new CommonPlace(defaultAddress);
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public CommonPlace getUserPlace() { return defaultAddress; }
}
