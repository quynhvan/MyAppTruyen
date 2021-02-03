package com.example.myapp.TruyenRecycler.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.Constants;
import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.Activity.ActivityTruyen;
import com.example.myapp.TruyenRecycler.Adapter.AdapterTheLoai;
import com.example.myapp.TruyenRecycler.model.TheLoai;
import com.example.myapp.TruyenRecycler.model.Truyen;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 **/
public class FragmentTruyenCoTich extends Fragment  {
    private ArrayList<TheLoai> dsTheLoai = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterTheLoai adapterTheLoai;
    public ArrayList<Truyen> dsTruyen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_the_loai, container, false);
        recyclerView = view.findViewById(R.id.re_the_loai);
        initShow();
        initDSTheLoai();
        return view;
    }
    private void initShow(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterTheLoai = new AdapterTheLoai(getContext(), dsTheLoai, new AdapterTheLoai.OnItemClickTheLoai() {
            @Override
            public void onClickTheLoai(int position) {
                TheLoai theLoai = dsTheLoai.get(position);
                dsTruyen = theLoai.getDsTruyen();
                Intent intent = new Intent(getContext(), ActivityTruyen.class);
                intent.putParcelableArrayListExtra(Constants.KEY_DS_TRUYEN,dsTruyen);
                getContext().startActivity(intent);

            }
        });
        recyclerView.setAdapter(adapterTheLoai);
    }
    public void initDSTheLoai() {
        //Ngu ngon
        ArrayList<Truyen> dsTruyenNguNgon = new ArrayList<>();
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon01, "Đàn kiến đền ơn", R.string.dan_kien_tra_on));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon02, "Thầy tu rởm",R.string.thay_tu_rom));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon03, "Tình bạn của rái cá", R.string.tinh_ban_cua_rai_ca));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon04, "Vẹt và châu chấu", R.string.vet_va_chau_chau));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon05, "Chim sơn ca", R.string.chim_son_ca));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon06, "Heo rừng và thỏ", R.string.heo_rung_va_tho));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon7, "Ông lão và con lừa", R.string.ong_lao_va_con_lua));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon08, "Sếu, cua, và bầy cá", R.string.seu_cua_va_bay_ca));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon09, "Sói và dê", R.string.soi_va_de));
        dsTruyenNguNgon.add(new Truyen(R.drawable.ngungon10, "Lừa và la", R.string.lua_va_la));
        TheLoai nguNgon = new TheLoai(R.drawable.nen4, "Ngụ Ngôn", dsTruyenNguNgon);

        //Vietnam
        ArrayList<Truyen> dsTruyenVN = new ArrayList<>();
        dsTruyenVN.add(new Truyen(R.drawable.vn_su_tich_dua_hau, "Sự tích dưa hấu", R.string.su_tich_dua_hau));
        dsTruyenVN.add(new Truyen(R.drawable.vn_02, "Sự tích chim gò sóng", R.string.su_tich_chim_go_song));
        dsTruyenVN.add(new Truyen(R.drawable.vn_03, "Sự tích con Ve sầu", R.string.su_tich_con_ve_sau));
        dsTruyenVN.add(new Truyen(R.drawable.vn04, "Sự tích Thánh làng Chèm", R.string.su_tich_thanh_lang_chem));
        dsTruyenVN.add(new Truyen(R.drawable.vn_05, "Sự tích con Chuồn Chuồn", R.string.su_tich_con_chuon_chuon));
        dsTruyenVN.add(new Truyen(R.drawable.vn_06, "Sự tích Vịnh Hạ Long", R.string.su_tich_vinh_ha_long));
        dsTruyenVN.add(new Truyen(R.drawable.vn_07, "Sự tích Dưa Bở", R.string.su_tich_dua_bo));
        dsTruyenVN.add(new Truyen(R.drawable.vn_08, "Sự tích con Mối", R.string.su_tich_con_moi));
        dsTruyenVN.add(new Truyen(R.drawable.vn_09, "Sự tích bông Hoa Cúc", R.string.su_tich_bong_hoa_cuc));
        dsTruyenVN.add(new Truyen(R.drawable.vn_10, "Sự tích hoa Thủy Tinh", R.string.su_tich_hoa_thuy_tinh));
        dsTruyenVN.add(new Truyen(R.drawable.vn_11, "Sự tích Cầu Vồng",R.string.su_tich_cau_vong));
        TheLoai VN = new TheLoai(R.drawable.nen3, "Việt Nam", dsTruyenVN);

        // Grim
        ArrayList<Truyen> dsTruyenGrim = new ArrayList<>();
        dsTruyenGrim.add(new Truyen(R.drawable.grim_01, "Gã say bột nghèo khó và con mèo đốm", R.string.ga_xay_bot_va_chu_meo_dom));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_02, "Mười hai công chúa và những đôi giày nhảy rách", R.string.muoi_hai_cong_chua_va_nhung_doi_giay_rach));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_03, "Ba anh em", R.string.ba_anh_em));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_04, "Cáo, sư tử và ngựa", R.string.cao_su_tu_va_ngua));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_05, "Ba anh chàng số đỏ", R.string.ba_chang_trai_so_do));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_06, "Ba chàng hoàng tử", R.string.ba_chang_hoang_tu));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_07, "Bác thợ xay bột và con quỷ", R.string.ga_xay_bot_va_con_quy));
        dsTruyenGrim.add(new Truyen(R.drawable.grim08, "Chuột nhắt, chim sẻ và dồi nướng", R.string.chuot_nhat_chim_se_va_doi_nuong));
        dsTruyenGrim.add(new Truyen(R.drawable.grim_09, "Sự tích hạt đậu", R.string.su_tich_hat_dau));

        TheLoai Grim = new TheLoai(R.drawable.the_loai_grim, "Grim", dsTruyenGrim);

        //The Gioi
        ArrayList<Truyen> dsTruyenTheGioi = new ArrayList<>();
        dsTruyenTheGioi.add(new Truyen(R.drawable.the_gioi_01, "Nàng công chúa bán than", R.string.su_tich_cong_chua_ban_than));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi_02, "Sự tích chuột chù", R.string.su_tich_chuot_tru));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi03, "Cái giá của sự thông thái", R.string.cai_gia_cua_su_thong_thai));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi04, "Chiếc hộp sắt biết nói", R.string.chiec_hop_sat_biet_noi));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi05, "Con chim khách màu nhiệm", R.string.con_chim_khach_mau_nhiem));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi06, "Ba bó rơm nếp", R.string.ba_bo_rom_nep));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi07, "Truyền thuyết hoa hồng vàng", R.string.truyen_thuyet_hoa_hong_vang));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi08, "Cái tai có phép lạ", R.string.cai_tai_co_phep_la));
        dsTruyenTheGioi.add(new Truyen(R.drawable.thegioi09, "Sự tích Hằng Nga", R.string.su_tich_hang_nga));

        TheLoai TheGioi = new TheLoai(R.drawable.the_loai_the_gioi, "Thế Giới", dsTruyenTheGioi);
        // Andersen
        ArrayList<Truyen> dsTruyenAndersen = new ArrayList<>();
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen02, "Bộ quần áo mới của Hoàng đế", R.string.bo_quan_ao_moi_cua_hoang_de));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen02, "Đôi giày đỏ", R.string.doi_giay_do));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen03, "Cô bé bán diêm", R.string.co_be_ban_diem));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen04, "Chiếc bật lửa thần", R.string.chiec_bat_lua_than));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen05, "Bác làm vườn và chủ nhà", R.string.bac_lam_vuon_va_chu_nha));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen06, "Nàng tiên cá", R.string.nang_tien_ca));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen07, "Gia đình nhà cò", R.string.gia_dinh_nha_co));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen08, "Chiêc hòm bay", R.string.chiec_hom_bay));
        dsTruyenAndersen.add(new Truyen(R.drawable.andersen09, "Chú lính chì dũng cảm", R.string.chu_linh_chi_dung_cam));

        TheLoai Andersen = new TheLoai(R.drawable.the_loai_andersen, "Andersen", dsTruyenAndersen);

        //Hy Lap
        ArrayList<Truyen> dsTruyenHyLap = new ArrayList<>();
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap01, "Vua Midas - Hoàng đế tai lừa", R.string.vua_midas_hoang_de_tai_lua));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap02, "Thần Aplollo và Artemis - Cặp song sinh nổi tiếng thần thoại", R.string.than_apollo_va_than_atemis));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap03, "Truyền thuyết nữ thần Athena", R.string.truyen_thuyet_nu_than_athena));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap04, "Chuyện tình chàng Orpheus và nàng Eurydice - truyền thuyết cây đàn lia", R.string.chuyen_tinh_chang_orpheus));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap05, "Thần thoại Narcissus và Echo - Truyền thuyết hoa thủy tiên", R.string.than_thoai_Narcissus));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap06, "Thần Hades - Vị thần cai quản địa ngục", R.string.than_Hades));
        dsTruyenHyLap.add(new Truyen(R.drawable.hyla07, "Nữ thần Hera - vị thần bảo trợ hôn nhân và gia đinh", R.string.vi_than_Hera));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap08, "Poseidon - Vị thần của biển cả", R.string.Poseidon_than_bien_ca));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap09, "Thần Zeus( Dớt, Jupiter) vị thần tối cao trên đỉnh Olympus", R.string.than_Zeus));
        dsTruyenHyLap.add(new Truyen(R.drawable.hylap10, "Nữ thần tình yêu Aphrodite hay thần vệ nữ", R.string.nu_than_tinh_yeu_Aphrodite));

        TheLoai HyLap = new TheLoai(R.drawable.the_loai_hy_lap, "Hy Lạp", dsTruyenHyLap);

        dsTheLoai.add(nguNgon);
        dsTheLoai.add(VN);
        dsTheLoai.add(Grim);
        dsTheLoai.add(TheGioi);
        dsTheLoai.add(Andersen);
        dsTheLoai.add(HyLap);
        adapterTheLoai.notifyDataSetChanged();
    }
}
