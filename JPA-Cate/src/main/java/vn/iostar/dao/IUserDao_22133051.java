package  vn.iostar.dao;
import java.util.List;

import  vn.iostar.entity.User_22133051;
public interface IUserDao_22133051 {
    List<User_22133051> getAllUsers(int page, int size);
    void addUser(User_22133051 user);
    void updateUser(User_22133051 user);
    void deleteUser(Long userId) throws Exception;
    User_22133051 getUserById(Long userId);
    User_22133051 findUserByEmail(String email);
    Long count();
    List<User_22133051> searchUser(String bookName, int start, int length);
    Long countUsers(String searchValue);
    User_22133051 findUserByUsername(String username);
}
