import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    private Vector2D velocity;
    public Color color;
    private Polygon polygon;
    private List<Vector2D> vertices;

    public Player(Vector2D position, Vector2D velocity,Color color) {

        this.position = position;
        this.velocity = velocity;
        this.color = color;
        setupPolygon();

    }

    public void setupPolygon(){
        this.polygon = new Polygon();
        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.vertices.forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int)vector2D.y));
    }

    public void render(Graphics graphics){
        this.update();
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }

    public void update(){
        this.polygon.reset(); // de xoa 3 dinh addpoint polygon o tren
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2)) // tinh tong tat ca cac vector trong list
                . multiply(1.0f/ (float)this.vertices.size());
        Vector2D translate = this.position.subtract(center);
        this.vertices.stream()
                     .map(vector2D -> vector2D.add(translate)) //tao ra vector moi, duyet qua cac phan tu ->vector se duoc cong them 1 vector khac de tao ra 1 vector moi
                     .forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int)vector2D.y)); //add point o tren 3 dinh , add point nay tao them 3 dinh nua -> dung reset de xoa 3 dinh cu
    }

    public void run() {
        Random random = new Random();
        if (this.position.x > 1024) {
            this.position.x = 0;
            this.position.y = random.nextInt(600);
        } else
        if (this.position.y > 600) {
            this.position.y = 0;
            this.position.x = random.nextInt(1024);
        }
        this.position.add(velocity);

    }
}
