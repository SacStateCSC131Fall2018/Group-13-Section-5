package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //added for possible future use
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
/**
 * The MainInterface class extends JPanel and creates the main interface for
 * Pirex. Creates tabs such as "Search for Documents", "Load Documents", and 
 * "Summarize Documents" which will have their own unique display to help the 
 * user accomplish what it is they will to achieve while using pirex. 
 * 
 * @author Braden Gills 			(Bradengills@csus.edu)
 * @author Catherine Nguyen 		(Catherinenguyen@csus.edu)
 * @author Johnathan Nelson Ento 	(Johnathannelsonento@csus.edu)
 * @author Joseph Libbon 			(Jplibbon@csus.edu)
 * @author Ramiro Bazan				(Bazan@csus.edu)
 * @version 1.4.3.1 05 December 2018
**/

public class MainInterface extends JPanel {
	/**the long for the serial versions UID. **/
	private static final long serialVersionUID = 14L;
	/** the String for the user input that is used to search. **/
	private String querySearch;
	/** the JTextField for the Query Input. **/
	private JTextField queryInput;
	/** the JTextArea for the text area in the middle. **/
	private JTextArea midText;
	/** the JTextArea for the text area for the bottom. **/
	private JTextArea bottomText;
	/** the String for the name of the opus. **/
	private String nameOfOpus;
	/** the JTextField for the text field for the user's entry. **/
	private JTextField textEntry;
	/** the JButton the button for process for the user to press. **/
	private JButton process;
	
