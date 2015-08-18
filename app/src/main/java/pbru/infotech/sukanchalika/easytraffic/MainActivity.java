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

    }

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
