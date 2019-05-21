package com.imooc.ioc_annotation3;

public class ProductService {

    private CategoryDao categoryDao;

    private ProductDao productDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save(){
        System.out.println("ProductSerice 的save()执行了。。。");
        categoryDao.seach();
        productDao.seach();
    }
}
