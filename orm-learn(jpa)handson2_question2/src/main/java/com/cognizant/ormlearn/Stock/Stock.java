package com.cognizant.ormlearn.Stock;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
@Id
@Column(name="st_id")
private int stock_id;
@Column(name="st_code")
private String stockcode;
@Column(name="st_date")
private Date date;
@Column(name="st_open")
private BigDecimal 	stockopen;
@Column(name="st_close")
private BigDecimal stockclose;
@Column(name="st_volume")
private BigDecimal stockvolume;
public int getStock_id() {
	return stock_id;
}
public void setStock_id(int stock_id) {
	this.stock_id = stock_id;
}
public String getStock_code() {
	return stockcode;
}
public void setStock_code(String stock_code) {
	this.stockcode = stock_code;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public BigDecimal getStock_open() {
	return stockopen;
}
public void setStock_open(BigDecimal stockopen) {
	this.stockopen = stockopen;
}
public BigDecimal getStock_close() {
	return stockclose;
}
public void setStock_close(BigDecimal stock_close) {
	this.stockclose = stock_close;
}
public BigDecimal getStock_volume() {
	return stockvolume;
}
public void setStock_volume(BigDecimal stock_volume) {
	this.stockvolume = stock_volume;
}

@Override
public String toString() {
	return "Stock [stock_id=" + stock_id + ", stock_code=" + stockcode + ", date=" + date + ", stock_open="
			+ stockopen + ", stock_close=" + stockclose + ", stock_volume=" + stockvolume + "]";
}


}
