import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.CompraDAO;
import dao.carrinhoDAO;
import dao.clienteDAO;
import dao.produtoDAO;
import pojo.Carrinho;
import pojo.Cliente;
import pojo.Compra;
import pojo.Produto;


import dao.categoriaDAO;
import pojo.Categoria;

public class loja {

	public static void main(String[] args)  {
		clienteDAO cliente = new clienteDAO();
		categoriaDAO categoria = new categoriaDAO();
		produtoDAO produto = new produtoDAO();
		CompraDAO compra = new CompraDAO();
		carrinhoDAO carrinho = new carrinhoDAO();
		int op;
		boolean sair = false;
		Scanner in = new Scanner(System.in);
	
		do {
			System.out.println(" 1 - Cadastrar cliente");
			System.out.println(" 2 - Listar clientes");
			System.out.println(" 3 - Excluir cliente");
			System.out.println(" 4 - Cadastrar categoria");
			System.out.println(" 5 - Listar categorias");
			System.out.println(" 6 - Excluir categoria");
			System.out.println(" 7 - Cadastrar produto");
			System.out.println(" 8 - Listar produtos");
			System.out.println(" 9 - Excluir produto");
			System.out.println(" 10 - Comprar");
			System.out.println(" 11 - Adicionar ao carrinho");
			System.out.println(" 12 - Listar Compras");
			System.out.println(" 13 - Excluir produto do carrinho");
			System.out.println("14 - Finalizar compra");
			System.out.println("15 - Excluir compra");
			System.out.println(" 0 - Sair");
			
			op = in.nextInt();
			in.nextLine(); //Eliminar buffer
			switch(op) {
			case 1:
				String nome, email, endereco, cidade, cep, telefone;
				System.out.println("Digite o nome do cliente:");
				nome = in.nextLine();
				System.out.println("Digite o email do cliente:");
				email = in.nextLine();
				System.out.println("Digite o endereço do cliente:");
				endereco = in.nextLine();
				System.out.println("Digite a cidade do cliente:");
				cidade = in.nextLine();
				System.out.println("Digite o cep do cliente:");
				cep = in.nextLine();
				System.out.println("Digite o telefone do cliente:");
				telefone = in.nextLine();
				Cliente cli = new Cliente(nome, email, endereco, cidade, cep, telefone);
				
				//Se o retorno do mï¿½todo adicionarUsuario for true, exibirï¿½ a mensagem de sucesso
				if(cliente.addCli(cli)) {
					System.out.println("Usuário adicionado com sucesso!");
				}else {
					System.err.println("Ocorreu algum erro ao inserir o usuário");
				}
				break;
				
			case 2:
				ArrayList<Cliente> listaClientes = cliente.listarClientes();
				for(Cliente c : listaClientes) {
					System.out.println(c.toString());
				}
				break;
			case 3:
				System.out.println("Digite o ID do usuário a ser excluído");
				int id = in.nextInt();
				if(cliente.excluirCliente(id)) {
					System.out.println("Usuário excluído com sucesso!");
				}else {
					System.err.println("Erro ao excluir usuário.");
				}
				break;
			case 4:
				String catNome;
				System.out.println("Digite o nome da categoria:");
				catNome = in.nextLine();
				Categoria cat = new Categoria(catNome);
				
				//Se o retorno do mï¿½todo adicionarUsuario for true, exibirï¿½ a mensagem de sucesso
				if(categoria.addCat(cat)) {
					System.out.println("Categoria adicionada com sucesso!");
				}else {
					System.err.println("Ocorreu algum erro ao inserir o usuário");
				}
				break;
			case 5:
				ArrayList<Categoria> listaCategoria = categoria.listarCategorias();
				for(Categoria ct : listaCategoria) {
					System.out.println(ct.toString());
				}
				break;
			case 6:
				System.out.println("Digite o ID da categoria a ser excluï¿½do");
				int idCat = in.nextInt();
				if(cliente.excluirCliente(idCat)) {
					System.out.println("Usuário excluído com sucesso!");
				}else {
					System.err.println("Erro ao excluir usuário.");
				}
				break;
				
			case 7:
				String descricao;
				int Cat, qtde;
				BigDecimal precoCusto, precoVenda;
				
				System.out.println("Digite a descricao do produto");
				descricao = in.nextLine();
				System.out.println("Digite a categoria do produto:");
				Cat = in.nextInt();
				System.out.println("Digite o preco de custo do produto");
				precoCusto = in.nextBigDecimal();
				System.out.println("Digite o preco de venda do produto");
				precoVenda = in.nextBigDecimal();
				System.out.println("Digite a quantidade a ser registrada");
				qtde = in.nextInt();
				Produto pro = new Produto(descricao, Cat, precoCusto, precoVenda, qtde);
				
				//Se o retorno do mï¿½todo adicionarUsuario for true, exibirï¿½ a mensagem de sucesso
				if(produto.addPro(pro)) {
					System.out.println("Usuï¿½rio adicionado com sucesso!");
				}else {
					System.err.println("Ocorreu algum erro ao inserir o usuário");
				}
				break;
				
			case 8:
				ArrayList<Produto> listaProdutos = produto.listarProdutos();
				for(Produto p: listaProdutos) {
					System.out.println(p.toString());
				}
				break;
				
			case 9:
				System.out.println("Digite o ID do produto a ser excluído");
				int idPro = in.nextInt();
				if(produto.excluirProduto(idPro)) {
					System.out.println("Produto excluído com sucesso!");
				}else {
					System.err.println("Erro ao excluir produto.");
				}
				break;
			case 10:
				System.out.println("Digite o ID do cliente:");
				int idCli = in.nextInt();
				System.out.println("Digite a data da compra:");
				String dataC = in.next();
			
				
				Compra c = new Compra(idCli, dataC);
				
				
			
				if(compra.addCompra(c)) {
					System.out.println("Digite o ID do produto que deseja adcionar ao carrinho:");
					int idP = in.nextInt();
					int cId = compra.getCompraById(idCli);
					
					System.out.println("Digite a quantidade do produto que deseja adcionar:");
					int qtd = in.nextInt();
					
					Carrinho carr = new Carrinho(cId, idP, qtd);
					
					//Se o retorno do mï¿½todo adicionarUsuario for true, exibirï¿½ a mensagem de sucesso
					if(carrinho.addCar(carr)) {
						System.out.println("Produto adicionado com sucesso!");
					}else {
						System.err.println("Ocorreu algum erro ao inserir o produto");
					}
				}else {
					System.err.println("Ocorreu algum erro ao inserir a compra");
				}
				break;
			case 11:
				System.out.println("Digite o ID da compra que deseja adcionar ao carrinho:");
				int cId = in.nextInt();
				System.out.println("Digite o ID do produto que deseja adcionar ao carrinho:");
				int idP = in.nextInt();
				
				
				System.out.println("Digite a quantidade do produto que deseja adcionar:");
				int qtd = in.nextInt();
				
				Carrinho carr = new Carrinho(cId, idP, qtd);
				
				//Se o retorno do mï¿½todo adicionarUsuario for true, exibirï¿½ a mensagem de sucesso
				if(carrinho.addCar(carr)) {
					System.out.println("Produto adicionado com sucesso!");
				}else {
					System.err.println("Ocorreu algum erro ao inserir o produto");
				}
				break;
			case 12:
				ArrayList<Compra> listaCompras = compra.listarCompras();
				for(Compra p: listaCompras) {
					System.out.println(p.toString());
				}
				break;
             case 13:
				System.out.println("Digite o ID do produto a ser excluÃ­do do carrinho");
				int idProCar = in.nextInt();
				if(carrinho.excluirProdutoCar(idProCar)) {
					System.out.println("Produto excluÃ­do com sucesso!");
				}else {
					System.err.println("Erro ao excluir produto.");
				}
				break;
	
        case 14:
			System.out.println("Digite o ID da compra a ser finalizada!");
			int compraId = in.nextInt();
			BigDecimal frete = new BigDecimal(10);
			String data = "12-12-12";
			if(compra.finalizarCompra(data, frete, compraId)) {
				System.out.println("Compra finalizada com sucesso!");
			}else {
				System.err.println("Falha ao finalizar compra.");
			}
			break;
        case 15:
        	System.out.println("Digite o ID da compra a ser excluida!");
        	int idC = in.nextInt();
        	if(carrinho.excluirCar(idC)){
			if(compra.excluirCompra(idC)) {
				System.out.println("Compra excluída com sucesso!");
			}else {
				System.err.println("Erro ao excluir compra.");
			}
        	}else{
        		System.err.println("Erro ao excluir compra.");
        	}
		}
	
	}while(!sair);
}

	

}