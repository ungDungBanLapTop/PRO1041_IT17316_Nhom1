/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class BaoHanhRepository {
  
    public List<BaoHanh> getAll(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM BaoHanh");
            List<BaoHanh> list = query.getResultList();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public BaoHanh add(BaoHanh baoHanh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(baoHanh);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return baoHanh;
    }
    public BaoHanh update(BaoHanh baoHanh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(baoHanh);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return baoHanh;
    }
    public BaoHanh delete(BaoHanh baoHanh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(baoHanh);
            transaction.commit();
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return baoHanh;
    }
    public BaoHanh getOne(String maBh){
        
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "SELECT bh FROM BaoHanh bh WHERE bh.ma like :ma";
            Query<BaoHanh> query = session.createQuery(hql);
            query.setParameter("ma", "%"+ maBh+ "%");
            BaoHanh bh = query.uniqueResult();
            return bh;
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
    
    }
}
