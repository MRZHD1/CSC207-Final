package src.entity;

import java.time.LocalDateTime;

public interface UserFactory {

    entity.User create(String userName, String password);

}
