
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.image.Image.*;
import javafx.util.Duration;
import javafx.util.Pair;

public class GameController implements Initializable {

    public Character character;
    public Shop shop;

    Scene fightScene;
    @FXML
    private Label level;
    public Label hp;
    public Label mana;
   public Label pseudo;
    public Label gold;
    public Label levelFight;
    public Label hpFight;
    public Label manaFight;
    public Label pseudoFight;
    public Label goldFight;
   public Button fightButton;
    public Button save;
    public ImageView characterImage;
    public SplitPane fight;
    public SplitPane village;
    public Button skipTurn;
    public Button basicAttack;
    public Button magicAttack;
    public ImageView test;
    public Label turn;
    public ArrayList<Enemy>enemyList;
    public ImageView enemyImage;
    public Label enemyHp;
    public Label enemyMana;
    public Label enemyName;
    public Text deathReason;
    public Pane deathAlert;
    public Pane manaAlert;
    public Pane winAlert;
    public ImageView weapon;
    public Label weaponDamage;
    public Label weaponName;
    public Label nbFleche;
    public Label secondaryWeaponName;
    public Label secondaryWeaponDamage;
    public ImageView secondaryWeapon;
    public Pane nextCombatAlert;
    public Pane selectLevel;

    public Text enemyCriticalStrike;
    public Text yourCriticalStrike;
    public Text enemyAttack;
    public Text yourAttack;
    public Pane enemyDialogueAttack;


    public Pane shopPane;
    public TabPane hunterShop;
    public TabPane mageShop;
    public TabPane warriorShop;
    public Pane notEnoughGold;

    public ChoiceBox<String> armeEquipe;



