package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hk.dao.BoardDAO;
import kr.co.hk.dto.S_Board_DTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[FrontController doGet메서드 실행]");
		String requri = request.getRequestURI();
		String ctxpath = request.getContextPath();
		String curi = requri.substring(ctxpath.length());
		System.out.println("requri = "+requri+", ctxpath = "+ctxpath+", curi = "+curi);
		
		if(curi.equals("/home.do")){
			request.setAttribute("sectionFlag", "home.jsp");
			request.setAttribute("flagTitle", "홈");
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
			rd.forward(request, response);
		}else if(curi.equals("/write.do")){
			request.setAttribute("sectionFlag", "write.jsp");
			request.setAttribute("flagTitle", "글쓰기");
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
			rd.forward(request, response);
		}else if(curi.equals("/list.do")){
			request.setAttribute("sectionFlag", "list.jsp");
			request.setAttribute("flagTitle", "글목록");
			List<S_Board_DTO> lsd = BoardDAO.getBoardDTOList();
			request.setAttribute("lsd", lsd);
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
			rd.forward(request, response);
		}else if(curi.equals("/listdetail.do")){
			request.setAttribute("sectionFlag", "listdetail.jsp");
			request.setAttribute("flagTitle", "게시글");
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
			rd.forward(request, response);
		}
		
		System.out.println("[FrontController doGet메서드 종료]");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[FrontController doPost메서드 실행]");
		request.setCharacterEncoding("UTF-8");
		
		String requri = request.getRequestURI();
		String ctxpath = request.getContextPath();
		String curi = requri.substring(ctxpath.length());
		System.out.println("requri = "+requri+", ctxpath = "+ctxpath+", curi = "+curi);
		
		if(curi.equals("/home.do")){
			
		}else if(curi.equals("/write.do")){
			S_Board_DTO dto = new S_Board_DTO();
			dto.setBoard_No(Integer.parseInt(request.getParameter("Board_No")));
			dto.setBoard_Title(request.getParameter("Board_Title"));
			dto.setBoard_Content(request.getParameter("Board_Content"));
			dto.setRegdate(request.getParameter("Regdate"));
			
			BoardDAO.insert_S_Board(dto);
			
			response.sendRedirect("list.do");
		}else if(curi.equals("/list.do")){
			
		}
		
		System.out.println("[FrontController doPost메서드 종료]");
	}

}
