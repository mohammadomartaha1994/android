    
   /// call 
     doWebViewPrint();
     
     
     
     /// functions 
    
    private void createWebPrintJob(WebView webView) {

        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter;
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                printAdapter = webView.createPrintDocumentAdapter("MohammadOmarTaha");
            }
            else
                printAdapter = webView.createPrintDocumentAdapter();

        } else {
            printAdapter = webView.createPrintDocumentAdapter();
        }
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());

    }


    private void doWebViewPrint() {
        WebView webView = new WebView(Print.this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                createWebPrintJob(view);
            }
        });

        String htmlDocument = "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body dir=\"rtl\" >\n" +
                "<center><h3 ><center dir=\"ltr\">Mohammad Omar Taha</center>\n\n\n\n\n" +
               "~~~~~"+text.getText().toString()+"~~~~~"+
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
    }
