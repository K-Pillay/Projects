import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//create a class for patients




class patientRecords {
    private String patientName;
    private String patientSurname;
    private int patientAge;
    private String medicalHistory;

    //Create patient object that takes the above variables as parameters and declare new objects
    public patientRecords(String patientName, String patientSurname, int patientAge, String medicalHistory)
    {
        this.patientName=patientName;
        this.patientSurname=patientSurname;
        this.patientAge=patientAge;
        this.medicalHistory=medicalHistory;
    }

    //use getter to obtain the details of the patients


    public String getPatientName() {
        return patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    // way to display all information neatly on screen

    @Override
    public String toString() {
        return patientName + " " + patientSurname + " " + " Age: " +patientAge + "Medical History:" + medicalHistory;
    }
}







public class hospitalManagementSystem extends JFrame implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new hospitalManagementSystem().setVisible(true);
            }
        });
    }


  //Formatting the GUI display
    private JTextField searchField;
    private JList<patientRecords> patientRecordstList;
    private DefaultListModel<patientRecords> patientRecordsListModel;

    //will be using an array list to store the patent records
    private ArrayList<patientRecords> patientRecordsArrayList;


    //Graphical user Interface
    public hospitalManagementSystem() {

        setTitle("Search and Sort App");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Search ");
        JButton searchButton = new JButton("Search ");
        searchButton.addActionListener(this);
        searchField = new JTextField(20);
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);

        //Create button to sort patient by name and age
        JButton sortByAgeButton = new JButton("Sort by Age");
        sortByAgeButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    sortPatientsByAge();
            }
        });
        topPanel.add(sortByAgeButton);

        JButton sortByNameButton = new JButton("Sort by Name");
        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortPatientsByName();
            }
        });
        topPanel.add(sortByNameButton);



        // setting up of objects to display the patient records.
        patientRecordstList = new JList<>();
        patientRecordsListModel = new DefaultListModel<>();
        patientRecordstList.setModel(patientRecordsListModel);

        JScrollPane scrollPane = new JScrollPane(patientRecordstList);


//placing the components on screen
        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);


        //Adding names of patients from question into an array list
        patientRecordsArrayList = new ArrayList<>();
        patientRecordsArrayList.add(new patientRecords("Gomolemo", "Mbaka", 25, "Type 2 Diabetes "));
        patientRecordsArrayList.add(new patientRecords("Thapelo", "Gama", 30, "Allergies to Pennicillin "));
        patientRecordsArrayList.add(new patientRecords("John", "Smith", 22, "No significant medical history "));
        patientRecordsArrayList.add(new patientRecords("Alice", "Botha", 33, " Allergies to Pennicillin "));
        patientRecordsArrayList.add(new patientRecords("Karabo", "Molefe", 23, "Type 2 Diabetes "));
        patientRecordsArrayList.add(new patientRecords("Elsa", "Bella", 34, "No significant medical history "));
        patientRecordsArrayList.add(new patientRecords("Lerato", "Nkosi", 35, "Hypertension "));
        patientRecordsArrayList.add(new patientRecords("Venod", "Pillay", 44, "Allergies to Pennicillin "));

        //call method to update the patient list of the patient records.
        updatePatientList(patientRecordsArrayList);
    }



    //method to update patient list
    private void updatePatientList(ArrayList<patientRecords> Patients) {
        patientRecordsListModel.clear();
        for (patientRecords patient : Patients) {
            patientRecordsListModel.addElement(patient);
        }
    }

    private void sortPatientsByAge() {
        Collections.sort(patientRecordsArrayList, new Comparator<patientRecords>() {
            @Override
            public int compare(patientRecords p1, patientRecords p2) {
                return Integer.compare(p1.getPatientAge(), p2.getPatientAge());
            }
        });
        updatePatientList(patientRecordsArrayList);


    }
    private void sortPatientsByName() {
        Collections.sort(patientRecordsArrayList, new Comparator<patientRecords>() {
            @Override
            public int compare(patientRecords p1, patientRecords p2) {
                return p1.getPatientName().compareToIgnoreCase(p2.getPatientName());
            }
        });
        updatePatientList(patientRecordsArrayList);
    }




    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String searchText = searchField.getText().trim();
            if (!searchText.isEmpty()) {
                ArrayList<patientRecords> filteredList = new ArrayList<>();
                for (patientRecords patient : patientRecordsArrayList) {
                    if (patient.getPatientName().toLowerCase().contains(searchText.toLowerCase()) ||
                            patient.getPatientSurname().toLowerCase().contains(searchText.toLowerCase())) {
                        filteredList.add(patient);
                    }
                }
                updatePatientList(filteredList);
            } else {
                updatePatientList(patientRecordsArrayList);
            }
        }
    }
}





