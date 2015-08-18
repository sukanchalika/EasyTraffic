package pbru.infotech.sukanchalika.easytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sukanchalika on 18/8/2558.
 */
public class MyAdapter extends BaseAdapter // กด alt+enter จะได้ mothod 4 ตัว
 //main class
{   //Explicit ประกาศตัวแปร
    private Context objContext; //สร้าง connection
    private int[] iconInts; //ประกาศตัวแปรแบบ array เป็นตำแหน่งของรูปภาพที่จะเอาไปโชว์ เหมือนสร้าง record set
    private String[] titleStrings; //ประกาศตัวแปรเป็นสตริง

    //build constructor กด Alt+insert
    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }

    @Override
    public int getCount() { //วนรอบกี่รอบ
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //get view
        LayoutInflater objLayoutInflater = (LayoutInflater)objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //open service
        View view1 = objLayoutInflater.inflate(R.layout.listview_traffic, viewGroup, false);
        //ให้ดัน obj นี้ไปทำงานที่ listview

        //show Image ให้โยงการแสดลผลไปที่ Imvicon
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imvicon);
        iconImageView.setImageResource(iconInts[i]);

        //Show Text แสดงตัวอักษร
        TextView titleTextView = (TextView) view1.findViewById(R.id.txtShowTitle);
        titleTextView.setText(titleStrings[i]);




        return view1;
    }
}
