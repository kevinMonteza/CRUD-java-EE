package com.cursomvc.pack;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instanciando el pool de conexiones
	@Resource(name = "jdbc/Productos")
	private DataSource miPool;
	//***************************************************
	private ModeloProducto modelo;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modelo = new ModeloProducto(miPool);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String instruccion = request.getParameter("instruccion");
		if (instruccion != null) {
			switch (instruccion) {
			case "insertar":
				try {
					insertarProductos(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "actualizar":
				actualizarProductos(request, response);
				break;
			case "eliminar":
				try {
					eliminarProdctos(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "cargar":
				try {
					cargarProd(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			default:
				listarProductos(request, response);
			}
		}
		else {
			listarProductos(request, response);
		}

	}

	private void eliminarProdctos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String codigo=request.getParameter("cArt");
		modelo.deleteProduct(codigo);
		listarProductos(request, response);
	}

	private void cargarProd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cod= request.getParameter("cArt");
		try {
		Producto product=modelo.cargarProd(cod);
		request.setAttribute("ElCodigo",product);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	

	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) 
	 {
			// TODO Auto-generated method stub
			SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
			Producto productoActualizado;
			String codigo=request.getParameter("cArt");
			String seccion=request.getParameter("seccion");
			String nombre=request.getParameter("nomArt");
			Date fecha=null;
			try {
			    fecha=formato.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Double precio=Double.parseDouble(request.getParameter("precio"));
			String importado=request.getParameter("import");
			String origin=request.getParameter("origin");
			productoActualizado= new Producto(codigo,seccion,nombre,precio,fecha,importado,origin);
			try {
				modelo.updateProduct(productoActualizado);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listarProductos(request, response);
		}

	private void insertarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
		Producto newProduct;
		String codigo=request.getParameter("CodArt");
		String seccion=request.getParameter("seccion");
		String nombre=request.getParameter("nomArt");
		Date fecha=null;
		try {
		    fecha=formato.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double precio=Double.parseDouble(request.getParameter("precio"));
		String importado=request.getParameter("import");
		String origin=request.getParameter("origin");
		newProduct= new Producto(codigo,seccion,nombre,precio,fecha,importado,origin);
		modelo.addProduct(newProduct);
		listarProductos(request, response);
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Producto> lista;
		try {
			lista = modelo.getProductos();
			request.setAttribute("ListaProductos", lista);
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			miDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
