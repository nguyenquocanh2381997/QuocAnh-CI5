import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class PolygonRenderer {
        private Color color;
        private Polygon polygon;
        private List<Vector2D> vertices;
        public double angle = 0.0;


        public PolygonRenderer(Color color, Vector2D... vertices) {
            this.color = color;
            this.polygon = new Polygon();
            this.vertices = Arrays.asList(vertices);
            this.vertices.forEach(vector2D -> polygon.addPoint((int)vector2D.x, (int)vector2D.y));
        }

        public void render(Graphics graphics, Vector2D position){
        this.update(position);
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }

    public void update(Vector2D position){
        this.polygon.reset(); // de xoa 3 dinh addpoint polygon o tren
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2)) // tinh tong tat ca cac vector trong list (cong don)
                .multiply(1.0f/ (float)this.vertices.size());

        Vector2D translate = position.subtract(center);
        this.vertices.stream()
                .map(vector2D -> vector2D.rotate(angle)) // xoay dinh
                .map(vector2D -> vector2D.add(translate)) //tao ra vector moi, duyet qua cac phan tu ->vector se duoc cong them 1 vector khac de tao ra 1 vector moi
                .forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int)vector2D.y)); //add point o tren 3 dinh , add point nay tao them 3 dinh nua -> dung reset de xoa 3 dinh cu
    }
}
