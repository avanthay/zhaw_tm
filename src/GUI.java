

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class GUI {

	private JFrame frame;
	private JTextField txtSteps;
	private JTextField txtValue;
	private JTextField txtResult;
	private JTextField txtState;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private ArrayList<JTextField> fieldList_1 = new ArrayList<JTextField>();
	private ArrayList<JTextField> fieldList_2 = new ArrayList<JTextField>();
	private ArrayList<JTextField> fieldList_3 = new ArrayList<JTextField>();
	private ArrayList<ArrayList<JTextField>> listOfFieldList = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<Band> bandList = new ArrayList<Band>();
	private boolean setInput;
	private Machine machine = new Machine();
	private int speed = 300;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		listOfFieldList.add(0, fieldList_1);
		listOfFieldList.add(1, fieldList_2);
		listOfFieldList.add(2, fieldList_3);
		bandList.add(0, machine.getBand1());
		bandList.add(1, machine.getBand2());
		bandList.add(2, machine.getBand3());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Dave's Turing machine");
		frame.setBounds(100, 100, 718, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 250, 112);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(0, 11, 67, 23);
		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machinedostart();
			}
		});

		JButton btnStep = new JButton("Step");
		btnStep.setBounds(0, 45, 67, 23);
		panel.add(btnStep);
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machinedostep();
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(0, 79, 67, 23);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machinedoreset();
			}
		});

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(77, 15, 46, 14);
		panel.add(lblValue);

		JLabel lblSteps = new JLabel("Steps");
		lblSteps.setBounds(75, 49, 46, 14);
		panel.add(lblSteps);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(75, 83, 46, 14);
		panel.add(lblResult);

		txtSteps = new JTextField();
		txtSteps.setBounds(131, 46, 86, 20);
		txtSteps.setEditable(false);
		txtSteps.setBackground(Color.white);
		panel.add(txtSteps);
		txtSteps.setColumns(10);

		txtValue = new JTextField();
		txtValue.setBounds(131, 12, 86, 20);
		panel.add(txtValue);
		txtValue.setColumns(10);

		txtResult = new JTextField();
		txtResult.setBounds(131, 80, 86, 20);
		txtResult.setEditable(false);
		txtResult.setBackground(Color.white);
		panel.add(txtResult);
		txtResult.setColumns(10);

		JPanel panel_0 = new JPanel();
		panel_0.setBounds(10, 145, 682, 110);
		frame.getContentPane().add(panel_0);
		panel_0.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 5, 662, 30);
		panel_0.add(panel_1);
		createFields(machine.getBand1(), fieldList_1, panel_1);

		panel_2 = new JPanel();
		panel_2.setBounds(10, 40, 662, 30);
		panel_0.add(panel_2);
		createFields(machine.getBand2(), fieldList_2, panel_2);

		panel_3 = new JPanel();
		panel_3.setBounds(10, 75, 662, 30);
		panel_0.add(panel_3);
		createFields(machine.getBand3(), fieldList_3, panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(270, 11, 126, 112);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JRadioButton rdbtnMultiplication = new JRadioButton("Multiplication");
		rdbtnMultiplication.setBounds(0, 12, 129, 23);
		panel_4.add(rdbtnMultiplication);
		rdbtnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machine.setConfig("Multiplication");
			}
		});

		JRadioButton rdbtnFaculty = new JRadioButton("Faculty");
		rdbtnFaculty.setBounds(0, 46, 129, 23);
		panel_4.add(rdbtnFaculty);
		rdbtnFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machine.setConfig("Faculty");
			}
		});

		ButtonGroup rdiogroup = new ButtonGroup();
		rdiogroup.add(rdbtnMultiplication);
		rdiogroup.add(rdbtnFaculty);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(406, 11, 250, 112);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 15, 46, 14);
		panel_5.add(lblState);

		txtState = new JTextField();
		txtState.setBounds(66, 12, 23, 20);
		txtState.setEditable(false);
		txtState.setBackground(Color.white);
		panel_5.add(txtState);
		txtState.setColumns(10);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(10, 83, 46, 14);
		panel_5.add(lblSpeed);
		
		JButton btnUp = new JButton("up");
		btnUp.setBackground(new Color(102, 204, 0));
		btnUp.setBounds(66, 79, 77, 23);
		panel_5.add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (speed > 0){
				speed = speed - 100;
			}}
		});
		
		JButton btnDown = new JButton("down");
		btnDown.setBackground(new Color(204, 0, 0));
		btnDown.setBounds(153, 79, 77, 23);
		panel_5.add(btnDown);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (speed < 1000){
				speed = speed + 100;
			}}
		});
	}

	public void createFields(Band band, ArrayList<JTextField> feldliste,
			JPanel panel) {
		for (int i = 0; i < 29; i++) {
			JTextField feld = new JTextField(band.getString(i), 1);
			feld.setHorizontalAlignment(JTextField.CENTER);
			feld.setEditable(false);
			feld.setBackground(Color.white);
			panel.add(feld);
			feldliste.add(i, feld);
		}
		feldliste.get(14).setBackground(Color.yellow);
	}

	public void refreshBand() {
		for (int i = 0; i < 3; i++) {
			Band band = bandList.get(i);
			ArrayList<JTextField> fields = listOfFieldList.get(i);
			int pos = band.getPosition();
			int ref = band.getReference();
			for (int u = 0; u < fields.size(); u++) {
				JTextField field = fields.get(u);
				String content = null;
				if (0 <= ((u - 14) + pos + ref)
						&& ((u - 14) + pos + ref) < band.getLength()) {
					content = band.getString((u - 14) + pos + ref);
				}
				field.setText(content);
			}
		}
	}
	
	public class RunMachine implements Runnable{
		public void run(){
			if (machine.getCurrentconfig() == null) {
				machinedostep();
			} else {
				while (machine.getFinisched() == false) {
					machinedostep();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void machinedostart() {
		RunMachine go = new RunMachine();
		Thread work = new Thread(go);
		work.start();
	}

	public void machinedostep() {
		if (machine.getCurrentconfig() == null) {
			JOptionPane
					.showMessageDialog(
							frame,
							"\nPlease select a Radiobutton\n(Multiplication or Faculty)\n\n",
							"No Radio selected", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			// step config für das GUI
			if (setInput != true) {
				machine.setInput(txtValue.getText(), machine.getBand1());
				refreshBand();
				this.setInput = true;
			} else {
				machine.step();
				this.txtSteps.setText("" + machine.getStep());
				txtState.setText("" + machine.getCurrentState());
				txtResult.setText(String.valueOf(machine.getResult()));
				refreshBand();
				if (machine.getFinisched()) {
					txtResult.setBackground(Color.green);
					txtState.setBackground(Color.green);
				}
			}
		}
	}

	/*
	 * Hilfsfunktion für Bugfixing
	 */
	public void printband() {
		for (int i = 0; i < bandList.size(); i++) {
			Band band = bandList.get(i);
			System.out.println("\n" + band.getName() + " length: "
					+ band.getLength() + " position: " + band.getPosition()
					+ " ref: " + band.getReference());
			System.out.print(band.getName() + " content: ");
			for (int u = 0; u < band.getLength(); u++) {
				System.out.print(band.getString(u));
			}
		}
	}

	public void machinedoreset() {
		machine.reset();
		refreshBand();
		txtResult.setBackground(Color.white);
		txtResult.setText("");
		txtState.setBackground(Color.white);
		txtState.setText("");
		txtSteps.setText("");
		txtValue.setText("");
		setInput = false;
		speed = 300;
	}

	public void setFrameVisible(boolean visible) {
		this.frame.setVisible(visible);
	}
}
