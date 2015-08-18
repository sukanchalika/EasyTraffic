package pbru.infotech.sukanchalika.easytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร เพื่อบอกว่าจะทำการ run app เพื่อเตรียม RAM ในการใช้งาน
    private ListView trafficListView;   // การตั้งตัวแปรสำหรับใช้ใน class ใช้ shift+ctl+enter คือ ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Main method หลักของการทำงานจะเริ่มเมื่อมีการเรียกใช้งาน
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget ผูกตัวแปรที่ประกาศไว้กับ .xml
        initialWidget(); //เรียกใช้ method

        //Create ListView
        createListView(); //จะเป็นตัวแดง เอาเมาส์ไปนี้แล้วกด alt+enter เพื่อสร้าง method

    }

    private void createListView() { //กำหนดค่าให้กับ array
        String[] strTitle = new String[20];
        strTitle[0] = "ห้ามเลี้ยวซ้าย";
        strTitle[1] = "ห้ามเลี้ยวขวา";
        strTitle[2] = "ตรงไป";
        strTitle[3] = "เลี้ยวขวา";
        strTitle[4] = "เลี้ยวซ้าย";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้า IN";
        strTitle[7] = "ออก OUT";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดความสูง";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "ห้ามจอด";
        strTitle[13] = "ระวังรถสวนทาง";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุดตรวจ";
        strTitle[17] = "จำกัดความเร็ว";
        strTitle[18] = "จำกัดความกว้าง";
        strTitle[19] = "จำกัดความสูง";


    }//createListView

    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView); //เลือก R ตาม app ที่เราตั้งไว้
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} // Main Class นี่คือ คลาสหลัก
