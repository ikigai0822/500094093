import java.sql.*;
import java.util.Scanner;
public class App
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/Films";
    static final String USER = "root";
    static final String PASS = "1223334444";
    public static void main(String[] Args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1: show rows \n 2: insert row : \n 3 Delete row ");
        System.out.println("Enter Choice :");
        int choice = sc.nextInt();
        
        if(choice == 1)
        {

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from Films");
                
                while(rs.next())
                {
                    
                    System.out.print(rs.getString(1)+"\t");
                    System.out.print(rs.getString(2)+"\t");
                    System.out.print(rs.getString(3)+"\t\t");
                    System.out.print(rs.getString(4)+"\n");
                    
                }
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(choice ==2)
        {
            try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO Films (Year) VALUES (1001)";
         stmt.executeUpdate(sql);
         
         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
        }
        else//Deletion not working 
        {
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "DELETE FROM Films WHERE Year = 1001";
         stmt.executeUpdate(sql);
         ResultSet rs = stmt.executeQuery(sql);
         //ResultSet r = stmt.executeQuery("select * from films");
         while(rs.next()){
            //Display values
           /*  System.out.print(r.getString(1)+"\t");
            System.out.print(r.getString(3)+"\t\t");
            System.out.print(r.getString(4)+"\n");*/
         }
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
        }
        }
}