import java.awt.*;

public class BackGround {
    public int x;
    public int y;
    public Color color;

    public BackGround(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void render(Graphics graphic) {
        graphic.setColor(this.color);
        graphic.fillRect(x,y , 1024, 600);
    }
}
