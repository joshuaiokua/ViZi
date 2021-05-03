package com.example.vizi;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import android.content.Context;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.core.cartesian.series.Column;

import org.json.JSONException;
import org.json.JSONObject;

public class SharedHelper {

    public static String loadJSONFromAsset(Context context, String jsonNAME) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(jsonNAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static JSONObject getJSON(Context context, String jsonNAME) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject((loadJSONFromAsset(context, jsonNAME)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static List<DataEntry> getData(Context context, JSONObject json) {
        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomDataEntry("VN.QN","Quang Ninh",json.optDouble("Quang Ninh", 0.0)));
        data.add(new CustomDataEntry("VN.TN","Tay Ninh",json.optDouble("Tay Ninh", 0.0)));
        data.add(new CustomDataEntry("VN.DB","Dien Bien",json.optDouble("Dien Bien", 0.0)));
        data.add(new CustomDataEntry("VN.307","Dong Bac",json.optDouble("Dong Bac", 0.0)));
        data.add(new CustomDataEntry("VN.TY","Thai Nguyen",json.optDouble("Thai Nguyen", 0.0)));
        data.add(new CustomDataEntry("VN.LI","Lai Chau",json.optDouble("Lai Chau", 0.0)));
        data.add(new CustomDataEntry("VN.LS","Lang Son",json.optDouble("Lang Son", 0.0)));
        data.add(new CustomDataEntry("VN.311","Son La",json.optDouble("Son La", 0.0)));
        data.add(new CustomDataEntry("VN.TH","Thanh Hoa",json.optDouble("Thanh Hoa", 0.0)));
        data.add(new CustomDataEntry("VN.TQ","Tuyen Quang",json.optDouble("Tuyen Quang", 0.0)));
        data.add(new CustomDataEntry("VN.YB","Yen Bai",json.optDouble("Yen Bai", 0.0)));
        data.add(new CustomDataEntry("VN.HO","Hoa Binh",json.optDouble("Hoa Binh", 0.0)));
        data.add(new CustomDataEntry("VN.HD","Hai Duong",json.optDouble("Hai Duong", 0.0)));
        data.add(new CustomDataEntry("VN.3623","Hai Phong",json.optDouble("Hai Phong", 0.0)));
        data.add(new CustomDataEntry("VN.317","Dong Bang Song Hong",json.optDouble("Dong Bang Song Hong", 0.0)));
        data.add(new CustomDataEntry("VN.318","Ha Noi",json.optDouble("Ha Noi", 0.0)));
        data.add(new CustomDataEntry("VN.BN","Bac Ninh",json.optDouble("Bac Ninh", 0.0)));
        data.add(new CustomDataEntry("VN.VC","Vinh Phuc",json.optDouble("Vinh Phuc", 0.0)));
        data.add(new CustomDataEntry("VN.NB","Ninh Binh",json.optDouble("Ninh Binh", 0.0)));
        data.add(new CustomDataEntry("VN.HM","Ha Nam",json.optDouble("Ha Nam", 0.0)));
        data.add(new CustomDataEntry("VN.ND","Nam Dinh",json.optDouble("Nam Dinh", 0.0)));
        data.add(new CustomDataEntry("VN.PT","Phu Tho",json.optDouble("Phu Tho", 0.0)));
        data.add(new CustomDataEntry("VN.BG","Bac Giang",json.optDouble("Bac Giang", 0.0)));
        data.add(new CustomDataEntry("VN.TB","Thai Binh",json.optDouble("Thai Binh", 0.0)));
        data.add(new CustomDataEntry("VN.328","Ha Tinh",json.optDouble("Ha Tinh", 0.0)));
        data.add(new CustomDataEntry("VN.NA","Nghe An",json.optDouble("Nghe An", 0.0)));
        data.add(new CustomDataEntry("VN.QB","Quang Binh",json.optDouble("Quang Binh", 0.0)));
        data.add(new CustomDataEntry("VN.723","Dak Lak",json.optDouble("Dak Lak", 0.0)));
        data.add(new CustomDataEntry("VN.724","Gia Lai",json.optDouble("Gia Lai", 0.0)));
        data.add(new CustomDataEntry("VN.KH","Khanh Hoa",json.optDouble("Khanh Hoa", 0.0)));
        data.add(new CustomDataEntry("VN.LD","Lam Dong",json.optDouble("Lam Dong", 0.0)));
        data.add(new CustomDataEntry("VN.NT","Ninh Thuan",json.optDouble("Ninh Thuan", 0.0)));
        data.add(new CustomDataEntry("VN.PY","Phu Yen",json.optDouble("Phu Yen", 0.0)));
        data.add(new CustomDataEntry("VN.BI","Binh Duong",json.optDouble("Binh Duong", 0.0)));
        data.add(new CustomDataEntry("VN.TG","Tien Giang",json.optDouble("Tien Giang", 0.0)));
        data.add(new CustomDataEntry("VN.6365","Dak Nong",json.optDouble("Dak Nong", 0.0)));
        data.add(new CustomDataEntry("VN.BP","Binh Phuoc",json.optDouble("Binh Phuoc", 0.0)));
        data.add(new CustomDataEntry("VN.BD","Binh Dinh",json.optDouble("Binh Dinh", 0.0)));
        data.add(new CustomDataEntry("VN.299","Kon Tum",json.optDouble("Kon Tum", 0.0)));
        data.add(new CustomDataEntry("VN.300","Quang Nam",json.optDouble("Quang Nam", 0.0)));
        data.add(new CustomDataEntry("VN.QG","Quang Ngai",json.optDouble("Quang Ngai", 0.0)));
        data.add(new CustomDataEntry("VN.QT","Quang Tri",json.optDouble("Quang Tri", 0.0)));
        data.add(new CustomDataEntry("VN.TT","Thua Thien - Hue",json.optDouble("Thua Thien - Hue", 0.0)));
        data.add(new CustomDataEntry("VN.DA","Da Nang",json.optDouble("Da Nang", 0.0)));
        data.add(new CustomDataEntry("VN.BV","Ba Ria - Vung Tau",json.optDouble("Ba Ria - Vung Tau", 0.0)));
        data.add(new CustomDataEntry("VN.BU","Binh Thuan",json.optDouble("Binh Thuan", 0.0)));
        data.add(new CustomDataEntry("VN.331","Dong Nam Bo",json.optDouble("Dong Nam Bo", 0.0)));
        data.add(new CustomDataEntry("VN.AG","An Giang",json.optDouble("An Giang", 0.0)));
        data.add(new CustomDataEntry("VN.333","Can Tho",json.optDouble("Can Tho", 0.0)));
        data.add(new CustomDataEntry("VN.DT","Dong Thap",json.optDouble("Dong Thap", 0.0)));
        data.add(new CustomDataEntry("VN.HC","Ho Chi Minh City",json.optDouble("Ho Chi Minh City", 0.0)));
        data.add(new CustomDataEntry("VN.KG","Kien Giang",json.optDouble("Kien Giang", 0.0)));
        data.add(new CustomDataEntry("VN.LA","Long An",json.optDouble("Long An", 0.0)));
        data.add(new CustomDataEntry("VN.BR","Ben Tre",json.optDouble("Ben Tre", 0.0)));
        data.add(new CustomDataEntry("VN.337","Hau Giang",json.optDouble("Hau Giang", 0.0)));
        data.add(new CustomDataEntry("VN.BL","Bac Lieu",json.optDouble("Bac Lieu", 0.0)));
        data.add(new CustomDataEntry("VN.CM","Ca Mau",json.optDouble("Ca Mau", 0.0)));
        data.add(new CustomDataEntry("VN.ST","Soc Trang",json.optDouble("Soc Trang", 0.0)));
        data.add(new CustomDataEntry("VN.TV","Tra Vinh",json.optDouble("Tra Vinh", 0.0)));
        data.add(new CustomDataEntry("VN.VL","Vinh Long",json.optDouble("Vinh Long", 0.0)));
        data.add(new CustomDataEntry("VN.CB","Cao Bang",json.optDouble("Cao Bang", 0.0)));
        data.add(new CustomDataEntry("VN.HG","Ha Giang",json.optDouble("Ha Giang", 0.0)));
        data.add(new CustomDataEntry("VN.LO","Lao Cai",json.optDouble("Lao Cai", 0.0)));

        return data;
    };

    static class CustomDataEntry extends DataEntry {
        public CustomDataEntry(String id, String name, Number value) {
            setValue("id", id);
            setValue("name", name);
            setValue("value", value);
        }
        public CustomDataEntry(String id, String name, Number value, LabelDataEntry label) {
            setValue("id", id);
            setValue("name", name);
            setValue("value", value);
            setValue("label", label);
        }

        public CustomDataEntry(String province, Object o1, Object o) {
        }
    }

    class LabelDataEntry extends DataEntry {
        LabelDataEntry(Boolean enabled) {
            setValue("enabled", enabled);
        }
    }

}
