package use_case.signup;

// two more usages of this class in LoginController and signupcontroller
public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;

    // one usage of below method in signupcontroller
    public SignupInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
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
}