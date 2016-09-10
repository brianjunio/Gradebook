/*Brian Junio
  Gradebook Project CSc 20*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gradebook implements KeyListener, ActionListener{
   static CardLayout contentPaneLayout;	
   static JFrame frame = new JFrame();
   static JButton newButton = new JButton();
   static JButton loadButton = new JButton();
   static JButton stuButton = new JButton();
   static JButton scoreButton = new JButton();
   static JButton sortButton = new JButton();
   static JButton viewButton = new JButton();
   static JButton saveButton = new JButton();
   static JButton exitButton = new JButton();
   static JButton createButton = new JButton();
   static JButton cancelButton = new JButton("Cancel");
   static JButton lCancelButton = new JButton("Cancel");
   static JButton sBackButton = new JButton("Back to Top Menu");
   static JButton sorSortButton = new JButton();
   static JButton sorTopButton = new JButton();
   static JButton vTopButton = new JButton();
   static JButton iTopButton = new JButton();
   static JButton iSave = new JButton();
   static JButton vDelete = new JButton();
   static JRadioButton iD = new JRadioButton();
   static JRadioButton name = new JRadioButton();
   static JTextField stuField = new JTextField();
   static JTextField classField = new JTextField();
   static JTextField iSSNText = new JTextField();
   static JTextField iNameText = new JTextField();
   static JTextField cClassField = new JTextField();
   static JTextField iAgeField = new JTextField();
   static JTextField sLabNumField = new JTextField();
   static JTextField sScoreForField = new JTextField();
   static JComboBox iGenderBox = new JComboBox();
   static JComboBox iLevelBox = new JComboBox();
   static JScrollPane scrollPane = new JScrollPane();
   static JTable gradeTable = new JTable();
   static String G[] = {"Male", "Female"};
   static String L[] = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
   static String columnName[] = {"ID", "Name", "Level", "Gender", "Age", "Lab 1", "Lab 2",
   "Lab 3", "Lab 4", "Lab 5", "Lab 6", "Lab 7", "Lab 8", "Lab 9", "Lab 10"};
   static String data[][] = new String[9][15];
   static int i = 0;
   static int j = 0;
   static int k = 0;
   static int l = 0;
   static int selection = 0;
        // static Container contentPane = frame.getContentPane();
   static JPanel contentPane;
   static boolean check;
   
   
   public void actionPerformed(ActionEvent e){
   	Object source = e.getSource();
	gradeTable = new JTable(data, columnName);
	JScrollPane tmp = new JScrollPane(gradeTable);
    if(source == newButton){ 
        contentPaneLayout.show(contentPane, "Create a New Class");
     	return;
        }

    if(source == scoreButton){
    	contentPaneLayout.show(contentPane, "Enter Lab Scores");
    	return;
    	}
    if(source == sortButton){
    	contentPaneLayout.show(contentPane, "Sort Students");
    	return;
    	}
    if(source == iSave){
   		data[i][0] = iSSNText.getText();
   		data[i][1] = iNameText.getText();
   		data[i][2] = (String)iGenderBox.getSelectedItem();
   		data[i][3] = iAgeField.getText();
   		data[i][4] = (String)iLevelBox.getSelectedItem();
   		iSSNText.setText("");
   		iNameText.setText("");
   		iAgeField.setText("");
   		iGenderBox.setSelectedIndex(0);
   		iLevelBox.setSelectedIndex(0);
   		i++;
   		stuField.setText("" + i);
   		return;
    	}
    	
    if(source == cancelButton || source == lCancelButton || source == sBackButton || 
    source == sorTopButton || source == vTopButton || source == iTopButton){
    	contentPaneLayout.show(contentPane, "Top Level Card");
    	return;
    	}
    if(source == loadButton){
    	contentPaneLayout.show(contentPane, "Load Students from Save File");
    	return;
    	}
    if(source == viewButton){
    	scrollPane.setViewport(tmp.getViewport());
    	contentPaneLayout.show(contentPane, "View Students");
    	return;
    	}
    if(source == exitButton || source == saveButton){
    	frame.dispose();
    	return;
    	}
    if(source == createButton){
    	String newClassName = cClassField.getText();
    	cClassField.setText("");
    	classField.setText(newClassName);
    	
    	return;
    	}
    	 
    if(source == stuButton){
    	contentPaneLayout.show(contentPane, "Student Information");
    	return;
    	}
    	
    if(source == vDelete){
    	selection = gradeTable.getSelectedRow();
    	for(int l = 0; l <= 14; l++){
    		data[0][l] = "" + selection;
    		}
    	}
   }
   
   public void keyTyped(KeyEvent e){
    
   }
   
   public void keyPressed(KeyEvent e){
   	if(e.getKeyCode() == KeyEvent.VK_ENTER){
   		i = 0;
   		j = Integer.parseInt(sLabNumField.getText());
   		k = Integer.parseInt(sScoreForField.getText());
   		data[i][j+4] = "" + k;
   		sLabNumField.setText("");
   		sScoreForField.setText("");
   		}
   		
   }
   
   public void keyReleased(KeyEvent e){
   	
   }
   

   public static void main(String args[]){
      frame = new JFrame("CSc 20 Gradebook");
      JLabel label = new JLabel("<html><font size=5><b>Use The Buttons Below to Manage Students</b></html>", JLabel.CENTER);
      frame.getContentPane().add(label);
      contentPane = (JPanel)frame.getContentPane();
      contentPane.setLayout(contentPaneLayout = new CardLayout());
      
//Front window
      JPanel newCard = new JPanel(new BorderLayout());
      newCard.add(label, BorderLayout.NORTH);
      ActionListener AL = new Gradebook();
      KeyListener KL = new Gradebook();
	  
      JPanel middlePanel = new JPanel(new FlowLayout());
      
	  JLabel classlabel = new JLabel("Class Name:",JLabel.LEFT);
	  classField = new JTextField("", 8); 
      JLabel stulabel = new JLabel("Number of Students:", JLabel.RIGHT);
      stuField = new JTextField("", 8);
      middlePanel.add(classlabel);
      middlePanel.add(classField);
      middlePanel.add(stulabel);
      middlePanel.add(stuField);
      newCard.add(middlePanel, BorderLayout.CENTER);
      
      JPanel buttonPanel = new JPanel(new GridLayout(2,4));
      newButton = new JButton("0. Create a New Class");
      buttonPanel.add(newButton);
      newButton.addActionListener(AL);   
      loadButton = new JButton("1. Load Students from Save File");
      buttonPanel.add(loadButton);
      loadButton.addActionListener(AL);
      stuButton = new JButton("2. Add New Student");
      buttonPanel.add(stuButton);
      stuButton.addActionListener(AL);
      scoreButton = new JButton("3. Enter Lab Scores");
      buttonPanel.add(scoreButton);
      scoreButton.addActionListener(AL);
      sortButton = new JButton("4. Sort Students");
      buttonPanel.add(sortButton);
      sortButton.addActionListener(AL);
      viewButton = new JButton("5. View/Delete Students");
      buttonPanel.add(viewButton);
      viewButton.addActionListener(AL);
      saveButton = new JButton("6. Backup Students to Computer");
      buttonPanel.add(saveButton);
      saveButton.addActionListener(AL);
      exitButton = new JButton("7. Exit");
      buttonPanel.add(exitButton);
      exitButton.addActionListener(AL);
      newCard.add(buttonPanel, BorderLayout.SOUTH);
      contentPane.add("Top Level Card", newCard);
      
//Create a New Class Window
      JPanel createCard = new JPanel(new BorderLayout());
      JPanel cTopPanel = new JPanel();
      JLabel cNewClass = new JLabel("<html><font size=5><b>Create a New Class</b></html>", JLabel.CENTER);
      cTopPanel.add(cNewClass);
      createCard.add(cTopPanel, BorderLayout.NORTH);
      JPanel cMiddlePanel = new JPanel(new FlowLayout());
      JLabel cName = new JLabel("Class Name:", JLabel.LEFT);
      cClassField = new JTextField("", 8);
      cMiddlePanel.add(cName);
      cMiddlePanel.add(cClassField);
      createCard.add(cMiddlePanel, BorderLayout.CENTER);
      JPanel cLowPanel = new JPanel(new FlowLayout());
      createButton = new JButton("Create");
      cLowPanel.add(createButton);
      createButton.addActionListener(AL);
      cLowPanel.add(cancelButton);
      cancelButton.addActionListener(AL);
      createCard.add(cLowPanel, BorderLayout.SOUTH);
      contentPane.add("Create a New Class", createCard);
      
//Load Students from Save File window
	  JPanel loadCard = new JPanel(new BorderLayout());
      JPanel lTopPanel = new JPanel();
      JLabel lLoadStu = new JLabel("<html><font size=5><b>Load Students from Save File</b></html>", JLabel.CENTER);
      lTopPanel.add(lLoadStu);
      loadCard.add(lTopPanel, BorderLayout.NORTH);
      JPanel lMiddlePanel = new JPanel(new FlowLayout());
      JLabel lName = new JLabel("Class Name:", JLabel.LEFT);
      JTextField lClassField = new JTextField("", 8);
      lMiddlePanel.add(lName);
      lMiddlePanel.add(lClassField);
      loadCard.add(lMiddlePanel, BorderLayout.CENTER);
      JPanel lLowPanel = new JPanel(new FlowLayout());
      JButton loadButton = new JButton("Load");
      lLowPanel.add(loadButton);
      lLowPanel.add(lCancelButton);
      lCancelButton.addActionListener(AL);
      loadCard.add(lLowPanel, BorderLayout.SOUTH);
      contentPane.add("Load Students from Save File", loadCard);
		
//Enter Student Information window
      JPanel infoCard = new JPanel(new BorderLayout());
      JPanel iTopButtonPanel = new JPanel(new FlowLayout());
      JLabel iStuInfo = new JLabel("<html><font size=5>Enter Student Information</b></html>", JLabel.CENTER);
      iTopButtonPanel.add(iStuInfo);
      infoCard.add(iTopButtonPanel, BorderLayout.NORTH);
      JPanel iMiddlePanel = new JPanel(new GridLayout(0,2));
      JLabel iSSN = new JLabel("SSN:", JLabel.RIGHT);
      iSSNText = new JTextField("", 20);
      iSSNText.setHorizontalAlignment(JTextField.RIGHT);
      JLabel iName = new JLabel("Name:", JLabel.RIGHT);
      iNameText = new JTextField("", 20);
      iNameText.setHorizontalAlignment(JTextField.RIGHT);
      JLabel iGender = new JLabel("Gender:", JLabel.RIGHT);
      iGenderBox = new JComboBox(G);  
      JLabel iAge = new JLabel("Age:", JLabel.RIGHT);
      iAgeField = new JTextField("", 20);
      iAgeField.setHorizontalAlignment(JTextField.RIGHT);
      JLabel iLevel = new JLabel("Academic Level:", JLabel.RIGHT);  
      iLevelBox = new JComboBox(L);  
      iMiddlePanel.add(iSSN);
      iMiddlePanel.add(iSSNText);
      iMiddlePanel.add(iName);
      iMiddlePanel.add(iNameText);
      iMiddlePanel.add(iGender);
      iMiddlePanel.add(iGenderBox);
      iMiddlePanel.add(iAge);
      iMiddlePanel.add(iAgeField);
      iMiddlePanel.add(iLevel);  
      iMiddlePanel.add(iLevelBox); 
      infoCard.add(iMiddlePanel, BorderLayout.CENTER);
      JPanel iBottomPanel = new JPanel(new GridLayout(0,2));
      iSave = new JButton("Save & Add Student");
      iSave.addActionListener(AL);
      iTopButton = new JButton("Back to Top Menu");
      iTopButton.addActionListener(AL);
      iBottomPanel.add(iSave);
      iBottomPanel.add(iTopButton);
      infoCard.add(iBottomPanel, BorderLayout.SOUTH);
      contentPane.add("Student Information", infoCard);
      
            
//Enter Lab Score window
	  JPanel scoreCard = new JPanel(new BorderLayout());
	  JPanel sTopPanel = new JPanel();
	  JLabel sEntScore = new JLabel("<html><font size=5><b>Enter Lab Scores</html></b>", JLabel.CENTER);
	  sTopPanel.add(sEntScore);
	  scoreCard.add(sTopPanel, BorderLayout.NORTH);
	  JPanel sMiddlePanel = new JPanel();
	  JLabel sLabNum = new JLabel("Lab Number:", JLabel.CENTER);
	  sLabNumField = new JTextField("", 8);
	  sLabNumField.addKeyListener(KL);
	  sLabNumField.setHorizontalAlignment(JTextField.RIGHT);
	  JLabel sScoreFor = new JLabel("Score For:", JLabel.CENTER);
	  sScoreForField = new JTextField("", 8);
	  sScoreForField.addKeyListener(KL);
	  sScoreForField.setHorizontalAlignment(JTextField.RIGHT);
	  sMiddlePanel.add(sLabNum);
	  sMiddlePanel.add(sLabNumField);
	  sMiddlePanel.add(sScoreFor);
	  sMiddlePanel.add(sScoreForField);
	  scoreCard.add(sMiddlePanel, BorderLayout.CENTER);
	  JPanel sLowPanel = new JPanel(new FlowLayout());
	  sLowPanel.add(sBackButton);
	  sBackButton.addActionListener(AL);
	  scoreCard.add(sLowPanel, BorderLayout.SOUTH);
	  contentPane.add("Enter Lab Scores", scoreCard);
	  
//Sort Students window
	  JPanel sortCard = new JPanel(new BorderLayout());
	  JPanel sorTopPanel = new JPanel();
	  JLabel sorLabel = new JLabel("<html><font size=5><b>Sort Students</b></html>", JLabel.CENTER);
	  sorTopPanel.add(sorLabel);
	  sortCard.add(sorTopPanel, BorderLayout.NORTH);
	  JPanel sorMiddlePanel = new JPanel(new FlowLayout());
	  JRadioButton iD = new JRadioButton("By ID");
	  JRadioButton name = new JRadioButton("By Name");
	  sorMiddlePanel.add(iD);
	  sorMiddlePanel.add(name);
	  sortCard.add(sorMiddlePanel, BorderLayout.CENTER);
	  JPanel sorBottomPanel = new JPanel(new FlowLayout());
	  sorSortButton = new JButton("Sort");
	  sorTopButton = new JButton("Top Menu");
	  sorBottomPanel.add(sorSortButton);
	  sorBottomPanel.add(sorTopButton);
	  sorTopButton.addActionListener(AL);
	  sortCard.add(sorBottomPanel, BorderLayout.SOUTH);
	  contentPane.add("Sort Students", sortCard);
	  
//View & Delete Students window
	  JPanel viewCard = new JPanel(new BorderLayout());
	  JPanel vTopPanel = new JPanel();
	  JLabel vLabel = new JLabel("<html><font size=3><b>View Students</b></html>", JLabel.CENTER);
	  vTopPanel.add(vLabel);
	  viewCard.add(vTopPanel, BorderLayout.NORTH);
	  JPanel vMiddlePanel = new JPanel(new FlowLayout());
	  scrollPane = new JScrollPane();
	  viewCard.add(scrollPane,BorderLayout.CENTER);
	  JPanel vBottomPanel = new JPanel(new FlowLayout());
	  vDelete = new JButton("Delete Selected");
	  vDelete.addActionListener(AL);
	  vTopButton = new JButton("Top Menu");
	  vTopButton.addActionListener(AL);
	  vBottomPanel.add(vDelete);
	  vBottomPanel.add(vTopButton);
	  viewCard.add(vBottomPanel, BorderLayout.SOUTH);
	  contentPane.add("View Students", viewCard);

      contentPaneLayout.show(contentPane, "Top Level Card");
      
      frame.pack();
      frame.setSize(900,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}      
      
