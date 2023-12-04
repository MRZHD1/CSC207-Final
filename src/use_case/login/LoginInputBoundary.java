package src.use_case.login;

public interface LoginInputBoundary {
    void execute(use_case.login.LoginInputData loginInputData);
}
// 3 usage of LoginInputBoundary is in login controller - make sure it works

