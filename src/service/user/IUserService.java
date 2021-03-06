package service.user;

import model.User;
import service.IServiceGeneric;

public interface IUserService extends IServiceGeneric<User> {
    boolean existedUsername(String username);
    boolean  checkLogin(String username, String password);
    User findByUsername(String username);
}
