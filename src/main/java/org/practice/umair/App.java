package org.practice.umair;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("WELLCOME TO INVENTORY MANAGEMENT SYSTEM.");
            System.out.print("\n PLEASE ENTER A NUMBER WHICH THING YOU HAVE TO MANGE 1. MANGE PRODUCTS  2.  MANGE SUPPLIER  3.  MANGE CATEGORIES : ");
            int choice = input.nextInt();
            if (choice < 1 || choice > 3) return;
            switch (choice){
                case 1:
                    System.out.println("WELLCOME TO PRODUCTS MANAGEMENT SYSTEM");

                    break;
                case 2:
                    System.out.println("WELLCOME TO SUPPLIER MANAGEMENT SYSTEM");
                    System.out.print("ENTER NUMBER WHICH OPERATION YOU WANT TO DO  1. CREATE SUPPLIER  2. GET SUPPLIER  3. DELETE SUPPLIER : ");
                    choice = input.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("YOU ARE GOING TO CREATE A SUPPLIER SO ENTER FOLLOWING INFORMATION.");
                            input.nextLine();
                            System.out.print("ENTER THE NAME OF SUPPLIER : ");
                            String name = input.nextLine();
                            System.out.print("ENTER THE CONTACT NUMBER OF THE SUPPLIER : ");
                            String phone = input.nextLine();
                            SupplierOperations.createSupplier(name,phone);
                            break;
                        case 2:
                            System.out.print("YOU ARE GOING TO GET A SUPPLIER BY ID : ");
                            int id = input.nextInt();
                            SupplierOperations.getSupplier(id);
                            break;
                        case 3:
                            System.out.print("YOU ARE GOING TO DELETE A SUPPLIER BY ID : ");
                            id = input.nextInt();
                            SupplierOperations.deleteSupplier(id);
                            break;
                        default:
                            System.out.println("PLEASE ENTER A VALID NUMBER AND TRY AGAIN");
                    }
                    break;
                case 3:
                    System.out.println("WELLCOME TO CATEGORY MANAGEMENT SYSTEM");
                    System.out.print("ENTER NUMBER WHICH OPERATION YOU WANT TO DO  1. CREATE CATEGORY  2. GET CATEGORY  3. DELETE CATEGORY : ");
                    choice = input.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("YOU ARE GOING TO CREATE A CATEGORY SO ENTER FOLLOWING INFORMATION.");
                            System.out.print("ENTER THE NAME OF CATEGORY : ");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.print("ENTER THE SHORT DESCRIPTION OF CATEGORY : ");
                            String description = input.nextLine();
                            System.out.println(name + " " +description);
                            CategoryOperations.creatingCategory(name,description);
                            break;
                        case 2:
                            System.out.println("YOU ARE GOING TO FIND A CATEGORY SO ENTER ITS ID : ");
                            int id = input.nextInt();
                            CategoryOperations.getCategory(id);
                            break;
                        case 3:
                            System.out.print("YOU ARE GOING TO DELETE A CATEGORY SO ENTER ITS ID : ");
                            id = input.nextInt();
                            CategoryOperations.deleteCategory(id);
                            break;
                        default:
                            System.out.println("PLEASE ENTER AGAIN AND ENTER A VALID NUMBER");
                    }
                    break;
                default:
                    System.out.println("PLEASE TRY WITH CORRECT PARAMETERS");
            }

        } catch (Exception e) {
            System.out.println("SOME PROBLEM OCCURRED IN MAIN JAVA CLASS : " + e);
        }

    }
}
