
    
        boolean isRunning;
        useThread u;

    
    /// to start thread  
    
                            isRunning=true;
                            u = new useThread();
                            u.start();
                            
                            
     /// to end thread 
     
                             isRunning=false;

    
    
    
    class useThread extends Thread {
        @Override
        public void run(){
            while (isRunning){

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                         
                         /// write code here
                    }
                });
                try {
                    Thread.sleep(5000);   /// 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
