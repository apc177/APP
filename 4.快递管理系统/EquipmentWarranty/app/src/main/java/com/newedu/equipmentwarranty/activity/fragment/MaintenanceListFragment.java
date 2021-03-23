package com.newedu.equipmentwarranty.activity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.newedu.equipmentwarranty.Config;
import com.newedu.equipmentwarranty.R;
import com.newedu.equipmentwarranty.activity.MainActivity;
import com.newedu.equipmentwarranty.adapter.MaintenanceInfoAdapter;
import com.newedu.equipmentwarranty.entity.MaintenanceInfo;
import com.newedu.equipmentwarranty.entity.JsonData;
import com.newedu.equipmentwarranty.entity.MaintenanceInfoVO;
import com.newedu.equipmentwarranty.utils.HttpUtils;

import static android.content.ContentValues.TAG;


public class MaintenanceListFragment extends Fragment {

    private RecyclerView buildListView;
    private MaintenanceInfoAdapter adapter;
    private OkHttpClient okHttpClient;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_maintenancelist, container, false);
        buildListView = root.findViewById(R.id.buildListView);
        buildListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        buildListView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }

    private void loadData() {
        String url = Config.BASE_URL + "/getdata?name="+Config.name+"&queryName=&limit=5&offset=0&pageIndex=1&pageSize=20&use=1";

        final Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("mobile", "mobile")
                .build();
        System.out.println(url);
        okHttpClient = HttpUtils.getClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e("js",str);
               final JSONObject jsonObject=JSONObject.parseObject(str);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MaintenanceInfoAdapter(getActivity(),jsonObject);
                        adapter.setOnItemClickListener(new MaintenanceInfoAdapter.OnItemClickListener() {
                            @Override
                            public void onClick(int position) {
                               //do nothing
                            }

                            @Override
                            public void onLongClick(int position) {
                                String s=Config.BASE_URL+"/qianshou?id="+(JSONObject.parseObject(jsonObject.getJSONArray("rows").get(position).toString()).get("id"));
                                System.out.println(s);
                                final Request request = new Request.Builder()
                                        .url(s)
                                        .get()
                                        .addHeader("mobile", "mobile")
                                        .build();
                               OkHttpClient mOkHttpClient = HttpUtils.getClient();
                                Call call = mOkHttpClient.newCall(request);
                                call.enqueue(new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {

                                    }

                                });
                                Toast.makeText(getActivity(), "签收成功", Toast.LENGTH_SHORT).show();
                                loadData();
                            }
                        });
                        buildListView.setAdapter(adapter);

                    }
                });
            }

        });
    }
}
