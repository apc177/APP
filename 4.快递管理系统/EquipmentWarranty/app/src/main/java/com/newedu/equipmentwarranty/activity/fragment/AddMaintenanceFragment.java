package com.newedu.equipmentwarranty.activity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.newedu.equipmentwarranty.adapter.MaintenanceInfoAdapter;
import com.newedu.equipmentwarranty.entity.AreaInfo;
import com.newedu.equipmentwarranty.entity.EquipmentInfo;
import com.newedu.equipmentwarranty.entity.JsonData;
import com.newedu.equipmentwarranty.entity.MaintenanceInfoVO;
import com.newedu.equipmentwarranty.entity.SpinnerData;
import com.theartofdev.edmodo.cropper.CropImage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.newedu.equipmentwarranty.Config;
import com.newedu.equipmentwarranty.R;
import com.newedu.equipmentwarranty.entity.MessageEvent;
import com.newedu.equipmentwarranty.utils.HttpUtils;

public class AddMaintenanceFragment extends Fragment {

    private Spinner buildingSpinner,floorSpinner,equipmentTypeSpinner,equipmentNameSpinner;
    private EditText maintenanceSNEdit,deviceLocationEdit,descriptionEdit,comp,adressee,tel;
    private ImageView buildImage;
    private Button submitBtn;
    private String areaID,equipmentID;
    private Uri imageUri, resultUri;
    private File mOutputImage;
    private Bitmap mBitmap;
    public static final int TAKE_PHOTO = 1;
    public static final int CUT_PHOTO = 2;
    String a1,a2;
    private OkHttpClient okHttpClient;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addmaintenance, container, false);
        EventBus.getDefault().register(this);

        // 获取layout中控件的引用
        tel=root.findViewById(R.id.tel);
        adressee=root.findViewById(R.id.addressee);
        maintenanceSNEdit = root.findViewById(R.id.maintenanceSN);
        buildingSpinner = root.findViewById(R.id.builing_spinner);
        floorSpinner = root.findViewById(R.id.floor_spinners);
        comp=root.findViewById(R.id.company);
        deviceLocationEdit = root.findViewById(R.id.deviceLocation);
        descriptionEdit = root.findViewById(R.id.description);
        buildImage = root.findViewById(R.id.buildimg);

        submitBtn = root.findViewById(R.id.submitBtn);


        buildImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOutputImage = new File(getActivity().getExternalCacheDir(), "output_image.jpg");

                try {
                    if (mOutputImage.exists()) {
                        mOutputImage.delete();
                    }
                    boolean flag = mOutputImage.createNewFile();
                    Log.e("flag",flag+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(getActivity()
                            , "com.newedu.equipmentwarranty.fileprovider",
                            mOutputImage);
                } else {
                    imageUri = Uri.fromFile(mOutputImage);
                }
                //启动相机程序
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });

        /** 保存操作 */
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a1.isEmpty()){
                    Toast.makeText(view.getContext(),"位置需要选择,否则没法保存",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(a2.isEmpty()){
                    Toast.makeText(view.getContext(),"位置名称需要选择,否则没法保存",Toast.LENGTH_SHORT).show();
                    return;
                }
                File file = null;
                OkHttpClient client = HttpUtils.getClient();
                try {
                    file = new File(new URI(resultUri.toString()));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                RequestBody body = RequestBody.create(MediaType.parse("image/png"), file);

                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM);
                builder.addFormDataPart("sender", maintenanceSNEdit.getText().toString());
                builder.addFormDataPart("image", System.currentTimeMillis()+".jpg", body);
                builder.addFormDataPart("remarks",descriptionEdit.getText().toString());
                builder.addFormDataPart("address",a1+a2);
                builder.addFormDataPart("company",comp.getText().toString());
                builder.addFormDataPart("name",Config.name);
                builder.addFormDataPart("addressee",adressee.getText().toString());
                builder.addFormDataPart("tel",tel.getText().toString());
                System.out.println(tel.getText().toString());
                MultipartBody multipartBody = builder.build();

//name=111&remarks=&image=&tel=&company=&sender=&address=&addressee=
                Log.d("multipartBody:",multipartBody.part(2).body().toString());
                final MediaType FORM_CONTENT_TYPE
                        = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
                RequestBody formBody = null;

                try {
                    formBody = new FormBody.Builder()

                            .add("name", Config.name)
                            .add("sender", maintenanceSNEdit.getText().toString())
                            .add("image", "http://39.106.186.134/a11.png")
                            .add("remarks",descriptionEdit.getText().toString())
                            .add("address",a1+a2)
                            .add("addressee",adressee.getText().toString())
                            .add("company",comp.getText().toString())
                            .add("tel",tel.getText().toString())
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(a1+a2);
                final Request request = new Request.Builder()
                        .url(Config.BASE_URL+"/Addlist" )
                        .post(formBody)
                        .build();
//                Request request = new Request.Builder()
//                        .url(Config.BASE_URL+"Addlist")
//                        .post(multipartBody)
//                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String s = response.body().string();
                        Log.e("MainActivity", s);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "成功" + s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });

        return root;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        buildImage.setImageBitmap((Bitmap) messageEvent.getData());
        resultUri = messageEvent.getResultUri();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.i("AddBuildFragment",requestCode+"");

        switch (requestCode) {

            case TAKE_PHOTO:
                if (resultCode == getActivity().RESULT_OK) {
                    CropImage.activity(imageUri)
                            .start(getActivity());
                }
                break;
            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE: {

                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == getActivity().RESULT_OK) {
                    resultUri = result.getUri();
                    try {
                        mBitmap = BitmapFactory.decodeStream(
                                getActivity().getContentResolver().openInputStream(resultUri));
                        buildImage.setImageBitmap(mBitmap);
                        Log.i("AddBuildFragment","----------------");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                }
            }
            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initPage();
    }

    /**
     * 页面数据初始化
     */
    private void initPage() {
        String url = Config.BASE_URL + "/servlet/m/maintenance/queryAreaAndEquipList";
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("token", Config.token)
                .addHeader("mobile", "mobile")
                .build();
        okHttpClient = HttpUtils.getClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("str",str);


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 绑定数据到spinner
                        Map<String, List> map = new HashMap<>();
                        List<String> b=new Vector<>();
                        String a="";
//
                        a="area";
                        try {
                            b.add(new String("金水区".getBytes("utf-8")));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        b.add("管城区");b.add("郑东新区");
                        map.put(a,b);
                        b.clear();

                        a="equip";
                        b.add("1");b.add("2");b.add("3");
                        map.put(a,b);

                        List equipType = map.get("equip");

                        List<SpinnerData> buildingSourceList = new ArrayList<>();
                        buildingSourceList.add(new SpinnerData("--请选择--","--请选择--"));
                        buildingSourceList.add(new SpinnerData("1","郑州市"));
                        buildingSourceList.add(new SpinnerData("2","北京市"));
                        buildingSourceList.add(new SpinnerData("3","老八的菜单"));

                        ArrayAdapter<SpinnerData> adapter = new ArrayAdapter<>(getContext(), R.layout.building_spinner_item, buildingSourceList);
                        //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自己定义改动
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        adapter.setDropDownViewResource(R.layout.builing_spinner_dropdown_item);
                        buildingSpinner.setAdapter(adapter);

                        //加入事件Spinner事件监听
                        buildingSpinner.setOnItemSelectedListener(new BuildingSpinnerSelectedListener());


                        // 设备类型Spinner的数据绑定
                        List<SpinnerData> equipmentTypeSourceList = new ArrayList<>();
                        equipmentTypeSourceList.add(new SpinnerData("--请选择--","--请选择--"));
                        for(Object item: equipType){
                            equipmentTypeSourceList.add(new SpinnerData(item.toString(),item.toString()));
                        }
                        ArrayAdapter<SpinnerData> adapterEquipType = new ArrayAdapter<>(getContext(), R.layout.building_spinner_item, equipmentTypeSourceList);
                        //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自己定义改动
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        adapterEquipType.setDropDownViewResource(R.layout.builing_spinner_dropdown_item);

                    }
                });
            }

        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /** building 下拉列表的change事件*/
    private class BuildingSpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            SpinnerData selectedItem = (SpinnerData)parent.getItemAtPosition(position);

            String text = selectedItem.getText();
            String value = selectedItem.getValue();
            Toast.makeText(view.getContext(),"text="+text+"&value="+value,Toast.LENGTH_SHORT).show();
            if(!text.equalsIgnoreCase("--请选择--")){
                floorSpinnerBinding(text);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    /** 根据 所选中的楼栋号,查询对应的所有楼层号*/
    private void floorSpinnerBinding(String building){
        a1=building;
        final List<String> lists=new Vector<>();
        if(building.equals("郑州市")){
            lists.add("金水区");
            lists.add("管城区");
            lists.add("二七区");
            lists.add("正东新区");
        }
        else if(building.equals("北京市")){
            lists.add("公主坟");
            lists.add("长安街");
            lists.add("毛纪的家");
        }
        else if(building.equals("老八的菜单")){
            lists.add("晓汉堡");
            lists.add("老干妈");
            lists.add("俘虏");
            lists.add("柠檬");
            lists.add("六舅");
            lists.add("米饭");
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 绑定数据到spinner

                List<SpinnerData> floorSourceList = new ArrayList<>();
                floorSourceList.add(new SpinnerData("--请选择--","--请选择--"));
                int i=0;
                for(String item: lists){
                    floorSourceList.add(new SpinnerData(i+++"",item));
                }
                ArrayAdapter<SpinnerData> adapter = new ArrayAdapter<>(getContext(), R.layout.building_spinner_item, floorSourceList);
                //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自己定义改动
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(R.layout.builing_spinner_dropdown_item);
                floorSpinner.setAdapter(adapter);

                //加入事件Spinner事件监听
                floorSpinner.setOnItemSelectedListener(new FloorSpinnerSelectedListener());
            }
        });


    }

    /** floor 下拉列表的change事件*/
    private class FloorSpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerData selectedItem = (SpinnerData)parent.getItemAtPosition(position);

            String text = selectedItem.getText();
            String value = selectedItem.getValue();
            a2=text;
            if(!text.equalsIgnoreCase("--请选择--")){
                areaID = value;
            }
            else{
                Toast.makeText(view.getContext(),"text="+text+"&value="+value,Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    /** equipmentType 下拉列表的change事件*/
    private class EquipmentTypeSpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerData selectedItem = (SpinnerData)parent.getItemAtPosition(position);

            String text = selectedItem.getText();
            String value = selectedItem.getValue();
            Toast.makeText(view.getContext(),"text="+text+"&value="+value,Toast.LENGTH_SHORT).show();

            if(!text.equalsIgnoreCase("--请选择--")){
                equipmentNameSpinnerBinding(text);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    /** 根据 所选中的设备类型，查询对应的所有设备名称*/
    private void equipmentNameSpinnerBinding(String equipmentType){
        String url = Config.BASE_URL + "/servlet/m/equipment/queryByType";

        RequestBody formBody = new FormBody.Builder()
                .add("equipmentType", equipmentType)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .addHeader("token", Config.token)
                .addHeader("mobile", "mobile")
                .build();
        okHttpClient = HttpUtils.getClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("str",str);
                final JsonData<List<EquipmentInfo>> jsonData = JSON.parseObject(str, new TypeReference<JsonData<List<EquipmentInfo>>>() {
                });

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 绑定数据到spinner
                        List<EquipmentInfo> list = jsonData.getData();
                        List<SpinnerData> equipmentNameSourceList = new ArrayList<>();
                        equipmentNameSourceList.add(new SpinnerData("--请选择--","--请选择--"));
                        for(EquipmentInfo item: list){
                            equipmentNameSourceList.add(new SpinnerData(String.valueOf(item.getId()),item.getEquipmentName()));
                        }
                        ArrayAdapter<SpinnerData> adapter = new ArrayAdapter<>(getContext(), R.layout.building_spinner_item, equipmentNameSourceList);
                        //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自己定义改动
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        adapter.setDropDownViewResource(R.layout.builing_spinner_dropdown_item);
                        equipmentNameSpinner.setAdapter(adapter);

                        //加入事件Spinner事件监听
                        equipmentNameSpinner.setOnItemSelectedListener(new EquipmentNameSpinnerSelectedListener());
                    }
                });
            }

        });
    }


    /** 设备名称 下拉列表 change事件 */
    private class EquipmentNameSpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerData selectedItem = (SpinnerData)parent.getItemAtPosition(position);

            String text = selectedItem.getText();
            String value = selectedItem.getValue();

            if(!text.equalsIgnoreCase("--请选择--")){
                equipmentID = value;
            }else{
                Toast.makeText(view.getContext(),"text="+text+"&value="+value,Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}