package use_case.signup;

public interface SignupOutputBoundary {
    void prepareSuccessView(use_case.signup.SignupOutputData user);

    void prepareFailView(String error);
}