        public void fight(javafx.event.ActionEvent actionEvent){
            this.fight.setVisible(true);
            this.test.setImage(character.getImage());
//            deathAlert.setVisible(false);
//            save.setVisible(false);
//            basicAttack.setVisible(true);
//            magicAttack.setVisible(true);
            this.village.setVisible(false);
            int nbEnemy=3;
            fillDungeon(3);
            this.enemyImage.setImage(enemyList.get(0).getImg());
            this.enemyName.setText("Name:"+enemyList.get(0).getName());
            this.enemyHp.setText("HP:"+enemyList.get(0).getHp());
            this.enemyMana.setText("MANA:"+enemyList.get(0).getMana());
            this.hpFight.setText("HP:"+character.getHp());
            this.levelFight.setText("LEVEL:"+character.getLevel());
            this.manaFight.setText("MANA:"+character.getMana());
            this.goldFight.setText("GOLD:"+character.getGold());

            this.pseudoFight.setText(character.getPseudo());


        }
        public void fillDungeon(int nbEnemy){
            this.enemyList=new ArrayList<Enemy>(3);
            for(int i=0;i<3;i++) {
                int rand = (int) (Math.random() * 6);
                switch(rand){
                    case 0:
                        Skeleton skeleton=new Skeleton(40,30,"skeleton");
                        this.enemyList.add(skeleton);
                        break;
                    case 1:
                        DarkMage darkMage=new DarkMage(30,50,"Dark Mage");
                        this.enemyList.add(darkMage);
                        break;
                    case 2:
                        EnemyMage enemyMage=new EnemyMage(30,40,"Mage");
                        this.enemyList.add(enemyMage);
                        break;
                    case 3:
                        EnemyWarrior enemyWarrior=new EnemyWarrior(50,30,"Warrior");
                        this.enemyList.add(enemyWarrior);
                        break;
                    case 4:
                        ZombiePeasant zombiePeasant=new ZombiePeasant(30,30,"Zombie Peasant");
                        this.enemyList.add(zombiePeasant);
                        break;
                    case 5:
                        Warlord warlord=new Warlord(80,30,"Warlord");
                        this.enemyList.add(warlord);
                        break;

                }


            }
        }
        public void titleScreen(javafx.event.ActionEvent actionEvent) throws IOException {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("acceuil.fxml"));
            Parent home_page_parent=loader.load();
            Stage app_stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene game_page_scene=new Scene(home_page_parent);
            app_stage.setScene(game_page_scene);
            app_stage.show();

    }
    public void charScreen(){
            fight.setVisible(false);
        skipTurn.setVisible(true);
        winAlert.setVisible(false);
        basicAttack.setVisible(true);
        magicAttack.setVisible(true); //on reaffiche les button pour les prochain combat
        this.hp.setText("HP:"+character.getMaxHp());
        this.mana.setText("HP:"+character.getMaxMana());
            village.setVisible(true);

    }
    public void enemyTurn(){

            int damage;
            enemyCriticalStrike.setVisible(false);
        int rand=(int)(Math.random()*2); //revoir les chances
        if((rand==1)&&(enemyList.get(0).manaNeeded()-1<enemyList.get(0).getMana())) {
            enemyDialogueAttack.setVisible(true);

                damage=enemyList.get(0).magicAttack();
            character.setHp(character.getHp() - damage);
            if(damage>enemyList.get(0).getMagicDamage())
                enemyCriticalStrike.setVisible(true);
            enemyAttack.setText("I launched a magic attack on you, it caused "+damage+" damage to you. HAHAHA");
            this.hpFight.setText("HP:" + character.getHp());
            enemyMana.setText("MANA:"+enemyList.get(0).getMana());
        }
        else{
            if(character.getClass().getName()=="Warrior") {
                enemyDialogueAttack.setVisible(true);

                damage = enemyList.get(0).basicAttack() - character.getShield().getDamage();
                character.setHp(character.getHp() - damage);
                if (damage + character.getShield().getDamage() > enemyList.get(0).getBasicDamage())
                    enemyCriticalStrike.setVisible(true);
                enemyAttack.setText("I launched a basic attack on you, it caused " + damage + " damage to you. HAHAHA");
                character.setHp((character.getHp()) - damage); //le warrior counter de degats avec son shield
            }
            else {
                enemyDialogueAttack.setVisible(true);

                damage = enemyList.get(0).basicAttack();
                character.setHp(character.getHp() - damage);
                if (damage > enemyList.get(0).getBasicDamage())
                    enemyCriticalStrike.setVisible(true);
                enemyAttack.setText("I launched a basic attack on you, it caused " + damage + " damage to you. HAHAHA");
                character.setHp(character.getHp() - damage);
                this.hpFight.setText("HP:" + character.getHp());
                enemyMana.setText("MANA:" + enemyList.get(0).getMana());
            }

        }

    }
    public void skipTurn(){
            yourAttack.setText("You skip your turn");
            yourCriticalStrike.setVisible(false);
        if(character.getMana()+20<=character.getMaxMana())
            character.setMana(character.getMana()+20);
        else if(character.getMaxMana()-character.getMana()<10)
            character.setMana(character.getMaxMana());
             //si on passe le tour on se regen plus de mana
        this.manaFight.setText("MANA:"+character.getMana());
        turn.setText("Enemy turn");

        enemyTurn();
        yourDeath();
    }
        public void basicAttack() throws InterruptedException {
            yourCriticalStrike.setVisible(false);
            int damage=character.basicAttack();
            yourAttack.setVisible(true);
            yourAttack.setText("You launch a basic attack on this monster that inflicts "+damage+" damage");
            if(damage>character.getWeapon().getDamage())
                yourCriticalStrike.setVisible(true);
            enemyList.get(0).setHp(enemyList.get(0).getHp()-damage);
//            TranslateTransition translate=new TranslateTransition(Duration.seconds(2),test);
//            translate.setToX(enemyImage.getLayoutX());
//            RotateTransition rotation=new RotateTransition(Duration.seconds(1),test);
//            rotation.setByAngle(30);
//
////            translate.setFromY(0);
////            translate.setToY(50);
//            translate.setCycleCount(2);
//            rotation.setCycleCount(2);
//            rotation.setDelay(Duration.seconds(2));
//            rotation.setAutoReverse(true);
//           translate.setAutoReverse(true);
//            translate.play();
//
//            rotation.play();
            enemyHp.setText("HP:"+enemyList.get(0).getHp());
            this.manaFight.setText("MANA:"+character.getMana()); //besoin de reafficher le mana car il a regen
            if(enemyList.get(0).getHp()<1)
                enemyDeath();
            else{
                turn.setText("Enemy turn"); // je fais pas le test dans la focntion car sinon il va tenter d'attaquer meme si il n 'y a plus rien dans la liste
                enemyTurn();
                turn.setText("Your turn");}
            turn.setText("Your turn");
            yourDeath();




              }
    public void magicAttack(){
            if(character.manaNeeded()-1<character.getMana()) {//attention c'est pas plus grand que 0 c est si il a assez de ^mana
                yourCriticalStrike.setVisible(false);
                int damage=character.magicAttack();
                yourAttack.setVisible(true);
                yourAttack.setText("You launch a magic attack on this monster that inflicts "+damage+" damage");
                if(damage>character.getMagicDamage())
                    yourCriticalStrike.setVisible(true);
                enemyList.get(0).setHp(enemyList.get(0).getHp()-damage);
                enemyHp.setText("HP:" + enemyList.get(0).getHp());
                this.manaFight.setText("MANA:" + character.getMana());
                if(enemyList.get(0).getHp()<1)
                    enemyDeath();
                else{
                    turn.setText("Enemy turn");
               enemyTurn();
                    turn.setText("Your turn");}

               yourDeath();


            }
            else {
                skipTurn.setVisible(false);
                basicAttack.setVisible(false);
                magicAttack.setVisible(false);
                manaAlert.setVisible(true);
            }


    }
    public void enemyDeath(){
        if(enemyList.get(0).getHp()<1){
            yourCriticalStrike.setVisible(false);
            yourAttack.setVisible(false);
            enemyDialogueAttack.setVisible(false);
            enemyList.remove(0);
            character.setGold(character.getGold()+50);
            this.goldFight.setText("GOLD:"+character.getGold());
            if(enemyList.isEmpty()){
                skipTurn.setVisible(false);
                basicAttack.setVisible(false);
                magicAttack.setVisible(false);
                character.setLevel(character.getLevel()+1);
                level.setText("LEVEL:"+character.getLevel());
                selectLevel.setVisible(true);

            }
            else {skipTurn.setVisible(false);
                basicAttack.setVisible(false);
                magicAttack.setVisible(false);
                nextCombatAlert.setVisible(true);
            }
        }

    }
    public void winAlert(){
        yourCriticalStrike.setVisible(false);
        yourAttack.setVisible(false);
        winAlert.setVisible(true);
        skipTurn.setVisible(false);
        basicAttack.setVisible(false);
        magicAttack.setVisible(false);

        character.setHp(character.getMaxHp());
        character.setMana(character.getMaxMana());
        this.hpFight.setText("HP:"+character.getHp());
        this.manaFight.setText("MANA:"+character.getMana());
    }
    public void improveHp(){
            character.setMaxHp(character.getMaxHp()+10);
            hp.setText("HP:"+character.getHp());
            selectLevel.setVisible(false);
            winAlert();

    }
    public void improveMana(){
        character.setMaxMana(character.getMaxMana()+10);
        mana.setText("MANA:"+character.getMana());
        selectLevel.setVisible(false);
        winAlert();
    }
    public void improveWeapon(){
        character.getWeapon().setDamage(character.getWeapon().getDamage()+10);
        weaponDamage.setText("DMG:"+character.getWeapon().getDamage());
        selectLevel.setVisible(false);
        winAlert();
    }

    public void nextCombat(){
        nextCombatAlert.setVisible(false);

        enemyImage.setImage(enemyList.get(0).getImg());
        enemyName.setText("Name:"+enemyList.get(0).getName());
        enemyHp.setText("HP:"+enemyList.get(0).getHp());
        enemyMana.setText("MANA:"+enemyList.get(0).getMana());
        skipTurn.setVisible(true);
        basicAttack.setVisible(true);
        magicAttack.setVisible(true);

    }
    public void yourDeath(){
        if(character.getHp()<1){
            skipTurn.setVisible(false);
            basicAttack.setVisible(false);
            magicAttack.setVisible(false);
            deathReason.setText(enemyList.get(0).getName()+"\n" +"skeletor killed you you lost your character and your progress");

            deathAlert.setVisible(true);
        }

    }
    public void changerArme(){
//            Weapon s=new Weapon(armeEquipe.getValue().getDamage(),armeEquipe.getValue().getName(),armeEquipe.getValue().getImg());
            String s;

        if(character.weaponList.get(armeEquipe.getValue()).getValue().getClass().getName()=="Shield"){
            Pair<String,Weapon>temp=new Pair<String, Weapon>(""+character.getShield().getName(),character.getShield());
             s=character.getShield().getName();
            character.weaponList.put(""+character.getShield().getName(),temp);
            secondaryWeaponName.setText("Name:"+character.weaponList.get(armeEquipe.getValue()).getKey());
            secondaryWeaponDamage.setText("DMG:"+character.weaponList.get(armeEquipe.getValue()).getValue().getDamage()); //regarder pourquoi poison bow deviens ironBow inverse pardon
            secondaryWeapon.setImage(character.weaponList.get(armeEquipe.getValue()).getValue().getImg());
            character.test(character.weaponList.get(armeEquipe.getValue()).getValue());

        }
        else {
            Pair<String,Weapon>temp=new Pair<String, Weapon>(""+character.getWeapon().getName(),character.getWeapon());
             s=character.getWeapon().getName();
            character.weaponList.put(""+character.getWeapon().getName(),temp);
            weaponDamage.setText("Name:" + character.weaponList.get(armeEquipe.getValue()).getKey());
            weaponName.setText("DMG:" + character.weaponList.get(armeEquipe.getValue()).getValue().getDamage()); //regarder pourquoi poison bow deviens ironBow inverse pardon

            weapon.setImage(character.weaponList.get(armeEquipe.getValue()).getValue().getImg());

            character.test(character.weaponList.get(armeEquipe.getValue()).getValue());
        }

        armeEquipe.getItems().add(s);
        character.weaponList.remove(armeEquipe.getValue());
        armeEquipe.getItems().remove(armeEquipe.getValue());


   }
