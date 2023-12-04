package use_case.login;

import entity.User;
import src.use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;


public class LoginInteractor implements LoginInputBoundary {
    final use_case.login.LoginUserDataAccessInterface userDataAccessObject;
    final use_case.login.LoginOutputBoundary loginPresenter;

    public LoginInteractor(use_case.login.LoginUserDataAccessInterface userDataAccessInterface,
                           use_case.login.LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());


                use_case.login.LoginOutputData loginOutputData = new use_case.login.LoginOutputData(user.getUserName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}