/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author HuynhPhung
 */
public class KhuyenMaiRespository {    
     private Session session = HibernateUtil.getFACTORY().openSession();
     
     public List<KhuyenMai> getAll(){
         try(Session session = HibernateUtil.getFACTORY().openSession();) {
             Query query = session.createQuery("From KhuyenMai");
             List<KhuyenMai> list = query.getResultList();
             return list;
         } catch (Exception e) {
         }
         return null;
     }
     
     public KhuyenMai getOne(String ma) {
        Transaction transaction = null;
        KhuyenMai km = new KhuyenMai();
        try {
            String query = "SELECT khuyenmai "
                    + "FROM KhuyenMai khuyenmai "
                    + "WHERE khuyenmai.ma = :ma ";
            Query<KhuyenMai> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            km = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return km;
    }
     
     public boolean add(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(km);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean update(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.update(km);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public static void main(String[] args) {
//        boolean add = new KhuyenMai
    }
}
