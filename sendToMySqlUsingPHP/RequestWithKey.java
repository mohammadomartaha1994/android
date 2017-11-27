import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RequestWithKey extends StringRequest {
    // private static final String REGISTER_REQUEST_URL="http://googleps.me/SPSProject/addFriend.php"; // php url
    // private static final String REGISTER_REQUEST_URL="http://kufermalik.com/Nouran/add.php";
    public  String  num1,num2;
    private Map<String,String> params;

    public AddIDreq(String num1,String num2 ,Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("num1",num1);
        params.put("num2",num2);
    }

    @Override
    public  Map<String,String> getParams(){
        return params;
    }

}
