package SistemaVendas;

import java.util.InputMismatchException;

import java.util.Scanner;

public class SistemaVendas {
	static Pedidos pedido;
	static Orcamento orcamento;
	static Produto produto;
	static Cliente cliente;
	static String nomeProduto;
	static double quantidadeProduto;
	static double valorProduto;
	static String usuario;
	static String senha;
	static Login login;

	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);

	public static void main(String[] args) {
		produto = new Produto();
		cliente = new Cliente();
		pedido = new Pedidos();
		orcamento = new Orcamento();
		login = new Login();

		boolean logado = false;

		do {

			System.out.println(" _____________________________ ");
			System.out.println("|    SISTEMA DE VENDAS        |");
			System.out.println("|_____________________________|");

			System.out.println(" USUÁRIO:");
			System.out.println("_________");
			usuario = scan.nextLine();

			System.out.println("SENHA:");
			System.out.println("_________");
			senha = scan.nextLine();

			logado = login.Logar(usuario, senha);

		} while (!logado);
		System.out.println(" _____________________________ ");
		System.out.println("|     SISTEMA DE VENDAS       | ");
		System.out.println("|_____________________________|");

		System.out.println(" __________________ ");
		System.out.println("|1-VENDER PRODUTO  |");
		System.out.println("|__________________|");
		System.out.println("|2-FAZER ORÇAMENTO |");
		System.out.println("|__________________|");
		System.out.println("|3-SAIR DO SISTEMA |");
		System.out.println("|__________________|");

		int opcao1 = scan.nextInt();

		switch (opcao1) {

		case 1:
			vender();
			break;
		case 2:
			orcamento();
			break;
		default:
			sair();
			break;
		}
		
	}

	private static void orcamento() {
		System.out.println(" __________________ ");
		System.out.println("|                  |");
		System.out.println("|REALIZAR ORÇAMENTO|");
		System.out.println("|__________________|");
		int opcao;


		do {
			System.out.println(" _____________________ ");
			System.out.println("|1-INCLUIR PRODUTO    |");
			System.out.println("|_____________________| ");
			System.out.println("|2-ALTERAR PRODUTO    |");
			System.out.println("|_____________________| ");
			System.out.println("|3-EXCLUIR PRODUTO    |");
			System.out.println("|_____________________| ");
			System.out.println("|4-LISTAR PRODUTOS    |");
			System.out.println("|_____________________| ");
			System.out.println("|5-FINALIZAR ORÇAMENTO|");
			System.out.println("|_____________________| ");

			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				incluirOrcamento();
				break;
			case 2:
				alterarOrcamento();
				break;
			case 3:
				excluirOrcamento();
				break;
			case 4:
				listarOrcamento();
				break;
			default:
				finalizarOrcamento();
				opcao = 5;
				break;
			}

		} while (opcao != 5);
		

	}

	private static void sair() {

		System.out.println(" CLOSE");

	}

	private static void vender() {
		System.out.println(" __________________ ");
		System.out.println("|                  |");
		System.out.println("| REALIZAR PEDIDO  |");
		System.out.println("|__________________|");
		int opcao;
		
		do {
			System.out.println(" __________________ ");
			System.out.println("|1-INCLUIR PRODUTO |");
			System.out.println("|__________________| ");
			System.out.println("|2-ALTERAR PRODUTO |");
			System.out.println("|__________________| ");
			System.out.println("|3-EXCLUIR PRODUTO |");
			System.out.println("|__________________| ");
			System.out.println("|4-LISTAR PRODUTOS |");
			System.out.println("|__________________| ");
			System.out.println("|5-FINALIZAR PEDIDO|");
			System.out.println("|__________________| ");

			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				incluirPedido();
				break;
			case 2:
				alterarPedido();
				break;
			case 3:
				excluirPedido();
				break;
			case 4:
				listarPedido();
				break;
			case 5:
				finalizarPedido();
				break;

			default:

				opcao = 6;
				break;

			}

		} while (opcao != 6);
		
	}

	public static void incluirOrcamento() {

		String continuar = "sim";

		
		do {

			try {

				System.out.println(" Informe o nome do Produto:");
				produto.setNome(scan.next());
				System.out.println(" Informe a quantidade do Produto: ");
				produto.setQuantidade(scan.nextDouble());
				System.out.println(" Informe o valor do Produto R$: ");
				produto.setValor(scan.nextDouble());
				orcamento.adicionarProduto(produto);
				produto = new Produto();
				System.out.println("Deseja inserir mais um produto ?");
				continuar = scan.next();
			} catch (InputMismatchException erro1) {
				System.out.println(" Não é permitido inserir letras informe somente números");
				scan.nextLine();
			}

		} while (continuar.equals("sim"));

		
	}

	public static void alterarOrcamento() {
		try {
			System.out.println(" Informe o nome do produto que deseja alterar");
			nomeProduto = scan1.nextLine();
			System.out.println(" Informe a quantidade do produto");
			quantidadeProduto = scan1.nextDouble();
			System.out.println(" Informe a valor do produto");
			valorProduto = scan1.nextDouble();

			Produto alterar = new Produto();

			alterar.setNome(nomeProduto);
			alterar.setQuantidade(quantidadeProduto);
			alterar.setValor(valorProduto);

			orcamento.alterarProduto(alterar);

			
		} catch (Exception ex) {

		}

	}

	public static void excluirOrcamento() {
		
			System.out.println("Iforme o produto que será removido");
			nomeProduto = scan1.next();
			orcamento.removerProduto(nomeProduto);

		
	}

	public static void listarOrcamento() {
		System.out.println(" __________________");
		System.out.println("| LISTA DE PRODUTOS|");
		System.out.println("|__________________|");
		for (Produto produto : orcamento.getListaProdutos()) {
			System.out.println("Produto:" + produto.getNome());
			System.out.println("Quantidade:" + produto.getQuantidade());
			System.out.println("Valor:"+ produto.getValor());
		}
	}

	public static void finalizarOrcamento() {
		try {
			System.out.println("Informe o nome do cliente");
			cliente.setNome(scan.next());
			System.out.println(" Informe o telefone do cliente");
			cliente.setTelefone(scan.next());

			System.out.println("VALOR TOTAL DO ORÇAMENTO:" + orcamento.getTotal() + " Reais");
			System.out.println("Informe o nome do cliente:" + cliente.getNome());
			System.out.println("Informe o Telefone:" + cliente.getTelefone());
			System.out.println("LISTA DE PEDIDOS " + orcamento.getListaProdutos());
		} catch (Exception ex) {
			
		}
	}

	//PEDIDO
	
	public static void incluirPedido() {

		String continuar = "sim";
		
		do {

			try {

				System.out.println(" Informe o nome do Produto:");
				produto.setNome(scan.next());
				System.out.println(" Informe a quantidade do Produto: ");
				produto.setQuantidade(scan.nextDouble());
				System.out.println(" Informe o valor do Produto R$: ");
				produto.setValor(scan.nextDouble());
				pedido.adicionarProduto(produto);
				produto = new Produto();
				System.out.println("Deseja inserir mais um produto ?");
				continuar = scan.next();

			} catch (InputMismatchException erro1) {
				System.out.println("Não é permitido inserir letras informe somente números");
				scan.nextLine();
			}

		} while (continuar.equals("sim"));

		
	}

	public static void alterarPedido() {
		try {
			System.out.println(" Informe o nome do produto que deseja alterar");
			nomeProduto = scan1.next();
			System.out.println(" Informe a quantidade do produto");
			quantidadeProduto = scan1.nextDouble();
			System.out.println(" Informe a valor do produto");
			valorProduto = scan1.nextDouble();

			Produto alterar = new Produto();

			alterar.setNome(nomeProduto);
			alterar.setQuantidade(quantidadeProduto);
			alterar.setValor(valorProduto);

			pedido.alterarProduto(alterar);

			
		} catch (Exception ex) {

		}

	}

	public static void excluirPedido() {
		
			System.out.println("Iforme o produto que será removido");
	     	nomeProduto = scan1.next();
			pedido.removerProduto(nomeProduto);
		
		
	}

	public static void listarPedido() {
		System.out.println(" __________________");
		System.out.println("| LISTA DE PRODUTOS|");
		System.out.println("|__________________|");
		for (Produto produto : pedido.getListaProdutos()) {
			System.out.println(" Produto:" + produto.getNome());
			System.out.println(" Quantidade:" + produto.getQuantidade());
			System.out.println(" Valor:" + produto.getValor());
		}
	}

	public static void finalizarPedido() {

		System.out.println("Informe o nome do cliente");
		cliente.setNome(scan.next());
		System.out.println(" Informe o telefone do cliente");
		cliente.setTelefone(scan.next());

		System.out.println("O VALOR TOTAL DO PEDIDO É:" + pedido.getTotal() + " REAIS");
		System.out.println("CLIENTE:" + cliente.getNome());
		System.out.println("Telefone:" + cliente.getTelefone());
		System.out.println("PRODUTOS COMPRADOS \n " + pedido.getListaProdutos());

	}

	

}
