package org.practice.umair;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.practice.entities.Category;
import org.practice.entities.Product;
import org.practice.entities.Supplier;

import java.util.List;

public class ProductsOperations {

    public static Session session = DbConnection.getSession();

    public static void creatingProduct(String name, int stock, Supplier supplier, Category category){

        try {

            Transaction transaction = session.beginTransaction();
            Product product = new Product(name,category,supplier,stock);
            session.persist(product);
            transaction.commit();
            System.out.println("PRODUCT CREATED SUCCESSFULLY.");

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN CREATING PRODUCT : " + e);
        } finally {
            session.close();
        }

    }

    public static void gettingProduct(int id){

        try {
            Transaction transaction = session.beginTransaction();
            Product product = session.find(Product.class, id);
            System.out.println(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE GETTING PRODUCT : " + e);
        } finally {
            session.close();
        }

    }

    public static void deletingProduct(int id){

        try {
            Transaction transaction = session.beginTransaction();
            Product product = session.find(Product.class, id);
            if (product != null){
                session.remove(product);
                System.out.println("supplier removed.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE REMOVING/DELETING PRODUCT : " + e);
        } finally {
            session.close();
        }

    }

    public static void gettingAllProducts(){

        try {

            Transaction transaction = session.beginTransaction();
            String hql = "FROM Product";
            Query query = session.createQuery(hql);
            List<Product> products = query.list();
            for (Product product : products){
                System.out.println(product);
            }

        } catch (Exception e) {
            System.out.println("ERROR WHILE GETTING ALL PRODUCTS : " + e);
        } finally {
            session.close();
        }

    }

}
