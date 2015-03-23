Below code is a working version of Application based on barcodefraglibv2

## SampleMainActivity.java ##
```
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abhi.barcode.frag.libv2.BarcodeFragment;
import com.abhi.barcode.frag.libv2.IScanResultHandler;
import com.abhi.barcode.frag.libv2.ScanResult;

public class SampleMainActivity extends FragmentActivity implements IScanResultHandler {
	
	BarcodeFragment fragment;
	Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_main);
        fragment = (BarcodeFragment)getSupportFragmentManager().findFragmentById(R.id.sample);
        fragment.setScanResultHandler(this);
        btn = ((Button)findViewById(R.id.scan));
        btn.setEnabled(false);

        // Support for adding decoding type 
        fragment.setDecodeFor(EnumSet.of(BarcodeFormat.QR_CODE));
    }

	@Override
	public void scanResult(ScanResult result) {
		btn.setEnabled(true);
		Toast.makeText(this, result.getRawResult().getText(), Toast.LENGTH_LONG).show();
	}
	
	public void scanAgain(View v){
		fragment.restart();
	}

}
```

## res/layout/activity\_sample\_main.xml ##
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".SampleMainActivity" >

    <fragment
        android:id="@+id/sample"
        android:name="com.abhi.barcode.frag.libv2.BarcodeFragment"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/scan"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true" />

    <Button
        android:id="@+id/scan"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:onClick="scanAgain"
        android:text="Re-Scan" />

</RelativeLayout>
```

please download both jar files from

Barcode Fragment library https://drive.google.com/file/d/0B6Yq_H82UOUfZVp2VVZrQVhMQjQ/edit?usp=sharing

Core Library (dependency)
https://drive.google.com/file/d/0B6Yq_H82UOUfaGRmUzlGTWwxSlU/edit?usp=sharing