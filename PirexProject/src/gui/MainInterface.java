package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //added for possible future use
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
 

public class MainInterface extends JPanel {
	
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
        
        return panel;
    }
	private JComponent loadTab() {
        JPanel panel = new JPanel(false);
        panel.setBorder(new EmptyBorder(15,10,10,10));
        
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
