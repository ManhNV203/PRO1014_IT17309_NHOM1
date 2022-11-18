
package Service.Implement;

import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import RepositoryJdbc.Implement.DanhMucRepositoryImplement;
import RepositoryJdbc.Implement.SanPhanRepositoryimplement;
import RepositoryJdbc.Implement.SizeRepositoryImplement;
import RepositoryJdbc.Interface.DanhMucRepositoryInterface;
import RepositoryJdbc.Interface.SanPhamRepositoryInterface;
import RepositoryJdbc.Interface.SizeRepositoryInterface;
import Service.Interface.SanPhamServiceInterface;
import ViewModel.SanPhamVModel;
import java.util.ArrayList;
import java.util.List;


public class SanPhamServiceIMplement implements SanPhamServiceInterface{
    private SanPhamRepositoryInterface sanPhamRepositoryInterface;
    private DanhMucRepositoryInterface danhMucRepositoryInterface;
    private SizeRepositoryInterface sizeRepositoryInterface;
    public SanPhamServiceIMplement(){
        sanPhamRepositoryInterface= new SanPhanRepositoryimplement();
        danhMucRepositoryInterface= new DanhMucRepositoryImplement();
        sizeRepositoryInterface= new SizeRepositoryImplement();
    }
    @Override
    public List<SanPhamVModel> getAllSP() {
        List<SanPham> listSanPham = sanPhamRepositoryInterface.getAllSanPham();
        List<SanPhamVModel> listSanPhamVModel = new ArrayList<>();
        List<DanhMuc> listDanhMuc = danhMucRepositoryInterface.getAllDM();
        List<Size> listSize = sizeRepositoryInterface.getAllSize();
        for (SanPham sanPham : listSanPham) {
            SanPhamVModel spview = new SanPhamVModel();
            spview.setMa(sanPham.getMa());
            spview.setTen(sanPham.getTen());
            spview.setDonGia(sanPham.getDonGia());
            spview.setVi(sanPham.getVi());
            String iddm= sanPham.getId_DanhMuc();
            for (DanhMuc danhMuc : listDanhMuc) {
                if(danhMuc.getId().equals(iddm)){
                    spview.setDanhmuc(danhMuc.getTenDM());
                }
            }
            String idsize = sanPham.getId_size();
            for (Size size : listSize) {
                if(size.getId().equals(idsize)){
                    spview.setSize(size.getMa());
                }
            }
            if(sanPham.getTrangThai()==0){
                spview.setTrangThai("Hết Hàng");
            }else{
                spview.setTrangThai("Còn Hàng");
            }
            listSanPhamVModel.add(spview);
            
        }
        return listSanPhamVModel;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.addSanPham(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.updateSanPham(sanPham);
    }

    @Override
    public void deleteSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.deleteSanPham(sanPham);
    }
    
}