//    public void updateWeapon(){
//            int nbArme;
//            nbArme=character.weaponList.size();
//        System.out.println(nbArme);
//       list=FXCollections.observableArrayList();
//
//       for(int i=0;i<nbArme;i++)
//           list.add(character.weaponList.get(i));
//       armeEquipe.getItems().addAll(list);
//
//
//
//
//   }
    public void closeShop(){
        shopPane.setVisible(false);
    }
    public void closeManaAlert(){
        skipTurn.setVisible(true);
        basicAttack.setVisible(true);
        magicAttack.setVisible(true);
        manaAlert.setVisible(false);
    }
        public void save(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
            try {// Recevoir le fichier
                FileOutputStream save = new FileOutputStream("C:\\Users\\hardg\\IdeaProjects\\Java\\sauvegarde\\" + character.getPseudo() + ".txt");
                save.write(this.character.getClass().getName().getBytes());
                save.write("\n".getBytes());
                save.write(String.valueOf(this.character.getHp() + "\n").getBytes());
                save.write(String.valueOf(this.character.getMana() + "\n").getBytes());
                save.write(String.valueOf(this.character.getLevel() + "\n").getBytes());
                save.write(this.character.getPseudo().getBytes());
                save.write("\n".getBytes());
                save.write(String.valueOf(this.character.getWeapon().getName() + "\n").getBytes());
                save.write(String.valueOf(this.character.getWeapon().getDamage() + "\n").getBytes());
                save.write(String.valueOf( this.character.getWeapon().getName()+".png\n").getBytes());
                if(this.character.getClass().getName()=="Warrior"){
                    save.write(String.valueOf(this.character.getShield().getName() + "\n").getBytes());
                    save.write(String.valueOf(this.character.getShield().getDamage() + "\n").getBytes());
                    save.write(String.valueOf( this.character.getShield().getName()+".png\n").getBytes());

                }

                save.flush();
                save.close();
                System.out.println("La sauvegarde a reussie");

            }
            catch (Exception e) {
                System.out.println("Probleme lors de la save");
                System.err.println(e);
            }
        }
        public void openShop(){
            shopPane.setVisible(true);
            if(this.character.getClass().getName()=="Hunter")
                hunterShop.setVisible(true);
            else if(this.character.getClass().getName()=="Mage")
                mageShop.setVisible(true);
            else
                warriorShop.setVisible(true);
        }
        public void affPoisonBow(){

        }
       public void buyFireStaff(){
           if(character.getGold()>=shop.shop.get(0).getValue()){   //0 car l'iron est 0 dans la liste
               Pair<String,Weapon>fireStaff=new Pair<>("fireStaff",shop.shop.get(0).getKey());
               character.weaponList.put(shop.shop.get(0).getKey().getName(),fireStaff);
               character.setGold(character.getGold()-shop.shop.get(0).getValue());
               gold.setText("GOLD:"+character.getGold());

               armeEquipe.getItems().add(shop.shop.get(0).getKey().getName());
           }
           else
               notEnoughGold.setVisible(true);
       }

      public void buyIceStaff(){
          if(character.getGold()>=shop.shop.get(1).getValue()){   //0 car l'iron est 0 dans la liste
              Pair<String,Weapon>iceStaff=new Pair<>("iceStaff",shop.shop.get(1).getKey());
              character.weaponList.put(shop.shop.get(1).getKey().getName(),iceStaff);
              character.setGold(character.getGold()-shop.shop.get(1).getValue());
              gold.setText("GOLD:"+character.getGold());

              armeEquipe.getItems().add(shop.shop.get(1).getKey().getName());
          }
          else
              notEnoughGold.setVisible(true);
      }

        public void buyDarkSword(){
            if(character.getGold()>=shop.shop.get(0).getValue()){   //0 car l'iron est 0 dans la liste
                Pair<String,Weapon>darkSword=new Pair<>("darkSword",shop.shop.get(0).getKey());
                character.weaponList.put(shop.shop.get(0).getKey().getName(),darkSword);
                character.setGold(character.getGold()-shop.shop.get(0).getValue());
                gold.setText("GOLD:"+character.getGold());

                armeEquipe.getItems().add(shop.shop.get(0).getKey().getName());
            }
            else
                notEnoughGold.setVisible(true);
       }
      public void buyFireSword(){
          if(character.getGold()>=shop.shop.get(1).getValue()){   //0 car l'iron est 0 dans la liste
              Pair<String,Weapon>fireSword=new Pair<>("fireSword",shop.shop.get(1).getKey());
              character.weaponList.put(shop.shop.get(1).getKey().getName(),fireSword);
              character.setGold(character.getGold()-shop.shop.get(1).getValue());
              gold.setText("GOLD:"+character.getGold());

              armeEquipe.getItems().add(shop.shop.get(1).getKey().getName());
          }
          else
              notEnoughGold.setVisible(true);
      }
        public void buyMagicalShield(){
            if(character.getGold()>=shop.shop.get(2).getValue()){   //0 car l'iron est 0 dans la liste
                Pair<String,Weapon>magicalShield=new Pair<>("magicalShield",shop.shop.get(2).getKey());
                character.weaponList.put(shop.shop.get(2).getKey().getName(),magicalShield);
                character.setGold(character.getGold()-shop.shop.get(2).getValue());
                gold.setText("GOLD:"+character.getGold());

                armeEquipe.getItems().add(shop.shop.get(2).getKey().getName());
            }
            else
                notEnoughGold.setVisible(true);
        }
    public void buyGoldenShield(){
        if(character.getGold()>=shop.shop.get(3).getValue()){   //0 car l'iron est 0 dans la liste
            Pair<String,Weapon>goldenShield=new Pair<>("goldenShield",shop.shop.get(3).getKey());//aulieu de faire avec pair on peut faire avec getclass.get(Name)
            character.weaponList.put(shop.shop.get(3).getKey().getName(),goldenShield);
            character.setGold(character.getGold()-shop.shop.get(3).getValue());
            gold.setText("GOLD:"+character.getGold());

            armeEquipe.getItems().add(shop.shop.get(3).getKey().getName());
        }
        else
            notEnoughGold.setVisible(true);
    }
