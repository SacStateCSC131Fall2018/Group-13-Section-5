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
 * 
 * @author Braden Gills
 * @author Catherine Nguyen (catherinenguyen@csus.edu)
 * @author Johnathan Nelson Ento 
 * @author Joseph Libbon 
 * @author Ramiro Bazan
 * @version 1.4.0 03 December 2018
**/

public class MainInterface extends JPanel {
	private String querySearch;
	private JTextField queryInput;
	private JTextArea midText;
	private JTextArea bottomText;
	private String nameOfOpus;
	
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
        			
        			midText.setText("I see that you are searching but the search function is not currently implemented yet \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Testing as needed scrollbar");
        			bottomText.setText("I see that you are searching but the search function is not currently implemented yet ");
        	}
        });
        
        return panel;
    }
	
	/* Edited loadTap 12/04/18 @9:04pm
	 * Version 1.4.0 Added Framework for Load Document Tab
	 */
	private JComponent loadTab() {
		JPanel panel = new JPanel(false);
        panel.setBorder(new EmptyBorder(15,10,10,10));
        JPanel searchOptions = new JPanel(new BorderLayout());
        
        JPanel textFile = new JPanel(new BorderLayout()); // Load Documents > top line with Text File, text box, and browse
        JLabel text = new JLabel("Text File:");
        text.setBorder(new EmptyBorder(0,0,0,10));
        textFile.add(text, BorderLayout.WEST);
        JTextField textEntry = new JTextField(75);
        textFile.add(textEntry, BorderLayout.CENTER);
        JButton browse = new JButton("Browse");
        textFile.add(browse, BorderLayout.EAST);
        
        
        JPanel gutenberg = new JPanel(new BorderLayout()) ;	// Load Documents 2nd line with Text File Type: and drop down menu
        gutenberg.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel textFileType = new JLabel("Text File Type:");
        textFileType.setBorder(new EmptyBorder(0, 0, 0, 10));
        gutenberg.add(textFileType, BorderLayout.WEST);
        String[] allowedFiles = {"Project Gutenberg File", ".txt File"};
        JComboBox dropDown = new JComboBox(allowedFiles );
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
        JButton process = new JButton("Process");
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
	
	public void actionPerformed(ActionEvent in) {  //unsure if this method is currently required but added for possible future use.
		String event;
		event = in.getActionCommand();					
	}

}
