package ExpenseTracker;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExpenseTracker {
    // private String name= "League";
//private double price =20.00;



    private static final String url = "jdbc:mysql://localhost:3306/tracker";
    private static final String user = "root";
    private static final String password = "2Notebook1";


     static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private void add(String name,String price){


    }
    private void displayName(String prices){


    }
    private void displayPrice(String names){

    }
    private void displayAll(){


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        ExpenseTracker t = new ExpenseTracker();
        Scanner scan = new Scanner(System.in);
        //Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement();


       // stmt.executeUpdate(added);



        String total = "SELECT sum(price) from expenses";
        rs = stmt.executeQuery(total);
        rs.next();

        if(rs.getDouble(1)>100){
            System.out.println("STOP SPENDING MONEY!");
        }








        String command = "";

        do {

            System.out.print("To add type ADD.\n" +
                    "To display by name type DNAME.\n" +
                    "To display by price type DPRICE.\n" +
                    "To display all type DALL.\n" +
                    "To quit type QUIT.\n");
            command = scan.next();
            switch (command) {
                case "ADD":


                    System.out.println("Type in the name of product then price. Press enter after each input.");
                    String added =  "INSERT INTO expenses(price,name)"+"VALUES(?,?)";
                    PreparedStatement adds = con.prepareStatement(added);


                    String item = scan.next();

                    Double pr = scan.nextDouble();
                    adds.setString(1,item);
                    adds.setDouble(2,pr);
                    break;
                case "DNAME":
                    System.out.println("Type in name to display price.");
                    String names = scan.next();
                    String select = "SELECT name, price FROM expenses where name = ?";
                    adds = con.prepareStatement(select);
                    adds.setString(1,names);
                    rs = adds.executeQuery();
                    while(rs.next()) {

                        System.out.print(rs.getString("name")+"\t");
                        System.out.println(rs.getString("price"));
                    }

                    break;
                case "DPRICE":
                    System.out.println("Type in price to display name.");
                   Double pricea = scan.nextDouble();
                    String selectN = "SELECT name, price FROM expenses where price = ?";
                    adds = con.prepareStatement(selectN);
                    adds.setDouble(1,pricea);
                    rs = adds.executeQuery();
                    while(rs.next()) {

                        System.out.print(rs.getString("name")+"\t");
                        System.out.println(rs.getString("price"));
                    }
                    break;
                case "DALL":
                    String selectAll = "select * from expenses";
                    rs = stmt.executeQuery(selectAll);
                    while(rs.next()) {

                        System.out.print(rs.getString("name")+"\t");
                        System.out.println(rs.getString("price"));
                    }


                    break;
                case "QUIT":

                    break;
                case"DELETE":
                    System.out.println("Type in a name to delete row");
                    String delete = scan.next();
                    String DeleteR = "Delete from expenses where name = ? Limit 1";
                    adds = con.prepareStatement(DeleteR);
                    adds.setString(1,delete);
                    adds.executeUpdate();
                    break;
                case "TOTAL":

                  rs = stmt.executeQuery(total);
                  rs.next();
                  System.out.println(rs.getString(1));

                    break;
                //   default:
                //     System.out.println("Incorrect Command Try Again.");
                //   break;
            }
        }while(!(command.equals("QUIT")));


        con.close();
        stmt.close();
        rs.close();

    }
}
