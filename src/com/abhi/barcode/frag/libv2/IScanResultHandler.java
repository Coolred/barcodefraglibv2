package com.abhi.barcode.frag.libv2;


public interface IScanResultHandler {
	void scanResult(ScanResult result);

	public enum MODE {
		PRODUCT_MODE, QR_CODE_MODE, DATA_MATRIX_MODE, ONE_D_MODE;
	}
}
