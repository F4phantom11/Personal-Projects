import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tracker {
   // private String name= "League";
//private double price =20.00;
    private HashMap<String, String> expenseName =  new HashMap<String, String>();
    private HashMap<String, String> expensePrice =  new HashMap<String, String>();
    private ArrayList<java.io.Serializable> showExpense = new ArrayList<java.io.Serializable>();

    private void add(String name,String price){
        showExpense.add(name);
        showExpense.add(price);
        expenseName.put(name,price);
        expensePrice.put(price,name);

    }
    private void displayName(String prices){

        System.out.println(expensePrice.get(prices));
    }
    private void displayPrice(String names){
        System.out.println(expenseName.get(names));
    }
    private void displayAll(){
        for(int i =0;i<showExpense.size();i++) {
            if(i%2==0&&i!=0){
                System.out.println();
            }
            System.out.print(showExpense.get(i)+"\t");

        }

    }

    public static void main(String[] args) throws IOException {
        Tracker t = new Tracker();
        Scanner scan = new Scanner(System.in);



      /*  wr.write("HELOO1");
        wr.newLine();
        wr.write("HELOO22");
        wr.newLine();
        wr.write("HELOO3");
        wr.newLine();
        wr.write("HELOO4");
        wr.newLine();
        wr.close();
       while(re.ready()) {
           System.out.println(re.readLine());
       }

        re.close();
*/BufferedReader re = new BufferedReader(new FileReader("C:\\Users\\Owner\\Desktop\\Exp.txt"));
        while(re.ready()) {
String it= re.readLine();
String pre = re.readLine();
            t.expenseName.put(it,pre);
            t.expensePrice.put(pre,it);
        }
        re.close();


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
                    BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Owner\\Desktop\\Exp.txt",true));

                    System.out.println("Type in the name of product then price. Press enter after each input.");

                    String item = scan.next();
                    wr.append(item);
                    Double pr = scan.nextDouble();
                    wr.newLine();
                    wr.append(String.valueOf(pr));
                    wr.newLine();
                    t.expenseName.put(item,String.valueOf(pr));
                    t.expensePrice.put(String.valueOf(pr),item);
                    wr.close();
                   // t.add(item,pr);
                    break;
                case "DNAME":
                    System.out.println("Type in price to display name.");
                     pr = scan.nextDouble();
                    t.displayName(String.valueOf(pr));

                    break;
                case "DPRICE":
                    System.out.println("Type in price to display name.");
                    item = scan.next();
                    t.displayPrice(item);
                    break;
                case "DALL":
                    BufferedReader red = new BufferedReader(new FileReader("C:\\Users\\Owner\\Desktop\\Exp.txt"));
                    while(red.ready()) {

                        System.out.print(red.readLine()+"\t");
                        System.out.println(red.readLine());
                    }
                    red.close();
                    //t.displayAll();
                    break;
                case "QUIT":

                    break;
                case"DELETE":
                    BufferedWriter wrw = new BufferedWriter(new FileWriter("C:\\Users\\Owner\\Desktop\\Exp.txt"));
                    wrw.close();
                    break;
                case "TOTAL":
                    BufferedReader tot = new BufferedReader(new FileReader("C:\\Users\\Owner\\Desktop\\Exp.txt"));
                    Double total = 0.0;
                    while(tot.ready()) {

                       tot.readLine();

                               total+=  Double.valueOf(tot.readLine());
                    }
                    System.out.println(total);
                    tot.close();

                    break;
             //   default:
               //     System.out.println("Incorrect Command Try Again.");
                 //   break;
            }
        }while(!(command.equals("QUIT")));


    }
}
