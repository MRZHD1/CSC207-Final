package src.entity;

import java.time.LocalDateTime;

public class CommonUser implements entity.User {

    private final String userName;
    private final String password;


    /**
     * @param userName
     * @param password
     */
    public CommonUser(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }
    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;


    }


}
