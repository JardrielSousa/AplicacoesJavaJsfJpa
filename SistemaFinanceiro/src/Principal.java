import br.com.sistemaFinanceiro.model.Cliente;
import br.com.sistemaFinanceiro.model.Fornecedor;
import br.com.sistemaFinanceiro.service.ContaPagar;
import br.com.sistemaFinanceiro.service.ContaReceber;

public class Principal {

	public static void main(String[] args) {
		Fornecedor imobiliaria = new Fornecedor();
		imobiliaria.setNome("js tec");
		
		Fornecedor loja = new Fornecedor();
		loja.setNome("jsVariedades");
		
		Cliente dono = new Cliente();
		dono.setNome("jardriel");
		
		Cliente f = new Cliente();
		f.setNome("mae");
		
		ContaPagar conta1 = new ContaPagar(imobiliaria, "matrix", 1230d, "10/08/1997");
		
		ContaPagar conta2 = new ContaPagar(loja, "loja", 53030d, "10/08/1997");
		
		ContaReceber contaReceber = new ContaReceber(dono, "jsmultimarcas",236.00,"15/01/2020");
		ContaReceber contaReceber2 = new ContaReceber(dono, "jsVariedades",300.00,"15/01/2020");
		
		conta1.pagar();
		conta2.cancelar();
		
		contaReceber.receber();
		contaReceber2.cancelar();
	}

}
