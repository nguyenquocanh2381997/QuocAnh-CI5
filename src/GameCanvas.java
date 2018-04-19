import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphic;

    private List<Star> stars;
    private List<Enemy> enemies;

    public Player player;

    private Random random;
    private int count = 0;
    private int countEnemy = 0;
    private BackGround backGround;



    public GameCanvas() {
        //SetSize

        this.setSize(1024, 600);
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();

        this.setupBackBuffered();
        this.backGround = new BackGround(0, 0 , Color.black);

        this.player = new Player();
        this.player.position.set(200,200);

        random = new Random();
        this.setVisible(true);
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
//        this.enemy.render(this.graphic);
        this.enemies.forEach(enemy -> enemy.render(this.graphic));
        this.player.render(this.graphic);
        this.repaint();
    }



    public void runAll(){
        //cap nhat tat ca moi thu
        createStar();
        this.stars.forEach(star -> star.run());

        this.player.run();
        this.createrEnemy();
        this.runEnemy();

//        this.enemy.run();
//        this.enem.velocity.set(this.player.position.subtract(this.enemy.position).normalize()).multiply(1.5f);
    }

    public void createStar() {
        if (this.count == 30) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(2)+1 ,0);
            this.stars.add(star);
            this.count = 0;
        } else {
            count += 1;
        }
    }

    public void createrEnemy(){
        if (this.countEnemy == 50){
           Enemy enemy = new Enemy();
           enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
           enemy.velocity.set(this.random.nextInt(2)+1 ,0);
           this.enemies.add(enemy);
           this.countEnemy = 0;
        }else {
            countEnemy += 1;
        }
    }

    public void runEnemy(){
        this.enemies.forEach(enemy -> enemy.velocity.set(
                player.position
                        .subtract(enemy.position)
                        .normalize()
        ).multiply(2));
        this.enemies.forEach(enemy -> enemy.run());
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


