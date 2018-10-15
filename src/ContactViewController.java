import com.mysql.cj.api.x.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContactViewController implements Initializable
{

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Contact, Integer> idColumn;

    @FXML
    private TableColumn<Contact, String> firstColumn;

    @FXML
    private TableColumn<Contact, String> lastColumn;

    @FXML
    private TableColumn<Contact, String> addressColumn;

    @FXML
    private TableColumn<Contact, Integer> phoneColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        idColumn.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("id"));
        firstColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        lastColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("phoneNumber"));

        try
        {
            tableView.getItems().addAll(DBConnect.getContacts());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void createContactButtonPushed(ActionEvent event) throws IOException
    {
        SceneChanger.changeScenes(event, "ContactCreatorView.fxml", "Contact Create");
    }
}
