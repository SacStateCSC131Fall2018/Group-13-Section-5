package gui;

/**
 * The Pirex is an information retrieval system that individuals can use 
 * to investigate their own texts. This program uses the PirexWindow class 
 * to create a graphic user interface and declares a PirexWindow data type 
 * named window and then constructs window as a new PirexWindow from 
 * PirexWindow.java. which extends JFrame. In Sprint 1, we need to ensure 
 * that we meet the needs of the stake holders and present a valid and 
 * click-able GUI. 
 * 
 * @note for Grader:
 * The first commit for this project can be found here: https://github.com/JLibbon/CSC-131-Group
 * We did not know that the professor shared a repository with us when we 
 * first committed a version to github.
 *  
 * @author Braden Gills
 * @author Catherine Nguyen (catherinenguyen@csus.edu)
 * @author Johnathan Nelson Ento 
 * @author Joseph Libbon 
 * @author Ramiro Bazan
 * @version 1.4.2 04 December 2018
**/

public class Pirex {
	/**
     * The entry point of the application
     *
     * @param args   The command-line arguments
     */
    public static void main(String[] args)
    {
        PirexWindow         window;
        
        
        window = new PirexWindow();
        window.setTitle("Pirex");        
        
        
        
    }
}
