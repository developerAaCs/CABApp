package aacs.com.np.cabapp;

import android.app.DownloadManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Dell on 6/12/2017.
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {


    //Register the device
    @Override
    public void onTokenRefresh() {

        String recent_token =FirebaseInstanceId.getInstance().getToken();
        Log.d("REGISTRATION_TOKEN",recent_token);
        registerToken(recent_token);
    }

    //Store the obtained token to the database
   private void registerToken(String token){
        OkHttpClient client= new OkHttpClient();
        RequestBody body= new FormBody.Builder()
                              .add("Token",token)
                               .build();
        //Send the token to the database in the url to store it
        Request request = new Request.Builder()
                              .url("http://192.168.100.10/CABAppServer/register.php")
                              .post(body)
                              .build();
       if(body == null) {
           Log.d("REGISTRATION_STATUS", "Registration Token not sent");
       }try{
            client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }



    }


}
