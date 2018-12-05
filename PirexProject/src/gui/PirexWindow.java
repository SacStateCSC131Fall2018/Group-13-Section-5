package gui;

//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

/**
 * The PirexWindow class extends JFrame and implements ActionListeners to 
 * create a GUI that encompasses a menu bar, menu bar items , and actions 
 * that go with these items to satisfy the needs of the stake holders. This 
 * class will use a private method to create a new JFrame called frame, 
 * giving it the display name of "Pirex", setting the image icon for the GUI,
 * and the JMenuBar along with its JMenuItems. This class also has a public 
 * method that allows the menu items to perform an action when activated.
 * 
 * @author Braden Gills
 * @author Catherine Nguyen (catherinenguyen@csus.edu)
 * @author Johnathan Nelson Ento 
 * @author Joseph Libbon 
 * @author Ramiro Bazan
 * @version 1.4.2 04 December 2018
**/

public class PirexWindow extends JFrame implements  ActionListener {
	private String savedQuery;
	private MainInterface main;
	
	 /**CONSTRUCTOR**/
	 /** 
	 *  Constructor for the PirexWindow.
	 *  This constructor sets the component's locale property to be returned 
	 *  by JComponent.getDefaultLocale. Also, this constructor calls the 
	 *  private method setupLayout(). 
	 **/
    public PirexWindow()
    {
        super();
        setupLayout();
    }
    /**PRIVATE SETUP_LAYOUT METHOD **/
    /**
     * The setupLayout method sets the default close operations to exit on close. 
     * Similar to any web browser when a user presses the "close" button the program
     * will close. This method sets the Icon to the preferred image. It then
     * creates a new MainInterface names main and adds that main to the JFrame plus 
     * a JmenuBar named menuBar. 
     **/
    private void setupLayout() {
    	/** Creates JFrame("Pirex") named frame and sets default close operation to exit on close**/
    	JFrame frame;
    	frame = new JFrame("Pirex");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	/** Sets The Icon/Logo for Pirex**/
    	ImageIcon img = new ImageIcon("PirexProject/src/gui/pirex.png");
        frame.setIconImage(img.getImage());
        
    	/** Sets main equal to a new MainInterface**/
        main = new MainInterface();
        
        /**Adds main to frame and creates a JMenuBar named menuBar**/
        frame.add(main);
        JMenuBar menuBar = new JMenuBar();
        
        /**Creates a Jmenu under the name "File" and adds JMenuItem "Open**/
    	JMenu fileMenu = new JMenu("File");						//File drop down window
    	JMenuItem openMenuItem = new JMenuItem("Open");			
    	openMenuItem.addActionListener(this);	
    	fileMenu.add(openMenuItem);
    	
    	JMenuItem exportMenuItem = new JMenuItem("Export");		
    	exportMenuItem.addActionListener(this);
    	fileMenu.add(exportMenuItem);
    	
    	JMenuItem saveQueryMenuItem = new JMenuItem("Save Query");	//saves a search query
    	saveQueryMenuItem.addActionListener(this);
    	fileMenu.add(saveQueryMenuItem);
    	
    	JMenuItem loadQueryMenuItem = new JMenuItem("Load Query");
    	loadQueryMenuItem.addActionListener(this);
    	fileMenu.add(loadQueryMenuItem);
    	
    	JMenuItem exitMenuItem = new JMenuItem("Exit");	//exits eclipse
    	exitMenuItem.addActionListener(this);
    	fileMenu.add(exitMenuItem);
    	
    	
    	JMenu optionsMenu = new JMenu("Options");				//Options Drop down window
    	JMenuItem sourcesMenuItem = new JMenuItem("Sources");
    	sourcesMenuItem.addActionListener(this);
    	optionsMenu.add(sourcesMenuItem);
    	
    	JMenuItem documentsMenuItem = new JMenuItem("Documents");
    	documentsMenuItem.addActionListener(this);
    	optionsMenu.add(documentsMenuItem);
    	
    	
    	JMenu helpMenu = new JMenu("Help");						//Help drop down window
    	JMenuItem indexMenuItem = new JMenuItem("Index");
    	indexMenuItem.addActionListener(this);
    	helpMenu.add(indexMenuItem);
    	
    	JMenuItem aboutMenuItem = new JMenuItem("About");
    	aboutMenuItem.addActionListener(this);
    	helpMenu.add(aboutMenuItem);
    	
    	
    	menuBar.add(fileMenu);
    	menuBar.add(optionsMenu);
    	menuBar.add(helpMenu);
    	
    	frame.setPreferredSize(new Dimension(1080,720));
    	frame.setJMenuBar(menuBar);
    	
    	frame.pack();
    	frame.setVisible(true);
        
        
    	
    }
    public void actionPerformed(ActionEvent in)
    {
    	String event;
		event = in.getActionCommand();
		if(event == "Open") {
			try {
				Runtime.getRuntime().exec("explorer.exe /select,"); //Opens file explorer on Windows  operating system
			} catch (IOException e) {
				System.out.print("incompatible operating system");
				e.printStackTrace();
			}
			System.out.println("Open pressed");
		} 
		else if(event == "Export") {
			try {
				File file = new File(main.getNameOfOpus() + ".txt");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(main.export());
				fileWriter.flush();
				fileWriter.close();
				
				JFrame success = new JFrame();
				success = new JFrame("Pirex");
		    	success.setPreferredSize(new Dimension(400,100));
		    	JLabel say = new JLabel();
		    	say.setHorizontalAlignment(SwingConstants.CENTER);
		        say.setText("Successfully saved to "+ main.getNameOfOpus() + ".txt");
		    	success.add(say);
		    	success.pack();
		    	success.setVisible(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else if(event == "Save Query") {
			savedQuery = main.getQuery();
			JFrame success = new JFrame();
			success = new JFrame("Pirex");
	    	success.setPreferredSize(new Dimension(200,100));
	    	JLabel say = new JLabel();
	    	say.setHorizontalAlignment(SwingConstants.CENTER);
	        say.setText("Successfully saved Query");
	    	success.add(say);
	    	success.pack();
	    	success.setVisible(true);
		
		}
		else if(event == "Load Query") {
			System.out.println("Load Query pressed");
		}
		else if(event == "Exit") {                 //Exits the Program
			System.exit(0);
		}
		else if(event == "Sources") {
			System.out.println("Sources pressed");
		}
		else if(event == "Documents") {
			System.out.println("Documents pressed");
		}
		else if(event == "Index") {
			ProcessBuilder IndexFile = new ProcessBuilder("Notepad.exe","Index.txt"); 
			
			try {
				IndexFile.start();
			} catch (IOException e) {
				System.out.println("Failure to open File");
				e.printStackTrace();
			}
			System.out.println("Index pressed");
		}
		else if(event == "About") {
			ProcessBuilder AboutFile = new ProcessBuilder("Notepad.exe","About.txt"); //Opens About.txt file in Notepad on windows pc
			
			try {
				AboutFile.start();
			} catch (IOException e) {
				System.out.println("Failure to open File");
				e.printStackTrace();
			}
			System.out.println("About pressed");
		}
			
    }
}