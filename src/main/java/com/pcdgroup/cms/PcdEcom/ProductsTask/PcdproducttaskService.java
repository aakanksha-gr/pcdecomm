package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

public interface PcdproducttaskService {

	public String createPcdproducttask(Pcdproducttaskmaster pcdproducttaskmaster);
	public Pcdproducttaskmaster getPcdproducttask(Integer pcdproducttaskid);
	public List<Pcdproducttaskmaster> getAllPcdproducttask();
	public String deletePcdproducttask(Integer pcdproducttaskid);
	public String updatePcdproducttask(Pcdproducttaskmaster pcdproducttaskmaster, Integer pcdproducttaskid);
	public List<?> getAlltaskByProductId(Integer pid);
	
}
