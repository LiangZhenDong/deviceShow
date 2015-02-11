package com.example.deviceshow;

import java.io.InputStream;
import java.util.List;

import com.bosstun.adapter.ViewHolder;



import com.bosstun.localdata.Book;
import com.bosstun.localdata.BookParser;
import com.bosstun.localdata.PullBookParser;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
public class sim extends Activity {
     
    private static final String[] str_num={"13996991234","13808301234","13709491234"};
    private static final String[] str_tc={"���еش�(�ײͷ�12Ԫ������50�����ţ�10M�������������أ�����0.1Ԫ/���ӣ�������ѣ�����أ�����0.4Ԫ/���ӣ�����0.2Ԫ/���ӣ�)","ȫ��ͨ(�ײͷ�58Ԫ������50�����ţ�100Mȫ�����������أ�����0.1Ԫ/���ӣ�������ѣ�����أ�����0.4Ԫ/���ӣ�������ѣ�)","4G(�ײͷ�20Ԫ������100�����ţ�500M�������������أ�����0.2Ԫ/���ӣ�������ѣ�����أ�����0.6Ԫ/���ӣ�����0.4Ԫ/���ӣ�)"};
    private TextView view02,view03 ;
	private final String TAG = "sim";
    private Spinner spinner02,spinner03;
    private Button bt_sim_success,bt_sm,bt_pz;
    private ArrayAdapter<String> adapter02,adapter03;
    private Camera camera = null;
	private Boolean bCameropen = false;
	private Parameters cameraParameter;
	private static final String LOG_TAG = "XML";
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sim);
      
        view02 = (TextView) findViewById(R.id.spinnerText02);
        spinner02 = (Spinner) findViewById(R.id.Spinner02);
        bt_sim_success=(Button)findViewById(R.id.sim_success);
        bt_sm=(Button)findViewById(R.id.bt_sm);
        bt_pz=(Button)findViewById(R.id.bt_pz);

        view03 = (TextView) findViewById(R.id.spinnerText03);
        spinner03 = (Spinner) findViewById(R.id.Spinner03);
        //����ѡ������ArrayAdapter�������� 
        adapter02 = new ArrayAdapter<String>(this,R.layout.myspinner,str_num);
        adapter03 = new ArrayAdapter<String>(this,R.layout.myspinner,str_tc);
        //���������б�ķ��
        adapter02.setDropDownViewResource(R.layout.myspinner);
        adapter03.setDropDownViewResource(R.layout.myspinner);
        //��adapter ��ӵ�spinner��
        spinner02.setAdapter(adapter02);
        spinner03.setAdapter(adapter03);
        //����¼�Spinner�¼�����  
        spinner02.setOnItemSelectedListener(new SpinnerSelectedListener());
        spinner03.setOnItemSelectedListener(new SpinnerSelectedListener());
        //����Ĭ��ֵ
        spinner02.setVisibility(View.VISIBLE);
        spinner03.setVisibility(View.VISIBLE);
        
        bt_sim_success.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
             {
            	
            	//��ȡLayoutInflater���󣬸ö����ܰ�XML�ļ�ת��Ϊ��֮һֱ��View����  
                LayoutInflater inflater = getLayoutInflater();  
                //����ָ���Ĳ����ļ�����һ�����в㼶��ϵ��View����  
                //�ڶ�������ΪView����ĸ��ڵ㣬��LinearLayout��ID  
                View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast));                   
                //����ImageView�ؼ�  
                //ע������layout�в���  
                TextView text = (TextView) layout.findViewById(R.id.tx_toast);  
                text.setText("�����ɹ�");  
  
                Toast toast = new Toast(getApplicationContext());  
                //����Toast��λ��  
                //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);  
                toast.setDuration(Toast.LENGTH_LONG);  
                //��Toast��ʾΪ�����Զ��������  
                toast.setView(layout);  
                toast.show();
