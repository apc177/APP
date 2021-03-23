package com.newedu.equipmentwarranty.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import java.io.FileNotFoundException;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.newedu.equipmentwarranty.R;
import com.newedu.equipmentwarranty.entity.MessageEvent;
import com.theartofdev.edmodo.cropper.CropImage;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_maintenancelist, R.id.navigation_addmaintenance)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("MainActivity",requestCode+"");

        switch (requestCode) {

            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE: {

                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == this.RESULT_OK) {
                    Uri resultUri = result.getUri();
                    try {
                        bitmap = BitmapFactory.decodeStream(
                                getContentResolver().openInputStream(resultUri));
                        //buildImage.setImageBitmap(mBitmap);
                        EventBus.getDefault().post(new MessageEvent("拍照成功",bitmap,resultUri));
                        Log.i("MainActivity","----------------");
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

    public Bitmap getBitmap(){
        return this.bitmap;
    }


}
