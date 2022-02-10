import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable {
   @FXML
    private TextField pseudo;
    @FXML
   private Pane errorPane;
   private GameController gameController;
   private Scene game_page_scene;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("test.fxml"));
            Parent home_page_parent=loader.load();
            gameController =loader.getController();
            game_page_scene=new Scene(home_page_parent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void closeErrorBox(){
        errorPane.setVisible(false);
    }

    public void createWarrior(javafx.event.ActionEvent actionEvent) throws IOException {
        if(pseudo.getText().isEmpty())
            errorPane.setVisible(true);
        else {
            Warrior warrior = new Warrior(100, 50, pseudo.getText());
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            gameController.setWarrior(warrior.getHp(), warrior.getMana(), warrior.getPseudo());

//            gameController.basicAttack.setVisible(false);
//            gameController.magicAttack.setVisible(false);
//            gameController.hunterShop.setVisible(false);
//            gameController.mageShop.setVisible(false);
//            gameController.warriorShop.setVisible(false);
            gameController.enemyList = new ArrayList<>();

            app_stage.setScene(game_page_scene);
            app_stage.show();
        }


    }
    public void createHunter(javafx.event.ActionEvent actionEvent) throws IOException {
        if(pseudo.getText().isEmpty())
            errorPane.setVisible(true);
        else {
            Hunter hunter = new Hunter(100, 50, pseudo.getText());
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            gameController.setHunter(hunter.getHp(), hunter.getMana(), hunter.getPseudo());
//        gameController.basicAttack.setVisible(false);
//        gameController.magicAttack.setVisible(false);
            gameController.enemyList = new ArrayList<>();
//        gameController.hunterShop.setVisible(false);
//        gameController.mageShop.setVisible(false);
//        gameController.warriorShop.setVisible(false);

            app_stage.setScene(game_page_scene);
            app_stage.show(); // arme est null chelou ?:
        }
    }
    public void createMage(javafx.event.ActionEvent actionEvent) throws IOException {
        if(pseudo.getText().isEmpty())
            errorPane.setVisible(true);
        else {
            Mage mage = new Mage(100, 50, pseudo.getText());
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            gameController.setMage(mage.getHp(), mage.getMana(), mage.getPseudo());
            gameController.hunterShop.setVisible(false); // sinon ca bug
//        gameController.basicAttack.setVisible(false);
//        gameController.magicAttack.setVisible(false);

//        gameController.mageShop.setVisible(false);
//        gameController.warriorShop.setVisible(false);
            gameController.enemyList = new ArrayList<>();


            app_stage.setScene(game_page_scene);
            app_stage.show();
        }
    }
}
