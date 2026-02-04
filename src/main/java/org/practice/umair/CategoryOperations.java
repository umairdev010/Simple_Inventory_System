package org.practice.umair;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.entities.Category;

public class CategoryOperations {

    public static Session session = DbConnection.getSession();

    public static void creatingCategory(String name, String description) {

        try {

            Transaction transaction = session.beginTransaction();
            session.persist(new Category(name, description));
            transaction.commit();
            System.out.println("CATEGORY CREATED SUCCESSFULLY");

        } catch (Exception e) {
            System.out.println("Error occurred in creating category : " + e);
        } finally {
            session.close();
        }

    }

    public static void getCategory(int id) {

        try {

            Transaction transaction = session.beginTransaction();
            Category category = session.find(Category.class, id);
            transaction.commit();
            System.out.println(category);

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN GETTING CATEGORY : " + e);
        } finally {
            session.close();
        }

    }

    public static void deleteCategory(int id) {

        try {

            Transaction transaction = session.beginTransaction();
            Category category = session.find(Category.class, id);
            if (category != null) {
                session.remove(category);
                transaction.commit();
                System.out.println("CATEGORY IS DELETED.");
            } else {

                System.out.println("There is some problem in deleting try again.");

            }


        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN GETTING CATEGORY : " + e);
        } finally {
            session.close();
        }

    }

}
