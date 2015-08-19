package pbru.infotech.sukanchalika.easytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;
    private String[] questionStrings;
    private int[] imageInts;
    private int radioAnInt, indexAnInt; //ค่าเริ่มต้นตัวเลยเป็น 0 อัตโนมัติ, string เป็น NULL


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Bind Widget เป็นการ bind ตัวแปรกับ widget
        bindWidget(); //จะเกิดตัวแดง กด Alt+enter

        // การสร้าง Radio Controller ตัวควบคุมในส่วนการทำงานของ Radio group
        radioController();

    } //onCreate

    public void clickAnswer(View view) {
        //เมื่อมีการคลิกที่ปุ่ม Answer ให้มาเช็คคำตอบที่นี่
        if (radioAnInt == 0) { //การแจ้งเตือนเมื่อไม่เลือกคำตอบใดๆ
            Toast.makeText(TestActivity.this, "กรุณาคลิกเลือกคำตอบด้วยค่ะ", Toast.LENGTH_SHORT).show();
        } else {
            myModel(); //เช็คว่าทำครบ 10 ข้อรึยัง
        }

    } //clickAnswer

    private void myModel() {
        if (indexAnInt == 9) {
            showAnswerDialog(); //สร้าง popup แจ้งผลคะแนนเมื่อทำครบ 10 ข้อ

        } else {
            indexAnInt += 1;

            //change view
            changeView(indexAnInt);
        }
    } //myModel

    private void changeView(int anInt) {
        //Change Question
        questionTextView.setText(questionStrings[anInt]);
    } //changeView

    private void showAnswerDialog() {

    }


    private void radioController() {
        //onCheck สามารถเปลี่ยนการเลือกบนหน้าจอได้
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }
            }
        });


    }

    //การตั้ง method โดยใช้ override โดยให้ไปเรียกการทำงานเริ่มต้นที่ onStart เริ่มแรก
    @Override
    protected void onStart() {

        //Setup โดยการตึงตัวแปรจากตัวคำถาม 10 ตัวมาไว้ที่นี่
        questionStrings = getResources().getStringArray(R.array.question);
        //ดึงรูปภาพมาวาง
        imageInts = new int[10];
        imageInts[0] = R.drawable.traffic_01;
        imageInts[1] = R.drawable.traffic_02;
        imageInts[2] = R.drawable.traffic_03;
        imageInts[3] = R.drawable.traffic_04;
        imageInts[4] = R.drawable.traffic_05;
        imageInts[5] = R.drawable.traffic_06;
        imageInts[6] = R.drawable.traffic_07;
        imageInts[7] = R.drawable.traffic_08;
        imageInts[8] = R.drawable.traffic_09;
        imageInts[9] = R.drawable.traffic_10;

        String[] strChoice = getResources().getStringArray(R.array.times1);

        //Just Start
        questionTextView.setText(questionStrings[0]);
        trafficImageView.setImageResource(imageInts[0]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

        super.onStart();
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficTest);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
} //Main Class
