package com.example.friendchatting.conversor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class DataConver {

    /*
    public static byte[] convertImage2Array(Bitmap bitmap){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, out);

        return out.toByteArray();
    }

    public static Bitmap converByte2Bitmap(byte[] byteArr){
        return BitmapFactory.decodeByteArray(byteArr, 0, byteArr.length);
    }

     */

    @TypeConverter
    public static String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos = new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        if(temp==null)
        {
            return null;
        }
        else
            return temp;
    }


    @TypeConverter
    public static Bitmap StringToBitMap(String encodedString){
        try {
            byte[] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            if(bitmap==null)
            {
                return null;
            }
            else
            {
                return bitmap;
            }

        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }


}
