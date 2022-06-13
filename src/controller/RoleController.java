package controller;

import model.Role;
import service.role.RoleService;

import java.util.List;

public class RoleController {
    RoleService roleService = new RoleService();
    public List<Role> showListRole(){
        return roleService.findAll();
    }
}
