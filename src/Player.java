import java.awt.*;

public class Player {
    public Vector2D position;
    private PlayerMove playerMove;
    private PolygonRenderer renderer;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.red, new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
    }

    public void run() {
        this.playerMove.run(this);
        this.renderer.angle = this.playerMove.angle;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
