package NetWork;

import Model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Socket socket;

    private static void init(){
        try{
            System.out.println("开始连接服务器");
            socket = new Socket("119.23.225.4",8042);
            System.out.println("连接服务器成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("连接服务器失败");
        }
    }

    public static boolean QueryStudent(){
        Map<String,String> query = new HashMap<>();
        query.put("operation","QueryStudent");
        JSONObject jsonObject = JSONObject.fromObject(query);
        if (socket==null){
            init();
        }
        write(jsonObject.toString());
        try{
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String message = null;
            while ((message = br.readLine()) != null) {
                System.out.println("接收到的数据："+message);
                JSONObject receive = JSONObject.fromObject(message);
                System.out.println("parsing");
                return Parsing_Json(receive);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    private static void write(String msg) {
        try {

            new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true).println(msg);
         /*   OutputStream out = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(msg);
            writer.flush();*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean Parsing_Json(JSONObject jsonObject){
        String operation = jsonObject.getString("operation");
        if (operation.equals("response_query")){
            JSONArray arr = jsonObject.getJSONArray("StudentsInfo");
            for (int i =0;i<arr.size();i++){
                JSONObject json = (JSONObject)arr.get(i);
                Student student = new Student();
                student.setAge(json.getString("age"));
                student.setCharacter(Double.parseDouble(json.getString("character")));
                student.setFamily(Double.parseDouble(json.getString("family")));
                student.setId(json.getString("id"));
                student.setName(json.getString("name"));
                student.setRest(Double.parseDouble(json.getString("rest")));
                student.setSex( json.getString("sex").equals("0")?true:false);//1为false男生 0为true女生
                student.setStudy(Double.parseDouble(json.getString("study")));
                System.out.println(student.getAge()+" "+student.getId()+" "+student.getName()+" "+student.getCharacter()+" "+student.getFamily()+" "+student.getRest()+" "+student.getSex()+" "+student.getStudy());
                Student.student.add(student);
            }
            return true;
        }else {
            return false;
        }



    }





}
