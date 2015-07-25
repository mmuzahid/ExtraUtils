/**
 * @author MUZAHIDUL ISLAM
 * A tiny ping Server
 * */
public class MirrorWeb {

	public static void main(String args[]) throws java.io.IOException {
		java.net.ServerSocket server = new java.net.ServerSocket(7070);
		System.out.println("server started at 7070....");
		while (true) {
			java.net.Socket clientSocket = server.accept();
			StringBuffer requestBody = new StringBuffer("");
			java.io.InputStream input = clientSocket.getInputStream();
			java.io.InputStreamReader reader = new java.io.InputStreamReader(
					input);
			do {
				requestBody.append((char)input.read());
			} while (input.available() > 0);

			String responseBody = new String("HTTP/1.1 200 OK\r\n" + 
					"Content-Type: text/html; charset=utf-8\r\n" + 
					"\r\n server time: " + new java.util.Date() +
					"<br \\> your request: <hr \\>" + requestBody.toString().replace("\n", "<br \\>") +
					"\r\n");
			System.out.println(requestBody.toString());
			java.io.OutputStream out = clientSocket.getOutputStream();
			out.write(responseBody.getBytes("UTF-8"));
			out.flush();
			out.close();
			reader.close();
			
		}
	}

}
