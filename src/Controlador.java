public class Controlador extends Modelo {

	// Verifica se ainda é possivel aceitar a nota
	public boolean validarEntradaDeNota(double nota) {
		if (getSaldo() + nota <= getMAXIMO_DINHEIRO()) {
			setSaldo(nota);
			return true;
		}
		return false;
	}

	// Debitar o valor do produto
	public double debitarProduto(double valor) {
		return getSaldo() - valor;
	}
}
