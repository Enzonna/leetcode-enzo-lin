package lessoncode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    服务器端

    先运行服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建对象
        //8899 : 服务器的端口号
        ServerSocket ss = new ServerSocket(8899);

        while (true) {
            //接收请求
            Socket s = ss.accept();
            //输入流
            InputStream is = s.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }

            //输出流
            OutputStream os = s.getOutputStream();
            os.write("shou dao!!!".getBytes());
            s.shutdownOutput();//通知客户端不写了

            //关闭资源
            is.close();
            os.close();
            s.close();
        }
    }
}
