import javafx.scene.Scene;
import java.awt.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javax.imageio.ImageIO;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

public class Photo extends UI{
    private BufferedImage screenshot(){
        try{
            //Gets the default javafx graphic & default bounds
            GraphicsDevice graphics = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            Rectangle bounds = graphics.getDefaultConfiguration().getBounds();
            //Sets width and height bounds
            int width = bounds.width;
            int height = bounds.height;
            //Robot method captures the screenshot
            Robot robot = new Robot();
            //returns robot method as an image
            return robot.createScreenCapture(bounds);
        } catch(HeadlessException | AWTException e){
            //returns null if no screen to capture
            return null;
        }//End of catch
    }//End of screenshot method

    public void start(Stage stage){
        //Creates a scene to take the screenshot
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 280, 480);
        //Title of the scene we just created
        stage.setTitle("Screenshot of your Tasklist");
        stage.setScene(scene);
        //Places in the center of the scene & displays
        stage.centerOnScreen();
        stage.show();
        BufferedImage screenshot = screenshot();
        if (screenshot != null){
            saveScreenshot(screenshot, "screenshot.png");
        }

    }//End of start method

    //Saving the screenshot
    private void saveScreenshot(BufferedImage screenshot, String filename){
        try{
            ImageIO.write(screenshot(), "png", new File(filename));
            System.out.println("Saved screenshot to: " + filename);
        }catch(Exception e){
            e.printStackTrace();
        }//End catch
    }//Close saveScreenshot class
}//End of Photo class
