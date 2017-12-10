package arquitetura.ifrn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfaceMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valorReg;
	Integer[] regs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
	
	String[] instrucaoCompleta = new String[3];
	String instrucao = null;
	Integer[] pilha = new Integer[10];
	Integer[] operandos = new Integer[2];
	int r1 = 0, r2 = 0;
	
	//MEMÓRIA
	String[] instrucoes = new String[5];
	Integer[] dados = new Integer[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMain frame = new InterfaceMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceMain() {
		setResizable(false);
		setTitle("Stack Simulator");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceMain.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Stack Simulator");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Century Gothic", Font.BOLD, 35));
		title.setBounds(450, 12, 264, 56);
		contentPane.add(title);
		
		JLabel lblValorDosRegistradores = new JLabel("Valor dos registradores:");
		lblValorDosRegistradores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValorDosRegistradores.setBounds(40, 134, 181, 20);
		contentPane.add(lblValorDosRegistradores);
		
		valorReg = new JTextField();
		valorReg.setFont(new Font("Tahoma", Font.BOLD, 12));
		valorReg.setBounds(41, 174, 132, 29);
		contentPane.add(valorReg);
		valorReg.setColumns(10);
		
		JLabel lblInstrucoes = new JLabel("Instru\u00E7\u00F5es:");
		lblInstrucoes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInstrucoes.setBounds(40, 330, 181, 20);
		contentPane.add(lblInstrucoes);
		
		//LABELS DA PILHA
		JLabel pilha1 = new JLabel("");
		pilha1.setFont(new Font("Arial", Font.BOLD, 12));
		pilha1.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha1.setBounds(643, 462, 113, 25);
		contentPane.add(pilha1);
		
		JLabel pilha2 = new JLabel("");
		pilha2.setFont(new Font("Arial", Font.BOLD, 12));
		pilha2.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha2.setBounds(643, 430, 113, 25);
		contentPane.add(pilha2);
		
		JLabel pilha3 = new JLabel("");
		pilha3.setFont(new Font("Arial", Font.BOLD, 12));
		pilha3.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha3.setBounds(643, 395, 113, 25);
		contentPane.add(pilha3);
		
		JLabel pilha4 = new JLabel("");
		pilha4.setFont(new Font("Arial", Font.BOLD, 12));
		pilha4.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha4.setBounds(643, 359, 113, 25);
		contentPane.add(pilha4);
		
		JLabel pilha5 = new JLabel("");
		pilha5.setFont(new Font("Arial", Font.BOLD, 12));
		pilha5.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha5.setBounds(643, 322, 113, 25);
		contentPane.add(pilha5);
		
		JLabel pilha6 = new JLabel("");
		pilha6.setFont(new Font("Arial", Font.BOLD, 12));
		pilha6.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha6.setBounds(643, 291, 113, 25);
		contentPane.add(pilha6);
		
		JLabel pilha7 = new JLabel("");
		pilha7.setFont(new Font("Arial", Font.BOLD, 12));
		pilha7.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha7.setBounds(643, 257, 113, 25);
		contentPane.add(pilha7);
		
		JLabel pilha8 = new JLabel("");
		pilha8.setFont(new Font("Arial", Font.BOLD, 12));
		pilha8.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha8.setBounds(644, 224, 113, 25);
		contentPane.add(pilha8);
		
		JLabel pilha9 = new JLabel("");
		pilha9.setFont(new Font("Arial", Font.BOLD, 12));
		pilha9.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha9.setBounds(643, 188, 113, 25);
		contentPane.add(pilha9);
		
		JLabel pilha10 = new JLabel("");
		pilha10.setFont(new Font("Arial", Font.BOLD, 12));
		pilha10.setVerticalAlignment(SwingConstants.BOTTOM);
		pilha10.setBounds(643, 152, 113, 25);
		contentPane.add(pilha10);
		// FIM LABELS DA PILHA
		
		JComboBox registradores = new JComboBox();
		registradores.setBackground(SystemColor.menu);
		registradores.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}));
		registradores.setToolTipText("REGS");
		registradores.setBounds(187, 175, 85, 29);
		contentPane.add(registradores);
		
		JLabel regA = new JLabel("A = " + regs[0]);
		regA.setForeground(new Color(105, 105, 105));
		regA.setFont(new Font("Arial", Font.BOLD, 18));
		regA.setBounds(47, 243, 71, 20);
		contentPane.add(regA);
		
		JLabel regB = new JLabel("B = " + regs[1]);
		regB.setForeground(new Color(105, 105, 105));
		regB.setFont(new Font("Arial", Font.BOLD, 18));
		regB.setBounds(47, 282, 71, 20);
		contentPane.add(regB);
		
		JLabel regC = new JLabel("C = " + regs[2]);
		regC.setForeground(Color.GRAY);
		regC.setFont(new Font("Arial", Font.BOLD, 18));
		regC.setBounds(115, 243, 71, 20);
		contentPane.add(regC);
		
		JLabel regE = new JLabel("E = " + regs[3]);
		regE.setForeground(new Color(105, 105, 105));
		regE.setFont(new Font("Arial", Font.BOLD, 18));
		regE.setBounds(189, 243, 71, 20);
		contentPane.add(regE);
		
		JLabel regG = new JLabel("G = " + regs[4]);
		regG.setForeground(Color.GRAY);
		regG.setFont(new Font("Arial", Font.BOLD, 18));
		regG.setBounds(257, 243, 71, 20);
		contentPane.add(regG);
		
		JLabel regI = new JLabel("I = " + regs[5]);
		regI.setForeground(new Color(105, 105, 105));
		regI.setFont(new Font("Arial", Font.BOLD, 18));
		regI.setBounds(324, 243, 71, 20);
		contentPane.add(regI);
		
		JLabel regD = new JLabel("D = " + regs[6]);
		regD.setForeground(Color.GRAY);
		regD.setFont(new Font("Arial", Font.BOLD, 18));
		regD.setBounds(115, 282, 71, 20);
		contentPane.add(regD);
		
		JLabel regF = new JLabel("F = " + regs[7]);
		regF.setForeground(new Color(105, 105, 105));
		regF.setFont(new Font("Arial", Font.BOLD, 18));
		regF.setBounds(189, 282, 71, 20);
		contentPane.add(regF);
		
		JLabel regH = new JLabel("H = " + regs[8]);
		regH.setForeground(Color.GRAY);
		regH.setFont(new Font("Arial", Font.BOLD, 18));
		regH.setBounds(257, 282, 71, 20);
		contentPane.add(regH);
		
		JLabel regJ = new JLabel("J = " + regs[9]);
		regJ.setForeground(new Color(105, 105, 105));
		regJ.setFont(new Font("Arial", Font.BOLD, 18));
		regJ.setBounds(324, 282, 71, 20);
		contentPane.add(regJ);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valorRegInt = 0;
				try {
					valorRegInt = Integer.parseInt(valorReg.getText());
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(InterfaceMain.this, "Passe um número válido!");
				}
				
				if(registradores.getSelectedItem().equals("A")) {
					regs[0] = valorRegInt; 
					regA.setText("A = " + regs[0]);
				} else if(registradores.getSelectedItem().equals("B")){
					regs[1] = valorRegInt;
					regB.setText("B = " + regs[1]);
				} else if(registradores.getSelectedItem().equals("C")){
					regs[2] = valorRegInt;
					regC.setText("C = " + regs[2]);
				} else if(registradores.getSelectedItem().equals("D")){
					regs[3] = valorRegInt;
					regD.setText("D = " + regs[3]);
				} else if(registradores.getSelectedItem().equals("E")){
					regs[4] = valorRegInt;
					regE.setText("E = " + regs[4]);
				} else if(registradores.getSelectedItem().equals("F")){
					regs[5] = valorRegInt;
					regF.setText("F = " + regs[5]);
				} else if(registradores.getSelectedItem().equals("G")){
					regs[6] = valorRegInt;
					regG.setText("G = " + regs[6]);
				} else if(registradores.getSelectedItem().equals("H")){
					regs[7] = valorRegInt;
					regH.setText("H = " + regs[7]);
				} else if(registradores.getSelectedItem().equals("I")){
					regs[8] = valorRegInt;
					regI.setText("I = " + regs[8]);
				} else if(registradores.getSelectedItem().equals("J")){
					regs[9] = valorRegInt;
					regJ.setText("J = " + regs[9]);
				} 
			}
		});
		
		btnAdicionar.setBackground(SystemColor.controlHighlight);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setBounds(282, 174, 94, 29);
		contentPane.add(btnAdicionar);
		
		JLabel p_endereco1 = new JLabel("");
		p_endereco1.setVerticalAlignment(SwingConstants.BOTTOM);
		p_endereco1.setFont(new Font("Arial", Font.BOLD, 12));
		p_endereco1.setBounds(846, 168, 50, 25);
		contentPane.add(p_endereco1);
		
		JLabel p_endereco2 = new JLabel("");
		p_endereco2.setVerticalAlignment(SwingConstants.BOTTOM);
		p_endereco2.setFont(new Font("Arial", Font.BOLD, 12));
		p_endereco2.setBounds(846, 197, 50, 25);
		contentPane.add(p_endereco2);
		
		JLabel p_endereco3 = new JLabel("");
		p_endereco3.setVerticalAlignment(SwingConstants.BOTTOM);
		p_endereco3.setFont(new Font("Arial", Font.BOLD, 12));
		p_endereco3.setBounds(846, 228, 50, 25);
		contentPane.add(p_endereco3);
		
		JLabel p_endereco4 = new JLabel("");
		p_endereco4.setVerticalAlignment(SwingConstants.BOTTOM);
		p_endereco4.setFont(new Font("Arial", Font.BOLD, 12));
		p_endereco4.setBounds(846, 257, 50, 25);
		contentPane.add(p_endereco4);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setForeground(Color.BLACK);
		separator_21.setBounds(836, 472, 219, 20);
		contentPane.add(separator_21);
		
		JLabel p_endereco5 = new JLabel("");
		p_endereco5.setVerticalAlignment(SwingConstants.BOTTOM);
		p_endereco5.setFont(new Font("Arial", Font.BOLD, 12));
		p_endereco5.setBounds(846, 287, 50, 25);
		contentPane.add(p_endereco5);
		
		JLabel p_dados5 = new JLabel("");
		p_dados5.setVerticalAlignment(SwingConstants.BOTTOM);
		p_dados5.setFont(new Font("Arial", Font.BOLD, 12));
		p_dados5.setBounds(850, 470, 46, 25);
		contentPane.add(p_dados5);
		
		JLabel p_dados4 = new JLabel("");
		p_dados4.setVerticalAlignment(SwingConstants.BOTTOM);
		p_dados4.setFont(new Font("Arial", Font.BOLD, 12));
		p_dados4.setBounds(850, 440, 46, 25);
		contentPane.add(p_dados4);
		
		JLabel p_dados3 = new JLabel("");
		p_dados3.setVerticalAlignment(SwingConstants.BOTTOM);
		p_dados3.setFont(new Font("Arial", Font.BOLD, 12));
		p_dados3.setBounds(850, 411, 46, 25);
		contentPane.add(p_dados3);
		
		JLabel p_dados2 = new JLabel("");
		p_dados2.setVerticalAlignment(SwingConstants.BOTTOM);
		p_dados2.setFont(new Font("Arial", Font.BOLD, 12));
		p_dados2.setBounds(850, 380, 46, 25);
		contentPane.add(p_dados2);
		
		JLabel p_dados1 = new JLabel("");
		p_dados1.setVerticalAlignment(SwingConstants.BOTTOM);
		p_dados1.setFont(new Font("Arial", Font.BOLD, 12));
		p_dados1.setBounds(850, 351, 46, 25);
		contentPane.add(p_dados1);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setOrientation(SwingConstants.VERTICAL);
		separator_15.setForeground(SystemColor.controlShadow);
		separator_15.setBounds(797, 142, 29, 341);
		contentPane.add(separator_15);
		
		JLabel endereco1 = new JLabel("");
		endereco1.setVerticalAlignment(SwingConstants.BOTTOM);
		endereco1.setFont(new Font("Arial", Font.BOLD, 12));
		endereco1.setBounds(919, 169, 134, 25);
		contentPane.add(endereco1);
		
		JLabel endereco2 = new JLabel("");
		endereco2.setVerticalAlignment(SwingConstants.BOTTOM);
		endereco2.setFont(new Font("Arial", Font.BOLD, 12));
		endereco2.setBounds(919, 198, 134, 25);
		contentPane.add(endereco2);
		
		JLabel endereco3 = new JLabel("");
		endereco3.setVerticalAlignment(SwingConstants.BOTTOM);
		endereco3.setFont(new Font("Arial", Font.BOLD, 12));
		endereco3.setBounds(919, 229, 134, 25);
		contentPane.add(endereco3);
		
		JLabel endereco4 = new JLabel("");
		endereco4.setVerticalAlignment(SwingConstants.BOTTOM);
		endereco4.setFont(new Font("Arial", Font.BOLD, 12));
		endereco4.setBounds(919, 261, 134, 25);
		contentPane.add(endereco4);
		
		JLabel endereco5 = new JLabel("");
		endereco5.setVerticalAlignment(SwingConstants.BOTTOM);
		endereco5.setFont(new Font("Arial", Font.BOLD, 12));
		endereco5.setBounds(919, 291, 134, 25);
		contentPane.add(endereco5);
		
		JLabel dados1 = new JLabel("");
		dados1.setVerticalAlignment(SwingConstants.BOTTOM);
		dados1.setFont(new Font("Arial", Font.BOLD, 12));
		dados1.setBounds(919, 351, 123, 25);
		contentPane.add(dados1);
		
		JLabel dados2 = new JLabel("");
		dados2.setVerticalAlignment(SwingConstants.BOTTOM);
		dados2.setFont(new Font("Arial", Font.BOLD, 12));
		dados2.setBounds(919, 380, 123, 25);
		contentPane.add(dados2);
		
		JLabel dados3 = new JLabel("");
		dados3.setVerticalAlignment(SwingConstants.BOTTOM);
		dados3.setFont(new Font("Arial", Font.BOLD, 12));
		dados3.setBounds(919, 411, 123, 25);
		contentPane.add(dados3);
		
		JLabel dados4 = new JLabel("");
		dados4.setVerticalAlignment(SwingConstants.BOTTOM);
		dados4.setFont(new Font("Arial", Font.BOLD, 12));
		dados4.setBounds(919, 440, 123, 25);
		contentPane.add(dados4);
		
		JLabel dados5 = new JLabel("");
		dados5.setVerticalAlignment(SwingConstants.BOTTOM);
		dados5.setFont(new Font("Arial", Font.BOLD, 12));
		dados5.setBounds(919, 471, 123, 24);
		contentPane.add(dados5);
		
		
		JLabel[] campoPilha = {pilha1, pilha2, pilha3, pilha4, pilha5, pilha6, pilha7, pilha8, pilha9, pilha10};
		JLabel[] memoriaInstrucoes = {endereco1, endereco2, endereco3, endereco4, endereco5};
		JLabel[] p_memoriaInstrucoes = {p_endereco1, p_endereco2, p_endereco3, p_endereco4, p_endereco5};
		JLabel[] memoriaDados = {dados1, dados2, dados3, dados4, dados5};
		JLabel[] p_memoriaDados = {p_dados1, p_dados2, p_dados3, p_dados4, p_dados5};
		
		JTextArea campoInstrucoes = new JTextArea();
		campoInstrucoes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campoInstrucoes.setBounds(40, 361, 332, 79);
		contentPane.add(campoInstrucoes);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instrucao = campoInstrucoes.getText();
				
				if (instrucao.length() >= 5)
					instrucaoCompleta = instrucao.split(" ");
				else
					instrucaoCompleta[0] = instrucao;
				
				switch (instrucaoCompleta[0].trim().toUpperCase()) {
				case "POP":
					if(operandos[0] != null || operandos[1] != null) {
						switch (instrucaoCompleta[1].trim().toUpperCase()) {
						case "A":
							popPilha(pilha, regs, 0, "A", regA);
							break;
						case "B":
							popPilha(pilha, regs, 1, "B", regB);
							break;
						case "C":
							popPilha(pilha, regs, 2, "C", regC);
							break;
						case "D":
							popPilha(pilha, regs, 3, "D", regD);
							break;
						case "E":
							popPilha(pilha, regs, 4, "E", regE);
							break;
						case "F":
							popPilha(pilha, regs, 5, "F", regF);
							break;
						case "G":
							popPilha(pilha, regs, 6, "G", regG);
							break;
						case "H":
							popPilha(pilha, regs, 7, "H", regH);
							break;
						case "I":
							popPilha(pilha, regs, 8, "I", regI);
							break;
						case "J":
							popPilha(pilha, regs, 9, "J", regJ);
							break;
		
						default:
							JOptionPane.showMessageDialog(InterfaceMain.this, "Registrador não encontrado!");
							break;
						}
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "PUSH":
					switch (instrucaoCompleta[1].trim().toUpperCase()) {
					case "A":
						pushPilha(pilha, regs, 0);
						break;
					case "B":
						pushPilha(pilha, regs, 1);
						break;
					case "C":
						pushPilha(pilha, regs, 2);
						break;
					case "D":
						pushPilha(pilha, regs, 3);
						break;
					case "E":
						pushPilha(pilha, regs, 4);
						break;
					case "F":
						pushPilha(pilha, regs, 5);
						break;
					case "G":
						pushPilha(pilha, regs, 6);
						break;
					case "H":
						pushPilha(pilha, regs, 7);
						break;
					case "I":
						pushPilha(pilha, regs, 8);
						break;
					case "J":
						pushPilha(pilha, regs, 9);
						break;

					default:
						JOptionPane.showMessageDialog(InterfaceMain.this, "Registrador não encontrado!");
						break;
					}
					break;
				case "ADD":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] + pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "SUB":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] - pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "MULT":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] * pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "DIV":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] / pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "AND":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] & pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "OR":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] | pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "XOR":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						r2 = operandos[1];
						pilha[r2] = pilha[r2] ^ pilha[r1];
						pilha[r1] = null;
					} else {
						JOptionPane.showMessageDialog(InterfaceMain.this, "Não é possível executar esta instrução!");
					}
					break;
				case "NOT":
					operandos = operandosPilha(pilha);
					if(operandos[0] != null){
						r1 = operandos[0];
						pilha[r1] = ~pilha[r1];
					} else {
						pilha[0] = ~pilha[0];
					}
					break;
					
				default:
					JOptionPane.showMessageDialog(InterfaceMain.this, "Instrução não reconhecida!");
					break;
				}
				//String pilhaTexto = imprimirPilha(pilha, campoPilha);
				//pilha1.setText(pilhaTexto);
				imprimirPilha(pilha, campoPilha);
				campoInstrucoes.setText("");
			}
		});
		btnExecutar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExecutar.setBackground(SystemColor.controlHighlight);
		btnExecutar.setBounds(278, 454, 94, 29);
		contentPane.add(btnExecutar);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(40, 363, 336, 79);
		contentPane.add(panel);
		
		JLabel lblPilha = new JLabel("PILHA");
		lblPilha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPilha.setBounds(625, 121, 44, 20);
		contentPane.add(lblPilha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(432, 199, 85, 30);
		contentPane.add(panel_1);
		
		JLabel pc = new JLabel("");
		panel_1.add(pc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(432, 314, 85, 30);
		contentPane.add(panel_2);
		
		JLabel ir = new JLabel("");
		panel_2.add(ir);
		
		JLabel lblNewLabel = new JLabel("PC");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(432, 174, 29, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIr.setBounds(432, 288, 29, 14);
		contentPane.add(lblIr);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 0, 1094, 79);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 534, 1094, 38);
		contentPane.add(panel_4);
		
		JLabel copyrigth = new JLabel("\u00A9 Desenvolvido por Adlem, Breno e Victor");
		panel_4.add(copyrigth);
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.controlShadow);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(405, 134, 29, 341);
		contentPane.add(separator);
		
		JLabel lblRegistradores = new JLabel("Registradores");
		lblRegistradores.setForeground(SystemColor.windowBorder);
		lblRegistradores.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblRegistradores.setBounds(40, 214, 181, 20);
		contentPane.add(lblRegistradores);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setForeground(SystemColor.controlShadow);
		separator_10.setBounds(40, 273, 342, 20);
		contentPane.add(separator_10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBounds(537, 462, 219, 20);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.desktop);
		separator_2.setBounds(537, 430, 219, 20);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(537, 394, 219, 20);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(537, 359, 219, 20);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(537, 322, 219, 20);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(537, 291, 219, 20);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(537, 257, 219, 20);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(537, 224, 219, 20);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(Color.BLACK);
		separator_9.setBounds(537, 188, 219, 20);
		contentPane.add(separator_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(537, 152, 221, 343);
		contentPane.add(panel_6);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setForeground(SystemColor.controlShadow);
		separator_11.setBounds(185, 237, 29, 73);
		contentPane.add(separator_11);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setOrientation(SwingConstants.VERTICAL);
		separator_12.setForeground(SystemColor.controlShadow);
		separator_12.setBounds(255, 237, 29, 73);
		contentPane.add(separator_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setOrientation(SwingConstants.VERTICAL);
		separator_13.setForeground(SystemColor.controlShadow);
		separator_13.setBounds(321, 237, 29, 73);
		contentPane.add(separator_13);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setOrientation(SwingConstants.VERTICAL);
		separator_14.setForeground(SystemColor.controlShadow);
		separator_14.setBounds(112, 237, 29, 73);
		contentPane.add(separator_14);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar, SystemColor.scrollbar));
		panel_5.setBackground(SystemColor.controlHighlight);
		panel_5.setBounds(40, 234, 342, 79);
		contentPane.add(panel_5);
		
		JSeparator separator_22 = new JSeparator();
		separator_22.setForeground(Color.BLACK);
		separator_22.setBounds(836, 253, 219, 20);
		contentPane.add(separator_22);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setForeground(Color.BLACK);
		separator_23.setBounds(836, 223, 219, 20);
		contentPane.add(separator_23);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setForeground(Color.BLACK);
		separator_24.setBounds(836, 193, 219, 20);
		contentPane.add(separator_24);
		
		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o        Instru\u00E7\u00E3o");
		lblPosio.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPosio.setFont(new Font("Arial", Font.BOLD, 12));
		lblPosio.setBounds(850, 134, 169, 25);
		contentPane.add(lblPosio);
		
		JSeparator separator_26 = new JSeparator();
		separator_26.setOrientation(SwingConstants.VERTICAL);
		separator_26.setForeground(SystemColor.desktop);
		separator_26.setBounds(906, 139, 29, 361);
		contentPane.add(separator_26);
		
		JLabel lblPosioDados = new JLabel("Posi\u00E7\u00E3o        Dados");
		lblPosioDados.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPosioDados.setFont(new Font("Arial", Font.BOLD, 12));
		lblPosioDados.setBounds(850, 318, 169, 25);
		contentPane.add(lblPosioDados);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		panel_7.setBackground(SystemColor.controlHighlight);
		panel_7.setBounds(836, 136, 221, 30);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		panel_8.setBackground(SystemColor.controlHighlight);
		panel_8.setBounds(836, 318, 221, 32);
		contentPane.add(panel_8);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setForeground(Color.BLACK);
		separator_16.setBounds(836, 380, 220, 20);
		contentPane.add(separator_16);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setForeground(Color.BLACK);
		separator_17.setBounds(836, 286, 219, 20);
		contentPane.add(separator_17);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setForeground(Color.BLACK);
		separator_18.setBounds(836, 320, 220, 20);
		contentPane.add(separator_18);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setForeground(Color.BLACK);
		separator_19.setBounds(836, 440, 217, 20);
		contentPane.add(separator_19);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setForeground(Color.BLACK);
		separator_20.setBounds(836, 410, 221, 20);
		contentPane.add(separator_20);
		
		JLabel lblMemria = new JLabel("MEM\u00D3RIA");
		lblMemria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMemria.setBounds(909, 110, 97, 20);
		contentPane.add(lblMemria);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop, SystemColor.desktop));
		panel_9.setBackground(SystemColor.menu);
		panel_9.setBounds(836, 159, 221, 342);
		contentPane.add(panel_9);
		
		JButton button = new JButton("Executar");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(0, 0, 94, 29);
		contentPane.add(button);
		
	}
	
	static void popPilha(Integer[] pilha, Integer[] regs, int indice, String letraReg, JLabel label) {
		Integer[] operandos = operandosPilha(pilha);
		Integer topo = operandos[0];
		if(topo != null) {
			regs[indice] = pilha[topo];
			pilha[topo] = null;
			label.setText(letraReg + " = " + regs[indice]);
		} else {
			regs[indice] = pilha[0];
			pilha[0] = null;
			label.setText(letraReg + " = " + regs[indice]);
		}
	}
	
	static Integer[] operandosPilha(Integer[] pilha){
		Integer[] operandos = new Integer[2];
		int index = 0;
		for (int i = 0; i < pilha.length; i++) {
			if (pilha[i] == null) {
				index = i;
				break;
			} else {
				index = pilha.length;
			}
		}
		if ((index - 2) >= 0) {
			operandos[0] = (index - 1);
			operandos[1] = (index - 2);	
		} 
		return operandos;
	}
	
	static void pushPilha(Integer[] pilha, Integer[] regs, int index){
		for (int i = 0; i < pilha.length; i++) {
			if (pilha[i] == null) {
				pilha[i] = regs[index];
				break;
			}
		}
	}
	
	static void imprimirPilha(Integer[] registradores, JLabel[] labels){
		String[] pilhaString = new String[10];
		
		for (int i = registradores.length - 1; i >= 0; i--) {
			if (registradores[i] == null){ 
				labels[i].setText("");
			}else{ 
				labels[i].setText("" + registradores[i]);
			}
		}
		
		String str = "";
	    for (int i = pilhaString.length-1; i >= 0 ; i--){   
	      str = str + pilhaString[i];
	    }
	}
}