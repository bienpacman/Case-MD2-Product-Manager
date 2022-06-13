package service.user;

import config.ConfigReadAndWriteFIle;
import model.Category;
import model.Product;
import model.User;

import java.util.List;

public class UserService implements IUserService{
    public static String PathUser = ConfigReadAndWriteFIle.Path + "user.txt";
    public static List<User> userList = new ConfigReadAndWriteFIle<User>().readFile(PathUser);


    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFIle<User>().writeFile(PathUser,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void editById(Category category) {

    }

    @Override
    public void editById(Product product) {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void sortByPrice() {

    }

    @Override
    public User findProductByName(String name) {
        return null;
    }

    @Override
    public boolean existedUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return  userList.get(i);

            }
        }
        return null;
    }
}
