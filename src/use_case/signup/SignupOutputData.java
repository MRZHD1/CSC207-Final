package use_case.signup;

import entity.CommonPlace;

public class SignupOutputData {

    private final String username;
    private CommonPlace defaultAddress;
    private String creationTime;

    private boolean useCaseFailed;

    public SignupOutputData(String username, CommonPlace defaultAddress , boolean useCaseFailed) {
        this.username = username;
        this.defaultAddress = defaultAddress;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public CommonPlace getDefaultAddress() {return defaultAddress;}
}
