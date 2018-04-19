import java.awt.*;

public class Enemy {
    public Vector2D position;
    public Vector2D velocity;
    private ImageRenderer renderer;

    public Enemy(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png", 10, 10);
    }

    public void run(){
        this.position.addUp(this.velocity); // thay doi vi tri
    }

    public void render(Graphics graphics){
       this.renderer.render(graphics, this.position);
    }
}
