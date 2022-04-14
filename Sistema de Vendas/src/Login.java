package SistemaVendas;

public class Login implements Autentificar {

	String usuario = "admin";
	String senha = "admin";

	public boolean Logar(String usuario, String senha) {

		if (usuario.equals(this.usuario) && senha.equals(this.senha)) {
			System.out.println(" ACESSO LIBERADO ");

			return true;
		} else {
			System.out.println(" USUÁRIO INVÁLIDO");

			return false;
		}
	}
}
