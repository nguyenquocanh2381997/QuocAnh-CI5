import java.awt.*;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    private PlayerMove playerMove;
    private PolygonRenderer renderer;
    public int angle;


    public Player(Vector2D position, Vector2D velocity, Color color) {
        this.position = position;
        this.velocity = velocity;
        this.renderer = new PolygonRenderer(Color.red,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
    }

    public void run() {
        this.playerMove.run(this);
        this.position.addUp(this.velocity.rotate(this.angle));
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
