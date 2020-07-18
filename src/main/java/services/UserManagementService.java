package services;

import model.AppUser;

import java.util.Set;

public interface UserManagementService {
    void saveUser (AppUser appUser);

    void deleteUser (AppUser appUser);

    void follow(String currentUserLogin, String userLoginToFollow);

    void stopFollowing(String currentUserLogin, String UserLoginToUnFollow);

    Set<AppUser> getFollowedUsers(String currentUserLogin);

    Set<AppUser> getNotFollowedUsers(String currentUserLogin);

    boolean isUserValid(String login, String passwrd);

    boolean isUserLoginAvailable(String login);

    boolean isUserEmailAvailable(String email);
}
