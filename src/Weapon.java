import javafx.scene.image.Image;

public class Weapon {
    protected int damage;
    protected String name;
    protected Image img;

    public Weapon(){
        this.damage=0;
        this.name="null";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon(int dmg, String name,Image img){
            this.damage=dmg;
            this.name=name;
            this.img=img;
        }
    public Image getImg(){
        return this.img;
    }
    public void setImg(Image img){
        this.img=img;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
