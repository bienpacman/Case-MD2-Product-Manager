package service.role;

import config.ConfigReadAndWriteFIle;
import model.Category;
import model.Product;
import model.Role;
import model.RoleName;

import java.util.List;

public class RoleService implements IRoleService {
    public static String PathRole = ConfigReadAndWriteFIle.Path + "role.txt";
    public static List<Role> roleList = new ConfigReadAndWriteFIle<Role>().readFile(PathRole);

    @Override
    public List<Role> findAll() {
        if (roleList.size() > 2) {
            System.out.println(roleList);
            return roleList;

        } else {
            roleList.add(new Role(1, RoleName.USER));
            roleList.add(new Role(2, RoleName.MANAGER));
        }
        new ConfigReadAndWriteFIle<Role>().writeFile(PathRole, roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleList.add(role);
    }

    @Override
    public Role findById(int id) {
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
    public Role findProductByName(String name) {
        return null;
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i < roleList.size(); i++) {
            if (name == roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
