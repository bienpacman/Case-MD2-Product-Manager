package service.manager;

import config.ConfigReadAndWriteFIle;
import model.Category;
import model.Manager;
import model.Product;

import java.util.List;

public class ManagerService implements IManagerService {
    public static String PathManager = ConfigReadAndWriteFIle.Path + "manager.txt";
    public static List<Manager> managerList = new ConfigReadAndWriteFIle<Manager>().readFile(PathManager);

    @Override
    public List<Manager> findAll() {
        new ConfigReadAndWriteFIle<Manager>().writeFile(PathManager, managerList);
        return managerList;
    }

    @Override
    public void save(Manager manager) {
        managerList.clear();
        managerList.add(manager);
    }

    @Override
    public Manager findById(int id) {
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
    public Manager findProductByName(String name) {
        return null;
    }
}
