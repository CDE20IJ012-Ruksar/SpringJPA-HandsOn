package com.cognizant.ormlearn.StockRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.Stock.Stock;


public interface StockRepository extends CrudRepository<Stock, Integer>{
	public List<Stock> findAllByDateBetween(Date startDate, Date endDate);
	public List<Stock> findAllByStockopenGreaterThan(BigDecimal price);
	public List<Stock> findTop3ByOrderByStockvolumeDesc();
	public List<Stock> findTop3ByStockcodeOrderByStockcloseAsc(String stockcode);
	
}

