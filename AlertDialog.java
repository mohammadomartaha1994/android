
................... java

                LayoutInflater layoutInflater = LayoutInflater.from(ClassName.this);
                final View promptView = layoutInflater.inflate(R.layout.DialogName, null);
                final AlertDialog alertD = new AlertDialog.Builder(ClassName.this).create();
                
                TextView text = (TextView)promptView.findViewById(R.id.Text);
                
                alertD.setView(promptView);
                alertD.show();   
                
                
 .................... xml on layout
 
 
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:padding="20dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="10dp"
            android:textAppearance="?android:attr/textAppearanceMedium"
            android:text=""
            android:textColor="#f27515"
            android:id="@+id/text" />

    </LinearLayout>

</LinearLayout>
