import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * This method accepts the title of the new scene, the .fxml file
     * name for the new view and the ActionEvent that triggered the change
     */
    public static void changeScenes(ActionEvent event, String viewName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));

        Parent root = loader.load();

        Scene scene = new Scene(root);

        //get the stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}