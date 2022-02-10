import javafx.scene.image.Image;

public class Shield extends Weapon{

    public Shield(){
        super();
    }
    public Shield(int damage, String name, Image img){  //ici on interprete damage autrement=>dégats qu'il peut subir
        super(damage,name,img);
    }
}
