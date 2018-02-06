package com.cursomvc.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;





/**
 * Servlet implementation class controlServlet
 */
@WebServlet("/controlServlet")
public class controlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	  // definir o establecer el resource
	 @Resource(name="jdbc/Productos")
	 private DataSource miPool;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out= response.getWriter();
		String nombre="";
		response.setContentType("text/plain");
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet rs=null;
		
		try{
			miConexion=miPool.getConnection();
			
			String misql="SELECT * FROM `table 2`";
			miStatement=miConexion.createStatement();
			rs=miStatement.executeQuery(misql);
			while(rs.next()){
				out.print("Entro");
				nombre=rs.getString(3);
				out.println(nombre);
			}
		}catch(Exception e){
			out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
