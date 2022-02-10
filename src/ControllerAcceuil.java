import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerAcceuil implements Initializable{
    private GameController gameController;
    private Scene game_page_scene;

     public AnchorPane AnchorPane;

   public TextField nameCharacter;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("test.fxml"));
            Parent home_page_parent=loader.load();
            gameController =loader.getController();
            game_page_scene=new Scene(home_page_parent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void handleButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("You clicked");
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent home_page_parent=loader.load();
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    public void chargerPersonnage(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("You clicked");
        FileInputStream save=new FileInputStream("C:\\Users\\hardg\\IdeaProjects\\Java\\sauvegarde\\"+nameCharacter.getText()+".txt");
        Scanner scanner=new Scanner(save);

            String s=scanner.nextLine();
        System.out.println(s);
        System.out.println(s);
        if(s.equals("Warrior")){
            Warrior warrior=new Warrior(Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),scanner.nextLine());
            warrior.setWeapon(scanner.nextLine(),Integer.valueOf(scanner.nextLine()),scanner.nextLine(),scanner.nextLine(),Integer.valueOf(scanner.nextLine()),scanner.nextLine());
            scanner.close();
            save.close();

            Stage app_stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            gameController.setWarrior(warrior.getHp(),warrior.getMana(), warrior.getPseudo());
//            gameController.basicAttack.setVisible(false);
//            gameController.magicAttack.setVisible(false);
            gameController.enemyList=new ArrayList<>();
            app_stage.setScene(game_page_scene);



            app_stage.show();





        }
        else if(s.equals("Mage")){
            Mage mage=new Mage(Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),scanner.nextLine());
            scanner.close();
            save.close();

        }
        else {
            Hunter hunter=new Hunter(Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),Integer.valueOf(scanner.nextLine()),scanner.nextLine());
            scanner.close();
            save.close();

        }




//        File file=new File("C:\\Users\\hardg\\IdeaProjects\\Java\\sauvegarde\\"+nameCharacter.getText()+".txt","r");
//        FileReadbonne caner fr=new FileReader(file);
//
//        BufferedReader br=new BufferedReader(fr);
//        StringBuffer sb=new StringBuffer();
//        String line;
//        while ((line=br.readLine())!=null){
//            sb.append(line);
//            sb.append("\n");
//        }
//        fr.close();
//        System.out.println(sb.toString());

//        RandomAccessFile file=new RandomAccessFile("C:\\Users\\hardg\\IdeaProjects\\Java\\sauvegarde\\"+nameCharacter.getText()+".txt","r");
//        FileChannel channel=file.getChannel();
//        ByteBuffer buffer=ByteBuffer.allocate((int)channel.size());
//        channel.read(buffer);
//        buffer.flip();
//        for(int i=0;i<channel.size();i++){
//            System.out.println((int) buffer.get());
//        }
//        channel.close();
//        file.close();

//        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
//        Parent home_page_parent=loader.load();
//        Scene home_page_scene=new Scene(home_page_parent);
//        Stage app_stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(home_page_scene);
//        app_stage.show();

    }
}
