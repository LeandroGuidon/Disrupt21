package br.com.fiap.disrupt21.bo;

import java.util.ArrayList;

import br.com.fiap.disrupt21.dao.PersonagemDAO;
import br.com.fiap.disrupt21.model.PersonagemBean;

public class PersonagemBO {

	private PersonagemDAO pDao = new PersonagemDAO();
	
	/*Erros:
	 * 1 - Tudo correto.
	 * 2 - Ano inválido.
	 * 3 - Digite até 30 caractéres.
	 * 4 - Digite até 500 caractéres.
	 * 5 - Tipo de personagem incompatível. Digite 1 para principal ou 2 para secundário.
	 * 6 - Outro erro.
	*/
	public int InserirPersonagem(PersonagemBean p1) {
		if (p1.getAno() != 1955 && p1.getAno() != 1985 && p1.getAno() != 2015) {
			System.out.println("Ano invalido");
			return 2;
		}
		else if(p1.getNome().length() > 30) {
			System.out.println("Digite até 30 caractéres");
			return 3;
		}
		else if(p1.getMissao().length() > 500) {
			System.out.println("Digite até 500 caractéres");
			return 4;
		
		}
		else if(p1.getTipo()!=1 && p1.getTipo() != 2){
			System.out.println("Tipo de personagem incompativel. Digite 1 para principal e 2 para sencundario");
			return 5;
		}
		else {
			if (pDao.Inserir(p1)) {
				return 1;
			}else {
				return 6;
			}
		}
	}
	
	public int RemoverPersonagem(PersonagemBean p1) {
		
		if (p1.getAno() != 1955 && p1.getAno() != 1985 && p1.getAno() != 2015) {
			System.out.println("Ano invalido");
			return 2;
		}
		else if(p1.getNome().length() > 30) {
			System.out.println("Digite até 30 caractéres");
			return 3;
		}
		else {
			if (pDao.Remover(p1)) {
				return 1;
			}else {
				return 6;
			}
		}
	}
	
	public int EditarPersonagem(PersonagemBean p1) {
		
		if (p1.getAno() != 1955 && p1.getAno() != 1985 && p1.getAno() != 2015) {
			System.out.println("Ano invalido. Os anos permitidos são 1955, 1985 e 2015");
			return 2;
		}
		else if(p1.getNome().length() > 30) {
			System.out.println("Você ultrapassou o limite de caractéres. Digite até 30 caractéres");
			return 3;
		}
		else if(p1.getMissao().length() > 500) {
			System.out.println("Você ultrapassou o limite de caractéres. Digite até 500 caractéres");
			return 4;
		
		}
		else if(p1.getTipo()!=1 && p1.getTipo() != 2){
			System.out.println("Tipo de personagem incompativel. Digite 1 para principal e 2 para sencundario");
			return 5;
		}
		else {
			if (pDao.Remover(p1)) {
				return 1;
			}else {
				return 6;
			}
		}
	}
	
	public ArrayList<PersonagemBean> ListarPersonagens(){
		return pDao.buscaPersonagens();
	}
	
	public PersonagemBean SelecionarPersonagem(String nome, int ano) {
		return pDao.Selecionar(nome, ano);
		
	}
}
