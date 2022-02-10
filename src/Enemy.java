import javafx.scene.image.Image;

import java.util.ArrayList;

public class Enemy {
    protected int hp;
    protected int mana;
    protected String nom;
    protected int manaMax;
    protected int basicDamage;
    protected int magicDamage;

    public Enemy(){
        this.hp=0;
        this.mana=0;
        this.manaMax=0;
        nom="null";
    }
    public Enemy(int hp,int mana,String nom){
        this.hp=hp;
        this.mana=mana;
        this.manaMax=mana;
        this.nom=nom;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getBasicDamage(){
        return this.basicDamage;
    }
    public int getMagicDamage(){
        return this.magicDamage;
    }

    public int getMana() {
        return mana;
    }
    public Image getImg(){
        return null;
    }



    public String getName(){return this.nom;}
    public  void setName(String name){this.nom=nom;}

    public int basicAttack(){
        return 0;
    }
    public int magicAttack(){
        return 0;
    }
    public int manaNeeded(){
        return 0;
    }


}
