import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    private Star star;
    private Circle circle; // enemy

    private BufferedImage backBuffered;
    private Graphics graphic;

    private List<Star> stars;
    private List<Circle> circles;

    private Player player;

    private Random random;
    private int count;
    private BackGround backGround;



    public GameCanvas() {
        //SetSize

        this.setSize(1024, 600);
        this.stars = new ArrayList<>();
        this.circles = new ArrayList<>();
        this.setupBackBuffered();
        this.setVisible(true);
        this.backGround = new BackGround(0, 0 , Color.black);
        random = new Random();

    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphic = this.backBuffered.getGraphics();
    }


    @Override
    protected void paintComponent(Graphics g) {
        //back buffered de lat phia trc
        g.drawImage(this.backBuffered,0, 0,null);
    }

    public void renderAll(){
        this.backGround.render(this.graphic);

        this.stars.forEach(star -> star.render(this.graphic));
        this.circles.forEach(circle -> circle.render(graphic));
        this.player.render(this.graphic);

        this.repaint();
    }



    public void runAll(){
        //cap nhat tat ca moi thu
        createStar();
        this.stars.forEach(star -> star.run());

        this.createCircle();
        this.circles.forEach(circle -> circle.run());

        this.createPlayer();
        this.player.run();
    }

    public void createStar() {
        if (count == 30) {
             this.star = new Star(
                     new Vector2D(1024, this.random.nextInt(700)), // position
                     this.loadImage("resources-rocket-master/resources/images/star.png"),
                     15, 15,
                     new Vector2D(this.random.nextInt(2) + 1, 0)
                   );
            stars.add(star);
            this.count = 0;
        } else {
            count++;
        }

    }

    public void createCircle() {
        if (count == 30) {
            this.circle = new Circle(
                    new Vector2D(this.random.nextInt(1024),this.random.nextInt(700)), //cho enemy xuat hien ngau nhien
                    this.loadImage("resources-rocket-master/resources/images/circle.png"),
                    15 , 15,
                    new Vector2D(this.random.nextInt(2) + 1,0));
            this.circles.add(circle);
            this.count = 0;
        }else{
            this.count +=1;
        }
    }

    private void createPlayer(){
        this.player = new Player(
                new Vector2D(random.nextInt(1024),random.nextInt(600)),
                new Vector2D(this.random.nextInt(2) + 1,0),
                Color.RED
        );
    }

    private  BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
