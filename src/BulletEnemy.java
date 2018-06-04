public class BulletEnemy extends GameObject {
    public Vector2D velocity;

    // constructor
    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}