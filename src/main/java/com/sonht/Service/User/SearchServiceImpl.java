package com.sonht.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Dao.SearchDao;
import com.sonht.Entity.Product;

@Service
public class SearchServiceImpl implements ISearchService{
	@Autowired
	private SearchDao searchDao;
	@Override
	public List<Product> searchByName(String txtSearch) {
		return searchDao.searchByName(txtSearch);
	}

}
