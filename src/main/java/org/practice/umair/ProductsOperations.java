package org.practice.umair;

import org.hibernate.Session;

public class ProductsOperations {

    public static Session session = DbConnection.getSession();

    public static void creatingProduct(){

        try {

        } catch (Exception e) {
            System.out.println("");
        } finally {
            session.close();
        }

    }

    public static void gettingProduct(){

        try {

        } catch (Exception e) {
            System.out.println("");
        } finally {
            session.close();
        }

    }
    public static void deletingProduct(){

        try {

        } catch (Exception e) {
            System.out.println("");
        } finally {
            session.close();
        }

    }

}
