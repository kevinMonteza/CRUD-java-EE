package com.cursomvc.pack;

import java.util.Date;

public class Producto {
	
	
	
	public Producto(String cArt, String seccion, String nArt, Double precio, Date fecha, String importado,
			String paisO) {
		this.cArt = cArt;
		this.seccion = seccion;
		this.nArt = nArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisO = paisO;
	}
	public Producto(String seccion, String nArt, Double precio, Date fecha, String importado, String paisO) {
		this.seccion = seccion;
		this.nArt = nArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisO = paisO;
	}
	private String cArt;
	private String seccion;
	private String nArt;
	private Double precio;
	private Date fecha;
	private String importado;
	private String paisO;
	public String getcArt() {
		return cArt;
	}
	public void setcArt(String cArt) {
		this.cArt = cArt;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getnArt() {
		return nArt;
	}
	public void setnArt(String nArt) {
		this.nArt = nArt;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}
	public String getPaisO() {
		return paisO;
	}
	public void setPaisO(String paisO) {
		this.paisO = paisO;
	}
	@Override
	public String toString() {
		return "Producto [cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", precio=" + precio + ", fecha="
				+ fecha + ", importado=" + importado + ", paisO=" + paisO + "]";
	}
	
	
}
