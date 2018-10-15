import java.sql.*;
import java.util.ArrayList;

public class DBConnect
{
    private static String user = "root";
    private static String password = "";

    public static ArrayList<Contact> getContacts() throws SQLException {
        ArrayList<Contact> Contacts = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts?useSSL=false",
                    user, password);

            //2. create a Statement object
            statement = conn.createStatement();

            //3.  create the sql query
            resultSet = statement.executeQuery("SELECT * FROM contacts");

            //4. loop over the results, create MobilePhone Objects, and add it to the ArrayList
            while (resultSet.next()) {
                Contact newContact = new Contact
                        (
                                resultSet.getInt("Id"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Address"),
                                resultSet.getInt("Phone")
                        );
                Contacts.add(newContact);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }
        return Contacts;
    }
}
