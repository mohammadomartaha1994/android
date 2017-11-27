    compile 'com.mcxiaoke.volley:library:1.0.19'

      
      
       final Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                          try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            
                                      if (success) {  Toast.makeText(getApplication(),"Successful",Toast.LENGTH_LONG).show();}
                            
                                      else {AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity.this);
                                            builder.setMessage("Register Failed").setNegativeButton("Retry", null).create().show();}
                               }
                          catch (JSONException e) {e.printStackTrace();}

                        }
                    };

                    RequestWithKey RequestWithKey = new RequestWithKey(value1,value2, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(currentActivity.this);
                    queue.add(RequestWithKey);


