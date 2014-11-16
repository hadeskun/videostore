/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;


/**
 *
 * @author julian
 */
public class CategoryModel {

    private UserTransaction utx;

    private EntityManager em;

    public CategoryModel() {

    }

    public CategoryModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }

    //Method Create
    public void createCrud(String name){
        int id=0;
        while(em.find(Category.class, id)!=null) id++;
        Category entity = new Category(id);
        entity.setId(id);
        entity.setName(name);
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
    public Category retrieveCrud(int id){
        
       return em.find(Category.class, id);
        
    }

    //method updaTE
    public void updateCrud(int id,String name){

       //return em.find(Category.class, id);
        Category entity= em.find(Category.class, id);
        if(entity==null) return;
        entity.setName(name);
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
        
       Category entity=em.find(Category.class, id);
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

    //Codigo Juan Luis Conculta SELECT
    public List<Category> retrieve(){
        Query query = em.createQuery("select o from Category as o");
        return query.getResultList();
    }



}
