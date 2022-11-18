
package Service.Interface;

import DomainModel.SanPham;
import ViewModel.SanPhamVModel;
import java.util.List;


public interface SanPhamServiceInterface {
    public List<SanPhamVModel> getAllSP();
    public void addSanPham(SanPham sanPham);
    public void updateSanPham(SanPham sanPham);
    public void deleteSanPham(SanPham sanPham);
}
