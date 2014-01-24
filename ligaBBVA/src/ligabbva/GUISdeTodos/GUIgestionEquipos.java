package ligabbva.GUISdeTodos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;


public class GUIgestionEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIgestionEquipos dialog = new GUIgestionEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIgestionEquipos() {
		setTitle("Equipos");
		setBounds(100, 100, 422, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athletic", "Barcelona", "Madrid"}));
		comboBox.setBounds(26, 17, 99, 26);
		contentPanel.add(comboBox);
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
			{
				JButton btnAadirEquipo = new JButton("A\u00F1adir Equipo");
				btnAadirEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						comboBox.addItem(textField.getText());
					}
				});
				btnAadirEquipo.setBounds(214, 90, 158, 29);
				contentPanel.add(btnAadirEquipo);
			}
			{
				JButton btnEliminarEquipo = new JButton("Eliminar Equipo");
				btnEliminarEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBox.removeItem(comboBox.getSelectedItem());
					}
				});
				btnEliminarEquipo.setBounds(214, 249, 158, 29);
				contentPanel.add(btnEliminarEquipo);
			}
			{
				JButton btnModificarEquipo = new JButton("Modificar Equipo");
				btnModificarEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBox.removeItem(comboBox.getSelectedItem());
						comboBox.addItem(textField_1.getText());
					}
				});
				btnModificarEquipo.setBounds(214, 168, 158, 29);
				contentPanel.add(btnModificarEquipo);
			}
		}
		{
			textField = new JTextField();
			textField.setBounds(26, 91, 146, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(26, 169, 146, 26);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(26, 59, 69, 20);
		contentPanel.add(lblEquipo);
		
		JLabel lblEquipo_1 = new JLabel("Equipo");
		lblEquipo_1.setBounds(26, 133, 69, 20);
		contentPanel.add(lblEquipo_1);
	}
	
}