	/**CONSTRUCTOR**/
	/** 
	 * Constructor for MainInterface
	 * This constructor will create a JPanel and set its dimensions of
	 * to the borders to desired size. Also it creates tabs for the users 
	 * to use, such as "Search for Documents", "Load Documents", and 
	 * "Summarize Documents".
	**/
	public MainInterface() {
		super(new GridLayout(1, 1));
		Border Border = new EmptyBorder(20,15,15,15);
		setBorder(Border);
		JTabbedPane tabbedPane = new JTabbedPane();
        

        JComponent search = searchTab();
        tabbedPane.addTab("Search for Documents", search);
        
        JComponent load = loadTab();
        tabbedPane.addTab("Load Documents", load);
        
        JComponent summarize = summarizeTab();
        tabbedPane.addTab("Summarize Documents", summarize);
      
		add(tabbedPane);
    	
		
	}
    /**PRIVATE SEARCH_TAB METHOD **/
    /** 
     * The searchTab method creates the components of the
     * "Search for Documents" tab,  which will set its preferred 
     * dimensions and give it a "Clear" button. This method gives 
     * this tab an appealing display for the user's to help them use
     * Pirex effectively.
     *   
     *@return JComponent	The components for the "Search for Documents" tab.
    **/
	private JComponent searchTab() {
		JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(15,10,10,10));
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(5,10,10,10));
        JLabel query = new JLabel();
        query.setText("Query");
        query.setBorder(new EmptyBorder(0,0,0,5));
        topPanel.add(query, BorderLayout.WEST);
        queryInput = new JTextField(15);
        
        Border outline = BorderFactory.createLineBorder(Color.BLACK);
        queryInput.setBorder(BorderFactory.createCompoundBorder(outline, BorderFactory.createEmptyBorder(5, 5, 0, 5)));
        
        topPanel.add(queryInput, BorderLayout.CENTER);
        
        JButton clear = new JButton("Clear");
        
        clear.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		queryInput.setText("");
        	}
        });
        
        topPanel.add(clear, BorderLayout.EAST);
        
        panel.add(topPanel, BorderLayout.NORTH);
        JPanel midDisplay = new JPanel();
        midText = new JTextArea(15, 90);
        midText.setEditable(false);
        midDisplay.add(midText);
        JScrollPane midScroll = new JScrollPane ( midText );
        midText.setWrapStyleWord(true);
        midScroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        midDisplay.add(midScroll);
               
        panel.add(midDisplay);
        
        JPanel bottomDisplay = new JPanel();
        bottomText = new JTextArea(15, 90);
        bottomText.setEditable(false);
        
        bottomDisplay.add(bottomText);
        
        JScrollPane bottomScroll = new JScrollPane ( bottomText );
        bottomScroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        bottomDisplay.add(bottomScroll);
        
        panel.add(bottomDisplay, BorderLayout.SOUTH);
        queryInput.addActionListener(new ActionListener() {						// action listener for query input the method inside will activate on pressing ENTER key
        	public void actionPerformed(ActionEvent e) {
        			
        			querySearch = queryInput.getText();
        			
        			midText.setText("I see that you are searching but the search function is not currently implemented yet "
        					+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n You input: " + querySearch);
        			bottomText.setText("I see that you are searching but the search function is not currently implemented yet.\n you Input: "+ querySearch);
        	}
        });
        
        return panel;
    }
	
	/* Edited loadTap 12/04/18 @9:04pm
	 * Version 1.4.0 Added Framework for Load Document Tab
	 */
    /**PRIVATE LOAD_TAB METHOD **/
    /**
     * The loadTab method creates the components for the "Load Documents tab"
     * and sets the preferred dimensions for the user's entry and the 
     * user's desired output when they want to load a document. 
     * 
     *@return JComponent 	The components for the "Load Documents" tab. 
    **/
	private JComponent loadTab() {
		JPanel panel = new JPanel(false);
        panel.setBorder(new EmptyBorder(15,10,10,10));
        JPanel searchOptions = new JPanel(new BorderLayout());
        
        JPanel textFile = new JPanel(new BorderLayout()); // Load Documents > top line with Text File, text box, and browse
        JLabel text = new JLabel("Text File:");
        text.setBorder(new EmptyBorder(0,0,0,10));
        textFile.add(text, BorderLayout.WEST);
        textEntry = new JTextField(75);
        textEntry.addActionListener(new ActionListener() {	// action listener for query input the method inside will activate on pressing ENTER key
        	public void actionPerformed(ActionEvent e) {
    			
    			process.setEnabled(true);
        	}
        });
        textFile.add(textEntry, BorderLayout.CENTER);
        JButton browse = new JButton("Browse");
        textFile.add(browse, BorderLayout.EAST);
        
        
        JPanel gutenberg = new JPanel(new BorderLayout()) ;	// Load Documents 2nd line with Text File Type: and drop down menu
        gutenberg.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel textFileType = new JLabel("Text File Type:");
        textFileType.setBorder(new EmptyBorder(0, 0, 0, 10));
        gutenberg.add(textFileType, BorderLayout.WEST);
        String[] allowedFiles = {"Project Gutenberg File", ".txt File"};
        JComboBox<String> dropDown = new JComboBox<>(allowedFiles );
        gutenberg.add(dropDown, BorderLayout.CENTER);
        
        JPanel titleAndAuthor = new JPanel(new BorderLayout());
        titleAndAuthor.setBorder(new EmptyBorder(20,0,0,0));
        JPanel justTitle = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Title:");
        title.setBorder(new EmptyBorder(0,0,0,10));
        justTitle.add(title, BorderLayout.WEST);
        JTextField titleDisplay = new JTextField(40);
        justTitle.add(titleDisplay, BorderLayout.EAST);
        JPanel justAuthor = new JPanel(new BorderLayout());
        JLabel author = new JLabel("Author");
        author.setBorder(new EmptyBorder(0,20,0,10));
        justAuthor.add(author, BorderLayout.WEST);
        JTextField authorDisplay = new JTextField(40);
        justAuthor.add(authorDisplay, BorderLayout.EAST);
        
        titleAndAuthor.add(justAuthor, BorderLayout.EAST);
        titleAndAuthor.add(justTitle, BorderLayout.WEST);
        searchOptions.add(titleAndAuthor, BorderLayout.SOUTH);
        searchOptions.add(textFile, BorderLayout.NORTH);
        searchOptions.add(gutenberg, BorderLayout.CENTER);
        panel.add(searchOptions, BorderLayout.NORTH);					// end of top section for load Documents page
        
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBorder(new EmptyBorder(20,10,10,10));
        JPanel processLine = new JPanel(new BorderLayout());
        process = new JButton("Process");
        process.setEnabled(false);
        process.addActionListener(new ActionListener() {						
        	public void actionPerformed(ActionEvent e) {
    																//left blank until we have a way to test if the file is loaded or not
    			
    	}
        });
        processLine.add(process, BorderLayout.WEST);
        bottom.add(processLine, BorderLayout.NORTH);
        JTextArea summaryDisplay = new JTextArea(23, 90);
        JScrollPane scroll = new JScrollPane ( summaryDisplay );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        bottom.add(summaryDisplay, BorderLayout.SOUTH);
        bottom.add(scroll);
        panel.add(bottom, BorderLayout.SOUTH);
        
        return panel;
    }
	
    /**PRIVATE SUMMARIZE_TAB METHOD **/
    /**
     * The summarizeTab method creates and returns the components needed
     * for the "Summarize Documents" tab. This method will also set 
     * the desired dimensions for the components and displays a set text 
     * as a filler until this method is completely implemented. 
     * 
     *@return JComponent	The components for the "Summarize Documents" tab.
    **/
	private JComponent summarizeTab() {
		JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(15,10,10,10));
        JTextArea display = new JTextArea ( 5, 10 );
        display.setText("When fully implemented I will display information on Opuses");
        display.setEditable(false);
        display.setWrapStyleWord(true);
        panel.add(display);
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        panel.add(scroll);
        
        return panel;
    }
	
    /* ACTION_PERFORMED METHOD **/
    /*
     *  The actionPerformed method takes in an ActionEvent and performs the
     *  desired action depending on what is passed into this method.
     * 
     *  @param in	the ActionEvent that determines which action Pirex should perform.
    **/
	/*public void actionPerformed(ActionEvent in) {  //unsure if this method is currently required but added for possible future use.
		String event;
		event = in.getActionCommand();					
	}*/
	
    /** EXPORT METHOD **/
    /**
      *@return String 	the String that the user wishes to export.
    **/
	public String export() {
		return bottomText.getText();
	}
	
    /** GET_NAME_OF_OPUS METHOD **/
    /**
      *@return String	the String of the name of the opus. 
    **/
	public String getNameOfOpus() {
		nameOfOpus = "testingFile";
		return nameOfOpus;
	}
	
    /** GET_QUERY METHOD **/
    /**
     * 
      *@return String	the String that the user enters for ther Search Query.
    **/
	public String getQuery() {
	
		return querySearch;
	}
	
    /** EXPORT METHOD **/
    /**
      *@param query		the String
      *
    **/
	public void setQuery(String query) {
		queryInput.setText(query);
	}
}