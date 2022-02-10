import javafx.scene.image.Image;

public class Mage extends Character {
    Staff staff;
    Spell spell;
    public Mage(){
        super();
        this.staff=null;
    }
    public Mage(int hp,int mana,String pseudo){
        super(hp,mana,pseudo);
        Image img=new Image("images/woodenStaff.png");
        Image imgSpell=new Image("images/fireBall.png");
        this.image=new Image("images/mage.png");

        this.spell=new Spell(5,"fireBall",imgSpell);
        this.staff=new Staff(10,"woodenStaff",img);

        this.gold=1000;

    }
    public Mage(int hp,int mana,int level, String pseudo){
        super(hp,mana,level,pseudo);
    }
    public int basicAttack(){
                this.mana+=20;
        return this.staff.damage;
    }
    public int getMagicDamage(){return this.spell.getDamage();}
    public int magicAttack(){
        this.mana-=30;
        return this.spell.getDamage();
    }
    public int manaNeeded(){
        return 30;
    }
    public Weapon getWeapon(){
        return this.staff;
    }
    public void test(Weapon weapon){
        this.staff=new Staff(weapon.getDamage(),weapon.getName(),weapon.getImg());
    }
    public Spell getSpell(){
        return this.spell;
    }
}
