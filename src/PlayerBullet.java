import java.awt.*;
public class PlayerBullet extends GameObject {
    public Vector2D position;
    public Vector2D velocity;
    private ImageRenderer renderer;

    // constructor
    public PlayerBullet() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
