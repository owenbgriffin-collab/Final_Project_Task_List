import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Screenshot {
    //Class runs the screenshot code
    public static BufferedImage takeScreenshot(Component component){
        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        component.paint(image.getGraphics());
        return image;
    }
    public static void main(String[] args){
        //creates a screenshot button as well as setting the scale if the screenshot
        Runnable r = new Runnable() {
        public void run() {
        final JFrame frame = new JFrame("Screenshot");
        JMenuItem screenshot = new JMenuItem ("Screenshot");
        screenshot.setAccelerator(
             KeyStroke.getKeyStroke(KeyEvent.VK_0,
             InputEvent.CTRL_DOWN_MASK));
                screenshot.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent ae) {
                            BufferedImage img = takeScreenshot(
                                frame.getContentPane());
                                JOptionPane.showMessageDialog(
                                    null,
                                    new JLabel(
                                    new ImageIcon(
                                        img.getScaledInstance(
                                            img.getWidth(null)/2,
                                            img.getHeight(null)/2,
                                            Image.SCALE_SMOOTH
                                            ))));
                                try{
                                    ImageIO.write(
                                            img,
                                            "png",
                                            new File("screenshot.png"));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                );
            }
        };
    }

}
