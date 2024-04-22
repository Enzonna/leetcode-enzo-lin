package lessoncode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    客户端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {

        //创建对象
        /*
        "127.0.0.1" : 服务器的IP地址
        8899 : 服务器的端口号
         */
        Socket socket = new Socket("127.0.0.1", 8899);
        //使用流进行通信
        OutputStream os = socket.getOutputStream();
        //写数据
        os.write("abc".getBytes());
        //通知对方不写了
        socket.shutdownOutput();


        //接收服务器发过来的数据
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = is.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }

        //关闭资源
        os.close();
        socket.close();
    }
}
