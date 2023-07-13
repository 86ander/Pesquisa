import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Pesquisa extends JFrame implements ActionListener{
	
	private JLabel lblNome,lblEscolaridade,lblIdiomas;
	private JTextField txtNome;
	private JRadioButton rbFundamentalIncompleto,rbFundamentalCompleto,rbEnsinoMedioIncompleto,
	rbEnsinoMedioCompleto,rbSuperiorIncompleto,rbSuperiorCompleto,rbEspecialista,rbMestre,rbDoutor;
	private ButtonGroup grupo;
	private JCheckBox cbIngles,cbEspanhol,cbOutro;
	private JButton btnOk,btnFechar;
	private GridBagConstraints restricoes=new GridBagConstraints();
	private JPanel pnlCima,pnlBaixo,pnlPesquisa;
	
	public Pesquisa()
	{
		this.setTitle("Pesquisa");
		this.setSize(320,180);
		this.setLocation(300,80);
		this.setResizable(false);
		restricoes.fill = GridBagConstraints.BOTH;
		
		lblNome=new JLabel("Nome:",JLabel.RIGHT);
		txtNome = new JTextField(20);
		txtNome.setToolTipText("Digite o seu nome");
		
		lblEscolaridade=new JLabel("Escolaridade:",JLabel.RIGHT);
		grupo=new ButtonGroup();
	    rbFundamentalIncompleto=new JRadioButton("Fundamental Incompleto");
	    rbFundamentalIncompleto.setToolTipText("Escolaridade fundamental incompleto");
	    grupo.add(rbFundamentalIncompleto);
	    rbFundamentalCompleto=new JRadioButton("Fundamental Completo");
	    rbFundamentalCompleto.setToolTipText("Escolaridade fundamental completo");
	    grupo.add(rbFundamentalCompleto);
	    rbEnsinoMedioIncompleto=new JRadioButton("Ensino Médio Incompleto");
	    rbEnsinoMedioIncompleto.setToolTipText("Escolaridade ensino médio incompleto");
	    grupo.add(rbEnsinoMedioIncompleto);
	    rbEnsinoMedioCompleto=new JRadioButton("Ensino Médio Completo");
	    rbEnsinoMedioCompleto.setToolTipText("Escolaridade ensino médio completo");
	    grupo.add(rbEnsinoMedioCompleto);
	    rbSuperiorIncompleto=new JRadioButton("Superior Incompleto");
	    rbSuperiorIncompleto.setToolTipText("Escolaridade superior incompleto");
	    grupo.add(rbSuperiorIncompleto);
	    rbSuperiorCompleto=new JRadioButton("Superior Completo");
	    rbSuperiorCompleto.setToolTipText("Escolaridade superior completo");
	    grupo.add(rbSuperiorCompleto);
	    rbEspecialista=new JRadioButton("Especialista");
	    rbEspecialista.setToolTipText("Escolaridade especialista");
	    grupo.add(rbEspecialista);
	    rbMestre=new JRadioButton("Mestre");
	    rbMestre.setToolTipText("Escolaridade mestre");
	    grupo.add(rbMestre);
	    rbDoutor=new JRadioButton("Doutor(a)");
	    rbDoutor.setToolTipText("Escolaridade doutor(a)");
	    grupo.add(rbDoutor);
	    rbFundamentalIncompleto.setSelected(true);
	    
	    lblIdiomas=new JLabel("Idiomas que você é fluente:",JLabel.RIGHT);
	    cbIngles = new JCheckBox("Inglês");
	    cbIngles.setToolTipText("Fluente em Inglês");
	    cbEspanhol = new JCheckBox("Espanhol");
	    cbEspanhol.setToolTipText("Fluente em Espanhol");
	    cbOutro = new JCheckBox("Outro");
	    cbOutro.setToolTipText("Fluente em outro idioma que não é nem Inglês nem Espanhol");
	    
	    btnOk = new JButton("OK");
	    btnOk.setMnemonic('O');
	    btnOk.setToolTipText("Verifica se os dados foram preenchidos");
	    btnOk.addActionListener(this);
	    
	    btnFechar = new JButton("Fechar");
	    btnFechar.setMnemonic('F');
	    btnFechar.setToolTipText("Fecha a tela");
	    btnFechar.addActionListener(this);
	    
	    pnlCima=new JPanel(new GridBagLayout());
		restricoes.insets=new Insets(8,8,8,8);
		addGridBag(0,0,lblNome,pnlCima);
		restricoes.gridwidth=2;
		addGridBag(1,0,txtNome,pnlCima);
		restricoes.gridwidth=1;
		addGridBag(0,1,lblEscolaridade,pnlCima);
		addGridBag(0,2,rbFundamentalIncompleto,pnlCima);
		addGridBag(1,2,rbFundamentalCompleto,pnlCima);
		addGridBag(0,3,rbEnsinoMedioIncompleto,pnlCima);
		addGridBag(1,3,rbEnsinoMedioCompleto,pnlCima);
		addGridBag(0,4,rbSuperiorIncompleto,pnlCima);
		addGridBag(1,4,rbSuperiorCompleto,pnlCima);
		addGridBag(0,5,rbEspecialista,pnlCima);
		addGridBag(1,5,rbMestre,pnlCima);
		addGridBag(0,6,rbDoutor,pnlCima);
		addGridBag(0,7,lblIdiomas,pnlCima);
		addGridBag(0,8,cbIngles,pnlCima);
		addGridBag(1,8,cbEspanhol,pnlCima);
		addGridBag(2,8,cbOutro,pnlCima);
		
		pnlBaixo=new JPanel(new GridBagLayout());
		addGridBag(0,0,btnOk,pnlBaixo);
		addGridBag(1,0,btnFechar,pnlBaixo);
		
		pnlPesquisa=new JPanel(new GridBagLayout());
		addGridBag(0,0,pnlCima,pnlPesquisa);
		addGridBag(0,1,pnlBaixo,pnlPesquisa);
		
		Container P = getContentPane();
		P.add(pnlPesquisa);
		pack();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object origem = event.getSource();
		if (origem == btnOk)
		{
			if (txtNome.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"É necessário informar o seu nome",
						"Nome Inválido",JOptionPane.ERROR_MESSAGE);
			}else
			{
				String texto = "Nome: " + txtNome.getText().toString() + "\n";
				if (rbFundamentalIncompleto.isSelected())
					texto = texto + "Escolaridade: Fundamental Incompleto\n";
				else if (rbFundamentalCompleto.isSelected())
					texto = texto + "Escolaridade: Fundamental Completo\n";
				else if (rbEnsinoMedioIncompleto.isSelected())
					texto = texto + "Escolaridade: Ensino Médio Incompleto\n";
				else if (rbEnsinoMedioCompleto.isSelected())
					texto = texto + "Escolaridade: Ensino Médio Completo\n";
				else if (rbSuperiorIncompleto.isSelected())
					texto = texto + "Escolaridade: Superior Incompleto\n";
				else if (rbSuperiorCompleto.isSelected())
					texto = texto + "Escolaridade: Superior Completo\n";
				else if (rbEspecialista.isSelected())
					texto = texto + "Escolaridade: Especialista\n";
				else if (rbMestre.isSelected())
					texto = texto + "Escolaridade: Mestre\n";
				else if (rbDoutor.isSelected())
					texto = texto + "Escolaridade: Doutor(a)\n";
				if (cbIngles.isSelected())
					texto = texto + "Você é fluente no idioma Inglês\n";
				if (cbEspanhol.isSelected())
					texto = texto + "Você é fluente no idioma Espanhol\n";
				if (cbOutro.isSelected())
					texto = texto + "Você é fluente em outro idioma\n";
				JOptionPane.showMessageDialog(null,texto,
						"Pesquisa",JOptionPane.INFORMATION_MESSAGE);
			}
		}else if (origem == btnFechar)
		{
			dispose();
		}
	}
	
	public void addGridBag(final int x,final int y,final Component obj,final JPanel pnl)
	{
		restricoes.gridx=x;
		restricoes.gridy=y;
		pnl.add(obj,restricoes);
	}
	
	public static void main(String[] args) {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setVisible(true);
	}

}
