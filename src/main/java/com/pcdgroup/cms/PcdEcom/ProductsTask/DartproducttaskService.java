package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

public interface DartproducttaskService {

	public String createDartproducttask(Dartproducttaskmaster dartproducttaskmaster);
	public Dartproducttaskmaster getDartproducttask(Integer dartproducttaskid);
	public List<Dartproducttaskmaster> getAllDartproducttask();
	public String deleteDartproducttask(Integer dartproducttaskid);
	public String updateDartproducttask(Dartproducttaskmaster dartproducttaskmaster, Integer dartproducttaskid);
	List<?> getDartproducttaskByProductid(Integer dartproductid);
	
}
