package com.ty.foodorder.Service;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DAO.ProductDAO ;
import com.ty.foodorder.DTO.ProductDTO ;
@Component
public class ProductService
{
	@Autowired
	ProductDAO productDAO;

		public ProductDTO addProduct(ProductDTO productDTO)
		{
			return productDAO.addProduct ( productDTO );
		}
		
		public List < ProductDTO > fetchallproduct ( )
		{
			return productDAO.fetchallproduct ( );
		}
		public void deleteProduct(int id)
		{
			productDAO.deleteProduct ( id );
		}

		public void updateProduct ( ProductDTO productDTO )
		{
			productDAO.updateProduct ( productDTO );
		}
		
		public ProductDTO searchProduct(int id)
		{
			return productDAO.searchProduct ( id );
		}
}
