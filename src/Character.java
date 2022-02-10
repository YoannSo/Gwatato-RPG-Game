import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.*;

public class Character {
    protected int hp;
    protected int mana;
    protected int level;
    protected String pseudo;
    protected int maxMana;
    protected int maxHp;
    protected int gold;
    protected Image image;
    protected Map<String,Pair<String,Weapon>> weaponList; // enlever pair String de weapon

    public Character(){
        this.hp=0;
        this.mana=0;
        this.level=0;
        this.maxMana=0;
        this.maxHp=0;
        this.gold=0;
        this.image=null;
        this.weaponList=new HashMap<String,Pair<String,Weapon>>();
        this.pseudo=null;
    }


    public Character(int hp, int mana, String pseudo) {
        this.hp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.level = 0;
        this.maxHp = hp;
        this.gold = 0;
        this.pseudo = pseudo;
        this.weaponList = new HashMap<String,Pair<String,Weapon>>();
    }

    public Character(int hp,int mana,int level,String pseudo){
        this.hp=hp;
        this.mana=mana;
        this.maxMana=mana;
        this.level=level;
        this.gold=0;
        this.pseudo=pseudo;
        this.maxHp=hp;
        weaponList=null;
    }
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void test(Weapon weapon){}

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int basicAttack(){
        this.mana+=10;
        return 0;
    }
    public int magicAttack(){
        return 0;
    }
    public int manaNeeded(){
        return 0;
    }

    public int getMagicDamage(){return 0;}

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public Weapon getWeapon(){
        return null;
    }
    public Shield getShield(){
        return null;
    }
    public Spell getSpell(){return null;}
    public Image getImage(){return this.image;}

    public String getPseudo(){return this.pseudo;}
    public  void setPseudo(String pseudo){this.pseudo=pseudo;}


}
