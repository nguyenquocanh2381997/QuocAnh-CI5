import javax.swing.*;

public class GameWindow extends JFrame {
    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow(){
        //set size cho window
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.setVisible(true); //cho phep window duoc hien thi
    }
    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime(); // tinh nano giay
            if (currentTime - lastTime >= 17_000_000){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
