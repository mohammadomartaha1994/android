
..... send string to another activity 

                    Intent intent = new Intent(ThisClass.this,NextClass.class);
                    intent.putExtra("Name",Name.getText().toString());  
                    startActivity(intent);
                    finish();  // can not return to this activity with back botton 
                    
                    
                    String message = intent.getStringExtra("Name");   take the string from the second activity

                    
                    
...... get string from string file 

          getResources().getString(R.string.NAME) ;


....... get the day


 Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        TextView today = (TextView)findViewById(R.id.today);
        switch (day) {
            case Calendar.SATURDAY:
                today.setText("SATURDAY");
                break;
            case Calendar.SUNDAY:
                today.setText("SUNDAY");
                break;
            case Calendar.MONDAY:
                today.setText("MONDAY");
                break;
            case Calendar.TUESDAY:
                today.setText("TUESDAY");
                break;
            case Calendar.WEDNESDAY:
                today.setText("WEDNESDAY");
                break;
            case Calendar.THURSDAY:
                today.setText("THURSDAY");
                break;
            case Calendar.FRIDAY:
                today.setText("FRIDAY");
                break;
        }
        
        
        
        
 .....................  get the time from calender and convert to integer
 
            calander = Calendar.getInstance();
            
            simpledateformat_minutes = new SimpleDateFormat("mm");
            simpledateformat_hour = new SimpleDateFormat("HH");
            
            minutes = simpledateformat_minutes.format(calander.getTime());
            hour = simpledateformat_hour.format(calander.getTime());
            
            int MIN = Integer.parseInt(minutes);
            int HOUR = Integer.parseInt(hour);


........................  colors coding 

                    name.setBackgroundColor(Color.parseColor("#b00000"));
                    name.setTextColor(Color.WHITE);

        
        
........................... support back button 

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        @Override
          public boolean onCreateOptionsMenu(Menu menu) {
              return super.onCreateOptionsMenu(menu);
          }

          @Override
          public boolean onOptionsItemSelected(MenuItem item){

              int id = item.getItemId();
              if(id == android.R.id.home){
                  Intent intent = new Intent(this,MainActivity.class);
                  startActivity(intent);
              }
              return super.onOptionsItemSelected(item);
          }
          
          
          
          
          
................. call to number 


                              Intent intent = new Intent(Intent.ACTION_DIAL);
                              intent.setData(Uri.parse("tel:0"+s.phone));  // s.phne is a string has the phone number
                              if(intent.resolveActivity(getPackageManager()) != null ){
                                  startActivity(intent);
                              }


..............  convert bitmap image to string 

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


............. convert string image to bitmap 


    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }



..................   go to instgram  account

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mohammad_omar_taha/"));
                intent.setPackage("com.instagram.android");
                startActivity(intent);

.................  go to facebook account

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mohammad.omar.taha"));
                startActivity(intent);



.................. send Email


    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mohammadomartaha1994@gmail.com"});  // to
        intent.putExtra(Intent.EXTRA_SUBJECT, " subject ");
        intent.putExtra(Intent.EXTRA_TEXT,"  text ");

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }




.................... link to play store 

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.lecture.mohammad.alarmLecture"));
                startActivity(intent);




.................... internet connection

        public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();}


                if (isInternetConnected(getApplicationContext())){
                    Toast.makeText(getApplicationContext()," Internet Connected ",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext()," No Internet Connection ",Toast.LENGTH_LONG).show();
                 }



........................  Picasso library to load images from IMAGE URL
  
  
          ImageView image = (ImageView)findViewById(R.id.imageView2);
          Picasso.with(MainActivity.this).load("IMAGE URL").into(image);




........................ mediaPlayer 

        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.correct);   // make raw file and put music inside it 
        mediaPlayer.start();


........................

