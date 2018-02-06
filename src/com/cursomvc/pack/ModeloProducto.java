package com.cursomvc.pack;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import java.sql.PreparedStatement;

public class ModeloProducto {
	private DataSource origenDatos;

	public ModeloProducto(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public List<Producto> getProductos() throws Exception {
		Producto prod = null;
		List<Producto> productos = new ArrayList<>();
		Connection miConex = null;
		Statement miStatement = null;
		ResultSet rs = null;
		try{
		miConex = origenDatos.getConnection();
		String sql = "SELECT * FROM `table 2` ";
		miStatement = miConex.createStatement();
		rs = miStatement.executeQuery(sql);
		while (rs.next()) {
			prod = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5),
					rs.getString(6), rs.getString(7));
			productos.add(prod);
		}
		}finally{
			miStatement.close();
			miConex.close();
		}
		return productos;
	}

	public void addProduct(Producto newProduct) throws Exception{
		// TODO Auto-generated method stub
		Connection conexion = null;
		PreparedStatement miStatement = null;
		try {
			conexion = origenDatos.getConnection();
			String sql = "INSERT INTO `table 2`(`CODIGOARTICULO`, `SECCION`, `NOMBREARTÍCULO`, `PRECIO`, `FECHA`, `IMPORTADO`, `PAISDEORIGEN`)"
					+ "VALUES(?,?,?,?,?,?,?)";
			miStatement = conexion.prepareStatement(sql);
			miStatement.setString(1, newProduct.getcArt());
			miStatement.setString(2, newProduct.getSeccion());
			miStatement.setString(3, newProduct.getnArt());
			miStatement.setDouble(4, newProduct.getPrecio());
			java.util.Date utilDato=newProduct.getFecha();
			java.sql.Date fechaConv= new java.sql.Date(utilDato.getTime());
			miStatement.setDate(5,fechaConv);
			miStatement.setString(6, newProduct.getImportado());
			miStatement.setString(7, newProduct.getPaisO());
			miStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			miStatement.close();
			conexion.close();
		}

	}

	public Producto cargarProd(String cod) throws Exception{
		Producto pro= null;
		Connection conexion=null;
		PreparedStatement miStatement=null;
		ResultSet rs=null;
		
		
		try {
			conexion=origenDatos.getConnection();
			String sql="SELECT * FROM `table 2` WHERE CODIGOARTICULO=?";
			miStatement=conexion.prepareStatement(sql);
			miStatement.setString(1,cod);
			rs=miStatement.executeQuery();
			if(rs.next()){
				pro = new Producto( rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5),
						rs.getString(6), rs.getString(7));
			}else{
				throw new Exception("No se encontro el articulo con codigo articulo="+cod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			miStatement.close();
			conexion.close();
		}
		return pro;
	}

	public void updateProduct(Producto newProduct) throws Exception {
		// TODO Auto-generated method stub
		Connection conexion = null;
		PreparedStatement miStatement = null;
		try {
			conexion = origenDatos.getConnection();
			String sql = "UPDATE `table 2` SET `SECCION`=?, `NOMBREARTÍCULO`=?, `PRECIO`=?, `FECHA`=?, "
					+ "`IMPORTADO`=?, `PAISDEORIGEN`=? WHERE `CODIGOARTICULO`=?";
			miStatement = conexion.prepareStatement(sql);
			miStatement.setString(1, newProduct.getSeccion());
			miStatement.setString(2, newProduct.getnArt());
			miStatement.setDouble(3, newProduct.getPrecio());
			java.util.Date utilDato=newProduct.getFecha();
			java.sql.Date fechaConv= new java.sql.Date(utilDato.getTime());
			miStatement.setDate(4,fechaConv);
			miStatement.setString(5, newProduct.getImportado());
			miStatement.setString(6, newProduct.getPaisO());
			miStatement.setString(7, newProduct.getcArt());
			miStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			miStatement.close();
			conexion.close();
		}
	}

	public void deleteProduct(String codigo) throws Exception{
		// TODO Auto-generated method stub
		Connection conexion = null;
		PreparedStatement miStatement = null;
		try{
			conexion=origenDatos.getConnection();
			String sql="DELETE FROM `table 2` WHERE `CODIGOARTICULO`=?";
			miStatement=conexion.prepareStatement(sql);
			miStatement.setString(1,codigo);
			miStatement.executeQuery();
		}catch(SQLException e){
			e.getStackTrace();
			e.getMessage();
		}finally{
			miStatement.close();
			conexion.close();
		}
	}
}