//

       public void buyPoisonBow(){
            if(character.getGold()>=shop.shop.get(1).getValue()){   //0 car l'iron est 0 dans la liste
                    Pair<String,Weapon>poisonBow=new Pair<>("poisonBow",shop.shop.get(1).getKey());
                character.weaponList.put(shop.shop.get(1).getKey().getName(),poisonBow);
                character.setGold(character.getGold()-shop.shop.get(1).getValue());
                gold.setText("GOLD:"+character.getGold());

                armeEquipe.getItems().add(shop.shop.get(1).getKey().getName());
            }
            else
                notEnoughGold.setVisible(true);
       }
        public void buyIronBow(){
            if(character.getGold()>=shop.shop.get(0).getValue()){   //0 car l'iron est 0 dans la liste
                Pair<String,Weapon>ironBow=new Pair<>("ironBow",shop.shop.get(0).getKey());
                character.weaponList.put(shop.shop.get(0).getKey().getName(),ironBow);
                character.setGold(character.getGold()-shop.shop.get(0).getValue());
                gold.setText("GOLD:"+character.getGold());
//                updateWeapon();
                armeEquipe.getItems().add(shop.shop.get(0).getKey().getName());
            }
            else
                notEnoughGold.setVisible(true);
       }
        public void closeNotEnoughMoney(){
            notEnoughGold.setVisible(false);
        }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        hunterShop.setVisible(false);
        warriorShop.setVisible(false);
        mageShop.setVisible(false);

}
public void setHunter(int hp,int mana,String pseudo){
        this.level.setText("LEVEL:0");
        this.hp.setText("HP:"+hp);
        this.mana.setText("MANA:"+mana);
//        this.pseudo.setText("PSEUDO:"+pseudo);

        this.character=new Hunter(hp,mana,pseudo);
         this.shop=new Shop();
         this.shop=shop.shopHunter();
        hunterShop.setVisible(true);
        this.secondaryWeapon.setImage(this.character.getSpell().getImg());
        this.secondaryWeaponName.setText("NAME:"+this.character.getSpell().getName());
        this.secondaryWeaponDamage.setText("DAMAGE:"+character.getSpell().getDamage());

    this.gold.setText("GOLD:"+character.getGold());
    this.level.setText("LEVEL:"+character.getLevel());
    Image img=new Image("images/hunter.jpg");

        characterImage.setImage(img);
        weapon.setImage(character.getWeapon().getImg());
    weaponName.setText(""+character.getWeapon().getName());
    weaponDamage.setText("Damage;"+character.getWeapon().getDamage());

}
    public void setWarrior(int hp,int mana,String pseudo){

        this.hp.setText("HP:"+hp);
        this.mana.setText("MANA:"+mana);
//        this.pseudo.setText("PSEUDO:"+pseudoFight);
        this.character=new Warrior(hp,mana,pseudo);
        this.level.setText("LEVEL:"+character.getLevel());
        this.gold.setText("GOLD:"+character.getGold());
        Image img=new Image("images/warrior.png");
        this.shop=new Shop();
        this.shop=shop.shopWarrior();
        warriorShop.setVisible(true);
        characterImage.setImage(img);
        weapon.setImage(character.getWeapon().getImg());
        secondaryWeapon.setImage(character.getShield().getImg());
        weaponName.setText(character.getWeapon().getName());
        weaponDamage.setText("Damage;"+character.getWeapon().getDamage());
        secondaryWeaponName.setText(character.getShield().getName());
        secondaryWeaponDamage.setText("block:"+character.getShield().getDamage());
    }
    public void setMage(int hp,int mana,String pseudo){
        this.level.setText("LEVEL:0");
        this.hp.setText("HP:"+hp);
        this.mana.setText("MANA:"+mana);
//        this.pseudo.setText("PSEUDO:"+pseudo);
        this.character=new Mage(hp,mana,pseudo);
        this.level.setText("LEVEL:"+character.getLevel());
        this.gold.setText("GOLD:"+character.getGold());
        Image img=new Image("images/mage.png");
        this.shop=new Shop();
        this.shop=shop.shopMage();
        mageShop.setVisible(true);
        this.secondaryWeapon.setImage(this.character.getSpell().getImg());
        this.secondaryWeaponName.setText("NAME:"+this.character.getSpell().getName());
        this.secondaryWeaponDamage.setText("DAMAGE:"+character.getSpell().getDamage());

        characterImage.setImage(img);
        weapon.setImage(character.getWeapon().getImg());
        weaponName.setText(""+character.getWeapon().getName());
        weaponDamage.setText("Damage;"+character.getWeapon().getDamage());
    }
//    public void setHp(int hp){
//        this.hp.setText("HP:"+hp);
//        this.character.setHp(hp);
//    }
//    public void setMana(int mana){
//        this.mana.setText("MANA:"+mana);
//        this.character.setMana(mana);
//    }
//
//    public void setPseudo(String string){
//        this.pseudo.setText("PSEUDO:"+string);
//        this.character.setPseudo(string);
//    }
//
//    public void setImage(Image image1,Image image2){
//        imagetest.setImage(image1);
//        weapon.setImage(image2);
//        weaponName.setText("test"+character.getWeapon());
//        weaponDmg.setText("Damage;"+character.getWeapon());
//        if(character.getClass().getName()=="Hunter"){
//
//        }
//    }

}
