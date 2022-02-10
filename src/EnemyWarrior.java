import javafx.scene.image.Image;

public class EnemyWarrior extends Enemy {

    private Image img;
    public EnemyWarrior(){
        super();
        img=new Image("images/EnemyWarrior.png");
    }
    public EnemyWarrior(int hp,int mana, String pseudo){
        super(hp,mana,pseudo);
        this.basicDamage=10;
        this.magicDamage=5;
        img=new Image("images/EnemyWarrior.png");
    }


    public int basicAttack(){
        if(mana+10<=manaMax)
            this.mana=(getMana()+10);
        else if(manaMax-mana<10)
            this.mana=(manaMax);
        int rand=(int)(Math.random()*5); //1 chance sur 5
        if(rand==1) {
            System.out.println("COUP CRITIQUE");
            return basicDamage*2;
        }
        else
            return basicDamage;

    }

    public int magicAttack(){
        mana-=20;
        int rand=(int)(Math.random()*5); //1 chance sur 5
        if(rand==1) {
            System.out.println("COUP CRITIQUE ENNEMi");
            return magicDamage*2;
        }
        else
            return magicDamage;
    }
    public Image getImg(){return this.img;}
    public int manaNeeded(){
        return 20;
    }
}
