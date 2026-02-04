package org.practice.umair;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.practice.entities.Supplier;

public class SupplierOperations {

    public static Session session = DbConnection.getSession();

    public static void createSupplier(String name, String phone){

        try {

            Transaction transaction = session.beginTransaction();
            session.persist(new Supplier(name , phone));
            transaction.commit();
            System.out.println("SUPPLIER CREATED SUCCESSFULLY");

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN CREATING SUPPLIER : " + e);
        } finally {
            session.close();
        }

    }

    public static void getSupplier(int id){

        try {
            Transaction transaction = session.beginTransaction();
            Supplier supplier = session.find(Supplier.class , id);
            System.out.println(supplier);
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN THE SUPPLIER GETTING : " + e);
        } finally {
            session.close();
        }

    }

}
