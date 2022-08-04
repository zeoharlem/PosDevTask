package com.zeoharlem.posdevtask.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.zeoharlem.posdevtask.models.Transactions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public class FileAssetsUtils {

    private final static FileAssetsUtils instance = new FileAssetsUtils();

    private FileAssetsUtils(){

    }

    public static FileAssetsUtils getInstance(){
        return instance;
    }

    public String getReadJsonFromAssets(String filename, Context context) throws IOException {
        String jsonStringFile   = "";
        try (InputStream inputStream = context.getAssets().open(filename)) {
            int getFileSize = inputStream.available();
            byte[] byteBuffer = new byte[getFileSize];
            inputStream.read(byteBuffer);
            jsonStringFile  = new String(byteBuffer, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStringFile;
    }

    public String setReadableDate(String stringDate){
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat simpleDateFormat   = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat convertDateFormat  = new SimpleDateFormat("d, MMM yyyy hh:mm:ss aaa", Locale.getDefault());
            return convertDateFormat.format(Objects.requireNonNull(simpleDateFormat.parse(stringDate)));
        }
        catch (ParseException e) {
            e.printStackTrace();
            Log.e("SetReadableDate", "setReadableDate: "+e.getLocalizedMessage());
            return stringDate;
        }
    }

    public String currencyFormatter(double amount){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("NGN"));
        return format.format(amount).replace("NGN","₦");
    }

    /**
     *
     * @param filename
     * @param type
     * @param context
     * @return
     * Set filename
     * set the transaction type using ALL, CREDIT or DEBIT
     */
    public ArrayList<Transactions> loadJsonResults(String filename, String type, Context context){
        try {
            JSONArray jsonObject   = new JSONArray(getReadJsonFromAssets(filename, context));
            ArrayList<Transactions> transactionsArrayList   = new ArrayList<>();

            for (int i = 0; i < jsonObject.length(); i++) {
                Transactions singleTranx        = new Transactions();
                JSONObject getSingleTranxObj    = jsonObject.getJSONObject(i);

                String getPreparedDate  = setReadableDate(getSingleTranxObj.getString("transactionDate"));
                singleTranx.setTransactionTypeName(getSingleTranxObj.getString("transactionTypeName"));
                singleTranx.setStatusName(getSingleTranxObj.getString("statusName"));
                singleTranx.setCredit(getSingleTranxObj.getBoolean("isCredit"));
                singleTranx.setTransactionDate(getPreparedDate);
                singleTranx.setId(getSingleTranxObj.getInt("id"));

                if(getSingleTranxObj.getBoolean("isCredit")){
                    singleTranx.setAmount(currencyFormatter(getSingleTranxObj.getDouble("credit")));
                    Log.e("CreditBoolean", transactionsArrayList.size() + ") loadJsonResults: "+getSingleTranxObj.getBoolean("isCredit"));
                    //singleTranx.setCredit(creditAmount);
                    transactionsArrayList.add(singleTranx);
                }
                else if(!getSingleTranxObj.getBoolean("isCredit")){
                    singleTranx.setAmount(currencyFormatter(getSingleTranxObj.getDouble("debit")));
                    Log.e("DebitBoolean", i + ") loadJsonResults: "+getSingleTranxObj.getBoolean("isCredit"));

                    //singleTranx.setCredit(debitAmount);
                    transactionsArrayList.add(singleTranx);
                }
                else{
                    singleTranx.setAmount(currencyFormatter(Double.parseDouble(getSingleTranxObj.getString("amount"))));
                    transactionsArrayList.add(singleTranx);
                }

            }
            ArrayList<Transactions> list = new ArrayList<>(transactionsArrayList);
            transactionsArrayList.clear();
            return list;
        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.e("LoadJson", "loadError: "+ e.getLocalizedMessage());
            return null;
        }
    }
}
