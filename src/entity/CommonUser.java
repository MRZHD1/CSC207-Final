package entity;

import java.time.LocalDateTime;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final CommonPlace defaultAddress;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, CommonPlace defaultAddress) {
        this.name = name;
        this.password = password;
        this.defaultAddress = defaultAddress;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public CommonPlace getUserPlace() {return defaultAddress; }
}
