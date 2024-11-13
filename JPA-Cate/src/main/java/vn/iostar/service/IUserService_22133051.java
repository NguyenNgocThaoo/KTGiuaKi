package  vn.iostar.service;

import java.util.List;

import  vn.iostar.entity.User_22133051;

public interface IUserService_22133051 {
    List<User_22133051> getAllUsers(int page, int pagesize);
    void addUser(User_22133051 user);
    void updateUser(User_22133051 user);
    void deleteUser(Long userId) throws Exception;
    User_22133051 getUserById(Long userId);
    User_22133051 findUserByEmail(String email);
    User_22133051 login(String email, String password);
    Long count();
    Long countUsers(String searchValue);
    List<User_22133051> searchUsers(String searchValue, int start, int length);
    User_22133051 findUserByUsername(String username);
}
