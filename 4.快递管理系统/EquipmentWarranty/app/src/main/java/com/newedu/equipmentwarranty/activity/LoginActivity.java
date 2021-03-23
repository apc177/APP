package com.newedu.equipmentwarranty.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bumptech.glide.Glide;
import com.newedu.equipmentwarranty.Config;
import com.newedu.equipmentwarranty.R;
import com.newedu.equipmentwarranty.entity.JsonData;
import com.newedu.equipmentwarranty.utils.HttpUtils;
import com.newedu.equipmentwarranty.entity.UserInfo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameEdit, userPwdEdit,tryCodeEdit;
    private ImageView tryCodeImg;
    // 切换验证码按钮
    private Button tryCodeBtn;
    private CheckBox remberMeCheckBox;
    // 登陆按钮
    private Button loginBtn;
    private String url = Config.BASE_URL + "/kaptcha/kaptcha.jpg?d=";
    private OkHttpClient mOkHttpClient =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 页面初始化
        initView();
    }

    private void initView() {
        // 根据id获取布局文件中的控件
        userNameEdit = findViewById(R.id.textUserName);
        userPwdEdit = findViewById(R.id.textPassword);
        tryCodeEdit = findViewById(R.id.textTryCode);
        tryCodeImg = findViewById(R.id.tryCodeImg);
        tryCodeBtn = findViewById(R.id.tryCodeBtn);

        long time = System.currentTimeMillis();
        String newURL = url+time;
        // 使用Glide 来加载网络图片（即我们的验证码图片）
//        Glide.with(this).load(newURL).into(tryCodeImg);
        // 验证码切换按钮的click事件响应函数
        tryCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTryCodeImg();
            }
        });
//        remberMeCheckBox = findViewById(R.id.remberMe);
        loginBtn = findViewById(R.id.btn_login);

        loadTryCodeImg();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 获取输入的用户名，密码，验证码*/
                String usercode = tryCodeEdit.getText().toString().trim();
                String username = userNameEdit.getText().toString().trim();
                String userpwd = userPwdEdit.getText().toString().trim();
                login(username,userpwd,usercode);
            }
        });

    }

    private void loadTryCodeImg(){
        System.out.println(url);
        String defaultKaptchaURL  = url+System.currentTimeMillis();
        final Request request = new Request.Builder()
                .url(defaultKaptchaURL)
                .get()
                .addHeader("mobile", "mobile")
                .build();
        mOkHttpClient = HttpUtils.getClient();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final byte[] img = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                        //通过imageview，设置图片
                        tryCodeImg.setImageBitmap(bitmap);

                    }
                });
            }

        });
    }

    private void login(String username, String userpwd,String usercode ) {
        RequestBody formBody = new FormBody.Builder()
                .add("name", username)
                .add("password", userpwd)
                .add("code", usercode)
                .build();
        Config.name=username;
        final Request request = new Request.Builder()
                .url(Config.BASE_URL+"/loginjudge" )
                .post(formBody)
                .addHeader("mobile", "mobile")
                .build();
        mOkHttpClient = HttpUtils.getClient();
        Call call = mOkHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String str = response.body().string();
                System.out.println(str);
                Log.d("from server data:",str);
                final   JSONObject jsonObject =  JSONObject.parseObject(str);
                System.out.println(str);
                // 失败
                if(jsonObject.getInteger("code") == -1){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"验证码不彳亍", Toast.LENGTH_SHORT).show();
                        }

                    });
                    loadTryCodeImg();
                }
                else if(jsonObject.getInteger("code") == 0){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "账号密码空的！不彳亍", Toast.LENGTH_SHORT).show();
                        }
                    });
                    loadTryCodeImg();
                } else if(jsonObject.getInteger("code") == -2){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "账号密码不彳亍", Toast.LENGTH_SHORT).show();
                        }
                    });
                    loadTryCodeImg();
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "彳亍", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        });
    }
}
