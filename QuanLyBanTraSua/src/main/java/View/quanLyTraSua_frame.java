package View;

import DomainModel.DanhMuc;
import DomainModel.NguyenLieu;
import DomainModel.SanPham;
import DomainModel.Size;
import Service.Implement.DanhMucServiceImplement;
import Service.Implement.NguyenLieuServiceImplement;
import Service.Implement.SanPhamServiceIMplement;
import Service.Implement.SizeServiceimplement;
import Service.Interface.DanhMucServiceInterface;
import Service.Interface.NguyenLieuServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.SizeServiceInterface;
import ViewModel.NguyenLieuVModel;
import ViewModel.SanPhamVModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

public class quanLyTraSua_frame extends javax.swing.JFrame {

    private SanPhamServiceInterface sanPhamServiceInterface;
    private DanhMucServiceInterface danhMucServiceInterface;
    private SizeServiceInterface sizeServiceInterface;
    List<NguyenLieuVModel> listNL = new ArrayList<>();
    DefaultTableModel model;
    NguyenLieuServiceInterface service ;
    public quanLyTraSua_frame() {
        initComponents();
        hoverMouse();
        sanPhamServiceInterface = new SanPhamServiceIMplement();
        danhMucServiceInterface = new DanhMucServiceImplement();
        sizeServiceInterface = new SizeServiceimplement();
        service = new NguyenLieuServiceImplement();
        LoadTableDoUong();
        loadCBBFrame();
        listNL = service.getAll();
        fillToTBNL(listNL);
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
    public void fillToTBNL(List<NguyenLieuVModel> nl){
        model = (DefaultTableModel) tblNguyenLieu.getModel();
        model.setRowCount(0);
        nl.forEach((t) -> {
            model.addRow(t.dataRow());
        });
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel1 = new javax.swing.JLabel();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTrangThaiNL = new javax.swing.JTextField();
        btnResetNL = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaNL = new javax.swing.JTextField();
        btnThemNL = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguyenLieu = new javax.swing.JTable();
        txtXuatXuNL = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHanSuDungNL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNL = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnXoaNL = new javax.swing.JButton();
        btnSuaNL = new javax.swing.JButton();
        txtMaNL = new javax.swing.JTextField();
        txtNhaCungCapNL = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuongNL = new javax.swing.JTextField();
        dateNSXNL = new com.toedter.calendar.JDateChooser();
        txtTimKiemNL = new javax.swing.JTextField();
        btnTimKiemNL = new javax.swing.JButton();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlKhuyenMai = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTong.setBackground(new java.awt.Color(204, 255, 255));
        pnlTong.setPreferredSize(new java.awt.Dimension(1230, 710));

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
        btnDangXuatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatMenuActionPerformed(evt);
            }
        });

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

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(603, Short.MAX_VALUE))
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(654, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlBanHang, "cardBanHang");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(469, 469, 469))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel2)
                .addContainerGap(534, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
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
                        .addGap(0, 41, Short.MAX_VALUE))
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
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlDoAnUong, "cardSanPham");

        jLabel16.setText("H?n s? d?ng :");

        jLabel14.setText("Nhà cung c?p :");

        btnResetNL.setText("Reset");

        jLabel11.setText("S? lu?ng :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Qu?n lý nguyên li?u");

        jLabel12.setText("Ngày s?n xu?t");

        btnThemNL.setText("Thêm");
        btnThemNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNLActionPerformed(evt);
            }
        });

        tblNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Nguyên li?u", "Giá", "S? lu?ng", "Tr?ng thái", "Ngày s?n xu?t", "H?n s? d?ng", "Nhà cung c?p", "Xu?t x?"
            }
        ));
        jScrollPane2.setViewportView(tblNguyenLieu);

        jLabel13.setText("Tr?ng thái :");

        jLabel3.setText("Mã :");

        jLabel9.setText("Tên :");

        jLabel10.setText("Giá :");

        btnXoaNL.setText("Xóa");

        btnSuaNL.setText("S?a");

        jLabel15.setText("Xu?t x? :");

        btnTimKiemNL.setText("Tìm ki?m");

        javax.swing.GroupLayout pnlNguyenLieuLayout = new javax.swing.GroupLayout(pnlNguyenLieu);
        pnlNguyenLieu.setLayout(pnlNguyenLieuLayout);
        pnlNguyenLieuLayout.setHorizontalGroup(
            pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel4))
                    .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNguyenLieuLayout.createSequentialGroup()
                                .addComponent(btnThemNL)
                                .addGap(53, 53, 53)
                                .addComponent(btnSuaNL))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTimKiemNL)
                                    .addComponent(txtMaNL, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(txtTenNL)
                                    .addComponent(txtGiaNL)
                                    .addComponent(txtSoLuongNL))))
                        .addGap(70, 70, 70)
                        .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))
                                    .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                                        .addComponent(btnXoaNL)
                                        .addGap(35, 35, 35)))
                                .addGap(23, 23, 23)
                                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTrangThaiNL, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnResetNL))
                                    .addComponent(txtNhaCungCapNL)
                                    .addComponent(txtXuatXuNL)
                                    .addComponent(dateNSXNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHanSuDungNL, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTimKiemNL))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        pnlNguyenLieuLayout.setVerticalGroup(
            pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTrangThaiNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtHanSuDungNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlNguyenLieuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateNSXNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtGiaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhaCungCapNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(txtSoLuongNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXuatXuNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemNL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNL)
                    .addComponent(btnSuaNL)
                    .addComponent(btnXoaNL)
                    .addComponent(btnResetNL))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pnlgiaodien.add(pnlNguyenLieu, "cardNguyenLieu");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap(756, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel5)
                .addContainerGap(529, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlNhanVien, "cardNhanVien");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(737, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel6)
                .addContainerGap(523, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlKhachHang, "cardKhachHang");

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout pnlKhuyenMaiLayout = new javax.swing.GroupLayout(pnlKhuyenMai);
        pnlKhuyenMai.setLayout(pnlKhuyenMaiLayout);
        pnlKhuyenMaiLayout.setHorizontalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );
        pnlKhuyenMaiLayout.setVerticalGroup(
            pnlKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhuyenMaiLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel7)
                .addContainerGap(521, Short.MAX_VALUE))
        );

        pnlgiaodien.add(pnlKhuyenMai, "cardKhuyenMai");

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongKeLayout.createSequentialGroup()
                .addContainerGap(716, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel8)
                .addContainerGap(533, Short.MAX_VALUE))
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
                    .addComponent(pnlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnThemNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNLActionPerformed
        // TODO add your handling code here:
        NguyenLieu NLMD = new NguyenLieu();
        NLMD.setGia(Double.parseDouble(txtGiaNL.getText()));
        NLMD.setHSD(Integer.parseInt(txtHanSuDungNL.getText()));
        NLMD.setMa(txtMaNL.getText());
        NLMD.setNgaySanXuat(dateNSXNL.getDate());
        NLMD.setNhaCungCap(txtNhaCungCapNL.getText());
        NLMD.setSoLuong(Integer.parseInt(txtSoLuongNL.getText()));
        NLMD.setTen(txtTenNL.getText());
        NLMD.setTrangThai(Integer.parseInt(txtTrangThaiNL.getText()));
        NLMD.setXuatXu(txtXuatXuNL.getText());
        
        JOptionPane.showMessageDialog(rootPane, service.add(NLMD));
        listNL = service.getAll();
        fillToTBNL(listNL);
    }//GEN-LAST:event_btnThemNLActionPerformed

    private void btnDangXuatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatMenuActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(rootPane, "b?n có ch?c mu?n dang xu?t","Ðang xu?t",JOptionPane.YES_NO_OPTION);
        if(check ==JOptionPane.YES_OPTION){
            this.setVisible(false);
            DangNhapFrame dn = new DangNhapFrame();
            dn.setVisible(true);
        }
    }//GEN-LAST:event_btnDangXuatMenuActionPerformed

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
    private javax.swing.JButton btnNguyenLieuMenu;
    private javax.swing.JButton btnNhanVienMenu;
    private javax.swing.JButton btnResetNL;
    private javax.swing.JButton btnSuaDoUong;
    private javax.swing.JButton btnSuaNL;
    private javax.swing.JButton btnThemNL;
    private javax.swing.JButton btnThemdoUong;
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnTimKiemKho;
    private javax.swing.JButton btnTimKiemNL;
    private javax.swing.JButton btnXoaDoUong;
    private javax.swing.JButton btnXoaNL;
    private javax.swing.JButton btnclearFromThongtinSP;
    private javax.swing.JComboBox<String> cbbDanhMucKho;
    private javax.swing.JComboBox<String> cbbDanhmucSp;
    private javax.swing.JComboBox<String> cbbSize;
    private com.toedter.calendar.JDateChooser dateNSXNL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblLocDMkho;
    private javax.swing.JLabel lblMaDoUong;
    private javax.swing.JLabel lblSizeSanPham;
    private javax.swing.JLabel lblTenSp;
    private javax.swing.JLabel lblTimKiemTenSPKho;
    private javax.swing.JLabel lblTrangthai;
    private javax.swing.JLabel lblVi;
    private javax.swing.JLabel lbldanhmucSP;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlDoAnUong;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlKhuyenMai;
    private javax.swing.JPanel pnlNguyenLieu;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlTong;
    private javax.swing.JPanel pnlgiaodien;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JTable tblNguyenLieu;
    private javax.swing.JTable tblSanPhamDouong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaNL;
    private javax.swing.JTextField txtHanSuDungNL;
    private javax.swing.JTextField txtMaNL;
    private javax.swing.JTextField txtNhaCungCapNL;
    private javax.swing.JTextField txtSoLuongNL;
    private javax.swing.JTextField txtTenDoUong;
    private javax.swing.JTextField txtTenNL;
    private javax.swing.JTextField txtTimKiemKho;
    private javax.swing.JTextField txtTimKiemNL;
    private javax.swing.JTextField txtTrangThai;
    private javax.swing.JTextField txtTrangThaiNL;
    private javax.swing.JTextField txtVi;
    private javax.swing.JTextField txtXuatXuNL;
    private javax.swing.JTextField txtmaDoUong;
    // End of variables declaration//GEN-END:variables
}
