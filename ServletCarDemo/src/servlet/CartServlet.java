package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDao;
import entity.Cart;
import entity.Items;

public class CartServlet extends HttpServlet {
	private String action;//����
	private ItemsDao idao=new ItemsDao();
	

	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(request.getParameter("action")!=null){
			this.action = request.getParameter("action");
			if(action.equals("add")){//�����������Ʒ�����ﳵ
				if(addToCart(request,response)){
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/failure .jsp").forward(request, response);
				}
			}
			if(action.equals("show")){
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if(action.equals("delete")){//ɾ��
				if(deleteFromCart(request,response)){
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}

	private boolean deleteFromCart(HttpServletRequest request,
			HttpServletResponse response) {
		String id=request.getParameter("id");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		Items item = idao.getItemsById(Integer.parseInt(id));
		if(cart.removeGoodFromCart(item)){
			return true;
		}else {
			return false;
		}
	}

	private boolean addToCart(HttpServletRequest request,
			HttpServletResponse response) {
		//��ҳ��ȡ����
		String id=request.getParameter("id");
		String number=request.getParameter("num");
		Items item=idao.getItemsById(Integer.parseInt(id));
		
		//�Ƿ��һ�����ﳵ������Ʒ ��������Ӵ���session
		if(request.getSession().getAttribute("cart")==null){
			Cart cart=new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(cart.addGoodsInCart(item, Integer.parseInt(number))){
			return true;
		}else{
			return false;
		}
				

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}