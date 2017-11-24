    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();
    public MyCustomAdapter myadapter;



// inside  onCreate

        myadapter=new MyCustomAdapter(listnewsData);
        ListView lsNews=(ListView)findViewById(R.id.list);
        lsNews.setAdapter(myadapter);


        String url="http://www.kufermalik.com/tampass/searchapi.php"; /////// here the API url
        new MyAsyncTaskgetNews().execute(url);


//// 






    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater;
        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }
        
        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater =getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_list, null);  /// Create layout for the item

            final AdapterItems s = listnewsDataAdpater.get(position);

            TextView NAME = (TextView) myView.findViewById(R.id.NAME);
            NAME.setText(s.NAME);

            return myView;
        }
    }




    public class MyAsyncTaskgetNews extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected String  doInBackground(String... params) {
            try {
                String NewsData;
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(7000);
                try {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    NewsData = ConvertInputToStringNoChange(in);
                    publishProgress(NewsData);
                } finally {
                    urlConnection.disconnect();
                }

            }catch (Exception ex){}
            return null;
        }
        
        
        protected void onProgressUpdate(String... progress) {
            listnewsData.clear();
            try {
                JSONArray json=new JSONArray(progress[0]);
                for(int i=0;i<json.length();i++){
                    JSONObject user=json.getJSONObject(i);
                    listnewsData.add(new AdapterItems(user.getString("ID"),        /// don't forget to create class AdapterItems
                            user.getString("NAME")));
                }
                myadapter.notifyDataSetChanged();
            } catch (Exception ex) {}
        }
        
        
        protected void onPostExecute(String  result2){}
        
        
    }




    public static String ConvertInputToStringNoChange(InputStream inputStream) {
        BufferedReader bureader=new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String linereultcal="";
        try{
            while((line=bureader.readLine())!=null) {
                linereultcal+=line;
            }
            inputStream.close();
        }catch (Exception ex){}
        return linereultcal;
    }
