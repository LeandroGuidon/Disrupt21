package br.com.fiap.disrupt21.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.disrupt21.bo.PersonagemBO;
import br.com.fiap.disrupt21.model.PersonagemBean;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet(
		description = "Para teste de conexão", 
		urlPatterns = { 
				"/Cadastrar", 
				"/Remover",
				"/Selecao"
		})
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTeste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getRequestURI()) {
		
		case "/Disrupt21/Cadastrar":
			CadastroPersonagem(request, response);
			break;
		
		case "/Disrupt21/Remover":
			RemocaoPersonagem(request, response);
			break;
		case "/Disrupt21/Selecao":
			SelecaoPersonagem(request, response);
			break;
		
		default:
			System.out.println(request.getRequestURI());
			
		}
	}
	
	public void CadastroPersonagem (HttpServletRequest request, HttpServletResponse response) {
		PersonagemBean p1 = new PersonagemBean();			
		p1.setNome(request.getParameter("txtNm"));
		p1.setAno(Integer.parseInt(request.getParameter("txtAno")));
		p1.setTipo(Integer.parseInt(request.getParameter("txtTipo")));
		p1.setMissao(request.getParameter("txtMissao"));
		
		System.out.println(p1.getNome());
		System.out.println(p1.getAno());
		System.out.println(p1.getTipo());
		System.out.println(p1.getMissao());
		
		PersonagemBO pBo = new PersonagemBO();
		
		int status = pBo.InserirPersonagem(p1);

		try {
			switch(status) {
				
			case 1:
				response.sendRedirect("Teste.jsp?msgStatus=Os dados foram inseridos com sucesso!");
				break;
			case 2:
				response.sendRedirect("Teste.jsp?msgStatus2=Ano inválido!");
				break;
			case 3:
				response.sendRedirect("Teste.jsp?msgStatus3=Digite até 30 caractéres.");
				break;
			case 4:
				response.sendRedirect("Teste.jsp?msgStatus4=Digite até 500 caractéres.");
				break;
			case 5:
				response.sendRedirect("Teste.jsp?msgStatus5=Tipo de personagem incompatível. Digite 1 para principal ou 2 para secundário.");
				break;
			case 6:
				response.sendRedirect("Teste.jsp?msgStatus=Outro erro.");
				break;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public void RemocaoPersonagem (HttpServletRequest request, HttpServletResponse response) {
		PersonagemBean p1 = new PersonagemBean();
		p1.setNome(request.getParameter("txtNm"));
		p1.setAno(Integer.parseInt(request.getParameter("txtAno")));
		
		PersonagemBO pBo = new PersonagemBO();
		
		int status = pBo.RemoverPersonagem(p1);
		
		try {
			switch(status) {
				
			case 1:
				response.sendRedirect("TesteRemo.jsp?msgStatus=Os dados foram inseridos com sucesso!");
				break;
			case 2:
				response.sendRedirect("TesteRemo.jsp?msgStatus2=Ano inválido!");
				break;
			case 3:
				response.sendRedirect("TesteRemo.jsp?msgStatus3=Digite até 30 caractéres.");
				break;
			case 6:
				response.sendRedirect("TesteRemo.jsp?msgStatus=Outro erro.");
				break;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void SelecaoPersonagem (HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("txtNm");
		int ano = Integer.parseInt(request.getParameter("txtAno"));
		System.out.println(nome + ano);
		
		
		//PersonagemBO pBo = new PersonagemBO();
		//PersonagemBean p1 = pBo.SelecionarPersonagem(nome, ano);
		PersonagemBean p2 = new PersonagemBean();
		p2.setNome("Leandro");
		
		if(p2 != null) {
		
			request.setAttribute("objPersonagem", p2);
			
			//Criar um atributo e inserir o ID do cliente
			//request.setAttribute("objIdCli", idCli);
			try {
				request.getRequestDispatcher("Destino.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