//            	
//            	Toast.makeText(getApplicationContext(), "�����ɹ�"
//            		,Toast.LENGTH_SHORT).show();  
           	    	
            }
            
        });
        bt_sm.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
             {
		        Intent localIntent4 = new Intent(sim.this, IDCardInfoReaderActivity.class);
		        localIntent4.putExtra("isReadAll", true);
		        localIntent4.putExtra("isWeb", false);
		        localIntent4.putExtra("getImg", "1");
		       sim.this.startActivity(localIntent4);
            	
//            	Intent intent = new Intent(); 
//            	intent.setClassName("com.newland.activity", "com.newland.activity.MenuActivity");
//            	startActivity(intent); 	   
		       
		       
            }
            
        });   
        bt_pz.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
             {
//        		View paramView = null ;
//				ViewHolder localViewHolder = (ViewHolder) paramView.getTag();
//				if (!bCameropen) {
//					localViewHolder.setText(ConfigConstant.STR_CLOSE_FLASH);
//					localViewHolder.setImageResource(R.drawable.light_off);
//					initCamera();
//					Log.v(TAG, "supported Flash Modes:"+cameraParameter.getSupportedFlashModes());
//					cameraParameter.setFlashMode(Parameters.FLASH_MODE_ON);
//					cameraParameter.set("flash-mode", "on");
//					camera.setParameters(cameraParameter);
//					camera.startPreview();
//					camera.takePicture(null, null, null);
//					bCameropen = true;
//				} else {
//					camera.takePicture(null, null, null);
//					localViewHolder.setText(ConfigConstant.STR_OPEN_FLASH);
//					localViewHolder.setImageResource(R.drawable.light_on);
//					cameraParameter = camera.getParameters();
//					cameraParameter.setFlashMode(Parameters.FLASH_MODE_OFF);
//					camera.setParameters(cameraParameter);
//					camera.stopPreview();
//					camera.release();
//					bCameropen = false;
//				}

			
            	Intent intent = new Intent(); 
            	intent.setClassName("com.newland.activity", "com.newland.activity.MenuActivity");
            	startActivity(intent); 	    	
//            }
//                Intent localIntent3 = new Intent(sim.this, IdentifyCardReader.class);
//                Intent localIntent4 = new Intent(sim.this, IdentifyCardReader.class);
//		        localIntent3.putExtra("isReadAll", true);
//		        localIntent4.putExtra("isWeb", false);
//		        localIntent4.putExtra("getImg", "1");
//		       sim.this.startActivity(localIntent3);        	    	
            	
       } 
        });
        
        
        
   
    }  
    public void initCamera() {
		this.camera = Camera.open();
		this.cameraParameter = camera.getParameters();
	} 
    //ʹ��������ʽ����
    class SpinnerSelectedListener implements OnItemSelectedListener{
 
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            view02.setText("ѡ����룺"+str_num[arg2]);
            view03.setText("ѡ���ײͣ�"+str_tc[arg2]);
        }
 
        public void onNothingSelected(AdapterView<?> arg0) {
        } 
      
    }   

	protected void onDestroy() {
		super.onDestroy();
		Log.v("menu", "onDestroy");
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
			finish();
		return true;
	}

	protected void onPause() {
		super.onPause();
		Log.v("menu", "onPause");
		if (bCameropen) {
			camera.release();
			bCameropen = false;
		}
	}

	public void onResume() {
		super.onResume();
		Log.v("menu", "onResume");
		// setRequestedOrientation(0);
	}

	public void setFullscreen() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(1024, 1024);
	}

	public void setNoTitle() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	public void getBook() {
		try {
			InputStream is = getAssets().open("books.xml");
			BookParser parser = new PullBookParser();
			List<Book> books = parser.parse(is);
			for (Book book : books) {
				Log.i(LOG_TAG, book.toString());
			}
		} catch (Exception e) {
			Log.e(LOG_TAG, e.getMessage());
		}
	}
    
} 
