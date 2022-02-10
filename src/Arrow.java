import javafx.scene.image.Image;

public class Arrow extends Weapon{
        int nbArrow;
    public Arrow(){
        super();
    }
    public Arrow(int damage, String name, Image img){
        super(damage,name,img);
        nbArrow=5;
    }
}
