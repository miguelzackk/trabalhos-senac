package javaxTask;

import javax.swing.JOptionPane;

public class Cenario02 {

	public static void main(String[] args) {
		int dec = 0;

		JOptionPane.showMessageDialog(null, "Bem vindo(a) ao nosso gerenciador de produto.");

		Produto02 prod = new Produto02();
		do {
			prod.prod = JOptionPane.showInputDialog("Digite qual o produto deseja adicionar.");
			prod.preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço desse produto."));
			prod.quant = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desse produto em estoque."));

			JOptionPane.showMessageDialog(null, "\nProduto: " + prod.prod + "." + "\nPreço: R$"
					+ String.format("%.2f", prod.preco) + "." + "\nQuantidade: " + prod.quant + ".");
			int result = JOptionPane.showConfirmDialog(null, "Você deseja sair da calculadora?", "Calculadora",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				dec = 0;
			} else if (result == JOptionPane.NO_OPTION) {
				dec = 1;
			}
		} while (dec != 0);
	}

}
