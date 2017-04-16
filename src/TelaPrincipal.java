import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {
	private Container c;
	private JLabel tfNotas, tfProdutos, tfSaldo;
	private JButton btnUmReal, btnDoisReais, btnCincoReais, btnProdA, btnProdB, btnProdC;
	private JPanel pEsquerda, pDireita, pCentral;
	public Controlador controlador = new Controlador();

	public TelaPrincipal() {
		super("AFD - Maquina de doces [ -- LOJA DE DOCES DA MÃE DO JAPA -- ]");

		iniciarElementos();
		pEsquerda.add(tfNotas);
		pEsquerda.add(btnUmReal);
		pEsquerda.add(btnDoisReais);
		pEsquerda.add(btnCincoReais);
		pDireita.add(tfProdutos);
		pDireita.add(btnProdA);
		pDireita.add(btnProdB);
		pDireita.add(btnProdC);
		pCentral.add(tfSaldo);
		c.add(pEsquerda, BorderLayout.WEST);
		c.add(pDireita, BorderLayout.EAST);
		c.add(pCentral, BorderLayout.CENTER);

		setBotoesProdutos(false);

		Acoes acoes = new Acoes();
		btnUmReal.addActionListener(acoes);
		btnDoisReais.addActionListener(acoes);
		btnCincoReais.addActionListener(acoes);
		btnProdA.addActionListener(acoes);
		btnProdB.addActionListener(acoes);
		btnProdC.addActionListener(acoes);

		// Tela
		setSize(600, 400);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void iniciarElementos() {
		c = this.getContentPane();
		c.setLayout(new BorderLayout());

		tfNotas = new JLabel("INSERIR", JLabel.CENTER);
		tfProdutos = new JLabel("PRODUTOS", JLabel.CENTER);
		tfSaldo = new JLabel("R$ 0,00", JLabel.CENTER);
		btnUmReal = new JButton("R$ 1,00");
		btnDoisReais = new JButton("R$ 2,00");
		btnCincoReais = new JButton("R$ 5,00");
		btnProdA = new JButton("Doce A - R$ 6,00");
		btnProdB = new JButton("Doce B - R$ 7,00");
		btnProdC = new JButton("Doce C - R$ 8,00");
		pEsquerda = new JPanel(new GridLayout(4, 1));
		pDireita = new JPanel(new GridLayout(4, 1));
		pCentral = new JPanel(new BorderLayout());
	}

	// define o mesmo valor pra todos os botões (ativar/desativar tudo)
	public void setBotoesProdutos(boolean valor) {
		btnProdA.setEnabled(valor);
		btnProdB.setEnabled(valor);
		btnProdC.setEnabled(valor);
	}
	
	//Alterar a visibilidade dos botões de acordo com o valor de saldo
	public void setBotoesProdutos(double saldo) {
		if (saldo == 6) {
			btnProdA.setEnabled(true);
		}
		if (saldo == 7) {
			btnProdA.setEnabled(true);
			btnProdB.setEnabled(true);
		}
		if (saldo >= 8) {
			btnProdA.setEnabled(true);
			btnProdB.setEnabled(true);
			btnProdC.setEnabled(true);
		}
	}

	//Alterar o valor o saldo na tela
	public void alterarSaldoTela() {
		tfSaldo.setText("R$ " + controlador.getSaldo());
	}

	//Informar que o valor do saldo ja está no limite
	public void saldoMaior() {
		JOptionPane.showMessageDialog(null, "O valor máximo de saldo é R$ " + controlador.getMAXIMO_DINHEIRO());
	}

	//Zerar todos os valores da tela para reiniciar a maquina
	public void zerarTudo() {
		setBotoesProdutos(false);
		controlador.zerarSaldo();
		alterarSaldoTela();
	}

	//Informar o valor do troco e zerar a tela
	public void informarTroco(double valor) {
		zerarTudo();
		if (valor == 0) {
			JOptionPane.showMessageDialog(null, "Sem Troco");
		} else {
			JOptionPane.showMessageDialog(null, "Troco = R$ " + valor);
		}
	}

	//Ações dos botões
	private class Acoes implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnUmReal) {
				if (controlador.validarEntradaDeNota(1)) {
					alterarSaldoTela();
					setBotoesProdutos(controlador.getSaldo());
				} else
					saldoMaior();

			} else if (event.getSource() == btnDoisReais) {
				if (controlador.validarEntradaDeNota(2)) {
					alterarSaldoTela();
					setBotoesProdutos(controlador.getSaldo());
				} else
					saldoMaior();

			} else if (event.getSource() == btnCincoReais) {
				if (controlador.validarEntradaDeNota(5)) {
					alterarSaldoTela();
					setBotoesProdutos(controlador.getSaldo());
				} else
					saldoMaior();

			} else if (event.getSource() == btnProdA) {
				informarTroco(controlador.debitarProduto(6));

			} else if (event.getSource() == btnProdB) {
				informarTroco(controlador.debitarProduto(7));

			} else if (event.getSource() == btnProdC) {
				informarTroco(controlador.debitarProduto(8));

			}
		}
	}

}
