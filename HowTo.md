# Below content describes the usage of library #

## Please note library is based on Android Support Library hence you need to extend your activity from FragmentActivity ##

---

Barcode Fragment Library is an extension to the existing ZXing library. Which Provides the barcode scanner as a Fragment, which can be placed on any Activity

### Download the Library which comes along with sample layout and activity demonstrating the usage of barcode fragment library. ###

Since, Library is extension of **ZXing**, hence, in order to use the **barcodefragmentlibv2** you need to add core.jar in your build path.

The library requires a call back to be registered as `IScanResultHandler`.

Once registered with Fragment as `setScanResultHandler`the result will be forwarded to the registered class.

**EXAMPLE**
```
fragment = (BarcodeFragment) getSupportFragmentManager()
				.findFragmentById(R.id.barCode);
fragment.setScanResultHandler(this);
```


**Starting and Stopping Camera for QR Capture**

The library is designed to start scanning as soon as its loaded and will stop scanning as soon as it is removed.
hence to start and stop simply load and remove fragment from screen.

Once the capture is complete the library automatically calls `scanResult` hence you can restart QR code detection by simply calling `restart`.

You don't have to call the start and stop camera actions in your activity for activity state changes as the library takes care of state change by itself.