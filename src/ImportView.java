import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Responsible for creating a panel that searches for an import file
 */
public class ImportView extends JPanel {
    //Attributes
    private DatabaseImport importingDatabase;//Used to extract data from an import JSON file
    private Database newDatabase;//Database that stores data extracted from JSON file
    String filepath;//String that stores inputted filepath
    String prompt;//String that holds prompt added to the panel
    final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();//ArrayList that stores listeners

    //Constructors
    /**
     * Constructor for ImportView panel
     */
    public ImportView(){
        //Setting up panel view/layout
        newDatabase = new Database();

        this.setLayout(new BorderLayout());
        JTextField filepathField = new JTextField(20);
        filepath = "";
        prompt = "Enter filepath here";
        filepathField.setText(prompt);

        JButton searchButton = new JButton("Search");

        this.add(filepathField, BorderLayout.NORTH);
        this.add(searchButton, BorderLayout.SOUTH);

        this.setSize(300, 300);//Setting size of frame
        this.setVisible(true);//we want to see the frame right?

        //Searches for inputted filepath
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Saving input filepath
                filepath = filepathField.getText();

                //Detects if user is trying to search filepath that is not empty or just the prompt
                if(!(filepath.equals(prompt)) && !(filepath.equals(""))){

                    //Attempts to extract data from input file
                    importingDatabase = new DatabaseImport(filepath);
                    importingDatabase.importDatabase(newDatabase.getProductCatalogue(), newDatabase.getPasswords());

                    //If valid, listeners are notified
                    if(importingDatabase.wasImported()){
                        ChangeEvent importable = new ChangeEvent(this);

                        for(ChangeListener listener: listeners){
                            listener.stateChanged(importable);
                        }
                    }
                    //If not, user is notified that filepath was not valid
                    else{
                        JOptionPane.showMessageDialog(null, "File was not found!", "Filepath Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
    }

    //Sets
    /**
     * Adds a listener to the class
     */
    public void addChangeListener(ChangeListener newListener){
        listeners.add(newListener);
    }

    /**
     * Clears the database that stores the contents from the importation process
     */
    public void clearNewImport(){
        newDatabase = new Database();
    }

    //Gets
    /**
     * Gets the database that stores the contents from the importation process
     */
    public Database getNewImport(){
        return newDatabase.clone();
    }
}
