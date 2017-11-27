.......... on AndroidManifest

            <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key" />
            
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
            
            
            
........... create MapActicity and change it .. code :

public class MyLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng Palestine;
    double latitude=0.0;
    double longitude=0.0;
    LayoutInflater layoutInflater1;
    View promptView1;
    int timeOut=1000;
    AlertDialog alertD1;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        CheckUserPermsions();
    }


    //access to permsions
    void CheckUserPermsions(){
        if ( Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED  ){
                requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

        runlisner();// init the contact list

    }
    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    runlisner();// init the contact list
                } else {
                    // Permission Denied
                    Toast.makeText( this," Error " , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }



    public void runlisner() {


        locationLisner locationListener = new locationLisner();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
         layoutInflater1 = LayoutInflater.from(MyLocation.this);
         promptView1 = layoutInflater1.inflate(R.layout.progress_location, null);
         alertD1 = new AlertDialog.Builder(MyLocation.this).create();
         alertD1.setView(promptView1);
         alertD1.show();


        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,30000,1, locationListener);
        threadLocation threadlocation= new threadLocation();
        threadlocation.start();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    class threadLocation extends Thread {
        public void run(){
            while (true){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (locationLisner.location!=null) {
                            Log.d("test"," "+timeOut);
                            if (latitude==locationLisner.location.getLatitude() &&
                                    longitude==locationLisner.location.getLongitude()){
                            }
                            else {
                                timeOut=5000;
                                mMap.clear();
                                alertD1.dismiss();
                                latitude = locationLisner.location.getLatitude();
                                longitude = locationLisner.location.getLongitude();
                                Palestine = new LatLng(locationLisner.location.getLatitude(), locationLisner.location.getLongitude());
                                mMap.addMarker(new MarkerOptions().position(Palestine).title("Your Location Now"));
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(Palestine));
                                mMap.getUiSettings().setZoomControlsEnabled(true);
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Palestine, 12));
                            }
                        }
                        else Log.d("test"," "+timeOut);

                    }
                });
                try {
                    Thread.sleep(timeOut);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

