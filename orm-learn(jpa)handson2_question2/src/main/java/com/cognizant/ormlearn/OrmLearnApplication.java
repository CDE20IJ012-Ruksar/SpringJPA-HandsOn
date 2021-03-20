package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.Stock.Stock;
import com.cognizant.ormlearn.StockRepository.StockRepository;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class OrmLearnApplication {

	public static void main(String[] args) throws ParseException  {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		StockRepository stockRepository = context.getBean(StockRepository.class);
		//Date date=new Date();
		//date.setDate(2019-04-25);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate =formatter.parse("2019-09-01");
		Date endDate =formatter.parse("2019-09-30");
		List<Stock> stock_date_for_sept = stockRepository.findAllByDateBetween(startDate , endDate);
		System.out.println(stock_date_for_sept);
		
		List<Stock> stock_price = stockRepository.findAllByStockopenGreaterThan(new BigDecimal(1250));
		System.out.println(stock_price);
	
		List<Stock> highest_stock_volume_dates = stockRepository.findTop3ByOrderByStockvolumeDesc();
		System.out.println(highest_stock_volume_dates);
		
		String code="NFLX";
		List<Stock> lowest_netflix__stock_volume = stockRepository.findTop3ByStockcodeOrderByStockcloseAsc(code);
		System.out.println(lowest_netflix__stock_volume);
	}


}