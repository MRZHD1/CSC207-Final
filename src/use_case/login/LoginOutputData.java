package use_case.login;

public class LoginOutputData {

    private final String defaultAddress;
    private boolean useCaseFailed;

    public LoginOutputData(String defaultAddress, boolean useCaseFailed) {
        this.defaultAddress = defaultAddress;
        this.useCaseFailed = useCaseFailed;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

}
