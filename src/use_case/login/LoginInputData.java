package use_case.login;


// two more usages of LoginInputData class in LoginController
public class LoginInputData {

    final private String username;
    final private String password;

    // one usage of function below in logincontroller
    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    //one usage of getPassword() in LoginInteractor
    public String getPassword() {
        return password;
    }

}
