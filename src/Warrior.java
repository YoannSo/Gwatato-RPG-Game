import javafx.scene.image.Image;

public class Warrior extends Character {
    Sword sword;
    Shield shield;
    public Warrior(){
        super();
        this.sword=null;
        this.shield=null;
    }
    public Warrior(int hp,int mana, String pseudo){
        super(hp,mana,pseudo);
        Image swordImg=new Image("images/woodenSword.png");
        Image shieldImg=new Image("images/woodenShield.png");
        this.image=new Image("images/warrior.png");
        this.sword=new Sword(5,"woodenSword",swordImg);
        this.shield=new Shield(5,"woodenShield",shieldImg);
        this.gold=1000;
    }
    public Warrior(int hp,int mana,int level, String pseudo){
        super(hp,mana,level,pseudo);
    }
    public int getMagicDamage(){return 20;}

    public int basicAttack(){
        if(mana+10<=maxMana)
        setMana(getMana()+10);
        else if(maxMana-mana<10)
            setMana(maxMana);
        int rand=(int)(Math.random()*5); //1 chance sur 5
        if(rand==1)
            return sword.getDamage()*2;
        else
            return sword.getDamage();

    }

    public int magicAttack(){
        this.mana-=20;
        int rand=(int)(Math.random()*5); //1 chance sur 5
        if(rand==1) {
            System.out.println("COUP CRITIQUE");
            return 40;

        }
        else
            return 20;
    }
    public int manaNeeded(){
        return 20;
    }
    public Weapon getWeapon(){
        return this.sword;
    }
    public Shield getShield(){return this.shield;}
    public void setWeapon(String nom,int swordDmg,String sourceSword,String nom2,int shieldDmg,String sourceShield){
        System.out.println(sourceShield);
        System.out.println(sourceSword);
        Image swordImg=new Image("images/"+sourceSword);
        Image shieldImg=new Image("images/"+sourceShield);
//        this.sword=new Sword(swordDmg,nom,swordImg);
//        this.shield=new Shield(shieldDmg,nom2,shieldImg);
    }
    public void test(Weapon weapon){
        if(weapon.getClass().getName()=="Sword")
            this.sword=new Sword(weapon.getDamage(),weapon.getName(),weapon.getImg());
        else{
            this.shield=new Shield(weapon.getDamage(),weapon.getName(),weapon.getImg());
            System.out.println("test");
    }}
}
