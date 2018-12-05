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
 * @author Braden Gills 			(Bradengills@csus.edu)
 * @author Catherine Nguyen 		(Catherinenguyen@csus.edu)
 * @author Johnathan Nelson Ento 	(Johnathannelsonento@csus.edu)
 * @author Joseph Libbon 			(Jplibbon@csus.edu)
 * @author Ramiro Bazan				(Bazan@csus.edu)
 * @version 1.4.3 05 December 2018
**/

public class PirexWindow extends JFrame implements  ActionListener {
	
	/** the String that is saved when the user presses the "Save Query" **/
	private String savedQuery;
	/** the MainInterface that is created using the MainInterface class **/
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
     * will close. This method sets the Icon to the preferred image. It also creates
     * a menu bar, each having their own items and those items have action listeners. 
     * Lastly, this method sets its preferred dimensions, sets it to be packed, and 
     * makes sure its visible for users to see.
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
    	
    	/**Adds JMenuItem "Export" into JMenu "File"**/
    	JMenuItem exportMenuItem = new JMenuItem("Export");		
    	exportMenuItem.addActionListener(this);
    	fileMenu.add(exportMenuItem);
    	
    	/** Adds JMenuItem "Save Query" into JMenu "File" **/
    	JMenuItem saveQueryMenuItem = new JMenuItem("Save Query");	//saves a search query
    	saveQueryMenuItem.addActionListener(this);
    	fileMenu.add(saveQueryMenuItem);
    	
    	/** Adds JMenuItem "Load Query" into JMenu "File" **/
    	JMenuItem loadQueryMenuItem = new JMenuItem("Load Query");
    	loadQueryMenuItem.addActionListener(this);
    	fileMenu.add(loadQueryMenuItem);
    	
    	/** Adds JMenuItem "Exit" into JMenu "File" **/
    	JMenuItem exitMenuItem = new JMenuItem("Exit");	//exits eclipse
    	exitMenuItem.addActionListener(this);
    	fileMenu.add(exitMenuItem);
    	
    	/** Creates a Jmenu under the name "Options" and adds JMenuItem "Sources" **/
    	JMenu optionsMenu = new JMenu("Options");				//Options Drop down window
    	JMenuItem sourcesMenuItem = new JMenuItem("Sources");
    	sourcesMenuItem.addActionListener(this);
    	optionsMenu.add(sourcesMenuItem);
    	
    	/** Adds JMenuItem "Documents" into JMenu "Options" **/
    	JMenuItem documentsMenuItem = new JMenuItem("Documents");
    	documentsMenuItem.addActionListener(this);
    	optionsMenu.add(documentsMenuItem);
    	
    	/** Creates a Jmenu under the name "Help" and adds JMenuItem "Index" **/
    	JMenu helpMenu = new JMenu("Help");						//Help drop down window
    	JMenuItem indexMenuItem = new JMenuItem("Index");
    	indexMenuItem.addActionListener(this);
    	helpMenu.add(indexMenuItem);
    	
    	/** Adds JMenuItem "About" into JMenu "Help" **/
    	JMenuItem aboutMenuItem = new JMenuItem("About");
    	aboutMenuItem.addActionListener(this);
    	helpMenu.add(aboutMenuItem);
    	
    	/** This Adds "File", "Options", and "Help" into the menu bar of the Frame **/
    	menuBar.add(fileMenu);
    	menuBar.add(optionsMenu);
    	menuBar.add(helpMenu);
    	
    	/** Sets the Dimensions for the frame and adds the Menu bar **/
    	frame.setPreferredSize(new Dimension(1080,720));
    	frame.setJMenuBar(menuBar);
    	
    	/** Sets the window to be pack and sets its to be visible to users **/
    	frame.pack();
    	frame.setVisible(true);
    }
    
    /** ACTION_PERFORMED METHOD **/
    /**
     *  The actionPerformed method takes in an ActionEvent and performs the
     *  desired action depending on what is passed into this method.
     * 
     *  @param in	the ActionEvent that determines which action Pirex should perform.
    **/
    public void actionPerformed(ActionEvent in)
    {
    	/** Declares a String event and sets it equal to the command string associated with this action. **/
    	String event;
		event = in.getActionCommand();
		
		/** 
		 * If the event is equal to "Open", Pirex will try to open file explorer on 
		 * Windows Operating System and if it catches and exception Pirex will output 
		 * "incompatible operating system". Lastly, Pirex will output "Open Pressed"
		 * notifying to the user that it has been pressed.   
	    **/
		if(event == "Open") {
			try {
				Runtime.getRuntime().exec("explorer.exe /select,"); //Opens file explorer on Windows  operating system
			} catch (IOException e) {
				System.out.print("incompatible operating system");
				e.printStackTrace();
			}
			System.out.println("Open pressed");
		} 
		/** If the event is equal to "Export", Pirex will create a text file with
		 *  with the name of the opus from MainInterface. Also, Pirex will create
		 *  a JFrame notifying the user that they have successfully save to that 
		 *  certain text file.  
		**/
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
		/** 
		 * If the event is equal to "Save Query", Pirex will create a new JFrame, 
		 * set its preferred dimensions, its alignment to be centered, 
		 * text to say "Successfully saved Query", and for it all to be visible to the 
		 * user. 
		**/
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
		/** If the event is equal to "Load Query", Pirex will load the query you saved and then it 
		 * will create a JFrame that will print "Successfully loaded Query" to notify the user. 
	    **/
		else if(event == "Load Query") {
			main.setQuery(savedQuery);
			JFrame success = new JFrame();
			success = new JFrame("Pirex");
	    	success.setPreferredSize(new Dimension(200,100));
	    	JLabel say = new JLabel();
	    	say.setHorizontalAlignment(SwingConstants.CENTER);
	        say.setText("Successfully loaded Query");
	    	success.add(say);
	    	success.pack();
	    	success.setVisible(true);
		}
		/** If the event is equal to "Exit" Pirex will exit itself **/
		else if(event == "Exit") {                 //Exits the Program
			System.exit(0);
		}
		/** If the event is equal to "Sources" Pirex will print "Sources pressed" **/
		else if(event == "Sources") {
			System.out.println("Sources pressed");
		}
		/** If the event is equal to "Documents" Pirex will print "Documents pressed" **/
		else if(event == "Documents") {
			System.out.println("Documents pressed");
		}
		/** If the event is equal to "Index", Pirex will open a Index.txt using
		 * NotePad. Then it will try to start that file and if it catches an exception
		 * Pirex will output "Failure to open File". Lastly, it will print "Index pressed"
		 * to notify the user that it has been pressed.  
	    **/
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
		/** If the event is equal to "About", Pirex will open an About.txt file
		 * in Notepad on windows PC. Then it will try to start the process and if
		 * it fails it will catch an exception and output, "Failure to open File".
		 * After, Pirex will output "About pressed" to notify the user that it has
		 * been pressed.
		**/
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