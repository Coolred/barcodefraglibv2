package com.abhi.barcode.frag.libv2.sample.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.abhi.barcode.frag.libv2.BarcodeFragment;
import com.abhi.barcode.frag.libv2.IScanResultHandler;
import com.abhi.barcode.frag.libv2.R;
import com.abhi.barcode.frag.libv2.ScanResult;

public class BarcodeFragmentExampleActivity extends FragmentActivity implements IScanResultHandler {
	BarcodeFragment brf;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_barcode_fragment_example);
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        brf = new BarcodeFragment();
        trx.add(R.id.testFragmentHolder, brf, "HOLDER");
        trx.commit();
//        brf = (BarcodeFragment) getSupportFragmentManager().findFragmentById(R.id.barcodeFragment);
        brf.setDecodeFor(MODE.ONE_D_MODE);
        brf.setScanResultHandler(this);
    }

	@Override
	public void scanResult(ScanResult result) {
		Toast.makeText(this, result.getRawResult().getText(), Toast.LENGTH_LONG).show();
		try{
		brf.restart();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
