import java.awt.Color;
import java.util.Random;

public class SGRandomWalk {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(0, 0, 300, 300);
        box.draw();
        Ellipse Circle = new Ellipse(50,50,200, 200);
        Circle.fill();
        Circle.draw();  
        Random random = new Random();
        int x = 150;
        int y = 150;
        int steps = 0;
        Ellipse dot = new Ellipse(150,150,10, 10);
        dot.fill();
        // Print initial position
        System.out.println("Initial position: (" + x + ", " + y + ")");

        // Continue the simulation until outside the circle
        while (isInsideCircle(x, y)) {
            int deltaX = random.nextInt(21) - 10;
            int deltaY = random.nextInt(21) - 10;

            x += deltaX;
            y += deltaY;
            steps++;
            dot.translate(deltaX, deltaY);
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!isInsideCircle(x, y)) {
                break;
            }
        }

        // Print the number of steps taken
        System.out.println("Number of steps: " + steps);
    }

    private static boolean isInsideCircle(int x, int y) {
        int distance = (int) Math.sqrt(Math.pow(x - 150, 2) + Math.pow(y - 150, 2));
        return distance <= 100;
    }
}
