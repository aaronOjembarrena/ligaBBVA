package ligabbva.GUISdeTodos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class GUIgestionArbitros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIgestionArbitros dialog = new GUIgestionArbitros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIgestionArbitros() {
		setTitle("Arbitros");
		setBounds(100, 100, 422, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Juan", "Lasa", "Peperoni"}));
		comboBox.setBounds(26, 17, 99, 26);
		contentPanel.add(comboBox);
		{
			JLabel lblArbitro = new JLabel("Arbitro");
			lblArbitro.setBounds(26, 59, 69, 20);
			contentPanel.add(lblArbitro);
		}
		{
			JLabel lblArbitro_1 = new JLabel("Arbitro");
			lblArbitro_1.setBounds(26, 133, 69, 20);
			contentPanel.add(lblArbitro_1);
		}
		{
			JButton btnAadirArbitro = new JButton("A\u00F1adir Arbitro");
			btnAadirArbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.addItem(textField.getText());
				}
			});
			btnAadirArbitro.setBounds(214, 90, 158, 29);
			contentPanel.add(btnAadirArbitro);
		}
		{
			JButton btnModificarArbitro = new JButton("Modificar Arbitro");
			btnModificarArbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.removeItem(comboBox.getSelectedItem());
					comboBox.addItem(textField_1.getText());
				}
			});
			btnModificarArbitro.setBounds(214, 168, 158, 29);
			contentPanel.add(btnModificarArbitro);
		}
		{
			JButton btnEliminarArbitro = new JButton("Eliminar Arbitro");
			btnEliminarArbitro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.removeItem(comboBox.getSelectedItem());
				}
			});
			btnEliminarArbitro.setBounds(214, 249, 158, 29);
			contentPanel.add(btnEliminarArbitro);
		}
		
		textField = new JTextField();
		textField.setBounds(26, 91, 146, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 169, 146, 26);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("Volver");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new GUIinterfazMenuAdministrador(null).setVisible(true);
						dispose();
					}
				});
				buttonPane.add(btnVolver);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				buttonPane.add(btnSalir);
			}
		}
	}
}
