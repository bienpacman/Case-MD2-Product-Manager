package controller;

import dto.SignInDTO;
import dto.SignUpDTO;
import model.Manager;
import model.Role;
import model.RoleName;
import model.User;
import service.manager.ManagerService;
import service.role.RoleService;
import service.user.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserController {
    UserService userService = new UserService();
    RoleService roleService = new RoleService();
    ManagerService managerService = new ManagerService();

    public void register(SignUpDTO signUpDTO) {
        int id;
        if (UserService.userList.size() == 0) {
            id = 1;
        } else {
            id = UserService.userList.get(UserService.userList.size() - 1).getId() + 1;

        }
        Set<String> strRole = signUpDTO.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "MANAGER":
                    Role managerRole = roleService.findByName(RoleName.MANAGER);
                    roleSet.add(managerRole);
                    break;
                case "USER":
                    Role userRole = roleService.findByName(RoleName.USER);
                    roleSet.add(userRole);
                    break;
            }
        });
     // User user = new User(id, signUpDTO.getName(), signUpDTO.getPassword(), signUpDTO.getPassword(), roleSet);
        User user = new User(id,signUpDTO.getName(),signUpDTO.getUsername(),signUpDTO.getPassword(),roleSet);
        userService.save(user);
        userService.findAll();
    }
    public boolean login (SignInDTO signInDTO){
        if (userService.checkLogin(signInDTO.getName(),signInDTO.getPassword())){
            User user = userService.findByUsername(signInDTO.getName());
            Manager manager = new Manager(user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getRoleSet());
            managerService.save(manager);
            managerService.findAll();

            return true;
        }
        else
            return false;
    }
}
