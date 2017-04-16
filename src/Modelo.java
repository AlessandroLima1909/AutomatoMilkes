
public class Modelo {
	private double saldo; // O que é colocado na maquina
	private final double MAXIMO_DINHEIRO = 10;// maximo de dinheiro que pode add na maquina(10 reais)

	public void setSaldo(double nota) {
		this.saldo += nota;
	}
	
	public void zerarSaldo(){
		this.saldo = 0;
	}
	
	public double getSaldo(){
		return saldo;
	}

	public double getMAXIMO_DINHEIRO() {
		return MAXIMO_DINHEIRO;
	}

}
