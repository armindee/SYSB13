package TestView;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import TestController.TestDeleteController;
import TestController.RegisterController;
import TestController.TestSearchController;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TestMainView {

	public JFrame frame;
	private JTextField tfRegStudSpnr;
	private JTextField tfRegStudSname;
	private JTextField tfRegStudSadress;
	private JTextField tfRegStudStel;
	private JTextField tfRegCourseCcode;
	private JTextField tfRegCourseCname;
	private JTextField tfRegCourseCadress;
	private JTextField tfReadingSpnr;
	private JTextField tfReadingCcode;
	private JTextField tfSearchSpnr;
	private JTextField tfSearchSname;
	private JTextField tfSearchSadress;
	private JTextField tfSearchStel;
	private JTextField tfSearchCcode;
	private JTextField tfGradeSpnr;
	private JTextField tfGradeCourse;
	private JTextField tfSearchCname;
	private JTextField tfSearchCadress;
	private JSpinner spinRegCoursePoints;
	private JSpinner spinSearchPoints;
	private JComboBox comboGrade;
	
	private RegisterController registerController;
	private TestSearchController searchController;
	private TestDeleteController deleteController;
	private JTextField tfGrade;
	public JTable resultsTable;
	private JTextField tfGetGradeCcode;
	private JTextField tfGetGradeSpnr;
	private JTable resultsTableMisc;
	private JTextField tfCourseCcode;
	private JTextField tfStudentSpnr;



	/**
	 * Create the application.
	 */
	public TestMainView() {
		initialize();
		this.registerController = new RegisterController();
		this.searchController = new TestSearchController();
		this.deleteController = new TestDeleteController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 894, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setBounds(0, 0, 868, 680);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Registrering", null, panel, null);
		panel.setLayout(null);
		
		JButton btnRegStudent = new JButton("Registrera");
		btnRegStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegStudent_actionPerformed(e);
			}
		});
		btnRegStudent.setBounds(10, 164, 264, 37);
		panel.add(btnRegStudent);
		
		tfRegStudSpnr = new JTextField();
		tfRegStudSpnr.setBounds(94, 43, 180, 20);
		panel.add(tfRegStudSpnr);
		tfRegStudSpnr.setColumns(10);
		
		tfRegStudSname = new JTextField();
		tfRegStudSname.setBounds(94, 74, 180, 20);
		panel.add(tfRegStudSname);
		tfRegStudSname.setColumns(10);
		
		tfRegStudSadress = new JTextField();
		tfRegStudSadress.setBounds(94, 105, 180, 20);
		panel.add(tfRegStudSadress);
		tfRegStudSadress.setColumns(10);
		
		tfRegStudStel = new JTextField();
		tfRegStudStel.setBounds(94, 136, 180, 20);
		panel.add(tfRegStudStel);
		tfRegStudStel.setColumns(10);
		
		JLabel lblSpnr = new JLabel("Persnr");
		lblSpnr.setBounds(10, 43, 74, 14);
		panel.add(lblSpnr);
		
		JLabel lblRegStudent = new JLabel("Registrera student");
		lblRegStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegStudent.setBounds(10, 15, 136, 14);
		panel.add(lblRegStudent);
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(10, 74, 74, 14);
		panel.add(lblNamn);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(10, 105, 74, 14);
		panel.add(lblAdress);
		
		JLabel lblTel = new JLabel("Telefonr");
		lblTel.setBounds(10, 136, 74, 14);
		panel.add(lblTel);
		
		tfRegCourseCcode = new JTextField();
		tfRegCourseCcode.setBounds(399, 40, 182, 20);
		panel.add(tfRegCourseCcode);
		tfRegCourseCcode.setColumns(10);
		
		tfRegCourseCname = new JTextField();
		tfRegCourseCname.setBounds(399, 71, 180, 20);
		panel.add(tfRegCourseCname);
		tfRegCourseCname.setColumns(10);
		
		tfRegCourseCadress = new JTextField();
		tfRegCourseCadress.setBounds(399, 102, 182, 20);
		panel.add(tfRegCourseCadress);
		tfRegCourseCadress.setColumns(10);
		
		JButton btnRegCourse = new JButton("Registrera");
		btnRegCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegCourse_actionPerformed(e);
			}
		});
		btnRegCourse.setBounds(317, 164, 264, 37);
		panel.add(btnRegCourse);
		
		JLabel lblCcode = new JLabel("Kurskod");
		lblCcode.setBounds(317, 43, 74, 14);
		panel.add(lblCcode);
		
		JLabel lblCnamn = new JLabel("Namn");
		lblCnamn.setBounds(317, 74, 74, 14);
		panel.add(lblCnamn);
		
		JLabel lblCadress = new JLabel("Adress");
		lblCadress.setBounds(317, 105, 74, 14);
		panel.add(lblCadress);
		
		spinRegCoursePoints = new JSpinner();
		spinRegCoursePoints.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinRegCoursePoints.setBounds(401, 133, 53, 20);
		panel.add(spinRegCoursePoints);
		
		JLabel lblRegCourse = new JLabel("Registrera kurs");
		lblRegCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegCourse.setBounds(317, 15, 132, 14);
		panel.add(lblRegCourse);
		
		JLabel lblPoints = new JLabel("Poäng");
		lblPoints.setBounds(317, 136, 74, 14);
		panel.add(lblPoints);
		
		tfReadingSpnr = new JTextField();
		tfReadingSpnr.setBounds(94, 264, 180, 20);
		panel.add(tfReadingSpnr);
		tfReadingSpnr.setColumns(10);
		
		JLabel lblSpnr_1 = new JLabel("Personr");
		lblSpnr_1.setBounds(10, 264, 74, 14);
		panel.add(lblSpnr_1);
		
		tfReadingCcode = new JTextField();
		tfReadingCcode.setBounds(94, 295, 180, 20);
		panel.add(tfReadingCcode);
		tfReadingCcode.setColumns(10);
		
		JLabel lblCcode_1 = new JLabel("Kurskod");
		lblCcode_1.setBounds(10, 295, 74, 14);
		panel.add(lblCcode_1);
		
		JButton btnRegReading = new JButton("Registrera");
		btnRegReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegReading_actionPerformed(e);
			}
		});
		btnRegReading.setBounds(10, 326, 264, 37);
		panel.add(btnRegReading);
		
		JLabel lblRegReading = new JLabel("Registrera elev till kurs");
		lblRegReading.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegReading.setBounds(10, 236, 134, 14);
		panel.add(lblRegReading);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("S\u00F6k", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfSearchSpnr = new JTextField();
		tfSearchSpnr.setBounds(81, 31, 134, 20);
		panel_2.add(tfSearchSpnr);
		tfSearchSpnr.setColumns(10);
		
		JLabel lblSpnr_2 = new JLabel("Personr");
		lblSpnr_2.setBounds(10, 34, 46, 14);
		panel_2.add(lblSpnr_2);
		
		JButton btnSearchSpnr = new JButton("s\u00F6k");
		btnSearchSpnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchSpnr_actionPerformed(e);
			}
		});
		btnSearchSpnr.setBounds(234, 30, 63, 20);
		panel_2.add(btnSearchSpnr);
		
		tfSearchSname = new JTextField();
		tfSearchSname.setEditable(false);
		tfSearchSname.setColumns(10);
		tfSearchSname.setBounds(81, 75, 216, 20);
		panel_2.add(tfSearchSname);
		
		tfSearchSadress = new JTextField();
		tfSearchSadress.setEditable(false);
		tfSearchSadress.setColumns(10);
		tfSearchSadress.setBounds(81, 106, 216, 20);
		panel_2.add(tfSearchSadress);
		
		tfSearchStel = new JTextField();
		tfSearchStel.setEditable(false);
		tfSearchStel.setColumns(10);
		tfSearchStel.setBounds(81, 137, 216, 20);
		panel_2.add(tfSearchStel);
		
		JLabel lblNamn_1 = new JLabel("Namn");
		lblNamn_1.setBounds(10, 78, 46, 14);
		panel_2.add(lblNamn_1);
		
		JLabel lblAdress_1 = new JLabel("Adress");
		lblAdress_1.setBounds(10, 109, 46, 14);
		panel_2.add(lblAdress_1);
		
		JLabel lblTelenr = new JLabel("Telenr");
		lblTelenr.setBounds(10, 140, 46, 14);
		panel_2.add(lblTelenr);
		
		JLabel lblPKurs = new JLabel("Kurskod");
		lblPKurs.setBounds(372, 31, 58, 14);
		panel_2.add(lblPKurs);
		
		tfSearchCcode = new JTextField();
		tfSearchCcode.setBounds(440, 31, 134, 20);
		panel_2.add(tfSearchCcode);
		tfSearchCcode.setColumns(10);
		
		JButton btnSearchRemoveStudent = new JButton("Radera");
		btnSearchRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchRemoveStudent_actionPerformed(e);
			}
		});
		btnSearchRemoveStudent.setBounds(10, 168, 286, 35);
		panel_2.add(btnSearchRemoveStudent);
		
		tfSearchCname = new JTextField();
		tfSearchCname.setEditable(false);
		tfSearchCname.setColumns(10);
		tfSearchCname.setBounds(440, 75, 216, 20);
		panel_2.add(tfSearchCname);
		
		tfSearchCadress = new JTextField();
		tfSearchCadress.setEditable(false);
		tfSearchCadress.setColumns(10);
		tfSearchCadress.setBounds(440, 106, 216, 20);
		panel_2.add(tfSearchCadress);
		
		JLabel lblNamn_2 = new JLabel("Namn");
		lblNamn_2.setBounds(372, 78, 58, 14);
		panel_2.add(lblNamn_2);
		
		JLabel lblAdress_2 = new JLabel("Adress");
		lblAdress_2.setBounds(372, 112, 50, 14);
		panel_2.add(lblAdress_2);
		
		spinSearchPoints = new JSpinner();
		spinSearchPoints.setEnabled(false);
		spinSearchPoints.setBounds(440, 137, 53, 20);
		panel_2.add(spinSearchPoints);
		
		JLabel lblPong = new JLabel("Poäng");
		lblPong.setBounds(372, 143, 46, 14);
		panel_2.add(lblPong);
		
		JButton btnSearchRemoveCourse = new JButton("Radera");
		btnSearchRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchRemoveCourse_actionPerformed(e);
			}
		});
		btnSearchRemoveCourse.setBounds(372, 168, 284, 35);
		panel_2.add(btnSearchRemoveCourse);
		
		JButton btnSearchCourse = new JButton("s\u00F6k");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchCourse_actionPerformed(e);
			}
		});
		btnSearchCourse.setBounds(593, 30, 63, 23);
		panel_2.add(btnSearchCourse);
		
		JButton btnSearchEraseReading = new JButton("Radera student fr\u00E5n kurs");
		btnSearchEraseReading.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearchEraseReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchEraseReading_actionPerformed(e);
			}
		});
		btnSearchEraseReading.setBounds(10, 214, 646, 35);
		panel_2.add(btnSearchEraseReading);
		
		JLabel lblNewLabel = new JLabel("Sök student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 9, 287, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblSkKurs = new JLabel("Sök kurs");
		lblSkKurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkKurs.setBounds(372, 9, 287, 14);
		panel_2.add(lblSkKurs);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Resultat", null, panel_1, null);
		panel_1.setLayout(null);
		
		tfGradeSpnr = new JTextField();
		tfGradeSpnr.setBounds(10, 36, 86, 20);
		panel_1.add(tfGradeSpnr);
		tfGradeSpnr.setColumns(10);
		
		tfGradeCourse = new JTextField();
		tfGradeCourse.setBounds(127, 36, 86, 20);
		panel_1.add(tfGradeCourse);
		tfGradeCourse.setColumns(10);
		
		comboGrade = new JComboBox();
		comboGrade.setModel(new DefaultComboBoxModel(new String[] {"U", "E", "D", "C", "B", "A"}));
		comboGrade.setBounds(236, 36, 45, 20);
		panel_1.add(comboGrade);
		
		JButton btnGrade = new JButton("Gradera");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGradeg_actionPerformed(e);
			}
		});
		btnGrade.setBounds(10, 72, 271, 50);
		panel_1.add(btnGrade);
		
		JLabel lblGradeStudent = new JLabel("Persnummer");
		lblGradeStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGradeStudent.setBounds(10, 11, 86, 14);
		panel_1.add(lblGradeStudent);
		
		JLabel lblGradeCourse = new JLabel("Kurskod");
		lblGradeCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGradeCourse.setBounds(127, 11, 46, 14);
		panel_1.add(lblGradeCourse);
		
		JButton btnShowGrade = new JButton("Visa Betyg");
		btnShowGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowGrade_actionPerformed(e);
			}
		});
		btnShowGrade.setBounds(10, 275, 205, 50);
		panel_1.add(btnShowGrade);
		
		tfGrade = new JTextField();
		tfGrade.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfGrade.setForeground(Color.RED);
		tfGrade.setEditable(false);
		tfGrade.setBounds(236, 275, 45, 50);
		panel_1.add(tfGrade);
		tfGrade.setColumns(10);
		
		resultsTable = new JTable();
		resultsTable.setEnabled(false);
		resultsTable.setCellSelectionEnabled(true);
		resultsTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultsTable.setBounds(291, 39, 562, 602);
		panel_1.add(resultsTable);
		
		tfGetGradeCcode = new JTextField();
		tfGetGradeCcode.setColumns(10);
		tfGetGradeCcode.setBounds(10, 244, 271, 20);
		panel_1.add(tfGetGradeCcode);
		
		tfGetGradeSpnr = new JTextField();
		tfGetGradeSpnr.setColumns(10);
		tfGetGradeSpnr.setBounds(10, 188, 271, 20);
		panel_1.add(tfGetGradeSpnr);
		
		JLabel lblGetGradeStudent = new JLabel("Student personnummer");
		lblGetGradeStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGetGradeStudent.setBounds(10, 163, 271, 14);
		panel_1.add(lblGetGradeStudent);
		
		JLabel lblGetGradeCourse = new JLabel("Kurs kurskod");
		lblGetGradeCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGetGradeCourse.setBounds(10, 219, 271, 14);
		panel_1.add(lblGetGradeCourse);
		
		JButton btnShowResultForAllStudents = new JButton("Visa betyg f\u00F6r samtliga studenter");
		btnShowResultForAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowResultForAllStudents_actionPerformed(e);
			}
		});
		btnShowResultForAllStudents.setBounds(10, 336, 271, 50);
		panel_1.add(btnShowResultForAllStudents);
		
		JButton btnShowStudentsGrades = new JButton("Visa students samtliga betyg");
		btnShowStudentsGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowStudentsGrade_actionPerformed(e);
			}
		});
		btnShowStudentsGrades.setBounds(10, 397, 271, 50);
		panel_1.add(btnShowStudentsGrades);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Övrigt", null, panel_3, null);
		
		resultsTableMisc = new JTable();
		resultsTableMisc.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultsTableMisc.setBounds(291, 39, 562, 602);
		panel_3.add(resultsTableMisc);
		
		tfCourseCcode = new JTextField();
		tfCourseCcode.setColumns(10);
		tfCourseCcode.setBounds(10, 120, 271, 20);
		panel_3.add(tfCourseCcode);
		
		tfStudentSpnr = new JTextField();
		tfStudentSpnr.setColumns(10);
		tfStudentSpnr.setBounds(10, 64, 271, 20);
		panel_3.add(tfStudentSpnr);
		
		JLabel lblStudentPersonnummer = new JLabel("Student personnummer");
		lblStudentPersonnummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentPersonnummer.setBounds(10, 39, 271, 14);
		panel_3.add(lblStudentPersonnummer);
		
		JLabel lblKursKurskod = new JLabel("Kurs kurskod");
		lblKursKurskod.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKursKurskod.setBounds(10, 95, 271, 14);
		panel_3.add(lblKursKurskod);
		
		JButton btnShowRegisterdStudents = new JButton("Visa registrerade studenter p\u00E5 kurs");
		btnShowRegisterdStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowRegisterdStudents_actionPerformed(e);
			}
		});
		btnShowRegisterdStudents.setBounds(10, 151, 271, 50);
		panel_3.add(btnShowRegisterdStudents);
		
		JButton btnShowAllStudent = new JButton("Visa alla studenter");
		btnShowAllStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllStudent_actionPerformed(e);
			}
		});
		btnShowAllStudent.setBounds(10, 273, 271, 50);
		panel_3.add(btnShowAllStudent);
		
		JButton btnShowAllCourses = new JButton("Visa alla kurser");
		btnShowAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAllCourse_actionPerformed(e);
			}
		});
		btnShowAllCourses.setBounds(10, 334, 271, 50);
		panel_3.add(btnShowAllCourses);
		
		JButton btnStudentRegisteredToCourses = new JButton("Visa kurser student är registrerad på");
		btnStudentRegisteredToCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStudentRegisteredToCourses_actionPerformed(e);
			}
		});
		btnStudentRegisteredToCourses.setBounds(10, 212, 271, 50);
		panel_3.add(btnStudentRegisteredToCourses);
		
	}

	protected void btnShowAllCourse_actionPerformed(ActionEvent e) {
		resultsTableMisc.setModel(searchController.getTableModelForAllCourses());
	}

	protected void btnShowAllStudent_actionPerformed(ActionEvent e) {
		resultsTableMisc.setModel(searchController.getTableModelForAllStudents());
	}

	protected void btnStudentRegisteredToCourses_actionPerformed(ActionEvent e) {
		String spnr = tfStudentSpnr.getText();
		checkIfStringIsNull(spnr);
		resultsTableMisc.setModel(searchController.getTabelModelForStudentCourse(spnr));
		exceptionMessageForSearch();	
	}

	protected void btnShowStudentsGrade_actionPerformed(ActionEvent e) {
		String spnr = tfGetGradeSpnr.getText();
		checkIfStringIsNull(spnr);
		resultsTable.setModel(searchController.getTabelModelForStudentGrade(spnr));
		exceptionMessageForSearch();
	}

	protected void btnShowRegisterdStudents_actionPerformed(ActionEvent e) {
		String ccode = tfCourseCcode.getText();
		checkIfStringIsNull(ccode);
		resultsTableMisc.setModel(searchController.getTableModelForRegisterd(ccode));
		exceptionMessageForSearch();
	}

	protected void btnShowResultForAllStudents_actionPerformed(ActionEvent e) {
		String ccode = tfGetGradeCcode.getText();
		checkIfStringIsNull(ccode);
		resultsTable.setModel(searchController.getTabelModelForGrade(ccode));
		exceptionMessageForSearch();
	}

	protected void btnShowGrade_actionPerformed(ActionEvent e) {
		String ccode = tfGetGradeCcode.getText();
		String spnr = tfGetGradeSpnr.getText();
		
		checkIfStringIsNull(ccode);
		checkIfStringIsNull(spnr);
		
		tfGrade.setText(searchController.getGrade(ccode, spnr));
		exceptionMessageForSearch();
	}

	protected void btnGradeg_actionPerformed(ActionEvent e) {
		String ccode = tfGradeCourse.getText();
		String spnr = tfGradeSpnr.getText();
		String grade = (String)comboGrade.getSelectedItem();
		
		checkIfStringIsNull(ccode);
		checkIfStringIsNull(spnr);
		
		registerController.registerStudentGrade(searchController.getStudent(spnr), searchController.getCourse(ccode), grade);
		exceptionMessageForSearch();
		exceptionMessageForDelete();
	}

	protected void btnSearchEraseReading_actionPerformed(ActionEvent e) {
		String ccode = tfSearchCcode.getText();
		String spnr = tfSearchSpnr.getText();
		checkIfStringIsNull(ccode);
		checkIfStringIsNull(spnr);
		deleteController.deleteStudentFromCourse(ccode, spnr);
		exceptionMessageForDelete();
	}

	protected void btnSearchRemoveCourse_actionPerformed(ActionEvent e) {
		String ccode = tfSearchCcode.getText();
		checkIfStringIsNull(ccode);
		deleteController.deleteCourse(ccode);
		exceptionMessageForDelete();
	}

	protected void btnSearchRemoveStudent_actionPerformed(ActionEvent e) {
		String spnr = tfSearchSpnr.getText();
		checkIfStringIsNull(spnr);
		deleteController.deleteStudent(spnr);
		exceptionMessageForDelete();
	}

	protected void btnSearchCourse_actionPerformed(ActionEvent e) {
		String ccode = tfSearchCcode.getText();
		checkIfStringIsNull(ccode);
		tfSearchCname.setText(searchController.getCourse(ccode).getCname());
		tfSearchCadress.setText(searchController.getCourse(ccode).getCadress());
		spinSearchPoints.setValue(searchController.getCourse(ccode).getPoints());
		exceptionMessageForSearch();
	}

	protected void btnSearchSpnr_actionPerformed(ActionEvent e) {
		String spnr = tfSearchSpnr.getText();
		
		checkIfStringIsNull(spnr);
		
		tfSearchSname.setText(searchController.getStudent(spnr).getName());
		tfSearchSadress.setText(searchController.getStudent(spnr).getAdress());
		tfSearchStel.setText(searchController.getStudent(spnr).getTelnr());
		exceptionMessageForSearch();
	}

	protected void btnRegCourse_actionPerformed(ActionEvent e) {
		String ccode = tfRegCourseCcode.getText();
		String name = tfRegCourseCname.getText();
		String adress = tfRegCourseCadress.getText();
		
		checkIfStringIsNull(ccode);
		checkIfStringIsNull(name);
		checkIfStringIsNull(adress);
		
		registerController.registerCourse(ccode, name, adress, (Integer)spinRegCoursePoints.getValue());
		exceptionMessageForRegister();
	}

	protected void btnRegStudent_actionPerformed(ActionEvent e) {
		String spnr = tfRegStudSpnr.getText();
		String name = tfRegStudSname.getText();
		String adress = tfRegStudSadress.getText();
		String tel = tfRegStudStel.getText();
		
		checkIfStringIsNull(spnr);
		checkIfStringIsNull(name);
		checkIfStringIsNull(adress);
		checkIfStringIsNull(tel);
		
		registerController.registerStudent(spnr, name, adress, tel);
		exceptionMessageForRegister();
	}
	
	protected void btnRegReading_actionPerformed(ActionEvent e) {
		String spnr = tfReadingSpnr.getText();
		String ccode = tfReadingCcode.getText();
		
		checkIfStringIsNull(spnr);
		checkIfStringIsNull(ccode);
		
		registerController.registerStudentToCourse(searchController.getStudent(spnr), 
				searchController.getCourse(ccode));
		exceptionMessageForRegister();
	}
	
	private void exceptionMessageForRegister() {
		if(registerController.checkForException()) {
			JOptionPane.showMessageDialog(null, registerController.exceptionMessage);
		}else {
			JOptionPane.showMessageDialog(null, "Tillagd");
		}
	}
	
	private void exceptionMessageForSearch() {
		if(searchController.checkForException()) {
			System.out.println("fail");
			JOptionPane.showMessageDialog(null, searchController.exceptionMessage);
		}
	}
	
	private void exceptionMessageForDelete() {
		if(deleteController.checkForException()) {
			JOptionPane.showMessageDialog(null, searchController.exceptionMessage);
		}
	}
	
	private void checkIfStringIsNull(String checkString) {
		if(checkString.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält");
		}
	}
}
