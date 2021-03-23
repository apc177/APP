package com.newedu.equipmentwarranty.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.newedu.equipmentwarranty.entity.JsonData;
import com.newedu.equipmentwarranty.entity.MaintenanceInfoVO;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.Vector;

import com.newedu.equipmentwarranty.Config;
import com.newedu.equipmentwarranty.R;
import com.newedu.equipmentwarranty.entity.MaintenanceInfo;

public class MaintenanceInfoAdapter extends RecyclerView.Adapter<MaintenanceInfoAdapter.ViewHolder> {
    private List<MaintenanceInfoVO> dataList;
    private LayoutInflater layoutInflater;
    private Context context;
    private  OnItemClickListener onItemClickListener;
    /*习惯在Adapter中定义接口*/
    //条目的点击
    public interface OnItemClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public MaintenanceInfoAdapter(Context context, JSONObject jsonObject) {
        System.out.println(jsonObject);
        this.dataList = new Vector<>();
        JSONArray jsonArray = jsonObject.getJSONArray("rows");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject j=jsonArray.getJSONObject(i);//String address, String addressee, String waybill, String courier, String sender, String company, String telephone, String delytime, String picture, String remarks)
            String s=j.getString("picture");
            if(s==null||s.length()==0){
                s="http://39.106.186.134/a11.png";
            }
            else {
                while(s.charAt(0)=='.'){
                    s=s.substring(1);
                }
            };
            dataList.add(new MaintenanceInfoVO(j.getInteger("id"),j.getString("address"),j.getString("addressee"),j.getString("waybill"),j.getString("courier"),j.getString("sender"),j.getString("company"),j.getString("telephone"),j.getString("delytime"),s,j.getString("remarks")));
        }
        layoutInflater = LayoutInflater.from(context);
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.maintenance_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        MaintenanceInfoVO maintenanceInfo = dataList.get(position);
        Log.i("url",Config.BASE_URL+maintenanceInfo.getPicture());
        // todo 项目名重复了，后面让后台修改这个bug
        Log.d("imagePath:",Config.BASE_URL+maintenanceInfo.getPicture());
//        Picasso.with(context).load(Config.BASE_URL+maintenanceInfo.getImageURL()).into(holder.buildImg);
        if(maintenanceInfo.getPicture().charAt(0)!='h')
            Glide.with(context).load(Config.BASE_URL+maintenanceInfo.getPicture()).into(holder.buildImg);
        else {
            Glide.with(context).load(maintenanceInfo.getPicture()).into(holder.buildImg);
        }
        holder.deviceName.setText("公司："+maintenanceInfo.getCompany());
        holder.building.setText("地址："+maintenanceInfo.getAddress());
        holder.floor.setText("收货人："+maintenanceInfo.getAddressee());
        holder.deviceLocation.setText("收货地址："+maintenanceInfo.getCourier());
        holder.description.setText("备注："+maintenanceInfo.getRemarks());
        holder.time.setText("发货时间："+maintenanceInfo.getDelytime());
        if(onItemClickListener!=null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onLongClick(position);
                    Log.i("url","123");
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView buildImg;
        private TextView deviceName;
        private TextView building;
        private TextView floor;
        private TextView deviceLocation;
        private TextView description;
        private TextView time;



        ViewHolder(View itemView) {
            super(itemView);

            buildImg = itemView.findViewById(R.id.buildImg);
            deviceName = itemView.findViewById(R.id.deviceName);
            building = itemView.findViewById(R.id.building);
            floor = itemView.findViewById(R.id.floor);
            deviceLocation = itemView.findViewById(R.id.deviceLocation);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.time);

        }
    }


}
