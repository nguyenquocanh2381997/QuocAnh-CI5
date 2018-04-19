import java.util.Random;

public class PlayerMove {
    private Vector2D velocity;
    public double angle = 0.0;
    private Random random;

    public PlayerMove(){
        this.velocity = new Vector2D(2,0);
        this.random = new Random();
    }

    public void run(Player player){
        this.velocity.set(this.velocity.rotate(this.angle));
        player.position.addUp(this.velocity);
        if (player.position.x > 1024) {
            player.position.x = 0;
            player.position.y = random.nextInt(600);
        }
        if (player.position.y > 600) {
            player.position.y = 0;
            player.position.x = random.nextInt(1024);
        }
    }
}

