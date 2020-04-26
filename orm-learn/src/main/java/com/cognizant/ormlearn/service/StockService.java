package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepository;
	
	@Transactional
	public List<Stock> findAllTillSep(){
		return stockRepository.findAllTillSep();
	}
	
	@Transactional
	public List<Stock> findGoogle1250(){
		return stockRepository.findGoogle1250();
	}
	
	@Transactional
	public List<Stock> findTop3ByOrderByVolumeDesc(){
		return stockRepository.findTop3ByOrderByVolumeDesc();
	}
	
	@Transactional
	public List<Stock> findTop3ByCodeOrderByClose(String code){
		return stockRepository.findTop3ByCodeOrderByClose(code);
	}
}
