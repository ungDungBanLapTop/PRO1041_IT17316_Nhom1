/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.resquest.ChiTietSanPhamImportResquest;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel;
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class SanPhamRepositoryImpl implements SanPhamRepository {

    private Session session = new HibernateUtil().getFACTORY().openSession();

    @Override
    public List<SanPham> getAll() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
        
            
            Query <SanPham>query = session.createQuery("FROM SanPham ");
            List<SanPham> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> getAllByTrangThai(int trangThai) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham sp WHERE sp.trangThai = :trangThai ");
            query.setParameter("trangThai", trangThai);
            List<SanPham> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham add(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham delete(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham getOne(String maSp) {

        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ma like :ma";
            Query<SanPham> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maSp + "%");
            SanPham sp = query.uniqueResult();
            return sp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> search(String maSp) {
        List<SanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ma like :ma ";
            Query query = session.createQuery(hql);

            query.setParameter("ma", "%" + maSp + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> searchByTen(String tenSp) {
        List<SanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ten like :ten ";
            Query query = session.createQuery(hql);

            query.setParameter("ten", "%" + tenSp + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> searchFill(SanPhamSearchRequest request) {
        List<SanPham> list = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("""
                        FROM SanPham sp
                        WHERE  
                            (:ten IS NULL 
                            OR :ten LIKE '' 
                            OR sp.ten LIKE CONCAT('%',:ten,'%'))                       
                        AND( 
                            :tenManHinh IS NULL 
                            OR  :tenManHinh LIKE ''
                            OR manHinh.ma LIKE CONCAT('%',:tenManHinh,'%')) 
                        AND
                            (:tenCpu IS NULL 
                            OR :tenCpu LIKE '' 
                            OR cpu.ten LIKE CONCAT('%',:tenCpu,'%'))
                        AND( 
                            :tenMau IS NULL 
                            OR  :tenMau LIKE ''
                            OR mau.ten LIKE CONCAT('%',:tenMau,'%'))                                        
                        AND
                            (:tenHeDieuHanh IS NULL 
                            OR :tenHeDieuHanh LIKE '' 
                            OR heDieuHanh.ten LIKE CONCAT('%',:tenHeDieuHanh,'%'))
                        AND( 
                            :tenRam IS NULL 
                            OR  :tenRam LIKE ''
                            OR ram.ten LIKE CONCAT('%',:tenRam,'%')) 
                        AND
                            (:tenChatLieu IS NULL 
                            OR :tenChatLieu LIKE '' 
                            OR chatLieu.ten LIKE CONCAT('%',:tenChatLieu,'%'))
                        AND( 
                            :tenHang IS NULL 
                            OR  :tenHang LIKE ''
                            OR hang.ten LIKE CONCAT('%',:tenHang,'%'))
                        AND( 
                            sp.namBH  = :namSX                          
                            OR  :namSX  = 0 )                      
                        AND( 
                            sp.trongLuong  = :trongLuong                          
                            OR  :trongLuong  = 0 )
                        AND( 
                            sp.soLuongTon  = :soLuong                          
                            OR  :soLuong  = 0 ) 
                        AND( 
                             sp.giaBan BETWEEN :startsGiaBan AND :giaBan                       
                             OR  :giaBan  IS NULL )
                        AND (sp.trangThai = :trangThai  )
                        """);
            query.setParameter("ten", request.getTen());
            query.setParameter("tenManHinh", request.getManHinh());
            query.setParameter("tenCpu", request.getTenCpu());
            query.setParameter("tenMau", request.getTenMau());
            query.setParameter("tenHeDieuHanh", request.getTenHeDieuHanh());
            query.setParameter("tenRam", request.getTenRam());
            query.setParameter("tenChatLieu", request.getTenChatLieu());
            query.setParameter("tenHang", request.getTenHang());
            query.setParameter("namSX", request.getNamSX());
            query.setParameter("trongLuong", request.getTrongLuong());
            query.setParameter("soLuong", request.getSoLuong());
            query.setParameter("startsGiaBan", request.getStartsGiaBan());
            query.setParameter("giaBan", request.getGiaBan());
            query.setParameter("trangThai", request.getTrangThai());
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public List<SanPhamBanHangViewModel> getSanPhamBanHang() {
        List<SanPhamBanHangViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel"
                    + "(sp.id,sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa)"
                    + " FROM SanPham sp  WHERE sp.trangThai = 0 ";
            Query query = session.createQuery(hql);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max) {
        List<SanPhamBanHangViewModel> list;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel(sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa) FROM SanPham sp WHERE sp.giaBan >= :min AND sp.giaBan <= :max";
            Query query = session.createQuery(hql);
            query.setParameter("min", min);
            query.setParameter("max", max);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPhamBanHangViewModel> searchByTenBanHang(String tenSp) {
        List<SanPhamBanHangViewModel> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel(sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa) FROM SanPham sp WHERE sp.ten like :ten";
            Query query = session.createQuery(hql);
            query.setParameter("ten", "%" + tenSp + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public void updateSoLuongSanPham(Map<UUID, SanPham> list) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            for (Map.Entry<UUID, SanPham> entry : list.entrySet()) {
//                if (entry.getValue().getStatus() != 0) {
                Query query = session.createQuery("UPDATE SanPham SET soLuongTon = :soLuong WHERE id = :id");
//                            setParameter("soLuong", entry.getValue().getSoLuongTon()).
//                            setParameter("id", entry.getValue().getIdChiTietSP());
                query.executeUpdate();
//                }
            }
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public SanPham getById(UUID id) {
        SanPham sanPham = new SanPham();
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT sp FROM SanPham sp WHERE sp.idSanPham = :idSanPham";
            Query<SanPham> query = session.createQuery(hql);
            query.setParameter("idSanPham", id);
            sanPham = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public List<SanPhamCustomRespone> getListSanPham() {
        List<SanPhamCustomRespone> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone(sp.id, sp.ma,sp.ten, sp.soLuongTon, sp.hang.ten, sp.heDieuHanh.ten, sp.ram.dungLuong) FROM SanPham sp ";
            Query query = session.createQuery(hql);
            list = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public boolean saveAllSanPham(Map<String, ChiTietSanPhamImportResquest> list) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            list.values().stream().forEach(item -> {
                session.save(item.getCpu());
                session.save(item.getHang());
                session.save(item.getHeDieuHanh());
                session.save(item.getManHinh());
                session.save(item.getMauSac());
                session.save(item.getRam());
                item.getSanPham().setCpu(item.getCpu());
                item.getSanPham().setHang(item.getHang());
                item.getSanPham().setHeDieuHanh(item.getHeDieuHanh());
                item.getSanPham().setManHinh(item.getManHinh());
                item.getSanPham().setMau(item.getMauSac());
                item.getSanPham().setRam(item.getRam());
                session.save(item.getSanPham());
            });
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

    @Override
    public long countSanPham(long begin, long end) {
        long count ;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM(hdct.soLuong) FROM HoaDonChiTiet hdct "
                    + " inner join  HoaDon hd ON hd.idHoaDon = hdct.hoaDon.idHoaDon "
                    + " where hd.ngayThanhToan BETWEEN :begin AND :end ";
            Query query = session.createQuery(hql);
            query.setParameter("begin", begin);
            query.setParameter("end", end);
            count =  (long) query.uniqueResult();
             return count;
        } catch (Exception e) {
            return 0;
             
        }
       
    }
    
  

    @Override
    public long soSanPhamTheoNgay(long toDay) {
         long count ;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM(hdct.soLuong) FROM HoaDonChiTiet hdct "
                    + " inner join  HoaDon hd ON hd.idHoaDon = hdct.hoaDon.idHoaDon "
                    + " where hd.ngayThanhToan =:toDay";
            Query query = session.createQuery(hql);
            query.setParameter("toDay", toDay);
            count = (long) query.uniqueResult();
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public long soSanPham() {
       long count =0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM(hdct.soLuong) FROM HoaDonChiTiet hdct ";

            Query query = session.createQuery(hql);
            count = (long) query.uniqueResult();
              return count;
        } catch (Exception e) {
               return 0;
        }
     
    }
     public static void main(String[] args) {
//        String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
//        System.out.println(new SanPhamRepositoryImpl().soSanPhamTheoNgay(new ConverDate().dateToLong(date, "dd/MM/yyyy")));
    List<SanPham> list =  new SanPhamRepositoryImpl().getAll();
list.forEach(a ->{
        System.out.println(a);
        
        });
    }

    @Override
    public List<Top10SanPhamBanChayViewModel> top10SanPhamBanChay() {
         List<Top10SanPhamBanChayViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT  new com.mycompany.ungdungbanlaptop.model.viewModel.Top10SanPhamBanChayViewModel( sp.ten,SUM(hdct.soLuong),hdct.donGia)  FROM SanPham sp"
                    + " INNER JOIN HoaDonChiTiet hdct "
                    + " ON sp.idSanPham = hdct.sanPham.idSanPham"
                    + " GROUP BY sp.ten,hdct.donGia"
                    + " ORDER BY SUM(hdct.soLuong) DESC";
            Query<Top10SanPhamBanChayViewModel> query = session.createQuery(hql);
            list = query.setMaxResults(10).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham getByTen(String ten) {
           try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ten = :ten";
            Query<SanPham> query = session.createQuery(hql);
            query.setParameter("ten",  ten );
            SanPham sp = query.uniqueResult();
            return sp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
