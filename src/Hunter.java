import javafx.scene.image.Image;

import java.awt.*;

public class Hunter extends Character{
    Bow bow;
    Spell spell;
    int nbFleche;
    public Hunter(){
        super();
        this.bow=null;
    }
    public Hunter(int hp,int mana, String pseudo){
        super(hp,mana,pseudo);
        Image imgBow=new Image("images/woodenBow.png");
        Image imgSpell=new Image("images/arrow.jpg");
        this.image=new Image("images/hunter.jpg");
         this.bow=new Bow(20,"woodenBow",imgBow);
         this.spell=new Spell(5,"arrow",imgSpell);
         this.gold=0;
    }
    public int getMagicDamage(){return spell.getDamage();}
    public Hunter(int hp,int mana,int level, String pseudo){
        super(hp,mana,level,pseudo);
    }
    public int basicAttack(){
        this.mana+=10;
        return this.bow.damage;

    }
    public int magicAttack(){
        this.mana-=20;
        return this.spell.getDamage();
    }
    public int manaNeeded(){
        return 20;
    }
    public Weapon getWeapon(){
        return this.bow;
    }
    public void test(Weapon weapon){
        this.bow=new Bow(weapon.getDamage(),weapon.getName(),weapon.getImg());
    }
    public Spell getSpell(){
        return this.spell;
    }


}
