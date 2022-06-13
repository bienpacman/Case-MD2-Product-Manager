package config;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFIle<T> {
    public static String Path = "C:\\Github\\Case_Md2_Product_Management\\src\\data";

    public List<T> readFile(String path) {
        List<T> tList = new ArrayList<T>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tList;
    }

    public void writeFile(String path, List<T> tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
