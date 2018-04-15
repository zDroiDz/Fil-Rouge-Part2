package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.DescripteurImage;


public class ControlFiles {
	
	public ControlFiles()
	{
		
	}
	
	public String recupTxtOrXMLFile()
	{
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select a ressource");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt and xml files", "txt", "xml");
		jfc.addChoosableFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile().getPath();
		}
		return null;
	}
	
	public String recupImgFile()
	{
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select an image");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg and png files", "jpg", "png");
		jfc.addChoosableFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile().getPath();
		}
		
		return null;
	}
	
	public void drawAverageColor(DescripteurImage descripteurImage)
	{
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(descripteurImage.getComposante(0), descripteurImage.getComposante(1), descripteurImage.getComposante(2)));
        f.setSize(new Dimension(300, 200));
        f.setVisible(true);
        /*affichage d'une frame de la couleur moyenne*/
	}
	
	public void drawImage(String path)
	{
	        BufferedImage image;
			try {
				image = ImageIO.read(new File(path));
				JFrame frame = buildFrame(image.getWidth(),image.getHeight());
				
				JPanel pane = new JPanel() {
		            @Override
		            protected void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                g.drawImage(image, 0, 0, null);
		            }
		        };
		        
		        frame.add(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static JFrame buildFrame(int width,int height) {
        JFrame frame = new JFrame();
        frame.setSize(width+19, height+48);
        frame.setVisible(true);
        frame.setResizable(false);
        return frame;
    }
	
	public void displayText(String path)
	{
		
	}

}