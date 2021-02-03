//package com.example.myapp.objects;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapp.R;
//import com.example.myapp.TruyenRecycler.model.TheLoai;
//import com.example.myapp.TruyenRecycler.model.Truyen;
//
//import java.util.ArrayList;
//
//
//public class ListViewActivityTheLoai extends AppCompatActivity {
//    private ListView lv_the_loai;
//    private ListAdapterTheLoai listAdapterTheLoai;
//    private ListView listView;
//    private ListAdapterTruyen listAdapterTruyen;
//    private ArrayList<TheLoai> dsTheLoai = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_view_the_loai);
////        initViewsTheLoai();
//        initDSTheLoai();
//
////        lv_the_loai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
////                TheLoai theLoai = dsTheLoai.get(position);
////                ArrayList<Truyen> dsTruyen = theLoai.getDsTruyen();
////                Intent intent = new Intent(ListViewActivityTheLoai.this, ListViewActivityTruyen.class);
////                intent.putParcelableArrayListExtra(Constants.KEY_DS_TRUYEN, dsTruyen);
////                startActivity(intent);
////            }
////        });
//    }
//
////    private void initViewsTheLoai() {
////        lv_the_loai = findViewById(R.id.lv_the_loai);
////        listAdapterTheLoai = new ListAdapterTheLoai(FragmentTruyenCoTich.this, dsTheLoai);
////        lv_the_loai.setAdapter(listAdapterTheLoai);
////    }
//
//    public void initDSTheLoai() {
//        //Ngu ngon
//        ArrayList<Truyen> dsTruyenNguNgon = new ArrayList<>();
//        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon01, "Đàn kiến đền ơn", R.string.dan_kien_tra_on));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon02, "Thầy tu rởm", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon03, "Tình bạn của rái cá", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon04, "Vẹt và châu chấu", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon05, "Chim sơn ca", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon06, "Heo rừng và thỏ", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon7, "Ông lão và con lừa", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon08, "Sếu, cua, và bầy cá", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon09, "Sói và dê", "Ngày xửa ngày xưa"));
////        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon10, "Lừa và la", "Ngày xửa ngày xưa"));
//        TheLoai nguNgon = new TheLoai(R.drawable.nen4, "Ngụ Ngôn", dsTruyenNguNgon);
//
//        //Vietnam
//        ArrayList<Truyen> dsTruyenVN = new ArrayList<>();
////        dsTruyenVN.add(new Truyen(R.drawable.vn_su_tich_dua_hau, "Sự tích dưa hấu", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_02, "Sự tích chim gò sóng", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_03, "Sự tích con Ve sầu", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn04, "Sự tích Thánh làng Chèm", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_05, "Sự tích con Chuồn Chuồn", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_06, "Sự tích Vịnh Hạ Long", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_07, "Sự tích Dưa Bở", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_08, "Sự tích con Mối", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_09, "Sự tích bông Hoa Cúc", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_10, "Sự tích hoa Thủy Tinh", "Ngày xửa ngày xưa"));
////        dsTruyenVN.add(new Truyen(R.drawable.vn_11, "Sự tích Cầu Vồng", "Ngày xửa ngày xưa"));
//        TheLoai VN = new TheLoai(R.drawable.nen3, "Việt Nam", dsTruyenVN);
//
//        // Grim
//        ArrayList<Truyen> dsTruyenGrim = new ArrayList<>();
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_01, "Gã say bột nghèo khó và con mèo đốm", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_02, "Mười hai công chúa và những đôi giày nhảy rách", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_03, "Ba anh em", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_04, "Cáo, sư tử và ngựa", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_05, "Ba anh chàng số đỏ", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_06, "Ba chàng hoàng tử", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_07, "Bác thợ xay bột và con quỷ", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim08, "Chuột nhắt, chim sẻ và dồi nướng", "Ngày xửa ngày xưa"));
////        dsTruyenGrim.add(new Truyen(R.drawable.grim_09, "Sự tích hạt đậu", "Ngày xửa ngày xưa"));
//
//        TheLoai Grim = new TheLoai(R.drawable.the_loai_grim, "Grim", dsTruyenGrim);
//
//        //The Gioi
//        ArrayList<Truyen> dsTruyenTheGioi = new ArrayList<>();
////        dsTruyenTheGioi.add(new Truyen(R.drawable.the_gioi_01, "Nàng công chúa bán than", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi_02, "Sự tích chuột chù", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi03, "Cái giá của sự thông thái", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi04, "Chiếc hộp sắt biết nói", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi05, "Con chim khách màu nhiệm", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi06, "Ba bó rơm nếp", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi07, "Truyền thuyết hoa hồng vàng", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi08, "Cái tai có phép lạ", "Ngày xửa ngày xưa"));
////        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi09, "Sự tích Hằng Nga", "Ngày xửa ngày xưa"));
//
//        TheLoai TheGioi = new TheLoai(R.drawable.the_loai_the_gioi, "Thế Giới", dsTruyenTheGioi);
//        // Andersen
//        ArrayList<Truyen> dsTruyenAndersen = new ArrayList<>();
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen02, "Bộ quần áo mới của Hoàng đế", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen02, "Đôi giày đỏ", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen03, "Cô bé bán diêm", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen04, "Chiếc bật lửa thần", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen05, "Bác làm vườn và chủ nhà", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen06, "Nàng tiên cá", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen07, "Gia đình nhà cò", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen08, "Chiêc hòm bay", "Ngày xửa ngày xưa"));
////        dsTruyenAndersen.add(new Truyen(R.drawable.andersen09, "Chú lính chì dũng cảm", "Ngày xửa ngày xưa"));
//
//        TheLoai Andersen = new TheLoai(R.drawable.the_loai_andersen, "Andersen", dsTruyenAndersen);
//
//        //Hy Lap
//        ArrayList<Truyen> dsTruyenHyLap = new ArrayList<>();
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap01, "Vua Midas - Hoàng đế tai lừa", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap02, "Thần Aplollo và Artemis - Cặp song sinh nổi tiếng thần thoại", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap03, "Truyền thuyết nữ thần Athena", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap04, "Chuyện tình chàng Orpheus và nàng Eurydice - truyền thuyết cây đàn lia", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap05, "Thần thoại Narcissus và Echo - Truyền thuyết hoa thủy tiên", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap06, "Thần Hades - Vị thần cai quản địa ngục", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hyla07, "Nữ thần Hera - vị thần bảo trợ hôn nhân và gia đinh", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap08, "Poseidon - Vị thần của biển cả", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap09, "Thần Zeus( Dớt, Jupiter) vị thần tối cao trên đỉnh Olympus", "Ngày xửa ngày xưa"));
////        dsTruyenHyLap.add(new Truyen(R.drawable.hylap10, "Nữ thần tình yêu Aphrodite hay thần vệ nữ", "Ngày xửa ngày xưa"));
//
//        TheLoai HyLap = new TheLoai(R.drawable.the_loai_hy_lap, "Hy Lạp", dsTruyenHyLap);
//
//        dsTheLoai.add(nguNgon);
//        dsTheLoai.add(VN);
//        dsTheLoai.add(Grim);
//        dsTheLoai.add(TheGioi);
//        dsTheLoai.add(Andersen);
//        dsTheLoai.add(HyLap);
//        listAdapterTheLoai.notifyDataSetChanged();
//    }
//}