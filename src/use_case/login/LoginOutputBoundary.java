package use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(use_case.login.LoginOutputData user);

    void prepareFailView(String error);
}
