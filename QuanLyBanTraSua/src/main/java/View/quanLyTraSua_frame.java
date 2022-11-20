package View;

import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import Service.Implement.DanhMucServiceImplement;
import Service.Implement.SanPhamServiceIMplement;
import Service.Implement.SizeServiceimplement;
import Service.Interface.DanhMucServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.SizeServiceInterface;
import ViewModel.SanPhamVModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

public class quanLyTraSua_frame extends javax.swing.JFrame {

    private SanPhamServiceInterface sanPhamServiceInterface;
    private DanhMucServiceInterface danhMucServiceInterface;
    private SizeServiceInterface sizeServiceInterface;

    public quanLyTraSua_frame() {
        initComponents();
        hoverMouse();
        sanPhamServiceInterface = new SanPhamServiceIMplement();
        danhMucServiceInterface = new DanhMucServiceImplement();
        sizeServiceInterface = new SizeServiceimplement();
        LoadTableDoUong();
        loadCBBFrame();
    }

    //manh_quanlyDoUong
    public void loadCBBFrame() {
        //combobox thong tin san pham
        DefaultComboBoxModel tblComboBoxModelDMSP = (DefaultComboBoxModel) cbbDanhmucSp.getModel();
        List<DanhMuc> listDm = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listDm) {
            tblComboBoxModelDMSP.addElement(danhMuc.getTenDM());
        }
        // combobox size san pham
        DefaultComboBoxModel tblComboBoxModelDMKho = (DefaultComboBoxModel) cbbDanhMucKho.getModel();
        List<DanhMuc> listDmKho = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listDm) {
            tblComboBoxModelDMKho.addElement(danhMuc.getTenDM());
        }
        // combobox loc san pham
        DefaultComboBoxModel tblComboBoxModelSize = (DefaultComboBoxModel) cbbSize.getModel();
        List<Size> listSize = sizeServiceInterface.getAllSize();
        for (Size size : listSize) {
            tblComboBoxModelSize.addElement(size.getMa());
        }

    }
    //lay thong tin san pham
    public void LoadTableDoUong() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouong.getModel();
        tblModel.setRowCount(0);
        List<SanPhamVModel> list = sanPhamServiceInterface.getAllSP();
        for (SanPhamVModel sanPhamVModel : list) {
            tblModel.addRow(new Object[]{
                sanPhamVModel.getMa(),
                sanPhamVModel.getTen(),
                sanPhamVModel.getDonGia(),
                sanPhamVModel.getVi(),
                sanPhamVModel.getDanhmuc(),
                sanPhamVModel.getSize(),
                sanPhamVModel.getTrangThai()
            });
        }
    }
    // hien thi thong tin len from
    public void displaySanPhamFrom() {
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {
            txtmaDoUong.setText((String) tblSanPhamDouong.getValueAt(row, 0));
            txtTenDoUong.setText((String) tblSanPhamDouong.getValueAt(row, 1));
            txtGia.setText((String) tblSanPhamDouong.getValueAt(row, 2));
            txtVi.setText((String) tblSanPhamDouong.getValueAt(row, 3));
            cbbDanhmucSp.setSelectedItem(tblSanPhamDouong.getValueAt(row, 4));
            cbbSize.setSelectedItem(tblSanPhamDouong.getValueAt(row, 5));
            txtTrangThai.setText((String) tblSanPhamDouong.getValueAt(row, 6));
            txtmaDoUong.setEditable(false);
        }
    }
    //xoa trang from
    public void clearfromSanPham() {
        txtmaDoUong.setText("");
        txtTenDoUong.setText("");
        txtGia.setText("");
        txtVi.setText("");
        cbbDanhmucSp.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTrangThai.setText("");
        txtTimKiemKho.setText("");
        txtmaDoUong.setEditable(true);
    }
    //loc theo combobox
    public void LocCBBDM(){
        String nameDM = (String) cbbDanhMucKho.getSelectedItem();
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouong.getModel();
        tblModel.setRowCount(0);
        List<SanPhamVModel> list = sanPhamServiceInterface.getAllSP();
        for (SanPhamVModel sanPhamVModel : list) {
            if(sanPhamVModel.getTen().equalsIgnoreCase(nameDM)){
                tblModel.addRow(new Object[]{
                sanPhamVModel.getMa(),
                sanPhamVModel.getTen(),
                sanPhamVModel.getDonGia(),
                sanPhamVModel.getVi(),
                sanPhamVModel.getDanhmuc(),
                sanPhamVModel.getSize(),
                sanPhamVModel.getTrangThai()
            });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        pnlTong = new javax.swing.JPanel();
        pnlmenu = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnBanHang_Menu = new javax.swing.JButton();
        btnHoaDonMenu = new javax.swing.JButton();
        btnDoanUongMenu = new javax.swing.JButton();
        btnNguyenLieuMenu = new javax.swing.JButton();
        btnNhanVienMenu = new javax.swing.JButton();
        btnKhachHangmenu = new javax.swing.JButton();
        btnKhuyenMaiMenu = new javax.swing.JButton();
        btnThongkeMenu = new javax.swing.JButton();
        btnDangXuatMenu = new javax.swing.JButton();
        pnlgiaodien = new javax.swing.JPanel();
        pnlBanHang = new javax.swing.JPanel();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMaHoaDonBH = new javax.swing.JLabel();
        btnTaoHoaDonBH = new javax.swing.JButton();
        lblMaNhanVienBH = new javax.swing.JLabel();
        lblNgayTaoHDBH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTenKhachHangBH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaKhuyenMaiBH = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTienKhacDuaBH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTongTienBH = new javax.swing.JLabel();
        lblSoTienGiamBH = new javax.swing.JLabel();
        lblCanThanhToanBH = new javax.swing.JLabel();
        btnThanhToanBH = new javax.swing.JButton();
        lblTienTraLaiBH = new javax.swing.JLabel();
        pnlDSHoaDonBH = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSHoaDonBH = new javax.swing.JTable();
        pnlSanPhamOrderBH = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamOrderBH = new javax.swing.JTable();
        btnXoaSPOrderBH = new javax.swing.JButton();
        btnLamMoiSanPhamorderBH = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThongTinSanPhamBH = new javax.swing.JTable();
        lblAnhSanPhamBH = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtTimSanPhamBH = new javax.swing.JTextField();
        btnTimSanPhamBH = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cbbLocDanhMucBH = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        btnThemSanPhamOrder = new javax.swing.JButton();
        pnlHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlDoAnUong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblMaDoUong = new javax.swing.JLabel();
        lblTenSp = new javax.swing.JLabel();
        lblVi = new javax.swing.JLabel();
        lbldanhmucSP = new javax.swing.JLabel();
        lblSizeSanPham = new javax.swing.JLabel();
        lblTrangthai = new javax.swing.JLabel();
        txtmaDoUong = new javax.swing.JTextField();
        txtTenDoUong = new javax.swing.JTextField();
        txtVi = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        cbbDanhmucSp = new javax.swing.JComboBox<>();
        lblGia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cbbSize = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbbDanhMucKho = new javax.swing.JComboBox<>();
        lblLocDMkho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamDouong = new javax.swing.JTable();
        lblTimKiemTenSPKho = new javax.swing.JLabel();
        txtTimKiemKho = new javax.swing.JTextField();
        btnTimKiemKho = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnThemdoUong = new javax.swing.JButton();
        btnSuaDoUong = new javax.swing.JButton();
        btnXoaDoUong = new javax.swing.JButton();
        btnclearFromThongtinSP = new javax.swing.JButton();
        pnlNguyenLieu = new javax.swing.JPanel();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlKhuyenMai = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1250, 750));

        pnlTong.setBackground(new java.awt.Color(204, 255, 255));
        pnlTong.setPreferredSize(new java.awt.Dimension(1230, 722));

        pnlmenu.setBackground(new java.awt.Color(204, 255, 255));
        pnlmenu.setPreferredSize(new java.awt.Dimension(190, 710));

        btnBanHang_Menu.setBackground(new java.awt.Color(204, 255, 255));
        btnBanHang_Menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBanHang_Menu.setText("Bán Hàng");
        btnBanHang_Menu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnBanHang_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang_MenuActionPerformed(evt);
            }
        });

        btnHoaDonMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnHoaDonMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoaDonMenu.setText("Hóa Đơn");
        btnHoaDonMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnHoaDonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMenuActionPerformed(evt);
            }
        });

        btnDoanUongMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDoanUongMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoanUongMenu.setText("Đồ Ăn, Uống");
        btnDoanUongMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnDoanUongMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanUongMenuActionPerformed(evt);
            }
        });

        btnNguyenLieuMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnNguyenLieuMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNguyenLieuMenu.setText("Nguyên Liệu");
        btnNguyenLieuMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnNguyenLieuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguyenLieuMenuActionPerformed(evt);
            }
        });

        btnNhanVienMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnNhanVienMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVienMenu.setText("Nhân Viên");
        btnNhanVienMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnNhanVienMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienMenuActionPerformed(evt);
            }
        });

        btnKhachHangmenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhachHangmenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHangmenu.setText("Khách Hàng");
        btnKhachHangmenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhachHangmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangmenuActionPerformed(evt);
            }
        });

        btnKhuyenMaiMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhuyenMaiMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhuyenMaiMenu.setText("Khuyến Mại");
        btnKhuyenMaiMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhuyenMaiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiMenuActionPerformed(evt);
            }
        });

        btnThongkeMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnThongkeMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongkeMenu.setText("Thông kê");
        btnThongkeMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnThongkeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeMenuActionPerformed(evt);
            }
        });

        btnDangXuatMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDangXuatMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuatMenu.setText("Đăng Xuất");
        btnDangXuatMenu.setPreferredSize(new java.awt.Dimension(117, 48));

        javax.swing.GroupLayout pnlmenuLayout = new javax.swing.GroupLayout(pnlmenu);
        pnlmenu.setLayout(pnlmenuLayout);
        pnlmenuLayout.setHorizontalGroup(
            pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlmenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBanHang_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnHoaDonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoanUongMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNguyenLieuMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhanVienMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhachHangmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuyenMaiMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongkeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuatMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlmenuLayout.setVerticalGroup(
            pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanUongMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNguyenLieuMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVienMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHangmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMaiMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongkeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuatMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlgiaodien.setBackground(new java.awt.Color(204, 255, 255));
        pnlgiaodien.setLayout(new java.awt.CardLayout());

        pnlThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));

        jLabel1.setText("Mã hóa đơn");

        jLabel3.setText("Mã nhân viên");

        jLabel4.setText("Ngày Tạo");

        lblMaHoaDonBH.setText("HD1");

        btnTaoHoaDonBH.setBackground(new java.awt.Color(204, 255, 153));
        btnTaoHoaDonBH.setText("Tạo");

        lblMaNhanVienBH.setText("NV1");

        lblNgayTaoHDBH.setText("dd/mm/yyy");

        jLabel13.setText("Tên khách hàng");

        txtTenKhachHangBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangBHActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã hhuyến mại");

        txtMaKhuyenMaiBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhuyenMaiBHActionPerformed(evt);
            }
        });

        jLabel14.setText("Tổng tiền");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("VND");

        jLabel16.setText("Số tiền Giảm");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("VND");

        jLabel18.setText("Cần thanh toán");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("VND");

        jLabel20.setText("Trả lại");

        jLabel21.setText("Tiền khách đưa");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("VND");

        btnThanhToanBH.setBackground(new java.awt.Color(153, 255, 153));
        btnThanhToanBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToanBH.setText("Thanh Toán");

        javax.swing.GroupLayout pnlThongTinHoaDonLayout = new javax.swing.GroupLayout(pnlThongTinHoaDon);
        pnlThongTinHoaDon.setLayout(pnlThongTinHoaDonLayout);
        pnlThongTinHoaDonLayout.setHorizontalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                            .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(25, 25, 25)
                            .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblNgayTaoHDBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMaNhanVienBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMaHoaDonBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTaoHoaDonBH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtMaKhuyenMaiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinHoaDonLayout.createSequentialGroup()
                            .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16)
                                .addComponent(jLabel18)
                                .addComponent(jLabel20))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                    .addComponent(lblSoTienGiamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel19))
                                .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                    .addComponent(lblTongTienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15))
                                .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                    .addComponent(lblCanThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel17))
                                .addComponent(btnThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                        .addComponent(lblTienTraLaiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22))
                                    .addComponent(txtTienKhacDuaBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel21))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlThongTinHoaDonLayout.setVerticalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblMaHoaDonBH)
                    .addComponent(btnTaoHoaDonBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMaNhanVienBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayTaoHDBH)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtMaKhuyenMaiBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15))
                                    .addComponent(lblTongTienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(lblSoTienGiamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCanThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTienKhacDuaBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(lblTienTraLaiBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pnlDSHoaDonBH.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        tblDSHoaDonBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDSHoaDonBH);

        javax.swing.GroupLayout pnlDSHoaDonBHLayout = new javax.swing.GroupLayout(pnlDSHoaDonBH);
        pnlDSHoaDonBH.setLayout(pnlDSHoaDonBHLayout);
        pnlDSHoaDonBHLayout.setHorizontalGroup(
            pnlDSHoaDonBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSHoaDonBHLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlDSHoaDonBHLayout.setVerticalGroup(
            pnlDSHoaDonBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSHoaDonBHLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pnlSanPhamOrderBH.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm order"));

        tblSanPhamOrderBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblSanPhamOrderBH);

        btnXoaSPOrderBH.setBackground(new java.awt.Color(255, 153, 153));
        btnXoaSPOrderBH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaSPOrderBH.setText("Xóa sản phẩm");

        btnLamMoiSanPhamorderBH.setBackground(new java.awt.Color(153, 153, 255));
        btnLamMoiSanPhamorderBH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoiSanPhamorderBH.setText("Làm Mới");

        javax.swing.GroupLayout pnlSanPhamOrderBHLayout = new javax.swing.GroupLayout(pnlSanPhamOrderBH);
        pnlSanPhamOrderBH.setLayout(pnlSanPhamOrderBHLayout);
        pnlSanPhamOrderBHLayout.setHorizontalGroup(
            pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSPOrderBH)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamOrderBHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnLamMoiSanPhamorderBH, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlSanPhamOrderBHLayout.setVerticalGroup(
            pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                .addGroup(pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnXoaSPOrderBH)
                        .addGap(30, 30, 30)
                        .addComponent(btnLamMoiSanPhamorderBH)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin sản phẩm"));

        tblThongTinSanPhamBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblThongTinSanPhamBH);

        javax.swing.GroupLayout lblAnhSanPhamBHLayout = new javax.swing.GroupLayout(lblAnhSanPhamBH);
        lblAnhSanPhamBH.setLayout(lblAnhSanPhamBHLayout);
        lblAnhSanPhamBHLayout.setHorizontalGroup(
            lblAnhSanPhamBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        lblAnhSanPhamBHLayout.setVerticalGroup(
            lblAnhSanPhamBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        jLabel26.setText("Tên SP");

        btnTimSanPhamBH.setBackground(new java.awt.Color(153, 255, 255));
        btnTimSanPhamBH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimSanPhamBH.setText("Tìm Kiếm");

        jLabel27.setText("Danh Mục");

        cbbLocDanhMucBH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("Ảnh");

        btnThemSanPhamOrder.setBackground(new java.awt.Color(102, 255, 102));
        btnThemSanPhamOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemSanPhamOrder.setText("Thêm Sản phẩm Oder");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimSanPhamBH)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(jLabel27))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtTimSanPhamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocDanhMucBH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(btnThemSanPhamOrder)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnhSanPhamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbLocDanhMucBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThemSanPhamOrder)
                        .addComponent(jLabel28))
                    .addComponent(txtTimSanPhamBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btnTimSanPhamBH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnhSanPhamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBanHangLayout.createSequentialGroup()
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanHangLayout.createSequentialGroup()
                        .addComponent(pnlDSHoaDonBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 214, Short.MAX_VALUE))
                    .addComponent(pnlSanPhamOrderBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBanHangLayout.createSequentialGroup()
                        .addComponent(pnlDSHoaDonBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlSanPhamOrderBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBanHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlBanHang, "cardBanHang");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap(550, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(469, 469, 469))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel2)
                .addContainerGap(558, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlHoaDon, "cardHoaDon");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Đồ Ăn, Uống"));

        lblMaDoUong.setText("Mã ");

        lblTenSp.setText("Tên");

        lblVi.setText("Vị");

        lbldanhmucSP.setText("Danh Mục");

        lblSizeSanPham.setText("Size");

        lblTrangthai.setText("Trạng Thái");

        lblGia.setText("Đơn Giá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVi))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtVi, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addGap(408, 408, 408))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(txtmaDoUong)
                            .addComponent(txtGia))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSizeSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldanhmucSP)
                            .addComponent(lblTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(cbbDanhmucSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDoUong)
                    .addComponent(lbldanhmucSP)
                    .addComponent(txtmaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDanhmucSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenSp)
                            .addComponent(lblSizeSanPham)
                            .addComponent(txtTenDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGia)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangthai))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVi)
                    .addComponent(txtVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Đồ Ăn, Uống"));

        cbbDanhMucKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucKhoActionPerformed(evt);
            }
        });

        lblLocDMkho.setText("Danh Mục");

        tblSanPhamDouong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Đơn Giá", "Vị", "Danh Mục", "Size", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamDouong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamDouongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamDouong);

        lblTimKiemTenSPKho.setText("Tên Sản Phẩm");

        btnTimKiemKho.setText("Tìm Kiếm");
        btnTimKiemKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTimKiemTenSPKho)
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(lblLocDMkho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDanhMucKho, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocDMkho)
                        .addComponent(lblTimKiemTenSPKho)
                        .addComponent(txtTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemKho))
                    .addComponent(cbbDanhMucKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        btnThemdoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemdoUong.setText("Thêm");
        btnThemdoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemdoUongActionPerformed(evt);
            }
        });

        btnSuaDoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaDoUong.setText("Sửa");
        btnSuaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDoUongActionPerformed(evt);
            }
        });

        btnXoaDoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDoUong.setText("Xóa");
        btnXoaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoUongActionPerformed(evt);
            }
        });

        btnclearFromThongtinSP.setText("Clear");
        btnclearFromThongtinSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearFromThongtinSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnclearFromThongtinSP, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnXoaDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnSuaDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnThemdoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnThemdoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclearFromThongtinSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoAnUongLayout = new javax.swing.GroupLayout(pnlDoAnUong);
        pnlDoAnUong.setLayout(pnlDoAnUongLayout);
        pnlDoAnUongLayout.setHorizontalGroup(
            pnlDoAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoAnUongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDoAnUongLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDoAnUongLayout.setVerticalGroup(
            pnlDoAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoAnUongLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlDoAnUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlDoAnUong, "cardSanPham");

        javax.swing.GroupLayout pnlNguyenLieuLayout = new javax.swing.GroupLayout(pnlNguyenLieu);
        pnlNguyenLieu.setLayout(pnlNguyenLieuLayout);
        pnlNguyenLieuLayout.setHorizontalGroup(
            pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        pnlNguyenLieuLayout.setVerticalGroup(
            pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );

        pnlgiaodien.add(pnlNguyenLieu, "cardNguyenLieu");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap(757, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel5)
                .addContainerGap(553, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlNhanVien, "cardNhanVien");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(738, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel6)
                .addContainerGap(547, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlKhachHang, "cardKhachHang");

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout pnlKhuyenMaiLayout = new javax.swing.GroupLayout(pnlKhuyenMai);
        pnlKhuyenMai.setLayout(pnlKhuyenMaiLayout);
        pnlKhuyenMaiLayout.setHorizontalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap(637, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );
        pnlKhuyenMaiLayout.setVerticalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhuyenMaiLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel7)
                .addContainerGap(545, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlKhuyenMai, "cardKhuyenMai");

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongKeLayout.createSequentialGroup()
                .addContainerGap(717, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel8)
                .addContainerGap(557, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlThongKe, "cardThongKe");

        javax.swing.GroupLayout pnlTongLayout = new javax.swing.GroupLayout(pnlTong);
        pnlTong.setLayout(pnlTongLayout);
        pnlTongLayout.setHorizontalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTongLayout.createSequentialGroup()
                .addComponent(pnlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlgiaodien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTongLayout.setVerticalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTongLayout.createSequentialGroup()
                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addComponent(pnlgiaodien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlTong, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHang_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang_MenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardBanHang");
    }//GEN-LAST:event_btnBanHang_MenuActionPerformed

    private void btnHoaDonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardHoaDon");
    }//GEN-LAST:event_btnHoaDonMenuActionPerformed

    private void btnDoanUongMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanUongMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardSanPham");
    }//GEN-LAST:event_btnDoanUongMenuActionPerformed

    private void btnNguyenLieuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguyenLieuMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardNguyenLieu");
    }//GEN-LAST:event_btnNguyenLieuMenuActionPerformed

    private void btnNhanVienMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardNhanVien");
    }//GEN-LAST:event_btnNhanVienMenuActionPerformed

    private void btnKhachHangmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangmenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardKhachHang");
    }//GEN-LAST:event_btnKhachHangmenuActionPerformed

    private void btnKhuyenMaiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardKhuyenMai");
    }//GEN-LAST:event_btnKhuyenMaiMenuActionPerformed

    private void btnThongkeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeMenuActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlgiaodien.getLayout();
        layout.show(pnlgiaodien, "cardThongKe");
    }//GEN-LAST:event_btnThongkeMenuActionPerformed

    private void btnThemdoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemdoUongActionPerformed
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();
        sanPham.setMa(txtmaDoUong.getText());
        sanPham.setTen(txtTenDoUong.getText());
        sanPham.setDonGia(txtGia.getText());
        sanPham.setVi(txtVi.getText());
        String nameDM = (String) cbbDanhmucSp.getSelectedItem();
        List<DanhMuc> listdm = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listdm) {
            if(danhMuc.getTenDM().equals(nameDM)){
                sanPham.setId_DanhMuc(danhMuc.getId());
            }
        }
        String maSize = (String) cbbSize.getSelectedItem();
        List<Size> listSize = sizeServiceInterface.getAllSize();
        for (Size size : listSize) {
            if(size.getMa().equals(maSize)){
                sanPham.setId_size(size.getId());
            }
        }
        String trangThai = txtTrangThai.getText();
        if(trangThai.equalsIgnoreCase("Còn Hàng")){
            sanPham.setTrangThai(1);
        }
        if(trangThai.equalsIgnoreCase("Hết Hàng")){
            sanPham.setTrangThai(0);
        }
        System.out.println(sanPham);
        try {
            sanPhamServiceInterface.addSanPham(sanPham);
            LoadTableDoUong();
            clearfromSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemdoUongActionPerformed

    private void tblSanPhamDouongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamDouongMouseClicked
        // TODO add your handling code here:
        displaySanPhamFrom();
    }//GEN-LAST:event_tblSanPhamDouongMouseClicked

    private void btnclearFromThongtinSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearFromThongtinSPActionPerformed
        // TODO add your handling code here:
        clearfromSanPham();
        LoadTableDoUong();
    }//GEN-LAST:event_btnclearFromThongtinSPActionPerformed

    private void btnSuaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDoUongActionPerformed
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();
        sanPham.setMa(txtmaDoUong.getText());
        sanPham.setTen(txtTenDoUong.getText());
        sanPham.setDonGia(txtGia.getText());
        sanPham.setVi(txtVi.getText());
        String nameDM = (String) cbbDanhmucSp.getSelectedItem();
        List<DanhMuc> listdm = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listdm) {
            if(danhMuc.getTenDM().equals(nameDM)){
                sanPham.setId_DanhMuc(danhMuc.getId());
            }
        }
        String maSize = (String) cbbSize.getSelectedItem();
        List<Size> listSize = sizeServiceInterface.getAllSize();
        for (Size size : listSize) {
            if(size.getMa().equals(maSize)){
                sanPham.setId_size(size.getId());
            }
        }
        String trangThai = txtTrangThai.getText();
        if(trangThai.equalsIgnoreCase("Còn Hàng")){
            sanPham.setTrangThai(1);
        }
        if(trangThai.equalsIgnoreCase("Hết Hàng")){
            sanPham.setTrangThai(0);
        }
        System.out.println(sanPham);
        try {
            sanPhamServiceInterface.updateSanPham(sanPham);
            LoadTableDoUong();
            clearfromSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaDoUongActionPerformed

    private void btnXoaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoUongActionPerformed
 
         SanPham sanPham = new SanPham();
        sanPham.setMa(txtmaDoUong.getText());
        try {
            sanPhamServiceInterface.deleteSanPham(sanPham);
            LoadTableDoUong();
            clearfromSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaDoUongActionPerformed

    private void btnTimKiemKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhoActionPerformed
 
        String tenSp= txtTimKiemKho.getText();
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouong.getModel();
        tblModel.setRowCount(0);
        List<SanPhamVModel> list = sanPhamServiceInterface.getAllSP();
        for (SanPhamVModel sanPhamVModel : list) {
            if(sanPhamVModel.getTen().equalsIgnoreCase(tenSp)){
                tblModel.addRow(new Object[]{
                sanPhamVModel.getMa(),
                sanPhamVModel.getTen(),
                sanPhamVModel.getDonGia(),
                sanPhamVModel.getVi(),
                sanPhamVModel.getDanhmuc(),
                sanPhamVModel.getSize(),
                sanPhamVModel.getTrangThai()
            });
            }
        }
    }//GEN-LAST:event_btnTimKiemKhoActionPerformed

    private void cbbDanhMucKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucKhoActionPerformed
        // TODO add your handling code here:
//        LocCBBDM();
    }//GEN-LAST:event_cbbDanhMucKhoActionPerformed

    private void txtTenKhachHangBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangBHActionPerformed

    private void txtMaKhuyenMaiBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhuyenMaiBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhuyenMaiBHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quanLyTraSua_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanLyTraSua_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanLyTraSua_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanLyTraSua_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanLyTraSua_frame().setVisible(true);
            }
        });
    }

    private void hoverMouse() {
        File file = new File("logots.jpg");
        try {
            Image img = ImageIO.read(file);
            lblAnh.setIcon(new ImageIcon(img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), 0)));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JButton btn[] = {btnBanHang_Menu, btnDangXuatMenu, btnHoaDonMenu, btnKhachHangmenu, btnKhuyenMaiMenu, btnNhanVienMenu, btnThongkeMenu, btnDangXuatMenu, btnNguyenLieuMenu, btnDoanUongMenu};
        for (JButton x : btn) {
            x.setFocusPainted(false);
            x.setUI(new BasicButtonUI());
            x.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    x.setBackground(Color.white);
                    x.setForeground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    x.setBackground(new java.awt.Color(204, 255, 255));
                    x.setForeground(Color.black);
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang_Menu;
    private javax.swing.JButton btnDangXuatMenu;
    private javax.swing.JButton btnDoanUongMenu;
    private javax.swing.JButton btnHoaDonMenu;
    private javax.swing.JButton btnKhachHangmenu;
    private javax.swing.JButton btnKhuyenMaiMenu;
    private javax.swing.JButton btnLamMoiSanPhamorderBH;
    private javax.swing.JButton btnNguyenLieuMenu;
    private javax.swing.JButton btnNhanVienMenu;
    private javax.swing.JButton btnSuaDoUong;
    private javax.swing.JButton btnTaoHoaDonBH;
    private javax.swing.JButton btnThanhToanBH;
    private javax.swing.JButton btnThemSanPhamOrder;
    private javax.swing.JButton btnThemdoUong;
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnTimKiemKho;
    private javax.swing.JButton btnTimSanPhamBH;
    private javax.swing.JButton btnXoaDoUong;
    private javax.swing.JButton btnXoaSPOrderBH;
    private javax.swing.JButton btnclearFromThongtinSP;
    private javax.swing.JComboBox<String> cbbDanhMucKho;
    private javax.swing.JComboBox<String> cbbDanhmucSp;
    private javax.swing.JComboBox<String> cbbLocDanhMucBH;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JPanel lblAnhSanPhamBH;
    private javax.swing.JLabel lblCanThanhToanBH;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblLocDMkho;
    private javax.swing.JLabel lblMaDoUong;
    private javax.swing.JLabel lblMaHoaDonBH;
    private javax.swing.JLabel lblMaNhanVienBH;
    private javax.swing.JLabel lblNgayTaoHDBH;
    private javax.swing.JLabel lblSizeSanPham;
    private javax.swing.JLabel lblSoTienGiamBH;
    private javax.swing.JLabel lblTenSp;
    private javax.swing.JLabel lblTienTraLaiBH;
    private javax.swing.JLabel lblTimKiemTenSPKho;
    private javax.swing.JLabel lblTongTienBH;
    private javax.swing.JLabel lblTrangthai;
    private javax.swing.JLabel lblVi;
    private javax.swing.JLabel lbldanhmucSP;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlDSHoaDonBH;
    private javax.swing.JPanel pnlDoAnUong;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlKhuyenMai;
    private javax.swing.JPanel pnlNguyenLieu;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlSanPhamOrderBH;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private javax.swing.JPanel pnlTong;
    private javax.swing.JPanel pnlgiaodien;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JTable tblDSHoaDonBH;
    private javax.swing.JTable tblSanPhamDouong;
    private javax.swing.JTable tblSanPhamOrderBH;
    private javax.swing.JTable tblThongTinSanPhamBH;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaKhuyenMaiBH;
    private javax.swing.JTextField txtTenDoUong;
    private javax.swing.JTextField txtTenKhachHangBH;
    private javax.swing.JTextField txtTienKhacDuaBH;
    private javax.swing.JTextField txtTimKiemKho;
    private javax.swing.JTextField txtTimSanPhamBH;
    private javax.swing.JTextField txtTrangThai;
    private javax.swing.JTextField txtVi;
    private javax.swing.JTextField txtmaDoUong;
    // End of variables declaration//GEN-END:variables
}
