        create class name Fragment_Class 
                and make in extentds Fragment
                
         then make layout name fragment_layout 
                and give it ID 


        Call it :        

        Fragment_Class fragment = new Fragment_Class(); // to fragemnt class
        getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();  /// from the layout you need to move 
