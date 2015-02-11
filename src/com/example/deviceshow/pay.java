package com.example.deviceshow;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.newland.nativepackage.PrintContent;
import com.newland.nativepackage.PrintBlock;
import com.newland.nativepackage.PrintSet;
import com.newland.nativepackage.Printer;










import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
 
public class pay extends Activity {
     
    private static final String[] m={"10Ԫ","20Ԫ","30Ԫ","50Ԫ","100Ԫ","����"};
	private static  String DeviceId ;
	private static  int printerType =4;
	private static  String password ="1234";
    private TextView view ;
    private Spinner spinner;
    private Button bt_pay_success;
    private String contentGlb,str,str1,str2;
    private int   paramInt;
    private ArrayAdapter<String> adapter;
	private byte[] version;
    private  TelephonyManager deviceId; 
    private EditText et_num;
 
    private PrintHandler mhandler = new PrintHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);
         
        view = (TextView) findViewById(R.id.spinnerText);
        spinner = (Spinner) findViewById(R.id.Spinner01);
        bt_pay_success=(Button)findViewById(R.id.pay_success);
        et_num=(EditText)findViewById(R.id.num);
        
        //����ѡ������ArrayAdapter��������
        adapter = new ArrayAdapter<String>(this,R.layout.myspinner,m);        
        //���������б�ķ��
        adapter.setDropDownViewResource(R.layout.myspinner);       
        //��adapter ��ӵ�spinner��
        spinner.setAdapter(adapter);        
        //����¼�Spinner�¼�����  
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());        
        //����Ĭ��ֵ
        spinner.setVisibility(View.VISIBLE);    
        bt_pay_success.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
             {
//            	Intent intent = new Intent(); 
//            	intent.setClassName("com.newland.activity", "com.newland.activity.MenuActivity");
//            	startActivity(intent); 
//            	getPrintContent(null);           	
            	printTest();           	
             }    
       });  
 
        SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy��MM��dd��   HH:mm:ss     ");     
        Date   curDate   =   new   Date(System.currentTimeMillis());//��ȡ��ǰʱ��     
        str   =   formatter.format(curDate);     
        
    }       
	//ʹ��������ʽ����
    class SpinnerSelectedListener implements OnItemSelectedListener{
 
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            view.setText("��ֵ��"+m[arg2]);
        }
 
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    
    private int getIntValue(Element paramElement, String paramString, int paramInt)
    {
      if ("".equals(paramElement.getAttribute(paramString)));
      while (true)
      {
        //return paramInt;
        paramInt = Integer.parseInt(paramElement.getAttribute(paramString));
      }
    }
     
    private void printTest()
    {
      if (!loadLibs());  
      str1=et_num.getText().toString(); 
      str2= view.getText().toString();
       // return;
//        try
//        { 
//          if (Printer.openPrinter(this.printerType, this.deviceId, this.password) == 0)
//            break label75;
//          this.mHandler.sendEmptyMessage(2);
//        }
//        catch (Exception localException)
//        {
//          this.mHandler.obtainMessage(4, localException.getMessage()).sendToTarget();
//        }
//        continue;
//        if (Printer.initialPrinter() != 0)
//        {
//          label57: Printer.closePrinter();
//          this.mHandler.sendEmptyMessage(1);
    	  DeviceId  ="/dev/ttyS2";
    	Printer.openPrinter( printerType, DeviceId,password);
    	//Printer.getPrinterVersion(this.version);
       // Printer.print("��ȡ����汾��Ϣ�ǣ�" + new String(this.version) + "\r\n");
    	Printer.print("���첩ʿ�ٿƼ����޹�˾");
    	  Printer.print("\r\n\r\n\r\n");
       Printer.initialPrinter();	
//        Printer.setZoonIn(1, 2);
//        Printer.print("�������������ű���1:2\r\n");
//        Printer.setZoonIn(2,1) ;
//        Printer.print("�������������ű���2:1\r\n");
//        Printer.setZoonIn(1, 1);
//        Printer.print("�ֻ�����");
//        Printer.initialPrinter();
//        Printer.setAlignType(0);
//        Printer.print(str1+"\r\n");
//        Printer.setAlignType(1);
//        Printer.print("�ͻ�����");
//        Printer.setAlignType(2);
//        Printer.print("����");
       Printer.initialPrinter();
       Printer.setLeftMargin(24);
       Printer.print("Ӫҵ�㣺\r\n");
       Printer.initialPrinter();
       Printer.print("\r\n\r\n");
       Printer.setLeftMargin(24);
       Printer.print("�����ţ�0275634\r\n");
       Printer.print("\r\n\r\n");
        Printer.initialPrinter();
        Printer.setLeftMargin(24);
        Printer.print("�ֻ����룺"+str1+"\r\n");
        Printer.print("\r\n\r\n");
        Printer.initialPrinter();
        Printer.setLeftMargin(24);
        Printer.print(str2+"\r\n");
        Printer.print("\r\n\r\n");
        Printer.initialPrinter();
        Printer.setLeftMargin(24);
        Printer.print(str+"\r\n");
//        Printer.initialPrinter();
//        Printer.setAlignType(2);
//        Printer.setRightMargin(24);
//        Printer.print(str2 +"\r\n");
//        Printer.initialPrinter();
//        Printer.setLineSpacingByDotPitch(15);
//        Printer.print("�����м�ࣺ15�����\r\n");
//        Printer.initialPrinter();
//        Printer.setWordSpacingByDotPitch(5);
//        Printer.print("�����ַ����:5�����\r\n");
//        Printer.initialPrinter();
//        Printer.setPrintOrientation(0);
//        Printer.print("���ô�ӡ����:����\r\n");
//         Printer.initialPrinter();
//         Printer.setBold(0);
//         Printer.print(str);
//        Printer.setBold(1);
//        Printer.print("����/ȡ�������ӡ:����\r\n");
//        Printer.initialPrinter();
//        Printer.setUnderLine(0);
//        Printer.print("����/ȡ���»��ߴ�ӡ:ȡ��\r\n");
//        Printer.setUnderLine(1);
//        Printer.print("����/ȡ���»��ߴ�ӡ:����\r\n");
//        Printer.initialPrinter();
//        Printer.setInverse(0);
//        Printer.print("����/ȡ�����״�ӡ:ȡ��\r\n");
//        Printer.setInverse(1);
//        Printer.print("����/ȡ�����״�ӡ:����\r\n");        
        Printer.print("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
        Printer.closePrinter();
        //this.mhandler.sendEmptyMessage(29);
       this.mhandler.obtainMessage(29).sendToTarget();      
    }    
 

   public boolean loadLibs()
    {
    	System.loadLibrary("CMCC_PRINT_BOSSTUN_UA100");   
    	return true;
    }         

}
