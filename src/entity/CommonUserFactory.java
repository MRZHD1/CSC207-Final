package entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements entity.UserFactory {

    @Override
    public entity.User create(String userName, String password, LocalDateTime time) {
        return new entity.CommonUser(userName, password, time);
    }
}

