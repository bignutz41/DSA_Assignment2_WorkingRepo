/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author xhu
 */
public class NoiseRemoving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser imageFileChooser = new JFileChooser(new File("."));
        int stateImageFileChooser = imageFileChooser.showOpenDialog(null);
        
        JFrame frame = new JFrame("Noise Remover");
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(stateImageFileChooser == JFileChooser.APPROVE_OPTION)
        {
            String fileName = imageFileChooser.getSelectedFile().getPath();
            ImageProcess ip = new ImageProcess(fileName);
            ip.cleanNoise();
            ip.save(fileName + "_cleaned.jpg");
        }
    }
    
}
