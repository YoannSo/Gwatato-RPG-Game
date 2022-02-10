import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Shop {
    ArrayList<Pair<Weapon,Integer>> shop; //Arme/Prix

    Shop(){
       shop=new ArrayList<Pair<Weapon,Integer>>();
    }

    public Shop shopHunter(){
        Image img1=new Image("images/ironBow.png");
        Image img2=new Image("images/poisonBow.png");
        Bow ironBow=new Bow(20,"ironBow",img1);
        Bow poisonBow=new Bow(20,"poisonBow",img2);
        Pair<Weapon,Integer>pair1=new Pair<>(ironBow,150);
        Pair<Weapon,Integer>pair2=new Pair<>(poisonBow,250);
        shop.add(pair1);
        shop.add(pair2);
        return this;
    }
    public Shop shopWarrior(){
        Image img1=new Image("images/darkSword.png");
        Image img2=new Image("images/fireSword.png");
        Image img3=new Image("images/magicalShield.png");
        Image img4=new Image("images/goldenShield.png");
        Sword darkSword=new Sword(20,"darkSword",img1);
        Sword fireSword=new Sword(20,"fireSword",img2);
        Shield magicalShield=new Shield(20,"magicalShield",img3);
        Shield goldenShield=new Shield(20,"goldenShield",img4);
        Pair<Weapon,Integer>pair1=new Pair<>(darkSword,150);
        Pair<Weapon,Integer>pair2=new Pair<>(fireSword,250);
        Pair<Weapon,Integer>pair3=new Pair<>(magicalShield,150);
        Pair<Weapon,Integer>pair4=new Pair<>(goldenShield,250);
        shop.add(pair1);
        shop.add(pair2);
        shop.add(pair3);
        shop.add(pair4);
        return this;
    }
    public Shop shopMage(){
        Image img1=new Image("images/fireStaff.png");
        Image img2=new Image("images/iceStaff.png");
        Staff fireStaff=new Staff(20,"fireStaff",img1);
        Staff iceStaff=new Staff(20,"iceStaff",img2);
        Pair<Weapon,Integer>pair1=new Pair<>(fireStaff,150);
        Pair<Weapon,Integer>pair2=new Pair<>(iceStaff,250);
        shop.add(pair1);
        shop.add(pair2);
        return this;
    }
}
