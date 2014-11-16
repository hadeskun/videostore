/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import entity.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
/**
 *
 * @author julian
 */
public class ProductModel {

    private UserTransaction utx;

    private EntityManager em;

    public ProductModel() {
    }

    public ProductModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }
    
    //Method Create
    public void createCrud(String name,float price, String description, int categoryid){
        int id=0;
        while(em.find(Product.class, id)!=null) id++;
        Product entity = new Product(id);
        entity.setId(id);
        entity.setName(name);
        entity.setPrice(price);
        entity.setDescription(description);
        entity.setCategoryid(categoryid);

        try {

            utx.begin();
        } catch (Exception ex) {
           ex.printStackTrace();
        }

        em.persist(entity);
        try {
            utx.commit();
        } catch (Exception ex) {
             ex.printStackTrace();
        }

    }

    //Method Retrieve
    public Product retrieveCrud(int id){

       return em.find(Product.class, id);

    }

    //method updaTE
    public void updateCrud(int id,String name,Float price,String description,Integer categoryid){

       //return em.find(Category.class, id);
        Product entity= em.find(Product.class, id);
        if(entity==null) return;
        entity.setName(name);
        entity.setPrice(price);
        entity.setDescription(description);
        entity.setCategoryid(categoryid);
        
        try {

            utx.begin();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        em.merge(entity);
        try {
            utx.commit();
        } catch (Exception ex) {
             ex.printStackTrace();
        }


    }

    //Method Delete
    public void deleteCrud(int id){

       Product entity=em.find(Product.class, id);
       if(entity==null) return;
       try {

            utx.begin();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
       entity=em.merge(entity);
       em.remove(entity);
       try {
            utx.commit();
        } catch (Exception ex) {
             ex.printStackTrace();
        }


    }

    public List<Product> retrieveCat(int id){
        Query query = em.createQuery("SELECT o FROM Product as o WHERE o.categoryid=" + id);
        return query.getResultList();
    }

    public Product retrieveProduct(int id){
        Query query = em.createQuery("SELECT o FROM Product as o WHERE o.id=" + id);
        return (Product)query.getSingleResult();
    }
}
