import java.awt.*;

public class BulletPlayer {

    public Vector2D position;
    public Vector2D velocity;
    private ImageRenderer renderer;

    // constructor
    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
