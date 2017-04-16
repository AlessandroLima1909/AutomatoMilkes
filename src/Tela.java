
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Tela extends JFrame {

    Container c;
    JLabel tfNotas, tfTitulo, tfProdutos;
    JButton btn1, btn2, btn5, btnA, btnB, btnC, btnZerar;
    JTextArea taCaixaDeSaida;
    JPanel pEsquerda, pDireita, pCentral;
    JScrollPane scbBarra;
    Modelo modelo;

    double saldo, cotaDisponivel, troco;

    //parâmetros da tela
    public Tela(Modelo modelo) {
        setTitle("AFD - Máquina de doces");
        setSize(600, 400);
        setLocation(100, 100);
        iniciarElementos();
        this.modelo = modelo;
        
       
        
        
        setBotoesProdutos(false);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //desativa as notas caso elas não possam ser mais inseridas
    public void regularBotoesNotas(int cotaDisponivel) {
        if (cotaDisponivel < 5) {
            btn5.setEnabled(false);
            if (cotaDisponivel < 2) {
                btn2.setEnabled(false);
                if (cotaDisponivel < 1) {
                    btn1.setEnabled(false);
                }
            }

        }
    }

    //ativa os produtos que podem ser comprados
    public void regularBotoesProdutos(int creditoDisponivel) {
        if (creditoDisponivel >= 6) {
            btnA.setEnabled(true);
            if (creditoDisponivel >= 7) {
                btnB.setEnabled(true);
                if (creditoDisponivel >= 8) {
                    btnC.setEnabled(true);
                }
            }

        }
    }

    //define o mesmo valor pra todos os botões (pra ativar/desativar tudo)
    public void setBotoesNotas(boolean valor) {
        btn5.setEnabled(valor);
        btn2.setEnabled(valor);
        btn1.setEnabled(valor);
    }

    //define o mesmo valor pra todos os botões (pra ativar/desativar tudo)
    public void setBotoesProdutos(boolean valor) {
        btnA.setEnabled(valor);
        btnB.setEnabled(valor);
        btnC.setEnabled(valor);
    }

    public void escreverSaida(String texto)
    {
        taCaixaDeSaida.setText(taCaixaDeSaida.getText()+"\n"+texto);
    }
    //Iniciar elementos da tela
    public void iniciarElementos() {
        c = getContentPane();
        c.setLayout(new BorderLayout());
        tfNotas = new JLabel("INSERIR",JLabel.CENTER);
        tfTitulo = new JLabel("Loja de doces da mãe do japa ", JLabel.CENTER);
        tfProdutos = new JLabel("PRODUTOS",JLabel.CENTER);
        btn1 = new JButton("1 real");
        btn2 = new JButton("2 reais");
        btn5 = new JButton("5 reais");
        btnA = new JButton("Doce A");
        btnB = new JButton("Doce B");
        btnC = new JButton("Doce C");
        btnZerar = new JButton("ZERAR");
        taCaixaDeSaida = new JTextArea("[ -- LOJA DE DOCES DA MÃE DO JAPA -- ]\n");
        taCaixaDeSaida.setEditable(false);
        pEsquerda = new JPanel(new GridLayout(4, 1));
        pDireita = new JPanel(new GridLayout(4, 1));
        pCentral = new JPanel(new BorderLayout());
        scbBarra = new JScrollPane(taCaixaDeSaida);

    }

}
