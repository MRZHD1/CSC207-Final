package use_case.signup;
import use_case.signup.SignupInputData;

// 1 usage in login controller and 3 more usage of the below class in signup controller
public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData);
}
