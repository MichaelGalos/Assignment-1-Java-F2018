import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactCreatorViewController implements Initializable
{

    @FXML
    private TextField idTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) { msgLabel.setText(""); }

    @FXML
    public void createContactButtonPushed()
    {
        msgLabel.setText("");
        if(testFieldsForInput())
        {
            try
            {
                Contact newContact = new Contact(Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), Integer.parseInt(phoneNumberTextField.getText()));
            }
            catch (Exception e)
            {
                msgLabel.setText(e.getMessage());
            }
        }
    }

    public boolean testFieldsForInput()
    {
        msgLabel.setText("");

        try
        {
            Integer.parseInt(idTextField.getText());
        }
        catch(Exception e)
        {
            String msg = msgLabel.getText();
            msgLabel.setText(msg + "\nId must be a number");
        }

        if(firstNameTextField.getText().isEmpty())
        {
            String msg = msgLabel.getText();
            msgLabel.setText(msg + "\nFirst Name cannot be empty");
        }

        if(lastNameTextField.getText().isEmpty())
        {
            String msg = msgLabel.getText();
            msgLabel.setText(msg + "\nLast Name cannot be empty");
        }

        if(addressTextField.getText().isEmpty())
        {
            String msg = msgLabel.getText();
            msgLabel.setText(msg + "\nAddress cannot be empty");
        }

        try
        {
            Integer.parseInt(phoneNumberTextField.getText());
        }
        catch (Exception e)
        {
            String msg = msgLabel.getText();
            msgLabel.setText(msg + "\nPhone Number cannot be empty");
        }

        return msgLabel.getText().isEmpty();
    }

    public void showContactsButtonPressed(ActionEvent event) throws IOException
    {
        SceneChanger.changeScenes(event, "ContactView.fxml", "Contact Create");
    }
}
